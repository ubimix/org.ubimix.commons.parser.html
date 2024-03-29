/**
 * 
 */
package org.ubimix.commons.parser.html;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.ubimix.commons.parser.AbstractCharStream.Pointer;
import org.ubimix.commons.parser.CompositeTokenizer;
import org.ubimix.commons.parser.ICharStream;
import org.ubimix.commons.parser.ICharStream.IPointer;
import org.ubimix.commons.parser.ITokenizer;
import org.ubimix.commons.parser.StreamToken;
import org.ubimix.commons.parser.balancer.TagBalancer;
import org.ubimix.commons.parser.balancer.TagBalancer.IListener;
import org.ubimix.commons.parser.balancer.TagDescriptor;
import org.ubimix.commons.parser.base.SequenceTokenizer;
import org.ubimix.commons.parser.text.TextTokenizer;
import org.ubimix.commons.parser.xml.AbstractXmlParser;
import org.ubimix.commons.parser.xml.CDATAToken;
import org.ubimix.commons.parser.xml.CommentTokenizer;
import org.ubimix.commons.parser.xml.CommentTokenizer.CommentToken;
import org.ubimix.commons.parser.xml.Entity;
import org.ubimix.commons.parser.xml.EntityFactory;
import org.ubimix.commons.parser.xml.EntityToken;
import org.ubimix.commons.parser.xml.EntityTokenizer;
import org.ubimix.commons.parser.xml.TagToken;
import org.ubimix.commons.parser.xml.XMLTokenizer;

/**
 * @author kotelnikov
 */
public class HtmlParser extends AbstractXmlParser {

    public static class ContextSensitiveTokenizer extends StackableTokenizer {

        private Map<String, ITokenizer> fMap = new HashMap<String, ITokenizer>();

        public ContextSensitiveTokenizer(ITokenizer defaultTokenizer) {
            super(defaultTokenizer);
        }

        public ITokenizer getTokenizer(String tag) {
            return fMap.get(tag);
        }

        public void push(String tag) {
            ITokenizer tokenizer = getTokenizer(tag);
            push(tokenizer);
        }

        public void registerTokenizer(String tag, ITokenizer tokenizer) {
            fMap.put(tag, tokenizer);
        }

        public void unregisterTokenizer(String tag) {
            fMap.remove(tag);
        }

    }

    public static class StackableTokenizer implements ITokenizer {

        private ITokenizer fCurrentTokenizer;

        private ITokenizer fDefaultTokenizer;

        private Stack<ITokenizer> fStack = new Stack<ITokenizer>();

        public StackableTokenizer(ITokenizer defaultTokenizer) {
            fDefaultTokenizer = defaultTokenizer;
            fCurrentTokenizer = fDefaultTokenizer;
        }

        public ITokenizer getDefaultTokenizer() {
            return fDefaultTokenizer;
        }

        public void pop() {
            fStack.pop();
            fCurrentTokenizer = !fStack.isEmpty()
                ? fStack.peek()
                : fDefaultTokenizer;
        }

        public void push(ITokenizer tokenizer) {
            if (tokenizer == null) {
                tokenizer = fCurrentTokenizer;
            }
            fCurrentTokenizer = tokenizer;
            fStack.push(tokenizer);
        }

        @Override
        public StreamToken read(ICharStream stream) {
            StreamToken token = fCurrentTokenizer.read(stream);
            return token;
        }

        public void setDefaultTokenizer(ITokenizer defaultTokenizer) {
            fDefaultTokenizer = defaultTokenizer;
        }

    }

    protected static class TagInfo {
        private Map<String, String> fAttributes = new HashMap<String, String>();

        private Map<String, String> fNamespaces = new HashMap<String, String>();

        private TagInfo fParent;

        private String fTagName;

        public TagInfo(
            TagInfo parent,
            String tagName,
            Map<String, String> attributes) {
            fParent = parent;
            fTagName = tagName;
            if (attributes != null) {
                for (Map.Entry<String, String> entry : attributes.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    String prefix = null;
                    if (key.startsWith(NS_PREFIX)) {
                        prefix = key.substring(NS_PREFIX.length());
                    } else if (key.equals(NS)) {
                        prefix = "";
                    }
                    if (prefix != null) {
                        fNamespaces.put(prefix, value);
                    } else {
                        fAttributes.put(key, value);
                    }
                }
            }
        }

        public Map<String, String> getAttributes() {
            return fAttributes;
        }

        public Map<String, String> getNamespaces() {
            return fNamespaces;
        }

        public TagInfo getParent() {
            return fParent;
        }

        public String getTagName() {
            return fTagName;
        }

        public TagInfo pop() {
            return fParent;
        }

    }

    private static final String NS = "xmlns";

    private static final String NS_PREFIX = "xmlns:";

    private static TextTokenizer TEXT_TOKENIZER;

    public static XHTMLEntities XHTML_ENTITIES;

    private static XMLTokenizer XML_TOKENIZER;

    static {
        EntityFactory entityFactory = new EntityFactory();
        XHTML_ENTITIES = new XHTMLEntities(entityFactory);
        EntityTokenizer entityReader = new EntityTokenizer(entityFactory, false);
        XML_TOKENIZER = new XMLTokenizer(entityReader);
        TEXT_TOKENIZER = new TextTokenizer();
        XML_TOKENIZER.addTokenizer(TEXT_TOKENIZER);
    }

    protected StringBuilder fBuf = new StringBuilder();

    private int fDepth;

    protected TagBalancer fTagBalancer;

    private IListener fTagBalancerListener = new TagBalancer.IListener() {

        private TagInfo fTagInfo;

        @Override
        public void begin(String tag) {
            if (HtmlTagDictionary.isToken(tag)) {
                return;
            }
            Map<String, String> attributes = null;
            if (fTagToken != null && tag.equals(getTagName(fTagToken))) {
                attributes = fTagToken.getAttributesAsMap();
            }
            if (attributes == null) {
                attributes = Collections.emptyMap();
            }
            fTagInfo = new TagInfo(fTagInfo, tag, attributes);
            fListener.beginElement(
                tag,
                fTagInfo.getAttributes(),
                fTagInfo.getNamespaces());
            ContextSensitiveTokenizer tokenizer = getTokenizer();
            tokenizer.push(tag);
            fDepth++;
        }

        @Override
        public void end(String tag) {
            if (HtmlTagDictionary.isToken(tag)) {
                return;
            }
            fDepth--;
            fListener.endElement(
                fTagInfo.getTagName(),
                fTagInfo.getAttributes(),
                fTagInfo.getNamespaces());
            fTagInfo = fTagInfo.pop();
            ContextSensitiveTokenizer tokenizer = getTokenizer();
            tokenizer.pop();
        }
    };

    private TagToken fTagToken;

    public HtmlParser() {
        this(HtmlTagDescriptorBuilder.getInstance());
    }

    public HtmlParser(ITokenizer tokenizer) {
        super(tokenizer);
    }

    /**
     *  
     */
    public HtmlParser(TagDescriptor tagDescriptor) {
        super(new ContextSensitiveTokenizer(XML_TOKENIZER));
        fTagBalancer = new TagBalancer(tagDescriptor, fTagBalancerListener);
        ContextSensitiveTokenizer t = getTokenizer();
        t.registerTokenizer(
            HtmlTagDictionary.SCRIPT,
            getTagDelimitedTextTokenizer(HtmlTagDictionary.SCRIPT));
        t.registerTokenizer(
            HtmlTagDictionary.STYLE,
            getTagDelimitedTextTokenizer(HtmlTagDictionary.STYLE));
    }

    private void appendText(String content) {
        fBuf.append(content);
    }

    @Override
    protected boolean check(StreamToken token, Class<?> type) {
        return type.isInstance(token);
    }

    @Override
    protected void dispatchToken(StreamToken token) {
        super.dispatchToken(token);
    }

    @Override
    protected void finishParse() {
        flushText();
        fTagBalancer.finish();
    }

    protected void flushText() {
        if (fBuf.length() > 0) {
            String str = fBuf.toString();
            fTagBalancer.begin(HtmlTagDictionary.TOKEN_TEXT);
            fListener.onText(str);
            fTagBalancer.end(HtmlTagDictionary.TOKEN_TEXT);
            fBuf.delete(0, fBuf.length());
        }
    }

    protected CompositeTokenizer getTagDelimitedTextTokenizer(
        String delimiterTagName) {
        CompositeTokenizer tokenizer = new CompositeTokenizer();
        SequenceTokenizer scriptEnd = new SequenceTokenizer("</"
            + delimiterTagName
            + ">") {

            @Override
            protected TagToken newToken() {
                TagToken token = new TagToken() {
                    {
                        init(false, true);
                    }
                };
                return token;
            }

            @Override
            public StreamToken read(ICharStream stream) {
                TagToken token = (TagToken) super.read(stream);
                if (token != null) {
                    IPointer begin = token.getBegin();
                    IPointer end = token.getEnd();
                    String str = token.getText();
                    Pointer b = new Pointer(
                        begin.getPos() + 2,
                        begin.getColumn() + 2,
                        begin.getLine());
                    Pointer e = new Pointer(
                        end.getPos() - 1,
                        end.getColumn() - 1,
                        end.getLine());
                    token.setName(b, e, str.substring(2, str.length() - 1));
                }
                return token;
            }
        };
        tokenizer.addTokenizer(scriptEnd);
        tokenizer.addTokenizer(XML_TOKENIZER.getEntityTokenizer());
        tokenizer.addTokenizer(CommentTokenizer.INSTANCE);
        tokenizer.addTokenizer(TEXT_TOKENIZER);
        return tokenizer;
    }

    private String getTagName(TagToken tagToken) {
        if (tagToken == null) {
            return null;
        }
        String tagName = tagToken.getName();
        return tagName.toLowerCase();
    }

    public TagToken getTagToken() {
        return fTagToken;
    }

    @Override
    public ContextSensitiveTokenizer getTokenizer() {
        return (ContextSensitiveTokenizer) super.getTokenizer();
    }

    @Override
    protected void reportCDATA(CDATAToken token) {
        appendText(token.getText());
    }

    @Override
    protected void reportComment(CommentToken token) {
    }

    @Override
    protected void reportEntity(EntityToken token) {
        flushText();
        fTagBalancer.begin(HtmlTagDictionary.TOKEN_TEXT);
        Entity entity = token.getEntityKey();
        fListener.onEntity(entity);
        fTagBalancer.end(HtmlTagDictionary.TOKEN_TEXT);
    }

    @Override
    protected void reportEOL(StreamToken token) {
        reportSpaceTag(HtmlTagDictionary.TOKEN_EOL, token);
    }

    @Override
    protected void reportProcessingInstructions(StreamToken token) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void reportProlog(StreamToken token) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void reportSpaces(StreamToken token) {
        reportSpaceTag(HtmlTagDictionary.TOKEN_SPACE, token);
    }

    protected void reportSpaceTag(String tokenTag, StreamToken token) {
        flushText();
        fTagBalancer.begin(tokenTag);
        if (fDepth > 0) {
            String str = token.getText();
            fListener.onText(str);
        }
        fTagBalancer.end(tokenTag);
    }

    @Override
    protected void reportSpecialSymbols(StreamToken token) {
        appendText(token.getText());
    }

    @Override
    protected void reportTag(TagToken token) {
        flushText();
        fTagToken = token;
        String tagName = getTagName(token);
        if (token.isOpen()) {
            fTagBalancer.begin(tagName);
        }
        if (token.isClose()) {
            if (!HtmlTagDictionary.HTML.equals(tagName)) {
                fTagBalancer.end(tagName);
            }
        }
        fTagToken = null;
    }

    @Override
    protected void reportWord(StreamToken token) {
        appendText(token.getText());
    }
}

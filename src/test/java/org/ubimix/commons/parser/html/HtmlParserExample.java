/**
 * 
 */
package org.ubimix.commons.parser.html;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.ubimix.commons.parser.CharStream;
import org.ubimix.commons.parser.ICharStream;
import org.ubimix.commons.parser.StreamToken;
import org.ubimix.commons.parser.xml.IXmlParser;
import org.ubimix.commons.parser.xml.XMLTokenizer;
import org.ubimix.commons.parser.xml.utils.XmlSerializer;

/**
 * @author kotelnikov
 */
public class HtmlParserExample {

    public static void main(String[] args) throws IOException {
        new HtmlParserExample().parse();
        new HtmlParserExample().tokenize();
    }

    protected ICharStream newStream(String str) {
        ICharStream stream;
        // stream = new UnboundedCharStream(new
        // UnboundedCharStream.SimpleCharLoader(str));
        stream = new CharStream(str);
        return stream;
    }

    private void parse() throws IOException {
        String str = TestUtil.readResource(getClass(), "Wikipedia-France.html");
        IXmlParser parser = new HtmlParser();
        long start = System.currentTimeMillis();

        XmlSerializer listener = null;
        int count = 30;
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + " parse iteration...");
            listener = new XmlSerializer();
            listener.setSortAttributes(false);
            ICharStream stream = newStream(str);
            parser.parse(stream, listener);
        }

        long stop = System.currentTimeMillis();
        System.out.println("Parsed in " + ((stop - start) / count) + "ms");

        write("./tmp/WikipediaFrance.xml", listener.toString());
    }

    private void tokenize() throws IOException {
        String str = TestUtil.readResource(getClass(), "Wikipedia-France.html");
        ICharStream stream = newStream(str);
        XMLTokenizer tokenizer = XMLTokenizer.getFullXMLTokenizer();
        long start = System.currentTimeMillis();
        StreamToken token = tokenizer.read(stream);
        StringBuilder buf = new StringBuilder();
        while (token != null) {
            buf.append(token.getText());
            token = tokenizer.read(stream);
        }
        long stop = System.currentTimeMillis();
        System.out.println("Tokenized in " + (stop - start) + "ms");
        write("./tmp/WikipediaFrance.txt", buf.toString());

        if (!str.equals(buf.toString())) {
            throw new IllegalStateException();
        }
    }

    protected void write(String fileName, String str) throws IOException {
        File file = new File(fileName);
        file.getParentFile().mkdirs();
        FileWriter w = new FileWriter(file);
        w.write(str);
        w.close();
    }

}

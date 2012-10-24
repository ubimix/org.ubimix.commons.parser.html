/**
 * 
 */
package org.ubimix.commons.parser.html;

import junit.framework.TestCase;

import org.ubimix.commons.parser.CharStream;
import org.ubimix.commons.parser.ICharStream;
import org.ubimix.commons.parser.StreamToken;
import org.ubimix.commons.parser.xml.Entity;
import org.ubimix.commons.parser.xml.EntityFactory;
import org.ubimix.commons.parser.xml.EntityToken;
import org.ubimix.commons.parser.xml.EntityTokenizer;

/**
 * @author kotelnikov
 */
public class XHTMLEntityTokenizerTest extends TestCase {

    public XHTMLEntityTokenizerTest(String name) {
        super(name);
    }

    private void testEntityTokenizer(
        EntityFactory keyFactory,
        String str,
        Entity control) {
        EntityTokenizer tokenizer = new EntityTokenizer(keyFactory);
        ICharStream stream = new CharStream(str);
        StreamToken token = tokenizer.read(stream);
        if (control != null) {
            assertNotNull(token);
            assertTrue(token instanceof EntityToken);
            EntityToken t = (EntityToken) token;
            assertEquals(control, t.getEntityKey());
        } else {
            assertNull(token);
        }
    }

    public void testXHTMLEntityTokenizer() {
        EntityFactory entityFactory = new EntityFactory();
        XHTMLEntities e = new XHTMLEntities(entityFactory);
        testEntityTokenizer(entityFactory, "&#60;", e.XML.S_LT);
        testEntityTokenizer(entityFactory, "&#x3c;", e.XML.S_LT);
        testEntityTokenizer(entityFactory, "&#62;", e.XML.S_GT);
        testEntityTokenizer(entityFactory, "&#x3e;", e.XML.S_GT);

        testEntityTokenizer(entityFactory, "&agrave; ", e.CHARS.S_agrave);
        testEntityTokenizer(entityFactory, "&#224; ", e.CHARS.S_agrave);
        testEntityTokenizer(entityFactory, "&Alpha; ", e.SYMBOLS.S_Alpha);
        testEntityTokenizer(entityFactory, "&#913; ", e.SYMBOLS.S_Alpha);
        testEntityTokenizer(entityFactory, "&euro; ", e.SPECIALS.S_euro);
        testEntityTokenizer(entityFactory, "&#8364; ", e.SPECIALS.S_euro);

        // Non-standard entities
        testEntityTokenizer(entityFactory, "&xxx; ", null);
        Entity testEntity = entityFactory.newEntityKey("xxx", 99999);
        testEntityTokenizer(entityFactory, "&xxx; ", testEntity);
        testEntityTokenizer(entityFactory, "&#99999; ", testEntity);
    }

}

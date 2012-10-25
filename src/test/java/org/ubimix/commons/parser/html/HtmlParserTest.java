/**
 * 
 */
package org.ubimix.commons.parser.html;

import java.util.Map;

import junit.framework.TestCase;

import org.ubimix.commons.parser.CharStream;
import org.ubimix.commons.parser.ICharStream;
import org.ubimix.commons.parser.xml.IXmlParser;
import org.ubimix.commons.parser.xml.XmlListener;
import org.ubimix.commons.parser.xml.utils.XmlSerializer;

/**
 * @author kotelnikov
 */
public class HtmlParserTest extends TestCase {

    /**
     * @param name
     */
    public HtmlParserTest(String name) {
        super(name);
    }

    protected ICharStream newStream(String str) {
        return new CharStream(str);
        // return new StringBufferCharStream(str);
    }

    protected IXmlParser newXmlParser() {
        return new HtmlParser();
    }

    private String parseAndSerialize(String str) {
        XmlSerializer listener = new XmlSerializer();
        listener.setSortAttributes(false);
        IXmlParser parser = newXmlParser();
        ICharStream stream = newStream(str);
        parser.parse(stream, listener);
        return listener.toString();
    }

    public void testAttributes() {
        testAttributeWithEntities("a&#x27;b", "a'b");
        testAttributeWithEntities("a'b", "a'b");
        testParser(
            "<div prop=\"value\"/>",
            "<html><body><div prop='value'></div></body></html>");
        testParser(
            "<div prop=\"a'b\"/>",
            "<html><body><div prop='a&#x27;b'></div></body></html>");
    }

    private void testAttributeWithEntities(String attr, final String control) {
        IXmlParser parser = newXmlParser();
        parser.parse(
            newStream("<div prop=\"" + attr + "\"/>"),
            new XmlListener() {
                @Override
                public void beginElement(
                    String tagName,
                    Map<String, String> attributes,
                    Map<String, String> namespaces) {
                    if ("div".equals(tagName)) {
                        String value = attributes.get("prop");
                        assertEquals(control, value);
                    }
                }
            });
    }

    public void testExamplesFromJsoup() {
        // Tests
        testParser(
            "<body><p><textarea>one<p>two",
            "<html><body><p><textarea>one</textarea></p><p>two</p></body></html>");
        testParser(
            "<div > <a name=\"top\"></a ><p id=1 >Hello</p></div>",
            "<html><body><div> <a name='top'></a><p id='1'>Hello</p></div></body></html>");
        testParser(
            "foo <b>bar</b> baz",
            "<html><body>foo <b>bar</b> baz</body></html>");
        testParser(
            "<div title='Surf &amp; Turf'>Reef &amp; Beef</div>",
            "<html><body><div title='Surf &#x26; Turf'>Reef &#x26; Beef</div></body></html>");
    }

    public void testFormSelect() {
        testParser("<select>a", ""
            + "<html><body><select></select>a</body></html>");
        testParser("<option>a", ""
            + "<html><body>"
            + "<select><option>a</option></select>"
            + "</body></html>");
        testParser(""
            + "<select>\n"
            + "  <option>a\n"
            + "  <option>b\n"
            + "  <option>c\n"
            + "<p>d", ""
            + "<html><body>"
            + "<select>\n"
            + "  <option>a\n"
            + "  </option><option>b\n"
            + "  </option><option>c\n"
            + "</option></select>"
            + "<p>d</p>"
            + "</body></html>");

        testParser("<option>a<p>b", ""
            + "<html><body>"
            + "<select><option>a</option></select>"
            + "<p>b</p>"
            + "</body></html>");
        testParser(
            "<body><p><select><option>One<option>Two</p><p>Three</p>",
            ""
                + "<html><body><p>"
                + "<select>"
                + "<option>One</option>"
                + "<option>Two</option>"
                + "</select>"
                + "</p>"
                + "<p>Three</p>"
                + "</body></html>");
        testParser("<option>One<option>Two<p>Three", ""
            + "<html><body>"
            + "<select>"
            + "<option>One</option>"
            + "<option>Two</option>"
            + "</select>"
            + "<p>Three</p>"
            + "</body></html>");

    }

    public void testHeadElements() {
        testParser(
            "<title>Title",
            "<html><head><title>Title</title></head></html>");
        testParser("<title>Title<p>X", "<html>"
            + "<head>"
            + "<title>Title</title>"
            + "</head>"
            + "<body>"
            + "<p>X</p>"
            + "</body>"
            + "</html>");
        testParser("<meta name=keywords />"
            + "<link rel=stylesheet />"
            + "<title>title</title>"
            + "<p>Hello world</p>", ""
            + "<html>"
            + "<head>"
            + "<meta name='keywords'></meta>"
            + "<link rel='stylesheet'></link>"
            + "<title>title</title>"
            + "</head>"
            + "<body><p>Hello world</p></body>"
            + "</html>");

        testParser(""
            + "<meta name=keywords>"
            + "<link rel=stylesheet>"
            + "<title>title"
            + "<p>Hello world", ""
            + "<html>"
            + "<head>"
            + "<meta name='keywords'></meta>"
            + "<link rel='stylesheet'></link>"
            + "<title>title</title>"
            + "</head>"
            + "<body><p>Hello world</p></body>"
            + "</html>");
    }

    private void testParser(String str) {
        testParser(str, str);
    }

    private void testParser(String str, String control) {
        String test1 = parseAndSerialize(str);
        assertEquals(control, test1);
        String test2 = parseAndSerialize(test1);
        assertEquals(control, test2);
    }

    public void testScriptsAndStyles() {
        testParser(
            "a<script>b</script>c",
            "<html><body>a<script>b</script>c</body></html>");
        testParser(
            "before<script>toto<a href=''>it is not a tag <>> titi",
            "<html><body>before<script>toto&#x3c;a href=''&#x3e;it is not a tag &#x3c;&#x3e;&#x3e; titi</script></body></html>");

        testParser(
            "<script><a>text",
            "<html><head><script>&#x3c;a&#x3e;text</script></head></html>");
        testParser(
            "before<script><a>text",
            "<html><body>before<script>&#x3c;a&#x3e;text</script></body></html>");
        testParser(
            "<script>toto",
            "<html><head><script>toto</script></head></html>");
        testParser(
            "before<script>toto<a href=''>it is not a tag <>> titi",
            "<html><body>before<script>toto&#x3c;a href=''&#x3e;it is not a tag &#x3c;&#x3e;&#x3e; titi</script></body></html>");

        testParser(
            "before<script>toto[<!-- This is a comment -->] <a href=''>it is not a tag <>> titi",
            "<html><body>before<script>toto[] &#x3c;a href=''&#x3e;it is not a tag &#x3c;&#x3e;&#x3e; titi</script></body></html>");
    }

    public void testSerializeDeserialize() {
        testParser("  \n"
            + "  <div>\n"
            + "  <p> This is    \n"
            + "  a \n"
            + " paragraph</p> \n"
            + "  \n"
            + "</div>  \n"
            + "  ", ""
            + "<html><body><div>\n"
            + "  <p> This is    \n"
            + "  a \n"
            + " paragraph</p> \n"
            + "  \n"
            + "</div>  \n"
            + "  </body></html>");
        testParser(
            "<p>Lorem <p>Ipsum ",
            "<html><body><p>Lorem </p><p>Ipsum </p></body></html>");
        testParser(
            "<li>Lorem <li>Ipsum ",
            "<html><body><ul><li>Lorem </li><li>Ipsum </li></ul></body></html>");
        testParser(
            "<div><li>Lorem <li>Ipsum ",
            "<html><body><div><ul><li>Lorem </li><li>Ipsum </li></ul></div></body></html>");
        testParser(
            "<li>Lorem <li>Ipsum ",
            "<html><body><ul><li>Lorem </li><li>Ipsum </li></ul></body></html>");

        testParser("<div />", "<html><body><div></div></body></html>");
        testParser(
            "<div>This is a text</div>",
            "<html><body><div>This is a text</div></body></html>");
        testParser(
            "<div>This is a text",
            "<html><body><div>This is a text</div></body></html>");
        testParser("", "");
        testParser("<a/>", "<html><body><a></a></body></html>");
        testParser("    <div />   ", "<html><body><div></div>   </body></html>");
        testParser("<root>"
            + "<a xmlns='foo'><x></x><y></y></a>"
            + "<a xmlns:n='bar'><n:x></n:x><n:y></n:y></a>"
            + "</root>");
        testParser(
            "<feed xmlns='http://www.w3.org/2005/Atom' />",
            "<feed xmlns='http://www.w3.org/2005/Atom'></feed>");
        testParser(
            "<a><b><c><d><e><f>Text</f></e></d></c></b></a>",
            "<html><body><a><b><c><d><e><f>Text</f></e></d></c></b></a></body></html>");
        testParser(
            "<a><b>Text</b><c>Text</c><d>Text</d><e>Text</e><f>Text</f></a>",
            "<html><body><a><b>Text</b><c>Text</c><d>Text</d><e>Text</e><f>Text</f></a></body></html>");
        testParser(""
            + "<html>"
            + "<head>"
            + "<title>Hello, world</title>"
            + "</head>"
            + "<body>"
            + "<p class='first'>A new paragraph</p>"
            + "</body>"
            + "</html>");
        testParser("  a", "<html><body>a</body></html>");
        testParser("a !", "<html><body>a !</body></html>");
        testParser("a !\n", "<html><body>a !\n</body></html>");
        testParser(""
            + "<table id=table1 cellspacing=2px\n"
            + "    <h1>CONTENT</h1>\n"
            + "    <td><a href=index.html>1 -> Home Page</a>\n"
            + "    <td><a href=intro.html>2 -> Introduction</a>", ""
            + "<html><body>&#x3c;table id=table1 cellspacing=2px\n"
            + "    <h1>CONTENT</h1>\n"
            + "    <table><tr>"
            + "<td><a href='index.html'>1 -&#x3e; Home Page</a>\n"
            + "    </td>"
            + "<td><a href='intro.html'>2 -&#x3e; Introduction</a></td>"
            + "</tr></table>"
            + "</body></html>");
        testParser(""
            + "<table id=table1 cellspacing=2px>\n"
            + "    <h1>CONTENT</h1>\n"
            + "    <td><a href=index.html>1 -> Home Page</a>\n"
            + "    <td><a href=intro.html>2 -> Introduction</a>", ""
            + "<html><body>"
            + "<table id='table1' cellspacing='2px'>\n"
            + "    </table>"
            + "<h1>CONTENT</h1>\n"
            + "    <table><tr>"
            + "<td><a href='index.html'>1 -&#x3e; Home Page</a>\n"
            + "    </td>"
            + "<td><a href='intro.html'>2 -&#x3e; Introduction</a></td>"
            + "</tr></table>"
            + "</body></html>");
    }

    public void testSimpleText() {
        testParser("cd", "<html><body>cd</body></html>");
        testParser("<i>b</i>c", "<html><body><i>b</i>c</body></html>");
        testParser("a<s>b</s>c", "<html><body>a<s>b</s>c</body></html>");
    }

    public void testTables() {
        testParser("<table> <unknowntag> <td> Text ", "<html><body>"
            + "<table> <unknowntag> "
            + "<tr><td> Text </td></tr>"
            + "</unknowntag></table>"
            + "</body></html>");
        testParser("<table> <unknowntag> <tr> Text ", ""
            + "<html><body>"
            + "<table> <unknowntag> <tr> </tr></unknowntag></table>"
            + "Text </body></html>");

        testParser("<table>\n"
            + "  <tr>  \n"
            + "    <td> Hello \n"
            + "  <tr>  \n"
            + "    <td> World!"
            + "   </table>"
            + "Next line"
            + "", "<html><body>"
            + "<table>\n"
            + "  <tr>  \n"
            + "    <td> Hello \n"
            + "  </td></tr>"
            + "<tr>  \n"
            + "    <td> World!   "
            + "</td></tr></table>"
            + "Next line"
            + "</body></html>");
    }
}

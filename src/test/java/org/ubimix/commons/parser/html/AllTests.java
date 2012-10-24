package org.ubimix.commons.parser.html;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

    public static Test suite() {
        TestSuite suite = new TestSuite(AllTests.class.getName());
        //$JUnit-BEGIN$
        suite.addTestSuite(HtmlParserTest.class);
        suite.addTestSuite(TagDescriptorTest.class);
        suite.addTestSuite(TagHierarchyTest.class);
        suite.addTestSuite(TagTypeTest.class);
        suite.addTestSuite(XHTMLEntityTokenizerTest.class);
        //$JUnit-END$
        return suite;
    }

}

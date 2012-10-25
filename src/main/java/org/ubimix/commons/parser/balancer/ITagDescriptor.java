package org.ubimix.commons.parser.balancer;

/**
 * @author kotelnikov
 */
public interface ITagDescriptor {

    /**
     * Checks if a parent tag can contain a specified child tag.
     * 
     * @param parent parent tag to check
     * @param tag a child tag to check
     * @return <code>true</code> if the parent tag can contain the specified
     *         child tag
     */
    boolean accepts(String parent, String tag);

    /**
     * Returns a parent for the given tag
     * 
     * @param tag the tag for which a parent should be returned
     * @return a parent for the given tag
     */
    String getParentTag(String tag);

    /**
     * This method checks if the some types were declared for the specified tag.
     * 
     * @param tag the tag to check
     * @return <code>true</code> if some types were declared for the specified
     *         tag
     */
    boolean isDeclared(String tag);

}
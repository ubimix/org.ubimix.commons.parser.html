package org.ubimix.commons.parser.balancer;

import java.util.Map;
import java.util.Set;

/**
 * This object is used to define tag types.
 * 
 * @author kotelnikov
 */
public final class TagDescriptor implements ITagDescriptor {

    /**
     * Parent tags.
     */
    private Map<String, Set<String>> fChildTags;

    /**
     * A set of all declared tags.
     */
    private Set<String> fDeclaredTags;

    /**
     * Parent tags.
     */
    private Map<String, String> fParentTags;

    protected TagDescriptor(
        Map<String, Set<String>> childTags,
        Set<String> declaredTags,
        Map<String, String> parentTags) {
        fChildTags = childTags;
        fDeclaredTags = declaredTags;
        fParentTags = parentTags;
    }

    /**
     * @see org.ubimix.commons.parser.balancer.ITagDescriptor#accepts(java.lang.String,
     *      java.lang.String)
     */
    @Override
    public boolean accepts(String parent, String tag) {
        boolean result = false;
        Set<String> set = fChildTags.get(parent);
        if (set != null) {
            result = set.contains(tag);
        }
        return result;
    }

    /**
     * Returns a parent for the given tag
     * 
     * @param tag the tag for which a parent should be returned
     * @return a parent for the given tag
     */
    @Override
    public String getParentTag(String tag) {
        return fParentTags.get(tag);
    }

    /**
     * @see org.ubimix.commons.parser.balancer.ITagDescriptor#isDeclared(java.lang.String)
     */
    @Override
    public boolean isDeclared(String tag) {
        return fDeclaredTags.contains(tag);
    }

}
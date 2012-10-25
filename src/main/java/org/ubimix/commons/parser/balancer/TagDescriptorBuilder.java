package org.ubimix.commons.parser.balancer;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author kotelnikov
 */
public class TagDescriptorBuilder {

    /**
     * Parent tags.
     */
    private Map<String, String> fParentTags = new HashMap<String, String>();

    /**
     * Defines mapping between tags and their respective types. Each tag can
     * have multiple types.
     */
    private Map<String, Set<TagType>> fTagTypes = new HashMap<String, Set<TagType>>();

    public boolean accepts(String parent, String tag) {
        Set<TagType> parentTypes = getTagTypes(parent);
        if (parentTypes == null || parentTypes.isEmpty()) {
            return false;
        }
        Set<TagType> childTypes = getTagTypes(tag);
        if (childTypes == null || childTypes.isEmpty()) {
            return false;
        }
        boolean result = false;
        loop: for (TagType parentType : parentTypes) {
            for (TagType childType : childTypes) {
                if (parentType.contains(childType)) {
                    result = true;
                    break loop;
                }
            }
        }
        return result;
    }

    public TagDescriptor build() {
        Set<String> declaredTags = new HashSet<String>();
        Map<String, String> parentTags = new HashMap<String, String>(
            fParentTags);
        Map<String, Set<String>> childTags = new HashMap<String, Set<String>>();
        declaredTags.addAll(fParentTags.keySet());

        Map<String, Set<TagType>> tagToType = new HashMap<String, Set<TagType>>();
        Map<TagType, Set<String>> typeToTag = new HashMap<TagType, Set<String>>();
        for (Map.Entry<String, Set<TagType>> entry : fTagTypes.entrySet()) {
            String tag = entry.getKey();
            declaredTags.add(tag);
            Set<TagType> allTypes = get(tagToType, tag, true);
            Set<TagType> types = entry.getValue();
            for (TagType type : types) {
                Set<TagType> expandedTypes = type.getAllTypes();
                allTypes.addAll(expandedTypes);
                Set<String> allTags = get(typeToTag, type, true);
                allTags.add(tag);
            }
        }
        for (String tag : declaredTags) {
            Set<TagType> allTypes = get(tagToType, tag, false);
            Set<String> allContainedTags = new HashSet<String>();
            childTags.put(tag, allContainedTags);
            for (TagType type : allTypes) {
                Set<TagType> containedTypes = type.getContainedTypes();
                for (TagType containedType : containedTypes) {
                    Set<String> containedTags = typeToTag
                        .get(containedType);
                    allContainedTags.addAll(containedTags);
                }
            }
        }
        return new TagDescriptor(childTags, declaredTags, parentTags);
    }

    private <A, B> Set<B> get(Map<A, Set<B>> map, A key, boolean create) {
        Set<B> set = map.get(key);
        if (set == null && create) {
            set = new HashSet<B>();
            map.put(key, set);
        }
        return set;
    }

    /**
     * Returns a set of types for the specified tag
     * 
     * @param tag the tag to check
     * @return a set of types for the specified tag
     */
    public Set<TagType> getTagTypes(String tag) {
        return fTagTypes.get(tag);
    }

    /**
     * Sets a new parent for the specified type.
     * 
     * @param parent a tag parent
     * @param tag the tag to set
     */
    public void setParentTag(String parent, String tag) {
        String t = parent;
        while (t != null) {
            if (tag.equals(t)) {
                throw new IllegalArgumentException(
                    "A cycle in the tag hierarchy was found. Tag: '"
                        + tag
                        + "'. Parent: '"
                        + parent
                        + "'.");
            }
            t = fParentTags.get(t);
        }
        if (!accepts(parent, tag)) {
            throw new IllegalArgumentException("Tag '"
                + parent
                + "' can not contain the '"
                + tag
                + "' tag.");
        }
        fParentTags.put(tag, parent);
    }

    /**
     * Set parents for the specified tag
     * 
     * @param parent the parent tag
     * @param children a collection of children
     */
    public void setParentTags(String parent, Iterable<String> children) {
        for (String child : children) {
            setParentTag(parent, child);
        }
    }

    /**
     * Sets parent for the specified tags.
     * 
     * @param parent the parent tag
     * @param tags child tags
     */
    public void setParentTags(String parent, String... tags) {
        for (String tag : tags) {
            setParentTag(parent, tag);
        }
    }

    /**
     * Sets tag types.
     * 
     * @param type the type of the tag
     * @param tags a collection of types for the tag
     */
    public void setType(TagType type, Collection<String> tags) {
        for (String tag : tags) {
            setType(type, tag);
        }
    }

    /**
     * Sets tag types.
     * 
     * @param type the type of the tag
     * @param tags an array of types for the tag
     */
    public void setType(TagType type, String... tags) {
        for (String tag : tags) {
            setType(type, tag);
        }
    }

    /**
     * Sets a type for the tag
     * 
     * @param type the type to set
     * @param tag the tag to set
     */
    public void setType(TagType type, String tag) {
        Set<TagType> set = fTagTypes.get(tag);
        if (set == null) {
            set = new HashSet<TagType>();
            fTagTypes.put(tag, set);
        }
        set.add(type);
    }

}
package org.ubimix.commons.parser.html;

import java.util.HashSet;

public class HtmlTagDescriptor extends TagDescriptor {

    public TagType BLOCK = new TagType("block");

    public TagType BLOCK_CONTAINER = new TagType("blockContainer");

    public TagType BODY = new TagType("body");

    public TagType DEFINITION_LIST = new TagType("definitionList");

    public TagType DEFINITION_LIST_ITEM = new TagType("definitionListItem");

    public TagType HEAD = new TagType("head");

    public TagType HEAD_ELEMENT = new TagType("headElement");

    public TagType HTML = new TagType("html");

    public TagType INLINE = new TagType("inline");

    public TagType INLINE_CONTAINER = new TagType("inlineContainer");

    public TagType LIST = new TagType("list");

    public TagType LIST_ITEM = new TagType("listItem");

    public TagType PLAINTEXT_CONTAINER = new TagType("plaintext");

    public TagType SPACE = new TagType("space");

    public TagType TABLE = new TagType("table");

    // td, th
    public TagType TABLE_CELL = new TagType("tableCell");

    // tr, tbody, thead, ...
    public TagType TABLE_INNER = new TagType("tableInner");

    public TagType TABLE_ROW = new TagType("tableRow");

    public TagType TEXT = new TagType("text");

    public TagType TITLE = new TagType("title");

    public HtmlTagDescriptor() {
        // ----------------------------------------------------------------
        // Define tag types
        HTML.setContainedTypes(HEAD, BODY);
        HEAD.setContainedTypes(SPACE, HEAD_ELEMENT);
        TITLE.setParentTypes(HEAD_ELEMENT);
        TITLE.setContainedTypes(SPACE, INLINE, TEXT);

        BODY.setParentTypes(BLOCK_CONTAINER, INLINE_CONTAINER);

        SPACE.setParentTypes(INLINE);

        BLOCK_CONTAINER.setContainedTypes(SPACE, BLOCK);
        INLINE_CONTAINER.setContainedTypes(SPACE, INLINE, TEXT);

        TABLE_CELL.setParentTypes(BLOCK_CONTAINER, INLINE_CONTAINER);
        TABLE_ROW.setContainedTypes(SPACE, TABLE_CELL);
        TABLE_INNER.setContainedTypes(SPACE, TABLE_ROW, TABLE_INNER);
        TABLE.setParentTypes(BLOCK);
        TABLE.setContainedTypes(SPACE, TABLE_ROW, TABLE_INNER);

        LIST_ITEM.setParentTypes(BLOCK_CONTAINER, INLINE_CONTAINER);
        LIST.setParentTypes(BLOCK);
        LIST.setContainedTypes(SPACE, LIST_ITEM);

        DEFINITION_LIST_ITEM.setParentTypes(INLINE_CONTAINER);
        DEFINITION_LIST.setParentTypes(BLOCK);
        DEFINITION_LIST.setContainedTypes(SPACE, DEFINITION_LIST_ITEM);

        PLAINTEXT_CONTAINER.setContainedTypes(SPACE, TEXT);

        // ----------------------------------------------------------------
        // Define tag mapping
        setType(HTML, HtmlTagDictionary.HTML);
        setType(HEAD, HtmlTagDictionary.HEAD);
        HashSet<String> headElements = new HashSet<String>(
            HtmlTagDictionary.ALL_ELEMENTS);
        headElements.removeAll(HtmlTagDictionary.BODY_CONTENT_ELEMENTS);
        setType(HEAD_ELEMENT, headElements);
        setType(HEAD_ELEMENT, HtmlTagDictionary.SCRIPT, HtmlTagDictionary.STYLE);
        setType(BODY, HtmlTagDictionary.BODY);
        setType(TITLE, HtmlTagDictionary.TITLE);

        setType(
            PLAINTEXT_CONTAINER,
            HtmlTagDictionary.SCRIPT,
            HtmlTagDictionary.STYLE);

        setType(INLINE, HtmlTagDictionary.INLINE_ELEMENTS);
        setType(INLINE, HtmlTagDictionary.SCRIPT);

        setType(TEXT, HtmlTagDictionary.TOKEN_TEXT);
        setType(
            SPACE,
            HtmlTagDictionary.TOKEN_SPACE,
            HtmlTagDictionary.TOKEN_EOL);

        setType(BLOCK, HtmlTagDictionary.SCRIPT);
        setType(INLINE_CONTAINER, HtmlTagDictionary.HEADERS);
        setType(
            INLINE_CONTAINER,
            HtmlTagDictionary.BLOCKQUOTE,
            HtmlTagDictionary.DIV,
            HtmlTagDictionary.P,
            HtmlTagDictionary.PRE);
        setType(
            INLINE_CONTAINER,
            HtmlTagDictionary.A,
            HtmlTagDictionary.B,
            HtmlTagDictionary.EM,
            HtmlTagDictionary.STRONG,
            HtmlTagDictionary.I,
            HtmlTagDictionary.SPAN,
            HtmlTagDictionary.SUB,
            HtmlTagDictionary.SUP);

        setType(BLOCK, HtmlTagDictionary.BLOCK_ELEMENTS);
        setType(BLOCK_CONTAINER, HtmlTagDictionary.BLOCK_CONTAINER_ELEMENTS);

        setType(TABLE, HtmlTagDictionary.TABLE);
        setType(
            TABLE_INNER,
            HtmlTagDictionary.HGROUP,
            HtmlTagDictionary.THEAD,
            HtmlTagDictionary.TBODY,
            HtmlTagDictionary.COL,
            HtmlTagDictionary.COLGROUP);
        setType(TABLE_ROW, HtmlTagDictionary.TR);
        setType(TABLE_CELL, HtmlTagDictionary.TD, HtmlTagDictionary.TH);

        setType(LIST, HtmlTagDictionary.UL, HtmlTagDictionary.OL);
        setType(LIST_ITEM, HtmlTagDictionary.LI);

        setType(DEFINITION_LIST, HtmlTagDictionary.DL);
        setType(
            DEFINITION_LIST_ITEM,
            HtmlTagDictionary.DD,
            HtmlTagDictionary.DT);
        setType(BLOCK_CONTAINER, HtmlTagDictionary.DD);

        // ----------------------------------------------------------------
        // Default tag parents
        setParentTags(
            HtmlTagDictionary.HEAD,
            HtmlTagDictionary.META,
            HtmlTagDictionary.LINK,
            HtmlTagDictionary.TITLE,
            HtmlTagDictionary.SCRIPT,
            HtmlTagDictionary.STYLE);

        setParentTags(HtmlTagDictionary.P, HtmlTagDictionary.TOKEN_TEXT);
        setParentTags(HtmlTagDictionary.P, HtmlTagDictionary.INLINE_ELEMENTS);
        setParentTags(
            HtmlTagDictionary.HTML,
            HtmlTagDictionary.HEAD,
            HtmlTagDictionary.BODY);
        // FIXME: add a flag switching this rule on/off
        // (useful to generate HTML fragments without HTML/BODY tags)
        setParentTags(HtmlTagDictionary.BODY, HtmlTagDictionary.BLOCK_ELEMENTS);

        setParentTags(
            HtmlTagDictionary.TABLE,
            HtmlTagDictionary.HGROUP,
            HtmlTagDictionary.TR,
            HtmlTagDictionary.THEAD,
            HtmlTagDictionary.TBODY);
        setParentTags(
            HtmlTagDictionary.TR,
            HtmlTagDictionary.TH,
            HtmlTagDictionary.TD);
        setParentTags(
            HtmlTagDictionary.THEAD,
            HtmlTagDictionary.COL,
            HtmlTagDictionary.COLGROUP);

        setParentTags(HtmlTagDictionary.UL, HtmlTagDictionary.LI);
        setParentTags(
            HtmlTagDictionary.DL,
            HtmlTagDictionary.DT,
            HtmlTagDictionary.DD);

    }

}
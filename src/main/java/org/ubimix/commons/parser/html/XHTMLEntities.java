package org.ubimix.commons.parser.html;

import org.ubimix.commons.parser.xml.EntityFactory;
import org.ubimix.commons.parser.xml.XMLEntities;

/**
 * @author kotelnikov
 */
public class XHTMLEntities {

    public final XHTMLCharactersEntities CHARS;

    public final XHTMLSpecialEntities SPECIALS;

    public final XHTMLSymbolsEntities SYMBOLS;

    public final XMLEntities XML;

    public XHTMLEntities(EntityFactory entityFactory) {
        XML = new XMLEntities(entityFactory);
        CHARS = new XHTMLCharactersEntities(entityFactory);
        SYMBOLS = new XHTMLSymbolsEntities(entityFactory);
        SPECIALS = new XHTMLSpecialEntities(entityFactory);
    }

}

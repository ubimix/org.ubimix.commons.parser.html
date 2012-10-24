/**
 * 
 */
package org.ubimix.commons.parser.html;

import org.ubimix.commons.parser.xml.Entity;
import org.ubimix.commons.parser.xml.EntityDictionary;
import org.ubimix.commons.parser.xml.EntityFactory;

/**
 * @see http://www.w3.org/TR/1999/REC-html401-19991224/sgml/entities.html
 * 
 *      <pre>
 * <!-- Special characters for HTML -->
 * 
 * <!-- Character entity set. Typical invocation:
 *      <!ENTITY % HTMLspecial PUBLIC
 *        "-//W3C//ENTITIES Special//EN//HTML">
 *      %HTMLspecial; -->
 * 
 * <!-- Portions � International Organization for Standardization 1986:
 *      Permission to copy in any form is granted for use with
 *      conforming SGML systems and applications as defined in
 *      ISO 8879, provided this notice is included in all copies.
 * -->
 * 
 * <!-- Relevant ISO entity set is given unless names are newly introduced.
 *      New names (i.e., not in ISO 8879 list) do not clash with any
 *      existing ISO 8879 entity names. ISO 10646 character numbers
 *      are given for each character, in hex. CDATA values are decimal
 *      conversions of the ISO 10646 values and refer to the document
 *      character set. Names are ISO 10646 names. 
 * 
 * -->
 * 
 * <!-- C0 Controls and Basic Latin -->
 * <!ENTITY quot    CDATA "&#34;"   -- quotation mark = APL quote,
 *                                     U+0022 ISOnum -->
 * <!ENTITY amp     CDATA "&#38;"   -- ampersand, U+0026 ISOnum -->
 * <!ENTITY lt      CDATA "&#60;"   -- less-than sign, U+003C ISOnum -->
 * <!ENTITY gt      CDATA "&#62;"   -- greater-than sign, U+003E ISOnum -->
 * 
 * <!-- Latin Extended-A -->
 * <!ENTITY OElig   CDATA "&#338;"  -- latin capital ligature OE,
 *                                     U+0152 ISOlat2 -->
 * <!ENTITY oelig   CDATA "&#339;"  -- latin small ligature oe, U+0153 ISOlat2 -->
 * <!-- ligature is a misnomer, this is a separate character in some languages -->
 * <!ENTITY Scaron  CDATA "&#352;"  -- latin capital letter S with caron,
 *                                     U+0160 ISOlat2 -->
 * <!ENTITY scaron  CDATA "&#353;"  -- latin small letter s with caron,
 *                                     U+0161 ISOlat2 -->
 * <!ENTITY Yuml    CDATA "&#376;"  -- latin capital letter Y with diaeresis,
 *                                     U+0178 ISOlat2 -->
 * 
 * <!-- Spacing Modifier Letters -->
 * <!ENTITY circ    CDATA "&#710;"  -- modifier letter circumflex accent,
 *                                     U+02C6 ISOpub -->
 * <!ENTITY tilde   CDATA "&#732;"  -- small tilde, U+02DC ISOdia -->
 * 
 * <!-- General Punctuation -->
 * <!ENTITY ensp    CDATA "&#8194;" -- en space, U+2002 ISOpub -->
 * <!ENTITY emsp    CDATA "&#8195;" -- em space, U+2003 ISOpub -->
 * <!ENTITY thinsp  CDATA "&#8201;" -- thin space, U+2009 ISOpub -->
 * <!ENTITY zwnj    CDATA "&#8204;" -- zero width non-joiner,
 *                                     U+200C NEW RFC 2070 -->
 * <!ENTITY zwj     CDATA "&#8205;" -- zero width joiner, U+200D NEW RFC 2070 -->
 * <!ENTITY lrm     CDATA "&#8206;" -- left-to-right mark, U+200E NEW RFC 2070 -->
 * <!ENTITY rlm     CDATA "&#8207;" -- right-to-left mark, U+200F NEW RFC 2070 -->
 * <!ENTITY ndash   CDATA "&#8211;" -- en dash, U+2013 ISOpub -->
 * <!ENTITY mdash   CDATA "&#8212;" -- em dash, U+2014 ISOpub -->
 * <!ENTITY lsquo   CDATA "&#8216;" -- left single quotation mark,
 *                                     U+2018 ISOnum -->
 * <!ENTITY rsquo   CDATA "&#8217;" -- right single quotation mark,
 *                                     U+2019 ISOnum -->
 * <!ENTITY sbquo   CDATA "&#8218;" -- single low-9 quotation mark, U+201A NEW -->
 * <!ENTITY ldquo   CDATA "&#8220;" -- left double quotation mark,
 *                                     U+201C ISOnum -->
 * <!ENTITY rdquo   CDATA "&#8221;" -- right double quotation mark,
 *                                     U+201D ISOnum -->
 * <!ENTITY bdquo   CDATA "&#8222;" -- double low-9 quotation mark, U+201E NEW -->
 * <!ENTITY dagger  CDATA "&#8224;" -- dagger, U+2020 ISOpub -->
 * <!ENTITY Dagger  CDATA "&#8225;" -- double dagger, U+2021 ISOpub -->
 * <!ENTITY permil  CDATA "&#8240;" -- per mille sign, U+2030 ISOtech -->
 * <!ENTITY lsaquo  CDATA "&#8249;" -- single left-pointing angle quotation mark,
 *                                     U+2039 ISO proposed -->
 * <!-- lsaquo is proposed but not yet ISO standardized -->
 * <!ENTITY rsaquo  CDATA "&#8250;" -- single right-pointing angle quotation mark,
 *                                     U+203A ISO proposed -->
 * <!-- rsaquo is proposed but not yet ISO standardized -->
 * <!ENTITY euro   CDATA "&#8364;"  -- euro sign, U+20AC NEW -->
 * </pre>
 * @author kotelnikov
 */
public class XHTMLSpecialEntities extends EntityDictionary {

    /** ampersand, U+0026 ISOnum */
    public final Entity S_amp = newEntityKey("amp", 38);

    /** double low-9 quotation mark, U+201E NEW */
    public final Entity S_bdquo = newEntityKey("bdquo", 8222);

    /**
     * modifier letter circumflex accent, U+02C6 ISOpub
     */
    public final Entity S_circ = newEntityKey("circ", 710);

    /** dagger, U+2020 ISOpub */
    public final Entity S_dagger = newEntityKey("dagger", 8224);

    /** double dagger, U+2021 ISOpub */
    public final Entity S_Dagger = newEntityKey("Dagger", 8225);

    /** em space, U+2003 ISOpub */
    public final Entity S_emsp = newEntityKey("emsp", 8195);

    /** en space, U+2002 ISOpub */
    public final Entity S_ensp = newEntityKey("ensp", 8194);

    /** rsaquo is proposed but not yet ISO standardized */
    /** euro sign, U+20AC NEW */
    public final Entity S_euro = newEntityKey("euro", 8364);

    /** greater-than sign, U+003E ISOnum */
    public final Entity S_gt = newEntityKey("gt", 62);

    /**
     * left double quotation mark, U+201C ISOnum
     */
    public final Entity S_ldquo = newEntityKey("ldquo", 8220);

    /** left-to-right mark, U+200E NEW RFC 2070 */
    public final Entity S_lrm = newEntityKey("lrm", 8206);

    /**
     * single left-pointing angle quotation mark, U+2039 ISO proposed
     */
    public final Entity S_lsaquo = newEntityKey("lsaquo", 8249);

    /**
     * left single quotation mark, U+2018 ISOnum
     */
    public final Entity S_lsquo = newEntityKey("lsquo", 8216);

    /** less-than sign, U+003C ISOnum */
    public final Entity S_lt = newEntityKey("lt", 60);

    /** em dash, U+2014 ISOpub */
    public final Entity S_mdash = newEntityKey("mdash", 8212);

    /** en dash, U+2013 ISOpub */
    public final Entity S_ndash = newEntityKey("ndash", 8211);

    /** latin small ligature oe, U+0153 ISOlat2 */
    public final Entity S_oelig = newEntityKey("oelig", 339);

    /**
     * latin capital ligature OE, U+0152 ISOlat2
     */
    public final Entity S_OElig = newEntityKey("OElig", 338);

    /** per mille sign, U+2030 ISOtech */
    public final Entity S_permil = newEntityKey("permil", 8240);

    /**
     * quotation mark = APL quote, U+0022 ISOnum
     */
    public final Entity S_quot = newEntityKey("quot", 34);

    /**
     * right double quotation mark, U+201D ISOnum
     */
    public final Entity S_rdquo = newEntityKey("rdquo", 8221);

    /** right-to-left mark, U+200F NEW RFC 2070 */
    public final Entity S_rlm = newEntityKey("rlm", 8207);

    /** lsaquo is proposed but not yet ISO standardized */
    /**
     * single right-pointing angle quotation mark, U+203A ISO proposed
     */
    public final Entity S_rsaquo = newEntityKey("rsaquo", 8250);

    /**
     * right single quotation mark, U+2019 ISOnum
     */
    public final Entity S_rsquo = newEntityKey("rsquo", 8217);

    /** single low-9 quotation mark, U+201A NEW */
    public final Entity S_sbquo = newEntityKey("sbquo", 8218);

    /**
     * latin small letter s with caron, U+0161 ISOlat2
     */
    public final Entity S_scaron = newEntityKey("scaron", 353);

    /** ligature is a misnomer, this is a separate character in some languages */
    /**
     * latin capital letter S with caron, U+0160 ISOlat2
     */
    public final Entity S_Scaron = newEntityKey("Scaron", 352);

    /** thin space, U+2009 ISOpub */
    public final Entity S_thinsp = newEntityKey("thinsp", 8201);

    /** small tilde, U+02DC ISOdia */
    public final Entity S_tilde = newEntityKey("tilde", 732);

    /**
     * latin capital letter Y with diaeresis, U+0178 ISOlat2
     */
    public final Entity S_Yuml = newEntityKey("Yuml", 376);

    /** zero width joiner, U+200D NEW RFC 2070 */
    public final Entity S_zwj = newEntityKey("zwj", 8205);

    /**
     * zero width non-joiner, U+200C NEW RFC 2070
     */
    public final Entity S_zwnj = newEntityKey("zwnj", 8204);

    /**
     * @param factory
     */
    public XHTMLSpecialEntities(EntityFactory factory) {
        super(factory);
    }
}

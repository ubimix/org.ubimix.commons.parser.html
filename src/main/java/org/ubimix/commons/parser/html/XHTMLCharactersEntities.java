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
 * 
 * <!-- Portions � International Organization for Standardization 1986
 *      Permission to copy in any form is granted for use with
 *      conforming SGML systems and applications as defined in
 *      ISO 8879, provided this notice is included in all copies.
 * -->
 * <!-- Character entity set. Typical invocation:
 *      <!ENTITY % HTMLlat1 PUBLIC
 *        "-//W3C//ENTITIES Latin 1//EN//HTML">
 *      %HTMLlat1;
 * -->
 * 
 * <!ENTITY nbsp   CDATA "&#160;" -- no-break space = non-breaking space,
 *                                   U+00A0 ISOnum -->
 * <!ENTITY iexcl  CDATA "&#161;" -- inverted exclamation mark, U+00A1 ISOnum -->
 * <!ENTITY cent   CDATA "&#162;" -- cent sign, U+00A2 ISOnum -->
 * <!ENTITY pound  CDATA "&#163;" -- pound sign, U+00A3 ISOnum -->
 * <!ENTITY curren CDATA "&#164;" -- currency sign, U+00A4 ISOnum -->
 * <!ENTITY yen    CDATA "&#165;" -- yen sign = yuan sign, U+00A5 ISOnum -->
 * <!ENTITY brvbar CDATA "&#166;" -- broken bar = broken vertical bar,
 *                                   U+00A6 ISOnum -->
 * <!ENTITY sect   CDATA "&#167;" -- section sign, U+00A7 ISOnum -->
 * <!ENTITY uml    CDATA "&#168;" -- diaeresis = spacing diaeresis,
 *                                   U+00A8 ISOdia -->
 * <!ENTITY copy   CDATA "&#169;" -- copyright sign, U+00A9 ISOnum -->
 * <!ENTITY ordf   CDATA "&#170;" -- feminine ordinal indicator, U+00AA ISOnum -->
 * <!ENTITY laquo  CDATA "&#171;" -- left-pointing double angle quotation mark
 *                                   = left pointing guillemet, U+00AB ISOnum -->
 * <!ENTITY not    CDATA "&#172;" -- not sign, U+00AC ISOnum -->
 * <!ENTITY shy    CDATA "&#173;" -- soft hyphen = discretionary hyphen,
 *                                   U+00AD ISOnum -->
 * <!ENTITY reg    CDATA "&#174;" -- registered sign = registered trade mark sign,
 *                                   U+00AE ISOnum -->
 * <!ENTITY macr   CDATA "&#175;" -- macron = spacing macron = overline
 *                                   = APL overbar, U+00AF ISOdia -->
 * <!ENTITY deg    CDATA "&#176;" -- degree sign, U+00B0 ISOnum -->
 * <!ENTITY plusmn CDATA "&#177;" -- plus-minus sign = plus-or-minus sign,
 *                                   U+00B1 ISOnum -->
 * <!ENTITY sup2   CDATA "&#178;" -- superscript two = superscript digit two
 *                                   = squared, U+00B2 ISOnum -->
 * <!ENTITY sup3   CDATA "&#179;" -- superscript three = superscript digit three
 *                                   = cubed, U+00B3 ISOnum -->
 * <!ENTITY acute  CDATA "&#180;" -- acute accent = spacing acute,
 *                                   U+00B4 ISOdia -->
 * <!ENTITY micro  CDATA "&#181;" -- micro sign, U+00B5 ISOnum -->
 * <!ENTITY para   CDATA "&#182;" -- pilcrow sign = paragraph sign,
 *                                   U+00B6 ISOnum -->
 * <!ENTITY middot CDATA "&#183;" -- middle dot = Georgian comma
 *                                   = Greek middle dot, U+00B7 ISOnum -->
 * <!ENTITY cedil  CDATA "&#184;" -- cedilla = spacing cedilla, U+00B8 ISOdia -->
 * <!ENTITY sup1   CDATA "&#185;" -- superscript one = superscript digit one,
 *                                   U+00B9 ISOnum -->
 * <!ENTITY ordm   CDATA "&#186;" -- masculine ordinal indicator,
 *                                   U+00BA ISOnum -->
 * <!ENTITY raquo  CDATA "&#187;" -- right-pointing double angle quotation mark
 *                                   = right pointing guillemet, U+00BB ISOnum -->
 * <!ENTITY frac14 CDATA "&#188;" -- vulgar fraction one quarter
 *                                   = fraction one quarter, U+00BC ISOnum -->
 * <!ENTITY frac12 CDATA "&#189;" -- vulgar fraction one half
 *                                   = fraction one half, U+00BD ISOnum -->
 * <!ENTITY frac34 CDATA "&#190;" -- vulgar fraction three quarters
 *                                   = fraction three quarters, U+00BE ISOnum -->
 * <!ENTITY iquest CDATA "&#191;" -- inverted question mark
 *                                   = turned question mark, U+00BF ISOnum -->
 * <!ENTITY Agrave CDATA "&#192;" -- latin capital letter A with grave
 *                                   = latin capital letter A grave,
 *                                   U+00C0 ISOlat1 -->
 * <!ENTITY Aacute CDATA "&#193;" -- latin capital letter A with acute,
 *                                   U+00C1 ISOlat1 -->
 * <!ENTITY Acirc  CDATA "&#194;" -- latin capital letter A with circumflex,
 *                                   U+00C2 ISOlat1 -->
 * <!ENTITY Atilde CDATA "&#195;" -- latin capital letter A with tilde,
 *                                   U+00C3 ISOlat1 -->
 * <!ENTITY Auml   CDATA "&#196;" -- latin capital letter A with diaeresis,
 *                                   U+00C4 ISOlat1 -->
 * <!ENTITY Aring  CDATA "&#197;" -- latin capital letter A with ring above
 *                                   = latin capital letter A ring,
 *                                   U+00C5 ISOlat1 -->
 * <!ENTITY AElig  CDATA "&#198;" -- latin capital letter AE
 *                                   = latin capital ligature AE,
 *                                   U+00C6 ISOlat1 -->
 * <!ENTITY Ccedil CDATA "&#199;" -- latin capital letter C with cedilla,
 *                                   U+00C7 ISOlat1 -->
 * <!ENTITY Egrave CDATA "&#200;" -- latin capital letter E with grave,
 *                                   U+00C8 ISOlat1 -->
 * <!ENTITY Eacute CDATA "&#201;" -- latin capital letter E with acute,
 *                                   U+00C9 ISOlat1 -->
 * <!ENTITY Ecirc  CDATA "&#202;" -- latin capital letter E with circumflex,
 *                                   U+00CA ISOlat1 -->
 * <!ENTITY Euml   CDATA "&#203;" -- latin capital letter E with diaeresis,
 *                                   U+00CB ISOlat1 -->
 * <!ENTITY Igrave CDATA "&#204;" -- latin capital letter I with grave,
 *                                   U+00CC ISOlat1 -->
 * <!ENTITY Iacute CDATA "&#205;" -- latin capital letter I with acute,
 *                                   U+00CD ISOlat1 -->
 * <!ENTITY Icirc  CDATA "&#206;" -- latin capital letter I with circumflex,
 *                                   U+00CE ISOlat1 -->
 * <!ENTITY Iuml   CDATA "&#207;" -- latin capital letter I with diaeresis,
 *                                   U+00CF ISOlat1 -->
 * <!ENTITY ETH    CDATA "&#208;" -- latin capital letter ETH, U+00D0 ISOlat1 -->
 * <!ENTITY Ntilde CDATA "&#209;" -- latin capital letter N with tilde,
 *                                   U+00D1 ISOlat1 -->
 * <!ENTITY Ograve CDATA "&#210;" -- latin capital letter O with grave,
 *                                   U+00D2 ISOlat1 -->
 * <!ENTITY Oacute CDATA "&#211;" -- latin capital letter O with acute,
 *                                   U+00D3 ISOlat1 -->
 * <!ENTITY Ocirc  CDATA "&#212;" -- latin capital letter O with circumflex,
 *                                   U+00D4 ISOlat1 -->
 * <!ENTITY Otilde CDATA "&#213;" -- latin capital letter O with tilde,
 *                                   U+00D5 ISOlat1 -->
 * <!ENTITY Ouml   CDATA "&#214;" -- latin capital letter O with diaeresis,
 *                                   U+00D6 ISOlat1 -->
 * <!ENTITY times  CDATA "&#215;" -- multiplication sign, U+00D7 ISOnum -->
 * <!ENTITY Oslash CDATA "&#216;" -- latin capital letter O with stroke
 *                                   = latin capital letter O slash,
 *                                   U+00D8 ISOlat1 -->
 * <!ENTITY Ugrave CDATA "&#217;" -- latin capital letter U with grave,
 *                                   U+00D9 ISOlat1 -->
 * <!ENTITY Uacute CDATA "&#218;" -- latin capital letter U with acute,
 *                                   U+00DA ISOlat1 -->
 * <!ENTITY Ucirc  CDATA "&#219;" -- latin capital letter U with circumflex,
 *                                   U+00DB ISOlat1 -->
 * <!ENTITY Uuml   CDATA "&#220;" -- latin capital letter U with diaeresis,
 *                                   U+00DC ISOlat1 -->
 * <!ENTITY Yacute CDATA "&#221;" -- latin capital letter Y with acute,
 *                                   U+00DD ISOlat1 -->
 * <!ENTITY THORN  CDATA "&#222;" -- latin capital letter THORN,
 *                                   U+00DE ISOlat1 -->
 * <!ENTITY szlig  CDATA "&#223;" -- latin small letter sharp s = ess-zed,
 *                                   U+00DF ISOlat1 -->
 * <!ENTITY agrave CDATA "&#224;" -- latin small letter a with grave
 *                                   = latin small letter a grave,
 *                                   U+00E0 ISOlat1 -->
 * <!ENTITY aacute CDATA "&#225;" -- latin small letter a with acute,
 *                                   U+00E1 ISOlat1 -->
 * <!ENTITY acirc  CDATA "&#226;" -- latin small letter a with circumflex,
 *                                   U+00E2 ISOlat1 -->
 * <!ENTITY atilde CDATA "&#227;" -- latin small letter a with tilde,
 *                                   U+00E3 ISOlat1 -->
 * <!ENTITY auml   CDATA "&#228;" -- latin small letter a with diaeresis,
 *                                   U+00E4 ISOlat1 -->
 * <!ENTITY aring  CDATA "&#229;" -- latin small letter a with ring above
 *                                   = latin small letter a ring,
 *                                   U+00E5 ISOlat1 -->
 * <!ENTITY aelig  CDATA "&#230;" -- latin small letter ae
 *                                   = latin small ligature ae, U+00E6 ISOlat1 -->
 * <!ENTITY ccedil CDATA "&#231;" -- latin small letter c with cedilla,
 *                                   U+00E7 ISOlat1 -->
 * <!ENTITY egrave CDATA "&#232;" -- latin small letter e with grave,
 *                                   U+00E8 ISOlat1 -->
 * <!ENTITY eacute CDATA "&#233;" -- latin small letter e with acute,
 *                                   U+00E9 ISOlat1 -->
 * <!ENTITY ecirc  CDATA "&#234;" -- latin small letter e with circumflex,
 *                                   U+00EA ISOlat1 -->
 * <!ENTITY euml   CDATA "&#235;" -- latin small letter e with diaeresis,
 *                                   U+00EB ISOlat1 -->
 * <!ENTITY igrave CDATA "&#236;" -- latin small letter i with grave,
 *                                   U+00EC ISOlat1 -->
 * <!ENTITY iacute CDATA "&#237;" -- latin small letter i with acute,
 *                                   U+00ED ISOlat1 -->
 * <!ENTITY icirc  CDATA "&#238;" -- latin small letter i with circumflex,
 *                                   U+00EE ISOlat1 -->
 * <!ENTITY iuml   CDATA "&#239;" -- latin small letter i with diaeresis,
 *                                   U+00EF ISOlat1 -->
 * <!ENTITY eth    CDATA "&#240;" -- latin small letter eth, U+00F0 ISOlat1 -->
 * <!ENTITY ntilde CDATA "&#241;" -- latin small letter n with tilde,
 *                                   U+00F1 ISOlat1 -->
 * <!ENTITY ograve CDATA "&#242;" -- latin small letter o with grave,
 *                                   U+00F2 ISOlat1 -->
 * <!ENTITY oacute CDATA "&#243;" -- latin small letter o with acute,
 *                                   U+00F3 ISOlat1 -->
 * <!ENTITY ocirc  CDATA "&#244;" -- latin small letter o with circumflex,
 *                                   U+00F4 ISOlat1 -->
 * <!ENTITY otilde CDATA "&#245;" -- latin small letter o with tilde,
 *                                   U+00F5 ISOlat1 -->
 * <!ENTITY ouml   CDATA "&#246;" -- latin small letter o with diaeresis,
 *                                   U+00F6 ISOlat1 -->
 * <!ENTITY divide CDATA "&#247;" -- division sign, U+00F7 ISOnum -->
 * <!ENTITY oslash CDATA "&#248;" -- latin small letter o with stroke,
 *                                   = latin small letter o slash,
 *                                   U+00F8 ISOlat1 -->
 * <!ENTITY ugrave CDATA "&#249;" -- latin small letter u with grave,
 *                                   U+00F9 ISOlat1 -->
 * <!ENTITY uacute CDATA "&#250;" -- latin small letter u with acute,
 *                                   U+00FA ISOlat1 -->
 * <!ENTITY ucirc  CDATA "&#251;" -- latin small letter u with circumflex,
 *                                   U+00FB ISOlat1 -->
 * <!ENTITY uuml   CDATA "&#252;" -- latin small letter u with diaeresis,
 *                                   U+00FC ISOlat1 -->
 * <!ENTITY yacute CDATA "&#253;" -- latin small letter y with acute,
 *                                   U+00FD ISOlat1 -->
 * <!ENTITY thorn  CDATA "&#254;" -- latin small letter thorn,
 *                                   U+00FE ISOlat1 -->
 * <!ENTITY yuml   CDATA "&#255;" -- latin small letter y with diaeresis,
 *                               U+00FF ISOlat1 -->
 * </pre>
 * @author kotelnikov
 */
public class XHTMLCharactersEntities extends EntityDictionary {

    /** latin small letter a with acute, U+00E1 ISOlat1 */
    public final Entity S_aacute = newEntityKey("aacute", 225);

    /** latin capital letter A with acute, U+00C1 ISOlat1 */
    public final Entity S_Aacute = newEntityKey("Aacute", 193);

    /** latin small letter a with circumflex, U+00E2 ISOlat1 */
    public final Entity S_acirc = newEntityKey("acirc", 226);

    /** latin capital letter A with circumflex, U+00C2 ISOlat1 */
    public final Entity S_Acirc = newEntityKey("Acirc", 194);

    /** acute accent = spacing acute, U+00B4 ISOdia */
    public final Entity S_acute = newEntityKey("acute", 180);

    /** latin small letter ae = latin small ligature ae, U+00E6 ISOlat1 */
    public final Entity S_aelig = newEntityKey("aelig", 230);

    /** latin capital letter AE = latin capital ligature AE, U+00C6 ISOlat1 */
    public final Entity S_AElig = newEntityKey("AElig", 198);

    /**
     * latin small letter a with grave = latin small letter a grave, U+00E0
     * ISOlat1
     */
    public final Entity S_agrave = newEntityKey("agrave", 224);

    /**
     * latin capital letter A with grave = latin capital letter A grave, U+00C0
     * ISOlat1
     */
    public final Entity S_Agrave = newEntityKey("Agrave", 192);

    /**
     * latin small letter a with ring above = latin small letter a ring, U+00E5
     * ISOlat1
     */
    public final Entity S_aring = newEntityKey("aring", 229);

    /**
     * latin capital letter A with ring above = latin capital letter A ring,
     * U+00C5 ISOlat1
     */
    public final Entity S_Aring = newEntityKey("Aring", 197);

    /** latin small letter a with tilde, U+00E3 ISOlat1 */
    public final Entity S_atilde = newEntityKey("atilde", 227);

    /** latin capital letter A with tilde, U+00C3 ISOlat1 */
    public final Entity S_Atilde = newEntityKey("Atilde", 195);

    /** latin small letter a with diaeresis, U+00E4 ISOlat1 */
    public final Entity S_auml = newEntityKey("auml", 228);

    /** latin capital letter A with diaeresis, U+00C4 ISOlat1 */
    public final Entity S_Auml = newEntityKey("Auml", 196);

    /** broken bar = broken vertical bar, U+00A6 ISOnum */
    public final Entity S_brvbar = newEntityKey("brvbar", 166);

    /** latin small letter c with cedilla, U+00E7 ISOlat1 */
    public final Entity S_ccedil = newEntityKey("ccedil", 231);

    /** latin capital letter C with cedilla, U+00C7 ISOlat1 */
    public final Entity S_Ccedil = newEntityKey("Ccedil", 199);

    /** cedilla = spacing cedilla, U+00B8 ISOdia */
    public final Entity S_cedil = newEntityKey("cedil", 184);

    /** cent sign, U+00A2 ISOnum */
    public final Entity S_cent = newEntityKey("cent", 162);

    /** copyright sign, U+00A9 ISOnum */
    public final Entity S_copy = newEntityKey("copy", 169);

    /** currency sign, U+00A4 ISOnum */
    public final Entity S_curren = newEntityKey("curren", 164);

    /** degree sign, U+00B0 ISOnum */
    public final Entity S_deg = newEntityKey("deg", 176);

    /** division sign, U+00F7 ISOnum */
    public final Entity S_divide = newEntityKey("divide", 247);

    /** latin small letter e with acute, U+00E9 ISOlat1 */
    public final Entity S_eacute = newEntityKey("eacute", 233);

    /** latin capital letter E with acute, U+00C9 ISOlat1 */
    public final Entity S_Eacute = newEntityKey("Eacute", 201);

    /** latin small letter e with circumflex, U+00EA ISOlat1 */
    public final Entity S_ecirc = newEntityKey("ecirc", 234);

    /** latin capital letter E with circumflex, U+00CA ISOlat1 */
    public final Entity S_Ecirc = newEntityKey("Ecirc", 202);

    /** latin small letter e with grave, U+00E8 ISOlat1 */
    public final Entity S_egrave = newEntityKey("egrave", 232);

    /** latin capital letter E with grave, U+00C8 ISOlat1 */
    public final Entity S_Egrave = newEntityKey("Egrave", 200);

    /** latin small letter eth, U+00F0 ISOlat1 */
    public final Entity S_eth = newEntityKey("eth", 240);

    /** latin capital letter ETH, U+00D0 ISOlat1 */
    public final Entity S_ETH = newEntityKey("ETH", 208);

    /** latin small letter e with diaeresis, U+00EB ISOlat1 */
    public final Entity S_euml = newEntityKey("euml", 235);

    /** latin capital letter E with diaeresis, U+00CB ISOlat1 */
    public final Entity S_Euml = newEntityKey("Euml", 203);

    /** vulgar fraction one half = fraction one half, U+00BD ISOnum */
    public final Entity S_frac12 = newEntityKey("frac12", 189);

    /** vulgar fraction one quarter = fraction one quarter, U+00BC ISOnum */
    public final Entity S_frac14 = newEntityKey("frac14", 188);

    /** vulgar fraction three quarters = fraction three quarters, U+00BE ISOnum */
    public final Entity S_frac34 = newEntityKey("frac34", 190);

    /** latin small letter i with acute, U+00ED ISOlat1 */
    public final Entity S_iacute = newEntityKey("iacute", 237);

    /** latin capital letter I with acute, U+00CD ISOlat1 */
    public final Entity S_Iacute = newEntityKey("Iacute", 205);

    /** latin small letter i with circumflex, U+00EE ISOlat1 */
    public final Entity S_icirc = newEntityKey("icirc", 238);

    /** latin capital letter I with circumflex, U+00CE ISOlat1 */
    public final Entity S_Icirc = newEntityKey("Icirc", 206);

    /** inverted exclamation mark, U+00A1 ISOnum */
    public final Entity S_iexcl = newEntityKey("iexcl", 161);

    /** latin small letter i with grave, U+00EC ISOlat1 */
    public final Entity S_igrave = newEntityKey("igrave", 236);

    /** latin capital letter I with grave, U+00CC ISOlat1 */
    public final Entity S_Igrave = newEntityKey("Igrave", 204);

    /** inverted question mark = turned question mark, U+00BF ISOnum */
    public final Entity S_iquest = newEntityKey("iquest", 191);

    /** latin small letter i with diaeresis, U+00EF ISOlat1 */
    public final Entity S_iuml = newEntityKey("iuml", 239);

    /** latin capital letter I with diaeresis, U+00CF ISOlat1 */
    public final Entity S_Iuml = newEntityKey("Iuml", 207);

    /**
     * left-pointing double angle quotation mark = left pointing guillemet,
     * U+00AB ISOnum
     */
    public final Entity S_laquo = newEntityKey("laquo", 171);

    /** macron = spacing macron = overline = APL overbar, U+00AF ISOdia */
    public final Entity S_macr = newEntityKey("macr", 175);

    /** micro sign, U+00B5 ISOnum */
    public final Entity S_micro = newEntityKey("micro", 181);

    /** middle dot = Georgian comma = Greek middle dot, U+00B7 ISOnum */
    public final Entity S_middot = newEntityKey("middot", 183);

    /** no-break space = non-breaking space, U+00A0 ISOnum */
    public final Entity S_nbsp = newEntityKey("nbsp", 160);

    /** not sign, U+00AC ISOnum */
    public final Entity S_not = newEntityKey("not", 172);

    /** latin small letter n with tilde, U+00F1 ISOlat1 */
    public final Entity S_ntilde = newEntityKey("ntilde", 241);

    /** latin capital letter N with tilde, U+00D1 ISOlat1 */
    public final Entity S_Ntilde = newEntityKey("Ntilde", 209);

    /** latin small letter o with acute, U+00F3 ISOlat1 */
    public final Entity S_oacute = newEntityKey("oacute", 243);

    /** latin capital letter O with acute, U+00D3 ISOlat1 */
    public final Entity S_Oacute = newEntityKey("Oacute", 211);

    /** latin small letter o with circumflex, U+00F4 ISOlat1 */
    public final Entity S_ocirc = newEntityKey("ocirc", 244);

    /** latin capital letter O with circumflex, U+00D4 ISOlat1 */
    public final Entity S_Ocirc = newEntityKey("Ocirc", 212);

    /** latin small letter o with grave, U+00F2 ISOlat1 */
    public final Entity S_ograve = newEntityKey("ograve", 242);

    /** latin capital letter O with grave, U+00D2 ISOlat1 */
    public final Entity S_Ograve = newEntityKey("Ograve", 210);

    /** feminine ordinal indicator, U+00AA ISOnum */
    public final Entity S_ordf = newEntityKey("ordf", 170);

    /** masculine ordinal indicator, U+00BA ISOnum */
    public final Entity S_ordm = newEntityKey("ordm", 186);

    /**
     * latin small letter o with stroke, = latin small letter o slash, U+00F8
     * ISOlat1
     */
    public final Entity S_oslash = newEntityKey("oslash", 248);

    /**
     * latin capital letter O with stroke = latin capital letter O slash, U+00D8
     * ISOlat1
     */
    public final Entity S_Oslash = newEntityKey("Oslash", 216);

    /** latin small letter o with tilde, U+00F5 ISOlat1 */
    public final Entity S_otilde = newEntityKey("otilde", 245);

    /** latin capital letter O with tilde, U+00D5 ISOlat1 */
    public final Entity S_Otilde = newEntityKey("Otilde", 213);

    /** latin small letter o with diaeresis, U+00F6 ISOlat1 */
    public final Entity S_ouml = newEntityKey("ouml", 246);

    /** latin capital letter O with diaeresis, U+00D6 ISOlat1 */
    public final Entity S_Ouml = newEntityKey("Ouml", 214);

    /** pilcrow sign = paragraph sign, U+00B6 ISOnum */
    public final Entity S_para = newEntityKey("para", 182);

    /** plus-minus sign = plus-or-minus sign, U+00B1 ISOnum */
    public final Entity S_plusmn = newEntityKey("plusmn", 177);

    /** pound sign, U+00A3 ISOnum */
    public final Entity S_pound = newEntityKey("pound", 163);

    /**
     * right-pointing double angle quotation mark = right pointing guillemet,
     * U+00BB ISOnum
     */
    public final Entity S_raquo = newEntityKey("raquo", 187);

    /** registered sign = registered trade mark sign, U+00AE ISOnum */
    public final Entity S_reg = newEntityKey("reg", 174);

    /** section sign, U+00A7 ISOnum */
    public final Entity S_sect = newEntityKey("sect", 167);

    /** soft hyphen = discretionary hyphen, U+00AD ISOnum */
    public final Entity S_shy = newEntityKey("shy", 173);

    /** superscript one = superscript digit one, U+00B9 ISOnum */
    public final Entity S_sup1 = newEntityKey("sup1", 185);

    /** superscript two = superscript digit two = squared, U+00B2 ISOnum */
    public final Entity S_sup2 = newEntityKey("sup2", 178);

    /** superscript three = superscript digit three = cubed, U+00B3 ISOnum */
    public final Entity S_sup3 = newEntityKey("sup3", 179);

    /** latin small letter sharp s = ess-zed, U+00DF ISOlat1 */
    public final Entity S_szlig = newEntityKey("szlig", 223);

    /** latin small letter thorn, U+00FE ISOlat1 */
    public final Entity S_thorn = newEntityKey("thorn", 254);

    /** latin capital letter THORN, U+00DE ISOlat1 */
    public final Entity S_THORN = newEntityKey("THORN", 222);

    /** multiplication sign, U+00D7 ISOnum */
    public final Entity S_times = newEntityKey("times", 215);

    /** latin small letter u with acute, U+00FA ISOlat1 */
    public final Entity S_uacute = newEntityKey("uacute", 250);

    /** latin capital letter U with acute, U+00DA ISOlat1 */
    public final Entity S_Uacute = newEntityKey("Uacute", 218);

    /** latin small letter u with circumflex, U+00FB ISOlat1 */
    public final Entity S_ucirc = newEntityKey("ucirc", 251);

    /** latin capital letter U with circumflex, U+00DB ISOlat1 */
    public final Entity S_Ucirc = newEntityKey("Ucirc", 219);

    /** latin small letter u with grave, U+00F9 ISOlat1 */
    public final Entity S_ugrave = newEntityKey("ugrave", 249);

    /** latin capital letter U with grave, U+00D9 ISOlat1 */
    public final Entity S_Ugrave = newEntityKey("Ugrave", 217);

    /** diaeresis = spacing diaeresis, U+00A8 ISOdia */
    public final Entity S_uml = newEntityKey("uml", 168);

    /** latin small letter u with diaeresis, U+00FC ISOlat1 */
    public final Entity S_uuml = newEntityKey("uuml", 252);

    /** latin capital letter U with diaeresis, U+00DC ISOlat1 */
    public final Entity S_Uuml = newEntityKey("Uuml", 220);

    /** latin small letter y with acute, U+00FD ISOlat1 */
    public final Entity S_yacute = newEntityKey("yacute", 253);

    /** latin capital letter Y with acute, U+00DD ISOlat1 */
    public final Entity S_Yacute = newEntityKey("Yacute", 221);

    /** yen sign = yuan sign, U+00A5 ISOnum */
    public final Entity S_yen = newEntityKey("yen", 165);

    /** latin small letter y with diaeresis, U+00FF ISOlat1 */
    public final Entity S_yuml = newEntityKey("yuml", 255);

    public XHTMLCharactersEntities(EntityFactory factory) {
        super(factory);
    }

}

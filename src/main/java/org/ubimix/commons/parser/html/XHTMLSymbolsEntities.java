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
 * <!-- Mathematical, Greek and Symbolic characters for HTML -->
 * 
 * <!-- Character entity set. Typical invocation:
 *      <!ENTITY % HTMLsymbol PUBLIC
 *        "-//W3C//ENTITIES Symbols//EN//HTML">
 *      %HTMLsymbol; -->
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
 * <!-- Latin Extended-B -->
 * <!ENTITY fnof     CDATA "&#402;" -- latin small f with hook = function
 *                                     = florin, U+0192 ISOtech -->
 * 
 * <!-- Greek -->
 * <!ENTITY Alpha    CDATA "&#913;" -- greek capital letter alpha, U+0391 -->
 * <!ENTITY Beta     CDATA "&#914;" -- greek capital letter beta, U+0392 -->
 * <!ENTITY Gamma    CDATA "&#915;" -- greek capital letter gamma,
 *                                     U+0393 ISOgrk3 -->
 * <!ENTITY Delta    CDATA "&#916;" -- greek capital letter delta,
 *                                     U+0394 ISOgrk3 -->
 * <!ENTITY Epsilon  CDATA "&#917;" -- greek capital letter epsilon, U+0395 -->
 * <!ENTITY Zeta     CDATA "&#918;" -- greek capital letter zeta, U+0396 -->
 * <!ENTITY Eta      CDATA "&#919;" -- greek capital letter eta, U+0397 -->
 * <!ENTITY Theta    CDATA "&#920;" -- greek capital letter theta,
 *                                     U+0398 ISOgrk3 -->
 * <!ENTITY Iota     CDATA "&#921;" -- greek capital letter iota, U+0399 -->
 * <!ENTITY Kappa    CDATA "&#922;" -- greek capital letter kappa, U+039A -->
 * <!ENTITY Lambda   CDATA "&#923;" -- greek capital letter lambda,
 *                                     U+039B ISOgrk3 -->
 * <!ENTITY Mu       CDATA "&#924;" -- greek capital letter mu, U+039C -->
 * <!ENTITY Nu       CDATA "&#925;" -- greek capital letter nu, U+039D -->
 * <!ENTITY Xi       CDATA "&#926;" -- greek capital letter xi, U+039E ISOgrk3 -->
 * <!ENTITY Omicron  CDATA "&#927;" -- greek capital letter omicron, U+039F -->
 * <!ENTITY Pi       CDATA "&#928;" -- greek capital letter pi, U+03A0 ISOgrk3 -->
 * <!ENTITY Rho      CDATA "&#929;" -- greek capital letter rho, U+03A1 -->
 * <!-- there is no Sigmaf, and no U+03A2 character either -->
 * <!ENTITY Sigma    CDATA "&#931;" -- greek capital letter sigma,
 *                                     U+03A3 ISOgrk3 -->
 * <!ENTITY Tau      CDATA "&#932;" -- greek capital letter tau, U+03A4 -->
 * <!ENTITY Upsilon  CDATA "&#933;" -- greek capital letter upsilon,
 *                                     U+03A5 ISOgrk3 -->
 * <!ENTITY Phi      CDATA "&#934;" -- greek capital letter phi,
 *                                     U+03A6 ISOgrk3 -->
 * <!ENTITY Chi      CDATA "&#935;" -- greek capital letter chi, U+03A7 -->
 * <!ENTITY Psi      CDATA "&#936;" -- greek capital letter psi,
 *                                     U+03A8 ISOgrk3 -->
 * <!ENTITY Omega    CDATA "&#937;" -- greek capital letter omega,
 *                                     U+03A9 ISOgrk3 -->
 * 
 * <!ENTITY alpha    CDATA "&#945;" -- greek small letter alpha,
 *                                     U+03B1 ISOgrk3 -->
 * <!ENTITY beta     CDATA "&#946;" -- greek small letter beta, U+03B2 ISOgrk3 -->
 * <!ENTITY gamma    CDATA "&#947;" -- greek small letter gamma,
 *                                     U+03B3 ISOgrk3 -->
 * <!ENTITY delta    CDATA "&#948;" -- greek small letter delta,
 *                                     U+03B4 ISOgrk3 -->
 * <!ENTITY epsilon  CDATA "&#949;" -- greek small letter epsilon,
 *                                     U+03B5 ISOgrk3 -->
 * <!ENTITY zeta     CDATA "&#950;" -- greek small letter zeta, U+03B6 ISOgrk3 -->
 * <!ENTITY eta      CDATA "&#951;" -- greek small letter eta, U+03B7 ISOgrk3 -->
 * <!ENTITY theta    CDATA "&#952;" -- greek small letter theta,
 *                                     U+03B8 ISOgrk3 -->
 * <!ENTITY iota     CDATA "&#953;" -- greek small letter iota, U+03B9 ISOgrk3 -->
 * <!ENTITY kappa    CDATA "&#954;" -- greek small letter kappa,
 *                                     U+03BA ISOgrk3 -->
 * <!ENTITY lambda   CDATA "&#955;" -- greek small letter lambda,
 *                                     U+03BB ISOgrk3 -->
 * <!ENTITY mu       CDATA "&#956;" -- greek small letter mu, U+03BC ISOgrk3 -->
 * <!ENTITY nu       CDATA "&#957;" -- greek small letter nu, U+03BD ISOgrk3 -->
 * <!ENTITY xi       CDATA "&#958;" -- greek small letter xi, U+03BE ISOgrk3 -->
 * <!ENTITY omicron  CDATA "&#959;" -- greek small letter omicron, U+03BF NEW -->
 * <!ENTITY pi       CDATA "&#960;" -- greek small letter pi, U+03C0 ISOgrk3 -->
 * <!ENTITY rho      CDATA "&#961;" -- greek small letter rho, U+03C1 ISOgrk3 -->
 * <!ENTITY sigmaf   CDATA "&#962;" -- greek small letter final sigma,
 *                                     U+03C2 ISOgrk3 -->
 * <!ENTITY sigma    CDATA "&#963;" -- greek small letter sigma,
 *                                     U+03C3 ISOgrk3 -->
 * <!ENTITY tau      CDATA "&#964;" -- greek small letter tau, U+03C4 ISOgrk3 -->
 * <!ENTITY upsilon  CDATA "&#965;" -- greek small letter upsilon,
 *                                     U+03C5 ISOgrk3 -->
 * <!ENTITY phi      CDATA "&#966;" -- greek small letter phi, U+03C6 ISOgrk3 -->
 * <!ENTITY chi      CDATA "&#967;" -- greek small letter chi, U+03C7 ISOgrk3 -->
 * <!ENTITY psi      CDATA "&#968;" -- greek small letter psi, U+03C8 ISOgrk3 -->
 * <!ENTITY omega    CDATA "&#969;" -- greek small letter omega,
 *                                     U+03C9 ISOgrk3 -->
 * <!ENTITY thetasym CDATA "&#977;" -- greek small letter theta symbol,
 *                                     U+03D1 NEW -->
 * <!ENTITY upsih    CDATA "&#978;" -- greek upsilon with hook symbol,
 *                                     U+03D2 NEW -->
 * <!ENTITY piv      CDATA "&#982;" -- greek pi symbol, U+03D6 ISOgrk3 -->
 * 
 * <!-- General Punctuation -->
 * <!ENTITY bull     CDATA "&#8226;" -- bullet = black small circle,
 *                                      U+2022 ISOpub  -->
 * <!-- bullet is NOT the same as bullet operator, U+2219 -->
 * <!ENTITY hellip   CDATA "&#8230;" -- horizontal ellipsis = three dot leader,
 *                                      U+2026 ISOpub  -->
 * <!ENTITY prime    CDATA "&#8242;" -- prime = minutes = feet, U+2032 ISOtech -->
 * <!ENTITY Prime    CDATA "&#8243;" -- double prime = seconds = inches,
 *                                      U+2033 ISOtech -->
 * <!ENTITY oline    CDATA "&#8254;" -- overline = spacing overscore,
 *                                      U+203E NEW -->
 * <!ENTITY frasl    CDATA "&#8260;" -- fraction slash, U+2044 NEW -->
 * 
 * <!-- Letterlike Symbols -->
 * <!ENTITY weierp   CDATA "&#8472;" -- script capital P = power set
 *                                      = Weierstrass p, U+2118 ISOamso -->
 * <!ENTITY image    CDATA "&#8465;" -- blackletter capital I = imaginary part,
 *                                      U+2111 ISOamso -->
 * <!ENTITY real     CDATA "&#8476;" -- blackletter capital R = real part symbol,
 *                                      U+211C ISOamso -->
 * <!ENTITY trade    CDATA "&#8482;" -- trade mark sign, U+2122 ISOnum -->
 * <!ENTITY alefsym  CDATA "&#8501;" -- alef symbol = first transfinite cardinal,
 *                                      U+2135 NEW -->
 * <!-- alef symbol is NOT the same as hebrew letter alef,
 *      U+05D0 although the same glyph could be used to depict both characters -->
 * 
 * <!-- Arrows -->
 * <!ENTITY larr     CDATA "&#8592;" -- leftwards arrow, U+2190 ISOnum -->
 * <!ENTITY uarr     CDATA "&#8593;" -- upwards arrow, U+2191 ISOnum-->
 * <!ENTITY rarr     CDATA "&#8594;" -- rightwards arrow, U+2192 ISOnum -->
 * <!ENTITY darr     CDATA "&#8595;" -- downwards arrow, U+2193 ISOnum -->
 * <!ENTITY harr     CDATA "&#8596;" -- left right arrow, U+2194 ISOamsa -->
 * <!ENTITY crarr    CDATA "&#8629;" -- downwards arrow with corner leftwards
 *                                      = carriage return, U+21B5 NEW -->
 * <!ENTITY lArr     CDATA "&#8656;" -- leftwards double arrow, U+21D0 ISOtech -->
 * <!-- ISO 10646 does not say that lArr is the same as the 'is implied by' arrow
 *     but also does not have any other character for that function. So ? lArr can
 *     be used for 'is implied by' as ISOtech suggests -->
 * <!ENTITY uArr     CDATA "&#8657;" -- upwards double arrow, U+21D1 ISOamsa -->
 * <!ENTITY rArr     CDATA "&#8658;" -- rightwards double arrow,
 *                                      U+21D2 ISOtech -->
 * <!-- ISO 10646 does not say this is the 'implies' character but does not have 
 *      another character with this function so ?
 *      rArr can be used for 'implies' as ISOtech suggests -->
 * <!ENTITY dArr     CDATA "&#8659;" -- downwards double arrow, U+21D3 ISOamsa -->
 * <!ENTITY hArr     CDATA "&#8660;" -- left right double arrow,
 *                                      U+21D4 ISOamsa -->
 * 
 * <!-- Mathematical Operators -->
 * <!ENTITY forall   CDATA "&#8704;" -- for all, U+2200 ISOtech -->
 * <!ENTITY part     CDATA "&#8706;" -- partial differential, U+2202 ISOtech  -->
 * <!ENTITY exist    CDATA "&#8707;" -- there exists, U+2203 ISOtech -->
 * <!ENTITY empty    CDATA "&#8709;" -- empty set = null set = diameter,
 *                                      U+2205 ISOamso -->
 * <!ENTITY nabla    CDATA "&#8711;" -- nabla = backward difference,
 *                                      U+2207 ISOtech -->
 * <!ENTITY isin     CDATA "&#8712;" -- element of, U+2208 ISOtech -->
 * <!ENTITY notin    CDATA "&#8713;" -- not an element of, U+2209 ISOtech -->
 * <!ENTITY ni       CDATA "&#8715;" -- contains as member, U+220B ISOtech -->
 * <!-- should there be a more memorable name than 'ni'? -->
 * <!ENTITY prod     CDATA "&#8719;" -- n-ary product = product sign,
 *                                      U+220F ISOamsb -->
 * <!-- prod is NOT the same character as U+03A0 'greek capital letter pi' though
 *      the same glyph might be used for both -->
 * <!ENTITY sum      CDATA "&#8721;" -- n-ary sumation, U+2211 ISOamsb -->
 * <!-- sum is NOT the same character as U+03A3 'greek capital letter sigma'
 *      though the same glyph might be used for both -->
 * <!ENTITY minus    CDATA "&#8722;" -- minus sign, U+2212 ISOtech -->
 * <!ENTITY lowast   CDATA "&#8727;" -- asterisk operator, U+2217 ISOtech -->
 * <!ENTITY radic    CDATA "&#8730;" -- square root = radical sign,
 *                                      U+221A ISOtech -->
 * <!ENTITY prop     CDATA "&#8733;" -- proportional to, U+221D ISOtech -->
 * <!ENTITY infin    CDATA "&#8734;" -- infinity, U+221E ISOtech -->
 * <!ENTITY ang      CDATA "&#8736;" -- angle, U+2220 ISOamso -->
 * <!ENTITY and      CDATA "&#8743;" -- logical and = wedge, U+2227 ISOtech -->
 * <!ENTITY or       CDATA "&#8744;" -- logical or = vee, U+2228 ISOtech -->
 * <!ENTITY cap      CDATA "&#8745;" -- intersection = cap, U+2229 ISOtech -->
 * <!ENTITY cup      CDATA "&#8746;" -- union = cup, U+222A ISOtech -->
 * <!ENTITY int      CDATA "&#8747;" -- integral, U+222B ISOtech -->
 * <!ENTITY there4   CDATA "&#8756;" -- therefore, U+2234 ISOtech -->
 * <!ENTITY sim      CDATA "&#8764;" -- tilde operator = varies with = similar to,
 *                                      U+223C ISOtech -->
 * <!-- tilde operator is NOT the same character as the tilde, U+007E,
 *      although the same glyph might be used to represent both  -->
 * <!ENTITY cong     CDATA "&#8773;" -- approximately equal to, U+2245 ISOtech -->
 * <!ENTITY asymp    CDATA "&#8776;" -- almost equal to = asymptotic to,
 *                                      U+2248 ISOamsr -->
 * <!ENTITY ne       CDATA "&#8800;" -- not equal to, U+2260 ISOtech -->
 * <!ENTITY equiv    CDATA "&#8801;" -- identical to, U+2261 ISOtech -->
 * <!ENTITY le       CDATA "&#8804;" -- less-than or equal to, U+2264 ISOtech -->
 * <!ENTITY ge       CDATA "&#8805;" -- greater-than or equal to,
 *                                      U+2265 ISOtech -->
 * <!ENTITY sub      CDATA "&#8834;" -- subset of, U+2282 ISOtech -->
 * <!ENTITY sup      CDATA "&#8835;" -- superset of, U+2283 ISOtech -->
 * <!-- note that nsup, 'not a superset of, U+2283' is not covered by the Symbol 
 *      font encoding and is not included. Should it be, for symmetry?
 *      It is in ISOamsn  --> 
 * <!ENTITY nsub     CDATA "&#8836;" -- not a subset of, U+2284 ISOamsn -->
 * <!ENTITY sube     CDATA "&#8838;" -- subset of or equal to, U+2286 ISOtech -->
 * <!ENTITY supe     CDATA "&#8839;" -- superset of or equal to,
 *                                      U+2287 ISOtech -->
 * <!ENTITY oplus    CDATA "&#8853;" -- circled plus = direct sum,
 *                                      U+2295 ISOamsb -->
 * <!ENTITY otimes   CDATA "&#8855;" -- circled times = vector product,
 *                                      U+2297 ISOamsb -->
 * <!ENTITY perp     CDATA "&#8869;" -- up tack = orthogonal to = perpendicular,
 *                                      U+22A5 ISOtech -->
 * <!ENTITY sdot     CDATA "&#8901;" -- dot operator, U+22C5 ISOamsb -->
 * <!-- dot operator is NOT the same character as U+00B7 middle dot -->
 * 
 * <!-- Miscellaneous Technical -->
 * <!ENTITY lceil    CDATA "&#8968;" -- left ceiling = apl upstile,
 *                                      U+2308 ISOamsc  -->
 * <!ENTITY rceil    CDATA "&#8969;" -- right ceiling, U+2309 ISOamsc  -->
 * <!ENTITY lfloor   CDATA "&#8970;" -- left floor = apl downstile,
 *                                      U+230A ISOamsc  -->
 * <!ENTITY rfloor   CDATA "&#8971;" -- right floor, U+230B ISOamsc  -->
 * <!ENTITY lang     CDATA "&#9001;" -- left-pointing angle bracket = bra,
 *                                      U+2329 ISOtech -->
 * <!-- lang is NOT the same character as U+003C 'less than' 
 *      or U+2039 'single left-pointing angle quotation mark' -->
 * <!ENTITY rang     CDATA "&#9002;" -- right-pointing angle bracket = ket,
 *                                      U+232A ISOtech -->
 * <!-- rang is NOT the same character as U+003E 'greater than' 
 *      or U+203A 'single right-pointing angle quotation mark' -->
 * 
 * <!-- Geometric Shapes -->
 * <!ENTITY loz      CDATA "&#9674;" -- lozenge, U+25CA ISOpub -->
 * 
 * <!-- Miscellaneous Symbols -->
 * <!ENTITY spades   CDATA "&#9824;" -- black spade suit, U+2660 ISOpub -->
 * <!-- black here seems to mean filled as opposed to hollow -->
 * <!ENTITY clubs    CDATA "&#9827;" -- black club suit = shamrock,
 *                                      U+2663 ISOpub -->
 * <!ENTITY hearts   CDATA "&#9829;" -- black heart suit = valentine,
 *                                      U+2665 ISOpub -->
 * <!ENTITY diams    CDATA "&#9830;" -- black diamond suit, U+2666 ISOpub -->
 * </pre>
 * @author kotelnikov
 */
public class XHTMLSymbolsEntities extends EntityDictionary {

    /**
     * alef symbol is NOT the same as hebrew letter alef, U+05D0 although the
     * same glyph could be used to depict both characters
     */
    /**
     * alef symbol = first transfinite cardinal, U+2135 NEW
     */
    public final Entity S_alefsym = newEntityKey("alefsym", 8501);

    /**
     * greek small letter alpha, U+03B1 ISOgrk3
     */
    public final Entity S_alpha = newEntityKey("alpha", 945);

    /** greek capital letter alpha, U+0391 */
    public final Entity S_Alpha = newEntityKey("Alpha", 913);

    /** logical and = wedge, U+2227 ISOtech */
    public final Entity S_and = newEntityKey("and", 8743);

    /** angle, U+2220 ISOamso */
    public final Entity S_ang = newEntityKey("ang", 8736);

    /**
     * almost equal to = asymptotic to, U+2248 ISOamsr
     */
    public final Entity S_asymp = newEntityKey("asymp", 8776);

    /** greek small letter beta, U+03B2 ISOgrk3 */
    public final Entity S_beta = newEntityKey("beta", 946);

    /** greek capital letter beta, U+0392 */
    public final Entity S_Beta = newEntityKey("Beta", 914);

    /**
     * bullet = black small circle, U+2022 ISOpub
     */
    public final Entity S_bull = newEntityKey("bull", 8226);

    /** intersection = cap, U+2229 ISOtech */
    public final Entity S_cap = newEntityKey("cap", 8745);

    /** greek small letter chi, U+03C7 ISOgrk3 */
    public final Entity S_chi = newEntityKey("chi", 967);

    /** greek capital letter chi, U+03A7 */
    public final Entity S_Chi = newEntityKey("Chi", 935);

    /**
     * black club suit = shamrock, U+2663 ISOpub
     */
    public final Entity S_clubs = newEntityKey("clubs", 9827);

    /**
     * tilde operator is NOT the same character as the tilde, U+007E, although
     * the same glyph might be used to represent both
     */
    /** approximately equal to, U+2245 ISOtech */
    public final Entity S_cong = newEntityKey("cong", 8773);

    /**
     * downwards arrow with corner leftwards = carriage return, U+21B5 NEW
     */
    public final Entity S_crarr = newEntityKey("crarr", 8629);

    /** union = cup, U+222A ISOtech */
    public final Entity S_cup = newEntityKey("cup", 8746);

    /** downwards arrow, U+2193 ISOnum */
    public final Entity S_darr = newEntityKey("darr", 8595);

    /**
     * ISO 10646 does not say this is the 'implies' character but does not have
     * another character with this function so ? rArr can be used for 'implies'
     * as ISOtech suggests
     */
    /** downwards double arrow, U+21D3 ISOamsa */
    public final Entity S_dArr = newEntityKey("dArr", 8659);

    /**
     * greek small letter delta, U+03B4 ISOgrk3
     */
    public final Entity S_delta = newEntityKey("delta", 948);

    /**
     * greek capital letter delta, U+0394 ISOgrk3
     */
    public final Entity S_Delta = newEntityKey("Delta", 916);

    /** black diamond suit, U+2666 ISOpub */
    public final Entity S_diams = newEntityKey("diams", 9830);

    /**
     * empty set = null set = diameter, U+2205 ISOamso
     */
    public final Entity S_empty = newEntityKey("empty", 8709);

    /**
     * greek small letter epsilon, U+03B5 ISOgrk3
     */
    public final Entity S_epsilon = newEntityKey("epsilon", 949);

    /** greek capital letter epsilon, U+0395 */
    public final Entity S_Epsilon = newEntityKey("Epsilon", 917);

    /** identical to, U+2261 ISOtech */
    public final Entity S_equiv = newEntityKey("equiv", 8801);

    /** greek small letter eta, U+03B7 ISOgrk3 */
    public final Entity S_eta = newEntityKey("eta", 951);

    /** greek capital letter eta, U+0397 */
    public final Entity S_Eta = newEntityKey("Eta", 919);

    /** there exists, U+2203 ISOtech */
    public final Entity S_exist = newEntityKey("exist", 8707);

    /**
     * latin small f with hook = function = florin, U+0192 ISOtech
     */
    public final Entity S_fnof = newEntityKey("fnof", 402);

    /** for all, U+2200 ISOtech */
    public final Entity S_forall = newEntityKey("forall", 8704);

    /** fraction slash, U+2044 NEW */
    public final Entity S_frasl = newEntityKey("frasl", 8260);

    /**
     * greek small letter gamma, U+03B3 ISOgrk3
     */
    public final Entity S_gamma = newEntityKey("gamma", 947);

    /**
     * greek capital letter gamma, U+0393 ISOgrk3
     */
    public final Entity S_Gamma = newEntityKey("Gamma", 915);

    /**
     * greater-than or equal to, U+2265 ISOtech
     */
    public final Entity S_ge = newEntityKey("ge", 8805);

    /** left right arrow, U+2194 ISOamsa */
    public final Entity S_harr = newEntityKey("harr", 8596);

    /**
     * left right double arrow, U+21D4 ISOamsa
     */
    public final Entity S_hArr = newEntityKey("hArr", 8660);

    /**
     * black heart suit = valentine, U+2665 ISOpub
     */
    public final Entity S_hearts = newEntityKey("hearts", 9829);

    /**
     * horizontal ellipsis = three dot leader, U+2026 ISOpub
     */
    public final Entity S_hellip = newEntityKey("hellip", 8230);

    /**
     * blackletter capital I = imaginary part, U+2111 ISOamso
     */
    public final Entity S_image = newEntityKey("image", 8465);

    /** infinity, U+221E ISOtech */
    public final Entity S_infin = newEntityKey("infin", 8734);

    /** integral, U+222B ISOtech */
    public final Entity S_int = newEntityKey("int", 8747);

    /** greek small letter iota, U+03B9 ISOgrk3 */
    public final Entity S_iota = newEntityKey("iota", 953);

    /** greek capital letter iota, U+0399 */
    public final Entity S_Iota = newEntityKey("Iota", 921);

    /** element of, U+2208 ISOtech */
    public final Entity S_isin = newEntityKey("isin", 8712);

    /**
     * greek small letter kappa, U+03BA ISOgrk3
     */
    public final Entity S_kappa = newEntityKey("kappa", 954);

    /** greek capital letter kappa, U+039A */
    public final Entity S_Kappa = newEntityKey("Kappa", 922);

    /**
     * greek small letter lambda, U+03BB ISOgrk3
     */
    public final Entity S_lambda = newEntityKey("lambda", 955);

    /**
     * greek capital letter lambda, U+039B ISOgrk3
     */
    public final Entity S_Lambda = newEntityKey("Lambda", 923);

    /**
     * lang is NOT the same character as U+003C 'less than' or U+2039 'single
     * left-pointing angle quotation mark'
     */
    /**
     * left-pointing angle bracket = bra, U+2329 ISOtech
     */
    public final Entity S_lang = newEntityKey("lang", 9001);

    /** leftwards arrow, U+2190 ISOnum */
    public final Entity S_larr = newEntityKey("larr", 8592);

    /** leftwards double arrow, U+21D0 ISOtech */
    public final Entity S_lArr = newEntityKey("lArr", 8656);

    /**
     * left ceiling = apl upstile, U+2308 ISOamsc
     */
    public final Entity S_lceil = newEntityKey("lceil", 8968);

    /** less-than or equal to, U+2264 ISOtech */
    public final Entity S_le = newEntityKey("le", 8804);

    /**
     * left floor = apl downstile, U+230A ISOamsc
     */
    public final Entity S_lfloor = newEntityKey("lfloor", 8970);

    /** asterisk operator, U+2217 ISOtech */
    public final Entity S_lowast = newEntityKey("lowast", 8727);

    /** lozenge, U+25CA ISOpub */
    public final Entity S_loz = newEntityKey("loz", 9674);

    /**
     * sum is NOT the same character as U+03A3 'greek capital letter sigma'
     * though the same glyph might be used for both
     */
    /** minus sign, U+2212 ISOtech */
    public final Entity S_minus = newEntityKey("minus", 8722);

    /** greek small letter mu, U+03BC ISOgrk3 */
    public final Entity S_mu = newEntityKey("mu", 956);

    /** greek capital letter mu, U+039C */
    public final Entity S_Mu = newEntityKey("Mu", 924);

    /**
     * nabla = backward difference, U+2207 ISOtech
     */
    public final Entity S_nabla = newEntityKey("nabla", 8711);

    /** not equal to, U+2260 ISOtech */
    public final Entity S_ne = newEntityKey("ne", 8800);

    /** contains as member, U+220B ISOtech */
    public final Entity S_ni = newEntityKey("ni", 8715);

    /** not an element of, U+2209 ISOtech */
    public final Entity S_notin = newEntityKey("notin", 8713);

    /**
     * note that nsup, 'not a superset of, U+2283' is not covered by the Symbol
     * font encoding and is not included. Should it be, for symmetry? It is in
     * ISOamsn
     */
    /** not a subset of, U+2284 ISOamsn */
    public final Entity S_nsub = newEntityKey("nsub", 8836);

    /** greek small letter nu, U+03BD ISOgrk3 */
    public final Entity S_nu = newEntityKey("nu", 957);

    /** greek capital letter nu, U+039D */
    public final Entity S_Nu = newEntityKey("Nu", 925);

    /**
     * overline = spacing overscore, U+203E NEW
     */
    public final Entity S_oline = newEntityKey("oline", 8254);

    /**
     * greek small letter omega, U+03C9 ISOgrk3
     */
    public final Entity S_omega = newEntityKey("omega", 969);

    /**
     * greek capital letter omega, U+03A9 ISOgrk3
     */
    public final Entity S_Omega = newEntityKey("Omega", 937);

    /** greek small letter omicron, U+03BF NEW */
    public final Entity S_omicron = newEntityKey("omicron", 959);

    /** greek capital letter omicron, U+039F */
    public final Entity S_Omicron = newEntityKey("Omicron", 927);

    /**
     * circled plus = direct sum, U+2295 ISOamsb
     */
    public final Entity S_oplus = newEntityKey("oplus", 8853);

    /** logical or = vee, U+2228 ISOtech */
    public final Entity S_or = newEntityKey("or", 8744);

    /**
     * circled times = vector product, U+2297 ISOamsb
     */
    public final Entity S_otimes = newEntityKey("otimes", 8855);

    /** partial differential, U+2202 ISOtech */
    public final Entity S_part = newEntityKey("part", 8706);

    /**
     * up tack = orthogonal to = perpendicular, U+22A5 ISOtech
     */
    public final Entity S_perp = newEntityKey("perp", 8869);

    /** greek small letter phi, U+03C6 ISOgrk3 */
    public final Entity S_phi = newEntityKey("phi", 966);

    /**
     * greek capital letter phi, U+03A6 ISOgrk3
     */
    public final Entity S_Phi = newEntityKey("Phi", 934);

    /** greek small letter pi, U+03C0 ISOgrk3 */
    public final Entity S_pi = newEntityKey("pi", 960);

    /** greek capital letter pi, U+03A0 ISOgrk3 */
    public final Entity S_Pi = newEntityKey("Pi", 928);

    /** greek pi symbol, U+03D6 ISOgrk3 */
    public final Entity S_piv = newEntityKey("piv", 982);

    /** prime = minutes = feet, U+2032 ISOtech */
    public final Entity S_prime = newEntityKey("prime", 8242);

    /**
     * double prime = seconds = inches, U+2033 ISOtech
     */
    public final Entity S_Prime = newEntityKey("Prime", 8243);

    /**
     * n-ary product = product sign, U+220F ISOamsb
     */
    public final Entity S_prod = newEntityKey("prod", 8719);

    /** proportional to, U+221D ISOtech */
    public final Entity S_prop = newEntityKey("prop", 8733);

    /** greek small letter psi, U+03C8 ISOgrk3 */
    public final Entity S_psi = newEntityKey("psi", 968);

    /**
     * greek capital letter psi, U+03A8 ISOgrk3
     */
    public final Entity S_Psi = newEntityKey("Psi", 936);

    /**
     * square root = radical sign, U+221A ISOtech
     */
    public final Entity S_radic = newEntityKey("radic", 8730);

    /**
     * rang is NOT the same character as U+003E 'greater than' or U+203A 'single
     * right-pointing angle quotation mark'
     */
    /**
     * right-pointing angle bracket = ket, U+232A ISOtech
     */
    public final Entity S_rang = newEntityKey("rang", 9002);

    /** rightwards arrow, U+2192 ISOnum */
    public final Entity S_rarr = newEntityKey("rarr", 8594);

    /**
     * rightwards double arrow, U+21D2 ISOtech
     */
    public final Entity S_rArr = newEntityKey("rArr", 8658);

    /** right ceiling, U+2309 ISOamsc */
    public final Entity S_rceil = newEntityKey("rceil", 8969);

    /**
     * blackletter capital R = real part symbol, U+211C ISOamso
     */
    public final Entity S_real = newEntityKey("real", 8476);

    /** right floor, U+230B ISOamsc */
    public final Entity S_rfloor = newEntityKey("rfloor", 8971);

    /** greek small letter rho, U+03C1 ISOgrk3 */
    public final Entity S_rho = newEntityKey("rho", 961);

    /** greek capital letter rho, U+03A1 */
    public final Entity S_Rho = newEntityKey("Rho", 929);

    /** dot operator, U+22C5 ISOamsb */
    public final Entity S_sdot = newEntityKey("sdot", 8901);

    /**
     * greek small letter sigma, U+03C3 ISOgrk3
     */
    public final Entity S_sigma = newEntityKey("sigma", 963);

    /**
     * greek capital letter sigma, U+03A3 ISOgrk3
     */
    public final Entity S_Sigma = newEntityKey("Sigma", 931);

    /**
     * greek small letter final sigma, U+03C2 ISOgrk3
     */
    public final Entity S_sigmaf = newEntityKey("sigmaf", 962);

    /**
     * tilde operator = varies with = similar to, U+223C ISOtech
     */
    public final Entity S_sim = newEntityKey("sim", 8764);

    /** black spade suit, U+2660 ISOpub */
    public final Entity S_spades = newEntityKey("spades", 9824);

    /** subset of, U+2282 ISOtech */
    public final Entity S_sub = newEntityKey("sub", 8834);

    /** subset of or equal to, U+2286 ISOtech */
    public final Entity S_sube = newEntityKey("sube", 8838);

    /**
     * prod is NOT the same character as U+03A0 'greek capital letter pi' though
     * the same glyph might be used for both
     */
    /** n-ary sumation, U+2211 ISOamsb */
    public final Entity S_sum = newEntityKey("sum", 8721);

    /** superset of, U+2283 ISOtech */
    public final Entity S_sup = newEntityKey("sup", 8835);

    /**
     * superset of or equal to, U+2287 ISOtech
     */
    public final Entity S_supe = newEntityKey("supe", 8839);

    /** greek small letter tau, U+03C4 ISOgrk3 */
    public final Entity S_tau = newEntityKey("tau", 964);

    /** greek capital letter tau, U+03A4 */
    public final Entity S_Tau = newEntityKey("Tau", 932);

    /** therefore, U+2234 ISOtech */
    public final Entity S_there4 = newEntityKey("there4", 8756);

    /**
     * greek small letter theta, U+03B8 ISOgrk3
     */
    public final Entity S_theta = newEntityKey("theta", 952);

    /**
     * greek capital letter theta, U+0398 ISOgrk3
     */
    public final Entity S_Theta = newEntityKey("Theta", 920);

    /**
     * greek small letter theta symbol, U+03D1 NEW
     */
    public final Entity S_thetasym = newEntityKey("thetasym", 977);

    /** trade mark sign, U+2122 ISOnum */
    public final Entity S_trade = newEntityKey("trade", 8482);

    /** upwards arrow, U+2191 ISOnum */
    public final Entity S_uarr = newEntityKey("uarr", 8593);

    /**
     * ISO 10646 does not say that lArr is the same as the 'is implied by' arrow
     * but also does not have any other character for that function. So ? lArr
     * can be used for 'is implied by' as ISOtech suggests
     */
    /** upwards double arrow, U+21D1 ISOamsa */
    public final Entity S_uArr = newEntityKey("uArr", 8657);

    /**
     * greek upsilon with hook symbol, U+03D2 NEW
     */
    public final Entity S_upsih = newEntityKey("upsih", 978);

    /**
     * greek small letter upsilon, U+03C5 ISOgrk3
     */
    public final Entity S_upsilon = newEntityKey("upsilon", 965);

    /**
     * greek capital letter upsilon, U+03A5 ISOgrk3
     */
    public final Entity S_Upsilon = newEntityKey("Upsilon", 933);

    /**
     * script capital P = power set = Weierstrass p, U+2118 ISOamso
     */
    public final Entity S_weierp = newEntityKey("weierp", 8472);

    /** greek small letter xi, U+03BE ISOgrk3 */
    public final Entity S_xi = newEntityKey("xi", 958);

    /** greek capital letter xi, U+039E ISOgrk3 */
    public final Entity S_Xi = newEntityKey("Xi", 926);

    /** greek small letter zeta, U+03B6 ISOgrk3 */
    public final Entity S_zeta = newEntityKey("zeta", 950);

    /** greek capital letter zeta, U+0396 */
    public final Entity S_Zeta = newEntityKey("Zeta", 918);

    /**
     * @param factory
     */
    public XHTMLSymbolsEntities(EntityFactory factory) {
        super(factory);
    }
}

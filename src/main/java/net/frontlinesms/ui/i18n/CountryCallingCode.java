package net.frontlinesms.ui.i18n;

import net.frontlinesms.AppProperties;

/**
 * International area codes
 * This has been taken from http://countrycode.org/, using the following regexp
 * Find: .*(([A-Z]{2}) / [A-Z]*  ([0-9 ]*[0-9]+)).*
 * Replace: \2\(\"\3\"),
 * @author Morgan Belkadi <morgan@frontlinesms.com>
 */
public enum CountryCallingCode {
	AF("93"),
	AL("355"),
	DZ("213"),
	AS("1684"),
	AD("376"),
	AO("244"),
	AI("1264"),
	AQ("672"),
	AG("1268"),
	AR("54"),
	AM("374"),
	AW("297"),
	AU("61"),
	AT("43"),
	AZ("994"),
	BS("1242"),
	BH("973"),
	BD("880"),
	BB("1246"),
	BY("375"),
	BE("32"),
	BZ("501"),
	BJ("229"),
	BM("1441"),
	BT("975"),
	BO("591"),
	BA("387"),
	BW("267"),
	BR("55"),
	VG("1284"),
	BN("673"),
	BG("359"),
	BF("226"),
	MM("95"),
	BI("257"),
	KH("855"),
	CM("237"),
	CA("1"),
	CV("238"),
	KY("1345"),
	CF("236"),
	TD("235"),
	CL("56"),
	CN("86"),
	CX("61"),
	CC("61"),
	CO("57"),
	KM("269"),
	CK("682"),
	CR("506"),
	HR("385"),
	CU("53"),
	CY("357"),
	CZ("420"),
	CD("243"),
	DK("45"),
	DJ("253"),
	DM("1767"),
	DO("1809"),
	EC("593"),
	EG("20"),
	SV("503"),
	GQ("240"),
	ER("291"),
	EE("372"),
	ET("251"),
	FK("500"),
	FO("298"),
	FJ("679"),
	FI("358"),
	FR("33"),
	PF("689"),
	GA("241"),
	GM("220"),
	GE("995"),
	DE("49"),
	GH("233"),
	GI("350"),
	GR("30"),
	GL("299"),
	GD("1473"),
	GU("1671"),
	GT("502"),
	GN("224"),
	GW("245"),
	GY("592"),
	HT("509"),
	VA("39"),
	HN("504"),
	HK("852"),
	HU("36"),
	IS("354"),
	IN("91"),
	ID("62"),
	IR("98"),
	IQ("964"),
	IE("353"),
	IM("44"),
	IL("972"),
	IT("39"),
	CI("225"),
	JM("1876"),
	JP("81"),
	JE("44"),
	JO("962"),
	KZ("7"),
	KE("254"),
	KI("686"),
	KW("965"),
	KG("996"),
	LA("856"),
	LV("371"),
	LB("961"),
	LS("266"),
	LR("231"),
	LY("218"),
	LI("423"),
	LT("370"),
	LU("352"),
	MO("853"),
	MK("389"),
	MG("261"),
	MW("265"),
	MY("60"),
	MV("960"),
	ML("223"),
	MT("356"),
	MH("692"),
	MR("222"),
	MU("230"),
	YT("262"),
	MX("52"),
	FM("691"),
	MD("373"),
	MC("377"),
	MN("976"),
	ME("382"),
	MS("1664"),
	MA("212"),
	MZ("258"),
	NA("264"),
	NR("674"),
	NP("977"),
	NL("31"),
	AN("599"),
	NC("687"),
	NZ("64"),
	NI("505"),
	NE("227"),
	NG("234"),
	NU("683"),
	KP("850"),
	MP("1670"),
	NO("47"),
	OM("968"),
	PK("92"),
	PW("680"),
	PA("507"),
	PG("675"),
	PY("595"),
	PE("51"),
	PH("63"),
	PN("870"),
	PL("48"),
	PT("351"),
	PR("1"),
	QA("974"),
	CG("242"),
	RO("40"),
	RU("7"),
	RW("250"),
	BL("590"),
	SH("290"),
	KN("1869"),
	LC("1758"),
	MF("1599"),
	PM("508"),
	VC("1784"),
	WS("685"),
	SM("378"),
	ST("239"),
	SA("966"),
	SN("221"),
	RS("381"),
	SC("248"),
	SL("232"),
	SG("65"),
	SK("421"),
	SI("386"),
	SB("677"),
	SO("252"),
	ZA("27"),
	KR("82"),
	ES("34"),
	LK("94"),
	SD("249"),
	SR("597"),
	SZ("268"),
	SE("46"),
	CH("41"),
	SY("963"),
	TW("886"),
	TJ("992"),
	TZ("255"),
	TH("66"),
	TL("670"),
	TG("228"),
	TK("690"),
	TO("676"),
	TT("1868"),
	TN("216"),
	TR("90"),
	TM("993"),
	TC("1649"),
	TV("688"),
	UG("256"),
	UA("380"),
	AE("971"),
	GB("44"),
	US("1"),
	UY("598"),
	VI("1340"),
	UZ("998"),
	VU("678"),
	VE("58"),
	VN("84"),
	WF("681"),
	YE("967"),
	ZM("260"),
	ZW("263");
	
	private final String countryCode;

	CountryCallingCode (String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryCode() {
		return countryCode;
	}
	
	/**
	 * @param 2-letter country ISO country code
	 */
	static String getCountryCode(String country) {
		if (country == null || country.length()==0) {	
			return "";
		} else {
			CountryCallingCode code = valueOf(country.toUpperCase());
			return code == null ? "" : code.getCountryCode();
		}
	}
	
	/**
	 * Tries to format the given phone number into a valid international format.
	 * @param phoneNumber A non-formatted phone number
	 */
	public static String format(String phoneNumber, String countryCode) {
		// Remove the (0) sometimes present is certain numbers.
		// This 0 MUST NOT be present in the international formatted number
		String formattedNumber = phoneNumber.replace("(0)", "");
		
		// Remove every character which is not a digit
		formattedNumber = formattedNumber.replaceAll("\\D", "");
		
		if (phoneNumber.startsWith("+")) {
			// If the original number was prefixed by ++,
			// we put it back
			return "+" + formattedNumber;
		} else if (formattedNumber.startsWith("00")) {
			// If the number was prefixed by the (valid) 00(code) format,
			// we transform it to the + sign
			return "+" + formattedNumber.substring(2);
		} else if (formattedNumber.startsWith(getCountryCode(countryCode))) {
			// If the number was prefixed by the current country code,
			// we just put a + sign back in front of it.
			return "+" + formattedNumber;
		} else if (formattedNumber.startsWith("0")) {
			// Most internal numbers starts with one 0. We'll have to remove it
			// Before putting a + sign in front of it.
			formattedNumber = formattedNumber.substring(1);
		}
		
		// NB: even if a + sign had been specified, it's been removed by the replaceAll function
		// We have to put one back.
		// We also try to prefix the number with the current country code
		return "+" + getCountryCode(countryCode) + formattedNumber;
	}

	/**
	 * @param msisdn A phone number
	 * @return <code>true</code> if the number is in a proper international format, <code>false</code> otherwise.
	 */
	public static boolean isInInternationalFormat(String msisdn) {
		return msisdn.matches("\\+\\d+");
	}
}

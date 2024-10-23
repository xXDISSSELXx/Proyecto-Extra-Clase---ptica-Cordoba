package co.edu.opticacordoba.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.edu.opticacordoba.helpers.ObjectHelper;

public class TextHelper {

	public static final String EMPTY = "";

	private TextHelper() {
		
	}
	
	public static boolean isNull(final String string) {
		return ObjectHelper.isNull(string);
	}
	
	public static String getDefault(final String string, final String defaultObject) {
		return ObjectHelper.getDefault(string, defaultObject);
	}
	
	public static String getDefault(final String string) {
		return getDefault(string, EMPTY);
	}
	
	public static boolean isEmpty(final String string) {
		return EMPTY.equals(getDefault(string));
	}
	
	public static boolean isEmptyApplyingTrim(final String string) {
		return isEmpty(applyTrim(string));
	}
	
	public static String applyTrim(final String string) {
		return getDefault(string).trim();
	}
	
	public static boolean hasNumber(final String string) {
		Pattern pattern= Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(string);
		return matcher.find();
	}
	
	public static Integer amountLetters(final String string) {
		return string.length();
	}
	
	public static boolean inRangeAmmountOfLetters(final String string, final Integer number) {
		return amountLetters(string) <= number;
	}
}


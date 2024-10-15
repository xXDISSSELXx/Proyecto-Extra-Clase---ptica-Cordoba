package co.edu.uco.crosscutting.helpers;


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
}


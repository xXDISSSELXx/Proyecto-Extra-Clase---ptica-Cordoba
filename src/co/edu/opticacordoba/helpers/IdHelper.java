package co.edu.opticacordoba.helpers;

public class IdHelper {
	
	private static final String DEFAULT_ID = "1";
	
	public static final Integer convertToNumber(final String idAsString) {
		return TextHelper.applyTrim(idAsString).matches("\\d+") ?  Integer.parseInt(idAsString) : getDefault();
	}

	public static final Integer getDefault(final Integer value, final Integer defaultValue) {
		return ObjectHelper.getDefault(value, defaultValue);
	}
	
	public static final Integer getDefault() {
		return Integer.parseInt(DEFAULT_ID);
	}
	
	public static final String getDefaultAsSring() {
		return DEFAULT_ID;
	}
	
	public static final boolean isDefault(final Integer value) {
		return getDefault(value, getDefault()).equals(getDefault());
	}
	
	public static final boolean isDefault(final String idAsString) {
		return getDefault(convertToNumber(idAsString), getDefault()).equals(getDefault());
	}
}

package co.edu.opticacordoba.helpers;

public class ObjectHelper {
	String name = "Juan";

private ObjectHelper() {
		
	}
	
	public static <O> boolean isNull(O object) {
		return object == null;
	}
	
	public static <O> O getDefault(final O object, final O defaultObject) {
		return isNull(object) ? defaultObject : object;
	}
}

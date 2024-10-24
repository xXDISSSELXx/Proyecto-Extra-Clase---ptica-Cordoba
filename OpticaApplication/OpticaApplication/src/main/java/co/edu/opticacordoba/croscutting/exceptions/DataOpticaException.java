package co.edu.opticacordoba.croscutting.exceptions;

import co.edu.opticacrosscutting.exceptions.enums.Layer;

public class DataOpticaException extends OpticaException{

	private static final long serialVersionUID = 1L;

	public DataOpticaException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.DATA);
	}

	public static final DataOpticaException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new DataOpticaException(userMessage, technicalMessage, rootException);
	}

	public static final DataOpticaException crear(final String userMessage) {
		return new DataOpticaException(userMessage, userMessage, new Exception());
	}

	public static final DataOpticaException crear(final String userMessage, final String technicalMessage) {
		return new DataOpticaException(userMessage, technicalMessage, new Exception());
	}
}

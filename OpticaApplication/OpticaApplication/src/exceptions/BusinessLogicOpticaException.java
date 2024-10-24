package co.edu.opticacordoba.croscutting.exceptions;

import co.edu.opticacrosscutting.exceptions.enums.Layer;

public class BusinessLogicOpticaException extends OpticaException{

	private static final long serialVersionUID = 1L;

	public BusinessLogicOpticaException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.BUSINESSLOGIC);
	}

	public static final BusinessLogicOpticaException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new BusinessLogicOpticaException(userMessage, technicalMessage, rootException);
	}

	public static final BusinessLogicOpticaException crear(final String userMessage) {
		return new BusinessLogicOpticaException(userMessage, userMessage, new Exception());
	}

	public static final BusinessLogicOpticaException crear(final String userMessage, final String technicalMessage) {
		return new BusinessLogicOpticaException(userMessage, technicalMessage, new Exception());
	}
}

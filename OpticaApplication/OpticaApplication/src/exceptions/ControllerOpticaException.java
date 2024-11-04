package co.edu.opticacordoba.croscutting.exceptions;

import co.edu.opticacrosscutting.exceptions.enums.Layer;

public class ControllerOpticaException extends OpticaException{

	private static final long serialVersionUID = 1L;

	public ControllerOpticaException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.CONTROLLER);
	}

	public static final ControllerOpticaException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new ControllerOpticaException(userMessage, technicalMessage, rootException);
	}

	public static final ControllerOpticaException crear(final String userMessage) {
		return new ControllerOpticaException(userMessage, userMessage, new Exception());
	}

	public static final ControllerOpticaException crear(final String userMessage, final String technicalMessage) {
		return new ControllerOpticaException(userMessage, technicalMessage, new Exception());
	}

}

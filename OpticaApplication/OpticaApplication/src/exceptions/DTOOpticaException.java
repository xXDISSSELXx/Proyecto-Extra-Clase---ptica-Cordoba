package co.edu.opticacordoba.croscutting.exceptions;

import co.edu.opticacrosscutting.exceptions.enums.Layer;

public class DTOOpticaException extends OpticaException{

	private static final long serialVersionUID = 1L;

	public DTOOpticaException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.DTO);
	}

	public static final DTOOpticaException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new DTOOpticaException(userMessage, technicalMessage, rootException);
	}

	public static final DTOOpticaException crear(final String userMessage) {
		return new DTOOpticaException(userMessage, userMessage, new Exception());
	}

	public static final DTOOpticaException crear(final String userMessage, final String technicalMessage) {
		return new DTOOpticaException(userMessage, technicalMessage, new Exception());
	}
}

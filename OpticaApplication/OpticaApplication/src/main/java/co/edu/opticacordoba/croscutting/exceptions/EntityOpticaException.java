package co.edu.opticacordoba.croscutting.exceptions;

import co.edu.opticacrosscutting.exceptions.enums.Layer;

public class EntityOpticaException extends OpticaException{

	private static final long serialVersionUID = 1L;

	public EntityOpticaException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.ENTITY);
	}

	public static final EntityOpticaException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new EntityOpticaException(userMessage, technicalMessage, rootException);
	}

	public static final EntityOpticaException crear(final String userMessage) {
		return new EntityOpticaException(userMessage, userMessage, new Exception());
	}

	public static final EntityOpticaException crear(final String userMessage, final String technicalMessage) {
		return new EntityOpticaException(userMessage, technicalMessage, new Exception());
	}
}

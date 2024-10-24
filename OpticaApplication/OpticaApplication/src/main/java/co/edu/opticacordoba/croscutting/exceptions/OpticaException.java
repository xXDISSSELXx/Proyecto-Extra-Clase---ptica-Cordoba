package co.edu.opticacordoba.croscutting.exceptions;

import co.edu.opticacrosscutting.exceptions.enums.Layer;
import co.edu.opticacrosscutting.exceptions.OpticaApplicationException;

public class OpticaException extends OpticaApplicationException{

	private static final long serialVersionUID = 1L;

	public OpticaException(final String userMessage, final String technicalMessage, final Exception rootException,
			final Layer layer) {
		super(userMessage, technicalMessage, rootException, layer);
	}

	public static OpticaException crear(final String userMessage, final String technicalMessage,
			final Exception rootException, final Layer layer) {
		return new OpticaException(userMessage, technicalMessage, rootException, layer);
	}

	public static OpticaException crear(final String userMessage) {
		return new OpticaException(userMessage, userMessage, new Exception(), Layer.GENERAL);
	}

	public static OpticaException crear(final String userMessage, final String technicalMessage) {
		return new OpticaException(userMessage, technicalMessage, new Exception(), Layer.GENERAL);
	}
}

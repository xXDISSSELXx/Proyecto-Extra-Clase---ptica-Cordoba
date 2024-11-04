package co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl;

import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteNumeroDocumentoConsistencyIsValid;
import co.edu.opticacordoba.croscutting.exceptions.BusinessLogicOpticaException;
import co.edu.opticacrosscutting.helpers.NumericHelper;
import co.edu.opticacrosscutting.helpers.TextHelper;

public class ClienteNumeroDocumentoConsistencyIsValidImpl implements ClienteNumeroDocumentoConsistencyIsValid{

	@Override
	public void execute(String data) {
		validateNotNull(data);
		validateRange(data);
	}
	
	private void validateRange(final String number) {
		if(TextHelper.hasOnlyNumbers(number)) {
			if(!NumericHelper.isGreaterOrEqual(TextHelper.convertToNumber(number), 1000)) {
				var userMessage= "El número de documento del cliente debe ser 1000 o mayor para aplicar."; 
				BusinessLogicOpticaException.crear(userMessage);
			}
		}
	}
	
	private void validateNotNull(final String data) {
		if(TextHelper.isEmpty(data)) {
			var userMessage= "El número de documento del cliente no puede estar vacío...";
			
			throw BusinessLogicOpticaException.crear(userMessage);
		}
	}
}

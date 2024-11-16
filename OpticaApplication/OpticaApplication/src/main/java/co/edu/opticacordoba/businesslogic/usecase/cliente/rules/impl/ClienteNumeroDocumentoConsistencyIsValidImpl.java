package co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl;

import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteNumeroDocumentoConsistencyIsValid;
import co.edu.opticacordoba.croscutting.exceptions.BusinessLogicOpticaException;
import co.edu.opticacrosscutting.helpers.TextHelper;

public class ClienteNumeroDocumentoConsistencyIsValidImpl implements ClienteNumeroDocumentoConsistencyIsValid{

	@Override
	public void execute(String data) {
		validateNotNull(data);
		validateRange(data);
		validateNumber(data);
	}
	
	private void validateNumber(final String number) {
		if(!TextHelper.hasOnlyNumbers(number)) {
			var userMessage= "El número de documento del cliente debe tener únicamente números para aplicar."; 
			throw BusinessLogicOpticaException.crear(userMessage);
		}
	}
	
	private void validateRange(final String number) {
			if(!TextHelper.lenIsValid(number, 9, 10)) {
				var userMessage= "El número de documento del cliente debe tener entre 9 y 10 dígitos para aplicar."; 
				throw BusinessLogicOpticaException.crear(userMessage);
			}
	}
	
	private void validateNotNull(final String data) {
		if(TextHelper.isEmpty(data)) {
			var userMessage= "El número de documento del cliente no puede estar vacío...";
			
			throw BusinessLogicOpticaException.crear(userMessage);
		}
	}

	@Override
	public void executeUpdate(String data) {
		
	}
}

package co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl;

import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteCorreoConsistencyIsValid;
import co.edu.opticacordoba.croscutting.exceptions.BusinessLogicOpticaException;
import co.edu.opticacrosscutting.helpers.TextHelper;

public class ClienteCorreoConsistencyIsValidImpl implements ClienteCorreoConsistencyIsValid{

	@Override
	public void execute(String data) {
		validateLength(data);
		if(!TextHelper.isEmptyApplyingTrim(data)) {
			isCorreo(data);
		}
	}
	
	@Override
	public void executeUpdate(String data) {
		validateLength(data);
		if(!TextHelper.isEmptyApplyingTrim(data)) {
			isCorreo(data);
		}
	}

	
	private void validateLength(final String data) {
		if(!TextHelper.maxLenIsValid(TextHelper.applyTrim(data), 150)) {
			var userMessage= "El correo del cliente puede contener máximo 150 caracteres."; 
			BusinessLogicOpticaException.crear(userMessage);
		}
	}
	
	private void isCorreo(final String string) {
		 if(!TextHelper.applyTrim(string).matches(".*@.*[a-z]+.*..*")) {
			 var userMessage = "El correo del cliente no contiene un fórmato válido";
			 BusinessLogicOpticaException.crear(userMessage);
		 }
	}

	
}

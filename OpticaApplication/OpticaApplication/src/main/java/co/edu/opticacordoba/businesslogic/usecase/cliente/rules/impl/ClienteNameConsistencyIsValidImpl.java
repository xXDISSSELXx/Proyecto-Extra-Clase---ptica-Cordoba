package co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl;

import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteNameConsistencyIsValid;
import co.edu.opticacordoba.croscutting.exceptions.BusinessLogicOpticaException;
import co.edu.opticacrosscutting.helpers.TextHelper;

public class ClienteNameConsistencyIsValidImpl implements ClienteNameConsistencyIsValid{

	@Override
	public void execute(String data) {
		validateNotNull(data);
		validateLength(data);
		validateFormat(data);
		validateText(data);
	}

	@Override
	public void executeUpdate(String data) {
		validateLength(data);
		validateFormat(data);
	}
	
	private void validateLength(final String data) {
		if(!TextHelper.maxLenIsValid(data, 50)) {
			var userMessage= "El nombre del cliente puede contener máximo 50 caracteres."; 
			BusinessLogicOpticaException.crear(userMessage);
		}
	}
	
	private void validateFormat(final String data) {
		if(!TextHelper.containsLettersAndSpaces(data)) {
			var userMessage= "El nombre del cliente sólo puede contener letras."; 
			BusinessLogicOpticaException.crear(userMessage);
		}
	}
	
	private void validateNotNull(final String data) {
		if(TextHelper.isEmpty(data)) {
			var userMessage= "El nombre del cliente no puede estar vacío...";
			
			throw BusinessLogicOpticaException.crear(userMessage);
		}
	}
	
	private void validateText(final String data) {
		if(TextHelper.hasNumber(data)) {
			var userMessage= "El nombre del cliente no puede contener números...";
			
			throw BusinessLogicOpticaException.crear(userMessage);
		}
	}

	
}

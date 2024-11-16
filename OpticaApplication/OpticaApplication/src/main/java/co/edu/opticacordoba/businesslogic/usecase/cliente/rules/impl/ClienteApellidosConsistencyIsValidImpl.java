package co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl;

import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteApellidosConsistencyIsValid;
import co.edu.opticacordoba.croscutting.exceptions.BusinessLogicOpticaException;
import co.edu.opticacrosscutting.helpers.TextHelper;

public class ClienteApellidosConsistencyIsValidImpl implements ClienteApellidosConsistencyIsValid{

	@Override
	public void execute(String data) {
		validateLength(data);
		validateFormat(data);
		validateNotNull(data);
		validateText(data);
	}
	
	@Override
	public void executeUpdate(String data) {
		validateLength(data);
		validateFormat(data);
	}
	
	private void validateLength(final String data) {
		if(!TextHelper.maxLenIsValid(data, 50)) {
			var userMessage= "El apellido del cliente puede contener máximo 100 caracteres."; 
			BusinessLogicOpticaException.crear(userMessage);
		}
	}
	
	private void validateFormat(final String data) {
		if(!TextHelper.containsLettersAndSpaces(data)) {
			var userMessage= "El apellido del cliente sólo puede contener letras."; 
			BusinessLogicOpticaException.crear(userMessage);
		}
	}
	
	private void validateNotNull(final String data) {
		if(TextHelper.isEmpty(data)) {
			var userMessage= "El apellido del cliente no puede estar vacío...";
			
			throw BusinessLogicOpticaException.crear(userMessage);
		}
	}
	
	private void validateText(final String data) {
		if(TextHelper.hasNumber(data)) {
			var userMessage= "El apellido del cliente no puede contener números...";
			
			throw BusinessLogicOpticaException.crear(userMessage);
		}
	}
}

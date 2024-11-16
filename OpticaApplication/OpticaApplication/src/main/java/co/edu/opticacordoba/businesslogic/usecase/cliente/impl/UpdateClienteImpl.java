package co.edu.opticacordoba.businesslogic.usecase.cliente.impl;

import co.edu.opticacordoba.businesslogic.adapter.entity.ClienteEntityAdapter;
import co.edu.opticacordoba.businesslogic.usecase.cliente.UpdateCliente;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteApellidosConsistencyIsValid;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteCorreoConsistencyIsValid;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteExists;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteNameConsistencyIsValid;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteNumeroDocumentoDoesNotExistsForTipoDocumento;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteTelefonoConsistencyIsValid;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl.ClienteApellidosConsistencyIsValidImpl;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl.ClienteCorreoConsistencyIsValidImpl;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl.ClienteExistsImpl;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl.ClienteNameConsistencyIsValidImpl;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl.ClienteNumeroDocumentoDoesNotExistsForTipoDocumentoImpl;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl.ClienteTelefonoConsistencyIsValidImpl;
import co.edu.opticacordoba.croscutting.exceptions.BusinessLogicOpticaException;
import co.edu.opticacordoba.data.dao.DAOFactory;
import co.edu.opticacordoba.domain.ClienteDomain;
import co.edu.opticacrosscutting.helpers.ObjectHelper;
import co.edu.opticacrosscutting.helpers.TextHelper;

public class UpdateClienteImpl implements UpdateCliente{
	
	ClienteApellidosConsistencyIsValid apellidosConsistencyIsValid = new ClienteApellidosConsistencyIsValidImpl();
	ClienteCorreoConsistencyIsValid clienteCorreoConsistencyIsValid = new ClienteCorreoConsistencyIsValidImpl();
	ClienteNameConsistencyIsValid clienteNameConsistencyIsValid = new ClienteNameConsistencyIsValidImpl();
	ClienteNumeroDocumentoDoesNotExistsForTipoDocumento clienteNumeroDocumentoDoesNotExistsForTipoDocumento = new ClienteNumeroDocumentoDoesNotExistsForTipoDocumentoImpl();
	ClienteTelefonoConsistencyIsValid clienteTelefonoConsistencyIsValid = new ClienteTelefonoConsistencyIsValidImpl();
	ClienteExists clienteExists = new ClienteExistsImpl();
	
	private DAOFactory daoFactory;
	
	public UpdateClienteImpl(DAOFactory factory) {
		setDaoFactory(factory);
	}

	@Override
	public void execute(ClienteDomain data) {
		clienteExists.execute(data.getId(), daoFactory);
		apellidosConsistencyIsValid.executeUpdate(data.getApellidos());
		clienteCorreoConsistencyIsValid.executeUpdate(data.getCorreo());
		clienteNameConsistencyIsValid.executeUpdate(data.getNombre());
		clienteNumeroDocumentoDoesNotExistsForTipoDocumento.executeUpdate(data, daoFactory);
		clienteTelefonoConsistencyIsValid.executeUpdate(data.getTelefono());
		
		var clienteEntity = ClienteEntityAdapter.getClienteEntityAdapter().adaptTarget(data);
		daoFactory.getClienteDAO().update(clienteEntity);
	}
	
	private void setDaoFactory(final DAOFactory daoFactory) {
		if (ObjectHelper.isNull(daoFactory)) {
			var userMessage= "Se ha presentado un problema inesperado tratando de llevar a cabo la modificación de la información del cliente deseada. Por favor intente de nuevo y si el problema persiste, llame...";
			var technicalMessage = "El dao factory requerido para crear la clase que actualiza el cliente llegó nula...";
			
			throw BusinessLogicOpticaException.crear(userMessage, technicalMessage);
		}
		this.daoFactory = daoFactory;
	}


}

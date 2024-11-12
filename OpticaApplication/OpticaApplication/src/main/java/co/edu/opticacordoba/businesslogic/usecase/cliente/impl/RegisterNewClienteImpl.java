package co.edu.opticacordoba.businesslogic.usecase.cliente.impl;

import co.edu.opticacordoba.businesslogic.adapter.entity.ClienteEntityAdapter;
import co.edu.opticacordoba.businesslogic.usecase.cliente.RegisterNewCliente;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteApellidosConsistencyIsValid;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteCorreoConsistencyIsValid;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteNameConsistencyIsValid;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteNumeroDocumentoConsistencyIsValid;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteNumeroDocumentoDoesNotExistsForTipoDocumento;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.ClienteTelefonoConsistencyIsValid;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.TipoDocumentoExists;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl.ClienteApellidosConsistencyIsValidImpl;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl.ClienteCorreoConsistencyIsValidImpl;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl.ClienteNameConsistencyIsValidImpl;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl.ClienteNumeroDocumentoConsistencyIsValidImpl;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl.ClienteNumeroDocumentoDoesNotExistsForTipoDocumentoImpl;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl.ClienteTelefonoConsistencyIsValidImpl;
import co.edu.opticacordoba.businesslogic.usecase.cliente.rules.impl.TipoDocumentoExistsImpl;
import co.edu.opticacordoba.croscutting.exceptions.BusinessLogicOpticaException;
import co.edu.opticacordoba.data.dao.DAOFactory;
import co.edu.opticacordoba.domain.ClienteDomain;
import co.edu.opticacrosscutting.helpers.IdHelper;
import co.edu.opticacrosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.SqlConnectionHelper;

public class RegisterNewClienteImpl implements RegisterNewCliente{
	
	private DAOFactory daoFactory;
	private ClienteApellidosConsistencyIsValid apellidosConsistencyIsValid = new ClienteApellidosConsistencyIsValidImpl();
	private ClienteCorreoConsistencyIsValid clienteCorreoConsistencyIsValid = new ClienteCorreoConsistencyIsValidImpl();
	private ClienteNameConsistencyIsValid clienteNameConsistencyIsValid = new ClienteNameConsistencyIsValidImpl();
	private ClienteNumeroDocumentoConsistencyIsValid clienteNumeroDocumentoConsistencyIsValid = new ClienteNumeroDocumentoConsistencyIsValidImpl();
	private ClienteNumeroDocumentoDoesNotExistsForTipoDocumento clienteNumeroDocumentoDoesNotExistsForTipoDocumento = new ClienteNumeroDocumentoDoesNotExistsForTipoDocumentoImpl();
	private ClienteTelefonoConsistencyIsValid clienteTelefonoConsistencyIsValid = new ClienteTelefonoConsistencyIsValidImpl();
	private TipoDocumentoExists tipoDocumentoExists = new TipoDocumentoExistsImpl();
	
	
	public RegisterNewClienteImpl(final DAOFactory daoFactory) {
		setDaoFactory(daoFactory);
	}

	@Override
	public void execute(ClienteDomain data) {
		clienteNumeroDocumentoConsistencyIsValid.execute(data.getNumeroDocumento());
		apellidosConsistencyIsValid.execute(data.getApellidos());
		clienteCorreoConsistencyIsValid.execute(data.getCorreo());
		clienteNameConsistencyIsValid.execute(data.getNombre());
		tipoDocumentoExists.execute(data.getTipoDocumento().getId(), daoFactory);
		clienteNumeroDocumentoDoesNotExistsForTipoDocumento.execute(data, daoFactory);
		clienteTelefonoConsistencyIsValid.execute(data.getTelefono());
		var clienteDomainToCreate = ClienteDomain.create(IdHelper.getDefault(), data.getNumeroDocumento(), data.getTipoDocumento(), data.getNombre(), data.getApellidos(), data.getTelefono(), data.getCorreo());
		var clienteEntity = ClienteEntityAdapter.getClienteEntityAdapter().adaptTarget(clienteDomainToCreate);
		daoFactory.getClienteDAO().create(clienteEntity);
	}
	
	private void setDaoFactory(final DAOFactory daoFactory) {
		if (ObjectHelper.isNull(daoFactory)) {
			var userMessage= "Se ha presentado un problema inesperado tratando de llevar a cabo el registro de la información del cliente deseada. Por favor intente de nuevo y si el problema persiste, llame...";
			var technicalMessage = "El dao factory requerido para crear la clase que registra el cliente llegó nula...";
			
			throw BusinessLogicOpticaException.crear(userMessage, technicalMessage);
		}
		this.daoFactory = daoFactory;
	}
	

}

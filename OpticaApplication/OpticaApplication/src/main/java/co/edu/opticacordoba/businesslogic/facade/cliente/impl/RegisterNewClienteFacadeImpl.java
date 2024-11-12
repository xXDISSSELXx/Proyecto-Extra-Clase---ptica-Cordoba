package co.edu.opticacordoba.businesslogic.facade.cliente.impl;

import co.edu.opticacordoba.businesslogic.adapter.dto.ClienteDTOAdapter;
import co.edu.opticacordoba.businesslogic.facade.cliente.RegisterNewClienteFacade;
import co.edu.opticacordoba.businesslogic.usecase.cliente.impl.RegisterNewClienteImpl;
import co.edu.opticacordoba.croscutting.exceptions.BusinessLogicOpticaException;
import co.edu.opticacordoba.croscutting.exceptions.OpticaException;
import co.edu.opticacordoba.data.dao.DAOFactory;
import co.edu.opticacordoba.data.dao.enums.DAOSource;
import co.edu.opticacordoba.dto.ClienteDTO;

public class RegisterNewClienteFacadeImpl implements RegisterNewClienteFacade{

	@Override
	public void execute(ClienteDTO data) {
		var factory = DAOFactory.getFactory(DAOSource.POSTGRESQL);
		try {
			var factory2 = DAOFactory.getFactory(DAOSource.POSTGRESQL);
			factory.initTransaction();
			var registerNewClienteUseCase = new RegisterNewClienteImpl(factory2);
			var clienteDomain = ClienteDTOAdapter.getClienteDTOAdapter().adaptSource(data);
			
			registerNewClienteUseCase.execute(clienteDomain);
			factory.commitTransaction();
		}catch (final OpticaException exception) {
			factory.rollbackTransaction();
			throw exception;
		}catch (final Exception exception) {
			factory.rollbackTransaction();
			var userMessage ="Se ha presentado un problema tratando de registrar la información del nuevo cliente.";
			var technicalMessage ="Se ha presentado un problema inseperado registrando la información del nuevo cliente. Por favor revise el log de errores para tener más detalles...";
			throw BusinessLogicOpticaException.crear(userMessage, technicalMessage, exception);
		} finally {
			factory.closeConnection();
		}
		
	}

}

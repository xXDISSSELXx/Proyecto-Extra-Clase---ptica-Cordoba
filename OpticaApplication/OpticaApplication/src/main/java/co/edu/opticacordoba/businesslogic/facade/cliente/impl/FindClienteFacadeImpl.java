package co.edu.opticacordoba.businesslogic.facade.cliente.impl;

import java.util.List;

import co.edu.opticacordoba.businesslogic.adapter.dto.ClienteDTOAdapter;
import co.edu.opticacordoba.businesslogic.facade.cliente.FindClienteFacade;
import co.edu.opticacordoba.businesslogic.usecase.cliente.impl.FindClienteImpl;
import co.edu.opticacordoba.croscutting.exceptions.BusinessLogicOpticaException;
import co.edu.opticacordoba.croscutting.exceptions.OpticaException;
import co.edu.opticacordoba.data.dao.DAOFactory;
import co.edu.opticacordoba.data.dao.enums.DAOSource;
import co.edu.opticacordoba.dto.ClienteDTO;

public class FindClienteFacadeImpl implements FindClienteFacade{

	@Override
	public List<ClienteDTO> execute(ClienteDTO data) {
		var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);
		
		try {
			var findClienteUseCase = new FindClienteImpl(factory);
			var clienteDomain = ClienteDTOAdapter.getClienteDTOAdapter().adaptSource(data);
			
			return ClienteDTOAdapter.getClienteDTOAdapter().adaptTarget(findClienteUseCase.execute(clienteDomain));
		}catch (final OpticaException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage ="Se ha presentado un problema tratando de consultar la información de los clientes.";
			var technicalMessage ="Se ha presentado un problema inesperado consultando la información de los clientes. Por favor revise el log de errores para tener más detalles...";
			throw BusinessLogicOpticaException.crear(userMessage, technicalMessage, exception);
		} finally {
			factory.closeConnection();
		}
	}
}

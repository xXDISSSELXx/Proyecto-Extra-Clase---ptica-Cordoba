package co.edu.opticacordoba.businesslogic.facade.cliente.impl;


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
	public ClienteDTO execute(Integer data) {
		var factory = DAOFactory.getFactory(DAOSource.POSTGRESQL);
		
		try {
			var factory2 = DAOFactory.getFactory(DAOSource.POSTGRESQL);
			var findClienteUseCase = new FindClienteImpl(factory2);
			
			return ClienteDTOAdapter.getClienteDTOAdapter().adaptTarget(findClienteUseCase.execute(data));
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

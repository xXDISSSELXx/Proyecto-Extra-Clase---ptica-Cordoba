package co.edu.opticacordoba.businesslogic.facade.tipodocumento.impl;

import co.edu.opticacordoba.businesslogic.adapter.dto.TipoDocumentoDTOAdapter;
import co.edu.opticacordoba.businesslogic.facade.tipodocumento.RegisterNewTipoDocumentoFacade;
import co.edu.opticacordoba.businesslogic.usecase.tipodocumento.impl.RegisterNewTipoDocumentoImpl;
import co.edu.opticacordoba.croscutting.exceptions.BusinessLogicOpticaException;
import co.edu.opticacordoba.croscutting.exceptions.OpticaException;
import co.edu.opticacordoba.data.dao.DAOFactory;
import co.edu.opticacordoba.data.dao.enums.DAOSource;
import co.edu.opticacordoba.dto.TipoDocumentoDTO;

public class RegisterNewTipoDocumentoFacadeImpl implements RegisterNewTipoDocumentoFacade{

	@Override
	public void execute(TipoDocumentoDTO data) {
		var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);
		
		try {
			factory.initTransaction();
			var registerNewTipoDocumentoUseCase = new RegisterNewTipoDocumentoImpl(factory);
			var tipoDocumentoDomain = TipoDocumentoDTOAdapter.getTipoDocumentoDTOAdapter().adaptSource(data);
			
			registerNewTipoDocumentoUseCase.execute(tipoDocumentoDomain);
			
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

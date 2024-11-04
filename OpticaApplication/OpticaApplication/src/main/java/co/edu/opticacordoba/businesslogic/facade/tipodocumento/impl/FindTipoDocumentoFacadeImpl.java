package co.edu.opticacordoba.businesslogic.facade.tipodocumento.impl;

import java.util.List;

import co.edu.opticacordoba.businesslogic.adapter.dto.TipoDocumentoDTOAdapter;
import co.edu.opticacordoba.businesslogic.facade.tipodocumento.FindTipoDocumentoFacade;
import co.edu.opticacordoba.businesslogic.usecase.tipodocumento.impl.FindTipoDocumentoImpl;
import co.edu.opticacordoba.croscutting.exceptions.BusinessLogicOpticaException;
import co.edu.opticacordoba.croscutting.exceptions.OpticaException;
import co.edu.opticacordoba.data.dao.DAOFactory;
import co.edu.opticacordoba.data.dao.enums.DAOSource;
import co.edu.opticacordoba.dto.TipoDocumentoDTO;

public class FindTipoDocumentoFacadeImpl implements FindTipoDocumentoFacade{

	@Override
	public List<TipoDocumentoDTO> execute(TipoDocumentoDTO data) {
		var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);
		
		try {
			var findTipoDocumentoUseCase = new FindTipoDocumentoImpl(factory);
			var tipoDocumentoDomain = TipoDocumentoDTOAdapter.getTipoDocumentoDTOAdapter().adaptSource(data);
			
			return TipoDocumentoDTOAdapter.getTipoDocumentoDTOAdapter().adaptTarget(findTipoDocumentoUseCase.execute(tipoDocumentoDomain));
		}catch (final OpticaException exception) {
			throw exception;
		}catch (final Exception exception) {
			var userMessage ="Se ha presentado un problema tratando de consultar la información de los tipos de documento.";
			var technicalMessage ="Se ha presentado un problema inesperado consultando la información de los tipos de documento. Por favor revise el log de errores para tener más detalles...";
			throw BusinessLogicOpticaException.crear(userMessage, technicalMessage, exception);
		} finally {
			factory.closeConnection();
		}
	}
}

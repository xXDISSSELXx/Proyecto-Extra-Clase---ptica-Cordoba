package co.edu.opticacordoba.businesslogic.usecase.tipodocumento.impl;

import co.edu.opticacordoba.businesslogic.adapter.entity.TipoDocumentoEntityAdapter;
import co.edu.opticacordoba.businesslogic.usecase.tipodocumento.RegisterNewTipoDocumento;
import co.edu.opticacordoba.businesslogic.usecase.tipodocumento.rules.TipoDocumentoNameConsistencyIsValid;
import co.edu.opticacordoba.businesslogic.usecase.tipodocumento.rules.TipoDocumentoNameDoesNotExists;
import co.edu.opticacordoba.businesslogic.usecase.tipodocumento.rules.impl.TipoDocumentoNameConsistencyIsValidImpl;
import co.edu.opticacordoba.businesslogic.usecase.tipodocumento.rules.impl.TipoDocumentoNameDoesNotExistsImpl;
import co.edu.opticacordoba.croscutting.exceptions.BusinessLogicOpticaException;
import co.edu.opticacordoba.data.dao.DAOFactory;
import co.edu.opticacordoba.domain.TipoDocumentoDomain;
import co.edu.opticacrosscutting.helpers.IdHelper;
import co.edu.opticacrosscutting.helpers.ObjectHelper;

public class RegisterNewTipoDocumentoImpl implements RegisterNewTipoDocumento{

	TipoDocumentoNameConsistencyIsValid tipoDocumentoNameConsistencyIsValid = new TipoDocumentoNameConsistencyIsValidImpl();
	TipoDocumentoNameDoesNotExists tipoDocumentoNameDoesNotExistsImpl = new TipoDocumentoNameDoesNotExistsImpl();
	
	private DAOFactory daoFactory;
	
	public RegisterNewTipoDocumentoImpl(DAOFactory daoFactory) {
		setDaoFactory(daoFactory);
	}

	@Override
	public void execute(TipoDocumentoDomain data) {
		tipoDocumentoNameConsistencyIsValid.execute(data.getTipoDocumento());
		tipoDocumentoNameDoesNotExistsImpl.execute(data, null);
		
		var tipoDocumentoDomainToCreate = TipoDocumentoDomain.create(generateId(), data.getTipoDocumento());
		var tipoDocumentoEntity = TipoDocumentoEntityAdapter.getTipoDocumentoEntityAdapter().adaptTarget(tipoDocumentoDomainToCreate);
		
		daoFactory.getTipoDocumentoDAO().create(tipoDocumentoEntity);
	}
	
	private Integer generateId() {
		var id = IdHelper.generate();
		var tipoDocumentoEntity = daoFactory.getTipoDocumentoDAO().findByID(id);
		
		if(IdHelper.isEqual(tipoDocumentoEntity.getId(), id)) {
			id = generateId();
		}
		return id;
	}

	private void setDaoFactory(final DAOFactory daoFactory) {
		if (ObjectHelper.isNull(daoFactory)) {
			var userMessage= "Se ha presentado un problema inesperado tratando de llevar a cabo el registro de la información del tipo de documento deseada. Por favor intente de nuevo y si el problema persiste, llame...";
			var technicalMessage = "El dao factory requerido para crear la clase que registra el tipo de documento llegó nula...";
			
			throw BusinessLogicOpticaException.crear(userMessage, technicalMessage);
		}
		this.daoFactory = daoFactory;
	}
}

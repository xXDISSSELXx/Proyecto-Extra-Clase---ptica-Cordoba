package co.edu.opticacordoba.businesslogic.usecase.tipodocumento.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.opticacordoba.businesslogic.adapter.entity.TipoDocumentoEntityAdapter;
import co.edu.opticacordoba.businesslogic.usecase.tipodocumento.FindTipoDocumento;
import co.edu.opticacordoba.croscutting.exceptions.BusinessLogicOpticaException;
import co.edu.opticacordoba.data.dao.DAOFactory;
import co.edu.opticacordoba.domain.TipoDocumentoDomain;
import co.edu.opticacordoba.entity.TipoDocumentoEntity;
import co.edu.opticacrosscutting.helpers.ObjectHelper;

public class FindTipoDocumentoImpl implements FindTipoDocumento{

	private DAOFactory factory;
	
	public FindTipoDocumentoImpl(DAOFactory factory) {
		setDaoFactory(factory);
	}

	@Override
	public List<TipoDocumentoDomain> execute(TipoDocumentoDomain data) {
		var tipoDocumentoDomainToMap = TipoDocumentoDomain.create(data.getId(), data.getTipoDocumento());
		var tipoDocumentoEntity = TipoDocumentoEntityAdapter.getTipoDocumentoEntityAdapter().adaptTarget(tipoDocumentoDomainToMap);
		var tipoDocumentoEntityList = factory.getTipoDocumentoDAO().findByFilter(tipoDocumentoEntity);
		var tipoDocumentoDomain = new ArrayList<TipoDocumentoDomain>();
		for(TipoDocumentoEntity entity : tipoDocumentoEntityList) {
			tipoDocumentoDomain.add(TipoDocumentoEntityAdapter.getTipoDocumentoEntityAdapter().adaptSource(entity));
		}
		return  tipoDocumentoDomain;
	}

	private void setDaoFactory(final DAOFactory factory) {
		if (ObjectHelper.isNull(factory)) {
			var userMessage= "Se ha presentado un problema inesperado tratando de llevar a cabo la consulta de la información de los tipos de documento deseada. Por favor intente de nuevo y si el problema persiste, llame...";
			var technicalMessage = "El dao factory requerido para consultar la clase que consulta los tipos de documento llegó nula...";
			
			throw BusinessLogicOpticaException.crear(userMessage, technicalMessage);
		}
		this.factory = factory;
	}
}

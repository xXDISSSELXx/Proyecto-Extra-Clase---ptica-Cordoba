package co.edu.opticacordoba.businesslogic.adapter.entity;

import co.edu.opticacordoba.businesslogic.adapter.Adapter;
import co.edu.opticacordoba.domain.TipoDocumentoDomain;
import co.edu.opticacordoba.entity.TipoDocumentoEntity;
import co.edu.opticacrosscutting.helpers.IdHelper;
import co.edu.opticacrosscutting.helpers.ObjectHelper;
import co.edu.opticacrosscutting.helpers.TextHelper;

public class TipoDocumentoEntityAdapter implements Adapter<TipoDocumentoDomain, TipoDocumentoEntity>{

	private static final Adapter<TipoDocumentoDomain, TipoDocumentoEntity> instance = new TipoDocumentoEntityAdapter();
	
	private TipoDocumentoEntityAdapter() {
		
	}
	
	public static Adapter<TipoDocumentoDomain, TipoDocumentoEntity>  getTipoDocumentoEntityAdapter() {
		return instance;
	}
	
	@Override
	public TipoDocumentoDomain adaptSource(TipoDocumentoEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new TipoDocumentoEntity());
		return TipoDocumentoDomain.create(entityToAdapt.getId(), entityToAdapt.getTipoDocumento());
	}

	@Override
	public TipoDocumentoEntity adaptTarget(TipoDocumentoDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, TipoDocumentoDomain.create(IdHelper.getDefault(), TextHelper.EMPTY));
		var entityAdapted = new TipoDocumentoEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setTipoDocumento(domainToAdapt.getTipoDocumento());
		return entityAdapted;
	}
}

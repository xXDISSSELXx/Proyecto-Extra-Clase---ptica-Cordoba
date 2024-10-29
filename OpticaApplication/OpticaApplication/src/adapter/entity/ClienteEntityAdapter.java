package co.edu.opticacordoba.businesslogic.adapter.entity;

import co.edu.opticacordoba.businesslogic.adapter.Adapter;
import co.edu.opticacordoba.domain.ClienteDomain;
import co.edu.opticacordoba.domain.TipoDocumentoDomain;
import co.edu.opticacordoba.entity.ClienteEntity;
import co.edu.opticacrosscutting.helpers.IdHelper;
import co.edu.opticacrosscutting.helpers.NumericHelper;
import co.edu.opticacrosscutting.helpers.ObjectHelper;
import co.edu.opticacrosscutting.helpers.TextHelper;

public class ClienteEntityAdapter implements Adapter<ClienteDomain, ClienteEntity>{
	
	private static final Adapter<ClienteDomain, ClienteEntity> instance = new ClienteEntityAdapter();
	
	private ClienteEntityAdapter() {
		
	}
	
	public static Adapter<ClienteDomain, ClienteEntity>  getClienteEntityAdapter() {
		return instance;
	}

	@Override
	public ClienteDomain adaptSource(ClienteEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new ClienteEntity());
		return ClienteDomain.create(entityToAdapt.getId(), entityToAdapt.getNumeroDocumento(), TipoDocumentoEntityAdapter.getTipoDocumentoEntityAdapter().adaptSource(entityToAdapt.getTipoDocumento()), entityToAdapt.getNombre(), entityToAdapt.getApellidos(), entityToAdapt.getTelefono(), entityToAdapt.getCorreo());
	}

	@Override
	public ClienteEntity adaptTarget(ClienteDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, ClienteDomain.create(IdHelper.getDefault(), NumericHelper.ZERO, TipoDocumentoDomain.create(IdHelper.getDefault(), TextHelper.EMPTY), TextHelper.EMPTY, TextHelper.EMPTY, NumericHelper.ZERO, TextHelper.EMPTY));
		var entityAdapted = new ClienteEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setNumeroDocumento(domainToAdapt.getNumeroDocumento());
		entityAdapted.setTipoDocumento(TipoDocumentoEntityAdapter.getTipoDocumentoEntityAdapter().adaptTarget(domainToAdapt.getTipoDocumento()));
		entityAdapted.setNombre(domainToAdapt.getNombre());
		entityAdapted.setApellidos(domainToAdapt.getApellidos());
		entityAdapted.setTelefono(domainToAdapt.getTelefono());
		entityAdapted.setCorreo(domainToAdapt.getCorreo());
		return entityAdapted;
	}

}

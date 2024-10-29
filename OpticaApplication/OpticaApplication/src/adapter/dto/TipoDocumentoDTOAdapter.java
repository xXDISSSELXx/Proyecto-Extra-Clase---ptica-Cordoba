package co.edu.opticacordoba.businesslogic.adapter.dto;

import co.edu.opticacordoba.businesslogic.adapter.Adapter;
import co.edu.opticacordoba.domain.TipoDocumentoDomain;
import co.edu.opticacordoba.dto.TipoDocumentoDTO;
import co.edu.opticacrosscutting.helpers.IdHelper;
import co.edu.opticacrosscutting.helpers.ObjectHelper;
import co.edu.opticacrosscutting.helpers.TextHelper;

public class TipoDocumentoDTOAdapter implements Adapter<TipoDocumentoDomain, TipoDocumentoDTO>{

	private static final Adapter<TipoDocumentoDomain, TipoDocumentoDTO> instance = new TipoDocumentoDTOAdapter();
	
	private TipoDocumentoDTOAdapter() {
		
	}
	
	public static Adapter<TipoDocumentoDomain, TipoDocumentoDTO>  getTipoDocumentoDTOAdapter() {
		return instance;
	}
	
	@Override
	public TipoDocumentoDomain adaptSource(TipoDocumentoDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, TipoDocumentoDTO.create());
		return TipoDocumentoDomain.create(IdHelper.convertToNumber(dtoToAdapt.getId()), dtoToAdapt.getTipoDocumento());
	}

	@Override
	public TipoDocumentoDTO adaptTarget(TipoDocumentoDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, TipoDocumentoDomain.create(IdHelper.getDefault(), TextHelper.EMPTY));
		return TipoDocumentoDTO.create().setId("").setTipoDocumento(domainToAdapt.getTipoDocumento());
	}

}
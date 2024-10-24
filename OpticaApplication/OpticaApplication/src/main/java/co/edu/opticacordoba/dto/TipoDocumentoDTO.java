package co.edu.opticacordoba.dto;

import co.edu.opticacrosscutting.helpers.IdHelper;
import co.edu.opticacrosscutting.helpers.TextHelper;

public class TipoDocumentoDTO extends DomainDTO{

	private String tipoDocumento;
	
	public TipoDocumentoDTO() {
		super(IdHelper.getDefaultAsString());
		// TODO Auto-generated constructor stub
	}

	public static final TipoDocumentoDTO create() {
		return new TipoDocumentoDTO();
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	public TipoDocumentoDTO setTipoDocumento(final String tipoDocumento) {
		this.tipoDocumento = TextHelper.applyTrim(tipoDocumento);
		return this;
	}
	
	@Override
	public String getId() {
		return super.getId();
	}
	
	public TipoDocumentoDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}

}

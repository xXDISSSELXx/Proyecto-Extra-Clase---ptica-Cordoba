package co.edu.opticacordoba.domain;

import java.util.UUID;

import co.edu.opticacrosscutting.helpers.TextHelper;

public class TipoDocumentoDomain extends Domain{
	
	private String tipoDocumento;

	protected TipoDocumentoDomain(int id, final String tipoDocumento) {
		super(id);
		setTipoDocumento(tipoDocumento);
	}
	
	public static final TipoDocumentoDomain create(int id, final String tipoDocumento) {
		return new TipoDocumentoDomain(id, tipoDocumento);
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	private void setTipoDocumento(final String tipoDocumento) {
		this.tipoDocumento = TextHelper.applyTrim(tipoDocumento);
	}
	
	@Override
	public int getId() {
		return super.getId();
	}
	
}

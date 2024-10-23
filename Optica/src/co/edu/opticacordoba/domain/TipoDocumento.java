package co.edu.opticacordoba.domain;

import co.edu.opticacrosscutting.helpers.TextHelper;

public class TipoDocumento extends Domain{
	
	private String tipoDocumento;

	protected TipoDocumento(int id, final String tipoDocumento) {
		super(id);
		setTipoDocumento(tipoDocumento);
	}
	
	public TipoDocumento create(int id, final String tipoDocumento) {
		return new TipoDocumento(id, tipoDocumento);
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	private void setTipoDocumento(final String tipoDocumento) {
		this.tipoDocumento = TextHelper.applyTrim(tipoDocumento);
	}
	
}

package co.edu.opticacordoba.entity;

import co.edu.opticacrosscutting.helpers.IdHelper;
import co.edu.opticacrosscutting.helpers.TextHelper;

public class TipoDocumentoEntity extends DomainEntity {
	
	private String tipoDocumento;

	public TipoDocumentoEntity() {
		super(IdHelper.getDefault());
		setTipoDocumento(TextHelper.EMPTY);
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	public void setTipoDocumento(final String tipoDocumento) {
		this.tipoDocumento = TextHelper.applyTrim(tipoDocumento);
	}
	
	@Override
	public void setId(final int id) {
		super.setId(id);
	}
	
	@Override
	public int getId() {
		return super.getId();
	}
}

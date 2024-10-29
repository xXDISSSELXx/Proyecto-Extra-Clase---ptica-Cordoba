package co.edu.opticacordoba.dto;

import co.edu.opticacrosscutting.helpers.TextHelper;
import co.edu.opticacrosscutting.helpers.IdHelper;

public class DomainDTO {

	private String id;
	
	protected DomainDTO(final String id) {
		setIdentifier(id);
	}

	protected String getId() {
		return id;
	}

	protected void setIdentifier(final String id) {
		this.id = TextHelper.getDefault(id, IdHelper.getDefaultAsString());  
	}
	
	
}

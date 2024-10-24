package co.edu.opticacordoba.domain;

import co.edu.opticacrosscutting.helpers.IdHelper;
public class Domain {
	
private int id;
	
	protected Domain(final int id) {
		setId(id);
	}

	protected int getId() {
		return id;
	}

	protected void setId(final int id) {
		this.id = IdHelper.getDefault(id, IdHelper.getDefault());  
	}
}

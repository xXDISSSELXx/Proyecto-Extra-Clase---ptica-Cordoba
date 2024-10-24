package co.edu.opticacordoba.entity;


import co.edu.opticacrosscutting.helpers.IdHelper;

public class DomainEntity {

	private int id;
	
	protected DomainEntity(final int id) {
		setId(id);
	}

	protected int getId() {
		return id;
	}

	protected void setId(final int id) {
		this.id = IdHelper.getDefault(id, IdHelper.getDefault());  
	}
	
}

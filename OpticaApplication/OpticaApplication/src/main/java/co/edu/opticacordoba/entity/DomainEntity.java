package co.edu.opticacordoba.entity;


import co.edu.opticacrosscutting.helpers.IdHelper;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

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

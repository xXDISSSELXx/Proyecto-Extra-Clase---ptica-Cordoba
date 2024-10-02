package co.edu.uco.ucobet.dto;

import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class CountryDTO extends DomainDTO{

	private String name;
	
	public CountryDTO() {
		super(UUIDHelper.getDefaultAsString());
		setName(TextHelper.EMPTY);
	}
	
	public static final CountryDTO create() {   //CountryDTO country = CountryDTO.create().setName("...").setId("...")
		return new CountryDTO();                //Allows to create a new country and set its name and Id in one line!!!
	}

	public String getName() {
		return name;
	}
	
	public CountryDTO setName(final String name) {
		this.name = TextHelper.applyTrim(name);
		return this;
	}
	
	public CountryDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}

	@Override
	public String getId() {
		return super.getId();
	}
	
}

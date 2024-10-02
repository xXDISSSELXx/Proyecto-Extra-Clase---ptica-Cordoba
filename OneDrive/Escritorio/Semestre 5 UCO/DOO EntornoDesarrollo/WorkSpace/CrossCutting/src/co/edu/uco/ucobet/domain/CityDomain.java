package co.edu.uco.ucobet.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class CityDomain extends Domain{

	private String name;
	private CountryDomain country;
	
	private CityDomain(final UUID id, final String name, final CountryDomain country) {
		super(id);
		setName(name);
		setCountry(country);
	}
	
	public static final CityDomain create(final UUID id, final String name, final CountryDomain country) {
		return new CityDomain(id, name, country);
	}
	
	public static final CityDomain create() {
		return new CityDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, CountryDomain.create());
	}
	
	public String getName() {
		return name;
	}
	
	private void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}
	
	@Override
	public UUID getId() {
		return super.getId();
	}

	public CountryDomain getCountry() {
		return country;
	}

	private void setCountry(final CountryDomain country) {
		this.country = ObjectHelper.getDefault(country, CountryDomain.create(getId(), name));
	}
	
	
}

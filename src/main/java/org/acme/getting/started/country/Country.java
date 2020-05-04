package org.acme.getting.started.country;

import java.util.List;

import javax.json.bind.annotation.JsonbCreator;

public class Country {

	public final String name;
	public final String capital;


	@JsonbCreator
	public Country(String name, String capital) {
		this.name = name;
		this.capital = capital;
	}

	@Override
	public String toString() {
		return "Country{" +
				"name='" + name + '\'' +
				", capital='" + capital + '\'' +
				'}';
	}

	public static class CountryBuilder {
		private String name;
		private String capital;

		public CountryBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public CountryBuilder setCapital(String capital) {
			this.capital = capital;
			return this;
		}

		public Country createCountry() {
			return new Country(name, capital);
		}
	}
}

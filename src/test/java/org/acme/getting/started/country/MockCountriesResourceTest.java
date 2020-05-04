package org.acme.getting.started.country;

import java.util.Collections;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

@QuarkusTest
class MockCountriesResourceTest {

	@InjectMock
	@RestClient
	CountriesService countriesService;

	@BeforeEach
	void setUp() {
		Mockito.when(countriesService.getByName("greece")).thenReturn(Collections
				.singleton(new Country.CountryBuilder().setName("Greece").createCountry()));
	}

	/**
	 * 'GR' has been mocked so we expect to get back exactly what was mocked
	 */
	@Test
	void testGreece() {
		given()
				.when().get("/country/name/greece")
				.then()
				.statusCode(200)
				.body("$.size()", is(1),
						"[0].name", is("Greece"),
						"[0].capital", nullValue());
	}

	/**
	 * 'FR' hasn't been mocked so Mockito gives up back the default response
	 */
	@Test
	void testFrance() {
		given()
				.when().get("/country/name/france")
				.then()
				.statusCode(200)
				.body("$.size()", is(0));
	}
}

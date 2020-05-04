package org.acme.getting.started.country;

import javax.inject.Inject;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
//@QuarkusTestResource(WiremockCountries.class)
class RegularCountriesServiceTest {

	@Inject
	@RestClient
	CountriesService countriesService;

	@Test
	void testGR() {
		assertThat(countriesService.getByName("GR")).hasSize(10).extracting("name").contains("Greece");
//		assertThat(countriesService.getByName("GR")).hasSize(1).extracting("name").contains("Ελλάδα");
	}
}

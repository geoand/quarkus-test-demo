package org.acme.getting.started.country;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class RegularCountriesResourceTest {

	@Test
	void testGreece() {
		given()
				.when().get("/country/name/greece")
				.then()
				.statusCode(200)
				.body("$.size()", is(1),
						"[0].name", is("Greece"),
						"[0].capital", is("Athens"));
	}
}

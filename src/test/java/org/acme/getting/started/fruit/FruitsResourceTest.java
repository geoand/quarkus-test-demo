package org.acme.getting.started.fruit;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(TestDatabase.class)
class FruitsResourceTest {

	@Test
	void testListAll() {
		given()
				.when().get("/fruit")
				.then()
				.statusCode(200)
				.body("$.size()", is(3),
						"[0].name", is("Cherry"));
	}
}

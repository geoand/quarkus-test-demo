package org.acme.getting.started.fruit;

import java.util.Collections;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

@QuarkusTest
class MockFruitResourceTests {

	@Test
	void testListAll() {
		PanacheMock.mock(Fruit.class);
		when(Fruit.listAll()).thenReturn(Collections.singletonList(createFruit("Banana")));

		given()
				.when().get("/fruit")
				.then()
				.statusCode(200)
				.body("$.size()", is(1),
						"[0].name", is("Banana"));
	}

	private Fruit createFruit(String name) {
		Fruit result = new Fruit();
		result.name = name;
		return result;
	}

}

package org.acme.getting.started.fruit;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/fruit")
public class FruitResource {

	@GET
	@Produces("application/json")
	public List<Fruit> fruits() {
		return Fruit.listAll();
	}
}

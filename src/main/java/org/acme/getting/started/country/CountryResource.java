package org.acme.getting.started.country;

import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/country")
public class CountryResource {

	@Inject
	@RestClient
	CountriesService countriesService;


	@GET
	@Path("/name/{name}")
	@Produces("application/json")
	public Set<Country> getByName(@PathParam("name") String name) {
		return countriesService.getByName(name);
	}
}

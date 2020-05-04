package org.acme.getting.started.country;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/v2")
@RegisterRestClient
@ApplicationScoped
public interface CountriesService {

    @GET
    @Path("/name/{name}")
    @Produces("application/json")
	Set<Country> getByName(@PathParam("name") String name);
}

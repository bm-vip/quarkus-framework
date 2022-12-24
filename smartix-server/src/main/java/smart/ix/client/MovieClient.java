package smart.ix.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import smart.ix.client.dto.MovieDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "movie-client")
@Produces(MediaType.APPLICATION_JSON)
public interface MovieClient {
    @GET
    @Path("/auto-complete")
    MovieDto search(
            @QueryParam("q") String query,
            @HeaderParam("X-RapidAPI-Key") String apiKey,
            @HeaderParam("X-RapidAPI-Host") String host);
}

package smart.ix.rest;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import smart.ix.client.MovieClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("/api/v1/movie")
public class MovieResource {

    @RestClient
    MovieClient movieClient;
    @ConfigProperty(name = "imdb.api.host")
    String apiHost;
    @ConfigProperty(name = "imdb.api.key")
    String apiKey;

    @GET
    public Response currentWeather(@QueryParam("q") String query) {
        return Response.ok(movieClient.search(query,apiKey,apiHost)).build();
    }
}

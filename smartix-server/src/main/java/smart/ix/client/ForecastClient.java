package smart.ix.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import smart.ix.model.InlineResponse200;
import smart.ix.model.InlineResponse2001;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "forecast-client")
public interface ForecastClient {
    @GET
    @Path("/current.json")
    InlineResponse200 currentWeather(@QueryParam("key") String apiKey, @QueryParam("q") String query);

    @GET
    @Path("/forecast.json")
    InlineResponse2001 forecastWeather(@QueryParam("key") String apiKey, @QueryParam("q") String query, @QueryParam("days") int days);
}

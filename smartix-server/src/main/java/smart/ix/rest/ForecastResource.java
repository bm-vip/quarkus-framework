package smart.ix.rest;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import smart.ix.client.ForecastClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("/api/v1/forecast")
public class ForecastResource {

    @RestClient
    ForecastClient forecastClient;
    @ConfigProperty(name = "weather.api.key")
    String weatherApiKey;

    @GET
    @Path("/current")
    public Response currentWeather(@QueryParam("q") String query) {
        return Response.ok(forecastClient.currentWeather(weatherApiKey,query)).build();
    }

    @GET
    @Path("/forecast")
    public Response forecastClient(@QueryParam("q") String q, @QueryParam("days") Integer days) {
        return Response.ok(forecastClient.forecastWeather(weatherApiKey, q, days)).build();
    }
}

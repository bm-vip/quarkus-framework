package smart.ix.rest;

import io.quarkus.grpc.GrpcClient;
import smart.ix.*;
import smart.ix.client.dto.MovieDto;
import smart.ix.client.dto.WeatherDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Produces(MediaType.APPLICATION_JSON)
@Path("/api/v1/smart-feature")
public class SmartFeatureResource {

    @GrpcClient("smartFeature")
    SmartFeatureGrpc.SmartFeatureBlockingStub blockingSmartFeature;

    @GET
    @Path("/forecast")
    public Response forecastWeather(@QueryParam("q") String q, @QueryParam("days") Integer days) {
        List<WeatherResponse> list = blockingSmartFeature.forecastWeather(WeatherRequest.newBuilder().setQuery(q).setDays(days).build()).getWeathersList();
        return Response.ok(list.stream().map(WeatherDto::new).collect(Collectors.toList())).build();
    }

    @GET
    @Path("/movies")
    public Response searchMovies(@QueryParam("q") String q) {
        List<MovieResponse> list = blockingSmartFeature.searchMovies(MovieRequest.newBuilder().setQuery(q).build()).getMoviesList();
        return Response.ok(list.stream().map(MovieDto::new).collect(Collectors.toList())).build();
    }
}

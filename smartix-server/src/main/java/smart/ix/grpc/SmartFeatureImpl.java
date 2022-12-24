package smart.ix.grpc;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import smart.ix.*;
import smart.ix.client.ForecastClient;
import smart.ix.client.MovieClient;
import smart.ix.mapper.MovieMapper;
import smart.ix.mapper.WeatherMapper;
import smart.ix.client.dto.InlineResponse2001;
import smart.ix.client.dto.MovieDto;

import javax.inject.Inject;

@GrpcService
@RequiredArgsConstructor
@Slf4j
public class SmartFeatureImpl implements SmartFeature {
    @RestClient
    ForecastClient forecastClient;
    @RestClient
    MovieClient movieClient;
    @ConfigProperty(name = "weather.api.key")
    String weatherApiKey;
    @ConfigProperty(name = "imdb.api.key")
    String imdbApiKey;
    @ConfigProperty(name = "imdb.api.host")
    String imdbApiHost;
    @Inject
    MovieMapper movieMapper;
    @Inject
    WeatherMapper weatherMapper;
    
    @Override
    @SneakyThrows
    public Uni<MoviesResponse> searchMovies(MovieRequest request) {
        MovieDto movieDto = movieClient.search(imdbApiKey,imdbApiHost,request.getQuery());
        return Uni.createFrom().item(movieMapper.toResponse(movieDto));
    }

    @Override
    public Uni<WeathersResponse> forecastWeather(WeatherRequest request) {
        InlineResponse2001 response2001 = forecastClient.forecastWeather(weatherApiKey, request.getQuery(), request.getDays());
        return Uni.createFrom().item(weatherMapper.toResponse(response2001));
    }
}

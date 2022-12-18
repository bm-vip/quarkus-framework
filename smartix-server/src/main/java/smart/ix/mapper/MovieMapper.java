package smart.ix.mapper;

import org.mapstruct.Mapper;
import smart.ix.MovieResponse;
import smart.ix.MoviesResponse;
import smart.ix.model.D;
import smart.ix.model.MovieModel;

import java.util.Collections;
import java.util.stream.Collectors;

import static smart.ix.util.MapperHelper.getOrDefault;

@Mapper(componentModel = "cdi")
public interface MovieMapper {

    default MovieResponse toResponse(final D model) {
        if (model == null)
            return MovieResponse.newBuilder().build();
        return MovieResponse.newBuilder()
                .setActors(getOrDefault(() -> model.getS(), ""))
                .setUrl(getOrDefault(() -> model.getI().getImageUrl(), ""))
                .setName(getOrDefault(() -> model.getL(), ""))
                .setYear(getOrDefault(() -> model.getY(), 0))
                .setRank(getOrDefault(() -> model.getRank(), 0))
                .build();
    }
    default MoviesResponse toResponse(final MovieModel model) {
        if (model == null)
            return MoviesResponse.newBuilder().build();
        return MoviesResponse.newBuilder()
                .addAllMovies(getOrDefault(() -> model.getD().stream().map(this::toResponse).collect(Collectors.toList()), Collections.EMPTY_LIST))
                .build();
    }
}
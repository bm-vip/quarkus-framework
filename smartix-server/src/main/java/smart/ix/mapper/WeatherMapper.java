package smart.ix.mapper;

import org.mapstruct.Mapper;
import smart.ix.WeatherResponse;
import smart.ix.WeathersResponse;
import smart.ix.client.dto.ForecastForecastday;
import smart.ix.client.dto.InlineResponse2001;

import java.util.Collections;
import java.util.stream.Collectors;

import static smart.ix.util.MapperHelper.getOrDefault;

@Mapper(componentModel = "cdi")
public interface WeatherMapper {

    default WeatherResponse toResponse(final ForecastForecastday model) {
        if (model == null)
            return WeatherResponse.newBuilder().build();
        return WeatherResponse.newBuilder()
                .setAvgTempC(getOrDefault(() -> model.getDay().getAvgtempC().doubleValue(), 0D))
                .setDate(getOrDefault(() -> model.getDate().toString(), ""))
                .setCondition(getOrDefault(() -> model.getDay().getCondition().getText(), ""))
                .setIcon(getOrDefault(() -> model.getDay().getCondition().getIcon(), ""))
                .build();
    }

    default WeathersResponse toResponse(final InlineResponse2001 model) {
        if (model == null)
            return WeathersResponse.newBuilder().build();
        return WeathersResponse.newBuilder()
                .addAllWeathers(getOrDefault(() -> model.getForecast().getForecastday().stream().map(this::toResponse).collect(Collectors.toList()), Collections.EMPTY_LIST))
                .build();
    }
}
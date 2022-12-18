package smart.ix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;
@Data
public class Forecast {
    @JsonProperty("forecastday")
    private List<ForecastForecastday> forecastday = null;
}

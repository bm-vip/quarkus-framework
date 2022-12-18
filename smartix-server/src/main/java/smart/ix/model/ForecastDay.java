package smart.ix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ForecastDay {
    @JsonProperty("maxtemp_c")
    private BigDecimal maxtempC = null;

    @JsonProperty("maxtemp_f")
    private BigDecimal maxtempF = null;

    @JsonProperty("mintemp_c")
    private BigDecimal mintempC = null;

    @JsonProperty("mintemp_f")
    private BigDecimal mintempF = null;

    @JsonProperty("avgtemp_c")
    private BigDecimal avgtempC = null;

    @JsonProperty("avgtemp_f")
    private BigDecimal avgtempF = null;

    @JsonProperty("maxwind_mph")
    private BigDecimal maxwindMph = null;

    @JsonProperty("maxwind_kph")
    private BigDecimal maxwindKph = null;

    @JsonProperty("totalprecip_mm")
    private Integer totalprecipMm = null;

    @JsonProperty("totalprecip_in")
    private Integer totalprecipIn = null;

    @JsonProperty("avgvis_km")
    private Integer avgvisKm = null;

    @JsonProperty("avgvis_miles")
    private Integer avgvisMiles = null;

    @JsonProperty("avghumidity")
    private Integer avghumidity = null;

    @JsonProperty("daily_will_it_rain")
    private Integer dailyWillItRain = null;

    @JsonProperty("daily_chance_of_rain")
    private Integer dailyChanceOfRain = null;

    @JsonProperty("daily_will_it_snow")
    private Integer dailyWillItSnow = null;

    @JsonProperty("daily_chance_of_snow")
    private Integer dailyChanceOfSnow = null;

    @JsonProperty("condition")
    private ForecastDayCondition condition = null;

    @JsonProperty("uv")
    private Integer uv = null;

}

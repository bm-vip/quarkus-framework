package smart.ix.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ForecastForecastday {
    @JsonProperty("date")
    private LocalDate date = null;

    @JsonProperty("date_epoch")
    private Integer dateEpoch = null;

    @JsonProperty("day")
    private ForecastDay day = null;
}

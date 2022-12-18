package smart.ix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class InlineResponse2001 {
  @JsonProperty("location")
  private Location location = null;

  @JsonProperty("current")
  private Current current = null;

  @JsonProperty("forecast")
  private Forecast forecast = null;
}

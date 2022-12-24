package smart.ix.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * InlineResponse200
 */
@Data
public class InlineResponse200 {
  @JsonProperty("location")
  private Location location = null;

  @JsonProperty("current")
  private Current current = null;

}

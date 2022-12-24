package smart.ix.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Location {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("region")
    private String region = null;

    @JsonProperty("country")
    private String country = null;

    @JsonProperty("lat")
    private BigDecimal lat = null;

    @JsonProperty("lon")
    private BigDecimal lon = null;

    @JsonProperty("tz_id")
    private String tzId = null;

    @JsonProperty("localtime_epoch")
    private Integer localtimeEpoch = null;

    @JsonProperty("localtime")
    private String localtime = null;
}

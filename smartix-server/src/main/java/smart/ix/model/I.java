package smart.ix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class I {
    @JsonProperty("height")
    private int height;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("width")
    private int width;
}

package smart.ix.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class MovieDto {
    @JsonProperty("d")
    private ArrayList<D> d;
    @JsonProperty("q")
    private String q;
    @JsonProperty("v")
    private int v;
}



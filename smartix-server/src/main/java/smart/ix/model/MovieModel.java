package smart.ix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class MovieModel {
    @JsonProperty("d")
    private ArrayList<D> d;
    @JsonProperty("q")
    private String q;
    @JsonProperty("v")
    private int v;
}



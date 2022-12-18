package smart.ix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class D{
    @JsonProperty("i")
    private I i;
    @JsonProperty("id")
    private String id;
    @JsonProperty("l")
    private String l;
    @JsonProperty("q")
    private String q;
    @JsonProperty("qid")
    private String qid;
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("s")
    private String s;
    @JsonProperty("y")
    private int y;
    @JsonProperty("yr")
    private String yr;
}

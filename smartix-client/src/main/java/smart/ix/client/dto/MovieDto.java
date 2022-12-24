package smart.ix.client.dto;

import smart.ix.MovieResponse;

public class MovieDto {
    private String name;
    private String url;
    private String actors;
    private Integer year;
    private Integer rank;

    public MovieDto(MovieResponse response) {
        this.name = response.getName();
        this.url = response.getUrl();
        this.actors = response.getActors();
        this.year = response.getYear();
        this.rank = response.getRank();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}

package smart.ix.dto;

import smart.ix.WeatherResponse;

public class WeatherDto {
    private String date;
    private String condition;
    private String icon;
    private Double avgTempC;

    public WeatherDto(WeatherResponse response) {
        this.date = response.getDate();
        this.condition = response.getCondition();
        this.icon = response.getIcon();
        this.avgTempC = response.getAvgTempC();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Double getAvgTempC() {
        return avgTempC;
    }

    public void setAvgTempC(Double avgTempC) {
        this.avgTempC = avgTempC;
    }
}

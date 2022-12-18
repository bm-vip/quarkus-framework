package smart.ix.dto;

import smart.ix.DeviceType;
import smart.ix.WatchModel;

public class WatchDto {
    private String id;
    private String name;
    private DeviceType type;
    public int burnedCalories;

    public WatchDto(WatchModel model) {
        this.id = model.getId();
        this.name = model.getName();
        this.type = model.getType();
        this.burnedCalories = model.getBurnedCalories();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public int getBurnedCalories() {
        return burnedCalories;
    }

    public void setBurnedCalories(int burnedCalories) {
        this.burnedCalories = burnedCalories;
    }
}

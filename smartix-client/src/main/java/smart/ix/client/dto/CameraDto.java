package smart.ix.client.dto;


import smart.ix.CameraModel;
import smart.ix.DeviceType;

public class CameraDto {
    private String id;
    private String name;
    private DeviceType type;
    private String image;
    private String url;

    public CameraDto(CameraModel model) {
        this.id = model.getId();
        this.name = model.getName();
        this.type = model.getType();
        this.image = model.getImage();
        this.url = model.getUrl();
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

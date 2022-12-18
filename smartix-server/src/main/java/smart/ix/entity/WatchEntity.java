package smart.ix.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import smart.ix.DeviceType;

@MongoEntity(collection = "Watch")
@Data
public class WatchEntity {
    @BsonId
    private ObjectId id;
    private String name;
    private DeviceType type;
    public int burnedCalories;
}

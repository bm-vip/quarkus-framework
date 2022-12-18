package smart.ix.mapper;

import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import smart.ix.DeviceType;
import smart.ix.WatchModel;
import smart.ix.entity.WatchEntity;

import static smart.ix.util.MapperHelper.getOrDefault;

@Mapper(componentModel = "cdi")
public interface WatchMapper extends BaseMapper<WatchModel, WatchEntity> {
    @Override
    default WatchEntity toEntity(final WatchModel model){
        if (model == null)
            return null;
        WatchEntity entity = new WatchEntity();
        entity.setId(new ObjectId(model.getId()));
        entity.setName(model.getName());
        entity.setType(model.getType());
        entity.setBurnedCalories(model.getBurnedCalories());
        return entity;
    }

    @Override
    default WatchModel toModel(final WatchEntity entity) {
        if (entity == null)
            return WatchModel.newBuilder().build();
        return WatchModel.newBuilder()
                .setId(getOrDefault(()->entity.getId().toString(),""))
                .setType(getOrDefault(()->entity.getType(), DeviceType.UNRECOGNIZED))
                .setName(getOrDefault(()->entity.getName(),""))
                .setBurnedCalories(getOrDefault(()->entity.getBurnedCalories(),0))
                .build();
    }
}
package smart.ix.mapper;

import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import smart.ix.CameraModel;
import smart.ix.DeviceType;
import smart.ix.entity.CameraEntity;

import static smart.ix.util.MapperHelper.getOrDefault;

@Mapper(componentModel = "cdi")
public interface CameraMapper extends BaseMapper<CameraModel, CameraEntity> {
    @Override
    default CameraEntity toEntity(final CameraModel model){
        CameraEntity entity = new CameraEntity();
        entity.setId(new ObjectId(model.getId()));
        entity.setName(model.getName());
        entity.setType(model.getType());
        entity.setUrl(model.getUrl());
        entity.setImage(model.getImage());
        return entity;
    }

    @Override
    default CameraModel toModel(final CameraEntity entity) {
        if (entity == null)
            return CameraModel.newBuilder().build();
        return CameraModel.newBuilder()
                .setId(getOrDefault(()->entity.getId().toString(),""))
                .setType(getOrDefault(()->entity.getType(), DeviceType.UNRECOGNIZED))
                .setName(getOrDefault(()->entity.getName(),""))
                .setImage(getOrDefault(()->entity.getImage(),""))
                .setUrl(getOrDefault(()->entity.getUrl(),""))
                .build();
    }
}
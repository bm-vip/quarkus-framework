package smart.ix.service.impl;

import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import smart.ix.CameraModel;
import smart.ix.CameraModels;
import smart.ix.entity.CameraEntity;
import smart.ix.exception.NotFoundException;
import smart.ix.mapper.CameraMapper;
import smart.ix.repository.CameraRepository;
import smart.ix.service.CameraService;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class CameraServiceImpl implements CameraService {
    private final CameraRepository repository;
    private final CameraMapper mapper;

    @Override
    public void save(CameraModel model) {
        log.debug("call save with {}", model);
        if (Objects.nonNull(model.getId())) {
            CameraEntity old = repository.findByIdOptional(new ObjectId(model.getId())).orElseThrow(() -> new NotFoundException("camera not found with id" + model.getId()));
            repository.update(mapper.updateEntity(model, old));
        } else
            repository.persist(mapper.toEntity(model));
    }

    @Override
    public CameraModel findById(String id) {
        CameraEntity entity = repository.findByIdOptional(new ObjectId(id)).orElseThrow(() -> new NotFoundException("camera not found with id " + id));
        return mapper.toModel(entity);
    }

    @Override
    public List<CameraModel> findAll(String field, Object value) {
        if (Objects.isNull(value))
            return mapper.toModel(repository.listAll());
        return mapper.toModel(repository.find(field, value).list());
    }

    @Override
    public void delete(String id) {
        repository.deleteById(new ObjectId(id));
    }
}

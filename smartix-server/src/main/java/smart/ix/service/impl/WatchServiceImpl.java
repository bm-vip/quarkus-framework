package smart.ix.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import smart.ix.WatchModel;
import smart.ix.entity.WatchEntity;
import smart.ix.exception.NotFoundException;
import smart.ix.mapper.WatchMapper;
import smart.ix.repository.WatchRepository;
import smart.ix.service.WatchService;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class WatchServiceImpl implements WatchService {
    private final WatchRepository repository;
    private final WatchMapper mapper;

    @Override
    public void save(WatchModel model) {
        log.debug("call save with {}", model);
        if (Objects.nonNull(model.getId())) {
            WatchEntity old = repository.findByIdOptional(new ObjectId(model.getId())).orElseThrow(() -> new NotFoundException("watch not found with id" + model.getId()));
            repository.update(mapper.updateEntity(model, old));
        } else
            repository.persist(mapper.toEntity(model));
    }

    @Override
    public WatchModel findById(String id) {
        WatchEntity entity = repository.findByIdOptional(new ObjectId(id)).orElseThrow(() -> new NotFoundException("watch not found with id " + id));
        return mapper.toModel(entity);
    }

    @Override
    public List<WatchModel> findAll(String field, Object value) {
        return mapper.toModel(repository.find(field, value).list());
    }

    @Override
    public void delete(String id) {
        repository.deleteById(new ObjectId(id));
    }
}

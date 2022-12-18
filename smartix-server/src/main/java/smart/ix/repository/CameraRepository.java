package smart.ix.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import smart.ix.entity.CameraEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CameraRepository implements PanacheMongoRepository<CameraEntity> {
    public List<CameraEntity> findByName(String name) {
        return find("name", name).list();
    }
}

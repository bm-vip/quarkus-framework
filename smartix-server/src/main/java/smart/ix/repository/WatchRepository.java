package smart.ix.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import smart.ix.entity.WatchEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class WatchRepository implements PanacheMongoRepository<WatchEntity> {
    public List<WatchEntity> findByName(String name) {
        return find("name", name).list();
    }
}

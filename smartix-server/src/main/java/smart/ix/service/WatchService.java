package smart.ix.service;

import smart.ix.WatchModel;

import java.util.List;

public interface WatchService {
    void save(WatchModel model);
    WatchModel findById(String id);
    List<WatchModel> findAll(String field, Object value);
    void delete(String id);
}

package smart.ix.service;

import smart.ix.CameraModel;

import java.util.List;

public interface CameraService {
    void save(CameraModel model);
    CameraModel findById(String id);
    List<CameraModel> findAll(String field, Object value);
    void delete(String id);
}

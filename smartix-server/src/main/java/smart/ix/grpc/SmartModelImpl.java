package smart.ix.grpc;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import smart.ix.*;
import smart.ix.service.CameraService;
import smart.ix.service.WatchService;

import java.util.List;

@GrpcService
@RequiredArgsConstructor
@Slf4j
public class SmartModelImpl implements SmartModel {
    private final CameraService cameraService;
    private final WatchService watchService;

    @Override
    public Uni<CameraModel> saveCameraInfo(CameraModel request) {
        log.debug("call saveCameraInfo with {}", request);
        cameraService.save(request);
        return Uni.createFrom().item(request);
    }

    @Override
    public Uni<CameraModels> getCameraInfo(CameraModel request) {
        log.debug("call getCameraInfo with {}", request);
        List<CameraModel> models = null;
        if (StringUtils.isNotEmpty(request.getId()))
            models = cameraService.findAll("id",new ObjectId(request.getId()));
        else if (StringUtils.isNotEmpty(request.getName()))
            models = cameraService.findAll("name", request.getName());
        else models = cameraService.findAll(null,null);

        CameraModels cameraModels = CameraModels.newBuilder().addAllModels(models).build();
        return Uni.createFrom().item(cameraModels);
    }

    @Override
    public Uni<WatchModel> saveWatchInfo(WatchModel request) {
        log.debug("call saveWatchInfo with {}", request);
        watchService.save(request);
        return Uni.createFrom().item(request);
    }

    @Override
    public Uni<WatchModels> getWatchInfo(WatchModel request) {
        log.debug("call getWatchInfo with {}", request);
        List<WatchModel> models = null;
        if (StringUtils.isNotEmpty(request.getId()))
            models = watchService.findAll("id", new ObjectId(request.getId()));
        else if (StringUtils.isNotEmpty(request.getName()))
            models = watchService.findAll("name", request.getName());
        else models = watchService.findAll(null,null);

        WatchModels watchModels = WatchModels.newBuilder().addAllModels(models).build();
        return Uni.createFrom().item(watchModels);
    }
}

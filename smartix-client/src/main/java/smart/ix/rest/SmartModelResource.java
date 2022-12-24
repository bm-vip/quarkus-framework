package smart.ix.rest;

import io.quarkus.grpc.GrpcClient;
import smart.ix.*;
import smart.ix.client.dto.CameraDto;
import smart.ix.client.dto.WatchDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Produces(MediaType.APPLICATION_JSON)
@Path("/api/v1/smart-model")
public class SmartModelResource {

    @GrpcClient("smartModel")
    SmartModelGrpc.SmartModelBlockingStub blockingSmartModel;

    @GET
    @Path("/camera")
    public Response getCameraInfo(@QueryParam("name") String name) {
        List<CameraModel> list = blockingSmartModel.getCameraInfo(CameraModel.newBuilder().setName(name).build()).getModelsList();
        return Response.ok(list.stream().map(CameraDto::new).collect(Collectors.toList())).build();
    }

    @GET
    @Path("/watch")
    public Response getWatchInfo(@QueryParam("name") String name) {
        List<WatchModel> list = blockingSmartModel.getWatchInfo(WatchModel.newBuilder().setName(name).build()).getModelsList();
        return Response.ok(list.stream().map(WatchDto::new).collect(Collectors.toList())).build();
    }
}

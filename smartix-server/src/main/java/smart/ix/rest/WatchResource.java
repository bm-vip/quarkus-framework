package smart.ix.rest;

import smart.ix.entity.WatchEntity;
import smart.ix.repository.WatchRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("/api/v1/watch")
public class WatchResource {

    @Inject
    WatchRepository repository;

    @GET
    @Path("/{name}")
    public Response findByName(@PathParam("name") String name) {
        return Response.ok(repository.findByName(name)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(repository.findAll().list()).build();
    }

    @POST
    public Response save(WatchEntity entity) {
        repository.persistOrUpdate(entity);
        return Response.ok().build();
    }
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        repository.delete(id);
        return Response.ok().build();
    }

}

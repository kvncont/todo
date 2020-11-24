package com.github.kvncont;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/todo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ToDoResource {

    @Inject
    ToDoService service;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response newTaskString(@Valid String task) {
        try {
            if (task == null) {
                return Response.status(400).entity("Task not provided").build();
            }
            return Response.ok(service.addTask(task)).build();
        }
        catch (Exception e){
            return Response.serverError().build();
        }
    }

    @GET
    public Response allTasks(){
        return Response.ok(service.allTasks()).build();
    }

    @GET
    @Path("/{id}")
    public Response task(@PathParam("id") String id){
        return Response.ok(service.getTask(id)).build();
    }

    @PATCH
    @Path("status/{id}")
    public Response changeStatus(@PathParam("id") String id){
        return Response.ok(service.changeStatus(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id){
        return Response.ok(service.delete(id)).build();
    }
    
}
package com.erremauro.restfulapi.resource;

import com.erremauro.restfulapi.type.ApiResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Example Book API Resource.
 * @author robertomauro
 */
@Path("books")
public class BookResource {
    
    @GET @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse getBook(@PathParam("id") int id) {
        return ApiResponse.ok(id)
                .withMessage("Book #" + id + " requested successfully.");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse getBooks() {
        return ApiResponse.ok("Book list requested successfully.");
    }
}

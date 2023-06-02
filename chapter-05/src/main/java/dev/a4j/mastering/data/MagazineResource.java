package dev.a4j.mastering.data;


import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/library")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MagazineResource {

    @GET
    public List<Book> findAll() {
        return Book.listAll();
    }

    @GET
    @Path("{name}")
    public List<Book> findByName(@PathParam("name") String name) {
        return Book.findByName(name);
    }

    @POST
    @Transactional
    public Book insert(Book book) {
        book.persist();
        return book;
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        Book.deleteById(id);
    }

}

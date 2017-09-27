package com.bookstore.rest;

import com.bookstore.model.Author;
import com.bookstore.service.AuthorService;
import io.dropwizard.hibernate.UnitOfWork;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by iurii on 9/14/17.
 */
@Path(ResourceTemplateUrl.AUTHOR)
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class AuthorRest {

    private AuthorService authorService;

    @Inject
    public AuthorRest(AuthorService authorService) {
        this.authorService = authorService;
    }

    @POST
    @UnitOfWork
    public Response save(@Valid Author author) {
        Author persistAuthor = authorService.saveAuthor(author);
        return Response.status(Response.Status.CREATED).entity(persistAuthor).build();
    }

    @GET
    @Path("/id/{id}")
    @UnitOfWork
    public Response findAuthorByID(@PathParam("id") Integer authorId) {
        Author author = authorService.findAuthorById(authorId);
        return (author != null) ?
                Response.status(Response.Status.FOUND).entity(author).build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/name/{name}")
    @UnitOfWork
    public Response findAuthorByName(@PathParam("name") String name) {
        List<Author> authorList = authorService.findAuthorByName(name);
        return Response.ok().entity(new GenericEntity<List<Author>>(authorList){}).build();
    }

    @GET
    @UnitOfWork
    public Response findAllAuthors() {
        List<Author> authorList = authorService.findAllAuthors();
        return Response.ok().entity(new GenericEntity<List<Author>>(authorList){}).build();
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public Response deleteAuthor(@PathParam("id") Integer authorId) {
        Author author = authorService.findAuthorById(authorId);
        if (author != null) {
            authorService.deleteAuthor(author);
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

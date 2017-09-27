package com.bookstore.rest;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;
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
@Path(ResourceTemplateUrl.BOOK)
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class BookRest {
    private BookService bookService;

    @Inject
    public BookRest(BookService bookService) {
        this.bookService = bookService;
    }

    @POST
    @UnitOfWork
    public Response save(Book book) {
        Book persistBook = bookService.saveBook(book);
        return Response.status(Response.Status.CREATED).entity(persistBook).build();
    }

    @GET
    @Path("/id/{isbn}")
    @UnitOfWork
    public Response findBookByIsbn(@PathParam("isbn") String isbn) {
        Book book = bookService.findBookByIsbn(isbn);
        return (book != null) ?
                Response.status(Response.Status.FOUND).entity(book).build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/title/{title}")
    @UnitOfWork
    public Response findBookByTitle(@PathParam("title") String title) {
        List<Book> bookList = bookService.findBookByTitle(title);
        return Response.ok().entity(new GenericEntity<List<Book>>(bookList){}).build();
    }

    @GET
    @UnitOfWork
    public Response findAllBook() {
        List<Book> bookList = bookService.findAllBooks();
        return Response.ok().entity(new GenericEntity<List<Book>>(bookList){}).build();
    }

    @DELETE
    @Path("/{isbn}")
    @UnitOfWork
    public Response deleteBook(@PathParam("isbn") String isbn) {
        Book book = bookService.findBookByIsbn(isbn);
        if (book != null) {
            bookService.deleteBook(book);
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
package com.bookstore.rest;

import com.bookstore.view.BookView;
import com.bookstore.view.LoginView;
import io.dropwizard.hibernate.UnitOfWork;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by iurii on 10/5/17.
 */
@Path("/view")
@Produces(MediaType.TEXT_HTML)
public class ViewRest {
    private BookView bookView;
    private LoginView loginView;

    @Inject
    public ViewRest(BookView bookView, LoginView loginView) {
        this.bookView = bookView;
        this.loginView = loginView;
    }

    @Path("/login")
    @GET
    @UnitOfWork
    public LoginView getLoginView() { return loginView; }


    @Path("/book_list")
    @GET
    @UnitOfWork
    public BookView getBookList() {
        return bookView;
    }
}

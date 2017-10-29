package com.bookstore.rest;

import com.bookstore.service.LoginService;
import io.dropwizard.hibernate.UnitOfWork;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by iurii on 10/25/17.
 */
@Path("/login")
public class LoginRest {
    private LoginService loginService;

    @Inject
    public LoginRest(LoginService loginService) {
        this.loginService = loginService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @UnitOfWork
    @Path("/check")
    public Response checkUserPermission(@FormParam("login") String login,
                                        @FormParam("password") String password) {
        loginService.isUserExits(login, password);

        return Response.ok().build();
    }
}

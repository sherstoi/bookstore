package com.bookstore.view;

import com.bookstore.service.LoginService;
import io.dropwizard.views.View;

import javax.inject.Inject;

/**
 * Created by iurii on 10/8/17.
 */
public class LoginView extends View {
    LoginService loginService;

    @Inject
    public LoginView(LoginService loginService) {
        super("/login-view.mustache");
        this.loginService = loginService;
    }

}
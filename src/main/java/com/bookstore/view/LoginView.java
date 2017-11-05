package com.bookstore.view;

import io.dropwizard.views.View;

import javax.inject.Inject;

/**
 * Created by iurii on 10/8/17.
 */
public class LoginView extends View {

    public LoginView() {
        super("/login-view.mustache");
    }
}
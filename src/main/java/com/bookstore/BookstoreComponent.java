package com.bookstore;

import com.bookstore.config.di_modules.DaoModule;
import com.bookstore.config.di_modules.RestModule;
import com.bookstore.config.di_modules.ServiceModule;
import com.bookstore.config.di_modules.ViewModule;
import com.bookstore.rest.AuthorRest;
import com.bookstore.rest.BookRest;
import com.bookstore.rest.LoginRest;
import com.bookstore.rest.ViewRest;
import com.bookstore.service.AuthorService;
import com.bookstore.service.BookService;
import com.bookstore.service.LoginService;
import com.bookstore.view.BookView;
import com.bookstore.view.LoginView;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by iurii on 9/25/17.
 */
@Singleton
@Component(modules = {DaoModule.class, ServiceModule.class, RestModule.class, ViewModule.class})
public interface BookstoreComponent {
    AuthorService getAuthorService();
    BookService getBookService();
    LoginService getLoginService();
    BookView getBookView();
    LoginView getLoginView();
    AuthorRest getAuthorRest();
    BookRest getBookRest();
    ViewRest getViewRest();
    LoginRest getLoginRest();
}
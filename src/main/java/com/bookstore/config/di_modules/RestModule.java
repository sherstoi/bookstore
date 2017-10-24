package com.bookstore.config.di_modules;

import com.bookstore.rest.AuthorRest;
import com.bookstore.rest.BookRest;
import com.bookstore.rest.ViewRest;
import com.bookstore.service.AuthorService;
import com.bookstore.service.BookService;
import com.bookstore.view.BookView;
import com.bookstore.view.LoginView;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by iurii on 9/27/17.
 */
@Module
public class RestModule {
    @Singleton
    @Provides
    AuthorRest provideAuthorRest(AuthorService authorService) {
        return new AuthorRest(authorService);
    }

    @Singleton
    @Provides
    BookRest provideBookRest(BookService bookService) {
        return new BookRest(bookService);
    }

    @Singleton
    @Provides
    ViewRest provideViewRest(BookView bookView, LoginView loginView) { return new ViewRest(bookView, loginView); }
}

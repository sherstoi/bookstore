package com.bookstore.config.di_modules;

import com.bookstore.service.BookService;
import com.bookstore.service.LoginService;
import com.bookstore.view.BookView;
import com.bookstore.view.LoginView;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by iurii on 10/5/17.
 */
@Module
public class ViewModule {
    @Singleton
    @Provides
    BookView provideBookView(BookService bookService) { return new BookView(bookService); }

    @Singleton
    @Provides
    LoginView provideLoginView(LoginService loginService) { return new LoginView(loginService); }
}

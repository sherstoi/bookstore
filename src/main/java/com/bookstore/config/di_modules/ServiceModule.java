package com.bookstore.config.di_modules;

import com.bookstore.dao.AuthorDAO;
import com.bookstore.dao.BookDAO;
import com.bookstore.service.AuthorService;
import com.bookstore.service.BookService;
import com.bookstore.service.LoginService;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by iurii on 9/27/17.
 */
@Module
public class ServiceModule {
    @Singleton
    @Provides
    BookService provideBookService(BookDAO bookDAO) {
        return new BookService(bookDAO);
    }

    @Singleton
    @Provides
    AuthorService provideAuthorService(AuthorDAO authorDAO) {
        return new AuthorService(authorDAO);
    }

    @Singleton
    @Provides
    LoginService provideLoginService() { return new LoginService(); }
}

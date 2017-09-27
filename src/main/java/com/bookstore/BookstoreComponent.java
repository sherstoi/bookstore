package com.bookstore;

import com.bookstore.config.di_modules.DaoModule;
import com.bookstore.rest.AuthorRest;
import com.bookstore.rest.BookRest;
import com.bookstore.service.AuthorService;
import com.bookstore.service.BookService;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by iurii on 9/25/17.
 */
@Singleton
@Component(modules = {DaoModule.class})
public interface BookstoreComponent {
    AuthorService getAuthorService();
    BookService getBookService();
    AuthorRest getAuthorRest();
    BookRest getBookRest();
}
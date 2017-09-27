package com.bookstore.config.di_modules;

import com.bookstore.dao.AuthorDAO;
import com.bookstore.dao.BookDAO;
import com.bookstore.rest.AuthorRest;
import com.bookstore.rest.BookRest;
import com.bookstore.service.AuthorService;
import com.bookstore.service.BookService;
import dagger.Module;
import dagger.Provides;
import org.hibernate.SessionFactory;

import javax.inject.Singleton;

/**
 * Created by iurii on 9/25/17.
 */
@Module
public class DaoModule {
    private SessionFactory sessionFactory;

    public DaoModule(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Singleton
    @Provides
    SessionFactory provideSessionFactory() {
        return sessionFactory;
    }

    @Singleton
    @Provides
    BookDAO provideBookDAO(SessionFactory sessionFactory) {
        return new BookDAO(sessionFactory);
    }

    @Singleton
    @Provides
    AuthorDAO provideAuthorDAO(SessionFactory sessionFactory) {
        return new AuthorDAO(sessionFactory);
    }
}

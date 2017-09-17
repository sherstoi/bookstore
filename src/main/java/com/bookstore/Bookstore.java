package com.bookstore;

import com.bookstore.config.BookstoreConfig;
import com.bookstore.dao.AuthorDAO;
import com.bookstore.dao.BookDAO;
import com.bookstore.model.Author;
import com.bookstore.model.Book;
import com.bookstore.rest.AuthorRest;
import com.bookstore.rest.BookRest;
import com.bookstore.service.AuthorService;
import com.bookstore.service.BookService;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.text.SimpleDateFormat;

/**
 * Created by iurii on 9/9/17.
 */
public class Bookstore extends Application<BookstoreConfig> {
    private static final String SERVER = "server";
    private static final String APPLICATION_PROP = "application.yaml";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private final HibernateBundle<BookstoreConfig> hibernateBundle = new HibernateBundle<BookstoreConfig>(Author.class, Book.class) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(BookstoreConfig configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    public static void main(String[] args) throws Exception {
        new Bookstore().run(SERVER, APPLICATION_PROP);
    }

    @Override
    public void initialize(Bootstrap<BookstoreConfig> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(BookstoreConfig bookstoreConfig, Environment environment) {
        AuthorDAO authorDAO = new AuthorDAO(hibernateBundle.getSessionFactory());
        BookDAO bookDAO = new BookDAO(hibernateBundle.getSessionFactory());
        environment.getObjectMapper().setDateFormat(new SimpleDateFormat(DATE_FORMAT));
        environment.jersey().register(new AuthorRest(new AuthorService(authorDAO)));
        environment.jersey().register(new BookRest(new BookService(bookDAO)));
    }
}

package com.bookstore;

import com.bookstore.config.BookstoreConfig;
import com.bookstore.config.di_modules.DaoModule;
import com.bookstore.model.Author;
import com.bookstore.model.Book;
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
        BookstoreComponent bookstoreComponent = DaggerBookstoreComponent.builder()
                .daoModule(new DaoModule(hibernateBundle.getSessionFactory())).build();
        environment.getObjectMapper().setDateFormat(new SimpleDateFormat(DATE_FORMAT));
        environment.jersey().register(bookstoreComponent.getAuthorRest());
        environment.jersey().register(bookstoreComponent.getBookRest());
    }
}
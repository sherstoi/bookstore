package com.bookstore;

import com.bookstore.config.BookstoreConfig;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by iurii on 9/9/17.
 */
public class Bookstore extends Application<BookstoreConfig> {
    private static final String SERVER = "server";

    public static void main(String[] args) throws Exception {
        new Bookstore().run(SERVER);
    }

    @Override
    public void initialize(Bootstrap<BookstoreConfig> bootstrap) {
    }

    @Override
    public void run(BookstoreConfig bookstoreConfig, Environment environment) {
    }
}

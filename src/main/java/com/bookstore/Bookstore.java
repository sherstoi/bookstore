package com.bookstore;

import com.bookstore.config.BookstoreConfig;
import com.bookstore.config.di_modules.DaoModule;
import com.bookstore.filter.CustomAuthFilter;
import com.bookstore.model.Author;
import com.bookstore.model.Book;
import com.bookstore.model.Usrlog;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.text.SimpleDateFormat;
import java.util.EnumSet;

/**
 * Created by iurii on 9/9/17.
 */
public class Bookstore extends Application<BookstoreConfig> {
    private static final String SERVER = "server";
    private static final String APPLICATION_PROP = "application.yaml";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private final HibernateBundle<BookstoreConfig> hibernateBundle = new HibernateBundle<BookstoreConfig>(Author.class, Book.class, Usrlog.class) {
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
        bootstrap.addBundle(new ViewBundle<>());
        bootstrap.addBundle(new AssetsBundle("/assets/", "/page"));
    }

    @Override
    public void run(BookstoreConfig bookstoreConfig, Environment environment) {
        BookstoreComponent bookstoreComponent = DaggerBookstoreComponent.builder()
                .daoModule(new DaoModule(hibernateBundle.getSessionFactory())).build();
        environment.getObjectMapper().setDateFormat(new SimpleDateFormat(DATE_FORMAT));
        environment.jersey().register(bookstoreComponent.getAuthorRest());
        environment.jersey().register(bookstoreComponent.getBookRest());
        environment.jersey().register(bookstoreComponent.getViewRest());
        environment.jersey().register(bookstoreComponent.getLoginRest());
        corsBuilder(environment);

        //TODO move below to dagger componenet
        CustomAuthFilter customAuthFilter = new CustomAuthFilter();
        environment.jersey().register(new AuthDynamicFeature(customAuthFilter));
    }

    private FilterRegistration.Dynamic corsBuilder(Environment environment) {
        final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        return cors;
    }
}
package com.bookstore.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by iurii on 9/9/17.
 */
public class BookstoreConfig extends Configuration {
    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }
}

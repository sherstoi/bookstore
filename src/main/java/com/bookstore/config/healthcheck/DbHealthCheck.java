package com.bookstore.config.healthcheck;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by iurii on 9/26/17.
 */
//TODO
public class DbHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}

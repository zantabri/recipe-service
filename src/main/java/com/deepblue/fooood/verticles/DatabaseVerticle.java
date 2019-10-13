package com.deepblue.fooood.verticles;

import static com.deepblue.fooood.Queues.*;
import com.deepblue.fooood.services.DatabaseService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.serviceproxy.ServiceBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class DatabaseVerticle extends AbstractVerticle {

    private final Logger logger = LoggerFactory.getLogger(DatabaseVerticle.class);

    @Override
    public void start(Promise<Void> promise) throws Exception {

        logger.info("starting database verticle");
        DatabaseService.create(ready -> {

            //work of setting up the database service would have been attempted in the
            //service creation method we are just working with the result here
            if(ready.failed()) {
                promise.fail(ready.cause());
                return;
            }

            ServiceBinder binder = new ServiceBinder(vertx);
            binder
               .setAddress(RECIPE_DB_QUEUE)
               .register(DatabaseService.class, ready.result());

            logger.info("database verticle started");
            promise.complete();

        });
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}

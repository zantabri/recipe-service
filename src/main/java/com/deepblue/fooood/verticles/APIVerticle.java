package com.deepblue.fooood.verticles;

import static com.deepblue.fooood.Queues.*;

import com.deepblue.fooood.services.APIService;
import com.deepblue.fooood.services.DatabaseService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.serviceproxy.ServiceBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class APIVerticle extends AbstractVerticle {

    private final Logger logger = LoggerFactory.getLogger(APIVerticle.class);
    private DatabaseService databaseService;

    @Override
    public void start(Promise<Void> startPromise) throws Exception {

        logger.info("starting api verticle");
        databaseService = DatabaseService.createProxy(vertx, RECIPE_DB_QUEUE);
        Promise<APIService> promise = Promise.promise();
        APIService.create(databaseService, promise);

        promise.future().compose(resp -> {

            ServiceBinder binder = new ServiceBinder(vertx);
            binder.setAddress(RECIPE_API_QUEUE);
            binder.register(APIService.class, resp);
            logger.info("api verticle started");
            startPromise.complete();
            return promise.future();

        });

    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        super.stop(stopFuture);
    }
}

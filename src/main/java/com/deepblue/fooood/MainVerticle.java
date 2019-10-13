package com.deepblue.fooood;

import com.deepblue.fooood.services.APIService;
import com.deepblue.fooood.verticles.APIVerticle;
import com.deepblue.fooood.verticles.DatabaseVerticle;
import com.deepblue.fooood.verticles.HttpServerVerticle;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.Promise;

/**
 *
 */
public class MainVerticle extends AbstractVerticle {

    private APIService apiService;

    @Override
    public void start(Promise<Void> startPromise) {

        Promise<String> databaseDeployment = Promise.promise();
        vertx.deployVerticle(DatabaseVerticle.class.getName(),databaseDeployment);

        Future<String> apiVerticleDeployment = databaseDeployment.future().compose(id -> {

            Promise<String> promise = Promise.promise();
            vertx.deployVerticle(APIVerticle.class.getName(), new DeploymentOptions().setInstances(4), promise);
            return promise.future();

        });

        Future<String> httpServerDeploymentVerticle = apiVerticleDeployment.compose(id -> {

            Promise<String> promise = Promise.promise();
            vertx.deployVerticle(HttpServerVerticle.class.getName(), promise);

            return  promise.future();

        });

        httpServerDeploymentVerticle.setHandler(ar -> {
           if(ar.failed()) {
               startPromise.fail(ar.cause());
               return;
           }

           startPromise.complete();

        });

    }

}

package com.deepblue.fooood.verticles;

import static com.deepblue.fooood.Queues.*;
import com.deepblue.fooood.services.APIService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.handler.impl.CookieHandlerImpl;
import io.vertx.ext.web.sstore.LocalSessionStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class HttpServerVerticle extends AbstractVerticle {

    private APIService apiService;
    private final Logger logger = LoggerFactory.getLogger(HttpServerVerticle.class);

    @Override
    public void start(Promise<Void> startPromise) throws Exception {

        logger.info("starting http server verticle");

        apiService = APIService.createProxy(vertx, RECIPE_API_QUEUE);

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);
        router.route().handler(new CookieHandlerImpl());
        router.route().handler(BodyHandler.create());
        router.route().handler(SessionHandler.create(LocalSessionStore.create(vertx)));

        router.get("/recipes").handler(this::getRecipes);
        router.post("/recipes").handler(this::addRecipe);
        router.put("/recipes/:id").handler(this::updateRecipe);

        server.requestHandler(router).listen(8080, ar -> {

            if(ar.failed()) {
                startPromise.fail(ar.cause());
                return;
            }

            logger.info("http server verticle started");
            startPromise.complete();

        });

    }

    private void updateRecipe(RoutingContext context) {

        logger.info("update recipe called");
        apiService.updateRecipes(context.getBodyAsJson(), reply -> {

            context.response().putHeader("Content-Type", "application/json");

            if(reply.failed()) {
                context.response().setStatusCode(500);
                context.response().end(new JsonObject()
                .put("success",false)
                .put("error", reply.cause().getMessage()).encode());
                return;
            }

            context.response().setStatusCode(200);
            context.response().putHeader("Content-Type","application/json");
            context.response().end(new JsonObject().put("success",true).encode());

        });
    }

    private void addRecipe(RoutingContext context) {

        logger.info("add recipe called");
        JsonObject recipe = context.getBodyAsJson();
        apiService.saveRecipe(recipe, reply -> {

            if(reply.failed()) {
                 context.response().setStatusCode(500);
                context.response().putHeader("Content-Type","application/json");
                context.response().end(new JsonObject()
                    .put("success", false)
                    .put("error", reply.cause().getMessage()).encode());
                return;
            }

            context.response().setStatusCode(200);
            context.response().putHeader("Content-Type","application/json");
            context.response().end(new JsonObject().put("success",true).encode());

        });

    }

    private void getRecipes(RoutingContext context) {

        logger.info("get recipe called");
        apiService.getAllRecipes(reply -> {

            context.response().putHeader("Content-Type","application/json");
            if(reply.failed()) {
                context.response().setStatusCode(500);
                context.response().end(new JsonObject()
                        .put("success", false)
                        .put("error", reply.cause().getMessage()).encode());
                return;
            }

            context.response().setStatusCode(200);
            context.response().end(reply.result().encode());

        });

    }

}

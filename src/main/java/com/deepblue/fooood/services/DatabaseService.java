package com.deepblue.fooood.services;

import com.deepblue.fooood.model.FoodCategory;
import com.deepblue.fooood.model.Recipe;
import com.deepblue.fooood.services.impl.DatabaseServiceImpl;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.ProxyIgnore;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;


import java.util.List;

/**
 *
 */
@ProxyGen
@VertxGen
public interface DatabaseService {

    /**
     *
     * @param resultHandler
     * @return DatabaseService
     */
    @Fluent
    DatabaseService getAllRecipes(Handler<AsyncResult<List<Recipe>>> resultHandler);

    /**
     *
     * @param categories
     * @param resultHandler
     *
     * @return DatabaseService
     */
    @Fluent
    DatabaseService getRecipesByCategory(List<FoodCategory> categories, Handler<AsyncResult<List<Recipe>>> resultHandler);

    /**
     *
     * @param origin
     * @param resultHandler
     *
     * @return DatabaseService
     */
    @Fluent
    DatabaseService getRecipesByOrigin(String origin, Handler<AsyncResult<List<Recipe>>> resultHandler);

    /**
     *
     * @param origin
     * @param categories
     * @param resultHandler
     *
     * @return DatabaseService
     */
    @Fluent
    DatabaseService getRecipesByCategoryAndOrigin(String origin, List<FoodCategory> categories, Handler<AsyncResult<List<Recipe>>> resultHandler);

    /**
     *
     * @param recipe
     * @param resultHandler
     *
     * @return DatabaseService
     */
    @Fluent
    DatabaseService addRecipe(Recipe recipe, Handler<AsyncResult<Void>> resultHandler);

    /**
     *
     * @param recipe
     * @param resultHandler
     *
     * @return DatabaseService
     */
    @Fluent
    DatabaseService updateRecipe(Recipe recipe, Handler<AsyncResult<Void>> resultHandler);

    @ProxyIgnore
    static DatabaseService create(Handler<AsyncResult<DatabaseService>> readyHandler) {
        return new DatabaseServiceImpl(readyHandler);
    }

    @ProxyIgnore
    static DatabaseService createProxy(Vertx vertx, String address) {
        return new DatabaseServiceVertxEBProxy(vertx, address);
    }

}

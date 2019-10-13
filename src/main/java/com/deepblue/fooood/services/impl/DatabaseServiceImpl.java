package com.deepblue.fooood.services.impl;

import com.deepblue.fooood.model.FoodCategory;
import com.deepblue.fooood.model.Recipe;
import com.deepblue.fooood.services.DatabaseService;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DatabaseServiceImpl implements DatabaseService {

    private final Logger logger = LoggerFactory.getLogger(DatabaseService.class);

    public DatabaseServiceImpl(Handler<AsyncResult<DatabaseService>> readyHandler) {
        //connect to database and or prepare tables
        readyHandler.handle(Future.succeededFuture(this));
    }

    @Override
    public DatabaseService getAllRecipes(Handler<AsyncResult<List<Recipe>>> resultHandler) {
        return null;
    }

    @Override
    public DatabaseService getRecipesByCategory(List<FoodCategory> categories, Handler<AsyncResult<List<Recipe>>> resultHandler) {
        return null;
    }

    @Override
    public DatabaseService getRecipesByOrigin(String origin, Handler<AsyncResult<List<Recipe>>> resultHandler) {
        return null;
    }

    @Override
    public DatabaseService getRecipesByCategoryAndOrigin(String origin, List<FoodCategory> categories, Handler<AsyncResult<List<Recipe>>> resultHandler) {
        return null;
    }

    @Override
    public DatabaseService addRecipe(Recipe recipe, Handler<AsyncResult<Void>> resultHandler) {
        return null;
    }

    @Override
    public DatabaseService updateRecipe(Recipe recipe, Handler<AsyncResult<Void>> resultHandler) {
        return null;
    }
}

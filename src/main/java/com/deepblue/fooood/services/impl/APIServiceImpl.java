package com.deepblue.fooood.services.impl;

import com.deepblue.fooood.services.APIService;
import com.deepblue.fooood.services.DatabaseService;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class APIServiceImpl implements APIService {

    private final Logger logger = LoggerFactory.getLogger(APIService.class);

    DatabaseService databaseService;

    public APIServiceImpl(DatabaseService dbService, Handler<AsyncResult<APIService>> readyHandler) {
        this.databaseService = dbService;
        //do any setup work
        readyHandler.handle(Future.succeededFuture(this));
    }

    @Override
    public APIService getAllRecipes(Handler<AsyncResult<JsonObject>> result) {
        return null;
    }

    @Override
    public APIService getRecipesByFoodCategories(List<String> foodCategories, Handler<AsyncResult<JsonObject>> result) {
        return null;
    }

    @Override
    public APIService getRecipesByOrigins(String origins, Handler<AsyncResult<JsonObject>> result) {
        return null;
    }

    @Override
    public APIService getRecipesByOriginAndFoodCategories(String origin, List<String> foodCategories, Handler<AsyncResult<JsonObject>> result) {
        return null;
    }

    @Override
    public APIService saveRecipe(JsonObject object, Handler<AsyncResult<Void>> result) {
        return null;
    }

    @Override
    public APIService updateRecipes(JsonObject object, Handler<AsyncResult<Void>> result) {
        return null;
    }
}

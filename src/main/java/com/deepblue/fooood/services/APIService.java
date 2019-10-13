package com.deepblue.fooood.services;

import com.deepblue.fooood.services.impl.APIServiceImpl;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

import java.util.List;

/**
 * performs
 *  validation
 *  business logic
 *  mapping
 * on requests and responses objects and parameters
 */
@ProxyGen
@VertxGen
public interface APIService {

    /**
     *
     * @param result
     *
     * @return ApiService
     */
    @Fluent
    APIService getAllRecipes(Handler<AsyncResult<JsonObject>> result);

    /**
     *
     * @param foodCategories
     * @param result
     *
     * @return ApiService
     */
    @Fluent
    APIService getRecipesByFoodCategories(List<String> foodCategories, Handler<AsyncResult<JsonObject>> result);

    /**
     *
     */
    @Fluent
    APIService getRecipesByOrigins(String origins, Handler<AsyncResult<JsonObject>> result);

    /**
     *
     * @param origin
     * @param foodCategories
     * @param result
     *
     * @return ApiService
     */
    @Fluent
    APIService getRecipesByOriginAndFoodCategories(String origin, List<String> foodCategories, Handler<AsyncResult<JsonObject>> result);

    /**
     *
     * @param object
     * @param result
     *
     * @return ApiService
     */
    @Fluent
    APIService saveRecipe(JsonObject object, Handler<AsyncResult<Void>> result);

    /**
     *
     * @param object
     * @param result
     *
     * @return ApiService
     */
    @Fluent
    APIService updateRecipes(JsonObject object, Handler<AsyncResult<Void>> result);

    /**
     *
     * @param dbService
     * @param result
     *
     * @return ApiService
     */
    @GenIgnore
    static APIService create(DatabaseService dbService, Handler<AsyncResult<APIService>> result) {
        return new APIServiceImpl(dbService, result);
    }

    /**
     *
     * @param vertx
     * @param address
     *
     * @return apiService
     */
    @GenIgnore
    static APIService createProxy(Vertx vertx, String address) {
        return new APIServiceVertxEBProxy(vertx, address);
    }

}

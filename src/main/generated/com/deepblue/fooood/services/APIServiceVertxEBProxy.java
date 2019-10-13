/*
* Copyright 2014 Red Hat, Inc.
*
* Red Hat licenses this file to you under the Apache License, version 2.0
* (the "License"); you may not use this file except in compliance with the
* License. You may obtain a copy of the License at:
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
* WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
* License for the specific language governing permissions and limitations
* under the License.
*/

package com.deepblue.fooood.services;

import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.Vertx;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.function.Function;
import io.vertx.serviceproxy.ServiceProxyBuilder;
import io.vertx.serviceproxy.ServiceException;
import io.vertx.serviceproxy.ServiceExceptionMessageCodec;
import io.vertx.serviceproxy.ProxyUtils;

import com.deepblue.fooood.services.APIService;
import java.util.List;
import io.vertx.core.json.JsonObject;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
/*
  Generated Proxy code - DO NOT EDIT
  @author Roger the Robot
*/

@SuppressWarnings({"unchecked", "rawtypes"})
public class APIServiceVertxEBProxy implements APIService {
  private Vertx _vertx;
  private String _address;
  private DeliveryOptions _options;
  private boolean closed;

  public APIServiceVertxEBProxy(Vertx vertx, String address) {
    this(vertx, address, null);
  }

  public APIServiceVertxEBProxy(Vertx vertx, String address, DeliveryOptions options) {
    this._vertx = vertx;
    this._address = address;
    this._options = options;
    try{
      this._vertx.eventBus().registerDefaultCodec(ServiceException.class, new ServiceExceptionMessageCodec());
    } catch (IllegalStateException ex) {}
  }

  @Override
  public  APIService getAllRecipes(Handler<AsyncResult<JsonObject>> result){
    if (closed) {
      result.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "getAllRecipes");
    _vertx.eventBus().<JsonObject>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        result.handle(Future.failedFuture(res.cause()));
      } else {
        result.handle(Future.succeededFuture(res.result().body()));
      }
    });
    return this;
  }
  @Override
  public  APIService getRecipesByFoodCategories(List<String> foodCategories, Handler<AsyncResult<JsonObject>> result){
    if (closed) {
      result.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();
    _json.put("foodCategories", new JsonArray(foodCategories));

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "getRecipesByFoodCategories");
    _vertx.eventBus().<JsonObject>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        result.handle(Future.failedFuture(res.cause()));
      } else {
        result.handle(Future.succeededFuture(res.result().body()));
      }
    });
    return this;
  }
  @Override
  public  APIService getRecipesByOrigins(String origins, Handler<AsyncResult<JsonObject>> result){
    if (closed) {
      result.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();
    _json.put("origins", origins);

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "getRecipesByOrigins");
    _vertx.eventBus().<JsonObject>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        result.handle(Future.failedFuture(res.cause()));
      } else {
        result.handle(Future.succeededFuture(res.result().body()));
      }
    });
    return this;
  }
  @Override
  public  APIService getRecipesByOriginAndFoodCategories(String origin, List<String> foodCategories, Handler<AsyncResult<JsonObject>> result){
    if (closed) {
      result.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();
    _json.put("origin", origin);
    _json.put("foodCategories", new JsonArray(foodCategories));

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "getRecipesByOriginAndFoodCategories");
    _vertx.eventBus().<JsonObject>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        result.handle(Future.failedFuture(res.cause()));
      } else {
        result.handle(Future.succeededFuture(res.result().body()));
      }
    });
    return this;
  }
  @Override
  public  APIService saveRecipe(JsonObject object, Handler<AsyncResult<Void>> result){
    if (closed) {
      result.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();
    _json.put("object", object);

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "saveRecipe");
    _vertx.eventBus().<Void>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        result.handle(Future.failedFuture(res.cause()));
      } else {
        result.handle(Future.succeededFuture(res.result().body()));
      }
    });
    return this;
  }
  @Override
  public  APIService updateRecipes(JsonObject object, Handler<AsyncResult<Void>> result){
    if (closed) {
      result.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return this;
    }
    JsonObject _json = new JsonObject();
    _json.put("object", object);

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "updateRecipes");
    _vertx.eventBus().<Void>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        result.handle(Future.failedFuture(res.cause()));
      } else {
        result.handle(Future.succeededFuture(res.result().body()));
      }
    });
    return this;
  }
}

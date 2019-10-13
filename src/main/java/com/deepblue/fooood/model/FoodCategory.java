package com.deepblue.fooood.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 *
 */
@DataObject
public class FoodCategory {

    private String title;

    public FoodCategory(JsonObject object) {
        this.title = object.getString("title");
    }

    public FoodCategory(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public JsonObject toJson() {
        return JsonObject.mapFrom(this);
    }

}

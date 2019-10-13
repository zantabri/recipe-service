package com.deepblue.fooood.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class FoodOrigin {

    private String title;

    public FoodOrigin(JsonObject jsonObject) {
        this.title = jsonObject.getString("title");
    }

    public FoodOrigin(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public JsonObject toJson() {
        return JsonObject.mapFrom(this);
    }

}

package com.deepblue.fooood.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 *
 */
@DataObject
public class PreparationStep {

    private int sequence;
    private String title;
    private String content;

    public PreparationStep(JsonObject object) {
        this.sequence = object.getInteger("sequence");
        this.title = object.getString("title");
        this.content = object.getString("content");
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public JsonObject toJson() {
        return JsonObject.mapFrom(this);
    }

}

package com.deepblue.fooood.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.List;
import java.util.stream.Collectors;

@DataObject
public class Recipe {

    private String name;
    private String description;
    private String imageUrl;
    private List<PreparationStep> preparationSteps;
    private List<FoodCategory> categories;
    private FoodOrigin origin;
    private int difficulty;

    public Recipe(JsonObject object) {

        this.name = object.getString("name");
        this.description = object.getString("description");
        this.origin = object.getJsonObject("origin").mapTo(FoodOrigin.class);

        this.categories = object.getJsonArray("categories").stream().map((obj) -> {
            return ((JsonObject)obj).mapTo(FoodCategory.class);
        }).collect(Collectors.toList());

        this.preparationSteps = object.getJsonArray("preparationSteps").stream().map((obj) -> {
            return ((JsonObject)obj).mapTo(PreparationStep.class);
        }).collect(Collectors.toList());
        this.imageUrl = object.getString("imageUrl");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FoodCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<FoodCategory> categories) {
        this.categories = categories;
    }

    public FoodOrigin getOrigin() {
        return origin;
    }

    public void setOrigin(FoodOrigin origin) {
        this.origin = origin;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PreparationStep> getPreparationSteps() {
        return preparationSteps;
    }

    public void setPreparationSteps(List<PreparationStep> preparationSteps) {
        this.preparationSteps = preparationSteps;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public JsonObject toJson(){
        return JsonObject.mapFrom(this);
    }

}

// Class for instantiating the Recipe-data containing object

package edu.calvin.cs262.hp46;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class DataModel {

    // Initiate variables
    private long id;
    private int image;
    private String recipe_name;
    private String url;
    private JSONArray ingredient;

    // Constructor for DataModel object
    // Contains ID, recipe name, image URL, URL link for recipe, and Ingredient object
    public DataModel(int id, String recipe, int image, String url, JSONArray ingredient) {
        this.setId(id);
        this.setRecipe_name(recipe);
        this.setImage(image);
        this.setUrl(url);
        this.setIngredient(ingredient);
    }

    // setter & getter for recipe image
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    // setter & getter for recipe ID
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // setter & getter for recipe name
    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    // setter & getter for recipe URI link provided by API
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // setter and getter for ingredient object
    public JSONArray getIngredient() {
        return ingredient;
    }

    public void setIngredient(JSONArray ingredient) {
        this.ingredient = ingredient;
    }
}
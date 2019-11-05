package edu.calvin.cs262.hp46;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ChildDataModel {

    private long id;
    private int image;
    private String title;
    private String uri;
    private List<Ingredient> ingredient;


    public ChildDataModel(int id, String recipe, int image, String uri, List<Ingredient> ingredient) {
        this.setId(id);
        this.setTitle(recipe);
        this.setImage(image);
        this.setUri(uri);
        this.setIngredient(ingredient);
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() { return uri; }

    public void setUri( String uri) { this.uri = uri; }

    public List<Ingredient> getIngredient() { return new ArrayList<>(ingredient); };

    public void setIngredient (List<Ingredient> ingredient) { this.ingredient = ingredient; };

    @Override
    public String toString() {
        Log.d("response ","ID: "+getId()+" Title: "+getTitle()+" URI: "+getUri());
        return super.toString();
    }
}
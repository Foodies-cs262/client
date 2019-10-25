package edu.calvin.cs262.hp46;

import android.util.Log;

import java.lang.reflect.Array;

public class ChildDataModel {

    long id;
    int image;
    String title;
    String uri;
    // Array ingredient; - may be used for the incorporating ingredient to the recipe

    public ChildDataModel(int id, String country, int image, String uri) {
        this.setId(id);
        this.setTitle(country);
        this.setImage(image);
        this.setUri(uri);
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

    @Override
    public String toString() {
        Log.d("response ","ID: "+getId()+" Title: "+getTitle()+" URI: "+getUri());
        return super.toString();
    }
}

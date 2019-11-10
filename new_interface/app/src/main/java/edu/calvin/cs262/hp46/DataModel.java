package edu.calvin.cs262.hp46;


//public class DataModel {
//
//    String name;
//    String type;
//    String version_number;
//    String feature;
//
//    public DataModel(String name, String type, String version_number, String feature ) {
//        this.name=name;
//        this.type=type;
//        this.version_number=version_number;
//        this.feature=feature;
//
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public String getVersion_number() {
//        return version_number;
//    }
//
//    public String getFeature() {
//        return feature;
//    }
//
//}

import java.util.ArrayList;
import java.util.List;

public class DataModel {

    private long id;
    private int image;
    private String title;
    private String uri;
    private List<Ingredient> ingredient;


    public DataModel(int id, String recipe, int image, String uri, List<Ingredient> ingredient) {
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

    public String getUri() {
        return uri;
    }
    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<Ingredient> getIngredient() {
        return new ArrayList<>(ingredient);
    }
    public void setIngredient(List<Ingredient> ingredient) {
        this.ingredient = ingredient;
    }
}
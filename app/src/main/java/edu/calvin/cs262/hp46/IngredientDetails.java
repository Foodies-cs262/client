package edu.calvin.cs262.hp46;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IngredientDetails {

    //return number of ingredients in specified array
    public static int getNumIngredients(JSONArray ingredients){
        return ingredients.length();
    }

    public static int getIngredientID(JSONArray ingredients, int index){
        try {
            return ingredients.getJSONObject(index).getInt("id");
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getIngredientName(JSONArray ingredients, int index){
        try {
            return ingredients.getJSONObject(index).getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getIngredientAmount(JSONArray ingredients, int index){
        try {
            return ingredients.getJSONObject(index).getInt("amount") ;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getIngredientUnit(JSONArray ingredients, int index){
        try {
            return ingredients.getJSONObject(index).getString("unit");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

}

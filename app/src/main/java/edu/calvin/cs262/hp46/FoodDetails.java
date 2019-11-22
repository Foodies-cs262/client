package edu.calvin.cs262.hp46;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FoodDetails {

    /**********************************************************************************************************************
     * functions for operating on json object returned from getRandomRecipe()
     ***********************************************************************************************************************/

    //get recipe id, this is used if operating on an object returned from the getRandomRecipe() function
    public static int getIDRand(JSONObject foodObject, int index) {
        try {
            return foodObject.getJSONArray("recipes").getJSONObject(index).getInt("id");
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //get recipe title, this is used if operating on an object returned from the getRandomRecipe() function
    public static String getTitleRand(JSONObject foodObject, int index) {
        try {
            return foodObject.getJSONArray("recipes").getJSONObject(index).getString("title");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    //get recipe source url, this is used if operating on an object returned from the getRandomRecipe() function
    public static String getSourceUrlRand(JSONObject foodObject, int index) {
        try {
            return foodObject.getJSONArray("recipes").getJSONObject(index).getString("sourceUrl");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    //get recipe image, this is used if operating on an object returned from the getRandomRecipe() function
    public static String getImageRand(JSONObject foodObject, int index) {
        try {
            return foodObject.getJSONArray("recipes").getJSONObject(index).getString("image");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    //get ingredients, this is used if operating on an object returned from the getRandomRecipe() function
    public static JSONArray getIngredientsRand(JSONObject foodObject, int index) {
        try {
            return foodObject.getJSONArray("recipes").getJSONObject(index).getJSONArray("extendedIngredients");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**********************************************************************************************************************
     * functions for operating on json object returned from searchRecipe()
     ***********************************************************************************************************************/

    //get recipe id, this is used if operating on an object returned from the searchRecipe() function
    public static int getIDSearch(JSONObject foodObject, int index) {
        try {
            return foodObject.getJSONArray("results").getJSONObject(index).getInt("id");
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //get recipe title, this is used if operating on an object returned from the searchRecipe() function
    public static String getTitleSearch(JSONObject foodObject, int index) {
        try {
            return foodObject.getJSONArray("results").getJSONObject(index).getString("title");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    //get recipe image, this is used if operating on an object returned from the searchRecipe() function
    public static String getImageSearch(JSONObject foodObject, int index) {
        try {
            //combine the base url and the image url
            return foodObject.getString("baseUri") + foodObject.getJSONArray("results").getJSONObject(index).getString("image");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**********************************************************************************************************************
     * functions for operating on json object returned from getRecipeInfo()
     ***********************************************************************************************************************/

    //get recipe id, this is used if operating on an object returned from the getRecipeInfo() function
    public static int getIDInfo(JSONObject foodObject) {
        try {
            return foodObject.getInt("id");
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //get recipe title, this is used if operating on an object returned from the getRecipeInfo() function
    public static String getTitleInfo(JSONObject foodObject) {
        try {
            return foodObject.getString("title");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    //get recipe source url, this is used if operating on an object returned from the getRecipeInfo() function
    public static String getSourceUrlInfo(JSONObject foodObject) {
        try {
            return foodObject.getString("sourceUrl");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    //get recipe image, this is used if operating on an object returned from the getRecipeInfo() function
    public static String getImageInfo(JSONObject foodObject) {
        try {
            return foodObject.getString("image");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    //get recipe image, this is used if operating on an object returned from the getRecipeInfo() function
    public static JSONArray getIngredientsInfo(JSONObject foodObject) {
        try {
            return foodObject.getJSONArray("extendedIngredients");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
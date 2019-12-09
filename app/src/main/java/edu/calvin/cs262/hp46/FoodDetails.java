package edu.calvin.cs262.hp46;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.Random;

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

    //getTags rand takes the JSONObject, the index of the desired recipe, and the maxNumber of tags you want returned
    //Note: size may vary recipe to recipe. For example, given a max of 3 you could get a list of 0 or 1 or 2 or 3
    public static List<String> getTagsRand(JSONObject foodObject, int index, int maxNumTags) throws JSONException {
        List<String> tagsList = new ArrayList<String>();
        JSONObject myObject = foodObject.getJSONArray("recipes").getJSONObject(index);
        Iterator<String> keys = myObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            try {
                if ( myObject.getString(key) == "true"){
                    tagsList.add(key);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
       return randomizeTags(tagsList, maxNumTags);
    }

    //function randomly indexes into tagsList and puts those values into another list a maxNumTags number of times or less
    //helper function for getTagsRand()
    public static List<String> randomizeTags(List<String> tagsList, int maxNumTags){
        List<String> randomTagsList = new ArrayList<String>();
        Random rand = new Random();
        int count = 0;
        while (tagsList.size() > 0 && count < maxNumTags){
            int randInt = rand.nextInt(tagsList.size());
            randomTagsList.add(count, tagsList.get(randInt));
            tagsList.remove(randInt);
            count++;
        }
        return randomTagsList;
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
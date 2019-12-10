package edu.calvin.cs262.hp46;

import android.util.Log;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;


public class NetworkUtils {

    /**getSourceCode() handles which function to choose based off of query types
    * Valid query types are getRandomRecipe, searchRecipe, and getRecipeInfo
    * If query type is getRecipeInfo, int i serves as the id. If one of the other two query types,
    *     int i is the number of recipes you want returned.
    * What the content of String request is only matters if queryType equals searchRecipe.
    *     Example for searchRecipe request: "steak". Example for other 2: "" - does not matter
    */
    static JSONObject getFood(String queryType, int i, String request) throws UnirestException {
        try {
            if (queryType.equals("getRandomRecipe")) {    //if wanting a random number of recipes
                return getRandomRecipe(i);
                //example of how one would access the contents of the recipe ingredients. See Spoonacular api for further documentation
                //return getRandomRecipe(numRecipesReturned).getJSONArray("recipes").getJSONObject(0).getJSONArray("extendedIngredients").getJSONObject(0).getString("name");
            } if (queryType.equals("searchRecipe")) {    //if searching for exact recipe
                return searchRecipe(i, request);
            } if (queryType.equals("getRecipeInfo")) {    //getting more recipe info, needed for searchRecipe
                return getRecipeInfo(i);
                //example of how one would access the contents of the recipe ingredients. See Spoonacular api for further documentation
                // return getRecipeInfo(479101).getJSONArray("extendedIngredients").getJSONObject(0).getString("name");
            } else {
                return null;
            }

        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    //returns a json object of numRecipes recipes
    public static JSONObject getRandomRecipe(int numRecipes) throws UnirestException {

        String numberString = String.valueOf(numRecipes);
        HttpResponse<JsonNode> response;
        response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/random?number=" + numberString)
                .header("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                .header("X-RapidAPI-Key", "Fill In")
                .asJson();
        return response.getBody().getObject();
    }

    //returns json object of numRecipes recipes related to the query entered
    public static JSONObject searchRecipe(int numRecipes, String query) throws UnirestException {
        String numberString = String.valueOf(numRecipes);
        HttpResponse<JsonNode> response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/search?number=" + numberString + "&query=" + query)
                .header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "Fill In")
                .asJson();
        return response.getBody().getObject();
    }

    //returns a json object of one recipe correlated to the id entered
    public static JSONObject getRecipeInfo(int id) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/" + id + "/information")
                .header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "Fill In")
                .asJson();
        return response.getBody().getObject();
    }
}


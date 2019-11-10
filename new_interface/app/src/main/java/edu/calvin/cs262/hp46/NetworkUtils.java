package edu.calvin.cs262.hp46;

import android.content.Context;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;
import org.json.JSONObject;


public class NetworkUtils {

    static String getSourceCode(Context context, String queryString) throws UnirestException {
        String chosenQueryType = "searchRecipe";
        String queryRand = "gerRandomRecipe";
        String querySearch = "searchRecipe";
        int numRecipesReturned = 1;
        try {
            if (chosenQueryType.equals(queryRand)){    //if wanting a random number of recipes
                return getRandomRecipe(numRecipesReturned).getJSONArray("recipes").getJSONObject(0).getString("title");
            }
            if (chosenQueryType.equals(querySearch)){    //if searching for exact recipe
                return searchRecipe(1, "pancakes ").getJSONArray("results").getJSONObject(0).getString("title");
            }
            else{
                return null;
            }

        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject getRandomRecipe(int numRecipes) throws UnirestException {
        String numberString = String.valueOf(numRecipes);
        HttpResponse<JsonNode> response;
        response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/random?number=" + numberString)
                .header("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                .header("X-RapidAPI-Key", "YOUR API KEY")
                .asJson();
        return response.getBody().getObject();
    }

    public static JSONObject searchRecipe(int numRecipes, String query) throws UnirestException {
        String numberString = String.valueOf(numRecipes);
        HttpResponse<JsonNode> response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/search?number=" + numberString + "&query=" + query)
                .header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "YOUR API KEY")
                .asJson();
        return response.getBody().getObject();
    }
}


package edu.calvin.cs262.hp46;

import android.content.Context;
import android.util.Log;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;


public class NetworkUtils {

    static String getRecipes(Context context, String queryString){
        HttpURLConnection httpURLConnection = null;
        BufferedReader bufferedReader = null;
        String htmlRecipes = null;
        // String[] protocol = context.getResources().getStringArray(R.array.http_array);

        try{
            /*
            //Uri builder;
                // https
                Uri.Builder builder = new Uri.Builder();
                //builder = Uri.parse(queryString).buildUpon()
                         builder.scheme("https")
                        .authority("spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                        .appendPath("/recipes/findByIngredients")
                        .appendQueryParameter("fillIngredients","false")
                        .appendQueryParameter("ingredients","tomato")
                        .appendQueryParameter("limitLicense","false")
                        .appendQueryParameter("number","5")
                        .appendQueryParameter("ranking","1")
                        .build();*/
            //this just returns 2 random recipes, I'm keeping it low for now so we don't waste our uses
            URL requestURL = new URL("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/random?number=2");

            //open up the connection
            httpURLConnection = (HttpURLConnection) requestURL.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com");
            httpURLConnection.setRequestProperty("x-rapidapi-key", "157988faa0mshc85633e27821365p1fd0a4jsn0b0e96477e8f");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();


            //convert InputStream type to String type
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line = bufferedReader.readLine())!= null){
                stringBuilder.append(line);
                // stringBuilder.append("\n");
            }
            if (stringBuilder.length() == 0){
                return null;
            }
            htmlRecipes = stringBuilder.toString();


            //convert to json
            Gson gson = new Gson();
            JsonElement element = gson.fromJson (htmlRecipes, JsonElement.class);
            JsonObject jsonObject = element.getAsJsonObject();

        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (httpURLConnection != null){
                httpURLConnection.disconnect();
            }
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return htmlRecipes;
    }
}
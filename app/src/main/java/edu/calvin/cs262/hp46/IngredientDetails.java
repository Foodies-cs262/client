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

    //deals with any spelling changes between ingredients, returns string unit
    public static String getCommonUnit(String unit){
        String lowerUnit = unit.toLowerCase();
        if (unit == "t" || lowerUnit == "teaspoon" || lowerUnit == "teaspoons" || lowerUnit == "tsp"){
            return "teaspoon(s)";
        }
        else if (unit == "T" || lowerUnit == "tablespoon" || lowerUnit == "tablespoons" || lowerUnit == "tbsp" || lowerUnit == "tbl" || lowerUnit == "tbs"){
            return "tablespoon(s)";
        }
        else if (lowerUnit == "fl.oz" || lowerUnit == "oz" || lowerUnit == "fluid ounce"){
            return "oz(s)";
        }
        else if (lowerUnit == "c" || lowerUnit == "cup" || lowerUnit == "cups" ){
            return "cup(s)";
        }
        else if (lowerUnit == "pint" || lowerUnit == "pints" || lowerUnit == "pt"){
            return "pint(s)";
        }
        else if (lowerUnit == "quart" || lowerUnit == "quarts" || lowerUnit == "q" || lowerUnit == "qt" || lowerUnit == "fl qt"){
            return "quart(s)";
        }
        else if (lowerUnit == "gallon" || lowerUnit == "g" || lowerUnit == "gal"){
            return "gallon(s)";
        }
        else if (lowerUnit == "liter" || lowerUnit == "litre" || lowerUnit == "l" ){
            return "liter(s)";
        }
        else if (lowerUnit == "milliliter" || lowerUnit == "millilitre" || lowerUnit == "cc" || lowerUnit == "ml"){
            return "milliliter(s)";
        }
        else if (lowerUnit == "pound" || lowerUnit == "lb" || lowerUnit == "#"){
            return "pound(s)";
        }
        else if (lowerUnit == "mg" || lowerUnit == "milligram" || lowerUnit == "milligramme"){
            return "milligram(s)";
        }
        else if (lowerUnit == "gram" || lowerUnit == "gramme" || lowerUnit == "g"){
            return "gram(s)";
        }
        else if (lowerUnit == "kg" || lowerUnit == "kilogram" || lowerUnit == "kilogramme"){
            return "kilogram(s)";
        }
        else if (lowerUnit == "gallon" || lowerUnit == "gal"){
            return "gallon(s)";
        }
        else {
            return unit;
        }

    }

}

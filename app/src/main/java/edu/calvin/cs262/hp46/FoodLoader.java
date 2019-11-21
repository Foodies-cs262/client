package edu.calvin.cs262.hp46;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONObject;


public class FoodLoader extends AsyncTaskLoader<JSONObject> {

    private String mQueryType;
    private int mI;
    private String mRequest;


    public FoodLoader(@NonNull Context context, String queryType, int i, String request) {
        super(context);
        mQueryType = queryType;
        mI = i;
        mRequest = request;
    }

    @Nullable
    @Override
    public JSONObject loadInBackground() {
        try {
            return NetworkUtils.getFood(mQueryType, mI, mRequest);
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}

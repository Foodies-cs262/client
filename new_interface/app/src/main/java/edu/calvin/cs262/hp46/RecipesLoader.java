package edu.calvin.cs262.hp46;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;


public class RecipesLoader extends AsyncTaskLoader<String> {

    private String mQueryString;
    Context mContext;

    public RecipesLoader(@NonNull Context context, String queryString, String transferProtocol) {
        super(context);
        mContext = context;
        mQueryString = queryString;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.getRecipes(mContext, mQueryString);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}

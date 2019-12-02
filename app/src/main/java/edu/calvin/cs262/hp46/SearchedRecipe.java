package edu.calvin.cs262.hp46;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/******************************************/          //Everything needed to access the api is denoted by these surrounding brackets
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
/******************************************/

/***************************************/
public class SearchedRecipe extends AppCompatActivity implements CustomAdapter.CustomViewHolder.OnNoteLister, LoaderManager.LoaderCallbacks<JSONObject> {
    private ArrayList<DataModel> mExampleList;                                                                /***************************************/
    private ArrayList<DataModel> emptyList = new ArrayList<>();

    final private int NUMBER_OF_ITEMS = 20;
    private RecyclerView mRecyclerView;
    private CustomAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searched);

        // Create an empty recipe list to prevent null reference
        createExampleList(emptyList);
        buildRecyclerView();

        // Listen to the text change and filter the recipeList
        ImageButton searchButton = findViewById(R.id.search);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.edittext);
                text = editText.getText().toString();

                Bundle queryBundle = new Bundle();
                queryBundle.putString("queryString", text);

                getSupportLoaderManager().restartLoader(0, queryBundle, SearchedRecipe.this);
            }
        });
        Bundle queryBundle = new Bundle();
        queryBundle.putString("queryString", "");

        /*******************************************************************/
        //start loader, loader won't start using getLoader()
        getSupportLoaderManager().initLoader(0, queryBundle, this);  //deprecated but still works
        /*******************************************************************/

        Log.i("Search", text);
    }

    /**************************************************************************************/

    @NonNull
    @Override
    public Loader<JSONObject> onCreateLoader(int i, @Nullable Bundle bundle) {
        //TODO: for the search functionality, you are going to want to use types, take advantage of the Bundle type
        //TODO: Verify if there is wifi, nice error handling
        Log.i("Search", bundle.getString("queryString"));
        return new FoodLoader(this, "searchRecipe", NUMBER_OF_ITEMS, bundle.getString("queryString"));
    }

    @Override
    public void onLoadFinished(@NonNull Loader<JSONObject> loader, JSONObject j) {
        ArrayList<DataModel> newList = new ArrayList<>();
        for(int i=0; i<NUMBER_OF_ITEMS; i++){
            newList.add(new DataModel(FoodDetails.getIDSearch(j, i),FoodDetails.getTitleSearch(j, i),R.drawable.image_needed,
                    FoodDetails.getSourceUrlRand(j, i), FoodDetails.getIngredientsRand(j, i)));
        }


        createExampleList(newList);
        buildRecyclerView();
    }

    @Override
    public void onLoaderReset(@NonNull Loader<JSONObject> loader) {
        // empty method - abstract
    }

    /**************************************************************************************/


    private void filter(String text) {
        ArrayList<DataModel> filteredList = new ArrayList<>();

        for (DataModel item : mExampleList) {
            if (item.getRecipe_name().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);
    }

    private void createExampleList(ArrayList<DataModel> newList) {
        mExampleList = newList;
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new CustomAdapter(mExampleList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    // https://www.youtube.com/watch?v=69C1ljfDvl0
    @Override
    public void onNoteClick(int position) {
        Log.i("position", Integer.toString(position));
        DataModel datamodel = mExampleList.get(position);

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(datamodel.getUrl()));
        startActivity(intent);
    }
}
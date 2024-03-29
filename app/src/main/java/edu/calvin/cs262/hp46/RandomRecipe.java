package edu.calvin.cs262.hp46;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONObject;

import java.util.ArrayList;


/******************************************/
//Everything needed to access the api is denoted by these surrounding brackets
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;


/******************************************/


public class RandomRecipe extends AppCompatActivity implements CustomAdapter.CustomViewHolder.OnNoteLister,
        CustomAdapter.CustomViewHolder.OnNoteLister2,LoaderManager.LoaderCallbacks<JSONObject> {
    private ArrayList<DataModel> mExampleList;
    private ArrayList<DataModel> emptyList = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private CustomAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FoodViewModel mWordViewModel;
    private int count = 0;
    private int count2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);


        mWordViewModel = ViewModelProviders.of(this).get(FoodViewModel.class);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.mygradient));
            toolbar.setTitleTextColor(0xFFFFFFFF);
        }

        //start loader, loader won't start using getLoader()
        getSupportLoaderManager().initLoader(0, null, this);  //deprecated but still works

        // Create an empty recipe list to prevent null reference
        createExampleList(emptyList);
        buildRecyclerView();

        // Listen to the text change and filter the recipeList
        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    @NonNull
    @Override
    public Loader<JSONObject> onCreateLoader(int i, @Nullable Bundle bundle) {
        //TODO: for the search functionality, you are going to want to use types, take advantage of the Bundle type
        //TODO: Verify if there is wifi, nice error handling
        return new FoodLoader(this, "getRandomRecipe", 20, "");
    }

    @Override
    public void onLoadFinished(@NonNull Loader<JSONObject> loader, JSONObject j) {
        ArrayList<DataModel> newList = new ArrayList<>();
        for(int i=0; i<20; i++){
            newList.add(new DataModel(FoodDetails.getIDRand(j, i),FoodDetails.getTitleRand(j, i),FoodDetails.getImageRand(j, i),
                    FoodDetails.getSourceUrlRand(j, i), FoodDetails.getIngredientsRand(j, i)));
        }

        createExampleList(newList);
        buildRecyclerView();
    }

    @Override
    public void onLoaderReset(@NonNull Loader<JSONObject> loader) {
        // empty method - abstract
    }


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
        mAdapter = new CustomAdapter(mExampleList, this, this);

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
    public void onNoteClick2(int position) {
        DataModel datamodel = mExampleList.get(position);
        Log.i("information", datamodel.getRecipe_name());

        Food food = new Food (count, datamodel.getRecipe_name());
        mWordViewModel.insert(food);

        String a;
        double b;
        String c;
        for (int i = 0; i < IngredientDetails.getNumIngredients(datamodel.getIngredient()); i++) {
            try{
                a = IngredientDetails.getIngredientName(datamodel.getIngredient(), i);
                b = IngredientDetails.getIngredientAmount(datamodel.getIngredient(), i);
                c = IngredientDetails.getIngredientUnit(datamodel.getIngredient(), i);
                Log.i("index", a);
                IngredientTable ing = new IngredientTable(count2, a, b, c);
                mWordViewModel.insert(ing);
                count2++;

            } catch(IndexOutOfBoundsException e){
                Log.i("index", "hello");
            }
        }

        count++;
    }

    // creating tabs on action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //action bar button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.navigation_home:
                Intent home = new Intent(this, MainActivity.class);
                this.startActivity(home);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}

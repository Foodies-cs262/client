package edu.calvin.cs262.hp46;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONObject;

import java.util.ArrayList;

/******************************************/          //Everything needed to access the api is denoted by these surrounding brackets
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
/******************************************/

                                                                                                              /***************************************/
public class SearchedRecipe extends AppCompatActivity implements CustomAdapter.CustomViewHolder.OnNoteLister, LoaderManager.LoaderCallbacks<JSONObject> {
    private ArrayList<DataModel> mExampleList;                                                                /***************************************/

    private RecyclerView mRecyclerView;
    private CustomAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null)
        {
            actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));
        }
        setContentView(R.layout.activity_searched);

        createExampleList();
        buildRecyclerView();

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


        /*******************************************************************/
        //start loader, loader won't start using getLoader()
        getSupportLoaderManager().initLoader(0, null, this);  //deprecated but still works
        /*******************************************************************/

    }

/**************************************************************************************/
    @NonNull
    @Override
    public Loader<JSONObject> onCreateLoader(int i, @Nullable Bundle bundle) {
        //TODO: for the search functionality, you are going to want to use types, take advantage of the Bundle type
        //TODO: Verify if there is wifi, nice error handling
        return new FoodLoader(this, "getRecipeInfo", 211419, "");
    }

    @Override
    public void onLoadFinished(@NonNull Loader<JSONObject> loader, JSONObject j) {
        /*try {
            //testing if communicating properly with API
            Log.d("here", FoodDetails.getTitleInfo(j));
            //testing if getting correct number of ingredients
            Log.d("here2",Integer.toString(   IngredientDetails.getNumIngredients( FoodDetails.getIngredientsInfo(j) )  )  );
            //testing if getting proper id of 1st ingredient
            Log.d ("here3", Integer.toString( IngredientDetails.getIngredientID( FoodDetails.getIngredientsInfo(j), 0 )) );
            //testing if getting proper name of 1st ingredient
            Log.d ("here4", IngredientDetails.getIngredientName( FoodDetails.getIngredientsInfo(j), 0 ));
            //testing if getting proper amount for first ingredient
            Log.d("here5",Integer.toString(   IngredientDetails.getIngredientAmount( FoodDetails.getIngredientsInfo(j), 0 )  )  );
            //testing if getting proper unit for first ingredient
            Log.d ("here6", IngredientDetails.getIngredientUnit( FoodDetails.getIngredientsInfo(j), 0 ));

        }
        catch (Exception e) {
            e.printStackTrace();
        }*/

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

    private void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new DataModel(1,"Pancake",R.drawable.fluffypancakes,
                "https://www.allrecipes.com/recipe/21014/good-old-fashioned-pancakes/", null));
        mExampleList.add(new DataModel(2,"Toast",R.drawable.cinnamon_french_toast,
                "https://www.allrecipes.com/recipe/7016/french-toast-i/", null));
        mExampleList.add(new DataModel(3,"Eggs & Bacon",R.drawable.eggs_bacon,
                "https://www.allrecipes.com/recipe/236040/bacon-and-egg-muffins/", null));
        mExampleList.add(new DataModel(4,"Chicken Meatballs and Spaghetti",R.drawable.image_needed,
                "https://www.allrecipes.com/recipe/189576/chicken-meatballs-and-spaghetti/?internalSource=hub%20recipe&referringContentType=Search", null));
        mExampleList.add(new DataModel(5,"Best Steak Marinade in Existence",R.drawable.image_needed,
                "https://www.allrecipes.com/recipe/143809/best-steak-marinade-in-existence/", null));
        mExampleList.add(new DataModel(6,"Little Meat Loaves",R.drawable.image_needed,
                "https://www.allrecipes.com/recipe/18798/little-meat-loaves/?internalSource=hub%20recipe&referringContentType=Search/", null));
        mExampleList.add(new DataModel(7,"Roasted Rack of Lamb",R.drawable.image_needed,
                "https://www.allrecipes.com/recipe/45641/roasted-rack-of-lambrack-of-lamb/?internalSource=hub%20recipe&referringContentType=Search/", null));
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
        DataModel datamodel = mExampleList.get(position);

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(datamodel.getUrl()));
        startActivity(intent);
    }
}

//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//import java.util.ArrayList;
//
//// Expandable ListView from http://tutorialscache.com/expandable-listview-android-tutorials/
//public class SearchedRecipe extends AppCompatActivity {
//
//    ArrayList<DataModel> dataModels;
//    ListView listView;
//    private static CustomAdapter adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_searched);
////        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
////        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
////                R.id.navigation_home, R.id.navigation_search, R.id.navigation_categories, R.id.navigation_shoppinglist)
////                .build();
////        NavController navController = Navigation.findNavController(main, R.id.nav_host_fragment);
////        NavigationUI.setupActionBarWithNavController(main, navController, appBarConfiguration);
////        NavigationUI.setupWithNavController(navView, navController);
//
//        listView=(ListView)findViewById(R.id.list);
//
//        dataModels= new ArrayList<>();
//
//        dataModels.add(new DataModel(1,"Pancake",R.drawable.fluffypancakes,
//                "https://www.allrecipes.com/recipe/21014/good-old-fashioned-pancakes/", null));
//        dataModels.add(new DataModel(2,"Toast",R.drawable.cinnamon_french_toast,
//                "https://www.allrecipes.com/recipe/7016/french-toast-i/", null));
//        dataModels.add(new DataModel(3,"Eggs & Bacon",R.drawable.eggs_bacon,
//                "https://www.allrecipes.com/recipe/236040/bacon-and-egg-muffins/", null));
//        dataModels.add(new DataModel(4,"Chicken Meatballs and Spaghetti",R.drawable.image_needed,
//                "https://www.allrecipes.com/recipe/189576/chicken-meatballs-and-spaghetti/?internalSource=hub%20recipe&referringContentType=Search", null));
//        dataModels.add(new DataModel(5,"Best Steak Marinade in Existence",R.drawable.image_needed,
//                "https://www.allrecipes.com/recipe/143809/best-steak-marinade-in-existence/", null));
//        dataModels.add(new DataModel(6,"Little Meat Loaves",R.drawable.image_needed,
//                "https://www.allrecipes.com/recipe/18798/little-meat-loaves/?internalSource=hub%20recipe&referringContentType=Search/", null));
//        dataModels.add(new DataModel(7,"Roasted Rack of Lamb",R.drawable.image_needed,
//                "https://www.allrecipes.com/recipe/45641/roasted-rack-of-lamb/?internalSource=hub%20recipe&referringContentType=Search/", null));
//
//        adapter= new CustomAdapter(dataModels,getApplicationContext());
//
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                DataModel dataModel= dataModels.get(position);
//
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                intent.setData(Uri.parse(dataModel.getUrl()));
//                startActivity(intent);
//            }
//        });
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}

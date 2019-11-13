package edu.calvin.cs262.hp46;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

// Expandable ListView from http://tutorialscache.com/expandable-listview-android-tutorials/
public class Lunch extends AppCompatActivity {

    ArrayList<DataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_search, R.id.navigation_categories, R.id.navigation_shoppinglist)
//                .build();
//        NavController navController = Navigation.findNavController(main, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(main, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);

        listView=(ListView)findViewById(R.id.list);

        dataModels= new ArrayList<>();

        dataModels.add(new DataModel(1,"Pancake",R.drawable.fluffypancakes,
                "https://www.allrecipes.com/recipe/21014/good-old-fashioned-pancakes/", null));
        dataModels.add(new DataModel(2,"Toast",R.drawable.cinnamon_french_toast,
                "https://www.allrecipes.com/recipe/7016/french-toast-i/", null));
        dataModels.add(new DataModel(3,"Eggs & Bacon",R.drawable.eggs_bacon,
                "https://www.allrecipes.com/recipe/236040/bacon-and-egg-muffins/", null));
        dataModels.add(new DataModel(4,"Chicken Meatballs and Spaghetti",R.drawable.image_needed,
                "https://www.allrecipes.com/recipe/189576/chicken-meatballs-and-spaghetti/?internalSource=hub%20recipe&referringContentType=Search", null));
        dataModels.add(new DataModel(5,"Best Steak Marinade in Existence",R.drawable.image_needed,
                "https://www.allrecipes.com/recipe/143809/best-steak-marinade-in-existence/", null));
        dataModels.add(new DataModel(6,"Little Meat Loaves",R.drawable.image_needed,
                "https://www.allrecipes.com/recipe/18798/little-meat-loaves/?internalSource=hub%20recipe&referringContentType=Search/", null));
        dataModels.add(new DataModel(7,"Roasted Rack of Lamb",R.drawable.image_needed,
                "https://www.allrecipes.com/recipe/45641/roasted-rack-of-lamb/?internalSource=hub%20recipe&referringContentType=Search/", null));

        adapter= new CustomAdapter(dataModels,getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel= dataModels.get(position);

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(dataModel.getUrl()));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package edu.calvin.cs262.hp46;

//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ExpandableListView;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.FragmentTransaction;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import edu.calvin.cs262.hp46.ui.home.HomeFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

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

//        dataModels.add(new DataModel(1,"Pancake",R.drawable.fluffypancakes,
//                "https://www.allrecipes.com/recipe/21014/good-old-fashioned-pancakes/", null));
//        dataModels.add(new DataModel(2,"Toast",R.drawable.cinnamon_french_toast,
//                "https://www.allrecipes.com/recipe/7016/french-toast-i/", null));
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
                intent.setData(Uri.parse(dataModel.getUri()));
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

//    ExpandableCustomAdapter expandableCustomAdapter;
//    ExpandableListView expandableListView;
//    List<String> headerData;
//    HashMap<String,ArrayList<ChildDataModel>> childData;
//    ChildDataModel childDataModel;
//    Context mContext;
//    ArrayList<ChildDataModel> searchedResult;
//    private int lastExpandedPosition = -1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lunch);
//
//        mContext = this;
//
//        //initializing arraylists
//        headerData = new ArrayList<>();
//        childData = new HashMap<>();
//        searchedResult = new ArrayList<>();
//
//        // link listview from activity_main.xml
//        expandableListView = findViewById(R.id.expandAbleListView);
//
//        //populating data of recipe with search keywords.
//        headerData.add("Searched");
//
//        //adding recipe to searched recipe **NEED TO ADD FOR LOOP WHEN INCORPORATING ROOM**
//
//        childDataModel = new ChildDataModel(1,"Pancake",R.drawable.fluffypancakes,
//                "https://www.allrecipes.com/recipe/21014/good-old-fashioned-pancakes/", null);
//        searchedResult.add(childDataModel);
//
//        childDataModel = new ChildDataModel(2,"Toast",R.drawable.cinnamon_french_toast,
//                "https://www.allrecipes.com/recipe/7016/french-toast-i/", null);
//        searchedResult.add(childDataModel);
//
//        childDataModel = new ChildDataModel(3,"Eggs & Bacon",R.drawable.eggs_bacon,
//                "https://www.allrecipes.com/recipe/236040/bacon-and-egg-muffins/", null);
//        searchedResult.add(childDataModel);
//
//        childData.put(headerData.get(0),searchedResult);
//
//        //set adapter to list view
//        expandableCustomAdapter = new ExpandableCustomAdapter(mContext,headerData,childData);
//        expandableListView.setAdapter(expandableCustomAdapter);
//
//        //child click listener
//        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView expandableListView, View view, int headPosition, int childPosition, long id) {
//                Toast.makeText(mContext,
//                        headerData.get(headPosition)
//                                + " has food recipe "
//                                + childData.get(
//                                headerData.get(headPosition)).get(
//                                childPosition).getTitle(), Toast.LENGTH_SHORT)
//                        .show();
//
//              // Links recipe list with appropriate URI
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                intent.setData(Uri.parse(childData.get(headerData.get(headPosition)).get(childPosition).getUri()));
//                startActivity(intent);
//
//              // WIP to send string data to the fragment home
//                HomeFragment fragmentB = new HomeFragment();
//                Bundle bundle = new Bundle();
//                bundle.putString("recipe", childData.get(headerData.get(headPosition)).get(childPosition).getTitle());
//                fragmentB.setArguments(bundle);
//                return false;
//            }
//        });
//
//        //group expanded
//        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//
//            @Override
//            public void onGroupExpand(int headPosition) {
//                if (lastExpandedPosition != -1
//                        && headPosition != lastExpandedPosition) {
//                    expandableListView.collapseGroup(lastExpandedPosition);
//                }
//                lastExpandedPosition = headPosition;
//                Toast.makeText(mContext,
//                        headerData.get(headPosition) + " continent expanded",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        //group collapsed
//        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//            @Override
//            public void onGroupCollapse(int headPosition) {
//                Toast.makeText(mContext,
//                        headerData.get(headPosition) + " continent collapsed",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        //Group Indicator
//        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//                parent.smoothScrollToPosition(groupPosition);
//
//                if (parent.isGroupExpanded(groupPosition)) {
//                    ImageView imageView = v.findViewById(R.id.expandable_icon);
//                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right));
//                } else {
//                    ImageView imageView = v.findViewById(R.id.expandable_icon);
//                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_down));
//                }
//                return false;
//            }
//        });
//    }
//}

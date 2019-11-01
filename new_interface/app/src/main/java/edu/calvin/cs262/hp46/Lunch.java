package edu.calvin.cs262.hp46;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.calvin.cs262.hp46.ui.home.HomeFragment;

// Expandable ListView from http://tutorialscache.com/expandable-listview-android-tutorials/
public class Lunch extends AppCompatActivity {

    ExpandableCustomAdapter expandableCustomAdapter;
    ExpandableListView expandableListView;
    List<String> headerData;
    HashMap<String,ArrayList<ChildDataModel>> childData;
    ChildDataModel childDataModel;
    Context mContext;
    ArrayList<ChildDataModel> westernLunch,africanCountries,nAmericanCountries,sAmericanCountries;
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        mContext = this;

        //initializing arraylists
        headerData = new ArrayList<>();
        childData = new HashMap<String,ArrayList<ChildDataModel>>();
        westernLunch = new ArrayList<>();
//        africanCountries = new ArrayList<>();
//        nAmericanCountries = new ArrayList<>();
//        sAmericanCountries = new ArrayList<>();



        // link listview from activity_main.xml
        expandableListView = findViewById(R.id.expandAbleListView);

        //populating data of world continents and their countries.
        headerData.add("Western");

        //adding countries to Asian continent
        childDataModel = new ChildDataModel(1,"Pancake",R.drawable.fluffypancakes,"https://www.allrecipes.com/recipe/21014/good-old-fashioned-pancakes/");
        westernLunch.add(childDataModel);

        childDataModel = new ChildDataModel(2,"Toast",R.drawable.cinnamon_french_toast, "https://www.allrecipes.com/recipe/7016/french-toast-i/");
        westernLunch.add(childDataModel);

        childDataModel = new ChildDataModel(3,"Eggs & Bacon",R.drawable.eggs_bacon, "https://www.allrecipes.com/recipe/236040/bacon-and-egg-muffins/");
        westernLunch.add(childDataModel);

        childData.put(headerData.get(0),westernLunch);


//        headerData.add("AFRICA");
//
//        //adding countries to African continent
//        childDataModel = new ChildDataModel(1,"South Africa",R.drawable.afghanistan);
//        africanCountries.add(childDataModel);
//
//        childDataModel = new ChildDataModel(2,"Zimbabwe",R.drawable.afghanistan);
//        childData.put(headerData.get(1),africanCountries);
//
//
//        headerData.add("NORTH AMERICA");
//        //adding countries to NORTH AMERICA continent
//        childDataModel = new ChildDataModel(1,"Canada",R.drawable.afghanistan);
//        nAmericanCountries.add(childDataModel);
//        childData.put(headerData.get(2),nAmericanCountries);
//
//
//        headerData.add("SOUTH AMERICA");
//        //adding countries to SOUTH AMERICA continent
//        childDataModel = new ChildDataModel(1,"Argentina",R.drawable.afghanistan);
//        sAmericanCountries.add(childDataModel);
//        childData.put(headerData.get(3),sAmericanCountries);



        //set adapter to list view
        expandableCustomAdapter = new ExpandableCustomAdapter(mContext,headerData,childData);
        expandableListView.setAdapter(expandableCustomAdapter);

        //child click listener
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int headPosition, int childPosition, long id) {
                Toast.makeText(mContext,
                        headerData.get(headPosition)
                                + " has food recipe "
                                + childData.get(
                                headerData.get(headPosition)).get(
                                childPosition).getTitle(), Toast.LENGTH_SHORT)
                        .show();
                // temporary placeholder until I understand how everything works better
//                Intent intentLoadActivity = new Intent (Lunch.this, Pancake.class);
//                startActivity(intentLoadActivity);

                //uses picasso, not working right now
              /*  String imageUri = "https://spoonacular.com/recipeImages/1023800-556x370.jpg";
                myImageView  = findViewById(R.id.imageView3);
                Picasso.with(this).load(imageUri).into(myImageView);


                // private void setListParentItemInfo(View convertView,final IPTVChannel iptvChannel){
                myImageButton = findViewById(R.id.image_pancake);
                String image_url="https://spoonacular.com/recipeImages/1023800-556x370.jpg";
                Picasso.with(this).load(image_url).into(myImageButton);
                */

              // Links recipe list with appropriate URI
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(childData.get(headerData.get(headPosition)).get(childPosition).getUri()));
                startActivity(intent);

                HomeFragment fragmentB = new HomeFragment();
                Bundle bundle = new Bundle();
                bundle.putString("recipe", childData.get(headerData.get(headPosition)).get(childPosition).getTitle());
                fragmentB.setArguments(bundle);
                return false;
            }
        });

        //group expanded
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int headPosition) {
                if (lastExpandedPosition != -1
                        && headPosition != lastExpandedPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = headPosition;
                Toast.makeText(mContext,
                        headerData.get(headPosition) + " continent expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //group collapsed
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int headPosition) {
                Toast.makeText(mContext,
                        headerData.get(headPosition) + " continent collapsed",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //Group Indicator
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                parent.smoothScrollToPosition(groupPosition);

                if (parent.isGroupExpanded(groupPosition)) {
                    ImageView imageView = v.findViewById(R.id.expandable_icon);
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right));
                } else {
                    ImageView imageView = v.findViewById(R.id.expandable_icon);
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_down));
                }
                return false;
            }
        });
    }
}

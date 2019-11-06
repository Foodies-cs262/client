package edu.calvin.cs262.cheferone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        childDataModel = new ChildDataModel(1,"Pancake",R.drawable.fluffypancakes);
        westernLunch.add(childDataModel);

        childDataModel = new ChildDataModel(2,"Toast",R.drawable.cinnamon_french_toast);
        westernLunch.add(childDataModel);

        childDataModel = new ChildDataModel(3,"Eggs & Bacon",R.drawable.eggs_bacon);
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
                                + " has country "
                                + childData.get(
                                headerData.get(headPosition)).get(
                                childPosition).getTitle(), Toast.LENGTH_SHORT)
                        .show();
                // temporary placeholder until I understand how everything works better
                Intent intentLoadActivity = new Intent (Lunch.this, Pancake.class);
                startActivity(intentLoadActivity);
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
                        headerData.get(headPosition) + " menu expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //group collapsed
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int headPosition) {
                Toast.makeText(mContext,
                        headerData.get(headPosition) + " menu collapsed",
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

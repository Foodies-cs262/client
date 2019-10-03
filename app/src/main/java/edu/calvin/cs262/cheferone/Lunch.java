package edu.calvin.cs262.cheferone;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import android.widget.ExpandableListAdapter;


// From http://www.androidhive.info/2013/07/android-expandable-list-view-tutorial/
public class Lunch extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        // get the listview
        expListView = findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.add("Asian");
        listDataHeader.add("Western");
        listDataHeader.add("Other");

        // Adding child data
        List<String> Asian = new ArrayList<>();
        Asian.add("Bibimbap");
        Asian.add("Pad Thai");
        Asian.add("Sushi");
        Asian.add("Ramen");
        Asian.add("Udon");
        Asian.add("Bulgogi");
        Asian.add("Kimbab");

        List<String> Western = new ArrayList<>();
        Western.add("Caesar Salad");
        Western.add("Grilled Cheese Sandwich");
        Western.add("Italian Bean Soup");
        Western.add("Slaw");
        Western.add("Chicken pot pie");
        Western.add("Casserole");

        List<String> Other = new ArrayList<>();
        Other.add("A");
        Other.add("B");
        Other.add("C");
        Other.add("D");
        Other.add("E");

        listDataChild.put(listDataHeader.get(0), Asian); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Western);
        listDataChild.put(listDataHeader.get(2), Other);
    }
}

package edu.calvin.cs262.hp46;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    ImageButton myImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_planner, R.id.navigation_shoppinglist)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

//        //when breakfast button clicked, open the breakfast activity
//        myImageButton = findViewById(R.id.image_breakfast);
//        myImageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentLoadActivity = new Intent (MainActivity.this, Breakfast.class);
//                startActivity(intentLoadActivity);
//            }
//        });
//
//        //when the dinner button is clicked, open the dinner activity
//        myImageButton = findViewById(R.id.image_dinner);
//        myImageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentLoadActivity = new Intent (MainActivity.this, Dinner.class);
//                startActivity(intentLoadActivity);
//            }
//        });
//
//        //when the dessert button is clicked, open the dessert activity
//        myImageButton = findViewById(R.id.image_dessert);
//        myImageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentLoadActivity = new Intent (MainActivity.this, Dessert.class);
//                startActivity(intentLoadActivity);
//            }
//        });
//
//        myImageButton = findViewById((R.id.image_lunch));
//
//        myImageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentLoadActivity = new Intent (MainActivity.this, Lunch.class);
//                startActivity(intentLoadActivity);
//            }
//        });

    }

}

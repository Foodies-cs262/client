package edu.calvin.cs262.hp46;

import android.os.Bundle;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
<<<<<<< HEAD:new_interface/app/src/main/java/edu/calvin/cs262/hp46/MainActivity.java

=======
>>>>>>> b8e622e4a8cf050235deca57e6f7a39ccb57629d:app/src/main/java/edu/calvin/cs262/hp46/MainActivity.java
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public String FoodName;
    ImageButton myImageButton;

    @Override
    // http://www.devcoons.com/android-bottom-navigation-menu-example-using-activities/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hide Action bar
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_categories, R.id.navigation_shoppinglist)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }


}

package edu.calvin.cs262.cheferone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton myImageButton;
    ImageButton myImageButton1;
    ImageButton myImageButton2;
    ImageButton myImageButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImageButton = findViewById(R.id.image_breakfast);
        myImageButton1 = findViewById(R.id.image_lunch);
        myImageButton2 = findViewById(R.id.image_dinner);
        myImageButton3 = findViewById(R.id.image_desert);

        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadActivity = new Intent (MainActivity.this, Breakfast.class);
                startActivity(intentLoadActivity);
            }
        });

        myImageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadActivity = new Intent (MainActivity.this, Lunch.class);
                startActivity(intentLoadActivity);
            }
        });

        myImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadActivity = new Intent (MainActivity.this, Dinner.class);
                startActivity(intentLoadActivity);
            }
        });

        myImageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadActivity = new Intent (MainActivity.this, Desert.class);
                startActivity(intentLoadActivity);
            }
        });


    }
}

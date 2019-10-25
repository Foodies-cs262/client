package edu.calvin.cs262.hp46;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;

public class Dessert  extends AppCompatActivity {
    ImageButton myImageButton;
    ImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);

        //Attempt to send data to fragement//
/*        Bundle bundle = new Bundle();
        bundle.putString("edttext", "From Activity");
    // set Fragmentclass Arguments
        HomeFragment fragobj = new HomeFragment();
        fragobj.setArguments(bundle);
*/


        myImageButton = findViewById(R.id.image_pancake);

        // on button click, url opens
        myImageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.allrecipes.com/recipe/21014/good-old-fashioned-pancakes/"));
                startActivity(intent);
            }
        });

    }
}


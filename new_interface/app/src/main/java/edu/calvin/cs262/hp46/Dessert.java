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


        //uses picasso, not working right now
      /*  String imageUri = "https://spoonacular.com/recipeImages/1023800-556x370.jpg";
        myImageView  = findViewById(R.id.imageView3);
        Picasso.with(this).load(imageUri).into(myImageView);


        // private void setListParentItemInfo(View convertView,final IPTVChannel iptvChannel){
        myImageButton = findViewById(R.id.image_pancake);
        String image_url="https://spoonacular.com/recipeImages/1023800-556x370.jpg";
        Picasso.with(this).load(image_url).into(myImageButton);
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


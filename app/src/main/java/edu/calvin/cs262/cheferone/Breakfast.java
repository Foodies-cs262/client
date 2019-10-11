package edu.calvin.cs262.cheferone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Breakfast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
    }

    public void showMenu(View view) {
        Intent intent = new Intent(this, menu_activity.class);
        startActivity(intent);
    }
}

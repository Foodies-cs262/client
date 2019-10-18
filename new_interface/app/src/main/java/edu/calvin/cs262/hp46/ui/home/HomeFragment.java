package edu.calvin.cs262.hp46.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import edu.calvin.cs262.hp46.Breakfast;

import edu.calvin.cs262.hp46.Dessert;
import edu.calvin.cs262.hp46.Dinner;
import edu.calvin.cs262.hp46.Lunch;
import edu.calvin.cs262.hp46.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    ImageButton myImageButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);

        //when breakfast button clicked, open the breakfast activity
        myImageButton = getView().findViewById(R.id.image_breakfast);
        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadActivity = new Intent (getActivity(), Breakfast.class);
                startActivity(intentLoadActivity);
            }
        });

        //when the dinner button is clicked, open the dinner activity
        myImageButton = getView().findViewById(R.id.image_dinner);
        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadActivity = new Intent (getActivity(), Dinner.class);
                startActivity(intentLoadActivity);
            }
        });

        //when the dessert button is clicked, open the dessert activity
        myImageButton = getView().findViewById(R.id.image_dessert);
        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadActivity = new Intent (getActivity(), Dessert.class);
                startActivity(intentLoadActivity);
            }
        });

        myImageButton = getView().findViewById((R.id.image_lunch));
        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadActivity = new Intent (getActivity(), Lunch.class);
                startActivity(intentLoadActivity);
            }
        });

            }
        });
        return root;




    }
}
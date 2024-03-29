package edu.calvin.cs262.hp46.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import edu.calvin.cs262.hp46.R;
import edu.calvin.cs262.hp46.RandomRecipe;
import edu.calvin.cs262.hp46.SearchedRecipe;
import edu.calvin.cs262.hp46.SharedViewModel;

public class SearchFragment extends Fragment {

    private Button button;
    private SearchViewModel searchViewModel;
    private SharedViewModel model;
    ImageButton myImageButton;
    ImageButton myImageButton2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        searchViewModel =
                ViewModelProviders.of(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);

        myImageButton = root.findViewById(R.id.random_recipe);
        myImageButton2 = root.findViewById(R.id.search);
        myImageButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intentLoadActivity = new Intent (getActivity(), RandomRecipe.class);
            startActivity(intentLoadActivity);
            }
        });
        myImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadActivity = new Intent (getActivity(), SearchedRecipe.class);
                startActivity(intentLoadActivity);
            }
        });
        return root;

    }
}

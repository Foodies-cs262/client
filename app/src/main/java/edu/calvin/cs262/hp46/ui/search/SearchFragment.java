package edu.calvin.cs262.hp46.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import edu.calvin.cs262.hp46.SearchedRecipe;
import edu.calvin.cs262.hp46.R;
import edu.calvin.cs262.hp46.SharedViewModel;

public class SearchFragment extends Fragment {

    private SearchViewModel searchViewModel;
    private SharedViewModel model;
    ImageView myView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        searchViewModel =
                ViewModelProviders.of(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        searchViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                myView = getView().findViewById(R.id.searchButton);
                myView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentLoadActivity = new Intent (getActivity(), SearchedRecipe.class);
                    startActivity(intentLoadActivity);
                    model.select("hi");

                }
            });

            }
        });
        return root;
    }
}
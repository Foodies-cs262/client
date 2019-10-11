package edu.calvin.cs262.hp46.ui.shoppinglist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import edu.calvin.cs262.hp46.R;

public class ShoppinglistFragment extends Fragment {

    private ShoppinglistViewModel shoppinglistViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shoppinglistViewModel =
                ViewModelProviders.of(this).get(ShoppinglistViewModel.class);
        View root = inflater.inflate(R.layout.fragment_shoppinglist, container, false);
        final TextView textView = root.findViewById(R.id.text_shoppinglist);
        shoppinglistViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}

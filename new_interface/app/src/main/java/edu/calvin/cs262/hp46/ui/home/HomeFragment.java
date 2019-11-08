package edu.calvin.cs262.hp46.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import edu.calvin.cs262.hp46.R;
import edu.calvin.cs262.hp46.SharedViewModel;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TextView tv;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        super.onCreate(savedInstanceState);
        SharedViewModel model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        tv = (TextView)getView().findViewById(R.id.list_result);
        model.getSelected().observe(this,  item -> {tv.setText("hi")        });


        /*
            String strtext = getArguments().getString("edttext");
    return inflater.inflate(R.layout.fragment, container, false);
<<<<<<< HEAD
         */

//        LayoutInflater lf = getActivity().getLayoutInflater();
//        View view =  lf.inflate(R.layout.fragment_home, container, false);
//
//        TextView mTextView = (TextView) getView().findViewById(R.id.list_result);
//        mTextView.setText(getArguments().getString("recipe"));

        return root;
    }

}
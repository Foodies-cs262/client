package edu.calvin.cs262.hp46.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import org.w3c.dom.Text;

import edu.calvin.cs262.hp46.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        /*
            String strtext = getArguments().getString("edttext");
    return inflater.inflate(R.layout.fragment, container, false);
         */

        LayoutInflater lf = getActivity().getLayoutInflater();
        View view =  lf.inflate(R.layout.fragment_home, container, false);

        TextView mTextView = (TextView) getView().findViewById(R.id.list_result);
        mTextView.setText(getArguments().getString("recipe"));

        return root;
    }
}
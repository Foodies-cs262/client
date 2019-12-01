/* NOTE!!
Fragment used for hard coding home page - Will be replaced with other functionality or be removed
completely when deemed unnecessary
*/

package edu.calvin.cs262.hp46.ui.planner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import edu.calvin.cs262.hp46.R;

public class CategoriesFragment extends Fragment {

    private CategoriesViewModel categoriesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        categoriesViewModel =
                ViewModelProviders.of(this).get(CategoriesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_categories, container, false);

//        categoriesViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//
//                //when breakfast button clicked, open the breakfast activity
//                myImageButton = getView().findViewById(R.id.image_breakfast);
//                myImageButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent intentLoadActivity = new Intent (getActivity(), Breakfast.class);
//                        startActivity(intentLoadActivity);
//                    }
//                });
//
//
//                myImageButton = getView().findViewById((R.id.image_lunch));
//                myImageButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent intentLoadActivity = new Intent (getActivity(), RandomRecipe.class);
//                        startActivity(intentLoadActivity);
//                    }
//                });
//
//            }
//        });

        return root;
    }
}
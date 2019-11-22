package edu.calvin.cs262.hp46.ui.shoppinglist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShoppinglistViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ShoppinglistViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the Shoppinglist fragment");
    }

    public LiveData<String> getText() {return mText;}

}

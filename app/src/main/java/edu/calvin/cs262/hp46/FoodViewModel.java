package edu.calvin.cs262.hp46;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class FoodViewModel extends AndroidViewModel {

    private FoodRepo mRepository;

    private LiveData<List<Food>> mAllFood;

    public FoodViewModel (Application application) {
        super(application);
        mRepository = new FoodRepo(application);
        mAllFood = mRepository.getAllFood();
    }

    LiveData<List<Food>> getAllFood() { return mAllFood; }

    public void insert(Food food) { mRepository.insert(food); }
}
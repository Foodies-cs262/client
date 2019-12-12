package edu.calvin.cs262.hp46;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class FoodViewModel extends AndroidViewModel {

    private FoodRepo mRepository;

    private LiveData<List<Food>> mAllFood;
    private LiveData<List<IngredientTable>> mAllIngredient;
    private LiveData<List<FoodIngredient>> mAll;


    public FoodViewModel (Application application) {
        super(application);
        mRepository = new FoodRepo(application);
        mAllFood = mRepository.getAllFood();
        mAllIngredient = mRepository.getAllIngredient();
        mAll = mRepository.getAllQuantity();
    }

//    public void setIngredient(){
//        mAllIngredient = mRepository.getAllIngredient();
//    }
//
//    public void setQ(){
//        mAll = mRepository.getallQ();
//    }

    public LiveData<List<Food>> getAllFood() { return mAllFood; }

    public LiveData<List<IngredientTable>> getAllIngredient() { return mAllIngredient; }
//
//    public LiveData<List<IngredientTable>> getAllQuanttity2() { return mallQuantity;}

    public LiveData<List<FoodIngredient>> getAllQuantity() { return mAll; }

    public void insert(Food food) { mRepository.insert(food); }

    public void insert(IngredientTable ingredientTable) { mRepository.insert(ingredientTable); }

    public void deleteIngredientTable( IngredientTable ingredientTable){ mRepository.deleteIngredientTable(ingredientTable);}

//    public void updateParam(String name, double amount){mRepository.updateParam(name, amount);}
//
//    public void getmyName1(String name){ mRepository.getmyName1(name); }


}
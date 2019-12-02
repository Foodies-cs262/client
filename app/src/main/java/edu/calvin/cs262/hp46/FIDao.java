package edu.calvin.cs262.hp46;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FIDao {

    @Insert
    void insert(FoodIngredient FI);

    @Insert
    void insert(Food food);

    @Insert
    void insert(IngredientTable ingr);


    @Query("DELETE FROM ingredient_table")
    void deleteIngredient();

    @Query("SELECT * from ingredient_table ORDER BY name ASC")
    LiveData<List<IngredientTable>> getAllIG();

    @Query("DELETE FROM food_table")
    void deleteFood();

    @Query("SELECT * from food_table ORDER BY name ASC")
    LiveData<List<Food>> getAllFood();

    @Query("DELETE FROM FOODINGREDIENT_TABLE")
    void deleteFI();

    @Query("SELECT * from FOODINGREDIENT_TABLE ORDER BY FoodID ASC")
    LiveData<List<FoodIngredient>> getAll();

}
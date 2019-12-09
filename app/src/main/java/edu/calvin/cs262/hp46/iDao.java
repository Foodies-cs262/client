package edu.calvin.cs262.hp46;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface iDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert( IngredientTable ingredientTable);

    @Query("DELETE FROM Ingredient_table")
    void deleteAllIngredient();

    @Query("SELECT * from ingredient_table ORDER BY Name ASC")
    LiveData<List<IngredientTable>> getAllIngredient();
}
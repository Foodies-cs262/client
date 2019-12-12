package edu.calvin.cs262.hp46;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


/**
 * @author Hamin Hong
 * iDao is Dao for ingredient table
 * */
@Dao
public interface iDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert( IngredientTable ingredientTable);

    @Query("DELETE FROM Ingredient_table")
    void deleteAllIngredient();

    @Query("SELECT * from ingredient_table ORDER BY Name ASC")
    LiveData<List<IngredientTable>> getAllIngredient();

    @Delete
    void deleteIngredientTable(IngredientTable ingredientTable);

    @Query("UPDATE Ingredient_table SET Quantity = :q WHERE Name = :n")
    void updateQuantity(String n, double q);

    @Query("SELECT Name from ingredient_table WHERE Name = :n")
    String getMyName(String n);

}
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
 * fDao is Dao for the FoodIngredient table
 * */
@Dao
public interface fiDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert( FoodIngredient foodIngredient);

    @Query("DELETE FROM Food_table")
    void deleteFoodIngredient();

    @Delete
    void deleteFoodIngredient (FoodIngredient foodIngredient);

    @Query("SELECT * from foodIngredient_table " +
            "ORDER BY iID ASC")
    LiveData<List<FoodIngredient>> getAllQuantity();
}
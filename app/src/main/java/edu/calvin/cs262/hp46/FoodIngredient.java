package edu.calvin.cs262.hp46;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


/**
 * @author Hamin Hong
 * FoodIngredient is the ingredient table for the databse
 * */
@Entity(tableName = "FoodIngredient_table")
public class FoodIngredient {

    @PrimaryKey
    @ColumnInfo(name = "fiID")
    private int fiID;

    @ColumnInfo(name = "fID")
    private int FoodID;

    @ColumnInfo(name = "iID")
    private int IngredientID;

    @ColumnInfo(name = "quantity")
    private double Quantity;

    public FoodIngredient(@NonNull int fiID, int FoodID, int IngredientID, double Quantity) {
        this.fiID = fiID;
        this.FoodID = FoodID;
        this.IngredientID = IngredientID;
        this.Quantity = Quantity;
    }

    public int getFiID() { return this.fiID;}

    public int getFoodID() {
        return this.FoodID;
    }

    public int getIngredientID() {
        return this.IngredientID;
    }

    public double getQuantity() {
        return this.Quantity;
    }

}
package edu.calvin.cs262.hp46;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "FoodIngredient_table")
public class FoodIngredient {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ID")
    private int uniqueID;

    @ColumnInfo(name = "IngredientID")
    private int IngredientID;

    @ColumnInfo(name = "FoodID")
    private int FoodID;

    @ColumnInfo(name = "Name")
    private double quantity;

    public FoodIngredient(@NonNull int uID, int foodId, int inqId, double quan) {
        this.uniqueID = uID;
        this.FoodID = foodId;
        this.IngredientID = inqId;
        this.quantity = quan;
    }

    public int getUID(){ return this.uniqueID;}

    public int getFoodID() {
        return this.FoodID;
    }

    public int getIngredientID() {
        return this.IngredientID;
    }

    public double getQuantity() {
        return this.quantity;
    }

}
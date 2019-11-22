package edu.calvin.cs262.hp46;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(primaryKeys = {"FoodID", "IngredientID"})
public class FoodIngredient {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ID")
    private int FoodID;
    private int IngredientID;

    @ColumnInfo(name = "Name")
    private double quantity;

    public FoodIngredient(@NonNull int foodId, int inqId, double quan) {
        this.FoodID = foodId;
        this.IngredientID = inqId;
        this.quantity = quan;
    }

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
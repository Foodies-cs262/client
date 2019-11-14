package edu.calvin.cs262.hp46;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(primaryKeys = {"FoodID", "IngredientID"})
public class Food_Ingredient {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ID")
    private int FoodID;
    private int IngredientID;

    @ColumnInfo(name = "Name")
    private double quantity;

    public Food_Ingredient(@NonNull int Fid, int Iid, double q) {
        this.FoodID = Fid;
        this.IngredientID = Iid;
        this.quantity = q;
    }

    public int getFoodID(){return this.FoodID;}
    public int getIngredientID(){return this.IngredientID;}
    public double getQuantity(){return this.quantity;}

}
package com.nehad.android.bakingapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;


public class Ingredient implements Parcelable {

    private double quantity;
    private String measure;
    private String ingredient;

    private final Map<String, String>    measuresFormat  = new HashMap<String, String>(){{
        put("CUP", "cup");
        put("TBLSP", "tbsp");
        put("TSP", "tsp");
        put("K", "kg");
        put("G", "g");
        put("OZ", "oz");
        put("UNIT", "");
    }};

    public Ingredient() {}

    private Ingredient(Parcel in) {
        setQuantity(in.readDouble());
        setMeasure(in.readString());
        setIngredient(in.readString());
    }

    public static final Parcelable.Creator<Ingredient> CREATOR = new Parcelable.Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel source) {

            return new Ingredient(source);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };

    public double getQuantity() {

        return quantity;
    }

    private void setQuantity(double quantity)
    {
        this.quantity = quantity;
    }

    public String getMeasure() {

        return measure;
    }

    private void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getIngredient() {

        return ingredient;
    }

    private void setIngredient(String ingredient) {

        this.ingredient = ingredient;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(quantity);
        dest.writeString(measure);
        dest.writeString(ingredient);
    }

    private String getFormattedQuantity() {
        return String.format("%." + (quantity % 1 == 0 ? "0" : "1") + "f", quantity);
    }

    private String  getMeasuresFormat () {
        String m = measuresFormat.get(measure);
        if (m == null) m = measure;
        return m;
    }

    private String getIngredientFormat() {
        return ingredient.substring(0, 1).toUpperCase() + ingredient.substring(1);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(getFormattedQuantity())
                .append(" ")
                .append(getMeasuresFormat())
                .append(" ")
                .append(getIngredientFormat())
                .toString();
    }
}

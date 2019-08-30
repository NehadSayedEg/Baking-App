package com.nehad.android.bakingapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Recipe implements Parcelable {

    private int id;
    private String name;
    private List<Ingredient> ingredients;
    private List<Step> steps;
    private int servings;
    private String image;

    public Recipe() {}

    private Recipe(Parcel in) {
        setId(in.readInt());
        setName(in.readString());
        ingredients = new ArrayList<>();
        in.readTypedList(ingredients, Ingredient.CREATOR);
        steps = new ArrayList<>();
        in.readTypedList(steps, Step.CREATOR);
        setServings(in.readInt());
        setImage(in.readString());

    }

    public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel source) {

            return new Recipe(source);
        }

        @Override
        public Recipe[] newArray(int size) {

            return new Recipe[size];
        }
    };

    public int getId() {

        return id;
    }

    private void setId(int id)
    {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {

        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients)
    {
        this.ingredients = ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {

        return steps;
    }

    public void setSteps(List<Step> steps) {

        this.steps = steps;
    }

    public int getServings() {

        return servings;
    }

    private void setServings(int servings) {

        this.servings = servings;
    }

    public String getImage() {

        return image;
    }

    private void setImage(String image)
    {
        this.image = image;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeTypedList(ingredients);
        dest.writeTypedList(steps);
        dest.writeInt(servings);
        dest.writeString(image);
    }
}

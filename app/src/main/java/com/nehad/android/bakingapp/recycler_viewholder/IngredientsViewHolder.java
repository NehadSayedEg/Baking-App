package com.nehad.android.bakingapp.recycler_viewholder;

import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.nehad.android.bakingapp.R;
import com.nehad.android.bakingapp.model.Ingredient;

import java.util.List;


public class IngredientsViewHolder extends RecyclerView.ViewHolder {

    private final LinearLayout ingredientLayout;

    public IngredientsViewHolder(View view) {
        super(view);
        ingredientLayout = view.findViewById(R.id.ingredientsLayout);
    }

    public void bindTo(final List<Ingredient> ingredients) {
        ingredientLayout.removeAllViews();
        for (Ingredient ingredient : ingredients) {

            AppCompatCheckBox ingredientCheckBox = new AppCompatCheckBox(itemView.getContext());

            ingredientCheckBox.setText(ingredient.toString());
            ingredientLayout.addView(ingredientCheckBox);
        }
    }
}

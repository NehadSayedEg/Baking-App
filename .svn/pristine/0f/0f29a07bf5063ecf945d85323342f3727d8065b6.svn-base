package com.nehad.android.bakingapp.recycler_viewholder;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nehad.android.bakingapp.R;
import com.nehad.android.bakingapp.Utils.RecipeUtils;
import com.nehad.android.bakingapp.model.Recipe;
import com.nehad.android.bakingapp.user_interface.ItemClickListener;
import com.squareup.picasso.Picasso;


public class RecipeViewHolder extends RecyclerView.ViewHolder {

    public final View itemView;
    private final TextView name;
    private final ImageView image;

    public RecipeViewHolder(View v) {
        super(v);
        itemView = v;
        name = v.findViewById(R.id.tv_name);
        image = v.findViewById(R.id.iv_image);
    }

    public void bindTo(final Recipe recipe, final ItemClickListener clickListener) {
        name.setText(recipe.getName());

        ViewCompat.setTransitionName(itemView, recipe.getName());

        Picasso.get()
                .load(recipe.getImage())
                .placeholder(RecipeUtils.getPlaceHolderImage())
                .into(image);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(recipe, RecipeViewHolder.this);
            }
        });
    }
}

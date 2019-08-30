package com.nehad.android.bakingapp.Utils;

import com.nehad.android.bakingapp.R;

public class RecipeUtils {

    private static final int[] placeholderImages = {
            R.drawable.cake,
            R.drawable.cake,
            R.drawable.cake,
            R.drawable.cake
    };

    private static int placeHolderImageIndex = 0;

    public static int getPlaceHolderImage() {
        placeHolderImageIndex++;
        placeHolderImageIndex %= placeholderImages.length;
        return placeholderImages[placeHolderImageIndex];
    }

}

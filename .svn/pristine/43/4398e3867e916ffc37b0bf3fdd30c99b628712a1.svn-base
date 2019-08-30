package com.nehad.android.bakingapp.network;

import android.util.Log;

import com.nehad.android.bakingapp.model.Recipe;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataHandler {

    private static final String TAG = DataHandler.class.getSimpleName();
    private static final String API_BASE_URL = "https://api.myjson.com/bins/";

    private Call<List<Recipe>> callRecipes;
    private List<Recipe> recipes;

    private final CallbackData callback;

    public DataHandler(CallbackData callback) {

        this.callback = callback;

        initializeCalls();
    }

    private void initializeCalls() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .client(client).build();
        RecipeApiService apiService = retrofit.create(RecipeApiService.class);

        callRecipes = apiService.getAllRecipes();
    }

    public void requestData() {
        Log.d(TAG, "requestData: Requesting...");
        if (!callRecipes.isExecuted()) {
            Log.d(TAG, "requestData: Enqueueing");
            callRecipes.enqueue(new Callback<List<Recipe>>() {
                @Override
                public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                    Log.d(TAG, "onResponse: Got Response: " + response.body().size());
                    recipes = response.body();
                    callback.onUpdate(recipes);
                }

                @Override
                public void onFailure(Call<List<Recipe>> call, Throwable t) {
                    Log.d(TAG, "onFailure: Failed");
                    t.printStackTrace();
                    recipes = new ArrayList<>();
                    callback.onUpdate(recipes);
                }
            });
            return;
        }
        callback.onUpdate(recipes);
    }

    public void forceRequest() {
        initializeCalls();
        requestData();
    }

    public interface  CallbackData {
        void onUpdate(List<Recipe> recipes);
    }
}

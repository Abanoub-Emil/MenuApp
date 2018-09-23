package com.champion.bero.menuapp.RetrofitWrapper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Champion on 23-Sep-18.
 */
public class RetrofitClientInstance  {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://50.87.52.41/~develps7/AutoZ/web/app_dev.php/en/api/restaurant/";


    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
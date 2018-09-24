package com.champion.bero.menuapp.RetrofitWrapper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Champion on 23-Sep-18.
 */
public class RetrofitClientInstance  {

    private static Retrofit retrofit;
    private static final String BASE_URL_EN = "http://50.87.52.41/~develps7/AutoZ/web/app_dev.php/en/api/restaurant/";
    private static final String BASE_URL_AR = "http://50.87.52.41/~develps7/AutoZ/web/app_dev.php/ar/api/restaurant/";
    private static  String BASE_URL = BASE_URL_EN;

    public static Retrofit getRetrofitInstance(boolean isEnglish) {

        if (!isEnglish){
            BASE_URL = BASE_URL_AR;
        }else {
            BASE_URL = BASE_URL_EN;
        }
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        return retrofit;
    }
}
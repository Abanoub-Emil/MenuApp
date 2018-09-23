package com.champion.bero.menuapp.RetrofitWrapper;

import com.champion.bero.menuapp.Model.APIKey;
import com.champion.bero.menuapp.Model.Data;
import com.champion.bero.menuapp.Model.MyResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Champion on 23-Sep-18.
 */
public interface API {

    @Headers("Content-Type: application/json")
    @POST("get-categories")
    Call<MyResponse> getData(@Body APIKey body);
}

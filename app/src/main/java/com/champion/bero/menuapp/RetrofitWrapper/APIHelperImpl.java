package com.champion.bero.menuapp.RetrofitWrapper;

import com.bumptech.glide.Glide;
import com.champion.bero.menuapp.Model.APIKey;
import com.champion.bero.menuapp.Model.Data;
import com.champion.bero.menuapp.Model.MyResponse;
import com.champion.bero.menuapp.UI.Welcome.Activities.WelcomeActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Champion on 24-Sep-18.
 */
public class APIHelperImpl implements APIHelper {


    @Override
    public void getData(Callback <MyResponse>callback, boolean isEnglish) {
        Call<MyResponse> call = RetrofitClientInstance.getRetrofitInstance(isEnglish)
                .create(API.class).getData(new APIKey("b07ae77b9f59af870c91662a23ac8813758b0786"));
        call.enqueue(callback);
    }

}

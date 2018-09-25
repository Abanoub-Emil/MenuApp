package com.champion.bero.menuapp.RetrofitWrapper;

import com.champion.bero.menuapp.Model.Data;
import com.champion.bero.menuapp.Model.MyResponse;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Champion on 24-Sep-18.
 */
public interface APIHelper {
    public void getData(Callback<MyResponse> callback, boolean isEnglish);



    interface OnRequestFinishedListener {
        void onSuccess(Data data);
    }

}

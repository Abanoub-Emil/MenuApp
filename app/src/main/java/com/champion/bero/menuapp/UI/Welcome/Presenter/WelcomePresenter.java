package com.champion.bero.menuapp.UI.Welcome.Presenter;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.champion.bero.menuapp.Model.APIKey;
import com.champion.bero.menuapp.Model.Data;
import com.champion.bero.menuapp.Model.MenuList;
import com.champion.bero.menuapp.Model.MyResponse;
import com.champion.bero.menuapp.Model.Restaurant;
import com.champion.bero.menuapp.RetrofitWrapper.API;
import com.champion.bero.menuapp.RetrofitWrapper.APIHelper;
import com.champion.bero.menuapp.RetrofitWrapper.APIHelperImpl;
import com.champion.bero.menuapp.RetrofitWrapper.RetrofitClientInstance;
import com.champion.bero.menuapp.UI.Welcome.Activities.WelcomeActivity;
import com.champion.bero.menuapp.UI.Welcome.Activities.WelcomeActivityInt;

import java.sql.SQLOutput;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Champion on 23-Sep-18.
 */
public class WelcomePresenter implements WelcomePresenterInt, APIHelper.OnRequestFinishedListener {

    WelcomeActivityInt welcomeActivity;
    Restaurant restaurant;
    List<MenuList> menuList;
    Data data;
    APIHelper apiHelper = new APIHelperImpl();

    public WelcomePresenter(WelcomeActivityInt welcomeActivity) {
        this.welcomeActivity = welcomeActivity;

    }

    public void requestData(boolean isEnglish) {
        try {
                        apiHelper.getData(new Callback<MyResponse>() {
                            @Override
                            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                                data = response.body().getData();
                                Bundle myBundle = new Bundle();
                                myBundle.putSerializable("data", data);
                                welcomeActivity.setBundle(myBundle);
                                welcomeActivity.setRestaurantImage(data.getRestaurant().getImage());
                                System.out.println(data.getRestaurant().getTitle());
                            }

                            @Override
                            public void onFailure(Call<MyResponse> call, Throwable t) {

                            }
                        },isEnglish);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onSuccess(Data data) {

    }


//    public ConfirmOrderFragment() {
//        // Required empty public constructor
//    }
//
//    public static ConfirmOrderFragment newInstance(Bundle extras, RideMapFragment.OverlayInteractor overlayInteractor) {
//        ConfirmOrderFragment fragment = new ConfirmOrderFragment();
//        fragment.setArguments(extras);
//        fragment.overlayInteractor = overlayInteractor;
//        return fragment;
//    }
}

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

    public void requestData() {
        try {
            Call<MyResponse> call = RetrofitClientInstance.getRetrofitInstance()
                    .create(API.class).getData(new APIKey("b07ae77b9f59af870c91662a23ac8813758b0786"));
            apiHelper.getData(call, this);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onSuccess(Data data) {
        Bundle myBundle = new Bundle();
        myBundle.putSerializable("data", data);
        welcomeActivity.setBundle(myBundle);

        welcomeActivity.setRestaurantImage(data.getRestaurant().getImage());
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

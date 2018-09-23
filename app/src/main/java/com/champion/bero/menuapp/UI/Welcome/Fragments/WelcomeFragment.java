package com.champion.bero.menuapp.UI.Welcome.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.champion.bero.menuapp.Model.APIKey;
import com.champion.bero.menuapp.Model.MyResponse;
import com.champion.bero.menuapp.Model.Restaurant;
import com.champion.bero.menuapp.R;
import com.champion.bero.menuapp.RetrofitWrapper.API;
import com.champion.bero.menuapp.RetrofitWrapper.RetrofitClientInstance;

import org.json.JSONObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment implements WelcomeFragmentInt {



    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
//        requestData();
        return view;
    }


//    private void requestData(){
//        try {
//            Call<MyResponse> call = RetrofitClientInstance.getRetrofitInstance()
//                    .create(API.class).getData(new APIKey("b07ae77b9f59af870c91662a23ac8813758b0786"));
//            call.enqueue(new Callback<MyResponse>() {
//                @Override
//                public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
//                  restaurant = response.body().getData().getRestaurant();
//                    System.out.println(restaurant.getTitle());
//                    System.out.println(restaurant.getImage());
//                }
//
//                @Override
//                public void onFailure(Call<MyResponse> call, Throwable t) {
//
//                }
//            });
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//
//    }

}

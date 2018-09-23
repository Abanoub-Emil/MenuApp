package com.champion.bero.menuapp.UI.Welcome.Activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableRow;

import com.bumptech.glide.Glide;
import com.champion.bero.menuapp.Model.APIKey;
import com.champion.bero.menuapp.Model.Data;
import com.champion.bero.menuapp.Model.MyResponse;
import com.champion.bero.menuapp.Model.Restaurant;
import com.champion.bero.menuapp.R;
import com.champion.bero.menuapp.RetrofitWrapper.API;
import com.champion.bero.menuapp.RetrofitWrapper.RetrofitClientInstance;
import com.champion.bero.menuapp.UI.Welcome.Fragments.DetailFragment;
import com.champion.bero.menuapp.UI.Welcome.Fragments.WelcomeFragment;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WelcomeActivity extends AppCompatActivity implements WelcomeActivityInt {

    LinearLayout MenuLayout;
    LinearLayout DetailsLayout;
    ImageView mainImage;
    Button mainMenu;
    Button mainLanguage;
    Restaurant restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        requestData();
        MenuLayout = findViewById(R.id.MenuFragment);
        DetailsLayout = findViewById(R.id.DetailsFragment);
        getSupportActionBar().hide();
        mainImage = findViewById(R.id.MainImage);
        mainMenu = findViewById(R.id.MainMenu);
        mainLanguage = findViewById(R.id.MainLanguage);
        addFragment(R.id.MenuFragment, new WelcomeFragment());
        addFragment(R.id.DetailsFragment, new DetailFragment());


//        LayoutParams params = new TableRow.LayoutParams(0, LayoutParams.MATCH_PARENT, 1f);
//        MenuLayout.setLayoutParams(params);
//        LayoutParams params1 = new TableRow.LayoutParams(0, LayoutParams.MATCH_PARENT, 3f);
//        DetailsLayout.setLayoutParams(params1);
    }


    private void addFragment(int viewID, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(viewID, fragment).commit();
    }

    private void requestData() {
        try {
            Call<MyResponse> call = RetrofitClientInstance.getRetrofitInstance()
                    .create(API.class).getData(new APIKey("b07ae77b9f59af870c91662a23ac8813758b0786"));
            call.enqueue(new Callback<MyResponse>() {
                @Override
                public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                    restaurant = response.body().getData().getRestaurant();
                    System.out.println(restaurant.getTitle());
                    String url = restaurant.getImage();
                    Glide.with(WelcomeActivity.this)
                            .load(url)
                            .into(mainImage);
                }

                @Override
                public void onFailure(Call<MyResponse> call, Throwable t) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

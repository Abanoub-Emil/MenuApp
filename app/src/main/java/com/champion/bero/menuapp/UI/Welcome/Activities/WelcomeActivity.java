package com.champion.bero.menuapp.UI.Welcome.Activities;

import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.champion.bero.menuapp.Model.Item;
import com.champion.bero.menuapp.R;
import com.champion.bero.menuapp.UI.Welcome.Fragments.DetailFragment;
import com.champion.bero.menuapp.UI.Welcome.Fragments.DetailFragmentInt;
import com.champion.bero.menuapp.UI.Welcome.Fragments.MenuFragment;
import com.champion.bero.menuapp.UI.Welcome.Presenter.WelcomePresenter;
import com.champion.bero.menuapp.UI.Welcome.Presenter.WelcomePresenterInt;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity implements WelcomeActivityInt {

    ConstraintLayout menuLayout;
    LinearLayout detailsLayout;
    ImageView mainImage;
    Button mainMenu;
    Button mainLanguage;
    Bundle bundle;
    WelcomePresenterInt welcomePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomePresenter = new WelcomePresenter(this);
        welcomePresenter.requestData();
        getSupportActionBar().hide();

        menuLayout = findViewById(R.id.MainView);
        detailsLayout = findViewById(R.id.MasterDetailView);
        mainImage = findViewById(R.id.MainImage);
        mainMenu = findViewById(R.id.MainMenu);
        mainLanguage = findViewById(R.id.MainLanguage);


        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenuClicked();
            }
        });

//        LayoutParams params = new TableRow.LayoutParams(0, LayoutParams.MATCH_PARENT, 1f);
//        MenuLayout.setLayoutParams(params);
//        LayoutParams params1 = new TableRow.LayoutParams(0, LayoutParams.MATCH_PARENT, 3f);
//        DetailsLayout.setLayoutParams(params1);
    }


    private void addFragment(int viewID, Fragment fragment) {
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(viewID, fragment).commit();
    }


    private void mainMenuClicked() {

        menuLayout.setVisibility(View.GONE);
        detailsLayout.setVisibility(View.VISIBLE);
    }


    @Override
    public void setRestaurantImage(String url) {
        Glide.with(this)
                .load(url)
                .into(mainImage);
    }

    @Override
    public void setBundle(Bundle bundle) {
        this.bundle = bundle ;

        addFragment(R.id.MenuFragment, new MenuFragment());
        addFragment(R.id.DetailsFragment, new DetailFragment());
    }

    @Override
    public void sendItemsToDetailsFragment(ArrayList<Item> items) {
        DetailFragmentInt detailFragment = (DetailFragment)getSupportFragmentManager().findFragmentById(R.id.DetailsFragment);
        detailFragment.updateView(items);
    }
}

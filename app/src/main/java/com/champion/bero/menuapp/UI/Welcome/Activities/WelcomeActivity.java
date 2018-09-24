package com.champion.bero.menuapp.UI.Welcome.Activities;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    TextView welcomeToOurResturant;
    Button mainMenu;
    Button mainLanguage;
    Button english;
    Button arabic;
    Bundle bundle;
    WelcomePresenterInt welcomePresenter;
    Boolean isEnglish = true;
    Boolean isChoosing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomePresenter = new WelcomePresenter(this);
        welcomePresenter.requestData(isEnglish);
        getSupportActionBar().hide();

        welcomeToOurResturant = findViewById(R.id.MainText);
        english = findViewById(R.id.main_english);
        arabic = findViewById(R.id.main_arabic);
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

        mainLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLangButtons();
            }
        });

        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isEnglish = false;
                arabic.setTextColor(Color.RED);
                english.setTextColor(Color.WHITE);
                welcomePresenter.requestData(isEnglish);
                welcomeToOurResturant.setText("اهلا بك في مطعمنا");
            }
        });

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isEnglish = true;
                arabic.setTextColor(Color.WHITE);
                english.setTextColor(Color.RED);
                welcomePresenter.requestData(isEnglish);
                welcomeToOurResturant.setText("Welcome To Our Restaurant");
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

        changeVisibility();
        addFragment(R.id.MenuFragment, new MenuFragment());
        addFragment(R.id.DetailsFragment, new DetailFragment());
    }

    public void changeVisibility(){
        if(menuLayout.getVisibility() == View.VISIBLE){
            menuLayout.setVisibility(View.GONE);
            detailsLayout.setVisibility(View.VISIBLE);
        }else{
            menuLayout.setVisibility(View.VISIBLE);
            detailsLayout.setVisibility(View.GONE);
        }

    }
    public void showLangButtons(){
        if(!isChoosing){
            arabic.setVisibility(View.VISIBLE);
            english.setVisibility(View.VISIBLE);
            mainLanguage.setBackgroundResource(R.drawable.icon3_red);
        }else{
            arabic.setVisibility(View.INVISIBLE);
            english.setVisibility(View.INVISIBLE);
            mainLanguage.setBackgroundResource(R.drawable.icon3);
        }

        isChoosing = !isChoosing;
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

    }

    @Override
    public void sendItemsToDetailsFragment(ArrayList<Item> items, String categoryName) {
        DetailFragmentInt detailFragment = (DetailFragment)getSupportFragmentManager().findFragmentById(R.id.DetailsFragment);
        detailFragment.updateView(items, categoryName);
    }
}

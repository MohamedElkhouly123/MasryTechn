package com.nglah.masrytechn.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.view.AllDeriver.AllDriver;
import com.nglah.masrytechn.view.All_Naglas.All_Nagla;
import com.nglah.masrytechn.view.choose_place.Nagla_Location;
import com.nglah.masrytechn.view.login.LoginActivity;
import com.nglah.masrytechn.view.payment.Payment;
import com.nglah.masrytechn.view.userProfile.UserProfile;
import com.nglah.masrytechn.viewModel.ViewModelUser;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity_User extends AppCompatActivity {

    ViewModelUser viewModelUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initListener();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu, this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.All_Drivers) {
            startActivity(new Intent(this, AllDriver.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initListener() {
        viewModelUser = ViewModelProviders.of(this).get(ViewModelUser.class);
        viewModelUser.makeLogout().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    goToLogin();
                }
            }
        });

    }

    @OnClick(R.id.logout)
     void logOut() {
        viewModelUser.setLogout(this);
    }

    private void goToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }
    @OnClick(R.id.my_info)
     void goToUserProfile() {
        startActivity(new Intent(this, UserProfile.class));

    }

    @OnClick(R.id.askNagla)
    void askNaglah(){

        Intent intent=new Intent(this, Nagla_Location.class);
        startActivity(intent);


    }

    @OnClick(R.id.mybag)
     void goToPayment(){
        Intent intent=new Intent(this, Payment.class);
        intent.putExtra("type","user");
        startActivity(intent);
    }
}



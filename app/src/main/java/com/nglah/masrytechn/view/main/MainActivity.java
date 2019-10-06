package com.nglah.masrytechn.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.view.login.LoginActivity;
import com.nglah.masrytechn.view.payment.Payment;
import com.nglah.masrytechn.view.userProfile.UserProfile;
import com.nglah.masrytechn.viewModel.ViewModelUser;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

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

    private void goToUserProfile() {
        startActivity(new Intent(this, UserProfile.class));

    }

    @OnClick(R.id.mybag)
     void goToPayment(){
        startActivity(new Intent(this, Payment.class));
    }
}



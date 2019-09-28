package com.nglah.masrytechn.view.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.view.login.LoginActivity;
import com.nglah.masrytechn.view.payment.Payment;
import com.nglah.masrytechn.view.userProfile.UserProfile;
import com.nglah.masrytechn.viewModel.ViewModelUser;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    ViewModelUser viewModelUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initListener();

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

    private void logOut() {
        viewModelUser.setLogout(this);
    }

    private void goToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    private void goToUserProfile() {
        startActivity(new Intent(this, UserProfile.class));

    }

    private void goToPayment(){
        startActivity(new Intent(this, Payment.class));
    }
}



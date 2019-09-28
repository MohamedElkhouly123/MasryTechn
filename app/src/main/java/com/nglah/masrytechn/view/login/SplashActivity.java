package com.nglah.masrytechn.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.view.main.MainActivity;
import com.nglah.masrytechn.viewModel.ViewModelUser;

public class SplashActivity extends AppCompatActivity {

    ViewModelUser viewModelUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initListener();
        splashScreen();
    }
    private void splashScreen() {
        Handler handler = new Handler();
        Runnable r = new Runnable() {
            public void run() {
                viewModelUser.checkUser(getApplicationContext());
            }
        };
        handler.postDelayed(r, 2000);
    }

    private void initListener() {

        viewModelUser = ViewModelProviders.of(this).get(ViewModelUser.class);
        viewModelUser.checkUSerIfLogin().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean response) {
                if (response) {
                    goToMain();
                } else {
                    goToLogin();
                    //Error happen
                }
            }
        });
    }

    private void goToMain() {
        startActivity(new Intent(this, MainActivity.class));

    }

    private void goToLogin() {
        startActivity(new Intent(this, LoginActivity.class));

    }
}

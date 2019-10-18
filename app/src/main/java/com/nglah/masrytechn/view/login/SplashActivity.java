package com.nglah.masrytechn.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.view.main.Main2Activity_Driver;
import com.nglah.masrytechn.view.main.MainActivity_User;
import com.nglah.masrytechn.viewModel.ViewModelUser;

import static com.nglah.masrytechn.model.UserModel.loggedInUser;

public class SplashActivity extends AppCompatActivity {

    ViewModelUser viewModelUser;
    ProgressBar progressBar;
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
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);
        viewModelUser = ViewModelProviders.of(this).get(ViewModelUser.class);
        viewModelUser.checkUSerIfLogin().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean response) {
                if (response) {
                    if (loggedInUser.getUserType()==1){
                    goToMain();
                    finish();

                    }else {
                        goToMainDriver();
                        finish();
                    }
                } else {
                    goToLogin();
                    finish();
                }
            }
        });
    }

    private void goToMain() {
        startActivity(new Intent(this, MainActivity_User.class));

    }
    private void goToMainDriver() {
        startActivity(new Intent(this, Main2Activity_Driver.class));

    }

    private void goToLogin() {
        startActivity(new Intent(this, LoginActivity.class));

    }
}

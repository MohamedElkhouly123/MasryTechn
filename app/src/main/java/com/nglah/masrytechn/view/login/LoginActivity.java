package com.nglah.masrytechn.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.network.networkModel.response.User.LoginResponse;
import com.nglah.masrytechn.network.networkModel.response.User.RegisterCarOwnerResponse;
import com.nglah.masrytechn.view.Utils.CheckNetwork;
import com.nglah.masrytechn.view.Utils.Dialog.Views;
import com.nglah.masrytechn.view.forgetPassword.ForgetActivity;
import com.nglah.masrytechn.view.main.Main2Activity_Driver;
import com.nglah.masrytechn.view.main.MainActivity_User;
import com.nglah.masrytechn.view.register.RegisterActivity;
import com.nglah.masrytechn.viewModel.ViewModelUser;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username)
    EditText et_userName;
    @BindView(R.id.password)
    EditText et_password;
    @BindView(R.id.btn_next)
    Button btn_login;
    @BindView(R.id.forget)
    TextView tv_forget;
    @BindView(R.id.textView4)
    TextView tv_createAccount;
    @BindView(R.id.rb_normalUser)
    RadioButton rb_normalUser;
    @BindView(R.id.rb_carOWner)
    RadioButton rb_carOwner;
    @BindString(R.string.networkException)
    String newtworkException;
    @BindString(R.string.poorConnection)
    String poorConnection;
    @BindString(R.string.serverError)
    String serverError;
    @BindString(R.string.selectTypeOfLogin)
    String selectTypeOfLogin;
    @BindString(R.string.userNameError)
    String userNameError;
    @BindString(R.string.noUserName)
    String noUserName;
    @BindString(R.string.noPassword)
    String noPassword;
    ViewModelUser viewModel;
    Views.LoadingView loadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loadingView = new Views.LoadingView(this);
        initListener();
    }


    private void initListener() {

        viewModel = ViewModelProviders.of(this).get(ViewModelUser.class);
        viewModel.makeLogin().observe(this, new Observer<LoginResponse>() {
            @Override
            public void onChanged(LoginResponse response) {
                loadingView.dismiss();
                if (response != null) {
                    if (response.getStatus()) {
                        goToMain();
                    } else if (!response.getStatus() && response.getMessage() != null &&
                            response.getMessage().equals("Wrong User Name Or Password !!")) {

                        showToast(userNameError);

                    } else if (response.getMessage() != null && response.getMessage().equals(newtworkException)) {

                        showToast(poorConnection);

                    } else {

                        showToast(response.getMessage());

                    }
                } else {

                    showToast(serverError);
                }
            }
        });

        viewModel.makeLoginCarOwner().observe(this, new Observer<RegisterCarOwnerResponse>() {
            @Override
            public void onChanged(RegisterCarOwnerResponse response) {
                loadingView.dismiss();
                if (response != null) {
                    if (response.getStatus()) {
                        goToMainDriver();
                    } else if (!response.getStatus() &&
                            response.getMessage().equals("Wrong User Name Or Password !!")) {
                        showToast(userNameError);
                    } else {
                        showToast(serverError);
                    }

                }
            }
        });

    }

    private Boolean checkData() {
        if (TextUtils.isEmpty(et_userName.getText().toString())) {
            et_userName.setError(noUserName);
            return false;

        } else if (TextUtils.isEmpty(et_password.getText().toString())) {
            et_password.setError(noPassword);
            return false;
        } else {
            return true;
        }

    }

    @OnClick(R.id.btn_next)
    void login() {

        if (rb_normalUser.isSelected() || rb_normalUser.isChecked()) {
            if (checkData()) {
                if (new CheckNetwork(this).getConnected()) {
                    loadingView.show();
                    viewModel.loginToServer(this, et_userName.getText().toString(),
                            et_password.getText().toString());
                } else {
                    showToast(poorConnection);
                }
            }
        } else if (rb_carOwner.isSelected() || rb_carOwner.isChecked()) {
            if (checkData()) {
                if (new CheckNetwork(this).getConnected()) {
                    loadingView.show();
                    viewModel.loginCarOwnerToServer(this, et_userName.getText().toString(),
                            et_password.getText().toString());
                }
            } else {
                showToast(poorConnection);
            }
        } else {
            showToast(selectTypeOfLogin);
        }
    }


    @OnClick(R.id.textView4)
    void createAccount() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    @OnClick(R.id.forget)
    void forgetPassword() {
        startActivity(new Intent(this, ForgetActivity.class));
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void goToMain() {
        startActivity(new Intent(this, MainActivity_User.class));
        finish();
    }

    private void goToMainDriver() {
        startActivity(new Intent(this, Main2Activity_Driver.class));
        finish();
    }
}

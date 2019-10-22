package com.nglah.masrytechn.view.forgetPassword;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.network.networkModel.response.User.ForgetPasswordResponse;
import com.nglah.masrytechn.view.Utils.CheckNetwork;
import com.nglah.masrytechn.view.Utils.Dialog.Views;
import com.nglah.masrytechn.viewModel.ViewModelUser;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetActivity extends AppCompatActivity {


    @BindView(R.id.et_forgetPasswordUserName)
    EditText et_userName;
    @BindView(R.id.et_forgetPasswordEmail)
    EditText et_email;
    @BindView(R.id.rb_forgetPassword_normalUser)
    RadioButton rb_normalUser;
    @BindView(R.id.rb_forgetPassword_carOWner)
    RadioButton rb_carOwner;

    @BindString(R.string.networkException)
    String newtworkException;
    @BindString(R.string.poorConnection)
    String poorConnection;
    @BindString(R.string.serverError)
    String serverError;
    @BindString(R.string.selectTypeOfLogin)
    String selectTypeOfLogin;

    ViewModelUser viewModel;

    String typeOfUSer;
    Views.LoadingView loadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        ButterKnife.bind(this);

        loadingView = new Views.LoadingView(this);
        initListener();
    }


    @OnClick(R.id.btn_forgetPassword_send)
    void sendData() {
        if (rb_normalUser.isSelected() || rb_normalUser.isChecked()) {
            if (checkData()) {
                if (new CheckNetwork(this).getConnected()) {
                    loadingView.show();
                    typeOfUSer = "NaqlaOwner";

                    viewModel.forgetPasswordToServer(et_email.getText().toString(),
                            et_userName.getText().toString(), typeOfUSer);
                } else {
                    showToast(poorConnection);
                }
            }
        } else if (rb_carOwner.isSelected() || rb_carOwner.isChecked()) {
            if (checkData()) {
                if (new CheckNetwork(this).getConnected()) {
                    loadingView.show();
                    typeOfUSer = "CarOwner";
                    viewModel.forgetPasswordToServer(et_email.getText().toString(),
                            et_userName.getText().toString(), typeOfUSer);
                } else {
                    showToast(poorConnection);
                }
            }
        } else {
            showToast(selectTypeOfLogin);
        }

    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private Boolean checkData() {

        if (TextUtils.isEmpty(et_email.getText().toString())) {
            return false;
        } else if (TextUtils.isEmpty(et_userName.getText().toString())) {
            return false;
        }
        return true;
    }

    private void initListener() {
        viewModel = ViewModelProviders.of(this).get(ViewModelUser.class);


        viewModel.makeForgetPassword().observe(this, new Observer<ForgetPasswordResponse>() {
            @Override
            public void onChanged(ForgetPasswordResponse response) {

                loadingView.dismiss();
                if (response != null) {
                    if (response.getStatus()) {
                        showToast("Send Successful ");
                        finish();
                    } else if (response.getMessage() != null &&
                            response.getMessage().equals(newtworkException)) {
                        showToast(poorConnection);
                    } else {
                        showToast(response.getMessage());
                    }

                } else {
                    showToast(serverError);
                }

            }
        });
    }
}

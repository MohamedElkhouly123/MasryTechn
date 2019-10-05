package com.nglah.masrytechn.view.register;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.model.UserModel;
import com.nglah.masrytechn.network.networkModel.response.User.VerifyEmailResponse;

import com.nglah.masrytechn.view.Utils.Dialog.Views;
import com.nglah.masrytechn.view.drive_Profile.DriverDataModel;
import com.nglah.masrytechn.view.userProfile.EditUserProfile;
import com.nglah.masrytechn.viewModel.ViewModelUser;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.username)
    EditText et_userName;
    @BindView(R.id.password)
    EditText et_password;
    @BindView(R.id.phone)
    EditText et_phone;
    @BindView(R.id.email)
    EditText et_email;
    @BindView(R.id.btn_next_register)
    Button btn_register;
    @BindView(R.id.spinner_userType)
    Spinner sp_userType;
    @BindString(R.string.noUserName)
    String noUserName;
    @BindString(R.string.noPassword)
    String noPassword;
    @BindString(R.string.noPhone)
    String noPhone;
    @BindString(R.string.noEmail)
    String noEmail;

    int userType;

    ViewModelUser viewModel;
    UserModel model;
    Views.LoadingView dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        dialog=new Views.LoadingView(this);
        initListener();
        initSpinner();

    }

    void initSpinner() {
        sp_userType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                userType = position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private Boolean checkData() {
        if (TextUtils.isEmpty(et_userName.getText().toString())) {
            et_userName.setHint(noUserName);
            return false;
        } else if (TextUtils.isEmpty(et_password.getText().toString())) {
            et_password.setHint(noPassword);
            return false;
        } else if (TextUtils.isEmpty(et_userName.getText().toString())) {
            et_userName.setHint(noUserName);
            return false;
        } else if (TextUtils.isEmpty(et_phone.getText().toString())) {
            et_phone.setHint(noPhone);
            return false;
        } else {
            return true;
        }

    }

    private void initListener() {

        viewModel = ViewModelProviders.of(this).get(ViewModelUser.class);
        viewModel.makeVerify().observe(this, new Observer<VerifyEmailResponse>() {
            @Override
            public void onChanged(VerifyEmailResponse response) {
                dialog.dismiss();
                if (userType == 0) {//normal user
                    registerNormalUSer();
                } else if (userType == 1) {//car owner
                    registerCarOwner();
                }

            }
        });


    }

    private void registerNormalUSer() {
        Intent intent = new Intent(this, EditUserProfile.class);
        intent.putExtra("type", "register");
        intent.putExtra("model", model);
        startActivity(intent);
    }

    private void registerCarOwner() {
        Intent intent = new Intent(this, DriverDataModel.class);
        intent.putExtra("type", "register");
        intent.putExtra("model", model);
        startActivity(intent);
    }

    private void showDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.confirm_email_dialog);

        final EditText et_code = dialog.findViewById(R.id.et_confirmEmailDialog_code);
        final TextView tv_ok = dialog.findViewById(R.id.tv_confirmEmailDialog_ok);


        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(et_code.getText().toString())) {
                    viewModel.sendEmailToServer(et_email.getText().toString());
                }
                dialog.dismiss();
            }
        });


        dialog.show();
    }

    @OnClick(R.id.btn_next_register)
    void register() {
        if (checkData()) {
            model = new UserModel();
            model.setEmail(et_email.getText().toString());
            model.setPhone(et_phone.getText().toString());
            model.setUserName(et_userName.getText().toString());
            showDialog();
        }
        showDialog();
    }

}

package com.nglah.masrytechn.view.userProfile;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nglah.masrytechn.Firebase.FireBaseToken;
import com.nglah.masrytechn.R;
import com.nglah.masrytechn.network.networkModel.request.User.RegisterRequest;
import com.nglah.masrytechn.network.networkModel.request.User.UpdateUserDataRequest;
import com.nglah.masrytechn.network.networkModel.response.User.RegisterResponse;
import com.nglah.masrytechn.network.networkModel.response.User.UpdateUserDataResponse;
import com.nglah.masrytechn.view.Utils.CheckNetwork;
import com.nglah.masrytechn.view.Utils.Dialog.Views;
import com.nglah.masrytechn.view.main.MainActivity_User;
import com.nglah.masrytechn.viewModel.ViewModelUser;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.nglah.masrytechn.model.UserModel.loggedInUser;

public class EditUserProfile extends AppCompatActivity {

    @BindView(R.id.edit_first_name)
    EditText et_firstName;
    @BindView(R.id.edit_family_name)
    EditText et_familyName;
    @BindView(R.id.edit_phone)
    EditText et_phone;
    @BindView(R.id.edit_email)
    EditText et_email;
    @BindView(R.id.user_name)
    EditText et_useName;
    @BindView(R.id.edit_password)
    EditText et_password;
    @BindView(R.id.tv_pass)
    TextView tv_password;
    @BindString(R.string.completeData)
    String completeData;
    @BindString(R.string.shortPassword)
    String shortPassword;
    @BindString(R.string.networkException)
    String newtworkException;
    @BindString(R.string.poorConnection)
    String poorConnection;
    @BindString(R.string.serverError)
    String serverError;


    @BindString(R.string.updateSuccessful)
    String updateSuccessful;
    String type;
    ViewModelUser viewModel;
    Views.LoadingView loadingView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_profile);
        ButterKnife.bind(this);
        loadingView = new Views.LoadingView(this);
        initListener();

        type = getIntent().getStringExtra("type");
        if (type.equals("edit")) {
            updateUi();
            et_useName.setEnabled(false);

        }


    }

    @OnClick(R.id.list)
    void back() {
        finish();
    }

    void updateUi() {
        et_email.setText(loggedInUser.getEmail());
        et_firstName.setText(loggedInUser.getFirstName());
        et_familyName.setText(loggedInUser.getLastName());
        et_phone.setText(loggedInUser.getPhone());
        et_useName.setText(loggedInUser.getUserName());
        et_password.setText(loggedInUser.getPassword());

    }

    private boolean validate() {

        if (TextUtils.isEmpty(et_firstName.getText().toString())) {

            return false;
        }
        if (TextUtils.isEmpty(et_familyName.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(et_phone.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(et_useName.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(et_email.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(et_password.getText().toString()) && et_password.getText().toString().length() < 6) {
            showToast(shortPassword);
            return false;
        }
        return true;
    }


    @OnClick(R.id.btn_confirm)
    void confirm() {
        if (type != null && type.equals("register")) {
            if (new CheckNetwork(this).getConnected()) {

                if (validate()) {
                    loadingView.show();

                    RegisterRequest request = new RegisterRequest();
                    request.setFname(et_firstName.getText().toString());
                    request.setLname(et_familyName.getText().toString());
                    request.setEmail(et_email.getText().toString());
                    request.setMobileNumber(et_phone.getText().toString());
                    request.setUserName(et_useName.getText().toString());
                    request.setToken(new FireBaseToken().getToken());
                    request.setPassword(et_password.getText().toString());

                    viewModel.registerToServer(this, request);


                } else {
                    showToast(completeData);
                }
            } else {
                showToast(poorConnection);
            }
        } else if (type.equals("edit")) {
            if (new CheckNetwork(this).getConnected()) {
                if (validate()) {

                    loadingView.show();
                    UpdateUserDataRequest request = new UpdateUserDataRequest();
                    request.setFname(et_firstName.getText().toString());
                    request.setLname(et_familyName.getText().toString());
                    request.setEmail(et_email.getText().toString());
                    request.setMobileNumber(et_phone.getText().toString());
                    request.setUserName(et_useName.getText().toString());
                    request.setPassword(et_password.getText().toString());
                    viewModel.updateUserDataToServer(this, request);
                } else {
                    showToast(completeData);
                }
            } else {
                showToast(poorConnection);
            }
        }

    }

    void showToast(String m) {
        Toast.makeText(this, m + "", Toast.LENGTH_SHORT).show();
    }

    private void initListener() {
        viewModel = ViewModelProviders.of(this).get(ViewModelUser.class);
        viewModel.makeRegister().observe(this, new Observer<RegisterResponse>() {
            @Override
            public void onChanged(RegisterResponse response) {
                loadingView.dismiss();
                if (response.getStatus()) {
                    goToMain();
                } else if (response.getMessage() != null && response.getMessage().equals(newtworkException)) {
                    showToast(poorConnection);
                } else if (response.getMessage() != null) {
                    showToast(response.getMessage());
                } else {
                    showToast(serverError);
                }

            }
        });

        viewModel.makeEditProfile().observe(this, new Observer<UpdateUserDataResponse>() {
            @Override
            public void onChanged(UpdateUserDataResponse response) {

                loadingView.dismiss();
                if (response.getStatus()) {
                    showToast(updateSuccessful);
                    finish();
                } else if (response.getMessage() != null && response.getMessage().equals(newtworkException)) {

                    showToast(poorConnection);

                } else if (response.getMessage() != null) {
                    showToast(response.getMessage());
                } else {
                    showToast(serverError);
                }

            }
        });

    }


    void goToMain() {
        startActivity(new Intent(this, MainActivity_User.class));
        finish();
    }


}

package com.nglah.masrytechn.view.drive_Profile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nglah.masrytechn.Firebase.FireBaseToken;
import com.nglah.masrytechn.R;
import com.nglah.masrytechn.network.networkModel.request.User.RegisterCarOwnerRequest;
import com.nglah.masrytechn.network.networkModel.request.User.UpdateDriverDataRequest;
import com.nglah.masrytechn.network.networkModel.response.User.RegisterCarOwnerResponse;
import com.nglah.masrytechn.network.networkModel.response.User.UpdateDriverDataResponse;
import com.nglah.masrytechn.view.Utils.CheckNetwork;
import com.nglah.masrytechn.view.Utils.ConvertImageToBase64;
import com.nglah.masrytechn.view.Utils.Dialog.Views;
import com.nglah.masrytechn.view.main.Main2Activity_Driver;
import com.nglah.masrytechn.viewModel.ViewModelUser;

import net.alhazmy13.mediapicker.Image.ImagePicker;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.nglah.masrytechn.model.UserModel.loggedInUser;

public class DriverDataModel extends AppCompatActivity {

    @BindView(R.id.et_nationality)
    EditText et_nationality;
    @BindView(R.id.et_license)
    EditText et_licences;
    @BindView(R.id.et_driverFirstName)
    EditText et_firstName;
    @BindView(R.id.et_driverLastName)
    EditText et_lastName;
    @BindView(R.id.et_idNumber)
    EditText et_idNumber;

    @BindView(R.id.et_driverPhone)
    EditText et_phone;
    @BindView(R.id.et_driverEmail)
    EditText et_email;
    @BindView(R.id.et_driverUserNAme)
    EditText et_userName;
    @BindView(R.id.et_driverPassword)
    EditText et_password;
    @BindView(R.id.driver_image)
    CircleImageView civ_driverImage;
    @BindView(R.id.textView10)
    TextView tv_password;
    @BindString(R.string.completeData)
    String completeData;
    @BindString(R.string.shortPassword)
    String shortPassword;
    @BindString(R.string.poorConnection)
    String poorConection;
    @BindString(R.string.uploadImage)
    String uploadImage;
    @BindString(R.string.networkException)
    String newtworkException;
    @BindString(R.string.serverError)
    String serverError;

    String type;
    ViewModelUser viewModel;
    ConvertImageToBase64 convertImageToBase64;
    Bitmap imageBitmap;
    String base64Image = "";
    Views.LoadingView dialog;
    RegisterCarOwnerRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_data_edit);
        ButterKnife.bind(this);

        convertImageToBase64 = new ConvertImageToBase64();
        type = getIntent().getStringExtra("type");
        request = (RegisterCarOwnerRequest) getIntent().getSerializableExtra("request");

        dialog = new Views.LoadingView(this);
        initListener();
        if (type.equals("edit")) {
            updateUi();
            et_userName.setEnabled(false);
        }

    }


    void updateUi() {
        et_nationality.setText(loggedInUser.getNationality());
        et_firstName.setText(loggedInUser.getFirstName());
        et_lastName.setText(loggedInUser.getLastName());
        et_email.setText(loggedInUser.getEmail());
        et_userName.setText(loggedInUser.getUserName());
        et_phone.setText(loggedInUser.getPhone());
        et_password.setText(loggedInUser.getPassword());
        et_licences.setText(loggedInUser.getLicenseNum());
        et_idNumber.setText(loggedInUser.getIdNumber());

    }

    private boolean validate() {
        if (TextUtils.isEmpty(et_licences.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(et_lastName.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(et_nationality.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(et_firstName.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(et_phone.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(et_userName.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(et_email.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(et_idNumber.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(et_password.getText().toString()) && et_password.getText().toString().length() < 6) {
            showToast(shortPassword);
            return false;
        }

        return true;
    }

    @OnClick(R.id.btn_DriverNext)
    void registerDriver() {
        if (type.equals("register")) {
            if (validate()) {

                request.setNationality(et_nationality.getText().toString());
                request.setFname(et_firstName.getText().toString());
                request.setLname(et_lastName.getText().toString());
                request.setEmail(et_email.getText().toString());
                request.setMobileNumber(et_phone.getText().toString());
                request.setUserName(et_userName.getText().toString());
                request.setToken(new FireBaseToken().getToken());
                request.setPassword(et_password.getText().toString());
                request.setLicenseNum(et_licences.getText().toString());
                request.setIdNumber(et_idNumber.getText().toString());
                request.setUserPhoto(base64Image);


                if (new CheckNetwork(this).getConnected()) {
                    dialog.show();
                    viewModel.registerCarOwnerToServer(this, request);
                } else
                    showToast(poorConection);
            }
        } else if (type.equals("edit")) {
            if (new CheckNetwork(this).getConnected()) {

                if (validate()) {
                    dialog.show();

                    UpdateDriverDataRequest request = new UpdateDriverDataRequest();
                    request.setUserName(loggedInUser.getUserName());
                    request.setOldEmail(loggedInUser.getEmail());
                    request.setPassword(et_password.getText().toString());
                    request.setMaxWeight(loggedInUser.getMaxWeight());
                    request.setCarType(loggedInUser.getCarType());
                    request.setPlateNumber(loggedInUser.getPlateNumber());
                    request.setCity(loggedInUser.getCity());
                    request.setCurrentCity(loggedInUser.getCurrentCity());
                    request.setCarIcon(loggedInUser.getCarIcon());
                    if (base64Image.equals("")) {
                        request.setUserPhoto(loggedInUser.getImageUrl());
                    } else {
                        request.setUserPhoto(base64Image);
                    }

                    request.setNationality(et_nationality.getText().toString());
                    request.setFname(et_firstName.getText().toString());
                    request.setLname(et_lastName.getText().toString());
                    request.setEmail(et_email.getText().toString());
                    request.setMobileNumber(et_phone.getText().toString());
                    request.setUserName(et_userName.getText().toString());
                    request.setLicenseNum(et_licences.getText().toString());
                    request.setIDnumber(et_idNumber.getText().toString());



                    viewModel.updateDriverDataToServer(this, request);


                } else {
                    showToast(poorConection);
                }
            }
        }

    }

    @OnClick(R.id.driver_image)
    void uploadImage() {
        openGallery();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ImagePicker.IMAGE_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> mPaths = data.getStringArrayListExtra(ImagePicker.EXTRA_IMAGE_PATH);
            for (String imagePath : mPaths) {
                base64Image = convertImageToBase64.convertBitmapToDataUrl(BitmapFactory.decodeFile(imagePath));
                imageBitmap = BitmapFactory.decodeFile(imagePath);
                civ_driverImage.setImageBitmap(imageBitmap);
            }
        }
    }

    private void openGallery() {
        new ImagePicker.Builder(DriverDataModel.this)
                .mode(ImagePicker.Mode.CAMERA_AND_GALLERY)
                .compressLevel(ImagePicker.ComperesLevel.MEDIUM)
                .allowMultipleImages(true)
                .build();
    }

    void showToast(String m) {
        Toast.makeText(this, m + "", Toast.LENGTH_SHORT).show();
    }

    private void initListener() {
        viewModel = ViewModelProviders.of(this).get(ViewModelUser.class);

        viewModel.makeRegisterCarOwner().observe(this, new Observer<RegisterCarOwnerResponse>() {
            @Override
            public void onChanged(RegisterCarOwnerResponse response) {

                dialog.dismiss();
                if (response != null) {
                    if (response.getId() != null) {
                        goToMain();
                    } else if (response.getMessage() != null && response.getMessage().equals(newtworkException)) {
                        showToast(poorConection);
                    } else if (response.getMessage() != null) {
                        showToast(response.getMessage());
                    } else {
                        showToast(serverError);
                    }
                }
            }
        });

        viewModel.makeEditDriverProfile().observe(this, new Observer<UpdateDriverDataResponse>() {
            @Override
            public void onChanged(UpdateDriverDataResponse response) {
                dialog.dismiss();


                dialog.dismiss();
                if (response .getStatus()) {
                    if (response.getId() != null) {
                        showToast(getString(R.string.updateSuccessful));
                        finish();

                    } else if (response.getMessage() != null && response.getMessage().equals(newtworkException)) {
                        showToast(poorConection);
                    } else if (response.getMessage() != null) {
                        showToast(response.getMessage());
                    } else {
                        showToast(serverError);
                    }
                }

            }
        });
    }

    void goToMain() {
        startActivity(new Intent(this, Main2Activity_Driver.class));
        finish();
    }
}

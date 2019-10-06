package com.nglah.masrytechn.view.drive_Profile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nglah.masrytechn.Firebase.FireBaseToken;
import com.nglah.masrytechn.R;
import com.nglah.masrytechn.network.networkModel.request.User.RegisterCarOwnerRequest;
import com.nglah.masrytechn.network.networkModel.response.User.RegisterCarOwnerResponse;
import com.nglah.masrytechn.view.Utils.ConvertImageToBase64;
import com.nglah.masrytechn.view.Utils.Dialog.Views;
import com.nglah.masrytechn.view.main.MainActivity;
import com.nglah.masrytechn.viewModel.ViewModelUser;

import net.alhazmy13.mediapicker.Image.ImagePicker;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class DriverDataModel extends AppCompatActivity {

    @BindView(R.id.et_nationality)
    EditText et_nationality;
    @BindView(R.id.et_license)
    EditText et_licences;
    @BindView(R.id.et_driverFirstName)
    EditText et_firstName;
    @BindView(R.id.et_driverLastName)
    EditText et_lastName;
    @BindView(R.id.et_driverFamilyName)
    EditText et_familyName;
    @BindView(R.id.et_driverIdNumber)
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
    @BindString(R.string.completeData)
    String completeData;
    @BindString(R.string.shortPassword)
    String shortPassword;
    @BindString(R.string.poorConnection)
    String poorConection;
    @BindString(R.string.uploadImage)
    String uploadImage;
    String type;
    ViewModelUser viewModel;
    ConvertImageToBase64 convertImageToBase64;
    Bitmap imageBitmap;
    String base64Image = "";
    Views.LoadingView dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_data_edit);
        ButterKnife.bind(this);

        type = getIntent().getStringExtra("type");
        dialog = new Views.LoadingView(this);
        initListener();


    }

    private boolean validate() {
        if (TextUtils.isEmpty(et_licences.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(et_lastName.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(et_idNumber.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(et_nationality.getText().toString())) {
            return false;
        }

        if (TextUtils.isEmpty(et_firstName.getText().toString())) {

            return false;
        }
        if (TextUtils.isEmpty(et_familyName.getText().toString())) {
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
        if (TextUtils.isEmpty(et_password.getText().toString()) && et_password.getText().toString().length() < 6) {
            showToast(shortPassword);
            return false;
        }
        if (base64Image != null && !base64Image.equals("")) {
            showToast(uploadImage);
        }
        return true;
    }

    @OnClick(R.id.btn_DriverNext)
    void registerDriver() {
        if (type.equals("register")) {
            if (validate()) {

                dialog.show();
                RegisterCarOwnerRequest request = new RegisterCarOwnerRequest();
                request.setNationality(et_nationality.getText().toString());
                request.setFname(et_firstName.getText().toString());
                request.setLname(et_familyName.getText().toString());
                request.setEmail(et_email.getText().toString());
                request.setMobileNumber(et_phone.getText().toString());
                request.setUserName(et_userName.getText().toString());
                request.setToken(new FireBaseToken().getToken());
                request.setPassword(et_password.getText().toString());
                request.setCarType("Toyota");
                request.setPlateNumber("1231123");
                request.setMaxWeight("12300");
                request.setCarIcon("21");
                request.setCurrentCity("cairo");
                request.setCity("Giza");
                viewModel.registerCarOwnerToServer(this, request);
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
            public void onChanged(RegisterCarOwnerResponse registerResponse) {

                dialog.dismiss();
                if (registerResponse.getId()!=null) {
                    goToMain();
                } else {
                    showToast("error happen tray again later");
                }
            }
        });

    }

    void goToMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}

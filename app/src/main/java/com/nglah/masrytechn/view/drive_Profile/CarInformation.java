package com.nglah.masrytechn.view.drive_Profile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.nglah.masrytechn.R;
import com.nglah.masrytechn.network.networkModel.request.User.RegisterCarOwnerRequest;
import com.nglah.masrytechn.view.Utils.ConvertImageToBase64;

import net.alhazmy13.mediapicker.Image.ImagePicker;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CarInformation extends AppCompatActivity {

    @BindView(R.id.sp_carType)
    Spinner sp_carType;
    @BindView(R.id.et_panelNumber)
    TextInputEditText et_panelNumber;
    @BindView(R.id.et_maxWeight)
    TextInputEditText et_maxWeight;
    @BindView(R.id.et_driveName)
    TextInputEditText et_driverName;
    @BindView(R.id.et_city)
    TextInputEditText et_city;
    @BindView(R.id.iv_carImage)
    ImageView iv_carImage;
    @BindView(R.id.btn_ok)
    Button btn_ok;
    @BindView(R.id.btn_cancel)
    Button btn_cancel;
    String carImage = "";
    String carType = "";
    ConvertImageToBase64 convertImageToBase64;
    Bitmap imageBitmap;
    RegisterCarOwnerRequest request = new RegisterCarOwnerRequest();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_information);
        ButterKnife.bind(this);
        convertImageToBase64 = new ConvertImageToBase64();

        sp_carType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                carType = sp_carType.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @OnClick(R.id.btn_ok)
    void ok() {

        if (validateDate()) {
            request.setCarType(carType);
            request.setPlateNumber(et_panelNumber.getText().toString());
            request.setMaxWeight(et_maxWeight.getText().toString());
            request.setCarIcon(carImage);
            request.setCurrentCity(et_city.getText().toString());
            request.setCity(et_city.getText().toString());
            goToCompleteRegister();
        }
    }

    @OnClick(R.id.tv_selectImage)
    void selectCarImage() {

        openGallery();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ImagePicker.IMAGE_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> mPaths = data.getStringArrayListExtra(ImagePicker.EXTRA_IMAGE_PATH);
            for (String imagePath : mPaths) {
                carImage = convertImageToBase64.convertBitmapToDataUrl(BitmapFactory.decodeFile(imagePath));
                imageBitmap = BitmapFactory.decodeFile(imagePath);
                iv_carImage.setVisibility(View.VISIBLE);
                iv_carImage.setImageBitmap(imageBitmap);
            }
        }
    }


    private void openGallery() {
        new ImagePicker.Builder(CarInformation.this)
                .mode(ImagePicker.Mode.CAMERA_AND_GALLERY)
                .compressLevel(ImagePicker.ComperesLevel.MEDIUM)
                .allowMultipleImages(true)
                .build();
    }

    void goToCompleteRegister() {
        Intent intent = new Intent(this, DriverDataModel.class);
        intent.putExtra("type", "register");
        intent.putExtra("request", request);

        startActivity(intent);
    }

    private boolean validateDate() {
        if (TextUtils.isEmpty(et_city.getText().toString())) {

            return false;
        } else if (TextUtils.isEmpty(et_maxWeight.getText().toString())) {
            return false;
        } else if (TextUtils.isEmpty(et_panelNumber.getText().toString())) {
            return false;
        }
        return true;
    }

}

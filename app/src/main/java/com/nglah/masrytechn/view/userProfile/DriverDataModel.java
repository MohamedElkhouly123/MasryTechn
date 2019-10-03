package com.nglah.masrytechn.view.userProfile;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.nglah.masrytechn.R;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_data_edit);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_DriverNext)
    void registerDriver() {

    }

    @OnClick(R.id.driver_image)
    void uploadImage() {
    }
}

package com.nglah.masrytechn.view.AllDeriver;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.network.networkModel.response.Naglaha.AllDriverResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DriverDetail extends AppCompatActivity {


    @BindView(R.id.tv_nationalitye)
    TextView tv_nationality;
    @BindView(R.id.tv_licencese)
    TextView tv_licences;
    @BindView(R.id.tv_fNamee)
    TextView tv_fName;
    @BindView(R.id.tv_lNamee)
    TextView tv_lName;
    @BindView(R.id.tv_idNumberDriver)
    TextView tv_idNumber;
    @BindView(R.id.tv_phoneDrivere)
    TextView tv_phone;
    @BindView(R.id.tv_emaile)
    TextView tv_email;
    @BindView(R.id.tv_userNamee)
    TextView tv_userName;
    @BindView(R.id.tv_typeOfCare)
    TextView tv_typeOfCar;
    @BindView(R.id.tv_plateNumbere)
    TextView tv_plateNumber;
    @BindView(R.id.tv_maxWeight_drivere)
    TextView tv_maxWeight;
    @BindView(R.id.tv_citye)
    TextView tv_city;
    @BindView(R.id.driver_namee)
    TextView tv_fullName;
    AllDriverResponse.Datum data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_detail);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        data = (AllDriverResponse.Datum) getIntent().getSerializableExtra("data");
        if (data != null) {
            updateUi();
        }
    }

    @OnClick(R.id.list)
    void back() {
        finish();
    }
    private void updateUi() {

        tv_nationality.setText(data.getNationality());
        tv_licences.setText(data.getLicenseNum());
        tv_fName.setText(data.getFname());
        tv_lName.setText(data.getLname());
        tv_fullName.setText(data.getFname() + " " + data.getLname());
        tv_idNumber.setText(data.getNumber()+"");
        tv_phone.setText(data.getMobileNumber());
        tv_email.setText(data.getEmail());
        tv_typeOfCar.setText(data.getCarType());
        tv_plateNumber.setText(data.getPlateNumber());
        tv_maxWeight.setText(data.getMaxWeight());
        tv_city.setText(data.getCity());
    }
}

package com.nglah.masrytechn.view.drive_Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.view.userProfile.EditUserProfile;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.nglah.masrytechn.model.UserModel.loggedInUser;

public class drive_profile extends AppCompatActivity {


    @BindView(R.id.tv_nationality)
    TextView tv_nationality;
    @BindView(R.id.tv_licences)
    TextView tv_licences;
    @BindView(R.id.tv_fName)
    TextView tv_fName;
    @BindView(R.id.tv_lName)
    TextView tv_lName;
    @BindView(R.id.tv_idNumber)
    TextView tv_idNumber;
    @BindView(R.id.tv_phone)
    TextView tv_phone;
    @BindView(R.id.tv_email)
    TextView tv_email;
    @BindView(R.id.tv_userName)
    TextView tv_userName;
    @BindView(R.id.tv_typeOfCar)
    TextView tv_typeOfCar;
    @BindView(R.id.tv_plateNumber)
    TextView tv_plateNumber;
    @BindView(R.id.tv_maxWeight)
    TextView tv_maxWeight;
    @BindView(R.id.tv_city)
    TextView tv_city;
    @BindView(R.id.driver_name)
    TextView tv_fullName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive_profile);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        updateUi();

    }
    @OnClick(R.id.list)void  back(){
        finish();
    }
    @Override
    protected void onResume() {
        super.onResume();
        updateUi();
    }

    private void updateUi() {
        tv_nationality.setText(loggedInUser.getNationality());
        tv_licences.setText(loggedInUser.getLicenseNum());
        tv_fName.setText(loggedInUser.getFirstName());
        tv_lName.setText(loggedInUser.getLastName());
        tv_fullName.setText(loggedInUser.getFirstName() + " "
                + loggedInUser.getLastName());
        tv_idNumber.setText(loggedInUser.getIdNumber());
        tv_phone.setText(loggedInUser.getPhone());
        tv_email.setText(loggedInUser.getEmail());
        tv_typeOfCar.setText(loggedInUser.getCarType());
        tv_plateNumber.setText(loggedInUser.getPlateNumber());
        tv_maxWeight.setText(loggedInUser.getMaxWeight());
        tv_city.setText(loggedInUser.getCity());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu, this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.Setting) {
            Intent intent = new Intent(this, DriverDataModel.class);
            intent.putExtra("type", "edit");
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

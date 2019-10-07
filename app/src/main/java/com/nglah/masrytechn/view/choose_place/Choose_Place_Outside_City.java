package com.nglah.masrytechn.view.choose_place;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import com.nglah.masrytechn.R;

public class Choose_Place_Outside_City extends AppCompatActivity {
    private Spinner spinnerCountry, spinnerRegion, spinnerCity ,choose_City;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__place__outside__city);
    }
}

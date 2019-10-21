package com.nglah.masrytechn.view.choose_place;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.nglah.masrytechn.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Nagla_Location extends AppCompatActivity {

    AddNaglaModel request = new AddNaglaModel();
    String whereNaglah="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nagla__location);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.insideCity)
    void inside_City(){
        whereNaglah="inside";
        request.setWhereNagla(whereNaglah);
        Intent intent = new Intent(this, Choose_Place_Inside_City.class);
        intent.putExtra("request", request);
        startActivity(intent);

    }
    @OnClick(R.id.outsideCity)
    void outside_City(){
        whereNaglah="outside";
        request.setWhereNagla(whereNaglah);

        Intent intent = new Intent(this, Choose_Place_Outside_City.class);
        intent.putExtra("request", request);
        startActivity(intent);

    }
}

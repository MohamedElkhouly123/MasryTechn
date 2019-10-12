package com.nglah.masrytechn.view.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.nglah.masrytechn.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_charge)
    void charge(){

        startActivity(new Intent(this,NextPayment.class));

    }
    @OnClick(R.id.list)void  back(){
        finish();
    }
}

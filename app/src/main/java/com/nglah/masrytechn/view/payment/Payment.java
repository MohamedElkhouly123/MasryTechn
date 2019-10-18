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
    @OnClick(R.id.visa)
    void charge(){
        goToPayment("VISA");
    }
    @OnClick(R.id.masterCard)
    void master(){
        goToPayment("MASTER");
    }
    void goToPayment(String type){
        Intent intent=new Intent(this,NextPayment.class);
        intent.putExtra("type",type);
        startActivity(intent);
    }

    @OnClick(R.id.list)void  back(){
        finish();
    }
}

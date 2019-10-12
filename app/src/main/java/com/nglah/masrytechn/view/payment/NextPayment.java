package com.nglah.masrytechn.view.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.nglah.masrytechn.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NextPayment extends AppCompatActivity {

    @BindView(R.id.card_number)
    EditText cardNumber;
    @BindView(R.id.card_holder)
    EditText card_holder;
    @BindView(R.id.month)
    EditText month;
    @BindView(R.id.year)
    EditText year;
    @BindView(R.id.cvv)
    EditText cvv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_payment);
        ButterKnife.bind(this);



    }
}

package com.nglah.masrytechn.view.payment;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.network.networkModel.request.Payment.PaymentRequest;
import com.nglah.masrytechn.network.networkModel.response.Payment.PaymentResponse;
import com.nglah.masrytechn.viewModel.ViewModelNaglaha;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R.id.money)
    EditText et_money;
    String type = "";
    ViewModelNaglaha viewModelNaglaha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_payment);
        ButterKnife.bind(this);
        type = getIntent().getStringExtra("type");
        initListener();
    }

    private void initListener() {
        viewModelNaglaha = ViewModelProviders.of(this).get(ViewModelNaglaha.class);
        viewModelNaglaha.makePayment().observe(this, new Observer<PaymentResponse>() {
            @Override
            public void onChanged(PaymentResponse paymentResponse) {


            }
        });
    }
    @OnClick(R.id.pay)
    void Pay() {
        if (validate()) {
            PaymentRequest request = new PaymentRequest();
            viewModelNaglaha.addPaymentToServer(request);
        } else {
            showToast(getString(R.string.completeData));
        }
    }

    Boolean validate() {

        if (TextUtils.isEmpty(et_money.getText().toString())) {
            return false;
        } else if (TextUtils.isEmpty(card_holder.getText().toString())) {
            return false;
        } else if (TextUtils.isEmpty(month.getText().toString())) {
            return false;
        }
        if (TextUtils.isEmpty(year.getText().toString())) {
            return false;
        } else if (TextUtils.isEmpty(cvv.getText().toString())) {
            return false;
        } else {
            return true;
        }
    }


    @OnClick(R.id.list)
    void back() {
        finish();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

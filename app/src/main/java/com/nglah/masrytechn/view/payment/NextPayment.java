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
import com.nglah.masrytechn.view.Utils.Dialog.Views;
import com.nglah.masrytechn.viewModel.ViewModelNaglaha;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.nglah.masrytechn.model.UserModel.loggedInUser;

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

    String type = "";
    ViewModelNaglaha viewModelNaglaha;
    @BindString(R.string.networkException)
    String newtworkException;
    @BindString(R.string.poorConnection)
    String poorConnection;
    @BindString(R.string.serverError)
    String serverError;

    Views.LoadingView loadingView;
    String user = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_payment);
        ButterKnife.bind(this);
        type = getIntent().getStringExtra("type");
        user = getIntent().getStringExtra("user");
        loadingView = new Views.LoadingView(this);
        initListener();
    }

    private void initListener() {
        viewModelNaglaha = ViewModelProviders.of(this).get(ViewModelNaglaha.class);
        viewModelNaglaha.makePayment().observe(this, new Observer<PaymentResponse>() {
            @Override
            public void onChanged(PaymentResponse response) {
                loadingView.dismiss();
                if (response != null) {
                    if (response.getResult().getCode().equals("000.200.000")) {
                        showToast(getString(R.string.successfulTransaction));
                        finish();
                    } else if (response.getResult().getCode().equals("100.100.101")) {
                        showToast(getString(R.string.inValidCardNumber));
                    } else if (response.getResult().getCode().equals("100.100.700")) {
                        showToast(response.getResult().getDescription());
                    } else if (response.getResult().getCode().equals("200.300.404")) {
                        showToast(response.getResult().getDescription());
                    } else if (response.getResult().getCode() != null) {
                        showToast(response.getResult().getDescription());

                    } else if (response.getResult().getCode().equals(newtworkException)) {
                        showToast(poorConnection);
                    } else {
                        showToast(serverError);
                    }


                } else {

                    showToast(serverError);
                }

            }
        });
    }

    @OnClick(R.id.pay)
    void Pay() {
        if (validate()) {
            loadingView.show();
            PaymentRequest request = new PaymentRequest();
            request.setUserId(loggedInUser.getId());
            request.setAmount(card_holder.getText().toString());
            request.setCardCvv(cvv.getText().toString());
            request.setCardexpiryYear(year.getText().toString());
            request.setCardExpireMonth(month.getText().toString());
            request.setCardNumber(cardNumber.getText().toString());
            request.setCardType(type);
            request.setRole(user);
            viewModelNaglaha.addPaymentToServer(request);
        } else {
            showToast(getString(R.string.completeData));
        }
    }

    Boolean validate() {

        if (TextUtils.isEmpty(card_holder.getText().toString())) {
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

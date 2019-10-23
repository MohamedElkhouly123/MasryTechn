package com.nglah.masrytechn.view.Accepted_Info;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.network.networkModel.request.driver.AcceptNqlahRequest;
import com.nglah.masrytechn.network.networkModel.response.driver.AcceptNaqlahaResponse;
import com.nglah.masrytechn.network.networkModel.response.driver.GetAllNaqlaResponse;
import com.nglah.masrytechn.view.Utils.Dialog.Views;
import com.nglah.masrytechn.viewModel.DriverViewModel;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.nglah.masrytechn.model.UserModel.loggedInUser;

public class Accepted_User_Info extends AppCompatActivity {

    @BindView(R.id.tv_nglah_name)
    TextView tv_naqlaOwner;
    @BindView(R.id.tv_order_type)
    TextView tv_orderType;
    @BindView(R.id.tv_date)
    TextView tv_date;
    @BindView(R.id.tv_time)
    TextView tv_time;
    @BindView(R.id.tv_thing_type)
    TextView tv_thingType;
    @BindView(R.id.tv_city)
    TextView tv_city;
    @BindView(R.id.tv_details)
    TextView tv_detail;
    @BindView(R.id.et_price)
    EditText et_price;


    @BindString(R.string.networkException)
    String newtworkException;
    @BindString(R.string.poorConnection)
    String poorConnection;
    @BindString(R.string.serverError)
    String serverError;
    GetAllNaqlaResponse.Datum data;
    DriverViewModel viewModel;
    Views.LoadingView loadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accepted__user__info);
        ButterKnife.bind(this);
        loadingView = new Views.LoadingView(this);
        data = (GetAllNaqlaResponse.Datum) getIntent().getSerializableExtra("data");
        initListener();
        if (data != null) {
            updateUi();

        }

    }

    private void initListener() {
        viewModel = ViewModelProviders.of(this).get(DriverViewModel.class);
        viewModel.getAcceptNaqla().observe(this, new Observer<AcceptNaqlahaResponse>() {
            @Override
            public void onChanged(AcceptNaqlahaResponse response) {
                loadingView.dismiss();

                if (response != null) {
                    if (response.getStatus() && response.getMsg().equals("done")) {
                        finish();
                    } else if (response.getMsg().equals(newtworkException)) {
                        showToast(poorConnection);
                    } else {
                        showToast(response.getMsg());
                    }

                } else {
                    showToast(serverError);
                }
            }
        });
    }

    private void updateUi() {
        tv_naqlaOwner.setText(data.getUser().getFname() + " " + data.getUser().getLname());
        tv_orderType.setText(data.getNaglahType());
        tv_date.setText(data.getNaqlaDate());
        tv_time.setText(data.getNaqlaTime());
        tv_thingType.setText(data.getElementType());
        tv_city.setText(data.getToP());
        tv_detail.setText(data.getDetails());
    }

    @OnClick(R.id.bt_ok)
    void acceptNAqlah() {
        if (!TextUtils.isEmpty(et_price.getText().toString())) {
            loadingView.show();
            AcceptNqlahRequest request = new AcceptNqlahRequest();
            request.setDriverId(Integer.parseInt(loggedInUser.getId()));
            request.setNaqlaId(data.getId());
            request.setPrice(Integer.parseInt(et_price.getText().toString()));
            viewModel.acceptNaqlaToServer(request);
        }
    }

    private void showToast(String m) {
        Toast.makeText(this, m, Toast.LENGTH_SHORT).show();
    }
}

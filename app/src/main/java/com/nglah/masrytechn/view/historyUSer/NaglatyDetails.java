package com.nglah.masrytechn.view.historyUSer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nglah.masrytechn.DriverListener;
import com.nglah.masrytechn.R;
import com.nglah.masrytechn.network.networkModel.request.driver.AddEvaluationRequest;
import com.nglah.masrytechn.network.networkModel.response.driver.AddEvaluationResponse;
import com.nglah.masrytechn.network.networkModel.response.driver.ComfirmNaqlaCostResponse;
import com.nglah.masrytechn.network.networkModel.response.driver.UserHistoryResponse;
import com.nglah.masrytechn.view.Utils.Dialog.Views;
import com.nglah.masrytechn.view.adapter.DriverAdapter;
import com.nglah.masrytechn.view.chat.ChatActivity;
import com.nglah.masrytechn.viewModel.DriverViewModel;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.nglah.masrytechn.model.UserModel.loggedInUser;

public class NaglatyDetails extends AppCompatActivity implements DriverListener {


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
    @BindView(R.id.rate)
    EditText et_rate;
    @BindView(R.id.rv_driver)
    RecyclerView rv_driver;

    @BindString(R.string.networkException)
    String newtworkException;
    @BindString(R.string.poorConnection)
    String poorConnection;
    @BindString(R.string.serverError)
    String serverError;
    UserHistoryResponse.Datum data;
    DriverViewModel viewModel;
    Views.LoadingView loadingView;
    LinearLayoutManager layoutManager;
    DriverAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naglaty_details);
        ButterKnife.bind(this);

        loadingView = new Views.LoadingView(this);
        data = (UserHistoryResponse.Datum) getIntent().getSerializableExtra("data");
        initListener();
        if (data != null) {
            updateUi();

        }

    }


    private void updateUi() {
        tv_orderType.setText(data.getNaglahType());
        tv_date.setText(data.getNaqlaDate());
        tv_time.setText(data.getNaqlaTime());
        tv_thingType.setText(data.getElementType());
        tv_city.setText(data.getToP());
        tv_detail.setText(data.getDetails());
        if (data.getDriver().size() > 0) {
            initRecycler();
        }
    }

    private void initRecycler() {
        layoutManager = new LinearLayoutManager(this);
        rv_driver.setLayoutManager(layoutManager);
        adapter = new DriverAdapter(data.getDriver(), this, this);
        rv_driver.setAdapter(adapter);


    }

    @OnClick(R.id.bt_ok)
    void acceptNAqlah() {

        if (!TextUtils.isEmpty(et_rate.getText().toString())) {
            loadingView.show();
            AddEvaluationRequest request = new AddEvaluationRequest();
            request.setUserId(Integer.parseInt(loggedInUser.getId()));
            request.setNaqlaId(data.getId());
            request.setRate(Integer.parseInt(et_rate.getText().toString()));
            viewModel.sendEvaluationToServer(request);
        } else {
            showToast("ادخل تقيم من فضلك");
        }
    }


    @Override
    public void accept() {

        confirmCost();
    }

    @Override
    public void chat() {

        goToChat();
    }

    private void confirmCost() {
        loadingView.show();
        viewModel.confirmCostToServer(Integer.parseInt(data.getDriverID()), data.getId());
    }

    private void goToChat() {
        Intent intent = new Intent(this, ChatActivity.class);
        intent.putExtra("id", "175");
        intent.putExtra("type", "driver");

        startActivity(intent);

    }

    private void initListener() {
        viewModel = ViewModelProviders.of(this).get(DriverViewModel.class);
        viewModel.getConfirmCost().observe(this, new Observer<ComfirmNaqlaCostResponse>() {
            @Override
            public void onChanged(ComfirmNaqlaCostResponse response) {

                loadingView.dismiss();
                if (response != null) {
                    if (response.getStatus()) {
                        showToast("تم تاكيد التكلفه ف انتظار السائق ");

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

        viewModel.getAddEvluationResponse().observe(this, new Observer<AddEvaluationResponse>() {
            @Override
            public void onChanged(AddEvaluationResponse response) {
                loadingView.dismiss();
                if (response != null) {
                    if (response.getStatus() && response.getMsg().equals("Naqla has been rated successfully")) {
                        showToast("تم اضافه التقيم بنجاح");

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

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}

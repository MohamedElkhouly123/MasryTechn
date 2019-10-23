package com.nglah.masrytechn.view.historyUSer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.network.networkModel.response.driver.ComfirmNaqlaCostResponse;
import com.nglah.masrytechn.network.networkModel.response.driver.UserHistoryResponse;
import com.nglah.masrytechn.view.Utils.Dialog.Views;
import com.nglah.masrytechn.view.chat.ChatActivity;
import com.nglah.masrytechn.viewModel.DriverViewModel;

import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Historydetail extends AppCompatActivity {


    @BindString(R.string.networkException)
    String newtworkException;
    @BindString(R.string.poorConnection)
    String poorConnection;
    @BindString(R.string.serverError)
    String serverError;
    @BindString(R.string.no_data_found)
    String noDataFound;

    DriverViewModel viewModel;
    UserHistoryResponse.Datum data;
    Views.LoadingView loadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historydetail);
        ButterKnife.bind(this);
        initListener();
        loadingView = new Views.LoadingView(this);

        data = (UserHistoryResponse.Datum) getIntent().getSerializableExtra("data");
        if (data != null) {
            updateUi();
        }

    }

    private void updateUi() {

    }

    @OnClick(R.id.confirm)
    void confirm() {
        goToChat();

    }

    private void goToChat() {
        Intent intent=new Intent(this, ChatActivity.class);
        intent.putExtra("id","175");
        intent.putExtra("type","driver");

        startActivity(intent);

    }

    private void confirmCost() {
        loadingView.show();
        viewModel.confirmCostToServer(175, 5);

    }

    private void initListener() {
        viewModel = ViewModelProviders.of(this).get(DriverViewModel.class);
        viewModel.getConfirmCost().observe(this, new Observer<ComfirmNaqlaCostResponse>() {
            @Override
            public void onChanged(ComfirmNaqlaCostResponse response) {

                loadingView.dismiss();
                if (response != null) {
                    if (response.getStatus()) {
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

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}

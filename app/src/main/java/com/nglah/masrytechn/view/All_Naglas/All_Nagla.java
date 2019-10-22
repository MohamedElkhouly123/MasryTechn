package com.nglah.masrytechn.view.All_Naglas;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.model.NAGLA;
import com.nglah.masrytechn.view.adapter.DriverNotificationAdapter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class All_Nagla extends AppCompatActivity {
    private DriverNotificationAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private TextView emptyTextView;
    private List<NAGLA> nglahOrdersList;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__nagla);
        ButterKnife.bind(this);
        initWidgets();

    }

    @OnClick(R.id.list)
    void backto() {
        finish();
    }

    private void initWidgets() {
        mRecyclerView = findViewById(R.id.recyclerView);
        emptyTextView = findViewById(R.id.tv_empty_image);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Drivers...");
    }

    private void refreshRecyclerView() {
//        nglahOrdersList.clear();

        if (nglahOrdersList.isEmpty()) {
            emptyTextView.setVisibility(View.VISIBLE);
        } else {
            emptyTextView.setVisibility(View.GONE);

//            mAdapter = new DriverNotificationAdapter(this, nglahOrdersList);   Notice Add values to Adapter nglahOrdersList

            mRecyclerView.setAdapter(mAdapter);
        }
    }
}

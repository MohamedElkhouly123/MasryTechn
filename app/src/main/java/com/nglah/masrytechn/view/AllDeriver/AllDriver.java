package com.nglah.masrytechn.view.AllDeriver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.model.Driver;

import java.util.List;

public class AllDriver extends AppCompatActivity {
    private NglahNotificationAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<Driver> driverAcceptedList;
    private TextView emptyTextView;
    ProgressDialog progressDialog;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_driver);

//        imageView=findViewById(R.id.imgBackRecent);
        // init all widgets in this activity
        initWidgets();

    }
    private void initWidgets(){
        mRecyclerView = findViewById(R.id.recyclerView);
        emptyTextView = findViewById(R.id.tv_empty_image);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                startActivity(new Intent(DriversList.this, User_Main.class));
//                finish();
//            }
//        });

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("loading...");
    }
    private void refreshRecyclerView(){
        if (driverAcceptedList.isEmpty()){
            emptyTextView.setVisibility(View.VISIBLE);
        }else {
            emptyTextView.setVisibility(View.GONE);
//            mAdapter = new NglahNotificationAdapter(driverAcceptedList, this);
            mRecyclerView.setAdapter(mAdapter);
        }

    }

}

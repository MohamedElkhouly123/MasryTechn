package com.nglah.masrytechn.view.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nglah.masrytechn.R;

public class ChatActivity extends AppCompatActivity {

    String userId;
    String driverId;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        type=getIntent().getStringExtra("type");
    }
}

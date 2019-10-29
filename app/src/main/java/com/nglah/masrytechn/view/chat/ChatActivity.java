package com.nglah.masrytechn.view.chat;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nglah.masrytechn.R;
import com.nglah.masrytechn.model.ChatModel;
import com.nglah.masrytechn.view.Utils.Dialog.Views;
import com.nglah.masrytechn.view.adapter.ChatAdpater;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChatActivity extends AppCompatActivity {

    @BindView(R.id.rv_chat)
    RecyclerView rv_chat;
    @BindView(R.id.et_message)
    EditText et_message;

    String userId;
    String driverId;
    String type;
    private DatabaseReference mDatabase;

    LinearLayoutManager layoutManager;
    ChatAdpater chatAdpater;

    List<ChatModel> data = new ArrayList<>();
    Views.LoadingView loadingView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);
        FirebaseApp.initializeApp(this);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        loadingView = new Views.LoadingView(this);


        loadingView.show();

//        type="";
//        type = getIntent().getStringExtra("type");
//        if (type.equals("driver")) {
//            driverId = getIntent().getStringExtra("id");
//            userId = loggedInUser.getId();
//        } else {
//            userId = getIntent().getStringExtra("id");
//            driverId = loggedInUser.getId();
//        }

        layoutManager = new LinearLayoutManager(this);
        rv_chat.setLayoutManager(layoutManager);
        chatAdpater = new ChatAdpater(data, this);
        rv_chat.setAdapter(chatAdpater);
        mDatabase.child("users").child("313").child("175").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                data.clear();
                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                    ChatModel model = new ChatModel();
                    model.setMessage(childDataSnapshot.child("message").getValue().toString());
                    model.setOwnerId(childDataSnapshot.child("ownerId").getValue().toString());
                    data.add(model);
                }
                loadingView.dismiss();
                chatAdpater.notifyDataSetChanged();
                rv_chat.scrollToPosition(data.size()-1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    @OnClick(R.id.send)
    void sendMesaage() {
        if (!TextUtils.isEmpty(et_message.getText().toString())) {
            ChatModel model = new ChatModel();
            model.setOwnerId("313");
            model.setMessage(et_message.getText().toString());
            mDatabase.child("users").child("313").child("175").push().setValue(model);
            et_message.setText("");

        }
    }

    private void showToast(String m) {
        Toast.makeText(this, m, Toast.LENGTH_SHORT).show();
    }


}

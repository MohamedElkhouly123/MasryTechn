package com.nglah.masrytechn.view.userProfile;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.view.chat.ChatActivity;
import com.nglah.masrytechn.view.historyUSer.History;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.nglah.masrytechn.model.UserModel.loggedInUser;

public class UserProfile extends AppCompatActivity {


    @BindView(R.id.tv_userName)
    TextView tv_userName;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.tv_email)
    TextView tv_email;
    @BindView(R.id.tv_phone)
    TextView tv_phone;
    @BindView(R.id.driver_name)
    TextView tv__fullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        updateUi();
    }

    @OnClick(R.id.list)
    void back() {
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUi();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu, this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.Setting) {
            Intent intent = new Intent(this, EditUserProfile.class);
            intent.putExtra("type", "edit");
            startActivity(intent);
        } else if (id == R.id.naglaty) {
            Intent intent = new Intent(this, ChatActivity.class);
            startActivity(intent);
        }
        return true;
    }

    void updateUi() {
        tv_email.setText(loggedInUser.getEmail());
        tv_name.setText(loggedInUser.getFirstName() + " " + loggedInUser.getLastName());
        tv_phone.setText(loggedInUser.getPhone());
        tv_userName.setText(loggedInUser.getUserName());
        tv__fullName.setText(loggedInUser.getFirstName() + " " + loggedInUser.getLastName());


    }


}

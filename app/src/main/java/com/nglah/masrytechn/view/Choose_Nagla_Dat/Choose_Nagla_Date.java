package com.nglah.masrytechn.view.Choose_Nagla_Dat;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nglah.masrytechn.Firebase.FireBaseToken;
import com.nglah.masrytechn.R;
import com.nglah.masrytechn.network.networkModel.request.naglaha.AddNaqlaRequest;
import com.nglah.masrytechn.network.networkModel.response.Naglaha.AddNaqlahaResponse;
import com.nglah.masrytechn.view.Utils.Dialog.Views;
import com.nglah.masrytechn.view.choose_place.AddNaglaModel;
import com.nglah.masrytechn.view.main.MainActivity_User;
import com.nglah.masrytechn.viewModel.ViewModelNaglaha;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.nglah.masrytechn.model.UserModel.loggedInUser;

public class Choose_Nagla_Date extends AppCompatActivity {
    EditText moreDetails;
    TextView date, time;
    ViewModelNaglaha viewModelNaglaha;
    AddNaglaModel request;
    String dateStr = "";
    String timeStr = "";
    String timetypeStr = "";  //now or later
    String details = "";
    Views.LoadingView loadingView;
    @BindString(R.string.networkException)
    String newtworkException;
    @BindString(R.string.poorConnection)
    String poorConnection;
    @BindString(R.string.serverError)
    String serverError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__nagla__date);
        ButterKnife.bind(this);
        initListener();
        request = (AddNaglaModel) getIntent().getSerializableExtra("request");
        loadingView = new Views.LoadingView(this);

        date = (TextView) findViewById(R.id.dateTxt);
        time = (TextView) findViewById(R.id.time_txt);
        moreDetails = (EditText) findViewById(R.id.details);


    }

    @OnClick(R.id.later)
    void laterTime() {
        final View dialogView = View.inflate(Choose_Nagla_Date.this, R.layout.date_time_picker, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(Choose_Nagla_Date.this).create();

        dialogView.findViewById(R.id.date_time_set).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePicker datePicker = (DatePicker) dialogView.findViewById(R.id.date_picker);
                TimePicker timePicker = (TimePicker) dialogView.findViewById(R.id.time_picker);

                Calendar calendar = new GregorianCalendar(datePicker.getYear(),
                        datePicker.getMonth(),
                        datePicker.getDayOfMonth(),
                        timePicker.getCurrentHour(),
                        timePicker.getCurrentMinute());

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");
                String formattedDate = df.format(calendar.getTime());
                String formattedTime = tf.format(calendar.getTime());
                time.setText(formattedTime);
                date.setText(formattedDate);


                alertDialog.dismiss();
            }
        });
        alertDialog.setView(dialogView);
        alertDialog.show();

        timetypeStr = "later";

    }

    @OnClick(R.id.now)
    void now() {
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");
        String formattedDate = df.format(c.getTime());
        String formattedTime = tf.format(c.getTime());
        time.setText(formattedTime);
        date.setText(formattedDate);
        timeStr = time.getText().toString();
        dateStr = date.getText().toString();
        timetypeStr = "now";

    }

    @OnClick(R.id.submitNaglaha)
    void submit() {
        if (request != null) {
            loadingView.show();
            request.setTime(timeStr);
            request.setDate(dateStr);
            request.setNglahTimeType(timetypeStr);
            request.setDetails(moreDetails.getText().toString());

            AddNaqlaRequest data = new AddNaqlaRequest();

            data.setToken(new FireBaseToken().getToken());
            data.setUserID(loggedInUser.getId());
            data.setDriverID("");
            data.setEmail(loggedInUser.getEmail());
            data.setDetails(details);
            data.setPrice("");
            data.setNaqlaTime(timeStr);
            data.setNaqlaDate(dateStr);
            data.setNaglahType(request.getNglahType());
            data.setElementType(request.getElementType());
            data.setCountry(request.getCountry());
            data.setRegion(request.getRegion());
            data.setNaglahTimeType(request.getNglahTimeType());
            data.setToP(request.getToCity());
            data.setFromP(request.getFromCity());
            data.setNaglahTimeType(request.getNglahTimeType());
            data.setRequestedAt("");


            viewModelNaglaha.addNaglahToServer(data);

        }

    }

    @OnClick(R.id.cancel)
    void cancel() {
        goToMain();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }


    private void initListener() {
        viewModelNaglaha = ViewModelProviders.of(this).get(ViewModelNaglaha.class);

        viewModelNaglaha.makeNewNaglaha().
                observe(this, new Observer<AddNaqlahaResponse>() {
                    @Override
                    public void onChanged(AddNaqlahaResponse response) {
                        loadingView.dismiss();
                        if (response != null) {
                            if ( response.getStatus()) {
                                showToast(getString(R.string.addNaqlahaSuccessful));
                                goToMain();
                            } else if (response.getMessage().equals(newtworkException)) {
                                showToast(poorConnection);
                            } else {
                                showToast(serverError);

                            }
                        }
                    }
                });
    }


    void goToMain() {
        startActivity(new Intent(this, MainActivity_User.class));
        finish();
    }
}

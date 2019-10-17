package com.nglah.masrytechn.view.Choose_Nagla_Dat;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.network.networkModel.response.Naglaha.UserRequestNaqlahResponse;
import com.nglah.masrytechn.view.choose_place.AddNaglaModel;
import com.nglah.masrytechn.view.main.MainActivity_User;
import com.nglah.masrytechn.viewModel.ViewModelNaglaha;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Choose_Nagla_Date extends AppCompatActivity {
    EditText moreDetails;
    TextView date, time;
    ViewModelNaglaha viewModelNaglaha;
    AddNaglaModel request = new AddNaglaModel();
    String dateStr="";
    String timeStr="";
    String timetypeStr="";  //now or later
    String details="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__nagla__date);
        ButterKnife.bind(this);
        initListener();

        date = (TextView) findViewById(R.id.dateTxt);
        time = (TextView) findViewById(R.id.time_txt);
        moreDetails=(EditText)findViewById(R.id.details);

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

        timetypeStr="later";

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
        timeStr=time.getText().toString();
        dateStr=date.getText().toString();
        timetypeStr="now";

    }

    @OnClick(R.id.submitNaglaha)
    void submit() {

        details=moreDetails.getText().toString();
        request.setTime(timeStr);
        request.setDate(dateStr);
        request.setNglahTimeType(timetypeStr);
        request.setDetails(details);

    }

    @OnClick(R.id.cancel)
    void cancel() {
        goToMain();
    }


    private void initListener() {
        viewModelNaglaha = ViewModelProviders.of(this).get(ViewModelNaglaha.class);

        viewModelNaglaha.makeNewNaglaha().
                observe(this, new Observer<UserRequestNaqlahResponse>() {
            @Override
            public void onChanged(UserRequestNaqlahResponse response) {
                goToMain();
            }
        });
    }


    void goToMain() {
        startActivity(new Intent(this, MainActivity_User.class));
    }
}

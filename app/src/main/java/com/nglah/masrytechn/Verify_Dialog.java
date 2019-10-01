package com.nglah.masrytechn;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Verify_Dialog extends AppCompatActivity {

    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify__dialog);
        final View view = getLayoutInflater().inflate(R.layout.activity_verify__dialog, null);
        alertDialog = new AlertDialog.Builder(Verify_Dialog.this).create();
        alertDialog.setTitle("ادخل رمز التاكيد");
        alertDialog.setCancelable(false);
//        alertDialog.setMessage("Your Message Here");
//        alertDialog.setIcon(R.drawable.key);


        final EditText etComments = (EditText) view.findViewById(R.id.etComments);

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "تاكيد", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "الغاء", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss() ;
            }
        });


        alertDialog.setView(view);
        alertDialog.show();
    }
}

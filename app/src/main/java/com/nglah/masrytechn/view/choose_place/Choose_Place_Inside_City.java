package com.nglah.masrytechn.view.choose_place;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.nglah.masrytechn.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Choose_Place_Inside_City extends AppCompatActivity {
    private Spinner spinnerCountry, spinnerRegion, spinnerCity;
    private Toolbar toolbar;
    private ImageView imgBackRecent;
    private ArrayAdapter<String> adapterCountry,adapterRegion,adapterCity;
    ArrayList<String> countryList=new ArrayList<>();
    ArrayList<String>regionList=new ArrayList<>();
    ArrayList<String>citylist=new ArrayList<>();
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    boolean flag=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__place__inside__city);
        sharedPreferences=getSharedPreferences("inside_City_File",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        countryList.add("- اختر الدوله -");
        countryList.add("السعوديه");
        countryList.add("Sedan");
        regionList.add("- اختر المنطقه -");
        regionList.add("كنبه");
        regionList.add("سرير");
        regionList.add("دولاب");
        regionList.add("المزيد");
        citylist.add("- اختر المدينه -");
        citylist.add("دهانات");
        citylist.add("خرصانه");
        citylist.add("اسمنت");
        citylist.add("حديد");
        citylist.add("خشب");
        citylist.add("طوب");
        citylist.add("المزيد");

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_next)
    void next(){
        startActivity(new Intent(this, Choose_Element.class));


    }
    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        imgBackRecent = (ImageView) findViewById(R.id.imgBackRecent);
        spinnerCountry = (Spinner) findViewById(R.id.sp_country);
        spinnerRegion = (Spinner) findViewById(R.id.sp_region);
        spinnerCity = (Spinner) findViewById(R.id.sp_city);
    }
    private void action(){

        imgBackRecent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(Choose_Element.this,InsideOrOutsideTown.class));
                finish();
            }
        });

        adapterCountry = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, countryList) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = view.findViewById(android.R.id.text1);
                tv.setTextColor(Color.parseColor("#037D8D"));

                return view;
            }
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.parseColor("#037D8D"));

                return view;

            }
        };
        spinnerCountry.setAdapter(adapterCountry);

        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i==0){
                    spinnerRegion.setVisibility(View.GONE);
                    spinnerCity.setVisibility(View.GONE);
                    flag=false;

//                }else if(i==carlist.size()-1){
//                    showAlertDialog();
                } else {
                    editor.putString("thing_type_elment"," اختر الدوله "+spinnerCountry.getSelectedItem().toString());
                    editor.commit();
                    spinnerRegion.setVisibility(View.VISIBLE);

                    flag=true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        adapterRegion = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, regionList) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = view.findViewById(android.R.id.text1);
                tv.setTextColor(Color.parseColor("#037D8D"));
                return view;
            }
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.parseColor("#037D8D"));

                return view;

            }
        };
        spinnerRegion.setAdapter(adapterRegion);

        spinnerRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i==0){
                    spinnerCity.setVisibility(View.GONE);
                    flag=false;

//                }else if(i==asaslist.size()-1){
//                    showAlertDialog();
                }else {
                    editor.putString("thing_type_elment"," اختر المنطقه "+spinnerRegion.getSelectedItem().toString());
                    spinnerCity.setVisibility(View.VISIBLE);
                    flag=true;
                    editor.commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        adapterCity = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, citylist) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = view.findViewById(android.R.id.text1);
                tv.setTextColor(Color.parseColor("#037D8D"));
                return view;
            }
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.parseColor("#037D8D"));

                return view;

            }
        };
        spinnerCity.setAdapter(adapterCity);

        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i==0){

                    flag=false;

//                }else if(i==citylist.size()-1){
//                    showAlertDialog();
                }else {
                    editor.putString("thing_type_elment"," اختر المدينه "+spinnerCity.getSelectedItem().toString());

                    flag=true;
                    editor.commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





    }


    //    private void showAlertDialog(){
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(Choose_Element.this);
//        final EditText editText = new EditText(Choose_Element.this);
//        builder.setView(editText);
////        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
////            @Override
////            public void onClick(DialogInterface dialogInterface, int i) {
////
////                editor.putString("thing_type_elment", editText.getText().toString());
////                editor.commit();
////                flag = true;
////                dialogInterface.dismiss();
////            }
////        });
////
////        builder.setNegativeButton(R.string.cancle, new DialogInterface.OnClickListener() {
////            @Override
////            public void onClick(DialogInterface dialogInterface, int i) {
////                flag = false;
////                dialogInterface.dismiss();
////            }
////        });
//
//        builder.show();
//        if (editText.getText().toString().isEmpty()){
//            flag=false;
//        }
//
//    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        startActivity(new Intent(Choose_Element.this,InsideOrOutsideTown.class));
        finish();
    }
}

package com.nglah.masrytechn.view.choose_place;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

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
}

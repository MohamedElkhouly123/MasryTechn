package com.nglah.masrytechn.view.choose_place;

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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.nglah.masrytechn.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Choose_Place_Inside_City extends AppCompatActivity {
    private Spinner spinnerCountry, spinnerRegion, spinnerCity;
    private Toolbar toolbar;
    private ImageView imgBackRecent;
    private ArrayAdapter<String> adapterCountry, adapterRegion, adapterCity;
    ArrayList<String> countryList = new ArrayList<>();
    ArrayList<String> regionList = new ArrayList<>();
    ArrayList<String> citylistSekaka1 = new ArrayList<>();
    ArrayList<String> citylistHodod2 = new ArrayList<>();
    ArrayList<String> citylistTabok3 = new ArrayList<>();
    ArrayList<String> citylistHaal4 = new ArrayList<>();
    ArrayList<String> citylistMonawara5 = new ArrayList<>();
    ArrayList<String> citylistKaseem6 = new ArrayList<>();
    ArrayList<String> citylistMaka7 = new ArrayList<>();
    ArrayList<String> citylistRead8 = new ArrayList<>();
    ArrayList<String> citylistSharkia9 = new ArrayList<>();
    ArrayList<String> citylistBaha10 = new ArrayList<>();
    ArrayList<String> citylistAaser11 = new ArrayList<>();
    ArrayList<String> citylistgasan12 = new ArrayList<>();
    ArrayList<String> citylistNagran13 = new ArrayList<>();
    String country = "";
    String region = "";
    String city = "";
    AddNaglaModel request;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    boolean flag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__place__inside__city);

        request= (AddNaglaModel) getIntent().getSerializableExtra("request");



        sharedPreferences = getSharedPreferences("inside_City_File", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        countryList.add("- اختر الدوله -");
        countryList.add("السعوديه");
        regionList.add("- اختر المنطقه -");
        regionList.add("سكاكا");
        regionList.add("الحدود الشماليه");
        regionList.add("تبوك");
        regionList.add("حائل");
        regionList.add("المدينه المنوره");
        regionList.add("القصيم");
        regionList.add("مكه المكرمه");
        regionList.add("الرياض");
        regionList.add("الشرقيه");
        regionList.add("الباحه");
        regionList.add("عسير");
        regionList.add("جازان");
        regionList.add("نجران");

        citylistSekaka1.add("- اختر المدينه -");
        citylistSekaka1.add("سكاكا");
        citylistSekaka1.add("دومه الجندل");
        citylistSekaka1.add("القريات");
        citylistSekaka1.add("طبرجل");

        citylistHodod2.add("- اختر المدينه -");
        citylistHodod2.add("رفحاء");
        citylistHodod2.add("طريف");
        citylistHodod2.add("العويقيليه");
        citylistHodod2.add("عرعر");
        citylistHodod2.add("شعبه نصاب");

        citylistTabok3.add("- اختر المدينه -");
        citylistTabok3.add("تيماء");
        citylistTabok3.add("ضباء");
        citylistTabok3.add("الوجه");
        citylistTabok3.add("حقل");
        citylistTabok3.add("البدع");

        citylistHaal4.add("- اختر المدينه -");
        citylistHaal4.add("بقعاء");
        citylistHaal4.add("الغزاله");
        citylistHaal4.add("الشنان");
        citylistHaal4.add("موقق");
        citylistHaal4.add("الحائط");
        citylistHaal4.add("السليمى");
        citylistHaal4.add("الشملى");
        citylistHaal4.add("سميراء");

        citylistMonawara5.add("- اختر المدينه -");
        citylistMonawara5.add("ينبع");
        citylistMonawara5.add("العلا");
        citylistMonawara5.add("الحناكيه");
        citylistMonawara5.add("مهد الذهب");
        citylistMonawara5.add("خيبر");
        citylistMonawara5.add("بدر");
        citylistMonawara5.add("السويرقيه");
        citylistMonawara5.add("العيص");
        citylistMonawara5.add("وادى الفرع");

        citylistKaseem6.add("- اختر المدينه -");
        citylistKaseem6.add("عنيزه");
        citylistKaseem6.add("الاسياح");
        citylistKaseem6.add("المذنب");
        citylistKaseem6.add("البكيريه");
        citylistKaseem6.add("البدائع");
        citylistKaseem6.add("الرس");
        citylistKaseem6.add("عيون الجواء");
        citylistKaseem6.add("رياض الخبراء");
        citylistKaseem6.add("الشماسيه");
        citylistKaseem6.add("عقله الصقور");
        citylistKaseem6.add("ضريه");
        citylistKaseem6.add("دخنه");
        citylistKaseem6.add("النبهانيه");
        citylistKaseem6.add("الخبراء");
        citylistKaseem6.add("صبيح");

        citylistMaka7.add("- اختر المدينه -");
        citylistMaka7.add("جده");
        citylistMaka7.add("الطائف");
        citylistMaka7.add("رابغ");
        citylistMaka7.add("الكامل");
        citylistMaka7.add("القنفذه");
        citylistMaka7.add("تربه");
        citylistMaka7.add("الليث");
        citylistMaka7.add("الجموم");
        citylistMaka7.add("خليص");
        citylistMaka7.add("اضم");
        citylistMaka7.add("الخرمه");
        citylistMaka7.add("رنيه");
        citylistMaka7.add("العرضيات");
        citylistMaka7.add("املويه");
        citylistMaka7.add("ميسان");
        citylistMaka7.add("بحره");

        citylistRead8.add("- اختر المدينه -");
        citylistRead8.add("الدرعيه");
        citylistRead8.add("المجمعه");
        citylistRead8.add("الغاط");
        citylistRead8.add("الخرج");
        citylistRead8.add("الدوادمى");
        citylistRead8.add("القويعيه");
        citylistRead8.add("وادى الدواسر");
        citylistRead8.add("الافلاج");
        citylistRead8.add("الزلفى");
        citylistRead8.add("شقراء");
        citylistRead8.add("حوطه بنى تميم");
        citylistRead8.add("عفيف");
        citylistRead8.add("السليل");
        citylistRead8.add("ضرما");
        citylistRead8.add("المزاحميه");
        citylistRead8.add("رماح");
        citylistRead8.add("ثادق");
        citylistRead8.add("حريملاء");
        citylistRead8.add("الحريق");
        citylistRead8.add("مرات");

        citylistSharkia9.add("- اختر المدينه -");
        citylistSharkia9.add("الاحساء");
        citylistSharkia9.add("الخبر");
        citylistSharkia9.add("الجبيل");
        citylistSharkia9.add("حفر الباطن");
        citylistSharkia9.add("النعيريه");
        citylistSharkia9.add("القطيف");
        citylistSharkia9.add("الخفجى");
        citylistSharkia9.add("راس تنوره");
        citylistSharkia9.add("بقيق");
        citylistSharkia9.add("قريه العليا");
        citylistSharkia9.add("العديد");

        citylistBaha10.add("- اختر المدينه -");
        citylistBaha10.add("بلجرشى");
        citylistBaha10.add("المندق");
        citylistBaha10.add("المخواه");
        citylistBaha10.add("العقيق");
        citylistBaha10.add("قلوه");
        citylistBaha10.add("القرى");
        citylistBaha10.add("بنى حسن");
        citylistBaha10.add("الحجره");
        citylistBaha10.add("غامد");

        citylistAaser11.add("- اختر المدينه -");
        citylistAaser11.add("بارق");
        citylistAaser11.add("خميس مشيط");
        citylistAaser11.add("بيشه");
        citylistAaser11.add("النماص");
        citylistAaser11.add("احد رفيده");
        citylistAaser11.add("بارق");
        citylistAaser11.add("البرك");
        citylistAaser11.add("بلقرن");
        citylistAaser11.add("تثليث");
        citylistAaser11.add("تنومه");
        citylistAaser11.add("رجال المع");
        citylistAaser11.add("رجال المع");
        citylistAaser11.add("سرات عبيده");
        citylistAaser11.add("طريب");
        citylistAaser11.add("ظهران الجنوب");
        citylistAaser11.add("محايل");
        citylistAaser11.add("المجارده");

        citylistgasan12.add("- اختر المدينه -");
        citylistgasan12.add("صبيا");
        citylistgasan12.add("صامطه");
        citylistgasan12.add("ابو عريش");
        citylistgasan12.add("جازان");
        citylistgasan12.add("احد المسارحه");
        citylistgasan12.add("بيش");
        citylistgasan12.add("العارضه");
        citylistgasan12.add("ضمد");
        citylistgasan12.add("الدرب");
        citylistgasan12.add("العيدابى");
        citylistgasan12.add("الدائر");
        citylistgasan12.add("الريث");
        citylistgasan12.add("الحرث");
        citylistgasan12.add("فرسان");
        citylistgasan12.add("الطوال");
        citylistgasan12.add("هروب");
        citylistgasan12.add("فيفاء");

        citylistNagran13.add("- اختر المدينه -");
        citylistNagran13.add("نجران");
        citylistNagran13.add("شروره");
        citylistNagran13.add("الحصينيه");
        citylistNagran13.add("حبونا");
        citylistNagran13.add("ثار");
        citylistNagran13.add("يدمه");
        citylistNagran13.add("بدر الجنوب");
        citylistNagran13.add("خباش");
        citylistNagran13.add("الخرخير");




        initView();
        action();

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_next)
    void next() {
        request.setCountry(country);
        request.setRegion(region);
        request.setFromCity(city);
        Toast.makeText(this,country, Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(this, Choose_Element.class);
        intent.putExtra("request",request);
        startActivity(intent);

    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        imgBackRecent = (ImageView) findViewById(R.id.imgBackRecent);
        spinnerCountry = (Spinner) findViewById(R.id.sp_country);
        spinnerRegion = (Spinner) findViewById(R.id.sp_region);
        spinnerCity = (Spinner) findViewById(R.id.sp_city);
    }

    private void action() {

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

                if (i == 0) {
                    spinnerRegion.setVisibility(View.GONE);
                    spinnerCity.setVisibility(View.GONE);
                    flag = false;
                    country="";

//                }else if(i==carlist.size()-1){
//                    showAlertDialog();
                } else {
                    editor.putString("thing_type_elment", " اختر الدوله " + spinnerCountry.getSelectedItem().toString());
                    editor.commit();
                    spinnerRegion.setVisibility(View.VISIBLE);
                    country = spinnerCountry.getItemAtPosition(i).toString();
                    flag = true;
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

                if (i == 0) {
                    spinnerCity.setVisibility(View.GONE);
                    flag = false;
                    region="";


                } else if (i == 1) {
                    addCity(citylistSekaka1);
                    editor.putString("thing_type_elment", " أثاث " + spinnerRegion.getSelectedItem().toString());
                    spinnerCity.setVisibility(View.VISIBLE);
                    flag = true;
                    editor.commit();
                    region = spinnerRegion.getItemAtPosition(i).toString();


                } else if (i == 2) {
                    addCity(citylistHodod2);
                    editor.putString("thing_type_elment", " أثاث " + spinnerRegion.getSelectedItem().toString());
                    spinnerCity.setVisibility(View.VISIBLE);
                    flag = true;
                    editor.commit();
                    region = spinnerRegion.getItemAtPosition(i).toString();


                } else if (i == 3) {
                    addCity(citylistTabok3);
                    editor.putString("thing_type_elment", " أثاث " + spinnerRegion.getSelectedItem().toString());
                    spinnerCity.setVisibility(View.VISIBLE);
                    flag = true;
                    editor.commit();
                    region = spinnerRegion.getItemAtPosition(i).toString();


                } else if (i == 4) {
                    addCity(citylistHaal4);
                    editor.putString("thing_type_elment", " أثاث " + spinnerRegion.getSelectedItem().toString());
                    spinnerCity.setVisibility(View.VISIBLE);
                    flag = true;
                    editor.commit();
                    region = spinnerRegion.getItemAtPosition(i).toString();


                } else if (i == 5) {
                    addCity(citylistMonawara5);
                    editor.putString("thing_type_elment", " أثاث " + spinnerRegion.getSelectedItem().toString());
                    spinnerCity.setVisibility(View.VISIBLE);
                    flag = true;
                    editor.commit();
                    region = spinnerRegion.getItemAtPosition(i).toString();


                } else if (i == 6) {
                    addCity(citylistKaseem6);
                    editor.putString("thing_type_elment", " أثاث " + spinnerRegion.getSelectedItem().toString());
                    spinnerCity.setVisibility(View.VISIBLE);
                    flag = true;
                    editor.commit();
                    region = spinnerRegion.getItemAtPosition(i).toString();


                } else if (i == 7) {
                    addCity(citylistMaka7);
                    editor.putString("thing_type_elment", " أثاث " + spinnerRegion.getSelectedItem().toString());
                    spinnerCity.setVisibility(View.VISIBLE);
                    flag = true;
                    editor.commit();
                    region = spinnerRegion.getItemAtPosition(i).toString();


                } else if (i == 8) {
                    addCity(citylistRead8);
                    editor.putString("thing_type_elment", " أثاث " + spinnerRegion.getSelectedItem().toString());
                    spinnerCity.setVisibility(View.VISIBLE);
                    flag = true;
                    editor.commit();
                    region = spinnerRegion.getItemAtPosition(i).toString();


                } else if (i == 9) {
                    addCity(citylistSharkia9);
                    editor.putString("thing_type_elment", " أثاث " + spinnerRegion.getSelectedItem().toString());
                    spinnerCity.setVisibility(View.VISIBLE);
                    flag = true;
                    editor.commit();
                    region = spinnerRegion.getItemAtPosition(i).toString();


                } else if (i == 10) {
                    addCity(citylistBaha10);
                    editor.putString("thing_type_elment", " أثاث " + spinnerRegion.getSelectedItem().toString());
                    spinnerCity.setVisibility(View.VISIBLE);
                    flag = true;
                    editor.commit();
                    region = spinnerRegion.getItemAtPosition(i).toString();


                } else if (i == 11) {
                    addCity(citylistAaser11);
                    editor.putString("thing_type_elment", " أثاث " + spinnerRegion.getSelectedItem().toString());
                    spinnerCity.setVisibility(View.VISIBLE);
                    flag = true;
                    editor.commit();
                    region = spinnerRegion.getItemAtPosition(i).toString();


                } else if (i == 12) {
                    addCity(citylistgasan12);
                    editor.putString("thing_type_elment", " أثاث " + spinnerRegion.getSelectedItem().toString());
                    spinnerCity.setVisibility(View.VISIBLE);
                    flag = true;
                    editor.commit();
                    region = spinnerRegion.getItemAtPosition(i).toString();


                } else if (i == 13) {
                    addCity(citylistNagran13);
                    editor.putString("thing_type_elment", " أثاث " + spinnerRegion.getSelectedItem().toString());
                    spinnerCity.setVisibility(View.VISIBLE);
                    flag = true;
                    editor.commit();
                    region = spinnerRegion.getItemAtPosition(i).toString();

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void addCity(ArrayList<String> citylist) {
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

                if (i == 0) {

                    flag = false;
                    city="";


                } else {
                    editor.putString("thing_type_elment", " مواد بناء " + spinnerCity.getSelectedItem().toString());
                    city = spinnerCity.getItemAtPosition(i).toString();

                    flag = true;
                    editor.commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

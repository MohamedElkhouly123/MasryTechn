package com.nglah.masrytechn.view.choose_place;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.view.Choose_Nagla_Dat.Choose_Nagla_Date;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Choose_Element extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView imgBackRecent;
    private Spinner car;
    private Spinner asas;
    private Spinner building;
    private Spinner other;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapterasas;
    private ArrayAdapter<String> adapterbulding;
    private ArrayAdapter<String> adapterother;
    ArrayList<String> carlist = new ArrayList<>();
    ArrayList<String> asaslist = new ArrayList<>();
    ArrayList<String> buldinglist = new ArrayList<>();
    ArrayList<String> otherlist = new ArrayList<>();
    AddNaglaModel request ;
    String elementStr = "";


    boolean flag = false;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__element);

        request= (AddNaglaModel) getIntent().getSerializableExtra("request");

        sharedPreferences = getSharedPreferences("nglah_file", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        carlist.add("- اختر سياره -");
        carlist.add("Hatchback");
        carlist.add("Sedan");
        carlist.add("MPV");
        carlist.add("SUV");
        carlist.add("Coupe");
        carlist.add("المزيد");
        asaslist.add("- اختر اثاث -");
        asaslist.add("كنبه");
        asaslist.add("سرير");
        asaslist.add("دولاب");
        asaslist.add("المزيد");
        buldinglist.add("- اختر مواد بناء -");
        buldinglist.add("دهانات");
        buldinglist.add("خرصانه");
        buldinglist.add("اسمنت");
        buldinglist.add("حديد");
        buldinglist.add("خشب");
        buldinglist.add("طوب");
        buldinglist.add("المزيد");
        otherlist.add("- شئ اخر -");
        otherlist.add("ادخال الشئ");
        ButterKnife.bind(this);

        initView();
        action();
    }

    @OnClick(R.id.btn_next)
    void next() {

        if (request!=null) {
            request.setElementType(elementStr);
            Intent intent = new Intent(this, Choose_Nagla_Date.class);
            intent.putExtra("request", request);
            startActivity(intent);
        }
    }



    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        imgBackRecent = (ImageView) findViewById(R.id.imgBackRecent);
        car = (Spinner) findViewById(R.id.car);
        asas = (Spinner) findViewById(R.id.asas);
        building = (Spinner) findViewById(R.id.building);
        other = (Spinner) findViewById(R.id.other);
    }

    private void action() {

        imgBackRecent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(Choose_Element.this,InsideOrOutsideTown.class));
                finish();
            }
        });

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, carlist) {

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
        car.setAdapter(adapter);

        car.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {
                    asas.setVisibility(View.VISIBLE);
                    building.setVisibility(View.VISIBLE);
                    other.setVisibility(View.VISIBLE);
                    flag = false;
                    elementStr = "";

                } else if (i == carlist.size() - 1) {
                    showAlertDialog();
                } else {
                    editor.putString("thing_type_elment", " سيارات " + car.getSelectedItem().toString());
                    editor.commit();
                    elementStr = car.getItemAtPosition(i).toString();

                    asas.setVisibility(View.GONE);
                    building.setVisibility(View.GONE);
                    other.setVisibility(View.GONE);
                    flag = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        adapterasas = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, asaslist) {

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
        asas.setAdapter(adapterasas);

        asas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {
                    car.setVisibility(View.VISIBLE);
                    building.setVisibility(View.VISIBLE);
                    other.setVisibility(View.VISIBLE);
                    flag = false;
                    elementStr = "";


                } else if (i == asaslist.size() - 1) {
                    showAlertDialog();
                } else {
                    editor.putString("thing_type_elment", " أثاث " + asas.getSelectedItem().toString());
                    car.setVisibility(View.GONE);
                    building.setVisibility(View.GONE);
                    other.setVisibility(View.GONE);
                    flag = true;
                    editor.commit();
                    elementStr = asas.getItemAtPosition(i).toString();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        adapterbulding = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, buldinglist) {

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
        building.setAdapter(adapterbulding);

        building.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {
                    car.setVisibility(View.VISIBLE);
                    asas.setVisibility(View.VISIBLE);
                    other.setVisibility(View.VISIBLE);
                    flag = false;
                    elementStr = "";


                } else if (i == buldinglist.size() - 1) {
                    showAlertDialog();
                } else {
                    editor.putString("thing_type_elment", " مواد بناء " + building.getSelectedItem().toString());
                    car.setVisibility(View.GONE);
                    asas.setVisibility(View.GONE);
                    other.setVisibility(View.GONE);
                    flag = true;
                    editor.commit();
                    elementStr = building.getItemAtPosition(i).toString();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        adapterother = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, otherlist) {

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
        other.setAdapter(adapterother);


        other.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 1) {

                    showAlertDialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }


    private void showAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Choose_Element.this);
        final EditText editText = new EditText(Choose_Element.this);
        builder.setView(editText);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                editor.putString("thing_type_elment", editText.getText().toString());
                editor.commit();
                flag = true;
                elementStr = editText.getText().toString(); //notice
                dialogInterface.dismiss();
            }
        });

//        builder.setNegativeButton(R.string.cancle, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                flag = false;
//                dialogInterface.dismiss();
//            }
//        });
        builder.show();

        if (editText.getText().toString().isEmpty()) {
            flag = false;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        startActivity(new Intent(Choose_Element.this,InsideOrOutsideTown.class));
        finish();
    }
}

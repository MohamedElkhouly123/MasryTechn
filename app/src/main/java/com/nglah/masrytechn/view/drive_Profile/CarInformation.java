package com.nglah.masrytechn.view.drive_Profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.nglah.masrytechn.R;
import com.nglah.masrytechn.network.networkModel.request.User.RegisterCarOwnerRequest;
import com.nglah.masrytechn.view.Utils.ConvertImageToBase64;

import net.alhazmy13.mediapicker.Image.ImagePicker;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class CarInformation extends AppCompatActivity {

    @BindView(R.id.sp_carType)
    Spinner sp_carType;
    @BindView(R.id.et_panelNumber)
    TextInputEditText et_panelNumber;
    @BindView(R.id.et_maxWeight)
    TextInputEditText et_maxWeight;
    @BindView(R.id.et_driveName)
    TextInputEditText et_driverName;
    @BindView(R.id.et_city)
    Spinner et_city;
    @BindView(R.id.iv_carImage)
    ImageView iv_carImage;
    @BindView(R.id.btn_ok)
    Button btn_ok;
    @BindView(R.id.btn_cancel)
    Button btn_cancel;
    String carImage = "";
    String carType = "";
    String spinnerValue="";
    ConvertImageToBase64 convertImageToBase64;
    Bitmap imageBitmap;
    RegisterCarOwnerRequest request = new RegisterCarOwnerRequest();
    ArrayList<String> chooseCitylist=new ArrayList<>();
    private ArrayAdapter<String> adapterChooseCity;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_information);
        ButterKnife.bind(this);
        sharedPreferences=getSharedPreferences("inside_City_File",MODE_PRIVATE);
        editor=sharedPreferences.edit();

        chooseCitylist.add("- اختر المدينه -");
//1
        chooseCitylist.add("سكاكا");
        chooseCitylist.add("دومه الجندل");
        chooseCitylist.add("القريات");
        chooseCitylist.add("طبرجل");
//2
        chooseCitylist.add("رفحاء");
        chooseCitylist.add("طريف");
        chooseCitylist.add("العويقيليه");
        chooseCitylist.add("عرعر");
        chooseCitylist.add("شعبه نصاب");
//3
        chooseCitylist.add("تيماء");
        chooseCitylist.add("ضباء");
        chooseCitylist.add("الوجه");
        chooseCitylist.add("حقل");
        chooseCitylist.add("البدع");
//4
        chooseCitylist.add("بقعاء");
        chooseCitylist.add("الغزاله");
        chooseCitylist.add("الشنان");
        chooseCitylist.add("موقق");
        chooseCitylist.add("الحائط");
        chooseCitylist.add("السليمى");
        chooseCitylist.add("الشملى");
        chooseCitylist.add("سميراء");
//5
        chooseCitylist.add("ينبع");
        chooseCitylist.add("العلا");
        chooseCitylist.add("الحناكيه");
        chooseCitylist.add("مهد الذهب");
        chooseCitylist.add("خيبر");
        chooseCitylist.add("بدر");
        chooseCitylist.add("السويرقيه");
        chooseCitylist.add("العيص");
        chooseCitylist.add("وادى الفرع");
//6
        chooseCitylist.add("عنيزه");
        chooseCitylist.add("الاسياح");
        chooseCitylist.add("المذنب");
        chooseCitylist.add("البكيريه");
        chooseCitylist.add("البدائع");
        chooseCitylist.add("الرس");
        chooseCitylist.add("عيون الجواء");
        chooseCitylist.add("رياض الخبراء");
        chooseCitylist.add("الشماسيه");
        chooseCitylist.add("عقله الصقور");
        chooseCitylist.add("ضريه");
        chooseCitylist.add("دخنه");
        chooseCitylist.add("النبهانيه");
        chooseCitylist.add("الخبراء");
        chooseCitylist.add("صبيح");
//7
        chooseCitylist.add("جده");
        chooseCitylist.add("الطائف");
        chooseCitylist.add("رابغ");
        chooseCitylist.add("الكامل");
        chooseCitylist.add("القنفذه");
        chooseCitylist.add("تربه");
        chooseCitylist.add("الليث");
        chooseCitylist.add("الجموم");
        chooseCitylist.add("خليص");
        chooseCitylist.add("اضم");
        chooseCitylist.add("الخرمه");
        chooseCitylist.add("رنيه");
        chooseCitylist.add("العرضيات");
        chooseCitylist.add("املويه");
        chooseCitylist.add("ميسان");
        chooseCitylist.add("بحره");
//8
        chooseCitylist.add("الدرعيه");
        chooseCitylist.add("المجمعه");
        chooseCitylist.add("الغاط");
        chooseCitylist.add("الخرج");
        chooseCitylist.add("الدوادمى");
        chooseCitylist.add("القويعيه");
        chooseCitylist.add("وادى الدواسر");
        chooseCitylist.add("الافلاج");
        chooseCitylist.add("الزلفى");
        chooseCitylist.add("شقراء");
        chooseCitylist.add("حوطه بنى تميم");
        chooseCitylist.add("عفيف");
        chooseCitylist.add("السليل");
        chooseCitylist.add("ضرما");
        chooseCitylist.add("المزاحميه");
        chooseCitylist.add("رماح");
        chooseCitylist.add("ثادق");
        chooseCitylist.add("حريملاء");
        chooseCitylist.add("الحريق");
        chooseCitylist.add("مرات");
//9
        chooseCitylist.add("الاحساء");
        chooseCitylist.add("الخبر");
        chooseCitylist.add("الجبيل");
        chooseCitylist.add("حفر الباطن");
        chooseCitylist.add("النعيريه");
        chooseCitylist.add("القطيف");
        chooseCitylist.add("الخفجى");
        chooseCitylist.add("راس تنوره");
        chooseCitylist.add("بقيق");
        chooseCitylist.add("قريه العليا");
        chooseCitylist.add("العديد");
//10
        chooseCitylist.add("بلجرشى");
        chooseCitylist.add("المندق");
        chooseCitylist.add("المخواه");
        chooseCitylist.add("العقيق");
        chooseCitylist.add("قلوه");
        chooseCitylist.add("القرى");
        chooseCitylist.add("بنى حسن");
        chooseCitylist.add("الحجره");
        chooseCitylist.add("غامد");
//11
        chooseCitylist.add("بارق");
        chooseCitylist.add("خميس مشيط");
        chooseCitylist.add("بيشه");
        chooseCitylist.add("النماص");
        chooseCitylist.add("احد رفيده");
        chooseCitylist.add("بارق");
        chooseCitylist.add("البرك");
        chooseCitylist.add("بلقرن");
        chooseCitylist.add("تثليث");
        chooseCitylist.add("تنومه");
        chooseCitylist.add("رجال المع");
        chooseCitylist.add("رجال المع");
        chooseCitylist.add("سرات عبيده");
        chooseCitylist.add("طريب");
        chooseCitylist.add("ظهران الجنوب");
        chooseCitylist.add("محايل");
        chooseCitylist.add("المجارده");
//12
        chooseCitylist.add("صبيا");
        chooseCitylist.add("صامطه");
        chooseCitylist.add("ابو عريش");
        chooseCitylist.add("جازان");
        chooseCitylist.add("احد المسارحه");
        chooseCitylist.add("بيش");
        chooseCitylist.add("العارضه");
        chooseCitylist.add("ضمد");
        chooseCitylist.add("الدرب");
        chooseCitylist.add("العيدابى");
        chooseCitylist.add("الدائر");
        chooseCitylist.add("الريث");
        chooseCitylist.add("الحرث");
        chooseCitylist.add("فرسان");
        chooseCitylist.add("الطوال");
        chooseCitylist.add("هروب");
        chooseCitylist.add("فيفاء");
//13
        chooseCitylist.add("نجران");
        chooseCitylist.add("شروره");
        chooseCitylist.add("الحصينيه");
        chooseCitylist.add("حبونا");
        chooseCitylist.add("ثار");
        chooseCitylist.add("يدمه");
        chooseCitylist.add("بدر الجنوب");
        chooseCitylist.add("خباش");
        chooseCitylist.add("الخرخير");
        action();
        convertImageToBase64 = new ConvertImageToBase64();

        sp_carType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                carType = sp_carType.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    @Optional
    @OnClick(R.id.list)void  back(){
        finish();
    }
    @OnClick(R.id.btn_ok)
    void ok() {

        if (validateDate()) {
            request.setCarType(carType);
            request.setPlateNumber(et_panelNumber.getText().toString());
            request.setMaxWeight(et_maxWeight.getText().toString());
            request.setCarIcon(carImage);
            request.setCurrentCity(spinnerValue);
            request.setCity(spinnerValue);

            goToCompleteRegister();
        }
    }

    @OnClick(R.id.tv_selectImage)
    void selectCarImage() {

        openGallery();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ImagePicker.IMAGE_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> mPaths = data.getStringArrayListExtra(ImagePicker.EXTRA_IMAGE_PATH);
            for (String imagePath : mPaths) {
                carImage = convertImageToBase64.convertBitmapToDataUrl(BitmapFactory.decodeFile(imagePath));
                imageBitmap = BitmapFactory.decodeFile(imagePath);
                iv_carImage.setVisibility(View.VISIBLE);
                iv_carImage.setImageBitmap(imageBitmap);
            }
        }
    }


    private void openGallery() {
        new ImagePicker.Builder(CarInformation.this)
                .mode(ImagePicker.Mode.CAMERA_AND_GALLERY)
                .compressLevel(ImagePicker.ComperesLevel.MEDIUM)
                .allowMultipleImages(true)
                .build();
    }

    void goToCompleteRegister() {
        Intent intent = new Intent(this, DriverDataModel.class);
        intent.putExtra("type", "register");
        intent.putExtra("request", request);

        startActivity(intent);
    }

    private boolean validateDate() {
        if (TextUtils.isEmpty(spinnerValue)) {

            return false;
        } else if (TextUtils.isEmpty(et_maxWeight.getText().toString())) {
            return false;
        } else if (TextUtils.isEmpty(et_panelNumber.getText().toString())) {
            return false;
        }
        return true;
    }

    private void action(){


        adapterChooseCity = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, chooseCitylist) {

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
        et_city.setAdapter(adapterChooseCity);

        et_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerValue = et_city.getItemAtPosition(i).toString();

//                if (i==0){
//
//
//
//                } else {
//                    editor.putString("thing_type_elment"," سيارات "+et_city.getSelectedItem().toString());
//                    editor.commit();
//                    spinnerValue =et_city.getSelectedItem().toString();
//                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
}

}

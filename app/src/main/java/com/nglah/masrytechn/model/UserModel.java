package com.nglah.masrytechn.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "user")

public class UserModel implements Serializable {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "access_token")
    private String accessToken = "";

    @SerializedName("isActive")
    @ColumnInfo(name = "active")
    private int active = 0;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private String id;

    @SerializedName("user_name")
    @ColumnInfo(name = "userName")
    private String UserName;

    @SerializedName("first_name")
    @ColumnInfo(name = "firstName")
    private String firstName;


    @SerializedName("last_name")
    @ColumnInfo(name = "lastName")
    private String lastName;


    @SerializedName("user_type")
    @ColumnInfo(name = "userType")
    private Integer userType;

    @SerializedName("email")
    @ColumnInfo(name = "email")
    private String Email;

    @SerializedName("phone")
    @ColumnInfo(name = "phone")
    private String Phone;

    @SerializedName("location")
    @ColumnInfo(name = "location")
    private String location;

    @SerializedName("image_url")
    @ColumnInfo(name = "image")
    private String imageUrl;
    @SerializedName("car_type")
    @ColumnInfo(name = "carType")
    private String carType;

    @SerializedName("PlateNumber")
    @ColumnInfo(name = "Plate_number")
    private String PlateNumber;

    @SerializedName("max_weight")
    @ColumnInfo(name = "MaxWeight")
    private String MaxWeight;

    @SerializedName("city")
    @ColumnInfo(name = "city")
    private String city;

    @SerializedName("current_city")
    @ColumnInfo(name = "CurrentCity")
    private String CurrentCity;

    @SerializedName("car_icon")
    @ColumnInfo(name = "CarIcon")
    private String CarIcon;
    @SerializedName("UserPhoto")

    @Expose
    private String LicenseNum;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("IDnumber")
    @Expose
    private String idNumber;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }


    @Ignore
    public static UserModel loggedInUser = null;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NonNull
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(@NonNull String accessToken) {
        this.accessToken = accessToken;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getPlateNumber() {
        return PlateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        PlateNumber = plateNumber;
    }

    public String getMaxWeight() {
        return MaxWeight;
    }

    public void setMaxWeight(String maxWeight) {
        MaxWeight = maxWeight;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCurrentCity() {
        return CurrentCity;
    }

    public void setCurrentCity(String currentCity) {
        CurrentCity = currentCity;
    }

    public String getCarIcon() {
        return CarIcon;
    }

    public void setCarIcon(String carIcon) {
        CarIcon = carIcon;
    }


    public String getLicenseNum() {
        return LicenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        LicenseNum = licenseNum;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}

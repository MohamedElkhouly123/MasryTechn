package com.nglah.masrytechn.network.networkModel.request.User;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RegisterCarOwnerRequest implements Serializable {

    @SerializedName("carType")
    @Expose
    private String carType;
    @SerializedName("PlateNumber")
    @Expose
    private String plateNumber;
    @SerializedName("MaxWeight")
    @Expose
    private String maxWeight;
    @SerializedName("fname")
    @Expose
    private String fname;
    @SerializedName("lname")
    @Expose
    private String lname;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("CurrentCity")
    @Expose
    private String currentCity;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("CarIcon")
    @Expose
    private String carIcon;
    @SerializedName("Token")
    @Expose
    private String token;
    @SerializedName("UserPhoto")
    @Expose
    private String userPhoto;
    @SerializedName("LicenseNum")
    @Expose
    private String licenseNum;
    @SerializedName("IDnumber")
    @Expose
    private String idNumber;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(String maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCarIcon() {
        return carIcon;
    }

    public void setCarIcon(String carIcon) {
        this.carIcon = carIcon;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

}


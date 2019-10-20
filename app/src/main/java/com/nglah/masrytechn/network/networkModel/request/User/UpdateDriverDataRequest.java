package com.nglah.masrytechn.network.networkModel.request.User;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateDriverDataRequest {

    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("fname")
    @Expose
    private String fname;
    @SerializedName("OldEmail")
    @Expose
    private String oldEmail;
    @SerializedName("lname")
    @Expose
    private String lname;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("PlateNumber")
    @Expose
    private String plateNumber;
    @SerializedName("carType")
    @Expose
    private String carType;
    @SerializedName("MaxWeight")
    @Expose
    private String maxWeight;
    @SerializedName("CurrentCity")
    @Expose
    private String currentCity;
    @SerializedName("CarIcon")
    @Expose
    private String carIcon;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("LicenseNum")
    @Expose
    private String licenseNum;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("UserPhoto")
    @Expose
    private String userPhoto;
    @SerializedName("IDnumber")
    @Expose
    private String iDnumber;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getOldEmail() {
        return oldEmail;
    }

    public void setOldEmail(String oldEmail) {
        this.oldEmail = oldEmail;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(String maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getCarIcon() {
        return carIcon;
    }

    public void setCarIcon(String carIcon) {
        this.carIcon = carIcon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getIDnumber() {
        return iDnumber;
    }

    public void setIDnumber(String iDnumber) {
        this.iDnumber = iDnumber;
    }
    }

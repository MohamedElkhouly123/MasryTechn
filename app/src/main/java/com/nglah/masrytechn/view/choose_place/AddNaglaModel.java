package com.nglah.masrytechn.view.choose_place;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddNaglaModel {

    @SerializedName("nglah_id")
    @Expose
    private int nglahId;

    private String driverId;

    @SerializedName("naglahOwnerName")
    @Expose
    private String naglahOwnerName;

//    @SerializedName("first_name")
//    @Expose
//    private String firstName;
//
//    @SerializedName("last_name")
//    @Expose
//    private String lastName;
    // naglaOwnerName= firstName + lastName

    @SerializedName("whereNagla")
    @Expose
    private String whereNagla;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("region")
    @Expose
    private String region;

    @SerializedName("fromCity")
    @Expose
    private String fromCity;

    @SerializedName("toCity")
    @Expose
    private String toCity;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("nglah_type")
    @Expose
    private String nglahType;

    @SerializedName("element_type")
    @Expose
    private String elementType;

//    @SerializedName("sector")
//    @Expose
//    private String sector;

    @SerializedName("timeType")
    @Expose
    private String nglahTimeType;  // now or later

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("time")
    @Expose
    private String time;

    @SerializedName("details")
    @Expose
    private String details;


    public AddNaglaModel(String firstName, String lastName, String email) {
//        this.firstName = firstName;
//        this.lastName = lastName;
        this.email = email;
    }

    public AddNaglaModel() {

    }


    public int getNglahId() {
        return nglahId;
    }

    public void setNglahId(int nglahId) {
        this.nglahId = nglahId;
    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public String getWhereNagla() {
        return whereNagla;
    }

    public void setWhereNagla(String whereNagla) {
        this.whereNagla = whereNagla;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNglahType() {
        return nglahType;
    }

    public void setNglahType(String nglahType) {
        this.nglahType = nglahType;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String thingType) {
        this.elementType = thingType;
    }

    public String getNglahTimeType() {
        return nglahTimeType;
    }

    public void setNglahTimeType(String nglahTimeType) {
        this.nglahTimeType = nglahTimeType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }



}

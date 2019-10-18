package com.nglah.masrytechn.view.choose_place;

import java.io.Serializable;

public class AddNaglaModel implements Serializable {

    private String whereNagla;
    private String country;
    private String region;
    private String fromCity;
    private String toCity;
    private String email;
    private String nglahType;
    private String elementType;
    private String nglahTimeType;  // now or later
    private String date;
    private String time;
    private String details;


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

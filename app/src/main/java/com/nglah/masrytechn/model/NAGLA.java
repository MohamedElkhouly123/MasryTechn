package com.nglah.masrytechn.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NAGLA { @SerializedName("nglah_id")
@Expose
private int nglahId;

    @SerializedName("first_name")
    @Expose
    private String firstName;

    @SerializedName("last_name")
    @Expose
    private String lastName;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("nglah_type")
    @Expose
    private String nglahType;

    @SerializedName("thing_type")
    @Expose
    private String thingType;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("sector")
    @Expose
    private String sector;

    @SerializedName("nglah_time")
    @Expose
    private String nglah_time;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("time")
    @Expose
    private String time;

    @SerializedName("details")
    @Expose
    private String details;


    public NAGLA(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getNglah_time() {
        return nglah_time;
    }

    public int getNglahId() {
        return nglahId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getNglahType() {
        return nglahType;
    }

    public String getThingType() {
        return thingType;
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDetails() {
        return details;
    }
}

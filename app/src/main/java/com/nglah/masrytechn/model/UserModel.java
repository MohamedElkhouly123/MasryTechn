package com.nglah.masrytechn.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

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

    @SerializedName("userName")
    @ColumnInfo(name = "userName")
    private String UserName;

    @SerializedName("firstName")
    @ColumnInfo(name = "firstName")
    private String firstName;


    @SerializedName("lastName")
    @ColumnInfo(name = "lastName")
    private String lastName;

    @SerializedName("userType")
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

    @SerializedName("imageUrl")
    @ColumnInfo(name = "image")
    private String imageUrl;



    @Ignore
    public static UserModel loggedInUser = null;

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
}

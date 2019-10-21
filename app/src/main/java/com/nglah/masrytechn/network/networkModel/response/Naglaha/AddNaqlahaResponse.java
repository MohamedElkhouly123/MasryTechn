package com.nglah.masrytechn.network.networkModel.response.Naglaha;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddNaqlahaResponse {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("FromP")
    @Expose
    private String fromP;
    @SerializedName("ToP")
    @Expose
    private String toP;
    @SerializedName("DriverID")
    @Expose
    private String driverID;
    @SerializedName("UserID")
    @Expose
    private String userID;
    @SerializedName("Details")
    @Expose
    private String details;
    @SerializedName("RequestedAt")
    @Expose
    private String requestedAt;
    @SerializedName("NaqlaTime")
    @Expose
    private String naqlaTime;
    @SerializedName("Price")
    @Expose
    private String price;
    @SerializedName("NaqlaDate")
    @Expose
    private String naqlaDate;
    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("Region")
    @Expose
    private String region;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("NaglahType")
    @Expose
    private String naglahType;
    @SerializedName("ElementType")
    @Expose
    private String elementType;
    @SerializedName("NaglahTimeType")
    @Expose
    private String naglahTimeType;
    @SerializedName("Token")
    @Expose
    private String token;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromP() {
        return fromP;
    }

    public void setFromP(String fromP) {
        this.fromP = fromP;
    }

    public String getToP() {
        return toP;
    }

    public void setToP(String toP) {
        this.toP = toP;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(String requestedAt) {
        this.requestedAt = requestedAt;
    }

    public String getNaqlaTime() {
        return naqlaTime;
    }

    public void setNaqlaTime(String naqlaTime) {
        this.naqlaTime = naqlaTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNaqlaDate() {
        return naqlaDate;
    }

    public void setNaqlaDate(String naqlaDate) {
        this.naqlaDate = naqlaDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNaglahType() {
        return naglahType;
    }

    public void setNaglahType(String naglahType) {
        this.naglahType = naglahType;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getNaglahTimeType() {
        return naglahTimeType;
    }

    public void setNaglahTimeType(String naglahTimeType) {
        this.naglahTimeType = naglahTimeType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

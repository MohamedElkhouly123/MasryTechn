package com.nglah.masrytechn.network.networkModel.response.driver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GetAllNaqlaResponse {
    public class Datum implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
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
        @SerializedName("NaqlaDate")
        @Expose
        private String naqlaDate;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("Token")
        @Expose
        private String token;
        @SerializedName("user")
        @Expose
        private User user;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
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

        public String getNaqlaDate() {
            return naqlaDate;
        }

        public void setNaqlaDate(String naqlaDate) {
            this.naqlaDate = naqlaDate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

    }


    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }


    public class User implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("fname")
        @Expose
        private String fname;
        @SerializedName("lname")
        @Expose
        private String lname;
        @SerializedName("mobileNumber")
        @Expose
        private String mobileNumber;
        @SerializedName("Email")
        @Expose
        private String email;
        @SerializedName("userName")
        @Expose
        private String userName;
        @SerializedName("LicenseNum")
        @Expose
        private Object licenseNum;
        @SerializedName("UserPhoto")
        @Expose
        private Object userPhoto;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Object getLicenseNum() {
            return licenseNum;
        }

        public void setLicenseNum(Object licenseNum) {
            this.licenseNum = licenseNum;
        }

        public Object getUserPhoto() {
            return userPhoto;
        }

        public void setUserPhoto(Object userPhoto) {
            this.userPhoto = userPhoto;
        }
    }
}

package com.nglah.masrytechn.network.networkModel.response.driver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class UserHistoryResponse {

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
        @SerializedName("driver")
        @Expose
        private List<Driver> driver = null;

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

        public List<Driver> getDriver() {
            return driver;
        }

        public void setDriver(List<Driver> driver) {
            this.driver = driver;
        }

    }


    public class Driver implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
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
        private String iDnumber;
        @SerializedName("Price")
        @Expose
        private String price;
        @SerializedName("rate")
        @Expose
        private Integer rate;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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

        public String getIDnumber() {
            return iDnumber;
        }

        public void setIDnumber(String iDnumber) {
            this.iDnumber = iDnumber;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public Integer getRate() {
            return rate;
        }

        public void setRate(Integer rate) {
            this.rate = rate;
        }

    }


    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    String message;


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

}

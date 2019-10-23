package com.nglah.masrytechn.network.networkModel.request.driver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AcceptNqlahRequest {


    @SerializedName("driverId")
    @Expose
    private String driverId;
    @SerializedName("naqlaId")
    @Expose
    private String price;
    @SerializedName("price")
    @Expose
    private String naqlaId;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getNaqlaId() {
        return naqlaId;
    }

    public void setNaqlaId(String naqlaId) {
        this.naqlaId = naqlaId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

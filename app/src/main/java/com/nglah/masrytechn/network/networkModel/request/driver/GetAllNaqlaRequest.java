package com.nglah.masrytechn.network.networkModel.request.driver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetAllNaqlaRequest {
    @SerializedName("driverId")
    @Expose
    private String driverId;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }
}

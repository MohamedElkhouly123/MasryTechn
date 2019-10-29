package com.nglah.masrytechn.network.networkModel.request.driver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddEvaluationRequest {

    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("naqlaId")
    @Expose
    private Integer naqlaId;
    @SerializedName("rate")
    @Expose
    private Integer rate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNaqlaId() {
        return naqlaId;
    }

    public void setNaqlaId(Integer naqlaId) {
        this.naqlaId = naqlaId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}

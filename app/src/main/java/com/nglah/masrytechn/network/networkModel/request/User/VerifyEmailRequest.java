package com.nglah.masrytechn.network.networkModel.request.User;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyEmailRequest {


    @SerializedName("TO")
    @Expose
    private String tO;

    public String getTO() {
        return tO;
    }

    public void setTO(String tO) {
        this.tO = tO;
    }

}

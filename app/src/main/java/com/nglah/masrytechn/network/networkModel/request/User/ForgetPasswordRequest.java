package com.nglah.masrytechn.network.networkModel.request.User;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgetPasswordRequest {

    @SerializedName("TO")
    @Expose
    private String tO;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("userType")
    @Expose
    private String userType;

    public String getTO() {
        return tO;
    }

    public void setTO(String tO) {
        this.tO = tO;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}

package com.nglah.masrytechn.network.networkModel.request.Payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentRequest {

    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("cardNumber")
    @Expose
    private String cardNumber;
    @SerializedName("cardExpireMonth")
    @Expose
    private String cardExpireMonth;
    @SerializedName("cardexpiryYear")
    @Expose
    private String cardexpiryYear;
    @SerializedName("cardCvv")
    @Expose
    private String cardCvv;
    @SerializedName("cardType")
    @Expose
    private String cardType;

    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("role")
    @Expose
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpireMonth() {
        return cardExpireMonth;
    }

    public void setCardExpireMonth(String cardExpireMonth) {
        this.cardExpireMonth = cardExpireMonth;
    }

    public String getCardexpiryYear() {
        return cardexpiryYear;
    }

    public void setCardexpiryYear(String cardexpiryYear) {
        this.cardexpiryYear = cardexpiryYear;
    }

    public String getCardCvv() {
        return cardCvv;
    }

    public void setCardCvv(String cardCvv) {
        this.cardCvv = cardCvv;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}

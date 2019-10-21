package com.nglah.masrytechn.network.networkModel.response.Payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaymentResponse {


    public class Card {

        @SerializedName("bin")
        @Expose
        private String bin;
        @SerializedName("last4Digits")
        @Expose
        private String last4Digits;
        @SerializedName("holder")
        @Expose
        private String holder;
        @SerializedName("expiryMonth")
        @Expose
        private String expiryMonth;
        @SerializedName("expiryYear")
        @Expose
        private String expiryYear;

        public String getBin() {
            return bin;
        }

        public void setBin(String bin) {
            this.bin = bin;
        }

        public String getLast4Digits() {
            return last4Digits;
        }

        public void setLast4Digits(String last4Digits) {
            this.last4Digits = last4Digits;
        }

        public String getHolder() {
            return holder;
        }

        public void setHolder(String holder) {
            this.holder = holder;
        }

        public String getExpiryMonth() {
            return expiryMonth;
        }

        public void setExpiryMonth(String expiryMonth) {
            this.expiryMonth = expiryMonth;
        }

        public String getExpiryYear() {
            return expiryYear;
        }

        public void setExpiryYear(String expiryYear) {
            this.expiryYear = expiryYear;
        }

    }

    public class Customer {

        @SerializedName("givenName")
        @Expose
        private String givenName;
        @SerializedName("surname")
        @Expose
        private String surname;
        @SerializedName("email")
        @Expose
        private String email;

        public String getGivenName() {
            return givenName;
        }

        public void setGivenName(String givenName) {
            this.givenName = givenName;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    }


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("paymentType")
    @Expose
    private String paymentType;
    @SerializedName("paymentBrand")
    @Expose
    private String paymentBrand;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("descriptor")
    @Expose
    private String descriptor;
    @SerializedName("merchantTransactionId")
    @Expose
    private String merchantTransactionId;
    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("resultDetails")
    @Expose
    private ResultDetails resultDetails;
    @SerializedName("card")
    @Expose
    private Card card;
    @SerializedName("customer")
    @Expose
    private Customer customer;
    @SerializedName("redirect")
    @Expose
    private Redirect redirect;
    @SerializedName("risk")
    @Expose
    private Risk risk;
    @SerializedName("buildNumber")
    @Expose
    private String buildNumber;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("ndc")
    @Expose
    private String ndc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentBrand() {
        return paymentBrand;
    }

    public void setPaymentBrand(String paymentBrand) {
        this.paymentBrand = paymentBrand;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getMerchantTransactionId() {
        return merchantTransactionId;
    }

    public void setMerchantTransactionId(String merchantTransactionId) {
        this.merchantTransactionId = merchantTransactionId;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDetails getResultDetails() {
        return resultDetails;
    }

    public void setResultDetails(ResultDetails resultDetails) {
        this.resultDetails = resultDetails;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Redirect getRedirect() {
        return redirect;
    }

    public void setRedirect(Redirect redirect) {
        this.redirect = redirect;
    }

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNdc() {
        return ndc;
    }

    public void setNdc(String ndc) {
        this.ndc = ndc;
    }


    public class Parameter {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("value")
        @Expose
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }


    public class Redirect {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("parameters")
        @Expose
        private List<Parameter> parameters = null;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<Parameter> getParameters() {
            return parameters;
        }

        public void setParameters(List<Parameter> parameters) {
            this.parameters = parameters;
        }

    }

    ;

    public class Result {

        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("description")
        @Expose
        private String description;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }


    public class ResultDetails {

        @SerializedName("ExtendedDescription")
        @Expose
        private String extendedDescription;
        @SerializedName("AcquirerResponse")
        @Expose
        private String acquirerResponse;

        public String getExtendedDescription() {
            return extendedDescription;
        }

        public void setExtendedDescription(String extendedDescription) {
            this.extendedDescription = extendedDescription;
        }

        public String getAcquirerResponse() {
            return acquirerResponse;
        }

        public void setAcquirerResponse(String acquirerResponse) {
            this.acquirerResponse = acquirerResponse;
        }

    }


    public class Risk {

        @SerializedName("score")
        @Expose
        private String score;

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

    }
}
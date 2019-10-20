package com.nglah.masrytechn.network.webservices;

import com.nglah.masrytechn.network.networkModel.request.Payment.PaymentRequest;
import com.nglah.masrytechn.network.networkModel.request.naglaha.AddNaqlaRequest;
import com.nglah.masrytechn.network.networkModel.response.Naglaha.AddNaqlahaResponse;
import com.nglah.masrytechn.network.networkModel.response.Naglaha.AllDriverResponse;
import com.nglah.masrytechn.network.networkModel.response.Payment.PaymentResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NaglahaWebServices {

    @POST("AddNaqla.php")
    @Headers({"Content-Type: application/json"})
    Observable<AddNaqlahaResponse> addNaglaha(@Body AddNaqlaRequest request);

    @POST("GetDrivers.php")
    @Headers({"Content-Type: application/json"})
    Observable<AllDriverResponse> getAllDriver();

    @POST("payment")
    @Headers({"Content-Type: application/json"})
    Observable<PaymentResponse> pay(@Body PaymentRequest request);

}

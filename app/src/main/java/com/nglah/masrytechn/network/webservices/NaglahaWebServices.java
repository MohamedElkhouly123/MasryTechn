package com.nglah.masrytechn.network.webservices;

import com.nglah.masrytechn.network.networkModel.request.Payment.PaymentRequest;
import com.nglah.masrytechn.network.networkModel.request.driver.AcceptNqlahRequest;
import com.nglah.masrytechn.network.networkModel.request.driver.GetAllNaqlaRequest;
import com.nglah.masrytechn.network.networkModel.request.naglaha.AddNaqlaRequest;
import com.nglah.masrytechn.network.networkModel.response.AcceptNaqlahaResponse;
import com.nglah.masrytechn.network.networkModel.response.Naglaha.AddNaqlahaResponse;
import com.nglah.masrytechn.network.networkModel.response.Naglaha.AllDriverResponse;
import com.nglah.masrytechn.network.networkModel.response.Payment.PaymentResponse;
import com.nglah.masrytechn.network.networkModel.response.driver.GetAllNaqlaResponse;

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

    @POST("getNaqla")
    @Headers({"Content-Type: application/json"})
    Observable<GetAllNaqlaResponse> getAllNaqla(@Body GetAllNaqlaRequest request);


    @POST("acceptNaqla")
    @Headers({"Content-Type: application/json"})
    Observable<AcceptNaqlahaResponse> acceptNaqlaha(@Body AcceptNqlahRequest request);

}

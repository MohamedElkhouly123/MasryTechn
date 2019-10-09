package com.nglah.masrytechn.network.webservices;

import com.nglah.masrytechn.network.networkModel.request.naglaha.AllDriverRequest;
import com.nglah.masrytechn.network.networkModel.request.naglaha.UserRequestNaqlahRequest;
import com.nglah.masrytechn.network.networkModel.response.Naglaha.AllDriverResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NaglahaWebServices {

    @POST("--")
    @Headers({"Content-Type: application/json"})
    Observable<UserRequestNaqlahRequest> addNaglaha(@Body  UserRequestNaqlahRequest request);

    @POST("--")
    @Headers({"Content-Type: application/json"})
    Observable<AllDriverResponse> getAllDriver(@Body AllDriverRequest request);

}

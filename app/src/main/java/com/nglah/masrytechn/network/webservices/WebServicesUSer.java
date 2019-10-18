package com.nglah.masrytechn.network.webservices;



import com.nglah.masrytechn.network.networkModel.request.User.ForgetPasswordRequest;
import com.nglah.masrytechn.network.networkModel.request.User.LoginRequest;
import com.nglah.masrytechn.network.networkModel.request.User.RegisterCarOwnerRequest;
import com.nglah.masrytechn.network.networkModel.request.User.RegisterRequest;
import com.nglah.masrytechn.network.networkModel.request.User.UpdateDriverDataRequest;
import com.nglah.masrytechn.network.networkModel.request.User.UpdateUserDataRequest;
import com.nglah.masrytechn.network.networkModel.request.User.VerifyEmailRequest;
import com.nglah.masrytechn.network.networkModel.response.User.ForgetPasswordResponse;
import com.nglah.masrytechn.network.networkModel.response.User.LoginResponse;
import com.nglah.masrytechn.network.networkModel.response.User.RegisterCarOwnerResponse;
import com.nglah.masrytechn.network.networkModel.response.User.RegisterResponse;
import com.nglah.masrytechn.network.networkModel.response.User.UpdateDriverDataResponse;
import com.nglah.masrytechn.network.networkModel.response.User.UpdateUserDataResponse;
import com.nglah.masrytechn.network.networkModel.response.User.VerifyEmailResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface WebServicesUSer {

    @POST("NaqlaOwnerSignUp.php")
    @Headers({"Content-Type: application/json"})
    Observable<RegisterResponse> Registration(@Body RegisterRequest request);

    @POST("CarOwnerSignUp.php")
    @Headers({"Content-Type: application/json"})
    Observable<RegisterCarOwnerResponse> RegistrationCarOwner(@Body RegisterCarOwnerRequest request);

    @POST("SendCode.php")
    @Headers({"Content-Type: application/json"})
    Observable<VerifyEmailResponse> verifyEmail(@Body VerifyEmailRequest request);
    @POST("NaqlaOwnerLogin.php")
    @Headers({"Content-Type: application/json"})
    Observable<LoginResponse> login(@Body LoginRequest request);

    @POST("CarOwnerLogin.php")
    @Headers({"Content-Type: application/json"})
    Observable<RegisterCarOwnerResponse> carOwnerLogin(@Body LoginRequest request);


    @POST("EditNaqlaUser.php")
    @Headers({"Content-Type: application/json"})
    Observable<UpdateUserDataResponse> updateUserData(@Body UpdateUserDataRequest request);

    @POST("EditCarUser.php")
    @Headers({"Content-Type: application/json"})
    Observable<UpdateDriverDataResponse> updateDriverData(@Body UpdateDriverDataRequest request);


    @POST("ResetPassword.php")
    @Headers({"Content-Type: application/json"})
    Observable<ForgetPasswordResponse> forgetPassword(@Body ForgetPasswordRequest request);

}

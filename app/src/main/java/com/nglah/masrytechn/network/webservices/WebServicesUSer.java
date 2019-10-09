package com.nglah.masrytechn.network.webservices;



import com.nglah.masrytechn.network.networkModel.request.User.ChangePasswordRequest;
import com.nglah.masrytechn.network.networkModel.request.User.ForgetPasswordRequest;
import com.nglah.masrytechn.network.networkModel.request.User.LoginRequest;
import com.nglah.masrytechn.network.networkModel.request.User.RegisterCarOwnerRequest;
import com.nglah.masrytechn.network.networkModel.request.User.RegisterRequest;
import com.nglah.masrytechn.network.networkModel.request.User.UpdateDriverDataRequest;
import com.nglah.masrytechn.network.networkModel.request.User.UpdateUserDataRequest;
import com.nglah.masrytechn.network.networkModel.request.User.UpdateUserImageRequest;
import com.nglah.masrytechn.network.networkModel.request.User.VerifyEmailRequest;
import com.nglah.masrytechn.network.networkModel.response.User.ChangePasswordResponse;
import com.nglah.masrytechn.network.networkModel.response.User.ForgetPasswordResponse;
import com.nglah.masrytechn.network.networkModel.response.User.GetUserInfoResponse;
import com.nglah.masrytechn.network.networkModel.response.User.LoginResponse;
import com.nglah.masrytechn.network.networkModel.response.User.RegisterCarOwnerResponse;
import com.nglah.masrytechn.network.networkModel.response.User.RegisterResponse;
import com.nglah.masrytechn.network.networkModel.response.User.UpdateDriverDataResponse;
import com.nglah.masrytechn.network.networkModel.response.User.UpdateUserDataResponse;
import com.nglah.masrytechn.network.networkModel.response.User.UpdateUserImageResponse;
import com.nglah.masrytechn.network.networkModel.response.User.VerifyEmailResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

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


    @POST("CarOwnerLogin.php")
    @Headers({"Content-Type: application/json"})
    Observable<UpdateUserDataResponse> updateUserData(@Body UpdateUserDataRequest request);

    @POST("CarOwnerLogin.php")
    @Headers({"Content-Type: application/json"})
    Observable<UpdateDriverDataResponse> updateDriverData(@Body UpdateDriverDataRequest request);


    @POST("person/password/email")
    @Headers({"Content-Type: application/json"})
    Observable<ForgetPasswordResponse> forgetPassword(@Body ForgetPasswordRequest request);

}

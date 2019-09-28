package com.nglah.masrytechn.network.webservices;



import com.nglah.masrytechn.network.networkModel.request.User.ChangePasswordRequest;
import com.nglah.masrytechn.network.networkModel.request.User.ForgetPasswordRequest;
import com.nglah.masrytechn.network.networkModel.request.User.LoginRequest;
import com.nglah.masrytechn.network.networkModel.request.User.RegisterRequest;
import com.nglah.masrytechn.network.networkModel.request.User.UpdateUserDataRequest;
import com.nglah.masrytechn.network.networkModel.request.User.UpdateUserImageRequest;
import com.nglah.masrytechn.network.networkModel.response.User.ChangePasswordResponse;
import com.nglah.masrytechn.network.networkModel.response.User.ForgetPasswordResponse;
import com.nglah.masrytechn.network.networkModel.response.User.GetUserInfoResponse;
import com.nglah.masrytechn.network.networkModel.response.User.LoginResponse;
import com.nglah.masrytechn.network.networkModel.response.User.RegisterResponse;
import com.nglah.masrytechn.network.networkModel.response.User.UpdateUserDataResponse;
import com.nglah.masrytechn.network.networkModel.response.User.UpdateUserImageResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface WebServicesUSer {

    @POST("person/register")
    @Headers({"Content-Type: application/json"})
    Observable<RegisterResponse> Registration(@Body RegisterRequest request);

    @POST("person/login")
    @Headers({"Content-Type: application/json"})
    Observable<LoginResponse> login(@Body LoginRequest request);


    @PUT("persons/user/{userId}")
    @Headers({"Content-Type: application/json"})
    Observable<UpdateUserDataResponse> EditUserProfile(@Header("Authorization") String token, @Path("userId") int userId, @Body UpdateUserDataRequest request);

    @PUT("persons/user/{userId}")
    @Headers({"Content-Type: application/json"})
    Observable<UpdateUserImageResponse> EditUserProfileImage(@Header("Authorization") String token, @Path("userId") int userId, @Body UpdateUserImageRequest request);

    @GET("persons/user/{userId}")
    @Headers({"Content-Type: application/json"})
    Observable<GetUserInfoResponse> getUserData(@Header("Authorization") String token, @Path("userId") int userId);

    @POST("person/password/change/{userId}")
    @Headers({"Content-Type: application/json"})
    Observable<ChangePasswordResponse> changePassword(@Header("Authorization") String token, @Path("userId") int userId, @Body ChangePasswordRequest request);

    @POST("person/password/email")
    @Headers({"Content-Type: application/json"})
    Observable<ForgetPasswordResponse> forgetPassword(@Body ForgetPasswordRequest request);

}

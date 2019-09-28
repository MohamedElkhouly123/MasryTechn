package com.nglah.masrytechn.repository;



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
import com.nglah.masrytechn.network.webservices.WebServicesUSer;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.nglah.masrytechn.model.UserModel.loggedInUser;


public class UserRepository {

    private WebServicesUSer webServicesUSer;

    public UserRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        String BASE_URL = "http://handasah.net/api/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        webServicesUSer = retrofit.create(WebServicesUSer.class);
    }

    // region singleton implementation
    private static class Loader {
        static UserRepository INSTANCE = new UserRepository();
    }


    public static UserRepository getInstance() {
        return Loader.INSTANCE;
    }

    public Observable<RegisterResponse> registrationRepository(final RegisterRequest request) {
        return Observable.create(new ObservableOnSubscribe<RegisterResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<RegisterResponse> emitter) {

                webServicesUSer.Registration(request).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new Observer<RegisterResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(RegisterResponse response) {
                        emitter.onNext(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        RegisterResponse response = new RegisterResponse();
                        response.setStatus(false);
                        response.setMsg(e.toString());
                        emitter.onNext(response);

                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });
    }

    public Observable<LoginResponse> loginRepository(final LoginRequest request) {
        return Observable.create(new ObservableOnSubscribe<LoginResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<LoginResponse> emitter) {


                webServicesUSer.login(request).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(LoginResponse response) {
                        emitter.onNext(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LoginResponse response = new LoginResponse();
                        response.setStatus(false);
                        response.setMsg(e.toString());
                        emitter.onNext(response);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });
    }


    public Observable<UpdateUserDataResponse> editProfileRepository(final UpdateUserDataRequest request) {
        return Observable.create(new ObservableOnSubscribe<UpdateUserDataResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<UpdateUserDataResponse> emitter) {


                webServicesUSer.EditUserProfile("Bearer " + loggedInUser.getRefreshToken(), loggedInUser.getId(), request).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new Observer<UpdateUserDataResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(UpdateUserDataResponse response) {

                        emitter.onNext(response);

                    }

                    @Override
                    public void onError(Throwable e) {
                        UpdateUserDataResponse response = new UpdateUserDataResponse();
                        response.setStatus(false);
                        response.setMsg(e.toString());
                        emitter.onNext(response);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });
    }

    public Observable<UpdateUserImageResponse> updateProfileImageRepository(final UpdateUserImageRequest request) {
        return Observable.create(new ObservableOnSubscribe<UpdateUserImageResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<UpdateUserImageResponse> emitter) {
                webServicesUSer.EditUserProfileImage("Bearer " + loggedInUser.getRefreshToken(), loggedInUser.getId(), request).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new Observer<UpdateUserImageResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(UpdateUserImageResponse response) {
                        emitter.onNext(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        UpdateUserImageResponse response = new UpdateUserImageResponse();
                        response.setStatus(false);
                        response.setMsg(e.toString());
                        emitter.onNext(response);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });
    }

    public Observable<GetUserInfoResponse> getUSerInfoRepository() {
        return Observable.create(new ObservableOnSubscribe<GetUserInfoResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<GetUserInfoResponse> emitter) {


                webServicesUSer.getUserData("Bearer " + loggedInUser.getRefreshToken(), loggedInUser.getId()).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new Observer<GetUserInfoResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(GetUserInfoResponse response) {

                        emitter.onNext(response);

                    }

                    @Override
                    public void onError(Throwable e) {
                        GetUserInfoResponse response = new GetUserInfoResponse();
                        response.setStatus(false);
                        response.setMsg(e.toString());
                        emitter.onNext(response);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });
    }

    public Observable<ChangePasswordResponse> changePasswordRepository(final ChangePasswordRequest request) {
        return Observable.create(new ObservableOnSubscribe<ChangePasswordResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<ChangePasswordResponse> emitter) {


                webServicesUSer.changePassword("Bearer " + loggedInUser.getRefreshToken(), loggedInUser.getId(), request).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new Observer<ChangePasswordResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ChangePasswordResponse response) {

                        emitter.onNext(response);

                    }

                    @Override
                    public void onError(Throwable e) {
                        ChangePasswordResponse response = new ChangePasswordResponse();
                        response.setStatus(false);
                        response.setMsg(e.toString());
                        emitter.onNext(response);

                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });
    }

    public Observable<ForgetPasswordResponse> forgetPasswordRepository(final ForgetPasswordRequest request) {
        return Observable.create(new ObservableOnSubscribe<ForgetPasswordResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<ForgetPasswordResponse> emitter) {
                webServicesUSer.forgetPassword(request).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new Observer<ForgetPasswordResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ForgetPasswordResponse response) {
                        emitter.onNext(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        ForgetPasswordResponse response = new ForgetPasswordResponse();
                        response.setStatus(false);
                        response.setMsg(e.toString());
                        emitter.onNext(response);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });
    }

}

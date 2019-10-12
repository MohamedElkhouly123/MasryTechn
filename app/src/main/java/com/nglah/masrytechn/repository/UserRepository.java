package com.nglah.masrytechn.repository;

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


public class UserRepository {

    private WebServicesUSer webServicesUSer;

    public UserRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        String BASE_URL = "https://pwalgs.com/nglah2/Users/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .client(client).addConverterFactory(GsonConverterFactory.create()).
                        addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
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
                        response.setMessage(e.toString());
                        emitter.onNext(response);

                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });
    }

    public Observable<RegisterCarOwnerResponse> registrationCarOwnerRepository
            (final RegisterCarOwnerRequest request) {
        return Observable.create(new ObservableOnSubscribe<RegisterCarOwnerResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<RegisterCarOwnerResponse> emitter) {


                webServicesUSer.RegistrationCarOwner(request).subscribeOn(Schedulers.io()).
                        observeOn(Schedulers.io()).subscribe(new Observer<RegisterCarOwnerResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(RegisterCarOwnerResponse response) {
                        emitter.onNext(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        RegisterCarOwnerResponse response = new RegisterCarOwnerResponse();
                        response.setStatus(false);
                        response.setMessage(e.toString());
                        emitter.onNext(response);

                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });
    }

    public Observable<VerifyEmailResponse> verifyEmailRepository(final VerifyEmailRequest request) {
        return Observable.create(new ObservableOnSubscribe<VerifyEmailResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<VerifyEmailResponse> emitter) {

                webServicesUSer.verifyEmail(request).subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io()).subscribe(new Observer<VerifyEmailResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(VerifyEmailResponse response) {
                        emitter.onNext(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        VerifyEmailResponse response = new VerifyEmailResponse();
                        response.setStatus(false);
                        response.setMessage(e.toString());
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


                webServicesUSer.login(request).subscribeOn(Schedulers.io()).
                        observeOn(Schedulers.io()).subscribe(new Observer<LoginResponse>() {
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
                        response.setMessage(e.toString());
                        emitter.onNext(response);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });
    }

    public Observable<RegisterCarOwnerResponse> loginCarOWnerRepository(final LoginRequest request) {
        return Observable.create(new ObservableOnSubscribe<RegisterCarOwnerResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<RegisterCarOwnerResponse> emitter) {


                webServicesUSer.carOwnerLogin(request).subscribeOn(Schedulers.io()).
                        observeOn(Schedulers.io()).subscribe(new Observer<RegisterCarOwnerResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(RegisterCarOwnerResponse response) {
                        emitter.onNext(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        RegisterCarOwnerResponse response = new RegisterCarOwnerResponse();
                        response.setStatus(false);
                        response.setMessage(e.toString());
                        emitter.onNext(response);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });
    }

    public Observable<UpdateUserDataResponse> updateUserDataRepository(final UpdateUserDataRequest request) {
        return Observable.create(new ObservableOnSubscribe<UpdateUserDataResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<UpdateUserDataResponse> emitter) {


                webServicesUSer.updateUserData(request).subscribeOn(Schedulers.io()).
                        observeOn(Schedulers.io()).subscribe(new Observer<UpdateUserDataResponse>() {
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
                        response.setMessage(e.toString());
                        emitter.onNext(response);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });
    }

    public Observable<UpdateDriverDataResponse> updateDriverDataRepository(final UpdateDriverDataRequest request) {
        return Observable.create(new ObservableOnSubscribe<UpdateDriverDataResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<UpdateDriverDataResponse> emitter) {


                webServicesUSer.updateDriverData(request).subscribeOn(Schedulers.io()).
                        observeOn(Schedulers.io()).subscribe(new Observer<UpdateDriverDataResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(UpdateDriverDataResponse response) {
                        emitter.onNext(response);

                    }

                    @Override
                    public void onError(Throwable e) {
                        UpdateDriverDataResponse response = new UpdateDriverDataResponse();
                        response.setStatus(false);
                        response.setMessage(e.toString());
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
                        response.setMessage(e.toString());
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

package com.nglah.masrytechn.repository;

import com.nglah.masrytechn.network.networkModel.request.User.RegisterRequest;
import com.nglah.masrytechn.network.networkModel.request.naglaha.UserRequestNaqlahRequest;
import com.nglah.masrytechn.network.networkModel.response.Naglaha.UserRequestNaqlahResponse;
import com.nglah.masrytechn.network.networkModel.response.User.RegisterResponse;
import com.nglah.masrytechn.network.webservices.NaglahaWebServices;
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

public class NaglahRepository {



    private NaglahaWebServices naglahaWebServices;

    public NaglahRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        String BASE_URL = "https://pwalgs.com/nglah2/Users/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        naglahaWebServices = retrofit.create(NaglahaWebServices.class);
    }

    // region singleton implementation
    private static class Loader {
        static NaglahRepository INSTANCE = new NaglahRepository();
    }


    public static NaglahRepository getInstance() {
        return NaglahRepository.Loader.INSTANCE;
    }

    public Observable<UserRequestNaqlahResponse> registrationRepository(final UserRequestNaqlahRequest request) {
        return Observable.create(new ObservableOnSubscribe<UserRequestNaqlahResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<UserRequestNaqlahResponse> emitter) {
                naglahaWebServices.addNaglaha(request).subscribeOn(Schedulers.io()).
                        observeOn(Schedulers.io()).subscribe(new Observer<UserRequestNaqlahRequest>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserRequestNaqlahRequest requestNaqlahRequest) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        UserRequestNaqlahResponse response = new UserRequestNaqlahResponse();
//                        response.setStatus(false);
//                        response.setMessage(e.toString());
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
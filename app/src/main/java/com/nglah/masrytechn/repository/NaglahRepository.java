package com.nglah.masrytechn.repository;

import com.nglah.masrytechn.network.networkModel.request.Payment.PaymentRequest;
import com.nglah.masrytechn.network.networkModel.request.naglaha.AddNaqlaRequest;
import com.nglah.masrytechn.network.networkModel.response.Naglaha.AllDriverResponse;
import com.nglah.masrytechn.network.networkModel.response.Naglaha.AddNaqlahaResponse;
import com.nglah.masrytechn.network.networkModel.response.Payment.PaymentResponse;
import com.nglah.masrytechn.network.webservices.NaglahaWebServices;

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

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                client(client).addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        naglahaWebServices = retrofit.create(NaglahaWebServices.class);
    }

    // region singleton implementation
    private static class Loader {
        static NaglahRepository INSTANCE = new NaglahRepository();
    }


    public static NaglahRepository getInstance() {
        return NaglahRepository.Loader.INSTANCE;
    }

    public Observable<AddNaqlahaResponse> addNaglahaRepository(final AddNaqlaRequest request) {
        return Observable.create(new ObservableOnSubscribe<AddNaqlahaResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<AddNaqlahaResponse> emitter) {

                naglahaWebServices.addNaglaha(request).subscribeOn(Schedulers.io()).
                        observeOn(Schedulers.io()).subscribe(new Observer<AddNaqlahaResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AddNaqlahaResponse response ) {
                        emitter.onNext(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        AddNaqlahaResponse response = new AddNaqlahaResponse();
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

    public Observable<AllDriverResponse> allDriverRepository() {
        return Observable.create(new ObservableOnSubscribe<AllDriverResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<AllDriverResponse> emitter) {
                naglahaWebServices.getAllDriver().subscribeOn(Schedulers.io()).
                        observeOn(Schedulers.io()).subscribe(new Observer<AllDriverResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AllDriverResponse response) {

                        emitter.onNext(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        AllDriverResponse response = new AllDriverResponse();
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
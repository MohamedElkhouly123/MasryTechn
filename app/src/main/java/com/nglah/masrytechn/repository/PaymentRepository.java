package com.nglah.masrytechn.repository;

import com.nglah.masrytechn.network.networkModel.request.Payment.PaymentRequest;
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

public class PaymentRepository {



    private NaglahaWebServices naglahaWebServices;

    public PaymentRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        String BASE_URL = "http://pym.pwalgs.com/api/";

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        naglahaWebServices = retrofit.create(NaglahaWebServices.class);
    }

    // region singleton implementation
    private static class Loader {
        static PaymentRepository INSTANCE = new PaymentRepository();
    }


    public static PaymentRepository getInstance() {
        return PaymentRepository.Loader.INSTANCE;
    }


    public Observable<PaymentResponse> paymentRepository(PaymentRequest request) {
        return Observable.create(new ObservableOnSubscribe<PaymentResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<PaymentResponse> emitter) {
                naglahaWebServices.pay(request).subscribeOn(Schedulers.io()).
                        observeOn(Schedulers.io()).subscribe(new Observer<PaymentResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(PaymentResponse response) {
                        emitter.onNext(response);
                    }
                    @Override
                    public void onError(Throwable e) {
//                        PaymentResponse response = new PaymentResponse();
//                        response.getResult().setCode(e.toString());
                        emitter.onNext(null);
                    }
                    @Override
                    public void onComplete() {
                    }
                });
            }
        });
    }

}

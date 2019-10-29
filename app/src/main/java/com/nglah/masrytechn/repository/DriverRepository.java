package com.nglah.masrytechn.repository;

import com.nglah.masrytechn.network.networkModel.request.driver.AcceptNqlahRequest;
import com.nglah.masrytechn.network.networkModel.request.driver.AddEvaluationRequest;
import com.nglah.masrytechn.network.networkModel.request.driver.ComfirmNaqlaCostRequest;
import com.nglah.masrytechn.network.networkModel.request.driver.GetAllNaqlaRequest;
import com.nglah.masrytechn.network.networkModel.request.driver.UserHistoryRequest;
import com.nglah.masrytechn.network.networkModel.response.driver.AcceptNaqlahaResponse;
import com.nglah.masrytechn.network.networkModel.response.driver.AddEvaluationResponse;
import com.nglah.masrytechn.network.networkModel.response.driver.ComfirmNaqlaCostResponse;
import com.nglah.masrytechn.network.networkModel.response.driver.GetAllNaqlaResponse;
import com.nglah.masrytechn.network.networkModel.response.driver.UserHistoryResponse;
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

public class DriverRepository {


    private NaglahaWebServices naglahaWebServices;

    public DriverRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        String BASE_URL = "http://pym.pwalgs.com/api/";

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                client(client).addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        naglahaWebServices = retrofit.create(NaglahaWebServices.class);
    }

    // region singleton implementation
    private static class Loader {
        static DriverRepository INSTANCE = new DriverRepository();
    }


    public static DriverRepository getInstance() {
        return DriverRepository.Loader.INSTANCE;
    }

    public Observable<GetAllNaqlaResponse> getNaqlaForDeriver(final GetAllNaqlaRequest request) {
        return Observable.create(new ObservableOnSubscribe<GetAllNaqlaResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<GetAllNaqlaResponse> emitter) {

                naglahaWebServices.getAllNaqla(request).subscribeOn(Schedulers.io()).
                        observeOn(Schedulers.io()).subscribe(new Observer<GetAllNaqlaResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetAllNaqlaResponse response) {
                        emitter.onNext(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        GetAllNaqlaResponse response = new GetAllNaqlaResponse();
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

    public Observable<AcceptNaqlahaResponse> acceptNaqlahRepository(final AcceptNqlahRequest request) {
        return Observable.create(new ObservableOnSubscribe<AcceptNaqlahaResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<AcceptNaqlahaResponse> emitter) {

                naglahaWebServices.acceptNaqlaha(request).subscribeOn(Schedulers.io()).
                        observeOn(Schedulers.io()).subscribe(new Observer<AcceptNaqlahaResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AcceptNaqlahaResponse response) {
                        emitter.onNext(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        AcceptNaqlahaResponse response = new AcceptNaqlahaResponse();
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

    public Observable<UserHistoryResponse> userHistoryRepository(final UserHistoryRequest request) {
        return Observable.create(new ObservableOnSubscribe<UserHistoryResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<UserHistoryResponse> emitter) {

                naglahaWebServices.getMyHistory(request).subscribeOn(Schedulers.io()).
                        observeOn(Schedulers.io()).subscribe(new Observer<UserHistoryResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserHistoryResponse response) {
                        emitter.onNext(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        UserHistoryResponse response = new UserHistoryResponse();
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

    public Observable<ComfirmNaqlaCostResponse> confirmCostRepository(final ComfirmNaqlaCostRequest request) {
        return Observable.create(new ObservableOnSubscribe<ComfirmNaqlaCostResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<ComfirmNaqlaCostResponse> emitter) {

                naglahaWebServices.confirmCost(request).subscribeOn(Schedulers.io()).
                        observeOn(Schedulers.io()).subscribe(new Observer<ComfirmNaqlaCostResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ComfirmNaqlaCostResponse response) {
                        emitter.onNext(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        ComfirmNaqlaCostResponse response = new ComfirmNaqlaCostResponse();
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

    public Observable<AddEvaluationResponse> addEvaluationRepository(final AddEvaluationRequest request) {
        return Observable.create(new ObservableOnSubscribe<AddEvaluationResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<AddEvaluationResponse> emitter) {

                naglahaWebServices.addEvluation(request).subscribeOn(Schedulers.io()).
                        observeOn(Schedulers.io()).subscribe(new Observer<AddEvaluationResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AddEvaluationResponse response) {
                        emitter.onNext(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        AddEvaluationResponse response = new AddEvaluationResponse();
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

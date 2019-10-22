package com.nglah.masrytechn.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nglah.masrytechn.repository.PaymentRepository;
import com.nglah.masrytechn.network.networkModel.request.Payment.PaymentRequest;
import com.nglah.masrytechn.network.networkModel.request.naglaha.AddNaqlaRequest;
import com.nglah.masrytechn.network.networkModel.response.Naglaha.AllDriverResponse;
import com.nglah.masrytechn.network.networkModel.response.Naglaha.AddNaqlahaResponse;
import com.nglah.masrytechn.network.networkModel.response.Payment.PaymentResponse;
import com.nglah.masrytechn.repository.NaglahRepository;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ViewModelNaglaha extends ViewModel {

    private MutableLiveData<AddNaqlahaResponse> addNaglahaReaponse = new MutableLiveData<>();
    private MutableLiveData<AllDriverResponse> getAllDriverResponse = new MutableLiveData<>();
    private MutableLiveData<PaymentResponse> paymentResponse = new MutableLiveData<>();


    public MutableLiveData<AddNaqlahaResponse> makeNewNaglaha() {
        return addNaglahaReaponse;
    }

    public void addNaglahToServer(AddNaqlaRequest request) {

        if (request.getToP()==null){
            request.setToP("");

        }
        request.setNaglahType("");
        NaglahRepository.getInstance().addNaglahaRepository(request)
                .subscribe(new Observer<AddNaqlahaResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AddNaqlahaResponse value) {

                        addNaglahaReaponse.postValue(value);

                    }

                    @Override
                    public void onError(Throwable e) {
                        addNaglahaReaponse.postValue(null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public MutableLiveData<AllDriverResponse> getAllDriver() {
        return getAllDriverResponse;
    }

    public void addNaglahToServer() {

        NaglahRepository.getInstance().allDriverRepository()
                .subscribe(new Observer<AllDriverResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AllDriverResponse value) {

                        getAllDriverResponse.postValue(value);

                    }

                    @Override
                    public void onError(Throwable e) {
                        getAllDriverResponse.postValue(null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public MutableLiveData<PaymentResponse> makePayment() {
        return paymentResponse;
    }

    public void addPaymentToServer(PaymentRequest request) {

        PaymentRepository.getInstance().paymentRepository(request)
                .subscribe(new Observer<PaymentResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PaymentResponse value) {

                        paymentResponse.postValue(value);

                    }

                    @Override
                    public void onError(Throwable e) {
                        paymentResponse.postValue(null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


}

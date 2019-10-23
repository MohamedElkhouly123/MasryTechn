package com.nglah.masrytechn.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nglah.masrytechn.network.networkModel.request.driver.AcceptNqlahRequest;
import com.nglah.masrytechn.network.networkModel.request.driver.GetAllNaqlaRequest;
import com.nglah.masrytechn.network.networkModel.response.AcceptNaqlahaResponse;
import com.nglah.masrytechn.network.networkModel.response.driver.GetAllNaqlaResponse;
import com.nglah.masrytechn.repository.DriverRepository;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DriverViewModel extends ViewModel {

    private MutableLiveData<GetAllNaqlaResponse> getNAqlaForDriver = new MutableLiveData<>();
    private MutableLiveData<AcceptNaqlahaResponse> acceptNaqlaresponse = new MutableLiveData<>();

    public MutableLiveData<GetAllNaqlaResponse> getAllNaqla() {
        return getNAqlaForDriver;
    }

    public void getAllNaqlaFromServer(String deroverID) {


        GetAllNaqlaRequest request = new GetAllNaqlaRequest();
        request.setDriverId(deroverID);
        DriverRepository.getInstance().getNaqlaForDeriver(request)
                .subscribe(new Observer<GetAllNaqlaResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetAllNaqlaResponse value) {

                        getNAqlaForDriver.postValue(value);

                    }

                    @Override
                    public void onError(Throwable e) {
                        getNAqlaForDriver.postValue(null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    public MutableLiveData<AcceptNaqlahaResponse> getAcceptNaqla() {
        return acceptNaqlaresponse;
    }

    public void acceptNaqlaToServer(AcceptNqlahRequest request) {


        DriverRepository.getInstance().acceptNaqlahRepository(request)
                .subscribe(new Observer<AcceptNaqlahaResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AcceptNaqlahaResponse value) {

                        acceptNaqlaresponse.postValue(value);

                    }

                    @Override
                    public void onError(Throwable e) {
                        acceptNaqlaresponse.postValue(null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}

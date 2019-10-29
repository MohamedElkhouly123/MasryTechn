package com.nglah.masrytechn.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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
import com.nglah.masrytechn.repository.DriverRepository;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DriverViewModel extends ViewModel {

    private MutableLiveData<GetAllNaqlaResponse> getNAqlaForDriver = new MutableLiveData<>();
    private MutableLiveData<AcceptNaqlahaResponse> acceptNaqlaresponse = new MutableLiveData<>();
    private MutableLiveData<UserHistoryResponse> userHistoryresponse = new MutableLiveData<>();
    private MutableLiveData<ComfirmNaqlaCostResponse> confirmCostResponse = new MutableLiveData<>();
    private MutableLiveData<AddEvaluationResponse> addEvluationResponse = new MutableLiveData<>();


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


    public MutableLiveData<UserHistoryResponse> getUSerHistory() {
        return userHistoryresponse;
    }

    public void getHistoryFromServer(String id) {

        UserHistoryRequest request = new UserHistoryRequest();
        request.setUserId(id);

        DriverRepository.getInstance().userHistoryRepository(request)
                .subscribe(new Observer<UserHistoryResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserHistoryResponse value) {
                        userHistoryresponse.postValue(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userHistoryresponse.postValue(null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    public MutableLiveData<ComfirmNaqlaCostResponse> getConfirmCost() {
        return confirmCostResponse;
    }

    public void confirmCostToServer(int driverID, int naqlaId) {

        ComfirmNaqlaCostRequest request = new ComfirmNaqlaCostRequest();
        request.setDriverId(driverID);
        request.setNaqlaId(naqlaId);

        DriverRepository.getInstance().confirmCostRepository(request)
                .subscribe(new Observer<ComfirmNaqlaCostResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ComfirmNaqlaCostResponse value) {
                        confirmCostResponse.postValue(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        confirmCostResponse.postValue(null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    public MutableLiveData<AddEvaluationResponse> getAddEvluationResponse() {
        return addEvluationResponse;
    }

    public void sendEvaluationToServer(AddEvaluationRequest request) {


        DriverRepository.getInstance().addEvaluationRepository(request)
                .subscribe(new Observer<AddEvaluationResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AddEvaluationResponse value) {
                        addEvluationResponse.postValue(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        addEvluationResponse.postValue(null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}

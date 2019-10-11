package com.nglah.masrytechn.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nglah.masrytechn.network.networkModel.request.naglaha.AllDriverRequest;
import com.nglah.masrytechn.network.networkModel.request.naglaha.UserRequestNaqlahRequest;
import com.nglah.masrytechn.network.networkModel.response.Naglaha.AllDriverResponse;
import com.nglah.masrytechn.network.networkModel.response.Naglaha.UserRequestNaqlahResponse;
import com.nglah.masrytechn.repository.NaglahRepository;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ViewModelNaglaha extends ViewModel {

    private MutableLiveData<UserRequestNaqlahResponse> addNaglahaReaponse = new MutableLiveData<>();
    private MutableLiveData<AllDriverResponse> getAllDriverResponse = new MutableLiveData<>();


    public MutableLiveData<UserRequestNaqlahResponse> makeNewNaglaha() {
        return addNaglahaReaponse;
    }

    public void addNaglahToServer(UserRequestNaqlahRequest request) {

        NaglahRepository.getInstance().addNaglahaRepository(request)
                .subscribe(new Observer<UserRequestNaqlahResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserRequestNaqlahResponse value) {

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

    public void addNaglahToServer(AllDriverRequest request) {

        NaglahRepository.getInstance().allDriverRepository(request)
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

}

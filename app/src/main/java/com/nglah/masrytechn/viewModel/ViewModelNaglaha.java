package com.nglah.masrytechn.viewModel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nglah.masrytechn.network.networkModel.request.User.RegisterRequest;
import com.nglah.masrytechn.network.networkModel.request.naglaha.UserRequestNaqlahRequest;
import com.nglah.masrytechn.network.networkModel.response.Naglaha.UserRequestNaqlahResponse;
import com.nglah.masrytechn.network.networkModel.response.User.RegisterResponse;
import com.nglah.masrytechn.repository.NaglahRepository;
import com.nglah.masrytechn.repository.UserRepository;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ViewModelNaglaha extends ViewModel {

    private MutableLiveData<UserRequestNaqlahResponse> addNaglahaReaponse = new MutableLiveData<>();



    public MutableLiveData<UserRequestNaqlahResponse> makeNewNaglaha() {
        return addNaglahaReaponse;
    }

    public void addNaglahToServer( UserRequestNaqlahRequest request) {

        NaglahRepository.getInstance().registrationRepository(request)
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

}

package com.nglah.masrytechn.viewModel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nglah.masrytechn.DataBase.DataBase;
import com.nglah.masrytechn.Firebase.FireBaseToken;
import com.nglah.masrytechn.model.UserModel;
import com.nglah.masrytechn.network.networkModel.request.User.ForgetPasswordRequest;
import com.nglah.masrytechn.network.networkModel.request.User.LoginRequest;
import com.nglah.masrytechn.network.networkModel.request.User.RegisterCarOwnerRequest;
import com.nglah.masrytechn.network.networkModel.request.User.RegisterRequest;
import com.nglah.masrytechn.network.networkModel.request.User.VerifyEmailRequest;
import com.nglah.masrytechn.network.networkModel.response.User.ChangePasswordResponse;
import com.nglah.masrytechn.network.networkModel.response.User.ForgetPasswordResponse;
import com.nglah.masrytechn.network.networkModel.response.User.GetUserInfoResponse;
import com.nglah.masrytechn.network.networkModel.response.User.LoginResponse;
import com.nglah.masrytechn.network.networkModel.response.User.RegisterCarOwnerResponse;
import com.nglah.masrytechn.network.networkModel.response.User.RegisterResponse;
import com.nglah.masrytechn.network.networkModel.response.User.UpdateUserDataResponse;
import com.nglah.masrytechn.network.networkModel.response.User.UpdateUserImageResponse;
import com.nglah.masrytechn.network.networkModel.response.User.VerifyEmailResponse;
import com.nglah.masrytechn.repository.UserRepository;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.nglah.masrytechn.model.UserModel.loggedInUser;


public class ViewModelUser extends ViewModel {

    private MutableLiveData<LoginResponse> loginResponse = new MutableLiveData<>();
    private MutableLiveData<VerifyEmailResponse> verifyResponse = new MutableLiveData<>();
    private MutableLiveData<RegisterResponse> registerResponse = new MutableLiveData<>();
    private MutableLiveData<RegisterCarOwnerResponse> registerCarOwnerResponse = new MutableLiveData<>();
    private MutableLiveData<UpdateUserDataResponse> editUserProfile = new MutableLiveData<>();
    private MutableLiveData<UpdateUserImageResponse> updateProfileImage = new MutableLiveData<>();
    private MutableLiveData<GetUserInfoResponse> getUserInfo = new MutableLiveData<>();
    private MutableLiveData<ChangePasswordResponse> changePassword = new MutableLiveData<>();
    private MutableLiveData<ForgetPasswordResponse> forgetPassword = new MutableLiveData<>();
    private MutableLiveData<Boolean> logout = new MutableLiveData<>();
    private MutableLiveData<Boolean> userLogin = new MutableLiveData<>();


    public MutableLiveData<RegisterResponse> makeRegister() {
        return registerResponse;
    }

    public void registerToServer(final Context context, RegisterRequest request) {

        UserRepository.getInstance().registrationRepository(request).subscribe(new Observer<RegisterResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RegisterResponse value) {
                if (value.getStatus()) {
                    saveDataInDataBase(context, value.getEmail(), value.getFname(),
                            value.getMobileNumber(), value.getUserName(), value.getLname()
                            , value.getToken(),
                            1, value.getId(), "", "", "", "",
                            "", "");
                }
                registerResponse.postValue(value);

            }

            @Override
            public void onError(Throwable e) {
                registerResponse.postValue(null);
            }

            @Override
            public void onComplete() {

            }
        });

    }

    public MutableLiveData<RegisterCarOwnerResponse> makeRegisterCarOwner() {
        return registerCarOwnerResponse;
    }

    public void registerCarOwnerToServer(final Context context, RegisterCarOwnerRequest request) {

        UserRepository.getInstance().registrationCarOwnerRepository(request).
                subscribe(new Observer<RegisterCarOwnerResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterCarOwnerResponse value) {

                        if (value.getId()!=null) {
                            saveDataInDataBase(context, value.getEmail(), value.getFname(),
                                    value.getMobileNumber(), value.getUserName(), value.getLname()
                                    , value.getToken(), 2, value.getId(), value.getCarType(),
                                    value.getPlateNumber(), value.getMaxWeight(), value.getCurrentCity()
                                    , value.getCity(), value.getCarIcon());
                        }
                        registerCarOwnerResponse.postValue(value);

                    }

                    @Override
                    public void onError(Throwable e) {
                        registerCarOwnerResponse.postValue(null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    public MutableLiveData<LoginResponse> makeLogin() {
        return loginResponse;
    }

    public void loginToServer(final Context context, String email, String password) {
        LoginRequest request = new LoginRequest();
        request.setEmail(email);
        request.setPassword(password);
        request.setToken(new FireBaseToken().getToken());
        UserRepository.getInstance().loginRepository(request).subscribe(new Observer<LoginResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(LoginResponse value) {

                //Save dataBase
                if (value.isStatus()) {

                }
                loginResponse.postValue(value);
            }

            @Override
            public void onError(Throwable e) {

                loginResponse.postValue(null);

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public MutableLiveData<VerifyEmailResponse> makeVerify() {
        return verifyResponse;
    }

    public void sendEmailToServer(String email) {
        VerifyEmailRequest request = new VerifyEmailRequest();
        UserRepository.getInstance().verifyEmailRepository(request).subscribe(new Observer<VerifyEmailResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(VerifyEmailResponse value) {
                verifyResponse.postValue(value);
            }

            @Override
            public void onError(Throwable e) {
                verifyResponse.postValue(null);
            }

            @Override
            public void onComplete() {

            }
        });
    }


    public MutableLiveData<Boolean> checkUSerIfLogin() {
        return userLogin;
    }

    public void checkUser(final Context context) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    UserModel userData = DataBase.getInstance(context).userProfileDao().checkIfUserExist();
                    if (userData != null) {
                        loggedInUser = userData;
                        userLogin.postValue(true);

                    } else {
                        userLogin.postValue(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    userLogin.postValue(false);
                }


            }
        }).start();

    }

    public MutableLiveData<UpdateUserDataResponse> makeEditProfile() {
        return editUserProfile;
    }


    public MutableLiveData<UpdateUserImageResponse> makeUpdateImageProfile() {
        return updateProfileImage;
    }


    public MutableLiveData<GetUserInfoResponse> makeGetUserInfo() {
        return getUserInfo;
    }


    public MutableLiveData<ChangePasswordResponse> makeChangePassword() {
        return changePassword;
    }


    public MutableLiveData<ForgetPasswordResponse> makeForgetPassword() {
        return forgetPassword;
    }

    public void forgetPasswordToServer(String email) {
        ForgetPasswordRequest request = new ForgetPasswordRequest();
        request.setEmail(email);

        UserRepository.getInstance().forgetPasswordRepository(request).subscribe(new Observer<ForgetPasswordResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(ForgetPasswordResponse response) {
                forgetPassword.postValue(response);
            }

            @Override
            public void onError(Throwable e) {

                forgetPassword.postValue(null);

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public MutableLiveData<Boolean> makeLogout() {
        return logout;
    }

    public void setLogout(final Context context) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DataBase.getInstance(context).userProfileDao().clear();
                    logout.postValue(true);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    logout.postValue(false);
                }


            }
        }).

                start();

    }

    private void saveDataInDataBase(Context context, String email, String firstName, String phone,
                                    String userName, String lastName, String accessToken, int type,
                                    String id, String carType, String paletNumber, String maxWeight,
                                    String currentCity, String city, String carIcon) {


        UserModel userData = new UserModel();
        userData.setEmail(email);
        userData.setUserName(userName);
        userData.setFirstName(firstName);
        userData.setLastName(lastName);
        userData.setPhone(phone);
        userData.setActive(1);
        userData.setUserType(type);
        userData.setId(id);
        userData.setCurrentCity(currentCity);
        userData.setCity(city);
        userData.setCarType(carType);
        userData.setPlateNumber(paletNumber);
        userData.setMaxWeight(maxWeight);
        userData.setCarIcon(carIcon);
        userData.setAccessToken(accessToken);
        loggedInUser = userData;
        DataBase.getInstance(context).userProfileDao().insert(loggedInUser);

    }


    private void updateDataInDataBase(final Context context, String email, String name,
                                      String location, String phone) {
        loggedInUser.setLocation(location);
        loggedInUser.setUserName(name);
        loggedInUser.setEmail(email);
        loggedInUser.setPhone(phone);
        DataBase.getInstance(context).userProfileDao().updateUserDate(loggedInUser);
    }


}

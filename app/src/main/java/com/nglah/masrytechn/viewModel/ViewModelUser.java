package com.nglah.masrytechn.viewModel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nglah.masrytechn.DataBase.DataBase;
import com.nglah.masrytechn.Firebase.FireBaseToken;
import com.nglah.masrytechn.model.UserModel;
import com.nglah.masrytechn.network.networkModel.request.User.ChangePasswordRequest;
import com.nglah.masrytechn.network.networkModel.request.User.ForgetPasswordRequest;
import com.nglah.masrytechn.network.networkModel.request.User.LoginRequest;
import com.nglah.masrytechn.network.networkModel.request.User.RegisterRequest;
import com.nglah.masrytechn.network.networkModel.request.User.UpdateUserDataRequest;
import com.nglah.masrytechn.network.networkModel.request.User.UpdateUserImageRequest;
import com.nglah.masrytechn.network.networkModel.response.User.ChangePasswordResponse;
import com.nglah.masrytechn.network.networkModel.response.User.ForgetPasswordResponse;
import com.nglah.masrytechn.network.networkModel.response.User.GetUserInfoResponse;
import com.nglah.masrytechn.network.networkModel.response.User.LoginResponse;
import com.nglah.masrytechn.network.networkModel.response.User.RegisterResponse;
import com.nglah.masrytechn.network.networkModel.response.User.UpdateUserDataResponse;
import com.nglah.masrytechn.network.networkModel.response.User.UpdateUserImageResponse;
import com.nglah.masrytechn.repository.UserRepository;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.nglah.masrytechn.model.UserModel.loggedInUser;


public class ViewModelUser extends ViewModel {

    private MutableLiveData<LoginResponse> loginResponse = new MutableLiveData<>();
    private MutableLiveData<RegisterResponse> registerResponse = new MutableLiveData<>();
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

    public void registerToServer(final Context context, String name, String phone, String location, String email, String password) {

        RegisterRequest request = new RegisterRequest();
        request.setName(name);
        request.setEmail(email);
        request.setPassword(password);
        request.setPasswordConfirmation(password);
        request.setPhone(phone);
        request.setAddress(location);
        request.setCityId("15585");
        request.setStateId("1072");
        request.setToken(new FireBaseToken().getToken());


        UserRepository.getInstance().registrationRepository(request).subscribe(new Observer<RegisterResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RegisterResponse value) {
                if (value.getStatus()) {
                    saveDataInDataBase(context, value.getData().getUser().getEmail(), value.getData().getUser().getName()
                            , value.getData().getUser().getPhone(), value.getData().getUser().getAddress(), ""
                            , value.getData().getUser().getToken(), 1, value.getData().getUser().getId(), 1);
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
                    saveDataInDataBase(context, value.getData().getUser().getEmail(), value.getData().getUser().getName()
                            , value.getData().getUser().getPhone(), value.getData().getUser().getAddress(), value.getData().getUser().getImage()
                            , value.getData().getUser().getToken(),1, value.getData().getUser().getId(), 1);
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

    public void updateUserDataToServer(final Context context, final String email, final String name, final String location, final String phone) {
        UpdateUserDataRequest request = new UpdateUserDataRequest();
        request.setAddress(location);
        request.setName(name);
        request.setPhone(phone);
        request.setEmail(email);
        request.setCityId("15585");
        request.setStateId("1072");
        UserRepository.getInstance().editProfileRepository(request).subscribe(new Observer<UpdateUserDataResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(UpdateUserDataResponse value) {

                if (value.getStatus()) {
                    updateDataInDataBase(context, email, name, location, phone);
                }
                editUserProfile.postValue(value);
            }

            @Override
            public void onError(Throwable e) {
                editUserProfile.postValue(null);


            }

            @Override
            public void onComplete() {

            }
        });
    }

    public MutableLiveData<UpdateUserImageResponse> makeUpdateImageProfile() {
        return updateProfileImage;
    }

    public void updateImageProfileToServer(final String image) {


        UpdateUserImageRequest request = new UpdateUserImageRequest();
        request.setName(loggedInUser.getUserName());
        request.setPhone(loggedInUser.getPhone());
        request.setEmail(loggedInUser.getEmail());
        request.setImage(image);
        request.setCityId("15585");
        request.setStateId("1072");
        UserRepository.getInstance().updateProfileImageRepository(request).subscribe(new Observer<UpdateUserImageResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(UpdateUserImageResponse value) {
                updateProfileImage.postValue(value);
            }

            @Override
            public void onError(Throwable e) {
                updateProfileImage.postValue(null);

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public MutableLiveData<GetUserInfoResponse> makeGetUserInfo() {
        return getUserInfo;
    }

    public void getUserInfoFromServer(final Context context) {

        UserRepository.getInstance().getUSerInfoRepository().subscribe(new Observer<GetUserInfoResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(GetUserInfoResponse response) {

                if (response.getStatus()) {
                    updateImageInDataBase(context, response.getData().getUser().getImageUrl());
                }
                getUserInfo.postValue(response);
            }

            @Override
            public void onError(Throwable e) {

                getUserInfo.postValue(null);
                //Handel Error
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public MutableLiveData<ChangePasswordResponse> makeChangePassword() {
        return changePassword;
    }

    public void changePasswordToServer(String oldPassword, String newPassword) {
        ChangePasswordRequest request = new ChangePasswordRequest();
        request.setOldPassword(oldPassword);
        request.setPassword(newPassword);
        request.setPasswordConfirmation(newPassword);

        UserRepository.getInstance().changePasswordRepository(request).subscribe(new Observer<ChangePasswordResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(ChangePasswordResponse response) {
                changePassword.postValue(response);
            }

            @Override
            public void onError(Throwable e) {
                if (e.toString().equals("java.net.SocketTimeoutException")) {
                    ChangePasswordResponse response = new ChangePasswordResponse();
//                    response.setStatus(false);
//                    response.setMsg("java.net.SocketTimeoutException");
                    changePassword.postValue(response);
                } else
                    changePassword.postValue(null);
                //Handel Error
            }

            @Override
            public void onComplete() {

            }
        });
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

    private void saveDataInDataBase(Context context, String email, String name, String phone,
                                    String location, String image, String accessToken, int type,
                                    int id, int loginType) {

        UserModel userData = new UserModel();
        userData.setLoginType(loginType);
        userData.setRefreshToken(accessToken);
        userData.setEmail(email);
        userData.setUserName(name);
        userData.setPhone(phone);
        userData.setImageUrl(image);
        userData.setLocation(location);
        userData.setActive(1);
        userData.setUserType(type);
        userData.setId(id);
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

    private void updateImageInDataBase(final Context context, String imageUrl) {
        loggedInUser.setImageUrl(imageUrl);
        DataBase.getInstance(context).userProfileDao().updateUserDate(loggedInUser);
    }

}

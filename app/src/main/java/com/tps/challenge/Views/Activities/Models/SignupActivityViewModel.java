package com.tps.challenge.Views.Activities.Models;

import android.databinding.ObservableField;

import com.tps.challenge.DataLayer.DataManager;
import com.tps.challenge.DataLayer.DataModels.db.UsersDBTable;
import com.tps.challenge.Utilities.AppLogger;
import com.tps.challenge.Utilities.CommonUtils;
import com.tps.challenge.Utilities.rx.SchedulerProvider;
import com.tps.challenge.Views.Activities.Navigators.SignupActivityViewNavigator;
import com.tps.challenge.Views.BaseViews.BaseViewModel;

import io.reactivex.functions.Consumer;

public class SignupActivityViewModel extends BaseViewModel<SignupActivityViewNavigator> {
    public ObservableField<Boolean> isLoading;
    private String password = "", email = "", phoneNumber = "";
    private String fName = "", lName = "";
    private int selectedGender = 0;

    public SignupActivityViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        isLoading = new ObservableField<>();
        isLoading.set(false);
    }


    public void onFirstNameTextChanged(CharSequence text) {
        fName = text.toString().trim();
    }

    public void onLastNameTextChanged(CharSequence text) {
        lName = text.toString().trim();
    }

    public void onPasswordTextChanged(CharSequence text) {
        if (text.length() <= 0) {
            getNavigator().validatePassword("password required");
        } else {
            getNavigator().validatePassword(null);
        }
        password = text.toString().trim();
    }

    public void onGenderItemSelected(int position) {
        selectedGender = position;
    }

    public void onEmailTextChanged(CharSequence text) {
        if (text.length() <= 0) {
            getNavigator().validateEmail("email required");
        } else {
            getNavigator().validateEmail(null);
        }
        email = text.toString().trim();
    }

    public void onMobileNumberTextChanged(CharSequence text) {
        if (text.length() <= 0) {
            getNavigator().validatePhone("phone number required");
        } else {
            getNavigator().validatePhone(null);
        }
        phoneNumber = text.toString().trim();
    }

    public void registerNewUser() {
        if (email.length() == 0 && password.length() == 0 && phoneNumber.length() == 0 && selectedGender > 0) {
            getNavigator().showToast("Please complete the form", 1);
            return;
        }
        if (ValidateUserData()) {
            //TODO every thing is Ok check if this user registered before if no then register
            if (selectedGender > 0)
                CheckUserEmailUsability();
            else
                getNavigator().showToast("please select gender", 1);

        } else {
            getNavigator().showToast("Mobile number is not valid", 1);
            getNavigator().validatePhone("mobile format like: \n +60 12 345 6789 or\n 01111234567");
        }
    }

    private void CheckUserEmailUsability() {
        getNavigator().showLoading();
        //getDataManager().getUserWithEmail(email);
        getCompositeDisposable().add(getDataManager()
                .getUserWithEmail(email)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<UsersDBTable>() {
                    @Override
                    public void accept(UsersDBTable response) throws Exception {
                        if (response != null) {
                            getNavigator().showToast("email already registered", 1);

                        } else {
                            AppLogger.d("User Not registered");
                            //TODO insert new User
                            insertNewUser();
                        }
                        getNavigator().hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getNavigator().hideLoading();
                        setIsLoading(false);
                        //TODO insert new User
                        insertNewUser();
                        getNavigator().handleError(throwable);
                    }
                }));
    }

    private void insertNewUser() {
        UsersDBTable mNewUser = new UsersDBTable();
        mNewUser.setEmail(email);
        mNewUser.setFirstName(fName);
        mNewUser.setLastName(lName);
        mNewUser.setId(CommonUtils.getCurrentTimeMilliSecond());
        mNewUser.setMobileNo(phoneNumber);
        mNewUser.setPassword(password);
        mNewUser.setGender(selectedGender);
        getCompositeDisposable().add(getDataManager()
                .insertUser(mNewUser)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean response) throws Exception {
                        if (response)
                            getNavigator().showToast("user registered successfully", 1);

                        setIsLoading(false);
                        getNavigator().hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        AppLogger.d("Insertion Failed!");
                        getNavigator().showToast("Register Failed \n try again later", 1);
                        setIsLoading(false);
                        getNavigator().hideLoading();
                    }
                }));
        //TODO navigate to login
    }

    private boolean ValidateUserData() {
        return isEmailValid();
    }

    private boolean isEmailValid() {
        if (CommonUtils.isEmailValid(email))
            return isPasswordValid();
        else {
            getNavigator().validateEmail("Email is not valid");
            return false;
        }
    }

    private boolean isPasswordValid() {
        if (CommonUtils.isPasswordValid(password))
            return isPhoneNumberValid();
        else {
            getNavigator().showToast("Password should contain one special character and minimum 8 character required", 1);
            getNavigator().validatePassword("enter valid password");
            return false;
        }
    }

    private boolean isPhoneNumberValid() {
        return CommonUtils.isPhoneValid(phoneNumber);
    }

    public void openLoginView() {
        getNavigator().openLoginActivity();
    }
}

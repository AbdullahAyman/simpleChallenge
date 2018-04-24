package com.tps.challenge.Views.Activities.Models;

import android.databinding.ObservableField;

import com.tps.challenge.BuildConfig;
import com.tps.challenge.DataLayer.DataManager;
import com.tps.challenge.DataLayer.DataModels.db.UsersDBTable;
import com.tps.challenge.Utilities.AppLogger;
import com.tps.challenge.Utilities.CommonUtils;
import com.tps.challenge.Utilities.rx.SchedulerProvider;
import com.tps.challenge.Views.Activities.Navigators.LoginActivityViewNavigator;
import com.tps.challenge.Views.BaseViews.BaseViewModel;

import io.reactivex.functions.Consumer;

public class LoginActivityViewModel extends BaseViewModel<LoginActivityViewNavigator> {
    public final ObservableField<String> versionName = new ObservableField<>();

    public LoginActivityViewModel(DataManager dataManager,
                                  SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        this.versionName.set("V " + BuildConfig.VERSION_NAME);
    }

    public void onServerLoginClick() {
        getNavigator().login();
    }

    public void login(final String email, final String password) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getUserWithEmail(email)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<UsersDBTable>() {
                    @Override
                    public void accept(UsersDBTable response) throws Exception {
                        getNavigator().hideLoading();
                        if (response != null) {
                            getDataManager().updateUserInfo(
                                    response.getMobileNo(),
                                    response.getId(),
                                    DataManager.LoggedInMode.LOGGED_IN_MODE,
                                    response.getEmail(),
                                    response.getFirstName().concat(" ").concat(response.getLastName()),
                                    password,
                                    response.getGender() + "",
                                    "");
                            if (response.getPassword().equals(password))
                                getNavigator().openMainActivity();
                            else
                                getNavigator().showToast("invalid password ", 1);

                        } else {
                            AppLogger.d("User Not registered");
                            getNavigator().showToast("User Not registered", 1);
                        }
                        setIsLoading(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        setIsLoading(false);
                        getNavigator().hideLoading();
                        getNavigator().showToast("User Not registered", 1);
                        getNavigator().handleError(throwable);
                    }
                }));
    }

    public boolean isEmailAndPasswordValid(String email, String password) {
        //validate email and password
        if (email == null || email.isEmpty()) {
            getNavigator().showToast("All fields are required", 1);
            return false;

        }
        if (!CommonUtils.isEmailValid(email)) {
            getNavigator().showToast("Email is not valid", 1);
            return false;
        }
        if (!CommonUtils.isPasswordValid(password)) {
            getNavigator().showToast("Password should contain one special character and a minimum 8 characters required", 1);
            return false;
        }
        return true;
    }

    public void openSignUpView() {
        //TODO navigate user to register screen
        AppLogger.d("navigate user to register screen");
        getNavigator().openSignUpView();
    }

    public void onCheckedChanged(boolean checked) {
        if (checked) {
            AppLogger.d("Checked");
            getDataManager().setCurrentUserLoggedInMode(DataManager.LoggedInMode.LOGGED_IN_MODE);

        } else {
            AppLogger.d("un Checked");
            getDataManager().setUserAsLoggedOut();
        }
    }

    public void onUsernameTextChanged(CharSequence username) {
        if (username.length() <= 0) {
            getNavigator().validateEmail("enter user name");
        } else {
            getNavigator().validateEmail(null);
        }
    }

    public void onPasswordTextChanged(CharSequence username) {
        if (username.length() <= 0) {
            getNavigator().validatePassword("enter password");
        } else {
            getNavigator().validatePassword(null);
        }
    }

}

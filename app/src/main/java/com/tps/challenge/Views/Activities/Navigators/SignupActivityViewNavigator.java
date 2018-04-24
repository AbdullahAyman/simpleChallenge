package com.tps.challenge.Views.Activities.Navigators;

import com.tps.challenge.Views.BaseNavigator;


public interface SignupActivityViewNavigator extends BaseNavigator {

    void validateEmail(String error);

    void validatePhone(String error);

    void validatePassword(String error);

    void openLoginActivity();
}

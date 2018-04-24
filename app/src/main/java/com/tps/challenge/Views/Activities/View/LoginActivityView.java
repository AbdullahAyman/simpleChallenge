package com.tps.challenge.Views.Activities.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.tps.challenge.BR;
import com.tps.challenge.R;
import com.tps.challenge.Views.Activities.Models.LoginActivityViewModel;
import com.tps.challenge.Views.Activities.Navigators.LoginActivityViewNavigator;
import com.tps.challenge.Views.BaseViews.BaseActivity;
import com.tps.challenge.databinding.ActivityLoginViewBinding;

import javax.inject.Inject;

public class LoginActivityView extends BaseActivity<ActivityLoginViewBinding, LoginActivityViewModel> implements LoginActivityViewNavigator {

    @Inject
    LoginActivityViewModel mLoginViewModel;

    ActivityLoginViewBinding mActivityLoginBinding;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivityView.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        mLoginViewModel.setNavigator(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivityView.getStartIntent(LoginActivityView.this);
        startActivity(intent);
        finish();
    }


    @Override
    public void login() {
        String email = mActivityLoginBinding.loginTvEmail.getText().toString();
        String password = mActivityLoginBinding.loginTvPassword.getText().toString();
        if (mLoginViewModel.isEmailAndPasswordValid(email, password)) {
            hideKeyboard();
            mLoginViewModel.login(email, password);
        } else {
            showToastMessage("invalid credentials", 0);
        }
    }

    @Override
    public void validateEmail(String error) {
        mActivityLoginBinding.loginTvEmail.setError(error);
    }

    @Override
    public void validatePassword(String error) {
        mActivityLoginBinding.loginTvPassword.setError(error);
    }

    @Override
    public void openSignUpView() {
        startActivity(SignupActivityView.getStartIntent(LoginActivityView.this));
        finish();
    }

    @Override
    public LoginActivityViewModel getViewModel() {
        return mLoginViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login_view;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

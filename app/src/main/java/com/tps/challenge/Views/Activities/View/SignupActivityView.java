package com.tps.challenge.Views.Activities.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.tps.challenge.BR;
import com.tps.challenge.R;
import com.tps.challenge.Utilities.CommonUtils;
import com.tps.challenge.Views.Activities.Models.SignupActivityViewModel;
import com.tps.challenge.Views.Activities.Navigators.SignupActivityViewNavigator;
import com.tps.challenge.Views.BaseViews.BaseActivity;
import com.tps.challenge.databinding.ActivitySignupViewBinding;

import javax.inject.Inject;


public class SignupActivityView extends BaseActivity<ActivitySignupViewBinding, SignupActivityViewModel>
        implements SignupActivityViewNavigator {

    @Inject
    SignupActivityViewModel mViewModel;
    ActivitySignupViewBinding mViewBinding;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SignupActivityView.class);
        return intent;
    }

    @Override
    public SignupActivityViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_signup_view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = getViewDataBinding();
        mViewModel.setNavigator(this);
        assignSpinner();
    }

    private void assignSpinner() {
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CommonUtils.getGender());
        mViewBinding.registerSpinnerGender.setAdapter(arrayAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void validateEmail(String error) {
        mViewBinding.registerTvEmail.setError(error);
    }

    @Override
    public void validatePhone(String error) {
        mViewBinding.registerTvMobileNo.setError(error);
    }

    @Override
    public void validatePassword(String error) {
        mViewBinding.registerTvPassword.setError(error);
    }

    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivityView.getStartIntent(this);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = LoginActivityView.getStartIntent(this);
        startActivity(intent);
        finish();
    }
}

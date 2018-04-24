package com.tps.challenge.Views.Activities.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.tps.challenge.BR;
import com.tps.challenge.R;
import com.tps.challenge.Views.Activities.Models.SplashActivityViewModel;
import com.tps.challenge.Views.Activities.Navigators.SplashActivityViewNavigator;
import com.tps.challenge.Views.BaseViews.BaseActivity;
import com.tps.challenge.databinding.ActivitySplashViewBinding;

import javax.inject.Inject;

public class SplashActivityView extends BaseActivity<ActivitySplashViewBinding, SplashActivityViewModel> implements SplashActivityViewNavigator {

    @Inject
    SplashActivityViewModel mSplashViewModel;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivityView.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivityView.getStartIntent(SplashActivityView.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivityView.getStartIntent(SplashActivityView.this);
        startActivity(intent);
        finish();
    }

    @Override
    public SplashActivityViewModel getViewModel() {
        return mSplashViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash_view;
    }

}

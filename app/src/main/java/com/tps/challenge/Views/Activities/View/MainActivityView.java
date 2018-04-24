package com.tps.challenge.Views.Activities.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.tps.challenge.BR;
import com.tps.challenge.R;
import com.tps.challenge.Views.Activities.Models.MainActivityViewModel;
import com.tps.challenge.Views.Activities.Navigators.MainActivityViewNavigator;
import com.tps.challenge.Views.BaseViews.BaseActivity;
import com.tps.challenge.Views.Dialgos.View.EditMobileDialogView;
import com.tps.challenge.databinding.ActivityMainViewBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivityView extends BaseActivity<ActivityMainViewBinding, MainActivityViewModel> implements MainActivityViewNavigator, HasSupportFragmentInjector {
    @Inject
    MainActivityViewModel mViewModel;
    ActivityMainViewBinding mViewBinding;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivityView.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = getViewDataBinding();
        mViewModel.setNavigator(this);
        mViewModel.displayUserData();
    }

    @Override
    public MainActivityViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main_view;
    }

    @Override
    public void showPopupToEditPhone(String phone) {
        //TODO show popup to edit mobile number
        final EditMobileDialogView mDialog = EditMobileDialogView.newInstance();
        mDialog.show(getSupportFragmentManager(), new EditMobileDialogView.callBack() {
            @Override
            public void onDismiss() {
                mViewModel.displayUserData();

            }
        });
    }

    @Override
    public void navigateToImagesView() {
        //TODO show images display
        Intent intent = ImagesDisplayerActivityView.getStartIntent(this);
        startActivity(intent);

    }

    @Override
    public void logOut() {
        Intent intent = LoginActivityView.getStartIntent(this);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        mViewModel.logOut();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

}

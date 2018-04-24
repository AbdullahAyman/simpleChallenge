package com.tps.challenge.Views.Activities.Models;

import com.tps.challenge.DataLayer.DataManager;
import com.tps.challenge.Utilities.AppConstants;
import com.tps.challenge.Utilities.rx.SchedulerProvider;
import com.tps.challenge.Views.Activities.Navigators.SplashActivityViewNavigator;
import com.tps.challenge.Views.BaseViews.BaseViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class SplashActivityViewModel extends BaseViewModel<SplashActivityViewNavigator> {

    public SplashActivityViewModel(DataManager dataManager,
                                   SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        Observable.just(true).delay(AppConstants.DELAY_MILLISECOND, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> decideNextActivity());

    }

    private void decideNextActivity() {
        if (getDataManager().getCurrentUserLoggedInMode()
                == DataManager.LoggedInMode.LOGGED_IN_MODE.getType()) {
            getNavigator().openMainActivity();
        } else {
            getNavigator().openLoginActivity();
        }
    }

}

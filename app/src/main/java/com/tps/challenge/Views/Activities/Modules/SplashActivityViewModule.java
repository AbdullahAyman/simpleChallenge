package com.tps.challenge.Views.Activities.Modules;

import com.tps.challenge.DataLayer.DataManager;
import com.tps.challenge.Utilities.rx.SchedulerProvider;
import com.tps.challenge.Views.Activities.Models.SplashActivityViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashActivityViewModule {

    @Provides
    SplashActivityViewModel provideSplashViewModel(DataManager dataManager,
                                                   SchedulerProvider schedulerProvider) {
        return new SplashActivityViewModel(dataManager, schedulerProvider);
    }

}

package com.tps.challenge.Views.Activities.Modules;

import com.tps.challenge.DataLayer.DataManager;
import com.tps.challenge.Utilities.rx.SchedulerProvider;
import com.tps.challenge.Views.Activities.Models.SignupActivityViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class SignupActivityViewModule {

    @Provides
    SignupActivityViewModel provideSignupActivityViewModel(DataManager dataManager,
                                                           SchedulerProvider schedulerProvider) {
        return new SignupActivityViewModel(dataManager, schedulerProvider);
    }

}

package com.tps.challenge.Views.Activities.Modules;

import com.tps.challenge.DataLayer.DataManager;
import com.tps.challenge.Utilities.rx.SchedulerProvider;
import com.tps.challenge.Views.Activities.Models.LoginActivityViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityViewModule {

    @Provides
    LoginActivityViewModel provideLoginViewModel(DataManager dataManager,
                                                 SchedulerProvider schedulerProvider) {
        return new LoginActivityViewModel(dataManager, schedulerProvider);
    }

}

package com.tps.challenge.Views.Activities.Modules;

import android.arch.lifecycle.ViewModelProvider;

import com.tps.challenge.DataLayer.DataManager;
import com.tps.challenge.Utilities.rx.SchedulerProvider;
import com.tps.challenge.Views.Activities.Models.MainActivityViewModel;
import com.tps.challenge.di.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityViewModule {

    @Provides
    MainActivityViewModel provideMainViewModel(DataManager dataManager,
                                                 SchedulerProvider schedulerProvider) {
        return new MainActivityViewModel(dataManager, schedulerProvider);
    }
    @Provides
    ViewModelProvider.Factory viewModelProviderFactory(MainActivityViewModel mMainActivityViewModel) {
        return new ViewModelProviderFactory<>(mMainActivityViewModel);
    }
}

package com.tps.challenge.Views.Dialgos.Modules;

import com.tps.challenge.DataLayer.DataManager;
import com.tps.challenge.Utilities.rx.SchedulerProvider;
import com.tps.challenge.Views.Dialgos.Models.EditMobileDialogModel;

import dagger.Module;
import dagger.Provides;

@Module
public class EditMobileDialogModule {
    @Provides
    EditMobileDialogModel provideEditMobileDialogModel(DataManager dataManager,
                                                       SchedulerProvider schedulerProvider) {
        return new EditMobileDialogModel(dataManager, schedulerProvider);
    }
}

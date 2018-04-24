package com.tps.challenge.Views.Dialgos.Provider;

import com.tps.challenge.Views.Dialgos.Modules.EditMobileDialogModule;
import com.tps.challenge.Views.Dialgos.View.EditMobileDialogView;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class EditMobileDialogProvider {
    @ContributesAndroidInjector(modules = EditMobileDialogModule.class)
    abstract EditMobileDialogView provideEditMobileDialogViewFactory();

}

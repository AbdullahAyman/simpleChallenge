package com.tps.challenge.di.builder;

import com.tps.challenge.Views.Activities.Modules.ImagesDisplayerActivityModule;
import com.tps.challenge.Views.Activities.Modules.LoginActivityViewModule;
import com.tps.challenge.Views.Activities.Modules.MainActivityViewModule;
import com.tps.challenge.Views.Activities.Modules.SignupActivityViewModule;
import com.tps.challenge.Views.Activities.Modules.SplashActivityViewModule;
import com.tps.challenge.Views.Activities.View.ImagesDisplayerActivityView;
import com.tps.challenge.Views.Activities.View.LoginActivityView;
import com.tps.challenge.Views.Activities.View.MainActivityView;
import com.tps.challenge.Views.Activities.View.SignupActivityView;
import com.tps.challenge.Views.Activities.View.SplashActivityView;
import com.tps.challenge.Views.Dialgos.Provider.EditMobileDialogProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = SplashActivityViewModule.class)
    abstract SplashActivityView bindSplashActivity();

    @ContributesAndroidInjector(modules = LoginActivityViewModule.class)
    abstract LoginActivityView bindLoginActivity();

    @ContributesAndroidInjector(modules = {MainActivityViewModule.class,
            EditMobileDialogProvider.class})
    abstract MainActivityView bindMainActivity();

    @ContributesAndroidInjector(modules = SignupActivityViewModule.class)
    abstract SignupActivityView bindSignupActivity();

    @ContributesAndroidInjector(modules = ImagesDisplayerActivityModule.class)
    abstract ImagesDisplayerActivityView bindImagesDisplayerActivityView();
}

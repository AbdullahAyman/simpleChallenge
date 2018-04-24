package com.tps.challenge.di.component;

import android.app.Application;

import com.tps.challenge.Utilities.MyApplication;
import com.tps.challenge.di.builder.ActivityBuilder;
import com.tps.challenge.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(MyApplication app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

}

package com.tps.challenge.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.tps.challenge.DataLayer.AppDataManager;
import com.tps.challenge.DataLayer.DataManager;
import com.tps.challenge.DataLayer.Local.Preference.AppPreferencesHelper;
import com.tps.challenge.DataLayer.Local.Preference.PreferencesHelper;
import com.tps.challenge.DataLayer.Local.db.AppDatabase;
import com.tps.challenge.DataLayer.Local.db.AppDbHelper;
import com.tps.challenge.DataLayer.Local.db.DbHelper;
import com.tps.challenge.DataLayer.Remote.ApiHelper;
import com.tps.challenge.DataLayer.Remote.AppApiHelper;
import com.tps.challenge.R;
import com.tps.challenge.Utilities.AppConstants;
import com.tps.challenge.Utilities.rx.AppSchedulerProvider;
import com.tps.challenge.Utilities.rx.SchedulerProvider;
import com.tps.challenge.di.DatabaseInfo;
import com.tps.challenge.di.PreferenceInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}

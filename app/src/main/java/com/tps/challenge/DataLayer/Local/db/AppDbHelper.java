package com.tps.challenge.DataLayer.Local.db;

import com.tps.challenge.DataLayer.DataModels.db.UsersDBTable;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDbHelper implements DbHelper {

    private final AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    @Override
    public Observable<Boolean> insertUser(UsersDBTable user) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.usersDao().insertAll(user);
                return true;
            }
        });
    }

    @Override
    public Observable<List<UsersDBTable>> getAllUsers() {
        return Observable.fromCallable(new Callable<List<UsersDBTable>>() {
            @Override
            public List<UsersDBTable> call() throws Exception {
                return mAppDatabase.usersDao().getAllUsers();
            }
        });
    }

    @Override
    public Observable<UsersDBTable> getUserWithEmail(String email) {
        return Observable.fromCallable(new Callable<UsersDBTable>() {
            @Override
            public UsersDBTable call() throws Exception {
                return mAppDatabase.usersDao().searchAllUsers(email);
            }
        });
    }

    @Override
    public Observable<Boolean> deleteUser(UsersDBTable user) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.usersDao().delete(user);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> deleteAllUsers() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.usersDao().deleteAll();
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> updateMobileUser(String userEmail, String newMobileNo) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.usersDao().update(userEmail, newMobileNo);
                return true;
            }
        });
    }
}

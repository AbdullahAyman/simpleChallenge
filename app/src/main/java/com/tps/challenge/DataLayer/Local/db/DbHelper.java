package com.tps.challenge.DataLayer.Local.db;

import com.tps.challenge.DataLayer.DataModels.db.UsersDBTable;

import java.util.List;

import io.reactivex.Observable;


public interface DbHelper {

    Observable<Boolean> insertUser(final UsersDBTable user);

    Observable<List<UsersDBTable>> getAllUsers();

    Observable<UsersDBTable> getUserWithEmail(String email);

    Observable<Boolean> deleteUser(final UsersDBTable user);

    Observable<Boolean> deleteAllUsers();

    Observable<Boolean> updateMobileUser(String userEmail, String newMobileNo);
}

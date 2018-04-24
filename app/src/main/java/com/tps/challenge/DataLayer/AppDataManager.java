package com.tps.challenge.DataLayer;

import android.content.Context;

import com.tps.challenge.DataLayer.DataModels.api.Photos.PhotosResponse;
import com.tps.challenge.DataLayer.DataModels.db.UsersDBTable;
import com.tps.challenge.DataLayer.Local.Preference.PreferencesHelper;
import com.tps.challenge.DataLayer.Local.db.DbHelper;
import com.tps.challenge.DataLayer.Remote.ApiHelper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

public class AppDataManager implements DataManager {
    //private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    AppDataManager(Context context,
                   DbHelper dbHelper,
                   PreferencesHelper preferencesHelper,
                   ApiHelper apiHelper) {
        //mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public Long getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserPassword() {
        return mPreferencesHelper.getCurrentUserPassword();
    }

    @Override
    public void setCurrentUserPassword(String password) {
        mPreferencesHelper.setCurrentUserPassword(password);
    }

    @Override
    public String getMobileNo() {
        return mPreferencesHelper.getMobileNo();
    }

    @Override
    public void setMobileNumber(String accessToken) {
        mPreferencesHelper.setMobileNumber(accessToken);
    }

    @Override
    public String getUserRoleId() {
        return mPreferencesHelper.getUserRoleId();
    }

    @Override
    public void setUserGender(String userRoleId) {
        mPreferencesHelper.setUserGender(userRoleId);
    }

    @Override
    public String getUserRoleType() {
        return mPreferencesHelper.getUserRoleType();
    }

    @Override
    public void setUserRoleType(String userRoleType) {
        mPreferencesHelper.setUserRoleType(userRoleType);
    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPreferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public Observable<Boolean> insertUser(UsersDBTable user) {
        return mDbHelper.insertUser(user);
    }

    @Override
    public Observable<List<UsersDBTable>> getAllUsers() {
        return mDbHelper.getAllUsers();
    }

    @Override
    public Observable<UsersDBTable> getUserWithEmail(String email) {
        return mDbHelper.getUserWithEmail(email);
    }

    @Override
    public Observable<Boolean> deleteUser(UsersDBTable user) {
        return mDbHelper.deleteUser(user);
    }

    @Override
    public Observable<Boolean> deleteAllUsers() {
        return mDbHelper.deleteAllUsers();
    }

    @Override
    public Observable<Boolean> updateMobileUser(String userEmail, String newMobileNo) {
        setMobileNumber(newMobileNo);
        return mDbHelper.updateMobileUser(userEmail, newMobileNo);
    }

    @Override
    public Single<PhotosResponse> loadImagesApi() {
        return mApiHelper.loadImagesApi();
    }

    @Override
    public Single<PhotosResponse> doLogoutApiCall() {
        setUserAsLoggedOut();
        return mApiHelper.doLogoutApiCall();
    }

    @Override
    public void updateApiHeader(Long userId, String accessToken) {
        setCurrentUserId(userId);
        setMobileNumber(accessToken);
    }

    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(
                null,
                null,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,
                null,
                null,
                null,
                null,
                null);
    }

    @Override
    public void updateUserInfo(String accessToken, Long userId, LoggedInMode loggedInMode, String email, String userName, String password, String userRoleId, String userRoleType) {
        setMobileNumber(accessToken);
        setCurrentUserId(userId);
        setCurrentUserLoggedInMode(loggedInMode);
        setCurrentUserName(userName);
        setUserGender(userRoleId);
        setUserRoleType(userRoleType);
        setCurrentUserPassword(password);
        setCurrentUserEmail(email);
    }

}

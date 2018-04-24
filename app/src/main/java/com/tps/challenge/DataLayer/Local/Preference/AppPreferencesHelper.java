package com.tps.challenge.DataLayer.Local.Preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.tps.challenge.DataLayer.DataManager;
import com.tps.challenge.Utilities.AppConstants;
import com.tps.challenge.di.PreferenceInfo;

import javax.inject.Inject;


public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";
    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";
    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";
    private static final String PREF_KEY_CURRENT_PASSWORD = "PREF_KEY_CURRENT_PASSWORD";
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";
    private static final String PREF_KEY_USER_ROLE_ID = "PREF_KEY_USER_ROLE_ID";
    private static final String PREF_KEY_USER_ROLE_TYPE = "PREF_KEY_USER_ROLE_TYPE";
    private static final String PREF_KEY_USER_EMAIL = "PREF_KEY_USER_EMAIL";

    private final SharedPreferences mPrefs;

    @Inject
    AppPreferencesHelper(Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public Long getCurrentUserId() {
        long userId = mPrefs.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
        return userId == AppConstants.NULL_INDEX ? null : userId;
    }

    @Override
    public void setCurrentUserId(Long userId) {
        long id = userId == null ? AppConstants.NULL_INDEX : userId;
        mPrefs.edit().putLong(PREF_KEY_CURRENT_USER_ID, id).apply();
    }

    @Override
    public String getCurrentUserName() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, null);
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply();
    }

    @Override
    public String getCurrentUserPassword() {
        return mPrefs.getString(PREF_KEY_CURRENT_PASSWORD, null);

    }

    @Override
    public void setCurrentUserPassword(String password) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_PASSWORD, password).apply();

    }

    @Override
    public int getCurrentUserLoggedInMode() {
        int mode = mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE,
                0);
        return mode;
    }

    @Override
    public void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode) {
        mPrefs.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.getType()).apply();
    }

    @Override
    public String getMobileNo() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void setMobileNumber(String accessToken) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
    }

    @Override
    public String getUserRoleId() {
        return mPrefs.getString(PREF_KEY_USER_ROLE_ID, null);
    }

    @Override
    public void setUserGender(String userRoleId) {
        mPrefs.edit().putString(PREF_KEY_USER_ROLE_ID, userRoleId).apply();
    }

    @Override
    public String getUserRoleType() {
        return mPrefs.getString(PREF_KEY_USER_ROLE_TYPE, null);
    }

    @Override
    public void setUserRoleType(String userRoleType) {
        mPrefs.edit().putString(PREF_KEY_USER_ROLE_TYPE, userRoleType).apply();
    }

    @Override
    public String getCurrentUserEmail() {
        return mPrefs.getString(PREF_KEY_USER_EMAIL, null);
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPrefs.edit().putString(PREF_KEY_USER_EMAIL, email).apply();
    }

}

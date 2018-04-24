package com.tps.challenge.DataLayer.Local.Preference;


import com.tps.challenge.DataLayer.DataManager;

public interface PreferencesHelper {

    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserPassword();

    void setCurrentUserPassword(String password);

    String getMobileNo();

    void setMobileNumber(String accessToken);

    String getUserRoleId();

    void setUserGender(String userRoleId);

    String getUserRoleType();

    void setUserRoleType(String userRoleType);

    void setCurrentUserEmail(String email);

    String getCurrentUserEmail();

}

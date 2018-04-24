package com.tps.challenge.DataLayer;

import com.tps.challenge.DataLayer.Local.Preference.PreferencesHelper;
import com.tps.challenge.DataLayer.Local.db.DbHelper;
import com.tps.challenge.DataLayer.Remote.ApiHelper;

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {

    void updateApiHeader(Long userId, String accessToken);

    void setUserAsLoggedOut();

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String email,
            String userName,
            String password,
            String userGenderId,
            String userRoleType);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE(1);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}

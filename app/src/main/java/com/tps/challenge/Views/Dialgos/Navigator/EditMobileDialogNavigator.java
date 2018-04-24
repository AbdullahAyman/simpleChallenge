package com.tps.challenge.Views.Dialgos.Navigator;

import com.tps.challenge.Views.BaseNavigator;

public interface EditMobileDialogNavigator extends BaseNavigator {
    void dismissPopup();

    void mobileError(String error);


    void setPhone(String phone);
}

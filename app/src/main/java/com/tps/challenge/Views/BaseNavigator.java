package com.tps.challenge.Views;


public interface BaseNavigator {
    void showToast(String message, int period);
    void handleError(Throwable throwable);
    void showLoading();
    void hideLoading();

}

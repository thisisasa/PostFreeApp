package com.asa.postfreeapp.views;

public interface BaseView {
    void onLoading();
    void onMidingLoading();
    void onError(String message);
    void onSuccess(Object message);
}

package com.datacellme.rxretro.network;

public interface OnResponseListener {
   <T> void onSuccess(T responseSuccess);
   <T> void onError(T responseError);
}

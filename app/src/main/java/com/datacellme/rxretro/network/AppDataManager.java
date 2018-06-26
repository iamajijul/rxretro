package com.datacellme.rxretro.network;

import android.content.Context;
import android.util.Log;

import com.datacellme.rxretro.network.model.Note;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class AppDataManager {
    private OnResponseListener mOnResponseListener;
    private Context mContext;
    private static ApiService mApiService;

    public AppDataManager(OnResponseListener mOnResponseListener, Context mContext) {
        this.mOnResponseListener = mOnResponseListener;
        this.mContext = mContext;
       // if (mApiService==null){
            mApiService = ApiClient.getClient(mContext).create(ApiService.class);
       // }
        Log.e("TAG",""+mApiService);
        fetchAllNotes();
    }

    public void fetchAllNotes(){
        mApiService.fetchAllNotes().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Note>>() {
                    @Override
                    public void onSuccess(List<Note> notes) {
                      mOnResponseListener.onSuccess(notes);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mOnResponseListener.onError("Error on fetching");

                    }
                });
    }

}

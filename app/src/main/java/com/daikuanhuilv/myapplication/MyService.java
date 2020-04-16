package com.daikuanhuilv.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Debug;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("aa", "-----------MyService==onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("aa", "-----------MyService==onBind");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("aa", "-----------MyService==onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("aa", "-----------MyService==onDestroy");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("aa", "-----------MyService==onUnbind");
        return super.onUnbind(intent);
    }

    //client 可以通过Binder获取Service实例
    public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }
    //通过binder实现调用者client与Service之间的通信
    private MyBinder binder = new MyBinder();

}

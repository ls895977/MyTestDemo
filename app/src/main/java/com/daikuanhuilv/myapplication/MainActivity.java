package com.daikuanhuilv.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("aa", "------------onCreate");
        findViewById(R.id.startService).setOnClickListener(this);
        findViewById(R.id.stopService).setOnClickListener(this);
        findViewById(R.id.startBindeService).setOnClickListener(this);
        findViewById(R.id.startUnBindeService).setOnClickListener(this);
        starTRunonUIThread();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("aa", "------------onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("aa", "------------onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("aa", "------------onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("aa", "------------onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("aa", "------------onDestroy");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("aa", "------------onConfigurationChanged");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startService:
                startService();
                break;
            case R.id.stopService:
                stopService();
                break;
            case R.id.startBindeService:
                startBindService();
                break;
            case R.id.startUnBindeService:
                startUnBindeService();
                break;
        }
    }

    /**
     * 开启后台服务
     */
    public void startService() {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);

    }

    /**
     * 停止后台服务
     */
    public void stopService() {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    /**
     * 开启后台服务
     */
    public void startBindService() {
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    /**
     * 解除后台服务
     */
    public void startUnBindeService() {
        unbindService(conn);
    }

    /**
     * runonUIThread更新ui
     */
    public void starTRunonUIThread() {
        new Thread() {//开启线程
            @Override
            public void run() {
                super.run();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        
                    }
                });
            }
        }.start();
    }
}

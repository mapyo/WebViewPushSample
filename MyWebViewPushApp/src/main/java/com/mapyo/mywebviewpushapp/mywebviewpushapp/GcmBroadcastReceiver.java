package com.mapyo.mywebviewpushapp.mywebviewpushapp;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

public class GcmBroadcastReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("GcmBroadcastReceiver", "GcmBroadcastReceiver started");
        // intentをGcmIntentServiceで処理する
        ComponentName comp = new ComponentName(context.getPackageName(),
                GcmIntentService.class.getName());
        // サービスを起動、サービス動作中はWakeLockを保持する
        startWakefulService(context, (intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);
    }
}

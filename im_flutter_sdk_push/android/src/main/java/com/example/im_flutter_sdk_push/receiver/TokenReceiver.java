package com.example.im_flutter_sdk_push.receiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;

import com.example.im_flutter_sdk_push.tools.PushIntent;
import com.example.im_flutter_sdk_push.tools.Utils;

import java.util.Objects;

import io.flutter.plugin.common.EventChannel;

public  class TokenReceiver extends BroadcastReceiver {

    protected final EventChannel.EventSink events;
    public TokenReceiver(Context context, EventChannel.EventSink events) {
        IntentFilter filter = new IntentFilter(PushIntent.TOKEN_INTENT_ACTION.id());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.registerReceiver(this, filter, Context.RECEIVER_NOT_EXPORTED);
        } else {
            context.registerReceiver(this, filter);
        }
        this.events = events;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // 判断事件
        if(Objects.equals(intent.getAction(), PushIntent.TOKEN_INTENT_ACTION.id())) {
            try{
                final String err = intent.getStringExtra(PushIntent.TOKEN_ERROR.id());
                if(err != null) { // 如果获取token失败
                    final String desc = intent.getStringExtra(PushIntent.TOKEN_ERROR_DESC.id());
                    this.events.error(err, desc, Utils.getPlatform().toUpperCase());
                }else {
                    final String token = intent.getStringExtra(PushIntent.TOKEN.id());
                    this.events.success(token);
                }
            }catch (Exception e) {
                this.events.error(e.getMessage(), e.getMessage(), Utils.getPlatform().toUpperCase());
            }
        }
    }
}
package com.example.im_flutter_sdk_push.event;

import android.content.BroadcastReceiver;
import android.content.Context;

import io.flutter.plugin.common.EventChannel;

public interface CreateBroadcastReceiverCallback {
    BroadcastReceiver createBroadcastReceiver(Context context, EventChannel.EventSink events);
}

package com.example.im_flutter_sdk_push;

import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;

import com.example.im_flutter_sdk_push.event.EaseStreamHandler;
import com.example.im_flutter_sdk_push.receiver.NotificationOpenReceiver;
import com.example.im_flutter_sdk_push.receiver.TokenReceiver;
import com.example.im_flutter_sdk_push.tools.PluginContext;
import com.example.im_flutter_sdk_push.tools.PushIntent;
import com.example.im_flutter_sdk_push.tools.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/** ImFlutterSdkPushPlugin */
public class ImFlutterSdkPushPlugin implements FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;
  private final List<EventChannel> eventChannels = new ArrayList<>();
  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "im_flutter_sdk_push");
    channel.setMethodCallHandler(this);
    PluginContext.initialize(flutterPluginBinding.getApplicationContext());
    setStreamHandlers(flutterPluginBinding);
  }

  private void setStreamHandlers(FlutterPluginBinding flutterPluginBinding) {
    Context context = flutterPluginBinding.getApplicationContext();
    Map<String, EventChannel.StreamHandler> streams = new ConcurrentHashMap<>();
    streams.put(Utils.getPlatform() + "/token", new EaseStreamHandler(context, TokenReceiver::new, PushIntent.TOKEN_INTENT_ACTION));
    streams.put(Utils.getPlatform() + "/openNotification", new EaseStreamHandler(context, NotificationOpenReceiver::new, PushIntent.TOKEN_INTENT_ACTION));
    for (Map.Entry<String, EventChannel.StreamHandler> entry : streams.entrySet()) {
      EventChannel eventChannel = new EventChannel(flutterPluginBinding.getBinaryMessenger(), entry.getKey());
      eventChannel.setStreamHandler(entry.getValue());
      eventChannels.add(eventChannel);
    }
  }




  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("getPlatform")) {
      result.success(Utils.getPlatform());
    } else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    if (channel != null) {
      channel.setMethodCallHandler(null);
      for (EventChannel e : eventChannels) {
        e.setStreamHandler(null);
      }
      eventChannels.clear();
    }
  }

}

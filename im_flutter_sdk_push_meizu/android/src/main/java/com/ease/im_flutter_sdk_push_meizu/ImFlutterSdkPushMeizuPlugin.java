package com.ease.im_flutter_sdk_push_meizu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.ease.im_flutter_sdk_push_meizu.meizu.MzTokenHelper;
import com.example.im_flutter_sdk_push.notifcation.EaseNotificationIntentListener;
import com.example.im_flutter_sdk_push.tools.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/** ImFlutterSdkPushMeizuPlugin */
public class ImFlutterSdkPushMeizuPlugin implements FlutterPlugin, MethodCallHandler, ActivityAware {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;
  private MzTokenHelper tokenHelper;
  EaseNotificationIntentListener notificationIntentListener;
  private Activity activity;


  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), Utils.getPlatform() + "/method");
    channel.setMethodCallHandler(this);
    tokenHelper = new MzTokenHelper(flutterPluginBinding.getApplicationContext());
    notificationIntentListener = new EaseNotificationIntentListener(flutterPluginBinding.getApplicationContext());
  }


  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("getToken")) {
      tokenHelper.getToken();
      result.success("");
    } else if (call.method.equals("openNotification")) {
      notificationIntentListener.getInitialIntent(result);
    } else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }

  @Override
  public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
    this.activity = binding.getActivity();
    binding.addOnNewIntentListener(this.notificationIntentListener);
    Intent startupIntent = activity.getIntent();
    if (Utils.checkNotificationFlags(startupIntent)) {
      this.notificationIntentListener.handleIntent(startupIntent);
    }
  }

  @Override
  public void onDetachedFromActivityForConfigChanges() {
    this.activity = null;
  }

  @Override
  public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {
    this.activity = binding.getActivity();
    binding.addOnNewIntentListener(this.notificationIntentListener);
    this.notificationIntentListener.handleIntent(activity.getIntent());
  }

  @Override
  public void onDetachedFromActivity() {
    this.activity = null;
  }
}

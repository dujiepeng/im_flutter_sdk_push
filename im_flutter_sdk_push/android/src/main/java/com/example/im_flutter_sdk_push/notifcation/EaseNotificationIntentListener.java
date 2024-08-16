package com.example.im_flutter_sdk_push.notifcation;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.im_flutter_sdk_push.tools.PushIntent;
import com.example.im_flutter_sdk_push.tools.Utils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

public class EaseNotificationIntentListener implements PluginRegistry.NewIntentListener  {

    protected String initialIntent;

    protected Context context;

    public EaseNotificationIntentListener(Context context) {
        this.context = context;
    }

    public void getInitialIntent(final MethodChannel.Result result) {
        result.success(initialIntent);
    }


    public boolean onNewIntent(@NonNull Intent intent) {
        if (Utils.checkNotificationFlags(intent)) {
            handleIntent(intent);
        }
        return false;
    }


    public void handleIntent(Intent intent) {
        String action = intent.getAction();
        String dataString = intent.getDataString();
        Bundle bundleExtras = intent.getExtras();
        Map<String, Object> map = new HashMap<>();
        map.put("uriPage", intent.getDataString());
        if (bundleExtras != null) {
            map.put("extras", bundleToMap(bundleExtras));
        }
        if (Intent.ACTION_VIEW.equals(action)) {
            initialIntent = dataString;
            if (bundleExtras != null) {
                Utils.sendNotificationOpenedAppEvent(context, map);
            }
        } else if (Intent.ACTION_MAIN.equals(action)) {
            if (bundleExtras != null) {
                Utils.sendNotificationOpenedAppEvent(context, map);
            }
        }else {
            System.out.println("NotificationIntentListener: Unsupported action intent:" + action);
        }
    }

    protected Map<String, Object> bundleToMap(Bundle bundle) {
        return null;
    }

}

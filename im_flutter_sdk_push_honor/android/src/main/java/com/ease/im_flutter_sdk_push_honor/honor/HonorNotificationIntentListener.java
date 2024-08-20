package com.ease.im_flutter_sdk_push_honor.honor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.UiContext;

import com.example.im_flutter_sdk_push.notifcation.EaseNotificationIntentListener;
import com.example.im_flutter_sdk_push.tools.Utils;

import java.util.HashMap;
import java.util.Map;

public class HonorNotificationIntentListener extends EaseNotificationIntentListener {
    public HonorNotificationIntentListener(Context context) {
        super(context);
    }

    public boolean onNewIntent(@NonNull Intent intent) {
        if (intent.getAction().equals(Intent.CATEGORY_DEFAULT)) {
            if (null != intent) {
                Map<String, Object> data = new HashMap<>();
                Bundle bundle = intent.getExtras();
                if (bundle != null) {
                    for (String key : bundle.keySet()) {
                        String content = bundle.getString(key);
                        data.put(key, content);
                    }
                }

                String dataString = intent.getDataString();
                if(dataString != null) {
                    data.put("uriPage", dataString);
                }
                Bundle bundleExtras = intent.getExtras();
                if (bundleExtras != null) {
                    data.put("extras", bundleToMap(bundleExtras));
                }

                if(data.size() != 0) {
                    Utils.sendNotificationOpenedAppEvent(context, data);
                }
            }
        }
        return false;
    }

}

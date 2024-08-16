package com.ease.im_flutter_sdk_push_huawei.hms;

import android.content.Context;
import android.os.Bundle;


import com.ease.im_flutter_sdk_push_huawei.helper.HmsRemoteMessageHelper;
import com.example.im_flutter_sdk_push.notifcation.EaseNotificationIntentListener;
import com.huawei.hms.push.RemoteMessage;

import java.util.Map;


public class HmsNotificationIntentListener extends EaseNotificationIntentListener {

    public HmsNotificationIntentListener(Context context) {
        super(context);
    }

    @Override
    protected Map<String, Object> bundleToMap(Bundle bundle) {
        RemoteMessage remoteMessage = new RemoteMessage(bundle);
        return HmsRemoteMessageHelper.toJson(remoteMessage);
    }

}


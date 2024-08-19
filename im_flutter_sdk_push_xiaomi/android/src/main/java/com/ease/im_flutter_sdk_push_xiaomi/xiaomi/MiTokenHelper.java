package com.ease.im_flutter_sdk_push_xiaomi.xiaomi;

import android.content.Context;

import com.example.im_flutter_sdk_push.token.TokenHelper;
import com.xiaomi.mipush.sdk.MiPushClient;

public class MiTokenHelper  extends TokenHelper {

    public MiTokenHelper(Context context) {
        super(context);
    }

    @Override
    public void getToken() {
        String app_id = "";
        String app_key = "";
        MiPushClient.registerPush(context, app_id, app_key);
        MiPushClient.enablePush(context);
    }
}
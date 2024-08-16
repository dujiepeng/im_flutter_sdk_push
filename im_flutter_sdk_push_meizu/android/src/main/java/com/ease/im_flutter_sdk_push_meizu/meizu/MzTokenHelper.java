package com.ease.im_flutter_sdk_push_meizu.meizu;

import android.content.Context;
import com.example.im_flutter_sdk_push.token.TokenHelper;
import com.meizu.cloud.pushsdk.PushManager;

public class MzTokenHelper extends TokenHelper{

    public MzTokenHelper(Context context) {
        super(context);
    }

    @Override
    public void getToken() {
        new Thread(() -> {
            String appId = "";
            String appKey = "";
            PushManager.register(context, appId, appKey);
        }).start();
    }
}
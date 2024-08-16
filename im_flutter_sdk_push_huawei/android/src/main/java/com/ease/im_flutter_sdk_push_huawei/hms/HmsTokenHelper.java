package com.ease.im_flutter_sdk_push_huawei.hms;

import android.content.Context;

import com.example.im_flutter_sdk_push.token.TokenHelper;
import com.example.im_flutter_sdk_push.tools.PushIntent;
import com.example.im_flutter_sdk_push.tools.Utils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;

public class HmsTokenHelper extends TokenHelper {
    public HmsTokenHelper(Context context) {
        super(context);
    }

    public void getToken() {
        new Thread(() -> {
            String appId = AGConnectServicesConfig.fromContext(context).getString("client/app_id");
            if (appId == null || appId.trim().length() == 0) {
                appId = "";
            }

            try {
                String token = HmsInstanceId.getInstance(this.context).getToken(appId, "HMS");
                Utils.sendToken(context, token);
            } catch (Exception e) {
                Utils.sendTokenError(context, e.getMessage());
            }
        }).start();
    }
}
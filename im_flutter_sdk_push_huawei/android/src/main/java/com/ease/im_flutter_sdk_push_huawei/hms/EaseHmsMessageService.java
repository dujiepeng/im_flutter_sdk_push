package com.ease.im_flutter_sdk_push_huawei.hms;

import com.example.im_flutter_sdk_push.tools.PluginContext;
import com.example.im_flutter_sdk_push.tools.PushIntent;
import com.example.im_flutter_sdk_push.tools.Utils;
import com.huawei.hms.push.HmsMessageService;

public class EaseHmsMessageService extends HmsMessageService {

    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        if(PluginContext.getContext() != null) {
            Utils.sendToken(PluginContext.getContext(), token);
        }
    }

    @Override
    public void onTokenError(Exception e) {
        super.onTokenError(e);
        if(PluginContext.getContext() != null) {
            Utils.sendTokenError(PluginContext.getContext(), e.getMessage());
        }
    }
}

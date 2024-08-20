package com.ease.im_flutter_sdk_push_honor.honor;

import com.example.im_flutter_sdk_push.tools.PluginContext;
import com.example.im_flutter_sdk_push.tools.Utils;
import com.hihonor.push.sdk.HonorMessageService;

public class HonorMessagesService extends HonorMessageService {
    @Override
    public void onNewToken(String pushToken) {
        if(PluginContext.getContext() != null) {
            Utils.sendToken(PluginContext.getContext(), pushToken);
        }
    }
}

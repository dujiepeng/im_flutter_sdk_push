package com.ease.im_flutter_sdk_push_vivo.vivo;

import com.ease.im_flutter_sdk_push_vivo.helper.VivoRemoteMessageHelper;
import com.example.im_flutter_sdk_push.tools.Utils;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;

public class VivoMessageService extends OpenClientPushMessageReceiver {
    @Override
    public void onReceiveRegId(android.content.Context context, java.lang.String regId) {
        Utils.sendToken(context, regId);
    }

    @Override
    public void onNotificationMessageClicked(android.content.Context context, com.vivo.push.model.UPSNotificationMessage msg) {
        Utils.sendNotificationOpenedAppEvent(context, VivoRemoteMessageHelper.toJson(msg));
    }
}

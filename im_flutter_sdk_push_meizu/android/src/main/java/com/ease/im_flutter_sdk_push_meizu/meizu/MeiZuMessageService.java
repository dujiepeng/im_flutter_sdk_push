package com.ease.im_flutter_sdk_push_meizu.meizu;



import static com.meizu.cloud.pushsdk.platform.message.BasicStatus.SUCCESS_CODE;

import android.content.Context;

import com.ease.im_flutter_sdk_push_meizu.helper.MzMessageHelper;
import com.example.im_flutter_sdk_push.tools.PluginContext;
import com.example.im_flutter_sdk_push.tools.Utils;
import com.meizu.cloud.pushsdk.MzPushMessageReceiver;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;

public class MeiZuMessageService extends MzPushMessageReceiver {
    @Override
    public void onRegisterStatus(Context context, RegisterStatus registerStatus) {
        super.onRegisterStatus(context, registerStatus);
        if(registerStatus.getCode().equals(SUCCESS_CODE)){
            if(PluginContext.getContext() == null) {
                Utils.sendTokenError(PluginContext.getContext(),"-1", "Plugin context is null.");
            }else {
                Utils.sendToken(PluginContext.getContext(), registerStatus.getPushId());
            }
        }else {
            Utils.sendTokenError(PluginContext.getContext(), registerStatus.getCode() ,"Get token error.");
        }
    }

    @Override
    public void onNotificationClicked(Context context, MzPushMessage mzPushMessage) {
        super.onNotificationClicked(context, mzPushMessage);
        Utils.sendNotificationOpenedAppEvent(context, MzMessageHelper.toJson(mzPushMessage));
    }
}

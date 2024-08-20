package com.ease.im_flutter_sdk_push_xiaomi.xiaomi;

import android.content.Context;

import com.ease.im_flutter_sdk_push_xiaomi.helper.MiPushMessageHelper;
import com.example.im_flutter_sdk_push.tools.Utils;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;

import java.util.List;

public class XiaomiMessageService  extends PushMessageReceiver {
    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        Utils.sendNotificationOpenedAppEvent(context, MiPushMessageHelper.toJson(miPushMessage));
    }

    @Override
    public void onCommandResult(Context context, MiPushCommandMessage message) {
        String command = message.getCommand();
        List<String> arguments = message.getCommandArguments();
        String cmdArg1 = ((arguments != null && arguments.size() > 0) ? arguments.get(0) : null);
        if (MiPushClient.COMMAND_REGISTER.equals(command)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
                Utils.sendToken(context, cmdArg1);
            }else {
                Utils.sendTokenError(context, "" + message.getResultCode(), cmdArg1);
            }
        }
    }

    @Override
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage message) {
        String command = message.getCommand();
        List<String> arguments = message.getCommandArguments();
        String cmdArg1 = ((arguments != null && arguments.size() > 0) ? arguments.get(0) : null);
        if (MiPushClient.COMMAND_REGISTER.equals(command)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
                Utils.sendToken(context, cmdArg1);
            }else {
                Utils.sendTokenError(context, "" + message.getResultCode(), cmdArg1);
            }
        }
    }
}

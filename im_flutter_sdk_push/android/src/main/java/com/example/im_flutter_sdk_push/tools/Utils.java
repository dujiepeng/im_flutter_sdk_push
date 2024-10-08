package com.example.im_flutter_sdk_push.tools;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.Nullable;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Utils {
    public static void sendIntent(@Nullable Context context, PushIntent action, PushIntent extraName1, String extra1, PushIntent extraName2, String extra2) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction(action.id());
            intent.putExtra(extraName1.id(), extra1);
            if(extra2 != null) {
                intent.putExtra(extraName2.id(), extra2);
            }
            context.sendBroadcast(intent);
        }
    }

    public static void sendToken(@Nullable Context context, String token) {
        sendIntent(context, PushIntent.TOKEN_INTENT_ACTION, PushIntent.TOKEN, token, null, null);
    }

    public static void sendTokenError(@Nullable Context context, String err, String desc) {
        sendIntent(context, PushIntent.TOKEN_INTENT_ACTION, PushIntent.TOKEN_ERROR, err, PushIntent.TOKEN_ERROR_DESC, desc);
    }

    public static boolean checkNotificationFlags(Intent intent) {
        int flagNumber = Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_RECEIVER_REPLACE_PENDING
                | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT ;
        int flagNumberAndBroughtToFront = flagNumber | Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT;
        return intent.getFlags() == flagNumber || intent.getFlags() == flagNumberAndBroughtToFront
                || intent.getBundleExtra("notification") != null || intent.getDataString() != null;
    }


    public static void sendNotificationOpenedAppEvent(@Nullable Context context, Map<String, Object> initialNotification) {
        Map<String, Object> ret = new HashMap<>();
        ret.putAll(initialNotification);
        ret.put("platform", Utils.getPlatform().toUpperCase());
        JSONObject jsonObject = new JSONObject(initialNotification);
        Utils.sendIntent(context, PushIntent.REMOTE_MESSAGE_NOTIFICATION_INTENT_ACTION, PushIntent.NOTIFICATION_OPEN,
                jsonObject.toString(), null, null);
    }
    public static String getPlatform() {
        return Build.MANUFACTURER.toUpperCase();
    }
}

package com.ease.im_flutter_sdk_push_xiaomi.helper;

import com.xiaomi.mipush.sdk.MiPushMessage;

import java.util.HashMap;
import java.util.Map;

public class MiPushMessageHelper {
    public static Map<String, Object> toJson(MiPushMessage message) {
        Map<String, Object> data = new HashMap<>();
        data.put("MESSAGE_ID", message.getMessageId());
        data.put("MESSAGE_TYPE", message.getMessageType());
        data.put("CONTENT", message.getContent());
        data.put("TITLE", message.getTitle());
        data.put("NOTIFY_TYPE", message.getNotifyType());
        data.put("ALIAS", message.getAlias());
        data.put("CATEGORY", message.getCategory());
        data.put("DESCRIPTION", message.getDescription());
        data.put("EXTRA", message.getExtra());
        data.put("PASSTHROUGH", message.getPassThrough());
        data.put("NOTIFY_ID", message.getNotifyId());
        data.put("TOPIC", message.getTopic());
        data.put("USER_ACCOUNT", message.getUserAccount());
        data.put("IS_ARRIVED_MESSAGE", message.isArrivedMessage());
        data.put("IS_NOTIFIED", message.isNotified());
        return data;
    }
}

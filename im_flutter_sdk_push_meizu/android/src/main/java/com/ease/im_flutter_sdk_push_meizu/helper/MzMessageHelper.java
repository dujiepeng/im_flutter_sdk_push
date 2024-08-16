package com.ease.im_flutter_sdk_push_meizu.helper;

import com.meizu.cloud.pushsdk.handler.MzPushMessage;

import java.util.HashMap;
import java.util.Map;

public class MzMessageHelper {
    public static Map<String, Object> toJson(MzPushMessage message) {
        Map<String, Object> data = new HashMap<>();
        data.put("CONTENT", message.getContent());
        data.put("NOTIFY_ID", message.getNotifyId());
        data.put("TITLE", message.getTitle());
        data.put("PUSH_TYPE", message.getPushType());
        data.put("TASK_ID", message.getTaskId());
        data.put("SELF_DEFINE_CONTENT_STRING", message.getSelfDefineContentString());
        return data;
    }
}

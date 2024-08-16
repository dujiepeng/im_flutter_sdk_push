package com.ease.im_flutter_sdk_push_vivo.helper;

import com.vivo.push.model.UPSNotificationMessage;

import java.util.HashMap;
import java.util.Map;

public class VivoRemoteMessageHelper {
    public static Map<String, Object> toJson(UPSNotificationMessage message) {
        Map<String, Object> data = new HashMap<>();
        data.put("CONTENT", message.getContent());
        data.put("CUSTOM_VALUE", message.getCustomValue());
        data.put("TITLE", message.getTitle());
        data.put("AD_CLICK_CHECK_URL", message.getAdClickCheckUrl());
        data.put("COMPATIBLE_TYPE", message.getCompatibleType());
        data.put("COVER_URL", message.getCoverUrl());
        data.put("EXTENT_STATUS", message.getExtentStatus());
        data.put("ICON_URL", message.getIconUrl());
        data.put("IS_MACRO_REPLACE", message.getIsMacroReplace());
        data.put("MSG_ID", message.getMsgId());
        data.put("NOTIFY_TYPE", message.getNotifyType());
        data.put("PARAMS", message.getParams());
        data.put("PURE_PIC_URL", message.getPurePicUrl());
        data.put("SKIP_CONTENT", message.getSkipContent());
        data.put("SKIP_TYPE", message.getSkipType());
        data.put("TARGET_CONTENT", message.getTargetContent());
        data.put("TARGET_TYPE", message.getTargetType());
        data.put("THIRD_PACKAGE_NAME", message.getThirdPackageName());

        return data;
    }
}

package com.ease.im_flutter_sdk_push_huawei.helper;

import com.huawei.hms.push.RemoteMessage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HmsRemoteMessageHelper {
    public static Map<String, Object> toJson(RemoteMessage message) {
        Map<String, Object> data = new HashMap<>();
        data.put("COLLAPSE_KEY",message.getCollapseKey());
        data.put("DATA",message.getData());
        data.put("DATA_OF_MAP",message.getDataOfMap());
        data.put("MESSAGE_ID",message.getMessageId());
        data.put("MESSAGE_TYPE",message.getMessageType());
        data.put("ORIGINAL_URGENCY",message.getOriginalUrgency());
        data.put("URGENCY", message.getUrgency());
        data.put("TTL", message.getTtl());
        data.put("SENT_TIME", message.getSentTime());
        data.put("TO", message.getToken());
        data.put("FROM", message.getFrom());
        data.put("TOKEN", message.getToken());
        data.put("RECEIPT_MODE", message.getReceiptMode());
        data.put("SEND_MODE", message.getSendMode());
        data.put("CONTENTS", message.describeContents());
        data.put("ANALYTIC_INFO", message.getAnalyticInfo());
        data.put("ANALYTIC_INFO_MAP", message.getAnalyticInfoMap());
        if (message.getNotification() != null) {
            RemoteMessage.Notification notification = message.getNotification();
            Map<String, Object> notificationMap = new HashMap<>();
            notificationMap.put("TITLE" , notification.getTitle());
            notificationMap.put("TITLE_LOCALIZATION_KEY" , notification.getTitleLocalizationKey());
            notificationMap.put("TITLE_LOCALIZATION_ARGS", Arrays.asList(notification.getTitleLocalizationArgs()));
            notificationMap.put("BODY_LOCALIZATION_KEY" , notification.getBodyLocalizationKey());
            notificationMap.put("BODY_LOCALIZATION_ARGS", Arrays.asList(notification.getBodyLocalizationArgs()));
            notificationMap.put("BODY" , notification.getBody());
            notificationMap.put("ICON" , notification.getIcon());
            notificationMap.put("SOUND" , notification.getSound());
            notificationMap.put("TAG" , notification.getTag());
            notificationMap.put("COLOR" , notification.getColor());
            notificationMap.put("CLICK_ACTION" , notification.getClickAction());
            notificationMap.put("CHANNEL_ID" , notification.getChannelId());
            notificationMap.put("IMAGE_URL" , notification.getImageUrl() + "");
            notificationMap.put("LINK" , notification.getLink() + "");
            notificationMap.put("NOTIFY_ID" , notification.getNotifyId());
            notificationMap.put("WHEN" , notification.getWhen());
            notificationMap.put("LIGHT_SETTINGS" , notification.getLightSettings());
            notificationMap.put("BADGE_NUMBER" , notification.getBadgeNumber());
            notificationMap.put("IMPORTANCE" , notification.getImportance());
            notificationMap.put("TICKER" , notification.getTicker());
            notificationMap.put("VIBRATE_CONFIG" , notification.getVibrateConfig());
            notificationMap.put("VISIBILITY" , notification.getVisibility());
            notificationMap.put("INTENT_URI" , notification.getIntentUri());
            notificationMap.put("IS_AUTO_CANCEL" , notification.isAutoCancel());
            notificationMap.put("IS_LOCAL_ONLY" , notification.isLocalOnly());
            notificationMap.put("IS_DEFAULT_LIGHT" , notification.isDefaultLight());
            notificationMap.put("IS_DEFAULT_SOUND" , notification.isDefaultSound());
            notificationMap.put("IS_DEFAULT_VIBRATE" , notification.isDefaultVibrate());
            data.put("NOTIFICATION", notificationMap);
        }

        return data;
    }
}

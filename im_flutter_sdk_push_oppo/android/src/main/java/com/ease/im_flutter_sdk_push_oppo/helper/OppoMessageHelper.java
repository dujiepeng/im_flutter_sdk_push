package com.ease.im_flutter_sdk_push_oppo.helper;

import com.heytap.msp.push.mode.DataMessage;

import java.util.HashMap;
import java.util.Map;

public class OppoMessageHelper {
    public static Map<String, Object> toJson(DataMessage message) {
        Map<String, Object> data = new HashMap<>();
        data.put("APP_ID", message.getAppId());
        data.put("APP_PACKAGE", message.getAppPackage());
        data.put("BALANCE_TIME", message.getBalanceTime());
        data.put("CONTENT", message.getContent());
        data.put("DESCRIPTION", message.getDescription());
        data.put("DISTINCT_CONTENT", message.getDistinctContent());
        data.put("DATA_EXTRA", message.getDataExtra());
        data.put("END_DATE", message.getEndDate());
        data.put("EVENT_ID", message.getEventId());
        data.put("FORCED_DELIVERY", message.getForcedDelivery());
        data.put("GLOBAL_ID", message.getGlobalId());
        data.put("MESSAGE_ID", message.getMessageID());
        data.put("MESSAGE_TYPE", message.getMessageType());
        data.put("MINI_PROGRAM_PKG", message.getMiniProgramPkg());
        data.put("MSG_COMMAND", message.getMsgCommand());
        data.put("NOTIFY_ID", message.getNotifyID());
        data.put("RULE", message.getRule());
        data.put("START_DATE", message.getStartDate());
        data.put("STATISTICS_EXTRA", message.getStatisticsExtra());
        data.put("TITLE", message.getTitle());
        data.put("TASK_ID", message.getTaskID());
        data.put("TIME_RANGES", message.getTimeRanges());
        data.put("TYPE", message.getType());

        return data;
    }
}

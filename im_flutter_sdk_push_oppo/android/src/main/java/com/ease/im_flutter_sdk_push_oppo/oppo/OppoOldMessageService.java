package com.ease.im_flutter_sdk_push_oppo.oppo;

import com.ease.im_flutter_sdk_push_oppo.helper.OppoMessageHelper;
import com.example.im_flutter_sdk_push.tools.Utils;
import com.heytap.msp.push.service.CompatibleDataMessageCallbackService;

public class OppoOldMessageService extends CompatibleDataMessageCallbackService {
    public void processMessage(android.content.Context context, com.heytap.msp.push.mode.DataMessage message) {
        Utils.sendNotificationOpenedAppEvent(context, OppoMessageHelper.toJson(message));
    }
}

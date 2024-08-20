package com.ease.im_flutter_sdk_push_oppo.oppo;

import android.content.Context;

import com.example.im_flutter_sdk_push.token.TokenHelper;
import com.example.im_flutter_sdk_push.tools.Utils;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.callback.ICallBackResultService;

public class OppoTokenHelper extends TokenHelper {
    public OppoTokenHelper(Context context) {
        super(context);
    }

    @Override
    public void getToken() {

        if(!HeytapPushManager.isSupportPush(context)) {
            Utils.sendTokenError(context, "-1", "no support push");
            return;
        }
        HeytapPushManager.requestNotificationPermission();

        HeytapPushManager.init(context, false);
        // TODO:
        String appKey = "";
        String secret = "";
        String token = HeytapPushManager.getRegisterID();
        if(token == null || token.trim().length() == 0) {
            HeytapPushManager.register(context, appKey, secret, new ICallBackResultService() {
                @Override
                public void onRegister(int i, String s) {
                    Utils.sendToken(context, s);
                }

                @Override
                public void onUnRegister(int i) {

                }

                @Override
                public void onSetPushTime(int i, String s) {

                }

                @Override
                public void onGetPushStatus(int i, int i1) {

                }

                @Override
                public void onGetNotificationStatus(int i, int i1) {

                }

                @Override
                public void onError(int i, String s) {
                    Utils.sendTokenError(context, ""+ i, s);
                }
            });
        }else {
            Utils.sendToken(context, token);
        }
    }
}

package com.ease.im_flutter_sdk_push_honor.honor;

import android.content.Context;

import com.example.im_flutter_sdk_push.token.TokenHelper;
import com.example.im_flutter_sdk_push.tools.Utils;
import com.hihonor.push.sdk.HonorPushCallback;
import com.hihonor.push.sdk.HonorPushClient;

public class HonorTokenHelper  extends TokenHelper {
    public HonorTokenHelper(Context context) {
        super(context);
    }

    @Override
    public void getToken() {
        HonorPushClient.getInstance().init(context, true);
        // 获取PushToken
        HonorPushClient.getInstance().getPushToken(new HonorPushCallback<String>() {
            @Override
            public void onSuccess(String pushToken) {
                Utils.sendToken(context, pushToken);
            }

            @Override
            public void onFailure(int errorCode, String errorString) {
                Utils.sendTokenError(context, "" + errorCode, errorString);
            }
        });
    }
}

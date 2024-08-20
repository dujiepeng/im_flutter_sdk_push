package com.ease.im_flutter_sdk_push_vivo.vivo;


import android.content.Context;

import com.example.im_flutter_sdk_push.token.TokenHelper;
import com.example.im_flutter_sdk_push.tools.Utils;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.vivo.push.PushConfig;
import com.vivo.push.listener.IPushQueryActionListener;
import com.vivo.push.util.VivoPushException;

public class VivoTokenHelper extends TokenHelper {
    public VivoTokenHelper(Context context) {
        super(context);
    }

    @Override
    public void getToken() {
        try {
            PushConfig config = new PushConfig.Builder()
                    .agreePrivacyStatement(true)
                    .build();
            PushClient.getInstance(context).initialize(config);
            PushClient.getInstance(context).turnOnPush(new IPushActionListener() {
                @Override
                public void onStateChanged(int i) {
                    if(i == 0) {
                        PushClient.getInstance(context).getRegId(new IPushQueryActionListener() {
                            @Override
                            public void onSuccess(String regId) {
                                System.out.println("regID: " + regId);
                                Utils.sendToken(context, regId);
                            }

                            @Override
                            public void onFail(Integer errCode) {
                                Utils.sendTokenError(context, errCode.toString(), null);
                            }
                        });
                    } else {
                        Utils.sendTokenError(context, "" + i, null);
                    }
                }
            });
        } catch (VivoPushException e) {
            Utils.sendTokenError(context, ""+ e.getCode(), e.getMessage());
        }
    }
}

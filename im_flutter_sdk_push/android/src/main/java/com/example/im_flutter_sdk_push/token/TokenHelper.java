package com.example.im_flutter_sdk_push.token;

import android.content.Context;

public abstract class TokenHelper {
    protected Context context;

    public TokenHelper(Context context) {
        this.context = context;
    }

    public abstract void getToken();
}

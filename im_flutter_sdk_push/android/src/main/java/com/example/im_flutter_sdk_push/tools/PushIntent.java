package com.example.im_flutter_sdk_push.tools;

public enum PushIntent {
    TOKEN_INTENT_ACTION("TOKEN_INTENT_ACTION"),
    TOKEN_ERROR("TOKEN_ERROR"),
    TOKEN("TOKEN"),
    REMOTE_MESSAGE_NOTIFICATION_INTENT_ACTION("REMOTE_MESSAGE_NOTIFICATION_INTENT_ACTION"),
    NOTIFICATION_OPEN("NOTIFICATION_OPEN");

    PushIntent(String id) {
        this.id = id;
    }
    private String id;
    public String id() {
        return id;
    }
}

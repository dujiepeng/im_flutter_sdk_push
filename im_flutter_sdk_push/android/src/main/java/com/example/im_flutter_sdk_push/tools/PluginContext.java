package com.example.im_flutter_sdk_push.tools;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.ref.WeakReference;

public class PluginContext {
    private static WeakReference<Context> weakReference;

    private PluginContext() {
    }

    public static void initialize(@NonNull Context context) {
        weakReference = new WeakReference<>(context);
    }

    @Nullable
    public static Context getContext() {
        return weakReference != null ? weakReference.get() : null;
    }
}

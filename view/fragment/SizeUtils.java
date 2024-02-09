package com.livpure.safedrink.view.fragment;

import android.content.Context;
/* loaded from: classes3.dex */
public class SizeUtils {
    public static int dp2px(Context context, float dpValue) {
        return (int) ((dpValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}

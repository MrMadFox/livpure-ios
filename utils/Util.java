package com.livpure.safedrink.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Util.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/livpure/safedrink/utils/Util;", "", "()V", "dp2px", "", "dpValue", "", "isAppInstalledOrNot", "", "mContext", "Landroid/content/Context;", ShareConstants.MEDIA_URI, "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Util {
    public static final Util INSTANCE = new Util();

    private Util() {
    }

    @JvmStatic
    public static final int dp2px(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    @JvmStatic
    public static final boolean isAppInstalledOrNot(Context mContext, String uri) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(uri, "uri");
        PackageManager packageManager = mContext.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "mContext.packageManager");
        try {
            packageManager.getPackageInfo(uri, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}

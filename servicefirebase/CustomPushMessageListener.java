package com.livpure.safedrink.servicefirebase;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import com.moengage.pushbase.push.PushMessageListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CustomPushMessageListener.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"Lcom/livpure/safedrink/servicefirebase/CustomPushMessageListener;", "Lcom/moengage/pushbase/push/PushMessageListener;", "()V", "handleCustomAction", "", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "payload", "", "onNotificationCleared", "Landroid/os/Bundle;", "onNotificationClick", "activity", "Landroid/app/Activity;", "onNotificationReceived", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CustomPushMessageListener extends PushMessageListener {
    @Override // com.moengage.pushbase.push.PushMessageListener
    public void onNotificationReceived(Context context, Bundle payload) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(payload, "payload");
        super.onNotificationReceived(context, payload);
    }

    @Override // com.moengage.pushbase.push.PushMessageListener
    public void onNotificationCleared(Context context, Bundle payload) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(payload, "payload");
        super.onNotificationCleared(context, payload);
    }

    @Override // com.moengage.pushbase.push.PushMessageListener
    public void onNotificationClick(Activity activity, Bundle payload) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(payload, "payload");
        super.onNotificationClick(activity, payload);
    }

    @Override // com.moengage.pushbase.push.PushMessageListener
    public void handleCustomAction(Context context, String payload) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(payload, "payload");
        super.handleCustomAction(context, payload);
    }
}

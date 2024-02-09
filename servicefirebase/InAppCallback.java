package com.livpure.safedrink.servicefirebase;

import android.util.Log;
import com.moengage.inapp.listeners.InAppLifeCycleListener;
import com.moengage.inapp.model.InAppData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InAppCallback.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/livpure/safedrink/servicefirebase/InAppCallback;", "Lcom/moengage/inapp/listeners/InAppLifeCycleListener;", "()V", "onDismiss", "", "inAppData", "Lcom/moengage/inapp/model/InAppData;", "onShown", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InAppCallback implements InAppLifeCycleListener {
    @Override // com.moengage.inapp.listeners.InAppLifeCycleListener
    public void onDismiss(InAppData inAppData) {
        Intrinsics.checkNotNullParameter(inAppData, "inAppData");
        Log.e("InApp Shown: %s", inAppData.toString());
    }

    @Override // com.moengage.inapp.listeners.InAppLifeCycleListener
    public void onShown(InAppData inAppData) {
        Intrinsics.checkNotNullParameter(inAppData, "inAppData");
        Log.e("InApp Shown: %s", inAppData.toString());
    }
}

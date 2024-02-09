package com.livpure.safedrink.servicefirebase;

import android.content.Context;
import android.util.Log;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import com.moengage.core.listeners.AppBackgroundListener;
import com.moengage.core.model.AppBackgroundData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;
/* compiled from: ApplicationBackgroundListener.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/livpure/safedrink/servicefirebase/ApplicationBackgroundListener;", "Lcom/moengage/core/listeners/AppBackgroundListener;", "()V", "onAppBackground", "", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "data", "Lcom/moengage/core/model/AppBackgroundData;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApplicationBackgroundListener implements AppBackgroundListener {
    @Override // com.moengage.core.listeners.AppBackgroundListener
    public void onAppBackground(Context context, AppBackgroundData data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        Timber.v(" goingToBackground(): Application going to background callback received.", new Object[0]);
        Log.e("goingToBackground():", data.toString());
    }
}

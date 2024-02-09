package com.livpure.safedrink.servicefirebase;

import android.util.Log;
import com.moengage.inapp.listeners.OnClickActionListener;
import com.moengage.inapp.model.ClickData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ClickActionCallback.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/livpure/safedrink/servicefirebase/ClickActionCallback;", "Lcom/moengage/inapp/listeners/OnClickActionListener;", "()V", "onClick", "", "clickData", "Lcom/moengage/inapp/model/ClickData;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ClickActionCallback implements OnClickActionListener {
    @Override // com.moengage.inapp.listeners.OnClickActionListener
    public boolean onClick(ClickData clickData) {
        Intrinsics.checkNotNullParameter(clickData, "clickData");
        Log.e("ClickActionCallback", clickData.toString());
        return false;
    }
}

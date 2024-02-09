package com.livpure.safedrink.servicefirebase;

import android.util.Log;
import com.moengage.inapp.listeners.SelfHandledAvailableListener;
import com.moengage.inapp.model.SelfHandledCampaignData;
import kotlin.Metadata;
/* compiled from: SelfHandledCallback.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/livpure/safedrink/servicefirebase/SelfHandledCallback;", "Lcom/moengage/inapp/listeners/SelfHandledAvailableListener;", "()V", "onSelfHandledAvailable", "", "data", "Lcom/moengage/inapp/model/SelfHandledCampaignData;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SelfHandledCallback implements SelfHandledAvailableListener {
    @Override // com.moengage.inapp.listeners.SelfHandledAvailableListener
    public void onSelfHandledAvailable(SelfHandledCampaignData selfHandledCampaignData) {
        Log.e("SelfHandledCallback", String.valueOf(selfHandledCampaignData));
    }
}

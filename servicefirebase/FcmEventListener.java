package com.livpure.safedrink.servicefirebase;

import com.moengage.firebase.listener.OnFcmRegistrationCompleteListener;
import com.moengage.pushbase.model.TokenRegistrationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;
/* compiled from: FcmEventListener.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/livpure/safedrink/servicefirebase/FcmEventListener;", "Lcom/moengage/firebase/listener/OnFcmRegistrationCompleteListener;", "()V", "navValue", "", "token", "", "onComplete", "result", "Lcom/moengage/pushbase/model/TokenRegistrationResult;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class FcmEventListener implements OnFcmRegistrationCompleteListener {
    public abstract void navValue(String str);

    @Override // com.moengage.firebase.listener.OnFcmRegistrationCompleteListener
    public void onComplete(TokenRegistrationResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Timber.v("onTokenAvailable(): Token Callback ReceivedToken: " + result.getToken(), new Object[0]);
        navValue(result.getToken());
    }
}

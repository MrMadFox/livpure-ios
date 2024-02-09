package com.livpure.safedrink.serviceRequest.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: OTPRequest.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/OTPRequest;", "", "otp", "", "(Ljava/lang/String;)V", "getOtp", "()Ljava/lang/String;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OTPRequest {
    private final String otp;

    public OTPRequest() {
        this(null, 1, null);
    }

    public OTPRequest(String otp) {
        Intrinsics.checkNotNullParameter(otp, "otp");
        this.otp = otp;
    }

    public /* synthetic */ OTPRequest(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getOtp() {
        return this.otp;
    }
}

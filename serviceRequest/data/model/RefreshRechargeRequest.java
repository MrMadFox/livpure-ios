package com.livpure.safedrink.serviceRequest.data.model;

import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RefreshRechargeRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/RefreshRechargeRequest;", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "", "(Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RefreshRechargeRequest {
    private final String userId;

    public static /* synthetic */ RefreshRechargeRequest copy$default(RefreshRechargeRequest refreshRechargeRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = refreshRechargeRequest.userId;
        }
        return refreshRechargeRequest.copy(str);
    }

    public final String component1() {
        return this.userId;
    }

    public final RefreshRechargeRequest copy(String str) {
        return new RefreshRechargeRequest(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RefreshRechargeRequest) && Intrinsics.areEqual(this.userId, ((RefreshRechargeRequest) obj).userId);
    }

    public int hashCode() {
        String str = this.userId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "RefreshRechargeRequest(userId=" + this.userId + ')';
    }

    public RefreshRechargeRequest(String str) {
        this.userId = str;
    }

    public final String getUserId() {
        return this.userId;
    }
}

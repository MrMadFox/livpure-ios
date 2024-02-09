package com.livpure.safedrink.serviceRequest.data.model;

import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NewPlanRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/NewPlanRequest;", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "", "city", "(Ljava/lang/String;Ljava/lang/String;)V", "getCity", "()Ljava/lang/String;", "getUserId", "component1", "component2", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NewPlanRequest {
    private final String city;
    private final String userId;

    public static /* synthetic */ NewPlanRequest copy$default(NewPlanRequest newPlanRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = newPlanRequest.userId;
        }
        if ((i & 2) != 0) {
            str2 = newPlanRequest.city;
        }
        return newPlanRequest.copy(str, str2);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.city;
    }

    public final NewPlanRequest copy(String str, String str2) {
        return new NewPlanRequest(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NewPlanRequest) {
            NewPlanRequest newPlanRequest = (NewPlanRequest) obj;
            return Intrinsics.areEqual(this.userId, newPlanRequest.userId) && Intrinsics.areEqual(this.city, newPlanRequest.city);
        }
        return false;
    }

    public int hashCode() {
        String str = this.userId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.city;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "NewPlanRequest(userId=" + this.userId + ", city=" + this.city + ')';
    }

    public NewPlanRequest(String str, String str2) {
        this.userId = str;
        this.city = str2;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getCity() {
        return this.city;
    }
}

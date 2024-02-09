package com.livpure.safedrink.serviceRequest.data.Models;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServiceLogs.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/Models/ServiceLogs;", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "", "response", "(Ljava/lang/String;Ljava/lang/String;)V", "getResponse", "()Ljava/lang/String;", "getUserId", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServiceLogs {
    private final String response;
    private final String userId;

    public ServiceLogs() {
        this(null, null, 3, null);
    }

    public ServiceLogs(String userId, String response) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(response, "response");
        this.userId = userId;
        this.response = response;
    }

    public /* synthetic */ ServiceLogs(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getResponse() {
        return this.response;
    }
}

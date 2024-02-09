package com.livpure.safedrink.serviceRequest.data.Models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServiceRequestHistory.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/Models/ServiceRequestHistory;", "", "token_id", "", "job_type", "mobile_number", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getJob_type", "()Ljava/lang/String;", "getMobile_number", "getToken_id", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServiceRequestHistory {
    private final String job_type;
    private final String mobile_number;
    private final String token_id;

    public ServiceRequestHistory() {
        this(null, null, null, 7, null);
    }

    public ServiceRequestHistory(String token_id, String job_type, String mobile_number) {
        Intrinsics.checkNotNullParameter(token_id, "token_id");
        Intrinsics.checkNotNullParameter(job_type, "job_type");
        Intrinsics.checkNotNullParameter(mobile_number, "mobile_number");
        this.token_id = token_id;
        this.job_type = job_type;
        this.mobile_number = mobile_number;
    }

    public /* synthetic */ ServiceRequestHistory(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getToken_id() {
        return this.token_id;
    }

    public final String getJob_type() {
        return this.job_type;
    }

    public final String getMobile_number() {
        return this.mobile_number;
    }
}

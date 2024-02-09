package com.livpure.safedrink.serviceRequest.data.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServiceHistory.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/ServiceHistory;", "", "request_ID", "", "data", "Lcom/livpure/safedrink/serviceRequest/data/model/ServiceHistoryBaseClass;", "(Ljava/lang/String;Lcom/livpure/safedrink/serviceRequest/data/model/ServiceHistoryBaseClass;)V", "getData", "()Lcom/livpure/safedrink/serviceRequest/data/model/ServiceHistoryBaseClass;", "getRequest_ID", "()Ljava/lang/String;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServiceHistory {
    @SerializedName("data")
    private final ServiceHistoryBaseClass data;
    @SerializedName("status")
    private final String request_ID;

    public ServiceHistory(String str, ServiceHistoryBaseClass data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.request_ID = str;
        this.data = data;
    }

    public final String getRequest_ID() {
        return this.request_ID;
    }

    public final ServiceHistoryBaseClass getData() {
        return this.data;
    }
}

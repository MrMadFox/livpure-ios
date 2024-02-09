package com.livpure.safedrink.serviceRequest.data.model;

import com.google.gson.annotations.SerializedName;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FreshdeskHistory.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/FreshdeskHistory;", "", "status", "", AnalyticsAttribute.STATUS_CODE_ATTRIBUTE, "", "message", "cases", "", "Lcom/livpure/safedrink/serviceRequest/data/model/FreshdeskHistoryData;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getCases", "()Ljava/util/List;", "getMessage", "()Ljava/lang/String;", "getStatus", "getStatusCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FreshdeskHistory {
    @SerializedName("data")
    private final List<FreshdeskHistoryData> cases;
    @SerializedName("message")
    private final String message;
    @SerializedName("status")
    private final String status;
    @SerializedName(AnalyticsAttribute.STATUS_CODE_ATTRIBUTE)
    private final Integer statusCode;

    public FreshdeskHistory(String str, Integer num, String str2, List<FreshdeskHistoryData> cases) {
        Intrinsics.checkNotNullParameter(cases, "cases");
        this.status = str;
        this.statusCode = num;
        this.message = str2;
        this.cases = cases;
    }

    public final String getStatus() {
        return this.status;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final List<FreshdeskHistoryData> getCases() {
        return this.cases;
    }
}

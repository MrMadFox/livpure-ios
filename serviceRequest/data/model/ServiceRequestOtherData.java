package com.livpure.safedrink.serviceRequest.data.model;

import com.livpure.safedrink.segment.SegmentProperties;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
/* compiled from: ServiceRequestOtherData.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/ServiceRequestOtherData;", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "", "head", "subhead", SegmentProperties.REMARK, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHead", "()Ljava/lang/String;", "getRemark", "getSubhead", "getUserId", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServiceRequestOtherData {
    private final String head;
    private final String remark;
    private final String subhead;
    private final String userId;

    public ServiceRequestOtherData(String str, String str2, String str3, String str4) {
        this.userId = str;
        this.head = str2;
        this.subhead = str3;
        this.remark = str4;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getHead() {
        return this.head;
    }

    public final String getSubhead() {
        return this.subhead;
    }

    public final String getRemark() {
        return this.remark;
    }
}

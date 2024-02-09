package com.livpure.safedrink.serviceRequest.data.model;

import com.google.gson.annotations.SerializedName;
import com.livpure.safedrink.segment.SegmentProperties;
import kotlin.Metadata;
/* compiled from: ServiceHistoryResponse.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/ServiceHistoryResponse;", "", "request_ID", "", "request_date", SegmentProperties.SERVICEREASON, "status", "contact_Person", "contact_Person_Mobile", "resolved_on", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContact_Person", "()Ljava/lang/String;", "getContact_Person_Mobile", "getRequest_ID", "getRequest_date", "getResolved_on", "getService_reason", "getStatus", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServiceHistoryResponse {
    @SerializedName("contact_person")
    private final String contact_Person;
    @SerializedName("contact_Person_Mobile")
    private final String contact_Person_Mobile;
    @SerializedName("Request_Id")
    private final String request_ID;
    @SerializedName("Resolved_on")
    private final String request_date;
    @SerializedName("resolved_on")
    private final String resolved_on;
    @SerializedName("Service_Reason")
    private final String service_reason;
    @SerializedName("Status")
    private final String status;

    public ServiceHistoryResponse(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.request_ID = str;
        this.request_date = str2;
        this.service_reason = str3;
        this.status = str4;
        this.contact_Person = str5;
        this.contact_Person_Mobile = str6;
        this.resolved_on = str7;
    }

    public final String getRequest_ID() {
        return this.request_ID;
    }

    public final String getRequest_date() {
        return this.request_date;
    }

    public final String getService_reason() {
        return this.service_reason;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getContact_Person() {
        return this.contact_Person;
    }

    public final String getContact_Person_Mobile() {
        return this.contact_Person_Mobile;
    }

    public final String getResolved_on() {
        return this.resolved_on;
    }
}

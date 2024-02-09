package com.livpure.safedrink.serviceRequest.data.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
/* compiled from: FreshdeskHistoryData.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/FreshdeskHistoryData;", "", "Request_Id", "", "Created_At", "", "Due_on", "Service_Reason", "Status", "contact_Person", "contact_Person_Mobile", "Resolved_on", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreated_At", "()Ljava/lang/String;", "getDue_on", "getRequest_Id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResolved_on", "getService_Reason", "getStatus", "getContact_Person", "getContact_Person_Mobile", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FreshdeskHistoryData {
    @SerializedName("created_at")
    private final String Created_At;
    @SerializedName("fr_due_by")
    private final String Due_on;
    @SerializedName("id")
    private final Integer Request_Id;
    @SerializedName("due_by")
    private final String Resolved_on;
    @SerializedName("subject")
    private final String Service_Reason;
    @SerializedName("status")
    private final Integer Status;
    @SerializedName("contact_person")
    private final String contact_Person;
    @SerializedName("contact_Person_Mobile")
    private final String contact_Person_Mobile;

    public FreshdeskHistoryData(Integer num, String str, String str2, String str3, Integer num2, String str4, String str5, String str6) {
        this.Request_Id = num;
        this.Created_At = str;
        this.Due_on = str2;
        this.Service_Reason = str3;
        this.Status = num2;
        this.contact_Person = str4;
        this.contact_Person_Mobile = str5;
        this.Resolved_on = str6;
    }

    public final Integer getRequest_Id() {
        return this.Request_Id;
    }

    public final String getCreated_At() {
        return this.Created_At;
    }

    public final String getDue_on() {
        return this.Due_on;
    }

    public final String getService_Reason() {
        return this.Service_Reason;
    }

    public final Integer getStatus() {
        return this.Status;
    }

    public final String getContact_Person() {
        return this.contact_Person;
    }

    public final String getContact_Person_Mobile() {
        return this.contact_Person_Mobile;
    }

    public final String getResolved_on() {
        return this.Resolved_on;
    }
}

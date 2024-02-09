package com.livpure.safedrink.serviceRequest.data.Models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ServiceRequestResponse.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/Models/ServiceRequestResponse;", "", "Status", "", "Msg", "Jobsheet", "case_id", "js_number", "apiException", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getJobsheet", "()Ljava/lang/String;", "getMsg", "getStatus", "getApiException", "()Ljava/lang/Boolean;", "setApiException", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCase_id", "getJs_number", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServiceRequestResponse {
    private final String Jobsheet;
    private final String Msg;
    private final String Status;
    private Boolean apiException;
    private final String case_id;
    private final String js_number;

    public ServiceRequestResponse(String str, String str2, String str3, String str4, String str5, Boolean bool) {
        this.Status = str;
        this.Msg = str2;
        this.Jobsheet = str3;
        this.case_id = str4;
        this.js_number = str5;
        this.apiException = bool;
    }

    public final String getStatus() {
        return this.Status;
    }

    public final String getMsg() {
        return this.Msg;
    }

    public final String getJobsheet() {
        return this.Jobsheet;
    }

    public final String getCase_id() {
        return this.case_id;
    }

    public final String getJs_number() {
        return this.js_number;
    }

    public /* synthetic */ ServiceRequestResponse(String str, String str2, String str3, String str4, String str5, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, (i & 32) != 0 ? false : bool);
    }

    public final Boolean getApiException() {
        return this.apiException;
    }

    public final void setApiException(Boolean bool) {
        this.apiException = bool;
    }
}

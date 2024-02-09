package com.livpure.safedrink.airpurifier.data.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: AirPurifierDashboardDetailsResponse.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDashboardDetailsResponse;", "", "message", "", "status", "", "apiException", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getApiException", "()Ljava/lang/Boolean;", "setApiException", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getStatus", "setStatus", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class AirPurifierDashboardDetailsResponse {
    private Boolean apiException;
    private String message;
    private Boolean status;

    public AirPurifierDashboardDetailsResponse() {
        this(null, null, null, 7, null);
    }

    public AirPurifierDashboardDetailsResponse(String str, Boolean bool, Boolean bool2) {
        this.message = str;
        this.status = bool;
        this.apiException = bool2;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public /* synthetic */ AirPurifierDashboardDetailsResponse(String str, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : bool, (i & 4) != 0 ? false : bool2);
    }

    public final Boolean getStatus() {
        return this.status;
    }

    public final void setStatus(Boolean bool) {
        this.status = bool;
    }

    public final Boolean getApiException() {
        return this.apiException;
    }

    public final void setApiException(Boolean bool) {
        this.apiException = bool;
    }
}

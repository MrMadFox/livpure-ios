package com.livpure.safedrink.api;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: BaseDTO.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b&\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/livpure/safedrink/api/BaseDTO;", "", "message", "", "records", "", "status", "", AnalyticsAttribute.STATUS_CODE_ATTRIBUTE, "", "success", "msg", "(Ljava/lang/String;Ljava/lang/Long;ZILjava/lang/Boolean;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getMsg", "setMsg", "getRecords", "()Ljava/lang/Long;", "setRecords", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getStatus", "()Z", "setStatus", "(Z)V", "getStatusCode", "()I", "setStatusCode", "(I)V", "getSuccess", "()Ljava/lang/Boolean;", "setSuccess", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseDTO {
    private String message;
    private String msg;
    private Long records;
    private boolean status;
    private int statusCode;
    private Boolean success;

    public BaseDTO() {
        this(null, null, false, 0, null, null, 63, null);
    }

    public BaseDTO(String str, Long l, boolean z, int i, Boolean bool, String str2) {
        this.message = str;
        this.records = l;
        this.status = z;
        this.statusCode = i;
        this.success = bool;
        this.msg = str2;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public /* synthetic */ BaseDTO(String str, Long l, boolean z, int i, Boolean bool, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0L : l, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? 200 : i, (i2 & 16) != 0 ? true : bool, (i2 & 32) != 0 ? "" : str2);
    }

    public final Long getRecords() {
        return this.records;
    }

    public final void setRecords(Long l) {
        this.records = l;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final void setStatus(boolean z) {
        this.status = z;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(int i) {
        this.statusCode = i;
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public final void setSuccess(Boolean bool) {
        this.success = bool;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String str) {
        this.msg = str;
    }
}

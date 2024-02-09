package com.livpure.safedrink.login.api.models.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: BaseV1Response.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0007\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "", "message", "", "status", "", "apiException", "isFurlencoUser", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getApiException", "()Ljava/lang/Boolean;", "setApiException", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setFurlencoUser", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getStatus", "setStatus", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class BaseV1Response {
    private Boolean apiException;
    private Boolean isFurlencoUser;
    private String message;
    @SerializedName("success")
    private Boolean status;

    public BaseV1Response() {
        this(null, null, null, null, 15, null);
    }

    public BaseV1Response(String str, Boolean bool, Boolean bool2, Boolean bool3) {
        this.message = str;
        this.status = bool;
        this.apiException = bool2;
        this.isFurlencoUser = bool3;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public /* synthetic */ BaseV1Response(String str, Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : bool, (i & 4) != 0 ? false : bool2, (i & 8) != 0 ? false : bool3);
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean bool) {
        this.status = bool;
    }

    public final Boolean getApiException() {
        return this.apiException;
    }

    public final void setApiException(Boolean bool) {
        this.apiException = bool;
    }

    public final Boolean isFurlencoUser() {
        return this.isFurlencoUser;
    }

    public final void setFurlencoUser(Boolean bool) {
        this.isFurlencoUser = bool;
    }
}

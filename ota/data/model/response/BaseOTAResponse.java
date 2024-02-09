package com.livpure.safedrink.ota.data.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: BaseOTAResponse.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/livpure/safedrink/ota/data/model/response/BaseOTAResponse;", "", "status", "", "apiException", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getApiException", "()Ljava/lang/Boolean;", "setApiException", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getStatus", "setStatus", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class BaseOTAResponse {
    private Boolean apiException;
    @SerializedName("success")
    private Boolean status;

    public BaseOTAResponse() {
        this(null, null, 3, null);
    }

    public BaseOTAResponse(Boolean bool, Boolean bool2) {
        this.status = bool;
        this.apiException = bool2;
    }

    public /* synthetic */ BaseOTAResponse(Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : bool, (i & 2) != 0 ? false : bool2);
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

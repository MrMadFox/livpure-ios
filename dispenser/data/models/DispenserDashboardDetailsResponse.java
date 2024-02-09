package com.livpure.safedrink.dispenser.data.models;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DispenserDashboardDetailsResponse.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J`\u0010\u0013\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u00152!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00140\u00172!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00140\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u001dR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/livpure/safedrink/dispenser/data/models/DispenserDashboardDetailsResponse;", "", "()V", "apiException", "", "getApiException", "()Ljava/lang/Boolean;", "setApiException", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "processResponseWithAPIExceptionForDispense", "", ExifInterface.GPS_DIRECTION_TRUE, "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "response", "onFailure", "function", "Lkotlin/Function0;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class DispenserDashboardDetailsResponse {
    private String message = "";
    private Boolean status = false;
    private Boolean apiException = false;

    public final <T> void processResponseWithAPIExceptionForDispense(Function1<? super T, Unit> onSuccess, Function1<? super T, Unit> onFailure, Function0<Unit> function) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        Intrinsics.checkNotNullParameter(function, "function");
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
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

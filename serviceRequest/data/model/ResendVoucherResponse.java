package com.livpure.safedrink.serviceRequest.data.model;

import com.google.gson.annotations.SerializedName;
import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ResendVoucherResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/ResendVoucherResponse;", "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "message", "", "msg", "(Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getMsg", "component1", "component2", MoEPushConstants.ACTION_COPY, "equals", "", "other", "", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ResendVoucherResponse extends BaseV1Response {
    @SerializedName("error")
    private String message;
    private final String msg;

    public ResendVoucherResponse() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ ResendVoucherResponse copy$default(ResendVoucherResponse resendVoucherResponse, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resendVoucherResponse.getMessage();
        }
        if ((i & 2) != 0) {
            str2 = resendVoucherResponse.msg;
        }
        return resendVoucherResponse.copy(str, str2);
    }

    public final String component1() {
        return getMessage();
    }

    public final String component2() {
        return this.msg;
    }

    public final ResendVoucherResponse copy(String str, String str2) {
        return new ResendVoucherResponse(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ResendVoucherResponse) {
            ResendVoucherResponse resendVoucherResponse = (ResendVoucherResponse) obj;
            return Intrinsics.areEqual(getMessage(), resendVoucherResponse.getMessage()) && Intrinsics.areEqual(this.msg, resendVoucherResponse.msg);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (getMessage() == null ? 0 : getMessage().hashCode()) * 31;
        String str = this.msg;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ResendVoucherResponse(message=" + getMessage() + ", msg=" + this.msg + ')';
    }

    public /* synthetic */ ResendVoucherResponse(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    @Override // com.livpure.safedrink.login.api.models.response.BaseV1Response
    public String getMessage() {
        return this.message;
    }

    @Override // com.livpure.safedrink.login.api.models.response.BaseV1Response
    public void setMessage(String str) {
        this.message = str;
    }

    public final String getMsg() {
        return this.msg;
    }

    public ResendVoucherResponse(String str, String str2) {
        super(null, null, null, null, 15, null);
        this.message = str;
        this.msg = str2;
    }
}

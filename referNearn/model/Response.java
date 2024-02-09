package com.livpure.safedrink.referNearn.model;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Response.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/livpure/safedrink/referNearn/model/Response;", "", "result", "Lcom/livpure/safedrink/referNearn/model/Result;", "message", "", "status", "(Lcom/livpure/safedrink/referNearn/model/Result;Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getResult", "()Lcom/livpure/safedrink/referNearn/model/Result;", "getStatus", "component1", "component2", "component3", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Response {
    @SerializedName("message")
    private final String message;
    @SerializedName("result")
    private final Result result;
    @SerializedName("status")
    private final String status;

    public Response() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Response copy$default(Response response, Result result, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            result = response.result;
        }
        if ((i & 2) != 0) {
            str = response.message;
        }
        if ((i & 4) != 0) {
            str2 = response.status;
        }
        return response.copy(result, str, str2);
    }

    public final Result component1() {
        return this.result;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.status;
    }

    public final Response copy(Result result, String str, String str2) {
        return new Response(result, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Response) {
            Response response = (Response) obj;
            return Intrinsics.areEqual(this.result, response.result) && Intrinsics.areEqual(this.message, response.message) && Intrinsics.areEqual(this.status, response.status);
        }
        return false;
    }

    public int hashCode() {
        Result result = this.result;
        int hashCode = (result == null ? 0 : result.hashCode()) * 31;
        String str = this.message;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.status;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Response(result=" + this.result + ", message=" + this.message + ", status=" + this.status + ')';
    }

    public Response(Result result, String str, String str2) {
        this.result = result;
        this.message = str;
        this.status = str2;
    }

    public /* synthetic */ Response(Result result, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : result, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    public final Result getResult() {
        return this.result;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getStatus() {
        return this.status;
    }
}

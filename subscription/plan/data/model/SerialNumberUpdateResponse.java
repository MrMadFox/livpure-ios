package com.livpure.safedrink.subscription.plan.data.model;

import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SerialNumberUpdateResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/SerialNumberUpdateResponse;", "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "data", "", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SerialNumberUpdateResponse extends BaseV1Response {
    private final String data;

    public static /* synthetic */ SerialNumberUpdateResponse copy$default(SerialNumberUpdateResponse serialNumberUpdateResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = serialNumberUpdateResponse.data;
        }
        return serialNumberUpdateResponse.copy(str);
    }

    public final String component1() {
        return this.data;
    }

    public final SerialNumberUpdateResponse copy(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new SerialNumberUpdateResponse(data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SerialNumberUpdateResponse) && Intrinsics.areEqual(this.data, ((SerialNumberUpdateResponse) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "SerialNumberUpdateResponse(data=" + this.data + ')';
    }

    public final String getData() {
        return this.data;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SerialNumberUpdateResponse(String data) {
        super(null, null, null, null, 15, null);
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }
}

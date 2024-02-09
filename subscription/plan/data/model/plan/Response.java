package com.livpure.safedrink.subscription.plan.data.model.plan;

import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Response.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/plan/Response;", "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "data", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/Data;", "(Lcom/livpure/safedrink/subscription/plan/data/model/plan/Data;)V", "getData", "()Lcom/livpure/safedrink/subscription/plan/data/model/plan/Data;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Response extends BaseV1Response {
    private final Data data;

    public static /* synthetic */ Response copy$default(Response response, Data data, int i, Object obj) {
        if ((i & 1) != 0) {
            data = response.data;
        }
        return response.copy(data);
    }

    public final Data component1() {
        return this.data;
    }

    public final Response copy(Data data) {
        return new Response(data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Response) && Intrinsics.areEqual(this.data, ((Response) obj).data);
    }

    public int hashCode() {
        Data data = this.data;
        if (data == null) {
            return 0;
        }
        return data.hashCode();
    }

    public String toString() {
        return "Response(data=" + this.data + ')';
    }

    public final Data getData() {
        return this.data;
    }

    public Response(Data data) {
        super(null, null, null, null, 15, null);
        this.data = data;
    }
}

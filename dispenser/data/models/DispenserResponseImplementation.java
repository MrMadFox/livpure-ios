package com.livpure.safedrink.dispenser.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DispenserResponseImplementation.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/livpure/safedrink/dispenser/data/models/DispenserResponseImplementation;", "Lcom/livpure/safedrink/dispenser/data/models/DispenserDashboardDetailsResponse;", "data", "", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DispenserResponseImplementation extends DispenserDashboardDetailsResponse {
    private final Object data;

    public static /* synthetic */ DispenserResponseImplementation copy$default(DispenserResponseImplementation dispenserResponseImplementation, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = dispenserResponseImplementation.data;
        }
        return dispenserResponseImplementation.copy(obj);
    }

    public final Object component1() {
        return this.data;
    }

    public final DispenserResponseImplementation copy(Object obj) {
        return new DispenserResponseImplementation(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DispenserResponseImplementation) && Intrinsics.areEqual(this.data, ((DispenserResponseImplementation) obj).data);
    }

    public int hashCode() {
        Object obj = this.data;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "DispenserResponseImplementation(data=" + this.data + ')';
    }

    public DispenserResponseImplementation(Object obj) {
        this.data = obj;
    }

    public final Object getData() {
        return this.data;
    }
}

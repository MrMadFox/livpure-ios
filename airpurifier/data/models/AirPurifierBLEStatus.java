package com.livpure.safedrink.airpurifier.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AirPurifierBLEStatus.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierBLEStatus;", "", "status", "", "serialNo", "(Ljava/lang/String;Ljava/lang/String;)V", "getSerialNo", "()Ljava/lang/String;", "getStatus", "component1", "component2", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AirPurifierBLEStatus {
    private final String serialNo;
    private final String status;

    public AirPurifierBLEStatus() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ AirPurifierBLEStatus copy$default(AirPurifierBLEStatus airPurifierBLEStatus, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = airPurifierBLEStatus.status;
        }
        if ((i & 2) != 0) {
            str2 = airPurifierBLEStatus.serialNo;
        }
        return airPurifierBLEStatus.copy(str, str2);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.serialNo;
    }

    public final AirPurifierBLEStatus copy(String status, String serialNo) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(serialNo, "serialNo");
        return new AirPurifierBLEStatus(status, serialNo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AirPurifierBLEStatus) {
            AirPurifierBLEStatus airPurifierBLEStatus = (AirPurifierBLEStatus) obj;
            return Intrinsics.areEqual(this.status, airPurifierBLEStatus.status) && Intrinsics.areEqual(this.serialNo, airPurifierBLEStatus.serialNo);
        }
        return false;
    }

    public int hashCode() {
        return (this.status.hashCode() * 31) + this.serialNo.hashCode();
    }

    public String toString() {
        return "AirPurifierBLEStatus(status=" + this.status + ", serialNo=" + this.serialNo + ')';
    }

    public AirPurifierBLEStatus(String status, String serialNo) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(serialNo, "serialNo");
        this.status = status;
        this.serialNo = serialNo;
    }

    public /* synthetic */ AirPurifierBLEStatus(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getSerialNo() {
        return this.serialNo;
    }
}

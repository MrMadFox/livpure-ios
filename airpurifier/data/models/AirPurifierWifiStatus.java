package com.livpure.safedrink.airpurifier.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AirPurifierWifiStatus.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierWifiStatus;", "", "deviceId", "", "connectivity", "(Ljava/lang/String;Ljava/lang/String;)V", "getConnectivity", "()Ljava/lang/String;", "getDeviceId", "component1", "component2", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AirPurifierWifiStatus {
    private final String connectivity;
    private final String deviceId;

    public AirPurifierWifiStatus() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ AirPurifierWifiStatus copy$default(AirPurifierWifiStatus airPurifierWifiStatus, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = airPurifierWifiStatus.deviceId;
        }
        if ((i & 2) != 0) {
            str2 = airPurifierWifiStatus.connectivity;
        }
        return airPurifierWifiStatus.copy(str, str2);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.connectivity;
    }

    public final AirPurifierWifiStatus copy(String deviceId, String connectivity) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(connectivity, "connectivity");
        return new AirPurifierWifiStatus(deviceId, connectivity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AirPurifierWifiStatus) {
            AirPurifierWifiStatus airPurifierWifiStatus = (AirPurifierWifiStatus) obj;
            return Intrinsics.areEqual(this.deviceId, airPurifierWifiStatus.deviceId) && Intrinsics.areEqual(this.connectivity, airPurifierWifiStatus.connectivity);
        }
        return false;
    }

    public int hashCode() {
        return (this.deviceId.hashCode() * 31) + this.connectivity.hashCode();
    }

    public String toString() {
        return "AirPurifierWifiStatus(deviceId=" + this.deviceId + ", connectivity=" + this.connectivity + ')';
    }

    public AirPurifierWifiStatus(String deviceId, String connectivity) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(connectivity, "connectivity");
        this.deviceId = deviceId;
        this.connectivity = connectivity;
    }

    public /* synthetic */ AirPurifierWifiStatus(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getConnectivity() {
        return this.connectivity;
    }
}

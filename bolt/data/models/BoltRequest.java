package com.livpure.safedrink.bolt.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BoltRequest.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/livpure/safedrink/bolt/data/models/BoltRequest;", "", "imeiNumber", "", "wifiConfigured", "", "connectivity", "(Ljava/lang/String;ZLjava/lang/String;)V", "getConnectivity", "()Ljava/lang/String;", "getImeiNumber", "getWifiConfigured", "()Z", "component1", "component2", "component3", MoEPushConstants.ACTION_COPY, "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BoltRequest {
    private final String connectivity;
    private final String imeiNumber;
    private final boolean wifiConfigured;

    public static /* synthetic */ BoltRequest copy$default(BoltRequest boltRequest, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = boltRequest.imeiNumber;
        }
        if ((i & 2) != 0) {
            z = boltRequest.wifiConfigured;
        }
        if ((i & 4) != 0) {
            str2 = boltRequest.connectivity;
        }
        return boltRequest.copy(str, z, str2);
    }

    public final String component1() {
        return this.imeiNumber;
    }

    public final boolean component2() {
        return this.wifiConfigured;
    }

    public final String component3() {
        return this.connectivity;
    }

    public final BoltRequest copy(String imeiNumber, boolean z, String str) {
        Intrinsics.checkNotNullParameter(imeiNumber, "imeiNumber");
        return new BoltRequest(imeiNumber, z, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BoltRequest) {
            BoltRequest boltRequest = (BoltRequest) obj;
            return Intrinsics.areEqual(this.imeiNumber, boltRequest.imeiNumber) && this.wifiConfigured == boltRequest.wifiConfigured && Intrinsics.areEqual(this.connectivity, boltRequest.connectivity);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.imeiNumber.hashCode() * 31;
        boolean z = this.wifiConfigured;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        String str = this.connectivity;
        return i2 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BoltRequest(imeiNumber=" + this.imeiNumber + ", wifiConfigured=" + this.wifiConfigured + ", connectivity=" + this.connectivity + ')';
    }

    public BoltRequest(String imeiNumber, boolean z, String str) {
        Intrinsics.checkNotNullParameter(imeiNumber, "imeiNumber");
        this.imeiNumber = imeiNumber;
        this.wifiConfigured = z;
        this.connectivity = str;
    }

    public final String getImeiNumber() {
        return this.imeiNumber;
    }

    public final boolean getWifiConfigured() {
        return this.wifiConfigured;
    }

    public final String getConnectivity() {
        return this.connectivity;
    }
}

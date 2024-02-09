package com.livpure.safedrink.bolt.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BoltBLEUpdate.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/livpure/safedrink/bolt/data/models/BoltBLEUpdate;", "", "serialNo", "", "roData", "isOffline", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "getRoData", "()Ljava/lang/String;", "getSerialNo", "component1", "component2", "component3", MoEPushConstants.ACTION_COPY, "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BoltBLEUpdate {
    private final boolean isOffline;
    private final String roData;
    private final String serialNo;

    public static /* synthetic */ BoltBLEUpdate copy$default(BoltBLEUpdate boltBLEUpdate, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = boltBLEUpdate.serialNo;
        }
        if ((i & 2) != 0) {
            str2 = boltBLEUpdate.roData;
        }
        if ((i & 4) != 0) {
            z = boltBLEUpdate.isOffline;
        }
        return boltBLEUpdate.copy(str, str2, z);
    }

    public final String component1() {
        return this.serialNo;
    }

    public final String component2() {
        return this.roData;
    }

    public final boolean component3() {
        return this.isOffline;
    }

    public final BoltBLEUpdate copy(String serialNo, String roData, boolean z) {
        Intrinsics.checkNotNullParameter(serialNo, "serialNo");
        Intrinsics.checkNotNullParameter(roData, "roData");
        return new BoltBLEUpdate(serialNo, roData, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BoltBLEUpdate) {
            BoltBLEUpdate boltBLEUpdate = (BoltBLEUpdate) obj;
            return Intrinsics.areEqual(this.serialNo, boltBLEUpdate.serialNo) && Intrinsics.areEqual(this.roData, boltBLEUpdate.roData) && this.isOffline == boltBLEUpdate.isOffline;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.serialNo.hashCode() * 31) + this.roData.hashCode()) * 31;
        boolean z = this.isOffline;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "BoltBLEUpdate(serialNo=" + this.serialNo + ", roData=" + this.roData + ", isOffline=" + this.isOffline + ')';
    }

    public BoltBLEUpdate(String serialNo, String roData, boolean z) {
        Intrinsics.checkNotNullParameter(serialNo, "serialNo");
        Intrinsics.checkNotNullParameter(roData, "roData");
        this.serialNo = serialNo;
        this.roData = roData;
        this.isOffline = z;
    }

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final String getRoData() {
        return this.roData;
    }

    public final boolean isOffline() {
        return this.isOffline;
    }
}

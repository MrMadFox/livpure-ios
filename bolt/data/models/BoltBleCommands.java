package com.livpure.safedrink.bolt.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BoltBleCommands.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/livpure/safedrink/bolt/data/models/BoltBleCommands;", "", "serialNo", "", "(Ljava/lang/String;)V", "getSerialNo", "()Ljava/lang/String;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BoltBleCommands {
    private final String serialNo;

    public static /* synthetic */ BoltBleCommands copy$default(BoltBleCommands boltBleCommands, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = boltBleCommands.serialNo;
        }
        return boltBleCommands.copy(str);
    }

    public final String component1() {
        return this.serialNo;
    }

    public final BoltBleCommands copy(String serialNo) {
        Intrinsics.checkNotNullParameter(serialNo, "serialNo");
        return new BoltBleCommands(serialNo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BoltBleCommands) && Intrinsics.areEqual(this.serialNo, ((BoltBleCommands) obj).serialNo);
    }

    public int hashCode() {
        return this.serialNo.hashCode();
    }

    public String toString() {
        return "BoltBleCommands(serialNo=" + this.serialNo + ')';
    }

    public BoltBleCommands(String serialNo) {
        Intrinsics.checkNotNullParameter(serialNo, "serialNo");
        this.serialNo = serialNo;
    }

    public final String getSerialNo() {
        return this.serialNo;
    }
}

package com.livpure.safedrink.serviceRequest.data.model;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TrackOrderReq.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/TrackOrderReq;", "", "MobileNo", "", "(Ljava/lang/String;)V", "getMobileNo", "()Ljava/lang/String;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TrackOrderReq {
    private final String MobileNo;

    public static /* synthetic */ TrackOrderReq copy$default(TrackOrderReq trackOrderReq, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = trackOrderReq.MobileNo;
        }
        return trackOrderReq.copy(str);
    }

    public final String component1() {
        return this.MobileNo;
    }

    public final TrackOrderReq copy(String str) {
        return new TrackOrderReq(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TrackOrderReq) && Intrinsics.areEqual(this.MobileNo, ((TrackOrderReq) obj).MobileNo);
    }

    public int hashCode() {
        String str = this.MobileNo;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "TrackOrderReq(MobileNo=" + this.MobileNo + ')';
    }

    public TrackOrderReq(String str) {
        this.MobileNo = str;
    }

    public final String getMobileNo() {
        return this.MobileNo;
    }
}

package com.livpure.safedrink.serviceRequest.data.model;

import com.moengage.pushbase.MoEPushConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TrackOrderRes.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/TrackOrderRes;", "", "orderStatus", "", "Lcom/livpure/safedrink/serviceRequest/data/model/TrackOrderList;", "userDetails", "Lcom/livpure/safedrink/serviceRequest/data/model/TrackOrderUserDetails;", "(Ljava/util/List;Lcom/livpure/safedrink/serviceRequest/data/model/TrackOrderUserDetails;)V", "getOrderStatus", "()Ljava/util/List;", "getUserDetails", "()Lcom/livpure/safedrink/serviceRequest/data/model/TrackOrderUserDetails;", "component1", "component2", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TrackOrderRes {
    private final List<TrackOrderList> orderStatus;
    private final TrackOrderUserDetails userDetails;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TrackOrderRes copy$default(TrackOrderRes trackOrderRes, List list, TrackOrderUserDetails trackOrderUserDetails, int i, Object obj) {
        if ((i & 1) != 0) {
            list = trackOrderRes.orderStatus;
        }
        if ((i & 2) != 0) {
            trackOrderUserDetails = trackOrderRes.userDetails;
        }
        return trackOrderRes.copy(list, trackOrderUserDetails);
    }

    public final List<TrackOrderList> component1() {
        return this.orderStatus;
    }

    public final TrackOrderUserDetails component2() {
        return this.userDetails;
    }

    public final TrackOrderRes copy(List<TrackOrderList> list, TrackOrderUserDetails trackOrderUserDetails) {
        return new TrackOrderRes(list, trackOrderUserDetails);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TrackOrderRes) {
            TrackOrderRes trackOrderRes = (TrackOrderRes) obj;
            return Intrinsics.areEqual(this.orderStatus, trackOrderRes.orderStatus) && Intrinsics.areEqual(this.userDetails, trackOrderRes.userDetails);
        }
        return false;
    }

    public int hashCode() {
        List<TrackOrderList> list = this.orderStatus;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        TrackOrderUserDetails trackOrderUserDetails = this.userDetails;
        return hashCode + (trackOrderUserDetails != null ? trackOrderUserDetails.hashCode() : 0);
    }

    public String toString() {
        return "TrackOrderRes(orderStatus=" + this.orderStatus + ", userDetails=" + this.userDetails + ')';
    }

    public TrackOrderRes(List<TrackOrderList> list, TrackOrderUserDetails trackOrderUserDetails) {
        this.orderStatus = list;
        this.userDetails = trackOrderUserDetails;
    }

    public final List<TrackOrderList> getOrderStatus() {
        return this.orderStatus;
    }

    public final TrackOrderUserDetails getUserDetails() {
        return this.userDetails;
    }
}

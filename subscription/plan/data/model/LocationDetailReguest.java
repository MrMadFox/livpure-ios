package com.livpure.safedrink.subscription.plan.data.model;

import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LocationDetailReguest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/LocationDetailReguest;", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "", "serialNo", "latitude", "longitude", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLatitude", "()Ljava/lang/String;", "getLongitude", "getSerialNo", "getUserId", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LocationDetailReguest {
    private final String latitude;
    private final String longitude;
    private final String serialNo;
    private final String userId;

    public static /* synthetic */ LocationDetailReguest copy$default(LocationDetailReguest locationDetailReguest, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = locationDetailReguest.userId;
        }
        if ((i & 2) != 0) {
            str2 = locationDetailReguest.serialNo;
        }
        if ((i & 4) != 0) {
            str3 = locationDetailReguest.latitude;
        }
        if ((i & 8) != 0) {
            str4 = locationDetailReguest.longitude;
        }
        return locationDetailReguest.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.serialNo;
    }

    public final String component3() {
        return this.latitude;
    }

    public final String component4() {
        return this.longitude;
    }

    public final LocationDetailReguest copy(String userId, String serialNo, String latitude, String longitude) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(serialNo, "serialNo");
        Intrinsics.checkNotNullParameter(latitude, "latitude");
        Intrinsics.checkNotNullParameter(longitude, "longitude");
        return new LocationDetailReguest(userId, serialNo, latitude, longitude);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocationDetailReguest) {
            LocationDetailReguest locationDetailReguest = (LocationDetailReguest) obj;
            return Intrinsics.areEqual(this.userId, locationDetailReguest.userId) && Intrinsics.areEqual(this.serialNo, locationDetailReguest.serialNo) && Intrinsics.areEqual(this.latitude, locationDetailReguest.latitude) && Intrinsics.areEqual(this.longitude, locationDetailReguest.longitude);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.userId.hashCode() * 31) + this.serialNo.hashCode()) * 31) + this.latitude.hashCode()) * 31) + this.longitude.hashCode();
    }

    public String toString() {
        return "LocationDetailReguest(userId=" + this.userId + ", serialNo=" + this.serialNo + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ')';
    }

    public LocationDetailReguest(String userId, String serialNo, String latitude, String longitude) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(serialNo, "serialNo");
        Intrinsics.checkNotNullParameter(latitude, "latitude");
        Intrinsics.checkNotNullParameter(longitude, "longitude");
        this.userId = userId;
        this.serialNo = serialNo;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final String getLatitude() {
        return this.latitude;
    }

    public final String getLongitude() {
        return this.longitude;
    }
}

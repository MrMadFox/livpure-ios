package com.livpure.safedrink.login.api.models.request;

import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DeviceDetailsRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/login/api/models/request/DeviceDetailsRequest;", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "", "deviceId", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getUserId", "component1", "component2", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeviceDetailsRequest {
    private final String deviceId;
    private final String userId;

    public static /* synthetic */ DeviceDetailsRequest copy$default(DeviceDetailsRequest deviceDetailsRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceDetailsRequest.userId;
        }
        if ((i & 2) != 0) {
            str2 = deviceDetailsRequest.deviceId;
        }
        return deviceDetailsRequest.copy(str, str2);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final DeviceDetailsRequest copy(String userId, String deviceId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        return new DeviceDetailsRequest(userId, deviceId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeviceDetailsRequest) {
            DeviceDetailsRequest deviceDetailsRequest = (DeviceDetailsRequest) obj;
            return Intrinsics.areEqual(this.userId, deviceDetailsRequest.userId) && Intrinsics.areEqual(this.deviceId, deviceDetailsRequest.deviceId);
        }
        return false;
    }

    public int hashCode() {
        return (this.userId.hashCode() * 31) + this.deviceId.hashCode();
    }

    public String toString() {
        return "DeviceDetailsRequest(userId=" + this.userId + ", deviceId=" + this.deviceId + ')';
    }

    public DeviceDetailsRequest(String userId, String deviceId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        this.userId = userId;
        this.deviceId = deviceId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }
}

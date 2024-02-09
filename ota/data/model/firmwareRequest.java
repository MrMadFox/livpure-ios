package com.livpure.safedrink.ota.data.model;

import com.facebook.internal.NativeProtocol;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: firmwareRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/livpure/safedrink/ota/data/model/firmwareRequest;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "macId", "roData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getMacId", "getRoData", "component1", "component2", "component3", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class firmwareRequest {
    private final String action;
    private final String macId;
    private final String roData;

    public static /* synthetic */ firmwareRequest copy$default(firmwareRequest firmwarerequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = firmwarerequest.action;
        }
        if ((i & 2) != 0) {
            str2 = firmwarerequest.macId;
        }
        if ((i & 4) != 0) {
            str3 = firmwarerequest.roData;
        }
        return firmwarerequest.copy(str, str2, str3);
    }

    public final String component1() {
        return this.action;
    }

    public final String component2() {
        return this.macId;
    }

    public final String component3() {
        return this.roData;
    }

    public final firmwareRequest copy(String action, String macId, String roData) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(macId, "macId");
        Intrinsics.checkNotNullParameter(roData, "roData");
        return new firmwareRequest(action, macId, roData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof firmwareRequest) {
            firmwareRequest firmwarerequest = (firmwareRequest) obj;
            return Intrinsics.areEqual(this.action, firmwarerequest.action) && Intrinsics.areEqual(this.macId, firmwarerequest.macId) && Intrinsics.areEqual(this.roData, firmwarerequest.roData);
        }
        return false;
    }

    public int hashCode() {
        return (((this.action.hashCode() * 31) + this.macId.hashCode()) * 31) + this.roData.hashCode();
    }

    public String toString() {
        return "firmwareRequest(action=" + this.action + ", macId=" + this.macId + ", roData=" + this.roData + ')';
    }

    public firmwareRequest(String action, String macId, String roData) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(macId, "macId");
        Intrinsics.checkNotNullParameter(roData, "roData");
        this.action = action;
        this.macId = macId;
        this.roData = roData;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getMacId() {
        return this.macId;
    }

    public final String getRoData() {
        return this.roData;
    }
}

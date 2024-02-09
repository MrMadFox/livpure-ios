package com.livpure.safedrink.ota.data.model;

import com.facebook.internal.NativeProtocol;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: OTARequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/livpure/safedrink/ota/data/model/OTARequest;", "", "productType", "", NativeProtocol.WEB_DIALOG_ACTION, "macId", "hardwareVersion", "softwareVersion", "roData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getHardwareVersion", "getMacId", "getProductType", "getRoData", "getSoftwareVersion", "component1", "component2", "component3", "component4", "component5", "component6", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OTARequest {
    private final String action;
    private final String hardwareVersion;
    private final String macId;
    private final String productType;
    private final String roData;
    private final String softwareVersion;

    public static /* synthetic */ OTARequest copy$default(OTARequest oTARequest, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oTARequest.productType;
        }
        if ((i & 2) != 0) {
            str2 = oTARequest.action;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = oTARequest.macId;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = oTARequest.hardwareVersion;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = oTARequest.softwareVersion;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = oTARequest.roData;
        }
        return oTARequest.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.productType;
    }

    public final String component2() {
        return this.action;
    }

    public final String component3() {
        return this.macId;
    }

    public final String component4() {
        return this.hardwareVersion;
    }

    public final String component5() {
        return this.softwareVersion;
    }

    public final String component6() {
        return this.roData;
    }

    public final OTARequest copy(String productType, String action, String macId, String hardwareVersion, String softwareVersion, String roData) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(macId, "macId");
        Intrinsics.checkNotNullParameter(hardwareVersion, "hardwareVersion");
        Intrinsics.checkNotNullParameter(softwareVersion, "softwareVersion");
        Intrinsics.checkNotNullParameter(roData, "roData");
        return new OTARequest(productType, action, macId, hardwareVersion, softwareVersion, roData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OTARequest) {
            OTARequest oTARequest = (OTARequest) obj;
            return Intrinsics.areEqual(this.productType, oTARequest.productType) && Intrinsics.areEqual(this.action, oTARequest.action) && Intrinsics.areEqual(this.macId, oTARequest.macId) && Intrinsics.areEqual(this.hardwareVersion, oTARequest.hardwareVersion) && Intrinsics.areEqual(this.softwareVersion, oTARequest.softwareVersion) && Intrinsics.areEqual(this.roData, oTARequest.roData);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.productType.hashCode() * 31) + this.action.hashCode()) * 31) + this.macId.hashCode()) * 31) + this.hardwareVersion.hashCode()) * 31) + this.softwareVersion.hashCode()) * 31) + this.roData.hashCode();
    }

    public String toString() {
        return "OTARequest(productType=" + this.productType + ", action=" + this.action + ", macId=" + this.macId + ", hardwareVersion=" + this.hardwareVersion + ", softwareVersion=" + this.softwareVersion + ", roData=" + this.roData + ')';
    }

    public OTARequest(String productType, String action, String macId, String hardwareVersion, String softwareVersion, String roData) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(macId, "macId");
        Intrinsics.checkNotNullParameter(hardwareVersion, "hardwareVersion");
        Intrinsics.checkNotNullParameter(softwareVersion, "softwareVersion");
        Intrinsics.checkNotNullParameter(roData, "roData");
        this.productType = productType;
        this.action = action;
        this.macId = macId;
        this.hardwareVersion = hardwareVersion;
        this.softwareVersion = softwareVersion;
        this.roData = roData;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getMacId() {
        return this.macId;
    }

    public final String getHardwareVersion() {
        return this.hardwareVersion;
    }

    public final String getSoftwareVersion() {
        return this.softwareVersion;
    }

    public final String getRoData() {
        return this.roData;
    }
}

package com.livpure.safedrink.airpurifier.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AirPurifierDevice.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003JM\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u0006+"}, d2 = {"Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDevice;", "", "imeiNo", "", "serialNo", "productType", "connectivity", "deviceStatus", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDeviceStatus;", "outdoor", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphOutdoor;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDeviceStatus;Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphOutdoor;)V", "getConnectivity", "()Ljava/lang/String;", "setConnectivity", "(Ljava/lang/String;)V", "getDeviceStatus", "()Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDeviceStatus;", "setDeviceStatus", "(Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDeviceStatus;)V", "getImeiNo", "setImeiNo", "getOutdoor", "()Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphOutdoor;", "setOutdoor", "(Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphOutdoor;)V", "getProductType", "setProductType", "getSerialNo", "setSerialNo", "component1", "component2", "component3", "component4", "component5", "component6", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AirPurifierDevice {
    private String connectivity;
    private AirPurifierDeviceStatus deviceStatus;
    private String imeiNo;
    private AirPurifierGraphOutdoor outdoor;
    private String productType;
    private String serialNo;

    public static /* synthetic */ AirPurifierDevice copy$default(AirPurifierDevice airPurifierDevice, String str, String str2, String str3, String str4, AirPurifierDeviceStatus airPurifierDeviceStatus, AirPurifierGraphOutdoor airPurifierGraphOutdoor, int i, Object obj) {
        if ((i & 1) != 0) {
            str = airPurifierDevice.imeiNo;
        }
        if ((i & 2) != 0) {
            str2 = airPurifierDevice.serialNo;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = airPurifierDevice.productType;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = airPurifierDevice.connectivity;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            airPurifierDeviceStatus = airPurifierDevice.deviceStatus;
        }
        AirPurifierDeviceStatus airPurifierDeviceStatus2 = airPurifierDeviceStatus;
        if ((i & 32) != 0) {
            airPurifierGraphOutdoor = airPurifierDevice.outdoor;
        }
        return airPurifierDevice.copy(str, str5, str6, str7, airPurifierDeviceStatus2, airPurifierGraphOutdoor);
    }

    public final String component1() {
        return this.imeiNo;
    }

    public final String component2() {
        return this.serialNo;
    }

    public final String component3() {
        return this.productType;
    }

    public final String component4() {
        return this.connectivity;
    }

    public final AirPurifierDeviceStatus component5() {
        return this.deviceStatus;
    }

    public final AirPurifierGraphOutdoor component6() {
        return this.outdoor;
    }

    public final AirPurifierDevice copy(String str, String str2, String str3, String str4, AirPurifierDeviceStatus deviceStatus, AirPurifierGraphOutdoor outdoor) {
        Intrinsics.checkNotNullParameter(deviceStatus, "deviceStatus");
        Intrinsics.checkNotNullParameter(outdoor, "outdoor");
        return new AirPurifierDevice(str, str2, str3, str4, deviceStatus, outdoor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AirPurifierDevice) {
            AirPurifierDevice airPurifierDevice = (AirPurifierDevice) obj;
            return Intrinsics.areEqual(this.imeiNo, airPurifierDevice.imeiNo) && Intrinsics.areEqual(this.serialNo, airPurifierDevice.serialNo) && Intrinsics.areEqual(this.productType, airPurifierDevice.productType) && Intrinsics.areEqual(this.connectivity, airPurifierDevice.connectivity) && Intrinsics.areEqual(this.deviceStatus, airPurifierDevice.deviceStatus) && Intrinsics.areEqual(this.outdoor, airPurifierDevice.outdoor);
        }
        return false;
    }

    public int hashCode() {
        String str = this.imeiNo;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.serialNo;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.productType;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.connectivity;
        return ((((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.deviceStatus.hashCode()) * 31) + this.outdoor.hashCode();
    }

    public String toString() {
        return "AirPurifierDevice(imeiNo=" + this.imeiNo + ", serialNo=" + this.serialNo + ", productType=" + this.productType + ", connectivity=" + this.connectivity + ", deviceStatus=" + this.deviceStatus + ", outdoor=" + this.outdoor + ')';
    }

    public AirPurifierDevice(String str, String str2, String str3, String str4, AirPurifierDeviceStatus deviceStatus, AirPurifierGraphOutdoor outdoor) {
        Intrinsics.checkNotNullParameter(deviceStatus, "deviceStatus");
        Intrinsics.checkNotNullParameter(outdoor, "outdoor");
        this.imeiNo = str;
        this.serialNo = str2;
        this.productType = str3;
        this.connectivity = str4;
        this.deviceStatus = deviceStatus;
        this.outdoor = outdoor;
    }

    public /* synthetic */ AirPurifierDevice(String str, String str2, String str3, String str4, AirPurifierDeviceStatus airPurifierDeviceStatus, AirPurifierGraphOutdoor airPurifierGraphOutdoor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, airPurifierDeviceStatus, airPurifierGraphOutdoor);
    }

    public final String getImeiNo() {
        return this.imeiNo;
    }

    public final void setImeiNo(String str) {
        this.imeiNo = str;
    }

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final void setSerialNo(String str) {
        this.serialNo = str;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final void setProductType(String str) {
        this.productType = str;
    }

    public final String getConnectivity() {
        return this.connectivity;
    }

    public final void setConnectivity(String str) {
        this.connectivity = str;
    }

    public final AirPurifierDeviceStatus getDeviceStatus() {
        return this.deviceStatus;
    }

    public final void setDeviceStatus(AirPurifierDeviceStatus airPurifierDeviceStatus) {
        Intrinsics.checkNotNullParameter(airPurifierDeviceStatus, "<set-?>");
        this.deviceStatus = airPurifierDeviceStatus;
    }

    public final AirPurifierGraphOutdoor getOutdoor() {
        return this.outdoor;
    }

    public final void setOutdoor(AirPurifierGraphOutdoor airPurifierGraphOutdoor) {
        Intrinsics.checkNotNullParameter(airPurifierGraphOutdoor, "<set-?>");
        this.outdoor = airPurifierGraphOutdoor;
    }
}

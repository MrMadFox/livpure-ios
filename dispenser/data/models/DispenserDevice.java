package com.livpure.safedrink.dispenser.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DispenserDevice.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003JC\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006$"}, d2 = {"Lcom/livpure/safedrink/dispenser/data/models/DispenserDevice;", "", "imeiNo", "", "serialNo", "productType", "connectivity", "deviceStatus", "Lcom/livpure/safedrink/dispenser/data/models/DispenserDeviceStatus;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/livpure/safedrink/dispenser/data/models/DispenserDeviceStatus;)V", "getConnectivity", "()Ljava/lang/String;", "setConnectivity", "(Ljava/lang/String;)V", "getDeviceStatus", "()Lcom/livpure/safedrink/dispenser/data/models/DispenserDeviceStatus;", "setDeviceStatus", "(Lcom/livpure/safedrink/dispenser/data/models/DispenserDeviceStatus;)V", "getImeiNo", "setImeiNo", "getProductType", "setProductType", "getSerialNo", "setSerialNo", "component1", "component2", "component3", "component4", "component5", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DispenserDevice {
    private String connectivity;
    private DispenserDeviceStatus deviceStatus;
    private String imeiNo;
    private String productType;
    private String serialNo;

    public static /* synthetic */ DispenserDevice copy$default(DispenserDevice dispenserDevice, String str, String str2, String str3, String str4, DispenserDeviceStatus dispenserDeviceStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dispenserDevice.imeiNo;
        }
        if ((i & 2) != 0) {
            str2 = dispenserDevice.serialNo;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = dispenserDevice.productType;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = dispenserDevice.connectivity;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            dispenserDeviceStatus = dispenserDevice.deviceStatus;
        }
        return dispenserDevice.copy(str, str5, str6, str7, dispenserDeviceStatus);
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

    public final DispenserDeviceStatus component5() {
        return this.deviceStatus;
    }

    public final DispenserDevice copy(String str, String str2, String str3, String str4, DispenserDeviceStatus deviceStatus) {
        Intrinsics.checkNotNullParameter(deviceStatus, "deviceStatus");
        return new DispenserDevice(str, str2, str3, str4, deviceStatus);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DispenserDevice) {
            DispenserDevice dispenserDevice = (DispenserDevice) obj;
            return Intrinsics.areEqual(this.imeiNo, dispenserDevice.imeiNo) && Intrinsics.areEqual(this.serialNo, dispenserDevice.serialNo) && Intrinsics.areEqual(this.productType, dispenserDevice.productType) && Intrinsics.areEqual(this.connectivity, dispenserDevice.connectivity) && Intrinsics.areEqual(this.deviceStatus, dispenserDevice.deviceStatus);
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
        return ((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.deviceStatus.hashCode();
    }

    public String toString() {
        return "DispenserDevice(imeiNo=" + this.imeiNo + ", serialNo=" + this.serialNo + ", productType=" + this.productType + ", connectivity=" + this.connectivity + ", deviceStatus=" + this.deviceStatus + ')';
    }

    public DispenserDevice(String str, String str2, String str3, String str4, DispenserDeviceStatus deviceStatus) {
        Intrinsics.checkNotNullParameter(deviceStatus, "deviceStatus");
        this.imeiNo = str;
        this.serialNo = str2;
        this.productType = str3;
        this.connectivity = str4;
        this.deviceStatus = deviceStatus;
    }

    public /* synthetic */ DispenserDevice(String str, String str2, String str3, String str4, DispenserDeviceStatus dispenserDeviceStatus, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, dispenserDeviceStatus);
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

    public final DispenserDeviceStatus getDeviceStatus() {
        return this.deviceStatus;
    }

    public final void setDeviceStatus(DispenserDeviceStatus dispenserDeviceStatus) {
        Intrinsics.checkNotNullParameter(dispenserDeviceStatus, "<set-?>");
        this.deviceStatus = dispenserDeviceStatus;
    }
}

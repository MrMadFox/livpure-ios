package com.livpure.safedrink.subscription.plan.data.model.deviceList;

import com.moengage.pushbase.MoEPushConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DeviceData.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceData;", "", "devices", "", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "airDevices", "(Ljava/util/List;Ljava/util/List;)V", "getAirDevices", "()Ljava/util/List;", "getDevices", "component1", "component2", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeviceData {
    private final List<DeviceList> airDevices;
    private final List<DeviceList> devices;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeviceData copy$default(DeviceData deviceData, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = deviceData.devices;
        }
        if ((i & 2) != 0) {
            list2 = deviceData.airDevices;
        }
        return deviceData.copy(list, list2);
    }

    public final List<DeviceList> component1() {
        return this.devices;
    }

    public final List<DeviceList> component2() {
        return this.airDevices;
    }

    public final DeviceData copy(List<DeviceList> devices, List<DeviceList> airDevices) {
        Intrinsics.checkNotNullParameter(devices, "devices");
        Intrinsics.checkNotNullParameter(airDevices, "airDevices");
        return new DeviceData(devices, airDevices);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeviceData) {
            DeviceData deviceData = (DeviceData) obj;
            return Intrinsics.areEqual(this.devices, deviceData.devices) && Intrinsics.areEqual(this.airDevices, deviceData.airDevices);
        }
        return false;
    }

    public int hashCode() {
        return (this.devices.hashCode() * 31) + this.airDevices.hashCode();
    }

    public String toString() {
        return "DeviceData(devices=" + this.devices + ", airDevices=" + this.airDevices + ')';
    }

    public DeviceData(List<DeviceList> devices, List<DeviceList> airDevices) {
        Intrinsics.checkNotNullParameter(devices, "devices");
        Intrinsics.checkNotNullParameter(airDevices, "airDevices");
        this.devices = devices;
        this.airDevices = airDevices;
    }

    public final List<DeviceList> getDevices() {
        return this.devices;
    }

    public final List<DeviceList> getAirDevices() {
        return this.airDevices;
    }
}

package com.livpure.safedrink.subscription.plan.data.model;

import com.moengage.pushbase.MoEPushConstants;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
/* compiled from: FirmwareDetails.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001d\u001a\u00020\u0013J\u0006\u0010\u001e\u001a\u00020\u0013J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\""}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/FirmwareDetails;", "", "currentHardwareVersion", "", "currentSoftwareVersion", "latestHardwareVersion", "latestSoftwareVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCurrentHardwareVersion", "()Ljava/lang/String;", "setCurrentHardwareVersion", "(Ljava/lang/String;)V", "getCurrentSoftwareVersion", "setCurrentSoftwareVersion", "getLatestHardwareVersion", "setLatestHardwareVersion", "getLatestSoftwareVersion", "setLatestSoftwareVersion", "compareVersions", "", "version1", "version2", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "equals", "other", "getHardwareVersion", "getSoftwareVersion", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FirmwareDetails {
    private String currentHardwareVersion;
    private String currentSoftwareVersion;
    private String latestHardwareVersion;
    private String latestSoftwareVersion;

    public static /* synthetic */ FirmwareDetails copy$default(FirmwareDetails firmwareDetails, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = firmwareDetails.currentHardwareVersion;
        }
        if ((i & 2) != 0) {
            str2 = firmwareDetails.currentSoftwareVersion;
        }
        if ((i & 4) != 0) {
            str3 = firmwareDetails.latestHardwareVersion;
        }
        if ((i & 8) != 0) {
            str4 = firmwareDetails.latestSoftwareVersion;
        }
        return firmwareDetails.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.currentHardwareVersion;
    }

    public final String component2() {
        return this.currentSoftwareVersion;
    }

    public final String component3() {
        return this.latestHardwareVersion;
    }

    public final String component4() {
        return this.latestSoftwareVersion;
    }

    public final FirmwareDetails copy(String currentHardwareVersion, String currentSoftwareVersion, String latestHardwareVersion, String latestSoftwareVersion) {
        Intrinsics.checkNotNullParameter(currentHardwareVersion, "currentHardwareVersion");
        Intrinsics.checkNotNullParameter(currentSoftwareVersion, "currentSoftwareVersion");
        Intrinsics.checkNotNullParameter(latestHardwareVersion, "latestHardwareVersion");
        Intrinsics.checkNotNullParameter(latestSoftwareVersion, "latestSoftwareVersion");
        return new FirmwareDetails(currentHardwareVersion, currentSoftwareVersion, latestHardwareVersion, latestSoftwareVersion);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FirmwareDetails) {
            FirmwareDetails firmwareDetails = (FirmwareDetails) obj;
            return Intrinsics.areEqual(this.currentHardwareVersion, firmwareDetails.currentHardwareVersion) && Intrinsics.areEqual(this.currentSoftwareVersion, firmwareDetails.currentSoftwareVersion) && Intrinsics.areEqual(this.latestHardwareVersion, firmwareDetails.latestHardwareVersion) && Intrinsics.areEqual(this.latestSoftwareVersion, firmwareDetails.latestSoftwareVersion);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.currentHardwareVersion.hashCode() * 31) + this.currentSoftwareVersion.hashCode()) * 31) + this.latestHardwareVersion.hashCode()) * 31) + this.latestSoftwareVersion.hashCode();
    }

    public String toString() {
        return "FirmwareDetails(currentHardwareVersion=" + this.currentHardwareVersion + ", currentSoftwareVersion=" + this.currentSoftwareVersion + ", latestHardwareVersion=" + this.latestHardwareVersion + ", latestSoftwareVersion=" + this.latestSoftwareVersion + ')';
    }

    public FirmwareDetails(String currentHardwareVersion, String currentSoftwareVersion, String latestHardwareVersion, String latestSoftwareVersion) {
        Intrinsics.checkNotNullParameter(currentHardwareVersion, "currentHardwareVersion");
        Intrinsics.checkNotNullParameter(currentSoftwareVersion, "currentSoftwareVersion");
        Intrinsics.checkNotNullParameter(latestHardwareVersion, "latestHardwareVersion");
        Intrinsics.checkNotNullParameter(latestSoftwareVersion, "latestSoftwareVersion");
        this.currentHardwareVersion = currentHardwareVersion;
        this.currentSoftwareVersion = currentSoftwareVersion;
        this.latestHardwareVersion = latestHardwareVersion;
        this.latestSoftwareVersion = latestSoftwareVersion;
    }

    public final String getCurrentHardwareVersion() {
        return this.currentHardwareVersion;
    }

    public final void setCurrentHardwareVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentHardwareVersion = str;
    }

    public final String getCurrentSoftwareVersion() {
        return this.currentSoftwareVersion;
    }

    public final void setCurrentSoftwareVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentSoftwareVersion = str;
    }

    public final String getLatestHardwareVersion() {
        return this.latestHardwareVersion;
    }

    public final void setLatestHardwareVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.latestHardwareVersion = str;
    }

    public final String getLatestSoftwareVersion() {
        return this.latestSoftwareVersion;
    }

    public final void setLatestSoftwareVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.latestSoftwareVersion = str;
    }

    public final boolean getHardwareVersion() {
        return compareVersions(this.currentHardwareVersion, this.latestHardwareVersion);
    }

    public final boolean getSoftwareVersion() {
        return compareVersions(this.currentSoftwareVersion, this.latestSoftwareVersion);
    }

    public final boolean compareVersions(String version1, String version2) {
        Intrinsics.checkNotNullParameter(version1, "version1");
        Intrinsics.checkNotNullParameter(version2, "version2");
        if (!Intrinsics.areEqual(version2, "") && !Intrinsics.areEqual(version1, "")) {
            Object[] array = new Regex("\\.").split(version1, 0).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            Object[] array2 = new Regex("\\.").split(version2, 0).toArray(new String[0]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr2 = (String[]) array2;
            int max = Math.max(strArr.length, strArr2.length);
            int i = 0;
            while (i < max) {
                if (Intrinsics.compare(i < strArr.length ? Integer.parseInt(strArr[i]) : 0, i < strArr2.length ? Integer.parseInt(strArr2[i]) : 0) != 0) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}

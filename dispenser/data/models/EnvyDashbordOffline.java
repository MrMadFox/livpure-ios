package com.livpure.safedrink.dispenser.data.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: envyDashbordOffline.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010&\u001a\u00020\u0010HÖ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0010HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\rR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\r¨\u00062"}, d2 = {"Lcom/livpure/safedrink/dispenser/data/models/EnvyDashbordOffline;", "Landroid/os/Parcelable;", "serialNo", "", "lastSyncOn", "remaining", "planDetails", "filterLife", "tankStatus", "productType", "connectivity", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConnectivity", "()Ljava/lang/String;", "getFilterLife", "id", "", "getId", "()I", "setId", "(I)V", "getLastSyncOn", "getPlanDetails", "getProductType", "getRemaining", "getSerialNo", "setSerialNo", "(Ljava/lang/String;)V", "getTankStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", MoEPushConstants.ACTION_COPY, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EnvyDashbordOffline implements Parcelable {
    public static final Parcelable.Creator<EnvyDashbordOffline> CREATOR = new Creator();
    private final String connectivity;
    private final String filterLife;
    private int id;
    private final String lastSyncOn;
    private final String planDetails;
    private final String productType;
    private final String remaining;
    private String serialNo;
    private final String tankStatus;

    /* compiled from: envyDashbordOffline.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<EnvyDashbordOffline> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EnvyDashbordOffline createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EnvyDashbordOffline(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EnvyDashbordOffline[] newArray(int i) {
            return new EnvyDashbordOffline[i];
        }
    }

    public final String component1() {
        return this.serialNo;
    }

    public final String component2() {
        return this.lastSyncOn;
    }

    public final String component3() {
        return this.remaining;
    }

    public final String component4() {
        return this.planDetails;
    }

    public final String component5() {
        return this.filterLife;
    }

    public final String component6() {
        return this.tankStatus;
    }

    public final String component7() {
        return this.productType;
    }

    public final String component8() {
        return this.connectivity;
    }

    public final EnvyDashbordOffline copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return new EnvyDashbordOffline(str, str2, str3, str4, str5, str6, str7, str8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EnvyDashbordOffline) {
            EnvyDashbordOffline envyDashbordOffline = (EnvyDashbordOffline) obj;
            return Intrinsics.areEqual(this.serialNo, envyDashbordOffline.serialNo) && Intrinsics.areEqual(this.lastSyncOn, envyDashbordOffline.lastSyncOn) && Intrinsics.areEqual(this.remaining, envyDashbordOffline.remaining) && Intrinsics.areEqual(this.planDetails, envyDashbordOffline.planDetails) && Intrinsics.areEqual(this.filterLife, envyDashbordOffline.filterLife) && Intrinsics.areEqual(this.tankStatus, envyDashbordOffline.tankStatus) && Intrinsics.areEqual(this.productType, envyDashbordOffline.productType) && Intrinsics.areEqual(this.connectivity, envyDashbordOffline.connectivity);
        }
        return false;
    }

    public int hashCode() {
        String str = this.serialNo;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.lastSyncOn;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.remaining;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.planDetails;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.filterLife;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.tankStatus;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.productType;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.connectivity;
        return hashCode7 + (str8 != null ? str8.hashCode() : 0);
    }

    public String toString() {
        return "EnvyDashbordOffline(serialNo=" + this.serialNo + ", lastSyncOn=" + this.lastSyncOn + ", remaining=" + this.remaining + ", planDetails=" + this.planDetails + ", filterLife=" + this.filterLife + ", tankStatus=" + this.tankStatus + ", productType=" + this.productType + ", connectivity=" + this.connectivity + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.serialNo);
        out.writeString(this.lastSyncOn);
        out.writeString(this.remaining);
        out.writeString(this.planDetails);
        out.writeString(this.filterLife);
        out.writeString(this.tankStatus);
        out.writeString(this.productType);
        out.writeString(this.connectivity);
    }

    public EnvyDashbordOffline(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.serialNo = str;
        this.lastSyncOn = str2;
        this.remaining = str3;
        this.planDetails = str4;
        this.filterLife = str5;
        this.tankStatus = str6;
        this.productType = str7;
        this.connectivity = str8;
    }

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final void setSerialNo(String str) {
        this.serialNo = str;
    }

    public final String getLastSyncOn() {
        return this.lastSyncOn;
    }

    public final String getRemaining() {
        return this.remaining;
    }

    public final String getPlanDetails() {
        return this.planDetails;
    }

    public final String getFilterLife() {
        return this.filterLife;
    }

    public final String getTankStatus() {
        return this.tankStatus;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final String getConnectivity() {
        return this.connectivity;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }
}

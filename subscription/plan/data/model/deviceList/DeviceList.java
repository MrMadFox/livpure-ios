package com.livpure.safedrink.subscription.plan.data.model.deviceList;

import android.os.Parcel;
import android.os.Parcelable;
import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DeviceList.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\t\u0010&\u001a\u00020\u0013HÖ\u0001J\u0013\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0013HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0013HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0007\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\r¨\u00061"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "Landroid/os/Parcelable;", "SerialNo", "", "ImeiNo", AnalyticsAttribute.USER_ID_ATTRIBUTE, "name", "isConfigured", "", "productType", "connectivity", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getImeiNo", "()Ljava/lang/String;", "getSerialNo", "setSerialNo", "(Ljava/lang/String;)V", "getConnectivity", "id", "", "getId", "()I", "setId", "(I)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getProductType", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", MoEPushConstants.ACTION_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeviceList implements Parcelable {
    public static final Parcelable.Creator<DeviceList> CREATOR = new Creator();
    private final String ImeiNo;
    private String SerialNo;
    private final String connectivity;
    private int id;
    private final Boolean isConfigured;
    private final String name;
    private final String productType;
    private final String userId;

    /* compiled from: DeviceList.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<DeviceList> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DeviceList createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new DeviceList(readString, readString2, readString3, readString4, valueOf, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DeviceList[] newArray(int i) {
            return new DeviceList[i];
        }
    }

    public static /* synthetic */ DeviceList copy$default(DeviceList deviceList, String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceList.SerialNo;
        }
        if ((i & 2) != 0) {
            str2 = deviceList.ImeiNo;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = deviceList.userId;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = deviceList.name;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            bool = deviceList.isConfigured;
        }
        Boolean bool2 = bool;
        if ((i & 32) != 0) {
            str5 = deviceList.productType;
        }
        String str10 = str5;
        if ((i & 64) != 0) {
            str6 = deviceList.connectivity;
        }
        return deviceList.copy(str, str7, str8, str9, bool2, str10, str6);
    }

    public final String component1() {
        return this.SerialNo;
    }

    public final String component2() {
        return this.ImeiNo;
    }

    public final String component3() {
        return this.userId;
    }

    public final String component4() {
        return this.name;
    }

    public final Boolean component5() {
        return this.isConfigured;
    }

    public final String component6() {
        return this.productType;
    }

    public final String component7() {
        return this.connectivity;
    }

    public final DeviceList copy(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6) {
        return new DeviceList(str, str2, str3, str4, bool, str5, str6);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeviceList) {
            DeviceList deviceList = (DeviceList) obj;
            return Intrinsics.areEqual(this.SerialNo, deviceList.SerialNo) && Intrinsics.areEqual(this.ImeiNo, deviceList.ImeiNo) && Intrinsics.areEqual(this.userId, deviceList.userId) && Intrinsics.areEqual(this.name, deviceList.name) && Intrinsics.areEqual(this.isConfigured, deviceList.isConfigured) && Intrinsics.areEqual(this.productType, deviceList.productType) && Intrinsics.areEqual(this.connectivity, deviceList.connectivity);
        }
        return false;
    }

    public int hashCode() {
        String str = this.SerialNo;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.ImeiNo;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.name;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.isConfigured;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str5 = this.productType;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.connectivity;
        return hashCode6 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "DeviceList(SerialNo=" + this.SerialNo + ", ImeiNo=" + this.ImeiNo + ", userId=" + this.userId + ", name=" + this.name + ", isConfigured=" + this.isConfigured + ", productType=" + this.productType + ", connectivity=" + this.connectivity + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.SerialNo);
        out.writeString(this.ImeiNo);
        out.writeString(this.userId);
        out.writeString(this.name);
        Boolean bool = this.isConfigured;
        if (bool == null) {
            i2 = 0;
        } else {
            out.writeInt(1);
            i2 = bool.booleanValue();
        }
        out.writeInt(i2);
        out.writeString(this.productType);
        out.writeString(this.connectivity);
    }

    public DeviceList(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6) {
        this.SerialNo = str;
        this.ImeiNo = str2;
        this.userId = str3;
        this.name = str4;
        this.isConfigured = bool;
        this.productType = str5;
        this.connectivity = str6;
    }

    public final String getSerialNo() {
        return this.SerialNo;
    }

    public final void setSerialNo(String str) {
        this.SerialNo = str;
    }

    public final String getImeiNo() {
        return this.ImeiNo;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean isConfigured() {
        return this.isConfigured;
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

package com.livpure.safedrink.app.recharge.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GstDetailsItem.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/livpure/safedrink/app/recharge/model/GstDetailsItem;", "Landroid/os/Parcelable;", "sgst", "", "taxableValue", "cgst", "igst", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCgst", "()Ljava/lang/String;", "getIgst", "getSgst", "getTaxableValue", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GstDetailsItem implements Parcelable {
    public static final Parcelable.Creator<GstDetailsItem> CREATOR = new Creator();
    private final String cgst;
    private final String igst;
    private final String sgst;
    private final String taxableValue;

    /* compiled from: GstDetailsItem.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<GstDetailsItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GstDetailsItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GstDetailsItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GstDetailsItem[] newArray(int i) {
            return new GstDetailsItem[i];
        }
    }

    public GstDetailsItem() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ GstDetailsItem copy$default(GstDetailsItem gstDetailsItem, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gstDetailsItem.sgst;
        }
        if ((i & 2) != 0) {
            str2 = gstDetailsItem.taxableValue;
        }
        if ((i & 4) != 0) {
            str3 = gstDetailsItem.cgst;
        }
        if ((i & 8) != 0) {
            str4 = gstDetailsItem.igst;
        }
        return gstDetailsItem.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.sgst;
    }

    public final String component2() {
        return this.taxableValue;
    }

    public final String component3() {
        return this.cgst;
    }

    public final String component4() {
        return this.igst;
    }

    public final GstDetailsItem copy(String str, String str2, String str3, String str4) {
        return new GstDetailsItem(str, str2, str3, str4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GstDetailsItem) {
            GstDetailsItem gstDetailsItem = (GstDetailsItem) obj;
            return Intrinsics.areEqual(this.sgst, gstDetailsItem.sgst) && Intrinsics.areEqual(this.taxableValue, gstDetailsItem.taxableValue) && Intrinsics.areEqual(this.cgst, gstDetailsItem.cgst) && Intrinsics.areEqual(this.igst, gstDetailsItem.igst);
        }
        return false;
    }

    public int hashCode() {
        String str = this.sgst;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.taxableValue;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cgst;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.igst;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "GstDetailsItem(sgst=" + this.sgst + ", taxableValue=" + this.taxableValue + ", cgst=" + this.cgst + ", igst=" + this.igst + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.sgst);
        out.writeString(this.taxableValue);
        out.writeString(this.cgst);
        out.writeString(this.igst);
    }

    public GstDetailsItem(String str, String str2, String str3, String str4) {
        this.sgst = str;
        this.taxableValue = str2;
        this.cgst = str3;
        this.igst = str4;
    }

    public /* synthetic */ GstDetailsItem(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getSgst() {
        return this.sgst;
    }

    public final String getTaxableValue() {
        return this.taxableValue;
    }

    public final String getCgst() {
        return this.cgst;
    }

    public final String getIgst() {
        return this.igst;
    }
}

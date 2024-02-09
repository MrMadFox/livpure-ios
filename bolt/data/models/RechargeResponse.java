package com.livpure.safedrink.bolt.data.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RechargeResponse.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/livpure/safedrink/bolt/data/models/RechargeResponse;", "Landroid/os/Parcelable;", "rechargeList", "", "(Ljava/lang/String;)V", "id", "", "getId", "()I", "setId", "(I)V", "getRechargeList", "()Ljava/lang/String;", "component1", MoEPushConstants.ACTION_COPY, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RechargeResponse implements Parcelable {
    public static final Parcelable.Creator<RechargeResponse> CREATOR = new Creator();
    private int id;
    @SerializedName("rechargeCmd")
    private final String rechargeList;

    /* compiled from: RechargeResponse.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<RechargeResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RechargeResponse createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RechargeResponse(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RechargeResponse[] newArray(int i) {
            return new RechargeResponse[i];
        }
    }

    public static /* synthetic */ RechargeResponse copy$default(RechargeResponse rechargeResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rechargeResponse.rechargeList;
        }
        return rechargeResponse.copy(str);
    }

    public final String component1() {
        return this.rechargeList;
    }

    public final RechargeResponse copy(String rechargeList) {
        Intrinsics.checkNotNullParameter(rechargeList, "rechargeList");
        return new RechargeResponse(rechargeList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RechargeResponse) && Intrinsics.areEqual(this.rechargeList, ((RechargeResponse) obj).rechargeList);
    }

    public int hashCode() {
        return this.rechargeList.hashCode();
    }

    public String toString() {
        return "RechargeResponse(rechargeList=" + this.rechargeList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.rechargeList);
    }

    public RechargeResponse(String rechargeList) {
        Intrinsics.checkNotNullParameter(rechargeList, "rechargeList");
        this.rechargeList = rechargeList;
    }

    public final String getRechargeList() {
        return this.rechargeList;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }
}

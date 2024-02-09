package com.livpure.safedrink.dispenser.data.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EnvyBLEResponse.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/livpure/safedrink/dispenser/data/models/EnvyBLEResponse;", "Landroid/os/Parcelable;", "serialNo", "", "response", "(Ljava/lang/String;Ljava/lang/String;)V", "id", "", "getId", "()I", "setId", "(I)V", "getResponse", "()Ljava/lang/String;", "getSerialNo", "setSerialNo", "(Ljava/lang/String;)V", "component1", "component2", MoEPushConstants.ACTION_COPY, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EnvyBLEResponse implements Parcelable {
    public static final Parcelable.Creator<EnvyBLEResponse> CREATOR = new Creator();
    private int id;
    private final String response;
    private String serialNo;

    /* compiled from: EnvyBLEResponse.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<EnvyBLEResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EnvyBLEResponse createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EnvyBLEResponse(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EnvyBLEResponse[] newArray(int i) {
            return new EnvyBLEResponse[i];
        }
    }

    public static /* synthetic */ EnvyBLEResponse copy$default(EnvyBLEResponse envyBLEResponse, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = envyBLEResponse.serialNo;
        }
        if ((i & 2) != 0) {
            str2 = envyBLEResponse.response;
        }
        return envyBLEResponse.copy(str, str2);
    }

    public final String component1() {
        return this.serialNo;
    }

    public final String component2() {
        return this.response;
    }

    public final EnvyBLEResponse copy(String str, String str2) {
        return new EnvyBLEResponse(str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EnvyBLEResponse) {
            EnvyBLEResponse envyBLEResponse = (EnvyBLEResponse) obj;
            return Intrinsics.areEqual(this.serialNo, envyBLEResponse.serialNo) && Intrinsics.areEqual(this.response, envyBLEResponse.response);
        }
        return false;
    }

    public int hashCode() {
        String str = this.serialNo;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.response;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "EnvyBLEResponse(serialNo=" + this.serialNo + ", response=" + this.response + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.serialNo);
        out.writeString(this.response);
    }

    public EnvyBLEResponse(String str, String str2) {
        this.serialNo = str;
        this.response = str2;
    }

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final void setSerialNo(String str) {
        this.serialNo = str;
    }

    public final String getResponse() {
        return this.response;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }
}

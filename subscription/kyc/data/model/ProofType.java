package com.livpure.safedrink.subscription.kyc.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ProofType.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\""}, d2 = {"Lcom/livpure/safedrink/subscription/kyc/data/model/ProofType;", "Landroid/os/Parcelable;", "idProofType", "", "idProofFileName", "addressProofType", "addressProofFileName", "date", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddressProofFileName", "()Ljava/lang/String;", "getAddressProofType", "getDate", "getIdProofFileName", "getIdProofType", "component1", "component2", "component3", "component4", "component5", MoEPushConstants.ACTION_COPY, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ProofType implements Parcelable {
    public static final Parcelable.Creator<ProofType> CREATOR = new Creator();
    private final String addressProofFileName;
    private final String addressProofType;
    private final String date;
    private final String idProofFileName;
    private final String idProofType;

    /* compiled from: ProofType.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<ProofType> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProofType createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ProofType(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProofType[] newArray(int i) {
            return new ProofType[i];
        }
    }

    public static /* synthetic */ ProofType copy$default(ProofType proofType, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = proofType.idProofType;
        }
        if ((i & 2) != 0) {
            str2 = proofType.idProofFileName;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = proofType.addressProofType;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = proofType.addressProofFileName;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = proofType.date;
        }
        return proofType.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.idProofType;
    }

    public final String component2() {
        return this.idProofFileName;
    }

    public final String component3() {
        return this.addressProofType;
    }

    public final String component4() {
        return this.addressProofFileName;
    }

    public final String component5() {
        return this.date;
    }

    public final ProofType copy(String idProofType, String idProofFileName, String addressProofType, String addressProofFileName, String str) {
        Intrinsics.checkNotNullParameter(idProofType, "idProofType");
        Intrinsics.checkNotNullParameter(idProofFileName, "idProofFileName");
        Intrinsics.checkNotNullParameter(addressProofType, "addressProofType");
        Intrinsics.checkNotNullParameter(addressProofFileName, "addressProofFileName");
        return new ProofType(idProofType, idProofFileName, addressProofType, addressProofFileName, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProofType) {
            ProofType proofType = (ProofType) obj;
            return Intrinsics.areEqual(this.idProofType, proofType.idProofType) && Intrinsics.areEqual(this.idProofFileName, proofType.idProofFileName) && Intrinsics.areEqual(this.addressProofType, proofType.addressProofType) && Intrinsics.areEqual(this.addressProofFileName, proofType.addressProofFileName) && Intrinsics.areEqual(this.date, proofType.date);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.idProofType.hashCode() * 31) + this.idProofFileName.hashCode()) * 31) + this.addressProofType.hashCode()) * 31) + this.addressProofFileName.hashCode()) * 31;
        String str = this.date;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ProofType(idProofType=" + this.idProofType + ", idProofFileName=" + this.idProofFileName + ", addressProofType=" + this.addressProofType + ", addressProofFileName=" + this.addressProofFileName + ", date=" + this.date + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.idProofType);
        out.writeString(this.idProofFileName);
        out.writeString(this.addressProofType);
        out.writeString(this.addressProofFileName);
        out.writeString(this.date);
    }

    public ProofType(String idProofType, String idProofFileName, String addressProofType, String addressProofFileName, String str) {
        Intrinsics.checkNotNullParameter(idProofType, "idProofType");
        Intrinsics.checkNotNullParameter(idProofFileName, "idProofFileName");
        Intrinsics.checkNotNullParameter(addressProofType, "addressProofType");
        Intrinsics.checkNotNullParameter(addressProofFileName, "addressProofFileName");
        this.idProofType = idProofType;
        this.idProofFileName = idProofFileName;
        this.addressProofType = addressProofType;
        this.addressProofFileName = addressProofFileName;
        this.date = str;
    }

    public final String getIdProofType() {
        return this.idProofType;
    }

    public final String getIdProofFileName() {
        return this.idProofFileName;
    }

    public final String getAddressProofType() {
        return this.addressProofType;
    }

    public final String getAddressProofFileName() {
        return this.addressProofFileName;
    }

    public final String getDate() {
        return this.date;
    }
}

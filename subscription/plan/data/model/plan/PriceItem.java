package com.livpure.safedrink.subscription.plan.data.model.plan;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import com.moengage.richnotification.internal.RichPushConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PriceItem.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0013\u0010#\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\"HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006-"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/plan/PriceItem;", "Landroid/os/Parcelable;", RichPushConstantsKt.PROPERTY_DURATION_KEY, "", "pricePerMonth", FirebaseAnalytics.Param.PRICE, "offerAmount", "bestValue", "", "saveMessage", "installationAmount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getBestValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDuration", "()Ljava/lang/String;", "setDuration", "(Ljava/lang/String;)V", "getInstallationAmount", "getOfferAmount", "getPrice", "getPricePerMonth", "getSaveMessage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", MoEPushConstants.ACTION_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/livpure/safedrink/subscription/plan/data/model/plan/PriceItem;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PriceItem implements Parcelable {
    public static final Parcelable.Creator<PriceItem> CREATOR = new Creator();
    @SerializedName("bestValue")
    private final Boolean bestValue;
    @SerializedName(RichPushConstantsKt.PROPERTY_DURATION_KEY)
    private String duration;
    @SerializedName("installation_amount")
    private final String installationAmount;
    @SerializedName("offerAmount")
    private final String offerAmount;
    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private final String price;
    @SerializedName("pricePerMonth")
    private final String pricePerMonth;
    @SerializedName("saveMessage")
    private final String saveMessage;

    /* compiled from: PriceItem.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<PriceItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PriceItem createFromParcel(Parcel parcel) {
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
            return new PriceItem(readString, readString2, readString3, readString4, valueOf, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PriceItem[] newArray(int i) {
            return new PriceItem[i];
        }
    }

    public PriceItem() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ PriceItem copy$default(PriceItem priceItem, String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = priceItem.duration;
        }
        if ((i & 2) != 0) {
            str2 = priceItem.pricePerMonth;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = priceItem.price;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = priceItem.offerAmount;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            bool = priceItem.bestValue;
        }
        Boolean bool2 = bool;
        if ((i & 32) != 0) {
            str5 = priceItem.saveMessage;
        }
        String str10 = str5;
        if ((i & 64) != 0) {
            str6 = priceItem.installationAmount;
        }
        return priceItem.copy(str, str7, str8, str9, bool2, str10, str6);
    }

    public final String component1() {
        return this.duration;
    }

    public final String component2() {
        return this.pricePerMonth;
    }

    public final String component3() {
        return this.price;
    }

    public final String component4() {
        return this.offerAmount;
    }

    public final Boolean component5() {
        return this.bestValue;
    }

    public final String component6() {
        return this.saveMessage;
    }

    public final String component7() {
        return this.installationAmount;
    }

    public final PriceItem copy(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6) {
        return new PriceItem(str, str2, str3, str4, bool, str5, str6);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PriceItem) {
            PriceItem priceItem = (PriceItem) obj;
            return Intrinsics.areEqual(this.duration, priceItem.duration) && Intrinsics.areEqual(this.pricePerMonth, priceItem.pricePerMonth) && Intrinsics.areEqual(this.price, priceItem.price) && Intrinsics.areEqual(this.offerAmount, priceItem.offerAmount) && Intrinsics.areEqual(this.bestValue, priceItem.bestValue) && Intrinsics.areEqual(this.saveMessage, priceItem.saveMessage) && Intrinsics.areEqual(this.installationAmount, priceItem.installationAmount);
        }
        return false;
    }

    public int hashCode() {
        String str = this.duration;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.pricePerMonth;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.price;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.offerAmount;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.bestValue;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str5 = this.saveMessage;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.installationAmount;
        return hashCode6 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "PriceItem(duration=" + this.duration + ", pricePerMonth=" + this.pricePerMonth + ", price=" + this.price + ", offerAmount=" + this.offerAmount + ", bestValue=" + this.bestValue + ", saveMessage=" + this.saveMessage + ", installationAmount=" + this.installationAmount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.duration);
        out.writeString(this.pricePerMonth);
        out.writeString(this.price);
        out.writeString(this.offerAmount);
        Boolean bool = this.bestValue;
        if (bool == null) {
            i2 = 0;
        } else {
            out.writeInt(1);
            i2 = bool.booleanValue();
        }
        out.writeInt(i2);
        out.writeString(this.saveMessage);
        out.writeString(this.installationAmount);
    }

    public PriceItem(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6) {
        this.duration = str;
        this.pricePerMonth = str2;
        this.price = str3;
        this.offerAmount = str4;
        this.bestValue = bool;
        this.saveMessage = str5;
        this.installationAmount = str6;
    }

    public /* synthetic */ PriceItem(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6);
    }

    public final String getDuration() {
        return this.duration;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final String getPricePerMonth() {
        return this.pricePerMonth;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getOfferAmount() {
        return this.offerAmount;
    }

    public final Boolean getBestValue() {
        return this.bestValue;
    }

    public final String getSaveMessage() {
        return this.saveMessage;
    }

    public final String getInstallationAmount() {
        return this.installationAmount;
    }
}

package com.livpure.safedrink.subscription.plan.data.model.payment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.moengage.pushbase.MoEPushConstants;
import com.moengage.richnotification.internal.RichPushConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PriceMappingItem.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006&"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/payment/PriceMappingItem;", "Landroid/os/Parcelable;", RichPushConstantsKt.PROPERTY_DURATION_KEY, "", FirebaseAnalytics.Param.PRICE, "pricePerMonth", "offerAmount", "bestValue", "", "saveMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getBestValue", "()Z", "getDuration", "()Ljava/lang/String;", "getOfferAmount", "getPrice", "getPricePerMonth", "getSaveMessage", "component1", "component2", "component3", "component4", "component5", "component6", MoEPushConstants.ACTION_COPY, "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PriceMappingItem implements Parcelable {
    public static final Parcelable.Creator<PriceMappingItem> CREATOR = new Creator();
    private final boolean bestValue;
    private final String duration;
    private final String offerAmount;
    private final String price;
    private final String pricePerMonth;
    private final String saveMessage;

    /* compiled from: PriceMappingItem.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<PriceMappingItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PriceMappingItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PriceMappingItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PriceMappingItem[] newArray(int i) {
            return new PriceMappingItem[i];
        }
    }

    public static /* synthetic */ PriceMappingItem copy$default(PriceMappingItem priceMappingItem, String str, String str2, String str3, String str4, boolean z, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = priceMappingItem.duration;
        }
        if ((i & 2) != 0) {
            str2 = priceMappingItem.price;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = priceMappingItem.pricePerMonth;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = priceMappingItem.offerAmount;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            z = priceMappingItem.bestValue;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            str5 = priceMappingItem.saveMessage;
        }
        return priceMappingItem.copy(str, str6, str7, str8, z2, str5);
    }

    public final String component1() {
        return this.duration;
    }

    public final String component2() {
        return this.price;
    }

    public final String component3() {
        return this.pricePerMonth;
    }

    public final String component4() {
        return this.offerAmount;
    }

    public final boolean component5() {
        return this.bestValue;
    }

    public final String component6() {
        return this.saveMessage;
    }

    public final PriceMappingItem copy(String duration, String price, String str, String offerAmount, boolean z, String str2) {
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(offerAmount, "offerAmount");
        return new PriceMappingItem(duration, price, str, offerAmount, z, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PriceMappingItem) {
            PriceMappingItem priceMappingItem = (PriceMappingItem) obj;
            return Intrinsics.areEqual(this.duration, priceMappingItem.duration) && Intrinsics.areEqual(this.price, priceMappingItem.price) && Intrinsics.areEqual(this.pricePerMonth, priceMappingItem.pricePerMonth) && Intrinsics.areEqual(this.offerAmount, priceMappingItem.offerAmount) && this.bestValue == priceMappingItem.bestValue && Intrinsics.areEqual(this.saveMessage, priceMappingItem.saveMessage);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.duration.hashCode() * 31) + this.price.hashCode()) * 31;
        String str = this.pricePerMonth;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.offerAmount.hashCode()) * 31;
        boolean z = this.bestValue;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode2 + i) * 31;
        String str2 = this.saveMessage;
        return i2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "PriceMappingItem(duration=" + this.duration + ", price=" + this.price + ", pricePerMonth=" + this.pricePerMonth + ", offerAmount=" + this.offerAmount + ", bestValue=" + this.bestValue + ", saveMessage=" + this.saveMessage + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.duration);
        out.writeString(this.price);
        out.writeString(this.pricePerMonth);
        out.writeString(this.offerAmount);
        out.writeInt(this.bestValue ? 1 : 0);
        out.writeString(this.saveMessage);
    }

    public PriceMappingItem(String duration, String price, String str, String offerAmount, boolean z, String str2) {
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(offerAmount, "offerAmount");
        this.duration = duration;
        this.price = price;
        this.pricePerMonth = str;
        this.offerAmount = offerAmount;
        this.bestValue = z;
        this.saveMessage = str2;
    }

    public /* synthetic */ PriceMappingItem(String str, String str2, String str3, String str4, boolean z, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, str4, z, (i & 32) != 0 ? null : str5);
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getPricePerMonth() {
        return this.pricePerMonth;
    }

    public final String getOfferAmount() {
        return this.offerAmount;
    }

    public final boolean getBestValue() {
        return this.bestValue;
    }

    public final String getSaveMessage() {
        return this.saveMessage;
    }
}

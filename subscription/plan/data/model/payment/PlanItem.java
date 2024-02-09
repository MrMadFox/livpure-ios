package com.livpure.safedrink.subscription.plan.data.model.payment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.kizitonwose.time.Interval$$ExternalSyntheticBackport0;
import com.moengage.pushbase.MoEPushConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlanItem.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0013J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010'J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J\t\u00105\u001a\u00020\fHÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\u0086\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00108J\t\u00109\u001a\u00020\bHÖ\u0001J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020\bHÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001J\u0019\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\bHÖ\u0001R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019¨\u0006E"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/payment/PlanItem;", "Landroid/os/Parcelable;", "status", "", "name", "id", "depositAmount", "litresPerMonth", "", "additionalUsagePerLitre", "", "basePrice", "", "emiAmount", "priceMapping", "", "Lcom/livpure/safedrink/subscription/plan/data/model/payment/PriceMappingItem;", "selectedDuration", "selectedDurationPrice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDJJLjava/util/List;Ljava/lang/Integer;Ljava/lang/Long;)V", "getAdditionalUsagePerLitre", "()D", "getBasePrice", "()J", "getDepositAmount", "()Ljava/lang/String;", "getEmiAmount", "getId", "getLitresPerMonth", "()I", "getName", "getPriceMapping", "()Ljava/util/List;", "getSelectedDuration", "()Ljava/lang/Integer;", "setSelectedDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSelectedDurationPrice", "()Ljava/lang/Long;", "setSelectedDurationPrice", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getStatus", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", MoEPushConstants.ACTION_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDJJLjava/util/List;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/livpure/safedrink/subscription/plan/data/model/payment/PlanItem;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PlanItem implements Parcelable {
    public static final Parcelable.Creator<PlanItem> CREATOR = new Creator();
    @SerializedName("rateperliter")
    private final double additionalUsagePerLitre;
    @SerializedName("amount")
    private final long basePrice;
    @SerializedName("depositAmount")
    private final String depositAmount;
    @SerializedName("emiAmount")
    private final long emiAmount;
    @SerializedName("planId")
    private final String id;
    @SerializedName("liters")
    private final int litresPerMonth;
    @SerializedName("planName")
    private final String name;
    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private final List<PriceMappingItem> priceMapping;
    private Integer selectedDuration;
    private Long selectedDurationPrice;
    @SerializedName("status")
    private final String status;

    /* compiled from: PlanItem.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<PlanItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlanItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt = parcel.readInt();
            double readDouble = parcel.readDouble();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i != readInt2; i++) {
                arrayList.add(PriceMappingItem.CREATOR.createFromParcel(parcel));
            }
            return new PlanItem(readString, readString2, readString3, readString4, readInt, readDouble, readLong, readLong2, arrayList, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlanItem[] newArray(int i) {
            return new PlanItem[i];
        }
    }

    public final String component1() {
        return this.status;
    }

    public final Integer component10() {
        return this.selectedDuration;
    }

    public final Long component11() {
        return this.selectedDurationPrice;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.id;
    }

    public final String component4() {
        return this.depositAmount;
    }

    public final int component5() {
        return this.litresPerMonth;
    }

    public final double component6() {
        return this.additionalUsagePerLitre;
    }

    public final long component7() {
        return this.basePrice;
    }

    public final long component8() {
        return this.emiAmount;
    }

    public final List<PriceMappingItem> component9() {
        return this.priceMapping;
    }

    public final PlanItem copy(String status, String name, String id, String depositAmount, int i, double d, long j, long j2, List<PriceMappingItem> priceMapping, Integer num, Long l) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(depositAmount, "depositAmount");
        Intrinsics.checkNotNullParameter(priceMapping, "priceMapping");
        return new PlanItem(status, name, id, depositAmount, i, d, j, j2, priceMapping, num, l);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlanItem) {
            PlanItem planItem = (PlanItem) obj;
            return Intrinsics.areEqual(this.status, planItem.status) && Intrinsics.areEqual(this.name, planItem.name) && Intrinsics.areEqual(this.id, planItem.id) && Intrinsics.areEqual(this.depositAmount, planItem.depositAmount) && this.litresPerMonth == planItem.litresPerMonth && Intrinsics.areEqual((Object) Double.valueOf(this.additionalUsagePerLitre), (Object) Double.valueOf(planItem.additionalUsagePerLitre)) && this.basePrice == planItem.basePrice && this.emiAmount == planItem.emiAmount && Intrinsics.areEqual(this.priceMapping, planItem.priceMapping) && Intrinsics.areEqual(this.selectedDuration, planItem.selectedDuration) && Intrinsics.areEqual(this.selectedDurationPrice, planItem.selectedDurationPrice);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.status.hashCode() * 31) + this.name.hashCode()) * 31) + this.id.hashCode()) * 31) + this.depositAmount.hashCode()) * 31) + this.litresPerMonth) * 31) + Interval$$ExternalSyntheticBackport0.m(this.additionalUsagePerLitre)) * 31) + PlanItem$$ExternalSyntheticBackport0.m(this.basePrice)) * 31) + PlanItem$$ExternalSyntheticBackport0.m(this.emiAmount)) * 31) + this.priceMapping.hashCode()) * 31;
        Integer num = this.selectedDuration;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.selectedDurationPrice;
        return hashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "PlanItem(status=" + this.status + ", name=" + this.name + ", id=" + this.id + ", depositAmount=" + this.depositAmount + ", litresPerMonth=" + this.litresPerMonth + ", additionalUsagePerLitre=" + this.additionalUsagePerLitre + ", basePrice=" + this.basePrice + ", emiAmount=" + this.emiAmount + ", priceMapping=" + this.priceMapping + ", selectedDuration=" + this.selectedDuration + ", selectedDurationPrice=" + this.selectedDurationPrice + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.status);
        out.writeString(this.name);
        out.writeString(this.id);
        out.writeString(this.depositAmount);
        out.writeInt(this.litresPerMonth);
        out.writeDouble(this.additionalUsagePerLitre);
        out.writeLong(this.basePrice);
        out.writeLong(this.emiAmount);
        List<PriceMappingItem> list = this.priceMapping;
        out.writeInt(list.size());
        for (PriceMappingItem priceMappingItem : list) {
            priceMappingItem.writeToParcel(out, i);
        }
        Integer num = this.selectedDuration;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        Long l = this.selectedDurationPrice;
        if (l == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeLong(l.longValue());
    }

    public PlanItem(String status, String name, String id, String depositAmount, int i, double d, long j, long j2, List<PriceMappingItem> priceMapping, Integer num, Long l) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(depositAmount, "depositAmount");
        Intrinsics.checkNotNullParameter(priceMapping, "priceMapping");
        this.status = status;
        this.name = name;
        this.id = id;
        this.depositAmount = depositAmount;
        this.litresPerMonth = i;
        this.additionalUsagePerLitre = d;
        this.basePrice = j;
        this.emiAmount = j2;
        this.priceMapping = priceMapping;
        this.selectedDuration = num;
        this.selectedDurationPrice = l;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getName() {
        return this.name;
    }

    public final String getId() {
        return this.id;
    }

    public final String getDepositAmount() {
        return this.depositAmount;
    }

    public final int getLitresPerMonth() {
        return this.litresPerMonth;
    }

    public final double getAdditionalUsagePerLitre() {
        return this.additionalUsagePerLitre;
    }

    public final long getBasePrice() {
        return this.basePrice;
    }

    public final long getEmiAmount() {
        return this.emiAmount;
    }

    public final List<PriceMappingItem> getPriceMapping() {
        return this.priceMapping;
    }

    public /* synthetic */ PlanItem(String str, String str2, String str3, String str4, int i, double d, long j, long j2, List list, Integer num, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, i, d, j, j2, list, (i2 & 512) != 0 ? 1 : num, (i2 & 1024) != 0 ? Long.valueOf(j) : l);
    }

    public final Integer getSelectedDuration() {
        return this.selectedDuration;
    }

    public final void setSelectedDuration(Integer num) {
        this.selectedDuration = num;
    }

    public final Long getSelectedDurationPrice() {
        return this.selectedDurationPrice;
    }

    public final void setSelectedDurationPrice(Long l) {
        this.selectedDurationPrice = l;
    }
}

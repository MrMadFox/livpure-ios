package com.livpure.safedrink.subscription.plan.data.model.plan;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Currentplans.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010C\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\tHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0093\u0002\u0010G\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020LHÖ\u0001J\t\u0010M\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001cR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001cR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001cR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001c¨\u0006N"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/plan/Currentplans;", "", "familyMemberCount", "", "depositAmount", "referralAmount", "amount", "planType", "productId", "", "liters", "rateperliter", "planName", "discountAmount", "emiAmount", FirebaseAnalytics.Param.PRICE, "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PriceItem;", "billingEndDate", "planId", "id", "validity", "status", "rPlanId", "productType", "active", "pricePerMonth", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActive", "()Ljava/lang/String;", "getAmount", "getBillingEndDate", "getDepositAmount", "getDiscountAmount", "getEmiAmount", "getFamilyMemberCount", "getId", "getLiters", "getPlanId", "getPlanName", "getPlanType", "getPrice", "()Ljava/util/List;", "getPricePerMonth", "getProductId", "getProductType", "getRPlanId", "getRateperliter", "getReferralAmount", "getStatus", "getValidity", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Currentplans {
    @SerializedName("active")
    private final String active;
    @SerializedName("amount")
    private final String amount;
    @SerializedName("billingEndDate")
    private final String billingEndDate;
    @SerializedName("depositAmount")
    private final String depositAmount;
    @SerializedName("discountAmount")
    private final String discountAmount;
    @SerializedName("emiAmount")
    private final String emiAmount;
    @SerializedName("familyMemberCount")
    private final String familyMemberCount;
    @SerializedName("_id")
    private final String id;
    @SerializedName("liters")
    private final String liters;
    @SerializedName("planId")
    private final String planId;
    @SerializedName("planName")
    private final String planName;
    @SerializedName("planType")
    private final String planType;
    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private final List<PriceItem> price;
    @SerializedName("pricePerMonth")
    private final String pricePerMonth;
    @SerializedName("productId")
    private final List<String> productId;
    @SerializedName("productType")
    private final String productType;
    @SerializedName("rPlanId")
    private final String rPlanId;
    @SerializedName("rateperliter")
    private final String rateperliter;
    @SerializedName("referralAmount")
    private final String referralAmount;
    @SerializedName("status")
    private final String status;
    @SerializedName("validity")
    private final String validity;

    public Currentplans() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    public final String component1() {
        return this.familyMemberCount;
    }

    public final String component10() {
        return this.discountAmount;
    }

    public final String component11() {
        return this.emiAmount;
    }

    public final List<PriceItem> component12() {
        return this.price;
    }

    public final String component13() {
        return this.billingEndDate;
    }

    public final String component14() {
        return this.planId;
    }

    public final String component15() {
        return this.id;
    }

    public final String component16() {
        return this.validity;
    }

    public final String component17() {
        return this.status;
    }

    public final String component18() {
        return this.rPlanId;
    }

    public final String component19() {
        return this.productType;
    }

    public final String component2() {
        return this.depositAmount;
    }

    public final String component20() {
        return this.active;
    }

    public final String component21() {
        return this.pricePerMonth;
    }

    public final String component3() {
        return this.referralAmount;
    }

    public final String component4() {
        return this.amount;
    }

    public final String component5() {
        return this.planType;
    }

    public final List<String> component6() {
        return this.productId;
    }

    public final String component7() {
        return this.liters;
    }

    public final String component8() {
        return this.rateperliter;
    }

    public final String component9() {
        return this.planName;
    }

    public final Currentplans copy(String str, String str2, String str3, String str4, String str5, List<String> list, String str6, String str7, String str8, String str9, String str10, List<PriceItem> list2, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19) {
        return new Currentplans(str, str2, str3, str4, str5, list, str6, str7, str8, str9, str10, list2, str11, str12, str13, str14, str15, str16, str17, str18, str19);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Currentplans) {
            Currentplans currentplans = (Currentplans) obj;
            return Intrinsics.areEqual(this.familyMemberCount, currentplans.familyMemberCount) && Intrinsics.areEqual(this.depositAmount, currentplans.depositAmount) && Intrinsics.areEqual(this.referralAmount, currentplans.referralAmount) && Intrinsics.areEqual(this.amount, currentplans.amount) && Intrinsics.areEqual(this.planType, currentplans.planType) && Intrinsics.areEqual(this.productId, currentplans.productId) && Intrinsics.areEqual(this.liters, currentplans.liters) && Intrinsics.areEqual(this.rateperliter, currentplans.rateperliter) && Intrinsics.areEqual(this.planName, currentplans.planName) && Intrinsics.areEqual(this.discountAmount, currentplans.discountAmount) && Intrinsics.areEqual(this.emiAmount, currentplans.emiAmount) && Intrinsics.areEqual(this.price, currentplans.price) && Intrinsics.areEqual(this.billingEndDate, currentplans.billingEndDate) && Intrinsics.areEqual(this.planId, currentplans.planId) && Intrinsics.areEqual(this.id, currentplans.id) && Intrinsics.areEqual(this.validity, currentplans.validity) && Intrinsics.areEqual(this.status, currentplans.status) && Intrinsics.areEqual(this.rPlanId, currentplans.rPlanId) && Intrinsics.areEqual(this.productType, currentplans.productType) && Intrinsics.areEqual(this.active, currentplans.active) && Intrinsics.areEqual(this.pricePerMonth, currentplans.pricePerMonth);
        }
        return false;
    }

    public int hashCode() {
        String str = this.familyMemberCount;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.depositAmount;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.referralAmount;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.amount;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.planType;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<String> list = this.productId;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        String str6 = this.liters;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.rateperliter;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.planName;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.discountAmount;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.emiAmount;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        List<PriceItem> list2 = this.price;
        int hashCode12 = (hashCode11 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str11 = this.billingEndDate;
        int hashCode13 = (hashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.planId;
        int hashCode14 = (hashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.id;
        int hashCode15 = (hashCode14 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.validity;
        int hashCode16 = (hashCode15 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.status;
        int hashCode17 = (hashCode16 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.rPlanId;
        int hashCode18 = (hashCode17 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.productType;
        int hashCode19 = (hashCode18 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.active;
        int hashCode20 = (hashCode19 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.pricePerMonth;
        return hashCode20 + (str19 != null ? str19.hashCode() : 0);
    }

    public String toString() {
        return "Currentplans(familyMemberCount=" + this.familyMemberCount + ", depositAmount=" + this.depositAmount + ", referralAmount=" + this.referralAmount + ", amount=" + this.amount + ", planType=" + this.planType + ", productId=" + this.productId + ", liters=" + this.liters + ", rateperliter=" + this.rateperliter + ", planName=" + this.planName + ", discountAmount=" + this.discountAmount + ", emiAmount=" + this.emiAmount + ", price=" + this.price + ", billingEndDate=" + this.billingEndDate + ", planId=" + this.planId + ", id=" + this.id + ", validity=" + this.validity + ", status=" + this.status + ", rPlanId=" + this.rPlanId + ", productType=" + this.productType + ", active=" + this.active + ", pricePerMonth=" + this.pricePerMonth + ')';
    }

    public Currentplans(String str, String str2, String str3, String str4, String str5, List<String> list, String str6, String str7, String str8, String str9, String str10, List<PriceItem> list2, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19) {
        this.familyMemberCount = str;
        this.depositAmount = str2;
        this.referralAmount = str3;
        this.amount = str4;
        this.planType = str5;
        this.productId = list;
        this.liters = str6;
        this.rateperliter = str7;
        this.planName = str8;
        this.discountAmount = str9;
        this.emiAmount = str10;
        this.price = list2;
        this.billingEndDate = str11;
        this.planId = str12;
        this.id = str13;
        this.validity = str14;
        this.status = str15;
        this.rPlanId = str16;
        this.productType = str17;
        this.active = str18;
        this.pricePerMonth = str19;
    }

    public /* synthetic */ Currentplans(String str, String str2, String str3, String str4, String str5, List list, String str6, String str7, String str8, String str9, String str10, List list2, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : list2, (i & 4096) != 0 ? null : str11, (i & 8192) != 0 ? null : str12, (i & 16384) != 0 ? null : str13, (i & 32768) != 0 ? null : str14, (i & 65536) != 0 ? null : str15, (i & 131072) != 0 ? null : str16, (i & 262144) != 0 ? null : str17, (i & 524288) != 0 ? null : str18, (i & 1048576) != 0 ? null : str19);
    }

    public final String getFamilyMemberCount() {
        return this.familyMemberCount;
    }

    public final String getDepositAmount() {
        return this.depositAmount;
    }

    public final String getReferralAmount() {
        return this.referralAmount;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getPlanType() {
        return this.planType;
    }

    public final List<String> getProductId() {
        return this.productId;
    }

    public final String getLiters() {
        return this.liters;
    }

    public final String getRateperliter() {
        return this.rateperliter;
    }

    public final String getPlanName() {
        return this.planName;
    }

    public final String getDiscountAmount() {
        return this.discountAmount;
    }

    public final String getEmiAmount() {
        return this.emiAmount;
    }

    public final List<PriceItem> getPrice() {
        return this.price;
    }

    public final String getBillingEndDate() {
        return this.billingEndDate;
    }

    public final String getPlanId() {
        return this.planId;
    }

    public final String getId() {
        return this.id;
    }

    public final String getValidity() {
        return this.validity;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getRPlanId() {
        return this.rPlanId;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final String getActive() {
        return this.active;
    }

    public final String getPricePerMonth() {
        return this.pricePerMonth;
    }
}

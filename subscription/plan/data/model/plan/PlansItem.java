package com.livpure.safedrink.subscription.plan.data.model.plan;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import com.moengage.richnotification.internal.RichPushConstantsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlansItem.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\bJ\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bå\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010%J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010P\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eHÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00109J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010T\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000eHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00109J\u0010\u0010a\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0002\u0010BJ\u0010\u0010b\u001a\u0004\u0018\u00010$HÆ\u0003¢\u0006\u0002\u0010GJ\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jî\u0002\u0010j\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$HÆ\u0001¢\u0006\u0002\u0010kJ\t\u0010l\u001a\u00020\"HÖ\u0001J\u0013\u0010m\u001a\u00020\u00112\b\u0010n\u001a\u0004\u0018\u00010oHÖ\u0003J\t\u0010p\u001a\u00020\"HÖ\u0001J\t\u0010q\u001a\u00020\u0003HÖ\u0001J\u0019\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020\"HÖ\u0001R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010'R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010'R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010'R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010'R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010'R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010'R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010'R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010'R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010'R\u001a\u0010 \u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R \u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010*R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010'R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010'R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010'R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010'R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010'R\u001e\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u0010\n\u0002\u0010E\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001e\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u0010\n\u0002\u0010J\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010'R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010:\u001a\u0004\bL\u00109R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010'¨\u0006w"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", "Landroid/os/Parcelable;", "depositAmount", "", "deposit_Amount", "amount", "planType", "pricePerMonth", "liters", "rateperliter", "planName", "description", "discountAmount", "content", "", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/ContentItem;", "unlimitedWater", "", RichPushConstantsKt.PROPERTY_DURATION_KEY, "headingName", FirebaseAnalytics.Param.PRICE, "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PriceItem;", "planId", "id", "validity", "rechargeType", "productType", "status", "familyMemberCount", "emiAmount", "rPlanId", "active", "popular", "selectedDuration", "", "selectedDurationPrice", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;)V", "getActive", "()Ljava/lang/String;", "getAmount", "getContent", "()Ljava/util/List;", "getDepositAmount", "getDeposit_Amount", "getDescription", "getDiscountAmount", "getDuration", "getEmiAmount", "getFamilyMemberCount", "getHeadingName", "getId", "getLiters", "getPlanId", "getPlanName", "getPlanType", "getPopular", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPrice", "getPricePerMonth", "getProductType", "getRPlanId", "getRateperliter", "getRechargeType", "getSelectedDuration", "()Ljava/lang/Integer;", "setSelectedDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSelectedDurationPrice", "()Ljava/lang/Long;", "setSelectedDurationPrice", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getStatus", "getUnlimitedWater", "getValidity", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component3", "component4", "component5", "component6", "component7", "component8", "component9", MoEPushConstants.ACTION_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PlansItem implements Parcelable {
    public static final Parcelable.Creator<PlansItem> CREATOR = new Creator();
    @SerializedName("active")
    private final String active;
    @SerializedName("amount")
    private final String amount;
    @SerializedName("content")
    private final List<ContentItem> content;
    @SerializedName("depositAmount")
    private final String depositAmount;
    @SerializedName("deposit_amount")
    private final String deposit_Amount;
    @SerializedName("description")
    private final String description;
    @SerializedName("discountAmount")
    private final String discountAmount;
    @SerializedName(RichPushConstantsKt.PROPERTY_DURATION_KEY)
    private final String duration;
    @SerializedName("emiAmount")
    private final String emiAmount;
    @SerializedName("familyMemberCount")
    private final String familyMemberCount;
    @SerializedName("headingName")
    private final String headingName;
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
    @SerializedName("popular")
    private final Boolean popular;
    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private final List<PriceItem> price;
    @SerializedName("pricePerMonth")
    private final String pricePerMonth;
    @SerializedName("productType")
    private final String productType;
    @SerializedName("rPlanId")
    private final String rPlanId;
    @SerializedName("rateperliter")
    private final String rateperliter;
    @SerializedName("rechargeType")
    private final String rechargeType;
    private Integer selectedDuration;
    private Long selectedDurationPrice;
    @SerializedName("status")
    private final String status;
    @SerializedName("unlimitedWater")
    private final Boolean unlimitedWater;
    @SerializedName("validity")
    private final String validity;

    /* compiled from: PlansItem.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<PlansItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlansItem createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            int i;
            PriceItem createFromParcel;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i2 = 0; i2 != readInt; i2++) {
                    arrayList.add(parcel.readInt() == 0 ? null : ContentItem.CREATOR.createFromParcel(parcel));
                }
            }
            ArrayList arrayList3 = arrayList;
            Boolean valueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                int i3 = 0;
                while (i3 != readInt2) {
                    if (parcel.readInt() == 0) {
                        i = readInt2;
                        createFromParcel = null;
                    } else {
                        i = readInt2;
                        createFromParcel = PriceItem.CREATOR.createFromParcel(parcel);
                    }
                    arrayList2.add(createFromParcel);
                    i3++;
                    readInt2 = i;
                }
            }
            return new PlansItem(readString, readString2, readString3, readString4, readString5, readString6, readString7, readString8, readString9, readString10, arrayList3, valueOf, readString11, readString12, arrayList2, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlansItem[] newArray(int i) {
            return new PlansItem[i];
        }
    }

    public PlansItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 268435455, null);
    }

    public final String component1() {
        return this.depositAmount;
    }

    public final String component10() {
        return this.discountAmount;
    }

    public final List<ContentItem> component11() {
        return this.content;
    }

    public final Boolean component12() {
        return this.unlimitedWater;
    }

    public final String component13() {
        return this.duration;
    }

    public final String component14() {
        return this.headingName;
    }

    public final List<PriceItem> component15() {
        return this.price;
    }

    public final String component16() {
        return this.planId;
    }

    public final String component17() {
        return this.id;
    }

    public final String component18() {
        return this.validity;
    }

    public final String component19() {
        return this.rechargeType;
    }

    public final String component2() {
        return this.deposit_Amount;
    }

    public final String component20() {
        return this.productType;
    }

    public final String component21() {
        return this.status;
    }

    public final String component22() {
        return this.familyMemberCount;
    }

    public final String component23() {
        return this.emiAmount;
    }

    public final String component24() {
        return this.rPlanId;
    }

    public final String component25() {
        return this.active;
    }

    public final Boolean component26() {
        return this.popular;
    }

    public final Integer component27() {
        return this.selectedDuration;
    }

    public final Long component28() {
        return this.selectedDurationPrice;
    }

    public final String component3() {
        return this.amount;
    }

    public final String component4() {
        return this.planType;
    }

    public final String component5() {
        return this.pricePerMonth;
    }

    public final String component6() {
        return this.liters;
    }

    public final String component7() {
        return this.rateperliter;
    }

    public final String component8() {
        return this.planName;
    }

    public final String component9() {
        return this.description;
    }

    public final PlansItem copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List<ContentItem> list, Boolean bool, String str11, String str12, List<PriceItem> list2, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, Boolean bool2, Integer num, Long l) {
        return new PlansItem(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, list, bool, str11, str12, list2, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, bool2, num, l);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlansItem) {
            PlansItem plansItem = (PlansItem) obj;
            return Intrinsics.areEqual(this.depositAmount, plansItem.depositAmount) && Intrinsics.areEqual(this.deposit_Amount, plansItem.deposit_Amount) && Intrinsics.areEqual(this.amount, plansItem.amount) && Intrinsics.areEqual(this.planType, plansItem.planType) && Intrinsics.areEqual(this.pricePerMonth, plansItem.pricePerMonth) && Intrinsics.areEqual(this.liters, plansItem.liters) && Intrinsics.areEqual(this.rateperliter, plansItem.rateperliter) && Intrinsics.areEqual(this.planName, plansItem.planName) && Intrinsics.areEqual(this.description, plansItem.description) && Intrinsics.areEqual(this.discountAmount, plansItem.discountAmount) && Intrinsics.areEqual(this.content, plansItem.content) && Intrinsics.areEqual(this.unlimitedWater, plansItem.unlimitedWater) && Intrinsics.areEqual(this.duration, plansItem.duration) && Intrinsics.areEqual(this.headingName, plansItem.headingName) && Intrinsics.areEqual(this.price, plansItem.price) && Intrinsics.areEqual(this.planId, plansItem.planId) && Intrinsics.areEqual(this.id, plansItem.id) && Intrinsics.areEqual(this.validity, plansItem.validity) && Intrinsics.areEqual(this.rechargeType, plansItem.rechargeType) && Intrinsics.areEqual(this.productType, plansItem.productType) && Intrinsics.areEqual(this.status, plansItem.status) && Intrinsics.areEqual(this.familyMemberCount, plansItem.familyMemberCount) && Intrinsics.areEqual(this.emiAmount, plansItem.emiAmount) && Intrinsics.areEqual(this.rPlanId, plansItem.rPlanId) && Intrinsics.areEqual(this.active, plansItem.active) && Intrinsics.areEqual(this.popular, plansItem.popular) && Intrinsics.areEqual(this.selectedDuration, plansItem.selectedDuration) && Intrinsics.areEqual(this.selectedDurationPrice, plansItem.selectedDurationPrice);
        }
        return false;
    }

    public int hashCode() {
        String str = this.depositAmount;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deposit_Amount;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.amount;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.planType;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.pricePerMonth;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.liters;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.rateperliter;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.planName;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.description;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.discountAmount;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        List<ContentItem> list = this.content;
        int hashCode11 = (hashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.unlimitedWater;
        int hashCode12 = (hashCode11 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str11 = this.duration;
        int hashCode13 = (hashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.headingName;
        int hashCode14 = (hashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        List<PriceItem> list2 = this.price;
        int hashCode15 = (hashCode14 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str13 = this.planId;
        int hashCode16 = (hashCode15 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.id;
        int hashCode17 = (hashCode16 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.validity;
        int hashCode18 = (hashCode17 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.rechargeType;
        int hashCode19 = (hashCode18 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.productType;
        int hashCode20 = (hashCode19 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.status;
        int hashCode21 = (hashCode20 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.familyMemberCount;
        int hashCode22 = (hashCode21 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.emiAmount;
        int hashCode23 = (hashCode22 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.rPlanId;
        int hashCode24 = (hashCode23 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.active;
        int hashCode25 = (hashCode24 + (str22 == null ? 0 : str22.hashCode())) * 31;
        Boolean bool2 = this.popular;
        int hashCode26 = (hashCode25 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.selectedDuration;
        int hashCode27 = (hashCode26 + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.selectedDurationPrice;
        return hashCode27 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "PlansItem(depositAmount=" + this.depositAmount + ", deposit_Amount=" + this.deposit_Amount + ", amount=" + this.amount + ", planType=" + this.planType + ", pricePerMonth=" + this.pricePerMonth + ", liters=" + this.liters + ", rateperliter=" + this.rateperliter + ", planName=" + this.planName + ", description=" + this.description + ", discountAmount=" + this.discountAmount + ", content=" + this.content + ", unlimitedWater=" + this.unlimitedWater + ", duration=" + this.duration + ", headingName=" + this.headingName + ", price=" + this.price + ", planId=" + this.planId + ", id=" + this.id + ", validity=" + this.validity + ", rechargeType=" + this.rechargeType + ", productType=" + this.productType + ", status=" + this.status + ", familyMemberCount=" + this.familyMemberCount + ", emiAmount=" + this.emiAmount + ", rPlanId=" + this.rPlanId + ", active=" + this.active + ", popular=" + this.popular + ", selectedDuration=" + this.selectedDuration + ", selectedDurationPrice=" + this.selectedDurationPrice + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.depositAmount);
        out.writeString(this.deposit_Amount);
        out.writeString(this.amount);
        out.writeString(this.planType);
        out.writeString(this.pricePerMonth);
        out.writeString(this.liters);
        out.writeString(this.rateperliter);
        out.writeString(this.planName);
        out.writeString(this.description);
        out.writeString(this.discountAmount);
        List<ContentItem> list = this.content;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            for (ContentItem contentItem : list) {
                if (contentItem == null) {
                    out.writeInt(0);
                } else {
                    out.writeInt(1);
                    contentItem.writeToParcel(out, i);
                }
            }
        }
        Boolean bool = this.unlimitedWater;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
        out.writeString(this.duration);
        out.writeString(this.headingName);
        List<PriceItem> list2 = this.price;
        if (list2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list2.size());
            for (PriceItem priceItem : list2) {
                if (priceItem == null) {
                    out.writeInt(0);
                } else {
                    out.writeInt(1);
                    priceItem.writeToParcel(out, i);
                }
            }
        }
        out.writeString(this.planId);
        out.writeString(this.id);
        out.writeString(this.validity);
        out.writeString(this.rechargeType);
        out.writeString(this.productType);
        out.writeString(this.status);
        out.writeString(this.familyMemberCount);
        out.writeString(this.emiAmount);
        out.writeString(this.rPlanId);
        out.writeString(this.active);
        Boolean bool2 = this.popular;
        if (bool2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool2.booleanValue() ? 1 : 0);
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

    public PlansItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List<ContentItem> list, Boolean bool, String str11, String str12, List<PriceItem> list2, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, Boolean bool2, Integer num, Long l) {
        this.depositAmount = str;
        this.deposit_Amount = str2;
        this.amount = str3;
        this.planType = str4;
        this.pricePerMonth = str5;
        this.liters = str6;
        this.rateperliter = str7;
        this.planName = str8;
        this.description = str9;
        this.discountAmount = str10;
        this.content = list;
        this.unlimitedWater = bool;
        this.duration = str11;
        this.headingName = str12;
        this.price = list2;
        this.planId = str13;
        this.id = str14;
        this.validity = str15;
        this.rechargeType = str16;
        this.productType = str17;
        this.status = str18;
        this.familyMemberCount = str19;
        this.emiAmount = str20;
        this.rPlanId = str21;
        this.active = str22;
        this.popular = bool2;
        this.selectedDuration = num;
        this.selectedDurationPrice = l;
    }

    public final String getDepositAmount() {
        return this.depositAmount;
    }

    public final String getDeposit_Amount() {
        return this.deposit_Amount;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getPlanType() {
        return this.planType;
    }

    public final String getPricePerMonth() {
        return this.pricePerMonth;
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

    public final String getDescription() {
        return this.description;
    }

    public final String getDiscountAmount() {
        return this.discountAmount;
    }

    public final List<ContentItem> getContent() {
        return this.content;
    }

    public final Boolean getUnlimitedWater() {
        return this.unlimitedWater;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getHeadingName() {
        return this.headingName;
    }

    public final List<PriceItem> getPrice() {
        return this.price;
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

    public final String getRechargeType() {
        return this.rechargeType;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getFamilyMemberCount() {
        return this.familyMemberCount;
    }

    public final String getEmiAmount() {
        return this.emiAmount;
    }

    public final String getRPlanId() {
        return this.rPlanId;
    }

    public final String getActive() {
        return this.active;
    }

    public final Boolean getPopular() {
        return this.popular;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ PlansItem(java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.util.List r41, java.lang.Boolean r42, java.lang.String r43, java.lang.String r44, java.util.List r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.lang.String r55, java.lang.Boolean r56, java.lang.Integer r57, java.lang.Long r58, int r59, kotlin.jvm.internal.DefaultConstructorMarker r60) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.Boolean, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Integer, java.lang.Long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

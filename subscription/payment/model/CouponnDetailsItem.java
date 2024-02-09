package com.livpure.safedrink.subscription.payment.model;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ValidateCouponModel.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b:\b\u0086\b\u0018\u00002\u00020\u0001BÏ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u0005¢\u0006\u0002\u0010 J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0014HÆ\u0003J\t\u0010B\u001a\u00020\u0014HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000bHÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000bHÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\u000f\u0010P\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\u0081\u0002\u0010S\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u00052\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010T\u001a\u00020\u00032\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020\u0014HÖ\u0001J\t\u0010W\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0016\u0010\u0015\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0016\u0010\u0019\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0016\u0010\u0018\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u0016\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010'R\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u0016\u0010\u001c\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0016\u0010\u0017\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\"R\u0016\u0010\u001f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\"R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\"R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\"¨\u0006X"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/model/CouponnDetailsItem;", "", "timeConstraints", "", "amount", "", "createdFor", "code", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "endDate", "city", "", "Lcom/livpure/safedrink/subscription/payment/model/CityItem;", "incLimit", "applicable", "description", "shortDescription", "message", AnalyticsAttribute.USER_ID_ATTRIBUTE, "retentionType", "", "cartAmount", "maxLimit", "startTime", "id", "endTime", "couponPlan", "Lcom/livpure/safedrink/subscription/payment/model/CouponPlanItem;", "startDate", "productType", "Lcom/livpure/safedrink/subscription/payment/model/ProductTypeItem;", "status", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getApplicable", "getCartAmount", "()I", "getCity", "()Ljava/util/List;", "getCode", "getCouponPlan", "getCreatedFor", "getDescription", "getEndDate", "getEndTime", "getId", "getIncLimit", "getMaxLimit", "getMessage", "getProductType", "getRetentionType", "getShortDescription", "getStartDate", "getStartTime", "getStatus", "getTimeConstraints", "()Z", "getUserId", "getVisibility", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", MoEPushConstants.ACTION_COPY, "equals", "other", "hashCode", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CouponnDetailsItem {
    @SerializedName("amount")
    private final String amount;
    @SerializedName("applicable")
    private final String applicable;
    @SerializedName("cartAmount")
    private final int cartAmount;
    @SerializedName("city")
    private final List<CityItem> city;
    @SerializedName("code")
    private final String code;
    @SerializedName("couponPlan")
    private final List<CouponPlanItem> couponPlan;
    @SerializedName("createdFor")
    private final String createdFor;
    @SerializedName("description")
    private final String description;
    @SerializedName("endDate")
    private final String endDate;
    @SerializedName("endTime")
    private final String endTime;
    @SerializedName("_id")
    private final String id;
    @SerializedName("incLimit")
    private final String incLimit;
    @SerializedName("maxLimit")
    private final String maxLimit;
    @SerializedName("message")
    private final String message;
    @SerializedName("productType")
    private final List<ProductTypeItem> productType;
    @SerializedName("retentionType")
    private final int retentionType;
    @SerializedName("shortDescription")
    private final String shortDescription;
    @SerializedName("startDate")
    private final String startDate;
    @SerializedName("startTime")
    private final String startTime;
    @SerializedName("status")
    private final String status;
    @SerializedName("timeConstraints")
    private final boolean timeConstraints;
    @SerializedName(AnalyticsAttribute.USER_ID_ATTRIBUTE)
    private final String userId;
    @SerializedName(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY)
    private final String visibility;

    public final boolean component1() {
        return this.timeConstraints;
    }

    public final String component10() {
        return this.description;
    }

    public final String component11() {
        return this.shortDescription;
    }

    public final String component12() {
        return this.message;
    }

    public final String component13() {
        return this.userId;
    }

    public final int component14() {
        return this.retentionType;
    }

    public final int component15() {
        return this.cartAmount;
    }

    public final String component16() {
        return this.maxLimit;
    }

    public final String component17() {
        return this.startTime;
    }

    public final String component18() {
        return this.id;
    }

    public final String component19() {
        return this.endTime;
    }

    public final String component2() {
        return this.amount;
    }

    public final List<CouponPlanItem> component20() {
        return this.couponPlan;
    }

    public final String component21() {
        return this.startDate;
    }

    public final List<ProductTypeItem> component22() {
        return this.productType;
    }

    public final String component23() {
        return this.status;
    }

    public final String component3() {
        return this.createdFor;
    }

    public final String component4() {
        return this.code;
    }

    public final String component5() {
        return this.visibility;
    }

    public final String component6() {
        return this.endDate;
    }

    public final List<CityItem> component7() {
        return this.city;
    }

    public final String component8() {
        return this.incLimit;
    }

    public final String component9() {
        return this.applicable;
    }

    public final CouponnDetailsItem copy(boolean z, String amount, String createdFor, String code, String visibility, String endDate, List<CityItem> city, String incLimit, String applicable, String description, String shortDescription, String message, String userId, int i, int i2, String maxLimit, String startTime, String id, String endTime, List<CouponPlanItem> couponPlan, String startDate, List<ProductTypeItem> productType, String status) {
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(createdFor, "createdFor");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(incLimit, "incLimit");
        Intrinsics.checkNotNullParameter(applicable, "applicable");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(shortDescription, "shortDescription");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(maxLimit, "maxLimit");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(couponPlan, "couponPlan");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(status, "status");
        return new CouponnDetailsItem(z, amount, createdFor, code, visibility, endDate, city, incLimit, applicable, description, shortDescription, message, userId, i, i2, maxLimit, startTime, id, endTime, couponPlan, startDate, productType, status);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CouponnDetailsItem) {
            CouponnDetailsItem couponnDetailsItem = (CouponnDetailsItem) obj;
            return this.timeConstraints == couponnDetailsItem.timeConstraints && Intrinsics.areEqual(this.amount, couponnDetailsItem.amount) && Intrinsics.areEqual(this.createdFor, couponnDetailsItem.createdFor) && Intrinsics.areEqual(this.code, couponnDetailsItem.code) && Intrinsics.areEqual(this.visibility, couponnDetailsItem.visibility) && Intrinsics.areEqual(this.endDate, couponnDetailsItem.endDate) && Intrinsics.areEqual(this.city, couponnDetailsItem.city) && Intrinsics.areEqual(this.incLimit, couponnDetailsItem.incLimit) && Intrinsics.areEqual(this.applicable, couponnDetailsItem.applicable) && Intrinsics.areEqual(this.description, couponnDetailsItem.description) && Intrinsics.areEqual(this.shortDescription, couponnDetailsItem.shortDescription) && Intrinsics.areEqual(this.message, couponnDetailsItem.message) && Intrinsics.areEqual(this.userId, couponnDetailsItem.userId) && this.retentionType == couponnDetailsItem.retentionType && this.cartAmount == couponnDetailsItem.cartAmount && Intrinsics.areEqual(this.maxLimit, couponnDetailsItem.maxLimit) && Intrinsics.areEqual(this.startTime, couponnDetailsItem.startTime) && Intrinsics.areEqual(this.id, couponnDetailsItem.id) && Intrinsics.areEqual(this.endTime, couponnDetailsItem.endTime) && Intrinsics.areEqual(this.couponPlan, couponnDetailsItem.couponPlan) && Intrinsics.areEqual(this.startDate, couponnDetailsItem.startDate) && Intrinsics.areEqual(this.productType, couponnDetailsItem.productType) && Intrinsics.areEqual(this.status, couponnDetailsItem.status);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v47 */
    public int hashCode() {
        boolean z = this.timeConstraints;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((((((((((((((((((((((((((((((((((((r0 * 31) + this.amount.hashCode()) * 31) + this.createdFor.hashCode()) * 31) + this.code.hashCode()) * 31) + this.visibility.hashCode()) * 31) + this.endDate.hashCode()) * 31) + this.city.hashCode()) * 31) + this.incLimit.hashCode()) * 31) + this.applicable.hashCode()) * 31) + this.description.hashCode()) * 31) + this.shortDescription.hashCode()) * 31) + this.message.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.retentionType) * 31) + this.cartAmount) * 31) + this.maxLimit.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.id.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.couponPlan.hashCode()) * 31) + this.startDate.hashCode()) * 31) + this.productType.hashCode()) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "CouponnDetailsItem(timeConstraints=" + this.timeConstraints + ", amount=" + this.amount + ", createdFor=" + this.createdFor + ", code=" + this.code + ", visibility=" + this.visibility + ", endDate=" + this.endDate + ", city=" + this.city + ", incLimit=" + this.incLimit + ", applicable=" + this.applicable + ", description=" + this.description + ", shortDescription=" + this.shortDescription + ", message=" + this.message + ", userId=" + this.userId + ", retentionType=" + this.retentionType + ", cartAmount=" + this.cartAmount + ", maxLimit=" + this.maxLimit + ", startTime=" + this.startTime + ", id=" + this.id + ", endTime=" + this.endTime + ", couponPlan=" + this.couponPlan + ", startDate=" + this.startDate + ", productType=" + this.productType + ", status=" + this.status + ')';
    }

    public CouponnDetailsItem(boolean z, String amount, String createdFor, String code, String visibility, String endDate, List<CityItem> city, String incLimit, String applicable, String description, String shortDescription, String message, String userId, int i, int i2, String maxLimit, String startTime, String id, String endTime, List<CouponPlanItem> couponPlan, String startDate, List<ProductTypeItem> productType, String status) {
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(createdFor, "createdFor");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(incLimit, "incLimit");
        Intrinsics.checkNotNullParameter(applicable, "applicable");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(shortDescription, "shortDescription");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(maxLimit, "maxLimit");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(couponPlan, "couponPlan");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(status, "status");
        this.timeConstraints = z;
        this.amount = amount;
        this.createdFor = createdFor;
        this.code = code;
        this.visibility = visibility;
        this.endDate = endDate;
        this.city = city;
        this.incLimit = incLimit;
        this.applicable = applicable;
        this.description = description;
        this.shortDescription = shortDescription;
        this.message = message;
        this.userId = userId;
        this.retentionType = i;
        this.cartAmount = i2;
        this.maxLimit = maxLimit;
        this.startTime = startTime;
        this.id = id;
        this.endTime = endTime;
        this.couponPlan = couponPlan;
        this.startDate = startDate;
        this.productType = productType;
        this.status = status;
    }

    public final boolean getTimeConstraints() {
        return this.timeConstraints;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getCreatedFor() {
        return this.createdFor;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getVisibility() {
        return this.visibility;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final List<CityItem> getCity() {
        return this.city;
    }

    public final String getIncLimit() {
        return this.incLimit;
    }

    public final String getApplicable() {
        return this.applicable;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getShortDescription() {
        return this.shortDescription;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final int getRetentionType() {
        return this.retentionType;
    }

    public final int getCartAmount() {
        return this.cartAmount;
    }

    public final String getMaxLimit() {
        return this.maxLimit;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getId() {
        return this.id;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final List<CouponPlanItem> getCouponPlan() {
        return this.couponPlan;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final List<ProductTypeItem> getProductType() {
        return this.productType;
    }

    public final String getStatus() {
        return this.status;
    }
}

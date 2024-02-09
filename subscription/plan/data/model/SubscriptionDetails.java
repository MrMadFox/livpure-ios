package com.livpure.safedrink.subscription.plan.data.model;

import com.google.gson.annotations.SerializedName;
import com.moengage.enum_models.Operator;
import com.moengage.pushbase.MoEPushConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SubscriptionDetails.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0002\u0010\u0010J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\u0093\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001J\u0013\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u00100\u001a\u00020\u0003J\u0006\u00101\u001a\u00020\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017¨\u00065"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/SubscriptionDetails;", "", "validTillDate", "", "validFromTo", "planName", "planRate", "balance", "isTopUpAllowed", "", "currentDate", "planAmount", "_AllowTopup", "emiPaid", "emiValidityTill", "EMIvalidityExpired", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Z)V", "getEMIvalidityExpired", "()Z", "get_AllowTopup", "set_AllowTopup", "(Z)V", "getCurrentDate", "()Ljava/lang/String;", "getEmiPaid", "getEmiValidityTill", "getPlanAmount", "setPlanAmount", "(Ljava/lang/String;)V", "getPlanName", "getPlanRate", "getValidFromTo", "getValidTillDate", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", MoEPushConstants.ACTION_COPY, "equals", "other", "getCancellationEndDateString", "getNormalizedBalanceString", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SubscriptionDetails {
    private final boolean EMIvalidityExpired;
    private boolean _AllowTopup;
    @SerializedName("Balance")
    private final String balance;
    @SerializedName(Operator.TODAY)
    private final String currentDate;
    private final String emiPaid;
    private final String emiValidityTill;
    private final boolean isTopUpAllowed;
    private String planAmount;
    @SerializedName("plan")
    private final String planName;
    @SerializedName("Rate")
    private final String planRate;
    @SerializedName("Period1")
    private final String validFromTo;
    @SerializedName("validityTill")
    private final String validTillDate;

    private final String component5() {
        return this.balance;
    }

    public final String component1() {
        return this.validTillDate;
    }

    public final String component10() {
        return this.emiPaid;
    }

    public final String component11() {
        return this.emiValidityTill;
    }

    public final boolean component12() {
        return this.EMIvalidityExpired;
    }

    public final String component2() {
        return this.validFromTo;
    }

    public final String component3() {
        return this.planName;
    }

    public final String component4() {
        return this.planRate;
    }

    public final boolean component6() {
        return this.isTopUpAllowed;
    }

    public final String component7() {
        return this.currentDate;
    }

    public final String component8() {
        return this.planAmount;
    }

    public final boolean component9() {
        return this._AllowTopup;
    }

    public final SubscriptionDetails copy(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, boolean z2, String str8, String str9, boolean z3) {
        return new SubscriptionDetails(str, str2, str3, str4, str5, z, str6, str7, z2, str8, str9, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SubscriptionDetails) {
            SubscriptionDetails subscriptionDetails = (SubscriptionDetails) obj;
            return Intrinsics.areEqual(this.validTillDate, subscriptionDetails.validTillDate) && Intrinsics.areEqual(this.validFromTo, subscriptionDetails.validFromTo) && Intrinsics.areEqual(this.planName, subscriptionDetails.planName) && Intrinsics.areEqual(this.planRate, subscriptionDetails.planRate) && Intrinsics.areEqual(this.balance, subscriptionDetails.balance) && this.isTopUpAllowed == subscriptionDetails.isTopUpAllowed && Intrinsics.areEqual(this.currentDate, subscriptionDetails.currentDate) && Intrinsics.areEqual(this.planAmount, subscriptionDetails.planAmount) && this._AllowTopup == subscriptionDetails._AllowTopup && Intrinsics.areEqual(this.emiPaid, subscriptionDetails.emiPaid) && Intrinsics.areEqual(this.emiValidityTill, subscriptionDetails.emiValidityTill) && this.EMIvalidityExpired == subscriptionDetails.EMIvalidityExpired;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.validTillDate;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.validFromTo;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.planName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.planRate;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.balance;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        boolean z = this.isTopUpAllowed;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode5 + i) * 31;
        String str6 = this.currentDate;
        int hashCode6 = (i2 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.planAmount;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        boolean z2 = this._AllowTopup;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (hashCode7 + i3) * 31;
        String str8 = this.emiPaid;
        int hashCode8 = (i4 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.emiValidityTill;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        boolean z3 = this.EMIvalidityExpired;
        return hashCode9 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        return "SubscriptionDetails(validTillDate=" + this.validTillDate + ", validFromTo=" + this.validFromTo + ", planName=" + this.planName + ", planRate=" + this.planRate + ", balance=" + this.balance + ", isTopUpAllowed=" + this.isTopUpAllowed + ", currentDate=" + this.currentDate + ", planAmount=" + this.planAmount + ", _AllowTopup=" + this._AllowTopup + ", emiPaid=" + this.emiPaid + ", emiValidityTill=" + this.emiValidityTill + ", EMIvalidityExpired=" + this.EMIvalidityExpired + ')';
    }

    public SubscriptionDetails(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, boolean z2, String str8, String str9, boolean z3) {
        this.validTillDate = str;
        this.validFromTo = str2;
        this.planName = str3;
        this.planRate = str4;
        this.balance = str5;
        this.isTopUpAllowed = z;
        this.currentDate = str6;
        this.planAmount = str7;
        this._AllowTopup = z2;
        this.emiPaid = str8;
        this.emiValidityTill = str9;
        this.EMIvalidityExpired = z3;
    }

    public final String getValidTillDate() {
        return this.validTillDate;
    }

    public final String getValidFromTo() {
        return this.validFromTo;
    }

    public final String getPlanName() {
        return this.planName;
    }

    public final String getPlanRate() {
        return this.planRate;
    }

    public final boolean isTopUpAllowed() {
        return this.isTopUpAllowed;
    }

    public final String getCurrentDate() {
        return this.currentDate;
    }

    public final String getPlanAmount() {
        return this.planAmount;
    }

    public final void setPlanAmount(String str) {
        this.planAmount = str;
    }

    public final boolean get_AllowTopup() {
        return this._AllowTopup;
    }

    public final void set_AllowTopup(boolean z) {
        this._AllowTopup = z;
    }

    public final String getEmiPaid() {
        return this.emiPaid;
    }

    public final String getEmiValidityTill() {
        return this.emiValidityTill;
    }

    public final boolean getEMIvalidityExpired() {
        return this.EMIvalidityExpired;
    }

    public final String getCancellationEndDateString() {
        String str;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            if (this.validTillDate != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(simpleDateFormat.parse(this.validTillDate));
                calendar.add(5, 14);
                str = simpleDateFormat.format(new Date(calendar.getTimeInMillis()));
            } else {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "{\n            if(validTi…\"\n            }\n        }");
            return str;
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004f A[Catch: ParseException -> 0x00a3, TryCatch #0 {ParseException -> 0x00a3, blocks: (B:3:0x000b, B:5:0x000f, B:7:0x0013, B:9:0x0024, B:11:0x0028, B:12:0x002c, B:15:0x0039, B:17:0x003d, B:25:0x004f, B:26:0x0051, B:28:0x0055, B:29:0x0059, B:30:0x006e, B:32:0x0072, B:40:0x0084, B:41:0x0086, B:43:0x008a, B:44:0x008e), top: B:49:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0055 A[Catch: ParseException -> 0x00a3, TryCatch #0 {ParseException -> 0x00a3, blocks: (B:3:0x000b, B:5:0x000f, B:7:0x0013, B:9:0x0024, B:11:0x0028, B:12:0x002c, B:15:0x0039, B:17:0x003d, B:25:0x004f, B:26:0x0051, B:28:0x0055, B:29:0x0059, B:30:0x006e, B:32:0x0072, B:40:0x0084, B:41:0x0086, B:43:0x008a, B:44:0x008e), top: B:49:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0084 A[Catch: ParseException -> 0x00a3, TryCatch #0 {ParseException -> 0x00a3, blocks: (B:3:0x000b, B:5:0x000f, B:7:0x0013, B:9:0x0024, B:11:0x0028, B:12:0x002c, B:15:0x0039, B:17:0x003d, B:25:0x004f, B:26:0x0051, B:28:0x0055, B:29:0x0059, B:30:0x006e, B:32:0x0072, B:40:0x0084, B:41:0x0086, B:43:0x008a, B:44:0x008e), top: B:49:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008a A[Catch: ParseException -> 0x00a3, TryCatch #0 {ParseException -> 0x00a3, blocks: (B:3:0x000b, B:5:0x000f, B:7:0x0013, B:9:0x0024, B:11:0x0028, B:12:0x002c, B:15:0x0039, B:17:0x003d, B:25:0x004f, B:26:0x0051, B:28:0x0055, B:29:0x0059, B:30:0x006e, B:32:0x0072, B:40:0x0084, B:41:0x0086, B:43:0x008a, B:44:0x008e), top: B:49:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String getNormalizedBalanceString() {
        /*
            r7 = this;
            java.lang.String r0 = "Balance : Rs 0"
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r3 = "dd/MM/yyyy"
            r1.<init>(r3, r2)
            java.lang.String r2 = r7.validTillDate     // Catch: java.text.ParseException -> La3
            if (r2 == 0) goto L22
            java.lang.String r3 = r7.currentDate     // Catch: java.text.ParseException -> La3
            if (r3 == 0) goto L22
            java.util.Date r2 = r1.parse(r2)     // Catch: java.text.ParseException -> La3
            java.lang.String r3 = r7.currentDate     // Catch: java.text.ParseException -> La3
            java.util.Date r1 = r1.parse(r3)     // Catch: java.text.ParseException -> La3
            long r1 = com.livpure.safedrink.utils.AppUtils.getDifference(r1, r2)     // Catch: java.text.ParseException -> La3
            goto L24
        L22:
            r1 = 0
        L24:
            int r2 = (int) r1     // Catch: java.text.ParseException -> La3
            r1 = 1
            if (r2 < 0) goto L2c
            r7._AllowTopup = r1     // Catch: java.text.ParseException -> La3
            goto La7
        L2c:
            r3 = 0
            r7._AllowTopup = r3     // Catch: java.text.ParseException -> La3
            int r4 = r2 / 30
            int r2 = r2 % 30
            java.lang.String r5 = "Balance : Rs -"
            java.lang.String r6 = "0"
            if (r2 != 0) goto L6e
            java.lang.String r2 = r7.planAmount     // Catch: java.text.ParseException -> La3
            if (r2 == 0) goto L4c
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.text.ParseException -> La3
            int r2 = r2.length()     // Catch: java.text.ParseException -> La3
            if (r2 != 0) goto L47
            r2 = 1
            goto L48
        L47:
            r2 = 0
        L48:
            if (r2 != r1) goto L4c
            r2 = 1
            goto L4d
        L4c:
            r2 = 0
        L4d:
            if (r2 == 0) goto L51
            r7.planAmount = r6     // Catch: java.text.ParseException -> La3
        L51:
            java.lang.String r2 = r7.planAmount     // Catch: java.text.ParseException -> La3
            if (r2 == 0) goto L59
            int r3 = java.lang.Integer.parseInt(r2)     // Catch: java.text.ParseException -> La3
        L59:
            int r4 = r4 * (-1)
            int r4 = r4 + r1
            int r3 = r3 * r4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.text.ParseException -> La3
            r1.<init>()     // Catch: java.text.ParseException -> La3
            r1.append(r5)     // Catch: java.text.ParseException -> La3
            r1.append(r3)     // Catch: java.text.ParseException -> La3
            java.lang.String r0 = r1.toString()     // Catch: java.text.ParseException -> La3
            goto La7
        L6e:
            java.lang.String r2 = r7.planAmount     // Catch: java.text.ParseException -> La3
            if (r2 == 0) goto L81
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.text.ParseException -> La3
            int r2 = r2.length()     // Catch: java.text.ParseException -> La3
            if (r2 != 0) goto L7c
            r2 = 1
            goto L7d
        L7c:
            r2 = 0
        L7d:
            if (r2 != r1) goto L81
            r2 = 1
            goto L82
        L81:
            r2 = 0
        L82:
            if (r2 == 0) goto L86
            r7.planAmount = r6     // Catch: java.text.ParseException -> La3
        L86:
            java.lang.String r2 = r7.planAmount     // Catch: java.text.ParseException -> La3
            if (r2 == 0) goto L8e
            int r3 = java.lang.Integer.parseInt(r2)     // Catch: java.text.ParseException -> La3
        L8e:
            int r4 = r4 * (-1)
            int r4 = r4 + r1
            int r3 = r3 * r4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.text.ParseException -> La3
            r1.<init>()     // Catch: java.text.ParseException -> La3
            r1.append(r5)     // Catch: java.text.ParseException -> La3
            r1.append(r3)     // Catch: java.text.ParseException -> La3
            java.lang.String r0 = r1.toString()     // Catch: java.text.ParseException -> La3
            goto La7
        La3:
            r1 = move-exception
            r1.printStackTrace()
        La7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.subscription.plan.data.model.SubscriptionDetails.getNormalizedBalanceString():java.lang.String");
    }
}

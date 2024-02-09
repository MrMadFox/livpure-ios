package com.livpure.safedrink.login.data.models;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: User.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\\\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bÿ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00109J\u0010\u0010]\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010b\u001a\u00020\nHÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010j\u001a\u00020\nHÆ\u0003J\t\u0010k\u001a\u00020\nHÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¤\u0002\u0010m\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0019\u001a\u00020\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010nJ\u0013\u0010o\u001a\u00020\n2\b\u0010p\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010q\u001a\u00020rHÖ\u0001J\t\u0010s\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001a\u0010\u0019\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001f\"\u0004\b2\u0010!R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001f\"\u0004\b4\u0010!R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001f\"\u0004\b8\u0010!R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010:\u001a\u0004\b\u0013\u00109R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010,\"\u0004\b<\u0010.R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001f\"\u0004\b>\u0010!R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001f\"\u0004\b@\u0010!R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010,\"\u0004\bB\u0010.R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001f\"\u0004\bD\u0010!R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001f\"\u0004\bF\u0010!R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001f\"\u0004\bH\u0010!R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u001f\"\u0004\bJ\u0010!R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u001f\"\u0004\bL\u0010!R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001f\"\u0004\bN\u0010!R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u001f\"\u0004\bP\u0010!R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u001f\"\u0004\bR\u0010!R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u001f\"\u0004\bT\u0010!¨\u0006t"}, d2 = {"Lcom/livpure/safedrink/login/data/models/User;", "", "name", "", "mobile", "email", "id", "token", "planId", "kycCompleted", "", "paymentCompleted", "referralCode", "address", "city", "area", "state", "hubCode", "pinCode", "isLoggedIn", "applicableDiscount", "", "alternatePhoneNumber", "planName", "planValidTillDate", "cancelService", "cancellationRequestedDate", "relocation_status", "refShortLink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getAlternatePhoneNumber", "setAlternatePhoneNumber", "getApplicableDiscount", "()Ljava/lang/Long;", "setApplicableDiscount", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getArea", "setArea", "getCancelService", "()Z", "setCancelService", "(Z)V", "getCancellationRequestedDate", "setCancellationRequestedDate", "getCity", "setCity", "getEmail", "setEmail", "getHubCode", "setHubCode", "getId", "setId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getKycCompleted", "setKycCompleted", "getMobile", "setMobile", "getName", "setName", "getPaymentCompleted", "setPaymentCompleted", "getPinCode", "setPinCode", "getPlanId", "setPlanId", "getPlanName", "setPlanName", "getPlanValidTillDate", "setPlanValidTillDate", "getRefShortLink", "setRefShortLink", "getReferralCode", "setReferralCode", "getRelocation_status", "setRelocation_status", "getState", "setState", "getToken", "setToken", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", MoEPushConstants.ACTION_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/livpure/safedrink/login/data/models/User;", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class User {
    private String address;
    private String alternatePhoneNumber;
    private Long applicableDiscount;
    private String area;
    private boolean cancelService;
    private String cancellationRequestedDate;
    private String city;
    private String email;
    private String hubCode;
    @SerializedName(AnalyticsAttribute.USER_ID_ATTRIBUTE)
    private String id;
    private final Boolean isLoggedIn;
    private boolean kycCompleted;
    private String mobile;
    private String name;
    private boolean paymentCompleted;
    @SerializedName("pincode")
    private String pinCode;
    private String planId;
    private String planName;
    private String planValidTillDate;
    private String refShortLink;
    private String referralCode;
    private String relocation_status;
    private String state;
    private String token;

    public final String component1() {
        return this.name;
    }

    public final String component10() {
        return this.address;
    }

    public final String component11() {
        return this.city;
    }

    public final String component12() {
        return this.area;
    }

    public final String component13() {
        return this.state;
    }

    public final String component14() {
        return this.hubCode;
    }

    public final String component15() {
        return this.pinCode;
    }

    public final Boolean component16() {
        return this.isLoggedIn;
    }

    public final Long component17() {
        return this.applicableDiscount;
    }

    public final String component18() {
        return this.alternatePhoneNumber;
    }

    public final String component19() {
        return this.planName;
    }

    public final String component2() {
        return this.mobile;
    }

    public final String component20() {
        return this.planValidTillDate;
    }

    public final boolean component21() {
        return this.cancelService;
    }

    public final String component22() {
        return this.cancellationRequestedDate;
    }

    public final String component23() {
        return this.relocation_status;
    }

    public final String component24() {
        return this.refShortLink;
    }

    public final String component3() {
        return this.email;
    }

    public final String component4() {
        return this.id;
    }

    public final String component5() {
        return this.token;
    }

    public final String component6() {
        return this.planId;
    }

    public final boolean component7() {
        return this.kycCompleted;
    }

    public final boolean component8() {
        return this.paymentCompleted;
    }

    public final String component9() {
        return this.referralCode;
    }

    public final User copy(String str, String str2, String str3, String id, String token, String str4, boolean z, boolean z2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Boolean bool, Long l, String str12, String str13, String str14, boolean z3, String str15, String str16, String str17) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(token, "token");
        return new User(str, str2, str3, id, token, str4, z, z2, str5, str6, str7, str8, str9, str10, str11, bool, l, str12, str13, str14, z3, str15, str16, str17);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof User) {
            User user = (User) obj;
            return Intrinsics.areEqual(this.name, user.name) && Intrinsics.areEqual(this.mobile, user.mobile) && Intrinsics.areEqual(this.email, user.email) && Intrinsics.areEqual(this.id, user.id) && Intrinsics.areEqual(this.token, user.token) && Intrinsics.areEqual(this.planId, user.planId) && this.kycCompleted == user.kycCompleted && this.paymentCompleted == user.paymentCompleted && Intrinsics.areEqual(this.referralCode, user.referralCode) && Intrinsics.areEqual(this.address, user.address) && Intrinsics.areEqual(this.city, user.city) && Intrinsics.areEqual(this.area, user.area) && Intrinsics.areEqual(this.state, user.state) && Intrinsics.areEqual(this.hubCode, user.hubCode) && Intrinsics.areEqual(this.pinCode, user.pinCode) && Intrinsics.areEqual(this.isLoggedIn, user.isLoggedIn) && Intrinsics.areEqual(this.applicableDiscount, user.applicableDiscount) && Intrinsics.areEqual(this.alternatePhoneNumber, user.alternatePhoneNumber) && Intrinsics.areEqual(this.planName, user.planName) && Intrinsics.areEqual(this.planValidTillDate, user.planValidTillDate) && this.cancelService == user.cancelService && Intrinsics.areEqual(this.cancellationRequestedDate, user.cancellationRequestedDate) && Intrinsics.areEqual(this.relocation_status, user.relocation_status) && Intrinsics.areEqual(this.refShortLink, user.refShortLink);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.mobile;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.email;
        int hashCode3 = (((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.id.hashCode()) * 31) + this.token.hashCode()) * 31;
        String str4 = this.planId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        boolean z = this.kycCompleted;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode4 + i) * 31;
        boolean z2 = this.paymentCompleted;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        String str5 = this.referralCode;
        int hashCode5 = (i4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.address;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.city;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.area;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.state;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.hubCode;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.pinCode;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Boolean bool = this.isLoggedIn;
        int hashCode12 = (hashCode11 + (bool == null ? 0 : bool.hashCode())) * 31;
        Long l = this.applicableDiscount;
        int hashCode13 = (hashCode12 + (l == null ? 0 : l.hashCode())) * 31;
        String str12 = this.alternatePhoneNumber;
        int hashCode14 = (hashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.planName;
        int hashCode15 = (hashCode14 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.planValidTillDate;
        int hashCode16 = (hashCode15 + (str14 == null ? 0 : str14.hashCode())) * 31;
        boolean z3 = this.cancelService;
        int i5 = (hashCode16 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
        String str15 = this.cancellationRequestedDate;
        int hashCode17 = (i5 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.relocation_status;
        int hashCode18 = (hashCode17 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.refShortLink;
        return hashCode18 + (str17 != null ? str17.hashCode() : 0);
    }

    public String toString() {
        return "User(name=" + this.name + ", mobile=" + this.mobile + ", email=" + this.email + ", id=" + this.id + ", token=" + this.token + ", planId=" + this.planId + ", kycCompleted=" + this.kycCompleted + ", paymentCompleted=" + this.paymentCompleted + ", referralCode=" + this.referralCode + ", address=" + this.address + ", city=" + this.city + ", area=" + this.area + ", state=" + this.state + ", hubCode=" + this.hubCode + ", pinCode=" + this.pinCode + ", isLoggedIn=" + this.isLoggedIn + ", applicableDiscount=" + this.applicableDiscount + ", alternatePhoneNumber=" + this.alternatePhoneNumber + ", planName=" + this.planName + ", planValidTillDate=" + this.planValidTillDate + ", cancelService=" + this.cancelService + ", cancellationRequestedDate=" + this.cancellationRequestedDate + ", relocation_status=" + this.relocation_status + ", refShortLink=" + this.refShortLink + ')';
    }

    public User(String str, String str2, String str3, String id, String token, String str4, boolean z, boolean z2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Boolean bool, Long l, String str12, String str13, String str14, boolean z3, String str15, String str16, String str17) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(token, "token");
        this.name = str;
        this.mobile = str2;
        this.email = str3;
        this.id = id;
        this.token = token;
        this.planId = str4;
        this.kycCompleted = z;
        this.paymentCompleted = z2;
        this.referralCode = str5;
        this.address = str6;
        this.city = str7;
        this.area = str8;
        this.state = str9;
        this.hubCode = str10;
        this.pinCode = str11;
        this.isLoggedIn = bool;
        this.applicableDiscount = l;
        this.alternatePhoneNumber = str12;
        this.planName = str13;
        this.planValidTillDate = str14;
        this.cancelService = z3;
        this.cancellationRequestedDate = str15;
        this.relocation_status = str16;
        this.refShortLink = str17;
    }

    public /* synthetic */ User(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Boolean bool, Long l, String str14, String str15, String str16, boolean z3, String str17, String str18, String str19, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, z, z2, str7, (i & 512) != 0 ? "" : str8, (i & 1024) != 0 ? "" : str9, (i & 2048) != 0 ? "" : str10, (i & 4096) != 0 ? "" : str11, str12, str13, bool, l, (131072 & i) != 0 ? "" : str14, (262144 & i) != 0 ? "" : str15, (524288 & i) != 0 ? "" : str16, z3, (2097152 & i) != 0 ? "" : str17, (4194304 & i) != 0 ? "" : str18, (i & 8388608) != 0 ? "" : str19);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final void setMobile(String str) {
        this.mobile = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.token = str;
    }

    public final String getPlanId() {
        return this.planId;
    }

    public final void setPlanId(String str) {
        this.planId = str;
    }

    public final boolean getKycCompleted() {
        return this.kycCompleted;
    }

    public final void setKycCompleted(boolean z) {
        this.kycCompleted = z;
    }

    public final boolean getPaymentCompleted() {
        return this.paymentCompleted;
    }

    public final void setPaymentCompleted(boolean z) {
        this.paymentCompleted = z;
    }

    public final String getReferralCode() {
        return this.referralCode;
    }

    public final void setReferralCode(String str) {
        this.referralCode = str;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final String getArea() {
        return this.area;
    }

    public final void setArea(String str) {
        this.area = str;
    }

    public final String getState() {
        return this.state;
    }

    public final void setState(String str) {
        this.state = str;
    }

    public final String getHubCode() {
        return this.hubCode;
    }

    public final void setHubCode(String str) {
        this.hubCode = str;
    }

    public final String getPinCode() {
        return this.pinCode;
    }

    public final void setPinCode(String str) {
        this.pinCode = str;
    }

    public final Boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    public final Long getApplicableDiscount() {
        return this.applicableDiscount;
    }

    public final void setApplicableDiscount(Long l) {
        this.applicableDiscount = l;
    }

    public final String getAlternatePhoneNumber() {
        return this.alternatePhoneNumber;
    }

    public final void setAlternatePhoneNumber(String str) {
        this.alternatePhoneNumber = str;
    }

    public final String getPlanName() {
        return this.planName;
    }

    public final void setPlanName(String str) {
        this.planName = str;
    }

    public final String getPlanValidTillDate() {
        return this.planValidTillDate;
    }

    public final void setPlanValidTillDate(String str) {
        this.planValidTillDate = str;
    }

    public final boolean getCancelService() {
        return this.cancelService;
    }

    public final void setCancelService(boolean z) {
        this.cancelService = z;
    }

    public final String getCancellationRequestedDate() {
        return this.cancellationRequestedDate;
    }

    public final void setCancellationRequestedDate(String str) {
        this.cancellationRequestedDate = str;
    }

    public final String getRelocation_status() {
        return this.relocation_status;
    }

    public final void setRelocation_status(String str) {
        this.relocation_status = str;
    }

    public final String getRefShortLink() {
        return this.refShortLink;
    }

    public final void setRefShortLink(String str) {
        this.refShortLink = str;
    }
}

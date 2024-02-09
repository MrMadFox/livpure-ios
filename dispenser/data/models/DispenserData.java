package com.livpure.safedrink.dispenser.data.models;

import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DispenserData.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u000eHÆ\u0003J\t\u00103\u001a\u00020\u0010HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010;\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u008e\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R\u001e\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0017\"\u0004\b,\u0010\u0019R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0017\"\u0004\b0\u0010\u0019¨\u0006C"}, d2 = {"Lcom/livpure/safedrink/dispenser/data/models/DispenserData;", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "", "username", "email", "phone", "registerDate", "productType", "referralCode", "emailVerification", "", "phoneVerification", AndroidContextPlugin.DEVICE_KEY, "Lcom/livpure/safedrink/dispenser/data/models/DispenserDevice;", "plan", "Lcom/livpure/safedrink/dispenser/data/models/DispenserPlanDetails;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/livpure/safedrink/dispenser/data/models/DispenserDevice;Lcom/livpure/safedrink/dispenser/data/models/DispenserPlanDetails;)V", "getDevice", "()Lcom/livpure/safedrink/dispenser/data/models/DispenserDevice;", "setDevice", "(Lcom/livpure/safedrink/dispenser/data/models/DispenserDevice;)V", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "getEmailVerification", "()Ljava/lang/Boolean;", "setEmailVerification", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPhone", "setPhone", "getPhoneVerification", "setPhoneVerification", "getPlan", "()Lcom/livpure/safedrink/dispenser/data/models/DispenserPlanDetails;", "setPlan", "(Lcom/livpure/safedrink/dispenser/data/models/DispenserPlanDetails;)V", "getProductType", "setProductType", "getReferralCode", "setReferralCode", "getRegisterDate", "setRegisterDate", "getUserId", "setUserId", "getUsername", "setUsername", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", MoEPushConstants.ACTION_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/livpure/safedrink/dispenser/data/models/DispenserDevice;Lcom/livpure/safedrink/dispenser/data/models/DispenserPlanDetails;)Lcom/livpure/safedrink/dispenser/data/models/DispenserData;", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DispenserData {
    private DispenserDevice device;
    private String email;
    private Boolean emailVerification;
    private String phone;
    private Boolean phoneVerification;
    private DispenserPlanDetails plan;
    private String productType;
    private String referralCode;
    private String registerDate;
    private String userId;
    private String username;

    public final String component1() {
        return this.userId;
    }

    public final DispenserDevice component10() {
        return this.device;
    }

    public final DispenserPlanDetails component11() {
        return this.plan;
    }

    public final String component2() {
        return this.username;
    }

    public final String component3() {
        return this.email;
    }

    public final String component4() {
        return this.phone;
    }

    public final String component5() {
        return this.registerDate;
    }

    public final String component6() {
        return this.productType;
    }

    public final String component7() {
        return this.referralCode;
    }

    public final Boolean component8() {
        return this.emailVerification;
    }

    public final Boolean component9() {
        return this.phoneVerification;
    }

    public final DispenserData copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, Boolean bool2, DispenserDevice device, DispenserPlanDetails plan) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(plan, "plan");
        return new DispenserData(str, str2, str3, str4, str5, str6, str7, bool, bool2, device, plan);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DispenserData) {
            DispenserData dispenserData = (DispenserData) obj;
            return Intrinsics.areEqual(this.userId, dispenserData.userId) && Intrinsics.areEqual(this.username, dispenserData.username) && Intrinsics.areEqual(this.email, dispenserData.email) && Intrinsics.areEqual(this.phone, dispenserData.phone) && Intrinsics.areEqual(this.registerDate, dispenserData.registerDate) && Intrinsics.areEqual(this.productType, dispenserData.productType) && Intrinsics.areEqual(this.referralCode, dispenserData.referralCode) && Intrinsics.areEqual(this.emailVerification, dispenserData.emailVerification) && Intrinsics.areEqual(this.phoneVerification, dispenserData.phoneVerification) && Intrinsics.areEqual(this.device, dispenserData.device) && Intrinsics.areEqual(this.plan, dispenserData.plan);
        }
        return false;
    }

    public int hashCode() {
        String str = this.userId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.username;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.email;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.phone;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.registerDate;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.productType;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.referralCode;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool = this.emailVerification;
        int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.phoneVerification;
        return ((((hashCode8 + (bool2 != null ? bool2.hashCode() : 0)) * 31) + this.device.hashCode()) * 31) + this.plan.hashCode();
    }

    public String toString() {
        return "DispenserData(userId=" + this.userId + ", username=" + this.username + ", email=" + this.email + ", phone=" + this.phone + ", registerDate=" + this.registerDate + ", productType=" + this.productType + ", referralCode=" + this.referralCode + ", emailVerification=" + this.emailVerification + ", phoneVerification=" + this.phoneVerification + ", device=" + this.device + ", plan=" + this.plan + ')';
    }

    public DispenserData(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, Boolean bool2, DispenserDevice device, DispenserPlanDetails plan) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(plan, "plan");
        this.userId = str;
        this.username = str2;
        this.email = str3;
        this.phone = str4;
        this.registerDate = str5;
        this.productType = str6;
        this.referralCode = str7;
        this.emailVerification = bool;
        this.phoneVerification = bool2;
        this.device = device;
        this.plan = plan;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final void setPhone(String str) {
        this.phone = str;
    }

    public final String getRegisterDate() {
        return this.registerDate;
    }

    public final void setRegisterDate(String str) {
        this.registerDate = str;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final void setProductType(String str) {
        this.productType = str;
    }

    public final String getReferralCode() {
        return this.referralCode;
    }

    public final void setReferralCode(String str) {
        this.referralCode = str;
    }

    public /* synthetic */ DispenserData(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, Boolean bool2, DispenserDevice dispenserDevice, DispenserPlanDetails dispenserPlanDetails, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? false : bool, (i & 256) != 0 ? false : bool2, dispenserDevice, dispenserPlanDetails);
    }

    public final Boolean getEmailVerification() {
        return this.emailVerification;
    }

    public final void setEmailVerification(Boolean bool) {
        this.emailVerification = bool;
    }

    public final Boolean getPhoneVerification() {
        return this.phoneVerification;
    }

    public final void setPhoneVerification(Boolean bool) {
        this.phoneVerification = bool;
    }

    public final DispenserDevice getDevice() {
        return this.device;
    }

    public final void setDevice(DispenserDevice dispenserDevice) {
        Intrinsics.checkNotNullParameter(dispenserDevice, "<set-?>");
        this.device = dispenserDevice;
    }

    public final DispenserPlanDetails getPlan() {
        return this.plan;
    }

    public final void setPlan(DispenserPlanDetails dispenserPlanDetails) {
        Intrinsics.checkNotNullParameter(dispenserPlanDetails, "<set-?>");
        this.plan = dispenserPlanDetails;
    }
}

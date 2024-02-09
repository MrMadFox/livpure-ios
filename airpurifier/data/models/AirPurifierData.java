package com.livpure.safedrink.airpurifier.data.models;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AirPurifierData.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00108\u001a\u00020\u000eHÆ\u0003J\t\u00109\u001a\u00020\u0010HÆ\u0003J\t\u0010:\u001a\u00020\u0012HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010B\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010!J\u0098\u0001\u0010C\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020\u000b2\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020HHÖ\u0001J\t\u0010I\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001fR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b'\u0010!\"\u0004\b(\u0010#R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001d\"\u0004\b4\u0010\u001fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001d\"\u0004\b6\u0010\u001f¨\u0006J"}, d2 = {"Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierData;", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "", "username", "email", "phone", "registerDate", "productType", "referralCode", "emailVerification", "", "phoneVerification", AndroidContextPlugin.DEVICE_KEY, "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDevice;", "airPurifierGraph", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraph;", "plan", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierPlanDetails;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDevice;Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraph;Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierPlanDetails;)V", "getAirPurifierGraph", "()Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraph;", "setAirPurifierGraph", "(Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraph;)V", "getDevice", "()Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDevice;", "setDevice", "(Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDevice;)V", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "getEmailVerification", "()Ljava/lang/Boolean;", "setEmailVerification", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPhone", "setPhone", "getPhoneVerification", "setPhoneVerification", "getPlan", "()Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierPlanDetails;", "setPlan", "(Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierPlanDetails;)V", "getProductType", "setProductType", "getReferralCode", "setReferralCode", "getRegisterDate", "setRegisterDate", "getUserId", "setUserId", "getUsername", "setUsername", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", MoEPushConstants.ACTION_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDevice;Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraph;Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierPlanDetails;)Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierData;", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AirPurifierData {
    @SerializedName("graph")
    private AirPurifierGraph airPurifierGraph;
    private AirPurifierDevice device;
    private String email;
    private Boolean emailVerification;
    private String phone;
    private Boolean phoneVerification;
    private AirPurifierPlanDetails plan;
    private String productType;
    private String referralCode;
    private String registerDate;
    private String userId;
    private String username;

    public final String component1() {
        return this.userId;
    }

    public final AirPurifierDevice component10() {
        return this.device;
    }

    public final AirPurifierGraph component11() {
        return this.airPurifierGraph;
    }

    public final AirPurifierPlanDetails component12() {
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

    public final AirPurifierData copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, Boolean bool2, AirPurifierDevice device, AirPurifierGraph airPurifierGraph, AirPurifierPlanDetails plan) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(airPurifierGraph, "airPurifierGraph");
        Intrinsics.checkNotNullParameter(plan, "plan");
        return new AirPurifierData(str, str2, str3, str4, str5, str6, str7, bool, bool2, device, airPurifierGraph, plan);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AirPurifierData) {
            AirPurifierData airPurifierData = (AirPurifierData) obj;
            return Intrinsics.areEqual(this.userId, airPurifierData.userId) && Intrinsics.areEqual(this.username, airPurifierData.username) && Intrinsics.areEqual(this.email, airPurifierData.email) && Intrinsics.areEqual(this.phone, airPurifierData.phone) && Intrinsics.areEqual(this.registerDate, airPurifierData.registerDate) && Intrinsics.areEqual(this.productType, airPurifierData.productType) && Intrinsics.areEqual(this.referralCode, airPurifierData.referralCode) && Intrinsics.areEqual(this.emailVerification, airPurifierData.emailVerification) && Intrinsics.areEqual(this.phoneVerification, airPurifierData.phoneVerification) && Intrinsics.areEqual(this.device, airPurifierData.device) && Intrinsics.areEqual(this.airPurifierGraph, airPurifierData.airPurifierGraph) && Intrinsics.areEqual(this.plan, airPurifierData.plan);
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
        return ((((((hashCode8 + (bool2 != null ? bool2.hashCode() : 0)) * 31) + this.device.hashCode()) * 31) + this.airPurifierGraph.hashCode()) * 31) + this.plan.hashCode();
    }

    public String toString() {
        return "AirPurifierData(userId=" + this.userId + ", username=" + this.username + ", email=" + this.email + ", phone=" + this.phone + ", registerDate=" + this.registerDate + ", productType=" + this.productType + ", referralCode=" + this.referralCode + ", emailVerification=" + this.emailVerification + ", phoneVerification=" + this.phoneVerification + ", device=" + this.device + ", airPurifierGraph=" + this.airPurifierGraph + ", plan=" + this.plan + ')';
    }

    public AirPurifierData(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, Boolean bool2, AirPurifierDevice device, AirPurifierGraph airPurifierGraph, AirPurifierPlanDetails plan) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(airPurifierGraph, "airPurifierGraph");
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
        this.airPurifierGraph = airPurifierGraph;
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

    public /* synthetic */ AirPurifierData(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, Boolean bool2, AirPurifierDevice airPurifierDevice, AirPurifierGraph airPurifierGraph, AirPurifierPlanDetails airPurifierPlanDetails, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? false : bool, (i & 256) != 0 ? false : bool2, airPurifierDevice, airPurifierGraph, airPurifierPlanDetails);
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

    public final AirPurifierDevice getDevice() {
        return this.device;
    }

    public final void setDevice(AirPurifierDevice airPurifierDevice) {
        Intrinsics.checkNotNullParameter(airPurifierDevice, "<set-?>");
        this.device = airPurifierDevice;
    }

    public final AirPurifierGraph getAirPurifierGraph() {
        return this.airPurifierGraph;
    }

    public final void setAirPurifierGraph(AirPurifierGraph airPurifierGraph) {
        Intrinsics.checkNotNullParameter(airPurifierGraph, "<set-?>");
        this.airPurifierGraph = airPurifierGraph;
    }

    public final AirPurifierPlanDetails getPlan() {
        return this.plan;
    }

    public final void setPlan(AirPurifierPlanDetails airPurifierPlanDetails) {
        Intrinsics.checkNotNullParameter(airPurifierPlanDetails, "<set-?>");
        this.plan = airPurifierPlanDetails;
    }
}

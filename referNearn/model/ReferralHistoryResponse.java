package com.livpure.safedrink.referNearn.model;

import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReferralHistoryResponse.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/livpure/safedrink/referNearn/model/ReferralHistoryResponse;", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "", "userName", "userPhone", "registeredDate", "signedUp", "subscribe", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRegisteredDate", "()Ljava/lang/String;", "getSignedUp", "getSubscribe", "getUserId", "getUserName", "getUserPhone", "component1", "component2", "component3", "component4", "component5", "component6", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferralHistoryResponse {
    private final String registeredDate;
    private final String signedUp;
    private final String subscribe;
    private final String userId;
    private final String userName;
    private final String userPhone;

    public ReferralHistoryResponse() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ReferralHistoryResponse copy$default(ReferralHistoryResponse referralHistoryResponse, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = referralHistoryResponse.userId;
        }
        if ((i & 2) != 0) {
            str2 = referralHistoryResponse.userName;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = referralHistoryResponse.userPhone;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = referralHistoryResponse.registeredDate;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = referralHistoryResponse.signedUp;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = referralHistoryResponse.subscribe;
        }
        return referralHistoryResponse.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userName;
    }

    public final String component3() {
        return this.userPhone;
    }

    public final String component4() {
        return this.registeredDate;
    }

    public final String component5() {
        return this.signedUp;
    }

    public final String component6() {
        return this.subscribe;
    }

    public final ReferralHistoryResponse copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new ReferralHistoryResponse(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReferralHistoryResponse) {
            ReferralHistoryResponse referralHistoryResponse = (ReferralHistoryResponse) obj;
            return Intrinsics.areEqual(this.userId, referralHistoryResponse.userId) && Intrinsics.areEqual(this.userName, referralHistoryResponse.userName) && Intrinsics.areEqual(this.userPhone, referralHistoryResponse.userPhone) && Intrinsics.areEqual(this.registeredDate, referralHistoryResponse.registeredDate) && Intrinsics.areEqual(this.signedUp, referralHistoryResponse.signedUp) && Intrinsics.areEqual(this.subscribe, referralHistoryResponse.subscribe);
        }
        return false;
    }

    public int hashCode() {
        String str = this.userId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.userName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userPhone;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.registeredDate;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.signedUp;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.subscribe;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "ReferralHistoryResponse(userId=" + this.userId + ", userName=" + this.userName + ", userPhone=" + this.userPhone + ", registeredDate=" + this.registeredDate + ", signedUp=" + this.signedUp + ", subscribe=" + this.subscribe + ')';
    }

    public ReferralHistoryResponse(String str, String str2, String str3, String str4, String str5, String str6) {
        this.userId = str;
        this.userName = str2;
        this.userPhone = str3;
        this.registeredDate = str4;
        this.signedUp = str5;
        this.subscribe = str6;
    }

    public /* synthetic */ ReferralHistoryResponse(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6);
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUserPhone() {
        return this.userPhone;
    }

    public final String getRegisteredDate() {
        return this.registeredDate;
    }

    public final String getSignedUp() {
        return this.signedUp;
    }

    public final String getSubscribe() {
        return this.subscribe;
    }
}

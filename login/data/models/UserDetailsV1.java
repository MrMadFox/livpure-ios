package com.livpure.safedrink.login.data.models;

import com.google.gson.annotations.SerializedName;
import com.livpure.safedrink.app.LSApplication;
import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: UserDetailsV1.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f¢\u0006\u0002\u0010\u0013J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\u0099\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fHÆ\u0001J\u0013\u00100\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u00102\u001a\u0004\u0018\u000103J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019¨\u00067"}, d2 = {"Lcom/livpure/safedrink/login/data/models/UserDetailsV1;", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "", "username", "email", "phone", "referralCode", "planId", "planName", "refShortLink", "cancelService", "", "cancellationRequestedDate", "addressDetailsList", "", "Lcom/livpure/safedrink/login/data/models/AddressDetails;", "planAndReferralDiscountList", "Lcom/livpure/safedrink/login/data/models/PlanAndReferralDiscountDetails;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getAddressDetailsList", "()Ljava/util/List;", "getCancelService", "()Z", "getCancellationRequestedDate", "()Ljava/lang/String;", "getEmail", "getPhone", "getPlanAndReferralDiscountList", "getPlanId", "getPlanName", "getRefShortLink", "getReferralCode", "getUserId", "getUsername", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", MoEPushConstants.ACTION_COPY, "equals", "other", "getMappedUser", "Lcom/livpure/safedrink/login/data/models/User;", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UserDetailsV1 {
    @SerializedName("user_address")
    private final List<AddressDetails> addressDetailsList;
    private final boolean cancelService;
    private final String cancellationRequestedDate;
    private final String email;
    private final String phone;
    @SerializedName("plan_details")
    private final List<PlanAndReferralDiscountDetails> planAndReferralDiscountList;
    private final String planId;
    private final String planName;
    private final String refShortLink;
    private final String referralCode;
    private final String userId;
    private final String username;

    public final String component1() {
        return this.userId;
    }

    public final String component10() {
        return this.cancellationRequestedDate;
    }

    public final List<AddressDetails> component11() {
        return this.addressDetailsList;
    }

    public final List<PlanAndReferralDiscountDetails> component12() {
        return this.planAndReferralDiscountList;
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
        return this.referralCode;
    }

    public final String component6() {
        return this.planId;
    }

    public final String component7() {
        return this.planName;
    }

    public final String component8() {
        return this.refShortLink;
    }

    public final boolean component9() {
        return this.cancelService;
    }

    public final UserDetailsV1 copy(String userId, String username, String email, String phone, String str, String str2, String str3, String str4, boolean z, String str5, List<AddressDetails> list, List<PlanAndReferralDiscountDetails> planAndReferralDiscountList) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(planAndReferralDiscountList, "planAndReferralDiscountList");
        return new UserDetailsV1(userId, username, email, phone, str, str2, str3, str4, z, str5, list, planAndReferralDiscountList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserDetailsV1) {
            UserDetailsV1 userDetailsV1 = (UserDetailsV1) obj;
            return Intrinsics.areEqual(this.userId, userDetailsV1.userId) && Intrinsics.areEqual(this.username, userDetailsV1.username) && Intrinsics.areEqual(this.email, userDetailsV1.email) && Intrinsics.areEqual(this.phone, userDetailsV1.phone) && Intrinsics.areEqual(this.referralCode, userDetailsV1.referralCode) && Intrinsics.areEqual(this.planId, userDetailsV1.planId) && Intrinsics.areEqual(this.planName, userDetailsV1.planName) && Intrinsics.areEqual(this.refShortLink, userDetailsV1.refShortLink) && this.cancelService == userDetailsV1.cancelService && Intrinsics.areEqual(this.cancellationRequestedDate, userDetailsV1.cancellationRequestedDate) && Intrinsics.areEqual(this.addressDetailsList, userDetailsV1.addressDetailsList) && Intrinsics.areEqual(this.planAndReferralDiscountList, userDetailsV1.planAndReferralDiscountList);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.userId.hashCode() * 31) + this.username.hashCode()) * 31) + this.email.hashCode()) * 31) + this.phone.hashCode()) * 31;
        String str = this.referralCode;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.planId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.planName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.refShortLink;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        boolean z = this.cancelService;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode5 + i) * 31;
        String str5 = this.cancellationRequestedDate;
        int hashCode6 = (i2 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<AddressDetails> list = this.addressDetailsList;
        return ((hashCode6 + (list != null ? list.hashCode() : 0)) * 31) + this.planAndReferralDiscountList.hashCode();
    }

    public String toString() {
        return "UserDetailsV1(userId=" + this.userId + ", username=" + this.username + ", email=" + this.email + ", phone=" + this.phone + ", referralCode=" + this.referralCode + ", planId=" + this.planId + ", planName=" + this.planName + ", refShortLink=" + this.refShortLink + ", cancelService=" + this.cancelService + ", cancellationRequestedDate=" + this.cancellationRequestedDate + ", addressDetailsList=" + this.addressDetailsList + ", planAndReferralDiscountList=" + this.planAndReferralDiscountList + ')';
    }

    public UserDetailsV1(String userId, String username, String email, String phone, String str, String str2, String str3, String str4, boolean z, String str5, List<AddressDetails> list, List<PlanAndReferralDiscountDetails> planAndReferralDiscountList) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(planAndReferralDiscountList, "planAndReferralDiscountList");
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.referralCode = str;
        this.planId = str2;
        this.planName = str3;
        this.refShortLink = str4;
        this.cancelService = z;
        this.cancellationRequestedDate = str5;
        this.addressDetailsList = list;
        this.planAndReferralDiscountList = planAndReferralDiscountList;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUsername() {
        return this.username;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getReferralCode() {
        return this.referralCode;
    }

    public final String getPlanId() {
        return this.planId;
    }

    public final String getPlanName() {
        return this.planName;
    }

    public final String getRefShortLink() {
        return this.refShortLink;
    }

    public final boolean getCancelService() {
        return this.cancelService;
    }

    public final String getCancellationRequestedDate() {
        return this.cancellationRequestedDate;
    }

    public final List<AddressDetails> getAddressDetailsList() {
        return this.addressDetailsList;
    }

    public final List<PlanAndReferralDiscountDetails> getPlanAndReferralDiscountList() {
        return this.planAndReferralDiscountList;
    }

    public final User getMappedUser() {
        User user = LSApplication.Companion.getUser();
        if (user != null) {
            user.setId(this.userId);
            user.setName(this.username);
            user.setEmail(this.email);
            user.setMobile(this.phone);
            user.setPlanId(this.planId);
            user.setPlanName(this.planName);
            user.setReferralCode(this.referralCode);
            user.setCancelService(this.cancelService);
            user.setRefShortLink(this.refShortLink);
            user.setCancellationRequestedDate(this.cancellationRequestedDate);
            List<AddressDetails> list = this.addressDetailsList;
            boolean z = true;
            if (!(list == null || list.isEmpty())) {
                user.setAddress(this.addressDetailsList.get(0).getAddress());
                user.setArea(this.addressDetailsList.get(0).getArea());
                user.setCity(this.addressDetailsList.get(0).getCity());
                user.setState(this.addressDetailsList.get(0).getState());
                user.setPinCode(this.addressDetailsList.get(0).getPinCode());
                user.setHubCode(this.addressDetailsList.get(0).getHubCode());
                String eKYCUploaded = this.addressDetailsList.get(0).getEKYCUploaded();
                user.setKycCompleted(eKYCUploaded != null ? StringsKt.equals(eKYCUploaded, "Y", true) : false);
                user.setRelocation_status(this.addressDetailsList.get(0).getRelocation_status());
            }
            List<PlanAndReferralDiscountDetails> list2 = this.planAndReferralDiscountList;
            if (list2 != null && !list2.isEmpty()) {
                z = false;
            }
            user.setApplicableDiscount(!z ? this.planAndReferralDiscountList.get(0).getDiscountAmount() : 0L);
            return user;
        }
        return null;
    }
}

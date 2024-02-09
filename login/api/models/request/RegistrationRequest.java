package com.livpure.safedrink.login.api.models.request;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RegistrationRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J_\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lcom/livpure/safedrink/login/api/models/request/RegistrationRequest;", "", "username", "", "email", "phone", "password", "referralCode", "deviceAppUID", "source", "city", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCity", "()Ljava/lang/String;", "getDeviceAppUID", "getEmail", "getPassword", "getPhone", "getReferralCode", "getSource", "getUsername", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RegistrationRequest {
    private final String city;
    private final String deviceAppUID;
    private final String email;
    private final String password;
    private final String phone;
    private final String referralCode;
    private final String source;
    private final String username;

    public final String component1() {
        return this.username;
    }

    public final String component2() {
        return this.email;
    }

    public final String component3() {
        return this.phone;
    }

    public final String component4() {
        return this.password;
    }

    public final String component5() {
        return this.referralCode;
    }

    public final String component6() {
        return this.deviceAppUID;
    }

    public final String component7() {
        return this.source;
    }

    public final String component8() {
        return this.city;
    }

    public final RegistrationRequest copy(String username, String email, String phone, String password, String referralCode, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(referralCode, "referralCode");
        return new RegistrationRequest(username, email, phone, password, referralCode, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RegistrationRequest) {
            RegistrationRequest registrationRequest = (RegistrationRequest) obj;
            return Intrinsics.areEqual(this.username, registrationRequest.username) && Intrinsics.areEqual(this.email, registrationRequest.email) && Intrinsics.areEqual(this.phone, registrationRequest.phone) && Intrinsics.areEqual(this.password, registrationRequest.password) && Intrinsics.areEqual(this.referralCode, registrationRequest.referralCode) && Intrinsics.areEqual(this.deviceAppUID, registrationRequest.deviceAppUID) && Intrinsics.areEqual(this.source, registrationRequest.source) && Intrinsics.areEqual(this.city, registrationRequest.city);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((this.username.hashCode() * 31) + this.email.hashCode()) * 31) + this.phone.hashCode()) * 31) + this.password.hashCode()) * 31) + this.referralCode.hashCode()) * 31;
        String str = this.deviceAppUID;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.source;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.city;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "RegistrationRequest(username=" + this.username + ", email=" + this.email + ", phone=" + this.phone + ", password=" + this.password + ", referralCode=" + this.referralCode + ", deviceAppUID=" + this.deviceAppUID + ", source=" + this.source + ", city=" + this.city + ')';
    }

    public RegistrationRequest(String username, String email, String phone, String password, String referralCode, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(referralCode, "referralCode");
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.referralCode = referralCode;
        this.deviceAppUID = str;
        this.source = str2;
        this.city = str3;
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

    public final String getPassword() {
        return this.password;
    }

    public final String getReferralCode() {
        return this.referralCode;
    }

    public final String getDeviceAppUID() {
        return this.deviceAppUID;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getCity() {
        return this.city;
    }
}

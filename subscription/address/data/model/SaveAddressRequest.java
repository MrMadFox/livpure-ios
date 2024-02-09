package com.livpure.safedrink.subscription.address.data.model;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SaveAddressRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003Jo\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000f¨\u0006,"}, d2 = {"Lcom/livpure/safedrink/subscription/address/data/model/SaveAddressRequest;", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "", "email", "phone", "city", "pinCode", "area", "address", "hubCode", "state", "alternatePhoneNumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getAlternatePhoneNumber", "setAlternatePhoneNumber", "(Ljava/lang/String;)V", "getArea", "getCity", "getEmail", "getHubCode", "getPhone", "getPinCode", "getState", "getUserId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SaveAddressRequest {
    private final String address;
    @SerializedName("alternatePhNo")
    private String alternatePhoneNumber;
    private final String area;
    private final String city;
    private final String email;
    @SerializedName("hub_code")
    private final String hubCode;
    private final String phone;
    @SerializedName("pincode")
    private final String pinCode;
    private final String state;
    private final String userId;

    public final String component1() {
        return this.userId;
    }

    public final String component10() {
        return this.alternatePhoneNumber;
    }

    public final String component2() {
        return this.email;
    }

    public final String component3() {
        return this.phone;
    }

    public final String component4() {
        return this.city;
    }

    public final String component5() {
        return this.pinCode;
    }

    public final String component6() {
        return this.area;
    }

    public final String component7() {
        return this.address;
    }

    public final String component8() {
        return this.hubCode;
    }

    public final String component9() {
        return this.state;
    }

    public final SaveAddressRequest copy(String userId, String email, String phone, String city, String pinCode, String area, String address, String hubCode, String state, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(pinCode, "pinCode");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(hubCode, "hubCode");
        Intrinsics.checkNotNullParameter(state, "state");
        return new SaveAddressRequest(userId, email, phone, city, pinCode, area, address, hubCode, state, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SaveAddressRequest) {
            SaveAddressRequest saveAddressRequest = (SaveAddressRequest) obj;
            return Intrinsics.areEqual(this.userId, saveAddressRequest.userId) && Intrinsics.areEqual(this.email, saveAddressRequest.email) && Intrinsics.areEqual(this.phone, saveAddressRequest.phone) && Intrinsics.areEqual(this.city, saveAddressRequest.city) && Intrinsics.areEqual(this.pinCode, saveAddressRequest.pinCode) && Intrinsics.areEqual(this.area, saveAddressRequest.area) && Intrinsics.areEqual(this.address, saveAddressRequest.address) && Intrinsics.areEqual(this.hubCode, saveAddressRequest.hubCode) && Intrinsics.areEqual(this.state, saveAddressRequest.state) && Intrinsics.areEqual(this.alternatePhoneNumber, saveAddressRequest.alternatePhoneNumber);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.userId.hashCode() * 31) + this.email.hashCode()) * 31) + this.phone.hashCode()) * 31) + this.city.hashCode()) * 31) + this.pinCode.hashCode()) * 31) + this.area.hashCode()) * 31) + this.address.hashCode()) * 31) + this.hubCode.hashCode()) * 31) + this.state.hashCode()) * 31;
        String str = this.alternatePhoneNumber;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SaveAddressRequest(userId=" + this.userId + ", email=" + this.email + ", phone=" + this.phone + ", city=" + this.city + ", pinCode=" + this.pinCode + ", area=" + this.area + ", address=" + this.address + ", hubCode=" + this.hubCode + ", state=" + this.state + ", alternatePhoneNumber=" + this.alternatePhoneNumber + ')';
    }

    public SaveAddressRequest(String userId, String email, String phone, String city, String pinCode, String area, String address, String hubCode, String state, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(pinCode, "pinCode");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(hubCode, "hubCode");
        Intrinsics.checkNotNullParameter(state, "state");
        this.userId = userId;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.pinCode = pinCode;
        this.area = area;
        this.address = address;
        this.hubCode = hubCode;
        this.state = state;
        this.alternatePhoneNumber = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getPinCode() {
        return this.pinCode;
    }

    public final String getArea() {
        return this.area;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getHubCode() {
        return this.hubCode;
    }

    public final String getState() {
        return this.state;
    }

    public final String getAlternatePhoneNumber() {
        return this.alternatePhoneNumber;
    }

    public final void setAlternatePhoneNumber(String str) {
        this.alternatePhoneNumber = str;
    }
}

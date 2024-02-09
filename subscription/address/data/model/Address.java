package com.livpure.safedrink.subscription.address.data.model;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Address.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JG\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/livpure/safedrink/subscription/address/data/model/Address;", "", "address", "", "city", "area", "pinCode", "state", "hubCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getArea", "getCity", "getHubCode", "getPinCode", "getState", "component1", "component2", "component3", "component4", "component5", "component6", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Address {
    private final String address;
    private final String area;
    private final String city;
    @SerializedName("hub_code")
    private final String hubCode;
    @SerializedName("pincode")
    private final String pinCode;
    private final String state;

    public static /* synthetic */ Address copy$default(Address address, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = address.address;
        }
        if ((i & 2) != 0) {
            str2 = address.city;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = address.area;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = address.pinCode;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = address.state;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = address.hubCode;
        }
        return address.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.address;
    }

    public final String component2() {
        return this.city;
    }

    public final String component3() {
        return this.area;
    }

    public final String component4() {
        return this.pinCode;
    }

    public final String component5() {
        return this.state;
    }

    public final String component6() {
        return this.hubCode;
    }

    public final Address copy(String address, String city, String area, String pinCode, String str, String hubCode) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(pinCode, "pinCode");
        Intrinsics.checkNotNullParameter(hubCode, "hubCode");
        return new Address(address, city, area, pinCode, str, hubCode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Address) {
            Address address = (Address) obj;
            return Intrinsics.areEqual(this.address, address.address) && Intrinsics.areEqual(this.city, address.city) && Intrinsics.areEqual(this.area, address.area) && Intrinsics.areEqual(this.pinCode, address.pinCode) && Intrinsics.areEqual(this.state, address.state) && Intrinsics.areEqual(this.hubCode, address.hubCode);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.address.hashCode() * 31) + this.city.hashCode()) * 31) + this.area.hashCode()) * 31) + this.pinCode.hashCode()) * 31;
        String str = this.state;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.hubCode.hashCode();
    }

    public String toString() {
        return "Address(address=" + this.address + ", city=" + this.city + ", area=" + this.area + ", pinCode=" + this.pinCode + ", state=" + this.state + ", hubCode=" + this.hubCode + ')';
    }

    public Address(String address, String city, String area, String pinCode, String str, String hubCode) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(pinCode, "pinCode");
        Intrinsics.checkNotNullParameter(hubCode, "hubCode");
        this.address = address;
        this.city = city;
        this.area = area;
        this.pinCode = pinCode;
        this.state = str;
        this.hubCode = hubCode;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getArea() {
        return this.area;
    }

    public final String getPinCode() {
        return this.pinCode;
    }

    public final String getState() {
        return this.state;
    }

    public final String getHubCode() {
        return this.hubCode;
    }
}

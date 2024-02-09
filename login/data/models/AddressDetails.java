package com.livpure.safedrink.login.data.models;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AddressDetails.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lcom/livpure/safedrink/login/data/models/AddressDetails;", "", "address", "", "area", "city", "hubCode", "pinCode", "state", "eKYCUploaded", "relocation_status", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getArea", "getCity", "getEKYCUploaded", "getHubCode", "getPinCode", "getRelocation_status", "getState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AddressDetails {
    private final String address;
    private final String area;
    private final String city;
    @SerializedName("Ekyc")
    private final String eKYCUploaded;
    @SerializedName("hub_code")
    private final String hubCode;
    @SerializedName("pincode")
    private final String pinCode;
    private final String relocation_status;
    private final String state;

    public final String component1() {
        return this.address;
    }

    public final String component2() {
        return this.area;
    }

    public final String component3() {
        return this.city;
    }

    public final String component4() {
        return this.hubCode;
    }

    public final String component5() {
        return this.pinCode;
    }

    public final String component6() {
        return this.state;
    }

    public final String component7() {
        return this.eKYCUploaded;
    }

    public final String component8() {
        return this.relocation_status;
    }

    public final AddressDetails copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return new AddressDetails(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AddressDetails) {
            AddressDetails addressDetails = (AddressDetails) obj;
            return Intrinsics.areEqual(this.address, addressDetails.address) && Intrinsics.areEqual(this.area, addressDetails.area) && Intrinsics.areEqual(this.city, addressDetails.city) && Intrinsics.areEqual(this.hubCode, addressDetails.hubCode) && Intrinsics.areEqual(this.pinCode, addressDetails.pinCode) && Intrinsics.areEqual(this.state, addressDetails.state) && Intrinsics.areEqual(this.eKYCUploaded, addressDetails.eKYCUploaded) && Intrinsics.areEqual(this.relocation_status, addressDetails.relocation_status);
        }
        return false;
    }

    public int hashCode() {
        String str = this.address;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.area;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.city;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.hubCode;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.pinCode;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.state;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.eKYCUploaded;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.relocation_status;
        return hashCode7 + (str8 != null ? str8.hashCode() : 0);
    }

    public String toString() {
        return "AddressDetails(address=" + this.address + ", area=" + this.area + ", city=" + this.city + ", hubCode=" + this.hubCode + ", pinCode=" + this.pinCode + ", state=" + this.state + ", eKYCUploaded=" + this.eKYCUploaded + ", relocation_status=" + this.relocation_status + ')';
    }

    public AddressDetails(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.address = str;
        this.area = str2;
        this.city = str3;
        this.hubCode = str4;
        this.pinCode = str5;
        this.state = str6;
        this.eKYCUploaded = str7;
        this.relocation_status = str8;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getArea() {
        return this.area;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getHubCode() {
        return this.hubCode;
    }

    public final String getPinCode() {
        return this.pinCode;
    }

    public final String getState() {
        return this.state;
    }

    public final String getEKYCUploaded() {
        return this.eKYCUploaded;
    }

    public final String getRelocation_status() {
        return this.relocation_status;
    }
}

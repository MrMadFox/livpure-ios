package com.livpure.safedrink.serviceRequest.data.model;

import com.livpure.safedrink.segment.SegmentProperties;
import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateAddressRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J±\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013¨\u00066"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/UpdateAddressRequest;", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "", "mobile", "area", "city", "state", "address", "pincode", "username", SegmentProperties.LAST_NAME, "alternatePhNo", "salutationCode", "machineStatus", "relocation_type", "source", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getAlternatePhNo", "getArea", "getCity", "getLastName", "getMachineStatus", "getMobile", "getPincode", "getRelocation_type", "getSalutationCode", "getSource", "getState", "getUserId", "getUsername", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateAddressRequest {
    private final String address;
    private final String alternatePhNo;
    private final String area;
    private final String city;
    private final String lastName;
    private final String machineStatus;
    private final String mobile;
    private final String pincode;
    private final String relocation_type;
    private final String salutationCode;
    private final String source;
    private final String state;
    private final String userId;
    private final String username;

    public final String component1() {
        return this.userId;
    }

    public final String component10() {
        return this.alternatePhNo;
    }

    public final String component11() {
        return this.salutationCode;
    }

    public final String component12() {
        return this.machineStatus;
    }

    public final String component13() {
        return this.relocation_type;
    }

    public final String component14() {
        return this.source;
    }

    public final String component2() {
        return this.mobile;
    }

    public final String component3() {
        return this.area;
    }

    public final String component4() {
        return this.city;
    }

    public final String component5() {
        return this.state;
    }

    public final String component6() {
        return this.address;
    }

    public final String component7() {
        return this.pincode;
    }

    public final String component8() {
        return this.username;
    }

    public final String component9() {
        return this.lastName;
    }

    public final UpdateAddressRequest copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        return new UpdateAddressRequest(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UpdateAddressRequest) {
            UpdateAddressRequest updateAddressRequest = (UpdateAddressRequest) obj;
            return Intrinsics.areEqual(this.userId, updateAddressRequest.userId) && Intrinsics.areEqual(this.mobile, updateAddressRequest.mobile) && Intrinsics.areEqual(this.area, updateAddressRequest.area) && Intrinsics.areEqual(this.city, updateAddressRequest.city) && Intrinsics.areEqual(this.state, updateAddressRequest.state) && Intrinsics.areEqual(this.address, updateAddressRequest.address) && Intrinsics.areEqual(this.pincode, updateAddressRequest.pincode) && Intrinsics.areEqual(this.username, updateAddressRequest.username) && Intrinsics.areEqual(this.lastName, updateAddressRequest.lastName) && Intrinsics.areEqual(this.alternatePhNo, updateAddressRequest.alternatePhNo) && Intrinsics.areEqual(this.salutationCode, updateAddressRequest.salutationCode) && Intrinsics.areEqual(this.machineStatus, updateAddressRequest.machineStatus) && Intrinsics.areEqual(this.relocation_type, updateAddressRequest.relocation_type) && Intrinsics.areEqual(this.source, updateAddressRequest.source);
        }
        return false;
    }

    public int hashCode() {
        String str = this.userId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.mobile;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.area;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.city;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.state;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.address;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.pincode;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.username;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.lastName;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.alternatePhNo;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.salutationCode;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.machineStatus;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.relocation_type;
        int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.source;
        return hashCode13 + (str14 != null ? str14.hashCode() : 0);
    }

    public String toString() {
        return "UpdateAddressRequest(userId=" + this.userId + ", mobile=" + this.mobile + ", area=" + this.area + ", city=" + this.city + ", state=" + this.state + ", address=" + this.address + ", pincode=" + this.pincode + ", username=" + this.username + ", lastName=" + this.lastName + ", alternatePhNo=" + this.alternatePhNo + ", salutationCode=" + this.salutationCode + ", machineStatus=" + this.machineStatus + ", relocation_type=" + this.relocation_type + ", source=" + this.source + ')';
    }

    public UpdateAddressRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.userId = str;
        this.mobile = str2;
        this.area = str3;
        this.city = str4;
        this.state = str5;
        this.address = str6;
        this.pincode = str7;
        this.username = str8;
        this.lastName = str9;
        this.alternatePhNo = str10;
        this.salutationCode = str11;
        this.machineStatus = str12;
        this.relocation_type = str13;
        this.source = str14;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final String getArea() {
        return this.area;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getState() {
        return this.state;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getPincode() {
        return this.pincode;
    }

    public final String getUsername() {
        return this.username;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getAlternatePhNo() {
        return this.alternatePhNo;
    }

    public final String getSalutationCode() {
        return this.salutationCode;
    }

    public final String getMachineStatus() {
        return this.machineStatus;
    }

    public final String getRelocation_type() {
        return this.relocation_type;
    }

    public final String getSource() {
        return this.source;
    }
}

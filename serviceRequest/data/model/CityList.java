package com.livpure.safedrink.serviceRequest.data.model;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CityList.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\bL\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003Já\u0001\u0010N\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010R\u001a\u00020SHÖ\u0001J\t\u0010T\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0017\"\u0004\b3\u0010\u0019R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0017\"\u0004\b9\u0010\u0019R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019¨\u0006U"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/CityList;", "", "_id", "", "c_id", "area", "pincode", "district", "state", "country", "flipkart", "non_flipkart", "Hub_Name", "hub_code", "status", "city_id", "created_by", "created_date", "modified_by", "modified_date", "city", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHub_Name", "()Ljava/lang/String;", "setHub_Name", "(Ljava/lang/String;)V", "get_id", "set_id", "getArea", "setArea", "getC_id", "setC_id", "getCity", "setCity", "getCity_id", "setCity_id", "getCountry", "setCountry", "getCreated_by", "setCreated_by", "getCreated_date", "setCreated_date", "getDistrict", "setDistrict", "getFlipkart", "setFlipkart", "getHub_code", "setHub_code", "getModified_by", "setModified_by", "getModified_date", "setModified_date", "getNon_flipkart", "setNon_flipkart", "getPincode", "setPincode", "getState", "setState", "getStatus", "setStatus", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CityList {
    private String Hub_Name;
    private String _id;
    private String area;
    private String c_id;
    private String city;
    private String city_id;
    private String country;
    private String created_by;
    private String created_date;
    private String district;
    private String flipkart;
    private String hub_code;
    private String modified_by;
    private String modified_date;
    private String non_flipkart;
    private String pincode;
    private String state;
    private String status;

    public final String component1() {
        return this._id;
    }

    public final String component10() {
        return this.Hub_Name;
    }

    public final String component11() {
        return this.hub_code;
    }

    public final String component12() {
        return this.status;
    }

    public final String component13() {
        return this.city_id;
    }

    public final String component14() {
        return this.created_by;
    }

    public final String component15() {
        return this.created_date;
    }

    public final String component16() {
        return this.modified_by;
    }

    public final String component17() {
        return this.modified_date;
    }

    public final String component18() {
        return this.city;
    }

    public final String component2() {
        return this.c_id;
    }

    public final String component3() {
        return this.area;
    }

    public final String component4() {
        return this.pincode;
    }

    public final String component5() {
        return this.district;
    }

    public final String component6() {
        return this.state;
    }

    public final String component7() {
        return this.country;
    }

    public final String component8() {
        return this.flipkart;
    }

    public final String component9() {
        return this.non_flipkart;
    }

    public final CityList copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18) {
        return new CityList(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CityList) {
            CityList cityList = (CityList) obj;
            return Intrinsics.areEqual(this._id, cityList._id) && Intrinsics.areEqual(this.c_id, cityList.c_id) && Intrinsics.areEqual(this.area, cityList.area) && Intrinsics.areEqual(this.pincode, cityList.pincode) && Intrinsics.areEqual(this.district, cityList.district) && Intrinsics.areEqual(this.state, cityList.state) && Intrinsics.areEqual(this.country, cityList.country) && Intrinsics.areEqual(this.flipkart, cityList.flipkart) && Intrinsics.areEqual(this.non_flipkart, cityList.non_flipkart) && Intrinsics.areEqual(this.Hub_Name, cityList.Hub_Name) && Intrinsics.areEqual(this.hub_code, cityList.hub_code) && Intrinsics.areEqual(this.status, cityList.status) && Intrinsics.areEqual(this.city_id, cityList.city_id) && Intrinsics.areEqual(this.created_by, cityList.created_by) && Intrinsics.areEqual(this.created_date, cityList.created_date) && Intrinsics.areEqual(this.modified_by, cityList.modified_by) && Intrinsics.areEqual(this.modified_date, cityList.modified_date) && Intrinsics.areEqual(this.city, cityList.city);
        }
        return false;
    }

    public int hashCode() {
        String str = this._id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.c_id;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.area;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.pincode;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.district;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.state;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.country;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.flipkart;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.non_flipkart;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.Hub_Name;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.hub_code;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.status;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.city_id;
        int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.created_by;
        int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.created_date;
        int hashCode15 = (hashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.modified_by;
        int hashCode16 = (hashCode15 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.modified_date;
        int hashCode17 = (hashCode16 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.city;
        return hashCode17 + (str18 != null ? str18.hashCode() : 0);
    }

    public String toString() {
        return "CityList(_id=" + this._id + ", c_id=" + this.c_id + ", area=" + this.area + ", pincode=" + this.pincode + ", district=" + this.district + ", state=" + this.state + ", country=" + this.country + ", flipkart=" + this.flipkart + ", non_flipkart=" + this.non_flipkart + ", Hub_Name=" + this.Hub_Name + ", hub_code=" + this.hub_code + ", status=" + this.status + ", city_id=" + this.city_id + ", created_by=" + this.created_by + ", created_date=" + this.created_date + ", modified_by=" + this.modified_by + ", modified_date=" + this.modified_date + ", city=" + this.city + ')';
    }

    public CityList(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18) {
        this._id = str;
        this.c_id = str2;
        this.area = str3;
        this.pincode = str4;
        this.district = str5;
        this.state = str6;
        this.country = str7;
        this.flipkart = str8;
        this.non_flipkart = str9;
        this.Hub_Name = str10;
        this.hub_code = str11;
        this.status = str12;
        this.city_id = str13;
        this.created_by = str14;
        this.created_date = str15;
        this.modified_by = str16;
        this.modified_date = str17;
        this.city = str18;
    }

    public final String get_id() {
        return this._id;
    }

    public final void set_id(String str) {
        this._id = str;
    }

    public final String getC_id() {
        return this.c_id;
    }

    public final void setC_id(String str) {
        this.c_id = str;
    }

    public final String getArea() {
        return this.area;
    }

    public final void setArea(String str) {
        this.area = str;
    }

    public final String getPincode() {
        return this.pincode;
    }

    public final void setPincode(String str) {
        this.pincode = str;
    }

    public final String getDistrict() {
        return this.district;
    }

    public final void setDistrict(String str) {
        this.district = str;
    }

    public final String getState() {
        return this.state;
    }

    public final void setState(String str) {
        this.state = str;
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final String getFlipkart() {
        return this.flipkart;
    }

    public final void setFlipkart(String str) {
        this.flipkart = str;
    }

    public final String getNon_flipkart() {
        return this.non_flipkart;
    }

    public final void setNon_flipkart(String str) {
        this.non_flipkart = str;
    }

    public final String getHub_Name() {
        return this.Hub_Name;
    }

    public final void setHub_Name(String str) {
        this.Hub_Name = str;
    }

    public final String getHub_code() {
        return this.hub_code;
    }

    public final void setHub_code(String str) {
        this.hub_code = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getCity_id() {
        return this.city_id;
    }

    public final void setCity_id(String str) {
        this.city_id = str;
    }

    public final String getCreated_by() {
        return this.created_by;
    }

    public final void setCreated_by(String str) {
        this.created_by = str;
    }

    public final String getCreated_date() {
        return this.created_date;
    }

    public final void setCreated_date(String str) {
        this.created_date = str;
    }

    public final String getModified_by() {
        return this.modified_by;
    }

    public final void setModified_by(String str) {
        this.modified_by = str;
    }

    public final String getModified_date() {
        return this.modified_date;
    }

    public final void setModified_date(String str) {
        this.modified_date = str;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }
}

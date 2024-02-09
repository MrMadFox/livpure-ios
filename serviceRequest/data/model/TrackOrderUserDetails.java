package com.livpure.safedrink.serviceRequest.data.model;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TrackOrderUserDetails.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/TrackOrderUserDetails;", "", "ekycStatus", "", "relocation_date", "humsarResponse", "Lcom/livpure/safedrink/serviceRequest/data/model/HumsarResponse;", "ekycApprovedDate", "relocation_type", "(Ljava/lang/String;Ljava/lang/String;Lcom/livpure/safedrink/serviceRequest/data/model/HumsarResponse;Ljava/lang/String;Ljava/lang/String;)V", "getEkycApprovedDate", "()Ljava/lang/String;", "getEkycStatus", "getHumsarResponse", "()Lcom/livpure/safedrink/serviceRequest/data/model/HumsarResponse;", "getRelocation_date", "getRelocation_type", "component1", "component2", "component3", "component4", "component5", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TrackOrderUserDetails {
    private final String ekycApprovedDate;
    private final String ekycStatus;
    private final HumsarResponse humsarResponse;
    private final String relocation_date;
    private final String relocation_type;

    public static /* synthetic */ TrackOrderUserDetails copy$default(TrackOrderUserDetails trackOrderUserDetails, String str, String str2, HumsarResponse humsarResponse, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = trackOrderUserDetails.ekycStatus;
        }
        if ((i & 2) != 0) {
            str2 = trackOrderUserDetails.relocation_date;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            humsarResponse = trackOrderUserDetails.humsarResponse;
        }
        HumsarResponse humsarResponse2 = humsarResponse;
        if ((i & 8) != 0) {
            str3 = trackOrderUserDetails.ekycApprovedDate;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = trackOrderUserDetails.relocation_type;
        }
        return trackOrderUserDetails.copy(str, str5, humsarResponse2, str6, str4);
    }

    public final String component1() {
        return this.ekycStatus;
    }

    public final String component2() {
        return this.relocation_date;
    }

    public final HumsarResponse component3() {
        return this.humsarResponse;
    }

    public final String component4() {
        return this.ekycApprovedDate;
    }

    public final String component5() {
        return this.relocation_type;
    }

    public final TrackOrderUserDetails copy(String str, String str2, HumsarResponse humsarResponse, String str3, String str4) {
        return new TrackOrderUserDetails(str, str2, humsarResponse, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TrackOrderUserDetails) {
            TrackOrderUserDetails trackOrderUserDetails = (TrackOrderUserDetails) obj;
            return Intrinsics.areEqual(this.ekycStatus, trackOrderUserDetails.ekycStatus) && Intrinsics.areEqual(this.relocation_date, trackOrderUserDetails.relocation_date) && Intrinsics.areEqual(this.humsarResponse, trackOrderUserDetails.humsarResponse) && Intrinsics.areEqual(this.ekycApprovedDate, trackOrderUserDetails.ekycApprovedDate) && Intrinsics.areEqual(this.relocation_type, trackOrderUserDetails.relocation_type);
        }
        return false;
    }

    public int hashCode() {
        String str = this.ekycStatus;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.relocation_date;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        HumsarResponse humsarResponse = this.humsarResponse;
        int hashCode3 = (hashCode2 + (humsarResponse == null ? 0 : humsarResponse.hashCode())) * 31;
        String str3 = this.ekycApprovedDate;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.relocation_type;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "TrackOrderUserDetails(ekycStatus=" + this.ekycStatus + ", relocation_date=" + this.relocation_date + ", humsarResponse=" + this.humsarResponse + ", ekycApprovedDate=" + this.ekycApprovedDate + ", relocation_type=" + this.relocation_type + ')';
    }

    public TrackOrderUserDetails(String str, String str2, HumsarResponse humsarResponse, String str3, String str4) {
        this.ekycStatus = str;
        this.relocation_date = str2;
        this.humsarResponse = humsarResponse;
        this.ekycApprovedDate = str3;
        this.relocation_type = str4;
    }

    public final String getEkycStatus() {
        return this.ekycStatus;
    }

    public final String getRelocation_date() {
        return this.relocation_date;
    }

    public final HumsarResponse getHumsarResponse() {
        return this.humsarResponse;
    }

    public final String getEkycApprovedDate() {
        return this.ekycApprovedDate;
    }

    public final String getRelocation_type() {
        return this.relocation_type;
    }
}

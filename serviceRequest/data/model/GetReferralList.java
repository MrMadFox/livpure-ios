package com.livpure.safedrink.serviceRequest.data.model;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GetReferralList.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/GetReferralList;", "", "id", "", "customer_name", "email_id", "phone_no", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCustomer_name", "()Ljava/lang/String;", "getEmail_id", "getId", "getPhone_no", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetReferralList {
    private final String customer_name;
    private final String email_id;
    private final String id;
    private final String phone_no;

    public static /* synthetic */ GetReferralList copy$default(GetReferralList getReferralList, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getReferralList.id;
        }
        if ((i & 2) != 0) {
            str2 = getReferralList.customer_name;
        }
        if ((i & 4) != 0) {
            str3 = getReferralList.email_id;
        }
        if ((i & 8) != 0) {
            str4 = getReferralList.phone_no;
        }
        return getReferralList.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.customer_name;
    }

    public final String component3() {
        return this.email_id;
    }

    public final String component4() {
        return this.phone_no;
    }

    public final GetReferralList copy(String str, String str2, String str3, String str4) {
        return new GetReferralList(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GetReferralList) {
            GetReferralList getReferralList = (GetReferralList) obj;
            return Intrinsics.areEqual(this.id, getReferralList.id) && Intrinsics.areEqual(this.customer_name, getReferralList.customer_name) && Intrinsics.areEqual(this.email_id, getReferralList.email_id) && Intrinsics.areEqual(this.phone_no, getReferralList.phone_no);
        }
        return false;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.customer_name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.email_id;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.phone_no;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "GetReferralList(id=" + this.id + ", customer_name=" + this.customer_name + ", email_id=" + this.email_id + ", phone_no=" + this.phone_no + ')';
    }

    public GetReferralList(String str, String str2, String str3, String str4) {
        this.id = str;
        this.customer_name = str2;
        this.email_id = str3;
        this.phone_no = str4;
    }

    public final String getId() {
        return this.id;
    }

    public final String getCustomer_name() {
        return this.customer_name;
    }

    public final String getEmail_id() {
        return this.email_id;
    }

    public final String getPhone_no() {
        return this.phone_no;
    }
}

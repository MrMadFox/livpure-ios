package com.livpure.safedrink.subscription.plan.data.model;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FaultCodeDetails.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/FaultCodeDetails;", "", "productType", "", "faultDescription", "faultCode", "filterLife", "serialNo", "connectivity", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConnectivity", "()Ljava/lang/String;", "getFaultCode", "getFaultDescription", "getFilterLife", "getProductType", "getSerialNo", "component1", "component2", "component3", "component4", "component5", "component6", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FaultCodeDetails {
    private final String connectivity;
    private final String faultCode;
    private final String faultDescription;
    private final String filterLife;
    private final String productType;
    private final String serialNo;

    public static /* synthetic */ FaultCodeDetails copy$default(FaultCodeDetails faultCodeDetails, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = faultCodeDetails.productType;
        }
        if ((i & 2) != 0) {
            str2 = faultCodeDetails.faultDescription;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = faultCodeDetails.faultCode;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = faultCodeDetails.filterLife;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = faultCodeDetails.serialNo;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = faultCodeDetails.connectivity;
        }
        return faultCodeDetails.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.productType;
    }

    public final String component2() {
        return this.faultDescription;
    }

    public final String component3() {
        return this.faultCode;
    }

    public final String component4() {
        return this.filterLife;
    }

    public final String component5() {
        return this.serialNo;
    }

    public final String component6() {
        return this.connectivity;
    }

    public final FaultCodeDetails copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new FaultCodeDetails(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FaultCodeDetails) {
            FaultCodeDetails faultCodeDetails = (FaultCodeDetails) obj;
            return Intrinsics.areEqual(this.productType, faultCodeDetails.productType) && Intrinsics.areEqual(this.faultDescription, faultCodeDetails.faultDescription) && Intrinsics.areEqual(this.faultCode, faultCodeDetails.faultCode) && Intrinsics.areEqual(this.filterLife, faultCodeDetails.filterLife) && Intrinsics.areEqual(this.serialNo, faultCodeDetails.serialNo) && Intrinsics.areEqual(this.connectivity, faultCodeDetails.connectivity);
        }
        return false;
    }

    public int hashCode() {
        String str = this.productType;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.faultDescription;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.faultCode;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.filterLife;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.serialNo;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.connectivity;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "FaultCodeDetails(productType=" + this.productType + ", faultDescription=" + this.faultDescription + ", faultCode=" + this.faultCode + ", filterLife=" + this.filterLife + ", serialNo=" + this.serialNo + ", connectivity=" + this.connectivity + ')';
    }

    public FaultCodeDetails(String str, String str2, String str3, String str4, String str5, String str6) {
        this.productType = str;
        this.faultDescription = str2;
        this.faultCode = str3;
        this.filterLife = str4;
        this.serialNo = str5;
        this.connectivity = str6;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final String getFaultDescription() {
        return this.faultDescription;
    }

    public final String getFaultCode() {
        return this.faultCode;
    }

    public final String getFilterLife() {
        return this.filterLife;
    }

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final String getConnectivity() {
        return this.connectivity;
    }
}

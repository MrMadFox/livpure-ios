package com.livpure.safedrink.serviceRequest.data.model;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CityByPincodeResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J/\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/CityByPincodeResponse;", "", "success", "", "message", "", "pincode", "", "Lcom/livpure/safedrink/serviceRequest/data/model/CityList;", "(ZLjava/lang/String;Ljava/util/List;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getPincode", "()Ljava/util/List;", "setPincode", "(Ljava/util/List;)V", "getSuccess", "()Z", "setSuccess", "(Z)V", "component1", "component2", "component3", MoEPushConstants.ACTION_COPY, "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CityByPincodeResponse {
    @SerializedName("message")
    private String message;
    @SerializedName("pincode")
    private List<CityList> pincode;
    @SerializedName("success")
    private boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CityByPincodeResponse copy$default(CityByPincodeResponse cityByPincodeResponse, boolean z, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = cityByPincodeResponse.success;
        }
        if ((i & 2) != 0) {
            str = cityByPincodeResponse.message;
        }
        if ((i & 4) != 0) {
            list = cityByPincodeResponse.pincode;
        }
        return cityByPincodeResponse.copy(z, str, list);
    }

    public final boolean component1() {
        return this.success;
    }

    public final String component2() {
        return this.message;
    }

    public final List<CityList> component3() {
        return this.pincode;
    }

    public final CityByPincodeResponse copy(boolean z, String message, List<CityList> list) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new CityByPincodeResponse(z, message, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CityByPincodeResponse) {
            CityByPincodeResponse cityByPincodeResponse = (CityByPincodeResponse) obj;
            return this.success == cityByPincodeResponse.success && Intrinsics.areEqual(this.message, cityByPincodeResponse.message) && Intrinsics.areEqual(this.pincode, cityByPincodeResponse.pincode);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = ((r0 * 31) + this.message.hashCode()) * 31;
        List<CityList> list = this.pincode;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "CityByPincodeResponse(success=" + this.success + ", message=" + this.message + ", pincode=" + this.pincode + ')';
    }

    public CityByPincodeResponse(boolean z, String message, List<CityList> list) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.success = z;
        this.message = message;
        this.pincode = list;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final List<CityList> getPincode() {
        return this.pincode;
    }

    public final void setPincode(List<CityList> list) {
        this.pincode = list;
    }
}

package com.livpure.safedrink.subscription.address.data.model;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServiceableAreaRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/subscription/address/data/model/ServiceableAreaRequest;", "", "pincode", "", "job_type", "(Ljava/lang/String;Ljava/lang/String;)V", "getJob_type", "()Ljava/lang/String;", "getPincode", "component1", "component2", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServiceableAreaRequest {
    @SerializedName("job_type")
    private final String job_type;
    private final String pincode;

    public static /* synthetic */ ServiceableAreaRequest copy$default(ServiceableAreaRequest serviceableAreaRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = serviceableAreaRequest.pincode;
        }
        if ((i & 2) != 0) {
            str2 = serviceableAreaRequest.job_type;
        }
        return serviceableAreaRequest.copy(str, str2);
    }

    public final String component1() {
        return this.pincode;
    }

    public final String component2() {
        return this.job_type;
    }

    public final ServiceableAreaRequest copy(String pincode, String job_type) {
        Intrinsics.checkNotNullParameter(pincode, "pincode");
        Intrinsics.checkNotNullParameter(job_type, "job_type");
        return new ServiceableAreaRequest(pincode, job_type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServiceableAreaRequest) {
            ServiceableAreaRequest serviceableAreaRequest = (ServiceableAreaRequest) obj;
            return Intrinsics.areEqual(this.pincode, serviceableAreaRequest.pincode) && Intrinsics.areEqual(this.job_type, serviceableAreaRequest.job_type);
        }
        return false;
    }

    public int hashCode() {
        return (this.pincode.hashCode() * 31) + this.job_type.hashCode();
    }

    public String toString() {
        return "ServiceableAreaRequest(pincode=" + this.pincode + ", job_type=" + this.job_type + ')';
    }

    public ServiceableAreaRequest(String pincode, String job_type) {
        Intrinsics.checkNotNullParameter(pincode, "pincode");
        Intrinsics.checkNotNullParameter(job_type, "job_type");
        this.pincode = pincode;
        this.job_type = job_type;
    }

    public /* synthetic */ ServiceableAreaRequest(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "waas_pincode_to_area" : str2);
    }

    public final String getPincode() {
        return this.pincode;
    }

    public final String getJob_type() {
        return this.job_type;
    }
}

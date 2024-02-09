package com.livpure.safedrink.subscription.address.data.model;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServiceableAreaItem.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/livpure/safedrink/subscription/address/data/model/ServiceableAreaItem;", "", "area", "", "hubCode", "state", "message", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getArea", "()Ljava/lang/String;", "getHubCode", "getMessage", "setMessage", "(Ljava/lang/String;)V", "getState", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServiceableAreaItem {
    private final String area;
    @SerializedName("hub_code")
    private final String hubCode;
    private String message;
    private final String state;

    public static /* synthetic */ ServiceableAreaItem copy$default(ServiceableAreaItem serviceableAreaItem, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = serviceableAreaItem.area;
        }
        if ((i & 2) != 0) {
            str2 = serviceableAreaItem.hubCode;
        }
        if ((i & 4) != 0) {
            str3 = serviceableAreaItem.state;
        }
        if ((i & 8) != 0) {
            str4 = serviceableAreaItem.message;
        }
        return serviceableAreaItem.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.area;
    }

    public final String component2() {
        return this.hubCode;
    }

    public final String component3() {
        return this.state;
    }

    public final String component4() {
        return this.message;
    }

    public final ServiceableAreaItem copy(String str, String str2, String str3, String str4) {
        return new ServiceableAreaItem(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServiceableAreaItem) {
            ServiceableAreaItem serviceableAreaItem = (ServiceableAreaItem) obj;
            return Intrinsics.areEqual(this.area, serviceableAreaItem.area) && Intrinsics.areEqual(this.hubCode, serviceableAreaItem.hubCode) && Intrinsics.areEqual(this.state, serviceableAreaItem.state) && Intrinsics.areEqual(this.message, serviceableAreaItem.message);
        }
        return false;
    }

    public int hashCode() {
        String str = this.area;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.hubCode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.state;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.message;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "ServiceableAreaItem(area=" + this.area + ", hubCode=" + this.hubCode + ", state=" + this.state + ", message=" + this.message + ')';
    }

    public ServiceableAreaItem(String str, String str2, String str3, String str4) {
        this.area = str;
        this.hubCode = str2;
        this.state = str3;
        this.message = str4;
    }

    public /* synthetic */ ServiceableAreaItem(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4);
    }

    public final String getArea() {
        return this.area;
    }

    public final String getHubCode() {
        return this.hubCode;
    }

    public final String getState() {
        return this.state;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}

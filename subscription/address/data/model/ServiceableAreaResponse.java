package com.livpure.safedrink.subscription.address.data.model;

import com.moengage.pushbase.MoEPushConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServiceableAreaResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/livpure/safedrink/subscription/address/data/model/ServiceableAreaResponse;", "", "areaDetailList", "", "Lcom/livpure/safedrink/subscription/address/data/model/ServiceableAreaItem;", "(Ljava/util/List;)V", "getAreaDetailList", "()Ljava/util/List;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServiceableAreaResponse {
    private final List<ServiceableAreaItem> areaDetailList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ServiceableAreaResponse copy$default(ServiceableAreaResponse serviceableAreaResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = serviceableAreaResponse.areaDetailList;
        }
        return serviceableAreaResponse.copy(list);
    }

    public final List<ServiceableAreaItem> component1() {
        return this.areaDetailList;
    }

    public final ServiceableAreaResponse copy(List<ServiceableAreaItem> list) {
        return new ServiceableAreaResponse(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ServiceableAreaResponse) && Intrinsics.areEqual(this.areaDetailList, ((ServiceableAreaResponse) obj).areaDetailList);
    }

    public int hashCode() {
        List<ServiceableAreaItem> list = this.areaDetailList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "ServiceableAreaResponse(areaDetailList=" + this.areaDetailList + ')';
    }

    public ServiceableAreaResponse(List<ServiceableAreaItem> list) {
        this.areaDetailList = list;
    }

    public final List<ServiceableAreaItem> getAreaDetailList() {
        return this.areaDetailList;
    }
}

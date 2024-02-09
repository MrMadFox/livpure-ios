package com.livpure.safedrink.subscription.plan.data.model.dashboard;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ProductStats.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/ProductStats;", "", "filterLife", "", "productType", "isEMI", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getFilterLife", "()Ljava/lang/String;", "()Z", "getProductType", "component1", "component2", "component3", MoEPushConstants.ACTION_COPY, "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ProductStats {
    private final String filterLife;
    private final boolean isEMI;
    private final String productType;

    public static /* synthetic */ ProductStats copy$default(ProductStats productStats, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = productStats.filterLife;
        }
        if ((i & 2) != 0) {
            str2 = productStats.productType;
        }
        if ((i & 4) != 0) {
            z = productStats.isEMI;
        }
        return productStats.copy(str, str2, z);
    }

    public final String component1() {
        return this.filterLife;
    }

    public final String component2() {
        return this.productType;
    }

    public final boolean component3() {
        return this.isEMI;
    }

    public final ProductStats copy(String str, String str2, boolean z) {
        return new ProductStats(str, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProductStats) {
            ProductStats productStats = (ProductStats) obj;
            return Intrinsics.areEqual(this.filterLife, productStats.filterLife) && Intrinsics.areEqual(this.productType, productStats.productType) && this.isEMI == productStats.isEMI;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.filterLife;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.productType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.isEMI;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ProductStats(filterLife=" + this.filterLife + ", productType=" + this.productType + ", isEMI=" + this.isEMI + ')';
    }

    public ProductStats(String str, String str2, boolean z) {
        this.filterLife = str;
        this.productType = str2;
        this.isEMI = z;
    }

    public final String getFilterLife() {
        return this.filterLife;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final boolean isEMI() {
        return this.isEMI;
    }
}

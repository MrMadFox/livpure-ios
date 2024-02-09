package com.livpure.safedrink.subscription.plan.data.model.dashboard;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UsageStats.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/UsageStats;", "", "remainingLitres", "", "totalConsumed", "(Ljava/lang/String;Ljava/lang/String;)V", "getRemainingLitres", "()Ljava/lang/String;", "getTotalConsumed", "component1", "component2", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UsageStats {
    @SerializedName("remaining")
    private final String remainingLitres;
    private final String totalConsumed;

    public static /* synthetic */ UsageStats copy$default(UsageStats usageStats, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = usageStats.remainingLitres;
        }
        if ((i & 2) != 0) {
            str2 = usageStats.totalConsumed;
        }
        return usageStats.copy(str, str2);
    }

    public final String component1() {
        return this.remainingLitres;
    }

    public final String component2() {
        return this.totalConsumed;
    }

    public final UsageStats copy(String str, String str2) {
        return new UsageStats(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UsageStats) {
            UsageStats usageStats = (UsageStats) obj;
            return Intrinsics.areEqual(this.remainingLitres, usageStats.remainingLitres) && Intrinsics.areEqual(this.totalConsumed, usageStats.totalConsumed);
        }
        return false;
    }

    public int hashCode() {
        String str = this.remainingLitres;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.totalConsumed;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "UsageStats(remainingLitres=" + this.remainingLitres + ", totalConsumed=" + this.totalConsumed + ')';
    }

    public UsageStats(String str, String str2) {
        this.remainingLitres = str;
        this.totalConsumed = str2;
    }

    public final String getRemainingLitres() {
        return this.remainingLitres;
    }

    public final String getTotalConsumed() {
        return this.totalConsumed;
    }
}

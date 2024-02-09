package com.livpure.safedrink.referNearn.model;

import com.moengage.pushbase.MoEPushConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: referralHistory.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/livpure/safedrink/referNearn/model/referralHistory;", "", "referralCount", "", "referralLiters", "", "referralHistory", "", "Lcom/livpure/safedrink/referNearn/model/ReferralHistoryResponse;", "(ILjava/lang/String;Ljava/util/List;)V", "getReferralCount", "()I", "getReferralHistory", "()Ljava/util/List;", "getReferralLiters", "()Ljava/lang/String;", "component1", "component2", "component3", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class referralHistory {
    private final int referralCount;
    private final List<ReferralHistoryResponse> referralHistory;
    private final String referralLiters;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ referralHistory copy$default(referralHistory referralhistory, int i, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = referralhistory.referralCount;
        }
        if ((i2 & 2) != 0) {
            str = referralhistory.referralLiters;
        }
        if ((i2 & 4) != 0) {
            list = referralhistory.referralHistory;
        }
        return referralhistory.copy(i, str, list);
    }

    public final int component1() {
        return this.referralCount;
    }

    public final String component2() {
        return this.referralLiters;
    }

    public final List<ReferralHistoryResponse> component3() {
        return this.referralHistory;
    }

    public final referralHistory copy(int i, String str, List<ReferralHistoryResponse> referralHistory) {
        Intrinsics.checkNotNullParameter(referralHistory, "referralHistory");
        return new referralHistory(i, str, referralHistory);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof referralHistory) {
            referralHistory referralhistory = (referralHistory) obj;
            return this.referralCount == referralhistory.referralCount && Intrinsics.areEqual(this.referralLiters, referralhistory.referralLiters) && Intrinsics.areEqual(this.referralHistory, referralhistory.referralHistory);
        }
        return false;
    }

    public int hashCode() {
        int i = this.referralCount * 31;
        String str = this.referralLiters;
        return ((i + (str == null ? 0 : str.hashCode())) * 31) + this.referralHistory.hashCode();
    }

    public String toString() {
        return "referralHistory(referralCount=" + this.referralCount + ", referralLiters=" + this.referralLiters + ", referralHistory=" + this.referralHistory + ')';
    }

    public referralHistory(int i, String str, List<ReferralHistoryResponse> referralHistory) {
        Intrinsics.checkNotNullParameter(referralHistory, "referralHistory");
        this.referralCount = i;
        this.referralLiters = str;
        this.referralHistory = referralHistory;
    }

    public /* synthetic */ referralHistory(int i, String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "" : str, list);
    }

    public final int getReferralCount() {
        return this.referralCount;
    }

    public final String getReferralLiters() {
        return this.referralLiters;
    }

    public final List<ReferralHistoryResponse> getReferralHistory() {
        return this.referralHistory;
    }
}

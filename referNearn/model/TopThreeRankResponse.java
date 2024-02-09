package com.livpure.safedrink.referNearn.model;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TopThreeRankResponse.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/livpure/safedrink/referNearn/model/TopThreeRankResponse;", "", "referUserId", "", "referName", "referCount", "", "regesiteredDate", "referAlliasName", "referRank", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getReferAlliasName", "()Ljava/lang/String;", "getReferCount", "()I", "getReferName", "getReferRank", "getReferUserId", "getRegesiteredDate", "component1", "component2", "component3", "component4", "component5", "component6", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TopThreeRankResponse {
    private final String referAlliasName;
    private final int referCount;
    private final String referName;
    private final int referRank;
    private final String referUserId;
    private final String regesiteredDate;

    public static /* synthetic */ TopThreeRankResponse copy$default(TopThreeRankResponse topThreeRankResponse, String str, String str2, int i, String str3, String str4, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = topThreeRankResponse.referUserId;
        }
        if ((i3 & 2) != 0) {
            str2 = topThreeRankResponse.referName;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            i = topThreeRankResponse.referCount;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            str3 = topThreeRankResponse.regesiteredDate;
        }
        String str6 = str3;
        if ((i3 & 16) != 0) {
            str4 = topThreeRankResponse.referAlliasName;
        }
        String str7 = str4;
        if ((i3 & 32) != 0) {
            i2 = topThreeRankResponse.referRank;
        }
        return topThreeRankResponse.copy(str, str5, i4, str6, str7, i2);
    }

    public final String component1() {
        return this.referUserId;
    }

    public final String component2() {
        return this.referName;
    }

    public final int component3() {
        return this.referCount;
    }

    public final String component4() {
        return this.regesiteredDate;
    }

    public final String component5() {
        return this.referAlliasName;
    }

    public final int component6() {
        return this.referRank;
    }

    public final TopThreeRankResponse copy(String referUserId, String referName, int i, String regesiteredDate, String referAlliasName, int i2) {
        Intrinsics.checkNotNullParameter(referUserId, "referUserId");
        Intrinsics.checkNotNullParameter(referName, "referName");
        Intrinsics.checkNotNullParameter(regesiteredDate, "regesiteredDate");
        Intrinsics.checkNotNullParameter(referAlliasName, "referAlliasName");
        return new TopThreeRankResponse(referUserId, referName, i, regesiteredDate, referAlliasName, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TopThreeRankResponse) {
            TopThreeRankResponse topThreeRankResponse = (TopThreeRankResponse) obj;
            return Intrinsics.areEqual(this.referUserId, topThreeRankResponse.referUserId) && Intrinsics.areEqual(this.referName, topThreeRankResponse.referName) && this.referCount == topThreeRankResponse.referCount && Intrinsics.areEqual(this.regesiteredDate, topThreeRankResponse.regesiteredDate) && Intrinsics.areEqual(this.referAlliasName, topThreeRankResponse.referAlliasName) && this.referRank == topThreeRankResponse.referRank;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.referUserId.hashCode() * 31) + this.referName.hashCode()) * 31) + this.referCount) * 31) + this.regesiteredDate.hashCode()) * 31) + this.referAlliasName.hashCode()) * 31) + this.referRank;
    }

    public String toString() {
        return "TopThreeRankResponse(referUserId=" + this.referUserId + ", referName=" + this.referName + ", referCount=" + this.referCount + ", regesiteredDate=" + this.regesiteredDate + ", referAlliasName=" + this.referAlliasName + ", referRank=" + this.referRank + ')';
    }

    public TopThreeRankResponse(String referUserId, String referName, int i, String regesiteredDate, String referAlliasName, int i2) {
        Intrinsics.checkNotNullParameter(referUserId, "referUserId");
        Intrinsics.checkNotNullParameter(referName, "referName");
        Intrinsics.checkNotNullParameter(regesiteredDate, "regesiteredDate");
        Intrinsics.checkNotNullParameter(referAlliasName, "referAlliasName");
        this.referUserId = referUserId;
        this.referName = referName;
        this.referCount = i;
        this.regesiteredDate = regesiteredDate;
        this.referAlliasName = referAlliasName;
        this.referRank = i2;
    }

    public /* synthetic */ TopThreeRankResponse(String str, String str2, int i, String str3, String str4, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, i, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, i2);
    }

    public final String getReferUserId() {
        return this.referUserId;
    }

    public final String getReferName() {
        return this.referName;
    }

    public final int getReferCount() {
        return this.referCount;
    }

    public final String getRegesiteredDate() {
        return this.regesiteredDate;
    }

    public final String getReferAlliasName() {
        return this.referAlliasName;
    }

    public final int getReferRank() {
        return this.referRank;
    }
}

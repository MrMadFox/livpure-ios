package com.livpure.safedrink.referNearn.model;

import com.moengage.pushbase.MoEPushConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: leadershipBoard.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/livpure/safedrink/referNearn/model/leadershipBoard;", "", "referralMonth", "", "myRank", "Lcom/livpure/safedrink/referNearn/model/MyRankResponse;", "topThreeRank", "", "Lcom/livpure/safedrink/referNearn/model/TopThreeRankResponse;", "leaderShipArray", "Lcom/livpure/safedrink/referNearn/model/LaderShipArrayResponse;", "(Ljava/lang/String;Lcom/livpure/safedrink/referNearn/model/MyRankResponse;Ljava/util/List;Ljava/util/List;)V", "getLeaderShipArray", "()Ljava/util/List;", "getMyRank", "()Lcom/livpure/safedrink/referNearn/model/MyRankResponse;", "getReferralMonth", "()Ljava/lang/String;", "getTopThreeRank", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class leadershipBoard {
    private final List<LaderShipArrayResponse> leaderShipArray;
    private final MyRankResponse myRank;
    private final String referralMonth;
    private final List<TopThreeRankResponse> topThreeRank;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ leadershipBoard copy$default(leadershipBoard leadershipboard, String str, MyRankResponse myRankResponse, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = leadershipboard.referralMonth;
        }
        if ((i & 2) != 0) {
            myRankResponse = leadershipboard.myRank;
        }
        if ((i & 4) != 0) {
            list = leadershipboard.topThreeRank;
        }
        if ((i & 8) != 0) {
            list2 = leadershipboard.leaderShipArray;
        }
        return leadershipboard.copy(str, myRankResponse, list, list2);
    }

    public final String component1() {
        return this.referralMonth;
    }

    public final MyRankResponse component2() {
        return this.myRank;
    }

    public final List<TopThreeRankResponse> component3() {
        return this.topThreeRank;
    }

    public final List<LaderShipArrayResponse> component4() {
        return this.leaderShipArray;
    }

    public final leadershipBoard copy(String str, MyRankResponse myRank, List<TopThreeRankResponse> topThreeRank, List<LaderShipArrayResponse> leaderShipArray) {
        Intrinsics.checkNotNullParameter(myRank, "myRank");
        Intrinsics.checkNotNullParameter(topThreeRank, "topThreeRank");
        Intrinsics.checkNotNullParameter(leaderShipArray, "leaderShipArray");
        return new leadershipBoard(str, myRank, topThreeRank, leaderShipArray);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof leadershipBoard) {
            leadershipBoard leadershipboard = (leadershipBoard) obj;
            return Intrinsics.areEqual(this.referralMonth, leadershipboard.referralMonth) && Intrinsics.areEqual(this.myRank, leadershipboard.myRank) && Intrinsics.areEqual(this.topThreeRank, leadershipboard.topThreeRank) && Intrinsics.areEqual(this.leaderShipArray, leadershipboard.leaderShipArray);
        }
        return false;
    }

    public int hashCode() {
        String str = this.referralMonth;
        return ((((((str == null ? 0 : str.hashCode()) * 31) + this.myRank.hashCode()) * 31) + this.topThreeRank.hashCode()) * 31) + this.leaderShipArray.hashCode();
    }

    public String toString() {
        return "leadershipBoard(referralMonth=" + this.referralMonth + ", myRank=" + this.myRank + ", topThreeRank=" + this.topThreeRank + ", leaderShipArray=" + this.leaderShipArray + ')';
    }

    public leadershipBoard(String str, MyRankResponse myRank, List<TopThreeRankResponse> topThreeRank, List<LaderShipArrayResponse> leaderShipArray) {
        Intrinsics.checkNotNullParameter(myRank, "myRank");
        Intrinsics.checkNotNullParameter(topThreeRank, "topThreeRank");
        Intrinsics.checkNotNullParameter(leaderShipArray, "leaderShipArray");
        this.referralMonth = str;
        this.myRank = myRank;
        this.topThreeRank = topThreeRank;
        this.leaderShipArray = leaderShipArray;
    }

    public /* synthetic */ leadershipBoard(String str, MyRankResponse myRankResponse, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, myRankResponse, list, list2);
    }

    public final String getReferralMonth() {
        return this.referralMonth;
    }

    public final MyRankResponse getMyRank() {
        return this.myRank;
    }

    public final List<TopThreeRankResponse> getTopThreeRank() {
        return this.topThreeRank;
    }

    public final List<LaderShipArrayResponse> getLeaderShipArray() {
        return this.leaderShipArray;
    }
}

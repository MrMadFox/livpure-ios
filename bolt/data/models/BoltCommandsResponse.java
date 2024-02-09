package com.livpure.safedrink.bolt.data.models;

import com.google.gson.annotations.SerializedName;
import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.moengage.pushbase.MoEPushConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BoltCommandsResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J6\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/livpure/safedrink/bolt/data/models/BoltCommandsResponse;", "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "pullFiveRequest", "", "RTC_Time", "", "RechargeCommands", "", "Lcom/livpure/safedrink/bolt/data/models/RechargeResponse;", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;)V", "getRTC_Time", "()Ljava/lang/String;", "setRTC_Time", "(Ljava/lang/String;)V", "getRechargeCommands", "()Ljava/util/List;", "getPullFiveRequest", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", MoEPushConstants.ACTION_COPY, "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;)Lcom/livpure/safedrink/bolt/data/models/BoltCommandsResponse;", "equals", "other", "", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BoltCommandsResponse extends BaseV1Response {
    @SerializedName("rtcCmd")
    private String RTC_Time;
    @SerializedName("roRecharge")
    private final List<RechargeResponse> RechargeCommands;
    private final Boolean pullFiveRequest;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BoltCommandsResponse copy$default(BoltCommandsResponse boltCommandsResponse, Boolean bool, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = boltCommandsResponse.pullFiveRequest;
        }
        if ((i & 2) != 0) {
            str = boltCommandsResponse.RTC_Time;
        }
        if ((i & 4) != 0) {
            list = boltCommandsResponse.RechargeCommands;
        }
        return boltCommandsResponse.copy(bool, str, list);
    }

    public final Boolean component1() {
        return this.pullFiveRequest;
    }

    public final String component2() {
        return this.RTC_Time;
    }

    public final List<RechargeResponse> component3() {
        return this.RechargeCommands;
    }

    public final BoltCommandsResponse copy(Boolean bool, String RTC_Time, List<RechargeResponse> list) {
        Intrinsics.checkNotNullParameter(RTC_Time, "RTC_Time");
        return new BoltCommandsResponse(bool, RTC_Time, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BoltCommandsResponse) {
            BoltCommandsResponse boltCommandsResponse = (BoltCommandsResponse) obj;
            return Intrinsics.areEqual(this.pullFiveRequest, boltCommandsResponse.pullFiveRequest) && Intrinsics.areEqual(this.RTC_Time, boltCommandsResponse.RTC_Time) && Intrinsics.areEqual(this.RechargeCommands, boltCommandsResponse.RechargeCommands);
        }
        return false;
    }

    public int hashCode() {
        Boolean bool = this.pullFiveRequest;
        int hashCode = (((bool == null ? 0 : bool.hashCode()) * 31) + this.RTC_Time.hashCode()) * 31;
        List<RechargeResponse> list = this.RechargeCommands;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "BoltCommandsResponse(pullFiveRequest=" + this.pullFiveRequest + ", RTC_Time=" + this.RTC_Time + ", RechargeCommands=" + this.RechargeCommands + ')';
    }

    public final Boolean getPullFiveRequest() {
        return this.pullFiveRequest;
    }

    public final String getRTC_Time() {
        return this.RTC_Time;
    }

    public final void setRTC_Time(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.RTC_Time = str;
    }

    public final List<RechargeResponse> getRechargeCommands() {
        return this.RechargeCommands;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoltCommandsResponse(Boolean bool, String RTC_Time, List<RechargeResponse> list) {
        super(null, null, null, null, 15, null);
        Intrinsics.checkNotNullParameter(RTC_Time, "RTC_Time");
        this.pullFiveRequest = bool;
        this.RTC_Time = RTC_Time;
        this.RechargeCommands = list;
    }
}

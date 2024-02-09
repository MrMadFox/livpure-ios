package com.livpure.safedrink.referNearn.model;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Result.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/livpure/safedrink/referNearn/model/Result;", "", "referralAmount", "", "referralLinkMessage", "referralCode", "referralMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getReferralAmount", "()Ljava/lang/String;", "getReferralCode", "getReferralLinkMessage", "getReferralMessage", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Result {
    @SerializedName("referralAmount")
    private final String referralAmount;
    @SerializedName("referralCode")
    private final String referralCode;
    @SerializedName("referralLinkMessage")
    private final String referralLinkMessage;
    @SerializedName("referralMessage")
    private final String referralMessage;

    public Result() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ Result copy$default(Result result, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = result.referralAmount;
        }
        if ((i & 2) != 0) {
            str2 = result.referralLinkMessage;
        }
        if ((i & 4) != 0) {
            str3 = result.referralCode;
        }
        if ((i & 8) != 0) {
            str4 = result.referralMessage;
        }
        return result.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.referralAmount;
    }

    public final String component2() {
        return this.referralLinkMessage;
    }

    public final String component3() {
        return this.referralCode;
    }

    public final String component4() {
        return this.referralMessage;
    }

    public final Result copy(String str, String str2, String str3, String str4) {
        return new Result(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Result) {
            Result result = (Result) obj;
            return Intrinsics.areEqual(this.referralAmount, result.referralAmount) && Intrinsics.areEqual(this.referralLinkMessage, result.referralLinkMessage) && Intrinsics.areEqual(this.referralCode, result.referralCode) && Intrinsics.areEqual(this.referralMessage, result.referralMessage);
        }
        return false;
    }

    public int hashCode() {
        String str = this.referralAmount;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.referralLinkMessage;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.referralCode;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.referralMessage;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "Result(referralAmount=" + this.referralAmount + ", referralLinkMessage=" + this.referralLinkMessage + ", referralCode=" + this.referralCode + ", referralMessage=" + this.referralMessage + ')';
    }

    public Result(String str, String str2, String str3, String str4) {
        this.referralAmount = str;
        this.referralLinkMessage = str2;
        this.referralCode = str3;
        this.referralMessage = str4;
    }

    public /* synthetic */ Result(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getReferralAmount() {
        return this.referralAmount;
    }

    public final String getReferralLinkMessage() {
        return this.referralLinkMessage;
    }

    public final String getReferralCode() {
        return this.referralCode;
    }

    public final String getReferralMessage() {
        return this.referralMessage;
    }
}

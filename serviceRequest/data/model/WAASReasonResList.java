package com.livpure.safedrink.serviceRequest.data.model;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WAASReasonResList.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/WAASReasonResList;", "", "Reason", "", "ReasonID", "(Ljava/lang/String;Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "setReason", "(Ljava/lang/String;)V", "getReasonID", "setReasonID", "component1", "component2", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WAASReasonResList {
    private String Reason;
    private String ReasonID;

    public static /* synthetic */ WAASReasonResList copy$default(WAASReasonResList wAASReasonResList, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = wAASReasonResList.Reason;
        }
        if ((i & 2) != 0) {
            str2 = wAASReasonResList.ReasonID;
        }
        return wAASReasonResList.copy(str, str2);
    }

    public final String component1() {
        return this.Reason;
    }

    public final String component2() {
        return this.ReasonID;
    }

    public final WAASReasonResList copy(String str, String str2) {
        return new WAASReasonResList(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WAASReasonResList) {
            WAASReasonResList wAASReasonResList = (WAASReasonResList) obj;
            return Intrinsics.areEqual(this.Reason, wAASReasonResList.Reason) && Intrinsics.areEqual(this.ReasonID, wAASReasonResList.ReasonID);
        }
        return false;
    }

    public int hashCode() {
        String str = this.Reason;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.ReasonID;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "WAASReasonResList(Reason=" + this.Reason + ", ReasonID=" + this.ReasonID + ')';
    }

    public WAASReasonResList(String str, String str2) {
        this.Reason = str;
        this.ReasonID = str2;
    }

    public final String getReason() {
        return this.Reason;
    }

    public final void setReason(String str) {
        this.Reason = str;
    }

    public final String getReasonID() {
        return this.ReasonID;
    }

    public final void setReasonID(String str) {
        this.ReasonID = str;
    }
}

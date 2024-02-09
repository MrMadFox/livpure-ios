package com.livpure.safedrink.subscription.cancelsubscription.data;

import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CancelRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/livpure/safedrink/subscription/cancelsubscription/data/CancelRequest;", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "", "email", "phone", "username", "cancellationReason", "otherreason", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCancellationReason", "()Ljava/lang/String;", "getEmail", "getOtherreason", "getPhone", "getUserId", "getUsername", "component1", "component2", "component3", "component4", "component5", "component6", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CancelRequest {
    private final String cancellationReason;
    private final String email;
    private final String otherreason;
    private final String phone;
    private final String userId;
    private final String username;

    public static /* synthetic */ CancelRequest copy$default(CancelRequest cancelRequest, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cancelRequest.userId;
        }
        if ((i & 2) != 0) {
            str2 = cancelRequest.email;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = cancelRequest.phone;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = cancelRequest.username;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = cancelRequest.cancellationReason;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = cancelRequest.otherreason;
        }
        return cancelRequest.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.email;
    }

    public final String component3() {
        return this.phone;
    }

    public final String component4() {
        return this.username;
    }

    public final String component5() {
        return this.cancellationReason;
    }

    public final String component6() {
        return this.otherreason;
    }

    public final CancelRequest copy(String userId, String email, String phone, String username, String cancellationReason, String otherreason) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(cancellationReason, "cancellationReason");
        Intrinsics.checkNotNullParameter(otherreason, "otherreason");
        return new CancelRequest(userId, email, phone, username, cancellationReason, otherreason);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CancelRequest) {
            CancelRequest cancelRequest = (CancelRequest) obj;
            return Intrinsics.areEqual(this.userId, cancelRequest.userId) && Intrinsics.areEqual(this.email, cancelRequest.email) && Intrinsics.areEqual(this.phone, cancelRequest.phone) && Intrinsics.areEqual(this.username, cancelRequest.username) && Intrinsics.areEqual(this.cancellationReason, cancelRequest.cancellationReason) && Intrinsics.areEqual(this.otherreason, cancelRequest.otherreason);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.userId.hashCode() * 31) + this.email.hashCode()) * 31) + this.phone.hashCode()) * 31) + this.username.hashCode()) * 31) + this.cancellationReason.hashCode()) * 31) + this.otherreason.hashCode();
    }

    public String toString() {
        return "CancelRequest(userId=" + this.userId + ", email=" + this.email + ", phone=" + this.phone + ", username=" + this.username + ", cancellationReason=" + this.cancellationReason + ", otherreason=" + this.otherreason + ')';
    }

    public CancelRequest(String userId, String email, String phone, String username, String cancellationReason, String otherreason) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(cancellationReason, "cancellationReason");
        Intrinsics.checkNotNullParameter(otherreason, "otherreason");
        this.userId = userId;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.cancellationReason = cancellationReason;
        this.otherreason = otherreason;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getUsername() {
        return this.username;
    }

    public final String getCancellationReason() {
        return this.cancellationReason;
    }

    public final String getOtherreason() {
        return this.otherreason;
    }
}

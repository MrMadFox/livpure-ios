package com.livpure.safedrink.app.support.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SRRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/app/support/data/models/SRRequest;", "", "email", "", "requestText", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getRequestText", "component1", "component2", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SRRequest {
    private final String email;
    private final String requestText;

    public static /* synthetic */ SRRequest copy$default(SRRequest sRRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sRRequest.email;
        }
        if ((i & 2) != 0) {
            str2 = sRRequest.requestText;
        }
        return sRRequest.copy(str, str2);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.requestText;
    }

    public final SRRequest copy(String email, String requestText) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(requestText, "requestText");
        return new SRRequest(email, requestText);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SRRequest) {
            SRRequest sRRequest = (SRRequest) obj;
            return Intrinsics.areEqual(this.email, sRRequest.email) && Intrinsics.areEqual(this.requestText, sRRequest.requestText);
        }
        return false;
    }

    public int hashCode() {
        return (this.email.hashCode() * 31) + this.requestText.hashCode();
    }

    public String toString() {
        return "SRRequest(email=" + this.email + ", requestText=" + this.requestText + ')';
    }

    public SRRequest(String email, String requestText) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(requestText, "requestText");
        this.email = email;
        this.requestText = requestText;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ SRRequest(java.lang.String r1, java.lang.String r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 1
            if (r3 == 0) goto L14
            com.livpure.safedrink.app.LSApplication$Companion r1 = com.livpure.safedrink.app.LSApplication.Companion
            com.livpure.safedrink.login.data.models.User r1 = r1.getUser()
            if (r1 == 0) goto L12
            java.lang.String r1 = r1.getEmail()
            if (r1 != 0) goto L14
        L12:
            java.lang.String r1 = ""
        L14:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.app.support.data.models.SRRequest.<init>(java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getRequestText() {
        return this.requestText;
    }
}

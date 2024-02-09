package com.livpure.safedrink.subscription.kyc.data.model;

import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: S3CredentialsResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/livpure/safedrink/subscription/kyc/data/model/S3CredentialsResponse;", "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "credentials", "Lcom/livpure/safedrink/subscription/kyc/data/model/S3Credentials;", "(Lcom/livpure/safedrink/subscription/kyc/data/model/S3Credentials;)V", "getCredentials", "()Lcom/livpure/safedrink/subscription/kyc/data/model/S3Credentials;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class S3CredentialsResponse extends BaseV1Response {
    private final S3Credentials credentials;

    public static /* synthetic */ S3CredentialsResponse copy$default(S3CredentialsResponse s3CredentialsResponse, S3Credentials s3Credentials, int i, Object obj) {
        if ((i & 1) != 0) {
            s3Credentials = s3CredentialsResponse.credentials;
        }
        return s3CredentialsResponse.copy(s3Credentials);
    }

    public final S3Credentials component1() {
        return this.credentials;
    }

    public final S3CredentialsResponse copy(S3Credentials s3Credentials) {
        return new S3CredentialsResponse(s3Credentials);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof S3CredentialsResponse) && Intrinsics.areEqual(this.credentials, ((S3CredentialsResponse) obj).credentials);
    }

    public int hashCode() {
        S3Credentials s3Credentials = this.credentials;
        if (s3Credentials == null) {
            return 0;
        }
        return s3Credentials.hashCode();
    }

    public String toString() {
        return "S3CredentialsResponse(credentials=" + this.credentials + ')';
    }

    public final S3Credentials getCredentials() {
        return this.credentials;
    }

    public S3CredentialsResponse(S3Credentials s3Credentials) {
        super(null, null, null, null, 15, null);
        this.credentials = s3Credentials;
    }
}

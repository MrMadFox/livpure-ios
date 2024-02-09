package com.livpure.safedrink.subscription.kyc.data.model;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.amplitude.api.Constants;
import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: S3Credentials.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/livpure/safedrink/subscription/kyc/data/model/S3Credentials;", "", "bucketName", "", "key", "secret", Constants.AMP_TRACKING_OPTION_REGION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBucketName", "()Ljava/lang/String;", "getKey", "getRegion", "getSecret", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class S3Credentials {
    @SerializedName(TransferTable.COLUMN_BUCKET_NAME)
    private final String bucketName;
    @SerializedName("user_key")
    private final String key;
    private final String region;
    @SerializedName("user_secret")
    private final String secret;

    public static /* synthetic */ S3Credentials copy$default(S3Credentials s3Credentials, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = s3Credentials.bucketName;
        }
        if ((i & 2) != 0) {
            str2 = s3Credentials.key;
        }
        if ((i & 4) != 0) {
            str3 = s3Credentials.secret;
        }
        if ((i & 8) != 0) {
            str4 = s3Credentials.region;
        }
        return s3Credentials.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.bucketName;
    }

    public final String component2() {
        return this.key;
    }

    public final String component3() {
        return this.secret;
    }

    public final String component4() {
        return this.region;
    }

    public final S3Credentials copy(String str, String str2, String str3, String str4) {
        return new S3Credentials(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof S3Credentials) {
            S3Credentials s3Credentials = (S3Credentials) obj;
            return Intrinsics.areEqual(this.bucketName, s3Credentials.bucketName) && Intrinsics.areEqual(this.key, s3Credentials.key) && Intrinsics.areEqual(this.secret, s3Credentials.secret) && Intrinsics.areEqual(this.region, s3Credentials.region);
        }
        return false;
    }

    public int hashCode() {
        String str = this.bucketName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.key;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.secret;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.region;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "S3Credentials(bucketName=" + this.bucketName + ", key=" + this.key + ", secret=" + this.secret + ", region=" + this.region + ')';
    }

    public S3Credentials(String str, String str2, String str3, String str4) {
        this.bucketName = str;
        this.key = str2;
        this.secret = str3;
        this.region = str4;
    }

    public final String getBucketName() {
        return this.bucketName;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getSecret() {
        return this.secret;
    }

    public final String getRegion() {
        return this.region;
    }
}

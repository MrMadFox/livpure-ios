package com.livpure.safedrink.subscription.kyc.data.model;

import com.moengage.pushbase.MoEPushConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: KYCUploadRequest.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J_\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006("}, d2 = {"Lcom/livpure/safedrink/subscription/kyc/data/model/KYCUploadRequest;", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "", "fileName", "", "proofType", "Lcom/livpure/safedrink/subscription/kyc/data/model/ProofType;", "salutationCode", "installationDate", "deliveryDate", "deliveryTime", "installationTime", "(Ljava/lang/String;Ljava/util/List;Lcom/livpure/safedrink/subscription/kyc/data/model/ProofType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeliveryDate", "()Ljava/lang/String;", "getDeliveryTime", "getFileName", "()Ljava/util/List;", "getInstallationDate", "getInstallationTime", "getProofType", "()Lcom/livpure/safedrink/subscription/kyc/data/model/ProofType;", "getSalutationCode", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KYCUploadRequest {
    private final String deliveryDate;
    private final String deliveryTime;
    private final List<String> fileName;
    private final String installationDate;
    private final String installationTime;
    private final ProofType proofType;
    private final String salutationCode;
    private final String userId;

    public final String component1() {
        return this.userId;
    }

    public final List<String> component2() {
        return this.fileName;
    }

    public final ProofType component3() {
        return this.proofType;
    }

    public final String component4() {
        return this.salutationCode;
    }

    public final String component5() {
        return this.installationDate;
    }

    public final String component6() {
        return this.deliveryDate;
    }

    public final String component7() {
        return this.deliveryTime;
    }

    public final String component8() {
        return this.installationTime;
    }

    public final KYCUploadRequest copy(String userId, List<String> fileName, ProofType proofType, String salutationCode, String installationDate, String deliveryDate, String deliveryTime, String installationTime) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(proofType, "proofType");
        Intrinsics.checkNotNullParameter(salutationCode, "salutationCode");
        Intrinsics.checkNotNullParameter(installationDate, "installationDate");
        Intrinsics.checkNotNullParameter(deliveryDate, "deliveryDate");
        Intrinsics.checkNotNullParameter(deliveryTime, "deliveryTime");
        Intrinsics.checkNotNullParameter(installationTime, "installationTime");
        return new KYCUploadRequest(userId, fileName, proofType, salutationCode, installationDate, deliveryDate, deliveryTime, installationTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KYCUploadRequest) {
            KYCUploadRequest kYCUploadRequest = (KYCUploadRequest) obj;
            return Intrinsics.areEqual(this.userId, kYCUploadRequest.userId) && Intrinsics.areEqual(this.fileName, kYCUploadRequest.fileName) && Intrinsics.areEqual(this.proofType, kYCUploadRequest.proofType) && Intrinsics.areEqual(this.salutationCode, kYCUploadRequest.salutationCode) && Intrinsics.areEqual(this.installationDate, kYCUploadRequest.installationDate) && Intrinsics.areEqual(this.deliveryDate, kYCUploadRequest.deliveryDate) && Intrinsics.areEqual(this.deliveryTime, kYCUploadRequest.deliveryTime) && Intrinsics.areEqual(this.installationTime, kYCUploadRequest.installationTime);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.userId.hashCode() * 31) + this.fileName.hashCode()) * 31) + this.proofType.hashCode()) * 31) + this.salutationCode.hashCode()) * 31) + this.installationDate.hashCode()) * 31) + this.deliveryDate.hashCode()) * 31) + this.deliveryTime.hashCode()) * 31) + this.installationTime.hashCode();
    }

    public String toString() {
        return "KYCUploadRequest(userId=" + this.userId + ", fileName=" + this.fileName + ", proofType=" + this.proofType + ", salutationCode=" + this.salutationCode + ", installationDate=" + this.installationDate + ", deliveryDate=" + this.deliveryDate + ", deliveryTime=" + this.deliveryTime + ", installationTime=" + this.installationTime + ')';
    }

    public KYCUploadRequest(String userId, List<String> fileName, ProofType proofType, String salutationCode, String installationDate, String deliveryDate, String deliveryTime, String installationTime) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(proofType, "proofType");
        Intrinsics.checkNotNullParameter(salutationCode, "salutationCode");
        Intrinsics.checkNotNullParameter(installationDate, "installationDate");
        Intrinsics.checkNotNullParameter(deliveryDate, "deliveryDate");
        Intrinsics.checkNotNullParameter(deliveryTime, "deliveryTime");
        Intrinsics.checkNotNullParameter(installationTime, "installationTime");
        this.userId = userId;
        this.fileName = fileName;
        this.proofType = proofType;
        this.salutationCode = salutationCode;
        this.installationDate = installationDate;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.installationTime = installationTime;
    }

    public /* synthetic */ KYCUploadRequest(String str, List list, ProofType proofType, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, proofType, str2, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? "" : str5, (i & 128) != 0 ? "" : str6);
    }

    public final String getUserId() {
        return this.userId;
    }

    public final List<String> getFileName() {
        return this.fileName;
    }

    public final ProofType getProofType() {
        return this.proofType;
    }

    public final String getSalutationCode() {
        return this.salutationCode;
    }

    public final String getInstallationDate() {
        return this.installationDate;
    }

    public final String getDeliveryDate() {
        return this.deliveryDate;
    }

    public final String getDeliveryTime() {
        return this.deliveryTime;
    }

    public final String getInstallationTime() {
        return this.installationTime;
    }
}

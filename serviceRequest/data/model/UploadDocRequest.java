package com.livpure.safedrink.serviceRequest.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UploadDocRequest.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0004\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/UploadDocRequest;", "", "proofType", "", "isPermanentAddress", "", "front", "Ljava/io/File;", "back", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/io/File;Ljava/io/File;)V", "getBack", "()Ljava/io/File;", "getFront", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getProofType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/io/File;Ljava/io/File;)Lcom/livpure/safedrink/serviceRequest/data/model/UploadDocRequest;", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UploadDocRequest {
    @SerializedName("back")
    @Expose
    private final File back;
    @SerializedName("front")
    @Expose
    private final File front;
    @SerializedName("isPermanentAddress")
    @Expose
    private final Boolean isPermanentAddress;
    @SerializedName("proofType")
    @Expose
    private final String proofType;

    public static /* synthetic */ UploadDocRequest copy$default(UploadDocRequest uploadDocRequest, String str, Boolean bool, File file, File file2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadDocRequest.proofType;
        }
        if ((i & 2) != 0) {
            bool = uploadDocRequest.isPermanentAddress;
        }
        if ((i & 4) != 0) {
            file = uploadDocRequest.front;
        }
        if ((i & 8) != 0) {
            file2 = uploadDocRequest.back;
        }
        return uploadDocRequest.copy(str, bool, file, file2);
    }

    public final String component1() {
        return this.proofType;
    }

    public final Boolean component2() {
        return this.isPermanentAddress;
    }

    public final File component3() {
        return this.front;
    }

    public final File component4() {
        return this.back;
    }

    public final UploadDocRequest copy(String str, Boolean bool, File file, File file2) {
        return new UploadDocRequest(str, bool, file, file2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UploadDocRequest) {
            UploadDocRequest uploadDocRequest = (UploadDocRequest) obj;
            return Intrinsics.areEqual(this.proofType, uploadDocRequest.proofType) && Intrinsics.areEqual(this.isPermanentAddress, uploadDocRequest.isPermanentAddress) && Intrinsics.areEqual(this.front, uploadDocRequest.front) && Intrinsics.areEqual(this.back, uploadDocRequest.back);
        }
        return false;
    }

    public int hashCode() {
        String str = this.proofType;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.isPermanentAddress;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        File file = this.front;
        int hashCode3 = (hashCode2 + (file == null ? 0 : file.hashCode())) * 31;
        File file2 = this.back;
        return hashCode3 + (file2 != null ? file2.hashCode() : 0);
    }

    public String toString() {
        return "UploadDocRequest(proofType=" + this.proofType + ", isPermanentAddress=" + this.isPermanentAddress + ", front=" + this.front + ", back=" + this.back + ')';
    }

    public UploadDocRequest(String str, Boolean bool, File file, File file2) {
        this.proofType = str;
        this.isPermanentAddress = bool;
        this.front = file;
        this.back = file2;
    }

    public final String getProofType() {
        return this.proofType;
    }

    public final Boolean isPermanentAddress() {
        return this.isPermanentAddress;
    }

    public final File getFront() {
        return this.front;
    }

    public final File getBack() {
        return this.back;
    }
}

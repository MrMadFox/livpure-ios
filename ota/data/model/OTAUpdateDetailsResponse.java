package com.livpure.safedrink.ota.data.model;

import com.google.gson.annotations.SerializedName;
import com.livpure.safedrink.ota.data.model.response.BaseOTAResponse;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: OTAUpdateDetailsResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/livpure/safedrink/ota/data/model/OTAUpdateDetailsResponse;", "Lcom/livpure/safedrink/ota/data/model/response/BaseOTAResponse;", "firmwareDetails", "Lcom/livpure/safedrink/ota/data/model/MessageDetails;", "(Lcom/livpure/safedrink/ota/data/model/MessageDetails;)V", "getFirmwareDetails", "()Lcom/livpure/safedrink/ota/data/model/MessageDetails;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OTAUpdateDetailsResponse extends BaseOTAResponse {
    @SerializedName("message")
    private final MessageDetails firmwareDetails;

    public static /* synthetic */ OTAUpdateDetailsResponse copy$default(OTAUpdateDetailsResponse oTAUpdateDetailsResponse, MessageDetails messageDetails, int i, Object obj) {
        if ((i & 1) != 0) {
            messageDetails = oTAUpdateDetailsResponse.firmwareDetails;
        }
        return oTAUpdateDetailsResponse.copy(messageDetails);
    }

    public final MessageDetails component1() {
        return this.firmwareDetails;
    }

    public final OTAUpdateDetailsResponse copy(MessageDetails messageDetails) {
        return new OTAUpdateDetailsResponse(messageDetails);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OTAUpdateDetailsResponse) && Intrinsics.areEqual(this.firmwareDetails, ((OTAUpdateDetailsResponse) obj).firmwareDetails);
    }

    public int hashCode() {
        MessageDetails messageDetails = this.firmwareDetails;
        if (messageDetails == null) {
            return 0;
        }
        return messageDetails.hashCode();
    }

    public String toString() {
        return "OTAUpdateDetailsResponse(firmwareDetails=" + this.firmwareDetails + ')';
    }

    public final MessageDetails getFirmwareDetails() {
        return this.firmwareDetails;
    }

    public OTAUpdateDetailsResponse(MessageDetails messageDetails) {
        super(null, null, 3, null);
        this.firmwareDetails = messageDetails;
    }
}

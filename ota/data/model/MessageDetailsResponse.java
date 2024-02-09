package com.livpure.safedrink.ota.data.model;

import com.google.gson.annotations.SerializedName;
import com.livpure.safedrink.ota.data.model.response.BaseOTAResponse;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MessageDetailsResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/livpure/safedrink/ota/data/model/MessageDetailsResponse;", "Lcom/livpure/safedrink/ota/data/model/response/BaseOTAResponse;", "otaDetails", "Lcom/livpure/safedrink/ota/data/model/MessageDetails;", "(Lcom/livpure/safedrink/ota/data/model/MessageDetails;)V", "getOtaDetails", "()Lcom/livpure/safedrink/ota/data/model/MessageDetails;", "component1", MoEPushConstants.ACTION_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MessageDetailsResponse extends BaseOTAResponse {
    @SerializedName("message")
    private final MessageDetails otaDetails;

    public static /* synthetic */ MessageDetailsResponse copy$default(MessageDetailsResponse messageDetailsResponse, MessageDetails messageDetails, int i, Object obj) {
        if ((i & 1) != 0) {
            messageDetails = messageDetailsResponse.otaDetails;
        }
        return messageDetailsResponse.copy(messageDetails);
    }

    public final MessageDetails component1() {
        return this.otaDetails;
    }

    public final MessageDetailsResponse copy(MessageDetails messageDetails) {
        return new MessageDetailsResponse(messageDetails);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MessageDetailsResponse) && Intrinsics.areEqual(this.otaDetails, ((MessageDetailsResponse) obj).otaDetails);
    }

    public int hashCode() {
        MessageDetails messageDetails = this.otaDetails;
        if (messageDetails == null) {
            return 0;
        }
        return messageDetails.hashCode();
    }

    public String toString() {
        return "MessageDetailsResponse(otaDetails=" + this.otaDetails + ')';
    }

    public final MessageDetails getOtaDetails() {
        return this.otaDetails;
    }

    public MessageDetailsResponse(MessageDetails messageDetails) {
        super(null, null, 3, null);
        this.otaDetails = messageDetails;
    }
}

package com.livpure.safedrink.ota.data.model;

import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MessageDetails.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/livpure/safedrink/ota/data/model/MessageDetails;", "", "oraRes", "", "firmwareData", "message", "commandDetails", "Lcom/livpure/safedrink/ota/data/model/CommandDetails;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/livpure/safedrink/ota/data/model/CommandDetails;)V", "getCommandDetails", "()Lcom/livpure/safedrink/ota/data/model/CommandDetails;", "getFirmwareData", "()Ljava/lang/String;", "getMessage", "getOraRes", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MessageDetails {
    @SerializedName("otaRequestCmd")
    private final CommandDetails commandDetails;
    private final String firmwareData;
    @SerializedName("msg")
    private final String message;
    private final String oraRes;

    public static /* synthetic */ MessageDetails copy$default(MessageDetails messageDetails, String str, String str2, String str3, CommandDetails commandDetails, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageDetails.oraRes;
        }
        if ((i & 2) != 0) {
            str2 = messageDetails.firmwareData;
        }
        if ((i & 4) != 0) {
            str3 = messageDetails.message;
        }
        if ((i & 8) != 0) {
            commandDetails = messageDetails.commandDetails;
        }
        return messageDetails.copy(str, str2, str3, commandDetails);
    }

    public final String component1() {
        return this.oraRes;
    }

    public final String component2() {
        return this.firmwareData;
    }

    public final String component3() {
        return this.message;
    }

    public final CommandDetails component4() {
        return this.commandDetails;
    }

    public final MessageDetails copy(String str, String str2, String str3, CommandDetails commandDetails) {
        return new MessageDetails(str, str2, str3, commandDetails);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MessageDetails) {
            MessageDetails messageDetails = (MessageDetails) obj;
            return Intrinsics.areEqual(this.oraRes, messageDetails.oraRes) && Intrinsics.areEqual(this.firmwareData, messageDetails.firmwareData) && Intrinsics.areEqual(this.message, messageDetails.message) && Intrinsics.areEqual(this.commandDetails, messageDetails.commandDetails);
        }
        return false;
    }

    public int hashCode() {
        String str = this.oraRes;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.firmwareData;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.message;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        CommandDetails commandDetails = this.commandDetails;
        return hashCode3 + (commandDetails != null ? commandDetails.hashCode() : 0);
    }

    public String toString() {
        return "MessageDetails(oraRes=" + this.oraRes + ", firmwareData=" + this.firmwareData + ", message=" + this.message + ", commandDetails=" + this.commandDetails + ')';
    }

    public MessageDetails(String str, String str2, String str3, CommandDetails commandDetails) {
        this.oraRes = str;
        this.firmwareData = str2;
        this.message = str3;
        this.commandDetails = commandDetails;
    }

    public final String getOraRes() {
        return this.oraRes;
    }

    public final String getFirmwareData() {
        return this.firmwareData;
    }

    public final String getMessage() {
        return this.message;
    }

    public final CommandDetails getCommandDetails() {
        return this.commandDetails;
    }
}

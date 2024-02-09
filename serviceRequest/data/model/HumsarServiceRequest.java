package com.livpure.safedrink.serviceRequest.data.model;

import kotlin.Metadata;
/* compiled from: HumsarServiceRequest.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001B_\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/model/HumsarServiceRequest;", "", "TokenNo", "", "ReasonID", "LSH_ID", "Mobile_No", "Serial_No", "Request_Type", "SubReason_ID", "Pickup_Date_Time", "Customer_Remarks", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCustomer_Remarks", "()Ljava/lang/String;", "getLSH_ID", "getMobile_No", "getPickup_Date_Time", "getReasonID", "getRequest_Type", "getSerial_No", "getSubReason_ID", "getTokenNo", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HumsarServiceRequest {
    private final String Customer_Remarks;
    private final String LSH_ID;
    private final String Mobile_No;
    private final String Pickup_Date_Time;
    private final String ReasonID;
    private final String Request_Type;
    private final String Serial_No;
    private final String SubReason_ID;
    private final String TokenNo;

    public HumsarServiceRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.TokenNo = str;
        this.ReasonID = str2;
        this.LSH_ID = str3;
        this.Mobile_No = str4;
        this.Serial_No = str5;
        this.Request_Type = str6;
        this.SubReason_ID = str7;
        this.Pickup_Date_Time = str8;
        this.Customer_Remarks = str9;
    }

    public final String getTokenNo() {
        return this.TokenNo;
    }

    public final String getReasonID() {
        return this.ReasonID;
    }

    public final String getLSH_ID() {
        return this.LSH_ID;
    }

    public final String getMobile_No() {
        return this.Mobile_No;
    }

    public final String getSerial_No() {
        return this.Serial_No;
    }

    public final String getRequest_Type() {
        return this.Request_Type;
    }

    public final String getSubReason_ID() {
        return this.SubReason_ID;
    }

    public final String getPickup_Date_Time() {
        return this.Pickup_Date_Time;
    }

    public final String getCustomer_Remarks() {
        return this.Customer_Remarks;
    }
}

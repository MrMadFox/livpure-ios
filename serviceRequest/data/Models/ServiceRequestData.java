package com.livpure.safedrink.serviceRequest.data.Models;

import com.livpure.safedrink.segment.SegmentProperties;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServiceRequestData.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/Models/ServiceRequestData;", "", "job", "", "mobile_number", "call_type", "serial_number", "date_created", SegmentProperties.APPOINTMENTDATE, "cust_voice", "caller_number", "reference_id", "created_by", "remarks", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppointment_date", "()Ljava/lang/String;", "getCall_type", "getCaller_number", "getCreated_by", "getCust_voice", "getDate_created", "getJob", "getMobile_number", "getReference_id", "getRemarks", "getSerial_number", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServiceRequestData {
    private final String appointment_date;
    private final String call_type;
    private final String caller_number;
    private final String created_by;
    private final String cust_voice;
    private final String date_created;
    private final String job;
    private final String mobile_number;
    private final String reference_id;
    private final String remarks;
    private final String serial_number;

    public ServiceRequestData() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public ServiceRequestData(String job, String mobile_number, String call_type, String serial_number, String date_created, String appointment_date, String cust_voice, String caller_number, String reference_id, String created_by, String remarks) {
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(mobile_number, "mobile_number");
        Intrinsics.checkNotNullParameter(call_type, "call_type");
        Intrinsics.checkNotNullParameter(serial_number, "serial_number");
        Intrinsics.checkNotNullParameter(date_created, "date_created");
        Intrinsics.checkNotNullParameter(appointment_date, "appointment_date");
        Intrinsics.checkNotNullParameter(cust_voice, "cust_voice");
        Intrinsics.checkNotNullParameter(caller_number, "caller_number");
        Intrinsics.checkNotNullParameter(reference_id, "reference_id");
        Intrinsics.checkNotNullParameter(created_by, "created_by");
        Intrinsics.checkNotNullParameter(remarks, "remarks");
        this.job = job;
        this.mobile_number = mobile_number;
        this.call_type = call_type;
        this.serial_number = serial_number;
        this.date_created = date_created;
        this.appointment_date = appointment_date;
        this.cust_voice = cust_voice;
        this.caller_number = caller_number;
        this.reference_id = reference_id;
        this.created_by = created_by;
        this.remarks = remarks;
    }

    public /* synthetic */ ServiceRequestData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) != 0 ? "" : str10, (i & 1024) == 0 ? str11 : "");
    }

    public final String getJob() {
        return this.job;
    }

    public final String getMobile_number() {
        return this.mobile_number;
    }

    public final String getCall_type() {
        return this.call_type;
    }

    public final String getSerial_number() {
        return this.serial_number;
    }

    public final String getDate_created() {
        return this.date_created;
    }

    public final String getAppointment_date() {
        return this.appointment_date;
    }

    public final String getCust_voice() {
        return this.cust_voice;
    }

    public final String getCaller_number() {
        return this.caller_number;
    }

    public final String getReference_id() {
        return this.reference_id;
    }

    public final String getCreated_by() {
        return this.created_by;
    }

    public final String getRemarks() {
        return this.remarks;
    }
}

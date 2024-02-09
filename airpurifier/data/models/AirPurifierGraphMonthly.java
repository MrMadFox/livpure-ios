package com.livpure.safedrink.airpurifier.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AirPurifierGraphMonthly.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphMonthly;", "", "date", "", "indoor", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphIndoor;", "outdoor", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphOutdoor;", "(Ljava/lang/String;Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphIndoor;Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphOutdoor;)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getIndoor", "()Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphIndoor;", "setIndoor", "(Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphIndoor;)V", "getOutdoor", "()Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphOutdoor;", "setOutdoor", "(Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphOutdoor;)V", "component1", "component2", "component3", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AirPurifierGraphMonthly {
    private String date;
    private AirPurifierGraphIndoor indoor;
    private AirPurifierGraphOutdoor outdoor;

    public static /* synthetic */ AirPurifierGraphMonthly copy$default(AirPurifierGraphMonthly airPurifierGraphMonthly, String str, AirPurifierGraphIndoor airPurifierGraphIndoor, AirPurifierGraphOutdoor airPurifierGraphOutdoor, int i, Object obj) {
        if ((i & 1) != 0) {
            str = airPurifierGraphMonthly.date;
        }
        if ((i & 2) != 0) {
            airPurifierGraphIndoor = airPurifierGraphMonthly.indoor;
        }
        if ((i & 4) != 0) {
            airPurifierGraphOutdoor = airPurifierGraphMonthly.outdoor;
        }
        return airPurifierGraphMonthly.copy(str, airPurifierGraphIndoor, airPurifierGraphOutdoor);
    }

    public final String component1() {
        return this.date;
    }

    public final AirPurifierGraphIndoor component2() {
        return this.indoor;
    }

    public final AirPurifierGraphOutdoor component3() {
        return this.outdoor;
    }

    public final AirPurifierGraphMonthly copy(String str, AirPurifierGraphIndoor indoor, AirPurifierGraphOutdoor outdoor) {
        Intrinsics.checkNotNullParameter(indoor, "indoor");
        Intrinsics.checkNotNullParameter(outdoor, "outdoor");
        return new AirPurifierGraphMonthly(str, indoor, outdoor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AirPurifierGraphMonthly) {
            AirPurifierGraphMonthly airPurifierGraphMonthly = (AirPurifierGraphMonthly) obj;
            return Intrinsics.areEqual(this.date, airPurifierGraphMonthly.date) && Intrinsics.areEqual(this.indoor, airPurifierGraphMonthly.indoor) && Intrinsics.areEqual(this.outdoor, airPurifierGraphMonthly.outdoor);
        }
        return false;
    }

    public int hashCode() {
        String str = this.date;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.indoor.hashCode()) * 31) + this.outdoor.hashCode();
    }

    public String toString() {
        return "AirPurifierGraphMonthly(date=" + this.date + ", indoor=" + this.indoor + ", outdoor=" + this.outdoor + ')';
    }

    public AirPurifierGraphMonthly(String str, AirPurifierGraphIndoor indoor, AirPurifierGraphOutdoor outdoor) {
        Intrinsics.checkNotNullParameter(indoor, "indoor");
        Intrinsics.checkNotNullParameter(outdoor, "outdoor");
        this.date = str;
        this.indoor = indoor;
        this.outdoor = outdoor;
    }

    public /* synthetic */ AirPurifierGraphMonthly(String str, AirPurifierGraphIndoor airPurifierGraphIndoor, AirPurifierGraphOutdoor airPurifierGraphOutdoor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, airPurifierGraphIndoor, airPurifierGraphOutdoor);
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        this.date = str;
    }

    public final AirPurifierGraphIndoor getIndoor() {
        return this.indoor;
    }

    public final void setIndoor(AirPurifierGraphIndoor airPurifierGraphIndoor) {
        Intrinsics.checkNotNullParameter(airPurifierGraphIndoor, "<set-?>");
        this.indoor = airPurifierGraphIndoor;
    }

    public final AirPurifierGraphOutdoor getOutdoor() {
        return this.outdoor;
    }

    public final void setOutdoor(AirPurifierGraphOutdoor airPurifierGraphOutdoor) {
        Intrinsics.checkNotNullParameter(airPurifierGraphOutdoor, "<set-?>");
        this.outdoor = airPurifierGraphOutdoor;
    }
}

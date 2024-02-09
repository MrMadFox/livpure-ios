package com.livpure.safedrink.airpurifier.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AirPurifierGraphDaily.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J:\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006'"}, d2 = {"Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphDaily;", "", "date", "", "hour", "", "indoor", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphIndoor;", "outdoor", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphOutdoor;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphIndoor;Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphOutdoor;)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getHour", "()Ljava/lang/Integer;", "setHour", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIndoor", "()Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphIndoor;", "setIndoor", "(Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphIndoor;)V", "getOutdoor", "()Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphOutdoor;", "setOutdoor", "(Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphOutdoor;)V", "component1", "component2", "component3", "component4", MoEPushConstants.ACTION_COPY, "(Ljava/lang/String;Ljava/lang/Integer;Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphIndoor;Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphOutdoor;)Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphDaily;", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AirPurifierGraphDaily {
    private String date;
    private Integer hour;
    private AirPurifierGraphIndoor indoor;
    private AirPurifierGraphOutdoor outdoor;

    public static /* synthetic */ AirPurifierGraphDaily copy$default(AirPurifierGraphDaily airPurifierGraphDaily, String str, Integer num, AirPurifierGraphIndoor airPurifierGraphIndoor, AirPurifierGraphOutdoor airPurifierGraphOutdoor, int i, Object obj) {
        if ((i & 1) != 0) {
            str = airPurifierGraphDaily.date;
        }
        if ((i & 2) != 0) {
            num = airPurifierGraphDaily.hour;
        }
        if ((i & 4) != 0) {
            airPurifierGraphIndoor = airPurifierGraphDaily.indoor;
        }
        if ((i & 8) != 0) {
            airPurifierGraphOutdoor = airPurifierGraphDaily.outdoor;
        }
        return airPurifierGraphDaily.copy(str, num, airPurifierGraphIndoor, airPurifierGraphOutdoor);
    }

    public final String component1() {
        return this.date;
    }

    public final Integer component2() {
        return this.hour;
    }

    public final AirPurifierGraphIndoor component3() {
        return this.indoor;
    }

    public final AirPurifierGraphOutdoor component4() {
        return this.outdoor;
    }

    public final AirPurifierGraphDaily copy(String str, Integer num, AirPurifierGraphIndoor indoor, AirPurifierGraphOutdoor outdoor) {
        Intrinsics.checkNotNullParameter(indoor, "indoor");
        Intrinsics.checkNotNullParameter(outdoor, "outdoor");
        return new AirPurifierGraphDaily(str, num, indoor, outdoor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AirPurifierGraphDaily) {
            AirPurifierGraphDaily airPurifierGraphDaily = (AirPurifierGraphDaily) obj;
            return Intrinsics.areEqual(this.date, airPurifierGraphDaily.date) && Intrinsics.areEqual(this.hour, airPurifierGraphDaily.hour) && Intrinsics.areEqual(this.indoor, airPurifierGraphDaily.indoor) && Intrinsics.areEqual(this.outdoor, airPurifierGraphDaily.outdoor);
        }
        return false;
    }

    public int hashCode() {
        String str = this.date;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.hour;
        return ((((hashCode + (num != null ? num.hashCode() : 0)) * 31) + this.indoor.hashCode()) * 31) + this.outdoor.hashCode();
    }

    public String toString() {
        return "AirPurifierGraphDaily(date=" + this.date + ", hour=" + this.hour + ", indoor=" + this.indoor + ", outdoor=" + this.outdoor + ')';
    }

    public AirPurifierGraphDaily(String str, Integer num, AirPurifierGraphIndoor indoor, AirPurifierGraphOutdoor outdoor) {
        Intrinsics.checkNotNullParameter(indoor, "indoor");
        Intrinsics.checkNotNullParameter(outdoor, "outdoor");
        this.date = str;
        this.hour = num;
        this.indoor = indoor;
        this.outdoor = outdoor;
    }

    public /* synthetic */ AirPurifierGraphDaily(String str, Integer num, AirPurifierGraphIndoor airPurifierGraphIndoor, AirPurifierGraphOutdoor airPurifierGraphOutdoor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, num, airPurifierGraphIndoor, airPurifierGraphOutdoor);
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        this.date = str;
    }

    public final Integer getHour() {
        return this.hour;
    }

    public final void setHour(Integer num) {
        this.hour = num;
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

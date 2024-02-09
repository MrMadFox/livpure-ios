package com.livpure.safedrink.airpurifier.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AirPurifierGraphOutdoor.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphOutdoor;", "", "pm2_5", "", "humidity", "temperature", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHumidity", "()Ljava/lang/Integer;", "setHumidity", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPm2_5", "setPm2_5", "getTemperature", "setTemperature", "component1", "component2", "component3", MoEPushConstants.ACTION_COPY, "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierGraphOutdoor;", "equals", "", "other", "hashCode", "toString", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AirPurifierGraphOutdoor {
    private Integer humidity;
    private Integer pm2_5;
    private Integer temperature;

    public static /* synthetic */ AirPurifierGraphOutdoor copy$default(AirPurifierGraphOutdoor airPurifierGraphOutdoor, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = airPurifierGraphOutdoor.pm2_5;
        }
        if ((i & 2) != 0) {
            num2 = airPurifierGraphOutdoor.humidity;
        }
        if ((i & 4) != 0) {
            num3 = airPurifierGraphOutdoor.temperature;
        }
        return airPurifierGraphOutdoor.copy(num, num2, num3);
    }

    public final Integer component1() {
        return this.pm2_5;
    }

    public final Integer component2() {
        return this.humidity;
    }

    public final Integer component3() {
        return this.temperature;
    }

    public final AirPurifierGraphOutdoor copy(Integer num, Integer num2, Integer num3) {
        return new AirPurifierGraphOutdoor(num, num2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AirPurifierGraphOutdoor) {
            AirPurifierGraphOutdoor airPurifierGraphOutdoor = (AirPurifierGraphOutdoor) obj;
            return Intrinsics.areEqual(this.pm2_5, airPurifierGraphOutdoor.pm2_5) && Intrinsics.areEqual(this.humidity, airPurifierGraphOutdoor.humidity) && Intrinsics.areEqual(this.temperature, airPurifierGraphOutdoor.temperature);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.pm2_5;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.humidity;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.temperature;
        return hashCode2 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        return "AirPurifierGraphOutdoor(pm2_5=" + this.pm2_5 + ", humidity=" + this.humidity + ", temperature=" + this.temperature + ')';
    }

    public AirPurifierGraphOutdoor(Integer num, Integer num2, Integer num3) {
        this.pm2_5 = num;
        this.humidity = num2;
        this.temperature = num3;
    }

    public final Integer getPm2_5() {
        return this.pm2_5;
    }

    public final void setPm2_5(Integer num) {
        this.pm2_5 = num;
    }

    public final Integer getHumidity() {
        return this.humidity;
    }

    public final void setHumidity(Integer num) {
        this.humidity = num;
    }

    public final Integer getTemperature() {
        return this.temperature;
    }

    public final void setTemperature(Integer num) {
        this.temperature = num;
    }
}

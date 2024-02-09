package com.livpure.safedrink.dispenser.data.models;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DispenserDeviceStatus.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\\\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0091\u0002\u0010^\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010b\u001a\u00020cHÖ\u0001J\t\u0010d\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001dR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001dR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u0010\u001dR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001dR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u0010\u001dR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001b\"\u0004\b9\u0010\u001dR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001dR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001b\"\u0004\b=\u0010\u001dR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001b\"\u0004\b?\u0010\u001dR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001b\"\u0004\bA\u0010\u001dR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001b\"\u0004\bC\u0010\u001dR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001b\"\u0004\bE\u0010\u001dR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001b\"\u0004\bG\u0010\u001d¨\u0006e"}, d2 = {"Lcom/livpure/safedrink/dispenser/data/models/DispenserDeviceStatus;", "", "imeiNo", "", "dispense", "pm2_5", "mode", "tdsSpeed", "disinfection", "tempSettings", "temperature", "humidity", "tvoc", "runningTime", "countDown", "countDownRem", "faultAlert", "filterLife", "machineStatus", "validityStatus", "validityDate", "daysCount", "version", "rf", "lastUpdatedDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountDown", "()Ljava/lang/String;", "setCountDown", "(Ljava/lang/String;)V", "getCountDownRem", "setCountDownRem", "getDaysCount", "setDaysCount", "getDisinfection", "setDisinfection", "getDispense", "setDispense", "getFaultAlert", "setFaultAlert", "getFilterLife", "setFilterLife", "getHumidity", "setHumidity", "getImeiNo", "setImeiNo", "getLastUpdatedDate", "setLastUpdatedDate", "getMachineStatus", "setMachineStatus", "getMode", "setMode", "getPm2_5", "setPm2_5", "getRf", "setRf", "getRunningTime", "setRunningTime", "getTdsSpeed", "setTdsSpeed", "getTempSettings", "setTempSettings", "getTemperature", "setTemperature", "getTvoc", "setTvoc", "getValidityDate", "setValidityDate", "getValidityStatus", "setValidityStatus", "getVersion", "setVersion", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DispenserDeviceStatus {
    private String countDown;
    private String countDownRem;
    private String daysCount;
    private String disinfection;
    private String dispense;
    private String faultAlert;
    private String filterLife;
    private String humidity;
    private String imeiNo;
    private String lastUpdatedDate;
    private String machineStatus;
    private String mode;
    private String pm2_5;
    private String rf;
    private String runningTime;
    private String tdsSpeed;
    private String tempSettings;
    private String temperature;
    private String tvoc;
    private String validityDate;
    private String validityStatus;
    private String version;

    public DispenserDeviceStatus() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
    }

    public final String component1() {
        return this.imeiNo;
    }

    public final String component10() {
        return this.tvoc;
    }

    public final String component11() {
        return this.runningTime;
    }

    public final String component12() {
        return this.countDown;
    }

    public final String component13() {
        return this.countDownRem;
    }

    public final String component14() {
        return this.faultAlert;
    }

    public final String component15() {
        return this.filterLife;
    }

    public final String component16() {
        return this.machineStatus;
    }

    public final String component17() {
        return this.validityStatus;
    }

    public final String component18() {
        return this.validityDate;
    }

    public final String component19() {
        return this.daysCount;
    }

    public final String component2() {
        return this.dispense;
    }

    public final String component20() {
        return this.version;
    }

    public final String component21() {
        return this.rf;
    }

    public final String component22() {
        return this.lastUpdatedDate;
    }

    public final String component3() {
        return this.pm2_5;
    }

    public final String component4() {
        return this.mode;
    }

    public final String component5() {
        return this.tdsSpeed;
    }

    public final String component6() {
        return this.disinfection;
    }

    public final String component7() {
        return this.tempSettings;
    }

    public final String component8() {
        return this.temperature;
    }

    public final String component9() {
        return this.humidity;
    }

    public final DispenserDeviceStatus copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22) {
        return new DispenserDeviceStatus(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DispenserDeviceStatus) {
            DispenserDeviceStatus dispenserDeviceStatus = (DispenserDeviceStatus) obj;
            return Intrinsics.areEqual(this.imeiNo, dispenserDeviceStatus.imeiNo) && Intrinsics.areEqual(this.dispense, dispenserDeviceStatus.dispense) && Intrinsics.areEqual(this.pm2_5, dispenserDeviceStatus.pm2_5) && Intrinsics.areEqual(this.mode, dispenserDeviceStatus.mode) && Intrinsics.areEqual(this.tdsSpeed, dispenserDeviceStatus.tdsSpeed) && Intrinsics.areEqual(this.disinfection, dispenserDeviceStatus.disinfection) && Intrinsics.areEqual(this.tempSettings, dispenserDeviceStatus.tempSettings) && Intrinsics.areEqual(this.temperature, dispenserDeviceStatus.temperature) && Intrinsics.areEqual(this.humidity, dispenserDeviceStatus.humidity) && Intrinsics.areEqual(this.tvoc, dispenserDeviceStatus.tvoc) && Intrinsics.areEqual(this.runningTime, dispenserDeviceStatus.runningTime) && Intrinsics.areEqual(this.countDown, dispenserDeviceStatus.countDown) && Intrinsics.areEqual(this.countDownRem, dispenserDeviceStatus.countDownRem) && Intrinsics.areEqual(this.faultAlert, dispenserDeviceStatus.faultAlert) && Intrinsics.areEqual(this.filterLife, dispenserDeviceStatus.filterLife) && Intrinsics.areEqual(this.machineStatus, dispenserDeviceStatus.machineStatus) && Intrinsics.areEqual(this.validityStatus, dispenserDeviceStatus.validityStatus) && Intrinsics.areEqual(this.validityDate, dispenserDeviceStatus.validityDate) && Intrinsics.areEqual(this.daysCount, dispenserDeviceStatus.daysCount) && Intrinsics.areEqual(this.version, dispenserDeviceStatus.version) && Intrinsics.areEqual(this.rf, dispenserDeviceStatus.rf) && Intrinsics.areEqual(this.lastUpdatedDate, dispenserDeviceStatus.lastUpdatedDate);
        }
        return false;
    }

    public int hashCode() {
        String str = this.imeiNo;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.dispense;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.pm2_5;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.mode;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.tdsSpeed;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.disinfection;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.tempSettings;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.temperature;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.humidity;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.tvoc;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.runningTime;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.countDown;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.countDownRem;
        int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.faultAlert;
        int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.filterLife;
        int hashCode15 = (hashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.machineStatus;
        int hashCode16 = (hashCode15 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.validityStatus;
        int hashCode17 = (hashCode16 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.validityDate;
        int hashCode18 = (hashCode17 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.daysCount;
        int hashCode19 = (hashCode18 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.version;
        int hashCode20 = (hashCode19 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.rf;
        int hashCode21 = (hashCode20 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.lastUpdatedDate;
        return hashCode21 + (str22 != null ? str22.hashCode() : 0);
    }

    public String toString() {
        return "DispenserDeviceStatus(imeiNo=" + this.imeiNo + ", dispense=" + this.dispense + ", pm2_5=" + this.pm2_5 + ", mode=" + this.mode + ", tdsSpeed=" + this.tdsSpeed + ", disinfection=" + this.disinfection + ", tempSettings=" + this.tempSettings + ", temperature=" + this.temperature + ", humidity=" + this.humidity + ", tvoc=" + this.tvoc + ", runningTime=" + this.runningTime + ", countDown=" + this.countDown + ", countDownRem=" + this.countDownRem + ", faultAlert=" + this.faultAlert + ", filterLife=" + this.filterLife + ", machineStatus=" + this.machineStatus + ", validityStatus=" + this.validityStatus + ", validityDate=" + this.validityDate + ", daysCount=" + this.daysCount + ", version=" + this.version + ", rf=" + this.rf + ", lastUpdatedDate=" + this.lastUpdatedDate + ')';
    }

    public DispenserDeviceStatus(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22) {
        this.imeiNo = str;
        this.dispense = str2;
        this.pm2_5 = str3;
        this.mode = str4;
        this.tdsSpeed = str5;
        this.disinfection = str6;
        this.tempSettings = str7;
        this.temperature = str8;
        this.humidity = str9;
        this.tvoc = str10;
        this.runningTime = str11;
        this.countDown = str12;
        this.countDownRem = str13;
        this.faultAlert = str14;
        this.filterLife = str15;
        this.machineStatus = str16;
        this.validityStatus = str17;
        this.validityDate = str18;
        this.daysCount = str19;
        this.version = str20;
        this.rf = str21;
        this.lastUpdatedDate = str22;
    }

    public /* synthetic */ DispenserDeviceStatus(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) != 0 ? "" : str10, (i & 1024) != 0 ? "" : str11, (i & 2048) != 0 ? "" : str12, (i & 4096) != 0 ? "" : str13, (i & 8192) != 0 ? "" : str14, (i & 16384) != 0 ? "" : str15, (i & 32768) != 0 ? "" : str16, (i & 65536) != 0 ? "" : str17, (i & 131072) != 0 ? "" : str18, (i & 262144) != 0 ? "" : str19, (i & 524288) != 0 ? "" : str20, (i & 1048576) != 0 ? "" : str21, (i & 2097152) != 0 ? "" : str22);
    }

    public final String getImeiNo() {
        return this.imeiNo;
    }

    public final void setImeiNo(String str) {
        this.imeiNo = str;
    }

    public final String getDispense() {
        return this.dispense;
    }

    public final void setDispense(String str) {
        this.dispense = str;
    }

    public final String getPm2_5() {
        return this.pm2_5;
    }

    public final void setPm2_5(String str) {
        this.pm2_5 = str;
    }

    public final String getMode() {
        return this.mode;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    public final String getTdsSpeed() {
        return this.tdsSpeed;
    }

    public final void setTdsSpeed(String str) {
        this.tdsSpeed = str;
    }

    public final String getDisinfection() {
        return this.disinfection;
    }

    public final void setDisinfection(String str) {
        this.disinfection = str;
    }

    public final String getTempSettings() {
        return this.tempSettings;
    }

    public final void setTempSettings(String str) {
        this.tempSettings = str;
    }

    public final String getTemperature() {
        return this.temperature;
    }

    public final void setTemperature(String str) {
        this.temperature = str;
    }

    public final String getHumidity() {
        return this.humidity;
    }

    public final void setHumidity(String str) {
        this.humidity = str;
    }

    public final String getTvoc() {
        return this.tvoc;
    }

    public final void setTvoc(String str) {
        this.tvoc = str;
    }

    public final String getRunningTime() {
        return this.runningTime;
    }

    public final void setRunningTime(String str) {
        this.runningTime = str;
    }

    public final String getCountDown() {
        return this.countDown;
    }

    public final void setCountDown(String str) {
        this.countDown = str;
    }

    public final String getCountDownRem() {
        return this.countDownRem;
    }

    public final void setCountDownRem(String str) {
        this.countDownRem = str;
    }

    public final String getFaultAlert() {
        return this.faultAlert;
    }

    public final void setFaultAlert(String str) {
        this.faultAlert = str;
    }

    public final String getFilterLife() {
        return this.filterLife;
    }

    public final void setFilterLife(String str) {
        this.filterLife = str;
    }

    public final String getMachineStatus() {
        return this.machineStatus;
    }

    public final void setMachineStatus(String str) {
        this.machineStatus = str;
    }

    public final String getValidityStatus() {
        return this.validityStatus;
    }

    public final void setValidityStatus(String str) {
        this.validityStatus = str;
    }

    public final String getValidityDate() {
        return this.validityDate;
    }

    public final void setValidityDate(String str) {
        this.validityDate = str;
    }

    public final String getDaysCount() {
        return this.daysCount;
    }

    public final void setDaysCount(String str) {
        this.daysCount = str;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final String getRf() {
        return this.rf;
    }

    public final void setRf(String str) {
        this.rf = str;
    }

    public final String getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    public final void setLastUpdatedDate(String str) {
        this.lastUpdatedDate = str;
    }
}

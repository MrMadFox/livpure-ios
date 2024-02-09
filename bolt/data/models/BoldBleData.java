package com.livpure.safedrink.bolt.data.models;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BoldBleData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b<\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÃ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jí\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020CHÖ\u0001J\t\u0010D\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018¨\u0006E"}, d2 = {"Lcom/livpure/safedrink/bolt/data/models/BoldBleData;", "", "location", "", "rfSignal", "dcn", "simNumber", "versionNumber", "sub", "va", "flowRate", "roControlStatus", "flowStatus", "lowPressureSwitch", "pumpStatus", "remainingLitre", "totalLitreFiltered", "remainingFilterLife", "faultsAsPerTable", "tamperCondition", "rtcTime", "dailyWaterConsume", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDailyWaterConsume", "()Ljava/lang/String;", "getDcn", "getFaultsAsPerTable", "getFlowRate", "getFlowStatus", "getLocation", "getLowPressureSwitch", "getPumpStatus", "getRemainingFilterLife", "getRemainingLitre", "getRfSignal", "getRoControlStatus", "getRtcTime", "getSimNumber", "getSub", "getTamperCondition", "getTotalLitreFiltered", "getVa", "getVersionNumber", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BoldBleData {
    @SerializedName("DWC")
    private final String dailyWaterConsume;
    @SerializedName("DCN")
    private final String dcn;
    @SerializedName("OT")
    private final String faultsAsPerTable;
    @SerializedName("FR")
    private final String flowRate;
    @SerializedName("FS")
    private final String flowStatus;
    @SerializedName("LC")
    private final String location;
    @SerializedName("LPS")
    private final String lowPressureSwitch;
    @SerializedName("PS")
    private final String pumpStatus;
    @SerializedName("IT")
    private final String remainingFilterLife;
    @SerializedName("RL")
    private final String remainingLitre;
    @SerializedName("RF")
    private final String rfSignal;
    @SerializedName("RCS")
    private final String roControlStatus;
    @SerializedName("GRTC")
    private final String rtcTime;
    @SerializedName("SIM")
    private final String simNumber;
    @SerializedName("SUB")
    private final String sub;
    @SerializedName(ExifInterface.GPS_DIRECTION_TRUE)
    private final String tamperCondition;
    @SerializedName("TL")
    private final String totalLitreFiltered;
    @SerializedName("VA")
    private final String va;
    @SerializedName(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)
    private final String versionNumber;

    public final String component1() {
        return this.location;
    }

    public final String component10() {
        return this.flowStatus;
    }

    public final String component11() {
        return this.lowPressureSwitch;
    }

    public final String component12() {
        return this.pumpStatus;
    }

    public final String component13() {
        return this.remainingLitre;
    }

    public final String component14() {
        return this.totalLitreFiltered;
    }

    public final String component15() {
        return this.remainingFilterLife;
    }

    public final String component16() {
        return this.faultsAsPerTable;
    }

    public final String component17() {
        return this.tamperCondition;
    }

    public final String component18() {
        return this.rtcTime;
    }

    public final String component19() {
        return this.dailyWaterConsume;
    }

    public final String component2() {
        return this.rfSignal;
    }

    public final String component3() {
        return this.dcn;
    }

    public final String component4() {
        return this.simNumber;
    }

    public final String component5() {
        return this.versionNumber;
    }

    public final String component6() {
        return this.sub;
    }

    public final String component7() {
        return this.va;
    }

    public final String component8() {
        return this.flowRate;
    }

    public final String component9() {
        return this.roControlStatus;
    }

    public final BoldBleData copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19) {
        return new BoldBleData(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BoldBleData) {
            BoldBleData boldBleData = (BoldBleData) obj;
            return Intrinsics.areEqual(this.location, boldBleData.location) && Intrinsics.areEqual(this.rfSignal, boldBleData.rfSignal) && Intrinsics.areEqual(this.dcn, boldBleData.dcn) && Intrinsics.areEqual(this.simNumber, boldBleData.simNumber) && Intrinsics.areEqual(this.versionNumber, boldBleData.versionNumber) && Intrinsics.areEqual(this.sub, boldBleData.sub) && Intrinsics.areEqual(this.va, boldBleData.va) && Intrinsics.areEqual(this.flowRate, boldBleData.flowRate) && Intrinsics.areEqual(this.roControlStatus, boldBleData.roControlStatus) && Intrinsics.areEqual(this.flowStatus, boldBleData.flowStatus) && Intrinsics.areEqual(this.lowPressureSwitch, boldBleData.lowPressureSwitch) && Intrinsics.areEqual(this.pumpStatus, boldBleData.pumpStatus) && Intrinsics.areEqual(this.remainingLitre, boldBleData.remainingLitre) && Intrinsics.areEqual(this.totalLitreFiltered, boldBleData.totalLitreFiltered) && Intrinsics.areEqual(this.remainingFilterLife, boldBleData.remainingFilterLife) && Intrinsics.areEqual(this.faultsAsPerTable, boldBleData.faultsAsPerTable) && Intrinsics.areEqual(this.tamperCondition, boldBleData.tamperCondition) && Intrinsics.areEqual(this.rtcTime, boldBleData.rtcTime) && Intrinsics.areEqual(this.dailyWaterConsume, boldBleData.dailyWaterConsume);
        }
        return false;
    }

    public int hashCode() {
        String str = this.location;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.rfSignal;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.dcn;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.simNumber;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.versionNumber;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.sub;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.va;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.flowRate;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.roControlStatus;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.flowStatus;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.lowPressureSwitch;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.pumpStatus;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.remainingLitre;
        int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.totalLitreFiltered;
        int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.remainingFilterLife;
        int hashCode15 = (hashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.faultsAsPerTable;
        int hashCode16 = (hashCode15 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.tamperCondition;
        int hashCode17 = (hashCode16 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.rtcTime;
        int hashCode18 = (hashCode17 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.dailyWaterConsume;
        return hashCode18 + (str19 != null ? str19.hashCode() : 0);
    }

    public String toString() {
        return "BoldBleData(location=" + this.location + ", rfSignal=" + this.rfSignal + ", dcn=" + this.dcn + ", simNumber=" + this.simNumber + ", versionNumber=" + this.versionNumber + ", sub=" + this.sub + ", va=" + this.va + ", flowRate=" + this.flowRate + ", roControlStatus=" + this.roControlStatus + ", flowStatus=" + this.flowStatus + ", lowPressureSwitch=" + this.lowPressureSwitch + ", pumpStatus=" + this.pumpStatus + ", remainingLitre=" + this.remainingLitre + ", totalLitreFiltered=" + this.totalLitreFiltered + ", remainingFilterLife=" + this.remainingFilterLife + ", faultsAsPerTable=" + this.faultsAsPerTable + ", tamperCondition=" + this.tamperCondition + ", rtcTime=" + this.rtcTime + ", dailyWaterConsume=" + this.dailyWaterConsume + ')';
    }

    public BoldBleData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19) {
        this.location = str;
        this.rfSignal = str2;
        this.dcn = str3;
        this.simNumber = str4;
        this.versionNumber = str5;
        this.sub = str6;
        this.va = str7;
        this.flowRate = str8;
        this.roControlStatus = str9;
        this.flowStatus = str10;
        this.lowPressureSwitch = str11;
        this.pumpStatus = str12;
        this.remainingLitre = str13;
        this.totalLitreFiltered = str14;
        this.remainingFilterLife = str15;
        this.faultsAsPerTable = str16;
        this.tamperCondition = str17;
        this.rtcTime = str18;
        this.dailyWaterConsume = str19;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getRfSignal() {
        return this.rfSignal;
    }

    public final String getDcn() {
        return this.dcn;
    }

    public final String getSimNumber() {
        return this.simNumber;
    }

    public final String getVersionNumber() {
        return this.versionNumber;
    }

    public final String getSub() {
        return this.sub;
    }

    public final String getVa() {
        return this.va;
    }

    public final String getFlowRate() {
        return this.flowRate;
    }

    public final String getRoControlStatus() {
        return this.roControlStatus;
    }

    public final String getFlowStatus() {
        return this.flowStatus;
    }

    public final String getLowPressureSwitch() {
        return this.lowPressureSwitch;
    }

    public final String getPumpStatus() {
        return this.pumpStatus;
    }

    public final String getRemainingLitre() {
        return this.remainingLitre;
    }

    public final String getTotalLitreFiltered() {
        return this.totalLitreFiltered;
    }

    public final String getRemainingFilterLife() {
        return this.remainingFilterLife;
    }

    public final String getFaultsAsPerTable() {
        return this.faultsAsPerTable;
    }

    public final String getTamperCondition() {
        return this.tamperCondition;
    }

    public final String getRtcTime() {
        return this.rtcTime;
    }

    public final String getDailyWaterConsume() {
        return this.dailyWaterConsume;
    }
}

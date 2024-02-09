package com.livpure.safedrink.subscription.plan.data;

import com.moengage.pushbase.MoEPushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DispenserRoSetting.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\\\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bÿ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jµ\u0002\u0010^\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010b\u001a\u00020cHÖ\u0001J\t\u0010d\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010 R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001e\"\u0004\b1\u0010 R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001e\"\u0004\b3\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001e\"\u0004\b7\u0010 R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001eR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001e\"\u0004\b:\u0010 R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u001eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001e\"\u0004\b=\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001eR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001e\"\u0004\b@\u0010 R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u001eR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010 ¨\u0006e"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/DispenserRoSetting;", "", "despensing", "", "coldWaterDespensing", "warmWater", "hotWater", "coldWater", "tds", "inputTds", "tank", "uv", "fault", "faultCode", "heaterStatus", "coolingStatus", "bottleDisinfection", "tankUV", "coldTankStatus", "compressorButtonStatus", "collectionFloatStatus", "condenserFanSpeed", "evaporaterFanSpeed", "temperature", "humidity", "feelsLikeZone", "waterGenerationStatus", "quietModeStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBottleDisinfection", "()Ljava/lang/String;", "setBottleDisinfection", "(Ljava/lang/String;)V", "getColdTankStatus", "setColdTankStatus", "getColdWater", "getColdWaterDespensing", "getCollectionFloatStatus", "setCollectionFloatStatus", "getCompressorButtonStatus", "setCompressorButtonStatus", "getCondenserFanSpeed", "setCondenserFanSpeed", "getCoolingStatus", "getDespensing", "getEvaporaterFanSpeed", "setEvaporaterFanSpeed", "getFault", "getFaultCode", "setFaultCode", "getFeelsLikeZone", "setFeelsLikeZone", "getHeaterStatus", "getHotWater", "getHumidity", "setHumidity", "getInputTds", "getQuietModeStatus", "setQuietModeStatus", "getTank", "getTankUV", "setTankUV", "getTds", "getTemperature", "setTemperature", "getUv", "getWarmWater", "getWaterGenerationStatus", "setWaterGenerationStatus", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", MoEPushConstants.ACTION_COPY, "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DispenserRoSetting {
    private String bottleDisinfection;
    private String coldTankStatus;
    private final String coldWater;
    private final String coldWaterDespensing;
    private String collectionFloatStatus;
    private String compressorButtonStatus;
    private String condenserFanSpeed;
    private final String coolingStatus;
    private final String despensing;
    private String evaporaterFanSpeed;
    private final String fault;
    private String faultCode;
    private String feelsLikeZone;
    private final String heaterStatus;
    private final String hotWater;
    private String humidity;
    private final String inputTds;
    private String quietModeStatus;
    private final String tank;
    private String tankUV;
    private final String tds;
    private String temperature;
    private final String uv;
    private final String warmWater;
    private String waterGenerationStatus;

    public final String component1() {
        return this.despensing;
    }

    public final String component10() {
        return this.fault;
    }

    public final String component11() {
        return this.faultCode;
    }

    public final String component12() {
        return this.heaterStatus;
    }

    public final String component13() {
        return this.coolingStatus;
    }

    public final String component14() {
        return this.bottleDisinfection;
    }

    public final String component15() {
        return this.tankUV;
    }

    public final String component16() {
        return this.coldTankStatus;
    }

    public final String component17() {
        return this.compressorButtonStatus;
    }

    public final String component18() {
        return this.collectionFloatStatus;
    }

    public final String component19() {
        return this.condenserFanSpeed;
    }

    public final String component2() {
        return this.coldWaterDespensing;
    }

    public final String component20() {
        return this.evaporaterFanSpeed;
    }

    public final String component21() {
        return this.temperature;
    }

    public final String component22() {
        return this.humidity;
    }

    public final String component23() {
        return this.feelsLikeZone;
    }

    public final String component24() {
        return this.waterGenerationStatus;
    }

    public final String component25() {
        return this.quietModeStatus;
    }

    public final String component3() {
        return this.warmWater;
    }

    public final String component4() {
        return this.hotWater;
    }

    public final String component5() {
        return this.coldWater;
    }

    public final String component6() {
        return this.tds;
    }

    public final String component7() {
        return this.inputTds;
    }

    public final String component8() {
        return this.tank;
    }

    public final String component9() {
        return this.uv;
    }

    public final DispenserRoSetting copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25) {
        return new DispenserRoSetting(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DispenserRoSetting) {
            DispenserRoSetting dispenserRoSetting = (DispenserRoSetting) obj;
            return Intrinsics.areEqual(this.despensing, dispenserRoSetting.despensing) && Intrinsics.areEqual(this.coldWaterDespensing, dispenserRoSetting.coldWaterDespensing) && Intrinsics.areEqual(this.warmWater, dispenserRoSetting.warmWater) && Intrinsics.areEqual(this.hotWater, dispenserRoSetting.hotWater) && Intrinsics.areEqual(this.coldWater, dispenserRoSetting.coldWater) && Intrinsics.areEqual(this.tds, dispenserRoSetting.tds) && Intrinsics.areEqual(this.inputTds, dispenserRoSetting.inputTds) && Intrinsics.areEqual(this.tank, dispenserRoSetting.tank) && Intrinsics.areEqual(this.uv, dispenserRoSetting.uv) && Intrinsics.areEqual(this.fault, dispenserRoSetting.fault) && Intrinsics.areEqual(this.faultCode, dispenserRoSetting.faultCode) && Intrinsics.areEqual(this.heaterStatus, dispenserRoSetting.heaterStatus) && Intrinsics.areEqual(this.coolingStatus, dispenserRoSetting.coolingStatus) && Intrinsics.areEqual(this.bottleDisinfection, dispenserRoSetting.bottleDisinfection) && Intrinsics.areEqual(this.tankUV, dispenserRoSetting.tankUV) && Intrinsics.areEqual(this.coldTankStatus, dispenserRoSetting.coldTankStatus) && Intrinsics.areEqual(this.compressorButtonStatus, dispenserRoSetting.compressorButtonStatus) && Intrinsics.areEqual(this.collectionFloatStatus, dispenserRoSetting.collectionFloatStatus) && Intrinsics.areEqual(this.condenserFanSpeed, dispenserRoSetting.condenserFanSpeed) && Intrinsics.areEqual(this.evaporaterFanSpeed, dispenserRoSetting.evaporaterFanSpeed) && Intrinsics.areEqual(this.temperature, dispenserRoSetting.temperature) && Intrinsics.areEqual(this.humidity, dispenserRoSetting.humidity) && Intrinsics.areEqual(this.feelsLikeZone, dispenserRoSetting.feelsLikeZone) && Intrinsics.areEqual(this.waterGenerationStatus, dispenserRoSetting.waterGenerationStatus) && Intrinsics.areEqual(this.quietModeStatus, dispenserRoSetting.quietModeStatus);
        }
        return false;
    }

    public int hashCode() {
        String str = this.despensing;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.coldWaterDespensing;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.warmWater;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.hotWater;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.coldWater;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.tds;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.inputTds;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.tank;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.uv;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.fault;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.faultCode;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.heaterStatus;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.coolingStatus;
        int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.bottleDisinfection;
        int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.tankUV;
        int hashCode15 = (hashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.coldTankStatus;
        int hashCode16 = (hashCode15 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.compressorButtonStatus;
        int hashCode17 = (hashCode16 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.collectionFloatStatus;
        int hashCode18 = (hashCode17 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.condenserFanSpeed;
        int hashCode19 = (hashCode18 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.evaporaterFanSpeed;
        int hashCode20 = (hashCode19 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.temperature;
        int hashCode21 = (hashCode20 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.humidity;
        int hashCode22 = (hashCode21 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.feelsLikeZone;
        int hashCode23 = (hashCode22 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.waterGenerationStatus;
        int hashCode24 = (hashCode23 + (str24 == null ? 0 : str24.hashCode())) * 31;
        String str25 = this.quietModeStatus;
        return hashCode24 + (str25 != null ? str25.hashCode() : 0);
    }

    public String toString() {
        return "DispenserRoSetting(despensing=" + this.despensing + ", coldWaterDespensing=" + this.coldWaterDespensing + ", warmWater=" + this.warmWater + ", hotWater=" + this.hotWater + ", coldWater=" + this.coldWater + ", tds=" + this.tds + ", inputTds=" + this.inputTds + ", tank=" + this.tank + ", uv=" + this.uv + ", fault=" + this.fault + ", faultCode=" + this.faultCode + ", heaterStatus=" + this.heaterStatus + ", coolingStatus=" + this.coolingStatus + ", bottleDisinfection=" + this.bottleDisinfection + ", tankUV=" + this.tankUV + ", coldTankStatus=" + this.coldTankStatus + ", compressorButtonStatus=" + this.compressorButtonStatus + ", collectionFloatStatus=" + this.collectionFloatStatus + ", condenserFanSpeed=" + this.condenserFanSpeed + ", evaporaterFanSpeed=" + this.evaporaterFanSpeed + ", temperature=" + this.temperature + ", humidity=" + this.humidity + ", feelsLikeZone=" + this.feelsLikeZone + ", waterGenerationStatus=" + this.waterGenerationStatus + ", quietModeStatus=" + this.quietModeStatus + ')';
    }

    public DispenserRoSetting(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25) {
        this.despensing = str;
        this.coldWaterDespensing = str2;
        this.warmWater = str3;
        this.hotWater = str4;
        this.coldWater = str5;
        this.tds = str6;
        this.inputTds = str7;
        this.tank = str8;
        this.uv = str9;
        this.fault = str10;
        this.faultCode = str11;
        this.heaterStatus = str12;
        this.coolingStatus = str13;
        this.bottleDisinfection = str14;
        this.tankUV = str15;
        this.coldTankStatus = str16;
        this.compressorButtonStatus = str17;
        this.collectionFloatStatus = str18;
        this.condenserFanSpeed = str19;
        this.evaporaterFanSpeed = str20;
        this.temperature = str21;
        this.humidity = str22;
        this.feelsLikeZone = str23;
        this.waterGenerationStatus = str24;
        this.quietModeStatus = str25;
    }

    public final String getDespensing() {
        return this.despensing;
    }

    public final String getColdWaterDespensing() {
        return this.coldWaterDespensing;
    }

    public final String getWarmWater() {
        return this.warmWater;
    }

    public final String getHotWater() {
        return this.hotWater;
    }

    public final String getColdWater() {
        return this.coldWater;
    }

    public final String getTds() {
        return this.tds;
    }

    public final String getInputTds() {
        return this.inputTds;
    }

    public final String getTank() {
        return this.tank;
    }

    public final String getUv() {
        return this.uv;
    }

    public final String getFault() {
        return this.fault;
    }

    public final String getFaultCode() {
        return this.faultCode;
    }

    public final void setFaultCode(String str) {
        this.faultCode = str;
    }

    public final String getHeaterStatus() {
        return this.heaterStatus;
    }

    public final String getCoolingStatus() {
        return this.coolingStatus;
    }

    public final String getBottleDisinfection() {
        return this.bottleDisinfection;
    }

    public final void setBottleDisinfection(String str) {
        this.bottleDisinfection = str;
    }

    public final String getTankUV() {
        return this.tankUV;
    }

    public final void setTankUV(String str) {
        this.tankUV = str;
    }

    public final String getColdTankStatus() {
        return this.coldTankStatus;
    }

    public final void setColdTankStatus(String str) {
        this.coldTankStatus = str;
    }

    public final String getCompressorButtonStatus() {
        return this.compressorButtonStatus;
    }

    public final void setCompressorButtonStatus(String str) {
        this.compressorButtonStatus = str;
    }

    public final String getCollectionFloatStatus() {
        return this.collectionFloatStatus;
    }

    public final void setCollectionFloatStatus(String str) {
        this.collectionFloatStatus = str;
    }

    public final String getCondenserFanSpeed() {
        return this.condenserFanSpeed;
    }

    public final void setCondenserFanSpeed(String str) {
        this.condenserFanSpeed = str;
    }

    public final String getEvaporaterFanSpeed() {
        return this.evaporaterFanSpeed;
    }

    public final void setEvaporaterFanSpeed(String str) {
        this.evaporaterFanSpeed = str;
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

    public final String getFeelsLikeZone() {
        return this.feelsLikeZone;
    }

    public final void setFeelsLikeZone(String str) {
        this.feelsLikeZone = str;
    }

    public final String getWaterGenerationStatus() {
        return this.waterGenerationStatus;
    }

    public final void setWaterGenerationStatus(String str) {
        this.waterGenerationStatus = str;
    }

    public final String getQuietModeStatus() {
        return this.quietModeStatus;
    }

    public final void setQuietModeStatus(String str) {
        this.quietModeStatus = str;
    }
}

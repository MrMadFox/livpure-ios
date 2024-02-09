package com.livpure.safedrink.subscription.plan.data.model.dashboard;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.gson.annotations.SerializedName;
import com.livpure.safedrink.MyBarDataSet;
import com.livpure.safedrink.subscription.plan.data.DispenserRoSetting;
import com.livpure.safedrink.subscription.plan.data.model.FaultCodeDetails;
import com.livpure.safedrink.subscription.plan.data.model.FirmwareDetails;
import com.livpure.safedrink.subscription.plan.data.model.SubscriptionDetails;
import com.moengage.pushbase.MoEPushConstants;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
/* compiled from: DashboardDetails.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001cJ\t\u00107\u001a\u00020\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010A\u001a\u00020\u0007HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010C\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0011\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003JÄ\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010GJ\u0013\u0010H\u001a\u00020\u00032\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J&\u0010J\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0011\u0012\f\u0012\n\u0012\u0004\u0012\u00020L\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00070KJ(\u0010M\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010\u00112\u0016\u0010N\u001a\u0012\u0012\u0004\u0012\u00020P0Oj\b\u0012\u0004\u0012\u00020P`QH\u0002J\t\u0010R\u001a\u00020PHÖ\u0001J\t\u0010S\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010+R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006T"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/DashboardDetails;", "", "isPlanChangeAllowed", "", "usage", "Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/UsageStats;", "planStatus", "", "balance", "Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/BalanceInfo;", "lastSyncDate", "scanSerialNo", "subscriptionDetails", "Lcom/livpure/safedrink/subscription/plan/data/model/SubscriptionDetails;", "dispenserRoSetting", "Lcom/livpure/safedrink/subscription/plan/data/DispenserRoSetting;", "dailyConsumptionList", "", "Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/DailyConsumptionItem;", "productStats", "Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/ProductStats;", "firmwareDetails", "Lcom/livpure/safedrink/subscription/plan/data/model/FirmwareDetails;", "faultCodeDetails", "Lcom/livpure/safedrink/subscription/plan/data/model/FaultCodeDetails;", "device_IMEI_Number", "device_Connectivity", "device_Serial_Number", "(ZLcom/livpure/safedrink/subscription/plan/data/model/dashboard/UsageStats;Ljava/lang/String;Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/BalanceInfo;Ljava/lang/String;Ljava/lang/Boolean;Lcom/livpure/safedrink/subscription/plan/data/model/SubscriptionDetails;Lcom/livpure/safedrink/subscription/plan/data/DispenserRoSetting;Ljava/util/List;Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/ProductStats;Lcom/livpure/safedrink/subscription/plan/data/model/FirmwareDetails;Lcom/livpure/safedrink/subscription/plan/data/model/FaultCodeDetails;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBalance", "()Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/BalanceInfo;", "getDailyConsumptionList", "()Ljava/util/List;", "getDevice_Connectivity", "()Ljava/lang/String;", "getDevice_IMEI_Number", "getDevice_Serial_Number", "getDispenserRoSetting", "()Lcom/livpure/safedrink/subscription/plan/data/DispenserRoSetting;", "getFaultCodeDetails", "()Lcom/livpure/safedrink/subscription/plan/data/model/FaultCodeDetails;", "getFirmwareDetails", "()Lcom/livpure/safedrink/subscription/plan/data/model/FirmwareDetails;", "()Z", "getLastSyncDate", "getPlanStatus", "getProductStats", "()Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/ProductStats;", "getScanSerialNo", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSubscriptionDetails", "()Lcom/livpure/safedrink/subscription/plan/data/model/SubscriptionDetails;", "getUsage", "()Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/UsageStats;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", MoEPushConstants.ACTION_COPY, "(ZLcom/livpure/safedrink/subscription/plan/data/model/dashboard/UsageStats;Ljava/lang/String;Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/BalanceInfo;Ljava/lang/String;Ljava/lang/Boolean;Lcom/livpure/safedrink/subscription/plan/data/model/SubscriptionDetails;Lcom/livpure/safedrink/subscription/plan/data/DispenserRoSetting;Ljava/util/List;Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/ProductStats;Lcom/livpure/safedrink/subscription/plan/data/model/FirmwareDetails;Lcom/livpure/safedrink/subscription/plan/data/model/FaultCodeDetails;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/livpure/safedrink/subscription/plan/data/model/dashboard/DashboardDetails;", "equals", "other", "getConsumptionData", "Lkotlin/Triple;", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "getDataSet", "list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "hashCode", "toString", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DashboardDetails {
    private final BalanceInfo balance;
    @SerializedName("consumption")
    private final List<DailyConsumptionItem> dailyConsumptionList;
    @SerializedName("connectivity")
    private final String device_Connectivity;
    @SerializedName("imeiNo")
    private final String device_IMEI_Number;
    @SerializedName("serialNo")
    private final String device_Serial_Number;
    @SerializedName("roSetting")
    private final DispenserRoSetting dispenserRoSetting;
    private final FaultCodeDetails faultCodeDetails;
    private final FirmwareDetails firmwareDetails;
    @SerializedName("planChange")
    private final boolean isPlanChangeAllowed;
    private final String lastSyncDate;
    private final String planStatus;
    @SerializedName("filterLife")
    private final ProductStats productStats;
    private final Boolean scanSerialNo;
    @SerializedName("message")
    private final SubscriptionDetails subscriptionDetails;
    private final UsageStats usage;

    public final boolean component1() {
        return this.isPlanChangeAllowed;
    }

    public final ProductStats component10() {
        return this.productStats;
    }

    public final FirmwareDetails component11() {
        return this.firmwareDetails;
    }

    public final FaultCodeDetails component12() {
        return this.faultCodeDetails;
    }

    public final String component13() {
        return this.device_IMEI_Number;
    }

    public final String component14() {
        return this.device_Connectivity;
    }

    public final String component15() {
        return this.device_Serial_Number;
    }

    public final UsageStats component2() {
        return this.usage;
    }

    public final String component3() {
        return this.planStatus;
    }

    public final BalanceInfo component4() {
        return this.balance;
    }

    public final String component5() {
        return this.lastSyncDate;
    }

    public final Boolean component6() {
        return this.scanSerialNo;
    }

    public final SubscriptionDetails component7() {
        return this.subscriptionDetails;
    }

    public final DispenserRoSetting component8() {
        return this.dispenserRoSetting;
    }

    public final List<DailyConsumptionItem> component9() {
        return this.dailyConsumptionList;
    }

    public final DashboardDetails copy(boolean z, UsageStats usageStats, String str, BalanceInfo balanceInfo, String lastSyncDate, Boolean bool, SubscriptionDetails subscriptionDetails, DispenserRoSetting dispenserRoSetting, List<DailyConsumptionItem> list, ProductStats productStats, FirmwareDetails firmwareDetails, FaultCodeDetails faultCodeDetails, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(lastSyncDate, "lastSyncDate");
        return new DashboardDetails(z, usageStats, str, balanceInfo, lastSyncDate, bool, subscriptionDetails, dispenserRoSetting, list, productStats, firmwareDetails, faultCodeDetails, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DashboardDetails) {
            DashboardDetails dashboardDetails = (DashboardDetails) obj;
            return this.isPlanChangeAllowed == dashboardDetails.isPlanChangeAllowed && Intrinsics.areEqual(this.usage, dashboardDetails.usage) && Intrinsics.areEqual(this.planStatus, dashboardDetails.planStatus) && Intrinsics.areEqual(this.balance, dashboardDetails.balance) && Intrinsics.areEqual(this.lastSyncDate, dashboardDetails.lastSyncDate) && Intrinsics.areEqual(this.scanSerialNo, dashboardDetails.scanSerialNo) && Intrinsics.areEqual(this.subscriptionDetails, dashboardDetails.subscriptionDetails) && Intrinsics.areEqual(this.dispenserRoSetting, dashboardDetails.dispenserRoSetting) && Intrinsics.areEqual(this.dailyConsumptionList, dashboardDetails.dailyConsumptionList) && Intrinsics.areEqual(this.productStats, dashboardDetails.productStats) && Intrinsics.areEqual(this.firmwareDetails, dashboardDetails.firmwareDetails) && Intrinsics.areEqual(this.faultCodeDetails, dashboardDetails.faultCodeDetails) && Intrinsics.areEqual(this.device_IMEI_Number, dashboardDetails.device_IMEI_Number) && Intrinsics.areEqual(this.device_Connectivity, dashboardDetails.device_Connectivity) && Intrinsics.areEqual(this.device_Serial_Number, dashboardDetails.device_Serial_Number);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    public int hashCode() {
        boolean z = this.isPlanChangeAllowed;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        UsageStats usageStats = this.usage;
        int hashCode = (i + (usageStats == null ? 0 : usageStats.hashCode())) * 31;
        String str = this.planStatus;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        BalanceInfo balanceInfo = this.balance;
        int hashCode3 = (((hashCode2 + (balanceInfo == null ? 0 : balanceInfo.hashCode())) * 31) + this.lastSyncDate.hashCode()) * 31;
        Boolean bool = this.scanSerialNo;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        SubscriptionDetails subscriptionDetails = this.subscriptionDetails;
        int hashCode5 = (hashCode4 + (subscriptionDetails == null ? 0 : subscriptionDetails.hashCode())) * 31;
        DispenserRoSetting dispenserRoSetting = this.dispenserRoSetting;
        int hashCode6 = (hashCode5 + (dispenserRoSetting == null ? 0 : dispenserRoSetting.hashCode())) * 31;
        List<DailyConsumptionItem> list = this.dailyConsumptionList;
        int hashCode7 = (hashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        ProductStats productStats = this.productStats;
        int hashCode8 = (hashCode7 + (productStats == null ? 0 : productStats.hashCode())) * 31;
        FirmwareDetails firmwareDetails = this.firmwareDetails;
        int hashCode9 = (hashCode8 + (firmwareDetails == null ? 0 : firmwareDetails.hashCode())) * 31;
        FaultCodeDetails faultCodeDetails = this.faultCodeDetails;
        int hashCode10 = (hashCode9 + (faultCodeDetails == null ? 0 : faultCodeDetails.hashCode())) * 31;
        String str2 = this.device_IMEI_Number;
        int hashCode11 = (hashCode10 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.device_Connectivity;
        int hashCode12 = (hashCode11 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.device_Serial_Number;
        return hashCode12 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "DashboardDetails(isPlanChangeAllowed=" + this.isPlanChangeAllowed + ", usage=" + this.usage + ", planStatus=" + this.planStatus + ", balance=" + this.balance + ", lastSyncDate=" + this.lastSyncDate + ", scanSerialNo=" + this.scanSerialNo + ", subscriptionDetails=" + this.subscriptionDetails + ", dispenserRoSetting=" + this.dispenserRoSetting + ", dailyConsumptionList=" + this.dailyConsumptionList + ", productStats=" + this.productStats + ", firmwareDetails=" + this.firmwareDetails + ", faultCodeDetails=" + this.faultCodeDetails + ", device_IMEI_Number=" + this.device_IMEI_Number + ", device_Connectivity=" + this.device_Connectivity + ", device_Serial_Number=" + this.device_Serial_Number + ')';
    }

    public DashboardDetails(boolean z, UsageStats usageStats, String str, BalanceInfo balanceInfo, String lastSyncDate, Boolean bool, SubscriptionDetails subscriptionDetails, DispenserRoSetting dispenserRoSetting, List<DailyConsumptionItem> list, ProductStats productStats, FirmwareDetails firmwareDetails, FaultCodeDetails faultCodeDetails, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(lastSyncDate, "lastSyncDate");
        this.isPlanChangeAllowed = z;
        this.usage = usageStats;
        this.planStatus = str;
        this.balance = balanceInfo;
        this.lastSyncDate = lastSyncDate;
        this.scanSerialNo = bool;
        this.subscriptionDetails = subscriptionDetails;
        this.dispenserRoSetting = dispenserRoSetting;
        this.dailyConsumptionList = list;
        this.productStats = productStats;
        this.firmwareDetails = firmwareDetails;
        this.faultCodeDetails = faultCodeDetails;
        this.device_IMEI_Number = str2;
        this.device_Connectivity = str3;
        this.device_Serial_Number = str4;
    }

    public final boolean isPlanChangeAllowed() {
        return this.isPlanChangeAllowed;
    }

    public final UsageStats getUsage() {
        return this.usage;
    }

    public final String getPlanStatus() {
        return this.planStatus;
    }

    public final BalanceInfo getBalance() {
        return this.balance;
    }

    public final String getLastSyncDate() {
        return this.lastSyncDate;
    }

    public final Boolean getScanSerialNo() {
        return this.scanSerialNo;
    }

    public final SubscriptionDetails getSubscriptionDetails() {
        return this.subscriptionDetails;
    }

    public final DispenserRoSetting getDispenserRoSetting() {
        return this.dispenserRoSetting;
    }

    public final List<DailyConsumptionItem> getDailyConsumptionList() {
        return this.dailyConsumptionList;
    }

    public final ProductStats getProductStats() {
        return this.productStats;
    }

    public final FirmwareDetails getFirmwareDetails() {
        return this.firmwareDetails;
    }

    public final FaultCodeDetails getFaultCodeDetails() {
        return this.faultCodeDetails;
    }

    public final String getDevice_IMEI_Number() {
        return this.device_IMEI_Number;
    }

    public final String getDevice_Connectivity() {
        return this.device_Connectivity;
    }

    public final String getDevice_Serial_Number() {
        return this.device_Serial_Number;
    }

    public final Triple<List<String>, List<IBarDataSet>, String> getConsumptionData() {
        int i;
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        List<DailyConsumptionItem> list = this.dailyConsumptionList;
        if (list != null) {
            i = 0;
            for (DailyConsumptionItem dailyConsumptionItem : list) {
                if (!Intrinsics.areEqual(dailyConsumptionItem.getDateString(), "")) {
                    try {
                        String substring = dailyConsumptionItem.getDateString().substring(5, 7);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                        String str = new DateFormatSymbols().getMonths()[Integer.parseInt(substring) - 1];
                        Intrinsics.checkNotNullExpressionValue(str, "DateFormatSymbols().months[monthNumber - 1]");
                        String substring2 = str.substring(0, 3);
                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        String substring3 = dailyConsumptionItem.getDateString().substring(8, 10);
                        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                        arrayList2.add(substring2 + " - " + substring3);
                        if (dailyConsumptionItem.getLitres() != null) {
                            arrayList.add(Integer.valueOf(Integer.parseInt(dailyConsumptionItem.getLitres())));
                            i += Integer.parseInt(dailyConsumptionItem.getLitres());
                        } else {
                            arrayList.add(0);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        } else {
            i = 0;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(i / 7)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        List<IBarDataSet> dataSet = getDataSet(arrayList);
        return new Triple<>(arrayList2, dataSet, "Average Water Consumption in a Week : " + format + " litres");
    }

    private final List<IBarDataSet> getDataSet(ArrayList<Integer> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        MyBarDataSet myBarDataSet = new MyBarDataSet(arrayList2, "");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(new BarEntry(arrayList.get(i).intValue(), i));
        }
        arrayList3.add(myBarDataSet);
        return arrayList3;
    }
}

package com.livpure.safedrink.airpurifier.model;

import androidx.arch.core.util.Function;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.facebook.appevents.AppEventsConstants;
import com.github.mikephil.charting.data.Entry;
import com.livpure.safedrink.R;
import com.livpure.safedrink.airpurifier.data.AirPurifierCommandsRespository;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierBLEStatus;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierCommand;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierDashboardDetails;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierData;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierDevice;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierDeviceStatus;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierGraph;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierGraphDaily;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierGraphMonthly;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierGraphOutdoor;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierGraphWeekly;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierPlanDetails;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierPublishCommand;
import com.livpure.safedrink.airpurifier.data.models.ImageStatus;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.bolt.data.models.BoltCommandsResponse;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
/* compiled from: HomePurifierModel.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010}\u001a\u00020~2\u0006\u0010\u007f\u001a\u00020\u0004J1\u0010\u0080\u0001\u001a,\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010?\u0012\f\u0012\n\u0012\u0004\u0012\u00020@\u0018\u00010?\u0012\f\u0012\n\u0012\u0004\u0012\u00020@\u0018\u00010?0>J\u0007\u0010\u0081\u0001\u001a\u00020~J1\u0010\u0082\u0001\u001a,\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010?\u0012\f\u0012\n\u0012\u0004\u0012\u00020@\u0018\u00010?\u0012\f\u0012\n\u0012\u0004\u0012\u00020@\u0018\u00010?0>J\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020/0$J1\u0010\u0084\u0001\u001a,\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010?\u0012\f\u0012\n\u0012\u0004\u0012\u00020@\u0018\u00010?\u0012\f\u0012\n\u0012\u0004\u0012\u00020@\u0018\u00010?0>J\"\u0010\u0085\u0001\u001a\u00020~2\u0007\u0010\u0086\u0001\u001a\u00020\u00042\u0007\u0010\u0087\u0001\u001a\u00020\u00042\u0007\u0010\u0088\u0001\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R \u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010*\u001a\b\u0012\u0004\u0012\u00020%0$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001a\u00103\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001a\u00106\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u00040$¢\u0006\b\n\u0000\u001a\u0004\b:\u0010'R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040 ¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\"RJ\u0010=\u001a2\u0012.\u0012,\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010?\u0012\f\u0012\n\u0012\u0004\u0012\u00020@\u0018\u00010?\u0012\f\u0012\n\u0012\u0004\u0012\u00020@\u0018\u00010?0>0$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010'\"\u0004\bB\u0010)R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020D0 X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010F\u001a\u0004\u0018\u00010\u00102\b\u0010E\u001a\u0004\u0018\u00010\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0012\"\u0004\bH\u0010\u0014R\u001a\u0010I\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040 ¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\"R\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00040 ¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\"R\u000e\u0010P\u001a\u00020QX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010R\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00040 ¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\"R\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020X0$¢\u0006\b\n\u0000\u001a\u0004\bY\u0010'R\u001a\u0010Z\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0006\"\u0004\b\\\u0010\bR\u0017\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00040 ¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\"R\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00040 ¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\"R\u0017\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00040 ¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\"R\u0017\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00040 ¢\u0006\b\n\u0000\u001a\u0004\bd\u0010\"R\u0017\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00040 ¢\u0006\b\n\u0000\u001a\u0004\bf\u0010\"R\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020Q0$¢\u0006\b\n\u0000\u001a\u0004\bh\u0010'R\u001b\u0010i\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\u001e\u001a\u0004\bj\u0010\u001cR\u0017\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040 ¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\"R\u001a\u0010n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0006\"\u0004\bp\u0010\bR\u0017\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00040 ¢\u0006\b\n\u0000\u001a\u0004\br\u0010\"R\u0017\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00040 ¢\u0006\b\n\u0000\u001a\u0004\bt\u0010\"R\u0017\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00040 ¢\u0006\b\n\u0000\u001a\u0004\bv\u0010\"R \u0010w\u001a\b\u0012\u0004\u0012\u00020%0$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010'\"\u0004\by\u0010)R \u0010z\u001a\b\u0012\u0004\u0012\u00020%0$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010'\"\u0004\b|\u0010)¨\u0006\u0089\u0001"}, d2 = {"Lcom/livpure/safedrink/airpurifier/model/HomePurifierModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "IonStatus", "", "getIonStatus", "()Ljava/lang/String;", "setIonStatus", "(Ljava/lang/String;)V", "PowerOnStatus", "getPowerOnStatus", "setPowerOnStatus", "SleepStatus", "getSleepStatus", "setSleepStatus", "_device", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "get_device", "()Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "set_device", "(Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;)V", "airCommand", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierPublishCommand;", "airPurifierCommand", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierCommand;", "airPurifierCommandsRespository", "Lcom/livpure/safedrink/airpurifier/data/AirPurifierCommandsRespository;", "getAirPurifierCommandsRespository", "()Lcom/livpure/safedrink/airpurifier/data/AirPurifierCommandsRespository;", "airPurifierCommandsRespository$delegate", "Lkotlin/Lazy;", "balanceAmount", "Landroidx/lifecycle/MutableLiveData;", "getBalanceAmount", "()Landroidx/lifecycle/MutableLiveData;", "bleImage", "Landroidx/lifecycle/LiveData;", "", "getBleImage", "()Landroidx/lifecycle/LiveData;", "setBleImage", "(Landroidx/lifecycle/LiveData;)V", "bleImageOff", "getBleImageOff", "setBleImageOff", "boltCommandsResponse", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/livpure/safedrink/bolt/data/models/BoltCommandsResponse;", "buzzer", "getBuzzer", "setBuzzer", "childLockStatus", "getChildLockStatus", "setChildLockStatus", "connectivity", "getConnectivity", "setConnectivity", "connectivityStatus", "getConnectivityStatus", "countDownRem", "getCountDownRem", "dailyUsageStats", "Lkotlin/Triple;", "Ljava/util/ArrayList;", "Lcom/github/mikephil/charting/data/Entry;", "getDailyUsageStats", "setDailyUsageStats", "dashboardData", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDashboardDetails;", "value", AndroidContextPlugin.DEVICE_KEY, "getDevice", "setDevice", "fanSpeedStatus", "getFanSpeedStatus", "setFanSpeedStatus", "filterLife", "getFilterLife", "humidityTest", "getHumidityTest", "imageStatus", "Lcom/livpure/safedrink/airpurifier/data/models/ImageStatus;", "imeiNumber", "getImeiNumber", "setImeiNumber", "lastSyncText", "getLastSyncText", "loadingStatus", "", "getLoadingStatus", "modeStatus", "getModeStatus", "setModeStatus", "outdoorHumidity", "getOutdoorHumidity", "outdoorTemperature", "getOutdoorTemperature", "outdoor_pm2_5Text", "getOutdoor_pm2_5Text", "planName", "getPlanName", "pm2_5Text", "getPm2_5Text", "powerOnStatusImage", "getPowerOnStatusImage", "repository", "getRepository", "repository$delegate", "runningTime", "getRunningTime", "serialNumber", "getSerialNumber", "setSerialNumber", "temperatureText", "getTemperatureText", "tvocText", "getTvocText", "validityDateText", "getValidityDateText", "wifiImage", "getWifiImage", "setWifiImage", "wifiImageOff", "getWifiImageOff", "setWifiImageOff", "bleStatus", "", "status", "getDailyGraphData", "getDashboardDetails", "getMonthlyGraphData", "getPendingBleCommand", "getWeeklyGraphData", "publishCommand", "command", "countdown", TransferTable.COLUMN_SPEED, "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomePurifierModel extends MediatorViewModel {
    private DeviceList _device;
    private AirPurifierPublishCommand airCommand;
    private AirPurifierCommand airPurifierCommand;
    private final MutableLiveData<String> balanceAmount;
    private LiveData<Integer> bleImage;
    private LiveData<Integer> bleImageOff;
    private final MediatorLiveData<BoltCommandsResponse> boltCommandsResponse;
    private final LiveData<String> connectivityStatus;
    private final MutableLiveData<String> countDownRem;
    private LiveData<Triple<ArrayList<String>, ArrayList<Entry>, ArrayList<Entry>>> dailyUsageStats;
    private final MutableLiveData<AirPurifierDashboardDetails> dashboardData;
    private DeviceList device;
    private final MutableLiveData<String> filterLife;
    private final MutableLiveData<String> humidityTest;
    private ImageStatus imageStatus;
    private final MutableLiveData<String> lastSyncText;
    private final LiveData<Boolean> loadingStatus;
    private final MutableLiveData<String> outdoorHumidity;
    private final MutableLiveData<String> outdoorTemperature;
    private final MutableLiveData<String> outdoor_pm2_5Text;
    private final MutableLiveData<String> planName;
    private final MutableLiveData<String> pm2_5Text;
    private final LiveData<ImageStatus> powerOnStatusImage;
    private final MutableLiveData<String> runningTime;
    private final MutableLiveData<String> temperatureText;
    private final MutableLiveData<String> tvocText;
    private final MutableLiveData<String> validityDateText;
    private LiveData<Integer> wifiImage;
    private LiveData<Integer> wifiImageOff;
    private final Lazy repository$delegate = LazyKt.lazy(new Function0<AirPurifierCommandsRespository>() { // from class: com.livpure.safedrink.airpurifier.model.HomePurifierModel$repository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AirPurifierCommandsRespository invoke() {
            return new AirPurifierCommandsRespository();
        }
    });
    private String imeiNumber = "";
    private String connectivity = "";
    private String buzzer = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private String PowerOnStatus = "";
    private String IonStatus = "";
    private String SleepStatus = "";
    private String fanSpeedStatus = "";
    private String modeStatus = "";
    private String serialNumber = "";
    private String childLockStatus = "";
    private final Lazy airPurifierCommandsRespository$delegate = LazyKt.lazy(new Function0<AirPurifierCommandsRespository>() { // from class: com.livpure.safedrink.airpurifier.model.HomePurifierModel$airPurifierCommandsRespository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AirPurifierCommandsRespository invoke() {
            return new AirPurifierCommandsRespository();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadingStatus$lambda-25  reason: not valid java name */
    public static final Boolean m219loadingStatus$lambda25(Boolean bool) {
        return bool;
    }

    public HomePurifierModel() {
        MutableLiveData<AirPurifierDashboardDetails> mutableLiveData = new MutableLiveData<>();
        this.dashboardData = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue("");
        this.lastSyncText = mutableLiveData2;
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        mutableLiveData3.setValue("");
        this.countDownRem = mutableLiveData3;
        MutableLiveData<String> mutableLiveData4 = new MutableLiveData<>();
        mutableLiveData4.setValue("");
        this.pm2_5Text = mutableLiveData4;
        MutableLiveData<String> mutableLiveData5 = new MutableLiveData<>();
        mutableLiveData5.setValue("");
        this.temperatureText = mutableLiveData5;
        MutableLiveData<String> mutableLiveData6 = new MutableLiveData<>();
        mutableLiveData6.setValue("");
        this.tvocText = mutableLiveData6;
        MutableLiveData<String> mutableLiveData7 = new MutableLiveData<>();
        mutableLiveData7.setValue("");
        this.humidityTest = mutableLiveData7;
        MutableLiveData<String> mutableLiveData8 = new MutableLiveData<>();
        mutableLiveData8.setValue("");
        this.validityDateText = mutableLiveData8;
        MutableLiveData<String> mutableLiveData9 = new MutableLiveData<>();
        mutableLiveData9.setValue("");
        this.runningTime = mutableLiveData9;
        MutableLiveData<String> mutableLiveData10 = new MutableLiveData<>();
        mutableLiveData10.setValue("");
        this.filterLife = mutableLiveData10;
        MutableLiveData<String> mutableLiveData11 = new MutableLiveData<>();
        mutableLiveData11.setValue("");
        this.balanceAmount = mutableLiveData11;
        MutableLiveData<String> mutableLiveData12 = new MutableLiveData<>();
        mutableLiveData12.setValue("");
        this.planName = mutableLiveData12;
        MutableLiveData<String> mutableLiveData13 = new MutableLiveData<>();
        mutableLiveData13.setValue("");
        this.outdoor_pm2_5Text = mutableLiveData13;
        MutableLiveData<String> mutableLiveData14 = new MutableLiveData<>();
        mutableLiveData14.setValue("");
        this.outdoorTemperature = mutableLiveData14;
        MutableLiveData<String> mutableLiveData15 = new MutableLiveData<>();
        mutableLiveData15.setValue("");
        this.outdoorHumidity = mutableLiveData15;
        this.boltCommandsResponse = new MediatorLiveData<>();
        LiveData<Triple<ArrayList<String>, ArrayList<Entry>, ArrayList<Entry>>> map = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.airpurifier.model.HomePurifierModel$$ExternalSyntheticLambda5
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Triple m216dailyUsageStats$lambda18;
                m216dailyUsageStats$lambda18 = HomePurifierModel.m216dailyUsageStats$lambda18((AirPurifierDashboardDetails) obj);
                return m216dailyUsageStats$lambda18;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(dashboardData) {\n   …ll, null)\n        }\n    }");
        this.dailyUsageStats = map;
        LiveData<ImageStatus> map2 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.airpurifier.model.HomePurifierModel$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                ImageStatus m220powerOnStatusImage$lambda19;
                m220powerOnStatusImage$lambda19 = HomePurifierModel.m220powerOnStatusImage$lambda19(HomePurifierModel.this, (AirPurifierDashboardDetails) obj);
                return m220powerOnStatusImage$lambda19;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "map(dashboardData) {\n   …ageStatus\n        }\n    }");
        this.powerOnStatusImage = map2;
        LiveData<Integer> map3 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.airpurifier.model.HomePurifierModel$$ExternalSyntheticLambda8
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m222wifiImage$lambda20;
                m222wifiImage$lambda20 = HomePurifierModel.m222wifiImage$lambda20((AirPurifierDashboardDetails) obj);
                return m222wifiImage$lambda20;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map3, "map(dashboardData) {\n        R.drawable.wifi\n    }");
        this.wifiImage = map3;
        LiveData<Integer> map4 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.airpurifier.model.HomePurifierModel$$ExternalSyntheticLambda6
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m212bleImage$lambda21;
                m212bleImage$lambda21 = HomePurifierModel.m212bleImage$lambda21((AirPurifierDashboardDetails) obj);
                return m212bleImage$lambda21;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map4, "map(dashboardData) {\n   ….drawable.bluetooth\n    }");
        this.bleImage = map4;
        LiveData<Integer> map5 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.airpurifier.model.HomePurifierModel$$ExternalSyntheticLambda4
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m223wifiImageOff$lambda22;
                m223wifiImageOff$lambda22 = HomePurifierModel.m223wifiImageOff$lambda22((AirPurifierDashboardDetails) obj);
                return m223wifiImageOff$lambda22;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map5, "map(dashboardData) {\n   …R.drawable.wifi_off\n    }");
        this.wifiImageOff = map5;
        LiveData<Integer> map6 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.airpurifier.model.HomePurifierModel$$ExternalSyntheticLambda3
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m213bleImageOff$lambda23;
                m213bleImageOff$lambda23 = HomePurifierModel.m213bleImageOff$lambda23((AirPurifierDashboardDetails) obj);
                return m213bleImageOff$lambda23;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map6, "map(dashboardData) {\n   …wable.bluetooth_off\n    }");
        this.bleImageOff = map6;
        LiveData<String> map7 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.airpurifier.model.HomePurifierModel$$ExternalSyntheticLambda7
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m215connectivityStatus$lambda24;
                m215connectivityStatus$lambda24 = HomePurifierModel.m215connectivityStatus$lambda24((AirPurifierDashboardDetails) obj);
                return m215connectivityStatus$lambda24;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map7, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.connectivityStatus = map7;
        LiveData<Boolean> map8 = Transformations.map(getLoading(), new Function() { // from class: com.livpure.safedrink.airpurifier.model.HomePurifierModel$$ExternalSyntheticLambda9
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m219loadingStatus$lambda25;
                m219loadingStatus$lambda25 = HomePurifierModel.m219loadingStatus$lambda25((Boolean) obj);
                return m219loadingStatus$lambda25;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map8, "map(loading) {\n        it\n    }");
        this.loadingStatus = map8;
    }

    private final AirPurifierCommandsRespository getRepository() {
        return (AirPurifierCommandsRespository) this.repository$delegate.getValue();
    }

    public final String getImeiNumber() {
        return this.imeiNumber;
    }

    public final void setImeiNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imeiNumber = str;
    }

    public final String getConnectivity() {
        return this.connectivity;
    }

    public final void setConnectivity(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.connectivity = str;
    }

    public final String getBuzzer() {
        return this.buzzer;
    }

    public final void setBuzzer(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.buzzer = str;
    }

    public final DeviceList get_device() {
        return this._device;
    }

    public final void set_device(DeviceList deviceList) {
        this._device = deviceList;
    }

    public final String getPowerOnStatus() {
        return this.PowerOnStatus;
    }

    public final void setPowerOnStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.PowerOnStatus = str;
    }

    public final String getIonStatus() {
        return this.IonStatus;
    }

    public final void setIonStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.IonStatus = str;
    }

    public final String getSleepStatus() {
        return this.SleepStatus;
    }

    public final void setSleepStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.SleepStatus = str;
    }

    public final String getFanSpeedStatus() {
        return this.fanSpeedStatus;
    }

    public final void setFanSpeedStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fanSpeedStatus = str;
    }

    public final String getModeStatus() {
        return this.modeStatus;
    }

    public final void setModeStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modeStatus = str;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final void setSerialNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serialNumber = str;
    }

    public final String getChildLockStatus() {
        return this.childLockStatus;
    }

    public final void setChildLockStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.childLockStatus = str;
    }

    private final AirPurifierCommandsRespository getAirPurifierCommandsRespository() {
        return (AirPurifierCommandsRespository) this.airPurifierCommandsRespository$delegate.getValue();
    }

    public final MutableLiveData<String> getLastSyncText() {
        return this.lastSyncText;
    }

    public final MutableLiveData<String> getCountDownRem() {
        return this.countDownRem;
    }

    public final MutableLiveData<String> getPm2_5Text() {
        return this.pm2_5Text;
    }

    public final MutableLiveData<String> getTemperatureText() {
        return this.temperatureText;
    }

    public final MutableLiveData<String> getTvocText() {
        return this.tvocText;
    }

    public final MutableLiveData<String> getHumidityTest() {
        return this.humidityTest;
    }

    public final MutableLiveData<String> getValidityDateText() {
        return this.validityDateText;
    }

    public final MutableLiveData<String> getRunningTime() {
        return this.runningTime;
    }

    public final MutableLiveData<String> getFilterLife() {
        return this.filterLife;
    }

    public final MutableLiveData<String> getBalanceAmount() {
        return this.balanceAmount;
    }

    public final MutableLiveData<String> getPlanName() {
        return this.planName;
    }

    public final MutableLiveData<String> getOutdoor_pm2_5Text() {
        return this.outdoor_pm2_5Text;
    }

    public final MutableLiveData<String> getOutdoorTemperature() {
        return this.outdoorTemperature;
    }

    public final MutableLiveData<String> getOutdoorHumidity() {
        return this.outdoorHumidity;
    }

    public final void publishCommand(String command, String countdown, String speed) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(countdown, "countdown");
        Intrinsics.checkNotNullParameter(speed, "speed");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            this.airCommand = new AirPurifierPublishCommand(command, this.buzzer, countdown, speed);
            String str = this.imeiNumber;
            AirPurifierPublishCommand airPurifierPublishCommand = this.airCommand;
            AirPurifierCommand airPurifierCommand = null;
            if (airPurifierPublishCommand == null) {
                Intrinsics.throwUninitializedPropertyAccessException("airCommand");
                airPurifierPublishCommand = null;
            }
            this.airPurifierCommand = new AirPurifierCommand(str, airPurifierPublishCommand);
            try {
                AirPurifierCommandsRespository airPurifierCommandsRespository = getAirPurifierCommandsRespository();
                AirPurifierCommand airPurifierCommand2 = this.airPurifierCommand;
                if (airPurifierCommand2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("airPurifierCommand");
                } else {
                    airPurifierCommand = airPurifierCommand2;
                }
                observeAndTrack(airPurifierCommandsRespository.sendAirPurifierCommand(airPurifierCommand), new Observer() { // from class: com.livpure.safedrink.airpurifier.model.HomePurifierModel$$ExternalSyntheticLambda1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomePurifierModel.m221publishCommand$lambda14(HomePurifierModel.this, (BaseDataHolder) obj);
                    }
                });
                return;
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! We faced an issue while fetching your dashboard details at this time."));
                return;
            }
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: publishCommand$lambda-14  reason: not valid java name */
    public static final void m221publishCommand$lambda14(HomePurifierModel this$0, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        if (StringsKt.equals$default(baseDataHolder.getMessage(), "timeout", false, 2, null)) {
            return;
        }
        this$0.getDashboardDetails();
    }

    public final void bleStatus(final String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getAirPurifierCommandsRespository().setSaveStatus(new AirPurifierBLEStatus(status, this.serialNumber)), new Observer() { // from class: com.livpure.safedrink.airpurifier.model.HomePurifierModel$$ExternalSyntheticLambda2
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomePurifierModel.m214bleStatus$lambda15(HomePurifierModel.this, status, (BaseDataHolder) obj);
                    }
                });
                return;
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! We faced an issue while fetching your dashboard details at this time."));
                return;
            }
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bleStatus$lambda-15  reason: not valid java name */
    public static final void m214bleStatus$lambda15(HomePurifierModel this$0, String status, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(status, "$status");
        this$0.getLoading().setValue(false);
        if (StringsKt.contains$default((CharSequence) status.toString(), (CharSequence) "\"ST\"", false, 2, (Object) null)) {
            this$0.getDashboardDetails();
        }
    }

    public final LiveData<BoltCommandsResponse> getPendingBleCommand() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            this.boltCommandsResponse.addSource(getAirPurifierCommandsRespository().getBlueToothCommand(new AirPurifierBLEStatus("", this.serialNumber)), new Observer() { // from class: com.livpure.safedrink.airpurifier.model.HomePurifierModel$$ExternalSyntheticLambda11
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomePurifierModel.m218getPendingBleCommand$lambda16(HomePurifierModel.this, (BaseDataHolder) obj);
                }
            });
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
        return this.boltCommandsResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPendingBleCommand$lambda-16  reason: not valid java name */
    public static final void m218getPendingBleCommand$lambda16(HomePurifierModel this$0, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (baseDataHolder.getData() != null) {
            this$0.boltCommandsResponse.setValue(baseDataHolder.getData());
            return;
        }
        MutableLiveData<Event<String>> toastMessageLiveData = this$0.getToastMessageLiveData();
        String message = baseDataHolder.getMessage();
        if (message == null) {
            message = "Sorry! We got an error while fetching all those plans.";
        }
        toastMessageLiveData.setValue(new Event<>(message));
    }

    public final void getDashboardDetails() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getAirPurifierCommandsRespository().getDashboardDetails(this.serialNumber), new Observer() { // from class: com.livpure.safedrink.airpurifier.model.HomePurifierModel$$ExternalSyntheticLambda10
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomePurifierModel.m217getDashboardDetails$lambda17(HomePurifierModel.this, (AirPurifierDashboardDetails) obj);
                    }
                });
                return;
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! We faced an issue while fetching your dashboard details at this time."));
                return;
            }
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getDashboardDetails$lambda-17  reason: not valid java name */
    public static final void m217getDashboardDetails$lambda17(final HomePurifierModel this$0, AirPurifierDashboardDetails airPurifierDashboardDetails) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponseAir(airPurifierDashboardDetails, new Function1<AirPurifierDashboardDetails, Unit>() { // from class: com.livpure.safedrink.airpurifier.model.HomePurifierModel$getDashboardDetails$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AirPurifierDashboardDetails airPurifierDashboardDetails2) {
                invoke2(airPurifierDashboardDetails2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(AirPurifierDashboardDetails successfulResponse) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                MutableLiveData mutableLiveData4;
                MutableLiveData mutableLiveData5;
                MutableLiveData mutableLiveData6;
                MutableLiveData mutableLiveData7;
                MutableLiveData mutableLiveData8;
                MutableLiveData mutableLiveData9;
                MutableLiveData mutableLiveData10;
                MutableLiveData mutableLiveData11;
                AirPurifierData airPurifierData;
                AirPurifierDevice device;
                AirPurifierDeviceStatus deviceStatus;
                MutableLiveData mutableLiveData12;
                MutableLiveData mutableLiveData13;
                MutableLiveData mutableLiveData14;
                MutableLiveData mutableLiveData15;
                MutableLiveData mutableLiveData16;
                MutableLiveData mutableLiveData17;
                MutableLiveData mutableLiveData18;
                MutableLiveData mutableLiveData19;
                AirPurifierData airPurifierData2;
                AirPurifierPlanDetails plan;
                AirPurifierData airPurifierData3;
                AirPurifierPlanDetails plan2;
                MutableLiveData mutableLiveData20;
                MutableLiveData mutableLiveData21;
                AirPurifierData airPurifierData4;
                AirPurifierDevice device2;
                AirPurifierDeviceStatus deviceStatus2;
                String filterLife;
                AirPurifierData airPurifierData5;
                AirPurifierDevice device3;
                AirPurifierDeviceStatus deviceStatus3;
                String filterLife2;
                AirPurifierData airPurifierData6;
                AirPurifierDevice device4;
                AirPurifierDeviceStatus deviceStatus4;
                String filterLife3;
                MutableLiveData mutableLiveData22;
                AirPurifierData airPurifierData7;
                AirPurifierDevice device5;
                AirPurifierDeviceStatus deviceStatus5;
                AirPurifierData airPurifierData8;
                AirPurifierDevice device6;
                AirPurifierDeviceStatus deviceStatus6;
                String runningTime;
                AirPurifierData airPurifierData9;
                AirPurifierDevice device7;
                AirPurifierDeviceStatus deviceStatus7;
                AirPurifierData airPurifierData10;
                AirPurifierDevice device8;
                AirPurifierDeviceStatus deviceStatus8;
                AirPurifierData airPurifierData11;
                AirPurifierDevice device9;
                AirPurifierDeviceStatus deviceStatus9;
                AirPurifierData airPurifierData12;
                AirPurifierDevice device10;
                AirPurifierDeviceStatus deviceStatus10;
                AirPurifierData airPurifierData13;
                AirPurifierDevice device11;
                AirPurifierDeviceStatus deviceStatus11;
                AirPurifierData airPurifierData14;
                AirPurifierDevice device12;
                AirPurifierGraphOutdoor outdoor;
                Integer humidity;
                AirPurifierData airPurifierData15;
                AirPurifierDevice device13;
                AirPurifierGraphOutdoor outdoor2;
                Integer temperature;
                AirPurifierData airPurifierData16;
                AirPurifierDevice device14;
                AirPurifierGraphOutdoor outdoor3;
                Integer pm2_5;
                AirPurifierData airPurifierData17;
                AirPurifierDevice device15;
                AirPurifierGraphOutdoor outdoor4;
                AirPurifierData airPurifierData18;
                AirPurifierDevice device16;
                AirPurifierGraphOutdoor outdoor5;
                AirPurifierData airPurifierData19;
                AirPurifierDevice device17;
                AirPurifierGraphOutdoor outdoor6;
                AirPurifierData airPurifierData20;
                AirPurifierDevice device18;
                AirPurifierDeviceStatus deviceStatus12;
                AirPurifierData airPurifierData21;
                AirPurifierDevice device19;
                AirPurifierDeviceStatus deviceStatus13;
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                mutableLiveData = HomePurifierModel.this.dashboardData;
                mutableLiveData.setValue(successfulResponse);
                MutableLiveData<String> lastSyncText = HomePurifierModel.this.getLastSyncText();
                mutableLiveData2 = HomePurifierModel.this.dashboardData;
                AirPurifierDashboardDetails airPurifierDashboardDetails2 = (AirPurifierDashboardDetails) mutableLiveData2.getValue();
                String str = null;
                lastSyncText.setValue((airPurifierDashboardDetails2 == null || (airPurifierData21 = airPurifierDashboardDetails2.getAirPurifierData()) == null || (device19 = airPurifierData21.getDevice()) == null || (deviceStatus13 = device19.getDeviceStatus()) == null) ? null : deviceStatus13.getLastUpdatedDate());
                MutableLiveData<String> pm2_5Text = HomePurifierModel.this.getPm2_5Text();
                mutableLiveData3 = HomePurifierModel.this.dashboardData;
                AirPurifierDashboardDetails airPurifierDashboardDetails3 = (AirPurifierDashboardDetails) mutableLiveData3.getValue();
                pm2_5Text.setValue((airPurifierDashboardDetails3 == null || (airPurifierData20 = airPurifierDashboardDetails3.getAirPurifierData()) == null || (device18 = airPurifierData20.getDevice()) == null || (deviceStatus12 = device18.getDeviceStatus()) == null) ? null : deviceStatus12.getPm2_5());
                MutableLiveData<String> outdoor_pm2_5Text = HomePurifierModel.this.getOutdoor_pm2_5Text();
                mutableLiveData4 = HomePurifierModel.this.dashboardData;
                AirPurifierDashboardDetails airPurifierDashboardDetails4 = (AirPurifierDashboardDetails) mutableLiveData4.getValue();
                outdoor_pm2_5Text.setValue(String.valueOf((airPurifierDashboardDetails4 == null || (airPurifierData19 = airPurifierDashboardDetails4.getAirPurifierData()) == null || (device17 = airPurifierData19.getDevice()) == null || (outdoor6 = device17.getOutdoor()) == null) ? null : outdoor6.getPm2_5()));
                MutableLiveData<String> outdoorTemperature = HomePurifierModel.this.getOutdoorTemperature();
                mutableLiveData5 = HomePurifierModel.this.dashboardData;
                AirPurifierDashboardDetails airPurifierDashboardDetails5 = (AirPurifierDashboardDetails) mutableLiveData5.getValue();
                outdoorTemperature.setValue(String.valueOf((airPurifierDashboardDetails5 == null || (airPurifierData18 = airPurifierDashboardDetails5.getAirPurifierData()) == null || (device16 = airPurifierData18.getDevice()) == null || (outdoor5 = device16.getOutdoor()) == null) ? null : outdoor5.getTemperature()));
                MutableLiveData<String> outdoorHumidity = HomePurifierModel.this.getOutdoorHumidity();
                mutableLiveData6 = HomePurifierModel.this.dashboardData;
                AirPurifierDashboardDetails airPurifierDashboardDetails6 = (AirPurifierDashboardDetails) mutableLiveData6.getValue();
                outdoorHumidity.setValue(String.valueOf((airPurifierDashboardDetails6 == null || (airPurifierData17 = airPurifierDashboardDetails6.getAirPurifierData()) == null || (device15 = airPurifierData17.getDevice()) == null || (outdoor4 = device15.getOutdoor()) == null) ? null : outdoor4.getHumidity()));
                mutableLiveData7 = HomePurifierModel.this.dashboardData;
                AirPurifierDashboardDetails airPurifierDashboardDetails7 = (AirPurifierDashboardDetails) mutableLiveData7.getValue();
                if (((airPurifierDashboardDetails7 == null || (airPurifierData16 = airPurifierDashboardDetails7.getAirPurifierData()) == null || (device14 = airPurifierData16.getDevice()) == null || (outdoor3 = device14.getOutdoor()) == null || (pm2_5 = outdoor3.getPm2_5()) == null) ? null : pm2_5.toString()) == null) {
                    HomePurifierModel.this.getOutdoor_pm2_5Text().setValue("--");
                }
                mutableLiveData8 = HomePurifierModel.this.dashboardData;
                AirPurifierDashboardDetails airPurifierDashboardDetails8 = (AirPurifierDashboardDetails) mutableLiveData8.getValue();
                if (((airPurifierDashboardDetails8 == null || (airPurifierData15 = airPurifierDashboardDetails8.getAirPurifierData()) == null || (device13 = airPurifierData15.getDevice()) == null || (outdoor2 = device13.getOutdoor()) == null || (temperature = outdoor2.getTemperature()) == null) ? null : temperature.toString()) == null) {
                    HomePurifierModel.this.getOutdoorTemperature().setValue("--");
                }
                mutableLiveData9 = HomePurifierModel.this.dashboardData;
                AirPurifierDashboardDetails airPurifierDashboardDetails9 = (AirPurifierDashboardDetails) mutableLiveData9.getValue();
                if (((airPurifierDashboardDetails9 == null || (airPurifierData14 = airPurifierDashboardDetails9.getAirPurifierData()) == null || (device12 = airPurifierData14.getDevice()) == null || (outdoor = device12.getOutdoor()) == null || (humidity = outdoor.getHumidity()) == null) ? null : humidity.toString()) == null) {
                    HomePurifierModel.this.getOutdoorHumidity().setValue("--");
                }
                mutableLiveData10 = HomePurifierModel.this.dashboardData;
                AirPurifierDashboardDetails airPurifierDashboardDetails10 = (AirPurifierDashboardDetails) mutableLiveData10.getValue();
                if (StringsKt.equals$default((airPurifierDashboardDetails10 == null || (airPurifierData13 = airPurifierDashboardDetails10.getAirPurifierData()) == null || (device11 = airPurifierData13.getDevice()) == null || (deviceStatus11 = device11.getDeviceStatus()) == null) ? null : deviceStatus11.getCountDown(), AppEventsConstants.EVENT_PARAM_VALUE_NO, false, 2, null)) {
                    HomePurifierModel.this.getCountDownRem().setValue("Time");
                } else {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm");
                    try {
                        mutableLiveData11 = HomePurifierModel.this.dashboardData;
                        AirPurifierDashboardDetails airPurifierDashboardDetails11 = (AirPurifierDashboardDetails) mutableLiveData11.getValue();
                        Date parse = simpleDateFormat.parse((airPurifierDashboardDetails11 == null || (airPurifierData = airPurifierDashboardDetails11.getAirPurifierData()) == null || (device = airPurifierData.getDevice()) == null || (deviceStatus = device.getDeviceStatus()) == null) ? null : deviceStatus.getCountDownRem());
                        Intrinsics.checkNotNullExpressionValue(parse, "sdf.parse(dashboardData.…viceStatus?.countDownRem)");
                        HomePurifierModel.this.getCountDownRem().setValue(new SimpleDateFormat("HH:mm").format(parse));
                    } catch (Exception unused) {
                        HomePurifierModel.this.getCountDownRem().setValue("Time");
                    }
                }
                MutableLiveData<String> temperatureText = HomePurifierModel.this.getTemperatureText();
                mutableLiveData12 = HomePurifierModel.this.dashboardData;
                AirPurifierDashboardDetails airPurifierDashboardDetails12 = (AirPurifierDashboardDetails) mutableLiveData12.getValue();
                temperatureText.setValue((airPurifierDashboardDetails12 == null || (airPurifierData12 = airPurifierDashboardDetails12.getAirPurifierData()) == null || (device10 = airPurifierData12.getDevice()) == null || (deviceStatus10 = device10.getDeviceStatus()) == null) ? null : deviceStatus10.getTemperature());
                MutableLiveData<String> tvocText = HomePurifierModel.this.getTvocText();
                mutableLiveData13 = HomePurifierModel.this.dashboardData;
                AirPurifierDashboardDetails airPurifierDashboardDetails13 = (AirPurifierDashboardDetails) mutableLiveData13.getValue();
                tvocText.setValue((airPurifierDashboardDetails13 == null || (airPurifierData11 = airPurifierDashboardDetails13.getAirPurifierData()) == null || (device9 = airPurifierData11.getDevice()) == null || (deviceStatus9 = device9.getDeviceStatus()) == null) ? null : deviceStatus9.getTvoc());
                MutableLiveData<String> humidityTest = HomePurifierModel.this.getHumidityTest();
                mutableLiveData14 = HomePurifierModel.this.dashboardData;
                AirPurifierDashboardDetails airPurifierDashboardDetails14 = (AirPurifierDashboardDetails) mutableLiveData14.getValue();
                humidityTest.setValue((airPurifierDashboardDetails14 == null || (airPurifierData10 = airPurifierDashboardDetails14.getAirPurifierData()) == null || (device8 = airPurifierData10.getDevice()) == null || (deviceStatus8 = device8.getDeviceStatus()) == null) ? null : deviceStatus8.getHumidity());
                MutableLiveData<String> validityDateText = HomePurifierModel.this.getValidityDateText();
                mutableLiveData15 = HomePurifierModel.this.dashboardData;
                AirPurifierDashboardDetails airPurifierDashboardDetails15 = (AirPurifierDashboardDetails) mutableLiveData15.getValue();
                validityDateText.setValue((airPurifierDashboardDetails15 == null || (airPurifierData9 = airPurifierDashboardDetails15.getAirPurifierData()) == null || (device7 = airPurifierData9.getDevice()) == null || (deviceStatus7 = device7.getDeviceStatus()) == null) ? null : deviceStatus7.getValidityDate());
                mutableLiveData16 = HomePurifierModel.this.dashboardData;
                AirPurifierDashboardDetails airPurifierDashboardDetails16 = (AirPurifierDashboardDetails) mutableLiveData16.getValue();
                if (((airPurifierDashboardDetails16 == null || (airPurifierData8 = airPurifierDashboardDetails16.getAirPurifierData()) == null || (device6 = airPurifierData8.getDevice()) == null || (deviceStatus6 = device6.getDeviceStatus()) == null || (runningTime = deviceStatus6.getRunningTime()) == null) ? null : runningTime.toString()) != null) {
                    mutableLiveData22 = HomePurifierModel.this.dashboardData;
                    AirPurifierDashboardDetails airPurifierDashboardDetails17 = (AirPurifierDashboardDetails) mutableLiveData22.getValue();
                    Long longOrNull = StringsKt.toLongOrNull(String.valueOf((airPurifierDashboardDetails17 == null || (airPurifierData7 = airPurifierDashboardDetails17.getAirPurifierData()) == null || (device5 = airPurifierData7.getDevice()) == null || (deviceStatus5 = device5.getDeviceStatus()) == null) ? null : deviceStatus5.getRunningTime()));
                    String valueOf = String.valueOf(longOrNull != null ? Long.valueOf(longOrNull.longValue() / 60) : null);
                    String valueOf2 = String.valueOf(longOrNull != null ? Long.valueOf(longOrNull.longValue() % 60) : null);
                    MutableLiveData<String> runningTime2 = HomePurifierModel.this.getRunningTime();
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("%s hr:%s min", Arrays.copyOf(new Object[]{"" + valueOf, "" + StringsKt.padStart(valueOf2, 2, '0')}, 2));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    runningTime2.setValue(format);
                }
                mutableLiveData17 = HomePurifierModel.this.dashboardData;
                AirPurifierDashboardDetails airPurifierDashboardDetails18 = (AirPurifierDashboardDetails) mutableLiveData17.getValue();
                if (((airPurifierDashboardDetails18 == null || (airPurifierData6 = airPurifierDashboardDetails18.getAirPurifierData()) == null || (device4 = airPurifierData6.getDevice()) == null || (deviceStatus4 = device4.getDeviceStatus()) == null || (filterLife3 = deviceStatus4.getFilterLife()) == null) ? null : filterLife3.toString()) != null) {
                    mutableLiveData20 = HomePurifierModel.this.dashboardData;
                    AirPurifierDashboardDetails airPurifierDashboardDetails19 = (AirPurifierDashboardDetails) mutableLiveData20.getValue();
                    if (!Intrinsics.areEqual((airPurifierDashboardDetails19 == null || (airPurifierData5 = airPurifierDashboardDetails19.getAirPurifierData()) == null || (device3 = airPurifierData5.getDevice()) == null || (deviceStatus3 = device3.getDeviceStatus()) == null || (filterLife2 = deviceStatus3.getFilterLife()) == null) ? null : filterLife2.toString(), "")) {
                        mutableLiveData21 = HomePurifierModel.this.dashboardData;
                        AirPurifierDashboardDetails airPurifierDashboardDetails20 = (AirPurifierDashboardDetails) mutableLiveData21.getValue();
                        Integer intOrNull = (airPurifierDashboardDetails20 == null || (airPurifierData4 = airPurifierDashboardDetails20.getAirPurifierData()) == null || (device2 = airPurifierData4.getDevice()) == null || (deviceStatus2 = device2.getDeviceStatus()) == null || (filterLife = deviceStatus2.getFilterLife()) == null) ? null : StringsKt.toIntOrNull(filterLife);
                        if (intOrNull != null) {
                            MutableLiveData<String> filterLife4 = HomePurifierModel.this.getFilterLife();
                            StringBuilder sb = new StringBuilder();
                            sb.append(intOrNull);
                            sb.append('%');
                            filterLife4.setValue(sb.toString());
                        }
                    }
                }
                MutableLiveData<String> planName = HomePurifierModel.this.getPlanName();
                mutableLiveData18 = HomePurifierModel.this.dashboardData;
                AirPurifierDashboardDetails airPurifierDashboardDetails21 = (AirPurifierDashboardDetails) mutableLiveData18.getValue();
                planName.setValue((airPurifierDashboardDetails21 == null || (airPurifierData3 = airPurifierDashboardDetails21.getAirPurifierData()) == null || (plan2 = airPurifierData3.getPlan()) == null) ? null : plan2.getPlanName());
                MutableLiveData<String> balanceAmount = HomePurifierModel.this.getBalanceAmount();
                mutableLiveData19 = HomePurifierModel.this.dashboardData;
                AirPurifierDashboardDetails airPurifierDashboardDetails22 = (AirPurifierDashboardDetails) mutableLiveData19.getValue();
                if (airPurifierDashboardDetails22 != null && (airPurifierData2 = airPurifierDashboardDetails22.getAirPurifierData()) != null && (plan = airPurifierData2.getPlan()) != null) {
                    str = plan.getAmount();
                }
                balanceAmount.setValue(str);
            }
        }, new Function1<AirPurifierDashboardDetails, Unit>() { // from class: com.livpure.safedrink.airpurifier.model.HomePurifierModel$getDashboardDetails$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AirPurifierDashboardDetails airPurifierDashboardDetails2) {
                invoke2(airPurifierDashboardDetails2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(AirPurifierDashboardDetails it) {
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(it, "it");
                toastMessageLiveData = HomePurifierModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Oops! We faced an issue while fetching your dashboard details at this time."));
            }
        });
    }

    public final LiveData<Triple<ArrayList<String>, ArrayList<Entry>, ArrayList<Entry>>> getDailyUsageStats() {
        return this.dailyUsageStats;
    }

    public final void setDailyUsageStats(LiveData<Triple<ArrayList<String>, ArrayList<Entry>, ArrayList<Entry>>> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.dailyUsageStats = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dailyUsageStats$lambda-18  reason: not valid java name */
    public static final Triple m216dailyUsageStats$lambda18(AirPurifierDashboardDetails airPurifierDashboardDetails) {
        AirPurifierGraph airPurifierGraph;
        AirPurifierGraph airPurifierGraph2;
        AirPurifierData airPurifierData = airPurifierDashboardDetails.getAirPurifierData();
        List<AirPurifierGraphDaily> dayily = (airPurifierData == null || (airPurifierGraph2 = airPurifierData.getAirPurifierGraph()) == null) ? null : airPurifierGraph2.getDayily();
        if (!(dayily == null || dayily.isEmpty())) {
            AirPurifierData airPurifierData2 = airPurifierDashboardDetails.getAirPurifierData();
            if (airPurifierData2 == null || (airPurifierGraph = airPurifierData2.getAirPurifierGraph()) == null) {
                return null;
            }
            return airPurifierGraph.getDailyGraphData();
        }
        return new Triple(null, null, null);
    }

    public final Triple<ArrayList<String>, ArrayList<Entry>, ArrayList<Entry>> getDailyGraphData() {
        AirPurifierData airPurifierData;
        AirPurifierGraph airPurifierGraph;
        AirPurifierData airPurifierData2;
        AirPurifierGraph airPurifierGraph2;
        AirPurifierDashboardDetails value = this.dashboardData.getValue();
        Triple<ArrayList<String>, ArrayList<Entry>, ArrayList<Entry>> triple = null;
        List<AirPurifierGraphDaily> dayily = (value == null || (airPurifierData2 = value.getAirPurifierData()) == null || (airPurifierGraph2 = airPurifierData2.getAirPurifierGraph()) == null) ? null : airPurifierGraph2.getDayily();
        if (!(dayily == null || dayily.isEmpty())) {
            AirPurifierDashboardDetails value2 = this.dashboardData.getValue();
            if (value2 != null && (airPurifierData = value2.getAirPurifierData()) != null && (airPurifierGraph = airPurifierData.getAirPurifierGraph()) != null) {
                triple = airPurifierGraph.getDailyGraphData();
            }
            Intrinsics.checkNotNull(triple);
            return triple;
        }
        return new Triple<>(null, null, null);
    }

    public final Triple<ArrayList<String>, ArrayList<Entry>, ArrayList<Entry>> getMonthlyGraphData() {
        AirPurifierData airPurifierData;
        AirPurifierGraph airPurifierGraph;
        AirPurifierData airPurifierData2;
        AirPurifierGraph airPurifierGraph2;
        AirPurifierDashboardDetails value = this.dashboardData.getValue();
        Triple<ArrayList<String>, ArrayList<Entry>, ArrayList<Entry>> triple = null;
        List<AirPurifierGraphMonthly> monthly = (value == null || (airPurifierData2 = value.getAirPurifierData()) == null || (airPurifierGraph2 = airPurifierData2.getAirPurifierGraph()) == null) ? null : airPurifierGraph2.getMonthly();
        if (!(monthly == null || monthly.isEmpty())) {
            AirPurifierDashboardDetails value2 = this.dashboardData.getValue();
            if (value2 != null && (airPurifierData = value2.getAirPurifierData()) != null && (airPurifierGraph = airPurifierData.getAirPurifierGraph()) != null) {
                triple = airPurifierGraph.getMonthlyGraphData();
            }
            Intrinsics.checkNotNull(triple);
            return triple;
        }
        return new Triple<>(null, null, null);
    }

    public final Triple<ArrayList<String>, ArrayList<Entry>, ArrayList<Entry>> getWeeklyGraphData() {
        AirPurifierData airPurifierData;
        AirPurifierGraph airPurifierGraph;
        AirPurifierData airPurifierData2;
        AirPurifierGraph airPurifierGraph2;
        AirPurifierDashboardDetails value = this.dashboardData.getValue();
        Triple<ArrayList<String>, ArrayList<Entry>, ArrayList<Entry>> triple = null;
        List<AirPurifierGraphWeekly> weekly = (value == null || (airPurifierData2 = value.getAirPurifierData()) == null || (airPurifierGraph2 = airPurifierData2.getAirPurifierGraph()) == null) ? null : airPurifierGraph2.getWeekly();
        if (!(weekly == null || weekly.isEmpty())) {
            AirPurifierDashboardDetails value2 = this.dashboardData.getValue();
            if (value2 != null && (airPurifierData = value2.getAirPurifierData()) != null && (airPurifierGraph = airPurifierData.getAirPurifierGraph()) != null) {
                triple = airPurifierGraph.getWeeklyGraphData();
            }
            Intrinsics.checkNotNull(triple);
            return triple;
        }
        return new Triple<>(null, null, null);
    }

    public final LiveData<ImageStatus> getPowerOnStatusImage() {
        return this.powerOnStatusImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: powerOnStatusImage$lambda-19  reason: not valid java name */
    public static final ImageStatus m220powerOnStatusImage$lambda19(HomePurifierModel this$0, AirPurifierDashboardDetails airPurifierDashboardDetails) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AirPurifierData airPurifierData = airPurifierDashboardDetails.getAirPurifierData();
        if ((airPurifierData != null ? airPurifierData.getDevice() : null) != null) {
            this$0.imeiNumber = String.valueOf(airPurifierDashboardDetails.getAirPurifierData().getDevice().getImeiNo());
            this$0.PowerOnStatus = String.valueOf(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getPower());
            this$0.IonStatus = String.valueOf(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getNegative_ions());
            this$0.modeStatus = String.valueOf(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getMode());
            this$0.fanSpeedStatus = String.valueOf(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getSpeed());
            this$0.serialNumber = String.valueOf(airPurifierDashboardDetails.getAirPurifierData().getDevice().getSerialNo());
            this$0.childLockStatus = String.valueOf(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getChildLock());
            int i3 = Intrinsics.areEqual(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getPower(), "1") ? R.drawable.ic_power_on : R.drawable.ic_power_off;
            if (Intrinsics.areEqual(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getMode(), "4")) {
                i = R.drawable.ic_mode_manual_on;
            } else if (Intrinsics.areEqual(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getMode(), ExifInterface.GPS_MEASUREMENT_3D)) {
                i = R.drawable.ic_sleep_on;
            } else if (Intrinsics.areEqual(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getMode(), "1")) {
                i = R.drawable.ic_auto_on;
            } else {
                i = Intrinsics.areEqual(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getMode(), ExifInterface.GPS_MEASUREMENT_2D) ? R.drawable.ic_turbo_on : R.drawable.ic_mode_manual_off;
            }
            if (Intrinsics.areEqual(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getSpeed(), "1")) {
                i2 = R.drawable.ic_fan_speed_1_on;
            } else if (Intrinsics.areEqual(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getSpeed(), ExifInterface.GPS_MEASUREMENT_2D)) {
                i2 = R.drawable.ic_fan_speed_2_on;
            } else if (Intrinsics.areEqual(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getSpeed(), ExifInterface.GPS_MEASUREMENT_3D)) {
                i2 = R.drawable.ic_fan_speed_3_on;
            } else if (Intrinsics.areEqual(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getSpeed(), "4")) {
                i2 = R.drawable.ic_fan_speed_4_on;
            } else {
                i2 = Intrinsics.areEqual(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getSpeed(), "5") ? R.drawable.ic_fan_speed_5_on : R.drawable.ic_fan_speed_1_off;
            }
            ImageStatus imageStatus = new ImageStatus(i3, i, i2, Intrinsics.areEqual(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getNegative_ions(), "1") ? R.drawable.ic_ion_on : R.drawable.ic_ion_off, Intrinsics.areEqual(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getMode(), ExifInterface.GPS_MEASUREMENT_3D) ? R.drawable.ic_sleep_on : R.drawable.ic_sleep_off, Intrinsics.areEqual(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getChildLock(), "1") ? R.drawable.ic_child_lock_on : R.drawable.ic_child_lock_off, Intrinsics.areEqual(airPurifierDashboardDetails.getAirPurifierData().getDevice().getDeviceStatus().getCountDown(), AppEventsConstants.EVENT_PARAM_VALUE_NO) ? R.drawable.ic_timer_off : R.drawable.ic_timer_on);
            this$0.imageStatus = imageStatus;
            return imageStatus;
        }
        ImageStatus imageStatus2 = new ImageStatus(R.drawable.ic_power_off, R.drawable.ic_mode_manual_off, R.drawable.ic_fan_speed_1_off, R.drawable.ic_ion_off, R.drawable.ic_sleep_off, R.drawable.ic_child_lock_off, R.drawable.ic_timer_off);
        this$0.imageStatus = imageStatus2;
        return imageStatus2;
    }

    public final LiveData<Integer> getWifiImage() {
        return this.wifiImage;
    }

    public final void setWifiImage(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.wifiImage = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: wifiImage$lambda-20  reason: not valid java name */
    public static final Integer m222wifiImage$lambda20(AirPurifierDashboardDetails airPurifierDashboardDetails) {
        return Integer.valueOf((int) R.drawable.wifi);
    }

    public final LiveData<Integer> getBleImage() {
        return this.bleImage;
    }

    public final void setBleImage(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.bleImage = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bleImage$lambda-21  reason: not valid java name */
    public static final Integer m212bleImage$lambda21(AirPurifierDashboardDetails airPurifierDashboardDetails) {
        return Integer.valueOf((int) R.drawable.bluetooth);
    }

    public final LiveData<Integer> getWifiImageOff() {
        return this.wifiImageOff;
    }

    public final void setWifiImageOff(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.wifiImageOff = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: wifiImageOff$lambda-22  reason: not valid java name */
    public static final Integer m223wifiImageOff$lambda22(AirPurifierDashboardDetails airPurifierDashboardDetails) {
        return Integer.valueOf((int) R.drawable.wifi_off);
    }

    public final LiveData<Integer> getBleImageOff() {
        return this.bleImageOff;
    }

    public final void setBleImageOff(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.bleImageOff = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bleImageOff$lambda-23  reason: not valid java name */
    public static final Integer m213bleImageOff$lambda23(AirPurifierDashboardDetails airPurifierDashboardDetails) {
        return Integer.valueOf((int) R.drawable.bluetooth_off);
    }

    public final LiveData<String> getConnectivityStatus() {
        return this.connectivityStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: connectivityStatus$lambda-24  reason: not valid java name */
    public static final String m215connectivityStatus$lambda24(AirPurifierDashboardDetails airPurifierDashboardDetails) {
        AirPurifierDevice device;
        AirPurifierData airPurifierData = airPurifierDashboardDetails.getAirPurifierData();
        return ((airPurifierData == null || (device = airPurifierData.getDevice()) == null) ? null : device.getConnectivity()) != null ? String.valueOf(airPurifierDashboardDetails.getAirPurifierData().getDevice().getConnectivity()) : "";
    }

    public final LiveData<Boolean> getLoadingStatus() {
        return this.loadingStatus;
    }

    public final DeviceList getDevice() {
        return this.device;
    }

    public final void setDevice(DeviceList deviceList) {
        String serialNo;
        this._device = deviceList;
        this.device = deviceList;
        String str = "";
        this.imeiNumber = (deviceList == null || (r2 = deviceList.getImeiNo()) == null) ? "" : "";
        DeviceList deviceList2 = this.device;
        this.connectivity = (deviceList2 == null || (r2 = deviceList2.getConnectivity()) == null) ? "" : "";
        DeviceList deviceList3 = this.device;
        if (deviceList3 != null && (serialNo = deviceList3.getSerialNo()) != null) {
            str = serialNo;
        }
        this.serialNumber = str;
    }
}

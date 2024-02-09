package com.livpure.safedrink.dispenser.model;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.facebook.appevents.AppEventsConstants;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.livpure.safedrink.R;
import com.livpure.safedrink.airpurifier.data.AirPurifierCommandsRespository;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierCommand;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierPublishCommand;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.bolt.data.BoltBleCommandsRespository;
import com.livpure.safedrink.bolt.data.BoltDataUpdateRepository;
import com.livpure.safedrink.bolt.data.models.BoltCommandsResponse;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.dispenser.data.DispenserCommandsRepository;
import com.livpure.safedrink.dispenser.data.models.DispenserCommands;
import com.livpure.safedrink.dispenser.data.models.DispenserImageStatus;
import com.livpure.safedrink.dispenser.data.models.DispenserPublishCommand;
import com.livpure.safedrink.subscription.plan.data.DispenserRoSetting;
import com.livpure.safedrink.subscription.plan.data.SubscriptionRepository;
import com.livpure.safedrink.subscription.plan.data.model.DashboardDetailsResponse;
import com.livpure.safedrink.subscription.plan.data.model.SubscriptionDetails;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.DailyConsumptionItem;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.DashboardDetails;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.ProductStats;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
/* compiled from: HomeDispenserModel.kt */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u0097\u0001\u001a\u00020-J\b\u0010\u0098\u0001\u001a\u00030\u0096\u0001J\b\u0010\u0099\u0001\u001a\u00030\u0096\u0001J!\u0010\u009a\u0001\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010\u001e2\u0007\u0010\u009b\u0001\u001a\u00020-2\u0007\u0010\u009c\u0001\u001a\u00020-J#\u0010\u009d\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u009e\u0001\u001a\u00020-2\u0007\u0010\u009f\u0001\u001a\u00020-2\u0007\u0010 \u0001\u001a\u00020-R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020706X\u0082\u0004¢\u0006\u0002\n\u0000R(\u00109\u001a\u0004\u0018\u00010\u000f2\b\u00108\u001a\u0004\u0018\u00010\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0011\"\u0004\b;\u0010\u0013R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010@\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\b\u001a\u0004\bB\u0010CR\u001a\u0010E\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010/\"\u0004\bG\u00101R\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020-06¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0017\u0010K\u001a\b\u0012\u0004\u0012\u00020-06¢\u0006\b\n\u0000\u001a\u0004\bL\u0010JR\u0017\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\b\n\u0000\u001a\u0004\bN\u0010!R\u0017\u0010O\u001a\b\u0012\u0004\u0012\u00020P0\u001e¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010!R\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020-0\u001e¢\u0006\b\n\u0000\u001a\u0004\bS\u0010!R\u001a\u0010T\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010/\"\u0004\bV\u00101R\u000e\u0010W\u001a\u00020XX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010Y\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010/\"\u0004\b[\u00101R \u0010\\\u001a\b\u0012\u0004\u0012\u00020-0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010!\"\u0004\b^\u0010#R\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\b\n\u0000\u001a\u0004\b`\u0010!R\u0017\u0010a\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\b\n\u0000\u001a\u0004\bb\u0010!R\u0017\u0010c\u001a\b\u0012\u0004\u0012\u00020P0\u001e¢\u0006\b\n\u0000\u001a\u0004\bd\u0010!R\u0017\u0010e\u001a\b\u0012\u0004\u0012\u00020-0\u001e¢\u0006\b\n\u0000\u001a\u0004\bf\u0010!R\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020-06¢\u0006\b\n\u0000\u001a\u0004\bh\u0010JR \u0010i\u001a\b\u0012\u0004\u0012\u00020-0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010!\"\u0004\bk\u0010#R\u0017\u0010l\u001a\b\u0012\u0004\u0012\u00020-06¢\u0006\b\n\u0000\u001a\u0004\bm\u0010JR\u001b\u0010n\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010\b\u001a\u0004\bo\u0010CR\u001a\u0010q\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010/\"\u0004\bs\u00101R\u0017\u0010t\u001a\b\u0012\u0004\u0012\u00020P0\u001e¢\u0006\b\n\u0000\u001a\u0004\bu\u0010!R\u0017\u0010v\u001a\b\u0012\u0004\u0012\u00020-0\u001e¢\u0006\b\n\u0000\u001a\u0004\bw\u0010!R\u001b\u0010x\u001a\u00020y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b|\u0010\b\u001a\u0004\bz\u0010{R\u0017\u0010}\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\b\n\u0000\u001a\u0004\b~\u0010!R\u001c\u0010\u007f\u001a\u00020-X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010/\"\u0005\b\u0081\u0001\u00101R?\u0010\u0082\u0001\u001a.\u0012*\u0012(\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020-\u0018\u00010\u0084\u0001\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030\u0085\u0001\u0018\u00010\u0084\u0001\u0012\u0004\u0012\u00020-0\u0083\u00010\u001e¢\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010!R\u0019\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\t\n\u0000\u001a\u0005\b\u0088\u0001\u0010!R\u001d\u0010\u0089\u0001\u001a\u00020-X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010/\"\u0005\b\u008b\u0001\u00101R(\u0010\u008c\u0001\u001a\u0017\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u00020-\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u008d\u00010\u001e¢\u0006\t\n\u0000\u001a\u0005\b\u008e\u0001\u0010!R#\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010!\"\u0005\b\u0091\u0001\u0010#R#\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010!\"\u0005\b\u0094\u0001\u0010#¨\u0006¡\u0001"}, d2 = {"Lcom/livpure/safedrink/dispenser/model/HomeDispenserModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "BLECommands", "Lcom/livpure/safedrink/bolt/data/BoltBleCommandsRespository;", "getBLECommands", "()Lcom/livpure/safedrink/bolt/data/BoltBleCommandsRespository;", "BLECommands$delegate", "Lkotlin/Lazy;", "BLERepository", "Lcom/livpure/safedrink/bolt/data/BoltDataUpdateRepository;", "getBLERepository", "()Lcom/livpure/safedrink/bolt/data/BoltDataUpdateRepository;", "BLERepository$delegate", "_device", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "get_device", "()Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "set_device", "(Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;)V", "airCommand", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierPublishCommand;", "airPurifierCommand", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierCommand;", "airPurifierCommandsRespository", "Lcom/livpure/safedrink/airpurifier/data/AirPurifierCommandsRespository;", "getAirPurifierCommandsRespository", "()Lcom/livpure/safedrink/airpurifier/data/AirPurifierCommandsRespository;", "airPurifierCommandsRespository$delegate", "bleImage", "Landroidx/lifecycle/LiveData;", "", "getBleImage", "()Landroidx/lifecycle/LiveData;", "setBleImage", "(Landroidx/lifecycle/LiveData;)V", "bleImageOff", "getBleImageOff", "setBleImageOff", "boltCommandsResponse", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/livpure/safedrink/bolt/data/models/BoltCommandsResponse;", "getBoltCommandsResponse", "()Landroidx/lifecycle/MediatorLiveData;", "buzzer", "", "getBuzzer", "()Ljava/lang/String;", "setBuzzer", "(Ljava/lang/String;)V", "connectivity", "getConnectivity", "setConnectivity", "dashboardData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/livpure/safedrink/subscription/plan/data/model/DashboardDetailsResponse;", "value", AndroidContextPlugin.DEVICE_KEY, "getDevice", "setDevice", "dispenseCommand", "Lcom/livpure/safedrink/dispenser/data/models/DispenserPublishCommand;", "dispenserCommand", "Lcom/livpure/safedrink/dispenser/data/models/DispenserCommands;", "dispenserCommandsRespository", "Lcom/livpure/safedrink/dispenser/data/DispenserCommandsRepository;", "getDispenserCommandsRespository", "()Lcom/livpure/safedrink/dispenser/data/DispenserCommandsRepository;", "dispenserCommandsRespository$delegate", "dispenserStatus", "getDispenserStatus", "setDispenserStatus", "faultDescription", "getFaultDescription", "()Landroidx/lifecycle/MutableLiveData;", "filterLife", "getFilterLife", "filterLifeImage", "getFilterLifeImage", "hardwareUpdate", "", "getHardwareUpdate", "hardwareVersion", "getHardwareVersion", "hotWaterTemprature", "getHotWaterTemprature", "setHotWaterTemprature", "imageStatus", "Lcom/livpure/safedrink/dispenser/data/models/DispenserImageStatus;", "imeiNumber", "getImeiNumber", "setImeiNumber", "lastSynchronizedDate", "getLastSynchronizedDate", "setLastSynchronizedDate", "liveDispenserStatus", "getLiveDispenserStatus", "liveDispenserStatusImage", "getLiveDispenserStatusImage", "loadingStatus", "getLoadingStatus", "planDetails", "getPlanDetails", "planName", "getPlanName", "productType", "getProductType", "setProductType", "publishCommandStatus", "getPublishCommandStatus", "repository", "getRepository", "repository$delegate", "serialNumber", "getSerialNumber", "setSerialNumber", "softwareUpdate", "getSoftwareUpdate", "softwareVersion", "getSoftwareVersion", "subscriptionRepository", "Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "getSubscriptionRepository", "()Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "subscriptionRepository$delegate", "tdsImage", "getTdsImage", "tempStatus", "getTempStatus", "setTempStatus", "usageStats", "Lkotlin/Triple;", "", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "getUsageStats", "uvImage", "getUvImage", "warmWaterTemprature", "getWarmWaterTemprature", "setWarmWaterTemprature", "waterRemaining", "Lkotlin/Pair;", "getWaterRemaining", "wifiImage", "getWifiImage", "setWifiImage", "wifiImageOff", "getWifiImageOff", "setWifiImageOff", "bleStatus", "", "status", "getDashboardDetails", "getPendingBleCommand", "getSubmissionBLEStatus", "statusPkt", "powerPkt", "publishCommand", "command", "warmWater", "hotWater", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeDispenserModel extends MediatorViewModel {
    private final Lazy BLECommands$delegate;
    private final Lazy BLERepository$delegate;
    private DeviceList _device;
    private AirPurifierPublishCommand airCommand;
    private AirPurifierCommand airPurifierCommand;
    private final Lazy airPurifierCommandsRespository$delegate;
    private LiveData<Integer> bleImage;
    private LiveData<Integer> bleImageOff;
    private final MediatorLiveData<BoltCommandsResponse> boltCommandsResponse;
    private final MutableLiveData<DashboardDetailsResponse> dashboardData;
    private DeviceList device;
    private DispenserPublishCommand dispenseCommand;
    private DispenserCommands dispenserCommand;
    private final MutableLiveData<String> faultDescription;
    private final MutableLiveData<String> filterLife;
    private final LiveData<Integer> filterLifeImage;
    private final LiveData<Boolean> hardwareUpdate;
    private final LiveData<String> hardwareVersion;
    private DispenserImageStatus imageStatus;
    private LiveData<String> lastSynchronizedDate;
    private final LiveData<Integer> liveDispenserStatus;
    private final LiveData<Integer> liveDispenserStatusImage;
    private final LiveData<Boolean> loadingStatus;
    private final LiveData<String> planDetails;
    private final MutableLiveData<String> planName;
    private LiveData<String> productType;
    private final MutableLiveData<String> publishCommandStatus;
    private final LiveData<Boolean> softwareUpdate;
    private final LiveData<String> softwareVersion;
    private final LiveData<Integer> tdsImage;
    private final LiveData<Triple<List<String>, List<IBarDataSet>, String>> usageStats;
    private final LiveData<Integer> uvImage;
    private final LiveData<Pair<String, Integer>> waterRemaining;
    private LiveData<Integer> wifiImage;
    private LiveData<Integer> wifiImageOff;
    private final Lazy repository$delegate = LazyKt.lazy(new Function0<DispenserCommandsRepository>() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$repository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DispenserCommandsRepository invoke() {
            return new DispenserCommandsRepository();
        }
    });
    private String imeiNumber = "";
    private String connectivity = "";
    private String buzzer = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private String dispenserStatus = "";
    private String serialNumber = "";
    private String hotWaterTemprature = "";
    private String warmWaterTemprature = "";
    private String tempStatus = "";
    private final Lazy subscriptionRepository$delegate = LazyKt.lazy(new Function0<SubscriptionRepository>() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$subscriptionRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SubscriptionRepository invoke() {
            return new SubscriptionRepository();
        }
    });
    private final Lazy dispenserCommandsRespository$delegate = LazyKt.lazy(new Function0<DispenserCommandsRepository>() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$dispenserCommandsRespository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DispenserCommandsRepository invoke() {
            return new DispenserCommandsRepository();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadingStatus$lambda-11  reason: not valid java name */
    public static final Boolean m702loadingStatus$lambda11(Boolean bool) {
        return bool;
    }

    public HomeDispenserModel() {
        MutableLiveData<DashboardDetailsResponse> mutableLiveData = new MutableLiveData<>();
        this.dashboardData = mutableLiveData;
        this.boltCommandsResponse = new MediatorLiveData<>();
        this.BLERepository$delegate = LazyKt.lazy(new Function0<BoltDataUpdateRepository>() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$BLERepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BoltDataUpdateRepository invoke() {
                return new BoltDataUpdateRepository();
            }
        });
        this.BLECommands$delegate = LazyKt.lazy(new Function0<BoltBleCommandsRespository>() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$BLECommands$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BoltBleCommandsRespository invoke() {
                return new BoltBleCommandsRespository();
            }
        });
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue("");
        this.faultDescription = mutableLiveData2;
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        mutableLiveData3.setValue("");
        this.filterLife = mutableLiveData3;
        MutableLiveData<String> mutableLiveData4 = new MutableLiveData<>();
        mutableLiveData4.setValue("");
        this.planName = mutableLiveData4;
        this.airPurifierCommandsRespository$delegate = LazyKt.lazy(new Function0<AirPurifierCommandsRespository>() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$airPurifierCommandsRespository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AirPurifierCommandsRespository invoke() {
                return new AirPurifierCommandsRespository();
            }
        });
        this.publishCommandStatus = new MutableLiveData<>();
        LiveData<String> map = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda4
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m699lastSynchronizedDate$lambda4;
                m699lastSynchronizedDate$lambda4 = HomeDispenserModel.m699lastSynchronizedDate$lambda4((DashboardDetailsResponse) obj);
                return m699lastSynchronizedDate$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.lastSynchronizedDate = map;
        LiveData<String> map2 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda11
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m704productType$lambda6;
                m704productType$lambda6 = HomeDispenserModel.m704productType$lambda6((DashboardDetailsResponse) obj);
                return m704productType$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.productType = map2;
        LiveData<Integer> map3 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda22
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m712wifiImage$lambda7;
                m712wifiImage$lambda7 = HomeDispenserModel.m712wifiImage$lambda7((DashboardDetailsResponse) obj);
                return m712wifiImage$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map3, "map(dashboardData) {\n        R.drawable.wifi\n    }");
        this.wifiImage = map3;
        LiveData<Integer> map4 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda1
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m690bleImage$lambda8;
                m690bleImage$lambda8 = HomeDispenserModel.m690bleImage$lambda8((DashboardDetailsResponse) obj);
                return m690bleImage$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map4, "map(dashboardData) {\n   ….drawable.bluetooth\n    }");
        this.bleImage = map4;
        LiveData<Integer> map5 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda17
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m713wifiImageOff$lambda9;
                m713wifiImageOff$lambda9 = HomeDispenserModel.m713wifiImageOff$lambda9((DashboardDetailsResponse) obj);
                return m713wifiImageOff$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map5, "map(dashboardData) {\n   …R.drawable.wifi_off\n    }");
        this.wifiImageOff = map5;
        LiveData<Integer> map6 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda5
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m691bleImageOff$lambda10;
                m691bleImageOff$lambda10 = HomeDispenserModel.m691bleImageOff$lambda10((DashboardDetailsResponse) obj);
                return m691bleImageOff$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map6, "map(dashboardData) {\n   …wable.bluetooth_off\n    }");
        this.bleImageOff = map6;
        LiveData<Boolean> map7 = Transformations.map(getLoading(), new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda10
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m702loadingStatus$lambda11;
                m702loadingStatus$lambda11 = HomeDispenserModel.m702loadingStatus$lambda11((Boolean) obj);
                return m702loadingStatus$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map7, "map(loading) {\n        it\n    }");
        this.loadingStatus = map7;
        LiveData<Integer> map8 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda8
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m700liveDispenserStatus$lambda13;
                m700liveDispenserStatus$lambda13 = HomeDispenserModel.m700liveDispenserStatus$lambda13((DashboardDetailsResponse) obj);
                return m700liveDispenserStatus$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map8, "map(dashboardData) {\n   …        }\n        0\n    }");
        this.liveDispenserStatus = map8;
        LiveData<Integer> map9 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda23
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m701liveDispenserStatusImage$lambda14;
                m701liveDispenserStatusImage$lambda14 = HomeDispenserModel.m701liveDispenserStatusImage$lambda14((DashboardDetailsResponse) obj);
                return m701liveDispenserStatusImage$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map9, "map(dashboardData) {\n   …_dispense\n        }\n    }");
        this.liveDispenserStatusImage = map9;
        LiveData<Pair<String, Integer>> map10 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda7
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Pair m711waterRemaining$lambda15;
                m711waterRemaining$lambda15 = HomeDispenserModel.m711waterRemaining$lambda15((DashboardDetailsResponse) obj);
                return m711waterRemaining$lambda15;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map10, "map(dashboardData) {\n   …\"\", null)\n        }\n    }");
        this.waterRemaining = map10;
        LiveData<Integer> map11 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda18
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m710uvImage$lambda16;
                m710uvImage$lambda16 = HomeDispenserModel.m710uvImage$lambda16((DashboardDetailsResponse) obj);
                return m710uvImage$lambda16;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map11, "map(dashboardData) {\n   …le.uv_off\n        }\n    }");
        this.uvImage = map11;
        LiveData<Integer> map12 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda3
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m708tdsImage$lambda17;
                m708tdsImage$lambda17 = HomeDispenserModel.m708tdsImage$lambda17((DashboardDetailsResponse) obj);
                return m708tdsImage$lambda17;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map12, "map(dashboardData) {\n   …drawable.tds_band_1\n    }");
        this.tdsImage = map12;
        LiveData<String> map13 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda16
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m703planDetails$lambda18;
                m703planDetails$lambda18 = HomeDispenserModel.m703planDetails$lambda18((DashboardDetailsResponse) obj);
                return m703planDetails$lambda18;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map13, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.planDetails = map13;
        LiveData<Integer> map14 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda19
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m693filterLifeImage$lambda19;
                m693filterLifeImage$lambda19 = HomeDispenserModel.m693filterLifeImage$lambda19((DashboardDetailsResponse) obj);
                return m693filterLifeImage$lambda19;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map14, "map(dashboardData) {\n   …       -1\n        }\n    }");
        this.filterLifeImage = map14;
        LiveData<Boolean> map15 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda20
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m697hardwareUpdate$lambda20;
                m697hardwareUpdate$lambda20 = HomeDispenserModel.m697hardwareUpdate$lambda20((DashboardDetailsResponse) obj);
                return m697hardwareUpdate$lambda20;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map15, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.hardwareUpdate = map15;
        LiveData<Boolean> map16 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda21
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m706softwareUpdate$lambda21;
                m706softwareUpdate$lambda21 = HomeDispenserModel.m706softwareUpdate$lambda21((DashboardDetailsResponse) obj);
                return m706softwareUpdate$lambda21;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map16, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.softwareUpdate = map16;
        LiveData<String> map17 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda2
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m698hardwareVersion$lambda22;
                m698hardwareVersion$lambda22 = HomeDispenserModel.m698hardwareVersion$lambda22((DashboardDetailsResponse) obj);
                return m698hardwareVersion$lambda22;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map17, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.hardwareVersion = map17;
        LiveData<String> map18 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda9
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m707softwareVersion$lambda23;
                m707softwareVersion$lambda23 = HomeDispenserModel.m707softwareVersion$lambda23((DashboardDetailsResponse) obj);
                return m707softwareVersion$lambda23;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map18, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.softwareVersion = map18;
        LiveData<Triple<List<String>, List<IBarDataSet>, String>> map19 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda6
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Triple m709usageStats$lambda24;
                m709usageStats$lambda24 = HomeDispenserModel.m709usageStats$lambda24((DashboardDetailsResponse) obj);
                return m709usageStats$lambda24;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map19, "map(dashboardData) {\n   …null, \"\")\n        }\n    }");
        this.usageStats = map19;
    }

    private final DispenserCommandsRepository getRepository() {
        return (DispenserCommandsRepository) this.repository$delegate.getValue();
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

    public final String getDispenserStatus() {
        return this.dispenserStatus;
    }

    public final void setDispenserStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dispenserStatus = str;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final void setSerialNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serialNumber = str;
    }

    public final String getHotWaterTemprature() {
        return this.hotWaterTemprature;
    }

    public final void setHotWaterTemprature(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hotWaterTemprature = str;
    }

    public final String getWarmWaterTemprature() {
        return this.warmWaterTemprature;
    }

    public final void setWarmWaterTemprature(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.warmWaterTemprature = str;
    }

    public final String getTempStatus() {
        return this.tempStatus;
    }

    public final void setTempStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tempStatus = str;
    }

    private final SubscriptionRepository getSubscriptionRepository() {
        return (SubscriptionRepository) this.subscriptionRepository$delegate.getValue();
    }

    private final DispenserCommandsRepository getDispenserCommandsRespository() {
        return (DispenserCommandsRepository) this.dispenserCommandsRespository$delegate.getValue();
    }

    public final MediatorLiveData<BoltCommandsResponse> getBoltCommandsResponse() {
        return this.boltCommandsResponse;
    }

    private final BoltDataUpdateRepository getBLERepository() {
        return (BoltDataUpdateRepository) this.BLERepository$delegate.getValue();
    }

    private final BoltBleCommandsRespository getBLECommands() {
        return (BoltBleCommandsRespository) this.BLECommands$delegate.getValue();
    }

    public final MutableLiveData<String> getFaultDescription() {
        return this.faultDescription;
    }

    public final MutableLiveData<String> getFilterLife() {
        return this.filterLife;
    }

    public final MutableLiveData<String> getPlanName() {
        return this.planName;
    }

    private final AirPurifierCommandsRespository getAirPurifierCommandsRespository() {
        return (AirPurifierCommandsRespository) this.airPurifierCommandsRespository$delegate.getValue();
    }

    public final MutableLiveData<String> getPublishCommandStatus() {
        return this.publishCommandStatus;
    }

    public final void publishCommand(String command, String warmWater, String hotWater) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(warmWater, "warmWater");
        Intrinsics.checkNotNullParameter(hotWater, "hotWater");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            this.dispenseCommand = new DispenserPublishCommand(command, warmWater, hotWater, "");
            String str = this.imeiNumber;
            DispenserPublishCommand dispenserPublishCommand = this.dispenseCommand;
            DispenserCommands dispenserCommands = null;
            if (dispenserPublishCommand == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dispenseCommand");
                dispenserPublishCommand = null;
            }
            this.dispenserCommand = new DispenserCommands(str, dispenserPublishCommand);
            try {
                DispenserCommandsRepository dispenserCommandsRespository = getDispenserCommandsRespository();
                DispenserCommands dispenserCommands2 = this.dispenserCommand;
                if (dispenserCommands2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dispenserCommand");
                } else {
                    dispenserCommands = dispenserCommands2;
                }
                observeAndTrack(dispenserCommandsRespository.sendDispenserCommand(dispenserCommands), new Observer() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda13
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeDispenserModel.m705publishCommand$lambda3(HomeDispenserModel.this, (BaseDataHolder) obj);
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
    /* renamed from: publishCommand$lambda-3  reason: not valid java name */
    public static final void m705publishCommand$lambda3(HomeDispenserModel this$0, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.publishCommandStatus.setValue(baseDataHolder.getMessage());
    }

    public final LiveData<String> getLastSynchronizedDate() {
        return this.lastSynchronizedDate;
    }

    public final void setLastSynchronizedDate(LiveData<String> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.lastSynchronizedDate = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lastSynchronizedDate$lambda-4  reason: not valid java name */
    public static final String m699lastSynchronizedDate$lambda4(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getLastSyncDate() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getLastSyncDate() : "";
    }

    public final void bleStatus(final String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getBLERepository().sendBoltConfigtRequest(this.serialNumber, status, false), new Observer() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda15
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeDispenserModel.m692bleStatus$lambda5(HomeDispenserModel.this, status, (BaseDataHolder) obj);
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
    /* renamed from: bleStatus$lambda-5  reason: not valid java name */
    public static final void m692bleStatus$lambda5(HomeDispenserModel this$0, String status, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(status, "$status");
        this$0.getLoading().setValue(false);
        if (StringsKt.contains$default((CharSequence) status.toString(), (CharSequence) "\"FR\"", false, 2, (Object) null)) {
            this$0.getDashboardDetails();
        } else if (StringsKt.contains$default((CharSequence) status.toString(), (CharSequence) "DWC", false, 2, (Object) null)) {
            this$0.getPendingBleCommand();
        }
    }

    public final LiveData<String> getProductType() {
        return this.productType;
    }

    public final void setProductType(LiveData<String> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.productType = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: productType$lambda-6  reason: not valid java name */
    public static final String m704productType$lambda6(DashboardDetailsResponse dashboardDetailsResponse) {
        ProductStats productStats;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return ((dashboardDetails == null || (productStats = dashboardDetails.getProductStats()) == null) ? null : productStats.getProductType()) != null ? dashboardDetailsResponse.getDashboardDetails().getProductStats().getProductType() : "";
    }

    public final LiveData<Integer> getWifiImage() {
        return this.wifiImage;
    }

    public final void setWifiImage(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.wifiImage = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: wifiImage$lambda-7  reason: not valid java name */
    public static final Integer m712wifiImage$lambda7(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: bleImage$lambda-8  reason: not valid java name */
    public static final Integer m690bleImage$lambda8(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: wifiImageOff$lambda-9  reason: not valid java name */
    public static final Integer m713wifiImageOff$lambda9(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: bleImageOff$lambda-10  reason: not valid java name */
    public static final Integer m691bleImageOff$lambda10(DashboardDetailsResponse dashboardDetailsResponse) {
        return Integer.valueOf((int) R.drawable.bluetooth_off);
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

    public final void getDashboardDetails() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getSubscriptionRepository().getDashboardDetails(this.serialNumber), new Observer() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda14
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeDispenserModel.m694getDashboardDetails$lambda12(HomeDispenserModel.this, (DashboardDetailsResponse) obj);
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
    /* renamed from: getDashboardDetails$lambda-12  reason: not valid java name */
    public static final void m694getDashboardDetails$lambda12(final HomeDispenserModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(dashboardDetailsResponse, new Function1<DashboardDetailsResponse, Unit>() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$getDashboardDetails$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DashboardDetailsResponse dashboardDetailsResponse2) {
                invoke2(dashboardDetailsResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DashboardDetailsResponse successfulResponse) {
                MutableLiveData mutableLiveData;
                DispenserRoSetting dispenserRoSetting;
                DispenserRoSetting dispenserRoSetting2;
                DispenserRoSetting dispenserRoSetting3;
                DispenserRoSetting dispenserRoSetting4;
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                mutableLiveData = HomeDispenserModel.this.dashboardData;
                mutableLiveData.setValue(successfulResponse);
                MutableLiveData<String> faultDescription = HomeDispenserModel.this.getFaultDescription();
                DashboardDetails dashboardDetails = successfulResponse.getDashboardDetails();
                String str = null;
                faultDescription.setValue(String.valueOf((dashboardDetails == null || (dispenserRoSetting4 = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting4.getFault()));
                HomeDispenserModel homeDispenserModel = HomeDispenserModel.this;
                DashboardDetails dashboardDetails2 = successfulResponse.getDashboardDetails();
                homeDispenserModel.setDispenserStatus(String.valueOf((dashboardDetails2 == null || (dispenserRoSetting3 = dashboardDetails2.getDispenserRoSetting()) == null) ? null : dispenserRoSetting3.getDespensing()));
                HomeDispenserModel homeDispenserModel2 = HomeDispenserModel.this;
                DashboardDetails dashboardDetails3 = successfulResponse.getDashboardDetails();
                homeDispenserModel2.setHotWaterTemprature(String.valueOf((dashboardDetails3 == null || (dispenserRoSetting2 = dashboardDetails3.getDispenserRoSetting()) == null) ? null : dispenserRoSetting2.getHotWater()));
                HomeDispenserModel homeDispenserModel3 = HomeDispenserModel.this;
                DashboardDetails dashboardDetails4 = successfulResponse.getDashboardDetails();
                if (dashboardDetails4 != null && (dispenserRoSetting = dashboardDetails4.getDispenserRoSetting()) != null) {
                    str = dispenserRoSetting.getWarmWater();
                }
                homeDispenserModel3.setWarmWaterTemprature(String.valueOf(str));
            }
        }, new Function1<DashboardDetailsResponse, Unit>() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$getDashboardDetails$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DashboardDetailsResponse dashboardDetailsResponse2) {
                invoke2(dashboardDetailsResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DashboardDetailsResponse it) {
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(it, "it");
                toastMessageLiveData = HomeDispenserModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Oops! We faced an issue while fetching your dashboard details at this time."));
            }
        });
    }

    public final LiveData<Integer> getLiveDispenserStatus() {
        return this.liveDispenserStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveDispenserStatus$lambda-13  reason: not valid java name */
    public static final Integer m700liveDispenserStatus$lambda13(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null) != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing() != null && !Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing(), "")) {
            Integer.parseInt(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing());
        }
        return 0;
    }

    public final LiveData<Integer> getLiveDispenserStatusImage() {
        return this.liveDispenserStatusImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveDispenserStatusImage$lambda-14  reason: not valid java name */
    public static final Integer m701liveDispenserStatusImage$lambda14(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        DispenserRoSetting dispenserRoSetting = dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null;
        int i = R.drawable.cont_dispense;
        if (dispenserRoSetting != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing() != null && !Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing(), "") && Integer.parseInt(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing()) == 1) {
            i = R.drawable.cont_dispense_sel;
        }
        return Integer.valueOf(i);
    }

    public final LiveData<Pair<String, Integer>> getWaterRemaining() {
        return this.waterRemaining;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: waterRemaining$lambda-15  reason: not valid java name */
    public static final Pair m711waterRemaining$lambda15(DashboardDetailsResponse dashboardDetailsResponse) {
        String remainingLitres;
        String padStart;
        String remainingLitres2;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        String str = "";
        if ((dashboardDetails != null ? dashboardDetails.getUsage() : null) != null) {
            ProductStats productStats = dashboardDetailsResponse.getDashboardDetails().getProductStats();
            if ((productStats != null ? productStats.getProductType() : null) == null ? !((remainingLitres = dashboardDetailsResponse.getDashboardDetails().getUsage().getRemainingLitres()) == null || (padStart = StringsKt.padStart(remainingLitres, 6, '0')) == null) : !((remainingLitres2 = dashboardDetailsResponse.getDashboardDetails().getUsage().getRemainingLitres()) == null || (padStart = StringsKt.padStart(remainingLitres2, 6, '0')) == null)) {
                str = padStart;
            }
            long parseLong = Long.parseLong(str);
            return new Pair(str, Integer.valueOf(parseLong > 40 ? R.drawable.fullwaterlarge : parseLong > 10 ? R.drawable.purifyinglarge : R.drawable.emptywaterlarge));
        }
        return new Pair("", null);
    }

    public final LiveData<Integer> getUvImage() {
        return this.uvImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: uvImage$lambda-16  reason: not valid java name */
    public static final Integer m710uvImage$lambda16(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        Boolean bool = null;
        DispenserRoSetting dispenserRoSetting = dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null;
        int i = R.drawable.uv_off;
        if (dispenserRoSetting != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTankUV() != null) {
            String tankUV = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTankUV();
            if (tankUV != null) {
                bool = Boolean.valueOf(tankUV.length() > 0);
            }
            Intrinsics.checkNotNull(bool);
            if (bool.booleanValue()) {
                String tankUV2 = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTankUV();
                int parseInt = tankUV2 != null ? Integer.parseInt(tankUV2) : 0;
                if (parseInt != 0 && parseInt == 1) {
                    i = R.drawable.uv_on;
                }
            }
        }
        return Integer.valueOf(i);
    }

    public final LiveData<Integer> getTdsImage() {
        return this.tdsImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: tdsImage$lambda-17  reason: not valid java name */
    public static final Integer m708tdsImage$lambda17(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null) != null) {
            String tds = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTds();
            int parseInt = tds != null ? Integer.parseInt(tds) : 0;
            if (parseInt <= 0 && parseInt <= 1 && parseInt <= 2 && parseInt > 3) {
            }
        }
        return Integer.valueOf((int) R.drawable.tds_band_1);
    }

    public final LiveData<String> getPlanDetails() {
        return this.planDetails;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: planDetails$lambda-18  reason: not valid java name */
    public static final String m703planDetails$lambda18(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getSubscriptionDetails() : null) != null) {
            SubscriptionDetails subscriptionDetails = dashboardDetailsResponse.getDashboardDetails().getSubscriptionDetails();
            ProductStats productStats = dashboardDetailsResponse.getDashboardDetails().getProductStats();
            if ((productStats != null ? productStats.getProductType() : null) != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%s\n%s\n%s\n%s", Arrays.copyOf(new Object[]{subscriptionDetails.getPlanName(), "Valid Till: " + subscriptionDetails.getValidFromTo(), "Rate: " + subscriptionDetails.getPlanRate(), subscriptionDetails.getNormalizedBalanceString()}, 4));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                return format;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%s\n%s\n%s\n%s", Arrays.copyOf(new Object[]{subscriptionDetails.getPlanName(), "Valid Till: " + subscriptionDetails.getValidTillDate(), "Rate: " + subscriptionDetails.getPlanRate(), subscriptionDetails.getNormalizedBalanceString()}, 4));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        return "";
    }

    public final LiveData<Integer> getFilterLifeImage() {
        return this.filterLifeImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: filterLifeImage$lambda-19  reason: not valid java name */
    public static final Integer m693filterLifeImage$lambda19(DashboardDetailsResponse dashboardDetailsResponse) {
        int i;
        ProductStats productStats;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if (((dashboardDetails == null || (productStats = dashboardDetails.getProductStats()) == null) ? null : productStats.getFilterLife()) != null) {
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (!dashboardDetailsResponse.getDashboardDetails().getProductStats().getFilterLife().equals("")) {
                d = Double.parseDouble(dashboardDetailsResponse.getDashboardDetails().getProductStats().getFilterLife());
            }
            i = Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getProductStats().getProductType(), "zinger-waas") ? d > 10.0d ? R.drawable.zbluemedium : d > 3.0d ? R.drawable.zgreenmedium : R.drawable.zredmedium : d > 10.0d ? R.drawable.envygood : d > 3.0d ? R.drawable.envynormal : R.drawable.envybad;
        } else {
            i = -1;
        }
        return Integer.valueOf(i);
    }

    public final LiveData<Boolean> getHardwareUpdate() {
        return this.hardwareUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hardwareUpdate$lambda-20  reason: not valid java name */
    public static final Boolean m697hardwareUpdate$lambda20(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getHardwareVersion() : false);
    }

    public final LiveData<Boolean> getSoftwareUpdate() {
        return this.softwareUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: softwareUpdate$lambda-21  reason: not valid java name */
    public static final Boolean m706softwareUpdate$lambda21(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getSoftwareVersion() : false);
    }

    public final LiveData<String> getHardwareVersion() {
        return this.hardwareVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hardwareVersion$lambda-22  reason: not valid java name */
    public static final String m698hardwareVersion$lambda22(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getCurrentHardwareVersion() : "";
    }

    public final LiveData<String> getSoftwareVersion() {
        return this.softwareVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: softwareVersion$lambda-23  reason: not valid java name */
    public static final String m707softwareVersion$lambda23(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getCurrentSoftwareVersion() : "";
    }

    public final LiveData<Triple<List<String>, List<IBarDataSet>, String>> getUsageStats() {
        return this.usageStats;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: usageStats$lambda-24  reason: not valid java name */
    public static final Triple m709usageStats$lambda24(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        List<DailyConsumptionItem> dailyConsumptionList = dashboardDetails != null ? dashboardDetails.getDailyConsumptionList() : null;
        if (!(dailyConsumptionList == null || dailyConsumptionList.isEmpty())) {
            DashboardDetails dashboardDetails2 = dashboardDetailsResponse.getDashboardDetails();
            Intrinsics.checkNotNull(dashboardDetails2);
            return dashboardDetails2.getConsumptionData();
        }
        return new Triple(null, null, "");
    }

    public final LiveData<Boolean> getSubmissionBLEStatus(String statusPkt, String powerPkt) {
        Intrinsics.checkNotNullParameter(statusPkt, "statusPkt");
        Intrinsics.checkNotNullParameter(powerPkt, "powerPkt");
        if (LSApplication.Companion.isNetworkAvailable()) {
            return Transformations.map(getBLERepository().sendBoltConfigtRequest(this.serialNumber, statusPkt, false), new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Boolean m696getSubmissionBLEStatus$lambda25;
                    m696getSubmissionBLEStatus$lambda25 = HomeDispenserModel.m696getSubmissionBLEStatus$lambda25((BaseDataHolder) obj);
                    return m696getSubmissionBLEStatus$lambda25;
                }
            });
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSubmissionBLEStatus$lambda-25  reason: not valid java name */
    public static final Boolean m696getSubmissionBLEStatus$lambda25(BaseDataHolder baseDataHolder) {
        return Boolean.valueOf(baseDataHolder.getStatus());
    }

    public final void getPendingBleCommand() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            this.boltCommandsResponse.addSource(getBLECommands().getBoltBleCommands(this.serialNumber), new Observer() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserModel$$ExternalSyntheticLambda12
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeDispenserModel.m695getPendingBleCommand$lambda26(HomeDispenserModel.this, (BaseDataHolder) obj);
                }
            });
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPendingBleCommand$lambda-26  reason: not valid java name */
    public static final void m695getPendingBleCommand$lambda26(HomeDispenserModel this$0, BaseDataHolder baseDataHolder) {
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
}

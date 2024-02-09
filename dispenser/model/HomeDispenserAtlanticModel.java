package com.livpure.safedrink.dispenser.model;

import androidx.arch.core.util.Function;
import androidx.exifinterface.media.ExifInterface;
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
/* compiled from: HomeDispenserAtlanticModel.kt */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010¯\u0001\u001a\u00030°\u00012\u0007\u0010±\u0001\u001a\u00020-J\b\u0010²\u0001\u001a\u00030°\u0001J\b\u0010³\u0001\u001a\u00030°\u0001J!\u0010´\u0001\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010\u001e2\u0007\u0010µ\u0001\u001a\u00020-2\u0007\u0010¶\u0001\u001a\u00020-J,\u0010·\u0001\u001a\u00030°\u00012\u0007\u0010¸\u0001\u001a\u00020-2\u0007\u0010¹\u0001\u001a\u00020-2\u0007\u0010º\u0001\u001a\u00020-2\u0007\u0010»\u0001\u001a\u00020-R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010!R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020-05¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010/\"\u0004\b:\u00101R\u001a\u0010;\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010/\"\u0004\b=\u00101R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020?05X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010A\u001a\u0004\u0018\u00010\u000f2\b\u0010@\u001a\u0004\u0018\u00010\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0011\"\u0004\bC\u0010\u0013R\u001a\u0010D\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010/\"\u0004\bF\u00101R\u0017\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\b\n\u0000\u001a\u0004\bH\u0010!R\u000e\u0010I\u001a\u00020JX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010M\u001a\u00020N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\b\u001a\u0004\bO\u0010PR\u001a\u0010R\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010/\"\u0004\bT\u00101R\u001a\u0010U\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010/\"\u0004\bW\u00101R\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020-05¢\u0006\b\n\u0000\u001a\u0004\bY\u00107R\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020-05¢\u0006\b\n\u0000\u001a\u0004\b[\u00107R\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\b\n\u0000\u001a\u0004\b]\u0010!R\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\u001e¢\u0006\b\n\u0000\u001a\u0004\b`\u0010!R\u0017\u0010a\u001a\b\u0012\u0004\u0012\u00020-0\u001e¢\u0006\b\n\u0000\u001a\u0004\bb\u0010!R\u0017\u0010c\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\b\n\u0000\u001a\u0004\bd\u0010!R\u0017\u0010e\u001a\b\u0012\u0004\u0012\u00020-05¢\u0006\b\n\u0000\u001a\u0004\bf\u00107R\u001a\u0010g\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010/\"\u0004\bi\u00101R\u001a\u0010j\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010/\"\u0004\bl\u00101R\u000e\u0010m\u001a\u00020nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010o\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010/\"\u0004\bq\u00101R \u0010r\u001a\b\u0012\u0004\u0012\u00020-0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010!\"\u0004\bt\u0010#R\u0017\u0010u\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\b\n\u0000\u001a\u0004\bv\u0010!R\u0017\u0010w\u001a\b\u0012\u0004\u0012\u00020_0\u001e¢\u0006\b\n\u0000\u001a\u0004\bx\u0010!R\u0017\u0010y\u001a\b\u0012\u0004\u0012\u00020-0\u001e¢\u0006\b\n\u0000\u001a\u0004\bz\u0010!R\u0017\u0010{\u001a\b\u0012\u0004\u0012\u00020-05¢\u0006\b\n\u0000\u001a\u0004\b|\u00107R \u0010}\u001a\b\u0012\u0004\u0012\u00020-0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010!\"\u0004\b\u007f\u0010#R\u0019\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020-05¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u00107R\u001e\u0010\u0082\u0001\u001a\u00020N8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0084\u0001\u0010\b\u001a\u0005\b\u0083\u0001\u0010PR\u001d\u0010\u0085\u0001\u001a\u00020-X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010/\"\u0005\b\u0087\u0001\u00101R\u0019\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020_0\u001e¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010!R\u0019\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020-0\u001e¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010!R \u0010\u008c\u0001\u001a\u00030\u008d\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0090\u0001\u0010\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0019\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\t\n\u0000\u001a\u0005\b\u0092\u0001\u0010!R6\u0010\u0093\u0001\u001a\u001b\u0012\u0017\u0012\u0015\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0\u0094\u00010\u001eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010!\"\u0005\b\u0096\u0001\u0010#R#\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010!\"\u0005\b\u0099\u0001\u0010#R\u001d\u0010\u009a\u0001\u001a\u00020-X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010/\"\u0005\b\u009c\u0001\u00101R?\u0010\u009d\u0001\u001a.\u0012*\u0012(\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020-\u0018\u00010\u009e\u0001\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030\u009f\u0001\u0018\u00010\u009e\u0001\u0012\u0004\u0012\u00020-0\u0094\u00010\u001e¢\u0006\t\n\u0000\u001a\u0005\b \u0001\u0010!R\u0019\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\t\n\u0000\u001a\u0005\b¢\u0001\u0010!R\u001d\u0010£\u0001\u001a\u00020-X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0001\u0010/\"\u0005\b¥\u0001\u00101R(\u0010¦\u0001\u001a\u0017\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u00020-\u0012\u0006\u0012\u0004\u0018\u00010\u001f0§\u00010\u001e¢\u0006\t\n\u0000\u001a\u0005\b¨\u0001\u0010!R#\u0010©\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bª\u0001\u0010!\"\u0005\b«\u0001\u0010#R#\u0010¬\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u00ad\u0001\u0010!\"\u0005\b®\u0001\u0010#¨\u0006¼\u0001"}, d2 = {"Lcom/livpure/safedrink/dispenser/model/HomeDispenserAtlanticModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "BLECommands", "Lcom/livpure/safedrink/bolt/data/BoltBleCommandsRespository;", "getBLECommands", "()Lcom/livpure/safedrink/bolt/data/BoltBleCommandsRespository;", "BLECommands$delegate", "Lkotlin/Lazy;", "BLERepository", "Lcom/livpure/safedrink/bolt/data/BoltDataUpdateRepository;", "getBLERepository", "()Lcom/livpure/safedrink/bolt/data/BoltDataUpdateRepository;", "BLERepository$delegate", "_device", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "get_device", "()Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "set_device", "(Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;)V", "airCommand", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierPublishCommand;", "airPurifierCommand", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierCommand;", "airPurifierCommandsRespository", "Lcom/livpure/safedrink/airpurifier/data/AirPurifierCommandsRespository;", "getAirPurifierCommandsRespository", "()Lcom/livpure/safedrink/airpurifier/data/AirPurifierCommandsRespository;", "airPurifierCommandsRespository$delegate", "bleImage", "Landroidx/lifecycle/LiveData;", "", "getBleImage", "()Landroidx/lifecycle/LiveData;", "setBleImage", "(Landroidx/lifecycle/LiveData;)V", "bleImageOff", "getBleImageOff", "setBleImageOff", "boltCommandsResponse", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/livpure/safedrink/bolt/data/models/BoltCommandsResponse;", "getBoltCommandsResponse", "()Landroidx/lifecycle/MediatorLiveData;", "buzzer", "", "getBuzzer", "()Ljava/lang/String;", "setBuzzer", "(Ljava/lang/String;)V", "coldWaterImage", "getColdWaterImage", "coldWaterStatus", "Landroidx/lifecycle/MutableLiveData;", "getColdWaterStatus", "()Landroidx/lifecycle/MutableLiveData;", "coldWaterValue", "getColdWaterValue", "setColdWaterValue", "connectivity", "getConnectivity", "setConnectivity", "dashboardData", "Lcom/livpure/safedrink/subscription/plan/data/model/DashboardDetailsResponse;", "value", AndroidContextPlugin.DEVICE_KEY, "getDevice", "setDevice", "disinfection", "getDisinfection", "setDisinfection", "disinfectionImage", "getDisinfectionImage", "dispenseCommand", "Lcom/livpure/safedrink/dispenser/data/models/DispenserPublishCommand;", "dispenserCommand", "Lcom/livpure/safedrink/dispenser/data/models/DispenserCommands;", "dispenserCommandsRespository", "Lcom/livpure/safedrink/dispenser/data/DispenserCommandsRepository;", "getDispenserCommandsRespository", "()Lcom/livpure/safedrink/dispenser/data/DispenserCommandsRepository;", "dispenserCommandsRespository$delegate", "dispenserStatus", "getDispenserStatus", "setDispenserStatus", "dispensing", "getDispensing", "setDispensing", "faultDescription", "getFaultDescription", "filterLife", "getFilterLife", "filterLifeImage", "getFilterLifeImage", "hardwareUpdate", "", "getHardwareUpdate", "hardwareVersion", "getHardwareVersion", "hotWaterImage", "getHotWaterImage", "hotWaterStatus", "getHotWaterStatus", "hotWaterTemprature", "getHotWaterTemprature", "setHotWaterTemprature", "hotWaterValue", "getHotWaterValue", "setHotWaterValue", "imageStatus", "Lcom/livpure/safedrink/dispenser/data/models/DispenserImageStatus;", "imeiNumber", "getImeiNumber", "setImeiNumber", "lastSynchronizedDate", "getLastSynchronizedDate", "setLastSynchronizedDate", "liveDispenserStatusImage", "getLiveDispenserStatusImage", "loadingStatus", "getLoadingStatus", "planDetails", "getPlanDetails", "planName", "getPlanName", "productType", "getProductType", "setProductType", "publishCommandStatus", "getPublishCommandStatus", "repository", "getRepository", "repository$delegate", "serialNumber", "getSerialNumber", "setSerialNumber", "softwareUpdate", "getSoftwareUpdate", "softwareVersion", "getSoftwareVersion", "subscriptionRepository", "Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "getSubscriptionRepository", "()Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "subscriptionRepository$delegate", "tdsImage", "getTdsImage", "tds_selected", "Lkotlin/Triple;", "getTds_selected", "setTds_selected", "tds_selected_image", "getTds_selected_image", "setTds_selected_image", "tempStatus", "getTempStatus", "setTempStatus", "usageStats", "", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "getUsageStats", "uvImage", "getUvImage", "warmWaterTemprature", "getWarmWaterTemprature", "setWarmWaterTemprature", "waterRemaining", "Lkotlin/Pair;", "getWaterRemaining", "wifiImage", "getWifiImage", "setWifiImage", "wifiImageOff", "getWifiImageOff", "setWifiImageOff", "bleStatus", "", "status", "getDashboardDetails", "getPendingBleCommand", "getSubmissionBLEStatus", "statusPkt", "powerPkt", "publishCommand", "command", "warmWater", "hotWater", "tds", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeDispenserAtlanticModel extends MediatorViewModel {
    private final Lazy BLECommands$delegate;
    private final Lazy BLERepository$delegate;
    private DeviceList _device;
    private AirPurifierPublishCommand airCommand;
    private AirPurifierCommand airPurifierCommand;
    private final Lazy airPurifierCommandsRespository$delegate;
    private LiveData<Integer> bleImage;
    private LiveData<Integer> bleImageOff;
    private final MediatorLiveData<BoltCommandsResponse> boltCommandsResponse;
    private final LiveData<Integer> coldWaterImage;
    private final MutableLiveData<String> coldWaterStatus;
    private String coldWaterValue;
    private final MutableLiveData<DashboardDetailsResponse> dashboardData;
    private DeviceList device;
    private final LiveData<Integer> disinfectionImage;
    private DispenserPublishCommand dispenseCommand;
    private DispenserCommands dispenserCommand;
    private final MutableLiveData<String> faultDescription;
    private final MutableLiveData<String> filterLife;
    private final LiveData<Integer> filterLifeImage;
    private final LiveData<Boolean> hardwareUpdate;
    private final LiveData<String> hardwareVersion;
    private final LiveData<Integer> hotWaterImage;
    private final MutableLiveData<String> hotWaterStatus;
    private String hotWaterValue;
    private DispenserImageStatus imageStatus;
    private LiveData<String> lastSynchronizedDate;
    private final LiveData<Integer> liveDispenserStatusImage;
    private final LiveData<Boolean> loadingStatus;
    private final LiveData<String> planDetails;
    private final MutableLiveData<String> planName;
    private LiveData<String> productType;
    private final MutableLiveData<String> publishCommandStatus;
    private final LiveData<Boolean> softwareUpdate;
    private final LiveData<String> softwareVersion;
    private final LiveData<Integer> tdsImage;
    private LiveData<Triple<Integer, Integer, Integer>> tds_selected;
    private LiveData<Integer> tds_selected_image;
    private final LiveData<Triple<List<String>, List<IBarDataSet>, String>> usageStats;
    private final LiveData<Integer> uvImage;
    private final LiveData<Pair<String, Integer>> waterRemaining;
    private LiveData<Integer> wifiImage;
    private LiveData<Integer> wifiImageOff;
    private final Lazy repository$delegate = LazyKt.lazy(new Function0<DispenserCommandsRepository>() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$repository$2
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
    private String dispensing = "";
    private String disinfection = "";
    private String hotWaterTemprature = "";
    private String warmWaterTemprature = "";
    private String tempStatus = "";
    private final Lazy subscriptionRepository$delegate = LazyKt.lazy(new Function0<SubscriptionRepository>() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$subscriptionRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SubscriptionRepository invoke() {
            return new SubscriptionRepository();
        }
    });
    private final Lazy dispenserCommandsRespository$delegate = LazyKt.lazy(new Function0<DispenserCommandsRepository>() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$dispenserCommandsRespository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DispenserCommandsRepository invoke() {
            return new DispenserCommandsRepository();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadingStatus$lambda-15  reason: not valid java name */
    public static final Boolean m666loadingStatus$lambda15(Boolean bool) {
        return bool;
    }

    public HomeDispenserAtlanticModel() {
        MutableLiveData<DashboardDetailsResponse> mutableLiveData = new MutableLiveData<>();
        this.dashboardData = mutableLiveData;
        this.boltCommandsResponse = new MediatorLiveData<>();
        this.BLERepository$delegate = LazyKt.lazy(new Function0<BoltDataUpdateRepository>() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$BLERepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BoltDataUpdateRepository invoke() {
                return new BoltDataUpdateRepository();
            }
        });
        this.BLECommands$delegate = LazyKt.lazy(new Function0<BoltBleCommandsRespository>() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$BLECommands$2
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
        this.hotWaterStatus = mutableLiveData3;
        MutableLiveData<String> mutableLiveData4 = new MutableLiveData<>();
        mutableLiveData4.setValue("");
        this.coldWaterStatus = mutableLiveData4;
        this.hotWaterValue = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.coldWaterValue = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        MutableLiveData<String> mutableLiveData5 = new MutableLiveData<>();
        mutableLiveData5.setValue("");
        this.filterLife = mutableLiveData5;
        MutableLiveData<String> mutableLiveData6 = new MutableLiveData<>();
        mutableLiveData6.setValue("");
        this.planName = mutableLiveData6;
        this.airPurifierCommandsRespository$delegate = LazyKt.lazy(new Function0<AirPurifierCommandsRespository>() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$airPurifierCommandsRespository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AirPurifierCommandsRespository invoke() {
                return new AirPurifierCommandsRespository();
            }
        });
        this.publishCommandStatus = new MutableLiveData<>();
        LiveData<String> map = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda21
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m664lastSynchronizedDate$lambda6;
                m664lastSynchronizedDate$lambda6 = HomeDispenserAtlanticModel.m664lastSynchronizedDate$lambda6((DashboardDetailsResponse) obj);
                return m664lastSynchronizedDate$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.lastSynchronizedDate = map;
        LiveData<String> map2 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda10
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m668productType$lambda8;
                m668productType$lambda8 = HomeDispenserAtlanticModel.m668productType$lambda8((DashboardDetailsResponse) obj);
                return m668productType$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.productType = map2;
        LiveData<Triple<Integer, Integer, Integer>> map3 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda6
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Triple m673tds_selected$lambda9;
                m673tds_selected$lambda9 = HomeDispenserAtlanticModel.m673tds_selected$lambda9((DashboardDetailsResponse) obj);
                return m673tds_selected$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map3, "map(dashboardData) {\n   …selected)\n        }\n    }");
        this.tds_selected = map3;
        LiveData<Integer> map4 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda20
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m674tds_selected_image$lambda10;
                m674tds_selected_image$lambda10 = HomeDispenserAtlanticModel.m674tds_selected_image$lambda10((DashboardDetailsResponse) obj);
                return m674tds_selected_image$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map4, "map(dashboardData) {\n   …s_2_image\n        }\n    }");
        this.tds_selected_image = map4;
        LiveData<Integer> map5 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda11
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m678wifiImage$lambda11;
                m678wifiImage$lambda11 = HomeDispenserAtlanticModel.m678wifiImage$lambda11((DashboardDetailsResponse) obj);
                return m678wifiImage$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map5, "map(dashboardData) {\n        R.drawable.wifi\n    }");
        this.wifiImage = map5;
        LiveData<Integer> map6 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda9
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m652bleImage$lambda12;
                m652bleImage$lambda12 = HomeDispenserAtlanticModel.m652bleImage$lambda12((DashboardDetailsResponse) obj);
                return m652bleImage$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map6, "map(dashboardData) {\n   ….drawable.bluetooth\n    }");
        this.bleImage = map6;
        LiveData<Integer> map7 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda23
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m679wifiImageOff$lambda13;
                m679wifiImageOff$lambda13 = HomeDispenserAtlanticModel.m679wifiImageOff$lambda13((DashboardDetailsResponse) obj);
                return m679wifiImageOff$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map7, "map(dashboardData) {\n   …R.drawable.wifi_off\n    }");
        this.wifiImageOff = map7;
        LiveData<Integer> map8 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda1
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m653bleImageOff$lambda14;
                m653bleImageOff$lambda14 = HomeDispenserAtlanticModel.m653bleImageOff$lambda14((DashboardDetailsResponse) obj);
                return m653bleImageOff$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map8, "map(dashboardData) {\n   …wable.bluetooth_off\n    }");
        this.bleImageOff = map8;
        LiveData<Boolean> map9 = Transformations.map(getLoading(), new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda15
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m666loadingStatus$lambda15;
                m666loadingStatus$lambda15 = HomeDispenserAtlanticModel.m666loadingStatus$lambda15((Boolean) obj);
                return m666loadingStatus$lambda15;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map9, "map(loading) {\n        it\n    }");
        this.loadingStatus = map9;
        LiveData<Integer> map10 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda3
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m665liveDispenserStatusImage$lambda17;
                m665liveDispenserStatusImage$lambda17 = HomeDispenserAtlanticModel.m665liveDispenserStatusImage$lambda17((DashboardDetailsResponse) obj);
                return m665liveDispenserStatusImage$lambda17;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map10, "map(dashboardData) {\n   …dispense\n        }\n\n    }");
        this.liveDispenserStatusImage = map10;
        LiveData<Integer> map11 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda5
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m656disinfectionImage$lambda18;
                m656disinfectionImage$lambda18 = HomeDispenserAtlanticModel.m656disinfectionImage$lambda18((DashboardDetailsResponse) obj);
                return m656disinfectionImage$lambda18;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map11, "map(dashboardData) {\n   …ction_off\n        }\n    }");
        this.disinfectionImage = map11;
        LiveData<Pair<String, Integer>> map12 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda14
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Pair m677waterRemaining$lambda19;
                m677waterRemaining$lambda19 = HomeDispenserAtlanticModel.m677waterRemaining$lambda19((DashboardDetailsResponse) obj);
                return m677waterRemaining$lambda19;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map12, "map(dashboardData) {\n   …0\", null)\n        }\n    }");
        this.waterRemaining = map12;
        LiveData<Integer> map13 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda26
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m676uvImage$lambda20;
                m676uvImage$lambda20 = HomeDispenserAtlanticModel.m676uvImage$lambda20((DashboardDetailsResponse) obj);
                return m676uvImage$lambda20;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map13, "map(dashboardData) {\n   …  R.drawable.uv_off\n    }");
        this.uvImage = map13;
        LiveData<Integer> map14 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda24
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m663hotWaterImage$lambda21;
                m663hotWaterImage$lambda21 = HomeDispenserAtlanticModel.m663hotWaterImage$lambda21((DashboardDetailsResponse) obj);
                return m663hotWaterImage$lambda21;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map14, "map(dashboardData) {\n   …water_off\n        }\n    }");
        this.hotWaterImage = map14;
        LiveData<Integer> map15 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda7
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m655coldWaterImage$lambda22;
                m655coldWaterImage$lambda22 = HomeDispenserAtlanticModel.m655coldWaterImage$lambda22((DashboardDetailsResponse) obj);
                return m655coldWaterImage$lambda22;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map15, "map(dashboardData) {\n   …water_off\n        }\n    }");
        this.coldWaterImage = map15;
        LiveData<Integer> map16 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda12
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m672tdsImage$lambda23;
                m672tdsImage$lambda23 = HomeDispenserAtlanticModel.m672tdsImage$lambda23((DashboardDetailsResponse) obj);
                return m672tdsImage$lambda23;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map16, "map(dashboardData) {\n   …drawable.tds_band_1\n    }");
        this.tdsImage = map16;
        LiveData<String> map17 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda4
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m667planDetails$lambda24;
                m667planDetails$lambda24 = HomeDispenserAtlanticModel.m667planDetails$lambda24((DashboardDetailsResponse) obj);
                return m667planDetails$lambda24;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map17, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.planDetails = map17;
        LiveData<Integer> map18 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda27
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m657filterLifeImage$lambda25;
                m657filterLifeImage$lambda25 = HomeDispenserAtlanticModel.m657filterLifeImage$lambda25((DashboardDetailsResponse) obj);
                return m657filterLifeImage$lambda25;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map18, "map(dashboardData) {\n   …       -1\n        }\n    }");
        this.filterLifeImage = map18;
        LiveData<Boolean> map19 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda25
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m661hardwareUpdate$lambda26;
                m661hardwareUpdate$lambda26 = HomeDispenserAtlanticModel.m661hardwareUpdate$lambda26((DashboardDetailsResponse) obj);
                return m661hardwareUpdate$lambda26;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map19, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.hardwareUpdate = map19;
        LiveData<Boolean> map20 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda22
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m670softwareUpdate$lambda27;
                m670softwareUpdate$lambda27 = HomeDispenserAtlanticModel.m670softwareUpdate$lambda27((DashboardDetailsResponse) obj);
                return m670softwareUpdate$lambda27;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map20, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.softwareUpdate = map20;
        LiveData<String> map21 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda13
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m662hardwareVersion$lambda28;
                m662hardwareVersion$lambda28 = HomeDispenserAtlanticModel.m662hardwareVersion$lambda28((DashboardDetailsResponse) obj);
                return m662hardwareVersion$lambda28;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map21, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.hardwareVersion = map21;
        LiveData<String> map22 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda8
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m671softwareVersion$lambda29;
                m671softwareVersion$lambda29 = HomeDispenserAtlanticModel.m671softwareVersion$lambda29((DashboardDetailsResponse) obj);
                return m671softwareVersion$lambda29;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map22, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.softwareVersion = map22;
        LiveData<Triple<List<String>, List<IBarDataSet>, String>> map23 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda2
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Triple m675usageStats$lambda30;
                m675usageStats$lambda30 = HomeDispenserAtlanticModel.m675usageStats$lambda30((DashboardDetailsResponse) obj);
                return m675usageStats$lambda30;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map23, "map(dashboardData) {\n   …null, \"\")\n        }\n    }");
        this.usageStats = map23;
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

    public final String getDispensing() {
        return this.dispensing;
    }

    public final void setDispensing(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dispensing = str;
    }

    public final String getDisinfection() {
        return this.disinfection;
    }

    public final void setDisinfection(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.disinfection = str;
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

    public final MutableLiveData<String> getHotWaterStatus() {
        return this.hotWaterStatus;
    }

    public final MutableLiveData<String> getColdWaterStatus() {
        return this.coldWaterStatus;
    }

    public final String getHotWaterValue() {
        return this.hotWaterValue;
    }

    public final void setHotWaterValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hotWaterValue = str;
    }

    public final String getColdWaterValue() {
        return this.coldWaterValue;
    }

    public final void setColdWaterValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coldWaterValue = str;
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

    public final void publishCommand(String command, String warmWater, String hotWater, String tds) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(warmWater, "warmWater");
        Intrinsics.checkNotNullParameter(hotWater, "hotWater");
        Intrinsics.checkNotNullParameter(tds, "tds");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            DispenserPublishCommand dispenserPublishCommand = new DispenserPublishCommand(command, warmWater, hotWater, tds);
            this.dispenseCommand = dispenserPublishCommand;
            this.dispenserCommand = new DispenserCommands(this.imeiNumber, dispenserPublishCommand);
            try {
                DispenserCommandsRepository dispenserCommandsRespository = getDispenserCommandsRespository();
                DispenserCommands dispenserCommands = this.dispenserCommand;
                if (dispenserCommands == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dispenserCommand");
                    dispenserCommands = null;
                }
                observeAndTrack(dispenserCommandsRespository.sendDispenserCommand(dispenserCommands), new Observer() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda17
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeDispenserAtlanticModel.m669publishCommand$lambda5(HomeDispenserAtlanticModel.this, (BaseDataHolder) obj);
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
    /* renamed from: publishCommand$lambda-5  reason: not valid java name */
    public static final void m669publishCommand$lambda5(HomeDispenserAtlanticModel this$0, BaseDataHolder baseDataHolder) {
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
    /* renamed from: lastSynchronizedDate$lambda-6  reason: not valid java name */
    public static final String m664lastSynchronizedDate$lambda6(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getLastSyncDate() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getLastSyncDate() : "";
    }

    public final void bleStatus(final String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getBLERepository().sendBoltConfigtRequest(this.serialNumber, status, false), new Observer() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda19
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeDispenserAtlanticModel.m654bleStatus$lambda7(HomeDispenserAtlanticModel.this, status, (BaseDataHolder) obj);
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
    /* renamed from: bleStatus$lambda-7  reason: not valid java name */
    public static final void m654bleStatus$lambda7(HomeDispenserAtlanticModel this$0, String status, BaseDataHolder baseDataHolder) {
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
    /* renamed from: productType$lambda-8  reason: not valid java name */
    public static final String m668productType$lambda8(DashboardDetailsResponse dashboardDetailsResponse) {
        ProductStats productStats;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return ((dashboardDetails == null || (productStats = dashboardDetails.getProductStats()) == null) ? null : productStats.getProductType()) != null ? dashboardDetailsResponse.getDashboardDetails().getProductStats().getProductType() : "";
    }

    public final LiveData<Triple<Integer, Integer, Integer>> getTds_selected() {
        return this.tds_selected;
    }

    public final void setTds_selected(LiveData<Triple<Integer, Integer, Integer>> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.tds_selected = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: tds_selected$lambda-9  reason: not valid java name */
    public static final Triple m673tds_selected$lambda9(DashboardDetailsResponse dashboardDetailsResponse) {
        DispenserRoSetting dispenserRoSetting;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if (((dashboardDetails == null || (dispenserRoSetting = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting.getTds()) != null) {
            if (Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTds(), "1")) {
                return new Triple(Integer.valueOf((int) R.drawable.ic_tds_1_selected), Integer.valueOf((int) R.drawable.ic_tds_2_unselected), Integer.valueOf((int) R.drawable.ic_tds_3_unselected));
            }
            if (Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTds(), ExifInterface.GPS_MEASUREMENT_2D)) {
                return new Triple(Integer.valueOf((int) R.drawable.ic_tds_1_unselected), Integer.valueOf((int) R.drawable.ic_tds_2_selected), Integer.valueOf((int) R.drawable.ic_tds_3_unselected));
            }
            if (Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTds(), ExifInterface.GPS_MEASUREMENT_3D)) {
                return new Triple(Integer.valueOf((int) R.drawable.ic_tds_1_unselected), Integer.valueOf((int) R.drawable.ic_tds_2_unselected), Integer.valueOf((int) R.drawable.ic_tds_3_selected));
            }
            return new Triple(Integer.valueOf((int) R.drawable.ic_tds_1_unselected), Integer.valueOf((int) R.drawable.ic_tds_2_unselected), Integer.valueOf((int) R.drawable.ic_tds_3_unselected));
        }
        return new Triple(Integer.valueOf((int) R.drawable.ic_tds_1_unselected), Integer.valueOf((int) R.drawable.ic_tds_2_unselected), Integer.valueOf((int) R.drawable.ic_tds_3_unselected));
    }

    public final LiveData<Integer> getTds_selected_image() {
        return this.tds_selected_image;
    }

    public final void setTds_selected_image(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.tds_selected_image = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: tds_selected_image$lambda-10  reason: not valid java name */
    public static final Integer m674tds_selected_image$lambda10(DashboardDetailsResponse dashboardDetailsResponse) {
        DispenserRoSetting dispenserRoSetting;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        String tds = (dashboardDetails == null || (dispenserRoSetting = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting.getTds();
        int i = R.drawable.ic_tds_2_image;
        if (tds != null) {
            if (Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTds(), "1")) {
                i = R.drawable.ic_tds_1_image;
            } else if (!Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTds(), ExifInterface.GPS_MEASUREMENT_2D) && Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getTds(), ExifInterface.GPS_MEASUREMENT_3D)) {
                i = R.drawable.ic_tds_3_image;
            }
        }
        return Integer.valueOf(i);
    }

    public final LiveData<Integer> getWifiImage() {
        return this.wifiImage;
    }

    public final void setWifiImage(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.wifiImage = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: wifiImage$lambda-11  reason: not valid java name */
    public static final Integer m678wifiImage$lambda11(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: bleImage$lambda-12  reason: not valid java name */
    public static final Integer m652bleImage$lambda12(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: wifiImageOff$lambda-13  reason: not valid java name */
    public static final Integer m679wifiImageOff$lambda13(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: bleImageOff$lambda-14  reason: not valid java name */
    public static final Integer m653bleImageOff$lambda14(DashboardDetailsResponse dashboardDetailsResponse) {
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
                observeAndTrack(getSubscriptionRepository().getDashboardDetails(this.serialNumber), new Observer() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda18
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeDispenserAtlanticModel.m658getDashboardDetails$lambda16(HomeDispenserAtlanticModel.this, (DashboardDetailsResponse) obj);
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
    /* renamed from: getDashboardDetails$lambda-16  reason: not valid java name */
    public static final void m658getDashboardDetails$lambda16(final HomeDispenserAtlanticModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(dashboardDetailsResponse, new Function1<DashboardDetailsResponse, Unit>() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$getDashboardDetails$1$1
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
                DispenserRoSetting dispenserRoSetting5;
                DispenserRoSetting dispenserRoSetting6;
                DispenserRoSetting dispenserRoSetting7;
                DispenserRoSetting dispenserRoSetting8;
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                mutableLiveData = HomeDispenserAtlanticModel.this.dashboardData;
                mutableLiveData.setValue(successfulResponse);
                MutableLiveData<String> faultDescription = HomeDispenserAtlanticModel.this.getFaultDescription();
                DashboardDetails dashboardDetails = successfulResponse.getDashboardDetails();
                String str = null;
                faultDescription.setValue(String.valueOf((dashboardDetails == null || (dispenserRoSetting8 = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting8.getFault()));
                HomeDispenserAtlanticModel homeDispenserAtlanticModel = HomeDispenserAtlanticModel.this;
                DashboardDetails dashboardDetails2 = successfulResponse.getDashboardDetails();
                homeDispenserAtlanticModel.setDispenserStatus(String.valueOf((dashboardDetails2 == null || (dispenserRoSetting7 = dashboardDetails2.getDispenserRoSetting()) == null) ? null : dispenserRoSetting7.getDespensing()));
                HomeDispenserAtlanticModel homeDispenserAtlanticModel2 = HomeDispenserAtlanticModel.this;
                DashboardDetails dashboardDetails3 = successfulResponse.getDashboardDetails();
                homeDispenserAtlanticModel2.setHotWaterTemprature(String.valueOf((dashboardDetails3 == null || (dispenserRoSetting6 = dashboardDetails3.getDispenserRoSetting()) == null) ? null : dispenserRoSetting6.getHotWater()));
                HomeDispenserAtlanticModel homeDispenserAtlanticModel3 = HomeDispenserAtlanticModel.this;
                DashboardDetails dashboardDetails4 = successfulResponse.getDashboardDetails();
                homeDispenserAtlanticModel3.setWarmWaterTemprature(String.valueOf((dashboardDetails4 == null || (dispenserRoSetting5 = dashboardDetails4.getDispenserRoSetting()) == null) ? null : dispenserRoSetting5.getWarmWater()));
                HomeDispenserAtlanticModel homeDispenserAtlanticModel4 = HomeDispenserAtlanticModel.this;
                DashboardDetails dashboardDetails5 = successfulResponse.getDashboardDetails();
                homeDispenserAtlanticModel4.setDispensing(String.valueOf((dashboardDetails5 == null || (dispenserRoSetting4 = dashboardDetails5.getDispenserRoSetting()) == null) ? null : dispenserRoSetting4.getBottleDisinfection()));
                HomeDispenserAtlanticModel homeDispenserAtlanticModel5 = HomeDispenserAtlanticModel.this;
                DashboardDetails dashboardDetails6 = successfulResponse.getDashboardDetails();
                homeDispenserAtlanticModel5.setDisinfection(String.valueOf((dashboardDetails6 == null || (dispenserRoSetting3 = dashboardDetails6.getDispenserRoSetting()) == null) ? null : dispenserRoSetting3.getBottleDisinfection()));
                DashboardDetails dashboardDetails7 = successfulResponse.getDashboardDetails();
                if (Intrinsics.areEqual((dashboardDetails7 == null || (dispenserRoSetting2 = dashboardDetails7.getDispenserRoSetting()) == null) ? null : dispenserRoSetting2.getHeaterStatus(), AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    HomeDispenserAtlanticModel.this.getHotWaterStatus().setValue("Hot water off");
                    HomeDispenserAtlanticModel.this.setHotWaterValue(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                } else {
                    HomeDispenserAtlanticModel.this.getHotWaterStatus().setValue("Hot water On");
                    HomeDispenserAtlanticModel.this.setHotWaterValue("1");
                }
                DashboardDetails dashboardDetails8 = successfulResponse.getDashboardDetails();
                if (dashboardDetails8 != null && (dispenserRoSetting = dashboardDetails8.getDispenserRoSetting()) != null) {
                    str = dispenserRoSetting.getCoolingStatus();
                }
                if (Intrinsics.areEqual(str, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    HomeDispenserAtlanticModel.this.getColdWaterStatus().setValue("Cold water off");
                    HomeDispenserAtlanticModel.this.setColdWaterValue(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    return;
                }
                HomeDispenserAtlanticModel.this.getColdWaterStatus().setValue("Cold water On");
                HomeDispenserAtlanticModel.this.setColdWaterValue("1");
            }
        }, new Function1<DashboardDetailsResponse, Unit>() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$getDashboardDetails$1$2
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
                toastMessageLiveData = HomeDispenserAtlanticModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Oops! We faced an issue while fetching your dashboard details at this time."));
            }
        });
    }

    public final LiveData<Integer> getLiveDispenserStatusImage() {
        return this.liveDispenserStatusImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveDispenserStatusImage$lambda-17  reason: not valid java name */
    public static final Integer m665liveDispenserStatusImage$lambda17(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        DispenserRoSetting dispenserRoSetting = dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null;
        int i = R.drawable.cont_dispense;
        if (dispenserRoSetting != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing() != null && !Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing(), "") && Integer.parseInt(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing()) == 1) {
            i = R.drawable.cont_dispense_sel;
        }
        return Integer.valueOf(i);
    }

    public final LiveData<Integer> getDisinfectionImage() {
        return this.disinfectionImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: disinfectionImage$lambda-18  reason: not valid java name */
    public static final Integer m656disinfectionImage$lambda18(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        DispenserRoSetting dispenserRoSetting = dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null;
        int i = R.drawable.ic_disinfection_off;
        if (dispenserRoSetting != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing() != null && !Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing(), "")) {
            String bottleDisinfection = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getBottleDisinfection();
            if ((bottleDisinfection != null ? Integer.parseInt(bottleDisinfection) : 0) == 1) {
                i = R.drawable.ic_disinfection;
            }
        }
        return Integer.valueOf(i);
    }

    public final LiveData<Pair<String, Integer>> getWaterRemaining() {
        return this.waterRemaining;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: waterRemaining$lambda-19  reason: not valid java name */
    public static final Pair m677waterRemaining$lambda19(DashboardDetailsResponse dashboardDetailsResponse) {
        String remainingLitres;
        String padStart;
        String remainingLitres2;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getUsage() : null) != null) {
            ProductStats productStats = dashboardDetailsResponse.getDashboardDetails().getProductStats();
            if ((productStats != null ? productStats.getProductType() : null) == null ? (remainingLitres = dashboardDetailsResponse.getDashboardDetails().getUsage().getRemainingLitres()) == null || (padStart = StringsKt.padStart(remainingLitres, 6, '0')) == null : (remainingLitres2 = dashboardDetailsResponse.getDashboardDetails().getUsage().getRemainingLitres()) == null || (padStart = StringsKt.padStart(remainingLitres2, 6, '0')) == null) {
                padStart = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            try {
                long parseLong = Long.parseLong(padStart);
                return new Pair(padStart, Integer.valueOf(parseLong > 40 ? R.drawable.fullwaterlarge : parseLong > 10 ? R.drawable.purifyinglarge : R.drawable.emptywaterlarge));
            } catch (Exception unused) {
                return new Pair(AppEventsConstants.EVENT_PARAM_VALUE_NO, Integer.valueOf((int) R.drawable.emptywaterlarge));
            }
        }
        return new Pair(AppEventsConstants.EVENT_PARAM_VALUE_NO, null);
    }

    public final LiveData<Integer> getUvImage() {
        return this.uvImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: uvImage$lambda-20  reason: not valid java name */
    public static final Integer m676uvImage$lambda20(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null) != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getUv() != null) {
            if (dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getUv().length() > 0) {
                Integer.parseInt(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getUv());
            }
        }
        return Integer.valueOf((int) R.drawable.uv_off);
    }

    public final LiveData<Integer> getHotWaterImage() {
        return this.hotWaterImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hotWaterImage$lambda-21  reason: not valid java name */
    public static final Integer m663hotWaterImage$lambda21(DashboardDetailsResponse dashboardDetailsResponse) {
        int parseInt;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        DispenserRoSetting dispenserRoSetting = dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null;
        int i = R.drawable.ic_hotwater_off;
        if (dispenserRoSetting != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getHeaterStatus() != null && (parseInt = Integer.parseInt(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getHeaterStatus())) != 0 && parseInt == 1) {
            i = R.drawable.ic_hot_water;
        }
        return Integer.valueOf(i);
    }

    public final LiveData<Integer> getColdWaterImage() {
        return this.coldWaterImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: coldWaterImage$lambda-22  reason: not valid java name */
    public static final Integer m655coldWaterImage$lambda22(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        DispenserRoSetting dispenserRoSetting = dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null;
        int i = R.drawable.ic_coldwater_off;
        if (dispenserRoSetting != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getHeaterStatus() != null) {
            String coolingStatus = dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getCoolingStatus();
            int parseInt = coolingStatus != null ? Integer.parseInt(coolingStatus) : 0;
            if (parseInt != 0 && parseInt == 1) {
                i = R.drawable.ic_cold_water;
            }
        }
        return Integer.valueOf(i);
    }

    public final LiveData<Integer> getTdsImage() {
        return this.tdsImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: tdsImage$lambda-23  reason: not valid java name */
    public static final Integer m672tdsImage$lambda23(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: planDetails$lambda-24  reason: not valid java name */
    public static final String m667planDetails$lambda24(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: filterLifeImage$lambda-25  reason: not valid java name */
    public static final Integer m657filterLifeImage$lambda25(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: hardwareUpdate$lambda-26  reason: not valid java name */
    public static final Boolean m661hardwareUpdate$lambda26(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getHardwareVersion() : false);
    }

    public final LiveData<Boolean> getSoftwareUpdate() {
        return this.softwareUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: softwareUpdate$lambda-27  reason: not valid java name */
    public static final Boolean m670softwareUpdate$lambda27(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getSoftwareVersion() : false);
    }

    public final LiveData<String> getHardwareVersion() {
        return this.hardwareVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hardwareVersion$lambda-28  reason: not valid java name */
    public static final String m662hardwareVersion$lambda28(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getCurrentHardwareVersion() : "";
    }

    public final LiveData<String> getSoftwareVersion() {
        return this.softwareVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: softwareVersion$lambda-29  reason: not valid java name */
    public static final String m671softwareVersion$lambda29(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getCurrentSoftwareVersion() : "";
    }

    public final LiveData<Triple<List<String>, List<IBarDataSet>, String>> getUsageStats() {
        return this.usageStats;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: usageStats$lambda-30  reason: not valid java name */
    public static final Triple m675usageStats$lambda30(DashboardDetailsResponse dashboardDetailsResponse) {
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
            return Transformations.map(getBLERepository().sendBoltConfigtRequest(this.serialNumber, statusPkt, false), new Function() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Boolean m660getSubmissionBLEStatus$lambda31;
                    m660getSubmissionBLEStatus$lambda31 = HomeDispenserAtlanticModel.m660getSubmissionBLEStatus$lambda31((BaseDataHolder) obj);
                    return m660getSubmissionBLEStatus$lambda31;
                }
            });
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSubmissionBLEStatus$lambda-31  reason: not valid java name */
    public static final Boolean m660getSubmissionBLEStatus$lambda31(BaseDataHolder baseDataHolder) {
        return Boolean.valueOf(baseDataHolder.getStatus());
    }

    public final void getPendingBleCommand() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            this.boltCommandsResponse.addSource(getBLECommands().getBoltBleCommands(this.serialNumber), new Observer() { // from class: com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel$$ExternalSyntheticLambda16
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeDispenserAtlanticModel.m659getPendingBleCommand$lambda32(HomeDispenserAtlanticModel.this, (BaseDataHolder) obj);
                }
            });
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPendingBleCommand$lambda-32  reason: not valid java name */
    public static final void m659getPendingBleCommand$lambda32(HomeDispenserAtlanticModel this$0, BaseDataHolder baseDataHolder) {
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

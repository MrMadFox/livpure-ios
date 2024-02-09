package com.livpure.safedrink.dispenser.model;

import android.content.Context;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.livpure.safedrink.R;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.bolt.data.BoltBleCommandsRespository;
import com.livpure.safedrink.bolt.data.BoltDataUpdateRepository;
import com.livpure.safedrink.bolt.data.models.BoltCommandsResponse;
import com.livpure.safedrink.bolt.data.models.RechargeResponse;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.dispenser.data.BLECommandListRepository;
import com.livpure.safedrink.dispenser.data.DispenserCommandsRepository;
import com.livpure.safedrink.dispenser.data.DispenserOflineRepository;
import com.livpure.safedrink.dispenser.data.EnvyBLEResponseRepository;
import com.livpure.safedrink.dispenser.data.models.DispenserCommands;
import com.livpure.safedrink.dispenser.data.models.DispenserPublishCommand;
import com.livpure.safedrink.dispenser.data.models.EnvyBLEResponse;
import com.livpure.safedrink.dispenser.data.models.EnvyDashbordOffline;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.subscription.plan.data.DispenserRoSetting;
import com.livpure.safedrink.subscription.plan.data.SubscriptionRepository;
import com.livpure.safedrink.subscription.plan.data.model.DashboardDetailsResponse;
import com.livpure.safedrink.subscription.plan.data.model.SerialNumberUpdateResponse;
import com.livpure.safedrink.subscription.plan.data.model.SubscriptionDetails;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.DailyConsumptionItem;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.DashboardDetails;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.ProductStats;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
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
/* compiled from: UnlimitedWaterHomeModel.kt */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u0099\u0001\u001a\u00020\u00152\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001J\u001d\u0010\u009c\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0K0!2\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001J\u001d\u0010\u009d\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020p0K0!2\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001J\u001d\u0010\u009e\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0K0!2\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001J\u0012\u0010\u009f\u0001\u001a\u00030\u0098\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001J\u0012\u0010 \u0001\u001a\u00030\u0098\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001J\u0011\u0010¡\u0001\u001a\u00030\u0098\u00012\u0007\u0010¢\u0001\u001a\u00020\u0015J-\u0010£\u0001\u001a\u00030\u0098\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0007\u0010¤\u0001\u001a\u00020\u00152\u0007\u0010\u0099\u0001\u001a\u00020\u00152\u0007\u0010¥\u0001\u001a\u00020\u001bJ\u0010\u0010¦\u0001\u001a\u00020\"2\u0007\u0010§\u0001\u001a\u00020\u0015J\u0010\u0010¨\u0001\u001a\u00020\"2\u0007\u0010§\u0001\u001a\u00020\u0015J#\u0010©\u0001\u001a\u00030\u0098\u00012\u0007\u0010ª\u0001\u001a\u00020\u00152\u0007\u0010«\u0001\u001a\u00020\u00152\u0007\u0010¬\u0001\u001a\u00020\u0015J\u001a\u0010\u00ad\u0001\u001a\u00030\u0098\u00012\u0007\u0010®\u0001\u001a\u00020\u00152\u0007\u0010¯\u0001\u001a\u00020\u0015R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010'\u001a\b\u0012\u0004\u0012\u00020\"0!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020403X\u0082\u0004¢\u0006\u0002\n\u0000R(\u00106\u001a\u0004\u0018\u00010\u000f2\b\u00105\u001a\u0004\u0018\u00010\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0011\"\u0004\b8\u0010\u0013R\u001a\u00109\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010@\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\b\u001a\u0004\bB\u0010CR\u001a\u0010E\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0017\"\u0004\bG\u0010\u0019R\u000e\u0010H\u001a\u00020IX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0K0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082.¢\u0006\u0002\n\u0000R\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001503¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001503¢\u0006\b\n\u0000\u001a\u0004\bR\u0010PR\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\b\n\u0000\u001a\u0004\bT\u0010$R\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001b0!¢\u0006\b\n\u0000\u001a\u0004\bV\u0010$R\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00150!¢\u0006\b\n\u0000\u001a\u0004\bX\u0010$R\u000e\u0010Y\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Z\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0017\"\u0004\b\\\u0010\u0019R \u0010]\u001a\b\u0012\u0004\u0012\u00020\u00150!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010$\"\u0004\b_\u0010&R\u001a\u0010`\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0017\"\u0004\bb\u0010\u0019R\u0017\u0010c\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\b\n\u0000\u001a\u0004\bd\u0010$R\u001a\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0K0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00150!¢\u0006\b\n\u0000\u001a\u0004\bg\u0010$R\u0017\u0010h\u001a\b\u0012\u0004\u0012\u00020\u001503¢\u0006\b\n\u0000\u001a\u0004\bi\u0010PR \u0010j\u001a\b\u0012\u0004\u0012\u00020\u00150!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010$\"\u0004\bl\u0010&R\u0017\u0010m\u001a\b\u0012\u0004\u0012\u00020\u001503¢\u0006\b\n\u0000\u001a\u0004\bn\u0010PR\u001d\u0010o\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020p0K0+¢\u0006\b\n\u0000\u001a\u0004\bq\u0010.R\u0017\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00150!¢\u0006\b\n\u0000\u001a\u0004\bs\u0010$R\u001a\u0010t\u001a\u00020uX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR \u0010z\u001a\b\u0012\u0004\u0012\u00020\u001b0!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010$\"\u0004\b|\u0010&R\u001a\u0010}\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0017\"\u0004\b\u007f\u0010\u0019R\u0019\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u001b0!¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010$R\u0019\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150!¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010$R \u0010\u0084\u0001\u001a\u00030\u0085\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0088\u0001\u0010\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R=\u0010\u0089\u0001\u001a,\u0012(\u0012&\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010K\u0012\r\u0012\u000b\u0012\u0005\u0012\u00030\u008b\u0001\u0018\u00010K\u0012\u0004\u0012\u00020\u00150\u008a\u00010!¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010$R\u001a\u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u00030\u008e\u000103¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010PR\u000f\u0010\u0090\u0001\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0091\u0001\u001a\u0017\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\"0\u0092\u00010!¢\u0006\t\n\u0000\u001a\u0005\b\u0093\u0001\u0010$R#\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020\"0!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010$\"\u0005\b\u0096\u0001\u0010&¨\u0006°\u0001²\u0006\f\u0010±\u0001\u001a\u00030²\u0001X\u008a\u0084\u0002²\u0006\f\u0010³\u0001\u001a\u00030´\u0001X\u008a\u0084\u0002²\u0006\f\u0010µ\u0001\u001a\u00030¶\u0001X\u008a\u0084\u0002²\u0006\f\u0010±\u0001\u001a\u00030²\u0001X\u008a\u0084\u0002²\u0006\f\u0010µ\u0001\u001a\u00030¶\u0001X\u008a\u0084\u0002²\u0006\f\u0010±\u0001\u001a\u00030²\u0001X\u008a\u0084\u0002²\u0006\f\u0010³\u0001\u001a\u00030´\u0001X\u008a\u0084\u0002²\u0006\f\u0010³\u0001\u001a\u00030´\u0001X\u008a\u0084\u0002"}, d2 = {"Lcom/livpure/safedrink/dispenser/model/UnlimitedWaterHomeModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "BLECommands", "Lcom/livpure/safedrink/bolt/data/BoltBleCommandsRespository;", "getBLECommands", "()Lcom/livpure/safedrink/bolt/data/BoltBleCommandsRespository;", "BLECommands$delegate", "Lkotlin/Lazy;", "BLERepository", "Lcom/livpure/safedrink/bolt/data/BoltDataUpdateRepository;", "getBLERepository", "()Lcom/livpure/safedrink/bolt/data/BoltDataUpdateRepository;", "BLERepository$delegate", "_device", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "get_device", "()Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "set_device", "(Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;)V", "_productType", "", "get_productType", "()Ljava/lang/String;", "set_productType", "(Ljava/lang/String;)V", "allowTopup", "", "getAllowTopup", "()Z", "setAllowTopup", "(Z)V", "bleImage", "Landroidx/lifecycle/LiveData;", "", "getBleImage", "()Landroidx/lifecycle/LiveData;", "setBleImage", "(Landroidx/lifecycle/LiveData;)V", "bleImageOff", "getBleImageOff", "setBleImageOff", "boltCommandsResponse", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/livpure/safedrink/bolt/data/models/BoltCommandsResponse;", "getBoltCommandsResponse", "()Landroidx/lifecycle/MediatorLiveData;", "connectivity", "getConnectivity", "setConnectivity", "dashboardData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/livpure/safedrink/subscription/plan/data/model/DashboardDetailsResponse;", "value", AndroidContextPlugin.DEVICE_KEY, "getDevice", "setDevice", "deviceSerialNumber", "getDeviceSerialNumber", "setDeviceSerialNumber", "dispenseCommand", "Lcom/livpure/safedrink/dispenser/data/models/DispenserPublishCommand;", "dispenserCommand", "Lcom/livpure/safedrink/dispenser/data/models/DispenserCommands;", "dispenserCommandsRespository", "Lcom/livpure/safedrink/dispenser/data/DispenserCommandsRepository;", "getDispenserCommandsRespository", "()Lcom/livpure/safedrink/dispenser/data/DispenserCommandsRepository;", "dispenserCommandsRespository$delegate", "dispenserStatus", "getDispenserStatus", "setDispenserStatus", "envyBLEResponse", "Lcom/livpure/safedrink/dispenser/data/models/EnvyBLEResponse;", "envyBLEResponseList", "", "envyDashbordOffline", "Lcom/livpure/safedrink/dispenser/data/models/EnvyDashbordOffline;", "faultDescription", "getFaultDescription", "()Landroidx/lifecycle/MutableLiveData;", "filterLife", "getFilterLife", "filterLifeImage", "getFilterLifeImage", "hardwareUpdate", "getHardwareUpdate", "hardwareVersion", "getHardwareVersion", "hotWaterTemprature", "imeiNumber", "getImeiNumber", "setImeiNumber", "lastSynchronizedDate", "getLastSynchronizedDate", "setLastSynchronizedDate", "lastSynchronizedOn", "getLastSynchronizedOn", "setLastSynchronizedOn", "liveDispenserStatus", "getLiveDispenserStatus", "offlineDashboard", "planDetails", "getPlanDetails", "planName", "getPlanName", "productType", "getProductType", "setProductType", "publishCommandStatus", "getPublishCommandStatus", "rechargeResponse", "Lcom/livpure/safedrink/bolt/data/models/RechargeResponse;", "getRechargeResponse", "referralCode", "getReferralCode", "remainingLitres", "", "getRemainingLitres", "()D", "setRemainingLitres", "(D)V", "scanSerialNo", "getScanSerialNo", "setScanSerialNo", "serialNo", "getSerialNo", "setSerialNo", "softwareUpdate", "getSoftwareUpdate", "softwareVersion", "getSoftwareVersion", "subscriptionRepository", "Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "getSubscriptionRepository", "()Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "subscriptionRepository$delegate", "usageStats", "Lkotlin/Triple;", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "getUsageStats", "user", "Lcom/livpure/safedrink/login/data/models/User;", "getUser", "warmWaterTemprature", "waterRemaining", "Lkotlin/Pair;", "getWaterRemaining", "wifiImage", "getWifiImage", "setWifiImage", "bleStatus", "", "status", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "getAllEnvyBLEResponse", "getAllOflineBLECommands", "getAllOflineDashboarData", "getDashboardDetails", "getPendingBleCommand", "getSerialNumberStatus", "roSerialNumber", "offlineBLEStatus", "serialNumber", "lastPacket", "offlineFilterLife", "reading", "offlineWaterTank", "publishCommand", "command", "warmWater", "hotWater", "updateLocationDetails", "latitude", "longitude", "app_productionRelease", "bleCommandListRepository", "Lcom/livpure/safedrink/dispenser/data/BLECommandListRepository;", "envyBLEResponseRepository", "Lcom/livpure/safedrink/dispenser/data/EnvyBLEResponseRepository;", "dispenserOflineRepository", "Lcom/livpure/safedrink/dispenser/data/DispenserOflineRepository;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnlimitedWaterHomeModel extends MediatorViewModel {
    private final Lazy BLECommands$delegate;
    private final Lazy BLERepository$delegate;
    private DeviceList _device;
    private boolean allowTopup;
    private LiveData<Integer> bleImage;
    private LiveData<Integer> bleImageOff;
    private final MediatorLiveData<BoltCommandsResponse> boltCommandsResponse;
    private final MutableLiveData<DashboardDetailsResponse> dashboardData;
    private DeviceList device;
    private DispenserPublishCommand dispenseCommand;
    private DispenserCommands dispenserCommand;
    private EnvyBLEResponse envyBLEResponse;
    private final MediatorLiveData<List<EnvyBLEResponse>> envyBLEResponseList;
    private EnvyDashbordOffline envyDashbordOffline;
    private final MutableLiveData<String> faultDescription;
    private final MutableLiveData<String> filterLife;
    private final LiveData<Integer> filterLifeImage;
    private final LiveData<Boolean> hardwareUpdate;
    private final LiveData<String> hardwareVersion;
    private LiveData<String> lastSynchronizedDate;
    private final LiveData<Integer> liveDispenserStatus;
    private final MediatorLiveData<List<EnvyDashbordOffline>> offlineDashboard;
    private final LiveData<String> planDetails;
    private final MutableLiveData<String> planName;
    private LiveData<String> productType;
    private final MutableLiveData<String> publishCommandStatus;
    private final MediatorLiveData<List<RechargeResponse>> rechargeResponse;
    private final LiveData<String> referralCode;
    private double remainingLitres;
    private LiveData<Boolean> scanSerialNo;
    private final LiveData<Boolean> softwareUpdate;
    private final LiveData<String> softwareVersion;
    private final LiveData<Triple<List<String>, List<IBarDataSet>, String>> usageStats;
    private final MutableLiveData<User> user;
    private final LiveData<Pair<String, Integer>> waterRemaining;
    private LiveData<Integer> wifiImage;
    private String imeiNumber = "";
    private String connectivity = "";
    private String dispenserStatus = "";
    private String serialNo = "";
    private String hotWaterTemprature = "";
    private String warmWaterTemprature = "";
    private String _productType = "";
    private String deviceSerialNumber = "";
    private String lastSynchronizedOn = "";
    private final Lazy subscriptionRepository$delegate = LazyKt.lazy(new Function0<SubscriptionRepository>() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$subscriptionRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SubscriptionRepository invoke() {
            return new SubscriptionRepository();
        }
    });
    private final Lazy dispenserCommandsRespository$delegate = LazyKt.lazy(new Function0<DispenserCommandsRepository>() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$dispenserCommandsRespository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DispenserCommandsRepository invoke() {
            return new DispenserCommandsRepository();
        }
    });

    public UnlimitedWaterHomeModel() {
        MutableLiveData<DashboardDetailsResponse> mutableLiveData = new MutableLiveData<>();
        this.dashboardData = mutableLiveData;
        this.boltCommandsResponse = new MediatorLiveData<>();
        this.BLERepository$delegate = LazyKt.lazy(new Function0<BoltDataUpdateRepository>() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$BLERepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BoltDataUpdateRepository invoke() {
                return new BoltDataUpdateRepository();
            }
        });
        this.BLECommands$delegate = LazyKt.lazy(new Function0<BoltBleCommandsRespository>() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$BLECommands$2
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
        MutableLiveData<User> mutableLiveData5 = new MutableLiveData<>();
        mutableLiveData5.setValue(LSApplication.Companion.getUser());
        this.user = mutableLiveData5;
        this.publishCommandStatus = new MutableLiveData<>();
        LiveData<String> map = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m738lastSynchronizedDate$lambda5;
                m738lastSynchronizedDate$lambda5 = UnlimitedWaterHomeModel.m738lastSynchronizedDate$lambda5(UnlimitedWaterHomeModel.this, (DashboardDetailsResponse) obj);
                return m738lastSynchronizedDate$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.lastSynchronizedDate = map;
        LiveData<String> map2 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda20
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m743productType$lambda9;
                m743productType$lambda9 = UnlimitedWaterHomeModel.m743productType$lambda9((DashboardDetailsResponse) obj);
                return m743productType$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.productType = map2;
        LiveData<Integer> map3 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda18
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m752wifiImage$lambda10;
                m752wifiImage$lambda10 = UnlimitedWaterHomeModel.m752wifiImage$lambda10((DashboardDetailsResponse) obj);
                return m752wifiImage$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map3, "map(dashboardData) {\n        R.drawable.wifi\n    }");
        this.wifiImage = map3;
        LiveData<Integer> map4 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda4
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m722bleImage$lambda11;
                m722bleImage$lambda11 = UnlimitedWaterHomeModel.m722bleImage$lambda11((DashboardDetailsResponse) obj);
                return m722bleImage$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map4, "map(dashboardData) {\n   ….drawable.bluetooth\n    }");
        this.bleImage = map4;
        LiveData<Integer> map5 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda19
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m723bleImageOff$lambda12;
                m723bleImageOff$lambda12 = UnlimitedWaterHomeModel.m723bleImageOff$lambda12((DashboardDetailsResponse) obj);
                return m723bleImageOff$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map5, "map(dashboardData) {\n   …wable.bluetooth_off\n    }");
        this.bleImageOff = map5;
        LiveData<Boolean> map6 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda2
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m746scanSerialNo$lambda13;
                m746scanSerialNo$lambda13 = UnlimitedWaterHomeModel.m746scanSerialNo$lambda13((DashboardDetailsResponse) obj);
                return m746scanSerialNo$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map6, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.scanSerialNo = map6;
        LiveData<Integer> map7 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda22
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m739liveDispenserStatus$lambda16;
                m739liveDispenserStatus$lambda16 = UnlimitedWaterHomeModel.m739liveDispenserStatus$lambda16((DashboardDetailsResponse) obj);
                return m739liveDispenserStatus$lambda16;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map7, "map(dashboardData) {\n   …        }\n        0\n    }");
        this.liveDispenserStatus = map7;
        LiveData<String> map8 = Transformations.map(mutableLiveData5, new Function() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda16
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m745referralCode$lambda17;
                m745referralCode$lambda17 = UnlimitedWaterHomeModel.m745referralCode$lambda17((User) obj);
                return m745referralCode$lambda17;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map8, "map(user) {\n        if (…       \"\"\n        }\n    }");
        this.referralCode = map8;
        LiveData<Pair<String, Integer>> map9 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda11
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Pair m751waterRemaining$lambda18;
                m751waterRemaining$lambda18 = UnlimitedWaterHomeModel.m751waterRemaining$lambda18(UnlimitedWaterHomeModel.this, (DashboardDetailsResponse) obj);
                return m751waterRemaining$lambda18;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map9, "map(dashboardData) {\n   …\"\", null)\n        }\n    }");
        this.waterRemaining = map9;
        LiveData<String> map10 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda15
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m742planDetails$lambda19;
                m742planDetails$lambda19 = UnlimitedWaterHomeModel.m742planDetails$lambda19(UnlimitedWaterHomeModel.this, (DashboardDetailsResponse) obj);
                return m742planDetails$lambda19;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map10, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.planDetails = map10;
        LiveData<Integer> map11 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda3
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m727filterLifeImage$lambda20;
                m727filterLifeImage$lambda20 = UnlimitedWaterHomeModel.m727filterLifeImage$lambda20((DashboardDetailsResponse) obj);
                return m727filterLifeImage$lambda20;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map11, "map(dashboardData) {\n   …       -1\n        }\n    }");
        this.filterLifeImage = map11;
        LiveData<Boolean> map12 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda6
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m736hardwareUpdate$lambda21;
                m736hardwareUpdate$lambda21 = UnlimitedWaterHomeModel.m736hardwareUpdate$lambda21((DashboardDetailsResponse) obj);
                return m736hardwareUpdate$lambda21;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map12, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.hardwareUpdate = map12;
        LiveData<Boolean> map13 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda21
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m747softwareUpdate$lambda22;
                m747softwareUpdate$lambda22 = UnlimitedWaterHomeModel.m747softwareUpdate$lambda22((DashboardDetailsResponse) obj);
                return m747softwareUpdate$lambda22;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map13, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.softwareUpdate = map13;
        LiveData<String> map14 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda1
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m737hardwareVersion$lambda23;
                m737hardwareVersion$lambda23 = UnlimitedWaterHomeModel.m737hardwareVersion$lambda23((DashboardDetailsResponse) obj);
                return m737hardwareVersion$lambda23;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map14, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.hardwareVersion = map14;
        LiveData<String> map15 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda17
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m748softwareVersion$lambda24;
                m748softwareVersion$lambda24 = UnlimitedWaterHomeModel.m748softwareVersion$lambda24((DashboardDetailsResponse) obj);
                return m748softwareVersion$lambda24;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map15, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.softwareVersion = map15;
        LiveData<Triple<List<String>, List<IBarDataSet>, String>> map16 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda5
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Triple m750usageStats$lambda25;
                m750usageStats$lambda25 = UnlimitedWaterHomeModel.m750usageStats$lambda25((DashboardDetailsResponse) obj);
                return m750usageStats$lambda25;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map16, "map(dashboardData) {\n   …null, \"\")\n        }\n    }");
        this.usageStats = map16;
        this.offlineDashboard = new MediatorLiveData<>();
        this.rechargeResponse = new MediatorLiveData<>();
        this.envyBLEResponseList = new MediatorLiveData<>();
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

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final void setSerialNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serialNo = str;
    }

    public final String get_productType() {
        return this._productType;
    }

    public final void set_productType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this._productType = str;
    }

    public final String getDeviceSerialNumber() {
        return this.deviceSerialNumber;
    }

    public final void setDeviceSerialNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceSerialNumber = str;
    }

    public final String getLastSynchronizedOn() {
        return this.lastSynchronizedOn;
    }

    public final void setLastSynchronizedOn(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lastSynchronizedOn = str;
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

    public final MutableLiveData<User> getUser() {
        return this.user;
    }

    public final MutableLiveData<String> getPublishCommandStatus() {
        return this.publishCommandStatus;
    }

    public final boolean getAllowTopup() {
        return this.allowTopup;
    }

    public final void setAllowTopup(boolean z) {
        this.allowTopup = z;
    }

    public final double getRemainingLitres() {
        return this.remainingLitres;
    }

    public final void setRemainingLitres(double d) {
        this.remainingLitres = d;
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
                observeAndTrack(dispenserCommandsRespository.sendDispenserCommand(dispenserCommands), new Observer() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda7
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        UnlimitedWaterHomeModel.m744publishCommand$lambda4(UnlimitedWaterHomeModel.this, (BaseDataHolder) obj);
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
    /* renamed from: publishCommand$lambda-4  reason: not valid java name */
    public static final void m744publishCommand$lambda4(UnlimitedWaterHomeModel this$0, BaseDataHolder baseDataHolder) {
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
    /* renamed from: lastSynchronizedDate$lambda-5  reason: not valid java name */
    public static final String m738lastSynchronizedDate$lambda5(UnlimitedWaterHomeModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getLastSyncDate() : null) != null) {
            this$0.lastSynchronizedOn = dashboardDetailsResponse.getDashboardDetails().getLastSyncDate();
            return dashboardDetailsResponse.getDashboardDetails().getLastSyncDate();
        }
        return "";
    }

    public final void bleStatus(final String status, final Context context) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(context, "context");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getBLERepository().sendBoltConfigtRequest(this.serialNo, status, false), new Observer() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda9
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        UnlimitedWaterHomeModel.m724bleStatus$lambda7(UnlimitedWaterHomeModel.this, status, context, (BaseDataHolder) obj);
                    }
                });
                return;
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! We faced an issue while fetching your dashboard details at this time."));
                return;
            }
        }
        Lazy lazy = LazyKt.lazy(new Function0<EnvyBLEResponseRepository>() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$bleStatus$envyBLEResponseRepository$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EnvyBLEResponseRepository invoke() {
                return new EnvyBLEResponseRepository(context);
            }
        });
        EnvyBLEResponse envyBLEResponse = null;
        if (StringsKt.contains$default((CharSequence) status, (CharSequence) "RSA", false, 2, (Object) null)) {
            this.envyBLEResponse = new EnvyBLEResponse(this.deviceSerialNumber, status);
            EnvyBLEResponseRepository m726bleStatus$lambda8 = m726bleStatus$lambda8(lazy);
            EnvyBLEResponse envyBLEResponse2 = this.envyBLEResponse;
            if (envyBLEResponse2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("envyBLEResponse");
            } else {
                envyBLEResponse = envyBLEResponse2;
            }
            m726bleStatus$lambda8.insert(envyBLEResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bleStatus$lambda-7  reason: not valid java name */
    public static final void m724bleStatus$lambda7(UnlimitedWaterHomeModel this$0, String status, final Context context, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(status, "$status");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.getLoading().setValue(false);
        String str = status;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "\"FR\"", false, 2, (Object) null)) {
            this$0.getDashboardDetails(context);
        } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "DWC", false, 2, (Object) null)) {
            this$0.getPendingBleCommand(context);
        } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "RSA", false, 2, (Object) null)) {
            m725bleStatus$lambda7$lambda6(LazyKt.lazy(new Function0<BLECommandListRepository>() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$bleStatus$1$bleCommandListRepository$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BLECommandListRepository invoke() {
                    return new BLECommandListRepository(context);
                }
            })).deleteBLEDataList();
        }
    }

    /* renamed from: bleStatus$lambda-7$lambda-6  reason: not valid java name */
    private static final BLECommandListRepository m725bleStatus$lambda7$lambda6(Lazy<BLECommandListRepository> lazy) {
        return lazy.getValue();
    }

    /* renamed from: bleStatus$lambda-8  reason: not valid java name */
    private static final EnvyBLEResponseRepository m726bleStatus$lambda8(Lazy<EnvyBLEResponseRepository> lazy) {
        return lazy.getValue();
    }

    public final LiveData<String> getProductType() {
        return this.productType;
    }

    public final void setProductType(LiveData<String> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.productType = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: productType$lambda-9  reason: not valid java name */
    public static final String m743productType$lambda9(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: wifiImage$lambda-10  reason: not valid java name */
    public static final Integer m752wifiImage$lambda10(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: bleImage$lambda-11  reason: not valid java name */
    public static final Integer m722bleImage$lambda11(DashboardDetailsResponse dashboardDetailsResponse) {
        return Integer.valueOf((int) R.drawable.bluetooth);
    }

    public final LiveData<Integer> getBleImageOff() {
        return this.bleImageOff;
    }

    public final void setBleImageOff(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.bleImageOff = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bleImageOff$lambda-12  reason: not valid java name */
    public static final Integer m723bleImageOff$lambda12(DashboardDetailsResponse dashboardDetailsResponse) {
        return Integer.valueOf((int) R.drawable.bluetooth_off);
    }

    public final LiveData<Boolean> getScanSerialNo() {
        return this.scanSerialNo;
    }

    public final void setScanSerialNo(LiveData<Boolean> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.scanSerialNo = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: scanSerialNo$lambda-13  reason: not valid java name */
    public static final Boolean m746scanSerialNo$lambda13(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getScanSerialNo() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getScanSerialNo().booleanValue() : false);
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
        this._productType = (deviceList3 == null || (r2 = deviceList3.getProductType()) == null) ? "" : "";
        DeviceList deviceList4 = this.device;
        this.serialNo = (deviceList4 == null || (r2 = deviceList4.getSerialNo()) == null) ? "" : "";
        DeviceList deviceList5 = this.device;
        if (deviceList5 != null && (serialNo = deviceList5.getSerialNo()) != null) {
            str = serialNo;
        }
        this.deviceSerialNumber = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getDashboardDetails$lambda-14  reason: not valid java name */
    public static final DispenserOflineRepository m731getDashboardDetails$lambda14(Lazy<DispenserOflineRepository> lazy) {
        return lazy.getValue();
    }

    public final void getDashboardDetails(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        final Lazy lazy = LazyKt.lazy(new Function0<DispenserOflineRepository>() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$getDashboardDetails$dispenserOflineRepository$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DispenserOflineRepository invoke() {
                return new DispenserOflineRepository(context);
            }
        });
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            m731getDashboardDetails$lambda14(lazy).deleteDashboard();
            try {
                observeAndTrack(getSubscriptionRepository().getDashboardDetails(this.serialNo), new Observer() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda12
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        UnlimitedWaterHomeModel.m732getDashboardDetails$lambda15(UnlimitedWaterHomeModel.this, lazy, (DashboardDetailsResponse) obj);
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
    /* renamed from: getDashboardDetails$lambda-15  reason: not valid java name */
    public static final void m732getDashboardDetails$lambda15(final UnlimitedWaterHomeModel this$0, final Lazy dispenserOflineRepository$delegate, DashboardDetailsResponse dashboardDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dispenserOflineRepository$delegate, "$dispenserOflineRepository$delegate");
        this$0.getLoading().setValue(false);
        this$0.processResponse(dashboardDetailsResponse, new Function1<DashboardDetailsResponse, Unit>() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$getDashboardDetails$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                String format;
                DispenserOflineRepository m731getDashboardDetails$lambda14;
                EnvyDashbordOffline envyDashbordOffline;
                ProductStats productStats;
                ProductStats productStats2;
                ProductStats productStats3;
                DispenserRoSetting dispenserRoSetting;
                DispenserRoSetting dispenserRoSetting2;
                DispenserRoSetting dispenserRoSetting3;
                DispenserRoSetting dispenserRoSetting4;
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                mutableLiveData = UnlimitedWaterHomeModel.this.dashboardData;
                mutableLiveData.setValue(successfulResponse);
                MutableLiveData<String> faultDescription = UnlimitedWaterHomeModel.this.getFaultDescription();
                DashboardDetails dashboardDetails = successfulResponse.getDashboardDetails();
                faultDescription.setValue(String.valueOf((dashboardDetails == null || (dispenserRoSetting4 = dashboardDetails.getDispenserRoSetting()) == null) ? null : dispenserRoSetting4.getFault()));
                UnlimitedWaterHomeModel unlimitedWaterHomeModel = UnlimitedWaterHomeModel.this;
                DashboardDetails dashboardDetails2 = successfulResponse.getDashboardDetails();
                unlimitedWaterHomeModel.setDispenserStatus(String.valueOf((dashboardDetails2 == null || (dispenserRoSetting3 = dashboardDetails2.getDispenserRoSetting()) == null) ? null : dispenserRoSetting3.getDespensing()));
                UnlimitedWaterHomeModel unlimitedWaterHomeModel2 = UnlimitedWaterHomeModel.this;
                DashboardDetails dashboardDetails3 = successfulResponse.getDashboardDetails();
                unlimitedWaterHomeModel2.hotWaterTemprature = String.valueOf((dashboardDetails3 == null || (dispenserRoSetting2 = dashboardDetails3.getDispenserRoSetting()) == null) ? null : dispenserRoSetting2.getHotWater());
                UnlimitedWaterHomeModel unlimitedWaterHomeModel3 = UnlimitedWaterHomeModel.this;
                DashboardDetails dashboardDetails4 = successfulResponse.getDashboardDetails();
                unlimitedWaterHomeModel3.warmWaterTemprature = String.valueOf((dashboardDetails4 == null || (dispenserRoSetting = dashboardDetails4.getDispenserRoSetting()) == null) ? null : dispenserRoSetting.getWarmWater());
                DashboardDetails dashboardDetails5 = successfulResponse.getDashboardDetails();
                String str = "";
                String lastSyncDate = (dashboardDetails5 != null ? dashboardDetails5.getLastSyncDate() : null) != null ? successfulResponse.getDashboardDetails().getLastSyncDate() : "";
                DashboardDetails dashboardDetails6 = successfulResponse.getDashboardDetails();
                SubscriptionDetails subscriptionDetails = dashboardDetails6 != null ? dashboardDetails6.getSubscriptionDetails() : null;
                DashboardDetails dashboardDetails7 = successfulResponse.getDashboardDetails();
                if (((dashboardDetails7 == null || (productStats3 = dashboardDetails7.getProductStats()) == null) ? null : productStats3.getProductType()) != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    Object[] objArr = new Object[4];
                    objArr[0] = subscriptionDetails != null ? subscriptionDetails.getPlanName() : null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Valid Till: ");
                    sb.append(subscriptionDetails != null ? subscriptionDetails.getValidTillDate() : null);
                    objArr[1] = sb.toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Rate: ");
                    sb2.append(subscriptionDetails != null ? subscriptionDetails.getPlanRate() : null);
                    objArr[2] = sb2.toString();
                    objArr[3] = subscriptionDetails != null ? subscriptionDetails.getNormalizedBalanceString() : null;
                    format = String.format("%s\n%s\n%s\n%s", Arrays.copyOf(objArr, 4));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                } else {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = subscriptionDetails != null ? subscriptionDetails.getPlanName() : null;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Valid Till: ");
                    sb3.append(subscriptionDetails != null ? subscriptionDetails.getValidTillDate() : null);
                    objArr2[1] = sb3.toString();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Rate: ");
                    sb4.append(subscriptionDetails != null ? subscriptionDetails.getPlanRate() : null);
                    objArr2[2] = sb4.toString();
                    objArr2[3] = subscriptionDetails != null ? subscriptionDetails.getNormalizedBalanceString() : null;
                    format = String.format("%s\n%s\n%s\n%s", Arrays.copyOf(objArr2, 4));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                }
                String str2 = format;
                DashboardDetails dashboardDetails8 = successfulResponse.getDashboardDetails();
                EnvyDashbordOffline envyDashbordOffline2 = null;
                if (!StringsKt.equals$default((dashboardDetails8 == null || (productStats2 = dashboardDetails8.getProductStats()) == null) ? null : productStats2.getFilterLife(), "", false, 2, null)) {
                    DashboardDetails dashboardDetails9 = successfulResponse.getDashboardDetails();
                    str = String.valueOf((dashboardDetails9 == null || (productStats = dashboardDetails9.getProductStats()) == null) ? null : productStats.getFilterLife());
                }
                UnlimitedWaterHomeModel.this.envyDashbordOffline = new EnvyDashbordOffline(UnlimitedWaterHomeModel.this.getDeviceSerialNumber(), lastSyncDate, "UNLTD", str2, str, "", UnlimitedWaterHomeModel.this.get_productType(), "");
                m731getDashboardDetails$lambda14 = UnlimitedWaterHomeModel.m731getDashboardDetails$lambda14(dispenserOflineRepository$delegate);
                envyDashbordOffline = UnlimitedWaterHomeModel.this.envyDashbordOffline;
                if (envyDashbordOffline == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("envyDashbordOffline");
                } else {
                    envyDashbordOffline2 = envyDashbordOffline;
                }
                m731getDashboardDetails$lambda14.insert(envyDashbordOffline2);
            }
        }, new Function1<DashboardDetailsResponse, Unit>() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$getDashboardDetails$1$2
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
                toastMessageLiveData = UnlimitedWaterHomeModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Oops! We faced an issue while fetching your dashboard details at this time."));
            }
        });
    }

    public final LiveData<Integer> getLiveDispenserStatus() {
        return this.liveDispenserStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: liveDispenserStatus$lambda-16  reason: not valid java name */
    public static final Integer m739liveDispenserStatus$lambda16(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getDispenserRoSetting() : null) != null && dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing() != null && !Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing(), "")) {
            Integer.parseInt(dashboardDetailsResponse.getDashboardDetails().getDispenserRoSetting().getDespensing());
        }
        return 0;
    }

    public final LiveData<String> getReferralCode() {
        return this.referralCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: referralCode$lambda-17  reason: not valid java name */
    public static final String m745referralCode$lambda17(User user) {
        return user.getReferralCode() != null ? user.getReferralCode() : "";
    }

    public final LiveData<Pair<String, Integer>> getWaterRemaining() {
        return this.waterRemaining;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: waterRemaining$lambda-18  reason: not valid java name */
    public static final Pair m751waterRemaining$lambda18(UnlimitedWaterHomeModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        String remainingLitres;
        String padStart;
        String remainingLitres2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        String str = "";
        if ((dashboardDetails != null ? dashboardDetails.getUsage() : null) != null) {
            ProductStats productStats = dashboardDetailsResponse.getDashboardDetails().getProductStats();
            if ((productStats != null ? productStats.getProductType() : null) == null ? !((remainingLitres = dashboardDetailsResponse.getDashboardDetails().getUsage().getRemainingLitres()) == null || (padStart = StringsKt.padStart(remainingLitres, 5, '0')) == null) : !((remainingLitres2 = dashboardDetailsResponse.getDashboardDetails().getUsage().getRemainingLitres()) == null || (padStart = StringsKt.padStart(remainingLitres2, 5, '0')) == null)) {
                str = padStart;
            }
            double parseDouble = Double.parseDouble(str);
            this$0.remainingLitres = parseDouble;
            return new Pair(str, Integer.valueOf(parseDouble > 40.0d ? R.drawable.fullwaterlarge : parseDouble > 10.0d ? R.drawable.purifyinglarge : R.drawable.emptywaterlarge));
        }
        return new Pair("", null);
    }

    public final LiveData<String> getPlanDetails() {
        return this.planDetails;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: planDetails$lambda-19  reason: not valid java name */
    public static final String m742planDetails$lambda19(UnlimitedWaterHomeModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getSubscriptionDetails() : null) != null) {
            SubscriptionDetails subscriptionDetails = dashboardDetailsResponse.getDashboardDetails().getSubscriptionDetails();
            subscriptionDetails.getNormalizedBalanceString();
            this$0.allowTopup = subscriptionDetails.get_AllowTopup();
            ProductStats productStats = dashboardDetailsResponse.getDashboardDetails().getProductStats();
            if ((productStats != null ? productStats.getProductType() : null) != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%s\n%s\n%s\n%s", Arrays.copyOf(new Object[]{subscriptionDetails.getPlanName(), "Valid Till: " + subscriptionDetails.getValidTillDate(), "Rate: " + subscriptionDetails.getPlanRate(), subscriptionDetails.getNormalizedBalanceString()}, 4));
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
    /* renamed from: filterLifeImage$lambda-20  reason: not valid java name */
    public static final Integer m727filterLifeImage$lambda20(DashboardDetailsResponse dashboardDetailsResponse) {
        int i;
        ProductStats productStats;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if (((dashboardDetails == null || (productStats = dashboardDetails.getProductStats()) == null) ? null : productStats.getFilterLife()) != null) {
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (!Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getProductStats().getFilterLife(), "")) {
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
    /* renamed from: hardwareUpdate$lambda-21  reason: not valid java name */
    public static final Boolean m736hardwareUpdate$lambda21(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getHardwareVersion() : false);
    }

    public final LiveData<Boolean> getSoftwareUpdate() {
        return this.softwareUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: softwareUpdate$lambda-22  reason: not valid java name */
    public static final Boolean m747softwareUpdate$lambda22(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getSoftwareVersion() : false);
    }

    public final LiveData<String> getHardwareVersion() {
        return this.hardwareVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hardwareVersion$lambda-23  reason: not valid java name */
    public static final String m737hardwareVersion$lambda23(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getCurrentHardwareVersion() : "";
    }

    public final LiveData<String> getSoftwareVersion() {
        return this.softwareVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: softwareVersion$lambda-24  reason: not valid java name */
    public static final String m748softwareVersion$lambda24(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getCurrentSoftwareVersion() : "";
    }

    public final LiveData<Triple<List<String>, List<IBarDataSet>, String>> getUsageStats() {
        return this.usageStats;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: usageStats$lambda-25  reason: not valid java name */
    public static final Triple m750usageStats$lambda25(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        List<DailyConsumptionItem> dailyConsumptionList = dashboardDetails != null ? dashboardDetails.getDailyConsumptionList() : null;
        if (!(dailyConsumptionList == null || dailyConsumptionList.isEmpty())) {
            DashboardDetails dashboardDetails2 = dashboardDetailsResponse.getDashboardDetails();
            Intrinsics.checkNotNull(dashboardDetails2);
            return dashboardDetails2.getConsumptionData();
        }
        return new Triple(null, null, "");
    }

    public final void getPendingBleCommand(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (LSApplication.Companion.isNetworkAvailable()) {
            final Lazy lazy = LazyKt.lazy(new Function0<BLECommandListRepository>() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$getPendingBleCommand$bleCommandListRepository$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BLECommandListRepository invoke() {
                    return new BLECommandListRepository(context);
                }
            });
            m733getPendingBleCommand$lambda26(lazy).deleteBLEDataList();
            getLoading().setValue(true);
            this.boltCommandsResponse.addSource(getBLECommands().getBoltBleCommands(this.serialNo), new Observer() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda10
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UnlimitedWaterHomeModel.m734getPendingBleCommand$lambda27(UnlimitedWaterHomeModel.this, lazy, (BaseDataHolder) obj);
                }
            });
            return;
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* renamed from: getPendingBleCommand$lambda-26  reason: not valid java name */
    private static final BLECommandListRepository m733getPendingBleCommand$lambda26(Lazy<BLECommandListRepository> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPendingBleCommand$lambda-27  reason: not valid java name */
    public static final void m734getPendingBleCommand$lambda27(UnlimitedWaterHomeModel this$0, Lazy bleCommandListRepository$delegate, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bleCommandListRepository$delegate, "$bleCommandListRepository$delegate");
        this$0.getLoading().setValue(false);
        if (baseDataHolder.getData() != null) {
            if (((BoltCommandsResponse) baseDataHolder.getData()).getRechargeCommands() != null && (!((BoltCommandsResponse) baseDataHolder.getData()).getRechargeCommands().isEmpty())) {
                m733getPendingBleCommand$lambda26(bleCommandListRepository$delegate).insert(((BoltCommandsResponse) baseDataHolder.getData()).getRechargeCommands());
            }
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

    public final void getSerialNumberStatus(String roSerialNumber) {
        Intrinsics.checkNotNullParameter(roSerialNumber, "roSerialNumber");
        if (Intrinsics.areEqual(roSerialNumber, "")) {
            return;
        }
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getSubscriptionRepository().getUpdateSerialNumber(roSerialNumber), new Observer() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda8
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        UnlimitedWaterHomeModel.m735getSerialNumberStatus$lambda28(UnlimitedWaterHomeModel.this, (SerialNumberUpdateResponse) obj);
                    }
                });
                return;
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! We faced an issue while fetching data."));
                return;
            }
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSerialNumberStatus$lambda-28  reason: not valid java name */
    public static final void m735getSerialNumberStatus$lambda28(final UnlimitedWaterHomeModel this$0, final SerialNumberUpdateResponse serialNumberUpdateResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(serialNumberUpdateResponse, new Function1<SerialNumberUpdateResponse, Unit>() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$getSerialNumberStatus$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SerialNumberUpdateResponse serialNumberUpdateResponse2) {
                invoke2(serialNumberUpdateResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SerialNumberUpdateResponse serialNumberUpdateResponse2) {
                Intrinsics.checkNotNullParameter(serialNumberUpdateResponse2, "<anonymous parameter 0>");
                SerialNumberUpdateResponse.this.getMessage();
            }
        }, new Function1<SerialNumberUpdateResponse, Unit>() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$getSerialNumberStatus$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SerialNumberUpdateResponse serialNumberUpdateResponse2) {
                invoke2(serialNumberUpdateResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SerialNumberUpdateResponse it) {
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(it, "it");
                toastMessageLiveData = UnlimitedWaterHomeModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event(String.valueOf(it.getMessage())));
            }
        });
    }

    public final void updateLocationDetails(String latitude, String longitude) {
        Intrinsics.checkNotNullParameter(latitude, "latitude");
        Intrinsics.checkNotNullParameter(longitude, "longitude");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getSubscriptionRepository().updateLocationDetails(this.deviceSerialNumber, latitude, longitude), new Observer() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda14
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ((BaseDataHolder) obj).getStatus();
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

    /* renamed from: getAllOflineDashboarData$lambda-30  reason: not valid java name */
    private static final DispenserOflineRepository m730getAllOflineDashboarData$lambda30(Lazy<DispenserOflineRepository> lazy) {
        return lazy.getValue();
    }

    public final LiveData<List<EnvyDashbordOffline>> getAllOflineDashboarData(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.offlineDashboard.setValue(m730getAllOflineDashboarData$lambda30(LazyKt.lazy(new Function0<DispenserOflineRepository>() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$getAllOflineDashboarData$dispenserOflineRepository$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DispenserOflineRepository invoke() {
                return new DispenserOflineRepository(context);
            }
        })).getDashboard());
        return this.offlineDashboard;
    }

    public final MediatorLiveData<List<RechargeResponse>> getRechargeResponse() {
        return this.rechargeResponse;
    }

    /* renamed from: getAllOflineBLECommands$lambda-31  reason: not valid java name */
    private static final BLECommandListRepository m729getAllOflineBLECommands$lambda31(Lazy<BLECommandListRepository> lazy) {
        return lazy.getValue();
    }

    public final LiveData<List<RechargeResponse>> getAllOflineBLECommands(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.rechargeResponse.setValue(m729getAllOflineBLECommands$lambda31(LazyKt.lazy(new Function0<BLECommandListRepository>() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$getAllOflineBLECommands$bleCommandListRepository$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BLECommandListRepository invoke() {
                return new BLECommandListRepository(context);
            }
        })).getBLEDataList());
        return this.rechargeResponse;
    }

    /* renamed from: getAllEnvyBLEResponse$lambda-32  reason: not valid java name */
    private static final EnvyBLEResponseRepository m728getAllEnvyBLEResponse$lambda32(Lazy<EnvyBLEResponseRepository> lazy) {
        return lazy.getValue();
    }

    public final LiveData<List<EnvyBLEResponse>> getAllEnvyBLEResponse(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.envyBLEResponseList.setValue(m728getAllEnvyBLEResponse$lambda32(LazyKt.lazy(new Function0<EnvyBLEResponseRepository>() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$getAllEnvyBLEResponse$envyBLEResponseRepository$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EnvyBLEResponseRepository invoke() {
                return new EnvyBLEResponseRepository(context);
            }
        })).getBLEResponse());
        return this.envyBLEResponseList;
    }

    public final void offlineBLEStatus(final Context context, String serialNumber, String status, final boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serialNumber, "serialNumber");
        Intrinsics.checkNotNullParameter(status, "status");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getBLERepository().sendBoltConfigtRequest(serialNumber, status, true), new Observer() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$$ExternalSyntheticLambda13
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        UnlimitedWaterHomeModel.m740offlineBLEStatus$lambda34(UnlimitedWaterHomeModel.this, z, context, (BaseDataHolder) obj);
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
    /* renamed from: offlineBLEStatus$lambda-34  reason: not valid java name */
    public static final void m740offlineBLEStatus$lambda34(UnlimitedWaterHomeModel this$0, boolean z, final Context context, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.getLoading().setValue(false);
        if (z) {
            m741offlineBLEStatus$lambda34$lambda33(LazyKt.lazy(new Function0<EnvyBLEResponseRepository>() { // from class: com.livpure.safedrink.dispenser.model.UnlimitedWaterHomeModel$offlineBLEStatus$1$envyBLEResponseRepository$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final EnvyBLEResponseRepository invoke() {
                    return new EnvyBLEResponseRepository(context);
                }
            })).deleteBLEResponse();
        }
    }

    /* renamed from: offlineBLEStatus$lambda-34$lambda-33  reason: not valid java name */
    private static final EnvyBLEResponseRepository m741offlineBLEStatus$lambda34$lambda33(Lazy<EnvyBLEResponseRepository> lazy) {
        return lazy.getValue();
    }

    public final int offlineWaterTank(String reading) {
        Intrinsics.checkNotNullParameter(reading, "reading");
        double parseDouble = Double.parseDouble(reading);
        this.remainingLitres = parseDouble;
        return parseDouble > 40.0d ? R.drawable.fullwaterlarge : parseDouble > 10.0d ? R.drawable.purifyinglarge : R.drawable.emptywaterlarge;
    }

    public final int offlineFilterLife(String reading) {
        Intrinsics.checkNotNullParameter(reading, "reading");
        try {
            double parseLong = Long.parseLong(reading);
            return parseLong > 10.0d ? R.drawable.envygood : parseLong > 3.0d ? R.drawable.envynormal : R.drawable.envybad;
        } catch (Exception unused) {
            return R.drawable.envygood;
        }
    }
}

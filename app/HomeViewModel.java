package com.livpure.safedrink.app;

import android.content.Context;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.livpure.safedrink.R;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.HomeViewModel;
import com.livpure.safedrink.bolt.data.BoltBleCommandsRespository;
import com.livpure.safedrink.bolt.data.BoltDataUpdateRepository;
import com.livpure.safedrink.bolt.data.models.BoltCommandsResponse;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.login.api.models.response.BaseV1ResponseImplementation;
import com.livpure.safedrink.login.api.models.response.UserDetailsResponse;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.data.models.UserDetailsV1;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.ota.data.OTARepository;
import com.livpure.safedrink.ota.data.model.MessageDetails;
import com.livpure.safedrink.ota.data.model.MessageDetailsResponse;
import com.livpure.safedrink.ota.data.model.OTAUpdateDetailsResponse;
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
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\u0004¸\u0001¹\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0007\u0010\u0093\u0001\u001a\u00020TJ\u0007\u0010\u0094\u0001\u001a\u00020TJ\u0007\u0010\u0095\u0001\u001a\u00020TJ\u0007\u0010\u0096\u0001\u001a\u00020TJ\u0019\u0010\u0097\u0001\u001a\u00020T2\u0007\u0010\u0098\u0001\u001a\u00020\u00152\u0007\u0010\u0099\u0001\u001a\u00020\u0015J\r\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020I0\u001fJ+\u0010\u009b\u0001\u001a\u00020T2\u0007\u0010\u0098\u0001\u001a\u00020\u00152\u0007\u0010\u0099\u0001\u001a\u00020\u00152\u0007\u0010\u009c\u0001\u001a\u00020\u00152\u0007\u0010\u009d\u0001\u001a\u00020\u0015J\r\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020*0\u001fJ\u0010\u0010\u009f\u0001\u001a\u00020T2\u0007\u0010 \u0001\u001a\u00020\u0015J!\u0010¡\u0001\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\u001f2\u0007\u0010¢\u0001\u001a\u00020\u00152\u0007\u0010£\u0001\u001a\u00020\u0015J\u0018\u0010¤\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u00010\u001f2\b\u0010¥\u0001\u001a\u00030¦\u0001J\u0007\u0010§\u0001\u001a\u00020TJ\u0013\u0010¨\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001fJ\u0007\u0010©\u0001\u001a\u00020TJ\u0007\u0010ª\u0001\u001a\u00020TJ\u0007\u0010«\u0001\u001a\u00020TJ\u0007\u0010¬\u0001\u001a\u00020TJ\u0007\u0010\u00ad\u0001\u001a\u00020TJ\u0007\u0010®\u0001\u001a\u00020TJ<\u0010¯\u0001\u001a\u00020T2\t\b\u0001\u0010°\u0001\u001a\u00020 2\u0007\u0010±\u0001\u001a\u00020\u00152\u0007\u0010²\u0001\u001a\u00020\u00152\u0007\u0010³\u0001\u001a\u00020\u00152\r\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020T0SJ\u0019\u0010µ\u0001\u001a\u00020T2\u0007\u0010¶\u0001\u001a\u00020\u00152\u0007\u0010·\u0001\u001a\u00020\u0015R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150\u001f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u00100\u001a\u0004\u0018\u00010\u000f2\b\u0010/\u001a\u0004\u0018\u00010\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0011\"\u0004\b2\u0010\u0013R\u001a\u00103\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u0010\u0019R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\"R\u0017\u00108\u001a\b\u0012\u0004\u0012\u0002090\u001f¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\"R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00150\u001f¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\"R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b¢\u0006\b\n\u0000\u001a\u0004\bA\u0010?R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020 0\u001b¢\u0006\b\n\u0000\u001a\u0004\bC\u0010?R\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b¢\u0006\b\n\u0000\u001a\u0004\bE\u0010?R\u0017\u0010F\u001a\b\u0012\u0004\u0012\u0002090\u001b¢\u0006\b\n\u0000\u001a\u0004\bG\u0010?R\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010J\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0017\"\u0004\bL\u0010\u0019R \u0010M\u001a\b\u0012\u0004\u0012\u0002090\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\"\"\u0004\bN\u0010$R \u0010O\u001a\b\u0012\u0004\u0012\u00020\u00150\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\"\"\u0004\bQ\u0010$R \u0010R\u001a\b\u0012\u0004\u0012\u00020T0SX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0014\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00150\u001f¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010\"R\u001b\u0010]\u001a\u00020^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010\b\u001a\u0004\b_\u0010`R\u0017\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001f¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\"R\u0017\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00150\u001f¢\u0006\b\n\u0000\u001a\u0004\be\u0010\"R\u0014\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00150\u001f¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\"R \u0010j\u001a\b\u0012\u0004\u0012\u00020\u00150\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\"\"\u0004\bl\u0010$R\u0017\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00150\u001f¢\u0006\b\n\u0000\u001a\u0004\bn\u0010\"R \u0010o\u001a\b\u0012\u0004\u0012\u0002090\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\"\"\u0004\bq\u0010$R\u001a\u0010r\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0017\"\u0004\bt\u0010\u0019R\u000e\u0010u\u001a\u00020vX\u0082.¢\u0006\u0002\n\u0000R\u0017\u0010w\u001a\b\u0012\u0004\u0012\u0002090\u001f¢\u0006\b\n\u0000\u001a\u0004\bx\u0010\"R\u0017\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00150\u001f¢\u0006\b\n\u0000\u001a\u0004\bz\u0010\"R\u001b\u0010{\u001a\u00020|8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u007f\u0010\b\u001a\u0004\b}\u0010~R?\u0010\u0080\u0001\u001a.\u0012*\u0012(\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0082\u0001\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u00010\u0082\u0001\u0012\u0004\u0012\u00020\u00150\u0081\u00010\u001f¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010\"R\u001a\u0010\u0085\u0001\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010\u001b¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010?R\u0016\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u008a\u0001\u001a\u0017\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010 0\u008b\u00010\u001f¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010\"R#\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010\"\"\u0005\b\u008f\u0001\u0010$R#\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010\"\"\u0005\b\u0092\u0001\u0010$¨\u0006º\u0001"}, d2 = {"Lcom/livpure/safedrink/app/HomeViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "BLECommands", "Lcom/livpure/safedrink/bolt/data/BoltBleCommandsRespository;", "getBLECommands", "()Lcom/livpure/safedrink/bolt/data/BoltBleCommandsRespository;", "BLECommands$delegate", "Lkotlin/Lazy;", "BLERepository", "Lcom/livpure/safedrink/bolt/data/BoltDataUpdateRepository;", "getBLERepository", "()Lcom/livpure/safedrink/bolt/data/BoltDataUpdateRepository;", "BLERepository$delegate", "_device", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "get_device", "()Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "set_device", "(Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;)V", "_productType", "", "get_productType", "()Ljava/lang/String;", "set_productType", "(Ljava/lang/String;)V", SettingsJsonConstants.ANALYTICS_KEY, "Landroidx/lifecycle/MutableLiveData;", "Lcom/livpure/safedrink/common/arc/Event;", "Lcom/livpure/safedrink/app/HomeViewModel$Analytics;", "bleImage", "Landroidx/lifecycle/LiveData;", "", "getBleImage", "()Landroidx/lifecycle/LiveData;", "setBleImage", "(Landroidx/lifecycle/LiveData;)V", "bleImageOff", "getBleImageOff", "setBleImageOff", "boltCommandsResponse", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/livpure/safedrink/bolt/data/models/BoltCommandsResponse;", "connectivity", "getConnectivity", "dashboardData", "Lcom/livpure/safedrink/subscription/plan/data/model/DashboardDetailsResponse;", "value", AndroidContextPlugin.DEVICE_KEY, "getDevice", "setDevice", "deviceSerialNumber", "getDeviceSerialNumber", "setDeviceSerialNumber", "filterLifeImage", "getFilterLifeImage", "hardwareUpdate", "", "getHardwareUpdate", "hardwareVersion", "getHardwareVersion", "hintButtonText", "getHintButtonText", "()Landroidx/lifecycle/MutableLiveData;", "hintHeaderText", "getHintHeaderText", "hintImageResId", "getHintImageResId", "hintLabel", "getHintLabel", "hintVisibility", "getHintVisibility", "homeNavigationState", "Lcom/livpure/safedrink/app/HomeViewModel$HomeNavigationStates;", "imeiNo", "getImeiNo", "setImeiNo", "isTopUpAllowed", "setTopUpAllowed", "lastSynchronizedDate", "getLastSynchronizedDate", "setLastSynchronizedDate", "onHintButtonClick", "Lkotlin/Function0;", "", "getOnHintButtonClick", "()Lkotlin/jvm/functions/Function0;", "setOnHintButtonClick", "(Lkotlin/jvm/functions/Function0;)V", "otaData", "Lcom/livpure/safedrink/ota/data/model/MessageDetailsResponse;", "otaMessage", "getOtaMessage", "otaRepository", "Lcom/livpure/safedrink/ota/data/OTARepository;", "getOtaRepository", "()Lcom/livpure/safedrink/ota/data/OTARepository;", "otaRepository$delegate", "otaRequestCmd", "getOtaRequestCmd", "otaRequestMessage", "getOtaRequestMessage", "otaUpdateDetailsResponse", "Lcom/livpure/safedrink/ota/data/model/OTAUpdateDetailsResponse;", "planDetails", "getPlanDetails", "productType", "getProductType", "setProductType", "referralCode", "getReferralCode", "scanSerialNo", "getScanSerialNo", "setScanSerialNo", "serialNo", "getSerialNo", "setSerialNo", "serialNumberUpdateResponse", "Lcom/livpure/safedrink/subscription/plan/data/model/SerialNumberUpdateResponse;", "softwareUpdate", "getSoftwareUpdate", "softwareVersion", "getSoftwareVersion", "subscriptionRepository", "Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "getSubscriptionRepository", "()Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "subscriptionRepository$delegate", "usageStats", "Lkotlin/Triple;", "", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "getUsageStats", "user", "Lcom/livpure/safedrink/login/data/models/User;", "getUser", "userDetailsResponse", "Lcom/livpure/safedrink/login/api/models/response/UserDetailsResponse;", "waterRemaining", "Lkotlin/Pair;", "getWaterRemaining", "wifiImage", "getWifiImage", "setWifiImage", "wifiImageOff", "getWifiImageOff", "setWifiImageOff", "checkInstallationStatus", "checkKYCStatus", "checkPaymentStatus", "getDashboardDetails", "getFirmwareData", "_acion", "bleData", "getHomeNavigationState", "getOTA", "hwVersion", "swVersion", "getPendingBleCommand", "getSerialNumberStatus", "roSerialNumber", "getSubmissionBLEStatus", "statusPkt", "powerPkt", "getUserDetails", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "hideHintView", "observeAnalytics", "onAddLitresClicked", "onBoltSettingsClicked", "onReferFriendsAndEarnClicked", "onReferShareClicked", "onRenewChangePlanClicked", "refreshHintView", "showHintView", "drawableId", ViewHierarchyConstants.HINT_KEY, "buttonText", "header", "onClick", "updateLocationDetails", "latitude", "longitude", "Analytics", "HomeNavigationStates", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeViewModel extends MediatorViewModel {
    private final Lazy BLECommands$delegate;
    private final Lazy BLERepository$delegate;
    private DeviceList _device;
    private String _productType;
    private final MutableLiveData<Event<Analytics>> analytics;
    private LiveData<Integer> bleImage;
    private LiveData<Integer> bleImageOff;
    private final MediatorLiveData<BoltCommandsResponse> boltCommandsResponse;
    private final LiveData<String> connectivity;
    private final MutableLiveData<DashboardDetailsResponse> dashboardData;
    private DeviceList device;
    private String deviceSerialNumber;
    private final LiveData<Integer> filterLifeImage;
    private final LiveData<Boolean> hardwareUpdate;
    private final LiveData<String> hardwareVersion;
    private final MutableLiveData<String> hintHeaderText;
    private final MutableLiveData<Integer> hintImageResId;
    private final MutableLiveData<Boolean> hintVisibility;
    private final MutableLiveData<HomeNavigationStates> homeNavigationState;
    private String imeiNo;
    private LiveData<Boolean> isTopUpAllowed;
    private LiveData<String> lastSynchronizedDate;
    public Function0<Unit> onHintButtonClick;
    private MutableLiveData<MessageDetailsResponse> otaData;
    private final LiveData<String> otaMessage;
    private final Lazy otaRepository$delegate;
    private final LiveData<String> otaRequestCmd;
    private final LiveData<String> otaRequestMessage;
    private MutableLiveData<OTAUpdateDetailsResponse> otaUpdateDetailsResponse;
    private final LiveData<String> planDetails;
    private LiveData<String> productType;
    private final LiveData<String> referralCode;
    private LiveData<Boolean> scanSerialNo;
    private String serialNo;
    private SerialNumberUpdateResponse serialNumberUpdateResponse;
    private final LiveData<Boolean> softwareUpdate;
    private final LiveData<String> softwareVersion;
    private final Lazy subscriptionRepository$delegate;
    private final LiveData<Triple<List<String>, List<IBarDataSet>, String>> usageStats;
    private final MutableLiveData<User> user;
    private final MutableLiveData<UserDetailsResponse> userDetailsResponse;
    private final LiveData<Pair<String, Integer>> waterRemaining;
    private LiveData<Integer> wifiImage;
    private LiveData<Integer> wifiImageOff;
    private final MutableLiveData<String> hintLabel = new MutableLiveData<>();
    private final MutableLiveData<String> hintButtonText = new MutableLiveData<>();

    /* compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/livpure/safedrink/app/HomeViewModel$Analytics;", "", "(Ljava/lang/String;I)V", "UPDATE_USER_PLAN_VALIDITY", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum Analytics {
        UPDATE_USER_PLAN_VALIDITY
    }

    /* compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/livpure/safedrink/app/HomeViewModel$HomeNavigationStates;", "", "(Ljava/lang/String;I)V", "SELECT_PLAN", "CHECK_KYC", "CHECK_PAYMENT", "CHECK_INSTALLATION", "UPDATE_KYC", "INSTALLATION_PENDING", "HOME", "ADD_LITRES", "RECHARGE_CHANGE_PLAN", "REFER_AND_EARN", "INVITE", "BOLT_SETTINGS", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum HomeNavigationStates {
        SELECT_PLAN,
        CHECK_KYC,
        CHECK_PAYMENT,
        CHECK_INSTALLATION,
        UPDATE_KYC,
        INSTALLATION_PENDING,
        HOME,
        ADD_LITRES,
        RECHARGE_CHANGE_PLAN,
        REFER_AND_EARN,
        INVITE,
        BOLT_SETTINGS
    }

    public HomeViewModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue("");
        this.hintHeaderText = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue(Integer.valueOf((int) R.drawable.ic_logo));
        this.hintImageResId = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        mutableLiveData3.setValue(true);
        this.hintVisibility = mutableLiveData3;
        this.analytics = new MutableLiveData<>();
        this.serialNo = "";
        this.imeiNo = "";
        this._productType = "";
        this.deviceSerialNumber = "";
        this.subscriptionRepository$delegate = LazyKt.lazy(new Function0<SubscriptionRepository>() { // from class: com.livpure.safedrink.app.HomeViewModel$subscriptionRepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SubscriptionRepository invoke() {
                return new SubscriptionRepository();
            }
        });
        this.otaRepository$delegate = LazyKt.lazy(new Function0<OTARepository>() { // from class: com.livpure.safedrink.app.HomeViewModel$otaRepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OTARepository invoke() {
                return new OTARepository();
            }
        });
        this.otaData = new MutableLiveData<>();
        this.otaUpdateDetailsResponse = new MutableLiveData<>();
        this.homeNavigationState = new MutableLiveData<>();
        MutableLiveData<DashboardDetailsResponse> mutableLiveData4 = new MutableLiveData<>();
        this.dashboardData = mutableLiveData4;
        MutableLiveData<User> mutableLiveData5 = new MutableLiveData<>();
        mutableLiveData5.setValue(LSApplication.Companion.getUser());
        this.user = mutableLiveData5;
        this.BLERepository$delegate = LazyKt.lazy(new Function0<BoltDataUpdateRepository>() { // from class: com.livpure.safedrink.app.HomeViewModel$BLERepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BoltDataUpdateRepository invoke() {
                return new BoltDataUpdateRepository();
            }
        });
        this.BLECommands$delegate = LazyKt.lazy(new Function0<BoltBleCommandsRespository>() { // from class: com.livpure.safedrink.app.HomeViewModel$BLECommands$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BoltBleCommandsRespository invoke() {
                return new BoltBleCommandsRespository();
            }
        });
        LiveData<Pair<String, Integer>> map = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda5
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Pair m432waterRemaining$lambda4;
                m432waterRemaining$lambda4 = HomeViewModel.m432waterRemaining$lambda4((DashboardDetailsResponse) obj);
                return m432waterRemaining$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(dashboardData) {\n   …\"\", null)\n        }\n    }");
        this.waterRemaining = map;
        LiveData<String> map2 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda28
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m408connectivity$lambda5;
                m408connectivity$lambda5 = HomeViewModel.m408connectivity$lambda5((DashboardDetailsResponse) obj);
                return m408connectivity$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "map(dashboardData) {\n   …se\n            \"\"\n\n\n    }");
        this.connectivity = map2;
        LiveData<String> map3 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m424planDetails$lambda7;
                m424planDetails$lambda7 = HomeViewModel.m424planDetails$lambda7(HomeViewModel.this, (DashboardDetailsResponse) obj);
                return m424planDetails$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map3, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.planDetails = map3;
        LiveData<Integer> map4 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda6
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m409filterLifeImage$lambda8;
                m409filterLifeImage$lambda8 = HomeViewModel.m409filterLifeImage$lambda8((DashboardDetailsResponse) obj);
                return m409filterLifeImage$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map4, "map(dashboardData) {\n   …       -1\n        }\n    }");
        this.filterLifeImage = map4;
        LiveData<Integer> map5 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda26
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m433wifiImage$lambda9;
                m433wifiImage$lambda9 = HomeViewModel.m433wifiImage$lambda9((DashboardDetailsResponse) obj);
                return m433wifiImage$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map5, "map(dashboardData) {\n        R.drawable.wifi\n    }");
        this.wifiImage = map5;
        LiveData<Integer> map6 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda2
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m405bleImage$lambda10;
                m405bleImage$lambda10 = HomeViewModel.m405bleImage$lambda10((DashboardDetailsResponse) obj);
                return m405bleImage$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map6, "map(dashboardData) {\n   ….drawable.bluetooth\n    }");
        this.bleImage = map6;
        LiveData<Integer> map7 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda10
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m434wifiImageOff$lambda11;
                m434wifiImageOff$lambda11 = HomeViewModel.m434wifiImageOff$lambda11((DashboardDetailsResponse) obj);
                return m434wifiImageOff$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map7, "map(dashboardData) {\n   …R.drawable.wifi_off\n    }");
        this.wifiImageOff = map7;
        LiveData<Integer> map8 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda27
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m406bleImageOff$lambda12;
                m406bleImageOff$lambda12 = HomeViewModel.m406bleImageOff$lambda12((DashboardDetailsResponse) obj);
                return m406bleImageOff$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map8, "map(dashboardData) {\n   …wable.bluetooth_off\n    }");
        this.bleImageOff = map8;
        LiveData<String> map9 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda13
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m425productType$lambda13;
                m425productType$lambda13 = HomeViewModel.m425productType$lambda13((DashboardDetailsResponse) obj);
                return m425productType$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map9, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.productType = map9;
        LiveData<Boolean> map10 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda8
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m417hardwareUpdate$lambda14;
                m417hardwareUpdate$lambda14 = HomeViewModel.m417hardwareUpdate$lambda14((DashboardDetailsResponse) obj);
                return m417hardwareUpdate$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map10, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.hardwareUpdate = map10;
        LiveData<Boolean> map11 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda7
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m428softwareUpdate$lambda15;
                m428softwareUpdate$lambda15 = HomeViewModel.m428softwareUpdate$lambda15((DashboardDetailsResponse) obj);
                return m428softwareUpdate$lambda15;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map11, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.softwareUpdate = map11;
        LiveData<String> map12 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda12
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m418hardwareVersion$lambda16;
                m418hardwareVersion$lambda16 = HomeViewModel.m418hardwareVersion$lambda16((DashboardDetailsResponse) obj);
                return m418hardwareVersion$lambda16;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map12, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.hardwareVersion = map12;
        LiveData<String> map13 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda3
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m429softwareVersion$lambda17;
                m429softwareVersion$lambda17 = HomeViewModel.m429softwareVersion$lambda17((DashboardDetailsResponse) obj);
                return m429softwareVersion$lambda17;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map13, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.softwareVersion = map13;
        LiveData<String> map14 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda1
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m420lastSynchronizedDate$lambda18;
                m420lastSynchronizedDate$lambda18 = HomeViewModel.m420lastSynchronizedDate$lambda18((DashboardDetailsResponse) obj);
                return m420lastSynchronizedDate$lambda18;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map14, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.lastSynchronizedDate = map14;
        LiveData<Boolean> map15 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda9
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m427scanSerialNo$lambda19;
                m427scanSerialNo$lambda19 = HomeViewModel.m427scanSerialNo$lambda19((DashboardDetailsResponse) obj);
                return m427scanSerialNo$lambda19;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map15, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.scanSerialNo = map15;
        LiveData<Triple<List<String>, List<IBarDataSet>, String>> map16 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda29
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Triple m431usageStats$lambda20;
                m431usageStats$lambda20 = HomeViewModel.m431usageStats$lambda20((DashboardDetailsResponse) obj);
                return m431usageStats$lambda20;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map16, "map(dashboardData) {\n   …null, \"\")\n        }\n    }");
        this.usageStats = map16;
        LiveData<Boolean> map17 = Transformations.map(mutableLiveData4, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda4
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m419isTopUpAllowed$lambda21;
                m419isTopUpAllowed$lambda21 = HomeViewModel.m419isTopUpAllowed$lambda21((DashboardDetailsResponse) obj);
                return m419isTopUpAllowed$lambda21;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map17, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.isTopUpAllowed = map17;
        LiveData<String> map18 = Transformations.map(mutableLiveData5, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda22
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m426referralCode$lambda22;
                m426referralCode$lambda22 = HomeViewModel.m426referralCode$lambda22((User) obj);
                return m426referralCode$lambda22;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map18, "map(user) {\n        if (…       \"\"\n        }\n    }");
        this.referralCode = map18;
        this.userDetailsResponse = new MutableLiveData<>();
        this.boltCommandsResponse = new MediatorLiveData<>();
        LiveData<String> map19 = Transformations.map(this.otaData, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda23
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m422otaRequestCmd$lambda32;
                m422otaRequestCmd$lambda32 = HomeViewModel.m422otaRequestCmd$lambda32((MessageDetailsResponse) obj);
                return m422otaRequestCmd$lambda32;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map19, "map(otaData) {\n        i…       \"\"\n        }\n    }");
        this.otaRequestCmd = map19;
        LiveData<String> map20 = Transformations.map(this.otaUpdateDetailsResponse, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda25
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m423otaRequestMessage$lambda33;
                m423otaRequestMessage$lambda33 = HomeViewModel.m423otaRequestMessage$lambda33((OTAUpdateDetailsResponse) obj);
                return m423otaRequestMessage$lambda33;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map20, "map(otaUpdateDetailsResp…       \"\"\n        }\n    }");
        this.otaRequestMessage = map20;
        LiveData<String> map21 = Transformations.map(this.otaUpdateDetailsResponse, new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda24
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m421otaMessage$lambda34;
                m421otaMessage$lambda34 = HomeViewModel.m421otaMessage$lambda34((OTAUpdateDetailsResponse) obj);
                return m421otaMessage$lambda34;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map21, "map(otaUpdateDetailsResp…       \"\"\n        }\n    }");
        this.otaMessage = map21;
    }

    public final MutableLiveData<String> getHintLabel() {
        return this.hintLabel;
    }

    public final MutableLiveData<String> getHintButtonText() {
        return this.hintButtonText;
    }

    public final MutableLiveData<String> getHintHeaderText() {
        return this.hintHeaderText;
    }

    public final MutableLiveData<Integer> getHintImageResId() {
        return this.hintImageResId;
    }

    public final MutableLiveData<Boolean> getHintVisibility() {
        return this.hintVisibility;
    }

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final void setSerialNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serialNo = str;
    }

    public final DeviceList get_device() {
        return this._device;
    }

    public final void set_device(DeviceList deviceList) {
        this._device = deviceList;
    }

    public final String getImeiNo() {
        return this.imeiNo;
    }

    public final void setImeiNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imeiNo = str;
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

    public final Function0<Unit> getOnHintButtonClick() {
        Function0<Unit> function0 = this.onHintButtonClick;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onHintButtonClick");
        return null;
    }

    public final void setOnHintButtonClick(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onHintButtonClick = function0;
    }

    private final SubscriptionRepository getSubscriptionRepository() {
        return (SubscriptionRepository) this.subscriptionRepository$delegate.getValue();
    }

    private final OTARepository getOtaRepository() {
        return (OTARepository) this.otaRepository$delegate.getValue();
    }

    public final MutableLiveData<User> getUser() {
        return this.user;
    }

    private final BoltDataUpdateRepository getBLERepository() {
        return (BoltDataUpdateRepository) this.BLERepository$delegate.getValue();
    }

    private final BoltBleCommandsRespository getBLECommands() {
        return (BoltBleCommandsRespository) this.BLECommands$delegate.getValue();
    }

    public final LiveData<Pair<String, Integer>> getWaterRemaining() {
        return this.waterRemaining;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: waterRemaining$lambda-4  reason: not valid java name */
    public static final Pair m432waterRemaining$lambda4(DashboardDetailsResponse dashboardDetailsResponse) {
        String remainingLitres;
        String padStart;
        String remainingLitres2;
        String totalConsumed;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        String str = "";
        if ((dashboardDetails != null ? dashboardDetails.getUsage() : null) != null) {
            ProductStats productStats = dashboardDetailsResponse.getDashboardDetails().getProductStats();
            if ((productStats != null ? productStats.getProductType() : null) == null ? !((remainingLitres = dashboardDetailsResponse.getDashboardDetails().getUsage().getRemainingLitres()) == null || (padStart = StringsKt.padStart(remainingLitres, 5, '0')) == null) : !(!Intrinsics.areEqual(dashboardDetailsResponse.getDashboardDetails().getProductStats().getProductType(), "zinger-copper-emi") ? (remainingLitres2 = dashboardDetailsResponse.getDashboardDetails().getUsage().getRemainingLitres()) == null || (padStart = StringsKt.padStart(remainingLitres2, 5, '0')) == null : (totalConsumed = dashboardDetailsResponse.getDashboardDetails().getUsage().getTotalConsumed()) == null || (padStart = StringsKt.padStart(totalConsumed, 5, '0')) == null)) {
                str = padStart;
            }
            long parseLong = Long.parseLong(str);
            return new Pair(str, Integer.valueOf(parseLong > 40 ? R.drawable.fullwaterlarge : parseLong > 10 ? R.drawable.purifyinglarge : R.drawable.emptywaterlarge));
        }
        return new Pair("", null);
    }

    public final LiveData<String> getConnectivity() {
        return this.connectivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: connectivity$lambda-5  reason: not valid java name */
    public static final String m408connectivity$lambda5(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return ((dashboardDetails != null ? dashboardDetails.getFaultCodeDetails() : null) == null || dashboardDetailsResponse.getDashboardDetails().getFaultCodeDetails().getConnectivity() == null) ? "" : dashboardDetailsResponse.getDashboardDetails().getFaultCodeDetails().getConnectivity();
    }

    public final DeviceList getDevice() {
        return this.device;
    }

    public final void setDevice(DeviceList deviceList) {
        String serialNo;
        this.device = deviceList;
        this._device = deviceList;
        String str = "";
        this.imeiNo = (deviceList == null || (r2 = deviceList.getImeiNo()) == null) ? "" : "";
        DeviceList deviceList2 = this.device;
        this._productType = (deviceList2 == null || (r2 = deviceList2.getProductType()) == null) ? "" : "";
        DeviceList deviceList3 = this.device;
        this.serialNo = (deviceList3 == null || (r2 = deviceList3.getSerialNo()) == null) ? "" : "";
        DeviceList deviceList4 = this.device;
        if (deviceList4 != null && (serialNo = deviceList4.getSerialNo()) != null) {
            str = serialNo;
        }
        this.deviceSerialNumber = str;
    }

    public final LiveData<String> getPlanDetails() {
        return this.planDetails;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: planDetails$lambda-7  reason: not valid java name */
    public static final String m424planDetails$lambda7(HomeViewModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        List split$default;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        String str2 = "";
        if ((dashboardDetails != null ? dashboardDetails.getSubscriptionDetails() : null) != null) {
            SubscriptionDetails subscriptionDetails = dashboardDetailsResponse.getDashboardDetails().getSubscriptionDetails();
            User user = LSApplication.Companion.getUser();
            if (user != null) {
                String planName = subscriptionDetails.getPlanName();
                if (planName != null && (split$default = StringsKt.split$default((CharSequence) planName, new String[]{" "}, false, 0, 6, (Object) null)) != null && (str = (String) split$default.get(0)) != null) {
                    str2 = str;
                }
                user.setPlanName(str2);
                user.setPlanValidTillDate(subscriptionDetails.getValidTillDate());
                this$0.analytics.setValue(new Event<>(Analytics.UPDATE_USER_PLAN_VALIDITY));
            }
            ProductStats productStats = dashboardDetailsResponse.getDashboardDetails().getProductStats();
            if ((productStats != null ? productStats.getProductType() : null) != null) {
                String str3 = dashboardDetailsResponse.getDashboardDetails().getProductStats().getProductType().toString();
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                String lowerCase = str3.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (Intrinsics.areEqual(lowerCase, "zinger-copper-emi")) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("%s\n%s\n%s", Arrays.copyOf(new Object[]{"Plan - EMI", "Valid Till: " + subscriptionDetails.getEmiValidityTill(), "EMI Paid: " + subscriptionDetails.getEmiPaid()}, 3));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    return format;
                }
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format("%s\n%s\n%s\n%s", Arrays.copyOf(new Object[]{subscriptionDetails.getPlanName(), "Valid Till: " + subscriptionDetails.getValidTillDate(), "Rate: " + subscriptionDetails.getPlanRate(), subscriptionDetails.getNormalizedBalanceString()}, 4));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                return format2;
            }
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format("%s\n%s\n%s\n%s", Arrays.copyOf(new Object[]{subscriptionDetails.getPlanName(), "Valid Till: " + subscriptionDetails.getValidTillDate(), "Rate: " + subscriptionDetails.getPlanRate(), subscriptionDetails.getNormalizedBalanceString()}, 4));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            return format3;
        }
        return "";
    }

    public final LiveData<Integer> getFilterLifeImage() {
        return this.filterLifeImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: filterLifeImage$lambda-8  reason: not valid java name */
    public static final Integer m409filterLifeImage$lambda8(DashboardDetailsResponse dashboardDetailsResponse) {
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

    public final LiveData<Integer> getWifiImage() {
        return this.wifiImage;
    }

    public final void setWifiImage(LiveData<Integer> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.wifiImage = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: wifiImage$lambda-9  reason: not valid java name */
    public static final Integer m433wifiImage$lambda9(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: bleImage$lambda-10  reason: not valid java name */
    public static final Integer m405bleImage$lambda10(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: wifiImageOff$lambda-11  reason: not valid java name */
    public static final Integer m434wifiImageOff$lambda11(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: bleImageOff$lambda-12  reason: not valid java name */
    public static final Integer m406bleImageOff$lambda12(DashboardDetailsResponse dashboardDetailsResponse) {
        return Integer.valueOf((int) R.drawable.bluetooth_off);
    }

    public final LiveData<String> getProductType() {
        return this.productType;
    }

    public final void setProductType(LiveData<String> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.productType = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: productType$lambda-13  reason: not valid java name */
    public static final String m425productType$lambda13(DashboardDetailsResponse dashboardDetailsResponse) {
        ProductStats productStats;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return ((dashboardDetails == null || (productStats = dashboardDetails.getProductStats()) == null) ? null : productStats.getProductType()) != null ? dashboardDetailsResponse.getDashboardDetails().getProductStats().getProductType() : "";
    }

    public final LiveData<Boolean> getHardwareUpdate() {
        return this.hardwareUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hardwareUpdate$lambda-14  reason: not valid java name */
    public static final Boolean m417hardwareUpdate$lambda14(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getHardwareVersion() : false);
    }

    public final LiveData<Boolean> getSoftwareUpdate() {
        return this.softwareUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: softwareUpdate$lambda-15  reason: not valid java name */
    public static final Boolean m428softwareUpdate$lambda15(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getSoftwareVersion() : false);
    }

    public final LiveData<String> getHardwareVersion() {
        return this.hardwareVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hardwareVersion$lambda-16  reason: not valid java name */
    public static final String m418hardwareVersion$lambda16(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getCurrentHardwareVersion() : "";
    }

    public final LiveData<String> getSoftwareVersion() {
        return this.softwareVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: softwareVersion$lambda-17  reason: not valid java name */
    public static final String m429softwareVersion$lambda17(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getCurrentSoftwareVersion() : "";
    }

    public final LiveData<String> getLastSynchronizedDate() {
        return this.lastSynchronizedDate;
    }

    public final void setLastSynchronizedDate(LiveData<String> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.lastSynchronizedDate = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lastSynchronizedDate$lambda-18  reason: not valid java name */
    public static final String m420lastSynchronizedDate$lambda18(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getLastSyncDate() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getLastSyncDate() : "";
    }

    public final LiveData<Boolean> getScanSerialNo() {
        return this.scanSerialNo;
    }

    public final void setScanSerialNo(LiveData<Boolean> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.scanSerialNo = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: scanSerialNo$lambda-19  reason: not valid java name */
    public static final Boolean m427scanSerialNo$lambda19(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getScanSerialNo() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getScanSerialNo().booleanValue() : false);
    }

    public final LiveData<Triple<List<String>, List<IBarDataSet>, String>> getUsageStats() {
        return this.usageStats;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: usageStats$lambda-20  reason: not valid java name */
    public static final Triple m431usageStats$lambda20(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        List<DailyConsumptionItem> dailyConsumptionList = dashboardDetails != null ? dashboardDetails.getDailyConsumptionList() : null;
        if (!(dailyConsumptionList == null || dailyConsumptionList.isEmpty())) {
            DashboardDetails dashboardDetails2 = dashboardDetailsResponse.getDashboardDetails();
            Intrinsics.checkNotNull(dashboardDetails2);
            return dashboardDetails2.getConsumptionData();
        }
        return new Triple(null, null, "");
    }

    public final LiveData<Boolean> isTopUpAllowed() {
        return this.isTopUpAllowed;
    }

    public final void setTopUpAllowed(LiveData<Boolean> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.isTopUpAllowed = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isTopUpAllowed$lambda-21  reason: not valid java name */
    public static final Boolean m419isTopUpAllowed$lambda21(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getSubscriptionDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getSubscriptionDetails().get_AllowTopup() : false);
    }

    public final LiveData<String> getReferralCode() {
        return this.referralCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: referralCode$lambda-22  reason: not valid java name */
    public static final String m426referralCode$lambda22(User user) {
        return user.getReferralCode() != null ? user.getReferralCode() : "";
    }

    public final LiveData<Event<Analytics>> observeAnalytics() {
        return this.analytics;
    }

    public final LiveData<HomeNavigationStates> getHomeNavigationState() {
        this.homeNavigationState.setValue(HomeNavigationStates.CHECK_PAYMENT);
        return this.homeNavigationState;
    }

    public final void checkPaymentStatus() {
        User user = LSApplication.Companion.getUser();
        boolean z = true;
        if (!((user == null || !user.getPaymentCompleted()) ? false : false)) {
            this.homeNavigationState.setValue(HomeNavigationStates.SELECT_PLAN);
        } else {
            this.homeNavigationState.setValue(HomeNavigationStates.CHECK_KYC);
        }
    }

    public final void checkKYCStatus() {
        User user = LSApplication.Companion.getUser();
        Intrinsics.checkNotNull(user);
        if (user.getKycCompleted()) {
            this.homeNavigationState.setValue(HomeNavigationStates.UPDATE_KYC);
        } else {
            this.homeNavigationState.setValue(HomeNavigationStates.CHECK_INSTALLATION);
        }
    }

    public final void checkInstallationStatus() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getSubscriptionRepository().getInstallationStatus(), new Observer() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda15
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeViewModel.m407checkInstallationStatus$lambda23(HomeViewModel.this, (BaseV1ResponseImplementation) obj);
                    }
                });
                return;
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! Looks like we faced an issue contacting our server."));
                return;
            }
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkInstallationStatus$lambda-23  reason: not valid java name */
    public static final void m407checkInstallationStatus$lambda23(final HomeViewModel this$0, BaseV1ResponseImplementation baseV1ResponseImplementation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(baseV1ResponseImplementation, new Function1<BaseV1ResponseImplementation, Unit>() { // from class: com.livpure.safedrink.app.HomeViewModel$checkInstallationStatus$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseV1ResponseImplementation baseV1ResponseImplementation2) {
                invoke2(baseV1ResponseImplementation2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BaseV1ResponseImplementation it) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(it, "it");
                mutableLiveData = HomeViewModel.this.homeNavigationState;
                mutableLiveData.setValue(HomeViewModel.HomeNavigationStates.HOME);
            }
        }, new Function1<BaseV1ResponseImplementation, Unit>() { // from class: com.livpure.safedrink.app.HomeViewModel$checkInstallationStatus$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseV1ResponseImplementation baseV1ResponseImplementation2) {
                invoke2(baseV1ResponseImplementation2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BaseV1ResponseImplementation it) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(it, "it");
                mutableLiveData = HomeViewModel.this.homeNavigationState;
                mutableLiveData.setValue(HomeViewModel.HomeNavigationStates.INSTALLATION_PENDING);
            }
        });
    }

    public final void updateLocationDetails(String latitude, String longitude) {
        Intrinsics.checkNotNullParameter(latitude, "latitude");
        Intrinsics.checkNotNullParameter(longitude, "longitude");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getSubscriptionRepository().updateLocationDetails(this.deviceSerialNumber, latitude, longitude), new Observer() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda21
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

    public final void getDashboardDetails() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getSubscriptionRepository().getDashboardDetails(this.serialNo), new Observer() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda18
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeViewModel.m410getDashboardDetails$lambda25(HomeViewModel.this, (DashboardDetailsResponse) obj);
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
    /* renamed from: getDashboardDetails$lambda-25  reason: not valid java name */
    public static final void m410getDashboardDetails$lambda25(final HomeViewModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(dashboardDetailsResponse, new Function1<DashboardDetailsResponse, Unit>() { // from class: com.livpure.safedrink.app.HomeViewModel$getDashboardDetails$1$1
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
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                mutableLiveData = HomeViewModel.this.dashboardData;
                mutableLiveData.setValue(successfulResponse);
            }
        }, new Function1<DashboardDetailsResponse, Unit>() { // from class: com.livpure.safedrink.app.HomeViewModel$getDashboardDetails$1$2
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
                toastMessageLiveData = HomeViewModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Oops! We faced an issue while fetching your dashboard details at this time."));
            }
        });
    }

    public final void onAddLitresClicked() {
        this.homeNavigationState.setValue(HomeNavigationStates.ADD_LITRES);
    }

    public final void onReferFriendsAndEarnClicked() {
        this.homeNavigationState.setValue(HomeNavigationStates.REFER_AND_EARN);
    }

    public final void onReferShareClicked() {
        this.homeNavigationState.setValue(HomeNavigationStates.INVITE);
    }

    public final void onBoltSettingsClicked() {
        this.homeNavigationState.setValue(HomeNavigationStates.BOLT_SETTINGS);
    }

    public final void onRenewChangePlanClicked() {
        this.homeNavigationState.setValue(HomeNavigationStates.RECHARGE_CHANGE_PLAN);
    }

    public final void showHintView(int i, String hint, String buttonText, String header, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(hint, "hint");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.hintVisibility.setValue(true);
        this.hintImageResId.setValue(Integer.valueOf(i));
        this.hintLabel.setValue(hint);
        this.hintButtonText.setValue(buttonText);
        setOnHintButtonClick(onClick);
        this.hintHeaderText.setValue(header);
    }

    public final void hideHintView() {
        this.hintVisibility.setValue(false);
    }

    public final void refreshHintView() {
        User user = LSApplication.Companion.getUser();
        if (!(user != null && user.getPaymentCompleted())) {
            showHintView(R.drawable.ic_select_plan, "Looks like you have not selected a plan. Select one now to get started", "Select Plan", "Subscribe Now", new Function0<Unit>() { // from class: com.livpure.safedrink.app.HomeViewModel$refreshHintView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = HomeViewModel.this.homeNavigationState;
                    mutableLiveData.setValue(HomeViewModel.HomeNavigationStates.SELECT_PLAN);
                }
            });
            return;
        }
        User user2 = LSApplication.Companion.getUser();
        Intrinsics.checkNotNull(user2);
        if (!user2.getKycCompleted()) {
            showHintView(R.drawable.ic_kyc_document, "Looks like we do not have your KYC documents yet! Upload your KYC documents and complete this final step.", "Upload KYC", "KYC Pending", new Function0<Unit>() { // from class: com.livpure.safedrink.app.HomeViewModel$refreshHintView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = HomeViewModel.this.homeNavigationState;
                    mutableLiveData.setValue(HomeViewModel.HomeNavigationStates.UPDATE_KYC);
                }
            });
        } else if (this.homeNavigationState.getValue() == HomeNavigationStates.INSTALLATION_PENDING) {
            this.homeNavigationState.setValue(HomeNavigationStates.INSTALLATION_PENDING);
        } else if (CollectionsKt.contains(CollectionsKt.listOf((Object[]) new HomeNavigationStates[]{HomeNavigationStates.HOME, HomeNavigationStates.ADD_LITRES, HomeNavigationStates.RECHARGE_CHANGE_PLAN, HomeNavigationStates.REFER_AND_EARN, HomeNavigationStates.BOLT_SETTINGS}), this.homeNavigationState.getValue())) {
            this.homeNavigationState.setValue(HomeNavigationStates.HOME);
        }
    }

    public final LiveData<UserDetailsResponse> getUserDetails(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (LSApplication.Companion.isNetworkAvailable()) {
            User user = LSApplication.Companion.getUser();
            String email = user != null ? user.getEmail() : null;
            if (!(email == null || StringsKt.isBlank(email))) {
                getLoading().setValue(true);
                try {
                    User user2 = LSApplication.Companion.getUser();
                    Intrinsics.checkNotNull(user2);
                    String email2 = user2.getEmail();
                    Intrinsics.checkNotNull(email2);
                    observeAndTrack(UserRepository.Companion.getInstance(context).getUserDetails(email2), new Observer() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda20
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            HomeViewModel.m416getUserDetails$lambda26(HomeViewModel.this, context, (UserDetailsResponse) obj);
                        }
                    });
                } catch (APIException unused) {
                    getLoading().setValue(false);
                    getToastMessageLiveData().setValue(new Event<>("Oops! We faced some issue while refreshing your details."));
                }
            }
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
        return this.userDetailsResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUserDetails$lambda-26  reason: not valid java name */
    public static final void m416getUserDetails$lambda26(final HomeViewModel this$0, final Context context, UserDetailsResponse userDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.getLoading().setValue(false);
        this$0.processResponse(userDetailsResponse, new Function1<UserDetailsResponse, Unit>() { // from class: com.livpure.safedrink.app.HomeViewModel$getUserDetails$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UserDetailsResponse userDetailsResponse2) {
                invoke2(userDetailsResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserDetailsResponse successfulResponse) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                mutableLiveData = HomeViewModel.this.userDetailsResponse;
                mutableLiveData.setValue(successfulResponse);
                List<UserDetailsV1> userDetailsList = successfulResponse.getUserDetailsList();
                User mappedUser = !(userDetailsList == null || userDetailsList.isEmpty()) ? successfulResponse.getUserDetailsList().get(0).getMappedUser() : null;
                if (mappedUser != null) {
                    UserRepository.Companion.getInstance(context).setUser(mappedUser);
                }
            }
        }, new Function1<UserDetailsResponse, Unit>() { // from class: com.livpure.safedrink.app.HomeViewModel$getUserDetails$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UserDetailsResponse userDetailsResponse2) {
                invoke2(userDetailsResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserDetailsResponse it) {
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(it, "it");
                toastMessageLiveData = HomeViewModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Oops! We faced some issue while refreshing your details."));
            }
        });
    }

    public final LiveData<Boolean> getSubmissionBLEStatus(String statusPkt, String powerPkt) {
        Intrinsics.checkNotNullParameter(statusPkt, "statusPkt");
        Intrinsics.checkNotNullParameter(powerPkt, "powerPkt");
        if (LSApplication.Companion.isNetworkAvailable()) {
            return Transformations.map(getBLERepository().sendBoltConfigtRequest(this.serialNo, statusPkt, true), new Function() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda11
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Boolean m415getSubmissionBLEStatus$lambda27;
                    m415getSubmissionBLEStatus$lambda27 = HomeViewModel.m415getSubmissionBLEStatus$lambda27((BaseDataHolder) obj);
                    return m415getSubmissionBLEStatus$lambda27;
                }
            });
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSubmissionBLEStatus$lambda-27  reason: not valid java name */
    public static final Boolean m415getSubmissionBLEStatus$lambda27(BaseDataHolder baseDataHolder) {
        return Boolean.valueOf(baseDataHolder.getStatus());
    }

    public final LiveData<BoltCommandsResponse> getPendingBleCommand() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            this.boltCommandsResponse.addSource(getBLECommands().getBoltBleCommands(this.serialNo), new Observer() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda14
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeViewModel.m413getPendingBleCommand$lambda28(HomeViewModel.this, (BaseDataHolder) obj);
                }
            });
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
        return this.boltCommandsResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPendingBleCommand$lambda-28  reason: not valid java name */
    public static final void m413getPendingBleCommand$lambda28(HomeViewModel this$0, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
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

    public final void getSerialNumberStatus(String roSerialNumber) {
        Intrinsics.checkNotNullParameter(roSerialNumber, "roSerialNumber");
        if (Intrinsics.areEqual(roSerialNumber, "")) {
            return;
        }
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getSubscriptionRepository().getUpdateSerialNumber(roSerialNumber), new Observer() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda19
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeViewModel.m414getSerialNumberStatus$lambda29(HomeViewModel.this, (SerialNumberUpdateResponse) obj);
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
    /* renamed from: getSerialNumberStatus$lambda-29  reason: not valid java name */
    public static final void m414getSerialNumberStatus$lambda29(final HomeViewModel this$0, final SerialNumberUpdateResponse serialNumberUpdateResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(serialNumberUpdateResponse, new Function1<SerialNumberUpdateResponse, Unit>() { // from class: com.livpure.safedrink.app.HomeViewModel$getSerialNumberStatus$1$1
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
            public final void invoke2(SerialNumberUpdateResponse successfulResponse) {
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                SerialNumberUpdateResponse.this.getMessage();
            }
        }, new Function1<SerialNumberUpdateResponse, Unit>() { // from class: com.livpure.safedrink.app.HomeViewModel$getSerialNumberStatus$1$2
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
                toastMessageLiveData = HomeViewModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event(String.valueOf(it.getMessage())));
            }
        });
    }

    public final void getOTA(String _acion, String bleData, String hwVersion, String swVersion) {
        Intrinsics.checkNotNullParameter(_acion, "_acion");
        Intrinsics.checkNotNullParameter(bleData, "bleData");
        Intrinsics.checkNotNullParameter(hwVersion, "hwVersion");
        Intrinsics.checkNotNullParameter(swVersion, "swVersion");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                OTARepository otaRepository = getOtaRepository();
                DeviceList deviceList = this._device;
                String valueOf = String.valueOf(deviceList != null ? deviceList.getProductType() : null);
                DeviceList deviceList2 = this._device;
                observeAndTrack(otaRepository.getOTADetails(valueOf, String.valueOf(deviceList2 != null ? deviceList2.getImeiNo() : null), _acion, hwVersion, swVersion, bleData), new Observer() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda16
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeViewModel.m412getOTA$lambda30(HomeViewModel.this, (MessageDetailsResponse) obj);
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
    /* renamed from: getOTA$lambda-30  reason: not valid java name */
    public static final void m412getOTA$lambda30(HomeViewModel this$0, MessageDetailsResponse messageDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        if (messageDetailsResponse.getOtaDetails() != null) {
            this$0.otaData.setValue(messageDetailsResponse);
        }
    }

    public final void getFirmwareData(String _acion, String bleData) {
        Intrinsics.checkNotNullParameter(_acion, "_acion");
        Intrinsics.checkNotNullParameter(bleData, "bleData");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                OTARepository otaRepository = getOtaRepository();
                DeviceList deviceList = this._device;
                observeAndTrack(otaRepository.getFirmawareData(String.valueOf(deviceList != null ? deviceList.getImeiNo() : null), _acion, bleData), new Observer() { // from class: com.livpure.safedrink.app.HomeViewModel$$ExternalSyntheticLambda17
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeViewModel.m411getFirmwareData$lambda31(HomeViewModel.this, (OTAUpdateDetailsResponse) obj);
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
    /* renamed from: getFirmwareData$lambda-31  reason: not valid java name */
    public static final void m411getFirmwareData$lambda31(HomeViewModel this$0, OTAUpdateDetailsResponse oTAUpdateDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        if (oTAUpdateDetailsResponse.getFirmwareDetails() != null) {
            this$0.otaUpdateDetailsResponse.setValue(oTAUpdateDetailsResponse);
        }
    }

    public final LiveData<String> getOtaRequestCmd() {
        return this.otaRequestCmd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: otaRequestCmd$lambda-32  reason: not valid java name */
    public static final String m422otaRequestCmd$lambda32(MessageDetailsResponse messageDetailsResponse) {
        MessageDetails otaDetails = messageDetailsResponse.getOtaDetails();
        return (otaDetails != null ? otaDetails.getCommandDetails() : null) != null ? messageDetailsResponse.getOtaDetails().getCommandDetails().getOR() : "";
    }

    public final LiveData<String> getOtaRequestMessage() {
        return this.otaRequestMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: otaRequestMessage$lambda-33  reason: not valid java name */
    public static final String m423otaRequestMessage$lambda33(OTAUpdateDetailsResponse oTAUpdateDetailsResponse) {
        MessageDetails firmwareDetails = oTAUpdateDetailsResponse.getFirmwareDetails();
        return (firmwareDetails != null ? firmwareDetails.getFirmwareData() : null) != null ? oTAUpdateDetailsResponse.getFirmwareDetails().getFirmwareData() : "";
    }

    public final LiveData<String> getOtaMessage() {
        return this.otaMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: otaMessage$lambda-34  reason: not valid java name */
    public static final String m421otaMessage$lambda34(OTAUpdateDetailsResponse oTAUpdateDetailsResponse) {
        MessageDetails firmwareDetails = oTAUpdateDetailsResponse.getFirmwareDetails();
        return (firmwareDetails != null ? firmwareDetails.getMessage() : null) != null ? oTAUpdateDetailsResponse.getFirmwareDetails().getMessage() : "";
    }
}

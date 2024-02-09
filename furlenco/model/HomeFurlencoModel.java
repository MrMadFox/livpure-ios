package com.livpure.safedrink.furlenco.model;

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
import com.livpure.safedrink.app.HomeViewModel;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.bolt.data.BoltBleCommandsRespository;
import com.livpure.safedrink.bolt.data.BoltDataUpdateRepository;
import com.livpure.safedrink.bolt.data.models.BoltCommandsResponse;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
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
import com.livpure.safedrink.subscription.plan.data.model.SubscriptionDetails;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.DailyConsumptionItem;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.DashboardDetails;
import com.livpure.safedrink.subscription.plan.data.model.dashboard.ProductStats;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
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
/* compiled from: HomeFurlencoModel.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010h\u001a\u00020iJ\u0016\u0010j\u001a\u00020i2\u0006\u0010k\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u000fJ\f\u0010m\u001a\b\u0012\u0004\u0012\u0002040\u0015J&\u0010n\u001a\u00020i2\u0006\u0010k\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u000f2\u0006\u0010o\u001a\u00020\u000f2\u0006\u0010p\u001a\u00020\u000fJ\f\u0010q\u001a\b\u0012\u0004\u0012\u00020 0\u0015J\u001e\u0010r\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u00152\u0006\u0010s\u001a\u00020\u000f2\u0006\u0010t\u001a\u00020\u000fJ\u0014\u0010u\u001a\b\u0012\u0004\u0012\u00020^0\u00152\u0006\u0010v\u001a\u00020wJ\u0006\u0010x\u001a\u00020iR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R \u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0018R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u0015¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0018R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0018R\u0014\u00103\u001a\b\u0012\u0004\u0012\u0002040$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u000f0$¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0014\u00108\u001a\b\u0012\u0004\u0012\u0002090$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0018R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\b\u001a\u0004\b>\u0010?R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0018R\u0017\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0018R\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020F0$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0018R \u0010I\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0018\"\u0004\bK\u0010\u001aR\u001a\u0010L\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0011\"\u0004\bN\u0010\u0013R\u0017\u0010O\u001a\b\u0012\u0004\u0012\u00020/0\u0015¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0018R\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0018R\u001b\u0010S\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\b\u001a\u0004\bU\u0010VR9\u0010X\u001a*\u0012&\u0012$\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010Z\u0012\f\u0012\n\u0012\u0004\u0012\u00020[\u0018\u00010Z\u0012\u0004\u0012\u00020\u000f0Y0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010\u0018R\u0014\u0010]\u001a\b\u0012\u0004\u0012\u00020^0$X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010_\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00160`0\u0015¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u0018R \u0010b\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0018\"\u0004\bd\u0010\u001aR \u0010e\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u0018\"\u0004\bg\u0010\u001a¨\u0006y"}, d2 = {"Lcom/livpure/safedrink/furlenco/model/HomeFurlencoModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "BLECommands", "Lcom/livpure/safedrink/bolt/data/BoltBleCommandsRespository;", "getBLECommands", "()Lcom/livpure/safedrink/bolt/data/BoltBleCommandsRespository;", "BLECommands$delegate", "Lkotlin/Lazy;", "BLERepository", "Lcom/livpure/safedrink/bolt/data/BoltDataUpdateRepository;", "getBLERepository", "()Lcom/livpure/safedrink/bolt/data/BoltDataUpdateRepository;", "BLERepository$delegate", "ImeiNo", "", "getImeiNo", "()Ljava/lang/String;", "setImeiNo", "(Ljava/lang/String;)V", "bleImage", "Landroidx/lifecycle/LiveData;", "", "getBleImage", "()Landroidx/lifecycle/LiveData;", "setBleImage", "(Landroidx/lifecycle/LiveData;)V", "bleImageOff", "getBleImageOff", "setBleImageOff", "boltCommandsResponse", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/livpure/safedrink/bolt/data/models/BoltCommandsResponse;", "connectivity", "getConnectivity", "dashboardData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/livpure/safedrink/subscription/plan/data/model/DashboardDetailsResponse;", "deviceConnectivity", "getDeviceConnectivity", "setDeviceConnectivity", "deviceIMEI_Number", "getDeviceIMEI_Number", "setDeviceIMEI_Number", "filterLifeImage", "getFilterLifeImage", "hardwareUpdate", "", "getHardwareUpdate", "hardwareVersion", "getHardwareVersion", "homeNavigationState", "Lcom/livpure/safedrink/app/HomeViewModel$HomeNavigationStates;", "last_synchronized_on", "getLast_synchronized_on", "()Landroidx/lifecycle/MutableLiveData;", "otaData", "Lcom/livpure/safedrink/ota/data/model/MessageDetailsResponse;", "otaMessage", "getOtaMessage", "otaRepository", "Lcom/livpure/safedrink/ota/data/OTARepository;", "getOtaRepository", "()Lcom/livpure/safedrink/ota/data/OTARepository;", "otaRepository$delegate", "otaRequestCmd", "getOtaRequestCmd", "otaRequestMessage", "getOtaRequestMessage", "otaUpdateDetailsResponse", "Lcom/livpure/safedrink/ota/data/model/OTAUpdateDetailsResponse;", "planDetails", "getPlanDetails", "productType", "getProductType", "setProductType", "serialNo", "getSerialNo", "setSerialNo", "softwareUpdate", "getSoftwareUpdate", "softwareVersion", "getSoftwareVersion", "subscriptionRepository", "Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "getSubscriptionRepository", "()Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "subscriptionRepository$delegate", "usageStats", "Lkotlin/Triple;", "", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "getUsageStats", "userDetailsResponse", "Lcom/livpure/safedrink/login/api/models/response/UserDetailsResponse;", "waterRemaining", "Lkotlin/Pair;", "getWaterRemaining", "wifiImage", "getWifiImage", "setWifiImage", "wifiImageOff", "getWifiImageOff", "setWifiImageOff", "getDashboardDetails", "", "getFirmwareData", "_acion", "bleData", "getHomeNavigationState", "getOTA", "hwVersion", "swVersion", "getPendingBleCommand", "getSubmissionBLEStatus", "statusPkt", "powerPkt", "getUserDetails", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "onBoltSettingsClicked", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeFurlencoModel extends MediatorViewModel {
    private final Lazy BLECommands$delegate;
    private final Lazy BLERepository$delegate;
    private String ImeiNo;
    private LiveData<Integer> bleImage;
    private LiveData<Integer> bleImageOff;
    private final MediatorLiveData<BoltCommandsResponse> boltCommandsResponse;
    private final LiveData<String> connectivity;
    private final MutableLiveData<DashboardDetailsResponse> dashboardData;
    private String deviceConnectivity;
    private LiveData<String> deviceIMEI_Number;
    private final LiveData<Integer> filterLifeImage;
    private final LiveData<Boolean> hardwareUpdate;
    private final LiveData<String> hardwareVersion;
    private final MutableLiveData<HomeViewModel.HomeNavigationStates> homeNavigationState;
    private final MutableLiveData<String> last_synchronized_on;
    private MutableLiveData<MessageDetailsResponse> otaData;
    private final LiveData<String> otaMessage;
    private final Lazy otaRepository$delegate;
    private final LiveData<String> otaRequestCmd;
    private final LiveData<String> otaRequestMessage;
    private MutableLiveData<OTAUpdateDetailsResponse> otaUpdateDetailsResponse;
    private final LiveData<String> planDetails;
    private LiveData<String> productType;
    private String serialNo;
    private final LiveData<Boolean> softwareUpdate;
    private final LiveData<String> softwareVersion;
    private final Lazy subscriptionRepository$delegate;
    private final LiveData<Triple<List<String>, List<IBarDataSet>, String>> usageStats;
    private final MutableLiveData<UserDetailsResponse> userDetailsResponse;
    private final LiveData<Pair<String, Integer>> waterRemaining;
    private LiveData<Integer> wifiImage;
    private LiveData<Integer> wifiImageOff;

    public HomeFurlencoModel() {
        MutableLiveData<DashboardDetailsResponse> mutableLiveData = new MutableLiveData<>();
        this.dashboardData = mutableLiveData;
        this.subscriptionRepository$delegate = LazyKt.lazy(new Function0<SubscriptionRepository>() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$subscriptionRepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SubscriptionRepository invoke() {
                return new SubscriptionRepository();
            }
        });
        this.BLERepository$delegate = LazyKt.lazy(new Function0<BoltDataUpdateRepository>() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$BLERepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BoltDataUpdateRepository invoke() {
                return new BoltDataUpdateRepository();
            }
        });
        this.BLECommands$delegate = LazyKt.lazy(new Function0<BoltBleCommandsRespository>() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$BLECommands$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BoltBleCommandsRespository invoke() {
                return new BoltBleCommandsRespository();
            }
        });
        this.otaUpdateDetailsResponse = new MutableLiveData<>();
        this.otaRepository$delegate = LazyKt.lazy(new Function0<OTARepository>() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$otaRepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OTARepository invoke() {
                return new OTARepository();
            }
        });
        this.otaData = new MutableLiveData<>();
        this.userDetailsResponse = new MutableLiveData<>();
        this.boltCommandsResponse = new MediatorLiveData<>();
        this.homeNavigationState = new MutableLiveData<>();
        this.serialNo = "";
        this.ImeiNo = "";
        this.deviceConnectivity = "";
        this.last_synchronized_on = new MutableLiveData<>();
        LiveData<Pair<String, Integer>> map = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda6
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Pair m1003waterRemaining$lambda0;
                m1003waterRemaining$lambda0 = HomeFurlencoModel.m1003waterRemaining$lambda0((DashboardDetailsResponse) obj);
                return m1003waterRemaining$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(dashboardData) {\n   …\"\", null)\n        }\n    }");
        this.waterRemaining = map;
        LiveData<String> map2 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda9
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m984connectivity$lambda1;
                m984connectivity$lambda1 = HomeFurlencoModel.m984connectivity$lambda1((DashboardDetailsResponse) obj);
                return m984connectivity$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "map(dashboardData) {\n   …else\n            \"\"\n    }");
        this.connectivity = map2;
        LiveData<String> map3 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda7
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m998planDetails$lambda3;
                m998planDetails$lambda3 = HomeFurlencoModel.m998planDetails$lambda3((DashboardDetailsResponse) obj);
                return m998planDetails$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map3, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.planDetails = map3;
        LiveData<Integer> map4 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda23
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m986filterLifeImage$lambda4;
                m986filterLifeImage$lambda4 = HomeFurlencoModel.m986filterLifeImage$lambda4((DashboardDetailsResponse) obj);
                return m986filterLifeImage$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map4, "map(dashboardData) {\n   …       -1\n        }\n    }");
        this.filterLifeImage = map4;
        LiveData<Integer> map5 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda2
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m1004wifiImage$lambda5;
                m1004wifiImage$lambda5 = HomeFurlencoModel.m1004wifiImage$lambda5((DashboardDetailsResponse) obj);
                return m1004wifiImage$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map5, "map(dashboardData) {\n        R.drawable.wifi\n    }");
        this.wifiImage = map5;
        LiveData<Integer> map6 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda22
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m982bleImage$lambda6;
                m982bleImage$lambda6 = HomeFurlencoModel.m982bleImage$lambda6((DashboardDetailsResponse) obj);
                return m982bleImage$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map6, "map(dashboardData) {\n   ….drawable.bluetooth\n    }");
        this.bleImage = map6;
        LiveData<Integer> map7 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda4
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m1005wifiImageOff$lambda7;
                m1005wifiImageOff$lambda7 = HomeFurlencoModel.m1005wifiImageOff$lambda7((DashboardDetailsResponse) obj);
                return m1005wifiImageOff$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map7, "map(dashboardData) {\n   …R.drawable.wifi_off\n    }");
        this.wifiImageOff = map7;
        LiveData<Integer> map8 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda3
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer m983bleImageOff$lambda8;
                m983bleImageOff$lambda8 = HomeFurlencoModel.m983bleImageOff$lambda8((DashboardDetailsResponse) obj);
                return m983bleImageOff$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map8, "map(dashboardData) {\n   …wable.bluetooth_off\n    }");
        this.bleImageOff = map8;
        LiveData<String> map9 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda20
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m999productType$lambda9;
                m999productType$lambda9 = HomeFurlencoModel.m999productType$lambda9((DashboardDetailsResponse) obj);
                return m999productType$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map9, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.productType = map9;
        LiveData<Boolean> map10 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda21
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m993hardwareUpdate$lambda10;
                m993hardwareUpdate$lambda10 = HomeFurlencoModel.m993hardwareUpdate$lambda10((DashboardDetailsResponse) obj);
                return m993hardwareUpdate$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map10, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.hardwareUpdate = map10;
        LiveData<Boolean> map11 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda19
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m1000softwareUpdate$lambda11;
                m1000softwareUpdate$lambda11 = HomeFurlencoModel.m1000softwareUpdate$lambda11((DashboardDetailsResponse) obj);
                return m1000softwareUpdate$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map11, "map(dashboardData) {\n   …    false\n        }\n    }");
        this.softwareUpdate = map11;
        LiveData<String> map12 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda5
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m994hardwareVersion$lambda12;
                m994hardwareVersion$lambda12 = HomeFurlencoModel.m994hardwareVersion$lambda12((DashboardDetailsResponse) obj);
                return m994hardwareVersion$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map12, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.hardwareVersion = map12;
        LiveData<String> map13 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda8
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m1001softwareVersion$lambda13;
                m1001softwareVersion$lambda13 = HomeFurlencoModel.m1001softwareVersion$lambda13((DashboardDetailsResponse) obj);
                return m1001softwareVersion$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map13, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.softwareVersion = map13;
        LiveData<Triple<List<String>, List<IBarDataSet>, String>> map14 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda1
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Triple m1002usageStats$lambda14;
                m1002usageStats$lambda14 = HomeFurlencoModel.m1002usageStats$lambda14((DashboardDetailsResponse) obj);
                return m1002usageStats$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map14, "map(dashboardData) {\n   …null, \"\")\n        }\n    }");
        this.usageStats = map14;
        LiveData<String> map15 = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m985deviceIMEI_Number$lambda15;
                m985deviceIMEI_Number$lambda15 = HomeFurlencoModel.m985deviceIMEI_Number$lambda15(HomeFurlencoModel.this, (DashboardDetailsResponse) obj);
                return m985deviceIMEI_Number$lambda15;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map15, "map(dashboardData) {\n   …       \"\"\n        }\n    }");
        this.deviceIMEI_Number = map15;
        LiveData<String> map16 = Transformations.map(this.otaData, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda16
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m996otaRequestCmd$lambda22;
                m996otaRequestCmd$lambda22 = HomeFurlencoModel.m996otaRequestCmd$lambda22((MessageDetailsResponse) obj);
                return m996otaRequestCmd$lambda22;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map16, "map(otaData) {\n        i…       \"\"\n        }\n    }");
        this.otaRequestCmd = map16;
        LiveData<String> map17 = Transformations.map(this.otaUpdateDetailsResponse, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda18
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m997otaRequestMessage$lambda23;
                m997otaRequestMessage$lambda23 = HomeFurlencoModel.m997otaRequestMessage$lambda23((OTAUpdateDetailsResponse) obj);
                return m997otaRequestMessage$lambda23;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map17, "map(otaUpdateDetailsResp…       \"\"\n        }\n    }");
        this.otaRequestMessage = map17;
        LiveData<String> map18 = Transformations.map(this.otaUpdateDetailsResponse, new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda17
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m995otaMessage$lambda24;
                m995otaMessage$lambda24 = HomeFurlencoModel.m995otaMessage$lambda24((OTAUpdateDetailsResponse) obj);
                return m995otaMessage$lambda24;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map18, "map(otaUpdateDetailsResp…       \"\"\n        }\n    }");
        this.otaMessage = map18;
    }

    private final SubscriptionRepository getSubscriptionRepository() {
        return (SubscriptionRepository) this.subscriptionRepository$delegate.getValue();
    }

    private final BoltDataUpdateRepository getBLERepository() {
        return (BoltDataUpdateRepository) this.BLERepository$delegate.getValue();
    }

    private final BoltBleCommandsRespository getBLECommands() {
        return (BoltBleCommandsRespository) this.BLECommands$delegate.getValue();
    }

    private final OTARepository getOtaRepository() {
        return (OTARepository) this.otaRepository$delegate.getValue();
    }

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final void setSerialNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serialNo = str;
    }

    public final String getImeiNo() {
        return this.ImeiNo;
    }

    public final void setImeiNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ImeiNo = str;
    }

    public final String getDeviceConnectivity() {
        return this.deviceConnectivity;
    }

    public final void setDeviceConnectivity(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceConnectivity = str;
    }

    public final MutableLiveData<String> getLast_synchronized_on() {
        return this.last_synchronized_on;
    }

    public final void onBoltSettingsClicked() {
        this.homeNavigationState.setValue(HomeViewModel.HomeNavigationStates.BOLT_SETTINGS);
    }

    public final LiveData<HomeViewModel.HomeNavigationStates> getHomeNavigationState() {
        return this.homeNavigationState;
    }

    public final LiveData<Pair<String, Integer>> getWaterRemaining() {
        return this.waterRemaining;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: waterRemaining$lambda-0  reason: not valid java name */
    public static final Pair m1003waterRemaining$lambda0(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: connectivity$lambda-1  reason: not valid java name */
    public static final String m984connectivity$lambda1(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getDevice_Connectivity() : null) != null) {
            dashboardDetailsResponse.getDashboardDetails().getDevice_Connectivity();
            return "";
        }
        return "";
    }

    public final LiveData<String> getPlanDetails() {
        return this.planDetails;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: planDetails$lambda-3  reason: not valid java name */
    public static final String m998planDetails$lambda3(DashboardDetailsResponse dashboardDetailsResponse) {
        List split$default;
        String str;
        List split$default2;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        String str2 = "";
        if ((dashboardDetails != null ? dashboardDetails.getSubscriptionDetails() : null) != null) {
            SubscriptionDetails subscriptionDetails = dashboardDetailsResponse.getDashboardDetails().getSubscriptionDetails();
            User user = LSApplication.Companion.getUser();
            if (user != null) {
                String planName = subscriptionDetails.getPlanName();
                user.setPlanName((planName == null || (split$default2 = StringsKt.split$default((CharSequence) planName, new String[]{" "}, false, 0, 6, (Object) null)) == null || (r4 = (String) split$default2.get(0)) == null) ? "" : "");
                user.setPlanValidTillDate(subscriptionDetails.getValidTillDate());
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[2];
            String planName2 = subscriptionDetails.getPlanName();
            if (planName2 != null && (split$default = StringsKt.split$default((CharSequence) planName2, new String[]{" "}, false, 0, 6, (Object) null)) != null && (str = (String) split$default.get(0)) != null) {
                str2 = str;
            }
            objArr[0] = str2;
            objArr[1] = "Valid Till: " + subscriptionDetails.getValidTillDate();
            String format = String.format("%s\n%s", Arrays.copyOf(objArr, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        return "";
    }

    public final LiveData<Integer> getFilterLifeImage() {
        return this.filterLifeImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: filterLifeImage$lambda-4  reason: not valid java name */
    public static final Integer m986filterLifeImage$lambda4(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: wifiImage$lambda-5  reason: not valid java name */
    public static final Integer m1004wifiImage$lambda5(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: bleImage$lambda-6  reason: not valid java name */
    public static final Integer m982bleImage$lambda6(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: wifiImageOff$lambda-7  reason: not valid java name */
    public static final Integer m1005wifiImageOff$lambda7(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: bleImageOff$lambda-8  reason: not valid java name */
    public static final Integer m983bleImageOff$lambda8(DashboardDetailsResponse dashboardDetailsResponse) {
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
    /* renamed from: productType$lambda-9  reason: not valid java name */
    public static final String m999productType$lambda9(DashboardDetailsResponse dashboardDetailsResponse) {
        ProductStats productStats;
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return ((dashboardDetails == null || (productStats = dashboardDetails.getProductStats()) == null) ? null : productStats.getProductType()) != null ? dashboardDetailsResponse.getDashboardDetails().getProductStats().getProductType() : "";
    }

    public final LiveData<Boolean> getHardwareUpdate() {
        return this.hardwareUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hardwareUpdate$lambda-10  reason: not valid java name */
    public static final Boolean m993hardwareUpdate$lambda10(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getHardwareVersion() : false);
    }

    public final LiveData<Boolean> getSoftwareUpdate() {
        return this.softwareUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: softwareUpdate$lambda-11  reason: not valid java name */
    public static final Boolean m1000softwareUpdate$lambda11(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return Boolean.valueOf((dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getSoftwareVersion() : false);
    }

    public final LiveData<String> getHardwareVersion() {
        return this.hardwareVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hardwareVersion$lambda-12  reason: not valid java name */
    public static final String m994hardwareVersion$lambda12(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getCurrentHardwareVersion() : "";
    }

    public final LiveData<String> getSoftwareVersion() {
        return this.softwareVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: softwareVersion$lambda-13  reason: not valid java name */
    public static final String m1001softwareVersion$lambda13(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        return (dashboardDetails != null ? dashboardDetails.getFirmwareDetails() : null) != null ? dashboardDetailsResponse.getDashboardDetails().getFirmwareDetails().getCurrentSoftwareVersion() : "";
    }

    public final LiveData<Triple<List<String>, List<IBarDataSet>, String>> getUsageStats() {
        return this.usageStats;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: usageStats$lambda-14  reason: not valid java name */
    public static final Triple m1002usageStats$lambda14(DashboardDetailsResponse dashboardDetailsResponse) {
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        List<DailyConsumptionItem> dailyConsumptionList = dashboardDetails != null ? dashboardDetails.getDailyConsumptionList() : null;
        if (!(dailyConsumptionList == null || dailyConsumptionList.isEmpty())) {
            DashboardDetails dashboardDetails2 = dashboardDetailsResponse.getDashboardDetails();
            Intrinsics.checkNotNull(dashboardDetails2);
            return dashboardDetails2.getConsumptionData();
        }
        return new Triple(null, null, "");
    }

    public final LiveData<String> getDeviceIMEI_Number() {
        return this.deviceIMEI_Number;
    }

    public final void setDeviceIMEI_Number(LiveData<String> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.deviceIMEI_Number = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: deviceIMEI_Number$lambda-15  reason: not valid java name */
    public static final String m985deviceIMEI_Number$lambda15(HomeFurlencoModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DashboardDetails dashboardDetails = dashboardDetailsResponse.getDashboardDetails();
        if ((dashboardDetails != null ? dashboardDetails.getDevice_IMEI_Number() : null) != null) {
            this$0.ImeiNo = dashboardDetailsResponse.getDashboardDetails().getDevice_IMEI_Number();
            return dashboardDetailsResponse.getDashboardDetails().getDevice_IMEI_Number();
        }
        return "";
    }

    public final void getDashboardDetails() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getSubscriptionRepository().getDashboardDetails(""), new Observer() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda14
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeFurlencoModel.m987getDashboardDetails$lambda16(HomeFurlencoModel.this, (DashboardDetailsResponse) obj);
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
    public static final void m987getDashboardDetails$lambda16(final HomeFurlencoModel this$0, DashboardDetailsResponse dashboardDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(dashboardDetailsResponse, new Function1<DashboardDetailsResponse, Unit>() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$getDashboardDetails$1$1
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
                mutableLiveData = HomeFurlencoModel.this.dashboardData;
                mutableLiveData.setValue(successfulResponse);
                HomeFurlencoModel homeFurlencoModel = HomeFurlencoModel.this;
                DashboardDetails dashboardDetails = successfulResponse.getDashboardDetails();
                homeFurlencoModel.setSerialNo(String.valueOf(dashboardDetails != null ? dashboardDetails.getDevice_Serial_Number() : null));
                HomeFurlencoModel homeFurlencoModel2 = HomeFurlencoModel.this;
                DashboardDetails dashboardDetails2 = successfulResponse.getDashboardDetails();
                homeFurlencoModel2.setDeviceConnectivity(String.valueOf(dashboardDetails2 != null ? dashboardDetails2.getDevice_Connectivity() : null));
                MutableLiveData<String> last_synchronized_on = HomeFurlencoModel.this.getLast_synchronized_on();
                DashboardDetails dashboardDetails3 = successfulResponse.getDashboardDetails();
                last_synchronized_on.setValue(String.valueOf(dashboardDetails3 != null ? dashboardDetails3.getLastSyncDate() : null));
            }
        }, new Function1<DashboardDetailsResponse, Unit>() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$getDashboardDetails$1$2
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
                toastMessageLiveData = HomeFurlencoModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Oops! We faced an issue while fetching your dashboard details at this time."));
            }
        });
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
                    observeAndTrack(UserRepository.Companion.getInstance(context).getUserDetails(email2), new Observer() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda15
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            HomeFurlencoModel.m992getUserDetails$lambda17(HomeFurlencoModel.this, context, (UserDetailsResponse) obj);
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
    /* renamed from: getUserDetails$lambda-17  reason: not valid java name */
    public static final void m992getUserDetails$lambda17(final HomeFurlencoModel this$0, final Context context, UserDetailsResponse userDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.getLoading().setValue(false);
        this$0.processResponse(userDetailsResponse, new Function1<UserDetailsResponse, Unit>() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$getUserDetails$1$1
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
                mutableLiveData = HomeFurlencoModel.this.userDetailsResponse;
                mutableLiveData.setValue(successfulResponse);
                List<UserDetailsV1> userDetailsList = successfulResponse.getUserDetailsList();
                User mappedUser = !(userDetailsList == null || userDetailsList.isEmpty()) ? successfulResponse.getUserDetailsList().get(0).getMappedUser() : null;
                if (mappedUser != null) {
                    UserRepository.Companion.getInstance(context).setUser(mappedUser);
                }
            }
        }, new Function1<UserDetailsResponse, Unit>() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$getUserDetails$1$2
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
                toastMessageLiveData = HomeFurlencoModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Oops! We faced some issue while refreshing your details."));
            }
        });
    }

    public final LiveData<Boolean> getSubmissionBLEStatus(String statusPkt, String powerPkt) {
        Intrinsics.checkNotNullParameter(statusPkt, "statusPkt");
        Intrinsics.checkNotNullParameter(powerPkt, "powerPkt");
        if (LSApplication.Companion.isNetworkAvailable()) {
            return Transformations.map(getBLERepository().sendBoltConfigtRequest(this.serialNo, statusPkt, false), new Function() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda11
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Boolean m991getSubmissionBLEStatus$lambda18;
                    m991getSubmissionBLEStatus$lambda18 = HomeFurlencoModel.m991getSubmissionBLEStatus$lambda18((BaseDataHolder) obj);
                    return m991getSubmissionBLEStatus$lambda18;
                }
            });
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSubmissionBLEStatus$lambda-18  reason: not valid java name */
    public static final Boolean m991getSubmissionBLEStatus$lambda18(BaseDataHolder baseDataHolder) {
        return Boolean.valueOf(baseDataHolder.getStatus());
    }

    public final LiveData<BoltCommandsResponse> getPendingBleCommand() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            this.boltCommandsResponse.addSource(getBLECommands().getBoltBleCommands(this.serialNo), new Observer() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda10
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HomeFurlencoModel.m990getPendingBleCommand$lambda19(HomeFurlencoModel.this, (BaseDataHolder) obj);
                }
            });
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
        return this.boltCommandsResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPendingBleCommand$lambda-19  reason: not valid java name */
    public static final void m990getPendingBleCommand$lambda19(HomeFurlencoModel this$0, BaseDataHolder baseDataHolder) {
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

    public final void getOTA(String _acion, String bleData, String hwVersion, String swVersion) {
        Intrinsics.checkNotNullParameter(_acion, "_acion");
        Intrinsics.checkNotNullParameter(bleData, "bleData");
        Intrinsics.checkNotNullParameter(hwVersion, "hwVersion");
        Intrinsics.checkNotNullParameter(swVersion, "swVersion");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                OTARepository otaRepository = getOtaRepository();
                User user = LSApplication.Companion.getUser();
                observeAndTrack(otaRepository.getOTADetails(String.valueOf(user != null ? user.getPlanName() : null), this.ImeiNo, _acion, hwVersion, swVersion, bleData), new Observer() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda12
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeFurlencoModel.m989getOTA$lambda20(HomeFurlencoModel.this, (MessageDetailsResponse) obj);
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
    /* renamed from: getOTA$lambda-20  reason: not valid java name */
    public static final void m989getOTA$lambda20(HomeFurlencoModel this$0, MessageDetailsResponse messageDetailsResponse) {
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
                observeAndTrack(getOtaRepository().getFirmawareData(this.ImeiNo, _acion, bleData), new Observer() { // from class: com.livpure.safedrink.furlenco.model.HomeFurlencoModel$$ExternalSyntheticLambda13
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HomeFurlencoModel.m988getFirmwareData$lambda21(HomeFurlencoModel.this, (OTAUpdateDetailsResponse) obj);
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
    /* renamed from: getFirmwareData$lambda-21  reason: not valid java name */
    public static final void m988getFirmwareData$lambda21(HomeFurlencoModel this$0, OTAUpdateDetailsResponse oTAUpdateDetailsResponse) {
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
    /* renamed from: otaRequestCmd$lambda-22  reason: not valid java name */
    public static final String m996otaRequestCmd$lambda22(MessageDetailsResponse messageDetailsResponse) {
        MessageDetails otaDetails = messageDetailsResponse.getOtaDetails();
        return (otaDetails != null ? otaDetails.getCommandDetails() : null) != null ? messageDetailsResponse.getOtaDetails().getCommandDetails().getOR() : "";
    }

    public final LiveData<String> getOtaRequestMessage() {
        return this.otaRequestMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: otaRequestMessage$lambda-23  reason: not valid java name */
    public static final String m997otaRequestMessage$lambda23(OTAUpdateDetailsResponse oTAUpdateDetailsResponse) {
        MessageDetails firmwareDetails = oTAUpdateDetailsResponse.getFirmwareDetails();
        return (firmwareDetails != null ? firmwareDetails.getFirmwareData() : null) != null ? oTAUpdateDetailsResponse.getFirmwareDetails().getFirmwareData() : "";
    }

    public final LiveData<String> getOtaMessage() {
        return this.otaMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: otaMessage$lambda-24  reason: not valid java name */
    public static final String m995otaMessage$lambda24(OTAUpdateDetailsResponse oTAUpdateDetailsResponse) {
        MessageDetails firmwareDetails = oTAUpdateDetailsResponse.getFirmwareDetails();
        return (firmwareDetails != null ? firmwareDetails.getMessage() : null) != null ? oTAUpdateDetailsResponse.getFirmwareDetails().getMessage() : "";
    }
}

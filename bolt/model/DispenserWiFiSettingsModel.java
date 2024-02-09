package com.livpure.safedrink.bolt.model;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.bolt.data.BoltConfigurationRepository;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.dispenser.data.DispenserCommandsRepository;
import com.livpure.safedrink.dispenser.data.models.DispenserWifiStatus;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DispenserWIFISettingsModel.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010(2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00105\u001a\u000204R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b$\u0010%R\u001f\u0010'\u001a\u0010\u0012\f\u0012\n )*\u0004\u0018\u00010\u00160\u00160(¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020.0-¢\u0006\b\n\u0000\u001a\u0004\b2\u00100¨\u00066"}, d2 = {"Lcom/livpure/safedrink/bolt/model/DispenserWiFiSettingsModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "_device", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "get_device", "()Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "set_device", "(Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;)V", "value", AndroidContextPlugin.DEVICE_KEY, "getDevice", "setDevice", "dispenserCommandsRespository", "Lcom/livpure/safedrink/dispenser/data/DispenserCommandsRepository;", "getDispenserCommandsRespository", "()Lcom/livpure/safedrink/dispenser/data/DispenserCommandsRepository;", "dispenserCommandsRespository$delegate", "Lkotlin/Lazy;", "dispenserWifiStatus", "Lcom/livpure/safedrink/dispenser/data/models/DispenserWifiStatus;", "imeiNumber", "", "getImeiNumber", "()Ljava/lang/String;", "setImeiNumber", "(Ljava/lang/String;)V", "listOfWifiName", "", "getListOfWifiName", "()Ljava/util/List;", "productType", "getProductType", "setProductType", "repository", "Lcom/livpure/safedrink/bolt/data/BoltConfigurationRepository;", "getRepository", "()Lcom/livpure/safedrink/bolt/data/BoltConfigurationRepository;", "repository$delegate", "selectedWifiName", "Landroidx/lifecycle/LiveData;", "kotlin.jvm.PlatformType", "getSelectedWifiName", "()Landroidx/lifecycle/LiveData;", "selectedlistOfWifiName", "Landroidx/lifecycle/MutableLiveData;", "", "getSelectedlistOfWifiName", "()Landroidx/lifecycle/MutableLiveData;", "ssidList", "getSsidList", "getSubmissionStatus", "", "status", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DispenserWiFiSettingsModel extends MediatorViewModel {
    private DeviceList _device;
    private DeviceList device;
    private DispenserWifiStatus dispenserWifiStatus;
    private String imeiNumber;
    private String productType;
    private final LiveData<String> selectedWifiName;
    private final MutableLiveData<Integer> selectedlistOfWifiName;
    private final MutableLiveData<Integer> ssidList;
    private final Lazy repository$delegate = LazyKt.lazy(new Function0<BoltConfigurationRepository>() { // from class: com.livpure.safedrink.bolt.model.DispenserWiFiSettingsModel$repository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BoltConfigurationRepository invoke() {
            return new BoltConfigurationRepository();
        }
    });
    private final Lazy dispenserCommandsRespository$delegate = LazyKt.lazy(new Function0<DispenserCommandsRepository>() { // from class: com.livpure.safedrink.bolt.model.DispenserWiFiSettingsModel$dispenserCommandsRespository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DispenserCommandsRepository invoke() {
            return new DispenserCommandsRepository();
        }
    });
    private final List<String> listOfWifiName = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: selectedWifiName$lambda-6$lambda-5  reason: not valid java name */
    public static final void m481selectedWifiName$lambda6$lambda5(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: selectedlistOfWifiName$lambda-1$lambda-0  reason: not valid java name */
    public static final void m482selectedlistOfWifiName$lambda1$lambda0(Integer num) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ssidList$lambda-3$lambda-2  reason: not valid java name */
    public static final void m483ssidList$lambda3$lambda2(Integer num) {
    }

    public DispenserWiFiSettingsModel() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        observeAndTrack(mutableLiveData, new Observer() { // from class: com.livpure.safedrink.bolt.model.DispenserWiFiSettingsModel$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DispenserWiFiSettingsModel.m482selectedlistOfWifiName$lambda1$lambda0((Integer) obj);
            }
        });
        this.selectedlistOfWifiName = mutableLiveData;
        this.imeiNumber = "";
        this.productType = "";
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        observeAndTrack(mutableLiveData2, new Observer() { // from class: com.livpure.safedrink.bolt.model.DispenserWiFiSettingsModel$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DispenserWiFiSettingsModel.m483ssidList$lambda3$lambda2((Integer) obj);
            }
        });
        this.ssidList = mutableLiveData2;
        LiveData<String> map = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.bolt.model.DispenserWiFiSettingsModel$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m480selectedWifiName$lambda4;
                m480selectedWifiName$lambda4 = DispenserWiFiSettingsModel.m480selectedWifiName$lambda4(DispenserWiFiSettingsModel.this, (Integer) obj);
                return m480selectedWifiName$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        observeAndTrack(map, new Observer() { // from class: com.livpure.safedrink.bolt.model.DispenserWiFiSettingsModel$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DispenserWiFiSettingsModel.m481selectedWifiName$lambda6$lambda5((String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map<Int, String>(selecte…        }\n        )\n    }");
        this.selectedWifiName = map;
    }

    private final BoltConfigurationRepository getRepository() {
        return (BoltConfigurationRepository) this.repository$delegate.getValue();
    }

    private final DispenserCommandsRepository getDispenserCommandsRespository() {
        return (DispenserCommandsRepository) this.dispenserCommandsRespository$delegate.getValue();
    }

    public final List<String> getListOfWifiName() {
        return this.listOfWifiName;
    }

    public final MutableLiveData<Integer> getSelectedlistOfWifiName() {
        return this.selectedlistOfWifiName;
    }

    public final String getImeiNumber() {
        return this.imeiNumber;
    }

    public final void setImeiNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imeiNumber = str;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final void setProductType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.productType = str;
    }

    public final DeviceList get_device() {
        return this._device;
    }

    public final void set_device(DeviceList deviceList) {
        this._device = deviceList;
    }

    public final MutableLiveData<Integer> getSsidList() {
        return this.ssidList;
    }

    public final DeviceList getDevice() {
        return this.device;
    }

    public final void setDevice(DeviceList deviceList) {
        String productType;
        this._device = deviceList;
        this.device = deviceList;
        String str = "";
        this.imeiNumber = (deviceList == null || (r2 = deviceList.getImeiNo()) == null) ? "" : "";
        DeviceList deviceList2 = this.device;
        if (deviceList2 != null && (productType = deviceList2.getProductType()) != null) {
            str = productType;
        }
        this.productType = str;
    }

    public final LiveData<String> getSelectedWifiName() {
        return this.selectedWifiName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: selectedWifiName$lambda-4  reason: not valid java name */
    public static final String m480selectedWifiName$lambda4(DispenserWiFiSettingsModel this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<String> list = this$0.listOfWifiName;
        if (!(list == null || list.isEmpty())) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.intValue() < this$0.listOfWifiName.size()) {
                return this$0.listOfWifiName.get(it.intValue());
            }
        }
        return "";
    }

    public final LiveData<Boolean> getSubmissionStatus(String imeiNumber, boolean z) {
        Intrinsics.checkNotNullParameter(imeiNumber, "imeiNumber");
        DispenserWifiStatus dispenserWifiStatus = null;
        if (LSApplication.Companion.isNetworkAvailable()) {
            if (!Intrinsics.areEqual(this.productType, "AIRPURIFIER")) {
                if (z) {
                    return Transformations.map(getRepository().sendBoltConfigtRequest(imeiNumber, z, "wifi"), new Function() { // from class: com.livpure.safedrink.bolt.model.DispenserWiFiSettingsModel$$ExternalSyntheticLambda3
                        @Override // androidx.arch.core.util.Function
                        public final Object apply(Object obj) {
                            Boolean m478getSubmissionStatus$lambda8;
                            m478getSubmissionStatus$lambda8 = DispenserWiFiSettingsModel.m478getSubmissionStatus$lambda8((BaseDataHolder) obj);
                            return m478getSubmissionStatus$lambda8;
                        }
                    });
                }
                return Transformations.map(getRepository().sendBoltConfigtRequest(imeiNumber, z, "bluetooth"), new Function() { // from class: com.livpure.safedrink.bolt.model.DispenserWiFiSettingsModel$$ExternalSyntheticLambda2
                    @Override // androidx.arch.core.util.Function
                    public final Object apply(Object obj) {
                        Boolean m479getSubmissionStatus$lambda9;
                        m479getSubmissionStatus$lambda9 = DispenserWiFiSettingsModel.m479getSubmissionStatus$lambda9((BaseDataHolder) obj);
                        return m479getSubmissionStatus$lambda9;
                    }
                });
            }
            if (z) {
                this.dispenserWifiStatus = new DispenserWifiStatus(imeiNumber, "wifi");
            } else {
                this.dispenserWifiStatus = new DispenserWifiStatus(imeiNumber, "bluetooth");
            }
            DispenserCommandsRepository dispenserCommandsRespository = getDispenserCommandsRespository();
            DispenserWifiStatus dispenserWifiStatus2 = this.dispenserWifiStatus;
            if (dispenserWifiStatus2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dispenserWifiStatus");
            } else {
                dispenserWifiStatus = dispenserWifiStatus2;
            }
            return Transformations.map(dispenserCommandsRespository.setConnectivityStatus(dispenserWifiStatus), new Function() { // from class: com.livpure.safedrink.bolt.model.DispenserWiFiSettingsModel$$ExternalSyntheticLambda1
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Boolean m477getSubmissionStatus$lambda7;
                    m477getSubmissionStatus$lambda7 = DispenserWiFiSettingsModel.m477getSubmissionStatus$lambda7((BaseDataHolder) obj);
                    return m477getSubmissionStatus$lambda7;
                }
            });
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSubmissionStatus$lambda-7  reason: not valid java name */
    public static final Boolean m477getSubmissionStatus$lambda7(BaseDataHolder baseDataHolder) {
        return Boolean.valueOf(baseDataHolder.getStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSubmissionStatus$lambda-8  reason: not valid java name */
    public static final Boolean m478getSubmissionStatus$lambda8(BaseDataHolder baseDataHolder) {
        return Boolean.valueOf(baseDataHolder.getStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSubmissionStatus$lambda-9  reason: not valid java name */
    public static final Boolean m479getSubmissionStatus$lambda9(BaseDataHolder baseDataHolder) {
        return Boolean.valueOf(baseDataHolder.getStatus());
    }
}

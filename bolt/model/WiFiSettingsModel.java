package com.livpure.safedrink.bolt.model;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.livpure.safedrink.airpurifier.data.AirPurifierCommandsRespository;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierWifiStatus;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.bolt.data.BoltConfigurationRepository;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WiFiSettingsModel.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010(2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00108\u001a\u000207R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000e\u001a\u0004\b$\u0010%R\u001f\u0010'\u001a\u0010\u0012\f\u0012\n )*\u0004\u0018\u00010\u00160\u00160(¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0018\"\u0004\b3\u0010\u001aR\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020.0-¢\u0006\b\n\u0000\u001a\u0004\b5\u00100¨\u00069"}, d2 = {"Lcom/livpure/safedrink/bolt/model/WiFiSettingsModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "_device", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "get_device", "()Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "set_device", "(Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;)V", "airPurifierCommandsRespository", "Lcom/livpure/safedrink/airpurifier/data/AirPurifierCommandsRespository;", "getAirPurifierCommandsRespository", "()Lcom/livpure/safedrink/airpurifier/data/AirPurifierCommandsRespository;", "airPurifierCommandsRespository$delegate", "Lkotlin/Lazy;", "airPurifierWifiStatus", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierWifiStatus;", "value", AndroidContextPlugin.DEVICE_KEY, "getDevice", "setDevice", "imeiNumber", "", "getImeiNumber", "()Ljava/lang/String;", "setImeiNumber", "(Ljava/lang/String;)V", "listOfWifiName", "", "getListOfWifiName", "()Ljava/util/List;", "productType", "getProductType", "setProductType", "repository", "Lcom/livpure/safedrink/bolt/data/BoltConfigurationRepository;", "getRepository", "()Lcom/livpure/safedrink/bolt/data/BoltConfigurationRepository;", "repository$delegate", "selectedWifiName", "Landroidx/lifecycle/LiveData;", "kotlin.jvm.PlatformType", "getSelectedWifiName", "()Landroidx/lifecycle/LiveData;", "selectedlistOfWifiName", "Landroidx/lifecycle/MutableLiveData;", "", "getSelectedlistOfWifiName", "()Landroidx/lifecycle/MutableLiveData;", "serialNumber", "getSerialNumber", "setSerialNumber", "ssidList", "getSsidList", "getSubmissionStatus", "", "status", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WiFiSettingsModel extends MediatorViewModel {
    private DeviceList _device;
    private AirPurifierWifiStatus airPurifierWifiStatus;
    private DeviceList device;
    private String imeiNumber;
    private String productType;
    private final LiveData<String> selectedWifiName;
    private final MutableLiveData<Integer> selectedlistOfWifiName;
    private String serialNumber;
    private final MutableLiveData<Integer> ssidList;
    private final Lazy repository$delegate = LazyKt.lazy(new Function0<BoltConfigurationRepository>() { // from class: com.livpure.safedrink.bolt.model.WiFiSettingsModel$repository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BoltConfigurationRepository invoke() {
            return new BoltConfigurationRepository();
        }
    });
    private final Lazy airPurifierCommandsRespository$delegate = LazyKt.lazy(new Function0<AirPurifierCommandsRespository>() { // from class: com.livpure.safedrink.bolt.model.WiFiSettingsModel$airPurifierCommandsRespository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AirPurifierCommandsRespository invoke() {
            return new AirPurifierCommandsRespository();
        }
    });
    private final List<String> listOfWifiName = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: selectedWifiName$lambda-6$lambda-5  reason: not valid java name */
    public static final void m492selectedWifiName$lambda6$lambda5(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: selectedlistOfWifiName$lambda-1$lambda-0  reason: not valid java name */
    public static final void m493selectedlistOfWifiName$lambda1$lambda0(Integer num) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ssidList$lambda-3$lambda-2  reason: not valid java name */
    public static final void m494ssidList$lambda3$lambda2(Integer num) {
    }

    public WiFiSettingsModel() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        observeAndTrack(mutableLiveData, new Observer() { // from class: com.livpure.safedrink.bolt.model.WiFiSettingsModel$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WiFiSettingsModel.m493selectedlistOfWifiName$lambda1$lambda0((Integer) obj);
            }
        });
        this.selectedlistOfWifiName = mutableLiveData;
        this.imeiNumber = "";
        this.productType = "";
        this.serialNumber = "";
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        observeAndTrack(mutableLiveData2, new Observer() { // from class: com.livpure.safedrink.bolt.model.WiFiSettingsModel$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WiFiSettingsModel.m494ssidList$lambda3$lambda2((Integer) obj);
            }
        });
        this.ssidList = mutableLiveData2;
        LiveData<String> map = Transformations.map(mutableLiveData, new Function() { // from class: com.livpure.safedrink.bolt.model.WiFiSettingsModel$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m491selectedWifiName$lambda4;
                m491selectedWifiName$lambda4 = WiFiSettingsModel.m491selectedWifiName$lambda4(WiFiSettingsModel.this, (Integer) obj);
                return m491selectedWifiName$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        observeAndTrack(map, new Observer() { // from class: com.livpure.safedrink.bolt.model.WiFiSettingsModel$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WiFiSettingsModel.m492selectedWifiName$lambda6$lambda5((String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map<Int, String>(selecte…        }\n        )\n    }");
        this.selectedWifiName = map;
    }

    private final BoltConfigurationRepository getRepository() {
        return (BoltConfigurationRepository) this.repository$delegate.getValue();
    }

    private final AirPurifierCommandsRespository getAirPurifierCommandsRespository() {
        return (AirPurifierCommandsRespository) this.airPurifierCommandsRespository$delegate.getValue();
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

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final void setSerialNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serialNumber = str;
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
        String serialNo;
        this._device = deviceList;
        this.device = deviceList;
        String str = "";
        this.imeiNumber = (deviceList == null || (r2 = deviceList.getImeiNo()) == null) ? "" : "";
        DeviceList deviceList2 = this.device;
        this.productType = (deviceList2 == null || (r2 = deviceList2.getProductType()) == null) ? "" : "";
        DeviceList deviceList3 = this.device;
        if (deviceList3 != null && (serialNo = deviceList3.getSerialNo()) != null) {
            str = serialNo;
        }
        this.serialNumber = str;
    }

    public final LiveData<String> getSelectedWifiName() {
        return this.selectedWifiName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: selectedWifiName$lambda-4  reason: not valid java name */
    public static final String m491selectedWifiName$lambda4(WiFiSettingsModel this$0, Integer it) {
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
        AirPurifierWifiStatus airPurifierWifiStatus = null;
        if (LSApplication.Companion.isNetworkAvailable()) {
            if (!Intrinsics.areEqual(this.productType, "air-purifier")) {
                if (z) {
                    return Transformations.map(getRepository().sendBoltConfigtRequest(imeiNumber, z, "wifi"), new Function() { // from class: com.livpure.safedrink.bolt.model.WiFiSettingsModel$$ExternalSyntheticLambda3
                        @Override // androidx.arch.core.util.Function
                        public final Object apply(Object obj) {
                            Boolean m489getSubmissionStatus$lambda8;
                            m489getSubmissionStatus$lambda8 = WiFiSettingsModel.m489getSubmissionStatus$lambda8((BaseDataHolder) obj);
                            return m489getSubmissionStatus$lambda8;
                        }
                    });
                }
                return Transformations.map(getRepository().sendBoltConfigtRequest(imeiNumber, z, "bluetooth"), new Function() { // from class: com.livpure.safedrink.bolt.model.WiFiSettingsModel$$ExternalSyntheticLambda2
                    @Override // androidx.arch.core.util.Function
                    public final Object apply(Object obj) {
                        Boolean m490getSubmissionStatus$lambda9;
                        m490getSubmissionStatus$lambda9 = WiFiSettingsModel.m490getSubmissionStatus$lambda9((BaseDataHolder) obj);
                        return m490getSubmissionStatus$lambda9;
                    }
                });
            }
            this.airPurifierWifiStatus = new AirPurifierWifiStatus(imeiNumber, "wifi");
            AirPurifierCommandsRespository airPurifierCommandsRespository = getAirPurifierCommandsRespository();
            AirPurifierWifiStatus airPurifierWifiStatus2 = this.airPurifierWifiStatus;
            if (airPurifierWifiStatus2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("airPurifierWifiStatus");
            } else {
                airPurifierWifiStatus = airPurifierWifiStatus2;
            }
            return Transformations.map(airPurifierCommandsRespository.setConnectivityStatus(airPurifierWifiStatus), new Function() { // from class: com.livpure.safedrink.bolt.model.WiFiSettingsModel$$ExternalSyntheticLambda1
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Boolean m488getSubmissionStatus$lambda7;
                    m488getSubmissionStatus$lambda7 = WiFiSettingsModel.m488getSubmissionStatus$lambda7((BaseDataHolder) obj);
                    return m488getSubmissionStatus$lambda7;
                }
            });
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSubmissionStatus$lambda-7  reason: not valid java name */
    public static final Boolean m488getSubmissionStatus$lambda7(BaseDataHolder baseDataHolder) {
        return Boolean.valueOf(baseDataHolder.getStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSubmissionStatus$lambda-8  reason: not valid java name */
    public static final Boolean m489getSubmissionStatus$lambda8(BaseDataHolder baseDataHolder) {
        return Boolean.valueOf(baseDataHolder.getStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSubmissionStatus$lambda-9  reason: not valid java name */
    public static final Boolean m490getSubmissionStatus$lambda9(BaseDataHolder baseDataHolder) {
        return Boolean.valueOf(baseDataHolder.getStatus());
    }
}

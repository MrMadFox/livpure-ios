package com.livpure.safedrink.bolt.model;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
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
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DispenserSettingModel.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010)\u001a\u00020(2\u0006\u0010\t\u001a\u00020\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b#\u0010$¨\u0006*"}, d2 = {"Lcom/livpure/safedrink/bolt/model/DispenserSettingModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "_device", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "get_device", "()Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "set_device", "(Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;)V", "connectivity", "", "getConnectivity", "()Ljava/lang/String;", "setConnectivity", "(Ljava/lang/String;)V", "value", AndroidContextPlugin.DEVICE_KEY, "getDevice", "setDevice", "dispenserCommandsRespository", "Lcom/livpure/safedrink/dispenser/data/DispenserCommandsRepository;", "getDispenserCommandsRespository", "()Lcom/livpure/safedrink/dispenser/data/DispenserCommandsRepository;", "dispenserCommandsRespository$delegate", "Lkotlin/Lazy;", "dispenserWifiStatus", "Lcom/livpure/safedrink/dispenser/data/models/DispenserWifiStatus;", "imeiNumber", "getImeiNumber", "setImeiNumber", "productType", "getProductType", "setProductType", "repository", "Lcom/livpure/safedrink/bolt/data/BoltConfigurationRepository;", "getRepository", "()Lcom/livpure/safedrink/bolt/data/BoltConfigurationRepository;", "repository$delegate", "getSubmissionStatus", "Landroidx/lifecycle/LiveData;", "", "status", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DispenserSettingModel extends MediatorViewModel {
    private DeviceList _device;
    private DeviceList device;
    private DispenserWifiStatus dispenserWifiStatus;
    private final Lazy repository$delegate = LazyKt.lazy(new Function0<BoltConfigurationRepository>() { // from class: com.livpure.safedrink.bolt.model.DispenserSettingModel$repository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BoltConfigurationRepository invoke() {
            return new BoltConfigurationRepository();
        }
    });
    private final Lazy dispenserCommandsRespository$delegate = LazyKt.lazy(new Function0<DispenserCommandsRepository>() { // from class: com.livpure.safedrink.bolt.model.DispenserSettingModel$dispenserCommandsRespository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DispenserCommandsRepository invoke() {
            return new DispenserCommandsRepository();
        }
    });
    private String imeiNumber = "";
    private String connectivity = "";
    private String productType = "";

    private final BoltConfigurationRepository getRepository() {
        return (BoltConfigurationRepository) this.repository$delegate.getValue();
    }

    private final DispenserCommandsRepository getDispenserCommandsRespository() {
        return (DispenserCommandsRepository) this.dispenserCommandsRespository$delegate.getValue();
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

    public final String getProductType() {
        return this.productType;
    }

    public final void setProductType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.productType = str;
    }

    public final LiveData<Boolean> getSubmissionStatus(String imeiNumber, boolean z, String connectivity) {
        Intrinsics.checkNotNullParameter(imeiNumber, "imeiNumber");
        Intrinsics.checkNotNullParameter(connectivity, "connectivity");
        DispenserWifiStatus dispenserWifiStatus = null;
        if (LSApplication.Companion.isNetworkAvailable()) {
            if (Intrinsics.areEqual(this.productType, "AIRPURIFIER")) {
                this.dispenserWifiStatus = new DispenserWifiStatus(imeiNumber, "bluetooth");
                DispenserCommandsRepository dispenserCommandsRespository = getDispenserCommandsRespository();
                DispenserWifiStatus dispenserWifiStatus2 = this.dispenserWifiStatus;
                if (dispenserWifiStatus2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dispenserWifiStatus");
                } else {
                    dispenserWifiStatus = dispenserWifiStatus2;
                }
                return Transformations.map(dispenserCommandsRespository.setConnectivityStatus(dispenserWifiStatus), new Function() { // from class: com.livpure.safedrink.bolt.model.DispenserSettingModel$$ExternalSyntheticLambda0
                    @Override // androidx.arch.core.util.Function
                    public final Object apply(Object obj) {
                        Boolean m471getSubmissionStatus$lambda0;
                        m471getSubmissionStatus$lambda0 = DispenserSettingModel.m471getSubmissionStatus$lambda0((BaseDataHolder) obj);
                        return m471getSubmissionStatus$lambda0;
                    }
                });
            }
            return Transformations.map(getRepository().sendBoltConfigtRequest(imeiNumber, z, connectivity), new Function() { // from class: com.livpure.safedrink.bolt.model.DispenserSettingModel$$ExternalSyntheticLambda1
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Boolean m472getSubmissionStatus$lambda1;
                    m472getSubmissionStatus$lambda1 = DispenserSettingModel.m472getSubmissionStatus$lambda1((BaseDataHolder) obj);
                    return m472getSubmissionStatus$lambda1;
                }
            });
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSubmissionStatus$lambda-0  reason: not valid java name */
    public static final Boolean m471getSubmissionStatus$lambda0(BaseDataHolder baseDataHolder) {
        return Boolean.valueOf(baseDataHolder.getStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSubmissionStatus$lambda-1  reason: not valid java name */
    public static final Boolean m472getSubmissionStatus$lambda1(BaseDataHolder baseDataHolder) {
        return Boolean.valueOf(baseDataHolder.getStatus());
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
        this.connectivity = (deviceList2 == null || (r2 = deviceList2.getConnectivity()) == null) ? "" : "";
        DeviceList deviceList3 = this.device;
        if (deviceList3 != null && (productType = deviceList3.getProductType()) != null) {
            str = productType;
        }
        this.productType = str;
    }
}

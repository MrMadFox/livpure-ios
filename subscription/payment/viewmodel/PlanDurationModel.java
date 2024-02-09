package com.livpure.safedrink.subscription.payment.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlanDurationModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010\u0017@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u0014¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u0014¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\u0014¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u001a\u0010&\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000e¨\u0006*"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/viewmodel/PlanDurationModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "()V", "_device", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "get_device", "()Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "set_device", "(Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;)V", "connectivity", "", "getConnectivity", "()Ljava/lang/String;", "setConnectivity", "(Ljava/lang/String;)V", "value", AndroidContextPlugin.DEVICE_KEY, "getDevice", "setDevice", "durations", "Landroidx/lifecycle/MediatorLiveData;", "", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PriceItem;", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", "plan", "getPlan", "()Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", "setPlan", "(Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;)V", "planAmount", "getPlanAmount", "()Landroidx/lifecycle/MediatorLiveData;", "planLitres", "getPlanLitres", "planName", "getPlanName", "productType", "getProductType", "serialNumber", "getSerialNumber", "setSerialNumber", "getSelectedPlan", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PlanDurationModel extends AnalyticsViewModel {
    private DeviceList _device;
    private DeviceList device;
    private PlansItem plan;
    private final MediatorLiveData<List<PriceItem>> durations = new MediatorLiveData<>();
    private final MediatorLiveData<String> planName = new MediatorLiveData<>();
    private final MediatorLiveData<String> planLitres = new MediatorLiveData<>();
    private final MediatorLiveData<String> planAmount = new MediatorLiveData<>();
    private final MediatorLiveData<String> productType = new MediatorLiveData<>();
    private String serialNumber = "";
    private String connectivity = "";

    public final MediatorLiveData<String> getPlanName() {
        return this.planName;
    }

    public final MediatorLiveData<String> getPlanLitres() {
        return this.planLitres;
    }

    public final MediatorLiveData<String> getPlanAmount() {
        return this.planAmount;
    }

    public final MediatorLiveData<String> getProductType() {
        return this.productType;
    }

    public final List<PriceItem> getSelectedPlan() {
        PlansItem plansItem = this.plan;
        if (plansItem != null) {
            return plansItem.getPrice();
        }
        return null;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final void setSerialNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serialNumber = str;
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

    public final DeviceList getDevice() {
        return this.device;
    }

    public final void setDevice(DeviceList deviceList) {
        String connectivity;
        this._device = deviceList;
        this.device = deviceList;
        String str = "";
        this.serialNumber = (deviceList == null || (r2 = deviceList.getSerialNo()) == null) ? "" : "";
        DeviceList deviceList2 = this.device;
        if (deviceList2 != null && (connectivity = deviceList2.getConnectivity()) != null) {
            str = connectivity;
        }
        this.connectivity = str;
    }

    public final PlansItem getPlan() {
        return this.plan;
    }

    public final void setPlan(PlansItem plansItem) {
        this.plan = plansItem;
        this.durations.setValue(plansItem != null ? plansItem.getPrice() : null);
        this.planName.setValue((plansItem == null || (r2 = plansItem.getPlanName()) == null) ? "" : "");
        this.planLitres.setValue(String.valueOf(plansItem != null ? plansItem.getLiters() : null));
        this.planAmount.setValue(String.valueOf(plansItem != null ? plansItem.getAmount() : null));
    }
}

package com.livpure.safedrink.subscription.payment.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.subscription.plan.data.SubscriptionRepository;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
import com.livpure.safedrink.subscription.plan.data.model.plan.Response;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SelectPlanViewModel.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150#J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00160#J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000e¨\u0006)"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/viewmodel/SelectPlanViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "()V", "_device", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "get_device", "()Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "set_device", "(Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;)V", "connectivity", "", "getConnectivity", "()Ljava/lang/String;", "setConnectivity", "(Ljava/lang/String;)V", "value", AndroidContextPlugin.DEVICE_KEY, "getDevice", "setDevice", "plans", "Landroidx/lifecycle/MediatorLiveData;", "", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", "repository", "Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "getRepository", "()Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "repository$delegate", "Lkotlin/Lazy;", "selectedPlan", "Landroidx/lifecycle/MutableLiveData;", "serialNumber", "getSerialNumber", "setSerialNumber", "getAllPlanDetails", "Landroidx/lifecycle/LiveData;", "getSelectedPlan", "onSubscribePlanClicked", "", "planPosition", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SelectPlanViewModel extends AnalyticsViewModel {
    private DeviceList _device;
    private DeviceList device;
    private final Lazy repository$delegate = LazyKt.lazy(new Function0<SubscriptionRepository>() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanViewModel$repository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SubscriptionRepository invoke() {
            return new SubscriptionRepository();
        }
    });
    private final MediatorLiveData<List<PlansItem>> plans = new MediatorLiveData<>();
    private MutableLiveData<PlansItem> selectedPlan = new MutableLiveData<>();
    private String serialNumber = "";
    private String connectivity = "";

    private final SubscriptionRepository getRepository() {
        return (SubscriptionRepository) this.repository$delegate.getValue();
    }

    public final LiveData<List<PlansItem>> getAllPlanDetails() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            this.plans.addSource(getRepository().getPlanDetails(), new Observer() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanViewModel$$ExternalSyntheticLambda0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SelectPlanViewModel.m1392getAllPlanDetails$lambda0(SelectPlanViewModel.this, (Response) obj);
                }
            });
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
        return this.plans;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAllPlanDetails$lambda-0  reason: not valid java name */
    public static final void m1392getAllPlanDetails$lambda0(SelectPlanViewModel this$0, Response response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        if (response.getData() != null) {
            this$0.plans.setValue(response.getData().getPlans());
            return;
        }
        MutableLiveData<Event<String>> toastMessageLiveData = this$0.getToastMessageLiveData();
        String message = response.getMessage();
        if (message == null) {
            message = "Sorry! We got an error while fetching all those plans.";
        }
        toastMessageLiveData.setValue(new Event<>(message));
    }

    public final LiveData<PlansItem> getSelectedPlan() {
        return this.selectedPlan;
    }

    public final void onSubscribePlanClicked(int i) {
        MutableLiveData<PlansItem> mutableLiveData = this.selectedPlan;
        List<PlansItem> value = this.plans.getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveData.setValue(value.get(i));
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
}

package com.livpure.safedrink.subscription.payment.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.subscription.plan.data.SubscriptionRepository;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.subscription.plan.data.model.plan.Currentplans;
import com.livpure.safedrink.subscription.plan.data.model.plan.Data;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
import com.livpure.safedrink.subscription.plan.data.model.plan.Response;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: SelectPlanChangeModel.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000207060MJ\f\u0010N\u001a\b\u0012\u0004\u0012\u0002030\u0010J\f\u0010O\u001a\b\u0012\u0004\u0012\u0002030MJ\f\u0010P\u001a\b\u0012\u0004\u0012\u0002070MJ\u000e\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R \u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R \u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R(\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010*\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR \u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b0\u0010\u0014R\u000e\u00101\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0010¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0012R\u001d\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000207060\u0010¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0012R\u001d\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000207060\u0010¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0012R\u001a\u0010;\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\f\"\u0004\b=\u0010\u000eR\u001b\u0010>\u001a\u00020?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\b@\u0010AR\u0014\u0010D\u001a\b\u0012\u0004\u0012\u0002070EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\f\"\u0004\bH\u0010\u000eR\u001b\u0010I\u001a\u00020?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010C\u001a\u0004\bJ\u0010A¨\u0006T"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/viewmodel/SelectPlanChangeModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "_device", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "get_device", "()Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "set_device", "(Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;)V", "connectivity", "", "getConnectivity", "()Ljava/lang/String;", "setConnectivity", "(Ljava/lang/String;)V", "currentEMIPlanAmount", "Landroidx/lifecycle/MediatorLiveData;", "getCurrentEMIPlanAmount", "()Landroidx/lifecycle/MediatorLiveData;", "setCurrentEMIPlanAmount", "(Landroidx/lifecycle/MediatorLiveData;)V", "currentPlanAmount", "getCurrentPlanAmount", "setCurrentPlanAmount", "currentPlanEndDate", "getCurrentPlanEndDate", "setCurrentPlanEndDate", "currentPlanID", "", "getCurrentPlanID", "()I", "setCurrentPlanID", "(I)V", "currentPlanLitres", "getCurrentPlanLitres", "setCurrentPlanLitres", "currentPlanName", "getCurrentPlanName", "setCurrentPlanName", "currentPlanPerLitres", "getCurrentPlanPerLitres", "setCurrentPlanPerLitres", "value", AndroidContextPlugin.DEVICE_KEY, "getDevice", "setDevice", "isHolidayPlan", "", "setHolidayPlan", "isPlanUpdate", "planResponse", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/Response;", "getPlanResponse", "plans", "", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", "getPlans", "plans_unlimit", "getPlans_unlimit", "productType", "getProductType", "setProductType", "repository", "Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "getRepository", "()Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "repository$delegate", "Lkotlin/Lazy;", "selectedPlan", "Landroidx/lifecycle/MutableLiveData;", "serialNumber", "getSerialNumber", "setSerialNumber", "subscriptionRepository", "getSubscriptionRepository", "subscriptionRepository$delegate", "getAllPlanDetails", "Landroidx/lifecycle/LiveData;", "getPerLitreRate", "getPlanDetails", "getSelectedPlan", "onSubscribePlanClicked", "", "planPosition", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SelectPlanChangeModel extends MediatorViewModel {
    private DeviceList _device;
    private DeviceList device;
    private boolean isPlanUpdate;
    private final Lazy repository$delegate = LazyKt.lazy(new Function0<SubscriptionRepository>() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanChangeModel$repository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SubscriptionRepository invoke() {
            return new SubscriptionRepository();
        }
    });
    private final Lazy subscriptionRepository$delegate = LazyKt.lazy(new Function0<SubscriptionRepository>() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanChangeModel$subscriptionRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SubscriptionRepository invoke() {
            return new SubscriptionRepository();
        }
    });
    private final MediatorLiveData<List<PlansItem>> plans = new MediatorLiveData<>();
    private final MediatorLiveData<List<PlansItem>> plans_unlimit = new MediatorLiveData<>();
    private final MediatorLiveData<Response> planResponse = new MediatorLiveData<>();
    private MutableLiveData<PlansItem> selectedPlan = new MutableLiveData<>();
    private MediatorLiveData<String> currentPlanName = new MediatorLiveData<>();
    private MediatorLiveData<String> currentPlanAmount = new MediatorLiveData<>();
    private MediatorLiveData<String> currentEMIPlanAmount = new MediatorLiveData<>();
    private MediatorLiveData<String> currentPlanLitres = new MediatorLiveData<>();
    private MediatorLiveData<String> currentPlanEndDate = new MediatorLiveData<>();
    private MediatorLiveData<String> currentPlanPerLitres = new MediatorLiveData<>();
    private MediatorLiveData<Boolean> isHolidayPlan = new MediatorLiveData<>();
    private int currentPlanID = -1;
    private String productType = "";
    private String serialNumber = "";
    private String connectivity = "";

    private final SubscriptionRepository getRepository() {
        return (SubscriptionRepository) this.repository$delegate.getValue();
    }

    private final SubscriptionRepository getSubscriptionRepository() {
        return (SubscriptionRepository) this.subscriptionRepository$delegate.getValue();
    }

    public final MediatorLiveData<List<PlansItem>> getPlans() {
        return this.plans;
    }

    public final MediatorLiveData<List<PlansItem>> getPlans_unlimit() {
        return this.plans_unlimit;
    }

    public final MediatorLiveData<Response> getPlanResponse() {
        return this.planResponse;
    }

    public final MediatorLiveData<String> getCurrentPlanName() {
        return this.currentPlanName;
    }

    public final void setCurrentPlanName(MediatorLiveData<String> mediatorLiveData) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "<set-?>");
        this.currentPlanName = mediatorLiveData;
    }

    public final MediatorLiveData<String> getCurrentPlanAmount() {
        return this.currentPlanAmount;
    }

    public final void setCurrentPlanAmount(MediatorLiveData<String> mediatorLiveData) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "<set-?>");
        this.currentPlanAmount = mediatorLiveData;
    }

    public final MediatorLiveData<String> getCurrentEMIPlanAmount() {
        return this.currentEMIPlanAmount;
    }

    public final void setCurrentEMIPlanAmount(MediatorLiveData<String> mediatorLiveData) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "<set-?>");
        this.currentEMIPlanAmount = mediatorLiveData;
    }

    public final MediatorLiveData<String> getCurrentPlanLitres() {
        return this.currentPlanLitres;
    }

    public final void setCurrentPlanLitres(MediatorLiveData<String> mediatorLiveData) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "<set-?>");
        this.currentPlanLitres = mediatorLiveData;
    }

    public final MediatorLiveData<String> getCurrentPlanEndDate() {
        return this.currentPlanEndDate;
    }

    public final void setCurrentPlanEndDate(MediatorLiveData<String> mediatorLiveData) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "<set-?>");
        this.currentPlanEndDate = mediatorLiveData;
    }

    public final MediatorLiveData<String> getCurrentPlanPerLitres() {
        return this.currentPlanPerLitres;
    }

    public final void setCurrentPlanPerLitres(MediatorLiveData<String> mediatorLiveData) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "<set-?>");
        this.currentPlanPerLitres = mediatorLiveData;
    }

    public final MediatorLiveData<Boolean> isHolidayPlan() {
        return this.isHolidayPlan;
    }

    public final void setHolidayPlan(MediatorLiveData<Boolean> mediatorLiveData) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "<set-?>");
        this.isHolidayPlan = mediatorLiveData;
    }

    public final int getCurrentPlanID() {
        return this.currentPlanID;
    }

    public final void setCurrentPlanID(int i) {
        this.currentPlanID = i;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final void setProductType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.productType = str;
    }

    public final LiveData<Response> getPlanDetails() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            observeAndTrack(getSubscriptionRepository().getPlanDetails(), new Observer() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanChangeModel$$ExternalSyntheticLambda2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SelectPlanChangeModel.m1391getPlanDetails$lambda0(SelectPlanChangeModel.this, (Response) obj);
                }
            });
        }
        return this.planResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPlanDetails$lambda-0  reason: not valid java name */
    public static final void m1391getPlanDetails$lambda0(SelectPlanChangeModel this$0, Response response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (response.getData() != null) {
            this$0.planResponse.setValue(response);
            MediatorLiveData<String> mediatorLiveData = this$0.currentPlanName;
            Data data = response.getData();
            Intrinsics.checkNotNull(data);
            Currentplans currentplans = data.getCurrentplans();
            Intrinsics.checkNotNull(currentplans);
            mediatorLiveData.setValue(currentplans.getPlanName());
            MediatorLiveData<String> mediatorLiveData2 = this$0.currentPlanAmount;
            Currentplans currentplans2 = response.getData().getCurrentplans();
            Intrinsics.checkNotNull(currentplans2);
            mediatorLiveData2.setValue(currentplans2.getAmount());
            this$0.currentEMIPlanAmount.setValue(response.getData().getCurrentplans().getEmiAmount());
            this$0.currentPlanLitres.setValue(response.getData().getCurrentplans().getLiters());
            this$0.currentPlanPerLitres.setValue(response.getData().getCurrentplans().getRateperliter());
            this$0.currentPlanEndDate.setValue(response.getData().getCurrentplans().getBillingEndDate());
            String planId = response.getData().getCurrentplans().getPlanId();
            Intrinsics.checkNotNull(planId);
            this$0.currentPlanID = Integer.parseInt(planId);
            this$0.isHolidayPlan.setValue(Boolean.valueOf(response.getData().getHolidayPlan() != null));
        }
    }

    public final LiveData<List<PlansItem>> getAllPlanDetails() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            if (this.productType.toString().equals("air-purifier")) {
                this.plans.addSource(getRepository().getPlanDetails(), new Observer() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanChangeModel$$ExternalSyntheticLambda5
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        SelectPlanChangeModel.m1386getAllPlanDetails$lambda1(SelectPlanChangeModel.this, (Response) obj);
                    }
                });
            } else if (StringsKt.contains((CharSequence) this.productType.toString(), (CharSequence) "emi", true)) {
                this.plans.addSource(getRepository().getPlanDetails(), new Observer() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanChangeModel$$ExternalSyntheticLambda1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        SelectPlanChangeModel.m1387getAllPlanDetails$lambda2(SelectPlanChangeModel.this, (Response) obj);
                    }
                });
            } else {
                this.plans.addSource(getRepository().getPlanDetails(), new Observer() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanChangeModel$$ExternalSyntheticLambda3
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        SelectPlanChangeModel.m1388getAllPlanDetails$lambda3(SelectPlanChangeModel.this, (Response) obj);
                    }
                });
            }
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
        return this.plans;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAllPlanDetails$lambda-1  reason: not valid java name */
    public static final void m1386getAllPlanDetails$lambda1(SelectPlanChangeModel this$0, Response response) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAllPlanDetails$lambda-2  reason: not valid java name */
    public static final void m1387getAllPlanDetails$lambda2(SelectPlanChangeModel this$0, Response response) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAllPlanDetails$lambda-3  reason: not valid java name */
    public static final void m1388getAllPlanDetails$lambda3(SelectPlanChangeModel this$0, Response response) {
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

    public final MediatorLiveData<Response> getPerLitreRate() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            if (this.productType.toString().equals("air-purifier")) {
                observeAndTrack(getSubscriptionRepository().getPlanDetails(), new Observer() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanChangeModel$$ExternalSyntheticLambda0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        SelectPlanChangeModel.m1389getPerLitreRate$lambda4(SelectPlanChangeModel.this, (Response) obj);
                    }
                });
            } else {
                observeAndTrack(getSubscriptionRepository().getPlanDetails(), new Observer() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.SelectPlanChangeModel$$ExternalSyntheticLambda4
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        SelectPlanChangeModel.m1390getPerLitreRate$lambda5(SelectPlanChangeModel.this, (Response) obj);
                    }
                });
            }
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
        return this.planResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPerLitreRate$lambda-4  reason: not valid java name */
    public static final void m1389getPerLitreRate$lambda4(SelectPlanChangeModel this$0, Response response) {
        PlansItem plansItem;
        PlansItem plansItem2;
        PlansItem plansItem3;
        PlansItem plansItem4;
        PlansItem plansItem5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        if (response.getData() != null) {
            this$0.isPlanUpdate = false;
            this$0.planResponse.setValue(response);
            MediatorLiveData<String> mediatorLiveData = this$0.currentPlanName;
            Response value = this$0.planResponse.getValue();
            Intrinsics.checkNotNull(value);
            Data data = value.getData();
            Intrinsics.checkNotNull(data);
            List<PlansItem> plans = data.getPlans();
            String str = null;
            mediatorLiveData.setValue((plans == null || (plansItem5 = plans.get(0)) == null) ? null : plansItem5.getPlanName());
            MediatorLiveData<String> mediatorLiveData2 = this$0.currentPlanAmount;
            Response value2 = this$0.planResponse.getValue();
            Intrinsics.checkNotNull(value2);
            Data data2 = value2.getData();
            Intrinsics.checkNotNull(data2);
            List<PlansItem> plans2 = data2.getPlans();
            mediatorLiveData2.setValue(String.valueOf((plans2 == null || (plansItem4 = plans2.get(0)) == null) ? null : plansItem4.getAmount()));
            MediatorLiveData<String> mediatorLiveData3 = this$0.currentPlanLitres;
            Response value3 = this$0.planResponse.getValue();
            Intrinsics.checkNotNull(value3);
            Data data3 = value3.getData();
            Intrinsics.checkNotNull(data3);
            List<PlansItem> plans3 = data3.getPlans();
            mediatorLiveData3.setValue(String.valueOf((plans3 == null || (plansItem3 = plans3.get(0)) == null) ? null : plansItem3.getLiters()));
            MediatorLiveData<String> mediatorLiveData4 = this$0.currentPlanPerLitres;
            Response value4 = this$0.planResponse.getValue();
            Intrinsics.checkNotNull(value4);
            Data data4 = value4.getData();
            Intrinsics.checkNotNull(data4);
            List<PlansItem> plans4 = data4.getPlans();
            mediatorLiveData4.setValue(String.valueOf((plans4 == null || (plansItem2 = plans4.get(0)) == null) ? null : plansItem2.getRateperliter()));
            Response value5 = this$0.planResponse.getValue();
            Intrinsics.checkNotNull(value5);
            Data data5 = value5.getData();
            Intrinsics.checkNotNull(data5);
            List<PlansItem> plans5 = data5.getPlans();
            if (plans5 != null && (plansItem = plans5.get(0)) != null) {
                str = plansItem.getPlanId();
            }
            Intrinsics.checkNotNull(str);
            this$0.currentPlanID = Integer.parseInt(str);
            return;
        }
        MutableLiveData<Event<String>> toastMessageLiveData = this$0.getToastMessageLiveData();
        String message = response.getMessage();
        if (message == null) {
            message = "Sorry! We got an error while fetching all those plans.";
        }
        toastMessageLiveData.setValue(new Event<>(message));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPerLitreRate$lambda-5  reason: not valid java name */
    public static final void m1390getPerLitreRate$lambda5(SelectPlanChangeModel this$0, Response response) {
        PlansItem plansItem;
        PlansItem plansItem2;
        PlansItem plansItem3;
        PlansItem plansItem4;
        PlansItem plansItem5;
        PlansItem plansItem6;
        PlansItem plansItem7;
        PlansItem plansItem8;
        PlansItem plansItem9;
        PlansItem plansItem10;
        PlansItem plansItem11;
        PlansItem plansItem12;
        PlansItem plansItem13;
        PlansItem plansItem14;
        PlansItem plansItem15;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        if (response.getData() == null || this$0.isPlanUpdate) {
            return;
        }
        boolean z = true;
        this$0.isPlanUpdate = true;
        this$0.planResponse.setValue(response);
        this$0.plans_unlimit.setValue(response.getData().getPlans());
        MediatorLiveData<String> mediatorLiveData = this$0.currentPlanName;
        Response value = this$0.planResponse.getValue();
        Intrinsics.checkNotNull(value);
        Data data = value.getData();
        Intrinsics.checkNotNull(data);
        List<PlansItem> plans = data.getPlans();
        String str = null;
        mediatorLiveData.setValue((plans == null || (plansItem15 = plans.get(0)) == null) ? null : plansItem15.getPlanName());
        MediatorLiveData<String> mediatorLiveData2 = this$0.currentPlanAmount;
        Response value2 = this$0.planResponse.getValue();
        Intrinsics.checkNotNull(value2);
        Data data2 = value2.getData();
        Intrinsics.checkNotNull(data2);
        List<PlansItem> plans2 = data2.getPlans();
        mediatorLiveData2.setValue(String.valueOf((plans2 == null || (plansItem14 = plans2.get(0)) == null) ? null : plansItem14.getAmount()));
        MediatorLiveData<String> mediatorLiveData3 = this$0.currentEMIPlanAmount;
        Response value3 = this$0.planResponse.getValue();
        Intrinsics.checkNotNull(value3);
        Data data3 = value3.getData();
        Intrinsics.checkNotNull(data3);
        List<PlansItem> plans3 = data3.getPlans();
        mediatorLiveData3.setValue(String.valueOf((plans3 == null || (plansItem13 = plans3.get(0)) == null) ? null : plansItem13.getEmiAmount()));
        MediatorLiveData<String> mediatorLiveData4 = this$0.currentPlanLitres;
        Response value4 = this$0.planResponse.getValue();
        Intrinsics.checkNotNull(value4);
        Data data4 = value4.getData();
        Intrinsics.checkNotNull(data4);
        List<PlansItem> plans4 = data4.getPlans();
        mediatorLiveData4.setValue(String.valueOf((plans4 == null || (plansItem12 = plans4.get(0)) == null) ? null : plansItem12.getLiters()));
        MediatorLiveData<String> mediatorLiveData5 = this$0.currentPlanPerLitres;
        Response value5 = this$0.planResponse.getValue();
        Intrinsics.checkNotNull(value5);
        Data data5 = value5.getData();
        Intrinsics.checkNotNull(data5);
        List<PlansItem> plans5 = data5.getPlans();
        mediatorLiveData5.setValue(String.valueOf((plans5 == null || (plansItem11 = plans5.get(0)) == null) ? null : plansItem11.getRateperliter()));
        Response value6 = this$0.planResponse.getValue();
        Intrinsics.checkNotNull(value6);
        Data data6 = value6.getData();
        Intrinsics.checkNotNull(data6);
        List<PlansItem> plans6 = data6.getPlans();
        String planId = (plans6 == null || (plansItem10 = plans6.get(0)) == null) ? null : plansItem10.getPlanId();
        Intrinsics.checkNotNull(planId);
        this$0.currentPlanID = Integer.parseInt(planId);
        Response value7 = this$0.planResponse.getValue();
        Intrinsics.checkNotNull(value7);
        Data data7 = value7.getData();
        Intrinsics.checkNotNull(data7);
        List<PlansItem> plans7 = data7.getPlans();
        String planId2 = (plans7 == null || (plansItem9 = plans7.get(0)) == null) ? null : plansItem9.getPlanId();
        Intrinsics.checkNotNull(planId2);
        int parseInt = Integer.parseInt(planId2);
        if ((37 > parseInt || parseInt >= 41) ? false : false) {
            Response value8 = this$0.planResponse.getValue();
            Intrinsics.checkNotNull(value8);
            Data data8 = value8.getData();
            Intrinsics.checkNotNull(data8);
            List<PlansItem> plans8 = data8.getPlans();
            if (plans8 != null && (plansItem8 = plans8.get(0)) != null) {
                str = plansItem8.getPlanId();
            }
            Intrinsics.checkNotNull(str);
            this$0.currentPlanID = Integer.parseInt(str) - 36;
            return;
        }
        Response value9 = this$0.planResponse.getValue();
        Intrinsics.checkNotNull(value9);
        Data data9 = value9.getData();
        Intrinsics.checkNotNull(data9);
        List<PlansItem> plans9 = data9.getPlans();
        String planId3 = (plans9 == null || (plansItem7 = plans9.get(0)) == null) ? null : plansItem7.getPlanId();
        Intrinsics.checkNotNull(planId3);
        if (Integer.parseInt(planId3) == 22) {
            Response value10 = this$0.planResponse.getValue();
            Intrinsics.checkNotNull(value10);
            Data data10 = value10.getData();
            Intrinsics.checkNotNull(data10);
            List<PlansItem> plans10 = data10.getPlans();
            if (plans10 != null && (plansItem6 = plans10.get(0)) != null) {
                str = plansItem6.getPlanId();
            }
            Intrinsics.checkNotNull(str);
            this$0.currentPlanID = Integer.parseInt(str);
            return;
        }
        Response value11 = this$0.planResponse.getValue();
        Intrinsics.checkNotNull(value11);
        Data data11 = value11.getData();
        Intrinsics.checkNotNull(data11);
        List<PlansItem> plans11 = data11.getPlans();
        String planId4 = (plans11 == null || (plansItem5 = plans11.get(0)) == null) ? null : plansItem5.getPlanId();
        Intrinsics.checkNotNull(planId4);
        if (Integer.parseInt(planId4) == 27) {
            Response value12 = this$0.planResponse.getValue();
            Intrinsics.checkNotNull(value12);
            Data data12 = value12.getData();
            Intrinsics.checkNotNull(data12);
            List<PlansItem> plans12 = data12.getPlans();
            if (plans12 != null && (plansItem4 = plans12.get(0)) != null) {
                str = plansItem4.getPlanId();
            }
            Intrinsics.checkNotNull(str);
            this$0.currentPlanID = Integer.parseInt(str);
            return;
        }
        Response value13 = this$0.planResponse.getValue();
        Intrinsics.checkNotNull(value13);
        Data data13 = value13.getData();
        Intrinsics.checkNotNull(data13);
        List<PlansItem> plans13 = data13.getPlans();
        String planId5 = (plans13 == null || (plansItem3 = plans13.get(0)) == null) ? null : plansItem3.getPlanId();
        Intrinsics.checkNotNull(planId5);
        if (Integer.parseInt(planId5) < 5) {
            Response value14 = this$0.planResponse.getValue();
            Intrinsics.checkNotNull(value14);
            Data data14 = value14.getData();
            Intrinsics.checkNotNull(data14);
            List<PlansItem> plans14 = data14.getPlans();
            if (plans14 != null && (plansItem2 = plans14.get(0)) != null) {
                str = plansItem2.getPlanId();
            }
            Intrinsics.checkNotNull(str);
            this$0.currentPlanID = Integer.parseInt(str);
            return;
        }
        Response value15 = this$0.planResponse.getValue();
        Intrinsics.checkNotNull(value15);
        Data data15 = value15.getData();
        Intrinsics.checkNotNull(data15);
        List<PlansItem> plans15 = data15.getPlans();
        if (plans15 != null && (plansItem = plans15.get(0)) != null) {
            str = plansItem.getPlanId();
        }
        Intrinsics.checkNotNull(str);
        this$0.currentPlanID = Integer.parseInt(str) - 4;
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
        String productType;
        this._device = deviceList;
        this.device = deviceList;
        String str = "";
        this.serialNumber = (deviceList == null || (r2 = deviceList.getSerialNo()) == null) ? "" : "";
        DeviceList deviceList2 = this.device;
        this.connectivity = (deviceList2 == null || (r2 = deviceList2.getConnectivity()) == null) ? "" : "";
        DeviceList deviceList3 = this.device;
        if (deviceList3 != null && (productType = deviceList3.getProductType()) != null) {
            str = productType;
        }
        this.productType = str;
    }
}

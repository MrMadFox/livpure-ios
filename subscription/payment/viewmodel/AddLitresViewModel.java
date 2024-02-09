package com.livpure.safedrink.subscription.payment.viewmodel;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.subscription.plan.data.SubscriptionRepository;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.subscription.plan.data.model.plan.Currentplans;
import com.livpure.safedrink.subscription.plan.data.model.plan.Data;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
import com.livpure.safedrink.subscription.plan.data.model.plan.Response;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: AddLitresViewModel.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0\u0018H\u0007J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\u0006\u0010P\u001a\u00020QJ\f\u0010R\u001a\b\u0012\u0004\u0012\u00020,0\u0018J\u0016\u0010S\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010\u00182\u0006\u0010U\u001a\u00020VR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u001d¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u001a\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0010\"\u0004\b/\u0010\u0012R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001bR\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b4\u00105R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020,0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0010\"\u0004\b;\u0010\u0012R\u001b\u0010<\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u00107\u001a\u0004\b=\u00105R \u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001f\"\u0004\bA\u0010!R \u0010B\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001f\"\u0004\bD\u0010!R \u0010E\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001f\"\u0004\bG\u0010!R \u0010H\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u001f\"\u0004\bJ\u0010!R \u0010K\u001a\b\u0012\u0004\u0012\u00020\u00190\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\r\"\u0004\bM\u0010N¨\u0006W"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/viewmodel/AddLitresViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "_device", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "get_device", "()Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "set_device", "(Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;)V", "additionalLitres", "Landroidx/lifecycle/MutableLiveData;", "", "getAdditionalLitres", "()Landroidx/lifecycle/MutableLiveData;", "connectivity", "getConnectivity", "()Ljava/lang/String;", "setConnectivity", "(Ljava/lang/String;)V", "value", AndroidContextPlugin.DEVICE_KEY, "getDevice", "setDevice", "payButtonEnabled", "Landroidx/lifecycle/LiveData;", "", "getPayButtonEnabled", "()Landroidx/lifecycle/LiveData;", "payButtonText", "Landroidx/lifecycle/MediatorLiveData;", "getPayButtonText", "()Landroidx/lifecycle/MediatorLiveData;", "setPayButtonText", "(Landroidx/lifecycle/MediatorLiveData;)V", "<set-?>", "", "paymentAmountInINR", "getPaymentAmountInINR", "()D", "planResponse", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/Response;", "getPlanResponse", "plans", "", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", "productType", "getProductType", "setProductType", "ratePerLitreLabel", "getRatePerLitreLabel", "repository", "Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "getRepository", "()Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "repository$delegate", "Lkotlin/Lazy;", "selectedPlan", "serialNumber", "getSerialNumber", "setSerialNumber", "subscriptionRepository", "getSubscriptionRepository", "subscriptionRepository$delegate", "upgradePlanAmountText", "getUpgradePlanAmountText", "setUpgradePlanAmountText", "upgradePlanLitresText", "getUpgradePlanLitresText", "setUpgradePlanLitresText", "upgradePlanNameText", "getUpgradePlanNameText", "setUpgradePlanNameText", "upgradePlanText", "getUpgradePlanText", "setUpgradePlanText", "upgradePlanView", "getUpgradePlanView", "setUpgradePlanView", "(Landroidx/lifecycle/MutableLiveData;)V", "getAllPlanDetails", "getPerLitreRate", "", "getSelectedPlan", "updatePayment", "Lcom/livpure/safedrink/login/api/models/response/BaseV1ResponseImplementation;", "paymentPayLoad", "Lcom/livpure/safedrink/subscription/plan/data/model/payment/PaymentPayload;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AddLitresViewModel extends MediatorViewModel {
    private DeviceList _device;
    private String connectivity;
    private DeviceList device;
    private final LiveData<Boolean> payButtonEnabled;
    private MediatorLiveData<String> payButtonText;
    private double paymentAmountInINR;
    private final MediatorLiveData<Response> planResponse;
    private final MediatorLiveData<List<PlansItem>> plans;
    private String productType;
    private final LiveData<String> ratePerLitreLabel;
    private MutableLiveData<PlansItem> selectedPlan;
    private String serialNumber;
    private MediatorLiveData<String> upgradePlanAmountText;
    private MediatorLiveData<String> upgradePlanLitresText;
    private MediatorLiveData<String> upgradePlanNameText;
    private MediatorLiveData<String> upgradePlanText;
    private MutableLiveData<Boolean> upgradePlanView;
    private final MutableLiveData<String> additionalLitres = new MutableLiveData<>();
    private final Lazy repository$delegate = LazyKt.lazy(new Function0<SubscriptionRepository>() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel$repository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SubscriptionRepository invoke() {
            return new SubscriptionRepository();
        }
    });
    private final Lazy subscriptionRepository$delegate = LazyKt.lazy(new Function0<SubscriptionRepository>() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel$subscriptionRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SubscriptionRepository invoke() {
            return new SubscriptionRepository();
        }
    });

    public AddLitresViewModel() {
        MediatorLiveData<Response> mediatorLiveData = new MediatorLiveData<>();
        this.planResponse = mediatorLiveData;
        this.plans = new MediatorLiveData<>();
        this.payButtonText = new MediatorLiveData<>();
        this.upgradePlanText = new MediatorLiveData<>();
        this.upgradePlanNameText = new MediatorLiveData<>();
        this.upgradePlanLitresText = new MediatorLiveData<>();
        this.upgradePlanAmountText = new MediatorLiveData<>();
        this.productType = "";
        this.selectedPlan = new MutableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(true);
        this.upgradePlanView = mutableLiveData;
        LiveData<Boolean> map = Transformations.map(this.payButtonText, new Function() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean m1380payButtonEnabled$lambda1;
                m1380payButtonEnabled$lambda1 = AddLitresViewModel.m1380payButtonEnabled$lambda1(AddLitresViewModel.this, (String) obj);
                return m1380payButtonEnabled$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(payButtonText) {\n   …ntAmountInINR > 0.0\n    }");
        this.payButtonEnabled = map;
        LiveData<String> map2 = Transformations.map(mediatorLiveData, new Function() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel$$ExternalSyntheticLambda1
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                String m1381ratePerLitreLabel$lambda2;
                m1381ratePerLitreLabel$lambda2 = AddLitresViewModel.m1381ratePerLitreLabel$lambda2((Response) obj);
                return m1381ratePerLitreLabel$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "map(planResponse) {\n    …       \"\"\n        }\n    }");
        this.ratePerLitreLabel = map2;
        this.serialNumber = "";
        this.connectivity = "";
    }

    public final MutableLiveData<String> getAdditionalLitres() {
        return this.additionalLitres;
    }

    private final SubscriptionRepository getRepository() {
        return (SubscriptionRepository) this.repository$delegate.getValue();
    }

    private final SubscriptionRepository getSubscriptionRepository() {
        return (SubscriptionRepository) this.subscriptionRepository$delegate.getValue();
    }

    public final MediatorLiveData<Response> getPlanResponse() {
        return this.planResponse;
    }

    /* renamed from: getPayButtonText  reason: collision with other method in class */
    public final MediatorLiveData<String> m1382getPayButtonText() {
        return this.payButtonText;
    }

    public final void setPayButtonText(MediatorLiveData<String> mediatorLiveData) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "<set-?>");
        this.payButtonText = mediatorLiveData;
    }

    public final MediatorLiveData<String> getUpgradePlanText() {
        return this.upgradePlanText;
    }

    public final void setUpgradePlanText(MediatorLiveData<String> mediatorLiveData) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "<set-?>");
        this.upgradePlanText = mediatorLiveData;
    }

    public final MediatorLiveData<String> getUpgradePlanNameText() {
        return this.upgradePlanNameText;
    }

    public final void setUpgradePlanNameText(MediatorLiveData<String> mediatorLiveData) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "<set-?>");
        this.upgradePlanNameText = mediatorLiveData;
    }

    public final MediatorLiveData<String> getUpgradePlanLitresText() {
        return this.upgradePlanLitresText;
    }

    public final void setUpgradePlanLitresText(MediatorLiveData<String> mediatorLiveData) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "<set-?>");
        this.upgradePlanLitresText = mediatorLiveData;
    }

    public final MediatorLiveData<String> getUpgradePlanAmountText() {
        return this.upgradePlanAmountText;
    }

    public final void setUpgradePlanAmountText(MediatorLiveData<String> mediatorLiveData) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "<set-?>");
        this.upgradePlanAmountText = mediatorLiveData;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final void setProductType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.productType = str;
    }

    public final MutableLiveData<Boolean> getUpgradePlanView() {
        return this.upgradePlanView;
    }

    public final void setUpgradePlanView(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.upgradePlanView = mutableLiveData;
    }

    public final LiveData<Boolean> getPayButtonEnabled() {
        return this.payButtonEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: payButtonEnabled$lambda-1  reason: not valid java name */
    public static final Boolean m1380payButtonEnabled$lambda1(AddLitresViewModel this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return Boolean.valueOf(this$0.paymentAmountInINR > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public final LiveData<String> getRatePerLitreLabel() {
        return this.ratePerLitreLabel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ratePerLitreLabel$lambda-2  reason: not valid java name */
    public static final String m1381ratePerLitreLabel$lambda2(Response response) {
        Data data = response.getData();
        if ((data != null ? data.getCurrentplans() : null) != null) {
            if (Intrinsics.areEqual(String.valueOf(response.getData().getCurrentplans().getProductType()), "air-purifier")) {
                return "You will be charged at Rs. " + response.getData().getCurrentplans().getRateperliter() + "/Air";
            }
            return "You will be charged at Rs. " + response.getData().getCurrentplans().getRateperliter() + "/Litre";
        }
        return "";
    }

    public final double getPaymentAmountInINR() {
        return this.paymentAmountInINR;
    }

    public final void getPerLitreRate() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            try {
                if (this.productType.toString().equals("air-purifier")) {
                    getLoading().setValue(true);
                    observeAndTrack(getSubscriptionRepository().getPlanDetails(), new Observer() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel$$ExternalSyntheticLambda3
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            AddLitresViewModel.m1374getPerLitreRate$lambda3(AddLitresViewModel.this, (Response) obj);
                        }
                    });
                    try {
                        this.payButtonText.addSource(this.additionalLitres, new Observer() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel$$ExternalSyntheticLambda8
                            @Override // androidx.lifecycle.Observer
                            public final void onChanged(Object obj) {
                                AddLitresViewModel.m1375getPerLitreRate$lambda4(AddLitresViewModel.this, (String) obj);
                            }
                        });
                        this.payButtonText.addSource(this.planResponse, new Observer() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel$$ExternalSyntheticLambda5
                            @Override // androidx.lifecycle.Observer
                            public final void onChanged(Object obj) {
                                AddLitresViewModel.m1376getPerLitreRate$lambda5(AddLitresViewModel.this, (Response) obj);
                            }
                        });
                    } catch (Exception unused) {
                        this.payButtonText.addSource(this.planResponse, new Observer() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel$$ExternalSyntheticLambda5
                            @Override // androidx.lifecycle.Observer
                            public final void onChanged(Object obj) {
                                AddLitresViewModel.m1376getPerLitreRate$lambda5(AddLitresViewModel.this, (Response) obj);
                            }
                        });
                    }
                }
                getLoading().setValue(true);
                observeAndTrack(getSubscriptionRepository().getPlanDetails(), new Observer() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel$$ExternalSyntheticLambda2
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        AddLitresViewModel.m1377getPerLitreRate$lambda6(AddLitresViewModel.this, (Response) obj);
                    }
                });
                try {
                    this.payButtonText.addSource(this.additionalLitres, new Observer() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel$$ExternalSyntheticLambda7
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            AddLitresViewModel.m1378getPerLitreRate$lambda7(AddLitresViewModel.this, (String) obj);
                        }
                    });
                } catch (Exception unused2) {
                }
                this.payButtonText.addSource(this.planResponse, new Observer() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel$$ExternalSyntheticLambda6
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        AddLitresViewModel.m1379getPerLitreRate$lambda8(AddLitresViewModel.this, (Response) obj);
                    }
                });
                return;
            } catch (Exception unused3) {
                return;
            }
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPerLitreRate$lambda-3  reason: not valid java name */
    public static final void m1374getPerLitreRate$lambda3(AddLitresViewModel this$0, Response response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        if (response.getData() != null) {
            this$0.planResponse.setValue(response);
            this$0.getAllPlanDetails();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPerLitreRate$lambda-4  reason: not valid java name */
    public static final void m1375getPerLitreRate$lambda4(AddLitresViewModel this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.payButtonText.setValue(this$0.getPayButtonText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPerLitreRate$lambda-5  reason: not valid java name */
    public static final void m1376getPerLitreRate$lambda5(AddLitresViewModel this$0, Response response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.payButtonText.setValue(this$0.getPayButtonText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPerLitreRate$lambda-6  reason: not valid java name */
    public static final void m1377getPerLitreRate$lambda6(AddLitresViewModel this$0, Response response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        if (response.getData() != null) {
            this$0.planResponse.setValue(response);
            this$0.getAllPlanDetails();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPerLitreRate$lambda-7  reason: not valid java name */
    public static final void m1378getPerLitreRate$lambda7(AddLitresViewModel this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.payButtonText.setValue(this$0.getPayButtonText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPerLitreRate$lambda-8  reason: not valid java name */
    public static final void m1379getPerLitreRate$lambda8(AddLitresViewModel this$0, Response response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.payButtonText.setValue(this$0.getPayButtonText());
    }

    public final LiveData<List<PlansItem>> getAllPlanDetails() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            observeAndTrack(getRepository().getPlanDetails(), new Observer() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel$$ExternalSyntheticLambda4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AddLitresViewModel.m1373getAllPlanDetails$lambda9(AddLitresViewModel.this, (Response) obj);
                }
            });
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
        return this.plans;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0174 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0174 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x005c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x005c A[SYNTHETIC] */
    /* renamed from: getAllPlanDetails$lambda-9  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1373getAllPlanDetails$lambda9(com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel r7, com.livpure.safedrink.subscription.plan.data.model.plan.Response r8) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel.m1373getAllPlanDetails$lambda9(com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel, com.livpure.safedrink.subscription.plan.data.model.plan.Response):void");
    }

    private final String getPayButtonText() {
        Currentplans currentplans;
        Data data;
        Response value = this.planResponse.getValue();
        if (((value == null || (data = value.getData()) == null) ? null : data.getCurrentplans()) != null) {
            String value2 = this.additionalLitres.getValue();
            if (!(value2 == null || StringsKt.isBlank(value2))) {
                Response value3 = this.planResponse.getValue();
                Intrinsics.checkNotNull(value3);
                Data data2 = value3.getData();
                if (!StringsKt.equals$default((data2 == null || (currentplans = data2.getCurrentplans()) == null) ? null : currentplans.getPlanId(), "4", false, 2, null)) {
                    Response value4 = this.planResponse.getValue();
                    Data data3 = value4 != null ? value4.getData() : null;
                    Intrinsics.checkNotNull(data3);
                    Currentplans currentplans2 = data3.getCurrentplans();
                    if (!StringsKt.equals$default(currentplans2 != null ? currentplans2.getProductType() : null, "air-purifier", false, 2, null)) {
                        Response value5 = this.planResponse.getValue();
                        Data data4 = value5 != null ? value5.getData() : null;
                        Intrinsics.checkNotNull(data4);
                        Currentplans currentplans3 = data4.getCurrentplans();
                        if (!StringsKt.equals$default(currentplans3 != null ? currentplans3.getProductType() : null, "magna-waas", false, 2, null)) {
                            Response value6 = this.planResponse.getValue();
                            Data data5 = value6 != null ? value6.getData() : null;
                            Intrinsics.checkNotNull(data5);
                            Currentplans currentplans4 = data5.getCurrentplans();
                            if (!StringsKt.equals$default(currentplans4 != null ? currentplans4.getProductType() : null, "zingerhotwaas", false, 2, null)) {
                                Response value7 = this.planResponse.getValue();
                                Data data6 = value7 != null ? value7.getData() : null;
                                Intrinsics.checkNotNull(data6);
                                Currentplans currentplans5 = data6.getCurrentplans();
                                if (!StringsKt.equals$default(currentplans5 != null ? currentplans5.getPlanId() : null, "8", false, 2, null)) {
                                    this.upgradePlanView.setValue(false);
                                }
                            }
                        }
                    }
                }
                Response value8 = this.planResponse.getValue();
                Data data7 = value8 != null ? value8.getData() : null;
                Intrinsics.checkNotNull(data7);
                Currentplans currentplans6 = data7.getCurrentplans();
                String rateperliter = currentplans6 != null ? currentplans6.getRateperliter() : null;
                Intrinsics.checkNotNull(rateperliter);
                double parseDouble = Double.parseDouble(rateperliter);
                String value9 = this.additionalLitres.getValue();
                Intrinsics.checkNotNull(value9);
                this.paymentAmountInINR = new BigDecimal(String.valueOf(parseDouble * Double.parseDouble(value9))).setScale(2, RoundingMode.HALF_UP).doubleValue();
                return "Pay ₹ " + this.paymentAmountInINR;
            }
        }
        this.upgradePlanView.setValue(true);
        this.paymentAmountInINR = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        return "Add Water";
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006a A[Catch: APIException -> 0x00a2, TryCatch #0 {APIException -> 0x00a2, blocks: (B:6:0x0016, B:11:0x002b, B:13:0x0035, B:15:0x003b, B:17:0x0044, B:22:0x004e, B:24:0x0056, B:29:0x0060, B:31:0x006a, B:33:0x0070, B:35:0x0079, B:38:0x0084, B:42:0x0095, B:37:0x007f), top: B:50:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079 A[Catch: APIException -> 0x00a2, TryCatch #0 {APIException -> 0x00a2, blocks: (B:6:0x0016, B:11:0x002b, B:13:0x0035, B:15:0x003b, B:17:0x0044, B:22:0x004e, B:24:0x0056, B:29:0x0060, B:31:0x006a, B:33:0x0070, B:35:0x0079, B:38:0x0084, B:42:0x0095, B:37:0x007f), top: B:50:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.lifecycle.LiveData<com.livpure.safedrink.login.api.models.response.BaseV1ResponseImplementation> updatePayment(com.livpure.safedrink.subscription.plan.data.model.payment.PaymentPayload r15) {
        /*
            r14 = this;
            java.lang.String r0 = "paymentPayLoad"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            com.livpure.safedrink.subscription.plan.data.model.payment.PaymentPayload$PaymentState r0 = r15.getPaymentState()
            com.livpure.safedrink.subscription.plan.data.model.payment.PaymentPayload$PaymentState r1 = com.livpure.safedrink.subscription.plan.data.model.payment.PaymentPayload.PaymentState.PAYMENT_SUCCESS
            r2 = 0
            if (r0 != r1) goto Lc0
            com.livpure.safedrink.app.LSApplication$Companion r0 = com.livpure.safedrink.app.LSApplication.Companion
            boolean r0 = r0.isNetworkAvailable()
            if (r0 == 0) goto Lc0
            com.livpure.safedrink.subscription.plan.data.SubscriptionRepository r3 = r14.getSubscriptionRepository()     // Catch: com.livpure.safedrink.api.APIException -> La2
            double r0 = r14.paymentAmountInINR     // Catch: com.livpure.safedrink.api.APIException -> La2
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch: com.livpure.safedrink.api.APIException -> La2
            java.lang.String r0 = r15.getPaymentId()     // Catch: com.livpure.safedrink.api.APIException -> La2
            java.lang.String r1 = ""
            if (r0 != 0) goto L2a
            r5 = r1
            goto L2b
        L2a:
            r5 = r0
        L2b:
            androidx.lifecycle.MediatorLiveData<com.livpure.safedrink.subscription.plan.data.model.plan.Response> r0 = r14.planResponse     // Catch: com.livpure.safedrink.api.APIException -> La2
            java.lang.Object r0 = r0.getValue()     // Catch: com.livpure.safedrink.api.APIException -> La2
            com.livpure.safedrink.subscription.plan.data.model.plan.Response r0 = (com.livpure.safedrink.subscription.plan.data.model.plan.Response) r0     // Catch: com.livpure.safedrink.api.APIException -> La2
            if (r0 == 0) goto L3a
            com.livpure.safedrink.subscription.plan.data.model.plan.Data r0 = r0.getData()     // Catch: com.livpure.safedrink.api.APIException -> La2
            goto L3b
        L3a:
            r0 = r2
        L3b:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: com.livpure.safedrink.api.APIException -> La2
            com.livpure.safedrink.subscription.plan.data.model.plan.Currentplans r0 = r0.getCurrentplans()     // Catch: com.livpure.safedrink.api.APIException -> La2
            if (r0 == 0) goto L4d
            java.lang.String r0 = r0.getPlanId()     // Catch: com.livpure.safedrink.api.APIException -> La2
            if (r0 != 0) goto L4b
            goto L4d
        L4b:
            r6 = r0
            goto L4e
        L4d:
            r6 = r1
        L4e:
            com.livpure.safedrink.app.LSApplication$Companion r0 = com.livpure.safedrink.app.LSApplication.Companion     // Catch: com.livpure.safedrink.api.APIException -> La2
            com.livpure.safedrink.login.data.models.User r0 = r0.getUser()     // Catch: com.livpure.safedrink.api.APIException -> La2
            if (r0 == 0) goto L5f
            java.lang.String r0 = r0.getPlanId()     // Catch: com.livpure.safedrink.api.APIException -> La2
            if (r0 != 0) goto L5d
            goto L5f
        L5d:
            r8 = r0
            goto L60
        L5f:
            r8 = r1
        L60:
            androidx.lifecycle.MediatorLiveData<com.livpure.safedrink.subscription.plan.data.model.plan.Response> r0 = r14.planResponse     // Catch: com.livpure.safedrink.api.APIException -> La2
            java.lang.Object r0 = r0.getValue()     // Catch: com.livpure.safedrink.api.APIException -> La2
            com.livpure.safedrink.subscription.plan.data.model.plan.Response r0 = (com.livpure.safedrink.subscription.plan.data.model.plan.Response) r0     // Catch: com.livpure.safedrink.api.APIException -> La2
            if (r0 == 0) goto L6f
            com.livpure.safedrink.subscription.plan.data.model.plan.Data r0 = r0.getData()     // Catch: com.livpure.safedrink.api.APIException -> La2
            goto L70
        L6f:
            r0 = r2
        L70:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: com.livpure.safedrink.api.APIException -> La2
            com.livpure.safedrink.subscription.plan.data.model.plan.Currentplans r0 = r0.getCurrentplans()     // Catch: com.livpure.safedrink.api.APIException -> La2
            if (r0 == 0) goto L7f
            java.lang.String r0 = r0.getValidity()     // Catch: com.livpure.safedrink.api.APIException -> La2
            if (r0 != 0) goto L84
        L7f:
            r0 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: com.livpure.safedrink.api.APIException -> La2
        L84:
            java.lang.String r0 = r0.toString()     // Catch: com.livpure.safedrink.api.APIException -> La2
            int r7 = java.lang.Integer.parseInt(r0)     // Catch: com.livpure.safedrink.api.APIException -> La2
            java.lang.String r15 = r15.getSerialNo()     // Catch: com.livpure.safedrink.api.APIException -> La2
            if (r15 != 0) goto L94
            r9 = r1
            goto L95
        L94:
            r9 = r15
        L95:
            java.lang.String r10 = "topup"
            java.lang.String r11 = ""
            java.lang.String r12 = ""
            java.lang.String r13 = ""
            androidx.lifecycle.LiveData r15 = r3.setRechargeDetails(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: com.livpure.safedrink.api.APIException -> La2
            goto Le6
        La2:
            androidx.lifecycle.MutableLiveData r15 = r14.getLoading()
            r0 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r15.setValue(r0)
            androidx.lifecycle.MutableLiveData r15 = r14.getToastMessageLiveData()
            com.livpure.safedrink.common.arc.Event r0 = new com.livpure.safedrink.common.arc.Event
            java.lang.String r1 = "Oops! We faced an issue while saving the payment details."
            r0.<init>(r1)
            r15.setValue(r0)
            r15 = r2
            androidx.lifecycle.LiveData r15 = (androidx.lifecycle.LiveData) r15
            goto Le6
        Lc0:
            com.livpure.safedrink.app.LSApplication$Companion r15 = com.livpure.safedrink.app.LSApplication.Companion
            boolean r15 = r15.isNetworkAvailable()
            if (r15 != 0) goto Ld5
            androidx.lifecycle.MutableLiveData r15 = r14.getNetworkState()
            com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel$NetworkState r0 = com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel.NetworkState.OFFLINE
            r15.setValue(r0)
            r15 = r2
            androidx.lifecycle.LiveData r15 = (androidx.lifecycle.LiveData) r15
            goto Le6
        Ld5:
            androidx.lifecycle.MutableLiveData r15 = r14.getToastMessageLiveData()
            com.livpure.safedrink.common.arc.Event r0 = new com.livpure.safedrink.common.arc.Event
            java.lang.String r1 = "Payment Failed!!"
            r0.<init>(r1)
            r15.setValue(r0)
            r15 = r2
            androidx.lifecycle.LiveData r15 = (androidx.lifecycle.LiveData) r15
        Le6:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel.updatePayment(com.livpure.safedrink.subscription.plan.data.model.payment.PaymentPayload):androidx.lifecycle.LiveData");
    }

    public final LiveData<PlansItem> getSelectedPlan() {
        return this.selectedPlan;
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

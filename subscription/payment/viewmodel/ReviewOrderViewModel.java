package com.livpure.safedrink.subscription.payment.viewmodel;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.JsonObject;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.segment.SegmentLogger;
import com.livpure.safedrink.subscription.payment.model.CheckCouponModel;
import com.livpure.safedrink.subscription.payment.model.ValidateCouponModel;
import com.livpure.safedrink.subscription.plan.data.SubscriptionRepository;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.subscription.plan.data.model.payment.PaymentPayload;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
/* compiled from: ReviewOrderViewModel.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001nB\u0005¢\u0006\u0002\u0010\u0002J\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00140ZJ\f\u0010[\u001a\b\u0012\u0004\u0012\u00020!0ZJ\u000e\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_J\u000e\u0010`\u001a\u00020]2\u0006\u0010a\u001a\u00020bJ\u0006\u0010c\u001a\u00020]J.\u0010d\u001a\n\u0012\u0004\u0012\u00020e\u0018\u00010Z2\u0006\u0010f\u001a\u00020,2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020\u000b2\u0006\u0010j\u001a\u00020\u000bJ\u0014\u0010k\u001a\b\u0012\u0004\u0012\u00020W0Z2\u0006\u0010l\u001a\u00020mR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R(\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R(\u00105\u001a\u0004\u0018\u0001042\b\u0010\u001c\u001a\u0004\u0018\u000104@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010:\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R$\u0010=\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0010\"\u0004\b?\u0010\u0012R\u001a\u0010@\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0010\"\u0004\bB\u0010\u0012R\u001a\u0010C\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0010\"\u0004\bE\u0010\u0012R\u001a\u0010F\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0010\"\u0004\bH\u0010\u0012R\u001a\u0010I\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0010\"\u0004\bK\u0010\u0012R\u001b\u0010L\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bN\u0010OR\u0013\u0010R\u001a\u0004\u0018\u00010S¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0017\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\n¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\r¨\u0006o"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/viewmodel/ReviewOrderViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "_device", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "get_device", "()Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "set_device", "(Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;)V", "_selectedPlanName", "Landroidx/lifecycle/MutableLiveData;", "", "get_selectedPlanName", "()Landroidx/lifecycle/MutableLiveData;", "basePrice", "getBasePrice", "()Ljava/lang/String;", "setBasePrice", "(Ljava/lang/String;)V", "checkCouponExist", "Lcom/livpure/safedrink/subscription/payment/model/CheckCouponModel;", "getCheckCouponExist", "connectivity", "getConnectivity", "setConnectivity", "depositAmount", "getDepositAmount", "setDepositAmount", "value", AndroidContextPlugin.DEVICE_KEY, "getDevice", "setDevice", "navigationState", "Lcom/livpure/safedrink/subscription/payment/viewmodel/ReviewOrderViewModel$ReviewOrderNavigationState;", "payableAmount", "", "getPayableAmount", "()J", "setPayableAmount", "(J)V", "payableEMIAmount", "getPayableEMIAmount", "setPayableEMIAmount", "paymentData", "Lcom/livpure/safedrink/subscription/plan/data/model/payment/PaymentPayload;", "getPaymentData", "()Lcom/livpure/safedrink/subscription/plan/data/model/payment/PaymentPayload;", "setPaymentData", "(Lcom/livpure/safedrink/subscription/plan/data/model/payment/PaymentPayload;)V", "paymentId", "getPaymentId", "setPaymentId", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PriceItem;", "plan", "getPlan", "()Lcom/livpure/safedrink/subscription/plan/data/model/plan/PriceItem;", "setPlan", "(Lcom/livpure/safedrink/subscription/plan/data/model/plan/PriceItem;)V", "planName", "getPlanName", "setPlanName", "planNumber", "getPlanNumber", "setPlanNumber", "pricePerMonth", "getPricePerMonth", "setPricePerMonth", "selectedPlanId", "getSelectedPlanId", "setSelectedPlanId", "selectedPlanName", "getSelectedPlanName", "setSelectedPlanName", "serialNumber", "getSerialNumber", "setSerialNumber", "subscriptionRepository", "Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "getSubscriptionRepository", "()Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "subscriptionRepository$delegate", "Lkotlin/Lazy;", "user", "Lcom/livpure/safedrink/login/data/models/User;", "getUser", "()Lcom/livpure/safedrink/login/data/models/User;", "validateCoupon", "Lcom/livpure/safedrink/subscription/payment/model/ValidateCouponModel;", "getValidateCoupon", "checkIfCouponExist", "Landroidx/lifecycle/LiveData;", "observeNavigationState", "onPaymentClicked", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "onRechargeStatusUpdated", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "onTermsAndConditionsClicked", "updatePayment", "Lcom/livpure/safedrink/login/api/models/response/BaseV1ResponseImplementation;", "paymentPayLoad", "amount", "", "couponName", "couponAmount", "validateCouponCode", "jsonObject", "Lcom/google/gson/JsonObject;", "ReviewOrderNavigationState", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReviewOrderViewModel extends MediatorViewModel {
    private DeviceList _device;
    private final MutableLiveData<String> _selectedPlanName;
    private String connectivity;
    private DeviceList device;
    private final MutableLiveData<ReviewOrderNavigationState> navigationState;
    private long payableAmount;
    private long payableEMIAmount;
    private PaymentPayload paymentData;
    private PriceItem plan;
    private String planName;
    private String planNumber;
    private String serialNumber;
    private final Lazy subscriptionRepository$delegate = LazyKt.lazy(new Function0<SubscriptionRepository>() { // from class: com.livpure.safedrink.subscription.payment.viewmodel.ReviewOrderViewModel$subscriptionRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SubscriptionRepository invoke() {
            return new SubscriptionRepository();
        }
    });
    private final MutableLiveData<CheckCouponModel> checkCouponExist = new MutableLiveData<>();
    private final MutableLiveData<ValidateCouponModel> validateCoupon = new MutableLiveData<>();
    private final User user = LSApplication.Companion.getUser();
    private String paymentId = "";
    private String depositAmount = "";
    private String basePrice = "";
    private String pricePerMonth = "";
    private String selectedPlanName = "";
    private String selectedPlanId = "";

    /* compiled from: ReviewOrderViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/viewmodel/ReviewOrderViewModel$ReviewOrderNavigationState;", "", "(Ljava/lang/String;I)V", "INSTALLATION_ADDRESS", "TERMS_AND_CONDITIONS", "START_PAYMENT", "UPLOAD_KYC", "HOME", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum ReviewOrderNavigationState {
        INSTALLATION_ADDRESS,
        TERMS_AND_CONDITIONS,
        START_PAYMENT,
        UPLOAD_KYC,
        HOME
    }

    public ReviewOrderViewModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue("");
        this._selectedPlanName = mutableLiveData;
        this.planName = "";
        this.planNumber = "";
        this.navigationState = new MutableLiveData<>();
        this.serialNumber = "";
        this.connectivity = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubscriptionRepository getSubscriptionRepository() {
        return (SubscriptionRepository) this.subscriptionRepository$delegate.getValue();
    }

    public final MutableLiveData<CheckCouponModel> getCheckCouponExist() {
        return this.checkCouponExist;
    }

    public final MutableLiveData<ValidateCouponModel> getValidateCoupon() {
        return this.validateCoupon;
    }

    public final User getUser() {
        return this.user;
    }

    public final long getPayableAmount() {
        return this.payableAmount;
    }

    public final void setPayableAmount(long j) {
        this.payableAmount = j;
    }

    public final long getPayableEMIAmount() {
        return this.payableEMIAmount;
    }

    public final void setPayableEMIAmount(long j) {
        this.payableEMIAmount = j;
    }

    public final String getPaymentId() {
        return this.paymentId;
    }

    public final void setPaymentId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.paymentId = str;
    }

    public final PaymentPayload getPaymentData() {
        return this.paymentData;
    }

    public final void setPaymentData(PaymentPayload paymentPayload) {
        this.paymentData = paymentPayload;
    }

    public final String getDepositAmount() {
        return this.depositAmount;
    }

    public final void setDepositAmount(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.depositAmount = str;
    }

    public final String getBasePrice() {
        return this.basePrice;
    }

    public final void setBasePrice(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.basePrice = str;
    }

    public final String getPricePerMonth() {
        return this.pricePerMonth;
    }

    public final void setPricePerMonth(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pricePerMonth = str;
    }

    public final String getSelectedPlanName() {
        return this.selectedPlanName;
    }

    public final void setSelectedPlanName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectedPlanName = str;
    }

    public final String getSelectedPlanId() {
        return this.selectedPlanId;
    }

    public final void setSelectedPlanId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectedPlanId = str;
    }

    public final MutableLiveData<String> get_selectedPlanName() {
        return this._selectedPlanName;
    }

    public final String getPlanName() {
        return this.planName;
    }

    public final void setPlanName(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.selectedPlanName = value;
        this._selectedPlanName.setValue(value);
    }

    public final String getPlanNumber() {
        return this.planNumber;
    }

    public final void setPlanNumber(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.selectedPlanId = value;
    }

    public final PriceItem getPlan() {
        return this.plan;
    }

    public final void setPlan(PriceItem priceItem) {
        String price;
        String price2;
        this.plan = priceItem;
        long j = 0;
        this.payableAmount = (priceItem == null || (price2 = priceItem.getPrice()) == null) ? 0L : Long.parseLong(price2);
        if (priceItem != null && (price = priceItem.getPrice()) != null) {
            j = Long.parseLong(price);
        }
        this.payableEMIAmount = j;
        this.depositAmount = String.valueOf(priceItem != null ? priceItem.getInstallationAmount() : null);
        this.basePrice = String.valueOf(priceItem != null ? priceItem.getPrice() : null);
        this.pricePerMonth = String.valueOf(priceItem != null ? priceItem.getPricePerMonth() : null);
    }

    public final LiveData<ReviewOrderNavigationState> observeNavigationState() {
        User user = LSApplication.Companion.getUser();
        String address = user != null ? user.getAddress() : null;
        if (address == null || StringsKt.isBlank(address)) {
            this.navigationState.setValue(ReviewOrderNavigationState.INSTALLATION_ADDRESS);
        }
        return this.navigationState;
    }

    public final void onPaymentClicked(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        SegmentLogger.Companion companion = SegmentLogger.Companion;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        SegmentLogger with = companion.with(context);
        User user = LSApplication.Companion.getUser();
        String planId = user != null ? user.getPlanId() : null;
        if (planId == null || StringsKt.isBlank(planId)) {
            with.sendPaymentClickedEvent();
        } else {
            with.sendRechargeClickedEvent();
        }
        this.navigationState.setValue(ReviewOrderNavigationState.START_PAYMENT);
    }

    public final void onTermsAndConditionsClicked() {
        this.navigationState.setValue(ReviewOrderNavigationState.TERMS_AND_CONDITIONS);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075 A[Catch: APIException -> 0x00a8, TryCatch #0 {APIException -> 0x00a8, blocks: (B:7:0x002b, B:9:0x0037, B:12:0x0040, B:14:0x0047, B:18:0x0051, B:21:0x0056, B:23:0x005e, B:28:0x0068, B:32:0x0071, B:34:0x0075, B:36:0x007c, B:38:0x008c, B:41:0x0095, B:43:0x009a, B:13:0x0043), top: B:51:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008c A[Catch: APIException -> 0x00a8, TryCatch #0 {APIException -> 0x00a8, blocks: (B:7:0x002b, B:9:0x0037, B:12:0x0040, B:14:0x0047, B:18:0x0051, B:21:0x0056, B:23:0x005e, B:28:0x0068, B:32:0x0071, B:34:0x0075, B:36:0x007c, B:38:0x008c, B:41:0x0095, B:43:0x009a, B:13:0x0043), top: B:51:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0095 A[Catch: APIException -> 0x00a8, TryCatch #0 {APIException -> 0x00a8, blocks: (B:7:0x002b, B:9:0x0037, B:12:0x0040, B:14:0x0047, B:18:0x0051, B:21:0x0056, B:23:0x005e, B:28:0x0068, B:32:0x0071, B:34:0x0075, B:36:0x007c, B:38:0x008c, B:41:0x0095, B:43:0x009a, B:13:0x0043), top: B:51:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.lifecycle.LiveData<com.livpure.safedrink.login.api.models.response.BaseV1ResponseImplementation> updatePayment(com.livpure.safedrink.subscription.plan.data.model.payment.PaymentPayload r18, int r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.subscription.payment.viewmodel.ReviewOrderViewModel.updatePayment(com.livpure.safedrink.subscription.plan.data.model.payment.PaymentPayload, int, java.lang.String, java.lang.String):androidx.lifecycle.LiveData");
    }

    public final void onRechargeStatusUpdated(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        User user = LSApplication.Companion.getUser();
        if (user != null) {
            user.setPlanId(this.selectedPlanId);
        }
        UserRepository.Companion.getInstance(context).setUser(user);
        PaymentPayload paymentPayload = this.paymentData;
        this.paymentId = (paymentPayload == null || (r3 = paymentPayload.getPaymentId()) == null) ? "" : "";
        User user2 = LSApplication.Companion.getUser();
        Intrinsics.checkNotNull(user2);
        if (!user2.getKycCompleted()) {
            this.navigationState.setValue(ReviewOrderNavigationState.UPLOAD_KYC);
        } else {
            this.navigationState.setValue(ReviewOrderNavigationState.HOME);
        }
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
        this.serialNumber = (deviceList == null || (r3 = deviceList.getSerialNo()) == null) ? "" : "";
        DeviceList deviceList2 = this.device;
        if (deviceList2 != null && (connectivity = deviceList2.getConnectivity()) != null) {
            str = connectivity;
        }
        this.connectivity = str;
        DeviceList deviceList3 = this._device;
        if ((deviceList3 != null ? deviceList3.getProductType() : null) != null) {
            DeviceList deviceList4 = this._device;
            String productType = deviceList4 != null ? deviceList4.getProductType() : null;
            Intrinsics.checkNotNull(productType);
            if (StringsKt.contains((CharSequence) productType, (CharSequence) "emi", true)) {
                long j = this.payableEMIAmount;
                this.payableAmount = j;
                this.basePrice = String.valueOf(j);
            }
        }
    }

    public final LiveData<CheckCouponModel> checkIfCouponExist() {
        JsonObject jsonObject = new JsonObject();
        User user = this.user;
        jsonObject.addProperty(AnalyticsAttribute.USER_ID_ATTRIBUTE, user != null ? user.getId() : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new ReviewOrderViewModel$checkIfCouponExist$1(this, jsonObject, null), 2, null);
        return this.checkCouponExist;
    }

    public final LiveData<ValidateCouponModel> validateCouponCode(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new ReviewOrderViewModel$validateCouponCode$1(this, jsonObject, null), 2, null);
        return this.validateCoupon;
    }
}

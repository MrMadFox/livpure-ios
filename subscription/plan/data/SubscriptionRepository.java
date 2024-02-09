package com.livpure.safedrink.subscription.plan.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.JsonObject;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.bolt.data.models.BoltRequest;
import com.livpure.safedrink.login.api.models.response.BaseV1ResponseImplementation;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.subscription.payment.model.CheckCouponModel;
import com.livpure.safedrink.subscription.payment.model.ValidateCouponModel;
import com.livpure.safedrink.subscription.plan.api.SubscriptionAPIService;
import com.livpure.safedrink.subscription.plan.data.model.DashboardDetailsResponse;
import com.livpure.safedrink.subscription.plan.data.model.LocationDetailReguest;
import com.livpure.safedrink.subscription.plan.data.model.SerialNumberUpdateResponse;
import com.livpure.safedrink.subscription.plan.data.model.SubscriptionRequest;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceData;
import com.livpure.safedrink.subscription.plan.data.model.payment.PlanData;
import com.livpure.safedrink.subscription.plan.data.model.payment.RechargeDetailsRequest;
import com.livpure.safedrink.subscription.plan.data.model.plan.Response;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SubscriptionRepository.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00102\u0006\u0010\u0017\u001a\u00020\u0014J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00110\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0010J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0010J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\b\b\u0002\u0010 \u001a\u00020\u001bJ\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00102\u0006\u0010\u0017\u001a\u00020\u0014J`\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00102\u0006\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u0014J$\u0010.\u001a\b\u0012\u0004\u0012\u00020\"0\u00102\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u0014J,\u00102\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00110\u00102\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u0014J\u001f\u00105\u001a\b\u0012\u0004\u0012\u0002060\n2\u0006\u00107\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "", "()V", "subscriptionAPIService", "Lcom/livpure/safedrink/subscription/plan/api/SubscriptionAPIService;", "getSubscriptionAPIService", "()Lcom/livpure/safedrink/subscription/plan/api/SubscriptionAPIService;", "subscriptionAPIService$delegate", "Lkotlin/Lazy;", "checkCouponExist", "Lretrofit2/Response;", "Lcom/livpure/safedrink/subscription/payment/model/CheckCouponModel;", "userid", "Lcom/google/gson/JsonObject;", "(Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAirPurifierPlanDetails", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/api/BaseDataHolder;", "Lcom/livpure/safedrink/subscription/plan/data/model/payment/PlanData;", "product", "", "getDashboardDetails", "Lcom/livpure/safedrink/subscription/plan/data/model/DashboardDetailsResponse;", "serialNo", "getDeviceList", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceData;", "allDevice", "", "getInstallationStatus", "Lcom/livpure/safedrink/login/api/models/response/BaseV1ResponseImplementation;", "getPlanDetails", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/Response;", "allPlans", "getUpdateSerialNumber", "Lcom/livpure/safedrink/subscription/plan/data/model/SerialNumberUpdateResponse;", "setRechargeDetails", "rechargeAmount", "paymentId", "planId", "planDuration", "", "oldPlanId", "rechargeType", "deposit_amount", "couponName", "couponAmount", "updateDeviceConnection", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "wifiMode", "connectivity", "updateLocationDetails", "latitude", "longitude", "validateCouponCode", "Lcom/livpure/safedrink/subscription/payment/model/ValidateCouponModel;", "jsonObject", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SubscriptionRepository {
    private final Lazy subscriptionAPIService$delegate = LazyKt.lazy(new Function0<SubscriptionAPIService>() { // from class: com.livpure.safedrink.subscription.plan.data.SubscriptionRepository$subscriptionAPIService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SubscriptionAPIService invoke() {
            return SubscriptionAPIService.Factory.getAPIService();
        }
    });

    private final SubscriptionAPIService getSubscriptionAPIService() {
        return (SubscriptionAPIService) this.subscriptionAPIService$delegate.getValue();
    }

    public final LiveData<BaseV1ResponseImplementation> getInstallationStatus() throws APIException {
        SubscriptionAPIService subscriptionAPIService = getSubscriptionAPIService();
        User user = LSApplication.Companion.getUser();
        LiveData<BaseV1ResponseImplementation> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(subscriptionAPIService.getDeviceList(new SubscriptionRequest(String.valueOf(user != null ? user.getId() : null), "")), new Function0<BaseV1ResponseImplementation>() { // from class: com.livpure.safedrink.subscription.plan.data.SubscriptionRepository$getInstallationStatus$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BaseV1ResponseImplementation invoke() {
                return new BaseV1ResponseImplementation(null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ntation(null) }\n        )");
        return fromPublisher;
    }

    public final LiveData<DashboardDetailsResponse> getDashboardDetails(String serialNo) throws APIException {
        String str;
        Intrinsics.checkNotNullParameter(serialNo, "serialNo");
        if (LSApplication.Companion.getUser() != null) {
            User user = LSApplication.Companion.getUser();
            Intrinsics.checkNotNull(user);
            str = user.getId();
        } else {
            str = "";
        }
        LiveData<DashboardDetailsResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getSubscriptionAPIService().getDashboardDetails(new SubscriptionRequest(str, serialNo)), new Function0<DashboardDetailsResponse>() { // from class: com.livpure.safedrink.subscription.plan.data.SubscriptionRepository$getDashboardDetails$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DashboardDetailsResponse invoke() {
                return new DashboardDetailsResponse(null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …esponse(null) }\n        )");
        return fromPublisher;
    }

    public static /* synthetic */ LiveData getPlanDetails$default(SubscriptionRepository subscriptionRepository, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return subscriptionRepository.getPlanDetails(z);
    }

    public final LiveData<BaseDataHolder<PlanData>> getPlanDetails(boolean z) {
        LiveData<BaseDataHolder<PlanData>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getSubscriptionAPIService().getPlanDetails(z)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseDataHolder<PlanData>> getAirPurifierPlanDetails(String product) {
        Intrinsics.checkNotNullParameter(product, "product");
        LiveData<BaseDataHolder<PlanData>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getSubscriptionAPIService().getAirPurifierPlanDetails(product)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final LiveData<Response> getPlanDetails() {
        LiveData<Response> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getSubscriptionAPIService().getPlanDetails(), new Function0<Response>() { // from class: com.livpure.safedrink.subscription.plan.data.SubscriptionRepository$getPlanDetails$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Response invoke() {
                return new Response(null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …esponse(null) }\n        )");
        return fromPublisher;
    }

    public static /* synthetic */ LiveData getDeviceList$default(SubscriptionRepository subscriptionRepository, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return subscriptionRepository.getDeviceList(z);
    }

    public final LiveData<BaseDataHolder<DeviceData>> getDeviceList(boolean z) {
        LiveData<BaseDataHolder<DeviceData>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getSubscriptionAPIService().getDeviceList(z)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public static /* synthetic */ LiveData setRechargeDetails$default(SubscriptionRepository subscriptionRepository, String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, String str9, int i2, Object obj) throws APIException {
        String str10;
        String str11;
        String str12 = (i2 & 16) != 0 ? "" : str4;
        if ((i2 & 64) != 0) {
            if (i == 1) {
                str11 = "plan";
            } else {
                str11 = i + "_months";
            }
            str10 = str11;
        } else {
            str10 = str6;
        }
        return subscriptionRepository.setRechargeDetails(str, str2, str3, i, str12, str5, str10, str7, str8, str9);
    }

    public final LiveData<BaseV1ResponseImplementation> setRechargeDetails(String rechargeAmount, String paymentId, String planId, int i, String oldPlanId, String serialNo, String rechargeType, String deposit_amount, String couponName, String couponAmount) throws APIException {
        StringBuilder sb;
        String str;
        Intrinsics.checkNotNullParameter(rechargeAmount, "rechargeAmount");
        Intrinsics.checkNotNullParameter(paymentId, "paymentId");
        Intrinsics.checkNotNullParameter(planId, "planId");
        Intrinsics.checkNotNullParameter(oldPlanId, "oldPlanId");
        Intrinsics.checkNotNullParameter(serialNo, "serialNo");
        Intrinsics.checkNotNullParameter(rechargeType, "rechargeType");
        Intrinsics.checkNotNullParameter(deposit_amount, "deposit_amount");
        Intrinsics.checkNotNullParameter(couponName, "couponName");
        Intrinsics.checkNotNullParameter(couponAmount, "couponAmount");
        SubscriptionAPIService subscriptionAPIService = getSubscriptionAPIService();
        User user = LSApplication.Companion.getUser();
        if ((user != null ? user.getPlanId() : null) == null) {
            sb = new StringBuilder();
            str = "MOB_ANDROID_NEW_";
        } else {
            sb = new StringBuilder();
            str = "MOB_ANDROID_";
        }
        sb.append(str);
        sb.append(paymentId);
        LiveData<BaseV1ResponseImplementation> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(subscriptionAPIService.setRechargeDetails(new RechargeDetailsRequest(null, rechargeAmount, null, sb.toString(), planId, rechargeType, oldPlanId, serialNo, null, null, deposit_amount, couponName, couponAmount, 773, null)), new Function0<BaseV1ResponseImplementation>() { // from class: com.livpure.safedrink.subscription.plan.data.SubscriptionRepository$setRechargeDetails$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BaseV1ResponseImplementation invoke() {
                return new BaseV1ResponseImplementation(null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ntation(null) }\n        )");
        return fromPublisher;
    }

    public final LiveData<SerialNumberUpdateResponse> getUpdateSerialNumber(String serialNo) throws APIException {
        Intrinsics.checkNotNullParameter(serialNo, "serialNo");
        SubscriptionAPIService subscriptionAPIService = getSubscriptionAPIService();
        User user = LSApplication.Companion.getUser();
        Intrinsics.checkNotNull(user);
        LiveData<SerialNumberUpdateResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(subscriptionAPIService.getUpdateSerialNumber(new SubscriptionRequest(user.getId(), serialNo)), new Function0<SerialNumberUpdateResponse>() { // from class: com.livpure.safedrink.subscription.plan.data.SubscriptionRepository$getUpdateSerialNumber$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SerialNumberUpdateResponse invoke() {
                return new SerialNumberUpdateResponse("");
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …eResponse(\"\") }\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseDataHolder<Object>> updateLocationDetails(String serialNo, String latitude, String longitude) throws APIException {
        Intrinsics.checkNotNullParameter(serialNo, "serialNo");
        Intrinsics.checkNotNullParameter(latitude, "latitude");
        Intrinsics.checkNotNullParameter(longitude, "longitude");
        SubscriptionAPIService subscriptionAPIService = getSubscriptionAPIService();
        User user = LSApplication.Companion.getUser();
        Intrinsics.checkNotNull(user);
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(subscriptionAPIService.updateLocationDetails(new LocationDetailReguest(user.getId(), serialNo, latitude, longitude))));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final LiveData<SerialNumberUpdateResponse> updateDeviceConnection(String request, boolean z, String connectivity) throws APIException {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(connectivity, "connectivity");
        LiveData<SerialNumberUpdateResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getSubscriptionAPIService().updateDeviceConnection(new BoltRequest(request, z, connectivity)), new Function0<SerialNumberUpdateResponse>() { // from class: com.livpure.safedrink.subscription.plan.data.SubscriptionRepository$updateDeviceConnection$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SerialNumberUpdateResponse invoke() {
                return new SerialNumberUpdateResponse("");
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …eResponse(\"\") }\n        )");
        return fromPublisher;
    }

    public final Object checkCouponExist(JsonObject jsonObject, Continuation<? super retrofit2.Response<CheckCouponModel>> continuation) {
        return getSubscriptionAPIService().checkCouponExist(jsonObject, continuation);
    }

    public final Object validateCouponCode(JsonObject jsonObject, Continuation<? super retrofit2.Response<ValidateCouponModel>> continuation) {
        return getSubscriptionAPIService().validateCouponCode(jsonObject, continuation);
    }
}

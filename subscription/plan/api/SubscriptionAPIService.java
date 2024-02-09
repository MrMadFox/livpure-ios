package com.livpure.safedrink.subscription.plan.api;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.JsonObject;
import com.livpure.safedrink.api.APIService;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.bolt.data.models.BoltRequest;
import com.livpure.safedrink.login.api.models.response.BaseV1ResponseImplementation;
import com.livpure.safedrink.subscription.payment.model.CheckCouponModel;
import com.livpure.safedrink.subscription.payment.model.ValidateCouponModel;
import com.livpure.safedrink.subscription.plan.data.model.DashboardDetailsResponse;
import com.livpure.safedrink.subscription.plan.data.model.LocationDetailReguest;
import com.livpure.safedrink.subscription.plan.data.model.SerialNumberUpdateResponse;
import com.livpure.safedrink.subscription.plan.data.model.SubscriptionRequest;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceData;
import com.livpure.safedrink.subscription.plan.data.model.payment.PlanData;
import com.livpure.safedrink.subscription.plan.data.model.payment.RechargeDetailsRequest;
import io.reactivex.Flowable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
/* compiled from: SubscriptionAPIService.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 &2\u00020\u0001:\u0001&J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\b\b\u0001\u0010\f\u001a\u00020\rH'J\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H'J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\t2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H'J\u001e\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n0\t2\b\b\u0001\u0010\u0015\u001a\u00020\u0016H'J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\tH'J\u001e\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\b\b\u0001\u0010\u0019\u001a\u00020\u0016H'J\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H'J\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\t2\b\b\u0001\u0010\u001d\u001a\u00020\u001eH'J\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\b\b\u0001\u0010\u0010\u001a\u00020 H'J \u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n0\t2\b\b\u0001\u0010\u0010\u001a\u00020\"H'J!\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0001\u0010%\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/api/SubscriptionAPIService;", "", "checkCouponExist", "Lretrofit2/Response;", "Lcom/livpure/safedrink/subscription/payment/model/CheckCouponModel;", "userid", "Lcom/google/gson/JsonObject;", "(Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAirPurifierPlanDetails", "Lio/reactivex/Flowable;", "Lcom/livpure/safedrink/api/BaseDataHolder;", "Lcom/livpure/safedrink/subscription/plan/data/model/payment/PlanData;", "product", "", "getDashboardDetails", "Lcom/livpure/safedrink/subscription/plan/data/model/DashboardDetailsResponse;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/livpure/safedrink/subscription/plan/data/model/SubscriptionRequest;", "getDeviceList", "Lcom/livpure/safedrink/login/api/models/response/BaseV1ResponseImplementation;", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceData;", "allDevice", "", "getPlanDetails", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/Response;", "allPlans", "getUpdateSerialNumber", "Lcom/livpure/safedrink/subscription/plan/data/model/SerialNumberUpdateResponse;", "setRechargeDetails", "rechargeDetailsRequest", "Lcom/livpure/safedrink/subscription/plan/data/model/payment/RechargeDetailsRequest;", "updateDeviceConnection", "Lcom/livpure/safedrink/bolt/data/models/BoltRequest;", "updateLocationDetails", "Lcom/livpure/safedrink/subscription/plan/data/model/LocationDetailReguest;", "validateCouponCode", "Lcom/livpure/safedrink/subscription/payment/model/ValidateCouponModel;", "jsonObject", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SubscriptionAPIService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST("/v3/checkUserRetentionCoupomExists")
    Object checkCouponExist(@Body JsonObject jsonObject, Continuation<? super Response<CheckCouponModel>> continuation);

    @GET("/v3/planDetails")
    Flowable<BaseDataHolder<PlanData>> getAirPurifierPlanDetails(@Query("product") String str);

    @POST("/getDashBoardDetails")
    Flowable<DashboardDetailsResponse> getDashboardDetails(@Body SubscriptionRequest subscriptionRequest);

    @POST("/getDevices")
    Flowable<BaseV1ResponseImplementation> getDeviceList(@Body SubscriptionRequest subscriptionRequest);

    @GET("/v3/getDevicesByUserId")
    Flowable<BaseDataHolder<DeviceData>> getDeviceList(@Query("allDevice") boolean z);

    @GET("/v4/cityPlanDetails")
    Flowable<com.livpure.safedrink.subscription.plan.data.model.plan.Response> getPlanDetails();

    @GET("/v2/planDetails")
    Flowable<BaseDataHolder<PlanData>> getPlanDetails(@Query("allPlans") boolean z);

    @POST("/v3/scanSerialNo")
    Flowable<SerialNumberUpdateResponse> getUpdateSerialNumber(@Body SubscriptionRequest subscriptionRequest);

    @POST("/setRechargeDetails")
    Flowable<BaseV1ResponseImplementation> setRechargeDetails(@Body RechargeDetailsRequest rechargeDetailsRequest);

    @POST("/v3/updateDevice")
    Flowable<SerialNumberUpdateResponse> updateDeviceConnection(@Body BoltRequest boltRequest);

    @POST("/updateLocationDetails")
    Flowable<BaseDataHolder<Object>> updateLocationDetails(@Body LocationDetailReguest locationDetailReguest);

    @POST("/v3/readCouponCode")
    Object validateCouponCode(@Body JsonObject jsonObject, Continuation<? super Response<ValidateCouponModel>> continuation);

    /* compiled from: SubscriptionAPIService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/subscription/plan/api/SubscriptionAPIService$Factory;", "Lcom/livpure/safedrink/api/APIService;", "()V", "getAPIService", "Lcom/livpure/safedrink/subscription/plan/api/SubscriptionAPIService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends APIService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final SubscriptionAPIService getAPIService() {
            return (SubscriptionAPIService) new APIService.APIInterfaceFactory(this, SubscriptionAPIService.class).getAPIInterface();
        }
    }
}

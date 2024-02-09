package com.livpure.safedrink.serviceRequest.api;

import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.LSHConfig;
import com.livpure.safedrink.api.APIService;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.serviceRequest.data.Models.ServiceLogs;
import com.livpure.safedrink.serviceRequest.data.Models.ServiceRequestData;
import com.livpure.safedrink.serviceRequest.data.Models.ServiceRequestHistory;
import com.livpure.safedrink.serviceRequest.data.Models.ServiceRequestResponse;
import com.livpure.safedrink.serviceRequest.data.model.FreshdeskHistory;
import com.livpure.safedrink.serviceRequest.data.model.OTPRequest;
import com.livpure.safedrink.serviceRequest.data.model.RefreshRechargeRequest;
import com.livpure.safedrink.serviceRequest.data.model.RefreshRechargeResponse;
import com.livpure.safedrink.serviceRequest.data.model.ServiceHistory;
import com.livpure.safedrink.serviceRequest.data.model.ServiceRequestOtherData;
import io.reactivex.Flowable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
/* compiled from: ServiceReguestAPIService.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J.\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u000bH'J \u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J \u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0010H'J.\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u000bH'J \u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0015H'J\u0016\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e0\u0003H'J.\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00192\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u000bH'J \u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001bH'¨\u0006\u001d"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/api/ServiceReguestAPIService;", "", "getFreshdeskHistoryRequest", "Lio/reactivex/Flowable;", "Lcom/livpure/safedrink/serviceRequest/data/model/FreshdeskHistory;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/livpure/safedrink/serviceRequest/data/Models/ServiceLogs;", "getHumsarServiceRequest", "Lcom/livpure/safedrink/serviceRequest/data/model/ServiceHistory;", "Lcom/livpure/safedrink/serviceRequest/data/Models/ServiceRequestHistory;", "url", "", "entryPoint", "getServiceLogs", "Lcom/livpure/safedrink/api/BaseDataHolder;", "getServiceRequest", "Lcom/livpure/safedrink/serviceRequest/data/model/ServiceRequestOtherData;", "getServiceRequestHistory", "getServiceRequestTemp", "refreshRechargeRequest", "Lcom/livpure/safedrink/serviceRequest/data/model/RefreshRechargeResponse;", "Lcom/livpure/safedrink/serviceRequest/data/model/RefreshRechargeRequest;", "sendCancelOtp", "updateServiceRequest", "Lcom/livpure/safedrink/serviceRequest/data/Models/ServiceRequestResponse;", "Lcom/livpure/safedrink/serviceRequest/data/Models/ServiceRequestData;", "verifyCancelOtp", "Lcom/livpure/safedrink/serviceRequest/data/model/OTPRequest;", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ServiceReguestAPIService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST("/v3/serviceRequestHistory")
    Flowable<FreshdeskHistory> getFreshdeskHistoryRequest(@Body ServiceLogs serviceLogs);

    @POST
    Flowable<ServiceHistory> getHumsarServiceRequest(@Body ServiceRequestHistory serviceRequestHistory, @Url String str, @Query("entryPoint") String str2);

    @POST("/serviceLogs")
    Flowable<BaseDataHolder<Object>> getServiceLogs(@Body ServiceLogs serviceLogs);

    @POST("/v3/serviceRequest")
    Flowable<BaseDataHolder<Object>> getServiceRequest(@Body ServiceRequestOtherData serviceRequestOtherData);

    @POST
    Flowable<ServiceHistory> getServiceRequestHistory(@Body ServiceRequestHistory serviceRequestHistory, @Url String str, @Query("entryPoint") String str2);

    @POST("/v3/serviceRequestHistory")
    Flowable<BaseDataHolder<Object>> getServiceRequestTemp(@Body ServiceLogs serviceLogs);

    @POST("/ro/refresh")
    Flowable<RefreshRechargeResponse> refreshRechargeRequest(@Body RefreshRechargeRequest refreshRechargeRequest);

    @POST("v3/sendCancelOtp")
    Flowable<BaseDataHolder<Object>> sendCancelOtp();

    @POST
    Flowable<ServiceRequestResponse> updateServiceRequest(@Body ServiceRequestData serviceRequestData, @Url String str, @Query("entryPoint") String str2);

    @POST("v3/verifyCancelOtp")
    Flowable<BaseDataHolder<Object>> verifyCancelOtp(@Body OTPRequest oTPRequest);

    /* compiled from: ServiceReguestAPIService.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Flowable updateServiceRequest$default(ServiceReguestAPIService serviceReguestAPIService, ServiceRequestData serviceRequestData, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = LSHConfig.BASE_CRM_URL;
                }
                if ((i & 4) != 0) {
                    str2 = "Hudoo";
                }
                return serviceReguestAPIService.updateServiceRequest(serviceRequestData, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateServiceRequest");
        }

        public static /* synthetic */ Flowable getServiceRequestHistory$default(ServiceReguestAPIService serviceReguestAPIService, ServiceRequestHistory serviceRequestHistory, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = LSHConfig.BASE_CRM_URL;
                }
                if ((i & 4) != 0) {
                    str2 = "Drona";
                }
                return serviceReguestAPIService.getServiceRequestHistory(serviceRequestHistory, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getServiceRequestHistory");
        }

        public static /* synthetic */ Flowable getHumsarServiceRequest$default(ServiceReguestAPIService serviceReguestAPIService, ServiceRequestHistory serviceRequestHistory, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = LSHConfig.BASE_CRM_URL;
                }
                if ((i & 4) != 0) {
                    str2 = "Drona";
                }
                return serviceReguestAPIService.getHumsarServiceRequest(serviceRequestHistory, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getHumsarServiceRequest");
        }
    }

    /* compiled from: ServiceReguestAPIService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/api/ServiceReguestAPIService$Factory;", "Lcom/livpure/safedrink/api/APIService;", "()V", "getServicerequestAPIService", "Lcom/livpure/safedrink/serviceRequest/api/ServiceReguestAPIService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends APIService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final ServiceReguestAPIService getServicerequestAPIService() {
            return (ServiceReguestAPIService) new APIService.APIInterfaceFactory(this, ServiceReguestAPIService.class).getAPIInterface();
        }
    }
}

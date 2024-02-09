package com.livpure.safedrink.serviceRequest.api;

import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.api.APIHumsarService;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.serviceRequest.data.model.CustomerVoiceRequest;
import com.livpure.safedrink.serviceRequest.data.model.CustomerVoiceResponse;
import com.livpure.safedrink.serviceRequest.data.model.HumsarServiceRequest;
import io.reactivex.Flowable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
/* compiled from: HumsarServiceReguestAPIService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ \u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH'J \u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J \u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\r"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/api/HumsarServiceReguestAPIService;", "", "getWAAS_Cancellation", "Lio/reactivex/Flowable;", "Lcom/livpure/safedrink/api/BaseDataHolder;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/livpure/safedrink/serviceRequest/data/model/HumsarServiceRequest;", "getWAAS_GetCustomerVoice", "Lcom/livpure/safedrink/serviceRequest/data/model/CustomerVoiceResponse;", "Lcom/livpure/safedrink/serviceRequest/data/model/CustomerVoiceRequest;", "getWAAS_GetReason", "getWAAS_GetSubReason", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface HumsarServiceReguestAPIService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST("/MobileAPI/AppServices.svc/WAAS_Cancellation")
    Flowable<BaseDataHolder<Object>> getWAAS_Cancellation(@Body HumsarServiceRequest humsarServiceRequest);

    @POST("MobileAPI/AppServices.svc/WAAS_GetCustomerVoice")
    Flowable<CustomerVoiceResponse> getWAAS_GetCustomerVoice(@Body CustomerVoiceRequest customerVoiceRequest);

    @POST("MobileAPI/AppServices.svc/WAAS_GetReason")
    Flowable<BaseDataHolder<Object>> getWAAS_GetReason(@Body HumsarServiceRequest humsarServiceRequest);

    @POST("/MobileAPI/AppServices.svc/WAAS_GetSubReason")
    Flowable<BaseDataHolder<Object>> getWAAS_GetSubReason(@Body HumsarServiceRequest humsarServiceRequest);

    /* compiled from: HumsarServiceReguestAPIService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/api/HumsarServiceReguestAPIService$Factory;", "Lcom/livpure/safedrink/api/APIHumsarService;", "()V", "getAPIService", "Lcom/livpure/safedrink/serviceRequest/api/HumsarServiceReguestAPIService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends APIHumsarService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final HumsarServiceReguestAPIService getAPIService() {
            return (HumsarServiceReguestAPIService) new APIHumsarService.APIHumsarServiceInterfaceFactory(this, HumsarServiceReguestAPIService.class).getHumsarAPIInterface();
        }
    }
}

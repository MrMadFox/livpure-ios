package com.livpure.safedrink.serviceRequest.api;

import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.api.RelocationService;
import com.livpure.safedrink.serviceRequest.data.model.CityByPincodeRequest;
import com.livpure.safedrink.serviceRequest.data.model.CityByPincodeResponse;
import com.livpure.safedrink.serviceRequest.data.model.NewPlanRequest;
import com.livpure.safedrink.serviceRequest.data.model.NewPlanResponse;
import com.livpure.safedrink.serviceRequest.data.model.TrackOrderReq;
import com.livpure.safedrink.serviceRequest.data.model.TrackOrderRes;
import io.reactivex.Flowable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
/* compiled from: RelocationRequestAPIService.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u001a\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH'J\u001a\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\rH'¨\u0006\u000f"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/api/RelocationRequestAPIService;", "", "getCityByPincode", "Lio/reactivex/Flowable;", "Lcom/livpure/safedrink/serviceRequest/data/model/CityByPincodeResponse;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/livpure/safedrink/serviceRequest/data/model/CityByPincodeRequest;", "showNewPlan", "Lcom/livpure/safedrink/serviceRequest/data/model/NewPlanResponse;", "Lcom/livpure/safedrink/serviceRequest/data/model/NewPlanRequest;", "trackOrder", "Lcom/livpure/safedrink/serviceRequest/data/model/TrackOrderRes;", "trackOrderReq", "Lcom/livpure/safedrink/serviceRequest/data/model/TrackOrderReq;", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface RelocationRequestAPIService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST("getPincode")
    Flowable<CityByPincodeResponse> getCityByPincode(@Body CityByPincodeRequest cityByPincodeRequest);

    @POST("v4/shownewplan")
    Flowable<NewPlanResponse> showNewPlan(@Body NewPlanRequest newPlanRequest);

    @POST("trackOrderSap")
    Flowable<TrackOrderRes> trackOrder(@Body TrackOrderReq trackOrderReq);

    /* compiled from: RelocationRequestAPIService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/api/RelocationRequestAPIService$Factory;", "Lcom/livpure/safedrink/api/RelocationService;", "()V", "getRelocationRequestApiService", "Lcom/livpure/safedrink/serviceRequest/api/RelocationRequestAPIService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends RelocationService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final RelocationRequestAPIService getRelocationRequestApiService() {
            return (RelocationRequestAPIService) new RelocationService.APIInterfaceFactory(this, RelocationRequestAPIService.class).getAPIInterface();
        }
    }
}

package com.livpure.safedrink.serviceRequest.api;

import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.api.RelocationUpdateAddressService;
import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.livpure.safedrink.serviceRequest.data.model.UpdateAddressRequest;
import io.reactivex.Flowable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
/* compiled from: RelocationUpdateAddressAPIService.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\b"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/api/RelocationUpdateAddressAPIService;", "", "updateAddress", "Lio/reactivex/Flowable;", "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/livpure/safedrink/serviceRequest/data/model/UpdateAddressRequest;", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface RelocationUpdateAddressAPIService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST("v4/updateAddress")
    Flowable<BaseV1Response> updateAddress(@Body UpdateAddressRequest updateAddressRequest);

    /* compiled from: RelocationUpdateAddressAPIService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/api/RelocationUpdateAddressAPIService$Factory;", "Lcom/livpure/safedrink/api/RelocationUpdateAddressService;", "()V", "getRelocationUpdateAddressApiService", "Lcom/livpure/safedrink/serviceRequest/api/RelocationUpdateAddressAPIService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends RelocationUpdateAddressService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final RelocationUpdateAddressAPIService getRelocationUpdateAddressApiService() {
            return (RelocationUpdateAddressAPIService) new RelocationUpdateAddressService.APIInterfaceFactory(this, RelocationUpdateAddressAPIService.class).getAPIInterface();
        }
    }
}

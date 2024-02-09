package com.livpure.safedrink.ota.api;

import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.api.APIOTAService;
import com.livpure.safedrink.ota.data.model.MessageDetailsResponse;
import com.livpure.safedrink.ota.data.model.OTARequest;
import com.livpure.safedrink.ota.data.model.OTAUpdateDetailsResponse;
import com.livpure.safedrink.ota.data.model.firmwareRequest;
import io.reactivex.Flowable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
/* compiled from: OTAotaService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH'¨\u0006\u000b"}, d2 = {"Lcom/livpure/safedrink/ota/api/OTAotaService;", "", "getOTADetails", "Lio/reactivex/Flowable;", "Lcom/livpure/safedrink/ota/data/model/MessageDetailsResponse;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/livpure/safedrink/ota/data/model/OTARequest;", "updateOTADetails", "Lcom/livpure/safedrink/ota/data/model/OTAUpdateDetailsResponse;", "Lcom/livpure/safedrink/ota/data/model/firmwareRequest;", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface OTAotaService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST("/getOta")
    Flowable<MessageDetailsResponse> getOTADetails(@Body OTARequest oTARequest);

    @POST("/updateOta")
    Flowable<OTAUpdateDetailsResponse> updateOTADetails(@Body firmwareRequest firmwarerequest);

    /* compiled from: OTAotaService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/ota/api/OTAotaService$Factory;", "Lcom/livpure/safedrink/api/APIOTAService;", "()V", "getAPIOTAService", "Lcom/livpure/safedrink/ota/api/OTAotaService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends APIOTAService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final OTAotaService getAPIOTAService() {
            return (OTAotaService) new APIOTAService.APIOTAInterfaceFactory(this, OTAotaService.class).getAPIOTAInterface();
        }
    }
}

package com.livpure.safedrink.dispenser.api;

import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.api.APIService;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.bolt.data.models.BoltCommandsResponse;
import com.livpure.safedrink.dispenser.data.models.DispenserBLEStatus;
import com.livpure.safedrink.dispenser.data.models.DispenserCommands;
import com.livpure.safedrink.dispenser.data.models.DispenserDashboardDetails;
import com.livpure.safedrink.dispenser.data.models.DispenserStatus;
import com.livpure.safedrink.dispenser.data.models.DispenserWifiStatus;
import io.reactivex.Flowable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
/* compiled from: DispenserRequestAPIService.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ \u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\nH'J \u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\fH'J \u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u000eH'¨\u0006\u0010"}, d2 = {"Lcom/livpure/safedrink/dispenser/api/DispenserRequestAPIService;", "", "getBlueToothCommand", "Lio/reactivex/Flowable;", "Lcom/livpure/safedrink/api/BaseDataHolder;", "Lcom/livpure/safedrink/bolt/data/models/BoltCommandsResponse;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/livpure/safedrink/dispenser/data/models/DispenserBLEStatus;", "getDashboard", "Lcom/livpure/safedrink/dispenser/data/models/DispenserDashboardDetails;", "Lcom/livpure/safedrink/dispenser/data/models/DispenserStatus;", "sendDispenserCommand", "Lcom/livpure/safedrink/dispenser/data/models/DispenserCommands;", "setConnectivityStatus", "Lcom/livpure/safedrink/dispenser/data/models/DispenserWifiStatus;", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface DispenserRequestAPIService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST("/ro/getBlueToothCmd")
    Flowable<BaseDataHolder<BoltCommandsResponse>> getBlueToothCommand(@Body DispenserBLEStatus dispenserBLEStatus);

    @POST("/ro/dashboard")
    Flowable<DispenserDashboardDetails> getDashboard(@Body DispenserStatus dispenserStatus);

    @POST("/ro/command")
    Flowable<BaseDataHolder<Object>> sendDispenserCommand(@Body DispenserCommands dispenserCommands);

    @POST("/ro/saveConnectivity")
    Flowable<BaseDataHolder<Object>> setConnectivityStatus(@Body DispenserWifiStatus dispenserWifiStatus);

    /* compiled from: DispenserRequestAPIService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/dispenser/api/DispenserRequestAPIService$Factory;", "Lcom/livpure/safedrink/api/APIService;", "()V", "getAPIService", "Lcom/livpure/safedrink/dispenser/api/DispenserRequestAPIService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends APIService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final DispenserRequestAPIService getAPIService() {
            return (DispenserRequestAPIService) new APIService.APIInterfaceFactory(this, DispenserRequestAPIService.class).getAPIInterface();
        }
    }
}

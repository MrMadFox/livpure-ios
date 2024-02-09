package com.livpure.safedrink.airpurifier.api;

import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierBLEStatus;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierCommand;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierDashboardDetails;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierStatus;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierWifiStatus;
import com.livpure.safedrink.api.APIService;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.bolt.data.models.BoltCommandsResponse;
import io.reactivex.Flowable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
/* compiled from: AirPurifierRequestAPIService.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J \u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\nH'J \u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\fH'J \u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u000eH'J \u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'¨\u0006\u0011"}, d2 = {"Lcom/livpure/safedrink/airpurifier/api/AirPurifierRequestAPIService;", "", "getBlueToothCommand", "Lio/reactivex/Flowable;", "Lcom/livpure/safedrink/api/BaseDataHolder;", "Lcom/livpure/safedrink/bolt/data/models/BoltCommandsResponse;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierBLEStatus;", "getDashboard", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDashboardDetails;", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierStatus;", "sendAirPurifierCommand", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierCommand;", "setConnectivityStatus", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierWifiStatus;", "setSaveStatus", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AirPurifierRequestAPIService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST("/air/getBlueToothCmd")
    Flowable<BaseDataHolder<BoltCommandsResponse>> getBlueToothCommand(@Body AirPurifierBLEStatus airPurifierBLEStatus);

    @POST("/air/dashboard")
    Flowable<AirPurifierDashboardDetails> getDashboard(@Body AirPurifierStatus airPurifierStatus);

    @POST("/air/command")
    Flowable<BaseDataHolder<Object>> sendAirPurifierCommand(@Body AirPurifierCommand airPurifierCommand);

    @POST("/air/saveConnectivity")
    Flowable<BaseDataHolder<Object>> setConnectivityStatus(@Body AirPurifierWifiStatus airPurifierWifiStatus);

    @POST("/air/postBlueToothCmdResponse")
    Flowable<BaseDataHolder<Object>> setSaveStatus(@Body AirPurifierBLEStatus airPurifierBLEStatus);

    /* compiled from: AirPurifierRequestAPIService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/airpurifier/api/AirPurifierRequestAPIService$Factory;", "Lcom/livpure/safedrink/api/APIService;", "()V", "getAPIService", "Lcom/livpure/safedrink/airpurifier/api/AirPurifierRequestAPIService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends APIService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final AirPurifierRequestAPIService getAPIService() {
            return (AirPurifierRequestAPIService) new APIService.APIInterfaceFactory(this, AirPurifierRequestAPIService.class).getAPIInterface();
        }
    }
}

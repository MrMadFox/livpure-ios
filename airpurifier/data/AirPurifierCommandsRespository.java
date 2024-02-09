package com.livpure.safedrink.airpurifier.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.livpure.safedrink.airpurifier.api.AirPurifierRequestAPIService;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierBLEStatus;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierCommand;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierDashboardDetails;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierStatus;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierWifiStatus;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.bolt.data.models.BoltCommandsResponse;
import com.livpure.safedrink.login.data.models.User;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AirPurifierCommandsRespository.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\n2\u0006\u0010\u0011\u001a\u00020\u0012J\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\n2\u0006\u0010\u0014\u001a\u00020\u0015J\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\n2\u0006\u0010\u0017\u001a\u00020\u0018J\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/livpure/safedrink/airpurifier/data/AirPurifierCommandsRespository;", "", "()V", "apiService", "Lcom/livpure/safedrink/airpurifier/api/AirPurifierRequestAPIService;", "getApiService", "()Lcom/livpure/safedrink/airpurifier/api/AirPurifierRequestAPIService;", "apiService$delegate", "Lkotlin/Lazy;", "getBlueToothCommand", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/api/BaseDataHolder;", "Lcom/livpure/safedrink/bolt/data/models/BoltCommandsResponse;", "airPurifierBLEStatus", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierBLEStatus;", "getDashboardDetails", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDashboardDetails;", "serialNo", "", "sendAirPurifierCommand", "airPurifierCommand", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierCommand;", "setConnectivityStatus", "airPurifierWifiStatus", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierWifiStatus;", "setSaveStatus", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AirPurifierCommandsRespository {
    private final Lazy apiService$delegate = LazyKt.lazy(new Function0<AirPurifierRequestAPIService>() { // from class: com.livpure.safedrink.airpurifier.data.AirPurifierCommandsRespository$apiService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AirPurifierRequestAPIService invoke() {
            return AirPurifierRequestAPIService.Factory.getAPIService();
        }
    });

    private final AirPurifierRequestAPIService getApiService() {
        return (AirPurifierRequestAPIService) this.apiService$delegate.getValue();
    }

    public final LiveData<BaseDataHolder<Object>> sendAirPurifierCommand(AirPurifierCommand airPurifierCommand) {
        Intrinsics.checkNotNullParameter(airPurifierCommand, "airPurifierCommand");
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getApiService().sendAirPurifierCommand(airPurifierCommand)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseDataHolder<Object>> setSaveStatus(AirPurifierBLEStatus airPurifierBLEStatus) {
        Intrinsics.checkNotNullParameter(airPurifierBLEStatus, "airPurifierBLEStatus");
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getApiService().setSaveStatus(airPurifierBLEStatus)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseDataHolder<Object>> setConnectivityStatus(AirPurifierWifiStatus airPurifierWifiStatus) {
        Intrinsics.checkNotNullParameter(airPurifierWifiStatus, "airPurifierWifiStatus");
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getApiService().setConnectivityStatus(airPurifierWifiStatus)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseDataHolder<BoltCommandsResponse>> getBlueToothCommand(AirPurifierBLEStatus airPurifierBLEStatus) {
        Intrinsics.checkNotNullParameter(airPurifierBLEStatus, "airPurifierBLEStatus");
        LiveData<BaseDataHolder<BoltCommandsResponse>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getApiService().getBlueToothCommand(airPurifierBLEStatus)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    public final LiveData<AirPurifierDashboardDetails> getDashboardDetails(String serialNo) throws APIException {
        Intrinsics.checkNotNullParameter(serialNo, "serialNo");
        AirPurifierRequestAPIService apiService = getApiService();
        User user = LSApplication.Companion.getUser();
        LiveData<AirPurifierDashboardDetails> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observeAirPurifier(apiService.getDashboard(new AirPurifierStatus(user != null ? user.getId() : null, serialNo)), new Function0<AirPurifierDashboardDetails>() { // from class: com.livpure.safedrink.airpurifier.data.AirPurifierCommandsRespository$getDashboardDetails$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AirPurifierDashboardDetails invoke() {
                return new AirPurifierDashboardDetails(null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …Details(null) }\n        )");
        return fromPublisher;
    }
}

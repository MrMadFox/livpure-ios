package com.livpure.safedrink.ota.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.facebook.internal.NativeProtocol;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.ota.api.OTAotaService;
import com.livpure.safedrink.ota.data.model.MessageDetailsResponse;
import com.livpure.safedrink.ota.data.model.OTARequest;
import com.livpure.safedrink.ota.data.model.OTAUpdateDetailsResponse;
import com.livpure.safedrink.ota.data.model.firmwareRequest;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: OTARepository.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ<\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/livpure/safedrink/ota/data/OTARepository;", "", "()V", "otaOTAService", "Lcom/livpure/safedrink/ota/api/OTAotaService;", "getOtaOTAService", "()Lcom/livpure/safedrink/ota/api/OTAotaService;", "otaOTAService$delegate", "Lkotlin/Lazy;", "getFirmawareData", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/ota/data/model/OTAUpdateDetailsResponse;", "macId", "", NativeProtocol.WEB_DIALOG_ACTION, "roData", "getOTADetails", "Lcom/livpure/safedrink/ota/data/model/MessageDetailsResponse;", "productType", "hardwareVersion", "softwareVersion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OTARepository {
    private final Lazy otaOTAService$delegate = LazyKt.lazy(new Function0<OTAotaService>() { // from class: com.livpure.safedrink.ota.data.OTARepository$otaOTAService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final OTAotaService invoke() {
            return OTAotaService.Factory.getAPIOTAService();
        }
    });

    private final OTAotaService getOtaOTAService() {
        return (OTAotaService) this.otaOTAService$delegate.getValue();
    }

    public final LiveData<MessageDetailsResponse> getOTADetails(String productType, String macId, String action, String hardwareVersion, String softwareVersion, String roData) throws APIException {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(macId, "macId");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(hardwareVersion, "hardwareVersion");
        Intrinsics.checkNotNullParameter(softwareVersion, "softwareVersion");
        Intrinsics.checkNotNullParameter(roData, "roData");
        LiveData<MessageDetailsResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.otaObserve(getOtaOTAService().getOTADetails(new OTARequest(productType, action, macId, hardwareVersion, softwareVersion, roData)), new Function0<MessageDetailsResponse>() { // from class: com.livpure.safedrink.ota.data.OTARepository$getOTADetails$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MessageDetailsResponse invoke() {
                return new MessageDetailsResponse(null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …esponse(null) }\n        )");
        return fromPublisher;
    }

    public final LiveData<OTAUpdateDetailsResponse> getFirmawareData(String macId, String action, String roData) throws APIException {
        Intrinsics.checkNotNullParameter(macId, "macId");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(roData, "roData");
        LiveData<OTAUpdateDetailsResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.otaObserveData(getOtaOTAService().updateOTADetails(new firmwareRequest(action, macId, roData)), new Function0<OTAUpdateDetailsResponse>() { // from class: com.livpure.safedrink.ota.data.OTARepository$getFirmawareData$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OTAUpdateDetailsResponse invoke() {
                return new OTAUpdateDetailsResponse(null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …esponse(null) }\n        )");
        return fromPublisher;
    }
}

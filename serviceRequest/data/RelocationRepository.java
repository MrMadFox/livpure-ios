package com.livpure.safedrink.serviceRequest.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.koushikdutta.async.http.body.StringBody;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.livpure.safedrink.serviceRequest.api.MultipartRequestApiService;
import com.livpure.safedrink.serviceRequest.api.RelocationRequestAPIService;
import com.livpure.safedrink.serviceRequest.api.RelocationUpdateAddressAPIService;
import com.livpure.safedrink.serviceRequest.data.model.CityByPincodeRequest;
import com.livpure.safedrink.serviceRequest.data.model.CityByPincodeResponse;
import com.livpure.safedrink.serviceRequest.data.model.NewPlanRequest;
import com.livpure.safedrink.serviceRequest.data.model.NewPlanResponse;
import com.livpure.safedrink.serviceRequest.data.model.TrackOrderReq;
import com.livpure.safedrink.serviceRequest.data.model.TrackOrderRes;
import com.livpure.safedrink.serviceRequest.data.model.UpdateAddressRequest;
import com.livpure.safedrink.serviceRequest.data.model.UploadDocRequest;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
/* compiled from: RelocationRepository.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00142\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u00142\u0006\u0010!\u001a\u00020\"J\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00142\u0006\u0010%\u001a\u00020&J\u001a\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010(0\u00142\u0006\u0010)\u001a\u00020*R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011¨\u0006+"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/data/RelocationRepository;", "", "()V", "apiService", "Lcom/livpure/safedrink/serviceRequest/api/RelocationRequestAPIService;", "getApiService", "()Lcom/livpure/safedrink/serviceRequest/api/RelocationRequestAPIService;", "apiService$delegate", "Lkotlin/Lazy;", "multipartService", "Lcom/livpure/safedrink/serviceRequest/api/MultipartRequestApiService;", "getMultipartService", "()Lcom/livpure/safedrink/serviceRequest/api/MultipartRequestApiService;", "multipartService$delegate", "relocationUpdateApiService", "Lcom/livpure/safedrink/serviceRequest/api/RelocationUpdateAddressAPIService;", "getRelocationUpdateApiService", "()Lcom/livpure/safedrink/serviceRequest/api/RelocationUpdateAddressAPIService;", "relocationUpdateApiService$delegate", "getCityData", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/serviceRequest/data/model/CityByPincodeResponse;", "cityByPincodeRequest", "Lcom/livpure/safedrink/serviceRequest/data/model/CityByPincodeRequest;", "getFileExtension", "", "path", "showNewPlan", "Lcom/livpure/safedrink/serviceRequest/data/model/NewPlanResponse;", "newPlanRequest", "Lcom/livpure/safedrink/serviceRequest/data/model/NewPlanRequest;", "trackOrderStatus", "Lcom/livpure/safedrink/serviceRequest/data/model/TrackOrderRes;", "trackOrderReq", "Lcom/livpure/safedrink/serviceRequest/data/model/TrackOrderReq;", "updateAddressRelocation", "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "updateAddressRequest", "Lcom/livpure/safedrink/serviceRequest/data/model/UpdateAddressRequest;", "uploadDoc", "Lcom/livpure/safedrink/api/BaseDataHolder;", "uploadDocRequest", "Lcom/livpure/safedrink/serviceRequest/data/model/UploadDocRequest;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RelocationRepository {
    private final Lazy apiService$delegate = LazyKt.lazy(new Function0<RelocationRequestAPIService>() { // from class: com.livpure.safedrink.serviceRequest.data.RelocationRepository$apiService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RelocationRequestAPIService invoke() {
            return RelocationRequestAPIService.Factory.getRelocationRequestApiService();
        }
    });
    private final Lazy multipartService$delegate = LazyKt.lazy(new Function0<MultipartRequestApiService>() { // from class: com.livpure.safedrink.serviceRequest.data.RelocationRepository$multipartService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MultipartRequestApiService invoke() {
            return MultipartRequestApiService.Factory.getMultipartRequestApiService();
        }
    });
    private final Lazy relocationUpdateApiService$delegate = LazyKt.lazy(new Function0<RelocationUpdateAddressAPIService>() { // from class: com.livpure.safedrink.serviceRequest.data.RelocationRepository$relocationUpdateApiService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RelocationUpdateAddressAPIService invoke() {
            return RelocationUpdateAddressAPIService.Factory.getRelocationUpdateAddressApiService();
        }
    });

    private final RelocationRequestAPIService getApiService() {
        return (RelocationRequestAPIService) this.apiService$delegate.getValue();
    }

    private final MultipartRequestApiService getMultipartService() {
        return (MultipartRequestApiService) this.multipartService$delegate.getValue();
    }

    private final RelocationUpdateAddressAPIService getRelocationUpdateApiService() {
        return (RelocationUpdateAddressAPIService) this.relocationUpdateApiService$delegate.getValue();
    }

    public final LiveData<CityByPincodeResponse> getCityData(CityByPincodeRequest cityByPincodeRequest) {
        Intrinsics.checkNotNullParameter(cityByPincodeRequest, "cityByPincodeRequest");
        LiveData<CityByPincodeResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.checkForExceptionsAndObserveCityData(getApiService().getCityByPincode(cityByPincodeRequest)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …serveCityData()\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseV1Response> updateAddressRelocation(UpdateAddressRequest updateAddressRequest) {
        Intrinsics.checkNotNullParameter(updateAddressRequest, "updateAddressRequest");
        LiveData<BaseV1Response> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getRelocationUpdateApiService().updateAddress(updateAddressRequest), new Function0<BaseV1Response>() { // from class: com.livpure.safedrink.serviceRequest.data.RelocationRepository$updateAddressRelocation$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BaseV1Response invoke() {
                return new BaseV1Response(null, null, null, null, 15, null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …eV1Response() }\n        )");
        return fromPublisher;
    }

    public final LiveData<NewPlanResponse> showNewPlan(NewPlanRequest newPlanRequest) {
        Intrinsics.checkNotNullParameter(newPlanRequest, "newPlanRequest");
        LiveData<NewPlanResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.checkForExceptionsAndObservePlanData(getApiService().showNewPlan(newPlanRequest)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …servePlanData()\n        )");
        return fromPublisher;
    }

    public final LiveData<TrackOrderRes> trackOrderStatus(TrackOrderReq trackOrderReq) {
        Intrinsics.checkNotNullParameter(trackOrderReq, "trackOrderReq");
        LiveData<TrackOrderRes> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.checkForExceptionsAndObserveTrackOrder(getApiService().trackOrder(trackOrderReq)));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …rveTrackOrder()\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseDataHolder<Object>> uploadDoc(UploadDocRequest uploadDocRequest) {
        Intrinsics.checkNotNullParameter(uploadDocRequest, "uploadDocRequest");
        File front = uploadDocRequest.getFront();
        getFileExtension(front != null ? front.getPath() : null);
        File back = uploadDocRequest.getBack();
        getFileExtension(back != null ? back.getPath() : null);
        RequestBody create = RequestBody.Companion.create(String.valueOf(uploadDocRequest.getProofType()), MediaType.Companion.parse(StringBody.CONTENT_TYPE));
        RequestBody create2 = RequestBody.Companion.create(String.valueOf(uploadDocRequest.isPermanentAddress()), MediaType.Companion.parse(StringBody.CONTENT_TYPE));
        RequestBody.Companion companion = RequestBody.Companion;
        MediaType parse = MediaType.Companion.parse("multipart/form-data");
        File front2 = uploadDocRequest.getFront();
        Intrinsics.checkNotNull(front2);
        RequestBody create3 = companion.create(parse, front2);
        RequestBody.Companion companion2 = RequestBody.Companion;
        MediaType parse2 = MediaType.Companion.parse("multipart/form-data");
        File back2 = uploadDocRequest.getBack();
        Intrinsics.checkNotNull(back2);
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(getMultipartService().uploadDoc(create, create2, MultipartBody.Part.Companion.createFormData("front", uploadDocRequest.getFront().getName(), create3), MultipartBody.Part.Companion.createFormData("back", uploadDocRequest.getBack().getName(), companion2.create(parse2, back2)))));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }

    private final String getFileExtension(String str) {
        Intrinsics.checkNotNull(str);
        String file = new File(str).toString();
        Intrinsics.checkNotNullExpressionValue(file, "file.toString()");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) file, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default > 0) {
            String substring = file.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            System.out.println((Object) ("File extension is " + substring));
            return substring;
        }
        return "";
    }
}

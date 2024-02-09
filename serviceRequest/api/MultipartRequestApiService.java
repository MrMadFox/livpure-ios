package com.livpure.safedrink.serviceRequest.api;

import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.api.MultipartService;
import io.reactivex.Flowable;
import kotlin.Metadata;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
/* compiled from: MultipartRequestApiService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J<\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\nH'¨\u0006\r"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/api/MultipartRequestApiService;", "", "uploadDoc", "Lio/reactivex/Flowable;", "Lcom/livpure/safedrink/api/BaseDataHolder;", "proofType", "Lokhttp3/MultipartBody;", "Lokhttp3/RequestBody;", "isPermanentAddress", "fileFront", "Lokhttp3/MultipartBody$Part;", "fileBack", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface MultipartRequestApiService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST("v4/uploadUserDoc")
    Flowable<BaseDataHolder<Object>> uploadDoc(@Body MultipartBody multipartBody);

    @POST("v4/uploadUserDoc")
    @Multipart
    Flowable<BaseDataHolder<Object>> uploadDoc(@Part("proofType") RequestBody requestBody, @Part("isPermanentAddress") RequestBody requestBody2, @Part MultipartBody.Part part, @Part MultipartBody.Part part2);

    /* compiled from: MultipartRequestApiService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/api/MultipartRequestApiService$Factory;", "Lcom/livpure/safedrink/api/MultipartService;", "()V", "getMultipartRequestApiService", "Lcom/livpure/safedrink/serviceRequest/api/MultipartRequestApiService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends MultipartService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final MultipartRequestApiService getMultipartRequestApiService() {
            return (MultipartRequestApiService) new MultipartService.APIInterfaceFactory(this, MultipartRequestApiService.class).getAPIInterface();
        }
    }
}

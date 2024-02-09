package com.livpure.safedrink.subscription.kyc.api;

import com.livpure.safedrink.api.APIService;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.subscription.kyc.data.model.KYCUploadRequest;
import com.livpure.safedrink.subscription.kyc.data.model.S3CredentialsRequest;
import com.livpure.safedrink.subscription.kyc.data.model.S3CredentialsResponse;
import io.reactivex.Flowable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
/* compiled from: UploadKYCAPIService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J \u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\nH'¨\u0006\f"}, d2 = {"Lcom/livpure/safedrink/subscription/kyc/api/UploadKYCAPIService;", "", "getS3Credentials", "Lio/reactivex/Flowable;", "Lcom/livpure/safedrink/subscription/kyc/data/model/S3CredentialsResponse;", "credentialsRequest", "Lcom/livpure/safedrink/subscription/kyc/data/model/S3CredentialsRequest;", "updateKYCInformation", "Lcom/livpure/safedrink/api/BaseDataHolder;", "kycUploadRequest", "Lcom/livpure/safedrink/subscription/kyc/data/model/KYCUploadRequest;", "Factory", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface UploadKYCAPIService {
    public static final Factory Factory = Factory.$$INSTANCE;

    @POST("/getCredentials")
    Flowable<S3CredentialsResponse> getS3Credentials(@Body S3CredentialsRequest s3CredentialsRequest);

    @POST("/v2/aadharUpload")
    Flowable<BaseDataHolder<Object>> updateKYCInformation(@Body KYCUploadRequest kYCUploadRequest);

    /* compiled from: UploadKYCAPIService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/livpure/safedrink/subscription/kyc/api/UploadKYCAPIService$Factory;", "Lcom/livpure/safedrink/api/APIService;", "()V", "getUploadKYCAPIService", "Lcom/livpure/safedrink/subscription/kyc/api/UploadKYCAPIService;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends APIService {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
            super(null, 1, null);
        }

        public final UploadKYCAPIService getUploadKYCAPIService() {
            return (UploadKYCAPIService) new APIService.APIInterfaceFactory(this, UploadKYCAPIService.class).getAPIInterface();
        }
    }
}

package com.livpure.safedrink.subscription.kyc.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.subscription.kyc.api.UploadKYCAPIService;
import com.livpure.safedrink.subscription.kyc.data.model.KYCUploadRequest;
import com.livpure.safedrink.subscription.kyc.data.model.ProofType;
import com.livpure.safedrink.subscription.kyc.data.model.S3CredentialsRequest;
import com.livpure.safedrink.subscription.kyc.data.model.S3CredentialsResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: KYCRepository.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\rJ:\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f0\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/livpure/safedrink/subscription/kyc/data/KYCRepository;", "", "()V", "apiService", "Lcom/livpure/safedrink/subscription/kyc/api/UploadKYCAPIService;", "getApiService", "()Lcom/livpure/safedrink/subscription/kyc/api/UploadKYCAPIService;", "apiService$delegate", "Lkotlin/Lazy;", "getS3Credentials", "Landroidx/lifecycle/LiveData;", "Lcom/livpure/safedrink/subscription/kyc/data/model/S3CredentialsResponse;", "id", "", "updateKYCInformation", "Lcom/livpure/safedrink/api/BaseDataHolder;", "fileNames", "", "idProofType", "addressProofType", "salutation", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KYCRepository {
    private final Lazy apiService$delegate = LazyKt.lazy(new Function0<UploadKYCAPIService>() { // from class: com.livpure.safedrink.subscription.kyc.data.KYCRepository$apiService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UploadKYCAPIService invoke() {
            return UploadKYCAPIService.Factory.getUploadKYCAPIService();
        }
    });

    private final UploadKYCAPIService getApiService() {
        return (UploadKYCAPIService) this.apiService$delegate.getValue();
    }

    public static /* synthetic */ LiveData getS3Credentials$default(KYCRepository kYCRepository, String str, int i, Object obj) throws APIException {
        if ((i & 1) != 0) {
            str = "files-upload";
        }
        return kYCRepository.getS3Credentials(str);
    }

    public final LiveData<S3CredentialsResponse> getS3Credentials(String id) throws APIException {
        Intrinsics.checkNotNullParameter(id, "id");
        LiveData<S3CredentialsResponse> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.observe(getApiService().getS3Credentials(new S3CredentialsRequest(id)), new Function0<S3CredentialsResponse>() { // from class: com.livpure.safedrink.subscription.kyc.data.KYCRepository$getS3Credentials$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final S3CredentialsResponse invoke() {
                return new S3CredentialsResponse(null);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …esponse(null) }\n        )");
        return fromPublisher;
    }

    public final LiveData<BaseDataHolder<Object>> updateKYCInformation(List<String> fileNames, String idProofType, String addressProofType, String salutation) {
        Intrinsics.checkNotNullParameter(fileNames, "fileNames");
        Intrinsics.checkNotNullParameter(idProofType, "idProofType");
        Intrinsics.checkNotNullParameter(addressProofType, "addressProofType");
        Intrinsics.checkNotNullParameter(salutation, "salutation");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
        UploadKYCAPIService apiService = getApiService();
        User user = LSApplication.Companion.getUser();
        Intrinsics.checkNotNull(user);
        LiveData<BaseDataHolder<Object>> fromPublisher = LiveDataReactiveStreams.fromPublisher(APIUtilKt.validateAndObserve(apiService.updateKYCInformation(new KYCUploadRequest(user.getId(), fileNames, new ProofType(idProofType, fileNames.get(1), addressProofType, fileNames.get(0), simpleDateFormat.format(new Date())), StringsKt.contains((CharSequence) salutation, (CharSequence) "mr", true) ? "0002" : "0001", null, null, null, null, 240, null))));
        Intrinsics.checkNotNullExpressionValue(fromPublisher, "fromPublisher(\n         …ateAndObserve()\n        )");
        return fromPublisher;
    }
}

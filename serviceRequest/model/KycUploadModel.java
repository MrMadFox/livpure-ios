package com.livpure.safedrink.serviceRequest.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.serviceRequest.data.RelocationRepository;
import com.livpure.safedrink.serviceRequest.data.model.UploadDocRequest;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: KycUploadModel.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/model/KycUploadModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "relocationRepository", "Lcom/livpure/safedrink/serviceRequest/data/RelocationRepository;", "getRelocationRepository", "()Lcom/livpure/safedrink/serviceRequest/data/RelocationRepository;", "relocationRepository$delegate", "Lkotlin/Lazy;", "uploadResponse", "Landroidx/lifecycle/MediatorLiveData;", "", "uploadDoc", "Landroidx/lifecycle/LiveData;", "proofType", "isInstall", "", "imageFront", "Ljava/io/File;", "imageBack", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KycUploadModel extends MediatorViewModel {
    private final Lazy relocationRepository$delegate = LazyKt.lazy(new Function0<RelocationRepository>() { // from class: com.livpure.safedrink.serviceRequest.model.KycUploadModel$relocationRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RelocationRepository invoke() {
            return new RelocationRepository();
        }
    });
    private MediatorLiveData<String> uploadResponse = new MediatorLiveData<>();

    private final RelocationRepository getRelocationRepository() {
        return (RelocationRepository) this.relocationRepository$delegate.getValue();
    }

    public final LiveData<String> uploadDoc(String proofType, boolean z, File file, File file2) {
        Intrinsics.checkNotNullParameter(proofType, "proofType");
        if (LSApplication.Companion.isNetworkAvailable()) {
            observeAndTrack(getRelocationRepository().uploadDoc(new UploadDocRequest(proofType, Boolean.valueOf(z), file, file2)), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.KycUploadModel$$ExternalSyntheticLambda0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    KycUploadModel.m1140uploadDoc$lambda0(KycUploadModel.this, (BaseDataHolder) obj);
                }
            });
        }
        return this.uploadResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: uploadDoc$lambda-0  reason: not valid java name */
    public static final void m1140uploadDoc$lambda0(KycUploadModel this$0, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.uploadResponse.setValue(baseDataHolder.getMessage());
    }
}

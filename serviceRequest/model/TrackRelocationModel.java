package com.livpure.safedrink.serviceRequest.model;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.serviceRequest.data.RelocationRepository;
import com.livpure.safedrink.serviceRequest.data.model.TrackOrderReq;
import com.livpure.safedrink.serviceRequest.data.model.TrackOrderRes;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TrackRelocationModel.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\rR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/model/TrackRelocationModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "relocationRepository", "Lcom/livpure/safedrink/serviceRequest/data/RelocationRepository;", "getRelocationRepository", "()Lcom/livpure/safedrink/serviceRequest/data/RelocationRepository;", "relocationRepository$delegate", "Lkotlin/Lazy;", "trackRes", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/livpure/safedrink/serviceRequest/data/model/TrackOrderRes;", "trackOrder", "Landroidx/lifecycle/LiveData;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TrackRelocationModel extends MediatorViewModel {
    private final MediatorLiveData<TrackOrderRes> trackRes = new MediatorLiveData<>();
    private final Lazy relocationRepository$delegate = LazyKt.lazy(new Function0<RelocationRepository>() { // from class: com.livpure.safedrink.serviceRequest.model.TrackRelocationModel$relocationRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RelocationRepository invoke() {
            return new RelocationRepository();
        }
    });

    private final RelocationRepository getRelocationRepository() {
        return (RelocationRepository) this.relocationRepository$delegate.getValue();
    }

    public final LiveData<TrackOrderRes> trackOrder() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            User user = LSApplication.Companion.getUser();
            observeAndTrack(getRelocationRepository().trackOrderStatus(new TrackOrderReq(user != null ? user.getMobile() : null)), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.TrackRelocationModel$$ExternalSyntheticLambda0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TrackRelocationModel.m1175trackOrder$lambda0(TrackRelocationModel.this, (TrackOrderRes) obj);
                }
            });
        }
        return this.trackRes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: trackOrder$lambda-0  reason: not valid java name */
    public static final void m1175trackOrder$lambda0(TrackRelocationModel this$0, TrackOrderRes trackOrderRes) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.e("Track Res", String.valueOf(trackOrderRes));
        this$0.trackRes.setValue(trackOrderRes);
    }
}

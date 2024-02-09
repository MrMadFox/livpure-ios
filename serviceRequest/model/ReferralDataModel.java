package com.livpure.safedrink.serviceRequest.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.serviceRequest.data.LmsDevRepository;
import com.livpure.safedrink.serviceRequest.data.model.GetReferralRequest;
import com.livpure.safedrink.serviceRequest.data.model.GetReferralResponse;
import com.livpure.safedrink.serviceRequest.data.model.ResendVoucherRequest;
import com.livpure.safedrink.serviceRequest.data.model.ResendVoucherResponse;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReferralDataModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/model/ReferralDataModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "lmsDevRepository", "Lcom/livpure/safedrink/serviceRequest/data/LmsDevRepository;", "getLmsDevRepository", "()Lcom/livpure/safedrink/serviceRequest/data/LmsDevRepository;", "lmsDevRepository$delegate", "Lkotlin/Lazy;", "referralResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/livpure/safedrink/serviceRequest/data/model/GetReferralResponse;", "getReferralResponse", "()Landroidx/lifecycle/MutableLiveData;", "resendVoucherResponse", "Lcom/livpure/safedrink/serviceRequest/data/model/ResendVoucherResponse;", "getResendVoucherResponse", "getReferralData", "", "phoneNo", "", "resendVoucher", "id", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferralDataModel extends MediatorViewModel {
    private final Lazy lmsDevRepository$delegate = LazyKt.lazy(new Function0<LmsDevRepository>() { // from class: com.livpure.safedrink.serviceRequest.model.ReferralDataModel$lmsDevRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LmsDevRepository invoke() {
            return new LmsDevRepository();
        }
    });
    private final MutableLiveData<GetReferralResponse> referralResponse = new MutableLiveData<>();
    private final MutableLiveData<ResendVoucherResponse> resendVoucherResponse = new MutableLiveData<>();

    private final LmsDevRepository getLmsDevRepository() {
        return (LmsDevRepository) this.lmsDevRepository$delegate.getValue();
    }

    public final MutableLiveData<GetReferralResponse> getReferralResponse() {
        return this.referralResponse;
    }

    public final MutableLiveData<ResendVoucherResponse> getResendVoucherResponse() {
        return this.resendVoucherResponse;
    }

    public final void getReferralData(String str) {
        getLoading().setValue(true);
        if (LSApplication.Companion.isNetworkAvailable()) {
            try {
                observeAndTrack(getLmsDevRepository().getReferralData(new GetReferralRequest(str)), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.ReferralDataModel$$ExternalSyntheticLambda0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ReferralDataModel.m1154getReferralData$lambda0(ReferralDataModel.this, (GetReferralResponse) obj);
                    }
                });
                return;
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! We faced an issue while fetching your dashboard details at this time."));
                return;
            }
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getReferralData$lambda-0  reason: not valid java name */
    public static final void m1154getReferralData$lambda0(ReferralDataModel this$0, GetReferralResponse getReferralResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.referralResponse.setValue(getReferralResponse);
    }

    public final void resendVoucher(String str) {
        getLoading().setValue(true);
        if (LSApplication.Companion.isNetworkAvailable()) {
            try {
                observeAndTrack(getLmsDevRepository().resendVoucher(new ResendVoucherRequest(str)), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.ReferralDataModel$$ExternalSyntheticLambda1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ReferralDataModel.m1155resendVoucher$lambda1(ReferralDataModel.this, (ResendVoucherResponse) obj);
                    }
                });
                return;
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! We faced an issue while fetching your dashboard details at this time."));
                return;
            }
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: resendVoucher$lambda-1  reason: not valid java name */
    public static final void m1155resendVoucher$lambda1(ReferralDataModel this$0, ResendVoucherResponse resendVoucherResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        if (Intrinsics.areEqual(resendVoucherResponse != null ? resendVoucherResponse.getMessage() : null, "false")) {
            this$0.getLoading().setValue(false);
            this$0.resendVoucherResponse.setValue(resendVoucherResponse);
        }
    }
}

package com.livpure.safedrink.api;

import androidx.exifinterface.media.ExifInterface;
import com.livpure.safedrink.dispenser.data.models.DispenserDashboardDetailsResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DispenserResponseValidationResult.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/livpure/safedrink/api/DispenserResponseValidationResult;", "", "()V", "APIResolutionException", "FailedResponse", "SuccessfulResponse", "Lcom/livpure/safedrink/api/DispenserResponseValidationResult$APIResolutionException;", "Lcom/livpure/safedrink/api/DispenserResponseValidationResult$FailedResponse;", "Lcom/livpure/safedrink/api/DispenserResponseValidationResult$SuccessfulResponse;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class DispenserResponseValidationResult {
    public /* synthetic */ DispenserResponseValidationResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: DispenserResponseValidationResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/livpure/safedrink/api/DispenserResponseValidationResult$APIResolutionException;", "Lcom/livpure/safedrink/api/DispenserResponseValidationResult;", "()V", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class APIResolutionException extends DispenserResponseValidationResult {
        public static final APIResolutionException INSTANCE = new APIResolutionException();

        private APIResolutionException() {
            super(null);
        }
    }

    private DispenserResponseValidationResult() {
    }

    /* compiled from: DispenserResponseValidationResult.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/livpure/safedrink/api/DispenserResponseValidationResult$FailedResponse;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/livpure/safedrink/dispenser/data/models/DispenserDashboardDetailsResponse;", "Lcom/livpure/safedrink/api/DispenserResponseValidationResult;", "response", "(Lcom/livpure/safedrink/dispenser/data/models/DispenserDashboardDetailsResponse;)V", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class FailedResponse<T extends DispenserDashboardDetailsResponse> extends DispenserResponseValidationResult {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedResponse(T response) {
            super(null);
            Intrinsics.checkNotNullParameter(response, "response");
        }
    }

    /* compiled from: DispenserResponseValidationResult.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/livpure/safedrink/api/DispenserResponseValidationResult$SuccessfulResponse;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/livpure/safedrink/dispenser/data/models/DispenserDashboardDetailsResponse;", "Lcom/livpure/safedrink/api/DispenserResponseValidationResult;", "response", "(Lcom/livpure/safedrink/dispenser/data/models/DispenserDashboardDetailsResponse;)V", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class SuccessfulResponse<T extends DispenserDashboardDetailsResponse> extends DispenserResponseValidationResult {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SuccessfulResponse(T response) {
            super(null);
            Intrinsics.checkNotNullParameter(response, "response");
        }
    }
}

package com.livpure.safedrink.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.api.ApiException;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierDashboardDetailsResponse;
import com.livpure.safedrink.airpurifier.data.models.AirPurifierResponseImplementation;
import com.livpure.safedrink.api.AirPurifierResponseValidationResult;
import com.livpure.safedrink.api.DispenserResponseValidationResult;
import com.livpure.safedrink.api.V1ResponseValidationResult;
import com.livpure.safedrink.dispenser.data.models.DispenserDashboardDetailsResponse;
import com.livpure.safedrink.dispenser.data.models.DispenserResponseImplementation;
import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.livpure.safedrink.login.api.models.response.BaseV1ResponseImplementation;
import com.livpure.safedrink.ota.data.model.MessageDetailsResponse;
import com.livpure.safedrink.ota.data.model.OTAUpdateDetailsResponse;
import com.livpure.safedrink.serviceRequest.data.Models.ServiceRequestResponse;
import com.livpure.safedrink.serviceRequest.data.model.CityByPincodeResponse;
import com.livpure.safedrink.serviceRequest.data.model.FreshdeskHistory;
import com.livpure.safedrink.serviceRequest.data.model.NewPlanResponse;
import com.livpure.safedrink.serviceRequest.data.model.ServiceHistory;
import com.livpure.safedrink.serviceRequest.data.model.TrackOrderRes;
import com.livpure.safedrink.subscription.address.data.model.ServiceableAreaItem;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: APIUtil.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001\u001a\u001a\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\u001a\u001a\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u001a\u001a\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\u001a\u001a\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001\u001a\u001a\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\u001a\n\u0010\u000e\u001a\u00020\u000f*\u00020\u0010\u001a\u001b\u0010\u0011\u001a\u00020\u000f\"\b\b\u0000\u0010\u0012*\u00020\u0013*\u0004\u0018\u0001H\u0012¢\u0006\u0002\u0010\u0014\u001a.\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0001\"\b\b\u0000\u0010\u0012*\u00020\u0016*\b\u0012\u0004\u0012\u0002H\u00120\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0018\u001a.\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0001\"\b\b\u0000\u0010\u0012*\u00020\u001a*\b\u0012\u0004\u0012\u0002H\u00120\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0018\u001a.\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0001\"\b\b\u0000\u0010\u0012*\u00020\u001c*\b\u0012\u0004\u0012\u0002H\u00120\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0018\u001a.\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0001\"\b\b\u0000\u0010\u0012*\u00020\u001e*\b\u0012\u0004\u0012\u0002H\u00120\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0018\u001a.\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0001\"\b\b\u0000\u0010\u0012*\u00020 *\b\u0012\u0004\u0012\u0002H\u00120\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0018\u001ao\u0010!\u001a\u00020\"\"\b\b\u0000\u0010\u0012*\u00020\u0016*\u0004\u0018\u0001H\u00122!\u0010#\u001a\u001d\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\"0$2!\u0010(\u001a\u001d\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\"0$2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0\u0018¢\u0006\u0002\u0010*\u001ao\u0010+\u001a\u00020\"\"\b\b\u0000\u0010\u0012*\u00020\u001a*\u0004\u0018\u0001H\u00122!\u0010#\u001a\u001d\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\"0$2!\u0010(\u001a\u001d\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\"0$2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0\u0018¢\u0006\u0002\u0010,\u001a\u001b\u0010-\u001a\u00020.\"\b\b\u0000\u0010\u0012*\u00020\u001a*\u0004\u0018\u0001H\u0012¢\u0006\u0002\u0010/\u001a\u001b\u0010-\u001a\u000200\"\b\b\u0000\u0010\u0012*\u00020\u001c*\u0004\u0018\u0001H\u0012¢\u0006\u0002\u00101\u001a\u001b\u0010-\u001a\u000202\"\b\b\u0000\u0010\u0012*\u00020\u0016*\u0004\u0018\u0001H\u0012¢\u0006\u0002\u00103\u001a'\u0010-\u001a\u0002H\u0012\"\u0004\b\u0000\u00104\"\u000e\b\u0001\u0010\u0012*\b\u0012\u0004\u0012\u0002H405*\u0004\u0018\u0001H\u0012¢\u0006\u0002\u00106\u001a(\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u0012050\u0001\"\u0004\b\u0000\u0010\u0012*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u0012050\u0001\u001a\u001a\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\u0001*\n\u0012\u0006\u0012\u0004\u0018\u0001090\u0001¨\u0006:"}, d2 = {"checkForExceptionsAndObserve", "Lio/reactivex/Flowable;", "", "Lcom/livpure/safedrink/subscription/address/data/model/ServiceableAreaItem;", "checkForExceptionsAndObserveCityData", "Lcom/livpure/safedrink/serviceRequest/data/model/CityByPincodeResponse;", "checkForExceptionsAndObservePlanData", "Lcom/livpure/safedrink/serviceRequest/data/model/NewPlanResponse;", "checkForExceptionsAndObserveService", "Lcom/livpure/safedrink/serviceRequest/data/Models/ServiceRequestResponse;", "checkForExceptionsAndObserveServiceHistory", "Lcom/livpure/safedrink/serviceRequest/data/model/ServiceHistory;", "checkForExceptionsAndObserveTrackOrder", "Lcom/livpure/safedrink/serviceRequest/data/model/TrackOrderRes;", "isNetworkConnected", "", "Landroid/content/Context;", "isOkay", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/livpure/safedrink/api/BaseDTO;", "(Lcom/livpure/safedrink/api/BaseDTO;)Z", "observe", "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "nullDataObjectConstructor", "Lkotlin/Function0;", "observeAirPurifier", "Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDashboardDetailsResponse;", "observeDispenser", "Lcom/livpure/safedrink/dispenser/data/models/DispenserDashboardDetailsResponse;", "otaObserve", "Lcom/livpure/safedrink/ota/data/model/MessageDetailsResponse;", "otaObserveData", "Lcom/livpure/safedrink/ota/data/model/OTAUpdateDetailsResponse;", "processResponseWithAPIException", "", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "response", "onFailure", "onAPIException", "(Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "processResponseWithAPIExceptionForAir", "(Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDashboardDetailsResponse;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "validate", "Lcom/livpure/safedrink/api/AirPurifierResponseValidationResult;", "(Lcom/livpure/safedrink/airpurifier/data/models/AirPurifierDashboardDetailsResponse;)Lcom/livpure/safedrink/api/AirPurifierResponseValidationResult;", "Lcom/livpure/safedrink/api/DispenserResponseValidationResult;", "(Lcom/livpure/safedrink/dispenser/data/models/DispenserDashboardDetailsResponse;)Lcom/livpure/safedrink/api/DispenserResponseValidationResult;", "Lcom/livpure/safedrink/api/V1ResponseValidationResult;", "(Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;)Lcom/livpure/safedrink/api/V1ResponseValidationResult;", ExifInterface.LATITUDE_SOUTH, "Lcom/livpure/safedrink/api/BaseDataHolder;", "(Lcom/livpure/safedrink/api/BaseDataHolder;)Lcom/livpure/safedrink/api/BaseDataHolder;", "validateAndObserve", "validateFreshdesk", "Lcom/livpure/safedrink/serviceRequest/data/model/FreshdeskHistory;", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class APIUtilKt {
    public static final boolean isNetworkConnected(Context context) {
        NetworkCapabilities networkCapabilities;
        Intrinsics.checkNotNullParameter(context, "<this>");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT < 23) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    return false;
                }
                return activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 0;
            }
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return false;
            }
            return networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(1);
        }
        return false;
    }

    public static final <T> Flowable<BaseDataHolder<T>> validateAndObserve(Flowable<BaseDataHolder<T>> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "<this>");
        final BaseDataHolder baseDataHolder = new BaseDataHolder(null);
        Flowable<BaseDataHolder<T>> onErrorReturn = flowable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.livpure.safedrink.api.APIUtilKt$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                BaseDataHolder m298validateAndObserve$lambda0;
                m298validateAndObserve$lambda0 = APIUtilKt.m298validateAndObserve$lambda0((BaseDataHolder) obj);
                return m298validateAndObserve$lambda0;
            }
        }).onErrorReturn(new Function() { // from class: com.livpure.safedrink.api.APIUtilKt$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                BaseDataHolder m299validateAndObserve$lambda2;
                m299validateAndObserve$lambda2 = APIUtilKt.m299validateAndObserve$lambda2(BaseDataHolder.this, (Throwable) obj);
                return m299validateAndObserve$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "this.observeOn(AndroidSc…          }\n            }");
        return onErrorReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: validateAndObserve$lambda-0  reason: not valid java name */
    public static final BaseDataHolder m298validateAndObserve$lambda0(BaseDataHolder it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return validate(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: validateAndObserve$lambda-2  reason: not valid java name */
    public static final BaseDataHolder m299validateAndObserve$lambda2(BaseDataHolder errorResponse, Throwable it) {
        Intrinsics.checkNotNullParameter(errorResponse, "$errorResponse");
        Intrinsics.checkNotNullParameter(it, "it");
        errorResponse.setMessage(it.getMessage());
        return errorResponse;
    }

    public static final <T extends MessageDetailsResponse> Flowable<T> otaObserve(Flowable<T> flowable, final Function0<? extends T> nullDataObjectConstructor) throws APIException {
        Intrinsics.checkNotNullParameter(flowable, "<this>");
        Intrinsics.checkNotNullParameter(nullDataObjectConstructor, "nullDataObjectConstructor");
        Flowable<T> onErrorReturn = flowable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).onErrorReturn(new Function() { // from class: com.livpure.safedrink.api.APIUtilKt$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                MessageDetailsResponse m296otaObserve$lambda4;
                m296otaObserve$lambda4 = APIUtilKt.m296otaObserve$lambda4(Function0.this, (Throwable) obj);
                return m296otaObserve$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "this\n            .observ…          }\n            }");
        return onErrorReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: otaObserve$lambda-4  reason: not valid java name */
    public static final MessageDetailsResponse m296otaObserve$lambda4(Function0 nullDataObjectConstructor, Throwable it) {
        Intrinsics.checkNotNullParameter(nullDataObjectConstructor, "$nullDataObjectConstructor");
        Intrinsics.checkNotNullParameter(it, "it");
        if ((it instanceof UnknownHostException) || (it instanceof SocketTimeoutException)) {
            MessageDetailsResponse messageDetailsResponse = (MessageDetailsResponse) nullDataObjectConstructor.invoke();
            messageDetailsResponse.setApiException(true);
            return messageDetailsResponse;
        }
        String message = it.getMessage();
        if (message == null) {
            message = "Oops! There was an issue contacting our servers. Please try again in some time.";
        }
        throw new APIException(message);
    }

    public static final <T extends OTAUpdateDetailsResponse> Flowable<T> otaObserveData(Flowable<T> flowable, final Function0<? extends T> nullDataObjectConstructor) throws APIException {
        Intrinsics.checkNotNullParameter(flowable, "<this>");
        Intrinsics.checkNotNullParameter(nullDataObjectConstructor, "nullDataObjectConstructor");
        Flowable<T> onErrorReturn = flowable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).onErrorReturn(new Function() { // from class: com.livpure.safedrink.api.APIUtilKt$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                OTAUpdateDetailsResponse m297otaObserveData$lambda6;
                m297otaObserveData$lambda6 = APIUtilKt.m297otaObserveData$lambda6(Function0.this, (Throwable) obj);
                return m297otaObserveData$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "this\n            .observ…          }\n            }");
        return onErrorReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: otaObserveData$lambda-6  reason: not valid java name */
    public static final OTAUpdateDetailsResponse m297otaObserveData$lambda6(Function0 nullDataObjectConstructor, Throwable it) {
        Intrinsics.checkNotNullParameter(nullDataObjectConstructor, "$nullDataObjectConstructor");
        Intrinsics.checkNotNullParameter(it, "it");
        if ((it instanceof UnknownHostException) || (it instanceof SocketTimeoutException)) {
            OTAUpdateDetailsResponse oTAUpdateDetailsResponse = (OTAUpdateDetailsResponse) nullDataObjectConstructor.invoke();
            oTAUpdateDetailsResponse.setApiException(true);
            return oTAUpdateDetailsResponse;
        }
        String message = it.getMessage();
        if (message == null) {
            message = "Oops! There was an issue contacting our servers. Please try again in some time.";
        }
        throw new APIException(message);
    }

    public static final <T extends BaseV1Response> Flowable<T> observe(Flowable<T> flowable, final Function0<? extends T> nullDataObjectConstructor) throws APIException {
        Intrinsics.checkNotNullParameter(flowable, "<this>");
        Intrinsics.checkNotNullParameter(nullDataObjectConstructor, "nullDataObjectConstructor");
        Flowable<T> onErrorReturn = flowable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).onErrorReturn(new Function() { // from class: com.livpure.safedrink.api.APIUtilKt$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                BaseV1Response m293observe$lambda8;
                m293observe$lambda8 = APIUtilKt.m293observe$lambda8(Function0.this, (Throwable) obj);
                return m293observe$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "this\n            .observ…          }\n            }");
        return onErrorReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observe$lambda-8  reason: not valid java name */
    public static final BaseV1Response m293observe$lambda8(Function0 nullDataObjectConstructor, Throwable it) {
        Intrinsics.checkNotNullParameter(nullDataObjectConstructor, "$nullDataObjectConstructor");
        Intrinsics.checkNotNullParameter(it, "it");
        if ((it instanceof UnknownHostException) || (it instanceof SocketTimeoutException) || (it instanceof ApiException)) {
            BaseV1Response baseV1Response = (BaseV1Response) nullDataObjectConstructor.invoke();
            baseV1Response.setApiException(true);
            return baseV1Response;
        }
        String message = it.getMessage();
        if (message == null) {
            message = "Oops! There was an issue contacting our servers. Please try again in some time.";
        }
        throw new APIException(message);
    }

    public static final <T extends AirPurifierDashboardDetailsResponse> Flowable<T> observeAirPurifier(Flowable<T> flowable, final Function0<? extends T> nullDataObjectConstructor) throws APIException {
        Intrinsics.checkNotNullParameter(flowable, "<this>");
        Intrinsics.checkNotNullParameter(nullDataObjectConstructor, "nullDataObjectConstructor");
        Flowable<T> onErrorReturn = flowable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).onErrorReturn(new Function() { // from class: com.livpure.safedrink.api.APIUtilKt$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AirPurifierDashboardDetailsResponse m294observeAirPurifier$lambda10;
                m294observeAirPurifier$lambda10 = APIUtilKt.m294observeAirPurifier$lambda10(Function0.this, (Throwable) obj);
                return m294observeAirPurifier$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "this\n            .observ…          }\n            }");
        return onErrorReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observeAirPurifier$lambda-10  reason: not valid java name */
    public static final AirPurifierDashboardDetailsResponse m294observeAirPurifier$lambda10(Function0 nullDataObjectConstructor, Throwable it) {
        Intrinsics.checkNotNullParameter(nullDataObjectConstructor, "$nullDataObjectConstructor");
        Intrinsics.checkNotNullParameter(it, "it");
        if ((it instanceof UnknownHostException) || (it instanceof SocketTimeoutException)) {
            AirPurifierDashboardDetailsResponse airPurifierDashboardDetailsResponse = (AirPurifierDashboardDetailsResponse) nullDataObjectConstructor.invoke();
            airPurifierDashboardDetailsResponse.setApiException(true);
            return airPurifierDashboardDetailsResponse;
        }
        String message = it.getMessage();
        if (message == null) {
            message = "Oops! There was an issue contacting our servers. Please try again in some time.";
        }
        throw new APIException(message);
    }

    public static final <T extends DispenserDashboardDetailsResponse> Flowable<T> observeDispenser(Flowable<T> flowable, final Function0<? extends T> nullDataObjectConstructor) throws APIException {
        Intrinsics.checkNotNullParameter(flowable, "<this>");
        Intrinsics.checkNotNullParameter(nullDataObjectConstructor, "nullDataObjectConstructor");
        Flowable<T> onErrorReturn = flowable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).onErrorReturn(new Function() { // from class: com.livpure.safedrink.api.APIUtilKt$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DispenserDashboardDetailsResponse m295observeDispenser$lambda12;
                m295observeDispenser$lambda12 = APIUtilKt.m295observeDispenser$lambda12(Function0.this, (Throwable) obj);
                return m295observeDispenser$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "this\n            .observ…          }\n            }");
        return onErrorReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observeDispenser$lambda-12  reason: not valid java name */
    public static final DispenserDashboardDetailsResponse m295observeDispenser$lambda12(Function0 nullDataObjectConstructor, Throwable it) {
        Intrinsics.checkNotNullParameter(nullDataObjectConstructor, "$nullDataObjectConstructor");
        Intrinsics.checkNotNullParameter(it, "it");
        if ((it instanceof UnknownHostException) || (it instanceof SocketTimeoutException)) {
            DispenserDashboardDetailsResponse dispenserDashboardDetailsResponse = (DispenserDashboardDetailsResponse) nullDataObjectConstructor.invoke();
            dispenserDashboardDetailsResponse.setApiException(true);
            return dispenserDashboardDetailsResponse;
        }
        String message = it.getMessage();
        if (message == null) {
            message = "Oops! There was an issue contacting our servers. Please try again in some time.";
        }
        throw new APIException(message);
    }

    public static final Flowable<ServiceHistory> checkForExceptionsAndObserveServiceHistory(Flowable<ServiceHistory> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "<this>");
        Flowable<ServiceHistory> onErrorReturn = flowable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).onErrorReturn(new Function() { // from class: com.livpure.safedrink.api.APIUtilKt$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ServiceHistory m291checkForExceptionsAndObserveServiceHistory$lambda13;
                m291checkForExceptionsAndObserveServiceHistory$lambda13 = APIUtilKt.m291checkForExceptionsAndObserveServiceHistory$lambda13((Throwable) obj);
                return m291checkForExceptionsAndObserveServiceHistory$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "this\n        .observeOn(…in some time.\")\n        }");
        return onErrorReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkForExceptionsAndObserveServiceHistory$lambda-13  reason: not valid java name */
    public static final ServiceHistory m291checkForExceptionsAndObserveServiceHistory$lambda13(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String message = it.getMessage();
        if (message == null) {
            message = "Oops! There was an issue contacting our servers. Please try again in some time.";
        }
        throw new APIException(message);
    }

    public static final Flowable<CityByPincodeResponse> checkForExceptionsAndObserveCityData(Flowable<CityByPincodeResponse> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "<this>");
        Flowable<CityByPincodeResponse> onErrorReturn = flowable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).onErrorReturn(new Function() { // from class: com.livpure.safedrink.api.APIUtilKt$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CityByPincodeResponse m288checkForExceptionsAndObserveCityData$lambda14;
                m288checkForExceptionsAndObserveCityData$lambda14 = APIUtilKt.m288checkForExceptionsAndObserveCityData$lambda14((Throwable) obj);
                return m288checkForExceptionsAndObserveCityData$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "this\n        .observeOn(…in some time.\")\n        }");
        return onErrorReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkForExceptionsAndObserveCityData$lambda-14  reason: not valid java name */
    public static final CityByPincodeResponse m288checkForExceptionsAndObserveCityData$lambda14(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String message = it.getMessage();
        if (message == null) {
            message = "Oops! There was an issue contacting our servers. Please try again in some time.";
        }
        throw new APIException(message);
    }

    public static final Flowable<NewPlanResponse> checkForExceptionsAndObservePlanData(Flowable<NewPlanResponse> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "<this>");
        Flowable<NewPlanResponse> onErrorReturn = flowable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).onErrorReturn(new Function() { // from class: com.livpure.safedrink.api.APIUtilKt$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                NewPlanResponse m289checkForExceptionsAndObservePlanData$lambda15;
                m289checkForExceptionsAndObservePlanData$lambda15 = APIUtilKt.m289checkForExceptionsAndObservePlanData$lambda15((Throwable) obj);
                return m289checkForExceptionsAndObservePlanData$lambda15;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "this\n        .observeOn(…in some time.\")\n        }");
        return onErrorReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkForExceptionsAndObservePlanData$lambda-15  reason: not valid java name */
    public static final NewPlanResponse m289checkForExceptionsAndObservePlanData$lambda15(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String message = it.getMessage();
        if (message == null) {
            message = "Oops! There was an issue contacting our servers. Please try again in some time.";
        }
        throw new APIException(message);
    }

    public static final Flowable<TrackOrderRes> checkForExceptionsAndObserveTrackOrder(Flowable<TrackOrderRes> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "<this>");
        Flowable<TrackOrderRes> onErrorReturn = flowable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).onErrorReturn(new Function() { // from class: com.livpure.safedrink.api.APIUtilKt$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                TrackOrderRes m292checkForExceptionsAndObserveTrackOrder$lambda16;
                m292checkForExceptionsAndObserveTrackOrder$lambda16 = APIUtilKt.m292checkForExceptionsAndObserveTrackOrder$lambda16((Throwable) obj);
                return m292checkForExceptionsAndObserveTrackOrder$lambda16;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "this\n        .observeOn(…in some time.\")\n        }");
        return onErrorReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkForExceptionsAndObserveTrackOrder$lambda-16  reason: not valid java name */
    public static final TrackOrderRes m292checkForExceptionsAndObserveTrackOrder$lambda16(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String message = it.getMessage();
        if (message == null) {
            message = "Oops! There was an issue contacting our servers. Please try again in some time.";
        }
        throw new APIException(message);
    }

    public static final Flowable<FreshdeskHistory> validateFreshdesk(Flowable<FreshdeskHistory> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "<this>");
        Flowable<FreshdeskHistory> onErrorReturn = flowable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).onErrorReturn(new Function() { // from class: com.livpure.safedrink.api.APIUtilKt$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                FreshdeskHistory m300validateFreshdesk$lambda17;
                m300validateFreshdesk$lambda17 = APIUtilKt.m300validateFreshdesk$lambda17((Throwable) obj);
                return m300validateFreshdesk$lambda17;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "this\n            .observ…         */\n            }");
        return onErrorReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: validateFreshdesk$lambda-17  reason: not valid java name */
    public static final FreshdeskHistory m300validateFreshdesk$lambda17(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNull(null);
        return new FreshdeskHistory("false", 0, "Oops! There was an issue contacting our servers. Please try again in some time.", null);
    }

    public static final Flowable<ServiceRequestResponse> checkForExceptionsAndObserveService(Flowable<ServiceRequestResponse> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "<this>");
        Flowable<ServiceRequestResponse> onErrorReturn = flowable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).onErrorReturn(new Function() { // from class: com.livpure.safedrink.api.APIUtilKt$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ServiceRequestResponse m290checkForExceptionsAndObserveService$lambda18;
                m290checkForExceptionsAndObserveService$lambda18 = APIUtilKt.m290checkForExceptionsAndObserveService$lambda18((Throwable) obj);
                return m290checkForExceptionsAndObserveService$lambda18;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "this\n            .observ…ome time.\")\n            }");
        return onErrorReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkForExceptionsAndObserveService$lambda-18  reason: not valid java name */
    public static final ServiceRequestResponse m290checkForExceptionsAndObserveService$lambda18(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String message = it.getMessage();
        if (message == null) {
            message = "Oops! There was an issue contacting our servers. Please try again in some time.";
        }
        throw new APIException(message);
    }

    public static final Flowable<List<ServiceableAreaItem>> checkForExceptionsAndObserve(Flowable<List<ServiceableAreaItem>> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "<this>");
        final ArrayList arrayList = new ArrayList();
        Flowable<List<ServiceableAreaItem>> onErrorReturn = flowable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).onErrorReturn(new Function() { // from class: com.livpure.safedrink.api.APIUtilKt$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m287checkForExceptionsAndObserve$lambda20;
                m287checkForExceptionsAndObserve$lambda20 = APIUtilKt.m287checkForExceptionsAndObserve$lambda20(arrayList, (Throwable) obj);
                return m287checkForExceptionsAndObserve$lambda20;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "this\n            .observ…          }\n            }");
        return onErrorReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkForExceptionsAndObserve$lambda-20  reason: not valid java name */
    public static final List m287checkForExceptionsAndObserve$lambda20(List errorData, Throwable it) {
        Intrinsics.checkNotNullParameter(errorData, "$errorData");
        Intrinsics.checkNotNullParameter(it, "it");
        errorData.add(new ServiceableAreaItem(null, null, null, it.getMessage()));
        return errorData;
    }

    public static final <T extends BaseDTO> boolean isOkay(T t) {
        return t != null && t.getStatusCode() >= 200 && t.getStatusCode() < 300;
    }

    public static final <S, T extends BaseDataHolder<S>> T validate(T t) {
        String str;
        if (isOkay(t)) {
            if ((t != null ? t.getData() : null) != null) {
                return t;
            }
        }
        String message = t != null ? t.getMessage() : null;
        if (message == null || message.length() == 0) {
            str = "Oops! Looks like we faced an issue there. Please try again later.";
        } else {
            Intrinsics.checkNotNull(t);
            str = t.getMessage();
        }
        throw new Exception(str);
    }

    public static final <T extends AirPurifierDashboardDetailsResponse> AirPurifierResponseValidationResult validate(T t) {
        AirPurifierResponseValidationResult.FailedResponse failedResponse;
        if (t != null) {
            if (Intrinsics.areEqual((Object) t.getApiException(), (Object) true)) {
                failedResponse = AirPurifierResponseValidationResult.APIResolutionException.INSTANCE;
            } else if (Intrinsics.areEqual((Object) t.getStatus(), (Object) true)) {
                failedResponse = new AirPurifierResponseValidationResult.SuccessfulResponse(t);
            } else {
                failedResponse = new AirPurifierResponseValidationResult.FailedResponse(t);
            }
            if (failedResponse != null) {
                return failedResponse;
            }
        }
        AirPurifierResponseImplementation airPurifierResponseImplementation = new AirPurifierResponseImplementation(null);
        airPurifierResponseImplementation.setMessage("Oops! We faced an issue with this request, please try again later");
        airPurifierResponseImplementation.setStatus(false);
        airPurifierResponseImplementation.setApiException(false);
        return new AirPurifierResponseValidationResult.FailedResponse(airPurifierResponseImplementation);
    }

    public static final <T extends DispenserDashboardDetailsResponse> DispenserResponseValidationResult validate(T t) {
        DispenserResponseValidationResult.FailedResponse failedResponse;
        if (t != null) {
            if (Intrinsics.areEqual((Object) t.getApiException(), (Object) true)) {
                failedResponse = DispenserResponseValidationResult.APIResolutionException.INSTANCE;
            } else if (Intrinsics.areEqual((Object) t.getStatus(), (Object) true)) {
                failedResponse = new DispenserResponseValidationResult.SuccessfulResponse(t);
            } else {
                failedResponse = new DispenserResponseValidationResult.FailedResponse(t);
            }
            if (failedResponse != null) {
                return failedResponse;
            }
        }
        DispenserResponseImplementation dispenserResponseImplementation = new DispenserResponseImplementation(null);
        dispenserResponseImplementation.setMessage("Oops! We faced an issue with this request, please try again later");
        dispenserResponseImplementation.setStatus(false);
        dispenserResponseImplementation.setApiException(false);
        return new DispenserResponseValidationResult.FailedResponse(dispenserResponseImplementation);
    }

    public static final <T extends BaseV1Response> V1ResponseValidationResult validate(T t) {
        V1ResponseValidationResult.FailedResponse failedResponse;
        if (t != null) {
            if (Intrinsics.areEqual((Object) t.getApiException(), (Object) true)) {
                failedResponse = V1ResponseValidationResult.APIResolutionException.INSTANCE;
            } else if (Intrinsics.areEqual((Object) t.getStatus(), (Object) true)) {
                failedResponse = new V1ResponseValidationResult.SuccessfulResponse(t);
            } else {
                failedResponse = new V1ResponseValidationResult.FailedResponse(t);
            }
            if (failedResponse != null) {
                return failedResponse;
            }
        }
        BaseV1ResponseImplementation baseV1ResponseImplementation = new BaseV1ResponseImplementation(null);
        baseV1ResponseImplementation.setMessage("Oops! We faced an issue with this request, please try again later");
        baseV1ResponseImplementation.setStatus(false);
        baseV1ResponseImplementation.setApiException(false);
        return new V1ResponseValidationResult.FailedResponse(baseV1ResponseImplementation);
    }

    public static final <T extends BaseV1Response> void processResponseWithAPIException(T t, Function1<? super T, Unit> onSuccess, Function1<? super T, Unit> onFailure, Function0<Unit> onAPIException) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        Intrinsics.checkNotNullParameter(onAPIException, "onAPIException");
        V1ResponseValidationResult validate = validate(t);
        if (Intrinsics.areEqual(validate, V1ResponseValidationResult.APIResolutionException.INSTANCE)) {
            onAPIException.invoke();
        } else if (validate instanceof V1ResponseValidationResult.FailedResponse) {
            Intrinsics.checkNotNull(t);
            onFailure.invoke(t);
        } else if (validate instanceof V1ResponseValidationResult.SuccessfulResponse) {
            Intrinsics.checkNotNull(t);
            onSuccess.invoke(t);
        }
    }

    public static final <T extends AirPurifierDashboardDetailsResponse> void processResponseWithAPIExceptionForAir(T t, Function1<? super T, Unit> onSuccess, Function1<? super T, Unit> onFailure, Function0<Unit> onAPIException) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        Intrinsics.checkNotNullParameter(onAPIException, "onAPIException");
        AirPurifierResponseValidationResult validate = validate(t);
        if (Intrinsics.areEqual(validate, AirPurifierResponseValidationResult.APIResolutionException.INSTANCE)) {
            onAPIException.invoke();
        } else if (validate instanceof AirPurifierResponseValidationResult.FailedResponse) {
            Intrinsics.checkNotNull(t);
            onFailure.invoke(t);
        } else if (validate instanceof AirPurifierResponseValidationResult.SuccessfulResponse) {
            Intrinsics.checkNotNull(t);
            onSuccess.invoke(t);
        }
    }

    private static final <T extends DispenserDashboardDetailsResponse> void processResponseWithAPIExceptionForAir$processResponseWithAPIExceptionForDispense(T t, Function1<? super T, Unit> function1, Function1<? super T, Unit> function12, Function0<Unit> function0) {
        DispenserResponseValidationResult validate = validate(t);
        if (Intrinsics.areEqual(validate, DispenserResponseValidationResult.APIResolutionException.INSTANCE)) {
            function0.invoke();
        } else if (validate instanceof DispenserResponseValidationResult.FailedResponse) {
            Intrinsics.checkNotNull(t);
            function12.invoke(t);
        } else if (validate instanceof DispenserResponseValidationResult.SuccessfulResponse) {
            Intrinsics.checkNotNull(t);
            function1.invoke(t);
        }
    }
}

package com.livpure.safedrink.serviceRequest.model;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.facebook.share.internal.ShareConstants;
import com.livpure.safedrink.LSHConfig;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.segment.SegmentProperties;
import com.livpure.safedrink.serviceRequest.data.HumsarServicerequestRepository;
import com.livpure.safedrink.serviceRequest.data.Models.ServiceLogs;
import com.livpure.safedrink.serviceRequest.data.Models.ServiceRequestData;
import com.livpure.safedrink.serviceRequest.data.Models.ServiceRequestResponse;
import com.livpure.safedrink.serviceRequest.data.ServicerequestRepository;
import com.livpure.safedrink.serviceRequest.data.model.CustomerVoiceRequest;
import com.livpure.safedrink.serviceRequest.data.model.CustomerVoiceResponse;
import com.livpure.safedrink.serviceRequest.data.model.HumsarServiceRequest;
import com.livpure.safedrink.serviceRequest.data.model.OTPRequest;
import com.livpure.safedrink.serviceRequest.data.model.RefreshRechargeRequest;
import com.livpure.safedrink.serviceRequest.data.model.RefreshRechargeResponse;
import com.livpure.safedrink.serviceRequest.data.model.ServiceRequestOtherData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: RaiseServiceRequestModel.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u000bJ\u0006\u0010-\u001a\u00020*J\u000e\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u000bJ\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000bJ\u000e\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020\u000bJ\u0016\u00105\u001a\u00020*2\u0006\u00104\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000bJ\u001e\u00107\u001a\u00020*2\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000bJH\u0010;\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0=\u0018\u00010<2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u000bJH\u0010A\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0=\u0018\u00010<2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u000bJ\u000e\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020\u000bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0007R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0007R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 ¨\u0006D"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/model/RaiseServiceRequestModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "customerVoiceReasonResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/livpure/safedrink/serviceRequest/data/model/CustomerVoiceResponse;", "getCustomerVoiceReasonResponse", "()Landroidx/lifecycle/MutableLiveData;", "customerVoiceSubReasonResponse", "getCustomerVoiceSubReasonResponse", "dateTimeError", "", "getDateTimeError", "humsarServicerequestRepository", "Lcom/livpure/safedrink/serviceRequest/data/HumsarServicerequestRepository;", "getHumsarServicerequestRepository", "()Lcom/livpure/safedrink/serviceRequest/data/HumsarServicerequestRepository;", "humsarServicerequestRepository$delegate", "Lkotlin/Lazy;", "otherUpdate", "getOtherUpdate", "otpUpdateMessage", "getOtpUpdateMessage", "otpVerificationMessage", "getOtpVerificationMessage", "refreshRech", "Lcom/livpure/safedrink/serviceRequest/data/model/RefreshRechargeResponse;", "getRefreshRech", "serialNumber", "getSerialNumber", "()Ljava/lang/String;", "setSerialNumber", "(Ljava/lang/String;)V", "servicerequestRepository", "Lcom/livpure/safedrink/serviceRequest/data/ServicerequestRepository;", "getServicerequestRepository", "()Lcom/livpure/safedrink/serviceRequest/data/ServicerequestRepository;", "servicerequestRepository$delegate", "sourceFrom", "getSourceFrom", "setSourceFrom", "getCancelOTP", "", "getWAAS_GetCustomerVoice", "jobType", "getWAAS_GetReason", "getWAAS_GetSubReason", "reassionId", "isFormValid", "", "appintmentDate", "updateRefreshRecharge", SegmentProperties.USER_ID, "updateServiceLog", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "updateServiceRequest", "cust_voice", "cust_sub_voice", "remarks", "updateServicerequest", "Landroidx/lifecycle/LiveData;", "Lkotlin/Triple;", "createdDate", SegmentProperties.APPOINTMENTDATE, "reference_id", "updateServicerequesteee", "verifyCancelOtp", "otpNumber", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RaiseServiceRequestModel extends MediatorViewModel {
    private final Lazy servicerequestRepository$delegate = LazyKt.lazy(new Function0<ServicerequestRepository>() { // from class: com.livpure.safedrink.serviceRequest.model.RaiseServiceRequestModel$servicerequestRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ServicerequestRepository invoke() {
            return new ServicerequestRepository();
        }
    });
    private final Lazy humsarServicerequestRepository$delegate = LazyKt.lazy(new Function0<HumsarServicerequestRepository>() { // from class: com.livpure.safedrink.serviceRequest.model.RaiseServiceRequestModel$humsarServicerequestRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HumsarServicerequestRepository invoke() {
            return new HumsarServicerequestRepository();
        }
    });
    private String serialNumber = "";
    private String sourceFrom = "";
    private final MutableLiveData<String> dateTimeError = new MutableLiveData<>();
    private final MutableLiveData<String> otherUpdate = new MutableLiveData<>();
    private final MutableLiveData<RefreshRechargeResponse> refreshRech = new MutableLiveData<>();
    private final MutableLiveData<CustomerVoiceResponse> customerVoiceReasonResponse = new MutableLiveData<>();
    private final MutableLiveData<CustomerVoiceResponse> customerVoiceSubReasonResponse = new MutableLiveData<>();
    private final MutableLiveData<String> otpUpdateMessage = new MutableLiveData<>();
    private final MutableLiveData<String> otpVerificationMessage = new MutableLiveData<>();

    private final ServicerequestRepository getServicerequestRepository() {
        return (ServicerequestRepository) this.servicerequestRepository$delegate.getValue();
    }

    private final HumsarServicerequestRepository getHumsarServicerequestRepository() {
        return (HumsarServicerequestRepository) this.humsarServicerequestRepository$delegate.getValue();
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public final void setSourceFrom(String str) {
        this.sourceFrom = str;
    }

    public final MutableLiveData<String> getDateTimeError() {
        return this.dateTimeError;
    }

    public final MutableLiveData<String> getOtherUpdate() {
        return this.otherUpdate;
    }

    public final MutableLiveData<RefreshRechargeResponse> getRefreshRech() {
        return this.refreshRech;
    }

    public final MutableLiveData<CustomerVoiceResponse> getCustomerVoiceReasonResponse() {
        return this.customerVoiceReasonResponse;
    }

    public final MutableLiveData<CustomerVoiceResponse> getCustomerVoiceSubReasonResponse() {
        return this.customerVoiceSubReasonResponse;
    }

    public final MutableLiveData<String> getOtpUpdateMessage() {
        return this.otpUpdateMessage;
    }

    public final MutableLiveData<String> getOtpVerificationMessage() {
        return this.otpVerificationMessage;
    }

    public final LiveData<Triple<String, String, String>> updateServicerequesteee(String createdDate, String appointment_date, String cust_voice, String remarks, String reference_id) {
        Intrinsics.checkNotNullParameter(createdDate, "createdDate");
        Intrinsics.checkNotNullParameter(appointment_date, "appointment_date");
        Intrinsics.checkNotNullParameter(cust_voice, "cust_voice");
        Intrinsics.checkNotNullParameter(remarks, "remarks");
        Intrinsics.checkNotNullParameter(reference_id, "reference_id");
        User user = LSApplication.Companion.getUser();
        String valueOf = String.valueOf(user != null ? user.getMobile() : null);
        String str = this.serialNumber;
        Intrinsics.checkNotNull(str);
        User user2 = LSApplication.Companion.getUser();
        ServiceRequestData serviceRequestData = new ServiceRequestData("waas_case_it_create", valueOf, "Service_Complaint", str, createdDate, appointment_date, cust_voice, String.valueOf(user2 != null ? user2.getMobile() : null), reference_id, "100", remarks);
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            observeAndTrack(getServicerequestRepository().updateServiceRequest(serviceRequestData), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RaiseServiceRequestModel$$ExternalSyntheticLambda7
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RaiseServiceRequestModel.m1152updateServicerequesteee$lambda0(RaiseServiceRequestModel.this, (ServiceRequestResponse) obj);
                }
            });
            return (LiveData) null;
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateServicerequesteee$lambda-0  reason: not valid java name */
    public static final void m1152updateServicerequesteee$lambda0(RaiseServiceRequestModel this$0, ServiceRequestResponse serviceRequestResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        new Triple(serviceRequestResponse != null ? serviceRequestResponse.getStatus() : null, serviceRequestResponse != null ? serviceRequestResponse.getMsg() : null, serviceRequestResponse != null ? serviceRequestResponse.getJs_number() : null);
    }

    public final LiveData<Triple<String, String, String>> updateServicerequest(String createdDate, String appointment_date, String cust_voice, String remarks, String reference_id) {
        Intrinsics.checkNotNullParameter(createdDate, "createdDate");
        Intrinsics.checkNotNullParameter(appointment_date, "appointment_date");
        Intrinsics.checkNotNullParameter(cust_voice, "cust_voice");
        Intrinsics.checkNotNullParameter(remarks, "remarks");
        Intrinsics.checkNotNullParameter(reference_id, "reference_id");
        if (LSApplication.Companion.isNetworkAvailable()) {
            User user = LSApplication.Companion.getUser();
            String valueOf = String.valueOf(user != null ? user.getMobile() : null);
            String str = this.serialNumber;
            Intrinsics.checkNotNull(str);
            User user2 = LSApplication.Companion.getUser();
            return Transformations.map(getServicerequestRepository().updateServiceRequest(new ServiceRequestData("waas_case_it_create", valueOf, "Service_Complaint", str, createdDate, appointment_date, cust_voice, String.valueOf(user2 != null ? user2.getMobile() : null), reference_id, "100", remarks)), new Function() { // from class: com.livpure.safedrink.serviceRequest.model.RaiseServiceRequestModel$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Triple m1151updateServicerequest$lambda1;
                    m1151updateServicerequest$lambda1 = RaiseServiceRequestModel.m1151updateServicerequest$lambda1((ServiceRequestResponse) obj);
                    return m1151updateServicerequest$lambda1;
                }
            });
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateServicerequest$lambda-1  reason: not valid java name */
    public static final Triple m1151updateServicerequest$lambda1(ServiceRequestResponse serviceRequestResponse) {
        return new Triple(String.valueOf(serviceRequestResponse.getStatus()), String.valueOf(serviceRequestResponse.getJs_number()), String.valueOf(serviceRequestResponse.getMsg()));
    }

    public final void updateServiceRequest(String cust_voice, String cust_sub_voice, String remarks) {
        Intrinsics.checkNotNullParameter(cust_voice, "cust_voice");
        Intrinsics.checkNotNullParameter(cust_sub_voice, "cust_sub_voice");
        Intrinsics.checkNotNullParameter(remarks, "remarks");
        getLoading().setValue(true);
        if (LSApplication.Companion.isNetworkAvailable()) {
            User user = LSApplication.Companion.getUser();
            try {
                observeAndTrack(getServicerequestRepository().setServiceRequestOtherData(new ServiceRequestOtherData(user != null ? user.getId() : null, cust_voice, cust_sub_voice, remarks)), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RaiseServiceRequestModel$$ExternalSyntheticLambda4
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RaiseServiceRequestModel.m1150updateServiceRequest$lambda2(RaiseServiceRequestModel.this, (BaseDataHolder) obj);
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
    /* renamed from: updateServiceRequest$lambda-2  reason: not valid java name */
    public static final void m1150updateServiceRequest$lambda2(RaiseServiceRequestModel this$0, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.otherUpdate.setValue(baseDataHolder.getMessage());
    }

    public final void getCancelOTP() {
        getLoading().setValue(true);
        if (LSApplication.Companion.isNetworkAvailable()) {
            try {
                observeAndTrack(getServicerequestRepository().getCancelOTP(), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RaiseServiceRequestModel$$ExternalSyntheticLambda2
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RaiseServiceRequestModel.m1144getCancelOTP$lambda3(RaiseServiceRequestModel.this, (BaseDataHolder) obj);
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
    /* renamed from: getCancelOTP$lambda-3  reason: not valid java name */
    public static final void m1144getCancelOTP$lambda3(RaiseServiceRequestModel this$0, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.otpUpdateMessage.setValue(baseDataHolder.getMessage());
    }

    public final void verifyCancelOtp(String otpNumber) {
        Intrinsics.checkNotNullParameter(otpNumber, "otpNumber");
        getLoading().setValue(true);
        if (LSApplication.Companion.isNetworkAvailable()) {
            try {
                observeAndTrack(getServicerequestRepository().verifyCancelOtp(new OTPRequest(otpNumber)), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RaiseServiceRequestModel$$ExternalSyntheticLambda1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RaiseServiceRequestModel.m1153verifyCancelOtp$lambda4(RaiseServiceRequestModel.this, (BaseDataHolder) obj);
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
    /* renamed from: verifyCancelOtp$lambda-4  reason: not valid java name */
    public static final void m1153verifyCancelOtp$lambda4(RaiseServiceRequestModel this$0, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.otpVerificationMessage.setValue(baseDataHolder.getMessage());
    }

    public final void updateServiceLog(String userID, String request) {
        Intrinsics.checkNotNullParameter(userID, "userID");
        Intrinsics.checkNotNullParameter(request, "request");
        if (LSApplication.Companion.isNetworkAvailable()) {
            try {
                observeAndTrack(getServicerequestRepository().getserviceLogs(new ServiceLogs(userID, request)), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RaiseServiceRequestModel$$ExternalSyntheticLambda5
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RaiseServiceRequestModel.m1149updateServiceLog$lambda5(RaiseServiceRequestModel.this, (BaseDataHolder) obj);
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
    /* renamed from: updateServiceLog$lambda-5  reason: not valid java name */
    public static final void m1149updateServiceLog$lambda5(RaiseServiceRequestModel this$0, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
    }

    public final void updateRefreshRecharge(String userID) {
        Intrinsics.checkNotNullParameter(userID, "userID");
        getLoading().setValue(true);
        if (LSApplication.Companion.isNetworkAvailable()) {
            try {
                observeAndTrack(getServicerequestRepository().refreshRecharge(new RefreshRechargeRequest(userID)), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RaiseServiceRequestModel$$ExternalSyntheticLambda8
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RaiseServiceRequestModel.m1148updateRefreshRecharge$lambda6(RaiseServiceRequestModel.this, (RefreshRechargeResponse) obj);
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
    /* renamed from: updateRefreshRecharge$lambda-6  reason: not valid java name */
    public static final void m1148updateRefreshRecharge$lambda6(RaiseServiceRequestModel this$0, RefreshRechargeResponse refreshRechargeResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.refreshRech.setValue(refreshRechargeResponse);
    }

    public final void getWAAS_GetReason() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            try {
                observeAndTrack(getHumsarServicerequestRepository().getServiceRequest(new HumsarServiceRequest(LSHConfig.HUMSAR_TOKEN_NO, "", "", "", "", "", "", "", "")), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RaiseServiceRequestModel$$ExternalSyntheticLambda3
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RaiseServiceRequestModel.m1146getWAAS_GetReason$lambda7(RaiseServiceRequestModel.this, (BaseDataHolder) obj);
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
    /* renamed from: getWAAS_GetReason$lambda-7  reason: not valid java name */
    public static final void m1146getWAAS_GetReason$lambda7(RaiseServiceRequestModel this$0, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
    }

    public final void getWAAS_GetSubReason(String reassionId) {
        Intrinsics.checkNotNullParameter(reassionId, "reassionId");
        if (LSApplication.Companion.isNetworkAvailable()) {
            try {
                observeAndTrack(getHumsarServicerequestRepository().getServiceRequest(new HumsarServiceRequest(LSHConfig.HUMSAR_TOKEN_NO, reassionId, "", "", "", "", "", "", "")), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RaiseServiceRequestModel$$ExternalSyntheticLambda6
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RaiseServiceRequestModel.m1147getWAAS_GetSubReason$lambda8(RaiseServiceRequestModel.this, (BaseDataHolder) obj);
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
    /* renamed from: getWAAS_GetSubReason$lambda-8  reason: not valid java name */
    public static final void m1147getWAAS_GetSubReason$lambda8(RaiseServiceRequestModel this$0, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
    }

    public final void getWAAS_GetCustomerVoice(final String jobType) {
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getHumsarServicerequestRepository().getCustomerVoice(new CustomerVoiceRequest(LSHConfig.HUMSAR_TOKEN_NO, jobType)), new Observer() { // from class: com.livpure.safedrink.serviceRequest.model.RaiseServiceRequestModel$$ExternalSyntheticLambda9
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RaiseServiceRequestModel.m1145getWAAS_GetCustomerVoice$lambda9(RaiseServiceRequestModel.this, jobType, (CustomerVoiceResponse) obj);
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
    /* renamed from: getWAAS_GetCustomerVoice$lambda-9  reason: not valid java name */
    public static final void m1145getWAAS_GetCustomerVoice$lambda9(final RaiseServiceRequestModel this$0, final String jobType, final CustomerVoiceResponse customerVoiceResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(jobType, "$jobType");
        this$0.getLoading().setValue(false);
        this$0.processResponse(customerVoiceResponse, new Function1<CustomerVoiceResponse, Unit>() { // from class: com.livpure.safedrink.serviceRequest.model.RaiseServiceRequestModel$getWAAS_GetCustomerVoice$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CustomerVoiceResponse customerVoiceResponse2) {
                invoke2(customerVoiceResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CustomerVoiceResponse successfulResponse) {
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                if (Intrinsics.areEqual(jobType, "call_log")) {
                    this$0.getCustomerVoiceReasonResponse().setValue(successfulResponse);
                } else {
                    this$0.getCustomerVoiceSubReasonResponse().setValue(successfulResponse);
                }
                toastMessageLiveData = this$0.getToastMessageLiveData();
                String message = customerVoiceResponse.getMessage();
                Intrinsics.checkNotNull(message);
                toastMessageLiveData.setValue(new Event(message));
            }
        }, new Function1<CustomerVoiceResponse, Unit>() { // from class: com.livpure.safedrink.serviceRequest.model.RaiseServiceRequestModel$getWAAS_GetCustomerVoice$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CustomerVoiceResponse customerVoiceResponse2) {
                invoke2(customerVoiceResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CustomerVoiceResponse failedResponse) {
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(failedResponse, "failedResponse");
                toastMessageLiveData = RaiseServiceRequestModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Oops! We faced some issue while fetching referral link."));
            }
        });
    }

    public final boolean isFormValid(String appintmentDate) {
        Intrinsics.checkNotNullParameter(appintmentDate, "appintmentDate");
        if (StringsKt.isBlank(appintmentDate)) {
            this.dateTimeError.setValue("Please select the appointment date and time");
            return false;
        }
        this.dateTimeError.setValue(null);
        return true;
    }
}

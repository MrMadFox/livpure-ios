package com.livpure.safedrink.app;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.api.APIException;
import com.livpure.safedrink.api.BaseDataHolder;
import com.livpure.safedrink.app.DeviceHomeViewModel;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.bolt.data.BoltDataUpdateRepository;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.MediatorViewModel;
import com.livpure.safedrink.dispenser.data.EnvyBLEResponseRepository;
import com.livpure.safedrink.dispenser.data.models.EnvyBLEResponse;
import com.livpure.safedrink.login.api.models.response.BaseV1ResponseImplementation;
import com.livpure.safedrink.login.api.models.response.ReferralData;
import com.livpure.safedrink.login.api.models.response.ReferralLinkResponse;
import com.livpure.safedrink.login.api.models.response.UserDetailsResponse;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.data.models.UserDetailsV1;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.subscription.plan.data.SubscriptionRepository;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceData;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: DeviceHomeViewModel.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001:\u0001cB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010E\u001a\u00020,J\u0006\u0010F\u001a\u00020,J\u0006\u0010G\u001a\u00020,J\u0012\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0IJ\u001a\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0I2\u0006\u0010K\u001a\u00020LJ\u001a\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000b0I2\u0006\u0010K\u001a\u00020LJ\u001a\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0I2\u0006\u0010K\u001a\u00020LJ\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00130IJ\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00130IJ\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00180I2\u0006\u0010K\u001a\u00020LJ\u0014\u0010R\u001a\b\u0012\u0004\u0012\u0002020I2\u0006\u0010K\u001a\u00020LJ\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\f0IJ\u0014\u0010S\u001a\b\u0012\u0004\u0012\u00020D0I2\u0006\u0010K\u001a\u00020LJ\u0006\u0010T\u001a\u00020,J&\u0010U\u001a\u00020,2\u0006\u0010K\u001a\u00020L2\u0006\u0010V\u001a\u00020\u00182\u0006\u0010W\u001a\u00020\u00182\u0006\u0010X\u001a\u00020#J\u000e\u0010Y\u001a\u00020,2\u0006\u0010Z\u001a\u00020\u001eJ\u000e\u0010[\u001a\u00020,2\u0006\u0010Z\u001a\u00020\u001eJ\u0006\u0010\\\u001a\u00020,J6\u0010]\u001a\u00020,2\b\b\u0001\u0010^\u001a\u00020\u001e2\u0006\u0010_\u001a\u00020\u00182\u0006\u0010`\u001a\u00020\u00182\u0006\u0010a\u001a\u00020\u00182\f\u0010b\u001a\b\u0012\u0004\u0012\u00020,0+R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u0012¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u001a\u0010%\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001a\b\u0012\u0004\u0012\u0002020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\b\u001a\u0004\b5\u00106R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001aR \u0010:\u001a\b\u0012\u0004\u0012\u00020\f0\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001a\"\u0004\b<\u0010=R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u001aR\u001b\u0010@\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\b\u001a\u0004\bA\u00106R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006d²\u0006\n\u0010e\u001a\u00020fX\u008a\u0084\u0002²\u0006\n\u0010e\u001a\u00020fX\u008a\u0084\u0002²\u0006\n\u0010g\u001a\u00020hX\u008a\u0084\u0002²\u0006\n\u0010g\u001a\u00020hX\u008a\u0084\u0002"}, d2 = {"Lcom/livpure/safedrink/app/DeviceHomeViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "()V", "BLERepository", "Lcom/livpure/safedrink/bolt/data/BoltDataUpdateRepository;", "getBLERepository", "()Lcom/livpure/safedrink/bolt/data/BoltDataUpdateRepository;", "BLERepository$delegate", "Lkotlin/Lazy;", "airPurifierDevices", "Landroidx/lifecycle/MediatorLiveData;", "", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "getAirPurifierDevices", "()Landroidx/lifecycle/MediatorLiveData;", AndroidContextPlugin.DEVICE_KEY, "getDevice", "deviceHomeNavigationState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/livpure/safedrink/app/DeviceHomeViewModel$DeviceHomeNavigationStates;", "envyBLEResponseList", "Lcom/livpure/safedrink/dispenser/data/models/EnvyBLEResponse;", "getEnvyBLEResponseList", "hintButtonText", "", "getHintButtonText", "()Landroidx/lifecycle/MutableLiveData;", "hintHeaderText", "getHintHeaderText", "hintImageResId", "", "getHintImageResId", "hintLabel", "getHintLabel", "hintVisibility", "", "getHintVisibility", "nextFragmentCalled", "getNextFragmentCalled", "()Z", "setNextFragmentCalled", "(Z)V", "onHintButtonClick", "Lkotlin/Function0;", "", "getOnHintButtonClick", "()Lkotlin/jvm/functions/Function0;", "setOnHintButtonClick", "(Lkotlin/jvm/functions/Function0;)V", "referralLinkResponse", "Lcom/livpure/safedrink/login/api/models/response/ReferralLinkResponse;", "repository", "Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "getRepository", "()Lcom/livpure/safedrink/subscription/plan/data/SubscriptionRepository;", "repository$delegate", "rtndata", "getRtndata", "selectedDevice", "getSelectedDevice", "setSelectedDevice", "(Landroidx/lifecycle/MutableLiveData;)V", "ser", "getSer", "subscriptionRepository", "getSubscriptionRepository", "subscriptionRepository$delegate", "userDetailsResponse", "Lcom/livpure/safedrink/login/api/models/response/UserDetailsResponse;", "checkInstallationStatus", "checkKYCStatus", "checkPaymentStatus", "getAllAirPurifierDeviceDetails", "Landroidx/lifecycle/LiveData;", "getAllDeviceDetails", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "getAllEnvyBLEResponse", "getAllOflineDeviceDetails", "getDeviceHomeNavigationState", "getDeviceOfflineNavigationState", "getOflineUserDetails", "getReferralLink", "getUserDetails", "hideHintView", "offlineBLEStatus", "serialNumber", "status", "lastPacket", "onAirPurifierDeviceClicked", "planPosition", "onDeviceClicked", "refreshHintView", "showHintView", "drawableId", ViewHierarchyConstants.HINT_KEY, "buttonText", "header", "onClick", "DeviceHomeNavigationStates", "app_productionRelease", "deviceHomeRepository", "Lcom/livpure/safedrink/app/DeviceHomeRepository;", "envyBLEResponseRepository", "Lcom/livpure/safedrink/dispenser/data/EnvyBLEResponseRepository;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeviceHomeViewModel extends MediatorViewModel {
    private final Lazy BLERepository$delegate;
    private final MediatorLiveData<List<EnvyBLEResponse>> envyBLEResponseList;
    private final MutableLiveData<String> hintHeaderText;
    private final MutableLiveData<Integer> hintImageResId;
    private final MutableLiveData<Boolean> hintVisibility;
    private boolean nextFragmentCalled;
    public Function0<Unit> onHintButtonClick;
    private final MutableLiveData<ReferralLinkResponse> referralLinkResponse;
    private final MutableLiveData<String> rtndata;
    private final MutableLiveData<String> ser;
    private final MutableLiveData<UserDetailsResponse> userDetailsResponse;
    private final Lazy repository$delegate = LazyKt.lazy(new Function0<SubscriptionRepository>() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$repository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SubscriptionRepository invoke() {
            return new SubscriptionRepository();
        }
    });
    private final MediatorLiveData<List<DeviceList>> device = new MediatorLiveData<>();
    private final MediatorLiveData<List<DeviceList>> airPurifierDevices = new MediatorLiveData<>();
    private MutableLiveData<DeviceList> selectedDevice = new MutableLiveData<>();
    private final MutableLiveData<DeviceHomeNavigationStates> deviceHomeNavigationState = new MutableLiveData<>();
    private final Lazy subscriptionRepository$delegate = LazyKt.lazy(new Function0<SubscriptionRepository>() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$subscriptionRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SubscriptionRepository invoke() {
            return new SubscriptionRepository();
        }
    });
    private final MutableLiveData<String> hintLabel = new MutableLiveData<>();
    private final MutableLiveData<String> hintButtonText = new MutableLiveData<>();

    /* compiled from: DeviceHomeViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/livpure/safedrink/app/DeviceHomeViewModel$DeviceHomeNavigationStates;", "", "(Ljava/lang/String;I)V", "SELECT_PLAN", "CHECK_KYC", "CHECK_PAYMENT", "CHECK_INSTALLATION", "UPDATE_KYC", "INSTALLATION_PENDING", "HOME", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum DeviceHomeNavigationStates {
        SELECT_PLAN,
        CHECK_KYC,
        CHECK_PAYMENT,
        CHECK_INSTALLATION,
        UPDATE_KYC,
        INSTALLATION_PENDING,
        HOME
    }

    public DeviceHomeViewModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue("");
        this.hintHeaderText = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue(Integer.valueOf((int) R.drawable.ic_logo));
        this.hintImageResId = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        mutableLiveData3.setValue(true);
        this.hintVisibility = mutableLiveData3;
        this.ser = new MutableLiveData<>();
        this.userDetailsResponse = new MutableLiveData<>();
        this.referralLinkResponse = new MutableLiveData<>();
        this.rtndata = new MutableLiveData<>();
        this.BLERepository$delegate = LazyKt.lazy(new Function0<BoltDataUpdateRepository>() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$BLERepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BoltDataUpdateRepository invoke() {
                return new BoltDataUpdateRepository();
            }
        });
        this.envyBLEResponseList = new MediatorLiveData<>();
    }

    private final SubscriptionRepository getRepository() {
        return (SubscriptionRepository) this.repository$delegate.getValue();
    }

    public final MediatorLiveData<List<DeviceList>> getDevice() {
        return this.device;
    }

    public final MediatorLiveData<List<DeviceList>> getAirPurifierDevices() {
        return this.airPurifierDevices;
    }

    /* renamed from: getSelectedDevice  reason: collision with other method in class */
    public final MutableLiveData<DeviceList> m333getSelectedDevice() {
        return this.selectedDevice;
    }

    public final void setSelectedDevice(MutableLiveData<DeviceList> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.selectedDevice = mutableLiveData;
    }

    private final SubscriptionRepository getSubscriptionRepository() {
        return (SubscriptionRepository) this.subscriptionRepository$delegate.getValue();
    }

    public final boolean getNextFragmentCalled() {
        return this.nextFragmentCalled;
    }

    public final void setNextFragmentCalled(boolean z) {
        this.nextFragmentCalled = z;
    }

    public final MutableLiveData<String> getHintLabel() {
        return this.hintLabel;
    }

    public final MutableLiveData<String> getHintButtonText() {
        return this.hintButtonText;
    }

    public final MutableLiveData<String> getHintHeaderText() {
        return this.hintHeaderText;
    }

    public final MutableLiveData<Integer> getHintImageResId() {
        return this.hintImageResId;
    }

    public final MutableLiveData<Boolean> getHintVisibility() {
        return this.hintVisibility;
    }

    public final Function0<Unit> getOnHintButtonClick() {
        Function0<Unit> function0 = this.onHintButtonClick;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onHintButtonClick");
        return null;
    }

    public final void setOnHintButtonClick(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onHintButtonClick = function0;
    }

    public final MutableLiveData<String> getSer() {
        return this.ser;
    }

    /* renamed from: getAllDeviceDetails$lambda-3  reason: not valid java name */
    private static final DeviceHomeRepository m325getAllDeviceDetails$lambda3(Lazy<DeviceHomeRepository> lazy) {
        return lazy.getValue();
    }

    public final LiveData<List<DeviceList>> getAllDeviceDetails(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        final Lazy lazy = LazyKt.lazy(new Function0<DeviceHomeRepository>() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$getAllDeviceDetails$deviceHomeRepository$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DeviceHomeRepository invoke() {
                return new DeviceHomeRepository(context);
            }
        });
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            this.device.addSource(getRepository().getDeviceList(true), new Observer() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$$ExternalSyntheticLambda3
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DeviceHomeViewModel.m326getAllDeviceDetails$lambda4(DeviceHomeViewModel.this, lazy, (BaseDataHolder) obj);
                }
            });
        } else {
            this.deviceHomeNavigationState.setValue(DeviceHomeNavigationStates.HOME);
            getLoading().setValue(false);
            this.device.setValue(m325getAllDeviceDetails$lambda3(lazy).getAllDevices());
        }
        return this.device;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAllDeviceDetails$lambda-4  reason: not valid java name */
    public static final void m326getAllDeviceDetails$lambda4(DeviceHomeViewModel this$0, Lazy deviceHomeRepository$delegate, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(deviceHomeRepository$delegate, "$deviceHomeRepository$delegate");
        m325getAllDeviceDetails$lambda3(deviceHomeRepository$delegate).deleteAllDevice();
        this$0.getLoading().setValue(false);
        if (baseDataHolder.getData() != null) {
            this$0.device.setValue(((DeviceData) baseDataHolder.getData()).getDevices());
            this$0.airPurifierDevices.setValue(((DeviceData) baseDataHolder.getData()).getAirDevices());
            m325getAllDeviceDetails$lambda3(deviceHomeRepository$delegate).insert(((DeviceData) baseDataHolder.getData()).getDevices());
            return;
        }
        MutableLiveData<Event<String>> toastMessageLiveData = this$0.getToastMessageLiveData();
        String message = baseDataHolder.getMessage();
        if (message == null) {
            message = "Sorry! We got an error while fetching all those plans.";
        }
        toastMessageLiveData.setValue(new Event<>(message));
    }

    /* renamed from: getAllOflineDeviceDetails$lambda-5  reason: not valid java name */
    private static final DeviceHomeRepository m328getAllOflineDeviceDetails$lambda5(Lazy<DeviceHomeRepository> lazy) {
        return lazy.getValue();
    }

    public final LiveData<List<DeviceList>> getAllOflineDeviceDetails(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.device.setValue(m328getAllOflineDeviceDetails$lambda5(LazyKt.lazy(new Function0<DeviceHomeRepository>() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$getAllOflineDeviceDetails$deviceHomeRepository$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DeviceHomeRepository invoke() {
                return new DeviceHomeRepository(context);
            }
        })).getAllDevices());
        return this.device;
    }

    public final LiveData<List<DeviceList>> getAllAirPurifierDeviceDetails() {
        return this.airPurifierDevices;
    }

    public final LiveData<DeviceList> getSelectedDevice() {
        return this.selectedDevice;
    }

    public final void onDeviceClicked(int i) {
        this.nextFragmentCalled = true;
        MutableLiveData<DeviceList> mutableLiveData = this.selectedDevice;
        List<DeviceList> value = this.device.getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveData.setValue(value.get(i));
    }

    public final void onAirPurifierDeviceClicked(int i) {
        this.nextFragmentCalled = true;
        MutableLiveData<DeviceList> mutableLiveData = this.selectedDevice;
        List<DeviceList> value = this.airPurifierDevices.getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveData.setValue(value.get(i));
    }

    public final LiveData<DeviceHomeNavigationStates> getDeviceHomeNavigationState() {
        this.deviceHomeNavigationState.setValue(DeviceHomeNavigationStates.CHECK_PAYMENT);
        return this.deviceHomeNavigationState;
    }

    public final LiveData<DeviceHomeNavigationStates> getDeviceOfflineNavigationState() {
        this.deviceHomeNavigationState.setValue(DeviceHomeNavigationStates.HOME);
        return this.deviceHomeNavigationState;
    }

    public final void checkPaymentStatus() {
        User user = LSApplication.Companion.getUser();
        boolean z = true;
        if (!((user == null || !user.getPaymentCompleted()) ? false : false)) {
            this.deviceHomeNavigationState.setValue(DeviceHomeNavigationStates.SELECT_PLAN);
        } else {
            this.deviceHomeNavigationState.setValue(DeviceHomeNavigationStates.CHECK_KYC);
        }
    }

    public final void checkKYCStatus() {
        User user = LSApplication.Companion.getUser();
        Intrinsics.checkNotNull(user);
        if (!user.getKycCompleted()) {
            this.deviceHomeNavigationState.setValue(DeviceHomeNavigationStates.UPDATE_KYC);
        } else {
            this.deviceHomeNavigationState.setValue(DeviceHomeNavigationStates.CHECK_INSTALLATION);
        }
    }

    public final void checkInstallationStatus() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getSubscriptionRepository().getInstallationStatus(), new Observer() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$$ExternalSyntheticLambda0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DeviceHomeViewModel.m324checkInstallationStatus$lambda6(DeviceHomeViewModel.this, (BaseV1ResponseImplementation) obj);
                    }
                });
                return;
            } catch (APIException unused) {
                getLoading().setValue(false);
                getToastMessageLiveData().setValue(new Event<>("Oops! Looks like we faced an issue contacting our server."));
                return;
            }
        }
        getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkInstallationStatus$lambda-6  reason: not valid java name */
    public static final void m324checkInstallationStatus$lambda6(final DeviceHomeViewModel this$0, BaseV1ResponseImplementation baseV1ResponseImplementation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(baseV1ResponseImplementation, new Function1<BaseV1ResponseImplementation, Unit>() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$checkInstallationStatus$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseV1ResponseImplementation baseV1ResponseImplementation2) {
                invoke2(baseV1ResponseImplementation2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BaseV1ResponseImplementation it) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(it, "it");
                mutableLiveData = DeviceHomeViewModel.this.deviceHomeNavigationState;
                mutableLiveData.setValue(DeviceHomeViewModel.DeviceHomeNavigationStates.HOME);
            }
        }, new Function1<BaseV1ResponseImplementation, Unit>() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$checkInstallationStatus$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseV1ResponseImplementation baseV1ResponseImplementation2) {
                invoke2(baseV1ResponseImplementation2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BaseV1ResponseImplementation it) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(it, "it");
                mutableLiveData = DeviceHomeViewModel.this.deviceHomeNavigationState;
                mutableLiveData.setValue(DeviceHomeViewModel.DeviceHomeNavigationStates.INSTALLATION_PENDING);
            }
        });
    }

    public final void showHintView(int i, String hint, String buttonText, String header, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(hint, "hint");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.hintVisibility.setValue(true);
        this.hintImageResId.setValue(Integer.valueOf(i));
        this.hintLabel.setValue(hint);
        this.hintButtonText.setValue(buttonText);
        setOnHintButtonClick(onClick);
        this.hintHeaderText.setValue(header);
    }

    public final void hideHintView() {
        this.hintVisibility.setValue(false);
    }

    public final void refreshHintView() {
        User user = LSApplication.Companion.getUser();
        boolean z = true;
        if (!((user == null || !user.getPaymentCompleted()) ? false : false)) {
            showHintView(R.drawable.ic_select_plan, "Looks like you have not selected a plan. Select one now to get started", "Select Plan", "Subscribe Now", new Function0<Unit>() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$refreshHintView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = DeviceHomeViewModel.this.deviceHomeNavigationState;
                    mutableLiveData.setValue(DeviceHomeViewModel.DeviceHomeNavigationStates.SELECT_PLAN);
                }
            });
            return;
        }
        User user2 = LSApplication.Companion.getUser();
        Intrinsics.checkNotNull(user2);
        if (!user2.getKycCompleted()) {
            showHintView(R.drawable.ic_kyc_document, "Looks like we do not have your KYC documents yet! Upload your KYC documents and complete this final step.", "Upload KYC", "KYC Pending", new Function0<Unit>() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$refreshHintView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = DeviceHomeViewModel.this.deviceHomeNavigationState;
                    mutableLiveData.setValue(DeviceHomeViewModel.DeviceHomeNavigationStates.UPDATE_KYC);
                }
            });
        } else if (this.deviceHomeNavigationState.getValue() == DeviceHomeNavigationStates.INSTALLATION_PENDING) {
            this.deviceHomeNavigationState.setValue(DeviceHomeNavigationStates.INSTALLATION_PENDING);
        } else if (CollectionsKt.contains(CollectionsKt.listOf(DeviceHomeNavigationStates.HOME), this.deviceHomeNavigationState.getValue())) {
            this.deviceHomeNavigationState.setValue(DeviceHomeNavigationStates.HOME);
        }
    }

    public final LiveData<UserDetailsResponse> getUserDetails(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (LSApplication.Companion.isNetworkAvailable()) {
            User user = LSApplication.Companion.getUser();
            String email = user != null ? user.getEmail() : null;
            if (!(email == null || StringsKt.isBlank(email))) {
                getLoading().setValue(true);
                try {
                    User user2 = LSApplication.Companion.getUser();
                    Intrinsics.checkNotNull(user2);
                    String email2 = user2.getEmail();
                    Intrinsics.checkNotNull(email2);
                    observeAndTrack(UserRepository.Companion.getInstance(context).getUserDetails(email2), new Observer() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$$ExternalSyntheticLambda2
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            DeviceHomeViewModel.m330getUserDetails$lambda7(DeviceHomeViewModel.this, context, (UserDetailsResponse) obj);
                        }
                    });
                } catch (APIException unused) {
                    getLoading().setValue(false);
                    getToastMessageLiveData().setValue(new Event<>("Oops! We faced some issue while refreshing your details."));
                }
            }
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
        return this.userDetailsResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUserDetails$lambda-7  reason: not valid java name */
    public static final void m330getUserDetails$lambda7(final DeviceHomeViewModel this$0, final Context context, UserDetailsResponse userDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.getLoading().setValue(false);
        this$0.processResponse(userDetailsResponse, new Function1<UserDetailsResponse, Unit>() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$getUserDetails$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UserDetailsResponse userDetailsResponse2) {
                invoke2(userDetailsResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserDetailsResponse successfulResponse) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                List<UserDetailsV1> userDetailsList = successfulResponse.getUserDetailsList();
                User mappedUser = !(userDetailsList == null || userDetailsList.isEmpty()) ? successfulResponse.getUserDetailsList().get(0).getMappedUser() : null;
                LSApplication.Companion.setReferralLink(mappedUser != null ? mappedUser.getRefShortLink() : null);
                LSApplication.Companion.setPlanName(mappedUser != null ? mappedUser.getPlanName() : null);
                if (mappedUser != null) {
                    Context context2 = context;
                    DeviceHomeViewModel deviceHomeViewModel = this$0;
                    UserRepository.Companion.getInstance(context2).setUser(mappedUser);
                    mutableLiveData = deviceHomeViewModel.userDetailsResponse;
                    mutableLiveData.setValue(successfulResponse);
                }
            }
        }, new Function1<UserDetailsResponse, Unit>() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$getUserDetails$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UserDetailsResponse userDetailsResponse2) {
                invoke2(userDetailsResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserDetailsResponse it) {
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(it, "it");
                toastMessageLiveData = DeviceHomeViewModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Oops! We faced some issue while refreshing your details."));
            }
        });
    }

    public final LiveData<ReferralLinkResponse> getReferralLink(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (LSApplication.Companion.isNetworkAvailable()) {
            User user = LSApplication.Companion.getUser();
            String id = user != null ? user.getId() : null;
            if (!(id == null || StringsKt.isBlank(id))) {
                getLoading().setValue(true);
                try {
                    User user2 = LSApplication.Companion.getUser();
                    Intrinsics.checkNotNull(user2);
                    observeAndTrack(UserRepository.Companion.getInstance(context).getReferralLink(user2.getId()), new Observer() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$$ExternalSyntheticLambda1
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            DeviceHomeViewModel.m329getReferralLink$lambda8(DeviceHomeViewModel.this, (ReferralLinkResponse) obj);
                        }
                    });
                } catch (APIException unused) {
                    getLoading().setValue(false);
                    getToastMessageLiveData().setValue(new Event<>("Oops! We faced some issue while fetching referral link."));
                }
            }
        } else {
            getNetworkState().setValue(BaseViewModel.NetworkState.OFFLINE);
        }
        return this.referralLinkResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getReferralLink$lambda-8  reason: not valid java name */
    public static final void m329getReferralLink$lambda8(final DeviceHomeViewModel this$0, ReferralLinkResponse referralLinkResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoading().setValue(false);
        this$0.processResponse(referralLinkResponse, new Function1<ReferralLinkResponse, Unit>() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$getReferralLink$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ReferralLinkResponse referralLinkResponse2) {
                invoke2(referralLinkResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ReferralLinkResponse successfulResponse) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(successfulResponse, "successfulResponse");
                LSApplication.Companion companion = LSApplication.Companion;
                ReferralData data = successfulResponse.getData();
                Intrinsics.checkNotNull(data);
                companion.setReferralLink(data.getRefShortLink());
                mutableLiveData = DeviceHomeViewModel.this.referralLinkResponse;
                mutableLiveData.setValue(successfulResponse);
            }
        }, new Function1<ReferralLinkResponse, Unit>() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$getReferralLink$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ReferralLinkResponse referralLinkResponse2) {
                invoke2(referralLinkResponse2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ReferralLinkResponse failedResponse) {
                MutableLiveData toastMessageLiveData;
                Intrinsics.checkNotNullParameter(failedResponse, "failedResponse");
                toastMessageLiveData = DeviceHomeViewModel.this.getToastMessageLiveData();
                toastMessageLiveData.setValue(new Event("Oops! We faced some issue while fetching referral link."));
            }
        });
    }

    protected final MutableLiveData<String> getRtndata() {
        return this.rtndata;
    }

    public final LiveData<String> getOflineUserDetails(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.deviceHomeNavigationState.setValue(DeviceHomeNavigationStates.HOME);
        this.rtndata.setValue("Home");
        return this.rtndata;
    }

    private final BoltDataUpdateRepository getBLERepository() {
        return (BoltDataUpdateRepository) this.BLERepository$delegate.getValue();
    }

    public final MediatorLiveData<List<EnvyBLEResponse>> getEnvyBLEResponseList() {
        return this.envyBLEResponseList;
    }

    /* renamed from: getAllEnvyBLEResponse$lambda-9  reason: not valid java name */
    private static final EnvyBLEResponseRepository m327getAllEnvyBLEResponse$lambda9(Lazy<EnvyBLEResponseRepository> lazy) {
        return lazy.getValue();
    }

    public final LiveData<List<EnvyBLEResponse>> getAllEnvyBLEResponse(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.envyBLEResponseList.setValue(m327getAllEnvyBLEResponse$lambda9(LazyKt.lazy(new Function0<EnvyBLEResponseRepository>() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$getAllEnvyBLEResponse$envyBLEResponseRepository$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EnvyBLEResponseRepository invoke() {
                return new EnvyBLEResponseRepository(context);
            }
        })).getBLEResponse());
        return this.envyBLEResponseList;
    }

    public final void offlineBLEStatus(final Context context, String serialNumber, String status, final boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serialNumber, "serialNumber");
        Intrinsics.checkNotNullParameter(status, "status");
        if (LSApplication.Companion.isNetworkAvailable()) {
            getLoading().setValue(true);
            try {
                observeAndTrack(getBLERepository().sendBoltConfigtRequest(serialNumber, status, true), new Observer() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$$ExternalSyntheticLambda4
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DeviceHomeViewModel.m331offlineBLEStatus$lambda11(DeviceHomeViewModel.this, z, context, (BaseDataHolder) obj);
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
    /* renamed from: offlineBLEStatus$lambda-11  reason: not valid java name */
    public static final void m331offlineBLEStatus$lambda11(DeviceHomeViewModel this$0, boolean z, final Context context, BaseDataHolder baseDataHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.getLoading().setValue(false);
        if (z) {
            m332offlineBLEStatus$lambda11$lambda10(LazyKt.lazy(new Function0<EnvyBLEResponseRepository>() { // from class: com.livpure.safedrink.app.DeviceHomeViewModel$offlineBLEStatus$1$envyBLEResponseRepository$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final EnvyBLEResponseRepository invoke() {
                    return new EnvyBLEResponseRepository(context);
                }
            })).deleteBLEResponse();
        }
    }

    /* renamed from: offlineBLEStatus$lambda-11$lambda-10  reason: not valid java name */
    private static final EnvyBLEResponseRepository m332offlineBLEStatus$lambda11$lambda10(Lazy<EnvyBLEResponseRepository> lazy) {
        return lazy.getValue();
    }
}

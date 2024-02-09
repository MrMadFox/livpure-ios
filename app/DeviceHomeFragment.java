package com.livpure.safedrink.app;

import android.bluetooth.BluetoothGatt;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.koushikdutta.async.http.body.StringBody;
import com.livpure.safedrink.NavGraphDirections;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.AppLifeCycleManager;
import com.livpure.safedrink.app.DeviceHomeViewModel;
import com.livpure.safedrink.app.HomeFragmentDirections;
import com.livpure.safedrink.common.arc.ui.HorizontalMarginItemDecoration;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentDeviceHomeBinding;
import com.livpure.safedrink.dispenser.data.models.EnvyBLEResponse;
import com.livpure.safedrink.login.api.models.response.ReferralLinkResponse;
import com.livpure.safedrink.login.api.models.response.UserDetailsResponse;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.moengage.pushbase.MoEPushConstants;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
/* compiled from: DeviceHomeFragment.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010&\u001a\u00020'2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010(\u001a\u00020\u0017H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002J\b\u0010*\u001a\u00020'H\u0002J\b\u0010+\u001a\u00020\u0005H\u0014J\b\u0010,\u001a\u00020'H\u0002J\b\u0010-\u001a\u00020!H\u0014J\b\u0010.\u001a\u00020\u0017H\u0002J\b\u0010/\u001a\u00020'H\u0002J\u0010\u00100\u001a\u00020'2\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020'H\u0002J\u0006\u00104\u001a\u00020'J+\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\u00052\f\u00106\u001a\b\u0012\u0004\u0012\u00020\b072\u0006\u00108\u001a\u000209H\u0016¢\u0006\u0002\u0010:J\u001a\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0006\u0010@\u001a\u00020'J\u0010\u0010A\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0006\u0010B\u001a\u00020'J\b\u0010C\u001a\u00020'H\u0002J\b\u0010D\u001a\u00020'H\u0002J\u0010\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020\bH\u0002J\b\u0010G\u001a\u00020'H\u0002J\b\u0010H\u001a\u00020'H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#¨\u0006I"}, d2 = {"Lcom/livpure/safedrink/app/DeviceHomeFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentDeviceHomeBinding;", "()V", "LOCATION_PERMISSION_CODE", "", "REQUEST_LOCATION_CODE", "TAG", "", "getTAG", "()Ljava/lang/String;", "airPurifierDeviceList", "", "Lcom/livpure/safedrink/subscription/plan/data/model/deviceList/DeviceList;", "dataBinding", "deviceList", "deviceSerialNumber", "getDeviceSerialNumber", "setDeviceSerialNumber", "(Ljava/lang/String;)V", "dialog", "Landroidx/appcompat/app/AlertDialog;", "mBleConnected", "", "mBluetoothGatt", "Landroid/bluetooth/BluetoothGatt;", "navArgs", "Lcom/livpure/safedrink/app/DeviceHomeFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/app/DeviceHomeFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "selectDeviceHomeViewModel", "Lcom/livpure/safedrink/app/DeviceHomeViewModel;", "getSelectDeviceHomeViewModel", "()Lcom/livpure/safedrink/app/DeviceHomeViewModel;", "selectDeviceHomeViewModel$delegate", "Lkotlin/Lazy;", "bindVariablesToView", "", "checkGPSEnabled", "checkIfLocationPermissionGranted", "checkLocationPermission", "getLayoutId", "getReferralLink", "getViewModel", "isLocationEnabled", "listeners", MoEPushConstants.ACTION_NAVIGATE, NativeProtocol.WEB_DIALOG_ACTION, "Landroidx/navigation/NavDirections;", "navigateToSelectOrRechargePlan", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "openWebVew", "proceedToHomeScreen", "setupViewPager", "showAlert", "showContactUsScreen", "showInviteFriend", "referralLink", "showReferAndEarnScreen", "showUploadKYCScreen", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeviceHomeFragment extends DataBindingFragment<FragmentDeviceHomeBinding> {
    private List<DeviceList> airPurifierDeviceList;
    private FragmentDeviceHomeBinding dataBinding;
    private List<DeviceList> deviceList;
    private AlertDialog dialog;
    private boolean mBleConnected;
    private BluetoothGatt mBluetoothGatt;
    private final NavArgsLazy navArgs$delegate;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy selectDeviceHomeViewModel$delegate = LazyKt.lazy(new Function0<DeviceHomeViewModel>() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$selectDeviceHomeViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DeviceHomeViewModel invoke() {
            return (DeviceHomeViewModel) new ViewModelProvider(DeviceHomeFragment.this).get(DeviceHomeViewModel.class);
        }
    });
    private final int LOCATION_PERMISSION_CODE = 2;
    private int REQUEST_LOCATION_CODE = 101;
    private final String TAG = "livpurelogs";
    private String deviceSerialNumber = "";

    /* compiled from: DeviceHomeFragment.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceHomeViewModel.DeviceHomeNavigationStates.values().length];
            iArr[DeviceHomeViewModel.DeviceHomeNavigationStates.CHECK_KYC.ordinal()] = 1;
            iArr[DeviceHomeViewModel.DeviceHomeNavigationStates.CHECK_PAYMENT.ordinal()] = 2;
            iArr[DeviceHomeViewModel.DeviceHomeNavigationStates.SELECT_PLAN.ordinal()] = 3;
            iArr[DeviceHomeViewModel.DeviceHomeNavigationStates.UPDATE_KYC.ordinal()] = 4;
            iArr[DeviceHomeViewModel.DeviceHomeNavigationStates.CHECK_INSTALLATION.ordinal()] = 5;
            iArr[DeviceHomeViewModel.DeviceHomeNavigationStates.INSTALLATION_PENDING.ordinal()] = 6;
            iArr[DeviceHomeViewModel.DeviceHomeNavigationStates.HOME.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public int getLayoutId() {
        return R.layout.fragment_device_home;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public DeviceHomeFragment() {
        final DeviceHomeFragment deviceHomeFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(DeviceHomeFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$special$$inlined$navArgs$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Bundle invoke() {
                Bundle arguments = Fragment.this.getArguments();
                if (arguments != null) {
                    return arguments;
                }
                throw new IllegalStateException("Fragment " + Fragment.this + " has null arguments");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceHomeViewModel getSelectDeviceHomeViewModel() {
        return (DeviceHomeViewModel) this.selectDeviceHomeViewModel$delegate.getValue();
    }

    private final DeviceHomeFragmentArgs getNavArgs() {
        return (DeviceHomeFragmentArgs) this.navArgs$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public DeviceHomeViewModel getViewModel() {
        return getSelectDeviceHomeViewModel();
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final String getDeviceSerialNumber() {
        return this.deviceSerialNumber;
    }

    public final void setDeviceSerialNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceSerialNumber = str;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getSelectDeviceHomeViewModel().refreshHintView();
        listeners();
        Intrinsics.checkNotNullExpressionValue(AppEventsLogger.newLogger(getContext()), "newLogger(context)");
        if (LSApplication.Companion.isNetworkAvailable()) {
            DeviceHomeViewModel selectDeviceHomeViewModel = getSelectDeviceHomeViewModel();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            selectDeviceHomeViewModel.getUserDetails(requireActivity).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$$ExternalSyntheticLambda14
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DeviceHomeFragment.m315onViewCreated$lambda8(DeviceHomeFragment.this, (UserDetailsResponse) obj);
                }
            });
            DeviceHomeViewModel selectDeviceHomeViewModel2 = getSelectDeviceHomeViewModel();
            Context context = getContext();
            Intrinsics.checkNotNull(context);
            selectDeviceHomeViewModel2.getAllEnvyBLEResponse(context).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$$ExternalSyntheticLambda5
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DeviceHomeFragment.m321onViewCreated$lambda9(DeviceHomeFragment.this, (List) obj);
                }
            });
            return;
        }
        DeviceHomeViewModel selectDeviceHomeViewModel3 = getSelectDeviceHomeViewModel();
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
        selectDeviceHomeViewModel3.getOflineUserDetails(requireActivity2).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DeviceHomeFragment.m311onViewCreated$lambda15(DeviceHomeFragment.this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-8  reason: not valid java name */
    public static final void m315onViewCreated$lambda8(final DeviceHomeFragment this$0, UserDetailsResponse userDetailsResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual((Object) userDetailsResponse.getStatus(), (Object) true)) {
            this$0.getSelectDeviceHomeViewModel().getDeviceHomeNavigationState().observe(this$0.getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$$ExternalSyntheticLambda12
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DeviceHomeFragment.m316onViewCreated$lambda8$lambda4(DeviceHomeFragment.this, (DeviceHomeViewModel.DeviceHomeNavigationStates) obj);
                }
            });
            this$0.getSelectDeviceHomeViewModel().m333getSelectedDevice().observe(this$0.getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$$ExternalSyntheticLambda16
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DeviceHomeFragment.m320onViewCreated$lambda8$lambda7(DeviceHomeFragment.this, (DeviceList) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-8$lambda-4  reason: not valid java name */
    public static final void m316onViewCreated$lambda8$lambda4(final DeviceHomeFragment this$0, DeviceHomeViewModel.DeviceHomeNavigationStates deviceHomeNavigationStates) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (deviceHomeNavigationStates == null ? -1 : WhenMappings.$EnumSwitchMapping$0[deviceHomeNavigationStates.ordinal()]) {
            case 1:
                this$0.getSelectDeviceHomeViewModel().checkKYCStatus();
                return;
            case 2:
                this$0.getSelectDeviceHomeViewModel().checkPaymentStatus();
                return;
            case 3:
                if (this$0.isAdded()) {
                    this$0.openWebVew();
                    return;
                }
                return;
            case 4:
                if (this$0.isAdded()) {
                    User user = LSApplication.Companion.getUser();
                    if (Intrinsics.areEqual(user != null ? user.getRelocation_status() : null, "1")) {
                        this$0.showUploadKYCScreen();
                        return;
                    } else {
                        this$0.openWebVew();
                        return;
                    }
                }
                return;
            case 5:
                this$0.getSelectDeviceHomeViewModel().checkInstallationStatus();
                return;
            case 6:
                this$0.getSelectDeviceHomeViewModel().showHintView(R.drawable.ic_watch_later_white_150dp, "Your payment is complete and KYC Documents have been received. Our Delivery and Installation team would reach you shortly. (*T&C apply)", "Contact Us", "eKYC Documents Uploaded!", new Function0<Unit>() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$onViewCreated$1$1$1
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
                        DeviceHomeFragment.this.openWebVew();
                    }
                });
                return;
            case 7:
                this$0.getSelectDeviceHomeViewModel().hideHintView();
                DeviceHomeViewModel selectDeviceHomeViewModel = this$0.getSelectDeviceHomeViewModel();
                Context context = this$0.getContext();
                Intrinsics.checkNotNull(context);
                selectDeviceHomeViewModel.getAllDeviceDetails(context).observe(this$0.getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$$ExternalSyntheticLambda4
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DeviceHomeFragment.m317onViewCreated$lambda8$lambda4$lambda0(DeviceHomeFragment.this, (List) obj);
                    }
                });
                this$0.getSelectDeviceHomeViewModel().getAllAirPurifierDeviceDetails().observe(this$0.getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$$ExternalSyntheticLambda3
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DeviceHomeFragment.m318onViewCreated$lambda8$lambda4$lambda3(DeviceHomeFragment.this, (List) obj);
                    }
                });
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-8$lambda-4$lambda-0  reason: not valid java name */
    public static final void m317onViewCreated$lambda8$lambda4$lambda0(DeviceHomeFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAdded()) {
            List list = it;
            if (list == null || list.isEmpty()) {
                return;
            }
            if (this$0.checkIfLocationPermissionGranted()) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this$0.deviceList = it;
                this$0.setupViewPager();
                return;
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.deviceList = it;
            this$0.setupViewPager();
            this$0.onRequestPermissionsResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-8$lambda-4$lambda-3  reason: not valid java name */
    public static final void m318onViewCreated$lambda8$lambda4$lambda3(final DeviceHomeFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list = it;
        if (list == null || list.isEmpty()) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.airPurifierDeviceList = it;
        ViewPager2 viewPager2 = (ViewPager2) this$0._$_findCachedViewById(R.id.deviceAirPurifierViewPager);
        if (viewPager2.getAdapter() == null) {
            List<DeviceList> list2 = this$0.airPurifierDeviceList;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("airPurifierDeviceList");
                list2 = null;
            }
            viewPager2.setAdapter(new DevicePagerAdapter(list2, new Function1<Integer, Unit>() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$onViewCreated$1$1$3$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    DeviceHomeViewModel selectDeviceHomeViewModel;
                    selectDeviceHomeViewModel = DeviceHomeFragment.this.getSelectDeviceHomeViewModel();
                    selectDeviceHomeViewModel.onAirPurifierDeviceClicked(i);
                }
            }));
            viewPager2.setOffscreenPageLimit(1);
            final float dimension = viewPager2.getResources().getDimension(R.dimen.viewpager_next_item_visible) + viewPager2.getResources().getDimension(R.dimen.viewpager_current_item_horizontal_margin);
            viewPager2.setPageTransformer(new ViewPager2.PageTransformer() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$$ExternalSyntheticLambda7
                @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
                public final void transformPage(View view, float f) {
                    DeviceHomeFragment.m319onViewCreated$lambda8$lambda4$lambda3$lambda2$lambda1(dimension, view, f);
                }
            });
            Context context = viewPager2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            viewPager2.addItemDecoration(new HorizontalMarginItemDecoration(context, R.dimen.viewpager_current_item_horizontal_margin));
            return;
        }
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-8$lambda-4$lambda-3$lambda-2$lambda-1  reason: not valid java name */
    public static final void m319onViewCreated$lambda8$lambda4$lambda3$lambda2$lambda1(float f, View page, float f2) {
        Intrinsics.checkNotNullParameter(page, "page");
        page.setTranslationX((-f) * f2);
        page.setScaleY(1 - (Math.abs(f2) * 0.25f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-8$lambda-7  reason: not valid java name */
    public static final void m320onViewCreated$lambda8$lambda7(DeviceHomeFragment this$0, DeviceList device) {
        String str;
        HomeFragmentDirections.ActionHomeFragmentToAirPurifier actionHomeFragmentToAirPurifier;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getSelectDeviceHomeViewModel().getNextFragmentCalled()) {
            this$0.getSelectDeviceHomeViewModel().setNextFragmentCalled(false);
            String productType = device.getProductType();
            if (productType != null) {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                str = productType.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            if (!StringsKt.equals$default(str, "air-purifier", false, 2, null)) {
                Intrinsics.checkNotNullExpressionValue(device, "device");
                this$0.proceedToHomeScreen(device);
            } else if (device == null || (actionHomeFragmentToAirPurifier = HomeFragmentDirections.actionHomeFragmentToAirPurifier(device)) == null) {
            } else {
                this$0.navigate(actionHomeFragmentToAirPurifier);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-9  reason: not valid java name */
    public static final void m321onViewCreated$lambda9(DeviceHomeFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list = it;
        if (list == null || list.isEmpty()) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (list.size() > 0) {
            int i = 0;
            while (i < list.size()) {
                String serialNo = ((EnvyBLEResponse) it.get(i)).getSerialNo();
                Intrinsics.checkNotNull(serialNo);
                String response = ((EnvyBLEResponse) it.get(i)).getResponse();
                Intrinsics.checkNotNull(response);
                i++;
                if (Integer.valueOf(i).equals(Integer.valueOf(list.size() - 1))) {
                    DeviceHomeViewModel selectDeviceHomeViewModel = this$0.getSelectDeviceHomeViewModel();
                    Context context = this$0.getContext();
                    Intrinsics.checkNotNull(context);
                    selectDeviceHomeViewModel.offlineBLEStatus(context, serialNo, response, true);
                } else {
                    DeviceHomeViewModel selectDeviceHomeViewModel2 = this$0.getSelectDeviceHomeViewModel();
                    Context context2 = this$0.getContext();
                    Intrinsics.checkNotNull(context2);
                    selectDeviceHomeViewModel2.offlineBLEStatus(context2, serialNo, response, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-15  reason: not valid java name */
    public static final void m311onViewCreated$lambda15(final DeviceHomeFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getSelectDeviceHomeViewModel().getDeviceOfflineNavigationState().observe(this$0.getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$$ExternalSyntheticLambda11
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DeviceHomeFragment.m312onViewCreated$lambda15$lambda11(DeviceHomeFragment.this, (DeviceHomeViewModel.DeviceHomeNavigationStates) obj);
            }
        });
        this$0.getSelectDeviceHomeViewModel().m333getSelectedDevice().observe(this$0.getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$$ExternalSyntheticLambda15
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DeviceHomeFragment.m314onViewCreated$lambda15$lambda14(DeviceHomeFragment.this, (DeviceList) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-15$lambda-11  reason: not valid java name */
    public static final void m312onViewCreated$lambda15$lambda11(final DeviceHomeFragment this$0, DeviceHomeViewModel.DeviceHomeNavigationStates deviceHomeNavigationStates) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((deviceHomeNavigationStates == null ? -1 : WhenMappings.$EnumSwitchMapping$0[deviceHomeNavigationStates.ordinal()]) == 7) {
            this$0.getSelectDeviceHomeViewModel().hideHintView();
            DeviceHomeViewModel selectDeviceHomeViewModel = this$0.getSelectDeviceHomeViewModel();
            Context context = this$0.getContext();
            Intrinsics.checkNotNull(context);
            selectDeviceHomeViewModel.getAllOflineDeviceDetails(context).observe(this$0.getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$$ExternalSyntheticLambda2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DeviceHomeFragment.m313onViewCreated$lambda15$lambda11$lambda10(DeviceHomeFragment.this, (List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-15$lambda-11$lambda-10  reason: not valid java name */
    public static final void m313onViewCreated$lambda15$lambda11$lambda10(DeviceHomeFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAdded()) {
            List list = it;
            if (list == null || list.isEmpty()) {
                return;
            }
            try {
                if (this$0.checkIfLocationPermissionGranted()) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    this$0.deviceList = it;
                    this$0.setupViewPager();
                } else {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    this$0.deviceList = it;
                    this$0.setupViewPager();
                    this$0.onRequestPermissionsResult();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-15$lambda-14  reason: not valid java name */
    public static final void m314onViewCreated$lambda15$lambda14(DeviceHomeFragment this$0, DeviceList device) {
        String str;
        HomeFragmentDirections.ActionHomeFragmentToAirPurifier actionHomeFragmentToAirPurifier;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getSelectDeviceHomeViewModel().getNextFragmentCalled()) {
            this$0.getSelectDeviceHomeViewModel().setNextFragmentCalled(false);
            String productType = device.getProductType();
            if (productType != null) {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                str = productType.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            if (!StringsKt.equals$default(str, "air-purifier", false, 2, null)) {
                Intrinsics.checkNotNullExpressionValue(device, "device");
                this$0.proceedToHomeScreen(device);
            } else if (device == null || (actionHomeFragmentToAirPurifier = HomeFragmentDirections.actionHomeFragmentToAirPurifier(device)) == null) {
            } else {
                this$0.navigate(actionHomeFragmentToAirPurifier);
            }
        }
    }

    private final void listeners() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            FragmentDeviceHomeBinding fragmentDeviceHomeBinding = this.dataBinding;
            FragmentDeviceHomeBinding fragmentDeviceHomeBinding2 = null;
            if (fragmentDeviceHomeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                fragmentDeviceHomeBinding = null;
            }
            fragmentDeviceHomeBinding.knowMoreLL.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DeviceHomeFragment.m309listeners$lambda16(DeviceHomeFragment.this, view);
                }
            });
            FragmentDeviceHomeBinding fragmentDeviceHomeBinding3 = this.dataBinding;
            if (fragmentDeviceHomeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                fragmentDeviceHomeBinding2 = fragmentDeviceHomeBinding3;
            }
            fragmentDeviceHomeBinding2.inviteFriend.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DeviceHomeFragment.m310listeners$lambda17(DeviceHomeFragment.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-16  reason: not valid java name */
    public static final void m309listeners$lambda16(DeviceHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showReferAndEarnScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listeners$lambda-17  reason: not valid java name */
    public static final void m310listeners$lambda17(DeviceHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (LSApplication.Companion.getReferralLink() != null && !Intrinsics.areEqual(LSApplication.Companion.getReferralLink(), "")) {
            String referralLink = LSApplication.Companion.getReferralLink();
            Intrinsics.checkNotNull(referralLink);
            this$0.showInviteFriend(referralLink);
            return;
        }
        this$0.getReferralLink();
    }

    private final void showReferAndEarnScreen() {
        NavDirections actionHomeFragmentToReferAndEarnFragment = HomeFragmentDirections.actionHomeFragmentToReferAndEarnFragment();
        Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToReferAndEarnFragment, "actionHomeFragmentToReferAndEarnFragment()");
        FragmentKt.findNavController(this).navigate(actionHomeFragmentToReferAndEarnFragment);
    }

    private final void getReferralLink() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            DeviceHomeViewModel selectDeviceHomeViewModel = getSelectDeviceHomeViewModel();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            selectDeviceHomeViewModel.getReferralLink(requireActivity).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$$ExternalSyntheticLambda13
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DeviceHomeFragment.m308getReferralLink$lambda18(DeviceHomeFragment.this, (ReferralLinkResponse) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getReferralLink$lambda-18  reason: not valid java name */
    public static final void m308getReferralLink$lambda18(DeviceHomeFragment this$0, ReferralLinkResponse referralLinkResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (LSApplication.Companion.getReferralLink() == null || Intrinsics.areEqual(LSApplication.Companion.getReferralLink(), "")) {
            return;
        }
        String referralLink = LSApplication.Companion.getReferralLink();
        Intrinsics.checkNotNull(referralLink);
        this$0.showInviteFriend(referralLink);
    }

    private final void showInviteFriend(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        StringBuilder sb = new StringBuilder();
        sb.append("Refer & Earn\nGet instant ₹100 discount. Subscribe to Livpure Smart RO today.\nApply my code ");
        User user = LSApplication.Companion.getUser();
        sb.append(user != null ? user.getReferralCode() : null);
        sb.append(" now and subscribe to pure drinking water at home.\nClick here to know more :- \n");
        sb.append(str);
        intent.putExtra("android.intent.extra.TEXT", sb.toString());
        intent.setType(StringBody.CONTENT_TYPE);
        startActivity(Intent.createChooser(intent, null));
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentDeviceHomeBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.dataBinding = dataBinding;
        dataBinding.setViewModel(getSelectDeviceHomeViewModel());
    }

    private final boolean checkIfLocationPermissionGranted() {
        FragmentActivity activity = getActivity();
        Integer valueOf = activity != null ? Integer.valueOf(ContextCompat.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION")) : null;
        return valueOf != null && valueOf.intValue() == 0;
    }

    public final void onRequestPermissionsResult() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this.LOCATION_PERMISSION_CODE);
        }
    }

    public final void setupViewPager() {
        String str;
        Bundle arguments = getArguments();
        if ((arguments != null ? arguments.getString("serialNumber") : null) == null) {
            this.deviceSerialNumber = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else {
            Bundle arguments2 = getArguments();
            String string = arguments2 != null ? arguments2.getString("serialNumber") : null;
            Intrinsics.checkNotNull(string);
            this.deviceSerialNumber = string;
        }
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("serialNumber: ");
        Bundle arguments3 = getArguments();
        sb.append(arguments3 != null ? arguments3.getString("serialNumber") : null);
        Log.e(str2, sb.toString());
        if (Intrinsics.areEqual(this.deviceSerialNumber, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            ViewPager2 viewPager2 = (ViewPager2) _$_findCachedViewById(R.id.deviceViewPager);
            if (viewPager2.getAdapter() == null) {
                List<DeviceList> list = this.deviceList;
                if (list == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deviceList");
                    list = null;
                }
                viewPager2.setAdapter(new DevicePagerAdapter(list, new Function1<Integer, Unit>() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$setupViewPager$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i) {
                        DeviceHomeViewModel selectDeviceHomeViewModel;
                        selectDeviceHomeViewModel = DeviceHomeFragment.this.getSelectDeviceHomeViewModel();
                        selectDeviceHomeViewModel.onDeviceClicked(i);
                    }
                }));
                viewPager2.setOffscreenPageLimit(1);
                final float dimension = viewPager2.getResources().getDimension(R.dimen.viewpager_next_item_visible) + viewPager2.getResources().getDimension(R.dimen.viewpager_current_item_horizontal_margin);
                viewPager2.setPageTransformer(new ViewPager2.PageTransformer() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$$ExternalSyntheticLambda6
                    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
                    public final void transformPage(View view, float f) {
                        DeviceHomeFragment.m322setupViewPager$lambda23$lambda22(dimension, view, f);
                    }
                });
                Context context = viewPager2.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                viewPager2.addItemDecoration(new HorizontalMarginItemDecoration(context, R.dimen.viewpager_current_item_horizontal_margin));
            } else {
                RecyclerView.Adapter adapter = viewPager2.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
            }
        } else {
            List<DeviceList> list2 = this.deviceList;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deviceList");
                list2 = null;
            }
            for (DeviceList deviceList : list2) {
                if (Intrinsics.areEqual(this.deviceSerialNumber, deviceList.getSerialNo())) {
                    Bundle arguments4 = getArguments();
                    if (arguments4 != null) {
                        arguments4.clear();
                    }
                    proceedToHomeScreen(deviceList);
                    return;
                }
            }
        }
        AppLifeCycleManager.Companion companion = AppLifeCycleManager.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "this.requireContext()");
        if (Intrinsics.areEqual(companion.getInstance(requireContext).getHasNotificationDeeplink(), "")) {
            return;
        }
        AppLifeCycleManager.Companion companion2 = AppLifeCycleManager.Companion;
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "this.requireContext()");
        String hasNotificationDeeplink = companion2.getInstance(requireContext2).getHasNotificationDeeplink();
        if (hasNotificationDeeplink != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            str = hasNotificationDeeplink.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toUpperCase(locale)");
        } else {
            str = null;
        }
        if (StringsKt.equals$default(str, "REFERRAL", false, 2, null)) {
            NavDirections actionHomeFragmentToReferAndEarnFragment = HomeFragmentDirections.actionHomeFragmentToReferAndEarnFragment();
            Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToReferAndEarnFragment, "actionHomeFragmentToReferAndEarnFragment()");
            navigate(actionHomeFragmentToReferAndEarnFragment);
        }
        Context context2 = getContext();
        if (context2 != null) {
            AppLifeCycleManager.Companion.getInstance(context2).setHasNotificationDeeplink("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupViewPager$lambda-23$lambda-22  reason: not valid java name */
    public static final void m322setupViewPager$lambda23$lambda22(float f, View page, float f2) {
        Intrinsics.checkNotNullParameter(page, "page");
        page.setTranslationX((-f) * f2);
        page.setScaleY(1 - (Math.abs(f2) * 0.25f));
    }

    private final void proceedToHomeScreen(DeviceList deviceList) {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            Intrinsics.checkNotNull(alertDialog);
            if (alertDialog.isShowing()) {
                AlertDialog alertDialog2 = this.dialog;
                Intrinsics.checkNotNull(alertDialog2);
                alertDialog2.dismiss();
            }
        }
        if (checkGPSEnabled()) {
            if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(requireActivity(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
                checkLocationPermission();
            }
            try {
                if (StringsKt.equals(deviceList.getProductType(), "bolt-waas-wifi-ble", true) && Intrinsics.areEqual((Object) deviceList.isConfigured(), (Object) false)) {
                    HomeFragmentDirections.ActionHomeFragmentToBoltSettingsFragment actionHomeFragmentToBoltSettingsFragment = HomeFragmentDirections.actionHomeFragmentToBoltSettingsFragment(deviceList);
                    Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToBoltSettingsFragment, "actionHomeFragmentToBolt…tingsFragment(deviceList)");
                    navigate(actionHomeFragmentToBoltSettingsFragment);
                    return;
                }
                if (!StringsKt.equals(deviceList.getProductType(), "magna-waas", true) && !StringsKt.equals(deviceList.getProductType(), "zingerhotwaas", true)) {
                    if (!StringsKt.equals(deviceList.getProductType(), "atlantic-mountain-waas", true) && !StringsKt.equals(deviceList.getProductType(), "liv-knight+", true)) {
                        if (StringsKt.equals(deviceList.getProductType(), "airtowater", true)) {
                            HomeFragmentDirections.ActionHomeFragmentToAirToWater actionHomeFragmentToAirToWater = HomeFragmentDirections.actionHomeFragmentToAirToWater(deviceList);
                            Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToAirToWater, "actionHomeFragmentToAirToWater(deviceList)");
                            navigate(actionHomeFragmentToAirToWater);
                            return;
                        } else if (StringsKt.equals(deviceList.getProductType(), "air-purifier", true)) {
                            HomeFragmentDirections.ActionHomeFragmentToAirPurifier actionHomeFragmentToAirPurifier = HomeFragmentDirections.actionHomeFragmentToAirPurifier(deviceList);
                            Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToAirPurifier, "actionHomeFragmentToAirPurifier(deviceList)");
                            navigate(actionHomeFragmentToAirPurifier);
                            return;
                        } else {
                            try {
                                String productType = deviceList.getProductType();
                                Intrinsics.checkNotNull(productType);
                                if (StringsKt.contains((CharSequence) productType, (CharSequence) "UNLTD", true)) {
                                    HomeFragmentDirections.ActionHomeFragmentToUnlimiterWaterHomeFragment actionHomeFragmentToUnlimiterWaterHomeFragment = HomeFragmentDirections.actionHomeFragmentToUnlimiterWaterHomeFragment(deviceList);
                                    Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToUnlimiterWaterHomeFragment, "actionHomeFragmentToUnli…                        )");
                                    navigate(actionHomeFragmentToUnlimiterWaterHomeFragment);
                                } else {
                                    HomeFragmentDirections.ActionHomeFragmentToEnvyHome actionHomeFragmentToEnvyHome = HomeFragmentDirections.actionHomeFragmentToEnvyHome(deviceList);
                                    Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToEnvyHome, "actionHomeFragmentToEnvyHome(deviceList)");
                                    navigate(actionHomeFragmentToEnvyHome);
                                }
                                return;
                            } catch (Exception unused) {
                                HomeFragmentDirections.ActionHomeFragmentToEnvyHome actionHomeFragmentToEnvyHome2 = HomeFragmentDirections.actionHomeFragmentToEnvyHome(deviceList);
                                Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToEnvyHome2, "actionHomeFragmentToEnvyHome(deviceList)");
                                navigate(actionHomeFragmentToEnvyHome2);
                                return;
                            }
                        }
                    }
                    HomeFragmentDirections.ActionHomeFragmentToDispenserAtlantic actionHomeFragmentToDispenserAtlantic = HomeFragmentDirections.actionHomeFragmentToDispenserAtlantic(deviceList);
                    Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToDispenserAtlantic, "actionHomeFragmentToDispenserAtlantic(deviceList)");
                    navigate(actionHomeFragmentToDispenserAtlantic);
                    return;
                }
                HomeFragmentDirections.ActionHomeFragmentToDispenser actionHomeFragmentToDispenser = HomeFragmentDirections.actionHomeFragmentToDispenser(deviceList);
                Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToDispenser, "actionHomeFragmentToDispenser(deviceList)");
                navigate(actionHomeFragmentToDispenser);
            } catch (IllegalArgumentException unused2) {
            }
        }
    }

    private final void showUploadKYCScreen() {
        NavDestination currentDestination = FragmentKt.findNavController(this).getCurrentDestination();
        boolean z = false;
        if (currentDestination != null && currentDestination.getId() == R.id.homeFragment) {
            z = true;
        }
        if (z) {
            NavDirections actionHomeFragmentToKycUpload = HomeFragmentDirections.actionHomeFragmentToKycUpload();
            Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToKycUpload, "actionHomeFragmentToKycUpload()");
            navigate(actionHomeFragmentToKycUpload);
        }
    }

    public final void openWebVew() {
        NavGraphDirections.ActionGlobalOnBoardingWebViewFragment actionGlobalOnBoardingWebViewFragment = HomeFragmentDirections.actionGlobalOnBoardingWebViewFragment(R.string.onboarding_pending);
        Intrinsics.checkNotNullExpressionValue(actionGlobalOnBoardingWebViewFragment, "actionGlobalOnBoardingWe…tring.onboarding_pending)");
        FragmentKt.findNavController(this).navigate(actionGlobalOnBoardingWebViewFragment);
    }

    private final void navigateToSelectOrRechargePlan() {
        try {
            HomeFragmentDirections.ActionHomeFragmentToSelectPlanOrRechargeFragment actionHomeFragmentToSelectPlanOrRechargeFragment = HomeFragmentDirections.actionHomeFragmentToSelectPlanOrRechargeFragment(new DeviceList("New RO", "", "", "", false, "", ""));
            Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToSelectPlanOrRechargeFragment, "actionHomeFragmentToSele…RechargeFragment(_device)");
            navigate(actionHomeFragmentToSelectPlanOrRechargeFragment);
        } catch (IllegalArgumentException unused) {
        }
    }

    private final void showContactUsScreen() {
        HomeFragmentDirections.ActionHomeFragmentToContactUsFragment actionHomeFragmentToContactUsFragment = HomeFragmentDirections.actionHomeFragmentToContactUsFragment("1");
        Intrinsics.checkNotNullExpressionValue(actionHomeFragmentToContactUsFragment, "actionHomeFragmentToContactUsFragment(\"1\")");
        navigate(actionHomeFragmentToContactUsFragment);
    }

    private final void navigate(NavDirections navDirections) {
        FragmentKt.findNavController(this).navigate(navDirections);
    }

    private final boolean checkGPSEnabled() {
        if (!isLocationEnabled()) {
            showAlert();
        }
        return isLocationEnabled();
    }

    private final void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle("Enable Location").setMessage("Your Locations Settings is set to 'off'.\nPlease Enable Location to use this app").setCancelable(true).setPositiveButton("Location Settings", new DialogInterface.OnClickListener() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DeviceHomeFragment.m323showAlert$lambda25(DeviceHomeFragment.this, dialogInterface, i);
            }
        });
        AlertDialog create = builder.create();
        this.dialog = create;
        Intrinsics.checkNotNull(create);
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showAlert$lambda-25  reason: not valid java name */
    public static final void m323showAlert$lambda25(DeviceHomeFragment this$0, DialogInterface d, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(d, "d");
        d.dismiss();
        this$0.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    private final boolean isLocationEnabled() {
        Object systemService = requireActivity().getSystemService("location");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled(AndroidContextPlugin.NETWORK_KEY);
    }

    private final void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(requireActivity(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.ACCESS_FINE_LOCATION")) {
                new AlertDialog.Builder(requireActivity()).setTitle("Location Permission Needed").setCancelable(false).setMessage("This app needs the Location permission, please accept to use location functionality").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.livpure.safedrink.app.DeviceHomeFragment$$ExternalSyntheticLambda8
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        DeviceHomeFragment.m307checkLocationPermission$lambda26(DeviceHomeFragment.this, dialogInterface, i);
                    }
                }).create().show();
            } else {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this.REQUEST_LOCATION_CODE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkLocationPermission$lambda-26  reason: not valid java name */
    public static final void m307checkLocationPermission$lambda26(DeviceHomeFragment this$0, DialogInterface d, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(d, "d");
        ActivityCompat.requestPermissions(this$0.requireActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this$0.REQUEST_LOCATION_CODE);
        d.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (i == this.REQUEST_LOCATION_CODE) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                if (ContextCompat.checkSelfPermission(requireActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
                    Toast.makeText(requireActivity(), "permission granted", 1).show();
                    return;
                }
                return;
            }
            Toast.makeText(requireActivity(), "permission denied", 1).show();
        }
    }
}

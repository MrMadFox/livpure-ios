package com.livpure.safedrink.login;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amplitude.api.Constants;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.gun0912.tedpermission.TedPermissionResult;
import com.livpure.safedrink.BuildConfig;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.MainViewModel;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.views.BaseFragment;
import com.livpure.safedrink.segment.SegmentEventNames;
import com.livpure.safedrink.segment.SegmentProperties;
import com.livpure.safedrink.servicefirebase.FcmEventListener;
import com.livpure.safedrink.utils.MyVolleySingleton;
import com.moengage.core.Properties;
import com.moengage.core.analytics.MoEAnalyticsHelper;
import com.moengage.core.internal.CoreConstants;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import com.moengage.firebase.MoEFireBaseHelper;
import com.moengage.pushbase.internal.PushConstantsInternal;
import com.tedpark.tedpermission.rx2.TedRx2Permission;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
/* compiled from: SplashFragment.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0003J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020\"H\u0014J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\u001a2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u0011H\u0002J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u0011H\u0002J\b\u0010/\u001a\u00020\u001aH\u0002J\b\u00100\u001a\u00020\u001aH\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u00061"}, d2 = {"Lcom/livpure/safedrink/login/SplashFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/BaseFragment;", "()V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "mainViewModel", "Lcom/livpure/safedrink/app/MainViewModel;", "getMainViewModel", "()Lcom/livpure/safedrink/app/MainViewModel;", "mainViewModel$delegate", "Lkotlin/Lazy;", "notificationPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "setPrefs", "(Landroid/content/SharedPreferences;)V", "appPermissionDialog", "", "checkNotificationPermission", "generateTokenRequest", "getLayoutId", "", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "isToolbarVisible", "", "onAttach", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "registerToken", "token", "sendFirstInstallEvent", "showNotificationPermissionRationale", "showSettingDialog", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SplashFragment extends BaseFragment {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private Activity activity;
    private final Lazy mainViewModel$delegate;
    private final ActivityResultLauncher<String> notificationPermissionLauncher;
    private SharedPreferences prefs;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerToken$lambda-2  reason: not valid java name */
    public static final void m1102registerToken$lambda2(VolleyError volleyError) {
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
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
        return R.layout.fragment_splash;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    protected boolean isToolbarVisible() {
        return false;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public SplashFragment() {
        final SplashFragment splashFragment = this;
        this.mainViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(splashFragment, Reflection.getOrCreateKotlinClass(MainViewModel.class), new Function0<ViewModelStore>() { // from class: com.livpure.safedrink.login.SplashFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = Fragment.this.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.livpure.safedrink.login.SplashFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = Function0.this;
                if (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) {
                    CreationExtras defaultViewModelCreationExtras = splashFragment.requireActivity().getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.livpure.safedrink.login.SplashFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = Fragment.this.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        ActivityResultLauncher<String> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.livpure.safedrink.login.SplashFragment$$ExternalSyntheticLambda3
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SplashFragment.m1100notificationPermissionLauncher$lambda0(SplashFragment.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.notificationPermissionLauncher = registerForActivityResult;
    }

    private final MainViewModel getMainViewModel() {
        return (MainViewModel) this.mainViewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public AnalyticsViewModel getViewModel() {
        return (AnalyticsViewModel) new ViewModelProvider(this).get(AnalyticsViewModel.class);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final void setActivity(Activity activity) {
        this.activity = activity;
    }

    public final SharedPreferences getPrefs() {
        return this.prefs;
    }

    public final void setPrefs(SharedPreferences sharedPreferences) {
        this.prefs = sharedPreferences;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: notificationPermissionLauncher$lambda-0  reason: not valid java name */
    public static final void m1100notificationPermissionLauncher$lambda0(SplashFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!bool.booleanValue()) {
            if (this$0.shouldShowRequestPermissionRationale(PushConstantsInternal.NOTIFICATION_PERMISSION)) {
                this$0.showNotificationPermissionRationale();
                return;
            } else {
                this$0.appPermissionDialog();
                return;
            }
        }
        this$0.appPermissionDialog();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Activity activity = this.activity;
        this.prefs = activity != null ? activity.getSharedPreferences(BuildConfig.APPLICATION_ID, 0) : null;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        checkNotificationPermission();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.activity = context instanceof Activity ? (Activity) context : null;
    }

    private final void appPermissionDialog() {
        TedRx2Permission.Builder with = TedRx2Permission.with(getContext());
        Activity activity = this.activity;
        TedRx2Permission.Builder rationaleTitle = with.setRationaleTitle(activity != null ? activity.getString(R.string.location_heading) : null);
        Activity activity2 = this.activity;
        rationaleTitle.setRationaleMessage(activity2 != null ? activity2.getString(R.string.location_declaration) : null).setDeniedCloseButtonText("Cancel").setGotoSettingButtonText("OK").setPermissions("android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION").request().subscribeWith(new SingleObserver<TedPermissionResult>() { // from class: com.livpure.safedrink.login.SplashFragment$appPermissionDialog$1
            @Override // io.reactivex.SingleObserver
            public void onError(Throwable e) {
                Intrinsics.checkNotNullParameter(e, "e");
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable d) {
                Intrinsics.checkNotNullParameter(d, "d");
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(TedPermissionResult tedPermissionResult) {
                Intrinsics.checkNotNullParameter(tedPermissionResult, "tedPermissionResult");
                SplashFragment.this.generateTokenRequest();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void generateTokenRequest() {
        MoEFireBaseHelper.Companion.getInstance().generatePushToken(new FcmEventListener() { // from class: com.livpure.safedrink.login.SplashFragment$generateTokenRequest$1
            @Override // com.livpure.safedrink.servicefirebase.FcmEventListener
            public void navValue(String str) {
                Log.e("TOKEN", "TOKEN:  " + str);
                if (Intrinsics.areEqual(str, "")) {
                    return;
                }
                if (str != null) {
                    SplashFragment.this.registerToken(str);
                } else {
                    SplashFragment.this.registerToken("");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.String] */
    public final void registerToken(final String str) {
        sendFirstInstallEvent(str);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        Activity activity = this.activity;
        objectRef.element = Settings.Secure.getString(activity != null ? activity.getContentResolver() : null, CoreConstants.GENERIC_PARAM_V2_KEY_ANDROID_ID);
        final SplashFragment$$ExternalSyntheticLambda5 splashFragment$$ExternalSyntheticLambda5 = new Response.Listener() { // from class: com.livpure.safedrink.login.SplashFragment$$ExternalSyntheticLambda5
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                SplashFragment.m1101registerToken$lambda1((String) obj);
            }
        };
        final SplashFragment$$ExternalSyntheticLambda4 splashFragment$$ExternalSyntheticLambda4 = new Response.ErrorListener() { // from class: com.livpure.safedrink.login.SplashFragment$$ExternalSyntheticLambda4
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                SplashFragment.m1102registerToken$lambda2(volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(splashFragment$$ExternalSyntheticLambda5, splashFragment$$ExternalSyntheticLambda4) { // from class: com.livpure.safedrink.login.SplashFragment$registerToken$stringRequest$1
            @Override // com.android.volley.Request
            protected Map<String, String> getParams() {
                HashMap hashMap = new HashMap();
                hashMap.put("deviceId", objectRef.element);
                hashMap.put("key", str);
                hashMap.put("projectName", "waas");
                hashMap.put("applicationType", "1");
                hashMap.put("source", Constants.PLATFORM);
                hashMap.put(SegmentProperties.VERSION_CODE, "274");
                hashMap.put(SegmentProperties.VERSION_NAME, BuildConfig.VERSION_NAME);
                String RELEASE = Build.VERSION.RELEASE;
                Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
                hashMap.put(SegmentProperties.DEVICE_VERSION, RELEASE);
                hashMap.put(SegmentProperties.SDK_VERSION, "" + Build.VERSION.SDK_INT);
                String MODEL = Build.MODEL;
                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                hashMap.put("deviceModel", MODEL);
                String BRAND = Build.BRAND;
                Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                hashMap.put(SegmentProperties.BRAND, BRAND);
                Log.e(NativeProtocol.WEB_DIALOG_PARAMS, hashMap.toString());
                return hashMap;
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000, 1, 1.0f));
        Log.e("stringRequest", stringRequest.toString());
        MyVolleySingleton.getInstance(requireContext()).getRequestQueue().add(stringRequest);
        MoEFireBaseHelper companion = MoEFireBaseHelper.Companion.getInstance();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        companion.passPushToken(requireContext, str);
        new Handler().postDelayed(new Runnable() { // from class: com.livpure.safedrink.login.SplashFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                SplashFragment.m1103registerToken$lambda3(SplashFragment.this);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerToken$lambda-1  reason: not valid java name */
    public static final void m1101registerToken$lambda1(String str) {
        Log.e("Response", String.valueOf(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerToken$lambda-3  reason: not valid java name */
    public static final void m1103registerToken$lambda3(SplashFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getMainViewModel().setSplashShown();
    }

    private final void sendFirstInstallEvent(String str) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        SharedPreferences sharedPreferences = this.prefs;
        boolean z = true;
        if ((sharedPreferences == null || !sharedPreferences.getBoolean("firstRun", true)) ? false : false) {
            Activity activity = this.activity;
            Properties addAttribute = new Properties().addAttribute("source", Constants.PLATFORM).addAttribute(SegmentProperties.FIREBASE_TOKEN, str).addAttribute(SegmentProperties.DEVICE_ID, Settings.Secure.getString(activity != null ? activity.getContentResolver() : null, CoreConstants.GENERIC_PARAM_V2_KEY_ANDROID_ID)).addAttribute(SegmentProperties.VERSION_CODE, Integer.valueOf((int) BuildConfig.VERSION_CODE)).addAttribute(SegmentProperties.VERSION_NAME, BuildConfig.VERSION_NAME).addAttribute(SegmentProperties.DEVICE_VERSION, Build.VERSION.RELEASE).addAttribute(SegmentProperties.SDK_VERSION, Integer.valueOf(Build.VERSION.SDK_INT)).addAttribute("deviceModel", Build.MODEL).addAttribute(SegmentProperties.BRAND, Build.BRAND);
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            moEAnalyticsHelper.trackEvent(requireContext, SegmentEventNames.NEW_INSTALL, addAttribute);
            SharedPreferences sharedPreferences2 = this.prefs;
            if (sharedPreferences2 == null || (edit = sharedPreferences2.edit()) == null || (putBoolean = edit.putBoolean("firstRun", false)) == null) {
                return;
            }
            putBoolean.apply();
        }
    }

    private final void showNotificationPermissionRationale() {
        new MaterialAlertDialogBuilder(requireContext(), 2132017257).setTitle((CharSequence) "Alert").setMessage((CharSequence) "Notification permission is required, to show notification").setPositiveButton((CharSequence) "Ok", new DialogInterface.OnClickListener() { // from class: com.livpure.safedrink.login.SplashFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SplashFragment.m1104showNotificationPermissionRationale$lambda4(SplashFragment.this, dialogInterface, i);
            }
        }).setNegativeButton((CharSequence) "Cancel", new DialogInterface.OnClickListener() { // from class: com.livpure.safedrink.login.SplashFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SplashFragment.m1105showNotificationPermissionRationale$lambda5(SplashFragment.this, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showNotificationPermissionRationale$lambda-4  reason: not valid java name */
    public static final void m1104showNotificationPermissionRationale$lambda4(SplashFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notificationPermissionLauncher.launch(PushConstantsInternal.NOTIFICATION_PERMISSION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showNotificationPermissionRationale$lambda-5  reason: not valid java name */
    public static final void m1105showNotificationPermissionRationale$lambda5(SplashFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notificationPermissionLauncher.launch(PushConstantsInternal.NOTIFICATION_PERMISSION);
    }

    private final void showSettingDialog() {
        new MaterialAlertDialogBuilder(requireContext(), 2132017257).setTitle((CharSequence) "Notification Permission").setMessage((CharSequence) "Notification permission is required, Please allow notification permission from setting").setPositiveButton((CharSequence) "Ok", new DialogInterface.OnClickListener() { // from class: com.livpure.safedrink.login.SplashFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SplashFragment.m1106showSettingDialog$lambda6(SplashFragment.this, dialogInterface, i);
            }
        }).setNegativeButton((CharSequence) "Cancel", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showSettingDialog$lambda-6  reason: not valid java name */
    public static final void m1106showSettingDialog$lambda6(SplashFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:com.livpure.safedrink"));
        this$0.startActivity(intent);
    }

    private final void checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= 33) {
            if (ContextCompat.checkSelfPermission(requireContext(), PushConstantsInternal.NOTIFICATION_PERMISSION) != 0) {
                this.notificationPermissionLauncher.launch(PushConstantsInternal.NOTIFICATION_PERMISSION);
                return;
            } else {
                appPermissionDialog();
                return;
            }
        }
        appPermissionDialog();
    }
}

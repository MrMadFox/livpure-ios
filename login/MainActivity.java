package com.livpure.safedrink.login;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationViewKt;
import androidx.navigation.ui.ToolbarKt;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amplitude.api.Constants;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.login.widget.ToolTipPopup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.livpure.safedrink.BuildConfig;
import com.livpure.safedrink.NavGraphDirections;
import com.livpure.safedrink.R;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.api.ConnectionStateMonitor;
import com.livpure.safedrink.api.DisposableManager;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.app.MainViewModel;
import com.livpure.safedrink.common.FileUtilKt;
import com.livpure.safedrink.common.UiUtilKt;
import com.livpure.safedrink.databinding.ActivitySingleMainBinding;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.segment.SegmentEventNames;
import com.livpure.safedrink.segment.SegmentProperties;
import com.livpure.safedrink.servicefirebase.ApplicationBackgroundListener;
import com.livpure.safedrink.servicefirebase.ClickActionCallback;
import com.livpure.safedrink.servicefirebase.CustomPushMessageListener;
import com.livpure.safedrink.servicefirebase.FcmEventListener;
import com.livpure.safedrink.servicefirebase.InAppCallback;
import com.livpure.safedrink.servicefirebase.SelfHandledCallback;
import com.livpure.safedrink.subscription.plan.data.model.payment.PaymentPayload;
import com.livpure.safedrink.utils.Constant;
import com.livpure.safedrink.utils.MyVolleySingleton;
import com.livpure.safedrink.utils.UpdateChecker;
import com.moengage.core.MoECoreHelper;
import com.moengage.core.Properties;
import com.moengage.core.analytics.MoEAnalyticsHelper;
import com.moengage.core.internal.CoreConstants;
import com.moengage.core.internal.logger.LogManagerKt;
import com.moengage.firebase.MoEFireBaseHelper;
import com.moengage.inapp.MoEInAppHelper;
import com.moengage.pushbase.MoEPushConstants;
import com.moengage.pushbase.MoEPushHelper;
import com.moengage.richnotification.internal.RichPushConstantsKt;
import com.newrelic.agent.android.NewRelic;
import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.JsonLexerKt;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010*\u001a\u00020+H\u0002J\u000e\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020.J\b\u00101\u001a\u00020+H\u0002J\b\u00102\u001a\u00020.H\u0002J\b\u00103\u001a\u00020+H\u0002J\u0016\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u000207J\b\u00108\u001a\u00020+H\u0002J\u001e\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H\u0002J\u001e\u0010?\u001a\u00020+2\u0006\u0010:\u001a\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H\u0002J\u001e\u0010@\u001a\u00020+2\u0006\u0010:\u001a\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H\u0002J\b\u0010A\u001a\u00020+H\u0002J\b\u0010B\u001a\u00020+H\u0002J\b\u0010C\u001a\u00020.H\u0002J\u0010\u0010D\u001a\u00020+2\u0006\u0010:\u001a\u00020;H\u0002J\b\u0010E\u001a\u00020+H\u0002J\u0010\u0010F\u001a\u00020+2\u0006\u0010G\u001a\u00020HH\u0002J\u0006\u0010I\u001a\u00020+J\"\u0010J\u001a\u00020+2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\b\u0010M\u001a\u0004\u0018\u00010NH\u0014J\u0012\u0010O\u001a\u00020+2\b\u0010P\u001a\u0004\u0018\u00010QH\u0014J\u0012\u0010R\u001a\u00020+2\b\u0010S\u001a\u0004\u0018\u00010NH\u0014J\b\u0010T\u001a\u00020+H\u0014J$\u0010U\u001a\u00020+2\u0006\u0010V\u001a\u00020\u00052\b\u0010W\u001a\u0004\u0018\u00010\t2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\u001c\u0010Z\u001a\u00020+2\b\u0010[\u001a\u0004\u0018\u00010\t2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J+\u0010\\\u001a\u00020+2\u0006\u0010K\u001a\u00020\u00052\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\t0^2\u0006\u0010_\u001a\u00020`H\u0016¢\u0006\u0002\u0010aJ\b\u0010b\u001a\u00020+H\u0014J\b\u0010c\u001a\u00020+H\u0014J)\u0010d\u001a\u00020+2!\u0010e\u001a\u001d\u0012\u0013\u0012\u00110g¢\u0006\f\bh\u0012\b\bi\u0012\u0004\b\b(j\u0012\u0004\u0012\u00020+0fJ\u0010\u0010k\u001a\u00020+2\u0006\u0010l\u001a\u00020\tH\u0002J\u0010\u0010m\u001a\u00020+2\u0006\u0010l\u001a\u00020\tH\u0002J\u001e\u0010n\u001a\u00020+2\u0006\u0010:\u001a\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H\u0002J\u0006\u0010o\u001a\u00020+J\b\u0010p\u001a\u00020+H\u0002J\b\u0010q\u001a\u00020+H\u0002J\u0010\u0010r\u001a\u00020+2\u0006\u0010s\u001a\u00020\tH\u0002J\u0006\u0010t\u001a\u00020+J\b\u0010u\u001a\u00020+H\u0002JN\u0010v\u001a\u00020+2\u0006\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020\t2\b\u0010z\u001a\u0004\u0018\u00010\t2\b\u0010{\u001a\u0004\u0018\u00010\t2\b\u0010|\u001a\u0004\u0018\u00010\t2\b\u0010}\u001a\u0004\u0018\u00010\t2\u0006\u0010~\u001a\u00020\t2\u0006\u0010\u007f\u001a\u00020\tJ\t\u0010\u0080\u0001\u001a\u00020+H\u0002J\t\u0010\u0081\u0001\u001a\u00020+H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019¨\u0006\u0082\u0001"}, d2 = {"Lcom/livpure/safedrink/login/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/razorpay/PaymentResultWithDataListener;", "()V", "APP_UPDATE_TYPE_SUPPORTED", "", "REQUEST_LOCATION_CODE", "REQUEST_UPDATE", "apiVersion", "", "appBarConfiguration", "Landroidx/navigation/ui/AppBarConfiguration;", "appVersion", "connectionStateMonitor", "Lcom/livpure/safedrink/api/ConnectionStateMonitor;", "getConnectionStateMonitor", "()Lcom/livpure/safedrink/api/ConnectionStateMonitor;", "connectionStateMonitor$delegate", "Lkotlin/Lazy;", "deviceSerialNumber", "dialog", "Landroidx/appcompat/app/AlertDialog;", "isForceUpdate", "()Ljava/lang/String;", "setForceUpdate", "(Ljava/lang/String;)V", "mainViewModel", "Lcom/livpure/safedrink/app/MainViewModel;", "getMainViewModel", "()Lcom/livpure/safedrink/app/MainViewModel;", "mainViewModel$delegate", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "setPrefs", "(Landroid/content/SharedPreferences;)V", "updateListener", "Lcom/google/android/play/core/install/InstallStateUpdatedListener;", "version", "getVersion", "setVersion", "authenticateUser", "", "changeDrawerLockStatus", "isLocked", "", "changeToolbarVisibility", "isVisible", "checkForUpdates", "checkGPSEnabled", "checkLocationPermission", "getNodeValue", ViewHierarchyConstants.TAG_KEY, "element", "Lorg/w3c/dom/Element;", "goHome", "handleFlexibleUpdate", "manager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", LogManagerKt.LOG_LEVEL_INFO, "Lcom/google/android/play/core/tasks/Task;", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "handleImmediateUpdate", "handleUpdate", "initBranch", "initializeNewRelic", "isLocationEnabled", "launchRestartDialog", "moveToPlayStroe", MoEPushConstants.ACTION_NAVIGATE, NativeProtocol.WEB_DIALOG_ACTION, "Landroidx/navigation/NavDirections;", "navigateToNoNetworkScreen", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "onPause", "onPaymentError", "errorCode", "response", "paymentData", "Lcom/razorpay/PaymentData;", "onPaymentSuccess", "razorpayPaymentId", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", "overrideUpButtonUsage", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "registerToken", "token", "sendFirstInstallEvent", "setUpdateAction", "setupDefaultUpButtonNavigation", "setupNavigation", "showAlert", "showError", "errorMessage", "showInfoDialog", "showSplashScreen", "startRazorPayPayment", "rupeeAmount", "", "business_type", "serial_no", RichPushConstantsKt.PROPERTY_DURATION_KEY, "planId", "planName", "coupon_name", "coupon_amount", "updateDialog", "xmlParsingAPi", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MainActivity extends AppCompatActivity implements PaymentResultWithDataListener {
    private AppBarConfiguration appBarConfiguration;
    private AlertDialog dialog;
    private SharedPreferences prefs;
    private InstallStateUpdatedListener updateListener;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy mainViewModel$delegate = LazyKt.lazy(new Function0<MainViewModel>() { // from class: com.livpure.safedrink.login.MainActivity$mainViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MainViewModel invoke() {
            return (MainViewModel) new ViewModelProvider(MainActivity.this).get(MainViewModel.class);
        }
    });
    private final Lazy connectionStateMonitor$delegate = LazyKt.lazy(new Function0<ConnectionStateMonitor>() { // from class: com.livpure.safedrink.login.MainActivity$connectionStateMonitor$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ConnectionStateMonitor invoke() {
            return new ConnectionStateMonitor();
        }
    });
    private final int APP_UPDATE_TYPE_SUPPORTED = 1;
    private final int REQUEST_UPDATE = 100;
    private String deviceSerialNumber = "";
    private int REQUEST_LOCATION_CODE = 101;
    private String version = "";
    private String apiVersion = "";
    private String appVersion = "";
    private String isForceUpdate = "false";

    /* compiled from: MainActivity.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MainViewModel.GlobalNavigationStates.values().length];
            iArr[MainViewModel.GlobalNavigationStates.SPLASH.ordinal()] = 1;
            iArr[MainViewModel.GlobalNavigationStates.CHECK_AUTHENTICATION.ordinal()] = 2;
            iArr[MainViewModel.GlobalNavigationStates.AUTHENTICATE.ordinal()] = 3;
            iArr[MainViewModel.GlobalNavigationStates.HOME.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerToken$lambda-4  reason: not valid java name */
    public static final void m1075registerToken$lambda4(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerToken$lambda-5  reason: not valid java name */
    public static final void m1076registerToken$lambda5(VolleyError volleyError) {
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    private final MainViewModel getMainViewModel() {
        return (MainViewModel) this.mainViewModel$delegate.getValue();
    }

    private final ConnectionStateMonitor getConnectionStateMonitor() {
        return (ConnectionStateMonitor) this.connectionStateMonitor$delegate.getValue();
    }

    public final SharedPreferences getPrefs() {
        return this.prefs;
    }

    public final void setPrefs(SharedPreferences sharedPreferences) {
        this.prefs = sharedPreferences;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    public final String isForceUpdate() {
        return this.isForceUpdate;
    }

    public final void setForceUpdate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isForceUpdate = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MainActivity mainActivity = this;
        ViewDataBinding contentView = DataBindingUtil.setContentView(mainActivity, R.layout.activity_single_main);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(this, R.l…out.activity_single_main)");
        ((ActivitySingleMainBinding) contentView).setViewModel(getMainViewModel());
        setSupportActionBar((Toolbar) findViewById(R.id.mainToolbar));
        this.prefs = getSharedPreferences(BuildConfig.APPLICATION_ID, 0);
        MoEFireBaseHelper.Companion.getInstance().generatePushToken(new FcmEventListener() { // from class: com.livpure.safedrink.login.MainActivity$onCreate$1
            @Override // com.livpure.safedrink.servicefirebase.FcmEventListener
            public void navValue(String str) {
                if (Intrinsics.areEqual(str, "") || str == null) {
                    return;
                }
                MainActivity.this.registerToken(str);
            }
        });
        MoECoreHelper.INSTANCE.addAppBackgroundListener(new ApplicationBackgroundListener());
        MoEInAppHelper.Companion.getInstance().setClickActionListener(new ClickActionCallback());
        MoEInAppHelper.Companion.getInstance().addInAppLifeCycleListener(new InAppCallback());
        MoEInAppHelper.Companion.getInstance().setSelfHandledListener(new SelfHandledCallback());
        MoEPushHelper.Companion.getInstance().registerMessageListener(new CustomPushMessageListener());
        MainActivity mainActivity2 = this;
        LSApplication.Companion.setNetworkAvailable(APIUtilKt.isNetworkConnected(mainActivity2));
        getConnectionStateMonitor().enable(mainActivity2);
        setupNavigation();
        initializeNewRelic();
        new UpdateChecker().getVersionCode(mainActivity);
        xmlParsingAPi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        MoEInAppHelper companion = MoEInAppHelper.Companion.getInstance();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        companion.showInApp(applicationContext);
        initBranch();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            Intrinsics.checkNotNull(alertDialog);
            if (alertDialog.isShowing()) {
                AlertDialog alertDialog2 = this.dialog;
                Intrinsics.checkNotNull(alertDialog2);
                alertDialog2.dismiss();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.livpure.safedrink.login.MainActivity$xmlParsingAPi$thread$1] */
    private final void xmlParsingAPi() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final ArrayList arrayList = new ArrayList();
        final URL url = new URL("https://www.livpuresmart.com/assets/livpuresmart/version_check.xml");
        new Thread() { // from class: com.livpure.safedrink.login.MainActivity$xmlParsingAPi$thread$1
            /* JADX WARN: Type inference failed for: r7v1, types: [T, java.util.HashMap] */
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(FirebasePerfUrlConnection.openStream(url))).getElementsByTagName("android");
                    int length = elementsByTagName.getLength();
                    for (int i = 0; i < length; i++) {
                        if (elementsByTagName.item(0).getNodeType() == 1) {
                            objectRef.element = new HashMap();
                            Node item = elementsByTagName.item(i);
                            if (item == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.w3c.dom.Element");
                            }
                            Element element = (Element) item;
                            objectRef.element.put("current_version", this.getNodeValue("current_version", element));
                            MainActivity mainActivity = this;
                            mainActivity.setVersion(mainActivity.getNodeValue("current_version", element));
                            MainActivity mainActivity2 = this;
                            mainActivity2.setForceUpdate(mainActivity2.getNodeValue("is_force_update", element));
                            objectRef.element.put("is_force_update", this.getNodeValue("is_force_update", element));
                            System.out.println((Object) ("version===>>>>>>>123==>>>" + this.getVersion()));
                            System.out.println((Object) ("empDataHashMap===>>>>>>>" + objectRef.element));
                            arrayList.add(objectRef.element);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e2) {
                    e2.printStackTrace();
                } catch (SAXException e3) {
                    e3.printStackTrace();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }.start();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.livpure.safedrink.login.MainActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.m1086xmlParsingAPi$lambda0(MainActivity.this);
            }
        }, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: xmlParsingAPi$lambda-0  reason: not valid java name */
    public static final void m1086xmlParsingAPi$lambda0(MainActivity this$0) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.apiVersion = StringsKt.replace$default(this$0.version, InstructionFileId.DOT, "", false, 4, (Object) null);
        try {
            str = this$0.getPackageManager().getPackageInfo(this$0.getPackageName(), 0).versionName;
            Intrinsics.checkNotNullExpressionValue(str, "pInfo.versionName");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            str = "";
        }
        this$0.appVersion = StringsKt.replace$default(str, InstructionFileId.DOT, "", false, 4, (Object) null);
        Log.e("TAG", "xmlParsingAPi: apiVersion:" + this$0.apiVersion + "  , appVersion" + this$0.appVersion);
        if ((!StringsKt.isBlank(this$0.apiVersion)) && (!StringsKt.isBlank(this$0.appVersion)) && Integer.parseInt(this$0.apiVersion) > Integer.parseInt(this$0.appVersion)) {
            this$0.updateDialog();
        }
    }

    public final String getNodeValue(String tag, Element element) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(element, "element");
        Node item = element.getElementsByTagName(tag).item(0);
        if (item == null || !item.hasChildNodes()) {
            return "";
        }
        Node firstChild = item.getFirstChild();
        while (firstChild != null) {
            if (firstChild.getNodeType() == 3) {
                String nodeValue = firstChild.getNodeValue();
                Intrinsics.checkNotNullExpressionValue(nodeValue, "child.nodeValue");
                return nodeValue;
            }
        }
        return "";
    }

    private final void updateDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.dialog_app_update);
        Window window = dialog.getWindow();
        Intrinsics.checkNotNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        Button button = (Button) dialog.findViewById(R.id.btn_notnow);
        Button button2 = (Button) dialog.findViewById(R.id.btn_update_now);
        Button button3 = (Button) dialog.findViewById(R.id.btn_update_app);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.ll_normal_update);
        LinearLayout linearLayout2 = (LinearLayout) dialog.findViewById(R.id.ll_force_update);
        if (Intrinsics.areEqual(this.isForceUpdate, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            linearLayout2.setVisibility(0);
        } else {
            linearLayout.setVisibility(0);
        }
        dialog.show();
        dialog.setCancelable(false);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.login.MainActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.m1083updateDialog$lambda1(dialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.login.MainActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.m1084updateDialog$lambda2(MainActivity.this, view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.login.MainActivity$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.m1085updateDialog$lambda3(MainActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateDialog$lambda-1  reason: not valid java name */
    public static final void m1083updateDialog$lambda1(Dialog dialoglog, View view) {
        Intrinsics.checkNotNullParameter(dialoglog, "$dialoglog");
        dialoglog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateDialog$lambda-2  reason: not valid java name */
    public static final void m1084updateDialog$lambda2(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.moveToPlayStroe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateDialog$lambda-3  reason: not valid java name */
    public static final void m1085updateDialog$lambda3(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.moveToPlayStroe();
    }

    private final void moveToPlayStroe() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName())));
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.String] */
    public final void registerToken(final String str) {
        sendFirstInstallEvent(str);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        objectRef.element = Settings.Secure.getString(getContentResolver(), CoreConstants.GENERIC_PARAM_V2_KEY_ANDROID_ID);
        final MainActivity$$ExternalSyntheticLambda3 mainActivity$$ExternalSyntheticLambda3 = new Response.Listener() { // from class: com.livpure.safedrink.login.MainActivity$$ExternalSyntheticLambda3
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                MainActivity.m1075registerToken$lambda4((String) obj);
            }
        };
        final MainActivity$$ExternalSyntheticLambda2 mainActivity$$ExternalSyntheticLambda2 = new Response.ErrorListener() { // from class: com.livpure.safedrink.login.MainActivity$$ExternalSyntheticLambda2
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                MainActivity.m1076registerToken$lambda5(volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(mainActivity$$ExternalSyntheticLambda3, mainActivity$$ExternalSyntheticLambda2) { // from class: com.livpure.safedrink.login.MainActivity$registerToken$stringRequest$1
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
                return hashMap;
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000, 1, 1.0f));
        MyVolleySingleton.getInstance(getApplicationContext()).getRequestQueue().add(stringRequest);
        MoEFireBaseHelper companion = MoEFireBaseHelper.Companion.getInstance();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        companion.passPushToken(applicationContext, str);
    }

    private final void sendFirstInstallEvent(String str) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        SharedPreferences sharedPreferences = this.prefs;
        boolean z = true;
        if ((sharedPreferences == null || !sharedPreferences.getBoolean("firstRun", true)) ? false : false) {
            Properties addAttribute = new Properties().addAttribute("source", Constants.PLATFORM).addAttribute(SegmentProperties.FIREBASE_TOKEN, str).addAttribute(SegmentProperties.DEVICE_ID, Settings.Secure.getString(getContentResolver(), CoreConstants.GENERIC_PARAM_V2_KEY_ANDROID_ID)).addAttribute(SegmentProperties.VERSION_CODE, Integer.valueOf((int) BuildConfig.VERSION_CODE)).addAttribute(SegmentProperties.VERSION_NAME, BuildConfig.VERSION_NAME).addAttribute(SegmentProperties.DEVICE_VERSION, Build.VERSION.RELEASE).addAttribute(SegmentProperties.SDK_VERSION, Integer.valueOf(Build.VERSION.SDK_INT)).addAttribute("deviceModel", Build.MODEL).addAttribute(SegmentProperties.BRAND, Build.BRAND);
            MoEAnalyticsHelper moEAnalyticsHelper = MoEAnalyticsHelper.INSTANCE;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            moEAnalyticsHelper.trackEvent(applicationContext, SegmentEventNames.NEW_INSTALL, addAttribute);
            SharedPreferences sharedPreferences2 = this.prefs;
            if (sharedPreferences2 == null || (edit = sharedPreferences2.edit()) == null || (putBoolean = edit.putBoolean("firstRun", false)) == null) {
                return;
            }
            putBoolean.apply();
        }
    }

    private final void checkForUpdates() {
        final AppUpdateManager create = AppUpdateManagerFactory.create(getBaseContext());
        Intrinsics.checkNotNullExpressionValue(create, "create(baseContext)");
        final Task<AppUpdateInfo> appUpdateInfo = create.getAppUpdateInfo();
        appUpdateInfo.addOnSuccessListener(new OnSuccessListener() { // from class: com.livpure.safedrink.login.MainActivity$$ExternalSyntheticLambda5
            @Override // com.google.android.play.core.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                MainActivity.m1070checkForUpdates$lambda6(MainActivity.this, create, appUpdateInfo, (AppUpdateInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkForUpdates$lambda-6  reason: not valid java name */
    public static final void m1070checkForUpdates$lambda6(MainActivity this$0, AppUpdateManager appUpdateManager, Task appUpdateInfo, AppUpdateInfo appUpdateInfo2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appUpdateManager, "$appUpdateManager");
        Intrinsics.checkNotNullExpressionValue(appUpdateInfo, "appUpdateInfo");
        this$0.handleUpdate(appUpdateManager, appUpdateInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        Uri data2;
        String fileName;
        Uri data3;
        String fileName2;
        if (this.REQUEST_UPDATE == i) {
            if (i2 != -1) {
                if (i2 == 0) {
                    Toast.makeText(getBaseContext(), (int) R.string.toast_cancelled, 0).show();
                } else if (i2 == 1) {
                    Toast.makeText(getBaseContext(), (int) R.string.toast_failed, 0).show();
                }
            } else if (this.APP_UPDATE_TYPE_SUPPORTED == 1) {
                Toast.makeText(getBaseContext(), (int) R.string.toast_updated, 0).show();
            } else {
                Toast.makeText(getBaseContext(), (int) R.string.toast_started, 0).show();
            }
        }
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            String str = "";
            if (i == 101) {
                MainViewModel mainViewModel = getMainViewModel();
                data = intent != null ? intent.getData() : null;
                if (intent != null && (data2 = intent.getData()) != null && (fileName = FileUtilKt.getFileName(data2, this)) != null) {
                    str = fileName;
                }
                mainViewModel.setAddressProof(data, str);
            } else if (i != 102) {
            } else {
                MainViewModel mainViewModel2 = getMainViewModel();
                data = intent != null ? intent.getData() : null;
                if (intent != null && (data3 = intent.getData()) != null && (fileName2 = FileUtilKt.getFileName(data3, this)) != null) {
                    str = fileName2;
                }
                mainViewModel2.setIDProofFileName(data, str);
            }
        }
    }

    private final void handleUpdate(AppUpdateManager appUpdateManager, Task<AppUpdateInfo> task) {
        int i = this.APP_UPDATE_TYPE_SUPPORTED;
        if (i == 1) {
            handleImmediateUpdate(appUpdateManager, task);
        } else if (i == 0) {
            handleImmediateUpdate(appUpdateManager, task);
        }
    }

    private final void handleImmediateUpdate(AppUpdateManager appUpdateManager, Task<AppUpdateInfo> task) {
        if ((task.getResult().updateAvailability() == 2 || task.getResult().updateAvailability() == 3) && task.getResult().isUpdateTypeAllowed(1)) {
            appUpdateManager.startUpdateFlowForResult(task.getResult(), 1, this, this.REQUEST_UPDATE);
        }
    }

    private final void handleFlexibleUpdate(AppUpdateManager appUpdateManager, Task<AppUpdateInfo> task) {
        if (task.getResult().updateAvailability() == 3 && task.getResult().isUpdateTypeAllowed(1)) {
            handleImmediateUpdate(appUpdateManager, task);
        } else if ((task.getResult().updateAvailability() == 2 || task.getResult().updateAvailability() == 3) && task.getResult().isUpdateTypeAllowed(0)) {
            ((Button) _$_findCachedViewById(R.id.btn_update)).setVisibility(0);
            setUpdateAction(appUpdateManager, task);
        }
    }

    private final void setUpdateAction(final AppUpdateManager appUpdateManager, final Task<AppUpdateInfo> task) {
        ((Button) _$_findCachedViewById(R.id.btn_update)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.login.MainActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.m1077setUpdateAction$lambda8(MainActivity.this, appUpdateManager, task, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpdateAction$lambda-8  reason: not valid java name */
    public static final void m1077setUpdateAction$lambda8(final MainActivity this$0, final AppUpdateManager manager, Task info, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(manager, "$manager");
        Intrinsics.checkNotNullParameter(info, "$info");
        InstallStateUpdatedListener installStateUpdatedListener = new InstallStateUpdatedListener() { // from class: com.livpure.safedrink.login.MainActivity$$ExternalSyntheticLambda4
            @Override // com.google.android.play.core.listener.StateUpdatedListener
            public final void onStateUpdate(InstallState installState) {
                MainActivity.m1078setUpdateAction$lambda8$lambda7(MainActivity.this, manager, installState);
            }
        };
        this$0.updateListener = installStateUpdatedListener;
        manager.registerListener(installStateUpdatedListener);
        manager.startUpdateFlowForResult((AppUpdateInfo) info.getResult(), 0, this$0, this$0.REQUEST_UPDATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpdateAction$lambda-8$lambda-7  reason: not valid java name */
    public static final void m1078setUpdateAction$lambda8$lambda7(MainActivity this$0, AppUpdateManager manager, InstallState installState) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(manager, "$manager");
        ((Button) this$0._$_findCachedViewById(R.id.btn_update)).setVisibility(8);
        ((TextView) this$0._$_findCachedViewById(R.id.tv_status)).setVisibility(0);
        int installStatus = installState.installStatus();
        if (installStatus != 11) {
            switch (installStatus) {
                case 0:
                case 5:
                    ((TextView) this$0._$_findCachedViewById(R.id.tv_status)).setText(this$0.getString(R.string.info_failed));
                    ((Button) this$0._$_findCachedViewById(R.id.btn_update)).setVisibility(0);
                    return;
                case 1:
                    ((TextView) this$0._$_findCachedViewById(R.id.tv_status)).setText(this$0.getString(R.string.info_pending));
                    return;
                case 2:
                    ((TextView) this$0._$_findCachedViewById(R.id.tv_status)).setText(this$0.getString(R.string.info_downloading));
                    return;
                case 3:
                    ((TextView) this$0._$_findCachedViewById(R.id.tv_status)).setText(this$0.getString(R.string.info_installing));
                    return;
                case 4:
                    ((TextView) this$0._$_findCachedViewById(R.id.tv_status)).setText(this$0.getString(R.string.info_installed));
                    InstallStateUpdatedListener installStateUpdatedListener = this$0.updateListener;
                    if (installStateUpdatedListener == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("updateListener");
                        installStateUpdatedListener = null;
                    }
                    manager.unregisterListener(installStateUpdatedListener);
                    return;
                case 6:
                    ((TextView) this$0._$_findCachedViewById(R.id.tv_status)).setText(this$0.getString(R.string.info_canceled));
                    return;
                default:
                    ((TextView) this$0._$_findCachedViewById(R.id.tv_status)).setText(this$0.getString(R.string.info_restart));
                    return;
            }
        }
        ((TextView) this$0._$_findCachedViewById(R.id.tv_status)).setText(this$0.getString(R.string.info_installing));
        this$0.launchRestartDialog(manager);
    }

    private final void launchRestartDialog(final AppUpdateManager appUpdateManager) {
        new AlertDialog.Builder(this).setTitle(getString(R.string.update_title)).setMessage(getString(R.string.update_message)).setPositiveButton(getString(R.string.action_restart), new DialogInterface.OnClickListener() { // from class: com.livpure.safedrink.login.MainActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.m1073launchRestartDialog$lambda9(AppUpdateManager.this, dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: launchRestartDialog$lambda-9  reason: not valid java name */
    public static final void m1073launchRestartDialog$lambda9(AppUpdateManager manager, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(manager, "$manager");
        manager.completeUpdate();
    }

    private final void setupNavigation() {
        getMainViewModel().getGlobalNavigationStates().observe(this, new Observer() { // from class: com.livpure.safedrink.login.MainActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.m1079setupNavigation$lambda10(MainActivity.this, (MainViewModel.GlobalNavigationStates) obj);
            }
        });
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
        this.appBarConfiguration = new AppBarConfiguration.Builder(SetsKt.setOf((Object[]) new Integer[]{Integer.valueOf((int) R.id.homeFragment), Integer.valueOf((int) R.id.authPagerFragment), Integer.valueOf((int) R.id.noNetworkFragment), Integer.valueOf((int) R.id.kycUpload), Integer.valueOf((int) R.id.trackRelocationFragment)})).setOpenableLayout((DrawerLayout) _$_findCachedViewById(R.id.drawerLayout)).setFallbackOnNavigateUpListener(new MainActivity$inlined$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(new Function0<Boolean>() { // from class: com.livpure.safedrink.login.MainActivity$setupNavigation$$inlined$AppBarConfiguration$default$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return false;
            }
        })).build();
        setupDefaultUpButtonNavigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupNavigation$lambda-10  reason: not valid java name */
    public static final void m1079setupNavigation$lambda10(MainActivity this$0, MainViewModel.GlobalNavigationStates globalNavigationStates) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = globalNavigationStates == null ? -1 : WhenMappings.$EnumSwitchMapping$0[globalNavigationStates.ordinal()];
        if (i == 1) {
            this$0.showSplashScreen();
        } else if (i == 2) {
            this$0.getMainViewModel().checkAuthentication(this$0);
        } else if (i == 3) {
            this$0.authenticateUser();
        } else if (i == 4 && !this$0.isFinishing()) {
            try {
                String string = Settings.Secure.getString(this$0.getContentResolver(), CoreConstants.GENERIC_PARAM_V2_KEY_ANDROID_ID);
                User user = LSApplication.Companion.getUser();
                Intrinsics.checkNotNull(user);
                this$0.getMainViewModel().updateDeviceId(this$0, user.getId(), string);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            UiUtilKt.hideKeyboard(this$0);
            this$0.goHome();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: overrideUpButtonUsage$lambda-11  reason: not valid java name */
    public static final void m1074overrideUpButtonUsage$lambda11(Function1 tmp0, View view) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(view);
    }

    public final void overrideUpButtonUsage(final Function1<? super View, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ((MaterialToolbar) _$_findCachedViewById(R.id.mainToolbar)).setNavigationOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.login.MainActivity$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.m1074overrideUpButtonUsage$lambda11(Function1.this, view);
            }
        });
    }

    public final void setupDefaultUpButtonNavigation() {
        NavController findNavController = ActivityKt.findNavController(this, R.id.navHostFragment);
        AppBarConfiguration appBarConfiguration = null;
        ((MaterialToolbar) _$_findCachedViewById(R.id.mainToolbar)).setNavigationOnClickListener(null);
        MaterialToolbar mainToolbar = (MaterialToolbar) _$_findCachedViewById(R.id.mainToolbar);
        Intrinsics.checkNotNullExpressionValue(mainToolbar, "mainToolbar");
        MaterialToolbar materialToolbar = mainToolbar;
        AppBarConfiguration appBarConfiguration2 = this.appBarConfiguration;
        if (appBarConfiguration2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarConfiguration");
        } else {
            appBarConfiguration = appBarConfiguration2;
        }
        ToolbarKt.setupWithNavController(materialToolbar, findNavController, appBarConfiguration);
        NavigationView navDrawerView = (NavigationView) _$_findCachedViewById(R.id.navDrawerView);
        Intrinsics.checkNotNullExpressionValue(navDrawerView, "navDrawerView");
        NavigationViewKt.setupWithNavController(navDrawerView, findNavController);
    }

    private final void initBranch() {
        Branch.getInstance().initSession(new Branch.BranchReferralInitListener() { // from class: com.livpure.safedrink.login.MainActivity$$ExternalSyntheticLambda6
            @Override // io.branch.referral.Branch.BranchReferralInitListener
            public final void onInitFinished(JSONObject jSONObject, BranchError branchError) {
                MainActivity.m1072initBranch$lambda12(jSONObject, branchError);
            }
        }, getIntent().getData(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initBranch$lambda-12  reason: not valid java name */
    public static final void m1072initBranch$lambda12(JSONObject jSONObject, BranchError branchError) {
        if (branchError == null) {
            Log.i("BRANCH SDK", String.valueOf(jSONObject));
        } else {
            Log.i("BRANCH SDK", branchError.getMessage());
        }
    }

    private final void initializeNewRelic() {
        NewRelic.withApplicationToken(BuildConfig.NEW_RELIC_TOKEN).start(getApplication());
    }

    public final void startRazorPayPayment(double d, String business_type, String str, String str2, String str3, String str4, String coupon_name, String coupon_amount) {
        String str5;
        JSONObject jSONObject;
        String str6;
        Intrinsics.checkNotNullParameter(business_type, "business_type");
        Intrinsics.checkNotNullParameter(coupon_name, "coupon_name");
        Intrinsics.checkNotNullParameter(coupon_amount, "coupon_amount");
        Checkout checkout = new Checkout();
        if (str != null) {
            try {
                this.deviceSerialNumber = str;
            } catch (Exception e) {
                Toast.makeText(this, "Error in payment: " + e.getMessage(), 1).show();
                e.printStackTrace();
                return;
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("name", "Livpure Smart");
        jSONObject2.put("description", "ORDER");
        jSONObject2.put("image", "https://livpuresmart.com/mobile/logo.png");
        jSONObject2.put(FirebaseAnalytics.Param.CURRENCY, "INR");
        jSONObject2.put("amount", (int) (100 * d));
        jSONObject2.put("payment_capture", "1");
        JSONObject jSONObject3 = new JSONObject();
        User user = LSApplication.Companion.getUser();
        jSONObject3.put("email", user != null ? user.getEmail() : null);
        User user2 = LSApplication.Companion.getUser();
        jSONObject3.put("contact", user2 != null ? user2.getMobile() : null);
        jSONObject2.put("prefill", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        String str7 = "plan";
        if (Intrinsics.areEqual(business_type, "ADD_LITRES")) {
            str5 = "coupon_amount";
            jSONObject = jSONObject2;
        } else {
            jSONObject = jSONObject2;
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            str5 = "coupon_amount";
            sb.append(JsonLexerKt.COLON);
            if (Intrinsics.areEqual(str2, "1")) {
                str6 = "plan";
            } else {
                str6 = str2 + "_months";
            }
            sb.append(str6);
            jSONObject4.put("planIdRechargeType", sb.toString());
        }
        User user3 = LSApplication.Companion.getUser();
        jSONObject4.put("email", user3 != null ? user3.getEmail() : null);
        User user4 = LSApplication.Companion.getUser();
        jSONObject4.put("contact", user4 != null ? user4.getMobile() : null);
        User user5 = LSApplication.Companion.getUser();
        jSONObject4.put("name", user5 != null ? user5.getName() : null);
        User user6 = LSApplication.Companion.getUser();
        jSONObject4.put("user_id", user6 != null ? user6.getId() : null);
        jSONObject4.put("planName", str4);
        jSONObject4.put("payment_from", Constants.PLATFORM);
        jSONObject4.put("business", "WAAS");
        jSONObject4.put("serial_no", str);
        jSONObject4.put("business_type", business_type);
        if (Intrinsics.areEqual(business_type, "ADD_LITRES")) {
            jSONObject4.put("rechargeType", "topup");
        } else {
            if (!Intrinsics.areEqual(str2, "1")) {
                str7 = str2 + "_months";
            }
            jSONObject4.put("rechargeType", str7);
        }
        jSONObject4.put("plan_id", str3);
        jSONObject4.put("coupon_name", coupon_name);
        jSONObject4.put(str5, coupon_amount);
        JSONObject jSONObject5 = jSONObject;
        jSONObject5.put("notes", jSONObject4);
        checkout.open(this, jSONObject5);
    }

    public final void changeToolbarVisibility(boolean z) {
        if (z) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.show();
                return;
            }
            return;
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.hide();
        }
    }

    private final void authenticateUser() {
        NavGraphDirections.ActionGlobalOnBoardingWebViewFragment actionGlobalOnBoardingWebViewFragment = NavGraphDirections.actionGlobalOnBoardingWebViewFragment(R.string.onboarding);
        Intrinsics.checkNotNullExpressionValue(actionGlobalOnBoardingWebViewFragment, "actionGlobalOnBoardingWe…ment(R.string.onboarding)");
        navigate(actionGlobalOnBoardingWebViewFragment);
    }

    private final void showSplashScreen() {
        NavDirections actionGlobalSplashFragment = NavGraphDirections.actionGlobalSplashFragment();
        Intrinsics.checkNotNullExpressionValue(actionGlobalSplashFragment, "actionGlobalSplashFragment()");
        navigate(actionGlobalSplashFragment);
    }

    private final void goHome() {
        String str;
        String str2;
        String str3;
        String str4;
        String planName;
        String planName2;
        String planName3;
        String planName4;
        User user = LSApplication.Companion.getUser();
        if (user == null || (planName4 = user.getPlanName()) == null) {
            str = null;
        } else {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            str = planName4.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
        }
        if (!StringsKt.equals$default(str, "furlenco", false, 2, null)) {
            User user2 = LSApplication.Companion.getUser();
            if (user2 == null || (planName3 = user2.getPlanName()) == null) {
                str2 = null;
            } else {
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
                str2 = planName3.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toLowerCase(locale)");
            }
            if (!StringsKt.equals$default(str2, "rentmojo", false, 2, null)) {
                User user3 = LSApplication.Companion.getUser();
                if (user3 == null || (planName2 = user3.getPlanName()) == null) {
                    str3 = null;
                } else {
                    Locale locale3 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale3, "getDefault()");
                    str3 = planName2.toLowerCase(locale3);
                    Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String).toLowerCase(locale)");
                }
                if (!StringsKt.equals$default(str3, "rentomojo", false, 2, null)) {
                    User user4 = LSApplication.Companion.getUser();
                    if (user4 == null || (planName = user4.getPlanName()) == null) {
                        str4 = null;
                    } else {
                        Locale locale4 = Locale.getDefault();
                        Intrinsics.checkNotNullExpressionValue(locale4, "getDefault()");
                        str4 = planName.toLowerCase(locale4);
                        Intrinsics.checkNotNullExpressionValue(str4, "this as java.lang.String).toLowerCase(locale)");
                    }
                    if (!StringsKt.equals$default(str4, "b2b", false, 2, null)) {
                        NavGraphDirections.ActionGlobalHomeFragment actionGlobalHomeFragment = NavGraphDirections.actionGlobalHomeFragment(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        Intrinsics.checkNotNullExpressionValue(actionGlobalHomeFragment, "actionGlobalHomeFragment(\"0\")");
                        navigate(actionGlobalHomeFragment);
                        return;
                    }
                }
            }
        }
        NavDirections actionGlobalHomeFurlencoFragment = NavGraphDirections.actionGlobalHomeFurlencoFragment();
        Intrinsics.checkNotNullExpressionValue(actionGlobalHomeFurlencoFragment, "actionGlobalHomeFurlencoFragment()");
        navigate(actionGlobalHomeFurlencoFragment);
    }

    private final void navigate(NavDirections navDirections) {
        ActivityKt.findNavController(this, R.id.navHostFragment).navigate(navDirections);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        DisposableManager.dispose();
    }

    @Override // com.razorpay.PaymentResultWithDataListener
    public void onPaymentError(int i, String str, PaymentData paymentData) {
        Constant.Companion.setIsPaymentFailed(true);
        Toast.makeText(this, "Payment Failed!!", 1).show();
        getMainViewModel().setPaymentPayload(new PaymentPayload(PaymentPayload.PaymentState.PAYMENT_FAILED, null, paymentData, str, this.deviceSerialNumber, Integer.valueOf(i)));
    }

    @Override // com.razorpay.PaymentResultWithDataListener
    public void onPaymentSuccess(String str, PaymentData paymentData) {
        Toast.makeText(this, "Payment Successful!!", 0).show();
        getMainViewModel().setPaymentPayload(new PaymentPayload(PaymentPayload.PaymentState.PAYMENT_SUCCESS, str, paymentData, null, this.deviceSerialNumber, null));
    }

    private final void showError(String str) {
        Toast.makeText(this, str, 0).show();
    }

    public final void navigateToNoNetworkScreen() {
        NavDirections actionGlobalNoNetworkFragment = NavGraphDirections.actionGlobalNoNetworkFragment();
        Intrinsics.checkNotNullExpressionValue(actionGlobalNoNetworkFragment, "actionGlobalNoNetworkFragment()");
        navigate(actionGlobalNoNetworkFragment);
    }

    public final void changeDrawerLockStatus(boolean z) {
        ((DrawerLayout) _$_findCachedViewById(R.id.drawerLayout)).setDrawerLockMode(z ? 1 : 0);
    }

    public final void showInfoDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.dialog_feedback);
        Window window = dialog.getWindow();
        Intrinsics.checkNotNull(window);
        window.setLayout(-1, -2);
        Window window2 = dialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setBackgroundDrawable(new ColorDrawable(0));
        dialog.show();
        dialog.setCancelable(false);
        ((Button) dialog.findViewById(R.id.shareFeedbackButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.login.MainActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.m1081showInfoDialog$lambda13(dialog, this, view);
            }
        });
        ((TextView) dialog.findViewById(R.id.noThanksButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.login.MainActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.m1082showInfoDialog$lambda14(dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showInfoDialog$lambda-13  reason: not valid java name */
    public static final void m1081showInfoDialog$lambda13(Dialog dialoglog, MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(dialoglog, "$dialoglog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialoglog.dismiss();
        this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.livpure.safedrink")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showInfoDialog$lambda-14  reason: not valid java name */
    public static final void m1082showInfoDialog$lambda14(Dialog dialoglog, View view) {
        Intrinsics.checkNotNullParameter(dialoglog, "$dialoglog");
        dialoglog.dismiss();
    }

    private final boolean checkGPSEnabled() {
        if (!isLocationEnabled()) {
            showAlert();
        }
        return isLocationEnabled();
    }

    private final void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enable Location").setMessage("Your Locations Settings is set to 'off'.\nPlease Enable Location to use this app").setCancelable(true).setPositiveButton("Location Settings", new DialogInterface.OnClickListener() { // from class: com.livpure.safedrink.login.MainActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.m1080showAlert$lambda15(MainActivity.this, dialogInterface, i);
            }
        });
        AlertDialog create = builder.create();
        this.dialog = create;
        Intrinsics.checkNotNull(create);
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showAlert$lambda-15  reason: not valid java name */
    public static final void m1080showAlert$lambda15(MainActivity this$0, DialogInterface d, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(d, "d");
        d.dismiss();
        this$0.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    private final boolean isLocationEnabled() {
        Object systemService = getSystemService("location");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled(AndroidContextPlugin.NETWORK_KEY);
    }

    private final void checkLocationPermission() {
        MainActivity mainActivity = this;
        if (ContextCompat.checkSelfPermission(mainActivity, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            MainActivity mainActivity2 = this;
            if (ActivityCompat.shouldShowRequestPermissionRationale(mainActivity2, "android.permission.ACCESS_FINE_LOCATION")) {
                new AlertDialog.Builder(mainActivity).setTitle("Location Permission Needed").setCancelable(false).setMessage("This app needs the Location permission, please accept to use location functionality").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.livpure.safedrink.login.MainActivity$$ExternalSyntheticLambda9
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.m1071checkLocationPermission$lambda16(MainActivity.this, dialogInterface, i);
                    }
                }).create().show();
            } else {
                ActivityCompat.requestPermissions(mainActivity2, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this.REQUEST_LOCATION_CODE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkLocationPermission$lambda-16  reason: not valid java name */
    public static final void m1071checkLocationPermission$lambda16(MainActivity this$0, DialogInterface d, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(d, "d");
        ActivityCompat.requestPermissions(this$0, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this$0.REQUEST_LOCATION_CODE);
        d.dismiss();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(i, permissions, grantResults);
        if (i == this.REQUEST_LOCATION_CODE) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                MainActivity mainActivity = this;
                if (ContextCompat.checkSelfPermission(mainActivity, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                    Toast.makeText(mainActivity, "permission granted", 1).show();
                    return;
                }
                return;
            }
            Toast.makeText(this, "permission denied", 1).show();
        }
    }
}

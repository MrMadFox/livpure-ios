package com.livpure.safedrink.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.NavGraphDirections;
import com.livpure.safedrink.R;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.views.BaseActivity;
import com.livpure.safedrink.common.arc.ui.views.BaseFragment;
import com.livpure.safedrink.databinding.FragmentOnboardingWebviewBinding;
import com.livpure.safedrink.login.AuthPagerFragmentDirections;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.utils.AdvancedWebView;
import com.livpure.safedrink.utils.Constant;
import com.livpure.safedrink.utils.FileUtil;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
/* compiled from: StaticOnboardingWebViewFragment.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0014J\n\u0010!\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020\u001cH\u0014J\u0012\u0010&\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\"\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020 2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020\u001e2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J$\u00101\u001a\u0002002\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u00106\u001a\u00020\u001eH\u0016J\b\u00107\u001a\u00020\u001eH\u0002J$\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020 2\b\u0010:\u001a\u0004\u0018\u00010\u000b2\b\u0010;\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010<\u001a\u00020\u001e2\b\u0010=\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010>\u001a\u00020\u001e2\b\u0010=\u001a\u0004\u0018\u00010\u000b2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010A\u001a\u00020\u001eH\u0016J\b\u0010B\u001a\u00020\u001eH\u0016J\u001a\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u0002002\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010E\u001a\u00020\u001eH\u0002J\b\u0010F\u001a\u00020\u001eH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006G"}, d2 = {"Lcom/livpure/safedrink/app/StaticOnboardingWebViewFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/BaseFragment;", "Lcom/livpure/safedrink/utils/AdvancedWebView$Listener;", "Landroid/view/View$OnClickListener;", "()V", "actualImage", "Ljava/io/File;", "compressedImageFile", "dialog", "Landroidx/appcompat/app/AlertDialog;", "fileExtensionType", "", "fileType", "fragmentOnboardingWebviewBinding", "Lcom/livpure/safedrink/databinding/FragmentOnboardingWebviewBinding;", "imageUri", "Landroid/net/Uri;", "mFilePathCallback", "Landroid/webkit/ValueCallback;", "", "mobileNumber", "navArgs", "Lcom/livpure/safedrink/app/StaticWebViewFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/app/StaticWebViewFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "checkPermission", "", "chooseFileOpenDialog", "", "getLayoutId", "", "getScreenName", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "initViewContext", "isToolbarVisible", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "intent", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onLogInClick", "onPageError", "errorCode", "description", "failingUrl", "onPageFinished", "url", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPause", "onResume", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "requestPermission", "setWebChromeClient", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StaticOnboardingWebViewFragment extends BaseFragment implements AdvancedWebView.Listener, View.OnClickListener {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private File actualImage;
    private File compressedImageFile;
    private AlertDialog dialog;
    private String fileExtensionType;
    private String fileType;
    private FragmentOnboardingWebviewBinding fragmentOnboardingWebviewBinding;
    private Uri imageUri;
    private ValueCallback<Uri[]> mFilePathCallback;
    private String mobileNumber;
    private final NavArgsLazy navArgs$delegate;

    private final void initViewContext() {
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
        return R.layout.fragment_onboarding_webview;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    protected boolean isToolbarVisible() {
        return false;
    }

    @Override // com.livpure.safedrink.utils.AdvancedWebView.Listener
    public /* synthetic */ void onDownloadRequested(String str, String str2, String str3, long j, String str4, String str5) {
        AdvancedWebView.Listener.CC.$default$onDownloadRequested(this, str, str2, str3, j, str4, str5);
    }

    @Override // com.livpure.safedrink.utils.AdvancedWebView.Listener
    public /* synthetic */ void onExternalPageRequest(String str) {
        AdvancedWebView.Listener.CC.$default$onExternalPageRequest(this, str);
    }

    public StaticOnboardingWebViewFragment() {
        final StaticOnboardingWebViewFragment staticOnboardingWebViewFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(StaticWebViewFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.app.StaticOnboardingWebViewFragment$special$$inlined$navArgs$1
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

    private final StaticWebViewFragmentArgs getNavArgs() {
        return (StaticWebViewFragmentArgs) this.navArgs$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public AnalyticsViewModel getViewModel() {
        return (AnalyticsViewModel) new ViewModelProvider(this).get(AnalyticsViewModel.class);
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(inflater, R.layout.fragment_onboarding_webview, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, R.layo…ebview, container, false)");
        FragmentOnboardingWebviewBinding fragmentOnboardingWebviewBinding = (FragmentOnboardingWebviewBinding) inflate;
        this.fragmentOnboardingWebviewBinding = fragmentOnboardingWebviewBinding;
        if (fragmentOnboardingWebviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentOnboardingWebviewBinding");
            fragmentOnboardingWebviewBinding = null;
        }
        View root = fragmentOnboardingWebviewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "fragmentOnboardingWebviewBinding.root");
        return root;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initViewContext();
        FragmentOnboardingWebviewBinding fragmentOnboardingWebviewBinding = this.fragmentOnboardingWebviewBinding;
        if (fragmentOnboardingWebviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentOnboardingWebviewBinding");
            fragmentOnboardingWebviewBinding = null;
        }
        fragmentOnboardingWebviewBinding.webview.setListener(this, this);
        if (Build.VERSION.SDK_INT >= 23 && !checkPermission()) {
            requestPermission();
        }
        ((TextView) _$_findCachedViewById(R.id.tvLogIn)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.StaticOnboardingWebViewFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StaticOnboardingWebViewFragment.m449onViewCreated$lambda0(StaticOnboardingWebViewFragment.this, view2);
            }
        });
        if (LSApplication.Companion.isNetworkAvailable()) {
            if (Integer.valueOf(getNavArgs().getUrl()).equals(Integer.valueOf((int) R.string.onboarding_pending))) {
                if (LSApplication.Companion.getUser() != null) {
                    User user = LSApplication.Companion.getUser();
                    Intrinsics.checkNotNull(user);
                    if (user.getMobile() != null) {
                        User user2 = LSApplication.Companion.getUser();
                        Intrinsics.checkNotNull(user2);
                        if (!Intrinsics.areEqual(user2.getMobile(), "")) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(getString(getNavArgs().getUrl()));
                            User user3 = LSApplication.Companion.getUser();
                            Intrinsics.checkNotNull(user3);
                            sb.append(user3.getMobile());
                            ((AdvancedWebView) _$_findCachedViewById(R.id.webview)).loadUrl(sb.toString());
                        }
                    }
                    ((AdvancedWebView) _$_findCachedViewById(R.id.webview)).loadUrl(getString(R.string.onboarding));
                } else {
                    ((AdvancedWebView) _$_findCachedViewById(R.id.webview)).loadUrl(getString(getNavArgs().getUrl()));
                }
            } else {
                ((AdvancedWebView) _$_findCachedViewById(R.id.webview)).loadUrl(getString(getNavArgs().getUrl()));
            }
            setWebChromeClient();
        } else {
            showNoNetworkScreen();
        }
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, this, false, new Function1<OnBackPressedCallback, Unit>() { // from class: com.livpure.safedrink.app.StaticOnboardingWebViewFragment$onViewCreated$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnBackPressedCallback addCallback) {
                Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OnBackPressedCallback onBackPressedCallback) {
                invoke2(onBackPressedCallback);
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m449onViewCreated$lambda0(StaticOnboardingWebViewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onLogInClick();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public String getScreenName() {
        switch (getNavArgs().getUrl()) {
            case R.string.faq_url /* 2131951780 */:
                return Constant.FAQ;
            case R.string.onboarding /* 2131952028 */:
            case R.string.onboarding_pending /* 2131952030 */:
                return "Onboarding";
            case R.string.terms_and_conditions_url /* 2131952177 */:
                return Constant.TERMS_AND_CONDITIONS;
            case R.string.terms_of_use /* 2131952178 */:
                return Constant.TERMS_OF_USE;
            default:
                return super.getScreenName();
        }
    }

    private final void onLogInClick() {
        UserRepository.Companion companion = UserRepository.Companion;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "this.requireActivity()");
        companion.getInstance(requireActivity).logout();
        NavGraphDirections.ActionGlobalAuthentication actionGlobalAuthentication = AuthPagerFragmentDirections.actionGlobalAuthentication();
        Intrinsics.checkNotNullExpressionValue(actionGlobalAuthentication, "actionGlobalAuthentication()");
        FragmentKt.findNavController(this).navigate(actionGlobalAuthentication);
    }

    private final void setWebChromeClient() {
        FragmentOnboardingWebviewBinding fragmentOnboardingWebviewBinding = this.fragmentOnboardingWebviewBinding;
        if (fragmentOnboardingWebviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentOnboardingWebviewBinding");
            fragmentOnboardingWebviewBinding = null;
        }
        fragmentOnboardingWebviewBinding.webview.setWebChromeClient(new WebChromeClient() { // from class: com.livpure.safedrink.app.StaticOnboardingWebViewFragment$setWebChromeClient$1
            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                StaticOnboardingWebViewFragment.this.mFilePathCallback = valueCallback;
                StaticOnboardingWebViewFragment.this.chooseFileOpenDialog();
                return true;
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        FragmentOnboardingWebviewBinding fragmentOnboardingWebviewBinding = this.fragmentOnboardingWebviewBinding;
        String str = null;
        if (fragmentOnboardingWebviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentOnboardingWebviewBinding");
            fragmentOnboardingWebviewBinding = null;
        }
        fragmentOnboardingWebviewBinding.webview.onActivityResult(i, i2, intent);
        if (i == 201) {
            if (i2 == -1) {
                if (intent != null) {
                    try {
                        str = intent.getStringExtra(Constant.IMAGE_URI);
                    } catch (Exception unused) {
                        return;
                    }
                }
                Uri parse = Uri.parse(str);
                this.imageUri = parse;
                ValueCallback<Uri[]> valueCallback = this.mFilePathCallback;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(new Uri[]{parse});
                }
            }
        } else if (i == 203 && intent != null) {
            try {
                File from = FileUtil.from(getMContext(), intent.getData());
                this.actualImage = from;
                String valueOf = String.valueOf(from != null ? from.getAbsoluteFile() : null);
                String substring = valueOf.substring(StringsKt.lastIndexOf$default((CharSequence) valueOf, InstructionFileId.DOT, 0, false, 6, (Object) null) + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                this.fileExtensionType = substring;
                if (Intrinsics.areEqual(substring, "pdf")) {
                    ValueCallback<Uri[]> valueCallback2 = this.mFilePathCallback;
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue(new Uri[]{intent.getData()});
                        Unit unit = Unit.INSTANCE;
                        return;
                    }
                    return;
                }
                ValueCallback<Uri[]> valueCallback3 = this.mFilePathCallback;
                if (valueCallback3 != null) {
                    valueCallback3.onReceiveValue(new Uri[]{intent.getData()});
                    Unit unit2 = Unit.INSTANCE;
                }
            } catch (IOException e) {
                FragmentActivity mContext = getMContext();
                Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
                ((BaseActivity) getMContext()).errorToast(mContext, "mContext.resources.getString(R.string.failed_read_image_data)");
                e.printStackTrace();
                Unit unit3 = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void chooseFileOpenDialog() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.GET_CONTENT");
        intent.setType("image/*|application/pdf");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "application/pdf"});
        startActivityForResult(intent, Constant.FOLDER_DOCUMENT);
    }

    private final boolean checkPermission() {
        return ActivityCompat.checkSelfPermission(getMContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && ActivityCompat.checkSelfPermission(getMContext(), "android.permission.READ_EXTERNAL_STORAGE") == 0 && ActivityCompat.checkSelfPermission(getMContext(), "android.permission.CAMERA") == 0;
    }

    private final void requestPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.CAMERA"}, 101);
        }
    }

    @Override // com.livpure.safedrink.utils.AdvancedWebView.Listener
    public void onPageStarted(String str, Bitmap bitmap) {
        Log.e("livpurelogs", "onPageStarted: url: " + str);
        Intrinsics.checkNotNull(str);
        FragmentOnboardingWebviewBinding fragmentOnboardingWebviewBinding = null;
        if (Intrinsics.areEqual(str, requireActivity().getString(R.string.onboarding)) || Intrinsics.areEqual(str, requireActivity().getString(R.string.onboarding_auth))) {
            ((TextView) _$_findCachedViewById(R.id.tvLogIn)).setText(requireActivity().getString(R.string.log_in));
        } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "terms_of_use", false, 2, (Object) null)) {
            ((TextView) _$_findCachedViewById(R.id.tvLogIn)).setText(requireActivity().getString(R.string.log_in));
        } else {
            ((TextView) _$_findCachedViewById(R.id.tvLogIn)).setText(requireActivity().getString(R.string.log_out));
        }
        FragmentOnboardingWebviewBinding fragmentOnboardingWebviewBinding2 = this.fragmentOnboardingWebviewBinding;
        if (fragmentOnboardingWebviewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentOnboardingWebviewBinding");
        } else {
            fragmentOnboardingWebviewBinding = fragmentOnboardingWebviewBinding2;
        }
        fragmentOnboardingWebviewBinding.progressBarId.setVisibility(0);
    }

    @Override // com.livpure.safedrink.utils.AdvancedWebView.Listener
    public void onPageFinished(String str) {
        FragmentOnboardingWebviewBinding fragmentOnboardingWebviewBinding = this.fragmentOnboardingWebviewBinding;
        if (fragmentOnboardingWebviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentOnboardingWebviewBinding");
            fragmentOnboardingWebviewBinding = null;
        }
        fragmentOnboardingWebviewBinding.progressBarId.setVisibility(8);
    }

    @Override // com.livpure.safedrink.utils.AdvancedWebView.Listener
    public void onPageError(int i, String str, String str2) {
        FragmentOnboardingWebviewBinding fragmentOnboardingWebviewBinding = this.fragmentOnboardingWebviewBinding;
        if (fragmentOnboardingWebviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentOnboardingWebviewBinding");
            fragmentOnboardingWebviewBinding = null;
        }
        fragmentOnboardingWebviewBinding.progressBarId.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        FragmentOnboardingWebviewBinding fragmentOnboardingWebviewBinding = this.fragmentOnboardingWebviewBinding;
        if (fragmentOnboardingWebviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentOnboardingWebviewBinding");
            fragmentOnboardingWebviewBinding = null;
        }
        fragmentOnboardingWebviewBinding.webview.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FragmentOnboardingWebviewBinding fragmentOnboardingWebviewBinding = this.fragmentOnboardingWebviewBinding;
        if (fragmentOnboardingWebviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentOnboardingWebviewBinding");
            fragmentOnboardingWebviewBinding = null;
        }
        fragmentOnboardingWebviewBinding.webview.onResume();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FragmentOnboardingWebviewBinding fragmentOnboardingWebviewBinding = this.fragmentOnboardingWebviewBinding;
        if (fragmentOnboardingWebviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentOnboardingWebviewBinding");
            fragmentOnboardingWebviewBinding = null;
        }
        fragmentOnboardingWebviewBinding.webview.onDestroy();
        _$_clearFindViewByIdCache();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.GET_CONTENT");
        intent.setType("image/*|application/pdf");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "application/pdf"});
        startActivityForResult(intent, Constant.FOLDER_DOCUMENT);
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, this, false, new Function1<OnBackPressedCallback, Unit>() { // from class: com.livpure.safedrink.app.StaticOnboardingWebViewFragment$onActivityCreated$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OnBackPressedCallback onBackPressedCallback) {
                invoke2(onBackPressedCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnBackPressedCallback addCallback) {
                Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
                System.exit(0);
                throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
            }
        }, 2, null);
    }
}

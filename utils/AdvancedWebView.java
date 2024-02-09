package com.livpure.safedrink.utils;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Environment;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.services.s3.util.Mimetypes;
import com.amplitude.api.Constants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.StaticOnboardingWebViewFragment;
import com.livpure.safedrink.app.StaticWebViewFragment;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;
import kotlin.text.Typography;
import net.sqlcipher.database.SQLiteDatabase;
/* loaded from: classes3.dex */
public class AdvancedWebView extends WebView {
    protected static final String[] ALTERNATIVE_BROWSERS = {"org.mozilla.firefox", "com.android.chrome", "com.opera.browser", "org.mozilla.firefox_beta", "com.chrome.beta", "com.opera.browser.beta"};
    protected static final String CHARSET_DEFAULT = "UTF-8";
    protected static final String DATABASES_SUB_FOLDER = "/databases";
    protected static final String LANGUAGE_DEFAULT_ISO3 = "eng";
    public static final String PACKAGE_NAME_DOWNLOAD_MANAGER = "com.android.providers.downloads";
    protected static final int REQUEST_CODE_FILE_PICKER = 51426;
    private static final String TAG = "AdvancedWebView";
    private boolean isPageReload;
    protected WeakReference<Activity> mActivity;
    private final Context mContext;
    private Activity mContextActivity;
    private Fragment mContextFragment;
    protected WebChromeClient mCustomWebChromeClient;
    protected WebViewClient mCustomWebViewClient;
    protected ValueCallback<Uri> mFileUploadCallbackFirst;
    protected ValueCallback<Uri[]> mFileUploadCallbackSecond;
    protected WeakReference<Fragment> mFragment;
    protected boolean mGeolocationEnabled;
    protected final Map<String, String> mHttpHeaders;
    protected String mLanguageIso3;
    protected long mLastError;
    protected Listener mListener;
    protected final List<String> mPermittedHostnames;
    protected int mRequestCodeFilePicker;
    protected String mUploadableFileTypes;

    /* loaded from: classes3.dex */
    public interface Listener {

        /* renamed from: com.livpure.safedrink.utils.AdvancedWebView$Listener$-CC  reason: invalid class name */
        /* loaded from: classes3.dex */
        public final /* synthetic */ class CC {
            public static void $default$onDownloadRequested(Listener listener, String str, String str2, String str3, long j, String str4, String str5) {
            }

            public static void $default$onExternalPageRequest(Listener listener, String str) {
            }
        }

        void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent);

        void onExternalPageRequest(String url);

        void onPageError(int errorCode, String description, String failingUrl);

        void onPageFinished(String url);

        void onPageStarted(String url, Bitmap favicon);
    }

    public static boolean isFileUploadAvailable(final boolean needsCorrectMimeType) {
        return true;
    }

    public AdvancedWebView(Context context) {
        super(context);
        this.isPageReload = true;
        this.mPermittedHostnames = new LinkedList();
        this.mRequestCodeFilePicker = REQUEST_CODE_FILE_PICKER;
        this.mUploadableFileTypes = "*/*";
        this.mHttpHeaders = new HashMap();
        this.mContext = context;
        init(context);
    }

    public AdvancedWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.isPageReload = true;
        this.mPermittedHostnames = new LinkedList();
        this.mRequestCodeFilePicker = REQUEST_CODE_FILE_PICKER;
        this.mUploadableFileTypes = "*/*";
        this.mHttpHeaders = new HashMap();
        this.mContext = context;
        init(context);
    }

    public AdvancedWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.isPageReload = true;
        this.mPermittedHostnames = new LinkedList();
        this.mRequestCodeFilePicker = REQUEST_CODE_FILE_PICKER;
        this.mUploadableFileTypes = "*/*";
        this.mHttpHeaders = new HashMap();
        this.mContext = context;
        init(context);
    }

    public void setListener(final Activity activity, final Listener listener) {
        this.mContextActivity = activity;
        setListener(activity, listener, REQUEST_CODE_FILE_PICKER);
    }

    public void setListener(final StaticWebViewFragment activity, final Listener listener) {
        this.mContextFragment = activity;
        setListener(activity, listener, REQUEST_CODE_FILE_PICKER);
    }

    public void setListener(final StaticOnboardingWebViewFragment activity, final Listener listener) {
        this.mContextFragment = activity;
        setListener(activity, listener, REQUEST_CODE_FILE_PICKER);
    }

    public void setListener(final Activity activity, final Listener listener, final int requestCodeFilePicker) {
        if (activity != null) {
            this.mActivity = new WeakReference<>(activity);
        } else {
            this.mActivity = null;
        }
        setListener(listener, requestCodeFilePicker);
    }

    public void setListener(final Fragment activity, final Listener listener, final int requestCodeFilePicker) {
        if (activity != null) {
            this.mFragment = new WeakReference<>(activity);
        } else {
            this.mFragment = null;
        }
        setListener(listener, requestCodeFilePicker);
    }

    protected void setListener(final Listener listener, final int requestCodeFilePicker) {
        this.mListener = listener;
        this.mRequestCodeFilePicker = requestCodeFilePicker;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(final WebViewClient client) {
        this.mCustomWebViewClient = client;
    }

    public void setGeolocationEnabled(final boolean enabled) {
        if (enabled) {
            getSettings().setJavaScriptEnabled(true);
            getSettings().setGeolocationEnabled(true);
            setGeolocationDatabasePath();
        }
        this.mGeolocationEnabled = enabled;
    }

    protected void setGeolocationDatabasePath() {
        Activity activity;
        WeakReference<Fragment> weakReference = this.mFragment;
        if (weakReference != null && weakReference.get() != null && this.mFragment.get().getActivity() != null) {
            activity = this.mFragment.get().getActivity();
        } else {
            WeakReference<Activity> weakReference2 = this.mActivity;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            activity = this.mActivity.get();
        }
        getSettings().setGeolocationDatabasePath(activity.getFilesDir().getPath());
    }

    public void setUploadableFileTypes(final String mimeType) {
        this.mUploadableFileTypes = mimeType;
    }

    public void loadHtml(final String html) {
        loadHtml(html, null);
    }

    public void loadHtml(final String html, final String baseUrl) {
        loadHtml(html, baseUrl, null);
    }

    public void loadHtml(final String html, final String baseUrl, final String historyUrl) {
        loadHtml(html, baseUrl, historyUrl, "utf-8");
    }

    public void loadHtml(final String html, final String baseUrl, final String historyUrl, final String encoding) {
        loadDataWithBaseURL(baseUrl, html, Mimetypes.MIMETYPE_HTML, encoding, historyUrl);
    }

    @Override // android.webkit.WebView
    public void onResume() {
        super.onResume();
        resumeTimers();
    }

    @Override // android.webkit.WebView
    public void onPause() {
        super.onPause();
        pauseTimers();
    }

    public void onDestroy() {
        try {
            ((ViewGroup) getParent()).removeView(this);
        } catch (Exception unused) {
        }
        try {
            removeAllViews();
        } catch (Exception unused2) {
        }
        destroy();
    }

    public void onActivityResult(final int requestCode, final int resultCode, final Intent intent) {
        Uri[] uriArr;
        Uri[] uriArr2;
        int i;
        if (requestCode == this.mRequestCodeFilePicker) {
            if (resultCode != -1) {
                ValueCallback<Uri> valueCallback = this.mFileUploadCallbackFirst;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                    this.mFileUploadCallbackFirst = null;
                    return;
                }
                ValueCallback<Uri[]> valueCallback2 = this.mFileUploadCallbackSecond;
                if (valueCallback2 != null) {
                    valueCallback2.onReceiveValue(null);
                    this.mFileUploadCallbackSecond = null;
                }
            } else if (intent != null) {
                ValueCallback<Uri> valueCallback3 = this.mFileUploadCallbackFirst;
                if (valueCallback3 != null) {
                    valueCallback3.onReceiveValue(intent.getData());
                    this.mFileUploadCallbackFirst = null;
                } else if (this.mFileUploadCallbackSecond != null) {
                    try {
                    } catch (Exception unused) {
                        uriArr = null;
                    }
                    if (intent.getDataString() != null) {
                        uriArr2 = new Uri[]{Uri.parse(intent.getDataString())};
                    } else if (intent.getClipData() != null) {
                        int itemCount = intent.getClipData().getItemCount();
                        uriArr = new Uri[itemCount];
                        for (i = 0; i < itemCount; i++) {
                            try {
                                uriArr[i] = intent.getClipData().getItemAt(i).getUri();
                            } catch (Exception unused2) {
                            }
                        }
                        uriArr2 = uriArr;
                    } else {
                        uriArr2 = null;
                    }
                    this.mFileUploadCallbackSecond.onReceiveValue(uriArr2);
                    this.mFileUploadCallbackSecond = null;
                }
            }
        }
    }

    public void addHttpHeader(final String name, final String value) {
        this.mHttpHeaders.put(name, value);
    }

    public void removeHttpHeader(final String name) {
        this.mHttpHeaders.remove(name);
    }

    public void addPermittedHostname(String hostname) {
        this.mPermittedHostnames.add(hostname);
    }

    public void addPermittedHostnames(Collection<? extends String> collection) {
        this.mPermittedHostnames.addAll(collection);
    }

    public List<String> getPermittedHostnames() {
        return this.mPermittedHostnames;
    }

    public void removePermittedHostname(String hostname) {
        this.mPermittedHostnames.remove(hostname);
    }

    public void clearPermittedHostnames() {
        this.mPermittedHostnames.clear();
    }

    public boolean onBackPressed() {
        if (canGoBack()) {
            goBack();
            return false;
        }
        return true;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == 0 && keyCode == 4) {
            if (canGoBack()) {
                goBack();
                return true;
            }
            FragmentActivity activity = this.mContextFragment.getActivity();
            Objects.requireNonNull(activity);
            activity.finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected static void setAllowAccessFromFileUrls(final WebSettings webSettings, final boolean allowed) {
        webSettings.setAllowFileAccessFromFileURLs(allowed);
        webSettings.setAllowUniversalAccessFromFileURLs(allowed);
    }

    public void setCookiesEnabled(final boolean enabled) {
        CookieManager.getInstance().setAcceptCookie(enabled);
    }

    public void setThirdPartyCookiesEnabled(final boolean enabled) {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, enabled);
        }
    }

    public void setMixedContentAllowed(final boolean allowed) {
        setMixedContentAllowed(getSettings(), allowed);
    }

    protected void setMixedContentAllowed(final WebSettings webSettings, final boolean allowed) {
        if (Build.VERSION.SDK_INT >= 21) {
            webSettings.setMixedContentMode(!allowed ? 1 : 0);
        }
    }

    public void setDesktopMode(final boolean enabled) {
        String replace;
        WebSettings settings = getSettings();
        if (enabled) {
            replace = settings.getUserAgentString().replace(AnalyticsEvent.EVENT_TYPE_MOBILE, "eliboM").replace(Constants.PLATFORM, "diordnA");
        } else {
            replace = settings.getUserAgentString().replace("eliboM", AnalyticsEvent.EVENT_TYPE_MOBILE).replace("diordnA", Constants.PLATFORM);
        }
        settings.setUserAgentString(replace);
        settings.setUseWideViewPort(enabled);
        settings.setLoadWithOverviewMode(enabled);
        settings.setSupportZoom(enabled);
        settings.setBuiltInZoomControls(enabled);
    }

    protected void init(Context context) {
        if (isInEditMode()) {
            return;
        }
        if (context instanceof Activity) {
            this.mActivity = new WeakReference<>((Activity) context);
        }
        this.mLanguageIso3 = getLanguageIso3();
        setFocusable(true);
        setFocusableInTouchMode(true);
        setSaveEnabled(true);
        String path = context.getFilesDir().getPath();
        path.substring(0, path.lastIndexOf("/"));
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        setAllowAccessFromFileUrls(settings, false);
        settings.setBuiltInZoomControls(false);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        setThirdPartyCookiesEnabled(true);
        super.setWebViewClient(new WebViewClient() { // from class: com.livpure.safedrink.utils.AdvancedWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Log.e(AdvancedWebView.TAG, "onPageStarted: " + url);
                if (!AdvancedWebView.this.hasError() && AdvancedWebView.this.mListener != null) {
                    AdvancedWebView.this.mListener.onPageStarted(url, favicon);
                }
                if (AdvancedWebView.this.mCustomWebViewClient != null) {
                    AdvancedWebView.this.mCustomWebViewClient.onPageStarted(view, url, favicon);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (!AdvancedWebView.this.hasError() && AdvancedWebView.this.mListener != null) {
                    AdvancedWebView.this.mListener.onPageFinished(url);
                }
                if (AdvancedWebView.this.mCustomWebViewClient != null) {
                    AdvancedWebView.this.mCustomWebViewClient.onPageFinished(view, url);
                }
                if (view.getProgress() == 100) {
                    AdvancedWebView.this.isPageReload = false;
                }
                Log.e(AdvancedWebView.TAG, "onProgress: ===========>" + view.getProgress());
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                AdvancedWebView.this.setLastError();
                if (AdvancedWebView.this.mListener != null) {
                    AdvancedWebView.this.mListener.onPageError(errorCode, description, failingUrl);
                }
                if (AdvancedWebView.this.mCustomWebViewClient != null) {
                    AdvancedWebView.this.mCustomWebViewClient.onReceivedError(view, errorCode, description, failingUrl);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
                Intent intent;
                if (!AdvancedWebView.this.isPermittedUrl(url)) {
                    if (AdvancedWebView.this.mListener != null) {
                        AdvancedWebView.this.mListener.onExternalPageRequest(url);
                    }
                    return true;
                } else if (AdvancedWebView.this.mCustomWebViewClient == null || !AdvancedWebView.this.mCustomWebViewClient.shouldOverrideUrlLoading(view, url)) {
                    Uri parse = Uri.parse(url);
                    String scheme = parse.getScheme();
                    if (scheme != null) {
                        if (scheme.equals("tel")) {
                            intent = new Intent("android.intent.action.DIAL", parse);
                        } else if (scheme.equals("sms")) {
                            intent = new Intent("android.intent.action.SENDTO", parse);
                        } else if (scheme.equals("mailto")) {
                            intent = new Intent("android.intent.action.SENDTO", parse);
                        } else if (scheme.equals("whatsapp")) {
                            intent = new Intent("android.intent.action.SENDTO", parse);
                            intent.setPackage("com.whatsapp");
                        } else {
                            intent = null;
                        }
                        if (intent != null) {
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            try {
                                if (AdvancedWebView.this.mActivity != null && AdvancedWebView.this.mActivity.get() != null) {
                                    AdvancedWebView.this.mActivity.get().startActivity(intent);
                                } else {
                                    AdvancedWebView.this.getContext().startActivity(intent);
                                }
                            } catch (ActivityNotFoundException unused) {
                            }
                            return true;
                        }
                    }
                    view.loadUrl(url);
                    return true;
                } else {
                    return true;
                }
            }

            @Override // android.webkit.WebViewClient
            public void onLoadResource(WebView view, String url) {
                if (AdvancedWebView.this.mCustomWebViewClient != null) {
                    AdvancedWebView.this.mCustomWebViewClient.onLoadResource(view, url);
                } else {
                    super.onLoadResource(view, url);
                }
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                if (AdvancedWebView.this.mCustomWebViewClient != null) {
                    return AdvancedWebView.this.mCustomWebViewClient.shouldInterceptRequest(view, url);
                }
                return super.shouldInterceptRequest(view, url);
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (AdvancedWebView.this.mCustomWebViewClient != null) {
                        return AdvancedWebView.this.mCustomWebViewClient.shouldInterceptRequest(view, request);
                    }
                    return super.shouldInterceptRequest(view, request);
                }
                return null;
            }

            @Override // android.webkit.WebViewClient
            public void onFormResubmission(WebView view, Message dontResend, Message resend) {
                if (AdvancedWebView.this.mCustomWebViewClient != null) {
                    AdvancedWebView.this.mCustomWebViewClient.onFormResubmission(view, dontResend, resend);
                } else {
                    super.onFormResubmission(view, dontResend, resend);
                }
            }

            @Override // android.webkit.WebViewClient
            public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
                if (AdvancedWebView.this.mCustomWebViewClient != null) {
                    AdvancedWebView.this.mCustomWebViewClient.doUpdateVisitedHistory(view, url, isReload);
                } else {
                    super.doUpdateVisitedHistory(view, url, isReload);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                if (AdvancedWebView.this.mCustomWebViewClient != null) {
                    AdvancedWebView.this.mCustomWebViewClient.onReceivedSslError(view, handler, error);
                } else {
                    super.onReceivedSslError(view, handler, error);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (AdvancedWebView.this.mCustomWebViewClient != null) {
                        AdvancedWebView.this.mCustomWebViewClient.onReceivedClientCertRequest(view, request);
                    } else {
                        super.onReceivedClientCertRequest(view, request);
                    }
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
                if (AdvancedWebView.this.mCustomWebViewClient != null) {
                    AdvancedWebView.this.mCustomWebViewClient.onReceivedHttpAuthRequest(view, handler, host, realm);
                } else {
                    super.onReceivedHttpAuthRequest(view, handler, host, realm);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                if (AdvancedWebView.this.mCustomWebViewClient != null) {
                    return AdvancedWebView.this.mCustomWebViewClient.shouldOverrideKeyEvent(view, event);
                }
                return super.shouldOverrideKeyEvent(view, event);
            }

            @Override // android.webkit.WebViewClient
            public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
                if (AdvancedWebView.this.mCustomWebViewClient != null) {
                    AdvancedWebView.this.mCustomWebViewClient.onUnhandledKeyEvent(view, event);
                } else {
                    super.onUnhandledKeyEvent(view, event);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onScaleChanged(WebView view, float oldScale, float newScale) {
                if (AdvancedWebView.this.mCustomWebViewClient != null) {
                    AdvancedWebView.this.mCustomWebViewClient.onScaleChanged(view, oldScale, newScale);
                } else {
                    super.onScaleChanged(view, oldScale, newScale);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
                if (AdvancedWebView.this.mCustomWebViewClient != null) {
                    AdvancedWebView.this.mCustomWebViewClient.onReceivedLoginRequest(view, realm, account, args);
                } else {
                    super.onReceivedLoginRequest(view, realm, account, args);
                }
            }
        });
        super.setWebChromeClient(new WebChromeClient() { // from class: com.livpure.safedrink.utils.AdvancedWebView.2
            private boolean checkPermission() {
                return ContextCompat.checkSelfPermission(AdvancedWebView.this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(AdvancedWebView.this.mContext, "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(AdvancedWebView.this.mContext, "android.permission.CAMERA") == 0;
            }

            private void requestPermission() {
                if (Build.VERSION.SDK_INT >= 23) {
                    AdvancedWebView.this.mContextFragment.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.CAMERA"}, 101);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    AdvancedWebView.this.mCustomWebChromeClient.onProgressChanged(view, newProgress);
                } else {
                    super.onProgressChanged(view, newProgress);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView view, String title) {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    AdvancedWebView.this.mCustomWebChromeClient.onReceivedTitle(view, title);
                } else {
                    super.onReceivedTitle(view, title);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedIcon(WebView view, Bitmap icon) {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    AdvancedWebView.this.mCustomWebChromeClient.onReceivedIcon(view, icon);
                } else {
                    super.onReceivedIcon(view, icon);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    AdvancedWebView.this.mCustomWebChromeClient.onReceivedTouchIconUrl(view, url, precomposed);
                } else {
                    super.onReceivedTouchIconUrl(view, url, precomposed);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    AdvancedWebView.this.mCustomWebChromeClient.onShowCustomView(view, callback);
                } else {
                    super.onShowCustomView(view, callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, int requestedOrientation, WebChromeClient.CustomViewCallback callback) {
                if (Build.VERSION.SDK_INT >= 14) {
                    if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                        AdvancedWebView.this.mCustomWebChromeClient.onShowCustomView(view, requestedOrientation, callback);
                    } else {
                        super.onShowCustomView(view, requestedOrientation, callback);
                    }
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    AdvancedWebView.this.mCustomWebChromeClient.onHideCustomView();
                } else {
                    super.onHideCustomView();
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    return AdvancedWebView.this.mCustomWebChromeClient.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
                }
                return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
            }

            @Override // android.webkit.WebChromeClient
            public void onRequestFocus(WebView view) {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    AdvancedWebView.this.mCustomWebChromeClient.onRequestFocus(view);
                } else {
                    super.onRequestFocus(view);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onCloseWindow(WebView window) {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    AdvancedWebView.this.mCustomWebChromeClient.onCloseWindow(window);
                } else {
                    super.onCloseWindow(window);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    return AdvancedWebView.this.mCustomWebChromeClient.onJsAlert(view, url, message, result);
                }
                return super.onJsAlert(view, url, message, result);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    return AdvancedWebView.this.mCustomWebChromeClient.onJsConfirm(view, url, message, result);
                }
                return super.onJsConfirm(view, url, message, result);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    return AdvancedWebView.this.mCustomWebChromeClient.onJsPrompt(view, url, message, defaultValue, result);
                }
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    return AdvancedWebView.this.mCustomWebChromeClient.onJsBeforeUnload(view, url, message, result);
                }
                return super.onJsBeforeUnload(view, url, message, result);
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                if (AdvancedWebView.this.mGeolocationEnabled) {
                    callback.invoke(origin, true, false);
                } else if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    AdvancedWebView.this.mCustomWebChromeClient.onGeolocationPermissionsShowPrompt(origin, callback);
                } else {
                    super.onGeolocationPermissionsShowPrompt(origin, callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsHidePrompt() {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    AdvancedWebView.this.mCustomWebChromeClient.onGeolocationPermissionsHidePrompt();
                } else {
                    super.onGeolocationPermissionsHidePrompt();
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onPermissionRequest(PermissionRequest request) {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                        AdvancedWebView.this.mCustomWebChromeClient.onPermissionRequest(request);
                    } else {
                        super.onPermissionRequest(request);
                    }
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onPermissionRequestCanceled(PermissionRequest request) {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                        AdvancedWebView.this.mCustomWebChromeClient.onPermissionRequestCanceled(request);
                    } else {
                        super.onPermissionRequestCanceled(request);
                    }
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsTimeout() {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    return AdvancedWebView.this.mCustomWebChromeClient.onJsTimeout();
                }
                return super.onJsTimeout();
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String message, int lineNumber, String sourceID) {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    AdvancedWebView.this.mCustomWebChromeClient.onConsoleMessage(message, lineNumber, sourceID);
                } else {
                    super.onConsoleMessage(message, lineNumber, sourceID);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    return AdvancedWebView.this.mCustomWebChromeClient.onConsoleMessage(consoleMessage);
                }
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    return AdvancedWebView.this.mCustomWebChromeClient.getDefaultVideoPoster();
                }
                return super.getDefaultVideoPoster();
            }

            @Override // android.webkit.WebChromeClient
            public View getVideoLoadingProgressView() {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    return AdvancedWebView.this.mCustomWebChromeClient.getVideoLoadingProgressView();
                }
                return super.getVideoLoadingProgressView();
            }

            @Override // android.webkit.WebChromeClient
            public void getVisitedHistory(ValueCallback<String[]> callback) {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    AdvancedWebView.this.mCustomWebChromeClient.getVisitedHistory(callback);
                } else {
                    super.getVisitedHistory(callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onExceededDatabaseQuota(String url, String databaseIdentifier, long quota, long estimatedDatabaseSize, long totalQuota, WebStorage.QuotaUpdater quotaUpdater) {
                if (AdvancedWebView.this.mCustomWebChromeClient != null) {
                    AdvancedWebView.this.mCustomWebChromeClient.onExceededDatabaseQuota(url, databaseIdentifier, quota, estimatedDatabaseSize, totalQuota, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(url, databaseIdentifier, quota, estimatedDatabaseSize, totalQuota, quotaUpdater);
                }
            }
        });
        setDownloadListener(new DownloadListener() { // from class: com.livpure.safedrink.utils.AdvancedWebView.3
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(final String url, final String userAgent, final String contentDisposition, final String mimeType, final long contentLength) {
                String guessFileName = URLUtil.guessFileName(url, contentDisposition, mimeType);
                if (AdvancedWebView.this.mListener != null) {
                    AdvancedWebView.this.mListener.onDownloadRequested(url, guessFileName, mimeType, contentLength, contentDisposition, userAgent);
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String url, Map<String, String> additionalHttpHeaders) {
        if (additionalHttpHeaders == null) {
            additionalHttpHeaders = this.mHttpHeaders;
        } else if (this.mHttpHeaders.size() > 0) {
            additionalHttpHeaders.putAll(this.mHttpHeaders);
        }
        super.loadUrl(url, additionalHttpHeaders);
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String url) {
        if (this.mHttpHeaders.size() > 0) {
            super.loadUrl(url, this.mHttpHeaders);
        } else {
            super.loadUrl(url);
        }
    }

    public void loadUrl(String url, final boolean preventCaching) {
        if (preventCaching) {
            url = makeUrlUnique(url);
        }
        loadUrl(url);
    }

    public void loadUrl(String url, final boolean preventCaching, final Map<String, String> additionalHttpHeaders) {
        if (preventCaching) {
            url = makeUrlUnique(url);
        }
        loadUrl(url, additionalHttpHeaders);
    }

    protected static String makeUrlUnique(final String url) {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        if (url.contains("?")) {
            sb.append(Typography.amp);
        } else {
            if (url.lastIndexOf(47) <= 7) {
                sb.append('/');
            }
            sb.append('?');
        }
        sb.append(System.currentTimeMillis());
        sb.append('=');
        sb.append(1);
        return sb.toString();
    }

    public boolean isPermittedUrl(final String url) {
        if (this.mPermittedHostnames.size() == 0) {
            return true;
        }
        Uri parse = Uri.parse(url);
        String host = parse.getHost();
        if (host != null && host.matches("^[a-zA-Z0-9._!~*')(;:&=+$,%\\[\\]-]*$")) {
            String userInfo = parse.getUserInfo();
            if (userInfo == null || userInfo.matches("^[a-zA-Z0-9._!~*')(;:&=+$,%-]*$")) {
                for (String str : this.mPermittedHostnames) {
                    if (!host.equals(str)) {
                        if (host.endsWith(InstructionFileId.DOT + str)) {
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    protected boolean isHostnameAllowed(final String url) {
        return isPermittedUrl(url);
    }

    protected void setLastError() {
        this.mLastError = System.currentTimeMillis();
    }

    protected boolean hasError() {
        return this.mLastError + 500 >= System.currentTimeMillis();
    }

    protected static String getLanguageIso3() {
        try {
            return Locale.getDefault().getISO3Language().toLowerCase(Locale.US);
        } catch (MissingResourceException unused) {
            return LANGUAGE_DEFAULT_ISO3;
        }
    }

    public void setPageLoadStatus(boolean isReload) {
        this.isPageReload = isReload;
    }

    protected String getFileUploadPromptLabel() {
        try {
            if (this.mLanguageIso3.equals("zho")) {
                return decodeBase64("6YCJ5oup5LiA5Liq5paH5Lu2");
            }
            if (this.mLanguageIso3.equals("spa")) {
                return decodeBase64("RWxpamEgdW4gYXJjaGl2bw==");
            }
            if (this.mLanguageIso3.equals("hin")) {
                return decodeBase64("4KSP4KSVIOCkq+CkvOCkvuCkh+CksiDgpJrgpYHgpKjgpYfgpII=");
            }
            if (this.mLanguageIso3.equals("ben")) {
                return decodeBase64("4KaP4KaV4Kaf4Ka/IOCmq+CmvuCmh+CmsiDgpqjgpr/gprDgp43gpqzgpr7gpprgpqg=");
            }
            if (this.mLanguageIso3.equals("ara")) {
                return decodeBase64("2KfYrtiq2YrYp9ixINmF2YTZgSDZiNin2K3Yrw==");
            }
            if (this.mLanguageIso3.equals("por")) {
                return decodeBase64("RXNjb2xoYSB1bSBhcnF1aXZv");
            }
            if (this.mLanguageIso3.equals("rus")) {
                return decodeBase64("0JLRi9Cx0LXRgNC40YLQtSDQvtC00LjQvSDRhNCw0LnQuw==");
            }
            if (this.mLanguageIso3.equals("jpn")) {
                return decodeBase64("MeODleOCoeOCpOODq+OCkumBuOaKnuOBl+OBpuOBj+OBoOOBleOBhA==");
            }
            if (this.mLanguageIso3.equals("pan")) {
                return decodeBase64("4KiH4Kmx4KiVIOCoq+CovuCoh+CosiDgqJrgqYHgqKPgqYs=");
            }
            if (this.mLanguageIso3.equals("deu")) {
                return decodeBase64("V8OkaGxlIGVpbmUgRGF0ZWk=");
            }
            if (this.mLanguageIso3.equals("jav")) {
                return decodeBase64("UGlsaWggc2lqaSBiZXJrYXM=");
            }
            if (this.mLanguageIso3.equals("msa")) {
                return decodeBase64("UGlsaWggc2F0dSBmYWls");
            }
            if (this.mLanguageIso3.equals("tel")) {
                return decodeBase64("4LCS4LCVIOCwq+CxhuCxluCwsuCxjeCwqOCxgSDgsI7gsILgsJrgsYHgsJXgsYvgsILgsKHgsL8=");
            }
            if (this.mLanguageIso3.equals("vie")) {
                return decodeBase64("Q2jhu41uIG3hu5l0IHThuq1wIHRpbg==");
            }
            if (this.mLanguageIso3.equals("kor")) {
                return decodeBase64("7ZWY64KY7J2YIO2MjOydvOydhCDshKDtg50=");
            }
            if (this.mLanguageIso3.equals("fra")) {
                return decodeBase64("Q2hvaXNpc3NleiB1biBmaWNoaWVy");
            }
            if (this.mLanguageIso3.equals("mar")) {
                return decodeBase64("4KSr4KS+4KSH4KSyIOCkqOCkv+CkteCkoeCkvg==");
            }
            if (this.mLanguageIso3.equals("tam")) {
                return decodeBase64("4K6S4K6w4K+BIOCuleCvh+CuvuCuquCvjeCuquCviCDgrqTgr4fgrrDgr43grrXgr4E=");
            }
            if (this.mLanguageIso3.equals("urd")) {
                return decodeBase64("2KfbjNqpINmB2KfYptmEINmF24zauiDYs9uSINin2YbYqtiu2KfYqCDaqdix24zaug==");
            }
            if (this.mLanguageIso3.equals("fas")) {
                return decodeBase64("2LHYpyDYp9mG2KrYrtin2Kgg2qnZhtuM2K8g24zaqSDZgdin24zZhA==");
            }
            if (this.mLanguageIso3.equals("tur")) {
                return decodeBase64("QmlyIGRvc3lhIHNlw6dpbg==");
            }
            if (this.mLanguageIso3.equals("ita")) {
                return decodeBase64("U2NlZ2xpIHVuIGZpbGU=");
            }
            if (this.mLanguageIso3.equals("tha")) {
                return decodeBase64("4LmA4Lil4Li34Lit4LiB4LmE4Lif4Lil4LmM4Lir4LiZ4Li24LmI4LiH");
            }
            return this.mLanguageIso3.equals("guj") ? decodeBase64("4KqP4KqVIOCqq+CqvuCqh+CqsuCqqOCrhyDgqqrgqrjgqoLgqqY=") : "Choose a file";
        } catch (Exception unused) {
            return "Choose a file";
        }
    }

    protected static String decodeBase64(final String base64) throws IllegalArgumentException, UnsupportedEncodingException {
        return new String(Base64.decode(base64, 0), "UTF-8");
    }

    protected void openFileInput(final ValueCallback<Uri[]> fileUploadCallbackSecond, WebChromeClient.FileChooserParams fileChooserParams) {
        File file;
        String[] split;
        this.mFileUploadCallbackSecond = fileUploadCallbackSecond;
        loop0: for (String str : fileChooserParams.getAcceptTypes()) {
            for (String str2 : str.split(", ?+")) {
                char c = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != 41861) {
                    if (hashCode == 1911932022 && str2.equals("image/*")) {
                        c = 1;
                    }
                } else if (str2.equals("*/*")) {
                    c = 0;
                }
                if (c == 0) {
                    break loop0;
                }
            }
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(this.mContext.getPackageManager()) != null) {
            try {
                file = create_image();
            } catch (IOException e) {
                Log.e(TAG, "Image file creation failed", e);
                file = null;
            }
            if (file != null) {
                intent.putExtra("output", Uri.fromFile(file));
            } else {
                intent = null;
            }
        }
        Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
        intent2.addCategory("android.intent.category.OPENABLE");
        intent2.setType("*/*");
        intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        Intent[] intentArr = intent != null ? new Intent[]{intent} : new Intent[0];
        Intent intent3 = new Intent("android.intent.action.CHOOSER");
        intent3.putExtra("android.intent.extra.INTENT", intent2);
        intent3.putExtra("android.intent.extra.TITLE", this.mContext.getString(R.string.file_chooser));
        intent3.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
        this.mContextFragment.startActivityForResult(intent3, this.mRequestCodeFilePicker);
    }

    private File create_image() throws IOException {
        String format = new SimpleDateFormat("yyyy_mm_ss", Locale.ENGLISH).format(new Date());
        return File.createTempFile("file_" + format + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR, ".jpg", this.mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
    }

    public static boolean isFileUploadAvailable() {
        return isFileUploadAvailable(false);
    }

    public static boolean handleDownload(final Context context, final String fromUrl, final String toFilename) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(fromUrl));
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, toFilename);
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        try {
            try {
                downloadManager.enqueue(request);
            } catch (SecurityException unused) {
                request.setNotificationVisibility(0);
                downloadManager.enqueue(request);
            }
            return true;
        } catch (IllegalArgumentException unused2) {
            openAppSettings(context, PACKAGE_NAME_DOWNLOAD_MANAGER);
            return false;
        }
    }

    private static boolean openAppSettings(final Context context, final String packageName) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + packageName));
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class Browsers {
        private static String mAlternativePackage;

        public static boolean hasAlternative(final Context context) {
            return getAlternative(context) != null;
        }

        public static String getAlternative(final Context context) {
            String str = mAlternativePackage;
            if (str != null) {
                return str;
            }
            List asList = Arrays.asList(AdvancedWebView.ALTERNATIVE_BROWSERS);
            for (ApplicationInfo applicationInfo : context.getPackageManager().getInstalledApplications(128)) {
                if (applicationInfo.enabled && asList.contains(applicationInfo.packageName)) {
                    mAlternativePackage = applicationInfo.packageName;
                    return applicationInfo.packageName;
                }
            }
            return null;
        }

        public static void openUrl(final Activity context, final String url) {
            openUrl(context, url, false);
        }

        public static void openUrl(final Activity context, final String url, final boolean withoutTransition) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            intent.setPackage(getAlternative(context));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
            if (withoutTransition) {
                context.overridePendingTransition(0, 0);
            }
        }
    }
}

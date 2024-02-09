package com.livpure.safedrink.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.livpure.safedrink.common.arc.SingletonHolder;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AppLifeCycleManager.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/livpure/safedrink/app/AppLifeCycleManager;", "", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "hasNotificationDeeplink", "getHasNotificationDeeplink", "()Ljava/lang/String;", "setHasNotificationDeeplink", "(Ljava/lang/String;)V", "", "hasOnBoardingBeenShown", "getHasOnBoardingBeenShown", "()Z", "setHasOnBoardingBeenShown", "(Z)V", "prefs", "Landroid/content/SharedPreferences;", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppLifeCycleManager {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_DEEP_LINK_SHOWN = "";
    private static final String KEY_ONBOARDING_SHOWN = "hasOnboardingBeenShown";
    private final SharedPreferences prefs;

    public /* synthetic */ AppLifeCycleManager(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private AppLifeCycleManager(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("LSHLifecyclePrefs", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.applicationConte…s\", Context.MODE_PRIVATE)");
        this.prefs = sharedPreferences;
    }

    /* compiled from: AppLifeCycleManager.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/livpure/safedrink/app/AppLifeCycleManager$Companion;", "Lcom/livpure/safedrink/common/arc/SingletonHolder;", "Lcom/livpure/safedrink/app/AppLifeCycleManager;", "Landroid/content/Context;", "()V", "KEY_DEEP_LINK_SHOWN", "", "KEY_ONBOARDING_SHOWN", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion extends SingletonHolder<AppLifeCycleManager, Context> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: AppLifeCycleManager.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: com.livpure.safedrink.app.AppLifeCycleManager$Companion$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Context, AppLifeCycleManager> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(1, AppLifeCycleManager.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AppLifeCycleManager invoke(Context p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                return new AppLifeCycleManager(p0, null);
            }
        }

        private Companion() {
            super(AnonymousClass1.INSTANCE);
        }
    }

    public final boolean getHasOnBoardingBeenShown() {
        return this.prefs.getBoolean(KEY_ONBOARDING_SHOWN, false);
    }

    public final void setHasOnBoardingBeenShown(boolean z) {
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putBoolean(KEY_ONBOARDING_SHOWN, z);
        edit.apply();
    }

    public final String getHasNotificationDeeplink() {
        return this.prefs.getString("", "");
    }

    public final void setHasNotificationDeeplink(String str) {
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putString("", str);
        edit.apply();
    }
}

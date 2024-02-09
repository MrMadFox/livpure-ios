package com.livpure.safedrink.common.arc.ui.views;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.livpure.safedrink.BuildConfig;
import com.newrelic.agent.android.NewRelic;
import com.segment.analytics.Analytics;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: BaseActivity.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0004J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u0004H\u0004¨\u0006\u000f"}, d2 = {"Lcom/livpure/safedrink/common/arc/ui/views/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "errorToast", "", "mContext", "Landroid/content/Context;", "message", "", "getScreenName", "initializeNewRelic", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "startScreenTracking", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class BaseActivity extends AppCompatActivity {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        startScreenTracking();
        initializeNewRelic();
    }

    protected final void startScreenTracking() {
        if (isFinishing()) {
            return;
        }
        Analytics.with(this).screen(getScreenName());
    }

    private final String getScreenName() {
        String activityName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(activityName, "activityName");
        if (StringsKt.contains$default((CharSequence) activityName, (CharSequence) "Activity", false, 2, (Object) null)) {
            Intrinsics.checkNotNullExpressionValue(activityName, "activityName");
            activityName = StringsKt.removeSuffix(activityName, (CharSequence) "Activity");
        }
        Intrinsics.checkNotNullExpressionValue(activityName, "activityName");
        return activityName;
    }

    protected final void initializeNewRelic() {
        NewRelic.withApplicationToken(BuildConfig.NEW_RELIC_TOKEN).start(getApplication());
    }

    public final void errorToast(Context mContext, String message) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(message, "message");
        Toast.makeText(mContext, message, 0).show();
    }
}

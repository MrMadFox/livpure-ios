package com.livpure.safedrink.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.login.MainActivity;
import com.livpure.safedrink.utils.StringUtilsKt;
import com.segment.analytics.Analytics;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ReferalBaseFragment.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\n\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u0004H\u0016J\u0012\u0010#\u001a\u00020$2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010%\u001a\u00020$2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010(\u001a\u00020$H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/livpure/safedrink/view/fragment/ReferalBaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "hasInitializedRootView", "", "getHasInitializedRootView", "()Z", "setHasInitializedRootView", "(Z)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/BaseViewModel;", "getMViewModel", "()Lcom/livpure/safedrink/common/arc/ui/viewmodels/BaseViewModel;", "setMViewModel", "(Lcom/livpure/safedrink/common/arc/ui/viewmodels/BaseViewModel;)V", "rootView", "Landroid/view/View;", "getPersistentView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "layout", "", "getScreenName", "", "isToolBarVisible", "onActivityCreated", "", "onCreate", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "trackScreen", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ReferalBaseFragment extends Fragment {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private boolean hasInitializedRootView;
    public Context mContext;
    public BaseViewModel mViewModel;
    private View rootView;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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

    public boolean isToolBarVisible() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final Context getMContext() {
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        return null;
    }

    public final void setMContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    public final BaseViewModel getMViewModel() {
        BaseViewModel baseViewModel = this.mViewModel;
        if (baseViewModel != null) {
            return baseViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        return null;
    }

    public final void setMViewModel(BaseViewModel baseViewModel) {
        Intrinsics.checkNotNullParameter(baseViewModel, "<set-?>");
        this.mViewModel = baseViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (isAdded() && (requireActivity() instanceof MainActivity)) {
            ((MainActivity) requireActivity()).changeToolbarVisibility(isToolBarVisible());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        setMContext(requireActivity);
        setMViewModel((BaseViewModel) new ViewModelProvider(this).get(BaseViewModel.class));
    }

    public final boolean getHasInitializedRootView() {
        return this.hasInitializedRootView;
    }

    public final void setHasInitializedRootView(boolean z) {
        this.hasInitializedRootView = z;
    }

    public final View getPersistentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, int i) {
        View view = this.rootView;
        if (view == null) {
            this.rootView = layoutInflater != null ? layoutInflater.inflate(i, viewGroup, false) : null;
        } else {
            ViewParent parent = view != null ? view.getParent() : null;
            ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.rootView);
            }
        }
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (LSApplication.Companion.isNeedAnalytics()) {
            trackScreen();
        }
    }

    private final void trackScreen() {
        if (isAdded()) {
            Analytics.with(requireActivity()).screen(getScreenName());
        }
    }

    protected String getScreenName() {
        String fragmentName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(fragmentName, "fragmentName");
        if (StringsKt.contains$default((CharSequence) fragmentName, (CharSequence) "Fragment", false, 2, (Object) null)) {
            Intrinsics.checkNotNullExpressionValue(fragmentName, "fragmentName");
            fragmentName = StringsKt.removeSuffix(fragmentName, (CharSequence) "Fragment");
        }
        Intrinsics.checkNotNullExpressionValue(fragmentName, "fragmentName");
        return StringUtilsKt.fromCamelCaseToSpacedWords(fragmentName);
    }
}

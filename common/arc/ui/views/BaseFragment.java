package com.livpure.safedrink.common.arc.ui.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.api.APIUtilKt;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.BaseViewModel;
import com.livpure.safedrink.login.MainActivity;
import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.livpure.safedrink.utils.StringUtilsKt;
import com.segment.analytics.Analytics;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: BaseFragment.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH%J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H$J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001f\u001a\u00020\nH\u0004J\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u000eH\u0014J\b\u0010\"\u001a\u00020\nH\u0002Ja\u0010#\u001a\u00020\n\"\b\b\u0000\u0010$*\u00020%*\u0004\u0018\u0001H$2!\u0010&\u001a\u001d\u0012\u0013\u0012\u0011H$¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\n0'2!\u0010+\u001a\u001d\u0012\u0013\u0012\u0011H$¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\n0'¢\u0006\u0002\u0010,R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006-"}, d2 = {"Lcom/livpure/safedrink/common/arc/ui/views/BaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "mContext", "Landroidx/fragment/app/FragmentActivity;", "getMContext", "()Landroidx/fragment/app/FragmentActivity;", "mContext$delegate", "Lkotlin/Lazy;", "beforeScreenAnalytics", "", "getLayoutId", "", "getScreenName", "", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/BaseViewModel;", "isToolbarVisible", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "showNoNetworkScreen", "showToast", "errorMessage", "trackScreen", "processResponse", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "response", "onFailure", "(Lcom/livpure/safedrink/login/api/models/response/BaseV1Response;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseFragment extends Fragment {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy mContext$delegate = LazyKt.lazy(new Function0<FragmentActivity>() { // from class: com.livpure.safedrink.common.arc.ui.views.BaseFragment$mContext$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FragmentActivity invoke() {
            return BaseFragment.this.requireActivity();
        }
    });

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

    protected void beforeScreenAnalytics() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getLayoutId();

    protected abstract BaseViewModel getViewModel();

    protected boolean isToolbarVisible() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final FragmentActivity getMContext() {
        return (FragmentActivity) this.mContext$delegate.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        LiveData<BaseViewModel.NetworkState> networkState;
        LiveData<Event<String>> checkForMessages;
        super.onCreate(bundle);
        BaseViewModel viewModel = getViewModel();
        if (viewModel != null && (checkForMessages = viewModel.checkForMessages()) != null) {
            checkForMessages.observe(this, new Observer() { // from class: com.livpure.safedrink.common.arc.ui.views.BaseFragment$$ExternalSyntheticLambda0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseFragment.m541onCreate$lambda1(BaseFragment.this, (Event) obj);
                }
            });
        }
        BaseViewModel viewModel2 = getViewModel();
        if (viewModel2 == null || (networkState = viewModel2.getNetworkState()) == null) {
            return;
        }
        networkState.observe(this, new Observer() { // from class: com.livpure.safedrink.common.arc.ui.views.BaseFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseFragment.m542onCreate$lambda2(BaseFragment.this, (BaseViewModel.NetworkState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m541onCreate$lambda1(BaseFragment this$0, Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = (String) event.getContentIfNotHandled();
        if (str != null) {
            this$0.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m542onCreate$lambda2(BaseFragment this$0, BaseViewModel.NetworkState networkState) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (networkState == BaseViewModel.NetworkState.OFFLINE && this$0.isAdded()) {
            this$0.showNoNetworkScreen();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void showNoNetworkScreen() {
        ((MainActivity) requireActivity()).navigateToNoNetworkScreen();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(getLayoutId(), viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        LiveData<Boolean> checkScreenTrackingState;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        BaseViewModel viewModel = getViewModel();
        if (viewModel == null || (checkScreenTrackingState = viewModel.checkScreenTrackingState()) == null) {
            return;
        }
        checkScreenTrackingState.observe(this, new Observer() { // from class: com.livpure.safedrink.common.arc.ui.views.BaseFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseFragment.m543onViewCreated$lambda3(BaseFragment.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m543onViewCreated$lambda3(BaseFragment this$0, Boolean shouldTrack) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(shouldTrack, "shouldTrack");
        if (shouldTrack.booleanValue()) {
            this$0.trackScreen();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (isAdded() && (requireActivity() instanceof MainActivity)) {
            MainActivity mainActivity = (MainActivity) requireActivity();
            mainActivity.changeToolbarVisibility(isToolbarVisible());
            mainActivity.changeDrawerLockStatus(!isToolbarVisible() || LSApplication.Companion.getUser() == null);
        }
    }

    public final <T extends BaseV1Response> void processResponse(T t, Function1<? super T, Unit> onSuccess, Function1<? super T, Unit> onFailure) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        APIUtilKt.processResponseWithAPIException(t, onSuccess, onFailure, new Function0<Unit>() { // from class: com.livpure.safedrink.common.arc.ui.views.BaseFragment$processResponse$1
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
                BaseFragment.this.showNoNetworkScreen();
            }
        });
    }

    private final void trackScreen() {
        if (isAdded()) {
            Analytics.with(requireActivity()).screen(getScreenName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getScreenName() {
        String fragmentName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(fragmentName, "fragmentName");
        if (StringsKt.contains$default((CharSequence) fragmentName, (CharSequence) "Fragment", false, 2, (Object) null)) {
            Intrinsics.checkNotNullExpressionValue(fragmentName, "fragmentName");
            fragmentName = StringsKt.removeSuffix(fragmentName, (CharSequence) "Fragment");
        }
        Intrinsics.checkNotNullExpressionValue(fragmentName, "fragmentName");
        return StringUtilsKt.fromCamelCaseToSpacedWords(fragmentName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToast(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        if (isAdded()) {
            Toast.makeText(requireActivity(), errorMessage, 1).show();
        }
    }
}

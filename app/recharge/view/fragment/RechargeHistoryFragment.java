package com.livpure.safedrink.app.recharge.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.app.recharge.data.viewmodel.HistoryViewModel;
import com.livpure.safedrink.app.recharge.view.adapter.RechargeHistoryAdapter;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.views.BaseFragment;
import com.livpure.safedrink.login.data.models.User;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RechargeHistoryFragment.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/livpure/safedrink/app/recharge/view/fragment/RechargeHistoryFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/BaseFragment;", "()V", "historyViewModel", "Lcom/livpure/safedrink/app/recharge/data/viewmodel/HistoryViewModel;", AnalyticsAttribute.USER_ID_ATTRIBUTE, "", "getLayoutId", "", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "initViewContext", "", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "rechargeHistoryAPI", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RechargeHistoryFragment extends BaseFragment {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private HistoryViewModel historyViewModel;
    private final String userId;

    private final void rechargeHistoryAPI() {
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
        return R.layout.fragment_recharge_history;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public RechargeHistoryFragment() {
        User user = LSApplication.Companion.getUser();
        this.userId = user != null ? user.getId() : null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public AnalyticsViewModel getViewModel() {
        return (AnalyticsViewModel) new ViewModelProvider(this).get(AnalyticsViewModel.class);
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initViewContext();
        rechargeHistoryAPI();
    }

    private final void initViewContext() {
        HistoryViewModel historyViewModel = (HistoryViewModel) new ViewModelProvider(this).get(HistoryViewModel.class);
        this.historyViewModel = historyViewModel;
        HistoryViewModel historyViewModel2 = null;
        if (historyViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historyViewModel");
            historyViewModel = null;
        }
        historyViewModel.historyRepository();
        HistoryViewModel historyViewModel3 = this.historyViewModel;
        if (historyViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historyViewModel");
        } else {
            historyViewModel2 = historyViewModel3;
        }
        historyViewModel2.getRechargeDetailsList().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.app.recharge.view.fragment.RechargeHistoryFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RechargeHistoryFragment.m455initViewContext$lambda0(RechargeHistoryFragment.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initViewContext$lambda-0  reason: not valid java name */
    public static final void m455initViewContext$lambda0(RechargeHistoryFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RechargeHistoryAdapter rechargeHistoryAdapter = new RechargeHistoryAdapter(this$0.requireActivity(), list);
        ListView listView = (ListView) this$0._$_findCachedViewById(R.id.rechargeHistoryListView);
        Intrinsics.checkNotNull(listView);
        listView.setAdapter((ListAdapter) rechargeHistoryAdapter);
    }
}

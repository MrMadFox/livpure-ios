package com.livpure.safedrink.serviceRequest.view;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentServiceRequestHistoryBinding;
import com.livpure.safedrink.serviceRequest.data.model.FreshdeskHistoryData;
import com.livpure.safedrink.serviceRequest.data.model.ServiceHistoryResponse;
import com.livpure.safedrink.serviceRequest.model.ServiceRequestHistoryModel;
import com.livpure.safedrink.serviceRequest.view.adapter.RaiseServiceHistoryAdapter;
import com.livpure.safedrink.utils.AnimProgressBar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* compiled from: ServiceRequestHistoryFragment.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\u001a\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/view/ServiceRequestHistoryFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentServiceRequestHistoryBinding;", "()V", "animProgressBar", "Lcom/livpure/safedrink/utils/AnimProgressBar;", "dataBinding", "fragmentServiceRequestHistoryBinding", "freshdeskHistoryResponse", "", "Lcom/livpure/safedrink/serviceRequest/data/model/FreshdeskHistoryData;", "navArgs", "Lcom/livpure/safedrink/serviceRequest/view/RaiseServiceRequestFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/serviceRequest/view/RaiseServiceRequestFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "serviceHistoryResponse", "Lcom/livpure/safedrink/serviceRequest/data/model/ServiceHistoryResponse;", "serviceRequestHistoryModel", "Lcom/livpure/safedrink/serviceRequest/model/ServiceRequestHistoryModel;", "getServiceRequestHistoryModel", "()Lcom/livpure/safedrink/serviceRequest/model/ServiceRequestHistoryModel;", "serviceRequestHistoryModel$delegate", "Lkotlin/Lazy;", "bindVariablesToView", "", "getLayoutId", "", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showHistoryData", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServiceRequestHistoryFragment extends DataBindingFragment<FragmentServiceRequestHistoryBinding> {
    private AnimProgressBar animProgressBar;
    private FragmentServiceRequestHistoryBinding dataBinding;
    private FragmentServiceRequestHistoryBinding fragmentServiceRequestHistoryBinding;
    private List<FreshdeskHistoryData> freshdeskHistoryResponse;
    private final NavArgsLazy navArgs$delegate;
    private List<ServiceHistoryResponse> serviceHistoryResponse;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy serviceRequestHistoryModel$delegate = LazyKt.lazy(new Function0<ServiceRequestHistoryModel>() { // from class: com.livpure.safedrink.serviceRequest.view.ServiceRequestHistoryFragment$serviceRequestHistoryModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ServiceRequestHistoryModel invoke() {
            return (ServiceRequestHistoryModel) new ViewModelProvider(ServiceRequestHistoryFragment.this).get(ServiceRequestHistoryModel.class);
        }
    });

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
        return R.layout.fragment_service_request_history;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public ServiceRequestHistoryFragment() {
        final ServiceRequestHistoryFragment serviceRequestHistoryFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(RaiseServiceRequestFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.serviceRequest.view.ServiceRequestHistoryFragment$special$$inlined$navArgs$1
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public AnalyticsViewModel getViewModel() {
        return (AnalyticsViewModel) new ViewModelProvider(this).get(AnalyticsViewModel.class);
    }

    private final RaiseServiceRequestFragmentArgs getNavArgs() {
        return (RaiseServiceRequestFragmentArgs) this.navArgs$delegate.getValue();
    }

    private final ServiceRequestHistoryModel getServiceRequestHistoryModel() {
        return (ServiceRequestHistoryModel) this.serviceRequestHistoryModel$delegate.getValue();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        showHistoryData();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentServiceRequestHistoryBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.dataBinding = dataBinding;
    }

    private final void showHistoryData() {
        getServiceRequestHistoryModel().updateServicerequesteee();
        getServiceRequestHistoryModel().getServiceHistoryResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.serviceRequest.view.ServiceRequestHistoryFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ServiceRequestHistoryFragment.m1263showHistoryData$lambda0(ServiceRequestHistoryFragment.this, (List) obj);
            }
        });
        getServiceRequestHistoryModel().getFreshdeskHistoryData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.serviceRequest.view.ServiceRequestHistoryFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ServiceRequestHistoryFragment.m1264showHistoryData$lambda1(ServiceRequestHistoryFragment.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showHistoryData$lambda-0  reason: not valid java name */
    public static final void m1263showHistoryData$lambda0(ServiceRequestHistoryFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            this$0.serviceHistoryResponse = list;
        } else {
            this$0.serviceHistoryResponse = CollectionsKt.listOf(new ServiceHistoryResponse("", "", "", "", "", "", ""));
        }
        this$0.getServiceRequestHistoryModel().freshdeskHistoryResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showHistoryData$lambda-1  reason: not valid java name */
    public static final void m1264showHistoryData$lambda1(ServiceRequestHistoryFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list != null) {
            this$0.freshdeskHistoryResponse = list;
        } else {
            this$0.freshdeskHistoryResponse = CollectionsKt.listOf(new FreshdeskHistoryData(0, "", "", "", 0, "", "", ""));
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this$0.getMContext(), 1, false);
        FragmentServiceRequestHistoryBinding fragmentServiceRequestHistoryBinding = this$0.dataBinding;
        RecyclerView recyclerView = fragmentServiceRequestHistoryBinding != null ? fragmentServiceRequestHistoryBinding.listHistory : null;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        FragmentActivity mContext = this$0.getMContext();
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        List<FreshdeskHistoryData> list2 = this$0.freshdeskHistoryResponse;
        Intrinsics.checkNotNull(list2);
        List<ServiceHistoryResponse> list3 = this$0.serviceHistoryResponse;
        Intrinsics.checkNotNull(list3);
        RaiseServiceHistoryAdapter raiseServiceHistoryAdapter = new RaiseServiceHistoryAdapter(mContext, list2, list3, 0);
        FragmentServiceRequestHistoryBinding fragmentServiceRequestHistoryBinding2 = this$0.dataBinding;
        RecyclerView recyclerView2 = fragmentServiceRequestHistoryBinding2 != null ? fragmentServiceRequestHistoryBinding2.listHistory : null;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setAdapter(raiseServiceHistoryAdapter);
    }
}

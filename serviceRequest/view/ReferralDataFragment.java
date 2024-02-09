package com.livpure.safedrink.serviceRequest.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentReferralDataBinding;
import com.livpure.safedrink.interfaces.ItemClickListener;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.serviceRequest.data.model.GetReferralList;
import com.livpure.safedrink.serviceRequest.data.model.GetReferralResponse;
import com.livpure.safedrink.serviceRequest.data.model.ResendVoucherResponse;
import com.livpure.safedrink.serviceRequest.model.ReferralDataModel;
import com.livpure.safedrink.serviceRequest.view.adapter.ReferralDataAdapter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReferralDataFragment.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u001a\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/view/ReferralDataFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentReferralDataBinding;", "Lcom/livpure/safedrink/interfaces/ItemClickListener;", "()V", "dataBinding", "referralDataModel", "Lcom/livpure/safedrink/serviceRequest/model/ReferralDataModel;", "getReferralDataModel", "()Lcom/livpure/safedrink/serviceRequest/model/ReferralDataModel;", "referralDataModel$delegate", "Lkotlin/Lazy;", "referralDataResponse", "", "Lcom/livpure/safedrink/serviceRequest/data/model/GetReferralList;", "bindVariablesToView", "", "getLayoutId", "", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "onItemClick", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "position", "onViewCreated", "savedInstanceState", "Landroid/os/Bundle;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferralDataFragment extends DataBindingFragment<FragmentReferralDataBinding> implements ItemClickListener {
    private FragmentReferralDataBinding dataBinding;
    private List<GetReferralList> referralDataResponse;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy referralDataModel$delegate = LazyKt.lazy(new Function0<ReferralDataModel>() { // from class: com.livpure.safedrink.serviceRequest.view.ReferralDataFragment$referralDataModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ReferralDataModel invoke() {
            return (ReferralDataModel) new ViewModelProvider(ReferralDataFragment.this).get(ReferralDataModel.class);
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
        return R.layout.fragment_referral_data;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public AnalyticsViewModel getViewModel() {
        return (AnalyticsViewModel) new ViewModelProvider(this).get(AnalyticsViewModel.class);
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentReferralDataBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.dataBinding = dataBinding;
        dataBinding.setViewModel(getReferralDataModel());
    }

    private final ReferralDataModel getReferralDataModel() {
        return (ReferralDataModel) this.referralDataModel$delegate.getValue();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ReferralDataModel referralDataModel = getReferralDataModel();
        User user = LSApplication.Companion.getUser();
        referralDataModel.getReferralData(user != null ? user.getMobile() : null);
        getReferralDataModel().getReferralResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.serviceRequest.view.ReferralDataFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReferralDataFragment.m1248onViewCreated$lambda0(ReferralDataFragment.this, (GetReferralResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m1248onViewCreated$lambda0(ReferralDataFragment this$0, GetReferralResponse getReferralResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (getReferralResponse.getMessage() != null) {
            List<GetReferralList> getReferralList = getReferralResponse.getGetReferralList();
            if (getReferralList != null && getReferralList.isEmpty()) {
                Toast.makeText(this$0.getActivity(), this$0.getString(R.string.referrals_not_found), 0).show();
                return;
            }
            this$0.referralDataResponse = getReferralResponse.getGetReferralList();
            ((RecyclerView) this$0._$_findCachedViewById(R.id.referralData)).setLayoutManager(new LinearLayoutManager(this$0.getMContext(), 1, false));
            FragmentActivity mContext = this$0.getMContext();
            Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
            List<GetReferralList> list = this$0.referralDataResponse;
            Intrinsics.checkNotNull(list);
            ReferralDataAdapter referralDataAdapter = new ReferralDataAdapter(mContext, list, 0, 4, null);
            ((RecyclerView) this$0._$_findCachedViewById(R.id.referralData)).setAdapter(referralDataAdapter);
            referralDataAdapter.setOnItemClickListener(this$0);
            return;
        }
        Toast.makeText(this$0.getActivity(), "Something went wrong, please try again", 0).show();
    }

    @Override // com.livpure.safedrink.interfaces.ItemClickListener
    public void onItemClick(View view, int i) {
        GetReferralList getReferralList;
        ReferralDataModel referralDataModel = getReferralDataModel();
        List<GetReferralList> list = this.referralDataResponse;
        referralDataModel.resendVoucher((list == null || (getReferralList = list.get(i)) == null) ? null : getReferralList.getId());
        getReferralDataModel().getResendVoucherResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.serviceRequest.view.ReferralDataFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReferralDataFragment.m1247onItemClick$lambda1(ReferralDataFragment.this, (ResendVoucherResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onItemClick$lambda-1  reason: not valid java name */
    public static final void m1247onItemClick$lambda1(ReferralDataFragment this$0, ResendVoucherResponse resendVoucherResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(resendVoucherResponse.getMessage(), "false")) {
            Toast.makeText(this$0.getActivity(), resendVoucherResponse.getMsg(), 0).show();
            FragmentKt.findNavController(this$0).popBackStack(R.id.raiseServiceRequest, false);
        }
    }
}

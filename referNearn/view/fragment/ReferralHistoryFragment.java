package com.livpure.safedrink.referNearn.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.koushikdutta.async.http.body.StringBody;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentReferralHistoryBinding;
import com.livpure.safedrink.interfaces.ItemClickListener;
import com.livpure.safedrink.login.api.models.response.ReferralLinkResponse;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.referNearn.model.ReferralHistoryResponse;
import com.livpure.safedrink.referNearn.view.adapter.ReferralHistoryAdapter;
import com.livpure.safedrink.referNearn.viewmodels.ReferAndEarnViewModel;
import com.livpure.safedrink.utils.PermissionsRequest;
import com.livpure.safedrink.utils.Util;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReferralHistoryFragment.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0014J\b\u0010\u001c\u001a\u00020\u0017H\u0014J\u001a\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0019H\u0016J\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#J\u001a\u0010$\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0017R\u000e\u0010\u0005\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lcom/livpure/safedrink/referNearn/view/fragment/ReferralHistoryFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentReferralHistoryBinding;", "Lcom/livpure/safedrink/interfaces/ItemClickListener;", "()V", "fragmentReferralHistoryBinding", "referAndEarnModel", "Lcom/livpure/safedrink/referNearn/viewmodels/ReferAndEarnViewModel;", "getReferAndEarnModel", "()Lcom/livpure/safedrink/referNearn/viewmodels/ReferAndEarnViewModel;", "referAndEarnModel$delegate", "Lkotlin/Lazy;", "referralHistoryItem", "", "Lcom/livpure/safedrink/referNearn/model/ReferralHistoryResponse;", "getReferralHistoryItem", "()Ljava/util/List;", "setReferralHistoryItem", "(Ljava/util/List;)V", "bindVariablesToView", "", "dataBinding", "checkPermissions", "", "getLayoutId", "", "getReferralLink", "getViewModel", "isToolbarVisible", "onItemClick", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "position", "onShareReferralCodeClick", "referralLink", "", "onViewCreated", "savedInstanceState", "Landroid/os/Bundle;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferralHistoryFragment extends DataBindingFragment<FragmentReferralHistoryBinding> implements ItemClickListener {
    private FragmentReferralHistoryBinding fragmentReferralHistoryBinding;
    public List<ReferralHistoryResponse> referralHistoryItem;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy referAndEarnModel$delegate = LazyKt.lazy(new Function0<ReferAndEarnViewModel>() { // from class: com.livpure.safedrink.referNearn.view.fragment.ReferralHistoryFragment$referAndEarnModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ReferAndEarnViewModel invoke() {
            return (ReferAndEarnViewModel) new ViewModelProvider(ReferralHistoryFragment.this).get(ReferAndEarnViewModel.class);
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
        return R.layout.fragment_referral_history;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    protected boolean isToolbarVisible() {
        return true;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    private final ReferAndEarnViewModel getReferAndEarnModel() {
        return (ReferAndEarnViewModel) this.referAndEarnModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public ReferAndEarnViewModel getViewModel() {
        return getReferAndEarnModel();
    }

    public final List<ReferralHistoryResponse> getReferralHistoryItem() {
        List<ReferralHistoryResponse> list = this.referralHistoryItem;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("referralHistoryItem");
        return null;
    }

    public final void setReferralHistoryItem(List<ReferralHistoryResponse> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.referralHistoryItem = list;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentReferralHistoryBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.fragmentReferralHistoryBinding = dataBinding;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        getReferAndEarnModel().getReferralHistory();
        getReferAndEarnModel().getLeadershipBoard();
        FragmentReferralHistoryBinding fragmentReferralHistoryBinding = this.fragmentReferralHistoryBinding;
        if (fragmentReferralHistoryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentReferralHistoryBinding");
            fragmentReferralHistoryBinding = null;
        }
        fragmentReferralHistoryBinding.setUserData(getReferAndEarnModel());
        getReferAndEarnModel().getReferalHistoryList().observe(this, new Observer() { // from class: com.livpure.safedrink.referNearn.view.fragment.ReferralHistoryFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReferralHistoryFragment.m1123onViewCreated$lambda1(ReferralHistoryFragment.this, (List) obj);
            }
        });
        ((Button) _$_findCachedViewById(R.id.inviteNowButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.referNearn.view.fragment.ReferralHistoryFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReferralHistoryFragment.m1124onViewCreated$lambda2(ReferralHistoryFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m1123onViewCreated$lambda1(ReferralHistoryFragment this$0, List history) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(history, "history");
        this$0.setReferralHistoryItem(history);
        ((RecyclerView) this$0._$_findCachedViewById(R.id.listReferralHistoryId)).setLayoutManager(new LinearLayoutManager(this$0.getContext()));
        Context context = this$0.getContext();
        ReferralHistoryAdapter referralHistoryAdapter = context != null ? new ReferralHistoryAdapter(context, history) : null;
        ((RecyclerView) this$0._$_findCachedViewById(R.id.listReferralHistoryId)).setAdapter(referralHistoryAdapter);
        if (referralHistoryAdapter != null) {
            referralHistoryAdapter.setOnItemClickListener(this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m1124onViewCreated$lambda2(ReferralHistoryFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (LSApplication.Companion.getReferralLink() != null && !Intrinsics.areEqual(LSApplication.Companion.getReferralLink(), "")) {
            String referralLink = LSApplication.Companion.getReferralLink();
            Intrinsics.checkNotNull(referralLink);
            this$0.onShareReferralCodeClick(referralLink);
            return;
        }
        this$0.getReferralLink();
    }

    private final void getReferralLink() {
        if (LSApplication.Companion.isNetworkAvailable()) {
            ReferAndEarnViewModel referAndEarnModel = getReferAndEarnModel();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            referAndEarnModel.getReferralLink(requireActivity).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.referNearn.view.fragment.ReferralHistoryFragment$$ExternalSyntheticLambda1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReferralHistoryFragment.m1122getReferralLink$lambda3(ReferralHistoryFragment.this, (ReferralLinkResponse) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getReferralLink$lambda-3  reason: not valid java name */
    public static final void m1122getReferralLink$lambda3(ReferralHistoryFragment this$0, ReferralLinkResponse referralLinkResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (LSApplication.Companion.getReferralLink() == null || Intrinsics.areEqual(LSApplication.Companion.getReferralLink(), "")) {
            return;
        }
        String referralLink = LSApplication.Companion.getReferralLink();
        Intrinsics.checkNotNull(referralLink);
        this$0.onShareReferralCodeClick(referralLink);
    }

    public final void onShareReferralCodeClick(String referralLink) {
        Intrinsics.checkNotNullParameter(referralLink, "referralLink");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        StringBuilder sb = new StringBuilder();
        sb.append("Refer & Earn\nGet instant ₹100 discount. Subscribe to Livpure Smart RO today.\nApply my code ");
        User value = getReferAndEarnModel().getUser().getValue();
        sb.append(value != null ? value.getReferralCode() : null);
        sb.append(" now and subscribe to pure drinking water at home.\nClick here to know more :- \n");
        sb.append(referralLink);
        intent.putExtra("android.intent.extra.TEXT", sb.toString());
        intent.setType(StringBody.CONTENT_TYPE);
        startActivity(Intent.createChooser(intent, null));
    }

    @Override // com.livpure.safedrink.interfaces.ItemClickListener
    public void onItemClick(View view, int i) {
        ReferralHistoryResponse referralHistoryResponse = getReferralHistoryItem().get(i);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.imgWhatsappId) {
            Context context = getContext();
            Boolean valueOf2 = context != null ? Boolean.valueOf(Util.isAppInstalledOrNot(context, "com.whatsapp")) : null;
            Intrinsics.checkNotNull(valueOf2);
            if (valueOf2.booleanValue()) {
                String str = "https://api.whatsapp.com/send?phone=+91" + referralHistoryResponse.getUserPhone();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                startActivity(intent);
                return;
            }
            Toast.makeText(getActivity(), "Please Install Whatsapp to Chat with us !!", 0).show();
        } else if (valueOf != null && valueOf.intValue() == R.id.imgCallId && checkPermissions()) {
            Intent intent2 = new Intent("android.intent.action.CALL");
            intent2.setData(Uri.parse("tel:+91" + referralHistoryResponse.getUserPhone()));
            startActivity(intent2);
        }
    }

    private final boolean checkPermissions() {
        Context context = getContext();
        if (context != null && ContextCompat.checkSelfPermission(context, PermissionsRequest.INSTANCE.getCallPermission()) == 0) {
            return true;
        }
        ActivityCompat.requestPermissions(requireActivity(), new String[]{PermissionsRequest.INSTANCE.getCallPermission()}, 100);
        return false;
    }
}

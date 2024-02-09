package com.livpure.safedrink.subscription.cancelsubscription.view;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.FragmentKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.common.arc.ui.views.BaseFragment;
import com.livpure.safedrink.common.arc.ui.views.NoFilterArrayAdapter;
import com.livpure.safedrink.subscription.cancelsubscription.viewmodel.CancelSubsciptionConfirmationModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CancelSubsciptionConfirmationFragment.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u000f\u001a\u00020\rJ\u001a\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0017R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/livpure/safedrink/subscription/cancelsubscription/view/CancelSubsciptionConfirmationFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/BaseFragment;", "()V", "cancelSubsciptionConfirmationModel", "Lcom/livpure/safedrink/subscription/cancelsubscription/viewmodel/CancelSubsciptionConfirmationModel;", "getCancelSubsciptionConfirmationModel", "()Lcom/livpure/safedrink/subscription/cancelsubscription/viewmodel/CancelSubsciptionConfirmationModel;", "cancelSubsciptionConfirmationModel$delegate", "Lkotlin/Lazy;", "getLayoutId", "", "getViewModel", "goBack", "", "initializeViews", "onSubmitButtonClick", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CancelSubsciptionConfirmationFragment extends BaseFragment {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy cancelSubsciptionConfirmationModel$delegate = LazyKt.lazy(new Function0<CancelSubsciptionConfirmationModel>() { // from class: com.livpure.safedrink.subscription.cancelsubscription.view.CancelSubsciptionConfirmationFragment$cancelSubsciptionConfirmationModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CancelSubsciptionConfirmationModel invoke() {
            return (CancelSubsciptionConfirmationModel) new ViewModelProvider(CancelSubsciptionConfirmationFragment.this).get(CancelSubsciptionConfirmationModel.class);
        }
    });

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
        return R.layout.fragment_confirm_cancel_subscription;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    private final CancelSubsciptionConfirmationModel getCancelSubsciptionConfirmationModel() {
        return (CancelSubsciptionConfirmationModel) this.cancelSubsciptionConfirmationModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public CancelSubsciptionConfirmationModel getViewModel() {
        return getCancelSubsciptionConfirmationModel();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initializeViews();
    }

    private final void goBack() {
        FragmentKt.findNavController(this).popBackStack();
    }

    private final void initializeViews() {
        Spinner spinner = (Spinner) _$_findCachedViewById(R.id.cancelReason);
        if (spinner != null) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            spinner.setAdapter((SpinnerAdapter) new NoFilterArrayAdapter(requireActivity, 17367043, getCancelSubsciptionConfirmationModel().getListOfCancelReason()));
        }
        ((LinearLayout) _$_findCachedViewById(R.id.submitButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.cancelsubscription.view.CancelSubsciptionConfirmationFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CancelSubsciptionConfirmationFragment.m1283initializeViews$lambda1(CancelSubsciptionConfirmationFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initializeViews$lambda-1  reason: not valid java name */
    public static final void m1283initializeViews$lambda1(CancelSubsciptionConfirmationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onSubmitButtonClick();
    }

    public final void onSubmitButtonClick() {
        LiveData<Boolean> updateCancellationStatus;
        if (Intrinsics.areEqual(((Spinner) _$_findCachedViewById(R.id.cancelReason)).getSelectedItem().toString(), "Select Reason") || (updateCancellationStatus = getCancelSubsciptionConfirmationModel().updateCancellationStatus(((Spinner) _$_findCachedViewById(R.id.cancelReason)).getSelectedItem().toString())) == null) {
            return;
        }
        updateCancellationStatus.observe(this, new Observer() { // from class: com.livpure.safedrink.subscription.cancelsubscription.view.CancelSubsciptionConfirmationFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CancelSubsciptionConfirmationFragment.m1284onSubmitButtonClick$lambda2(CancelSubsciptionConfirmationFragment.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSubmitButtonClick$lambda-2  reason: not valid java name */
    public static final void m1284onSubmitButtonClick$lambda2(CancelSubsciptionConfirmationFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAdded()) {
            FragmentKt.findNavController(this$0).popBackStack(R.id.homeFragment, false);
        }
    }
}

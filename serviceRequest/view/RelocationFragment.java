package com.livpure.safedrink.serviceRequest.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.UiUtilKt;
import com.livpure.safedrink.common.arc.Event;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.common.arc.ui.views.NoFilterArrayAdapter;
import com.livpure.safedrink.databinding.FragmentRelocationAddressBinding;
import com.livpure.safedrink.login.api.models.response.BaseV1Response;
import com.livpure.safedrink.serviceRequest.data.model.NewPlanList;
import com.livpure.safedrink.serviceRequest.data.model.NewPlanResponse;
import com.livpure.safedrink.serviceRequest.model.RelocationModel;
import com.livpure.safedrink.serviceRequest.view.adapter.NewPlanAdapter;
import com.livpure.safedrink.utils.AnimProgressBar;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RelocationFragment.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0014J\u001a\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0018\u0010#\u001a\u00020\u00152\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0012H\u0002J\u0016\u0010%\u001a\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190'H\u0002J\b\u0010(\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/view/RelocationFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentRelocationAddressBinding;", "()V", "animProgressBar", "Lcom/livpure/safedrink/utils/AnimProgressBar;", "isShowDialog", "", "()Z", "setShowDialog", "(Z)V", "relocationModel", "Lcom/livpure/safedrink/serviceRequest/model/RelocationModel;", "getRelocationModel", "()Lcom/livpure/safedrink/serviceRequest/model/RelocationModel;", "relocationModel$delegate", "Lkotlin/Lazy;", "showPlanList", "", "Lcom/livpure/safedrink/serviceRequest/data/model/NewPlanList;", "bindVariablesToView", "", "dataBinding", "displayDialog", "job_Description", "", "getLayoutId", "", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "populateAreaSpinner", "areas", "populatePickupSpinner", "pickupList", "", "showNewPlanApi", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RelocationFragment extends DataBindingFragment<FragmentRelocationAddressBinding> {
    private AnimProgressBar animProgressBar;
    private boolean isShowDialog;
    private List<NewPlanList> showPlanList;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy relocationModel$delegate = LazyKt.lazy(new Function0<RelocationModel>() { // from class: com.livpure.safedrink.serviceRequest.view.RelocationFragment$relocationModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RelocationModel invoke() {
            return (RelocationModel) new ViewModelProvider(RelocationFragment.this).get(RelocationModel.class);
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
        return R.layout.fragment_relocation_address;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final boolean isShowDialog() {
        return this.isShowDialog;
    }

    public final void setShowDialog(boolean z) {
        this.isShowDialog = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public AnalyticsViewModel getViewModel() {
        return (AnalyticsViewModel) new ViewModelProvider(this).get(AnalyticsViewModel.class);
    }

    private final RelocationModel getRelocationModel() {
        return (RelocationModel) this.relocationModel$delegate.getValue();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.animProgressBar = new AnimProgressBar(requireContext());
        getRelocationModel().populateAreasWhenAvailable().observe(requireActivity(), new Observer() { // from class: com.livpure.safedrink.serviceRequest.view.RelocationFragment$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RelocationFragment.m1253onViewCreated$lambda0(RelocationFragment.this, (List) obj);
            }
        });
        getRelocationModel().getToastObserver().observe(requireActivity(), new Observer() { // from class: com.livpure.safedrink.serviceRequest.view.RelocationFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RelocationFragment.m1254onViewCreated$lambda1(RelocationFragment.this, (Event) obj);
            }
        });
        ArrayList arrayList = new ArrayList();
        String string = getString(R.string.self_pick_up);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.self_pick_up)");
        arrayList.add(string);
        String string2 = getString(R.string.company_pick_up);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.company_pick_up)");
        arrayList.add(string2);
        populatePickupSpinner(arrayList);
        ((Button) _$_findCachedViewById(R.id.btnSubmit)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RelocationFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RelocationFragment.m1255onViewCreated$lambda3(RelocationFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m1253onViewCreated$lambda0(RelocationFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.populateAreaSpinner(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m1254onViewCreated$lambda1(RelocationFragment this$0, Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.requireContext(), (CharSequence) event.peekContent(), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m1255onViewCreated$lambda3(final RelocationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getRelocationModel().isFormValidated()) {
            AnimProgressBar animProgressBar = this$0.animProgressBar;
            if (animProgressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                animProgressBar = null;
            }
            animProgressBar.show();
            this$0.getRelocationModel().updateAddress();
            this$0.getRelocationModel().getUpdateAddress().observe(this$0.getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.serviceRequest.view.RelocationFragment$$ExternalSyntheticLambda6
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RelocationFragment.m1256onViewCreated$lambda3$lambda2(RelocationFragment.this, (BaseV1Response) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3$lambda-2  reason: not valid java name */
    public static final void m1256onViewCreated$lambda3$lambda2(RelocationFragment this$0, BaseV1Response baseV1Response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnimProgressBar animProgressBar = this$0.animProgressBar;
        if (animProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            animProgressBar = null;
        }
        animProgressBar.dismiss();
        if (baseV1Response.getStatus() != null) {
            Boolean status = baseV1Response.getStatus();
            Intrinsics.checkNotNull(status);
            if (status.booleanValue()) {
                String message = baseV1Response.getMessage();
                Intrinsics.checkNotNull(message);
                this$0.displayDialog(message);
                return;
            }
            Toast.makeText(this$0.getActivity(), this$0.getString(R.string.sorry_try_again), 0).show();
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentRelocationAddressBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        dataBinding.setViewModel(getRelocationModel());
        dataBinding.setUser(LSApplication.Companion.getUser());
    }

    private final void populateAreaSpinner(List<String> list) {
        if (list != null) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) _$_findCachedViewById(R.id.areaAutoCompleteTextViewRelocation);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            autoCompleteTextView.setAdapter(new NoFilterArrayAdapter(requireActivity, 17367043, list));
            autoCompleteTextView.setShowSoftInputOnFocus(false);
            autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.livpure.safedrink.serviceRequest.view.RelocationFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    RelocationFragment.m1257populateAreaSpinner$lambda6$lambda5$lambda4(RelocationFragment.this, view, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: populateAreaSpinner$lambda-6$lambda-5$lambda-4  reason: not valid java name */
    public static final void m1257populateAreaSpinner$lambda6$lambda5$lambda4(RelocationFragment this$0, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z && this$0.isAdded()) {
            UiUtilKt.hideKeyboard(this$0.requireActivity());
        }
    }

    private final void showNewPlanApi() {
        getRelocationModel().showNewPlan().observe(this, new Observer() { // from class: com.livpure.safedrink.serviceRequest.view.RelocationFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RelocationFragment.m1259showNewPlanApi$lambda10(RelocationFragment.this, (NewPlanResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showNewPlanApi$lambda-10  reason: not valid java name */
    public static final void m1259showNewPlanApi$lambda10(final RelocationFragment this$0, NewPlanResponse newPlanResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isShowDialog) {
            return;
        }
        if (newPlanResponse != null && newPlanResponse.getStatus() == 200) {
            List<NewPlanList> plan = newPlanResponse.getPlan();
            if (plan != null && (plan.isEmpty() ^ true)) {
                List<NewPlanList> plan2 = newPlanResponse.getPlan();
                this$0.showPlanList = plan2;
                List<NewPlanList> list = null;
                if (plan2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("showPlanList");
                    plan2 = null;
                }
                if (!plan2.isEmpty()) {
                    final Dialog dialog = new Dialog(this$0.requireContext());
                    dialog.requestWindowFeature(1);
                    dialog.setContentView(R.layout.dialog_new_city_price);
                    Window window = dialog.getWindow();
                    Intrinsics.checkNotNull(window);
                    window.setLayout(-1, -2);
                    Window window2 = dialog.getWindow();
                    Intrinsics.checkNotNull(window2);
                    window2.setBackgroundDrawable(new ColorDrawable(0));
                    Button button = (Button) dialog.findViewById(R.id.btnAgree);
                    RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.listPlanValidityId);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this$0.getMContext(), 0, false));
                    FragmentActivity mContext = this$0.getMContext();
                    Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
                    FragmentActivity fragmentActivity = mContext;
                    List<NewPlanList> list2 = this$0.showPlanList;
                    if (list2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("showPlanList");
                    } else {
                        list = list2;
                    }
                    recyclerView.setAdapter(new NewPlanAdapter(fragmentActivity, CollectionsKt.sortedWith(list, new Comparator() { // from class: com.livpure.safedrink.serviceRequest.view.RelocationFragment$showNewPlanApi$lambda-10$$inlined$sortedByDescending$1
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Integer.valueOf(Integer.parseInt(((NewPlanList) t2).getDuration())), Integer.valueOf(Integer.parseInt(((NewPlanList) t).getDuration())));
                        }
                    })));
                    dialog.show();
                    this$0.isShowDialog = true;
                    dialog.setCancelable(false);
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RelocationFragment$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            RelocationFragment.m1260showNewPlanApi$lambda10$lambda9(dialog, this$0, view);
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        Toast.makeText(this$0.getActivity(), this$0.getString(R.string.sorry_try_again), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showNewPlanApi$lambda-10$lambda-9  reason: not valid java name */
    public static final void m1260showNewPlanApi$lambda10$lambda9(Dialog dialoglog, final RelocationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(dialoglog, "$dialoglog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialoglog.dismiss();
        this$0.getRelocationModel().updateAddress();
        this$0.getRelocationModel().getUpdateAddress().observe(this$0.getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.serviceRequest.view.RelocationFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RelocationFragment.m1261showNewPlanApi$lambda10$lambda9$lambda8(RelocationFragment.this, (BaseV1Response) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showNewPlanApi$lambda-10$lambda-9$lambda-8  reason: not valid java name */
    public static final void m1261showNewPlanApi$lambda10$lambda9$lambda8(RelocationFragment this$0, BaseV1Response baseV1Response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (baseV1Response.getStatus() != null) {
            Boolean status = baseV1Response.getStatus();
            Intrinsics.checkNotNull(status);
            if (status.booleanValue()) {
                if (this$0.isShowDialog) {
                    String message = baseV1Response.getMessage();
                    Intrinsics.checkNotNull(message);
                    this$0.displayDialog(message);
                    return;
                }
                return;
            }
            Toast.makeText(this$0.getActivity(), this$0.getString(R.string.sorry_try_again), 0).show();
        }
    }

    private final void displayDialog(String str) {
        Context context = getContext();
        final Dialog dialog = context != null ? new Dialog(context) : null;
        if (dialog != null) {
            dialog.requestWindowFeature(1);
        }
        if (dialog != null) {
            dialog.setContentView(R.layout.dialog_relocate_successfully);
        }
        Window window = dialog != null ? dialog.getWindow() : null;
        Intrinsics.checkNotNull(window);
        window.setLayout(-1, -2);
        Window window2 = dialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) dialog.findViewById(R.id.jobDescription)).setText(str);
        ((TextView) dialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.RelocationFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RelocationFragment.m1252displayDialog$lambda12(dialog, this, view);
            }
        });
        dialog.show();
        this.isShowDialog = false;
        dialog.setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: displayDialog$lambda-12  reason: not valid java name */
    public static final void m1252displayDialog$lambda12(Dialog dialog, RelocationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        if (this$0.isAdded()) {
            NavDirections actionUpdateAddressToKycUpload = RelocationFragmentDirections.actionUpdateAddressToKycUpload();
            Intrinsics.checkNotNullExpressionValue(actionUpdateAddressToKycUpload, "actionUpdateAddressToKycUpload()");
            FragmentKt.findNavController(this$0).navigate(actionUpdateAddressToKycUpload);
        }
    }

    private final void populatePickupSpinner(List<String> list) {
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) _$_findCachedViewById(R.id.pickupAutoCompleteTextView);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        autoCompleteTextView.setAdapter(new NoFilterArrayAdapter(requireActivity, 17367043, list));
        autoCompleteTextView.setShowSoftInputOnFocus(false);
        autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.livpure.safedrink.serviceRequest.view.RelocationFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                RelocationFragment.m1258populatePickupSpinner$lambda15$lambda14$lambda13(RelocationFragment.this, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: populatePickupSpinner$lambda-15$lambda-14$lambda-13  reason: not valid java name */
    public static final void m1258populatePickupSpinner$lambda15$lambda14$lambda13(RelocationFragment this$0, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z && this$0.isAdded()) {
            UiUtilKt.hideKeyboard(this$0.requireActivity());
        }
    }
}

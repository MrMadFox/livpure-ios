package com.livpure.safedrink.subscription.address.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.FragmentKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.UiUtilKt;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.common.arc.ui.views.NoFilterArrayAdapter;
import com.livpure.safedrink.databinding.FragmentInstallationAddressBinding;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.subscription.address.viewmodel.InstallationAddressViewModel;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: InstallationAddressFragment.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0005H\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u000b2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0002J\u0018\u0010\u001e\u001a\u00020\u000b2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006 "}, d2 = {"Lcom/livpure/safedrink/subscription/address/view/InstallationAddressFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentInstallationAddressBinding;", "()V", "addressViewModel", "Lcom/livpure/safedrink/subscription/address/viewmodel/InstallationAddressViewModel;", "getAddressViewModel", "()Lcom/livpure/safedrink/subscription/address/viewmodel/InstallationAddressViewModel;", "addressViewModel$delegate", "Lkotlin/Lazy;", "bindVariablesToView", "", "dataBinding", "getLayoutId", "", "getViewModel", "goBack", "goBackToSelectPlan", "handleBackNavigation", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "populateAreaSpinner", "areas", "", "", "populateCitySpinner", "cities", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstallationAddressFragment extends DataBindingFragment<FragmentInstallationAddressBinding> {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy addressViewModel$delegate = LazyKt.lazy(new Function0<InstallationAddressViewModel>() { // from class: com.livpure.safedrink.subscription.address.view.InstallationAddressFragment$addressViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InstallationAddressViewModel invoke() {
            return (InstallationAddressViewModel) new ViewModelProvider(InstallationAddressFragment.this).get(InstallationAddressViewModel.class);
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
        return R.layout.fragment_installation_address;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    private final InstallationAddressViewModel getAddressViewModel() {
        return (InstallationAddressViewModel) this.addressViewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public InstallationAddressViewModel getViewModel() {
        return getAddressViewModel();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentInstallationAddressBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        dataBinding.setViewModel(getAddressViewModel());
        dataBinding.setUser(LSApplication.Companion.getUser());
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        InstallationAddressFragment installationAddressFragment = this;
        getAddressViewModel().populateCitiesWhenAvailable().observe(installationAddressFragment, new Observer() { // from class: com.livpure.safedrink.subscription.address.view.InstallationAddressFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                InstallationAddressFragment.m1270onViewCreated$lambda0(InstallationAddressFragment.this, (List) obj);
            }
        });
        getAddressViewModel().populateAreasWhenAvailable().observe(installationAddressFragment, new Observer() { // from class: com.livpure.safedrink.subscription.address.view.InstallationAddressFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                InstallationAddressFragment.m1271onViewCreated$lambda1(InstallationAddressFragment.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m1270onViewCreated$lambda0(InstallationAddressFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.populateCitySpinner(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m1271onViewCreated$lambda1(InstallationAddressFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.populateAreaSpinner(list);
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    private final void handleBackNavigation() {
        User user = LSApplication.Companion.getUser();
        String address = user != null ? user.getAddress() : null;
        if (address == null || StringsKt.isBlank(address)) {
            goBackToSelectPlan();
        } else {
            goBack();
        }
    }

    private final void populateCitySpinner(List<String> list) {
        List mutableList;
        List<String> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            mutableList = CollectionsKt.mutableListOf("No cities found");
        } else {
            mutableList = CollectionsKt.toMutableList((Collection) list2);
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) _$_findCachedViewById(R.id.cityAutoCompleteTextView);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        autoCompleteTextView.setAdapter(new NoFilterArrayAdapter(requireActivity, 17367043, mutableList));
        autoCompleteTextView.setShowSoftInputOnFocus(false);
        autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.livpure.safedrink.subscription.address.view.InstallationAddressFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                InstallationAddressFragment.m1273populateCitySpinner$lambda3$lambda2(InstallationAddressFragment.this, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: populateCitySpinner$lambda-3$lambda-2  reason: not valid java name */
    public static final void m1273populateCitySpinner$lambda3$lambda2(InstallationAddressFragment this$0, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z && this$0.isAdded()) {
            UiUtilKt.hideKeyboard(this$0.requireActivity());
        }
    }

    private final void populateAreaSpinner(List<String> list) {
        if (list != null) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) _$_findCachedViewById(R.id.areaAutoCompleteTextView);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            autoCompleteTextView.setAdapter(new NoFilterArrayAdapter(requireActivity, 17367043, list));
            autoCompleteTextView.setShowSoftInputOnFocus(false);
            autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.livpure.safedrink.subscription.address.view.InstallationAddressFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    InstallationAddressFragment.m1272populateAreaSpinner$lambda6$lambda5$lambda4(InstallationAddressFragment.this, view, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: populateAreaSpinner$lambda-6$lambda-5$lambda-4  reason: not valid java name */
    public static final void m1272populateAreaSpinner$lambda6$lambda5$lambda4(InstallationAddressFragment this$0, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z && this$0.isAdded()) {
            UiUtilKt.hideKeyboard(this$0.requireActivity());
        }
    }

    private final void goBack() {
        FragmentKt.findNavController(this).popBackStack();
    }

    private final void goBackToSelectPlan() {
        FragmentKt.findNavController(this).popBackStack(R.id.selectPlanOrRechargeFragment, false);
    }
}

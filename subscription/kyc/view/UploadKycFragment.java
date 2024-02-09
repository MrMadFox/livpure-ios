package com.livpure.safedrink.subscription.kyc.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.NavGraphDirections;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.app.MainViewModel;
import com.livpure.safedrink.common.FileUtilKt;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.common.arc.ui.views.SpinnerWithHintAdapter;
import com.livpure.safedrink.databinding.FragmentUploadKycBinding;
import com.livpure.safedrink.subscription.kyc.viewmodel.UploadKYCViewModel;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* compiled from: UploadKycFragment.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0005H\u0014J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u0012\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\u001a\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0019H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/livpure/safedrink/subscription/kyc/view/UploadKycFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentUploadKycBinding;", "()V", "kycViewModel", "Lcom/livpure/safedrink/subscription/kyc/viewmodel/UploadKYCViewModel;", "getKycViewModel", "()Lcom/livpure/safedrink/subscription/kyc/viewmodel/UploadKYCViewModel;", "kycViewModel$delegate", "Lkotlin/Lazy;", "mainViewModel", "Lcom/livpure/safedrink/app/MainViewModel;", "getMainViewModel", "()Lcom/livpure/safedrink/app/MainViewModel;", "mainViewModel$delegate", "navArgs", "Lcom/livpure/safedrink/subscription/kyc/view/UploadKycFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/subscription/kyc/view/UploadKycFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "bindVariablesToView", "", "dataBinding", "getLayoutId", "", "getViewModel", "goHome", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSubmitButtonClicked", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "selectFile", "requestCode", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UploadKycFragment extends DataBindingFragment<FragmentUploadKycBinding> {
    public static final int ADDRESS_PROOF_REQUEST_CODE = 101;
    public static final Companion Companion = new Companion(null);
    public static final int ID_PROOF_REQUEST_CODE = 102;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy kycViewModel$delegate = LazyKt.lazy(new Function0<UploadKYCViewModel>() { // from class: com.livpure.safedrink.subscription.kyc.view.UploadKycFragment$kycViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UploadKYCViewModel invoke() {
            return (UploadKYCViewModel) new ViewModelProvider(UploadKycFragment.this).get(UploadKYCViewModel.class);
        }
    });
    private final Lazy mainViewModel$delegate;
    private final NavArgsLazy navArgs$delegate;

    /* compiled from: UploadKycFragment.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[UploadKYCViewModel.States.values().length];
            iArr[UploadKYCViewModel.States.SELECT_ADDRESS_PROOF.ordinal()] = 1;
            iArr[UploadKYCViewModel.States.SELECT_ID_PROOF.ordinal()] = 2;
            iArr[UploadKYCViewModel.States.HOME.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MainViewModel.ProofUploadStatus.values().length];
            iArr2[MainViewModel.ProofUploadStatus.SUCCESS.ordinal()] = 1;
            iArr2[MainViewModel.ProofUploadStatus.FAILURE.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

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
        return R.layout.fragment_upload_kyc;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public UploadKycFragment() {
        final UploadKycFragment uploadKycFragment = this;
        this.mainViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(uploadKycFragment, Reflection.getOrCreateKotlinClass(MainViewModel.class), new Function0<ViewModelStore>() { // from class: com.livpure.safedrink.subscription.kyc.view.UploadKycFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = Fragment.this.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.livpure.safedrink.subscription.kyc.view.UploadKycFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = Function0.this;
                if (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) {
                    CreationExtras defaultViewModelCreationExtras = uploadKycFragment.requireActivity().getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.livpure.safedrink.subscription.kyc.view.UploadKycFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = Fragment.this.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(UploadKycFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.subscription.kyc.view.UploadKycFragment$special$$inlined$navArgs$1
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

    /* compiled from: UploadKycFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/livpure/safedrink/subscription/kyc/view/UploadKycFragment$Companion;", "", "()V", "ADDRESS_PROOF_REQUEST_CODE", "", "ID_PROOF_REQUEST_CODE", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final UploadKYCViewModel getKycViewModel() {
        return (UploadKYCViewModel) this.kycViewModel$delegate.getValue();
    }

    private final MainViewModel getMainViewModel() {
        return (MainViewModel) this.mainViewModel$delegate.getValue();
    }

    private final UploadKycFragmentArgs getNavArgs() {
        return (UploadKycFragmentArgs) this.navArgs$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public UploadKYCViewModel getViewModel() {
        return getKycViewModel();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getKycViewModel().getCurrentState().observe(this, new Observer() { // from class: com.livpure.safedrink.subscription.kyc.view.UploadKycFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UploadKycFragment.m1293onCreate$lambda0(UploadKycFragment.this, (UploadKYCViewModel.States) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m1293onCreate$lambda0(UploadKycFragment this$0, UploadKYCViewModel.States states) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = states == null ? -1 : WhenMappings.$EnumSwitchMapping$0[states.ordinal()];
        if (i == 1) {
            this$0.selectFile(101);
        } else if (i == 2) {
            this$0.selectFile(102);
        } else if (i != 3) {
        } else {
            this$0.goHome();
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getMainViewModel().resetProofs();
        Spinner spinner = (Spinner) _$_findCachedViewById(R.id.salutationSpinner);
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(requireActivity(), (int) R.layout.list_item_plain_text_small, getKycViewModel().getSalutationList()));
        spinner.setSelection(0);
        Pair<LiveData<List<String>>, LiveData<List<String>>> fetchSpinnerData = getKycViewModel().fetchSpinnerData();
        UploadKycFragment uploadKycFragment = this;
        fetchSpinnerData.getFirst().observe(uploadKycFragment, new Observer() { // from class: com.livpure.safedrink.subscription.kyc.view.UploadKycFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UploadKycFragment.m1295onViewCreated$lambda4(UploadKycFragment.this, (List) obj);
            }
        });
        fetchSpinnerData.getSecond().observe(uploadKycFragment, new Observer() { // from class: com.livpure.safedrink.subscription.kyc.view.UploadKycFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UploadKycFragment.m1296onViewCreated$lambda7(UploadKycFragment.this, (List) obj);
            }
        });
        ((Button) _$_findCachedViewById(R.id.submitButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.kyc.view.UploadKycFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UploadKycFragment.m1297onViewCreated$lambda8(UploadKycFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m1295onViewCreated$lambda4(UploadKycFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        Spinner spinner = (Spinner) this$0._$_findCachedViewById(R.id.addressProofSpinner);
        List mutableList = CollectionsKt.toMutableList((Collection) list2);
        mutableList.add("Select Address Proof");
        Unit unit = Unit.INSTANCE;
        spinner.setAdapter((SpinnerAdapter) new SpinnerWithHintAdapter(this$0.requireActivity(), (int) R.layout.list_item_plain_text_small, mutableList));
        spinner.setSelection(list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-7  reason: not valid java name */
    public static final void m1296onViewCreated$lambda7(UploadKycFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        Spinner spinner = (Spinner) this$0._$_findCachedViewById(R.id.idProofSpinner);
        List mutableList = CollectionsKt.toMutableList((Collection) list2);
        mutableList.add("Select ID Proof");
        Unit unit = Unit.INSTANCE;
        spinner.setAdapter((SpinnerAdapter) new SpinnerWithHintAdapter(this$0.requireActivity(), (int) R.layout.list_item_plain_text_small, mutableList));
        spinner.setSelection(list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-8  reason: not valid java name */
    public static final void m1297onViewCreated$lambda8(UploadKycFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onSubmitButtonClicked();
    }

    private final void onSubmitButtonClicked() {
        MainViewModel mainViewModel = getMainViewModel();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        mainViewModel.startUploadingKYC(requireActivity).observe(this, new Observer() { // from class: com.livpure.safedrink.subscription.kyc.view.UploadKycFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UploadKycFragment.m1294onSubmitButtonClicked$lambda9(UploadKycFragment.this, (MainViewModel.ProofUploadStatus) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSubmitButtonClicked$lambda-9  reason: not valid java name */
    public static final void m1294onSubmitButtonClicked$lambda9(UploadKycFragment this$0, MainViewModel.ProofUploadStatus proofUploadStatus) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((proofUploadStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$1[proofUploadStatus.ordinal()]) != 1) {
            return;
        }
        UploadKYCViewModel kycViewModel = this$0.getKycViewModel();
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        kycViewModel.updateKYCInformation(requireActivity, this$0.getMainViewModel().getUploadedFileList());
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentUploadKycBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        dataBinding.setViewModel(getKycViewModel());
        dataBinding.setPaymentId(getNavArgs().getPaymentId());
        dataBinding.setUser(LSApplication.Companion.getUser());
        dataBinding.setActivityViewModel(getMainViewModel());
    }

    private final void selectFile(int i) {
        requireActivity().startActivityForResult(Intent.createChooser(FileUtilKt.getFileChooserIntentForImageAndPdf(), i == 101 ? "Upload Address Proof" : "Upload ID Proof"), i);
    }

    private final void goHome() {
        NavGraphDirections.ActionGlobalHomeFragment actionGlobalHomeFragment = UploadKycFragmentDirections.actionGlobalHomeFragment(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Intrinsics.checkNotNullExpressionValue(actionGlobalHomeFragment, "actionGlobalHomeFragment(\"0\")");
        FragmentKt.findNavController(this).navigate(actionGlobalHomeFragment);
    }
}

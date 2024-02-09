package com.livpure.safedrink.subscription.payment.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
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
import com.livpure.safedrink.app.MainViewModel;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentAddLitresBinding;
import com.livpure.safedrink.login.MainActivity;
import com.livpure.safedrink.login.api.models.response.BaseV1ResponseImplementation;
import com.livpure.safedrink.segment.SegmentLogger;
import com.livpure.safedrink.subscription.payment.view.AddLitresFragmentDirections;
import com.livpure.safedrink.subscription.payment.viewmodel.AddLitresViewModel;
import com.livpure.safedrink.subscription.plan.data.model.deviceList.DeviceList;
import com.livpure.safedrink.subscription.plan.data.model.payment.PaymentPayload;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
/* compiled from: AddLitresFragment.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\b\u0010#\u001a\u00020\u0005H\u0014J\b\u0010$\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\u001a\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u0019H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/view/AddLitresFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentAddLitresBinding;", "()V", "addLitresViewModel", "Lcom/livpure/safedrink/subscription/payment/viewmodel/AddLitresViewModel;", "getAddLitresViewModel", "()Lcom/livpure/safedrink/subscription/payment/viewmodel/AddLitresViewModel;", "addLitresViewModel$delegate", "Lkotlin/Lazy;", "mainViewModel", "Lcom/livpure/safedrink/app/MainViewModel;", "getMainViewModel", "()Lcom/livpure/safedrink/app/MainViewModel;", "mainViewModel$delegate", "navArgs", "Lcom/livpure/safedrink/subscription/payment/view/AddLitresFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/subscription/payment/view/AddLitresFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "planDetails", "Landroidx/lifecycle/MutableLiveData;", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", "addLiter", "", "isAdd", "", "bindVariablesToView", "dataBinding", "getLayoutId", "", "getPaymentObserver", "Landroidx/lifecycle/Observer;", "Lcom/livpure/safedrink/subscription/plan/data/model/payment/PaymentPayload;", "getViewModel", "goBack", "onPaymentButtonClicked", "onSeeAllPlanClicked", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "proceedToReviewOrder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AddLitresFragment extends DataBindingFragment<FragmentAddLitresBinding> {
    private final Lazy mainViewModel$delegate;
    private final NavArgsLazy navArgs$delegate;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy addLitresViewModel$delegate = LazyKt.lazy(new Function0<AddLitresViewModel>() { // from class: com.livpure.safedrink.subscription.payment.view.AddLitresFragment$addLitresViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AddLitresViewModel invoke() {
            AddLitresFragmentArgs navArgs;
            AddLitresViewModel addLitresViewModel = (AddLitresViewModel) new ViewModelProvider(AddLitresFragment.this).get(AddLitresViewModel.class);
            navArgs = AddLitresFragment.this.getNavArgs();
            addLitresViewModel.setDevice(navArgs.getDevice());
            return addLitresViewModel;
        }
    });
    private final MutableLiveData<PlansItem> planDetails = new MutableLiveData<>();

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
        return R.layout.fragment_add_litres;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public AddLitresFragment() {
        final AddLitresFragment addLitresFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(AddLitresFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.subscription.payment.view.AddLitresFragment$special$$inlined$navArgs$1
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
        this.mainViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(addLitresFragment, Reflection.getOrCreateKotlinClass(MainViewModel.class), new Function0<ViewModelStore>() { // from class: com.livpure.safedrink.subscription.payment.view.AddLitresFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.livpure.safedrink.subscription.payment.view.AddLitresFragment$special$$inlined$activityViewModels$default$2
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
                    CreationExtras defaultViewModelCreationExtras = addLitresFragment.requireActivity().getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.livpure.safedrink.subscription.payment.view.AddLitresFragment$special$$inlined$activityViewModels$default$3
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AddLitresFragmentArgs getNavArgs() {
        return (AddLitresFragmentArgs) this.navArgs$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AddLitresViewModel getAddLitresViewModel() {
        return (AddLitresViewModel) this.addLitresViewModel$delegate.getValue();
    }

    private final MainViewModel getMainViewModel() {
        return (MainViewModel) this.mainViewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public AddLitresViewModel getViewModel() {
        return getAddLitresViewModel();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentAddLitresBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        dataBinding.setViewModel(getAddLitresViewModel());
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getAddLitresViewModel().getPerLitreRate();
        ((Button) _$_findCachedViewById(R.id.paymentButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.view.AddLitresFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddLitresFragment.m1334onViewCreated$lambda0(AddLitresFragment.this, view2);
            }
        });
        ((Button) _$_findCachedViewById(R.id.upgradeNowButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.view.AddLitresFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddLitresFragment.m1335onViewCreated$lambda1(AddLitresFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.seeAllPlans)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.view.AddLitresFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddLitresFragment.m1336onViewCreated$lambda2(AddLitresFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.removeWater)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.view.AddLitresFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddLitresFragment.m1337onViewCreated$lambda3(AddLitresFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.waterAdd)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.view.AddLitresFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddLitresFragment.m1338onViewCreated$lambda4(AddLitresFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m1334onViewCreated$lambda0(AddLitresFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onPaymentButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m1335onViewCreated$lambda1(AddLitresFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onSeeAllPlanClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m1336onViewCreated$lambda2(AddLitresFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onSeeAllPlanClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m1337onViewCreated$lambda3(AddLitresFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.addLiter(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m1338onViewCreated$lambda4(AddLitresFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.addLiter(true);
    }

    private final void addLiter(boolean z) {
        String value = getAddLitresViewModel().getAdditionalLitres().getValue();
        if (value == null || StringsKt.isBlank(value)) {
            if (z) {
                getAddLitresViewModel().getAdditionalLitres().setValue("1");
            } else {
                getAddLitresViewModel().getAdditionalLitres().setValue(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
        } else if (z) {
            MutableLiveData<String> additionalLitres = getAddLitresViewModel().getAdditionalLitres();
            String value2 = getAddLitresViewModel().getAdditionalLitres().getValue();
            Intrinsics.checkNotNull(value2);
            additionalLitres.setValue(String.valueOf(Integer.parseInt(value2) + 1));
        } else if (Intrinsics.areEqual(getAddLitresViewModel().getAdditionalLitres().getValue(), AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
        } else {
            MutableLiveData<String> additionalLitres2 = getAddLitresViewModel().getAdditionalLitres();
            String value3 = getAddLitresViewModel().getAdditionalLitres().getValue();
            Intrinsics.checkNotNull(value3);
            additionalLitres2.setValue(String.valueOf(Integer.parseInt(value3) - 1));
        }
    }

    private final void onPaymentButtonClicked() {
        ((MainActivity) requireActivity()).startRazorPayPayment(getAddLitresViewModel().getPaymentAmountInINR(), "ADD_LITRES", getAddLitresViewModel().getSerialNumber(), "", "", "", "", "");
        getMainViewModel().getPaymentState().observe(requireActivity(), getPaymentObserver());
    }

    private final void onSeeAllPlanClicked() {
        DeviceList deviceList = getAddLitresViewModel().get_device();
        AddLitresFragmentDirections.ActionAddLitresToSelectPlanChargeFragment actionAddLitresToSelectPlanChargeFragment = deviceList != null ? AddLitresFragmentDirections.actionAddLitresToSelectPlanChargeFragment(deviceList) : null;
        if (actionAddLitresToSelectPlanChargeFragment != null) {
            FragmentKt.findNavController(this).navigate(actionAddLitresToSelectPlanChargeFragment);
        }
    }

    private final void proceedToReviewOrder() {
        AddLitresFragmentDirections.ActionAddLitresToPlanDurationFragment actionAddLitresToPlanDurationFragment;
        this.planDetails.setValue(getAddLitresViewModel().getSelectedPlan().getValue());
        DeviceList deviceList = getAddLitresViewModel().get_device();
        if (deviceList != null) {
            PlansItem value = this.planDetails.getValue();
            Intrinsics.checkNotNull(value);
            actionAddLitresToPlanDurationFragment = AddLitresFragmentDirections.actionAddLitresToPlanDurationFragment(value, deviceList);
        } else {
            actionAddLitresToPlanDurationFragment = null;
        }
        if (actionAddLitresToPlanDurationFragment != null) {
            FragmentKt.findNavController(this).navigate(actionAddLitresToPlanDurationFragment);
        }
    }

    private final Observer<PaymentPayload> getPaymentObserver() {
        return new Observer() { // from class: com.livpure.safedrink.subscription.payment.view.AddLitresFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddLitresFragment.m1332getPaymentObserver$lambda8(AddLitresFragment.this, (PaymentPayload) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPaymentObserver$lambda-8  reason: not valid java name */
    public static final void m1332getPaymentObserver$lambda8(final AddLitresFragment this$0, final PaymentPayload paymentPayLoad) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AddLitresViewModel addLitresViewModel = this$0.getAddLitresViewModel();
        Intrinsics.checkNotNullExpressionValue(paymentPayLoad, "paymentPayLoad");
        LiveData<BaseV1ResponseImplementation> updatePayment = addLitresViewModel.updatePayment(paymentPayLoad);
        if (updatePayment != null) {
            updatePayment.observe(this$0.requireActivity(), new Observer() { // from class: com.livpure.safedrink.subscription.payment.view.AddLitresFragment$$ExternalSyntheticLambda6
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AddLitresFragment.m1333getPaymentObserver$lambda8$lambda7(AddLitresFragment.this, paymentPayLoad, (BaseV1ResponseImplementation) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPaymentObserver$lambda-8$lambda-7  reason: not valid java name */
    public static final void m1333getPaymentObserver$lambda8$lambda7(final AddLitresFragment this$0, final PaymentPayload paymentPayload, BaseV1ResponseImplementation baseV1ResponseImplementation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.processResponse(baseV1ResponseImplementation, new Function1<BaseV1ResponseImplementation, Unit>() { // from class: com.livpure.safedrink.subscription.payment.view.AddLitresFragment$getPaymentObserver$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseV1ResponseImplementation baseV1ResponseImplementation2) {
                invoke2(baseV1ResponseImplementation2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BaseV1ResponseImplementation it) {
                AddLitresViewModel addLitresViewModel;
                AddLitresViewModel addLitresViewModel2;
                Intrinsics.checkNotNullParameter(it, "it");
                SegmentLogger.Companion companion = SegmentLogger.Companion;
                FragmentActivity requireActivity = AddLitresFragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                SegmentLogger with = companion.with(requireActivity);
                String paymentId = paymentPayload.getPaymentId();
                addLitresViewModel = AddLitresFragment.this.getAddLitresViewModel();
                Long valueOf = Long.valueOf(MathKt.roundToLong(addLitresViewModel.getPaymentAmountInINR()));
                addLitresViewModel2 = AddLitresFragment.this.getAddLitresViewModel();
                String value = addLitresViewModel2.getAdditionalLitres().getValue();
                with.sendAddedLitresEvent(paymentId, valueOf, value != null ? Integer.valueOf(Integer.parseInt(value)) : null);
                Toast.makeText(AddLitresFragment.this.requireActivity(), "Additional litres were added to your subscription successfully!", 1).show();
                AddLitresFragment.this.goBack();
            }
        }, new Function1<BaseV1ResponseImplementation, Unit>() { // from class: com.livpure.safedrink.subscription.payment.view.AddLitresFragment$getPaymentObserver$1$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseV1ResponseImplementation baseV1ResponseImplementation2) {
                invoke2(baseV1ResponseImplementation2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BaseV1ResponseImplementation failedResponse) {
                Intrinsics.checkNotNullParameter(failedResponse, "failedResponse");
                AddLitresFragment addLitresFragment = AddLitresFragment.this;
                String message = failedResponse.getMessage();
                if (message == null) {
                    message = "Sorry! We are facing an issue while adding water litres at this moment.";
                }
                addLitresFragment.showToast(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goBack() {
        NavGraphDirections.ActionGlobalHomeFragment actionGlobalHomeFragment = ReviewOrderFragmentDirections.actionGlobalHomeFragment(getAddLitresViewModel().getSerialNumber());
        Intrinsics.checkNotNullExpressionValue(actionGlobalHomeFragment, "actionGlobalHomeFragment…esViewModel.serialNumber)");
        FragmentKt.findNavController(this).navigate(actionGlobalHomeFragment);
    }
}

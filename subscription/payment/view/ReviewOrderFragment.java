package com.livpure.safedrink.subscription.payment.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import com.livpure.safedrink.NavGraphDirections;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.app.MainViewModel;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentReviewOrderBinding;
import com.livpure.safedrink.login.MainActivity;
import com.livpure.safedrink.login.api.models.response.BaseV1ResponseImplementation;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.login.repositories.UserRepository;
import com.livpure.safedrink.subscription.payment.model.CheckCouponModel;
import com.livpure.safedrink.subscription.payment.model.ValidateCouponModel;
import com.livpure.safedrink.subscription.payment.view.ReviewOrderFragmentDirections;
import com.livpure.safedrink.subscription.payment.viewmodel.ReviewOrderViewModel;
import com.livpure.safedrink.subscription.plan.data.model.payment.PaymentPayload;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
import com.livpure.safedrink.utils.AnimProgressBar;
import com.livpure.safedrink.utils.Constant;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
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
import kotlin.text.StringsKt;
/* compiled from: ReviewOrderFragment.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0002H\u0016J\b\u0010/\u001a\u000200H\u0014J\b\u00101\u001a\u00020$H\u0014J\b\u00102\u001a\u00020-H\u0002J\u0012\u00103\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0012\u00106\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00107\u001a\u00020-H\u0016J\u001a\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020:2\b\u00104\u001a\u0004\u0018\u000105H\u0017J\u0018\u0010;\u001a\u00020-2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0007H\u0002J\b\u0010?\u001a\u00020-H\u0002J\b\u0010@\u001a\u00020-H\u0002J\b\u0010A\u001a\u00020-H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0019\u001a\u0004\b%\u0010&R\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006B"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/view/ReviewOrderFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentReviewOrderBinding;", "()V", "animProgressBar", "Lcom/livpure/safedrink/utils/AnimProgressBar;", "couponAmount", "", "getCouponAmount", "()Ljava/lang/String;", "setCouponAmount", "(Ljava/lang/String;)V", "couponName", "getCouponName", "setCouponName", "isApiCalled", "", "()Z", "setApiCalled", "(Z)V", "mainViewModel", "Lcom/livpure/safedrink/app/MainViewModel;", "getMainViewModel", "()Lcom/livpure/safedrink/app/MainViewModel;", "mainViewModel$delegate", "Lkotlin/Lazy;", "navArgs", "Lcom/livpure/safedrink/subscription/payment/view/ReviewOrderFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/subscription/payment/view/ReviewOrderFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "paymentObserver", "Landroidx/lifecycle/Observer;", "Lcom/livpure/safedrink/subscription/plan/data/model/payment/PaymentPayload;", "reviewOrderViewModel", "Lcom/livpure/safedrink/subscription/payment/viewmodel/ReviewOrderViewModel;", "getReviewOrderViewModel", "()Lcom/livpure/safedrink/subscription/payment/viewmodel/ReviewOrderViewModel;", "reviewOrderViewModel$delegate", "user", "Lcom/livpure/safedrink/login/data/models/User;", "getUser", "()Lcom/livpure/safedrink/login/data/models/User;", "bindVariablesToView", "", "dataBinding", "getLayoutId", "", "getViewModel", "goHome", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onResume", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "sendSubscriptionEvent", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "razorpayPaymentId", "showInstallationAddressScreen", "showTermsAndConditions", "showUploadKYCScreen", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReviewOrderFragment extends DataBindingFragment<FragmentReviewOrderBinding> {
    private AnimProgressBar animProgressBar;
    private boolean isApiCalled;
    private final Lazy mainViewModel$delegate;
    private final NavArgsLazy navArgs$delegate;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final User user = LSApplication.Companion.getUser();
    private String couponName = "";
    private String couponAmount = "";
    private final Lazy reviewOrderViewModel$delegate = LazyKt.lazy(new Function0<ReviewOrderViewModel>() { // from class: com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment$reviewOrderViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ReviewOrderViewModel invoke() {
            ReviewOrderFragmentArgs navArgs;
            ReviewOrderFragmentArgs navArgs2;
            ReviewOrderFragmentArgs navArgs3;
            ReviewOrderFragmentArgs navArgs4;
            ReviewOrderViewModel reviewOrderViewModel = (ReviewOrderViewModel) new ViewModelProvider(ReviewOrderFragment.this).get(ReviewOrderViewModel.class);
            navArgs = ReviewOrderFragment.this.getNavArgs();
            reviewOrderViewModel.setPlan(navArgs.getPlan());
            navArgs2 = ReviewOrderFragment.this.getNavArgs();
            reviewOrderViewModel.setDevice(navArgs2.getDevice());
            navArgs3 = ReviewOrderFragment.this.getNavArgs();
            String planName = navArgs3.getPlanName();
            Intrinsics.checkNotNullExpressionValue(planName, "navArgs.planName");
            reviewOrderViewModel.setPlanName(planName);
            navArgs4 = ReviewOrderFragment.this.getNavArgs();
            String planNumber = navArgs4.getPlanNumber();
            Intrinsics.checkNotNullExpressionValue(planNumber, "navArgs.planNumber");
            reviewOrderViewModel.setPlanNumber(planNumber);
            return reviewOrderViewModel;
        }
    });
    private final Observer<PaymentPayload> paymentObserver = new Observer() { // from class: com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment$$ExternalSyntheticLambda6
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            ReviewOrderFragment.m1359paymentObserver$lambda7(ReviewOrderFragment.this, (PaymentPayload) obj);
        }
    };

    /* compiled from: ReviewOrderFragment.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReviewOrderViewModel.ReviewOrderNavigationState.values().length];
            iArr[ReviewOrderViewModel.ReviewOrderNavigationState.INSTALLATION_ADDRESS.ordinal()] = 1;
            iArr[ReviewOrderViewModel.ReviewOrderNavigationState.TERMS_AND_CONDITIONS.ordinal()] = 2;
            iArr[ReviewOrderViewModel.ReviewOrderNavigationState.START_PAYMENT.ordinal()] = 3;
            iArr[ReviewOrderViewModel.ReviewOrderNavigationState.UPLOAD_KYC.ordinal()] = 4;
            iArr[ReviewOrderViewModel.ReviewOrderNavigationState.HOME.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
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
        return R.layout.fragment_review_order;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public ReviewOrderFragment() {
        final ReviewOrderFragment reviewOrderFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(ReviewOrderFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment$special$$inlined$navArgs$1
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
        this.mainViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(reviewOrderFragment, Reflection.getOrCreateKotlinClass(MainViewModel.class), new Function0<ViewModelStore>() { // from class: com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment$special$$inlined$activityViewModels$default$2
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
                    CreationExtras defaultViewModelCreationExtras = reviewOrderFragment.requireActivity().getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment$special$$inlined$activityViewModels$default$3
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
    public final ReviewOrderFragmentArgs getNavArgs() {
        return (ReviewOrderFragmentArgs) this.navArgs$delegate.getValue();
    }

    public final User getUser() {
        return this.user;
    }

    public final String getCouponName() {
        return this.couponName;
    }

    public final void setCouponName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.couponName = str;
    }

    public final String getCouponAmount() {
        return this.couponAmount;
    }

    public final void setCouponAmount(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.couponAmount = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReviewOrderViewModel getReviewOrderViewModel() {
        return (ReviewOrderViewModel) this.reviewOrderViewModel$delegate.getValue();
    }

    private final MainViewModel getMainViewModel() {
        return (MainViewModel) this.mainViewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public ReviewOrderViewModel getViewModel() {
        return getReviewOrderViewModel();
    }

    public final boolean isApiCalled() {
        return this.isApiCalled;
    }

    public final void setApiCalled(boolean z) {
        this.isApiCalled = z;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getReviewOrderViewModel().observeNavigationState().observe(this, new Observer() { // from class: com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReviewOrderFragment.m1353onCreate$lambda0(ReviewOrderFragment.this, (ReviewOrderViewModel.ReviewOrderNavigationState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m1353onCreate$lambda0(ReviewOrderFragment this$0, ReviewOrderViewModel.ReviewOrderNavigationState reviewOrderNavigationState) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = reviewOrderNavigationState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[reviewOrderNavigationState.ordinal()];
        if (i == 1) {
            this$0.showInstallationAddressScreen();
        } else if (i == 2) {
            this$0.showTermsAndConditions();
        } else if (i != 3) {
            if (i == 4) {
                this$0.showUploadKYCScreen();
            } else if (i != 5) {
            } else {
                this$0.goHome();
            }
        } else {
            AnimProgressBar animProgressBar = this$0.animProgressBar;
            if (animProgressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                animProgressBar = null;
            }
            animProgressBar.show();
            MainActivity mainActivity = (MainActivity) this$0.requireActivity();
            String substring = ((TextView) this$0._$_findCachedViewById(R.id.tv_total_payable_amount)).getText().toString().substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            double parseDouble = Double.parseDouble(substring);
            String serialNumber = this$0.getReviewOrderViewModel().getSerialNumber();
            PriceItem plan = this$0.getReviewOrderViewModel().getPlan();
            mainActivity.startRazorPayPayment(parseDouble, "Subscription", serialNumber, plan != null ? plan.getDuration() : null, this$0.getReviewOrderViewModel().getSelectedPlanId(), this$0.getReviewOrderViewModel().getSelectedPlanName(), this$0.couponName, this$0.couponAmount);
            this$0.getMainViewModel().getPaymentState().observe(this$0, this$0.paymentObserver);
        }
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentReviewOrderBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        dataBinding.setUser(LSApplication.Companion.getUser());
        dataBinding.setViewModel(getReviewOrderViewModel());
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String sb;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        PriceItem plan = getReviewOrderViewModel().getPlan();
        if (StringsKt.equals$default(plan != null ? plan.getDuration() : null, "1", false, 2, null)) {
            sb = "28 Days";
        } else {
            StringBuilder sb2 = new StringBuilder();
            PriceItem plan2 = getReviewOrderViewModel().getPlan();
            sb2.append(plan2 != null ? plan2.getDuration() : null);
            sb2.append(" months");
            sb = sb2.toString();
        }
        ((TextView) _$_findCachedViewById(R.id.duration)).setText(sb);
        this.animProgressBar = new AnimProgressBar(requireContext());
        ((Button) _$_findCachedViewById(R.id.paymentButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReviewOrderFragment.m1354onViewCreated$lambda1(ReviewOrderFragment.this, view2);
            }
        });
        ((Button) _$_findCachedViewById(R.id.btn_coupon_apply)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReviewOrderFragment.m1355onViewCreated$lambda3(ReviewOrderFragment.this, view2);
            }
        });
        ((ImageView) _$_findCachedViewById(R.id.ivCloseIcon)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReviewOrderFragment.m1357onViewCreated$lambda4(ReviewOrderFragment.this, view2);
            }
        });
        getReviewOrderViewModel().checkIfCouponExist().observe(requireActivity(), new Observer() { // from class: com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReviewOrderFragment.m1358onViewCreated$lambda5(ReviewOrderFragment.this, (CheckCouponModel) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m1354onViewCreated$lambda1(ReviewOrderFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReviewOrderViewModel reviewOrderViewModel = this$0.getReviewOrderViewModel();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        reviewOrderViewModel.onPaymentClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c5  */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1355onViewCreated$lambda3(final com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment r5, android.view.View r6) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment.m1355onViewCreated$lambda3(com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3$lambda-2  reason: not valid java name */
    public static final void m1356onViewCreated$lambda3$lambda2(ReviewOrderFragment this$0, ValidateCouponModel validateCouponModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Button) this$0._$_findCachedViewById(R.id.btn_coupon_apply)).setEnabled(true);
        if (Intrinsics.areEqual(validateCouponModel.getStatus(), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            if (this$0.isApiCalled) {
                this$0.couponAmount = validateCouponModel.getData().getCouponnDetails().get(0).getAmount();
                ((TextView) this$0._$_findCachedViewById(R.id.tv_coupon_amount)).setText("- " + this$0.getResources().getString(R.string.Rs) + validateCouponModel.getData().getCouponnDetails().get(0).getAmount());
                String substring = ((TextView) this$0._$_findCachedViewById(R.id.tv_total_payable_amount)).getText().toString().substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                double parseDouble = Double.parseDouble(substring) - Double.parseDouble(validateCouponModel.getData().getCouponnDetails().get(0).getAmount());
                ((TextView) this$0._$_findCachedViewById(R.id.tv_total_payable_amount)).setText(this$0.getResources().getString(R.string.Rs) + parseDouble);
                ((ConstraintLayout) this$0._$_findCachedViewById(R.id.ll_coupon_layout)).setVisibility(8);
                ((ConstraintLayout) this$0._$_findCachedViewById(R.id.ll_coupon_applied_layout)).setVisibility(0);
                ((RelativeLayout) this$0._$_findCachedViewById(R.id.rlCouponLayout)).setVisibility(0);
                ((EditText) this$0._$_findCachedViewById(R.id.edtCouponApplied)).setText(StringsKt.trim((CharSequence) ((EditText) this$0._$_findCachedViewById(R.id.edt_coupon)).getText().toString()).toString());
            }
        } else if (this$0.isApiCalled) {
            Toast.makeText(this$0.requireActivity(), validateCouponModel.getMessage(), 0).show();
        }
        this$0.isApiCalled = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m1357onViewCreated$lambda4(ReviewOrderFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ConstraintLayout) this$0._$_findCachedViewById(R.id.ll_coupon_layout)).setVisibility(0);
        ((ConstraintLayout) this$0._$_findCachedViewById(R.id.ll_coupon_applied_layout)).setVisibility(8);
        ((RelativeLayout) this$0._$_findCachedViewById(R.id.rlCouponLayout)).setVisibility(8);
        ((TextView) this$0._$_findCachedViewById(R.id.tv_total_payable_amount)).setText(this$0.getResources().getString(R.string.Rs) + this$0.getReviewOrderViewModel().getPayableAmount());
        ((EditText) this$0._$_findCachedViewById(R.id.edtCouponApplied)).setText("");
        this$0.couponName = "";
        this$0.couponAmount = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-5  reason: not valid java name */
    public static final void m1358onViewCreated$lambda5(ReviewOrderFragment this$0, CheckCouponModel checkCouponModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (checkCouponModel.getStatus()) {
            if (Intrinsics.areEqual(this$0.getReviewOrderViewModel().getSelectedPlanId(), "52")) {
                ((LinearLayout) this$0._$_findCachedViewById(R.id.llCouponMainLayout)).setVisibility(8);
                return;
            } else {
                ((LinearLayout) this$0._$_findCachedViewById(R.id.llCouponMainLayout)).setVisibility(0);
                return;
            }
        }
        ((LinearLayout) this$0._$_findCachedViewById(R.id.llCouponMainLayout)).setVisibility(8);
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ((MainActivity) requireActivity()).setupDefaultUpButtonNavigation();
    }

    private final void showInstallationAddressScreen() {
        NavDirections actionReviewOrderFragmentToInstallationAddressFragment = ReviewOrderFragmentDirections.actionReviewOrderFragmentToInstallationAddressFragment();
        Intrinsics.checkNotNullExpressionValue(actionReviewOrderFragmentToInstallationAddressFragment, "actionReviewOrderFragmen…allationAddressFragment()");
        FragmentKt.findNavController(this).navigate(actionReviewOrderFragmentToInstallationAddressFragment);
    }

    private final void showTermsAndConditions() {
        NavGraphDirections.ActionGlobalWebViewFragment actionGlobalWebViewFragment = ReviewOrderFragmentDirections.actionGlobalWebViewFragment(R.string.terms_and_conditions_url);
        Intrinsics.checkNotNullExpressionValue(actionGlobalWebViewFragment, "actionGlobalWebViewFragm…terms_and_conditions_url)");
        FragmentKt.findNavController(this).navigate(actionGlobalWebViewFragment);
    }

    private final void showUploadKYCScreen() {
        ReviewOrderFragmentDirections.ActionReviewOrderFragmentToUploadKYCFragment actionReviewOrderFragmentToUploadKYCFragment = ReviewOrderFragmentDirections.actionReviewOrderFragmentToUploadKYCFragment(getReviewOrderViewModel().getPaymentId());
        Intrinsics.checkNotNullExpressionValue(actionReviewOrderFragmentToUploadKYCFragment, "actionReviewOrderFragmen…Model.paymentId\n        )");
        FragmentKt.findNavController(this).navigate(actionReviewOrderFragmentToUploadKYCFragment);
    }

    private final void goHome() {
        Bundle bundle = new Bundle();
        bundle.putString("serialNumber", getReviewOrderViewModel().getSerialNumber());
        FragmentKt.findNavController(this).navigate(R.id.homeFragment, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: paymentObserver$lambda-7  reason: not valid java name */
    public static final void m1359paymentObserver$lambda7(final ReviewOrderFragment this$0, final PaymentPayload paymentPayLoad) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReviewOrderViewModel reviewOrderViewModel = this$0.getReviewOrderViewModel();
        Intrinsics.checkNotNullExpressionValue(paymentPayLoad, "paymentPayLoad");
        String substring = ((TextView) this$0._$_findCachedViewById(R.id.tv_total_payable_amount)).getText().toString().substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        LiveData<BaseV1ResponseImplementation> updatePayment = reviewOrderViewModel.updatePayment(paymentPayLoad, (int) Double.parseDouble(substring), this$0.couponName, this$0.couponAmount);
        if (updatePayment != null) {
            updatePayment.observe(this$0, new Observer() { // from class: com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment$$ExternalSyntheticLambda7
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReviewOrderFragment.m1360paymentObserver$lambda7$lambda6(ReviewOrderFragment.this, paymentPayLoad, (BaseV1ResponseImplementation) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: paymentObserver$lambda-7$lambda-6  reason: not valid java name */
    public static final void m1360paymentObserver$lambda7$lambda6(final ReviewOrderFragment this$0, final PaymentPayload paymentPayload, BaseV1ResponseImplementation baseV1ResponseImplementation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnimProgressBar animProgressBar = this$0.animProgressBar;
        if (animProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            animProgressBar = null;
        }
        animProgressBar.dismiss();
        this$0.processResponse(baseV1ResponseImplementation, new Function1<BaseV1ResponseImplementation, Unit>() { // from class: com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment$paymentObserver$1$1$1
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
                ReviewOrderViewModel reviewOrderViewModel;
                Intrinsics.checkNotNullParameter(it, "it");
                ReviewOrderFragment reviewOrderFragment = ReviewOrderFragment.this;
                FragmentActivity requireActivity = reviewOrderFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                String paymentId = paymentPayload.getPaymentId();
                Intrinsics.checkNotNull(paymentId);
                reviewOrderFragment.sendSubscriptionEvent(requireActivity, paymentId);
                reviewOrderViewModel = ReviewOrderFragment.this.getReviewOrderViewModel();
                FragmentActivity requireActivity2 = ReviewOrderFragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                reviewOrderViewModel.onRechargeStatusUpdated(requireActivity2);
                UserRepository.Companion companion = UserRepository.Companion;
                FragmentActivity requireActivity3 = ReviewOrderFragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity3, "requireActivity()");
                UserRepository companion2 = companion.getInstance(requireActivity3);
                User user = LSApplication.Companion.getUser();
                if (user != null) {
                    user.setPaymentCompleted(true);
                } else {
                    user = null;
                }
                companion2.setUser(user);
            }
        }, new Function1<BaseV1ResponseImplementation, Unit>() { // from class: com.livpure.safedrink.subscription.payment.view.ReviewOrderFragment$paymentObserver$1$1$2
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
                ReviewOrderFragment reviewOrderFragment = ReviewOrderFragment.this;
                String message = failedResponse.getMessage();
                if (message == null) {
                    message = "Sorry. We faced an issue while updating your payment details.";
                }
                reviewOrderFragment.showToast(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSubscriptionEvent(Context context, String str) {
        LSApplication.Companion.getUser();
        getReviewOrderViewModel().getPlan();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (Constant.Companion.getIsPaymentFailed()) {
            AnimProgressBar animProgressBar = this.animProgressBar;
            if (animProgressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
                animProgressBar = null;
            }
            animProgressBar.dismiss();
            Constant.Companion.setIsPaymentFailed(false);
        }
    }
}

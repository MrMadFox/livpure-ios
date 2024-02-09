package com.livpure.safedrink.app;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentProfileBinding;
import com.livpure.safedrink.login.data.models.User;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
/* compiled from: ProfileFragment.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u000eH\u0014J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\u001a\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0006\u0010 \u001a\u00020\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, d2 = {"Lcom/livpure/safedrink/app/ProfileFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentProfileBinding;", "()V", "email", "", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "mobile", "getMobile", "setMobile", "profileViewModel", "Lcom/livpure/safedrink/app/ProfileViewModel;", "getProfileViewModel", "()Lcom/livpure/safedrink/app/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "bindVariablesToView", "", "dataBinding", "getLayoutId", "", "getViewModel", "onEditEmail", "onEditMobile", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "oncancelSubscriptionLinearLayoutClick", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ProfileFragment extends DataBindingFragment<FragmentProfileBinding> {
    private String email;
    private String mobile;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy profileViewModel$delegate = LazyKt.lazy(new Function0<ProfileViewModel>() { // from class: com.livpure.safedrink.app.ProfileFragment$profileViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ProfileViewModel invoke() {
            return (ProfileViewModel) new ViewModelProvider(ProfileFragment.this).get(ProfileViewModel.class);
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
        return R.layout.fragment_profile;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    private final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public ProfileViewModel getViewModel() {
        return getProfileViewModel();
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final void setMobile(String str) {
        this.mobile = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentProfileBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        dataBinding.setViewModel(getProfileViewModel());
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((LinearLayout) _$_findCachedViewById(R.id.cancelSubscriptionLinearLayout)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.ProfileFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileFragment.m445onViewCreated$lambda0(ProfileFragment.this, view2);
            }
        });
        ((ImageView) _$_findCachedViewById(R.id.imgEditMail)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.ProfileFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileFragment.m446onViewCreated$lambda1(ProfileFragment.this, view2);
            }
        });
        ((ImageView) _$_findCachedViewById(R.id.imgEditMobile)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.ProfileFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileFragment.m447onViewCreated$lambda2(ProfileFragment.this, view2);
            }
        });
        if (LSApplication.Companion.getUser() != null) {
            User user = LSApplication.Companion.getUser();
            Intrinsics.checkNotNull(user);
            if (user.getCancelService()) {
                User user2 = LSApplication.Companion.getUser();
                Intrinsics.checkNotNull(user2);
                if (Intrinsics.areEqual(user2.getCancellationRequestedDate(), "")) {
                    return;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                User user3 = LSApplication.Companion.getUser();
                Intrinsics.checkNotNull(user3);
                String format = String.format("%s submitted on %s", Arrays.copyOf(new Object[]{requireActivity().getString(R.string.subscription_cancellation), user3.getCancellationRequestedDate()}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                ((TextView) _$_findCachedViewById(R.id.cancel_subscription_tv)).setText(format);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m445onViewCreated$lambda0(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.oncancelSubscriptionLinearLayoutClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m446onViewCreated$lambda1(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onEditEmail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m447onViewCreated$lambda2(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onEditMobile();
    }

    private final void onEditEmail() {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("EmailMobile", "Email");
            FragmentKt.findNavController(this).navigate(R.id.action_email_mobile_verify, bundle);
        } catch (Exception e) {
            Logger.getLogger(e.toString());
        }
    }

    private final void onEditMobile() {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("EmailMobile", AnalyticsEvent.EVENT_TYPE_MOBILE);
            FragmentKt.findNavController(this).navigate(R.id.action_email_mobile_verify, bundle);
        } catch (Exception e) {
            Logger.getLogger(e.toString());
        }
    }

    public final void oncancelSubscriptionLinearLayoutClick() {
        try {
            NavDirections actionCancelSubscription = ProfileFragmentDirections.actionCancelSubscription();
            Intrinsics.checkNotNullExpressionValue(actionCancelSubscription, "actionCancelSubscription()");
            FragmentKt.findNavController(this).navigate(actionCancelSubscription);
        } catch (Exception e) {
            Logger.getLogger(e.toString());
        }
    }
}

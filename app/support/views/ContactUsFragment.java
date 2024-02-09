package com.livpure.safedrink.app.support.views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.app.support.views.ContactUsFragmentDirections;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.views.BaseFragment;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.segment.SegmentLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* compiled from: ContactUsFragment.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0014J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/livpure/safedrink/app/support/views/ContactUsFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/BaseFragment;", "()V", "navArgs", "Lcom/livpure/safedrink/app/support/views/ContactUsFragmentArgs;", "getNavArgs", "()Lcom/livpure/safedrink/app/support/views/ContactUsFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "getLayoutId", "", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "onViewCreated", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showRaiseAServiceRequestScreen", "cancelSub", "", "showRelocationRequestScreen", "showServiceRequestScreen", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ContactUsFragment extends BaseFragment {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final NavArgsLazy navArgs$delegate;

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
        return R.layout.fragment_contact_us;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public ContactUsFragment() {
        final ContactUsFragment contactUsFragment = this;
        this.navArgs$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(ContactUsFragmentArgs.class), new Function0<Bundle>() { // from class: com.livpure.safedrink.app.support.views.ContactUsFragment$special$$inlined$navArgs$1
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

    private final ContactUsFragmentArgs getNavArgs() {
        return (ContactUsFragmentArgs) this.navArgs$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public AnalyticsViewModel getViewModel() {
        return (AnalyticsViewModel) new ViewModelProvider(this).get(AnalyticsViewModel.class);
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((LinearLayout) _$_findCachedViewById(R.id.supportPhoneNumber)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.support.views.ContactUsFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ContactUsFragment.m460onViewCreated$lambda1(ContactUsFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.supportPhoneNumber1)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.support.views.ContactUsFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ContactUsFragment.m462onViewCreated$lambda3(ContactUsFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.serviceRequestButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.support.views.ContactUsFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ContactUsFragment.m463onViewCreated$lambda4(ContactUsFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.raiseAServiceRequest)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.support.views.ContactUsFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ContactUsFragment.m464onViewCreated$lambda5(ContactUsFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.serviceRequestButton1)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.support.views.ContactUsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ContactUsFragment.m465onViewCreated$lambda6(ContactUsFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.llCancelSubscription)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.support.views.ContactUsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ContactUsFragment.m466onViewCreated$lambda7(ContactUsFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.relocation)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.support.views.ContactUsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ContactUsFragment.m467onViewCreated$lambda8(ContactUsFragment.this, view2);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.myRequests)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.app.support.views.ContactUsFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ContactUsFragment.m461onViewCreated$lambda10(ContactUsFragment.this, view2);
            }
        });
        if (Intrinsics.areEqual(getNavArgs().getSerialNumber(), "1")) {
            ((LinearLayout) _$_findCachedViewById(R.id.llContactUs)).setVisibility(0);
            ((LinearLayout) _$_findCachedViewById(R.id.llServiceRequest)).setVisibility(8);
        } else {
            ((LinearLayout) _$_findCachedViewById(R.id.llContactUs)).setVisibility(8);
            ((LinearLayout) _$_findCachedViewById(R.id.llServiceRequest)).setVisibility(0);
        }
        User user = LSApplication.Companion.getUser();
        if (Intrinsics.areEqual(user != null ? user.getRelocation_status() : null, "1")) {
            ((TextView) _$_findCachedViewById(R.id.textRelocate)).setText(getString(R.string.track_relocation_status));
        } else {
            ((TextView) _$_findCachedViewById(R.id.textRelocate)).setText(getString(R.string.button_update_address));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m460onViewCreated$lambda1(ContactUsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            SegmentLogger with = SegmentLogger.Companion.with(context);
            User user = LSApplication.Companion.getUser();
            String name = user != null ? user.getName() : null;
            User user2 = LSApplication.Companion.getUser();
            with.contactUsClick(name, user2 != null ? user2.getId() : null);
        }
        this$0.startActivity(new Intent("android.intent.action.DIAL", Uri.fromParts("tel", "8800762226", null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m462onViewCreated$lambda3(ContactUsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            SegmentLogger with = SegmentLogger.Companion.with(context);
            User user = LSApplication.Companion.getUser();
            String name = user != null ? user.getName() : null;
            User user2 = LSApplication.Companion.getUser();
            with.emailUsClick(name, user2 != null ? user2.getId() : null);
        }
        this$0.startActivity(new Intent("android.intent.action.DIAL", Uri.fromParts("tel", "8800762226", null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m463onViewCreated$lambda4(ContactUsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showServiceRequestScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-5  reason: not valid java name */
    public static final void m464onViewCreated$lambda5(ContactUsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showRaiseAServiceRequestScreen(AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-6  reason: not valid java name */
    public static final void m465onViewCreated$lambda6(ContactUsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showServiceRequestScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-7  reason: not valid java name */
    public static final void m466onViewCreated$lambda7(ContactUsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showRaiseAServiceRequestScreen("1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-8  reason: not valid java name */
    public static final void m467onViewCreated$lambda8(ContactUsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showRelocationRequestScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-10  reason: not valid java name */
    public static final void m461onViewCreated$lambda10(ContactUsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            SegmentLogger with = SegmentLogger.Companion.with(context);
            User user = LSApplication.Companion.getUser();
            String name = user != null ? user.getName() : null;
            User user2 = LSApplication.Companion.getUser();
            with.raiseServiceRequestHistory(name, user2 != null ? user2.getId() : null);
        }
        NavDirections actionContactUsFragmentToRaiseServiceRequestHistoryFragment = ContactUsFragmentDirections.actionContactUsFragmentToRaiseServiceRequestHistoryFragment();
        Intrinsics.checkNotNullExpressionValue(actionContactUsFragmentToRaiseServiceRequestHistoryFragment, "actionContactUsFragmentT…eRequestHistoryFragment()");
        FragmentKt.findNavController(this$0).navigate(actionContactUsFragmentToRaiseServiceRequestHistoryFragment);
    }

    private final void showServiceRequestScreen() {
        NavDirections actionContactUsFragmentToServiceRequestFragment = ContactUsFragmentDirections.actionContactUsFragmentToServiceRequestFragment();
        Intrinsics.checkNotNullExpressionValue(actionContactUsFragmentToServiceRequestFragment, "actionContactUsFragmentToServiceRequestFragment()");
        FragmentKt.findNavController(this).navigate(actionContactUsFragmentToServiceRequestFragment);
    }

    private final void showRaiseAServiceRequestScreen(String str) {
        ContactUsFragmentDirections.ActionContactUsFragmentToRaiseServiceRequestFragment actionContactUsFragmentToRaiseServiceRequestFragment = ContactUsFragmentDirections.actionContactUsFragmentToRaiseServiceRequestFragment(getNavArgs().getSerialNumber(), str);
        Intrinsics.checkNotNullExpressionValue(actionContactUsFragmentToRaiseServiceRequestFragment, "actionContactUsFragmentT….serialNumber, cancelSub)");
        FragmentKt.findNavController(this).navigate(actionContactUsFragmentToRaiseServiceRequestFragment);
    }

    private final void showRelocationRequestScreen() {
        User user = LSApplication.Companion.getUser();
        if (Intrinsics.areEqual(user != null ? user.getRelocation_status() : null, "1")) {
            NavDirections actionContactUsFragmentToTrackRelocation = ContactUsFragmentDirections.actionContactUsFragmentToTrackRelocation();
            Intrinsics.checkNotNullExpressionValue(actionContactUsFragmentToTrackRelocation, "actionContactUsFragmentToTrackRelocation()");
            FragmentKt.findNavController(this).navigate(actionContactUsFragmentToTrackRelocation);
            return;
        }
        NavDirections actionContactUsFragmentToRelocationFragment = ContactUsFragmentDirections.actionContactUsFragmentToRelocationFragment();
        Intrinsics.checkNotNullExpressionValue(actionContactUsFragmentToRelocationFragment, "actionContactUsFragmentToRelocationFragment()");
        FragmentKt.findNavController(this).navigate(actionContactUsFragmentToRelocationFragment);
    }
}

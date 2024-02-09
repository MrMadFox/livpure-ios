package com.livpure.safedrink.referNearn.view.fragment;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.FragmentKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.material.textview.MaterialTextView;
import com.koushikdutta.async.http.body.StringBody;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentReferralInvitesBinding;
import com.livpure.safedrink.login.api.models.response.ReferralLinkResponse;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.referNearn.view.fragment.ReferEarnFragmentDirections;
import com.livpure.safedrink.referNearn.viewmodels.ReferAndEarnViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReferralInvitesFragment.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\nH\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\u0012\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\u0011J\u0006\u0010\u001f\u001a\u00020\u0011J\u000e\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0017J\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0017J\u001a\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010&H\u0017R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/livpure/safedrink/referNearn/view/fragment/ReferralInvitesFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentReferralInvitesBinding;", "Landroid/view/View$OnClickListener;", "()V", "myClip", "Landroid/content/ClipData;", "myClipboard", "Landroid/content/ClipboardManager;", "referAndEarnModel", "Lcom/livpure/safedrink/referNearn/viewmodels/ReferAndEarnViewModel;", "getReferAndEarnModel", "()Lcom/livpure/safedrink/referNearn/viewmodels/ReferAndEarnViewModel;", "referAndEarnModel$delegate", "Lkotlin/Lazy;", "referralInvitesBinding", "bindVariablesToView", "", "dataBinding", "getLayoutId", "", "getReferralLink", NativeProtocol.WEB_DIALOG_ACTION, "", "getViewModel", "isToolbarVisible", "", "onClick", "v", "Landroid/view/View;", "onClipReferralCodeClick", "onHowItsWorkButtonClicked", "onShareReferralCodeClick", "referralLink", "onShareReferralCodeWhatsAPPLinkClick", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "savedInstanceState", "Landroid/os/Bundle;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferralInvitesFragment extends DataBindingFragment<FragmentReferralInvitesBinding> implements View.OnClickListener {
    private ClipData myClip;
    private ClipboardManager myClipboard;
    private FragmentReferralInvitesBinding referralInvitesBinding;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy referAndEarnModel$delegate = LazyKt.lazy(new Function0<ReferAndEarnViewModel>() { // from class: com.livpure.safedrink.referNearn.view.fragment.ReferralInvitesFragment$referAndEarnModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ReferAndEarnViewModel invoke() {
            return (ReferAndEarnViewModel) new ViewModelProvider(ReferralInvitesFragment.this).get(ReferAndEarnViewModel.class);
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
        return R.layout.fragment_referral_invites;
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

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentReferralInvitesBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.referralInvitesBinding = dataBinding;
        if (dataBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("referralInvitesBinding");
            dataBinding = null;
        }
        dataBinding.setUserData(getReferAndEarnModel());
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        getReferAndEarnModel().getReferralHistory();
        getReferAndEarnModel().getLeadershipBoard();
        ((TextView) _$_findCachedViewById(R.id.onShareReferralCode)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.referNearn.view.fragment.ReferralInvitesFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReferralInvitesFragment.m1130onViewCreated$lambda0(ReferralInvitesFragment.this, view2);
            }
        });
        ((MaterialTextView) _$_findCachedViewById(R.id.onShareReferralCodeWhatsAPPLink)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.referNearn.view.fragment.ReferralInvitesFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReferralInvitesFragment.m1131onViewCreated$lambda1(ReferralInvitesFragment.this, view2);
            }
        });
        ((TextView) _$_findCachedViewById(R.id.txtCopyId)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.referNearn.view.fragment.ReferralInvitesFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReferralInvitesFragment.m1132onViewCreated$lambda2(ReferralInvitesFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m1130onViewCreated$lambda0(ReferralInvitesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (LSApplication.Companion.getReferralLink() != null && !Intrinsics.areEqual(LSApplication.Companion.getReferralLink(), "")) {
            String referralLink = LSApplication.Companion.getReferralLink();
            Intrinsics.checkNotNull(referralLink);
            this$0.onShareReferralCodeClick(referralLink);
            return;
        }
        this$0.getReferralLink("ShareAll");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m1131onViewCreated$lambda1(ReferralInvitesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (LSApplication.Companion.getReferralLink() != null && !Intrinsics.areEqual(LSApplication.Companion.getReferralLink(), "")) {
            String referralLink = LSApplication.Companion.getReferralLink();
            Intrinsics.checkNotNull(referralLink);
            this$0.onShareReferralCodeWhatsAPPLinkClick(referralLink);
            return;
        }
        this$0.getReferralLink("Whatsapp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m1132onViewCreated$lambda2(ReferralInvitesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onClipReferralCodeClick();
    }

    private final void getReferralLink(final String str) {
        if (LSApplication.Companion.isNetworkAvailable()) {
            ReferAndEarnViewModel referAndEarnModel = getReferAndEarnModel();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            referAndEarnModel.getReferralLink(requireActivity).observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.referNearn.view.fragment.ReferralInvitesFragment$$ExternalSyntheticLambda5
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReferralInvitesFragment.m1127getReferralLink$lambda3(str, this, (ReferralLinkResponse) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getReferralLink$lambda-3  reason: not valid java name */
    public static final void m1127getReferralLink$lambda3(String action, ReferralInvitesFragment this$0, ReferralLinkResponse referralLinkResponse) {
        Intrinsics.checkNotNullParameter(action, "$action");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (LSApplication.Companion.getReferralLink() == null || Intrinsics.areEqual(LSApplication.Companion.getReferralLink(), "")) {
            return;
        }
        if (Intrinsics.areEqual(action, "Whatsapp")) {
            String referralLink = LSApplication.Companion.getReferralLink();
            Intrinsics.checkNotNull(referralLink);
            this$0.onShareReferralCodeWhatsAPPLinkClick(referralLink);
            return;
        }
        String referralLink2 = LSApplication.Companion.getReferralLink();
        Intrinsics.checkNotNull(referralLink2);
        this$0.onShareReferralCodeClick(referralLink2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
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

    public final void onClipReferralCodeClick() {
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("clipboard") : null;
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        User value = getReferAndEarnModel().getUser().getValue();
        clipboardManager.setPrimaryClip(ClipData.newPlainText(r2, String.valueOf(value != null ? value.getReferralCode() : null)));
        Toast.makeText(getActivity(), "Referral Code Copied", 0).show();
    }

    public final void onShareReferralCodeWhatsAPPLinkClick(String referralLink) {
        Intrinsics.checkNotNullParameter(referralLink, "referralLink");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(StringBody.CONTENT_TYPE);
        intent.setPackage("com.whatsapp");
        StringBuilder sb = new StringBuilder();
        sb.append("Refer & Earn\nGet instant ₹100 discount. Subscribe to Livpure Smart RO today.\nApply my code ");
        User value = getReferAndEarnModel().getUser().getValue();
        sb.append(value != null ? value.getReferralCode() : null);
        sb.append(" now and subscribe to pure drinking water at home.\nClick here to know more :- \n");
        sb.append(referralLink);
        intent.putExtra("android.intent.extra.TEXT", sb.toString());
        try {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity);
            activity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
        }
    }

    public final void onHowItsWorkButtonClicked() {
        final Dialog dialog = new Dialog(requireActivity());
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.custome_dialog_how_its_work);
        Window window = dialog.getWindow();
        Intrinsics.checkNotNull(window);
        window.setLayout(-1, -2);
        window.setGravity(80);
        Window window2 = dialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setBackgroundDrawable(new ColorDrawable(0));
        dialog.setCancelable(true);
        dialog.show();
        ((ImageView) dialog.findViewById(R.id.imageCancel)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.referNearn.view.fragment.ReferralInvitesFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReferralInvitesFragment.m1128onHowItsWorkButtonClicked$lambda5(dialog, view);
            }
        });
        ((TextView) dialog.findViewById(R.id.termsAndConditionsLabel)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.referNearn.view.fragment.ReferralInvitesFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReferralInvitesFragment.m1129onHowItsWorkButtonClicked$lambda6(dialog, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onHowItsWorkButtonClicked$lambda-5  reason: not valid java name */
    public static final void m1128onHowItsWorkButtonClicked$lambda5(Dialog dialoglog, View view) {
        Intrinsics.checkNotNullParameter(dialoglog, "$dialoglog");
        dialoglog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onHowItsWorkButtonClicked$lambda-6  reason: not valid java name */
    public static final void m1129onHowItsWorkButtonClicked$lambda6(Dialog dialoglog, ReferralInvitesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(dialoglog, "$dialoglog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialoglog.dismiss();
        ReferEarnFragmentDirections.ActionSelectReferAndEarnToTermsAndCondition actionSelectReferAndEarnToTermsAndCondition = ReferEarnFragmentDirections.actionSelectReferAndEarnToTermsAndCondition(R.string.terms_of_use);
        Intrinsics.checkNotNullExpressionValue(actionSelectReferAndEarnToTermsAndCondition, "actionSelectReferAndEarn…on(R.string.terms_of_use)");
        FragmentKt.findNavController(this$0).navigate(actionSelectReferAndEarnToTermsAndCondition);
    }
}

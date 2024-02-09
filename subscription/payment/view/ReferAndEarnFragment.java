package com.livpure.safedrink.subscription.payment.view;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.koushikdutta.async.http.body.StringBody;
import com.livpure.safedrink.R;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentReferEarnBinding;
import com.livpure.safedrink.subscription.payment.viewmodel.ReferAndEarnModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReferAndEarnFragment.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0006H\u0014J\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/view/ReferAndEarnFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentReferEarnBinding;", "()V", "fragmentReferEarnBinding", "referAndEarnModel", "Lcom/livpure/safedrink/subscription/payment/viewmodel/ReferAndEarnModel;", "getReferAndEarnModel", "()Lcom/livpure/safedrink/subscription/payment/viewmodel/ReferAndEarnModel;", "referAndEarnModel$delegate", "Lkotlin/Lazy;", "bindVariablesToView", "", "dataBinding", "getLayoutId", "", "getViewModel", "onHowItsWorkButtonClicked", "onShareReferralCodeClick", "onShareReferralCodeWhatsAPPLink", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferAndEarnFragment extends DataBindingFragment<FragmentReferEarnBinding> {
    private FragmentReferEarnBinding fragmentReferEarnBinding;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy referAndEarnModel$delegate = LazyKt.lazy(new Function0<ReferAndEarnModel>() { // from class: com.livpure.safedrink.subscription.payment.view.ReferAndEarnFragment$referAndEarnModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ReferAndEarnModel invoke() {
            return (ReferAndEarnModel) new ViewModelProvider(ReferAndEarnFragment.this).get(ReferAndEarnModel.class);
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
        return R.layout.fragment_refer_earn;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    private final ReferAndEarnModel getReferAndEarnModel() {
        return (ReferAndEarnModel) this.referAndEarnModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public ReferAndEarnModel getViewModel() {
        return getReferAndEarnModel();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentReferEarnBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        this.fragmentReferEarnBinding = dataBinding;
    }

    public final void onShareReferralCodeClick() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType(StringBody.CONTENT_TYPE);
        startActivity(Intent.createChooser(intent, null));
    }

    public final void onShareReferralCodeWhatsAPPLink() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(StringBody.CONTENT_TYPE);
        intent.setPackage("com.whatsapp");
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
        ((ImageView) dialog.findViewById(R.id.imageCancel)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.view.ReferAndEarnFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReferAndEarnFragment.m1348onHowItsWorkButtonClicked$lambda1(dialog, view);
            }
        });
        ((TextView) dialog.findViewById(R.id.termsAndConditionsLabel)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.view.ReferAndEarnFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReferAndEarnFragment.m1349onHowItsWorkButtonClicked$lambda2(dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onHowItsWorkButtonClicked$lambda-1  reason: not valid java name */
    public static final void m1348onHowItsWorkButtonClicked$lambda1(Dialog dialoglog, View view) {
        Intrinsics.checkNotNullParameter(dialoglog, "$dialoglog");
        dialoglog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onHowItsWorkButtonClicked$lambda-2  reason: not valid java name */
    public static final void m1349onHowItsWorkButtonClicked$lambda2(Dialog dialoglog, View view) {
        Intrinsics.checkNotNullParameter(dialoglog, "$dialoglog");
        dialoglog.dismiss();
    }
}

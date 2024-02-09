package com.livpure.safedrink.serviceRequest.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.common.arc.ui.viewmodels.AnalyticsViewModel;
import com.livpure.safedrink.common.arc.ui.views.DataBindingFragment;
import com.livpure.safedrink.databinding.FragmentTrackRelocationBinding;
import com.livpure.safedrink.serviceRequest.data.model.TrackOrderRes;
import com.livpure.safedrink.serviceRequest.model.TrackRelocationModel;
import com.livpure.safedrink.utils.AnimProgressBar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TrackRelocationFragment.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\u001a\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lcom/livpure/safedrink/serviceRequest/view/TrackRelocationFragment;", "Lcom/livpure/safedrink/common/arc/ui/views/DataBindingFragment;", "Lcom/livpure/safedrink/databinding/FragmentTrackRelocationBinding;", "()V", "animProgressBar", "Lcom/livpure/safedrink/utils/AnimProgressBar;", "getAnimProgressBar", "()Lcom/livpure/safedrink/utils/AnimProgressBar;", "setAnimProgressBar", "(Lcom/livpure/safedrink/utils/AnimProgressBar;)V", "trackRelocationModel", "Lcom/livpure/safedrink/serviceRequest/model/TrackRelocationModel;", "getTrackRelocationModel", "()Lcom/livpure/safedrink/serviceRequest/model/TrackRelocationModel;", "trackRelocationModel$delegate", "Lkotlin/Lazy;", "bindVariablesToView", "", "dataBinding", "getDateOrder", "", "dateStr", "getDateUser", "getLayoutId", "", "getViewModel", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TrackRelocationFragment extends DataBindingFragment<FragmentTrackRelocationBinding> {
    private AnimProgressBar animProgressBar;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy trackRelocationModel$delegate = LazyKt.lazy(new Function0<TrackRelocationModel>() { // from class: com.livpure.safedrink.serviceRequest.view.TrackRelocationFragment$trackRelocationModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TrackRelocationModel invoke() {
            return (TrackRelocationModel) new ViewModelProvider(TrackRelocationFragment.this).get(TrackRelocationModel.class);
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
        return R.layout.fragment_track_relocation;
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment, com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final AnimProgressBar getAnimProgressBar() {
        return this.animProgressBar;
    }

    public final void setAnimProgressBar(AnimProgressBar animProgressBar) {
        this.animProgressBar = animProgressBar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment
    public AnalyticsViewModel getViewModel() {
        return (AnalyticsViewModel) new ViewModelProvider(this).get(AnalyticsViewModel.class);
    }

    private final TrackRelocationModel getTrackRelocationModel() {
        return (TrackRelocationModel) this.trackRelocationModel$delegate.getValue();
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.DataBindingFragment
    public void bindVariablesToView(FragmentTrackRelocationBinding dataBinding) {
        Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
        dataBinding.setViewModel(getTrackRelocationModel());
    }

    @Override // com.livpure.safedrink.common.arc.ui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        AnimProgressBar animProgressBar = new AnimProgressBar(requireContext());
        this.animProgressBar = animProgressBar;
        animProgressBar.show();
        getTrackRelocationModel().trackOrder().observe(getViewLifecycleOwner(), new Observer() { // from class: com.livpure.safedrink.serviceRequest.view.TrackRelocationFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TrackRelocationFragment.m1265onViewCreated$lambda0(TrackRelocationFragment.this, (TrackOrderRes) obj);
            }
        });
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, this, false, new Function1<OnBackPressedCallback, Unit>() { // from class: com.livpure.safedrink.serviceRequest.view.TrackRelocationFragment$onViewCreated$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnBackPressedCallback addCallback) {
                Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OnBackPressedCallback onBackPressedCallback) {
                invoke2(onBackPressedCallback);
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0333 A[ORIG_RETURN, RETURN] */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1265onViewCreated$lambda0(com.livpure.safedrink.serviceRequest.view.TrackRelocationFragment r11, com.livpure.safedrink.serviceRequest.data.model.TrackOrderRes r12) {
        /*
            Method dump skipped, instructions count: 820
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.serviceRequest.view.TrackRelocationFragment.m1265onViewCreated$lambda0(com.livpure.safedrink.serviceRequest.view.TrackRelocationFragment, com.livpure.safedrink.serviceRequest.data.model.TrackOrderRes):void");
    }

    private final String getDateUser(String str) {
        Exception e;
        String str2;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm a, dd MMM yyyy");
            Date parse = simpleDateFormat.parse(str);
            Intrinsics.checkNotNull(parse);
            str2 = simpleDateFormat2.format(parse);
            Intrinsics.checkNotNullExpressionValue(str2, "output.format(d!!)");
        } catch (Exception e2) {
            e = e2;
            str2 = "";
        }
        try {
            Log.e("mDate", str2);
        } catch (Exception e3) {
            e = e3;
            Log.e("mDate", e.toString());
            return str2;
        }
        return str2;
    }

    private final String getDateOrder(String str) {
        Exception e;
        String str2;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm a, dd MMM yyyy");
            Date parse = simpleDateFormat.parse(str);
            Intrinsics.checkNotNull(parse);
            str2 = simpleDateFormat2.format(parse);
            Intrinsics.checkNotNullExpressionValue(str2, "output.format(d!!)");
        } catch (Exception e2) {
            e = e2;
            str2 = "";
        }
        try {
            Log.e("mDate", str2);
        } catch (Exception e3) {
            e = e3;
            Log.e("mDate", e.toString());
            return str2;
        }
        return str2;
    }
}

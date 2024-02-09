package com.livpure.safedrink.subscription.payment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.databinding.AdapterHolidayPlanLayoutBinding;
import com.livpure.safedrink.interfaces.MultiItemClickListener;
import com.livpure.safedrink.interfaces.RefreshPlanListListener;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HolidayPlanAdapter.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0001,B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0019\u001a\u00020\fH\u0016J\u001c\u0010\u001a\u001a\u00020\u001b2\n\u0010\u001c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\fH\u0016J2\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0016J\u001c\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\fH\u0016J\u0016\u0010)\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\fJ2\u0010*\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010+\u001a\u00020\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/adapter/HolidayPlanAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/livpure/safedrink/subscription/payment/adapter/HolidayPlanAdapter$ViewHolder;", "Lcom/livpure/safedrink/interfaces/MultiItemClickListener;", "mContext", "Landroid/content/Context;", "planList", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", "refreshPlanListListener", "Lcom/livpure/safedrink/interfaces/RefreshPlanListListener;", "(Landroid/content/Context;Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;Lcom/livpure/safedrink/interfaces/RefreshPlanListListener;)V", "childPosition", "", "inflater", "Landroid/view/LayoutInflater;", "itemClickListener", "getMContext", "()Landroid/content/Context;", "getRefreshPlanListListener", "()Lcom/livpure/safedrink/interfaces/RefreshPlanListListener;", "rowIndex", "getRowIndex", "()I", "setRowIndex", "(I)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onChildItemClick", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "parentPosition", "isHoliday", "", "isUnlimited", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onParentItemClick", "selectedPlanClickEvent", "setOnItemClickListener", "ViewHolder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HolidayPlanAdapter extends RecyclerView.Adapter<ViewHolder> implements MultiItemClickListener {
    private int childPosition;
    private LayoutInflater inflater;
    private MultiItemClickListener itemClickListener;
    private final Context mContext;
    private final PlansItem planList;
    private final RefreshPlanListListener refreshPlanListListener;
    private int rowIndex;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // com.livpure.safedrink.interfaces.MultiItemClickListener
    public void selectedPlanClickEvent(View view, int i, int i2, boolean z, boolean z2) {
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final RefreshPlanListListener getRefreshPlanListListener() {
        return this.refreshPlanListListener;
    }

    public HolidayPlanAdapter(Context mContext, PlansItem planList, RefreshPlanListListener refreshPlanListListener) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(planList, "planList");
        Intrinsics.checkNotNullParameter(refreshPlanListListener, "refreshPlanListListener");
        this.mContext = mContext;
        this.planList = planList;
        this.refreshPlanListListener = refreshPlanListListener;
        this.rowIndex = -1;
        Object systemService = mContext.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.inflater = (LayoutInflater) systemService;
    }

    public final int getRowIndex() {
        return this.rowIndex;
    }

    public final void setRowIndex(int i) {
        this.rowIndex = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflater = this.inflater;
        Intrinsics.checkNotNull(layoutInflater);
        ViewDataBinding bind = DataBindingUtil.bind(layoutInflater.inflate(R.layout.adapter_holiday_plan_layout, parent, false));
        Intrinsics.checkNotNull(bind);
        return new ViewHolder(this, (AdapterHolidayPlanLayoutBinding) bind);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
        if ((r0.length() > 0) == true) goto L7;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(com.livpure.safedrink.subscription.payment.adapter.HolidayPlanAdapter.ViewHolder r11, final int r12) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.subscription.payment.adapter.HolidayPlanAdapter.onBindViewHolder(com.livpure.safedrink.subscription.payment.adapter.HolidayPlanAdapter$ViewHolder, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m1320onBindViewHolder$lambda1(HolidayPlanAdapter this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MultiItemClickListener multiItemClickListener = this$0.itemClickListener;
        if (multiItemClickListener != null) {
            multiItemClickListener.onChildItemClick(view, i, this$0.childPosition, true, false);
        }
    }

    /* compiled from: HolidayPlanAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/adapter/HolidayPlanAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/livpure/safedrink/databinding/AdapterHolidayPlanLayoutBinding;", "(Lcom/livpure/safedrink/subscription/payment/adapter/HolidayPlanAdapter;Lcom/livpure/safedrink/databinding/AdapterHolidayPlanLayoutBinding;)V", "getBinding", "()Lcom/livpure/safedrink/databinding/AdapterHolidayPlanLayoutBinding;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterHolidayPlanLayoutBinding binding;
        final /* synthetic */ HolidayPlanAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(HolidayPlanAdapter holidayPlanAdapter, AdapterHolidayPlanLayoutBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = holidayPlanAdapter;
            this.binding = binding;
            binding.executePendingBindings();
        }

        public final AdapterHolidayPlanLayoutBinding getBinding() {
            return this.binding;
        }
    }

    public final void setOnItemClickListener(MultiItemClickListener multiItemClickListener) {
        this.itemClickListener = multiItemClickListener;
    }

    public final void onParentItemClick(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.refreshPlanListListener.onClick(true, false, false);
        this.rowIndex = i;
        notifyDataSetChanged();
    }

    @Override // com.livpure.safedrink.interfaces.MultiItemClickListener
    public void onChildItemClick(View view, int i, int i2, boolean z, boolean z2) {
        this.childPosition = i2;
    }
}

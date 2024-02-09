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
import com.livpure.safedrink.databinding.AdapterUnlimitedPlanLayoutBinding;
import com.livpure.safedrink.interfaces.MultiItemClickListener;
import com.livpure.safedrink.interfaces.RefreshPlanListListener;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UnlimitedPlanAdapter.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0001.B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001b\u001a\u00020\rH\u0016J\u001c\u0010\u001c\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0016J2\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J\u001c\u0010'\u001a\u00060\u0002R\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\rH\u0016J\u0016\u0010+\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\rJ2\u0010,\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010-\u001a\u00020\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006/"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/adapter/UnlimitedPlanAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/livpure/safedrink/subscription/payment/adapter/UnlimitedPlanAdapter$ViewHolder;", "Lcom/livpure/safedrink/interfaces/MultiItemClickListener;", "mContext", "Landroid/content/Context;", "planList", "", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", "refreshPlanListListener", "Lcom/livpure/safedrink/interfaces/RefreshPlanListListener;", "(Landroid/content/Context;Ljava/util/List;Lcom/livpure/safedrink/interfaces/RefreshPlanListListener;)V", "childPosition", "", "inflater", "Landroid/view/LayoutInflater;", "itemClickListener", "getMContext", "()Landroid/content/Context;", "planResult", "getRefreshPlanListListener", "()Lcom/livpure/safedrink/interfaces/RefreshPlanListListener;", "rowIndex", "getRowIndex", "()I", "setRowIndex", "(I)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onChildItemClick", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "parentPosition", "isHoliday", "", "isUnlimited", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onParentItemClick", "selectedPlanClickEvent", "setOnItemClickListener", "ViewHolder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnlimitedPlanAdapter extends RecyclerView.Adapter<ViewHolder> implements MultiItemClickListener {
    private int childPosition;
    private LayoutInflater inflater;
    private MultiItemClickListener itemClickListener;
    private final Context mContext;
    private final List<PlansItem> planList;
    private PlansItem planResult;
    private final RefreshPlanListListener refreshPlanListListener;
    private int rowIndex;

    @Override // com.livpure.safedrink.interfaces.MultiItemClickListener
    public void selectedPlanClickEvent(View view, int i, int i2, boolean z, boolean z2) {
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final RefreshPlanListListener getRefreshPlanListListener() {
        return this.refreshPlanListListener;
    }

    public UnlimitedPlanAdapter(Context mContext, List<PlansItem> planList, RefreshPlanListListener refreshPlanListListener) {
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
        ViewDataBinding bind = DataBindingUtil.bind(layoutInflater.inflate(R.layout.adapter_unlimited_plan_layout, parent, false));
        Intrinsics.checkNotNull(bind);
        return new ViewHolder(this, (AdapterUnlimitedPlanLayoutBinding) bind);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.planList.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0078, code lost:
        if ((r0.length() > 0) == true) goto L19;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(com.livpure.safedrink.subscription.payment.adapter.UnlimitedPlanAdapter.ViewHolder r13, final int r14) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.subscription.payment.adapter.UnlimitedPlanAdapter.onBindViewHolder(com.livpure.safedrink.subscription.payment.adapter.UnlimitedPlanAdapter$ViewHolder, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m1330onBindViewHolder$lambda1(UnlimitedPlanAdapter this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MultiItemClickListener multiItemClickListener = this$0.itemClickListener;
        if (multiItemClickListener != null) {
            multiItemClickListener.onChildItemClick(view, i, this$0.childPosition, false, true);
        }
    }

    /* compiled from: UnlimitedPlanAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/adapter/UnlimitedPlanAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/livpure/safedrink/databinding/AdapterUnlimitedPlanLayoutBinding;", "(Lcom/livpure/safedrink/subscription/payment/adapter/UnlimitedPlanAdapter;Lcom/livpure/safedrink/databinding/AdapterUnlimitedPlanLayoutBinding;)V", "getBinding", "()Lcom/livpure/safedrink/databinding/AdapterUnlimitedPlanLayoutBinding;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterUnlimitedPlanLayoutBinding binding;
        final /* synthetic */ UnlimitedPlanAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(UnlimitedPlanAdapter unlimitedPlanAdapter, AdapterUnlimitedPlanLayoutBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = unlimitedPlanAdapter;
            this.binding = binding;
            binding.executePendingBindings();
        }

        public final AdapterUnlimitedPlanLayoutBinding getBinding() {
            return this.binding;
        }
    }

    public final void setOnItemClickListener(MultiItemClickListener multiItemClickListener) {
        this.itemClickListener = multiItemClickListener;
    }

    public final void onParentItemClick(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.refreshPlanListListener.onClick(false, true, false);
        this.rowIndex = i;
        notifyDataSetChanged();
    }

    @Override // com.livpure.safedrink.interfaces.MultiItemClickListener
    public void onChildItemClick(View view, int i, int i2, boolean z, boolean z2) {
        this.childPosition = i2;
    }
}

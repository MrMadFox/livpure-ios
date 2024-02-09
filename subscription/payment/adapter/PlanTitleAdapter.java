package com.livpure.safedrink.subscription.payment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.databinding.PlanPagerTitleLayoutBinding;
import com.livpure.safedrink.interfaces.ItemClickListener;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlanTitleAdapter.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0010R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/adapter/PlanTitleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/livpure/safedrink/subscription/payment/adapter/PlanTitleAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "paymentList", "", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", "(Landroid/content/Context;Ljava/util/List;)V", "inflater", "Landroid/view/LayoutInflater;", "itemClickListener", "Lcom/livpure/safedrink/interfaces/ItemClickListener;", "getMContext", "()Landroid/content/Context;", "rowIndex", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onItemClickListeners", "selectedItem", "ViewHolder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PlanTitleAdapter extends RecyclerView.Adapter<ViewHolder> {
    private LayoutInflater inflater;
    private ItemClickListener itemClickListener;
    private final Context mContext;
    private final List<PlansItem> paymentList;
    private int rowIndex;

    public PlanTitleAdapter(Context mContext, List<PlansItem> paymentList) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(paymentList, "paymentList");
        this.mContext = mContext;
        this.paymentList = paymentList;
        Object systemService = mContext.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.inflater = (LayoutInflater) systemService;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflater = this.inflater;
        Intrinsics.checkNotNull(layoutInflater);
        ViewDataBinding bind = DataBindingUtil.bind(layoutInflater.inflate(R.layout.plan_pager_title_layout, parent, false));
        Intrinsics.checkNotNull(bind);
        return new ViewHolder(this, (PlanPagerTitleLayoutBinding) bind);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.paymentList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PlansItem plansItem = this.paymentList.get(i);
        holder.getBinding().setPlanTitle(plansItem != null ? plansItem.getPlanName() : null);
        holder.getBinding().cardTitleId.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.adapter.PlanTitleAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlanTitleAdapter.m1326onBindViewHolder$lambda0(PlanTitleAdapter.this, i, view);
            }
        });
        if (this.rowIndex == i) {
            holder.getBinding().cardTitleId.setBackgroundResource(R.drawable.chosen_plan_bg);
            holder.getBinding().imgTriangleId.setVisibility(0);
            holder.getBinding().txtPlanTitleId.setTextColor(ResourcesCompat.getColor(this.mContext.getResources(), R.color.colorWhite, null));
        } else {
            holder.getBinding().cardTitleId.setBackgroundResource(R.drawable.default_plan_bg);
            holder.getBinding().imgTriangleId.setVisibility(8);
            holder.getBinding().txtPlanTitleId.setTextColor(ResourcesCompat.getColor(this.mContext.getResources(), R.color.colorBlack20, null));
        }
        holder.getBinding().executePendingBindings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m1326onBindViewHolder$lambda0(PlanTitleAdapter this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.rowIndex = i;
        ItemClickListener itemClickListener = this$0.itemClickListener;
        if (itemClickListener != null) {
            itemClickListener.onItemClick(view, i);
        }
        this$0.notifyDataSetChanged();
    }

    public final void onItemClickListeners(ItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
    }

    public final void selectedItem(int i) {
        this.rowIndex = i;
        notifyDataSetChanged();
    }

    /* compiled from: PlanTitleAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/adapter/PlanTitleAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/livpure/safedrink/databinding/PlanPagerTitleLayoutBinding;", "(Lcom/livpure/safedrink/subscription/payment/adapter/PlanTitleAdapter;Lcom/livpure/safedrink/databinding/PlanPagerTitleLayoutBinding;)V", "getBinding", "()Lcom/livpure/safedrink/databinding/PlanPagerTitleLayoutBinding;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final PlanPagerTitleLayoutBinding binding;
        final /* synthetic */ PlanTitleAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(PlanTitleAdapter planTitleAdapter, PlanPagerTitleLayoutBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = planTitleAdapter;
            this.binding = binding;
        }

        public final PlanPagerTitleLayoutBinding getBinding() {
            return this.binding;
        }
    }
}

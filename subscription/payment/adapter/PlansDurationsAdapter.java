package com.livpure.safedrink.subscription.payment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.databinding.AdapterPlansDurationsLayoutBinding;
import com.livpure.safedrink.interfaces.ItemClickListener;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlansDurationsAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\tH\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/adapter/PlansDurationsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/livpure/safedrink/subscription/payment/adapter/PlansDurationsAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "itemList", "", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PriceItem;", "perMonthPrice", "", "(Landroid/content/Context;Ljava/util/List;I)V", "itemClickListener", "Lcom/livpure/safedrink/interfaces/ItemClickListener;", "layoutInflater", "Landroid/view/LayoutInflater;", "getMContext", "()Landroid/content/Context;", "rowIndex", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "ViewHolder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PlansDurationsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ItemClickListener itemClickListener;
    private final List<PriceItem> itemList;
    private final LayoutInflater layoutInflater;
    private final Context mContext;
    private final int perMonthPrice;
    private int rowIndex;

    public final Context getMContext() {
        return this.mContext;
    }

    public PlansDurationsAdapter(Context mContext, List<PriceItem> itemList, int i) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        this.mContext = mContext;
        this.itemList = itemList;
        this.perMonthPrice = i;
        Object systemService = mContext.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.layoutInflater = (LayoutInflater) systemService;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding bind = DataBindingUtil.bind(this.layoutInflater.inflate(R.layout.adapter_plans_durations_layout, parent, false));
        Intrinsics.checkNotNull(bind);
        return new ViewHolder(this, (AdapterPlansDurationsLayoutBinding) bind);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PriceItem priceItem = this.itemList.get(i);
        holder.getPlanBinding().setDuration(priceItem);
        holder.getPlanBinding().setPosition(Integer.valueOf(i));
        holder.getPlanBinding().setCallBack(this);
        AppCompatTextView appCompatTextView = holder.getPlanBinding().textRsPlan;
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getResources().getString(R.string.Rs));
        sb.append(SafeJsonPrimitive.NULL_CHAR);
        sb.append(priceItem != null ? priceItem.getPricePerMonth() : null);
        appCompatTextView.setText(sb.toString());
        AppCompatTextView appCompatTextView2 = holder.getPlanBinding().textTotalMonth;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(priceItem != null ? priceItem.getDuration() : null);
        sb2.append(SafeJsonPrimitive.NULL_CHAR);
        sb2.append(this.mContext.getResources().getString(R.string.months));
        appCompatTextView2.setText(sb2.toString());
        AppCompatTextView appCompatTextView3 = holder.getPlanBinding().textDiscount;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.mContext.getResources().getString(R.string.Rs));
        sb3.append(SafeJsonPrimitive.NULL_CHAR);
        sb3.append(Integer.parseInt(priceItem != null ? priceItem.getDuration() : null) * this.perMonthPrice);
        appCompatTextView3.setText(sb3.toString());
        holder.getPlanBinding().textDiscount.setPaintFlags(holder.getPlanBinding().textDiscount.getPaintFlags() | 16);
        AppCompatTextView appCompatTextView4 = holder.getPlanBinding().textAmountRs;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.mContext.getResources().getString(R.string.Rs));
        sb4.append(SafeJsonPrimitive.NULL_CHAR);
        sb4.append(priceItem != null ? priceItem.getPrice() : null);
        appCompatTextView4.setText(sb4.toString());
        holder.getPlanBinding().textSaveAmount.setText(priceItem != null ? priceItem.getSaveMessage() : null);
        holder.getPlanBinding().lytValidityId.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.adapter.PlansDurationsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlansDurationsAdapter.m1328onBindViewHolder$lambda0(PlansDurationsAdapter.this, i, view);
            }
        });
        if (Intrinsics.areEqual(priceItem != null ? priceItem.getDuration() : null, "1")) {
            holder.getPlanBinding().viewPlan.setVisibility(8);
            holder.getPlanBinding().lytSimpleItem.setVisibility(8);
            AppCompatTextView appCompatTextView5 = holder.getPlanBinding().textMonth;
            appCompatTextView5.setText(" / " + this.mContext.getResources().getString(R.string.days));
        }
        if (this.rowIndex == i) {
            holder.getPlanBinding().lytValidityId.setBackgroundResource(R.drawable.border_raise_service_request);
            holder.getPlanBinding().radioPlanId.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.selected));
            holder.getPlanBinding().textRsPlan.setTextColor(this.mContext.getResources().getColor(R.color.colorWhite));
            holder.getPlanBinding().textMonth.setTextColor(this.mContext.getResources().getColor(R.color.colorWhite));
            holder.getPlanBinding().viewPlan.setBackgroundResource(R.drawable.view_plan);
            holder.getPlanBinding().textValidity.setTextColor(this.mContext.getResources().getColor(R.color.color_f0ebfe));
            holder.getPlanBinding().textTotalAmount.setTextColor(this.mContext.getResources().getColor(R.color.color_f0ebfe));
            holder.getPlanBinding().textAmountRs.setTextColor(this.mContext.getResources().getColor(R.color.colorWhite));
            holder.getPlanBinding().textTotalMonth.setTextColor(this.mContext.getResources().getColor(R.color.colorWhite));
            holder.getPlanBinding().textDiscount.setTextColor(this.mContext.getResources().getColor(R.color.colorWhite));
            holder.getPlanBinding().viewDivide.setBackgroundResource(R.drawable.view_plan);
            return;
        }
        holder.getPlanBinding().lytValidityId.setBackgroundResource(R.drawable.plan_unselected);
        holder.getPlanBinding().radioPlanId.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.oval));
        holder.getPlanBinding().textRsPlan.setTextColor(this.mContext.getResources().getColor(R.color.color_193357));
        holder.getPlanBinding().textMonth.setTextColor(this.mContext.getResources().getColor(R.color.color_193357));
        holder.getPlanBinding().viewPlan.setBackgroundResource(R.drawable.view_plan_unselected);
        holder.getPlanBinding().textValidity.setTextColor(this.mContext.getResources().getColor(R.color.color9));
        holder.getPlanBinding().textTotalAmount.setTextColor(this.mContext.getResources().getColor(R.color.color9));
        holder.getPlanBinding().textAmountRs.setTextColor(this.mContext.getResources().getColor(R.color.color_193357));
        holder.getPlanBinding().textTotalMonth.setTextColor(this.mContext.getResources().getColor(R.color.color_193357));
        holder.getPlanBinding().textDiscount.setTextColor(this.mContext.getResources().getColor(R.color.color_193357));
        holder.getPlanBinding().viewDivide.setBackgroundResource(R.drawable.view_plan_unselected);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m1328onBindViewHolder$lambda0(PlansDurationsAdapter this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notifyDataSetChanged();
        ItemClickListener itemClickListener = this$0.itemClickListener;
        if (itemClickListener != null) {
            itemClickListener.onItemClick(view, i);
        }
        this$0.rowIndex = i;
    }

    public final void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    /* compiled from: PlansDurationsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/adapter/PlansDurationsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "planBinding", "Lcom/livpure/safedrink/databinding/AdapterPlansDurationsLayoutBinding;", "(Lcom/livpure/safedrink/subscription/payment/adapter/PlansDurationsAdapter;Lcom/livpure/safedrink/databinding/AdapterPlansDurationsLayoutBinding;)V", "getPlanBinding", "()Lcom/livpure/safedrink/databinding/AdapterPlansDurationsLayoutBinding;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterPlansDurationsLayoutBinding planBinding;
        final /* synthetic */ PlansDurationsAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(PlansDurationsAdapter plansDurationsAdapter, AdapterPlansDurationsLayoutBinding planBinding) {
            super(planBinding.getRoot());
            Intrinsics.checkNotNullParameter(planBinding, "planBinding");
            this.this$0 = plansDurationsAdapter;
            this.planBinding = planBinding;
            planBinding.executePendingBindings();
        }

        public final AdapterPlansDurationsLayoutBinding getPlanBinding() {
            return this.planBinding;
        }
    }
}

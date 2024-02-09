package com.livpure.safedrink.subscription.payment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.databinding.AdapterPlanLayoutBinding;
import com.livpure.safedrink.interfaces.ItemClickListener;
import com.livpure.safedrink.subscription.plan.data.model.payment.PlanItem;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlanAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\tH\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0002R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/adapter/PlanAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/livpure/safedrink/subscription/payment/adapter/PlanAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "validityList", "", "Lcom/livpure/safedrink/subscription/plan/data/model/payment/PlanItem;", "rowIndex", "", "(Landroid/content/Context;Ljava/util/List;I)V", "itemClickListener", "Lcom/livpure/safedrink/interfaces/ItemClickListener;", "layoutInflater", "Landroid/view/LayoutInflater;", "getMContext", "()Landroid/content/Context;", "viewHolder", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "ViewHolder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PlanAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ItemClickListener itemClickListener;
    private final LayoutInflater layoutInflater;
    private final Context mContext;
    private int rowIndex;
    private final List<PlanItem> validityList;
    private ViewHolder viewHolder;

    public PlanAdapter(Context mContext, List<PlanItem> validityList, int i) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(validityList, "validityList");
        this.mContext = mContext;
        this.validityList = validityList;
        this.rowIndex = i;
        Object systemService = mContext.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.layoutInflater = (LayoutInflater) systemService;
    }

    public /* synthetic */ PlanAdapter(Context context, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, list, (i2 & 4) != 0 ? -1 : i);
    }

    public final Context getMContext() {
        return this.mContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(this.layoutInflater, R.layout.adapter_plan_layout, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, …an_layout, parent, false)");
        ViewHolder viewHolder = new ViewHolder(this, (AdapterPlanLayoutBinding) inflate);
        this.viewHolder = viewHolder;
        Objects.requireNonNull(viewHolder, "null cannot be cast to non-null type com.livpure.safedrink.subscription.payment.adapter.PlanAdapter.ViewHolder");
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int i) {
        RadioButton radioButton;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        PlanItem planItem = this.validityList.get(i);
        AdapterPlanLayoutBinding planBinding = holder.getPlanBinding();
        if (planBinding != null) {
            planBinding.setPlan(planItem);
        }
        AdapterPlanLayoutBinding planBinding2 = holder.getPlanBinding();
        if (planBinding2 != null) {
            planBinding2.setPosition(Integer.valueOf(i));
        }
        AdapterPlanLayoutBinding planBinding3 = holder.getPlanBinding();
        if (planBinding3 != null) {
            planBinding3.setCallBack(this);
        }
        AdapterPlanLayoutBinding planBinding4 = holder.getPlanBinding();
        if (planBinding4 != null && (linearLayout3 = planBinding4.lytValidityId) != null) {
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.adapter.PlanAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlanAdapter.m1321onBindViewHolder$lambda0(PlanAdapter.this, i, view);
                }
            });
        }
        if (this.rowIndex == i) {
            AdapterPlanLayoutBinding planBinding5 = holder.getPlanBinding();
            if (planBinding5 != null && (linearLayout2 = planBinding5.lytValidityId) != null) {
                linearLayout2.setBackgroundResource(R.drawable.borders_upgrade);
            }
            AdapterPlanLayoutBinding planBinding6 = holder.getPlanBinding();
            radioButton = planBinding6 != null ? planBinding6.radioPlanId : null;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
        } else {
            AdapterPlanLayoutBinding planBinding7 = holder.getPlanBinding();
            if (planBinding7 != null && (linearLayout = planBinding7.lytValidityId) != null) {
                linearLayout.setBackgroundResource(R.drawable.default_plan_bg);
            }
            AdapterPlanLayoutBinding planBinding8 = holder.getPlanBinding();
            radioButton = planBinding8 != null ? planBinding8.radioPlanId : null;
            if (radioButton != null) {
                radioButton.setChecked(false);
            }
        }
        AdapterPlanLayoutBinding planBinding9 = holder.getPlanBinding();
        if (planBinding9 != null) {
            planBinding9.executePendingBindings();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m1321onBindViewHolder$lambda0(PlanAdapter this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.rowIndex = i;
        this$0.notifyDataSetChanged();
        ItemClickListener itemClickListener = this$0.itemClickListener;
        if (itemClickListener != null) {
            itemClickListener.onItemClick(view, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.validityList.size();
    }

    public final void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    /* compiled from: PlanAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/adapter/PlanAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "planBinding", "Lcom/livpure/safedrink/databinding/AdapterPlanLayoutBinding;", "(Lcom/livpure/safedrink/subscription/payment/adapter/PlanAdapter;Lcom/livpure/safedrink/databinding/AdapterPlanLayoutBinding;)V", "getPlanBinding", "()Lcom/livpure/safedrink/databinding/AdapterPlanLayoutBinding;", "setPlanBinding", "(Lcom/livpure/safedrink/databinding/AdapterPlanLayoutBinding;)V", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private AdapterPlanLayoutBinding planBinding;
        final /* synthetic */ PlanAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(PlanAdapter planAdapter, AdapterPlanLayoutBinding planBinding) {
            super(planBinding.getRoot());
            Intrinsics.checkNotNullParameter(planBinding, "planBinding");
            this.this$0 = planAdapter;
            this.planBinding = planBinding;
        }

        public final AdapterPlanLayoutBinding getPlanBinding() {
            return this.planBinding;
        }

        public final void setPlanBinding(AdapterPlanLayoutBinding adapterPlanLayoutBinding) {
            this.planBinding = adapterPlanLayoutBinding;
        }
    }
}

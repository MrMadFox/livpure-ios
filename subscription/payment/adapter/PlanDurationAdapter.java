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
import com.livpure.safedrink.databinding.AdapterPlanDurationLayoutBinding;
import com.livpure.safedrink.interfaces.ItemClickListener;
import com.livpure.safedrink.subscription.payment.viewmodel.PlanDurationModel;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlanDurationAdapter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001 B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0016\u001a\u00020\tH\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\tH\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0018\u00010\u0002R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/adapter/PlanDurationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/livpure/safedrink/subscription/payment/adapter/PlanDurationAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "itemList", "", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PriceItem;", "rowIndex", "", "planDurationModel", "Lcom/livpure/safedrink/subscription/payment/viewmodel/PlanDurationModel;", "(Landroid/content/Context;Ljava/util/List;ILcom/livpure/safedrink/subscription/payment/viewmodel/PlanDurationModel;)V", "itemClickListener", "Lcom/livpure/safedrink/interfaces/ItemClickListener;", "layoutInflater", "Landroid/view/LayoutInflater;", "getMContext", "()Landroid/content/Context;", "getPlanDurationModel", "()Lcom/livpure/safedrink/subscription/payment/viewmodel/PlanDurationModel;", "viewHolder", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "ViewHolder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PlanDurationAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ItemClickListener itemClickListener;
    private final List<PriceItem> itemList;
    private final LayoutInflater layoutInflater;
    private final Context mContext;
    private final PlanDurationModel planDurationModel;
    private int rowIndex;
    private ViewHolder viewHolder;

    public /* synthetic */ PlanDurationAdapter(Context context, List list, int i, PlanDurationModel planDurationModel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, list, (i2 & 4) != 0 ? -1 : i, planDurationModel);
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public PlanDurationAdapter(Context mContext, List<PriceItem> itemList, int i, PlanDurationModel planDurationModel) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        Intrinsics.checkNotNullParameter(planDurationModel, "planDurationModel");
        this.mContext = mContext;
        this.itemList = itemList;
        this.rowIndex = i;
        this.planDurationModel = planDurationModel;
        Object systemService = mContext.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.layoutInflater = (LayoutInflater) systemService;
    }

    public final PlanDurationModel getPlanDurationModel() {
        return this.planDurationModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(this.layoutInflater, R.layout.adapter_plan_duration_layout, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, …on_layout, parent, false)");
        ViewHolder viewHolder = new ViewHolder(this, (AdapterPlanDurationLayoutBinding) inflate);
        this.viewHolder = viewHolder;
        Objects.requireNonNull(viewHolder, "null cannot be cast to non-null type com.livpure.safedrink.subscription.payment.adapter.PlanDurationAdapter.ViewHolder");
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int i) {
        RadioButton radioButton;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<PriceItem> list = this.itemList;
        PriceItem priceItem = list.get(list.size() - (i + 1));
        AdapterPlanDurationLayoutBinding planBinding = holder.getPlanBinding();
        if (planBinding != null) {
            planBinding.setDuration(priceItem);
        }
        AdapterPlanDurationLayoutBinding planBinding2 = holder.getPlanBinding();
        if (planBinding2 != null) {
            planBinding2.setPosition(Integer.valueOf(i));
        }
        AdapterPlanDurationLayoutBinding planBinding3 = holder.getPlanBinding();
        if (planBinding3 != null) {
            planBinding3.setCallBack(this);
        }
        AdapterPlanDurationLayoutBinding planBinding4 = holder.getPlanBinding();
        if (planBinding4 != null) {
            planBinding4.setViewModel(this.planDurationModel);
        }
        AdapterPlanDurationLayoutBinding planBinding5 = holder.getPlanBinding();
        if (planBinding5 != null && (linearLayout3 = planBinding5.lytValidityId) != null) {
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.adapter.PlanDurationAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlanDurationAdapter.m1323onBindViewHolder$lambda0(PlanDurationAdapter.this, i, view);
                }
            });
        }
        if (this.rowIndex == i) {
            AdapterPlanDurationLayoutBinding planBinding6 = holder.getPlanBinding();
            if (planBinding6 != null && (linearLayout2 = planBinding6.lytValidityId) != null) {
                linearLayout2.setBackgroundResource(R.drawable.borders_upgrade);
            }
            AdapterPlanDurationLayoutBinding planBinding7 = holder.getPlanBinding();
            radioButton = planBinding7 != null ? planBinding7.radioPlanId : null;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
        } else {
            AdapterPlanDurationLayoutBinding planBinding8 = holder.getPlanBinding();
            if (planBinding8 != null && (linearLayout = planBinding8.lytValidityId) != null) {
                linearLayout.setBackgroundResource(R.drawable.default_plan_bg);
            }
            AdapterPlanDurationLayoutBinding planBinding9 = holder.getPlanBinding();
            radioButton = planBinding9 != null ? planBinding9.radioPlanId : null;
            if (radioButton != null) {
                radioButton.setChecked(false);
            }
        }
        AdapterPlanDurationLayoutBinding planBinding10 = holder.getPlanBinding();
        if (planBinding10 != null) {
            planBinding10.executePendingBindings();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m1323onBindViewHolder$lambda0(PlanDurationAdapter this$0, int i, View view) {
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
        return this.itemList.size();
    }

    public final void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    /* compiled from: PlanDurationAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/adapter/PlanDurationAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "planBinding", "Lcom/livpure/safedrink/databinding/AdapterPlanDurationLayoutBinding;", "(Lcom/livpure/safedrink/subscription/payment/adapter/PlanDurationAdapter;Lcom/livpure/safedrink/databinding/AdapterPlanDurationLayoutBinding;)V", "getPlanBinding", "()Lcom/livpure/safedrink/databinding/AdapterPlanDurationLayoutBinding;", "setPlanBinding", "(Lcom/livpure/safedrink/databinding/AdapterPlanDurationLayoutBinding;)V", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private AdapterPlanDurationLayoutBinding planBinding;
        final /* synthetic */ PlanDurationAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(PlanDurationAdapter planDurationAdapter, AdapterPlanDurationLayoutBinding planBinding) {
            super(planBinding.getRoot());
            Intrinsics.checkNotNullParameter(planBinding, "planBinding");
            this.this$0 = planDurationAdapter;
            this.planBinding = planBinding;
        }

        public final AdapterPlanDurationLayoutBinding getPlanBinding() {
            return this.planBinding;
        }

        public final void setPlanBinding(AdapterPlanDurationLayoutBinding adapterPlanDurationLayoutBinding) {
            this.planBinding = adapterPlanDurationLayoutBinding;
        }
    }
}

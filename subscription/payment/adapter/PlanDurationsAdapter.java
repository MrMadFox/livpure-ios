package com.livpure.safedrink.subscription.payment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.databinding.AdapterPlanDurationsLayoutBinding;
import com.livpure.safedrink.interfaces.ItemClickListener;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: PlanDurationsAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001#B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJD\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\tH\u0016J\u001c\u0010\u001c\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\tH\u0016J\u001c\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\tH\u0016J\u0010\u0010\"\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0002R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/adapter/PlanDurationsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/livpure/safedrink/subscription/payment/adapter/PlanDurationsAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "itemList", "", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PriceItem;", "rowIndex", "", "(Landroid/content/Context;Ljava/util/List;I)V", "itemClickListener", "Lcom/livpure/safedrink/interfaces/ItemClickListener;", "layoutInflater", "Landroid/view/LayoutInflater;", "getMContext", "()Landroid/content/Context;", "viewHolder", "changeViewProperty", "", "holder", "bgColor", "textDurationColor", "textAmountColor", "textMonthColor", "imgCheckResource", "saveBackground", "getItemCount", "onBindViewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "ViewHolder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PlanDurationsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ItemClickListener itemClickListener;
    private final List<PriceItem> itemList;
    private final LayoutInflater layoutInflater;
    private final Context mContext;
    private int rowIndex;
    private ViewHolder viewHolder;

    public /* synthetic */ PlanDurationsAdapter(Context context, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, list, (i2 & 4) != 0 ? 0 : i);
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public PlanDurationsAdapter(Context mContext, List<PriceItem> itemList, int i) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        this.mContext = mContext;
        this.itemList = itemList;
        this.rowIndex = i;
        Object systemService = mContext.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.layoutInflater = (LayoutInflater) systemService;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(this.layoutInflater, R.layout.adapter_plan_durations_layout, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, …ns_layout, parent, false)");
        ViewHolder viewHolder = new ViewHolder(this, (AdapterPlanDurationsLayoutBinding) inflate);
        this.viewHolder = viewHolder;
        Objects.requireNonNull(viewHolder, "null cannot be cast to non-null type com.livpure.safedrink.subscription.payment.adapter.PlanDurationsAdapter.ViewHolder");
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int i) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(holder, "holder");
        PriceItem priceItem = this.itemList.get(i);
        AdapterPlanDurationsLayoutBinding planBinding = holder.getPlanBinding();
        if (planBinding != null) {
            planBinding.setDuration(priceItem);
        }
        AdapterPlanDurationsLayoutBinding planBinding2 = holder.getPlanBinding();
        if (planBinding2 != null) {
            planBinding2.setPosition(Integer.valueOf(i));
        }
        AdapterPlanDurationsLayoutBinding planBinding3 = holder.getPlanBinding();
        if (planBinding3 != null) {
            planBinding3.setCallBack(this);
        }
        AdapterPlanDurationsLayoutBinding planBinding4 = holder.getPlanBinding();
        if (planBinding4 != null && (linearLayout = planBinding4.lytValidityId) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.adapter.PlanDurationsAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlanDurationsAdapter.m1325onBindViewHolder$lambda0(PlanDurationsAdapter.this, i, view);
                }
            });
        }
        AdapterPlanDurationsLayoutBinding planBinding5 = holder.getPlanBinding();
        TextView textView = planBinding5 != null ? planBinding5.txtBestValueId : null;
        if (textView != null) {
            textView.setVisibility(StringsKt.equals$default(priceItem != null ? priceItem.getDuration() : null, "12", false, 2, null) ? 0 : 8);
        }
        String saveMessage = priceItem != null ? priceItem.getSaveMessage() : null;
        boolean areEqual = Intrinsics.areEqual(StringsKt.replace$default("No Saving", " ", "", false, 4, (Object) null), saveMessage != null ? StringsKt.replace$default(saveMessage, " ", "", false, 4, (Object) null) : null);
        AdapterPlanDurationsLayoutBinding planBinding6 = holder.getPlanBinding();
        AppCompatTextView appCompatTextView = planBinding6 != null ? planBinding6.txtSaving : null;
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(areEqual ? 4 : 0);
        }
        if (this.rowIndex == i) {
            changeViewProperty(holder, R.drawable.border_popular, R.color.colorWhite, R.color.colorWhite, R.color.colorWhite, R.drawable.ic_mdi_check_circle, R.drawable.save_selected_rounded);
        } else {
            changeViewProperty(holder, R.drawable.default_plan_bg, R.color.color4, R.color.color10, R.color.blueberry, R.drawable.ic_mdi_radio_button_unchecked, R.drawable.save_round_barder);
        }
        AdapterPlanDurationsLayoutBinding planBinding7 = holder.getPlanBinding();
        if (planBinding7 != null) {
            planBinding7.executePendingBindings();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m1325onBindViewHolder$lambda0(PlanDurationsAdapter this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.rowIndex = i;
        this$0.notifyDataSetChanged();
        ItemClickListener itemClickListener = this$0.itemClickListener;
        if (itemClickListener != null) {
            itemClickListener.onItemClick(view, i);
        }
    }

    private final void changeViewProperty(ViewHolder viewHolder, int i, int i2, int i3, int i4, int i5, int i6) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        ImageView imageView;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView appCompatTextView4;
        AppCompatTextView appCompatTextView5;
        LinearLayout linearLayout;
        AdapterPlanDurationsLayoutBinding planBinding = viewHolder.getPlanBinding();
        if (planBinding != null && (linearLayout = planBinding.lytValidityId) != null) {
            linearLayout.setBackgroundResource(i);
        }
        AdapterPlanDurationsLayoutBinding planBinding2 = viewHolder.getPlanBinding();
        if (planBinding2 != null && (appCompatTextView5 = planBinding2.txtPlanDurationId) != null) {
            appCompatTextView5.setTextColor(ResourcesCompat.getColor(this.mContext.getResources(), i2, null));
        }
        AdapterPlanDurationsLayoutBinding planBinding3 = viewHolder.getPlanBinding();
        if (planBinding3 != null && (appCompatTextView4 = planBinding3.txtPlanAmountId) != null) {
            appCompatTextView4.setTextColor(ResourcesCompat.getColor(this.mContext.getResources(), i3, null));
        }
        AdapterPlanDurationsLayoutBinding planBinding4 = viewHolder.getPlanBinding();
        if (planBinding4 != null && (appCompatTextView3 = planBinding4.txtPlanMonthId) != null) {
            appCompatTextView3.setTextColor(ResourcesCompat.getColor(this.mContext.getResources(), i4, null));
        }
        AdapterPlanDurationsLayoutBinding planBinding5 = viewHolder.getPlanBinding();
        if (planBinding5 != null && (imageView = planBinding5.imgPlanId) != null) {
            imageView.setImageResource(i5);
        }
        AdapterPlanDurationsLayoutBinding planBinding6 = viewHolder.getPlanBinding();
        if (planBinding6 != null && (appCompatTextView2 = planBinding6.txtSaving) != null) {
            appCompatTextView2.setBackgroundResource(i6);
        }
        AdapterPlanDurationsLayoutBinding planBinding7 = viewHolder.getPlanBinding();
        if (planBinding7 == null || (appCompatTextView = planBinding7.txtSaving) == null) {
            return;
        }
        appCompatTextView.setTextColor(ResourcesCompat.getColor(this.mContext.getResources(), i4, null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemList.size();
    }

    public final void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    /* compiled from: PlanDurationsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/adapter/PlanDurationsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "planBinding", "Lcom/livpure/safedrink/databinding/AdapterPlanDurationsLayoutBinding;", "(Lcom/livpure/safedrink/subscription/payment/adapter/PlanDurationsAdapter;Lcom/livpure/safedrink/databinding/AdapterPlanDurationsLayoutBinding;)V", "getPlanBinding", "()Lcom/livpure/safedrink/databinding/AdapterPlanDurationsLayoutBinding;", "setPlanBinding", "(Lcom/livpure/safedrink/databinding/AdapterPlanDurationsLayoutBinding;)V", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private AdapterPlanDurationsLayoutBinding planBinding;
        final /* synthetic */ PlanDurationsAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(PlanDurationsAdapter planDurationsAdapter, AdapterPlanDurationsLayoutBinding planBinding) {
            super(planBinding.getRoot());
            Intrinsics.checkNotNullParameter(planBinding, "planBinding");
            this.this$0 = planDurationsAdapter;
            this.planBinding = planBinding;
        }

        public final AdapterPlanDurationsLayoutBinding getPlanBinding() {
            return this.planBinding;
        }

        public final void setPlanBinding(AdapterPlanDurationsLayoutBinding adapterPlanDurationsLayoutBinding) {
            this.planBinding = adapterPlanDurationsLayoutBinding;
        }
    }
}

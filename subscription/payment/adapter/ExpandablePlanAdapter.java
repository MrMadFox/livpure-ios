package com.livpure.safedrink.subscription.payment.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.databinding.AdapterExpandablePlanLayoutBinding;
import com.livpure.safedrink.interfaces.MultiItemClickListener;
import com.livpure.safedrink.interfaces.RefreshPlanListListener;
import com.livpure.safedrink.subscription.plan.data.model.plan.PlansItem;
import com.livpure.safedrink.subscription.plan.data.model.plan.PriceItem;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ExpandablePlanAdapter.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0001.B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001b\u001a\u00020\rH\u0016J\u001c\u0010\u001c\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0016J2\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J\u001c\u0010'\u001a\u00060\u0002R\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\rH\u0016J\u000e\u0010+\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\rJ2\u0010,\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010-\u001a\u00020\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006/"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/adapter/ExpandablePlanAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/livpure/safedrink/subscription/payment/adapter/ExpandablePlanAdapter$ViewHolder;", "Lcom/livpure/safedrink/interfaces/MultiItemClickListener;", "mContext", "Landroid/content/Context;", "planList", "", "Lcom/livpure/safedrink/subscription/plan/data/model/plan/PlansItem;", "refreshPlanListListener", "Lcom/livpure/safedrink/interfaces/RefreshPlanListListener;", "(Landroid/content/Context;Ljava/util/List;Lcom/livpure/safedrink/interfaces/RefreshPlanListListener;)V", "childPosition", "", "inflater", "Landroid/view/LayoutInflater;", "itemClickListener", "getMContext", "()Landroid/content/Context;", "planResult", "getRefreshPlanListListener", "()Lcom/livpure/safedrink/interfaces/RefreshPlanListListener;", "rowIndex", "getRowIndex", "()I", "setRowIndex", "(I)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onChildItemClick", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "parentPosition", "isHoliday", "", "isUnlimited", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onParentItemClick", "selectedPlanClickEvent", "setOnItemClickListener", "ViewHolder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExpandablePlanAdapter extends RecyclerView.Adapter<ViewHolder> implements MultiItemClickListener {
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

    public ExpandablePlanAdapter(Context mContext, List<PlansItem> planList, RefreshPlanListListener refreshPlanListListener) {
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
        ViewDataBinding bind = DataBindingUtil.bind(layoutInflater.inflate(R.layout.adapter_expandable_plan_layout, parent, false));
        Intrinsics.checkNotNull(bind);
        return new ViewHolder(this, (AdapterExpandablePlanLayoutBinding) bind);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.planList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.planResult = this.planList.get(i);
        AdapterExpandablePlanLayoutBinding binding = holder.getBinding();
        PlansItem plansItem = this.planResult;
        if (plansItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("planResult");
            plansItem = null;
        }
        binding.setPlan(plansItem);
        holder.getBinding().setCallBack(this);
        holder.getBinding().setPosition(Integer.valueOf(i));
        PlansItem plansItem2 = this.planResult;
        if (plansItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("planResult");
            plansItem2 = null;
        }
        if (StringsKt.equals$default(plansItem2.getProductType(), "ZINGERCOPPERWAAS", false, 2, null)) {
            holder.getBinding().additionalUsage.setVisibility(8);
        } else {
            holder.getBinding().additionalUsage.setVisibility(0);
            TextView textView = holder.getBinding().additionalUsage;
            StringBuilder sb = new StringBuilder();
            sb.append("*Additional usage @ ");
            sb.append(this.mContext.getResources().getString(R.string.Rs));
            sb.append(SafeJsonPrimitive.NULL_CHAR);
            PlansItem plansItem3 = this.planResult;
            if (plansItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("planResult");
                plansItem3 = null;
            }
            sb.append(plansItem3.getRateperliter());
            sb.append("/Litre");
            textView.setText(sb.toString());
        }
        PlansItem plansItem4 = this.planResult;
        if (plansItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("planResult");
            plansItem4 = null;
        }
        if (StringsKt.equals$default(plansItem4.getPlanName(), "Platinum", false, 2, null)) {
            holder.getBinding().textPopular.setVisibility(0);
        } else {
            holder.getBinding().textPopular.setVisibility(8);
        }
        try {
            holder.getBinding().listPlanValidityId.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
            Context context = this.mContext;
            PlansItem plansItem5 = this.planResult;
            if (plansItem5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("planResult");
                plansItem5 = null;
            }
            List<PriceItem> price = plansItem5.getPrice();
            Intrinsics.checkNotNull(price);
            List sortedWith = CollectionsKt.sortedWith(price, new Comparator() { // from class: com.livpure.safedrink.subscription.payment.adapter.ExpandablePlanAdapter$onBindViewHolder$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    String duration;
                    String duration2;
                    PriceItem priceItem = (PriceItem) t2;
                    Integer num = null;
                    Integer valueOf = (priceItem == null || (duration2 = priceItem.getDuration()) == null) ? null : Integer.valueOf(Integer.parseInt(duration2));
                    PriceItem priceItem2 = (PriceItem) t;
                    if (priceItem2 != null && (duration = priceItem2.getDuration()) != null) {
                        num = Integer.valueOf(Integer.parseInt(duration));
                    }
                    return ComparisonsKt.compareValues(valueOf, num);
                }
            });
            PlansItem plansItem6 = this.planResult;
            if (plansItem6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("planResult");
                plansItem6 = null;
            }
            PlanValidityAdapter planValidityAdapter = new PlanValidityAdapter(context, sortedWith, i, false, Integer.parseInt(String.valueOf(plansItem6.getPricePerMonth())));
            holder.getBinding().listPlanValidityId.setAdapter(planValidityAdapter);
            planValidityAdapter.setOnItemClickListener(this);
        } catch (Exception e) {
            Log.e(AgentHealth.DEFAULT_KEY, e.toString());
        }
        if (this.rowIndex == i) {
            holder.getBinding().lytValidityId.setBackgroundResource(R.drawable.drawable_item_selected);
            holder.getBinding().lytItemExpandable.setVisibility(8);
            holder.getBinding().radioPlanId.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.ic_radiobox_selected));
            holder.getBinding().textPlanName.setTextColor(ResourcesCompat.getColor(this.mContext.getResources(), R.color.color_193357, null));
            holder.getBinding().textLitre.setTextColor(ResourcesCompat.getColor(this.mContext.getResources(), R.color.color_193357, null));
            holder.getBinding().textLitreMonth.setTextColor(ResourcesCompat.getColor(this.mContext.getResources(), R.color.color_193357, null));
            holder.getBinding().textAmount.setTextColor(ResourcesCompat.getColor(this.mContext.getResources(), R.color.color_193357, null));
            holder.getBinding().textPlanName.setTextAppearance(this.mContext.getApplicationContext(), R.style.boldText);
            PlansItem plansItem7 = this.planResult;
            if (plansItem7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("planResult");
                plansItem7 = null;
            }
            if (StringsKt.equals$default(plansItem7.getActive(), "yes", false, 2, null)) {
                holder.getBinding().btnRenewPlanId.setVisibility(0);
                holder.getBinding().additionalUsage.setVisibility(0);
            } else {
                holder.getBinding().btnRenewPlanId.setVisibility(8);
                holder.getBinding().additionalUsage.setVisibility(8);
            }
        } else {
            holder.getBinding().lytValidityId.setBackgroundResource(R.drawable.drawable_default_bg);
            holder.getBinding().lytItemExpandable.setVisibility(8);
            holder.getBinding().radioPlanId.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.ic_radiobox_unselected));
            holder.getBinding().textPlanName.setTextColor(ResourcesCompat.getColor(this.mContext.getResources(), R.color.color_8592a6, null));
            holder.getBinding().textLitre.setTextColor(ResourcesCompat.getColor(this.mContext.getResources(), R.color.color_8592a6, null));
            holder.getBinding().textLitreMonth.setTextColor(ResourcesCompat.getColor(this.mContext.getResources(), R.color.color_8592a6, null));
            holder.getBinding().textAmount.setTextColor(ResourcesCompat.getColor(this.mContext.getResources(), R.color.color_8592a6, null));
            holder.getBinding().btnRenewPlanId.setVisibility(8);
            holder.getBinding().additionalUsage.setVisibility(8);
        }
        holder.getBinding().btnRenewPlanId.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.adapter.ExpandablePlanAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandablePlanAdapter.m1319onBindViewHolder$lambda1(ExpandablePlanAdapter.this, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m1319onBindViewHolder$lambda1(ExpandablePlanAdapter this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MultiItemClickListener multiItemClickListener = this$0.itemClickListener;
        if (multiItemClickListener != null) {
            multiItemClickListener.onChildItemClick(view, i, this$0.childPosition, false, false);
        }
    }

    /* compiled from: ExpandablePlanAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/adapter/ExpandablePlanAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/livpure/safedrink/databinding/AdapterExpandablePlanLayoutBinding;", "(Lcom/livpure/safedrink/subscription/payment/adapter/ExpandablePlanAdapter;Lcom/livpure/safedrink/databinding/AdapterExpandablePlanLayoutBinding;)V", "getBinding", "()Lcom/livpure/safedrink/databinding/AdapterExpandablePlanLayoutBinding;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterExpandablePlanLayoutBinding binding;
        final /* synthetic */ ExpandablePlanAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ExpandablePlanAdapter expandablePlanAdapter, AdapterExpandablePlanLayoutBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = expandablePlanAdapter;
            this.binding = binding;
            binding.executePendingBindings();
        }

        public final AdapterExpandablePlanLayoutBinding getBinding() {
            return this.binding;
        }
    }

    public final void setOnItemClickListener(MultiItemClickListener multiItemClickListener) {
        this.itemClickListener = multiItemClickListener;
    }

    public final void onParentItemClick(int i) {
        this.refreshPlanListListener.onClick(false, false, true);
        this.rowIndex = i;
        notifyDataSetChanged();
    }

    @Override // com.livpure.safedrink.interfaces.MultiItemClickListener
    public void onChildItemClick(View view, int i, int i2, boolean z, boolean z2) {
        this.childPosition = i2;
    }
}

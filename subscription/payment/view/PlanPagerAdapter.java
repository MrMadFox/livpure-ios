package com.livpure.safedrink.subscription.payment.view;

import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.ChipGroup;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.LSApplication;
import com.livpure.safedrink.databinding.ViewPlanBinding;
import com.livpure.safedrink.login.data.models.User;
import com.livpure.safedrink.subscription.payment.view.PlanPagerAdapter;
import com.livpure.safedrink.subscription.plan.data.model.payment.PlanItem;
import com.livpure.safedrink.subscription.plan.data.model.payment.PriceMappingItem;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
/* compiled from: PlanPagerAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\bH\u0016J\u001c\u0010\f\u001a\u00020\t2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\bH\u0016J*\u0010\f\u001a\u00020\t2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/view/PlanPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/livpure/safedrink/subscription/payment/view/PlanPagerAdapter$PlanViewHolder;", "plansList", "", "Lcom/livpure/safedrink/subscription/plan/data/model/payment/PlanItem;", "onSubscribePlanClicked", "Lkotlin/Function1;", "", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "onBindViewHolder", "holder", "position", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "PlanViewHolder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PlanPagerAdapter extends RecyclerView.Adapter<PlanViewHolder> {
    private final Function1<Integer, Unit> onSubscribePlanClicked;
    private final List<PlanItem> plansList;

    /* JADX WARN: Multi-variable type inference failed */
    public PlanPagerAdapter(List<PlanItem> plansList, Function1<? super Integer, Unit> onSubscribePlanClicked) {
        Intrinsics.checkNotNullParameter(plansList, "plansList");
        Intrinsics.checkNotNullParameter(onSubscribePlanClicked, "onSubscribePlanClicked");
        this.plansList = plansList;
        this.onSubscribePlanClicked = onSubscribePlanClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(PlanViewHolder planViewHolder, int i, List list) {
        onBindViewHolder2(planViewHolder, i, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PlanViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.view_plan, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …                   false)");
        return new PlanViewHolder(this, (ViewPlanBinding) inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.plansList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PlanViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (i >= this.plansList.size()) {
            return;
        }
        holder.bind(this.plansList.get(i));
    }

    /* renamed from: onBindViewHolder  reason: avoid collision after fix types in other method */
    public void onBindViewHolder2(PlanViewHolder holder, int i, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (i >= this.plansList.size()) {
            return;
        }
        holder.bind(this.plansList.get(i));
    }

    /* compiled from: PlanPagerAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/livpure/safedrink/subscription/payment/view/PlanPagerAdapter$PlanViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bindingItem", "Lcom/livpure/safedrink/databinding/ViewPlanBinding;", "(Lcom/livpure/safedrink/subscription/payment/view/PlanPagerAdapter;Lcom/livpure/safedrink/databinding/ViewPlanBinding;)V", "bind", "", "planItem", "Lcom/livpure/safedrink/subscription/plan/data/model/payment/PlanItem;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class PlanViewHolder extends RecyclerView.ViewHolder {
        private final ViewPlanBinding bindingItem;
        final /* synthetic */ PlanPagerAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlanViewHolder(PlanPagerAdapter planPagerAdapter, ViewPlanBinding bindingItem) {
            super(bindingItem.getRoot());
            Intrinsics.checkNotNullParameter(bindingItem, "bindingItem");
            this.this$0 = planPagerAdapter;
            this.bindingItem = bindingItem;
        }

        public final void bind(final PlanItem planItem) {
            List<PriceMappingItem> priceMapping;
            Integer selectedDuration;
            Intrinsics.checkNotNullParameter(planItem, "planItem");
            this.bindingItem.setPlan(planItem);
            this.bindingItem.executePendingBindings();
            boolean z = false;
            if (planItem.getSelectedDuration() == null || ((selectedDuration = planItem.getSelectedDuration()) != null && selectedDuration.intValue() == 1)) {
                this.bindingItem.chip1Month.setChecked(true);
                PlanItem plan = this.bindingItem.getPlan();
                if (plan != null && (priceMapping = plan.getPriceMapping()) != null) {
                    for (PriceMappingItem priceMappingItem : priceMapping) {
                        if (Integer.parseInt(priceMappingItem.getDuration()) == 1) {
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String string = this.bindingItem.getRoot().getContext().getString(R.string.price_string_in_inr);
                            Intrinsics.checkNotNullExpressionValue(string, "bindingItem.root.context…ring.price_string_in_inr)");
                            String format = String.format(string, Arrays.copyOf(new Object[]{priceMappingItem.getPrice()}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                            ((TextView) this.bindingItem.getRoot().findViewById(R.id.price)).setText(format);
                            PlanItem plan2 = this.bindingItem.getPlan();
                            Intrinsics.checkNotNull(plan2);
                            plan2.setSelectedDuration(Integer.valueOf(Integer.parseInt(priceMappingItem.getDuration())));
                            PlanItem plan3 = this.bindingItem.getPlan();
                            Intrinsics.checkNotNull(plan3);
                            plan3.setSelectedDurationPrice(Long.valueOf(Long.parseLong(priceMappingItem.getPrice())));
                        }
                    }
                }
            }
            final PlanPagerAdapter planPagerAdapter = this.this$0;
            ((ChipGroup) this.bindingItem.getRoot().findViewById(R.id.durationGroup)).setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() { // from class: com.livpure.safedrink.subscription.payment.view.PlanPagerAdapter$PlanViewHolder$$ExternalSyntheticLambda1
                @Override // com.google.android.material.chip.ChipGroup.OnCheckedChangeListener
                public final void onCheckedChanged(ChipGroup chipGroup, int i) {
                    PlanPagerAdapter.PlanViewHolder.m1344bind$lambda3(PlanPagerAdapter.PlanViewHolder.this, planPagerAdapter, planItem, chipGroup, i);
                }
            });
            User user = LSApplication.Companion.getUser();
            String planId = user != null ? user.getPlanId() : null;
            if (!((planId == null || StringsKt.isBlank(planId)) ? true : true)) {
                Button button = this.bindingItem.subscribeButton;
                Resources resources = this.bindingItem.getRoot().getContext().getResources();
                User user2 = LSApplication.Companion.getUser();
                String planId2 = user2 != null ? user2.getPlanId() : null;
                PlanItem plan4 = this.bindingItem.getPlan();
                button.setText(resources.getString(Intrinsics.areEqual(planId2, plan4 != null ? plan4.getId() : null) ? R.string.label_recharge_select_plan : R.string.label_change_plan_select_plan));
            }
            final PlanPagerAdapter planPagerAdapter2 = this.this$0;
            ((Button) this.bindingItem.getRoot().findViewById(R.id.subscribeButton)).setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.subscription.payment.view.PlanPagerAdapter$PlanViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlanPagerAdapter.PlanViewHolder.m1346bind$lambda4(PlanPagerAdapter.this, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-3  reason: not valid java name */
        public static final void m1344bind$lambda3(PlanViewHolder this$0, final PlanPagerAdapter this$1, final PlanItem planItem, ChipGroup chipGroup, int i) {
            List<PriceMappingItem> priceMapping;
            Integer selectedDuration;
            int i2;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(planItem, "$planItem");
            if (i != -1) {
                PlanItem plan = this$0.bindingItem.getPlan();
                if (plan != null) {
                    if (i == R.id.chip_12_months) {
                        i2 = 12;
                    } else if (i == R.id.chip_6_months) {
                        i2 = 6;
                    } else {
                        i2 = 1;
                    }
                    plan.setSelectedDuration(i2);
                }
                PlanItem plan2 = this$0.bindingItem.getPlan();
                if (plan2 != null && (priceMapping = plan2.getPriceMapping()) != null) {
                    for (PriceMappingItem priceMappingItem : priceMapping) {
                        int parseInt = Integer.parseInt(priceMappingItem.getDuration());
                        PlanItem plan3 = this$0.bindingItem.getPlan();
                        if (parseInt == ((plan3 == null || (selectedDuration = plan3.getSelectedDuration()) == null) ? 1 : selectedDuration.intValue())) {
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String string = this$0.bindingItem.getRoot().getContext().getString(R.string.price_string_in_inr);
                            Intrinsics.checkNotNullExpressionValue(string, "bindingItem.root.context…ring.price_string_in_inr)");
                            String format = String.format(string, Arrays.copyOf(new Object[]{priceMappingItem.getPrice()}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                            ((TextView) this$0.bindingItem.getRoot().findViewById(R.id.price)).setText(format);
                            PlanItem plan4 = this$0.bindingItem.getPlan();
                            Intrinsics.checkNotNull(plan4);
                            plan4.setSelectedDuration(Integer.valueOf(Integer.parseInt(priceMappingItem.getDuration())));
                            PlanItem plan5 = this$0.bindingItem.getPlan();
                            Intrinsics.checkNotNull(plan5);
                            plan5.setSelectedDurationPrice(Long.valueOf(Long.parseLong(priceMappingItem.getPrice())));
                        }
                    }
                }
                new Handler().post(new Runnable() { // from class: com.livpure.safedrink.subscription.payment.view.PlanPagerAdapter$PlanViewHolder$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlanPagerAdapter.PlanViewHolder.m1345bind$lambda3$lambda2(PlanPagerAdapter.this, planItem);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-3$lambda-2  reason: not valid java name */
        public static final void m1345bind$lambda3$lambda2(PlanPagerAdapter this$0, PlanItem planItem) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(planItem, "$planItem");
            this$0.notifyItemChanged(this$0.plansList.indexOf(planItem));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-4  reason: not valid java name */
        public static final void m1346bind$lambda4(PlanPagerAdapter this$0, PlanViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.onSubscribePlanClicked.invoke(Integer.valueOf(this$1.getAdapterPosition()));
        }
    }
}

package com.livpure.safedrink.serviceRequest.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.databinding.AdapterNewPlanLayoutBinding;
import com.livpure.safedrink.serviceRequest.data.model.NewPlanList;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NewPlanAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/view/adapter/NewPlanAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/livpure/safedrink/serviceRequest/view/adapter/NewPlanAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "itemList", "", "Lcom/livpure/safedrink/serviceRequest/data/model/NewPlanList;", "(Landroid/content/Context;Ljava/util/List;)V", "layoutInflater", "Landroid/view/LayoutInflater;", "getMContext", "()Landroid/content/Context;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NewPlanAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<NewPlanList> itemList;
    private final LayoutInflater layoutInflater;
    private final Context mContext;

    public final Context getMContext() {
        return this.mContext;
    }

    public NewPlanAdapter(Context mContext, List<NewPlanList> itemList) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        this.mContext = mContext;
        this.itemList = itemList;
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
        ViewDataBinding bind = DataBindingUtil.bind(this.layoutInflater.inflate(R.layout.adapter_new_plan_layout, parent, false));
        Intrinsics.checkNotNull(bind);
        return new ViewHolder(this, (AdapterNewPlanLayoutBinding) bind);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        NewPlanList newPlanList = this.itemList.get(i);
        holder.getPlanBinding().setDuration(newPlanList);
        holder.getPlanBinding().setPosition(Integer.valueOf(i));
        AppCompatTextView appCompatTextView = holder.getPlanBinding().textRsPlan;
        appCompatTextView.setText(SafeJsonPrimitive.NULL_CHAR + newPlanList.getPrice());
        if (!Intrinsics.areEqual(newPlanList.getDuration(), "1")) {
            AppCompatTextView appCompatTextView2 = holder.getPlanBinding().textTotalMonth;
            appCompatTextView2.setText(newPlanList.getDuration() + SafeJsonPrimitive.NULL_CHAR + this.mContext.getResources().getString(R.string.months));
        } else {
            AppCompatTextView appCompatTextView3 = holder.getPlanBinding().textTotalMonth;
            appCompatTextView3.setText(newPlanList.getDuration() + SafeJsonPrimitive.NULL_CHAR + this.mContext.getResources().getString(R.string.one_month));
        }
        if (Intrinsics.areEqual(newPlanList.getDuration(), "12")) {
            holder.getPlanBinding().textPopular.setVisibility(0);
        } else {
            holder.getPlanBinding().textPopular.setVisibility(8);
        }
    }

    /* compiled from: NewPlanAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/view/adapter/NewPlanAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "planBinding", "Lcom/livpure/safedrink/databinding/AdapterNewPlanLayoutBinding;", "(Lcom/livpure/safedrink/serviceRequest/view/adapter/NewPlanAdapter;Lcom/livpure/safedrink/databinding/AdapterNewPlanLayoutBinding;)V", "getPlanBinding", "()Lcom/livpure/safedrink/databinding/AdapterNewPlanLayoutBinding;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterNewPlanLayoutBinding planBinding;
        final /* synthetic */ NewPlanAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(NewPlanAdapter newPlanAdapter, AdapterNewPlanLayoutBinding planBinding) {
            super(planBinding.getRoot());
            Intrinsics.checkNotNullParameter(planBinding, "planBinding");
            this.this$0 = newPlanAdapter;
            this.planBinding = planBinding;
            planBinding.executePendingBindings();
        }

        public final AdapterNewPlanLayoutBinding getPlanBinding() {
            return this.planBinding;
        }
    }
}

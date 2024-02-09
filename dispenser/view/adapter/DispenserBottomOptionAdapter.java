package com.livpure.safedrink.dispenser.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.databinding.AdapterDispenserBottomOptionsBinding;
import com.livpure.safedrink.interfaces.ItemClickListener;
import com.livpure.safedrink.model.DispenserBottomOption;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DispenserBottomOptionAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001aB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\tH\u0016J\u001c\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/livpure/safedrink/dispenser/view/adapter/DispenserBottomOptionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/livpure/safedrink/dispenser/view/adapter/DispenserBottomOptionAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "bottomOptionList", "", "Lcom/livpure/safedrink/model/DispenserBottomOption;", "margin", "", "(Landroid/content/Context;Ljava/util/List;I)V", "inflater", "Landroid/view/LayoutInflater;", "itemClickListener", "Lcom/livpure/safedrink/interfaces/ItemClickListener;", "rowIndex", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "ViewHolder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DispenserBottomOptionAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<DispenserBottomOption> bottomOptionList;
    private LayoutInflater inflater;
    private ItemClickListener itemClickListener;
    private final Context mContext;
    private final int margin;
    private int rowIndex;

    public DispenserBottomOptionAdapter(Context mContext, List<DispenserBottomOption> bottomOptionList, int i) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(bottomOptionList, "bottomOptionList");
        this.mContext = mContext;
        this.bottomOptionList = bottomOptionList;
        this.margin = i;
        this.rowIndex = -1;
        Object systemService = mContext.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.inflater = (LayoutInflater) systemService;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflater = this.inflater;
        Intrinsics.checkNotNull(layoutInflater);
        ViewDataBinding bind = DataBindingUtil.bind(layoutInflater.inflate(R.layout.adapter_dispenser_bottom_options, parent, false));
        Intrinsics.checkNotNull(bind);
        return new ViewHolder(this, (AdapterDispenserBottomOptionsBinding) bind);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.bottomOptionList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getBinding().setOption(this.bottomOptionList.get(i));
        holder.getBinding().setMargin(Integer.valueOf(this.margin));
        holder.getBinding().lytValidityId.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.dispenser.view.adapter.DispenserBottomOptionAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DispenserBottomOptionAdapter.m974onBindViewHolder$lambda0(DispenserBottomOptionAdapter.this, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m974onBindViewHolder$lambda0(DispenserBottomOptionAdapter this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.rowIndex = i;
        ItemClickListener itemClickListener = this$0.itemClickListener;
        if (itemClickListener != null) {
            itemClickListener.onItemClick(view, i);
        }
    }

    /* compiled from: DispenserBottomOptionAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/livpure/safedrink/dispenser/view/adapter/DispenserBottomOptionAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/livpure/safedrink/databinding/AdapterDispenserBottomOptionsBinding;", "(Lcom/livpure/safedrink/dispenser/view/adapter/DispenserBottomOptionAdapter;Lcom/livpure/safedrink/databinding/AdapterDispenserBottomOptionsBinding;)V", "getBinding", "()Lcom/livpure/safedrink/databinding/AdapterDispenserBottomOptionsBinding;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterDispenserBottomOptionsBinding binding;
        final /* synthetic */ DispenserBottomOptionAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(DispenserBottomOptionAdapter dispenserBottomOptionAdapter, AdapterDispenserBottomOptionsBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = dispenserBottomOptionAdapter;
            this.binding = binding;
            binding.executePendingBindings();
        }

        public final AdapterDispenserBottomOptionsBinding getBinding() {
            return this.binding;
        }
    }

    public final void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}

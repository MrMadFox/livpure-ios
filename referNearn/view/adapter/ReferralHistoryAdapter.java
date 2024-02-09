package com.livpure.safedrink.referNearn.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.databinding.AdapterReferrralHistoryBinding;
import com.livpure.safedrink.interfaces.ItemClickListener;
import com.livpure.safedrink.referNearn.model.ReferralHistoryResponse;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReferralHistoryAdapter.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0016\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u000fJ\u0010\u0010\u001b\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0018\u00010\u0002R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/livpure/safedrink/referNearn/view/adapter/ReferralHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/livpure/safedrink/referNearn/view/adapter/ReferralHistoryAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "referralList", "", "Lcom/livpure/safedrink/referNearn/model/ReferralHistoryResponse;", "(Landroid/content/Context;Ljava/util/List;)V", "itemClickListener", "Lcom/livpure/safedrink/interfaces/ItemClickListener;", "layoutInflater", "Landroid/view/LayoutInflater;", "viewHolder", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onItemClick", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "setOnItemClickListener", "ViewHolder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferralHistoryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ItemClickListener itemClickListener;
    private final LayoutInflater layoutInflater;
    private final List<ReferralHistoryResponse> referralList;
    private ViewHolder viewHolder;

    public ReferralHistoryAdapter(Context mContext, List<ReferralHistoryResponse> referralList) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(referralList, "referralList");
        this.referralList = referralList;
        Object systemService = mContext.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.layoutInflater = (LayoutInflater) systemService;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(this.layoutInflater, R.layout.adapter_referrral_history, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, …l_history, parent, false)");
        ViewHolder viewHolder = new ViewHolder(this, (AdapterReferrralHistoryBinding) inflate);
        this.viewHolder = viewHolder;
        Objects.requireNonNull(viewHolder, "null cannot be cast to non-null type com.livpure.safedrink.referNearn.view.adapter.ReferralHistoryAdapter.ViewHolder");
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ReferralHistoryResponse referralHistoryResponse = this.referralList.get(i);
        AdapterReferrralHistoryBinding adapterBinding = holder.getAdapterBinding();
        if (adapterBinding != null) {
            adapterBinding.setReferral(referralHistoryResponse);
        }
        AdapterReferrralHistoryBinding adapterBinding2 = holder.getAdapterBinding();
        if (adapterBinding2 != null) {
            adapterBinding2.setPosition(Integer.valueOf(i));
        }
        AdapterReferrralHistoryBinding adapterBinding3 = holder.getAdapterBinding();
        if (adapterBinding3 == null) {
            return;
        }
        adapterBinding3.setCallBack(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.referralList.size();
    }

    public final void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    /* compiled from: ReferralHistoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/livpure/safedrink/referNearn/view/adapter/ReferralHistoryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "adapterBinding", "Lcom/livpure/safedrink/databinding/AdapterReferrralHistoryBinding;", "(Lcom/livpure/safedrink/referNearn/view/adapter/ReferralHistoryAdapter;Lcom/livpure/safedrink/databinding/AdapterReferrralHistoryBinding;)V", "getAdapterBinding", "()Lcom/livpure/safedrink/databinding/AdapterReferrralHistoryBinding;", "setAdapterBinding", "(Lcom/livpure/safedrink/databinding/AdapterReferrralHistoryBinding;)V", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private AdapterReferrralHistoryBinding adapterBinding;
        final /* synthetic */ ReferralHistoryAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ReferralHistoryAdapter referralHistoryAdapter, AdapterReferrralHistoryBinding adapterBinding) {
            super(adapterBinding.getRoot());
            Intrinsics.checkNotNullParameter(adapterBinding, "adapterBinding");
            this.this$0 = referralHistoryAdapter;
            this.adapterBinding = adapterBinding;
            Intrinsics.checkNotNull(adapterBinding);
            adapterBinding.executePendingBindings();
        }

        public final AdapterReferrralHistoryBinding getAdapterBinding() {
            return this.adapterBinding;
        }

        public final void setAdapterBinding(AdapterReferrralHistoryBinding adapterReferrralHistoryBinding) {
            this.adapterBinding = adapterReferrralHistoryBinding;
        }
    }

    public final void onItemClick(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        ItemClickListener itemClickListener = this.itemClickListener;
        if (itemClickListener != null) {
            itemClickListener.onItemClick(view, i);
        }
    }
}

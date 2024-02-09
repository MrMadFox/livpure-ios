package com.livpure.safedrink.referNearn.view.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livpure.safedrink.R;
import com.livpure.safedrink.databinding.AdapterReferrralSuperUserBinding;
import com.livpure.safedrink.interfaces.ItemClickListener;
import com.livpure.safedrink.referNearn.model.LaderShipArrayResponse;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReferralSuperUserAdapter.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001dB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0016\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0011R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0018\u00010\u0002R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/livpure/safedrink/referNearn/view/adapter/ReferralSuperUserAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/livpure/safedrink/referNearn/view/adapter/ReferralSuperUserAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "superUserList", "", "Lcom/livpure/safedrink/referNearn/model/LaderShipArrayResponse;", "(Landroid/content/Context;Ljava/util/List;)V", "itemClickListener", "Lcom/livpure/safedrink/interfaces/ItemClickListener;", "layoutInflater", "Landroid/view/LayoutInflater;", "getMContext", "()Landroid/content/Context;", "viewHolder", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onItemClick", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "ViewHolder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferralSuperUserAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ItemClickListener itemClickListener;
    private final LayoutInflater layoutInflater;
    private final Context mContext;
    private final List<LaderShipArrayResponse> superUserList;
    private ViewHolder viewHolder;

    public ReferralSuperUserAdapter(Context mContext, List<LaderShipArrayResponse> superUserList) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(superUserList, "superUserList");
        this.mContext = mContext;
        this.superUserList = superUserList;
        Object systemService = mContext.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.layoutInflater = (LayoutInflater) systemService;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(this.layoutInflater, R.layout.adapter_referrral_super_user, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, …uper_user, parent, false)");
        ViewHolder viewHolder = new ViewHolder(this, (AdapterReferrralSuperUserBinding) inflate);
        this.viewHolder = viewHolder;
        Objects.requireNonNull(viewHolder, "null cannot be cast to non-null type com.livpure.safedrink.referNearn.view.adapter.ReferralSuperUserAdapter.ViewHolder");
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        LaderShipArrayResponse laderShipArrayResponse = this.superUserList.get(i);
        int i2 = (i + 1) % 4;
        AdapterReferrralSuperUserBinding adapterBinding = holder.getAdapterBinding();
        if (adapterBinding != null) {
            if (laderShipArrayResponse == null) {
                laderShipArrayResponse = null;
            }
            adapterBinding.setSuperUser(laderShipArrayResponse);
        }
        int i3 = R.color.color3;
        if (i2 != 1) {
            if (i2 == 2) {
                i3 = R.color.color1;
            } else if (i2 == 3) {
                i3 = R.color.color8;
            }
        }
        AdapterReferrralSuperUserBinding adapterBinding2 = holder.getAdapterBinding();
        TextView textView = adapterBinding2 != null ? adapterBinding2.txtShortNameId : null;
        if (textView == null) {
            return;
        }
        textView.setBackgroundTintList(ColorStateList.valueOf(ResourcesCompat.getColor(this.mContext.getResources(), i3, null)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.superUserList.size();
    }

    /* compiled from: ReferralSuperUserAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/livpure/safedrink/referNearn/view/adapter/ReferralSuperUserAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "adapterBinding", "Lcom/livpure/safedrink/databinding/AdapterReferrralSuperUserBinding;", "(Lcom/livpure/safedrink/referNearn/view/adapter/ReferralSuperUserAdapter;Lcom/livpure/safedrink/databinding/AdapterReferrralSuperUserBinding;)V", "getAdapterBinding", "()Lcom/livpure/safedrink/databinding/AdapterReferrralSuperUserBinding;", "setAdapterBinding", "(Lcom/livpure/safedrink/databinding/AdapterReferrralSuperUserBinding;)V", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private AdapterReferrralSuperUserBinding adapterBinding;
        final /* synthetic */ ReferralSuperUserAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ReferralSuperUserAdapter referralSuperUserAdapter, AdapterReferrralSuperUserBinding adapterBinding) {
            super(adapterBinding.getRoot());
            Intrinsics.checkNotNullParameter(adapterBinding, "adapterBinding");
            this.this$0 = referralSuperUserAdapter;
            this.adapterBinding = adapterBinding;
            Intrinsics.checkNotNull(adapterBinding);
            adapterBinding.executePendingBindings();
        }

        public final AdapterReferrralSuperUserBinding getAdapterBinding() {
            return this.adapterBinding;
        }

        public final void setAdapterBinding(AdapterReferrralSuperUserBinding adapterReferrralSuperUserBinding) {
            this.adapterBinding = adapterReferrralSuperUserBinding;
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

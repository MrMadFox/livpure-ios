package com.livpure.safedrink.serviceRequest.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.databinding.AdapterReferrelDataLayoutBinding;
import com.livpure.safedrink.interfaces.ItemClickListener;
import com.livpure.safedrink.serviceRequest.data.model.GetReferralList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReferralDataAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\tH\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0002R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/view/adapter/ReferralDataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/livpure/safedrink/serviceRequest/view/adapter/ReferralDataAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "itemList", "", "Lcom/livpure/safedrink/serviceRequest/data/model/GetReferralList;", "rowIndex", "", "(Landroid/content/Context;Ljava/util/List;I)V", "itemClickListener", "Lcom/livpure/safedrink/interfaces/ItemClickListener;", "layoutInflater", "Landroid/view/LayoutInflater;", "getMContext", "()Landroid/content/Context;", "viewHolder", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "ViewHolder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferralDataAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ItemClickListener itemClickListener;
    private final List<GetReferralList> itemList;
    private final LayoutInflater layoutInflater;
    private final Context mContext;
    private int rowIndex;
    private ViewHolder viewHolder;

    public /* synthetic */ ReferralDataAdapter(Context context, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, list, (i2 & 4) != 0 ? 0 : i);
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public ReferralDataAdapter(Context mContext, List<GetReferralList> itemList, int i) {
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
        ViewDataBinding inflate = DataBindingUtil.inflate(this.layoutInflater, R.layout.adapter_referrel_data_layout, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, …ta_layout, parent, false)");
        ViewHolder viewHolder = new ViewHolder(this, (AdapterReferrelDataLayoutBinding) inflate);
        this.viewHolder = viewHolder;
        Objects.requireNonNull(viewHolder, "null cannot be cast to non-null type com.livpure.safedrink.serviceRequest.view.adapter.ReferralDataAdapter.ViewHolder");
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int i) {
        TextView textView;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (i < this.itemList.size()) {
            GetReferralList getReferralList = this.itemList.get(i);
            AdapterReferrelDataLayoutBinding dataBinding = holder.getDataBinding();
            TextView textView2 = dataBinding != null ? dataBinding.textName : null;
            if (textView2 != null) {
                textView2.setText(getReferralList != null ? getReferralList.getCustomer_name() : null);
            }
            AdapterReferrelDataLayoutBinding dataBinding2 = holder.getDataBinding();
            TextView textView3 = dataBinding2 != null ? dataBinding2.textEmail : null;
            if (textView3 != null) {
                textView3.setText(getReferralList != null ? getReferralList.getEmail_id() : null);
            }
            AdapterReferrelDataLayoutBinding dataBinding3 = holder.getDataBinding();
            TextView textView4 = dataBinding3 != null ? dataBinding3.textPhone : null;
            if (textView4 != null) {
                textView4.setText(getReferralList != null ? getReferralList.getPhone_no() : null);
            }
            AdapterReferrelDataLayoutBinding dataBinding4 = holder.getDataBinding();
            if (dataBinding4 != null && (textView = dataBinding4.tvResend) != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.livpure.safedrink.serviceRequest.view.adapter.ReferralDataAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReferralDataAdapter.m1266onBindViewHolder$lambda0(ReferralDataAdapter.this, i, view);
                    }
                });
            }
        }
        AdapterReferrelDataLayoutBinding dataBinding5 = holder.getDataBinding();
        if (dataBinding5 != null) {
            dataBinding5.executePendingBindings();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m1266onBindViewHolder$lambda0(ReferralDataAdapter this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.rowIndex = i;
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

    /* compiled from: ReferralDataAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/view/adapter/ReferralDataAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "dataBinding", "Lcom/livpure/safedrink/databinding/AdapterReferrelDataLayoutBinding;", "(Lcom/livpure/safedrink/serviceRequest/view/adapter/ReferralDataAdapter;Lcom/livpure/safedrink/databinding/AdapterReferrelDataLayoutBinding;)V", "getDataBinding", "()Lcom/livpure/safedrink/databinding/AdapterReferrelDataLayoutBinding;", "setDataBinding", "(Lcom/livpure/safedrink/databinding/AdapterReferrelDataLayoutBinding;)V", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private AdapterReferrelDataLayoutBinding dataBinding;
        final /* synthetic */ ReferralDataAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ReferralDataAdapter referralDataAdapter, AdapterReferrelDataLayoutBinding dataBinding) {
            super(dataBinding.getRoot());
            Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
            this.this$0 = referralDataAdapter;
            this.dataBinding = dataBinding;
        }

        public final AdapterReferrelDataLayoutBinding getDataBinding() {
            return this.dataBinding;
        }

        public final void setDataBinding(AdapterReferrelDataLayoutBinding adapterReferrelDataLayoutBinding) {
            this.dataBinding = adapterReferrelDataLayoutBinding;
        }
    }
}

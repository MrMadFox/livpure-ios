package com.livpure.safedrink.serviceRequest.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.databinding.RowItemSupportHistoryBinding;
import com.livpure.safedrink.interfaces.ItemClickListener;
import com.livpure.safedrink.serviceRequest.data.model.FreshdeskHistoryData;
import com.livpure.safedrink.serviceRequest.data.model.ServiceHistoryResponse;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RaiseServiceHistoryAdapter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001%B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJD\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\u001c\u0010\u001e\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u001c\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0018\u00010\u0002R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/view/adapter/RaiseServiceHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/livpure/safedrink/serviceRequest/view/adapter/RaiseServiceHistoryAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "itemList", "", "Lcom/livpure/safedrink/serviceRequest/data/model/FreshdeskHistoryData;", "itemListFresh", "Lcom/livpure/safedrink/serviceRequest/data/model/ServiceHistoryResponse;", "rowIndex", "", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;I)V", "itemClickListener", "Lcom/livpure/safedrink/interfaces/ItemClickListener;", "layoutInflater", "Landroid/view/LayoutInflater;", "getMContext", "()Landroid/content/Context;", "viewHolder", "changeViewProperty", "", "holder", "bgColor", "textDurationColor", "textAmountColor", "textMonthColor", "imgCheckResource", "saveBackground", "getItemCount", "onBindViewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "ViewHolder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RaiseServiceHistoryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ItemClickListener itemClickListener;
    private final List<FreshdeskHistoryData> itemList;
    private final List<ServiceHistoryResponse> itemListFresh;
    private final LayoutInflater layoutInflater;
    private final Context mContext;
    private int rowIndex;
    private ViewHolder viewHolder;

    private final void changeViewProperty(ViewHolder viewHolder, int i, int i2, int i3, int i4, int i5, int i6) {
    }

    public /* synthetic */ RaiseServiceHistoryAdapter(Context context, List list, List list2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, list, list2, (i2 & 8) != 0 ? 0 : i);
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public RaiseServiceHistoryAdapter(Context mContext, List<FreshdeskHistoryData> itemList, List<ServiceHistoryResponse> itemListFresh, int i) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        Intrinsics.checkNotNullParameter(itemListFresh, "itemListFresh");
        this.mContext = mContext;
        this.itemList = itemList;
        this.itemListFresh = itemListFresh;
        this.rowIndex = i;
        Object systemService = mContext.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.layoutInflater = (LayoutInflater) systemService;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(this.layoutInflater, R.layout.row_item_support_history, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, …t_history, parent, false)");
        ViewHolder viewHolder = new ViewHolder(this, (RowItemSupportHistoryBinding) inflate);
        this.viewHolder = viewHolder;
        Objects.requireNonNull(viewHolder, "null cannot be cast to non-null type com.livpure.safedrink.serviceRequest.view.adapter.RaiseServiceHistoryAdapter.ViewHolder");
        return viewHolder;
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x020b A[Catch: Exception -> 0x01cb, TryCatch #0 {Exception -> 0x01cb, blocks: (B:138:0x0199, B:140:0x019f, B:142:0x01b0, B:144:0x01b6, B:148:0x01d0, B:150:0x01d6, B:152:0x01e8, B:154:0x01ee, B:156:0x0205, B:158:0x020b, B:163:0x0217, B:165:0x021d, B:169:0x0224, B:162:0x0212), top: B:287:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0212 A[Catch: Exception -> 0x01cb, TryCatch #0 {Exception -> 0x01cb, blocks: (B:138:0x0199, B:140:0x019f, B:142:0x01b0, B:144:0x01b6, B:148:0x01d0, B:150:0x01d6, B:152:0x01e8, B:154:0x01ee, B:156:0x0205, B:158:0x020b, B:163:0x0217, B:165:0x021d, B:169:0x0224, B:162:0x0212), top: B:287:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x021d A[Catch: Exception -> 0x01cb, TryCatch #0 {Exception -> 0x01cb, blocks: (B:138:0x0199, B:140:0x019f, B:142:0x01b0, B:144:0x01b6, B:148:0x01d0, B:150:0x01d6, B:152:0x01e8, B:154:0x01ee, B:156:0x0205, B:158:0x020b, B:163:0x0217, B:165:0x021d, B:169:0x0224, B:162:0x0212), top: B:287:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0224 A[Catch: Exception -> 0x01cb, TRY_LEAVE, TryCatch #0 {Exception -> 0x01cb, blocks: (B:138:0x0199, B:140:0x019f, B:142:0x01b0, B:144:0x01b6, B:148:0x01d0, B:150:0x01d6, B:152:0x01e8, B:154:0x01ee, B:156:0x0205, B:158:0x020b, B:163:0x0217, B:165:0x021d, B:169:0x0224, B:162:0x0212), top: B:287:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0305  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(com.livpure.safedrink.serviceRequest.view.adapter.RaiseServiceHistoryAdapter.ViewHolder r21, int r22) {
        /*
            Method dump skipped, instructions count: 880
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livpure.safedrink.serviceRequest.view.adapter.RaiseServiceHistoryAdapter.onBindViewHolder(com.livpure.safedrink.serviceRequest.view.adapter.RaiseServiceHistoryAdapter$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemList.size() + this.itemListFresh.size();
    }

    public final void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    /* compiled from: RaiseServiceHistoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/livpure/safedrink/serviceRequest/view/adapter/RaiseServiceHistoryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "planBinding", "Lcom/livpure/safedrink/databinding/RowItemSupportHistoryBinding;", "(Lcom/livpure/safedrink/serviceRequest/view/adapter/RaiseServiceHistoryAdapter;Lcom/livpure/safedrink/databinding/RowItemSupportHistoryBinding;)V", "getPlanBinding", "()Lcom/livpure/safedrink/databinding/RowItemSupportHistoryBinding;", "setPlanBinding", "(Lcom/livpure/safedrink/databinding/RowItemSupportHistoryBinding;)V", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private RowItemSupportHistoryBinding planBinding;
        final /* synthetic */ RaiseServiceHistoryAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(RaiseServiceHistoryAdapter raiseServiceHistoryAdapter, RowItemSupportHistoryBinding planBinding) {
            super(planBinding.getRoot());
            Intrinsics.checkNotNullParameter(planBinding, "planBinding");
            this.this$0 = raiseServiceHistoryAdapter;
            this.planBinding = planBinding;
        }

        public final RowItemSupportHistoryBinding getPlanBinding() {
            return this.planBinding;
        }

        public final void setPlanBinding(RowItemSupportHistoryBinding rowItemSupportHistoryBinding) {
            this.planBinding = rowItemSupportHistoryBinding;
        }
    }
}

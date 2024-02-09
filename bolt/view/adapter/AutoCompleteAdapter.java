package com.livpure.safedrink.bolt.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.livpure.safedrink.databinding.AdapterAutoCompleteBinding;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AutoCompleteAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/livpure/safedrink/bolt/view/adapter/AutoCompleteAdapter;", "Landroid/widget/ArrayAdapter;", "", "mContext", "Landroid/content/Context;", "adapterLayout", "", "dropDownList", "", "(Landroid/content/Context;ILjava/util/List;)V", "layoutInflater", "Landroid/view/LayoutInflater;", "getCount", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AutoCompleteAdapter extends ArrayAdapter<Object> {
    private final int adapterLayout;
    private final List<Object> dropDownList;
    private final LayoutInflater layoutInflater;

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoCompleteAdapter(Context mContext, int i, List<? extends Object> list) {
        super(mContext, i, list);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNull(list);
        this.adapterLayout = i;
        this.dropDownList = list;
        Object systemService = mContext.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.layoutInflater = (LayoutInflater) systemService;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        List<Object> list = this.dropDownList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup parent) {
        AdapterAutoCompleteBinding adapterAutoCompleteBinding;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (view == null) {
            ViewDataBinding inflate = DataBindingUtil.inflate(this.layoutInflater, this.adapterLayout, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, …terLayout, parent, false)");
            adapterAutoCompleteBinding = (AdapterAutoCompleteBinding) inflate;
            adapterAutoCompleteBinding.getRoot().setTag(adapterAutoCompleteBinding);
        } else {
            Object tag = view.getTag();
            Objects.requireNonNull(tag, "null cannot be cast to non-null type com.livpure.safedrink.databinding.AdapterAutoCompleteBinding");
            adapterAutoCompleteBinding = (AdapterAutoCompleteBinding) tag;
        }
        List<Object> list = this.dropDownList;
        Object obj = list != null ? list.get(i) : null;
        if (obj instanceof String) {
            adapterAutoCompleteBinding.txtAutoCompleteId.setText(((String) obj).toString());
        }
        View root = adapterAutoCompleteBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "adapterAutoCompleteBinding.root");
        return root;
    }
}

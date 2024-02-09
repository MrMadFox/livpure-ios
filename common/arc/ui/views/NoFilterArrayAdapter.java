package com.livpure.safedrink.common.arc.ui.views;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import androidx.exifinterface.media.ExifInterface;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NoFilterArrayAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0012B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u000bH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/livpure/safedrink/common/arc/ui/views/NoFilterArrayAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/widget/ArrayAdapter;", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "textViewResourceId", "", "objects", "", "(Landroid/content/Context;ILjava/util/List;)V", "filter", "Landroid/widget/Filter;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getFilter", "DummyFilter", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NoFilterArrayAdapter<T> extends ArrayAdapter<T> {
    private final Filter filter;
    private List<? extends T> items;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoFilterArrayAdapter(Context context, int i, List<? extends T> objects) {
        super(context, i, objects);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(objects, "objects");
        this.filter = new DummyFilter();
        this.items = objects;
    }

    public final List<T> getItems() {
        return (List<? extends T>) this.items;
    }

    public final void setItems(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public Filter getFilter() {
        return this.filter;
    }

    /* compiled from: NoFilterArrayAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0014¨\u0006\n"}, d2 = {"Lcom/livpure/safedrink/common/arc/ui/views/NoFilterArrayAdapter$DummyFilter;", "Landroid/widget/Filter;", "(Lcom/livpure/safedrink/common/arc/ui/views/NoFilterArrayAdapter;)V", "performFiltering", "Landroid/widget/Filter$FilterResults;", "arg0", "", "publishResults", "", "arg1", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private final class DummyFilter extends Filter {
        public DummyFilter() {
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.values = NoFilterArrayAdapter.this.getItems();
            filterResults.count = NoFilterArrayAdapter.this.getItems().size();
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            NoFilterArrayAdapter.this.notifyDataSetChanged();
        }
    }
}

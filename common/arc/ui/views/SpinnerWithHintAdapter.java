package com.livpure.safedrink.common.arc.ui.views;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SpinnerWithHintAdapter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0019\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tB+\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000b¢\u0006\u0002\u0010\fB3\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000b¢\u0006\u0002\u0010\rB+\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB3\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0006H\u0016¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/common/arc/ui/views/SpinnerWithHintAdapter;", "Landroid/widget/ArrayAdapter;", "", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "resource", "", "(Landroid/content/Context;I)V", "textViewResourceId", "(Landroid/content/Context;II)V", "objects", "", "(Landroid/content/Context;I[Ljava/lang/String;)V", "(Landroid/content/Context;II[Ljava/lang/String;)V", "", "(Landroid/content/Context;ILjava/util/List;)V", "(Landroid/content/Context;IILjava/util/List;)V", "getCount", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SpinnerWithHintAdapter extends ArrayAdapter<String> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpinnerWithHintAdapter(Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNull(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpinnerWithHintAdapter(Context context, int i, int i2) {
        super(context, i, i2);
        Intrinsics.checkNotNull(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpinnerWithHintAdapter(Context context, int i, String[] strArr) {
        super(context, i, strArr);
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNull(strArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpinnerWithHintAdapter(Context context, int i, int i2, String[] strArr) {
        super(context, i, i2, strArr);
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNull(strArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpinnerWithHintAdapter(Context context, int i, List<String> list) {
        super(context, i, list);
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNull(list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpinnerWithHintAdapter(Context context, int i, int i2, List<String> list) {
        super(context, i, i2, list);
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNull(list);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        int count = super.getCount();
        return count > 0 ? count - 1 : count;
    }
}

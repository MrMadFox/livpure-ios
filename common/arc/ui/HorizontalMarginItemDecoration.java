package com.livpure.safedrink.common.arc.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.moengage.core.internal.storage.database.contract.DeprecatedContractsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HorizontalMarginItemDecoration.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/livpure/safedrink/common/arc/ui/HorizontalMarginItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", DeprecatedContractsKt.INAPP_V2_MSG_CONTEXT, "Landroid/content/Context;", "horizontalMarginInDp", "", "(Landroid/content/Context;I)V", "horizontalMarginInPx", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HorizontalMarginItemDecoration extends RecyclerView.ItemDecoration {
    private final int horizontalMarginInPx;

    public HorizontalMarginItemDecoration(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.horizontalMarginInPx = (int) context.getResources().getDimension(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        outRect.right = this.horizontalMarginInPx;
        outRect.left = this.horizontalMarginInPx;
    }
}

package com.livpure.safedrink.view.fragment;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes3.dex */
public class CommonItemSpaceDecoration extends RecyclerView.ItemDecoration {
    private int mSpace;
    private boolean mVerticalOrientation;

    public CommonItemSpaceDecoration(int space) {
        this.mSpace = 0;
        this.mVerticalOrientation = true;
        this.mSpace = space;
    }

    public CommonItemSpaceDecoration(int space, boolean verticalOrientation) {
        this.mSpace = 0;
        this.mVerticalOrientation = true;
        this.mSpace = space;
        this.mVerticalOrientation = verticalOrientation;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.top = SizeUtils.dp2px(view.getContext(), this.mSpace);
        if (this.mVerticalOrientation) {
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.set(0, SizeUtils.dp2px(view.getContext(), this.mSpace), 0, SizeUtils.dp2px(view.getContext(), this.mSpace));
            } else {
                outRect.set(0, 0, 0, SizeUtils.dp2px(view.getContext(), this.mSpace));
            }
        } else if (parent.getChildAdapterPosition(view) == 0) {
            outRect.set(SizeUtils.dp2px(view.getContext(), this.mSpace), 0, 0, 0);
        } else {
            outRect.set(SizeUtils.dp2px(view.getContext(), this.mSpace), 0, SizeUtils.dp2px(view.getContext(), this.mSpace), 0);
        }
    }
}

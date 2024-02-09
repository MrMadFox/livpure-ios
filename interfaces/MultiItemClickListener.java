package com.livpure.safedrink.interfaces;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
/* compiled from: MultiItemClickListener.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J2\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&¨\u0006\r"}, d2 = {"Lcom/livpure/safedrink/interfaces/MultiItemClickListener;", "", "onChildItemClick", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "parentPosition", "", "childPosition", "isHoliday", "", "isUnlimited", "selectedPlanClickEvent", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface MultiItemClickListener {
    void onChildItemClick(View view, int i, int i2, boolean z, boolean z2);

    void selectedPlanClickEvent(View view, int i, int i2, boolean z, boolean z2);
}

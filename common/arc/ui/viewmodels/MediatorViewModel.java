package com.livpure.safedrink.common.arc.ui.viewmodels;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MediatorViewModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\tH\u0002J&\u0010\u000b\u001a\u00020\t\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u0007H\u0004R(\u0010\u0003\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/livpure/safedrink/common/arc/ui/viewmodels/MediatorViewModel;", "Lcom/livpure/safedrink/common/arc/ui/viewmodels/AnalyticsViewModel;", "()V", "liveDataAndObservers", "", "Lkotlin/Pair;", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/Observer;", "onCleared", "", "removeObservers", "observeAndTrack", ExifInterface.GPS_DIRECTION_TRUE, "observer", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class MediatorViewModel extends AnalyticsViewModel {
    private final List<Pair<LiveData<?>, Observer<?>>> liveDataAndObservers = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void observeAndTrack(LiveData<T> liveData, Observer<T> observer) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(observer, "observer");
        liveData.observeForever(observer);
        this.liveDataAndObservers.add(new Pair<>(liveData, observer));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        removeObservers();
    }

    private final void removeObservers() {
        Iterator<T> it = this.liveDataAndObservers.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            LiveData liveData = (LiveData) pair.getFirst();
            Observer observer = (Observer) pair.getSecond();
            if (liveData.hasObservers()) {
                liveData.removeObserver(observer);
            }
        }
    }
}

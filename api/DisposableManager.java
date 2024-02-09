package com.livpure.safedrink.api;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
/* loaded from: classes3.dex */
public class DisposableManager {
    private static CompositeDisposable compositeDisposable;

    public static void add(Disposable disposable) {
        getCompositeDisposable().add(disposable);
    }

    public static void dispose() {
        getCompositeDisposable().dispose();
    }

    private static CompositeDisposable getCompositeDisposable() {
        CompositeDisposable compositeDisposable2 = compositeDisposable;
        if (compositeDisposable2 == null || compositeDisposable2.isDisposed()) {
            compositeDisposable = new CompositeDisposable();
        }
        return compositeDisposable;
    }

    private DisposableManager() {
    }
}

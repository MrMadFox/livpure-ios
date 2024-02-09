package com.livpure.safedrink.utils;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RxUtils.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¨\u0006\u0004"}, d2 = {"subscribeOnBackground", "", "function", "Lkotlin/Function0;", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RxUtilsKt {
    public static final void subscribeOnBackground(final Function0<Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        Single.fromCallable(new Callable() { // from class: com.livpure.safedrink.utils.RxUtilsKt$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit m1393subscribeOnBackground$lambda0;
                m1393subscribeOnBackground$lambda0 = RxUtilsKt.m1393subscribeOnBackground$lambda0(Function0.this);
                return m1393subscribeOnBackground$lambda0;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: subscribeOnBackground$lambda-0  reason: not valid java name */
    public static final Unit m1393subscribeOnBackground$lambda0(Function0 function) {
        Intrinsics.checkNotNullParameter(function, "$function");
        function.invoke();
        return Unit.INSTANCE;
    }
}

package com.livpure.safedrink.dispenser.view;

import com.livpure.safedrink.dispenser.model.HomeDispenserAtlanticModel;
import com.livpure.safedrink.utils.AnimProgressBar;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeDispenserAtlanticFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.livpure.safedrink.dispenser.view.HomeDispenserAtlanticFragment$setupDashboard$14$1", f = "HomeDispenserAtlanticFragment.kt", i = {}, l = {300}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class HomeDispenserAtlanticFragment$setupDashboard$14$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeDispenserAtlanticFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeDispenserAtlanticFragment$setupDashboard$14$1(HomeDispenserAtlanticFragment homeDispenserAtlanticFragment, Continuation<? super HomeDispenserAtlanticFragment$setupDashboard$14$1> continuation) {
        super(2, continuation);
        this.this$0 = homeDispenserAtlanticFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeDispenserAtlanticFragment$setupDashboard$14$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeDispenserAtlanticFragment$setupDashboard$14$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HomeDispenserAtlanticModel homeDispenserAtlanticModel;
        AnimProgressBar animProgressBar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        homeDispenserAtlanticModel = this.this$0.getHomeDispenserAtlanticModel();
        homeDispenserAtlanticModel.getDashboardDetails();
        animProgressBar = this.this$0.animProgressBar;
        if (animProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animProgressBar");
            animProgressBar = null;
        }
        animProgressBar.dismiss();
        return Unit.INSTANCE;
    }
}

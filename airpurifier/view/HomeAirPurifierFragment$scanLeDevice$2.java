package com.livpure.safedrink.airpurifier.view;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
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
/* compiled from: HomeAirPurifierFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.livpure.safedrink.airpurifier.view.HomeAirPurifierFragment$scanLeDevice$2", f = "HomeAirPurifierFragment.kt", i = {}, l = {917}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class HomeAirPurifierFragment$scanLeDevice$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeAirPurifierFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeAirPurifierFragment$scanLeDevice$2(HomeAirPurifierFragment homeAirPurifierFragment, Continuation<? super HomeAirPurifierFragment$scanLeDevice$2> continuation) {
        super(2, continuation);
        this.this$0 = homeAirPurifierFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeAirPurifierFragment$scanLeDevice$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeAirPurifierFragment$scanLeDevice$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j;
        BluetoothLeScanner bluetoothLeScanner;
        BluetoothAdapter bluetoothAdapter;
        BluetoothLeScanner bluetoothLeScanner2;
        ScanCallback scanCallback;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            j = this.this$0.SCAN_PERIOD;
            this.label = 1;
            if (DelayKt.delay(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        bluetoothLeScanner = this.this$0.mBluetoothLeScanner;
        if (bluetoothLeScanner != null) {
            bluetoothAdapter = this.this$0.mBluetoothAdapter;
            if ((bluetoothAdapter == null || bluetoothAdapter.getState() != 12) ? false : false) {
                bluetoothLeScanner2 = this.this$0.mBluetoothLeScanner;
                Intrinsics.checkNotNull(bluetoothLeScanner2);
                scanCallback = this.this$0.scanCallback;
                bluetoothLeScanner2.stopScan(scanCallback);
            }
        }
        return Unit.INSTANCE;
    }
}

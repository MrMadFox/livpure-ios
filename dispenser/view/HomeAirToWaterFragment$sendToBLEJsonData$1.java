package com.livpure.safedrink.dispenser.view;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import androidx.core.app.ActivityCompat;
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
/* compiled from: HomeAirToWaterFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.livpure.safedrink.dispenser.view.HomeAirToWaterFragment$sendToBLEJsonData$1", f = "HomeAirToWaterFragment.kt", i = {}, l = {1073}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class HomeAirToWaterFragment$sendToBLEJsonData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeAirToWaterFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeAirToWaterFragment$sendToBLEJsonData$1(HomeAirToWaterFragment homeAirToWaterFragment, Continuation<? super HomeAirToWaterFragment$sendToBLEJsonData$1> continuation) {
        super(2, continuation);
        this.this$0 = homeAirToWaterFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeAirToWaterFragment$sendToBLEJsonData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeAirToWaterFragment$sendToBLEJsonData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BluetoothGatt bluetoothGatt;
        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        String[] strArr;
        BluetoothGatt bluetoothGatt2;
        BluetoothGattCharacteristic bluetoothGattCharacteristic2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(3500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        if (ActivityCompat.checkSelfPermission(this.this$0.requireActivity(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            bluetoothGatt2 = this.this$0.mBluetoothGatt;
            Intrinsics.checkNotNull(bluetoothGatt2);
            bluetoothGattCharacteristic2 = this.this$0.mReadCharacteristic;
            bluetoothGatt2.readCharacteristic(bluetoothGattCharacteristic2);
        } else if (Build.VERSION.SDK_INT >= 31) {
            strArr = this.this$0.android12BlePermission;
            ActivityCompat.requestPermissions(this.this$0.requireActivity(), strArr, 2);
        } else {
            bluetoothGatt = this.this$0.mBluetoothGatt;
            Intrinsics.checkNotNull(bluetoothGatt);
            bluetoothGattCharacteristic = this.this$0.mReadCharacteristic;
            bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
        }
        return Unit.INSTANCE;
    }
}

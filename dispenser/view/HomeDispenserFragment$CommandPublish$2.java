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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeDispenserFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.livpure.safedrink.dispenser.view.HomeDispenserFragment$CommandPublish$2", f = "HomeDispenserFragment.kt", i = {0}, l = {540}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class HomeDispenserFragment$CommandPublish$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $command1;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HomeDispenserFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeDispenserFragment$CommandPublish$2(HomeDispenserFragment homeDispenserFragment, String str, Continuation<? super HomeDispenserFragment$CommandPublish$2> continuation) {
        super(2, continuation);
        this.this$0 = homeDispenserFragment;
        this.$command1 = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HomeDispenserFragment$CommandPublish$2 homeDispenserFragment$CommandPublish$2 = new HomeDispenserFragment$CommandPublish$2(this.this$0, this.$command1, continuation);
        homeDispenserFragment$CommandPublish$2.L$0 = obj;
        return homeDispenserFragment$CommandPublish$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeDispenserFragment$CommandPublish$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        String publishToDeviceCommand;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            this.L$0 = coroutineScope2;
            this.label = 1;
            if (DelayKt.delay(200L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        }
        publishToDeviceCommand = this.this$0.publishToDeviceCommand(this.$command1);
        if (Intrinsics.areEqual(publishToDeviceCommand, "succes")) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this.this$0, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeDispenserFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.livpure.safedrink.dispenser.view.HomeDispenserFragment$CommandPublish$2$1", f = "HomeDispenserFragment.kt", i = {}, l = {544}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.livpure.safedrink.dispenser.view.HomeDispenserFragment$CommandPublish$2$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ HomeDispenserFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HomeDispenserFragment homeDispenserFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = homeDispenserFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
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
                strArr = this.this$0.ANDROID_12_BLE_PERMISSIONS;
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
}
